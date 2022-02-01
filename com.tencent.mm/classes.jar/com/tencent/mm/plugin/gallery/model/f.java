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
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.protocal.protobuf.bqk;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
{
  private int tRg;
  private k tRh;
  private SparseArray<RandomAccessFile> tRi;
  private SparseArray<bqk> tRj;
  int tRk;
  
  f()
  {
    AppMethodBeat.i(111278);
    this.tRg = 5;
    Object localObject1 = PreferenceManager.getDefaultSharedPreferences(ak.getContext());
    if (((SharedPreferences)localObject1).getInt("com.tencent.mm.plugin.gallery.cache.cache-up-to-date", 0) == 0)
    {
      ((SharedPreferences)localObject1).edit().putInt("com.tencent.mm.plugin.gallery.cache.cache-up-to-date", 1).apply();
      localObject1 = cXH();
      ae.i("MicroMsg.DiskCache", (String)localObject1);
      o.dd((String)localObject1, true);
    }
    long l1 = 0L;
    try
    {
      localObject1 = new StatFs(b.asd());
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
    ae.d("MicroMsg.DiskCache", "adjustCacheFileNum: %s gb: %s.", new Object[] { Long.valueOf(l1), Integer.valueOf(i) });
    if (i < 64)
    {
      this.tRg = 5;
      i = PreferenceManager.getDefaultSharedPreferences(ak.getContext()).getInt("com.tencent.mm.plugin.gallery.cache.cache-file-num", 0);
      if ((i == 0) || (i != this.tRg))
      {
        localObject1 = cXI();
        if (localObject1 == null) {
          break label354;
        }
        ae.i("MicroMsg.DiskCache", "cache path: %s.", new Object[] { localObject1 });
        o.dd((String)localObject1, true);
      }
    }
    for (;;)
    {
      PreferenceManager.getDefaultSharedPreferences(ak.getContext()).edit().putInt("com.tencent.mm.plugin.gallery.cache.cache-file-num", this.tRg).apply();
      String str = cXI();
      localObject1 = str;
      if (str == null)
      {
        ae.i("MicroMsg.DiskCache", "wtf!!! use old dir!!!");
        localObject1 = cXH();
      }
      if (bu.isNullOrNil((String)localObject1)) {
        break label437;
      }
      localObject1 = new k((String)localObject1);
      if (localObject1 != null) {
        break label364;
      }
      localObject1 = new IllegalArgumentException("save dir is null");
      AppMethodBeat.o(111278);
      throw ((Throwable)localObject1);
      if (i < 128)
      {
        this.tRg = 10;
        break;
      }
      if (i < 256)
      {
        this.tRg = 20;
        break;
      }
      this.tRg = 25;
      break;
      label354:
      ae.e("MicroMsg.DiskCache", "wtf!!! shared storage is not currently available.");
    }
    label364:
    if (!((k)localObject1).isDirectory())
    {
      bool = ((k)localObject1).mkdirs();
      ae.d("MicroMsg.DiskCache", "dir[%s] not exist, try to create it, result[%B]", new Object[] { w.B(((k)localObject1).fTh()), Boolean.valueOf(bool) });
    }
    this.tRh = ((k)localObject1);
    this.tRj = new SparseArray();
    AppMethodBeat.o(111278);
  }
  
  private void HC(int paramInt)
  {
    AppMethodBeat.i(111281);
    ae.d("MicroMsg.DiskCache", "pennqin debug disk cache deleteDataAndIndex: %s.", new Object[] { Integer.valueOf(paramInt) });
    if ((this.tRi == null) || (this.tRi.size() <= 0))
    {
      if (this.tRi == null) {}
      for (boolean bool = true;; bool = false)
      {
        ae.w("MicroMsg.DiskCache", "file map is invalid, is null? [%s]", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(111281);
        return;
      }
    }
    if (paramInt < 0)
    {
      ae.d("MicroMsg.DiskCache", "pennqin debug disk cache delete res: %s.", new Object[] { Boolean.valueOf(new k(this.tRh, "cache.idx").delete()) });
      this.tRj.clear();
    }
    while (paramInt < 0)
    {
      cXD();
      cXE();
      AppMethodBeat.o(111281);
      return;
      SparseArray localSparseArray = new SparseArray();
      int i = 0;
      while (i < this.tRj.size())
      {
        bqk localbqk = (bqk)this.tRj.valueAt(i);
        if (localbqk.HdQ != paramInt) {
          localSparseArray.put(this.tRj.keyAt(i), localbqk);
        }
        ae.v("MicroMsg.DiskCache", "index info{key[%s] beg[%d] length[%d]}", new Object[] { Integer.valueOf(localbqk.key), Long.valueOf(localbqk.HdP), Integer.valueOf(localbqk.length) });
        i += 1;
      }
      this.tRj = localSparseArray;
      cXC();
    }
    close((Closeable)this.tRi.get(paramInt));
    ae.d("MicroMsg.DiskCache", "pennqin debug disk cache deleteDataAndIndex delete file res: %s.", new Object[] { Boolean.valueOf(new k(this.tRh, HF(paramInt)).delete()) });
    AppMethodBeat.o(111281);
  }
  
  private void HD(int paramInt)
  {
    AppMethodBeat.i(111282);
    ae.d("MicroMsg.DiskCache", "jacks reset Index and Data: %d", new Object[] { Integer.valueOf(paramInt) });
    HC(paramInt);
    HB(paramInt);
    AppMethodBeat.o(111282);
  }
  
  private static String HF(int paramInt)
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
  
  private void cXE()
  {
    AppMethodBeat.i(111286);
    ae.d("MicroMsg.DiskCache", "pennqin debug disk cache !!!delete all cache file!!!");
    int i = 0;
    while (i < this.tRg)
    {
      ae.d("MicroMsg.DiskCache", "pennqin debug disk cache deleteDataAndIndex delete file res: %s.", new Object[] { Boolean.valueOf(new k(this.tRh, HF(this.tRg)).delete()) });
      i += 1;
    }
    AppMethodBeat.o(111286);
  }
  
  private int cXF()
  {
    int i = 0;
    AppMethodBeat.i(111290);
    if ((this.tRi == null) || (this.tRi.size() <= 0))
    {
      ae.d("MicroMsg.DiskCache", "checkDataSize, cache file invalid.");
      AppMethodBeat.o(111290);
      return -1;
    }
    int j = cXG();
    if (j < 0)
    {
      ae.d("MicroMsg.DiskCache", "jacks checkDataSize currentSuffix: %d", new Object[] { Integer.valueOf(this.tRk) });
      if (this.tRk + 1 >= this.tRg) {
        HD(i);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(111290);
      return i;
      i = this.tRk + 1;
      break;
      i = j;
    }
  }
  
  private int cXG()
  {
    AppMethodBeat.i(111291);
    if ((this.tRi == null) || (this.tRi.size() <= 0))
    {
      AppMethodBeat.o(111291);
      return -1;
    }
    int i = 0;
    try
    {
      while (i < this.tRi.size())
      {
        RandomAccessFile localRandomAccessFile = (RandomAccessFile)this.tRi.valueAt(i);
        ae.d("MicroMsg.DiskCache", "pennqin debug disk cache r.length[%s] MAX_CACHE_FILE_SIZE[%s]", new Object[] { Long.valueOf(localRandomAccessFile.length()), Integer.valueOf(52428800) });
        if (localRandomAccessFile.length() < 52428800L)
        {
          ae.d("MicroMsg.DiskCache", "pennqin debug disk cache getUsedSuffix, %s.", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(111291);
          return i;
        }
        i += 1;
      }
      return -1;
    }
    catch (IOException localIOException)
    {
      ae.printErrStackTrace("MicroMsg.DiskCache", localIOException, "", new Object[0]);
      AppMethodBeat.o(111291);
    }
  }
  
  private static String cXH()
  {
    AppMethodBeat.i(111292);
    String str = b.asj() + "diskcache";
    AppMethodBeat.o(111292);
    return str;
  }
  
  private static String cXI()
  {
    AppMethodBeat.i(111293);
    try
    {
      Object localObject = k.W(ak.getContext().getExternalCacheDir());
      localObject = w.B(((k)localObject).fTh()) + "/imgcache";
      AppMethodBeat.o(111293);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(111293);
    }
    return null;
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
        ae.e("MicroMsg.DiskCache", "want close %s fail: %s", new Object[] { paramCloseable.getClass().getName(), localException.getMessage() });
        ae.printErrStackTrace("MicroMsg.DiskCache", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(111283);
  }
  
  final void HB(int paramInt)
  {
    AppMethodBeat.i(111280);
    if (this.tRi == null) {}
    for (boolean bool = true;; bool = false)
    {
      ae.d("MicroMsg.DiskCache", "pennqin debug disk cache fileSuffix: %s, mDataFileMap == null? [%s].", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      try
      {
        RandomAccessFile localRandomAccessFile1;
        if (this.tRi == null)
        {
          this.tRi = new SparseArray();
          paramInt = 0;
          while (paramInt < this.tRg)
          {
            localRandomAccessFile1 = o.dg(this.tRh + "/" + HF(paramInt), true);
            this.tRi.put(paramInt, localRandomAccessFile1);
            paramInt += 1;
          }
          AppMethodBeat.o(111280);
          return;
        }
        if (paramInt < 0)
        {
          cXD();
          paramInt = 0;
          while (paramInt < this.tRg)
          {
            localRandomAccessFile1 = o.dg(this.tRh + "/" + HF(paramInt), true);
            this.tRi.put(paramInt, localRandomAccessFile1);
            paramInt += 1;
          }
          AppMethodBeat.o(111280);
          return;
        }
      }
      catch (Exception localException)
      {
        ae.e("MicroMsg.DiskCache", "load data file error: %s", new Object[] { localException.getMessage() });
        ae.printErrStackTrace("MicroMsg.DiskCache", localException, "", new Object[0]);
        this.tRi = null;
        AppMethodBeat.o(111280);
        return;
      }
      RandomAccessFile localRandomAccessFile2 = o.dg(this.tRh + "/" + HF(paramInt), true);
      close((Closeable)this.tRi.get(paramInt));
      this.tRi.put(paramInt, localRandomAccessFile2);
      AppMethodBeat.o(111280);
      return;
    }
  }
  
  public final Bitmap HE(int paramInt)
  {
    AppMethodBeat.i(111288);
    if ((this.tRi == null) || (this.tRi.size() <= 0))
    {
      ae.e("MicroMsg.DiskCache", "want to get bitmap, but data file is null");
      AppMethodBeat.o(111288);
      return null;
    }
    Object localObject = (bqk)this.tRj.get(paramInt);
    if (localObject != null) {
      try
      {
        byte[] arrayOfByte = new byte[((bqk)localObject).length];
        ae.d("MicroMsg.DiskCache", "read data, beg pos %d, length %d", new Object[] { Long.valueOf(((bqk)localObject).HdP), Integer.valueOf(((bqk)localObject).length) });
        RandomAccessFile localRandomAccessFile = (RandomAccessFile)this.tRi.get(((bqk)localObject).HdQ);
        localRandomAccessFile.seek(((bqk)localObject).HdP);
        localRandomAccessFile.read(arrayOfByte, 0, ((bqk)localObject).length);
        localObject = h.cu(arrayOfByte);
        if (localObject != null) {
          ae.d("MicroMsg.DiskCache", "get bitmap from disk cache ok, wh[%d, %d]", new Object[] { Integer.valueOf(((Bitmap)localObject).getWidth()), Integer.valueOf(((Bitmap)localObject).getHeight()) });
        }
        for (;;)
        {
          AppMethodBeat.o(111288);
          return localObject;
          this.tRj.remove(paramInt);
        }
        ae.w("MicroMsg.DiskCache", "oh!!! indexNode is null!!!");
      }
      catch (Throwable localThrowable)
      {
        ae.w("MicroMsg.DiskCache", "read data fail, key[%d]: %s", new Object[] { Integer.valueOf(paramInt), localThrowable.getMessage() });
        ae.printErrStackTrace("MicroMsg.DiskCache", localThrowable, "", new Object[0]);
        this.tRj.remove(paramInt);
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
    if ((this.tRi == null) || (this.tRi.size() <= 0))
    {
      if (this.tRi == null) {}
      for (;;)
      {
        ae.e("MicroMsg.DiskCache", "want to put bitmap, but data file is invalid, is null?[%s]", new Object[] { Boolean.valueOf(bool1) });
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
        ae.e("MicroMsg.DiskCache", "put bmp, value error, bmp is null? [%s]", new Object[] { Boolean.valueOf(bool1) });
        AppMethodBeat.o(111287);
        return;
      }
    }
    ae.d("MicroMsg.DiskCache", "put bmp key[%d] size[%d, %d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) });
    int i = cXF();
    if (i < 0)
    {
      ae.e("MicroMsg.DiskCache", "impossible!!! put bmp, file suffix < 0");
      AppMethodBeat.o(111287);
      return;
    }
    bqk localbqk = (bqk)this.tRj.get(paramInt);
    if (localbqk == null)
    {
      localbqk = new bqk();
      localbqk.key = paramInt;
    }
    for (;;)
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      try
      {
        paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
        long l = System.currentTimeMillis();
        paramBitmap = (RandomAccessFile)this.tRi.get(i);
        localbqk.HdP = paramBitmap.length();
        localbqk.HdQ = i;
        localbqk.length = localByteArrayOutputStream.size();
        byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
        paramBitmap.seek(localbqk.HdP);
        paramBitmap.write(arrayOfByte);
        this.tRk = i;
        ae.d("MicroMsg.DiskCache", "jacks [time: %d]save data ok, key[%d] beg pos %d, length %d, file_suffix %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(localbqk.key), Long.valueOf(localbqk.HdP), Integer.valueOf(localbqk.length), Integer.valueOf(localbqk.HdQ) });
        this.tRj.put(paramInt, localbqk);
        return;
      }
      catch (Throwable paramBitmap)
      {
        ae.e("MicroMsg.DiskCache", "error:%s", new Object[] { paramBitmap.getMessage() });
        ae.printErrStackTrace("MicroMsg.DiskCache", paramBitmap, "", new Object[0]);
        return;
      }
      finally
      {
        close(localByteArrayOutputStream);
        AppMethodBeat.o(111287);
      }
    }
  }
  
  final void cXB()
  {
    AppMethodBeat.i(111279);
    k localk = new k(this.tRh, "cache.idx");
    Object localObject2 = new bqj();
    Object localObject3 = w.B(localk.fTh());
    ae.d("MicroMsg.DiskCache", "pennqin debug disk cache path: %s.", new Object[] { localObject3 });
    Object localObject1 = localObject2;
    if (!bu.isNullOrNil((String)localObject3)) {}
    try
    {
      localObject3 = bu.readFromFile((String)localObject3);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        ((bqj)localObject2).parseFrom((byte[])localObject3);
        localObject1 = localObject2;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.DiskCache", "load index file error");
        ae.printErrStackTrace("MicroMsg.DiskCache", localException, "", new Object[0]);
        HC(-1);
        bqj localbqj1 = new bqj();
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        ae.e("MicroMsg.DiskCache", "load index file error, OOM, index length %s", new Object[] { Long.valueOf(localk.length()) });
        ae.printErrStackTrace("MicroMsg.DiskCache", localOutOfMemoryError, "", new Object[0]);
        HC(-1);
        bqj localbqj2 = new bqj();
      }
      AppMethodBeat.o(111279);
    }
    this.tRj.clear();
    localObject1 = ((bqj)localObject1).HdO.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (bqk)((Iterator)localObject1).next();
      this.tRj.put(((bqk)localObject2).key, localObject2);
    }
  }
  
  final void cXC()
  {
    AppMethodBeat.i(111284);
    bqj localbqj = new bqj();
    int i = 0;
    for (;;)
    {
      if (i < this.tRj.size()) {
        try
        {
          bqk localbqk = (bqk)this.tRj.valueAt(i);
          if (localbqk != null)
          {
            localbqj.HdO.add(localbqk);
            ae.v("MicroMsg.DiskCache", "index info{key[%s] beg[%d] length[%d] file_suffix[%d]}", new Object[] { Integer.valueOf(localbqk.key), Long.valueOf(localbqk.HdP), Integer.valueOf(localbqk.length), Integer.valueOf(localbqk.HdQ) });
          }
          i += 1;
        }
        catch (ClassCastException localClassCastException)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.DiskCache", localClassCastException, "saveIndex ClassCastException.", new Object[0]);
            localk = null;
          }
        }
      }
    }
    k localk = new k(this.tRh, "cache.idx");
    try
    {
      bu.u(w.B(localk.fTh()), localbqj.toByteArray());
      AppMethodBeat.o(111284);
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.DiskCache", "save index data error: %s", new Object[] { localException.getMessage() });
      ae.printErrStackTrace("MicroMsg.DiskCache", localException, "", new Object[0]);
      AppMethodBeat.o(111284);
    }
  }
  
  final void cXD()
  {
    AppMethodBeat.i(111285);
    if ((this.tRi == null) || (this.tRi.size() <= 0))
    {
      AppMethodBeat.o(111285);
      return;
    }
    int i = 0;
    while (i < this.tRi.size())
    {
      close((RandomAccessFile)this.tRi.valueAt(i));
      i += 1;
    }
    this.tRi.clear();
    AppMethodBeat.o(111285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.f
 * JD-Core Version:    0.7.0.1
 */