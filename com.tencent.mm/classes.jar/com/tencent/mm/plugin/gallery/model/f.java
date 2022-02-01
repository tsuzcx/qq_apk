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
import com.tencent.mm.protocal.protobuf.cdb;
import com.tencent.mm.protocal.protobuf.cdc;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
{
  private int xit;
  private o xiu;
  private SparseArray<RandomAccessFile> xiv;
  private SparseArray<cdc> xiw;
  int xix;
  
  f()
  {
    AppMethodBeat.i(111278);
    this.xit = 5;
    Object localObject1 = PreferenceManager.getDefaultSharedPreferences(MMApplicationContext.getContext());
    if (((SharedPreferences)localObject1).getInt("com.tencent.mm.plugin.gallery.cache.cache-up-to-date", 0) == 0)
    {
      ((SharedPreferences)localObject1).edit().putInt("com.tencent.mm.plugin.gallery.cache.cache-up-to-date", 1).apply();
      localObject1 = dRa();
      Log.i("MicroMsg.DiskCache", (String)localObject1);
      s.dy((String)localObject1, true);
    }
    long l1 = 0L;
    try
    {
      localObject1 = new StatFs(b.aKD());
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
    Log.d("MicroMsg.DiskCache", "adjustCacheFileNum: %s gb: %s.", new Object[] { Long.valueOf(l1), Integer.valueOf(i) });
    if (i < 64)
    {
      this.xit = 5;
      i = PreferenceManager.getDefaultSharedPreferences(MMApplicationContext.getContext()).getInt("com.tencent.mm.plugin.gallery.cache.cache-file-num", 0);
      if ((i == 0) || (i != this.xit))
      {
        localObject1 = dRb();
        if (localObject1 == null) {
          break label354;
        }
        Log.i("MicroMsg.DiskCache", "cache path: %s.", new Object[] { localObject1 });
        s.dy((String)localObject1, true);
      }
    }
    for (;;)
    {
      PreferenceManager.getDefaultSharedPreferences(MMApplicationContext.getContext()).edit().putInt("com.tencent.mm.plugin.gallery.cache.cache-file-num", this.xit).apply();
      String str = dRb();
      localObject1 = str;
      if (str == null)
      {
        Log.i("MicroMsg.DiskCache", "wtf!!! use old dir!!!");
        localObject1 = dRa();
      }
      if (Util.isNullOrNil((String)localObject1)) {
        break label437;
      }
      localObject1 = new o((String)localObject1);
      if (localObject1 != null) {
        break label364;
      }
      localObject1 = new IllegalArgumentException("save dir is null");
      AppMethodBeat.o(111278);
      throw ((Throwable)localObject1);
      if (i < 128)
      {
        this.xit = 10;
        break;
      }
      if (i < 256)
      {
        this.xit = 20;
        break;
      }
      this.xit = 25;
      break;
      label354:
      Log.e("MicroMsg.DiskCache", "wtf!!! shared storage is not currently available.");
    }
    label364:
    if (!((o)localObject1).isDirectory())
    {
      bool = ((o)localObject1).mkdirs();
      Log.d("MicroMsg.DiskCache", "dir[%s] not exist, try to create it, result[%B]", new Object[] { aa.z(((o)localObject1).her()), Boolean.valueOf(bool) });
    }
    this.xiu = ((o)localObject1);
    this.xiw = new SparseArray();
    AppMethodBeat.o(111278);
  }
  
  private void NC(int paramInt)
  {
    AppMethodBeat.i(111281);
    Log.d("MicroMsg.DiskCache", "pennqin debug disk cache deleteDataAndIndex: %s.", new Object[] { Integer.valueOf(paramInt) });
    if ((this.xiv == null) || (this.xiv.size() <= 0))
    {
      if (this.xiv == null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.w("MicroMsg.DiskCache", "file map is invalid, is null? [%s]", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(111281);
        return;
      }
    }
    if (paramInt < 0)
    {
      Log.d("MicroMsg.DiskCache", "pennqin debug disk cache delete res: %s.", new Object[] { Boolean.valueOf(new o(this.xiu, "cache.idx").delete()) });
      this.xiw.clear();
    }
    while (paramInt < 0)
    {
      dQW();
      dQX();
      AppMethodBeat.o(111281);
      return;
      SparseArray localSparseArray = new SparseArray();
      int i = 0;
      while (i < this.xiw.size())
      {
        cdc localcdc = (cdc)this.xiw.valueAt(i);
        if (localcdc.MiT != paramInt) {
          localSparseArray.put(this.xiw.keyAt(i), localcdc);
        }
        Log.v("MicroMsg.DiskCache", "index info{key[%s] beg[%d] length[%d]}", new Object[] { Integer.valueOf(localcdc.key), Long.valueOf(localcdc.MiS), Integer.valueOf(localcdc.length) });
        i += 1;
      }
      this.xiw = localSparseArray;
      dQV();
    }
    close((Closeable)this.xiv.get(paramInt));
    Log.d("MicroMsg.DiskCache", "pennqin debug disk cache deleteDataAndIndex delete file res: %s.", new Object[] { Boolean.valueOf(new o(this.xiu, NF(paramInt)).delete()) });
    AppMethodBeat.o(111281);
  }
  
  private void ND(int paramInt)
  {
    AppMethodBeat.i(111282);
    Log.d("MicroMsg.DiskCache", "jacks reset Index and Data: %d", new Object[] { Integer.valueOf(paramInt) });
    NC(paramInt);
    NB(paramInt);
    AppMethodBeat.o(111282);
  }
  
  private static String NF(int paramInt)
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
        Log.e("MicroMsg.DiskCache", "want close %s fail: %s", new Object[] { paramCloseable.getClass().getName(), localException.getMessage() });
        Log.printErrStackTrace("MicroMsg.DiskCache", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(111283);
  }
  
  private void dQX()
  {
    AppMethodBeat.i(111286);
    Log.d("MicroMsg.DiskCache", "pennqin debug disk cache !!!delete all cache file!!!");
    int i = 0;
    while (i < this.xit)
    {
      Log.d("MicroMsg.DiskCache", "pennqin debug disk cache deleteDataAndIndex delete file res: %s.", new Object[] { Boolean.valueOf(new o(this.xiu, NF(this.xit)).delete()) });
      i += 1;
    }
    AppMethodBeat.o(111286);
  }
  
  private int dQY()
  {
    int i = 0;
    AppMethodBeat.i(111290);
    if ((this.xiv == null) || (this.xiv.size() <= 0))
    {
      Log.d("MicroMsg.DiskCache", "checkDataSize, cache file invalid.");
      AppMethodBeat.o(111290);
      return -1;
    }
    int j = dQZ();
    if (j < 0)
    {
      Log.d("MicroMsg.DiskCache", "jacks checkDataSize currentSuffix: %d", new Object[] { Integer.valueOf(this.xix) });
      if (this.xix + 1 >= this.xit) {
        ND(i);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(111290);
      return i;
      i = this.xix + 1;
      break;
      i = j;
    }
  }
  
  private int dQZ()
  {
    AppMethodBeat.i(111291);
    if ((this.xiv == null) || (this.xiv.size() <= 0))
    {
      AppMethodBeat.o(111291);
      return -1;
    }
    int i = 0;
    try
    {
      while (i < this.xiv.size())
      {
        RandomAccessFile localRandomAccessFile = (RandomAccessFile)this.xiv.valueAt(i);
        Log.d("MicroMsg.DiskCache", "pennqin debug disk cache r.length[%s] MAX_CACHE_FILE_SIZE[%s]", new Object[] { Long.valueOf(localRandomAccessFile.length()), Integer.valueOf(52428800) });
        if (localRandomAccessFile.length() < 52428800L)
        {
          Log.d("MicroMsg.DiskCache", "pennqin debug disk cache getUsedSuffix, %s.", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(111291);
          return i;
        }
        i += 1;
      }
      return -1;
    }
    catch (IOException localIOException)
    {
      Log.printErrStackTrace("MicroMsg.DiskCache", localIOException, "", new Object[0]);
      AppMethodBeat.o(111291);
    }
  }
  
  private static String dRa()
  {
    AppMethodBeat.i(111292);
    String str = b.aKJ() + "diskcache";
    AppMethodBeat.o(111292);
    return str;
  }
  
  private static String dRb()
  {
    AppMethodBeat.i(111293);
    try
    {
      Object localObject = o.X(MMApplicationContext.getContext().getExternalCacheDir());
      localObject = aa.z(((o)localObject).her()) + "/imgcache";
      AppMethodBeat.o(111293);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(111293);
    }
    return null;
  }
  
  final void NB(int paramInt)
  {
    AppMethodBeat.i(111280);
    if (this.xiv == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.DiskCache", "pennqin debug disk cache fileSuffix: %s, mDataFileMap == null? [%s].", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      try
      {
        RandomAccessFile localRandomAccessFile1;
        if (this.xiv == null)
        {
          this.xiv = new SparseArray();
          paramInt = 0;
          while (paramInt < this.xit)
          {
            localRandomAccessFile1 = s.dB(this.xiu + "/" + NF(paramInt), true);
            this.xiv.put(paramInt, localRandomAccessFile1);
            paramInt += 1;
          }
          AppMethodBeat.o(111280);
          return;
        }
        if (paramInt < 0)
        {
          dQW();
          paramInt = 0;
          while (paramInt < this.xit)
          {
            localRandomAccessFile1 = s.dB(this.xiu + "/" + NF(paramInt), true);
            this.xiv.put(paramInt, localRandomAccessFile1);
            paramInt += 1;
          }
          AppMethodBeat.o(111280);
          return;
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.DiskCache", "load data file error: %s", new Object[] { localException.getMessage() });
        Log.printErrStackTrace("MicroMsg.DiskCache", localException, "", new Object[0]);
        this.xiv = null;
        AppMethodBeat.o(111280);
        return;
      }
      RandomAccessFile localRandomAccessFile2 = s.dB(this.xiu + "/" + NF(paramInt), true);
      close((Closeable)this.xiv.get(paramInt));
      this.xiv.put(paramInt, localRandomAccessFile2);
      AppMethodBeat.o(111280);
      return;
    }
  }
  
  public final Bitmap NE(int paramInt)
  {
    AppMethodBeat.i(111288);
    if ((this.xiv == null) || (this.xiv.size() <= 0))
    {
      Log.e("MicroMsg.DiskCache", "want to get bitmap, but data file is null");
      AppMethodBeat.o(111288);
      return null;
    }
    Object localObject = (cdc)this.xiw.get(paramInt);
    if (localObject != null) {
      try
      {
        byte[] arrayOfByte = new byte[((cdc)localObject).length];
        Log.d("MicroMsg.DiskCache", "read data, beg pos %d, length %d", new Object[] { Long.valueOf(((cdc)localObject).MiS), Integer.valueOf(((cdc)localObject).length) });
        RandomAccessFile localRandomAccessFile = (RandomAccessFile)this.xiv.get(((cdc)localObject).MiT);
        localRandomAccessFile.seek(((cdc)localObject).MiS);
        localRandomAccessFile.read(arrayOfByte, 0, ((cdc)localObject).length);
        localObject = BitmapUtil.decodeByteArray(arrayOfByte);
        if (localObject != null) {
          Log.d("MicroMsg.DiskCache", "get bitmap from disk cache ok, wh[%d, %d]", new Object[] { Integer.valueOf(((Bitmap)localObject).getWidth()), Integer.valueOf(((Bitmap)localObject).getHeight()) });
        }
        for (;;)
        {
          AppMethodBeat.o(111288);
          return localObject;
          this.xiw.remove(paramInt);
        }
        Log.w("MicroMsg.DiskCache", "oh!!! indexNode is null!!!");
      }
      catch (Throwable localThrowable)
      {
        Log.w("MicroMsg.DiskCache", "read data fail, key[%d]: %s", new Object[] { Integer.valueOf(paramInt), localThrowable.getMessage() });
        Log.printErrStackTrace("MicroMsg.DiskCache", localThrowable, "", new Object[0]);
        this.xiw.remove(paramInt);
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
    if ((this.xiv == null) || (this.xiv.size() <= 0))
    {
      if (this.xiv == null) {}
      for (;;)
      {
        Log.e("MicroMsg.DiskCache", "want to put bitmap, but data file is invalid, is null?[%s]", new Object[] { Boolean.valueOf(bool1) });
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
        Log.e("MicroMsg.DiskCache", "put bmp, value error, bmp is null? [%s]", new Object[] { Boolean.valueOf(bool1) });
        AppMethodBeat.o(111287);
        return;
      }
    }
    Log.d("MicroMsg.DiskCache", "put bmp key[%d] size[%d, %d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) });
    int i = dQY();
    if (i < 0)
    {
      Log.e("MicroMsg.DiskCache", "impossible!!! put bmp, file suffix < 0");
      AppMethodBeat.o(111287);
      return;
    }
    cdc localcdc = (cdc)this.xiw.get(paramInt);
    if (localcdc == null)
    {
      localcdc = new cdc();
      localcdc.key = paramInt;
    }
    for (;;)
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      try
      {
        paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
        long l = System.currentTimeMillis();
        paramBitmap = (RandomAccessFile)this.xiv.get(i);
        localcdc.MiS = paramBitmap.length();
        localcdc.MiT = i;
        localcdc.length = localByteArrayOutputStream.size();
        byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
        paramBitmap.seek(localcdc.MiS);
        paramBitmap.write(arrayOfByte);
        this.xix = i;
        Log.d("MicroMsg.DiskCache", "jacks [time: %d]save data ok, key[%d] beg pos %d, length %d, file_suffix %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(localcdc.key), Long.valueOf(localcdc.MiS), Integer.valueOf(localcdc.length), Integer.valueOf(localcdc.MiT) });
        this.xiw.put(paramInt, localcdc);
        return;
      }
      catch (Throwable paramBitmap)
      {
        Log.e("MicroMsg.DiskCache", "error:%s", new Object[] { paramBitmap.getMessage() });
        Log.printErrStackTrace("MicroMsg.DiskCache", paramBitmap, "", new Object[0]);
        return;
      }
      finally
      {
        close(localByteArrayOutputStream);
        AppMethodBeat.o(111287);
      }
    }
  }
  
  final void dQU()
  {
    AppMethodBeat.i(111279);
    o localo = new o(this.xiu, "cache.idx");
    Object localObject2 = new cdb();
    Object localObject3 = aa.z(localo.her());
    Log.d("MicroMsg.DiskCache", "pennqin debug disk cache path: %s.", new Object[] { localObject3 });
    Object localObject1 = localObject2;
    if (!Util.isNullOrNil((String)localObject3)) {}
    try
    {
      localObject3 = Util.readFromFile((String)localObject3);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        ((cdb)localObject2).parseFrom((byte[])localObject3);
        localObject1 = localObject2;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.DiskCache", "load index file error");
        Log.printErrStackTrace("MicroMsg.DiskCache", localException, "", new Object[0]);
        NC(-1);
        cdb localcdb1 = new cdb();
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        Log.e("MicroMsg.DiskCache", "load index file error, OOM, index length %s", new Object[] { Long.valueOf(localo.length()) });
        Log.printErrStackTrace("MicroMsg.DiskCache", localOutOfMemoryError, "", new Object[0]);
        NC(-1);
        cdb localcdb2 = new cdb();
      }
      AppMethodBeat.o(111279);
    }
    this.xiw.clear();
    localObject1 = ((cdb)localObject1).MiR.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (cdc)((Iterator)localObject1).next();
      this.xiw.put(((cdc)localObject2).key, localObject2);
    }
  }
  
  final void dQV()
  {
    AppMethodBeat.i(111284);
    cdb localcdb = new cdb();
    int i = 0;
    for (;;)
    {
      if (i < this.xiw.size()) {
        try
        {
          cdc localcdc = (cdc)this.xiw.valueAt(i);
          if (localcdc != null)
          {
            localcdb.MiR.add(localcdc);
            Log.v("MicroMsg.DiskCache", "index info{key[%s] beg[%d] length[%d] file_suffix[%d]}", new Object[] { Integer.valueOf(localcdc.key), Long.valueOf(localcdc.MiS), Integer.valueOf(localcdc.length), Integer.valueOf(localcdc.MiT) });
          }
          i += 1;
        }
        catch (ClassCastException localClassCastException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.DiskCache", localClassCastException, "saveIndex ClassCastException.", new Object[0]);
            localo = null;
          }
        }
      }
    }
    o localo = new o(this.xiu, "cache.idx");
    try
    {
      Util.writeToFile(aa.z(localo.her()), localcdb.toByteArray());
      AppMethodBeat.o(111284);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.DiskCache", "save index data error: %s", new Object[] { localException.getMessage() });
      Log.printErrStackTrace("MicroMsg.DiskCache", localException, "", new Object[0]);
      AppMethodBeat.o(111284);
    }
  }
  
  final void dQW()
  {
    AppMethodBeat.i(111285);
    if ((this.xiv == null) || (this.xiv.size() <= 0))
    {
      AppMethodBeat.o(111285);
      return;
    }
    int i = 0;
    while (i < this.xiv.size())
    {
      close((RandomAccessFile)this.xiv.valueAt(i));
      i += 1;
    }
    this.xiv.clear();
    AppMethodBeat.o(111285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.f
 * JD-Core Version:    0.7.0.1
 */