package com.tencent.mm.plugin.gallery.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.StatFs;
import android.preference.PreferenceManager;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.protocal.protobuf.bho;
import com.tencent.mm.protocal.protobuf.bhp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
{
  private int rAM;
  private e rAN;
  private SparseArray<RandomAccessFile> rAO;
  private SparseArray<bhp> rAP;
  int rAQ;
  
  f()
  {
    AppMethodBeat.i(111278);
    this.rAM = 5;
    Object localObject1 = PreferenceManager.getDefaultSharedPreferences(aj.getContext());
    if (((SharedPreferences)localObject1).getInt("com.tencent.mm.plugin.gallery.cache.cache-up-to-date", 0) == 0)
    {
      ((SharedPreferences)localObject1).edit().putInt("com.tencent.mm.plugin.gallery.cache.cache-up-to-date", 1).apply();
      localObject1 = czx();
      ad.i("MicroMsg.DiskCache", (String)localObject1);
      i.cO((String)localObject1, true);
    }
    long l1 = 0L;
    try
    {
      localObject1 = new StatFs(b.aib());
      long l2 = ((StatFs)localObject1).getBlockCountLong();
      long l3 = ((StatFs)localObject1).getBlockSizeLong();
      l1 = l3 * l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        boolean bool;
        continue;
        Object localObject2 = null;
      }
    }
    i = (int)((float)l1 / 1024.0F / 1024.0F / 1024.0F);
    ad.d("MicroMsg.DiskCache", "adjustCacheFileNum: %s gb: %s.", new Object[] { Long.valueOf(l1), Integer.valueOf(i) });
    if (i < 64)
    {
      this.rAM = 5;
      i = PreferenceManager.getDefaultSharedPreferences(aj.getContext()).getInt("com.tencent.mm.plugin.gallery.cache.cache-file-num", 0);
      if ((i == 0) || (i != this.rAM))
      {
        localObject1 = czy();
        if (localObject1 == null) {
          break label354;
        }
        ad.i("MicroMsg.DiskCache", "cache path: %s.", new Object[] { localObject1 });
        i.cO((String)localObject1, true);
      }
    }
    for (;;)
    {
      PreferenceManager.getDefaultSharedPreferences(aj.getContext()).edit().putInt("com.tencent.mm.plugin.gallery.cache.cache-file-num", this.rAM).apply();
      String str = czy();
      localObject1 = str;
      if (str == null)
      {
        ad.i("MicroMsg.DiskCache", "wtf!!! use old dir!!!");
        localObject1 = czx();
      }
      if (bt.isNullOrNil((String)localObject1)) {
        break label437;
      }
      localObject1 = new e((String)localObject1);
      if (localObject1 != null) {
        break label364;
      }
      localObject1 = new IllegalArgumentException("save dir is null");
      AppMethodBeat.o(111278);
      throw ((Throwable)localObject1);
      if (i < 128)
      {
        this.rAM = 10;
        break;
      }
      if (i < 256)
      {
        this.rAM = 20;
        break;
      }
      this.rAM = 25;
      break;
      label354:
      ad.e("MicroMsg.DiskCache", "wtf!!! shared storage is not currently available.");
    }
    label364:
    if (!((e)localObject1).isDirectory())
    {
      bool = ((e)localObject1).mkdirs();
      ad.d("MicroMsg.DiskCache", "dir[%s] not exist, try to create it, result[%B]", new Object[] { q.B(((e)localObject1).fhU()), Boolean.valueOf(bool) });
    }
    this.rAN = ((e)localObject1);
    this.rAP = new SparseArray();
    AppMethodBeat.o(111278);
  }
  
  private void DU(int paramInt)
  {
    AppMethodBeat.i(111281);
    ad.d("MicroMsg.DiskCache", "pennqin debug disk cache deleteDataAndIndex: %s.", new Object[] { Integer.valueOf(paramInt) });
    if ((this.rAO == null) || (this.rAO.size() <= 0))
    {
      if (this.rAO == null) {}
      for (boolean bool = true;; bool = false)
      {
        ad.w("MicroMsg.DiskCache", "file map is invalid, is null? [%s]", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(111281);
        return;
      }
    }
    if (paramInt < 0)
    {
      ad.d("MicroMsg.DiskCache", "pennqin debug disk cache delete res: %s.", new Object[] { Boolean.valueOf(new e(this.rAN, "cache.idx").delete()) });
      this.rAP.clear();
    }
    while (paramInt < 0)
    {
      czt();
      czu();
      AppMethodBeat.o(111281);
      return;
      SparseArray localSparseArray = new SparseArray();
      int i = 0;
      while (i < this.rAP.size())
      {
        bhp localbhp = (bhp)this.rAP.valueAt(i);
        if (localbhp.DFw != paramInt) {
          localSparseArray.put(this.rAP.keyAt(i), localbhp);
        }
        ad.v("MicroMsg.DiskCache", "index info{key[%s] beg[%d] length[%d]}", new Object[] { Integer.valueOf(localbhp.key), Long.valueOf(localbhp.DFv), Integer.valueOf(localbhp.length) });
        i += 1;
      }
      this.rAP = localSparseArray;
      czs();
    }
    close((Closeable)this.rAO.get(paramInt));
    ad.d("MicroMsg.DiskCache", "pennqin debug disk cache deleteDataAndIndex delete file res: %s.", new Object[] { Boolean.valueOf(new e(this.rAN, DX(paramInt)).delete()) });
    AppMethodBeat.o(111281);
  }
  
  private void DV(int paramInt)
  {
    AppMethodBeat.i(111282);
    ad.d("MicroMsg.DiskCache", "jacks reset Index and Data: %d", new Object[] { Integer.valueOf(paramInt) });
    DU(paramInt);
    DT(paramInt);
    AppMethodBeat.o(111282);
  }
  
  private static String DX(int paramInt)
  {
    AppMethodBeat.i(111289);
    StringBuilder localStringBuilder = new StringBuilder("cache.data");
    if (paramInt == 0) {}
    for (String str = "";; str = String.valueOf(paramInt))
    {
      str = str;
      AppMethodBeat.o(111289);
      return str;
    }
  }
  
  private static void close(Closeable paramCloseable)
  {
    AppMethodBeat.i(111283);
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        AppMethodBeat.o(111283);
        return;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.DiskCache", "want close %s fail: %s", new Object[] { paramCloseable.getClass().getName(), localException.getMessage() });
        ad.printErrStackTrace("MicroMsg.DiskCache", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(111283);
  }
  
  private void czu()
  {
    AppMethodBeat.i(111286);
    ad.d("MicroMsg.DiskCache", "pennqin debug disk cache !!!delete all cache file!!!");
    int i = 0;
    while (i < this.rAM)
    {
      ad.d("MicroMsg.DiskCache", "pennqin debug disk cache deleteDataAndIndex delete file res: %s.", new Object[] { Boolean.valueOf(new e(this.rAN, DX(this.rAM)).delete()) });
      i += 1;
    }
    AppMethodBeat.o(111286);
  }
  
  private int czv()
  {
    int i = 0;
    AppMethodBeat.i(111290);
    if ((this.rAO == null) || (this.rAO.size() <= 0))
    {
      ad.d("MicroMsg.DiskCache", "checkDataSize, cache file invalid.");
      AppMethodBeat.o(111290);
      return -1;
    }
    int j = czw();
    if (j < 0)
    {
      ad.d("MicroMsg.DiskCache", "jacks checkDataSize currentSuffix: %d", new Object[] { Integer.valueOf(this.rAQ) });
      if (this.rAQ + 1 >= this.rAM) {
        DV(i);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(111290);
      return i;
      i = this.rAQ + 1;
      break;
      i = j;
    }
  }
  
  private int czw()
  {
    AppMethodBeat.i(111291);
    if ((this.rAO == null) || (this.rAO.size() <= 0))
    {
      AppMethodBeat.o(111291);
      return -1;
    }
    int i = 0;
    try
    {
      while (i < this.rAO.size())
      {
        RandomAccessFile localRandomAccessFile = (RandomAccessFile)this.rAO.valueAt(i);
        ad.d("MicroMsg.DiskCache", "pennqin debug disk cache r.length[%s] MAX_CACHE_FILE_SIZE[%s]", new Object[] { Long.valueOf(localRandomAccessFile.length()), Integer.valueOf(52428800) });
        if (localRandomAccessFile.length() < 52428800L)
        {
          ad.d("MicroMsg.DiskCache", "pennqin debug disk cache getUsedSuffix, %s.", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(111291);
          return i;
        }
        i += 1;
      }
      return -1;
    }
    catch (IOException localIOException)
    {
      ad.printErrStackTrace("MicroMsg.DiskCache", localIOException, "", new Object[0]);
      AppMethodBeat.o(111291);
    }
  }
  
  private static String czx()
  {
    AppMethodBeat.i(111292);
    String str = b.aih() + "diskcache";
    AppMethodBeat.o(111292);
    return str;
  }
  
  private static String czy()
  {
    AppMethodBeat.i(111293);
    try
    {
      Object localObject = e.R(aj.getContext().getExternalCacheDir());
      localObject = q.B(((e)localObject).fhU()) + "/imgcache";
      AppMethodBeat.o(111293);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(111293);
    }
    return null;
  }
  
  final void DT(int paramInt)
  {
    AppMethodBeat.i(111280);
    if (this.rAO == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.DiskCache", "pennqin debug disk cache fileSuffix: %s, mDataFileMap == null? [%s].", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      try
      {
        RandomAccessFile localRandomAccessFile1;
        if (this.rAO == null)
        {
          this.rAO = new SparseArray();
          paramInt = 0;
          while (paramInt < this.rAM)
          {
            localRandomAccessFile1 = i.cS(this.rAN + "/" + DX(paramInt), true);
            this.rAO.put(paramInt, localRandomAccessFile1);
            paramInt += 1;
          }
          AppMethodBeat.o(111280);
          return;
        }
        if (paramInt < 0)
        {
          czt();
          paramInt = 0;
          while (paramInt < this.rAM)
          {
            localRandomAccessFile1 = i.cS(this.rAN + "/" + DX(paramInt), true);
            this.rAO.put(paramInt, localRandomAccessFile1);
            paramInt += 1;
          }
          AppMethodBeat.o(111280);
          return;
        }
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.DiskCache", "load data file error: %s", new Object[] { localException.getMessage() });
        ad.printErrStackTrace("MicroMsg.DiskCache", localException, "", new Object[0]);
        this.rAO = null;
        AppMethodBeat.o(111280);
        return;
      }
      RandomAccessFile localRandomAccessFile2 = i.cS(this.rAN + "/" + DX(paramInt), true);
      close((Closeable)this.rAO.get(paramInt));
      this.rAO.put(paramInt, localRandomAccessFile2);
      AppMethodBeat.o(111280);
      return;
    }
  }
  
  public final Bitmap DW(int paramInt)
  {
    AppMethodBeat.i(111288);
    if ((this.rAO == null) || (this.rAO.size() <= 0))
    {
      ad.e("MicroMsg.DiskCache", "want to get bitmap, but data file is null");
      AppMethodBeat.o(111288);
      return null;
    }
    Object localObject = (bhp)this.rAP.get(paramInt);
    if (localObject != null) {
      try
      {
        byte[] arrayOfByte = new byte[((bhp)localObject).length];
        ad.d("MicroMsg.DiskCache", "read data, beg pos %d, length %d", new Object[] { Long.valueOf(((bhp)localObject).DFv), Integer.valueOf(((bhp)localObject).length) });
        RandomAccessFile localRandomAccessFile = (RandomAccessFile)this.rAO.get(((bhp)localObject).DFw);
        localRandomAccessFile.seek(((bhp)localObject).DFv);
        localRandomAccessFile.read(arrayOfByte, 0, ((bhp)localObject).length);
        localObject = com.tencent.mm.sdk.platformtools.f.cl(arrayOfByte);
        if (localObject != null) {
          ad.d("MicroMsg.DiskCache", "get bitmap from disk cache ok, wh[%d, %d]", new Object[] { Integer.valueOf(((Bitmap)localObject).getWidth()), Integer.valueOf(((Bitmap)localObject).getHeight()) });
        }
        for (;;)
        {
          AppMethodBeat.o(111288);
          return localObject;
          this.rAP.remove(paramInt);
        }
        ad.w("MicroMsg.DiskCache", "oh!!! indexNode is null!!!");
      }
      catch (Throwable localThrowable)
      {
        ad.w("MicroMsg.DiskCache", "read data fail, key[%d]: %s", new Object[] { Integer.valueOf(paramInt), localThrowable.getMessage() });
        ad.printErrStackTrace("MicroMsg.DiskCache", localThrowable, "", new Object[0]);
        this.rAP.remove(paramInt);
        AppMethodBeat.o(111288);
        return null;
      }
    }
    AppMethodBeat.o(111288);
    return null;
  }
  
  public final void a(int paramInt, Bitmap paramBitmap)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(111287);
    if ((this.rAO == null) || (this.rAO.size() <= 0))
    {
      if (this.rAO == null) {}
      for (;;)
      {
        ad.e("MicroMsg.DiskCache", "want to put bitmap, but data file is invalid, is null?[%s]", new Object[] { Boolean.valueOf(bool1) });
        AppMethodBeat.o(111287);
        return;
        bool1 = false;
      }
    }
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      if (paramBitmap == null) {}
      for (bool1 = bool2;; bool1 = false)
      {
        ad.e("MicroMsg.DiskCache", "put bmp, value error, bmp is null? [%s]", new Object[] { Boolean.valueOf(bool1) });
        AppMethodBeat.o(111287);
        return;
      }
    }
    ad.d("MicroMsg.DiskCache", "put bmp key[%d] size[%d, %d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) });
    int i = czv();
    if (i < 0)
    {
      ad.e("MicroMsg.DiskCache", "impossible!!! put bmp, file suffix < 0");
      AppMethodBeat.o(111287);
      return;
    }
    bhp localbhp = (bhp)this.rAP.get(paramInt);
    if (localbhp == null)
    {
      localbhp = new bhp();
      localbhp.key = paramInt;
    }
    for (;;)
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      try
      {
        paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
        long l = System.currentTimeMillis();
        paramBitmap = (RandomAccessFile)this.rAO.get(i);
        localbhp.DFv = paramBitmap.length();
        localbhp.DFw = i;
        localbhp.length = localByteArrayOutputStream.size();
        byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
        paramBitmap.seek(localbhp.DFv);
        paramBitmap.write(arrayOfByte);
        this.rAQ = i;
        ad.d("MicroMsg.DiskCache", "jacks [time: %d]save data ok, key[%d] beg pos %d, length %d, file_suffix %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(localbhp.key), Long.valueOf(localbhp.DFv), Integer.valueOf(localbhp.length), Integer.valueOf(localbhp.DFw) });
        this.rAP.put(paramInt, localbhp);
        return;
      }
      catch (Throwable paramBitmap)
      {
        ad.e("MicroMsg.DiskCache", "error:%s", new Object[] { paramBitmap.getMessage() });
        ad.printErrStackTrace("MicroMsg.DiskCache", paramBitmap, "", new Object[0]);
        return;
      }
      finally
      {
        close(localByteArrayOutputStream);
        AppMethodBeat.o(111287);
      }
    }
  }
  
  final void czr()
  {
    AppMethodBeat.i(111279);
    e locale = new e(this.rAN, "cache.idx");
    Object localObject2 = new bho();
    Object localObject3 = q.B(locale.fhU());
    ad.d("MicroMsg.DiskCache", "pennqin debug disk cache path: %s.", new Object[] { localObject3 });
    Object localObject1 = localObject2;
    if (!bt.isNullOrNil((String)localObject3)) {}
    try
    {
      localObject3 = bt.readFromFile((String)localObject3);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        ((bho)localObject2).parseFrom((byte[])localObject3);
        localObject1 = localObject2;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.DiskCache", "load index file error");
        ad.printErrStackTrace("MicroMsg.DiskCache", localException, "", new Object[0]);
        DU(-1);
        bho localbho1 = new bho();
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        ad.e("MicroMsg.DiskCache", "load index file error, OOM, index length %s", new Object[] { Long.valueOf(locale.length()) });
        ad.printErrStackTrace("MicroMsg.DiskCache", localOutOfMemoryError, "", new Object[0]);
        DU(-1);
        bho localbho2 = new bho();
      }
      AppMethodBeat.o(111279);
    }
    this.rAP.clear();
    localObject1 = ((bho)localObject1).DFu.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (bhp)((Iterator)localObject1).next();
      this.rAP.put(((bhp)localObject2).key, localObject2);
    }
  }
  
  final void czs()
  {
    AppMethodBeat.i(111284);
    bho localbho = new bho();
    int i = 0;
    for (;;)
    {
      if (i < this.rAP.size()) {
        try
        {
          bhp localbhp = (bhp)this.rAP.valueAt(i);
          if (localbhp != null)
          {
            localbho.DFu.add(localbhp);
            ad.v("MicroMsg.DiskCache", "index info{key[%s] beg[%d] length[%d] file_suffix[%d]}", new Object[] { Integer.valueOf(localbhp.key), Long.valueOf(localbhp.DFv), Integer.valueOf(localbhp.length), Integer.valueOf(localbhp.DFw) });
          }
          i += 1;
        }
        catch (ClassCastException localClassCastException)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.DiskCache", localClassCastException, "saveIndex ClassCastException.", new Object[0]);
            locale = null;
          }
        }
      }
    }
    e locale = new e(this.rAN, "cache.idx");
    try
    {
      bt.t(q.B(locale.fhU()), localbho.toByteArray());
      AppMethodBeat.o(111284);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.DiskCache", "save index data error: %s", new Object[] { localException.getMessage() });
      ad.printErrStackTrace("MicroMsg.DiskCache", localException, "", new Object[0]);
      AppMethodBeat.o(111284);
    }
  }
  
  final void czt()
  {
    AppMethodBeat.i(111285);
    if ((this.rAO == null) || (this.rAO.size() <= 0))
    {
      AppMethodBeat.o(111285);
      return;
    }
    int i = 0;
    while (i < this.rAO.size())
    {
      close((RandomAccessFile)this.rAO.valueAt(i));
      i += 1;
    }
    this.rAO.clear();
    AppMethodBeat.o(111285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.f
 * JD-Core Version:    0.7.0.1
 */