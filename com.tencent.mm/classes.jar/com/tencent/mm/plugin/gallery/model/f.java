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
import com.tencent.mm.loader.i.b;
import com.tencent.mm.protocal.protobuf.dcd;
import com.tencent.mm.protocal.protobuf.dce;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
{
  private int HHc;
  private u HHd;
  private SparseArray<RandomAccessFile> HHe;
  private SparseArray<dce> HHf;
  int HHg;
  
  f()
  {
    AppMethodBeat.i(111278);
    this.HHc = 5;
    Object localObject1 = PreferenceManager.getDefaultSharedPreferences(MMApplicationContext.getContext());
    if (((SharedPreferences)localObject1).getInt("com.tencent.mm.plugin.gallery.cache.cache-up-to-date", 0) == 0)
    {
      ((SharedPreferences)localObject1).edit().putInt("com.tencent.mm.plugin.gallery.cache.cache-up-to-date", 1).apply();
      localObject1 = fAD();
      Log.i("MicroMsg.DiskCache", (String)localObject1);
      y.ew((String)localObject1, true);
    }
    long l1 = 0L;
    try
    {
      localObject1 = new StatFs(b.bmt());
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
      this.HHc = 5;
      i = PreferenceManager.getDefaultSharedPreferences(MMApplicationContext.getContext()).getInt("com.tencent.mm.plugin.gallery.cache.cache-file-num", 0);
      if ((i == 0) || (i != this.HHc))
      {
        localObject1 = fAE();
        if (localObject1 == null) {
          break label329;
        }
        Log.i("MicroMsg.DiskCache", "cache path: %s.", new Object[] { localObject1 });
        y.ew((String)localObject1, true);
      }
    }
    for (;;)
    {
      PreferenceManager.getDefaultSharedPreferences(MMApplicationContext.getContext()).edit().putInt("com.tencent.mm.plugin.gallery.cache.cache-file-num", this.HHc).apply();
      String str = fAE();
      localObject1 = str;
      if (str == null)
      {
        Log.i("MicroMsg.DiskCache", "wtf!!! use old dir!!!");
        localObject1 = fAD();
      }
      if (Util.isNullOrNil((String)localObject1)) {
        break label412;
      }
      localObject1 = new u((String)localObject1);
      if (localObject1 != null) {
        break label339;
      }
      localObject1 = new IllegalArgumentException("save dir is null");
      AppMethodBeat.o(111278);
      throw ((Throwable)localObject1);
      if (i >= 128) {
        break;
      }
      this.HHc = 10;
      break;
      label329:
      Log.e("MicroMsg.DiskCache", "wtf!!! shared storage is not currently available.");
    }
    label339:
    if (!((u)localObject1).isDirectory())
    {
      bool = ((u)localObject1).jKY();
      Log.d("MicroMsg.DiskCache", "dir[%s] not exist, try to create it, result[%B]", new Object[] { ah.v(((u)localObject1).jKT()), Boolean.valueOf(bool) });
    }
    this.HHd = ((u)localObject1);
    this.HHf = new SparseArray();
    AppMethodBeat.o(111278);
  }
  
  private static String WB(int paramInt)
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
  
  private void Wy(int paramInt)
  {
    AppMethodBeat.i(111281);
    Log.d("MicroMsg.DiskCache", "pennqin debug disk cache deleteDataAndIndex: %s.", new Object[] { Integer.valueOf(paramInt) });
    if ((this.HHe == null) || (this.HHe.size() <= 0))
    {
      if (this.HHe == null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.w("MicroMsg.DiskCache", "file map is invalid, is null? [%s]", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(111281);
        return;
      }
    }
    if (paramInt < 0)
    {
      Log.d("MicroMsg.DiskCache", "pennqin debug disk cache delete res: %s.", new Object[] { Boolean.valueOf(new u(this.HHd, "cache.idx").diJ()) });
      this.HHf.clear();
    }
    while (paramInt < 0)
    {
      fAz();
      fAA();
      AppMethodBeat.o(111281);
      return;
      SparseArray localSparseArray = new SparseArray();
      int i = 0;
      while (i < this.HHf.size())
      {
        dce localdce = (dce)this.HHf.valueAt(i);
        if (localdce.aaHT != paramInt) {
          localSparseArray.put(this.HHf.keyAt(i), localdce);
        }
        Log.v("MicroMsg.DiskCache", "index info{key[%s] beg[%d] length[%d]}", new Object[] { Integer.valueOf(localdce.key), Long.valueOf(localdce.aaHS), Integer.valueOf(localdce.length) });
        i += 1;
      }
      this.HHf = localSparseArray;
      fAy();
    }
    close((Closeable)this.HHe.get(paramInt));
    Log.d("MicroMsg.DiskCache", "pennqin debug disk cache deleteDataAndIndex delete file res: %s.", new Object[] { Boolean.valueOf(new u(this.HHd, WB(paramInt)).diJ()) });
    AppMethodBeat.o(111281);
  }
  
  private void Wz(int paramInt)
  {
    AppMethodBeat.i(111282);
    Log.d("MicroMsg.DiskCache", "jacks reset Index and Data: %d", new Object[] { Integer.valueOf(paramInt) });
    Wy(paramInt);
    Wx(paramInt);
    AppMethodBeat.o(111282);
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
  
  private void fAA()
  {
    AppMethodBeat.i(111286);
    Log.d("MicroMsg.DiskCache", "pennqin debug disk cache !!!delete all cache file!!!");
    int i = 0;
    while (i < this.HHc)
    {
      Log.d("MicroMsg.DiskCache", "pennqin debug disk cache deleteDataAndIndex delete file res: %s.", new Object[] { Boolean.valueOf(new u(this.HHd, WB(this.HHc)).diJ()) });
      i += 1;
    }
    AppMethodBeat.o(111286);
  }
  
  private int fAB()
  {
    int i = 0;
    AppMethodBeat.i(111290);
    if ((this.HHe == null) || (this.HHe.size() <= 0))
    {
      Log.d("MicroMsg.DiskCache", "checkDataSize, cache file invalid.");
      AppMethodBeat.o(111290);
      return -1;
    }
    int j = fAC();
    if (j < 0)
    {
      Log.d("MicroMsg.DiskCache", "jacks checkDataSize currentSuffix: %d", new Object[] { Integer.valueOf(this.HHg) });
      if (this.HHg + 1 >= this.HHc) {
        Wz(i);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(111290);
      return i;
      i = this.HHg + 1;
      break;
      i = j;
    }
  }
  
  private int fAC()
  {
    AppMethodBeat.i(111291);
    if ((this.HHe == null) || (this.HHe.size() <= 0))
    {
      AppMethodBeat.o(111291);
      return -1;
    }
    int i = 0;
    try
    {
      while (i < this.HHe.size())
      {
        RandomAccessFile localRandomAccessFile = (RandomAccessFile)this.HHe.valueAt(i);
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
  
  private static String fAD()
  {
    AppMethodBeat.i(111292);
    String str = b.bmz() + "diskcache";
    AppMethodBeat.o(111292);
    return str;
  }
  
  private static String fAE()
  {
    AppMethodBeat.i(111293);
    try
    {
      Object localObject = u.V(MMApplicationContext.getContext().getExternalCacheDir());
      localObject = ah.v(((u)localObject).jKT()) + "/imgcache";
      AppMethodBeat.o(111293);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(111293);
    }
    return null;
  }
  
  public final Bitmap WA(int paramInt)
  {
    AppMethodBeat.i(111288);
    if ((this.HHe == null) || (this.HHe.size() <= 0))
    {
      Log.e("MicroMsg.DiskCache", "want to get bitmap, but data file is null");
      AppMethodBeat.o(111288);
      return null;
    }
    Object localObject = (dce)this.HHf.get(paramInt);
    if (localObject != null) {
      try
      {
        byte[] arrayOfByte = new byte[((dce)localObject).length];
        Log.d("MicroMsg.DiskCache", "read data, beg pos %d, length %d", new Object[] { Long.valueOf(((dce)localObject).aaHS), Integer.valueOf(((dce)localObject).length) });
        RandomAccessFile localRandomAccessFile = (RandomAccessFile)this.HHe.get(((dce)localObject).aaHT);
        localRandomAccessFile.seek(((dce)localObject).aaHS);
        localRandomAccessFile.read(arrayOfByte, 0, ((dce)localObject).length);
        localObject = BitmapUtil.decodeByteArray(arrayOfByte);
        if (localObject != null) {
          Log.d("MicroMsg.DiskCache", "get bitmap from disk cache ok, wh[%d, %d]", new Object[] { Integer.valueOf(((Bitmap)localObject).getWidth()), Integer.valueOf(((Bitmap)localObject).getHeight()) });
        }
        for (;;)
        {
          AppMethodBeat.o(111288);
          return localObject;
          this.HHf.remove(paramInt);
        }
        Log.w("MicroMsg.DiskCache", "oh!!! indexNode is null!!!");
      }
      finally
      {
        Log.w("MicroMsg.DiskCache", "read data fail, key[%d]: %s", new Object[] { Integer.valueOf(paramInt), localThrowable.getMessage() });
        Log.printErrStackTrace("MicroMsg.DiskCache", localThrowable, "", new Object[0]);
        this.HHf.remove(paramInt);
        AppMethodBeat.o(111288);
        return null;
      }
    }
    AppMethodBeat.o(111288);
    return null;
  }
  
  final void Wx(int paramInt)
  {
    AppMethodBeat.i(111280);
    if (this.HHe == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.DiskCache", "pennqin debug disk cache fileSuffix: %s, mDataFileMap == null? [%s].", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      try
      {
        RandomAccessFile localRandomAccessFile1;
        if (this.HHe == null)
        {
          this.HHe = new SparseArray();
          paramInt = 0;
          while (paramInt < this.HHc)
          {
            localRandomAccessFile1 = y.eA(this.HHd + "/" + WB(paramInt), true);
            this.HHe.put(paramInt, localRandomAccessFile1);
            paramInt += 1;
          }
          AppMethodBeat.o(111280);
          return;
        }
        if (paramInt < 0)
        {
          fAz();
          paramInt = 0;
          while (paramInt < this.HHc)
          {
            localRandomAccessFile1 = y.eA(this.HHd + "/" + WB(paramInt), true);
            this.HHe.put(paramInt, localRandomAccessFile1);
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
        this.HHe = null;
        AppMethodBeat.o(111280);
        return;
      }
      RandomAccessFile localRandomAccessFile2 = y.eA(this.HHd + "/" + WB(paramInt), true);
      close((Closeable)this.HHe.get(paramInt));
      this.HHe.put(paramInt, localRandomAccessFile2);
      AppMethodBeat.o(111280);
      return;
    }
  }
  
  public final void d(int paramInt, Bitmap paramBitmap)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(111287);
    if ((this.HHe == null) || (this.HHe.size() <= 0))
    {
      if (this.HHe == null) {}
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
    int i = fAB();
    if (i < 0)
    {
      Log.e("MicroMsg.DiskCache", "impossible!!! put bmp, file suffix < 0");
      AppMethodBeat.o(111287);
      return;
    }
    dce localdce = (dce)this.HHf.get(paramInt);
    if (localdce == null)
    {
      localdce = new dce();
      localdce.key = paramInt;
    }
    for (;;)
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      try
      {
        paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
        long l = System.currentTimeMillis();
        paramBitmap = (RandomAccessFile)this.HHe.get(i);
        localdce.aaHS = paramBitmap.length();
        localdce.aaHT = i;
        localdce.length = localByteArrayOutputStream.size();
        byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
        paramBitmap.seek(localdce.aaHS);
        paramBitmap.write(arrayOfByte);
        this.HHg = i;
        Log.d("MicroMsg.DiskCache", "jacks [time: %d]save data ok, key[%d] beg pos %d, length %d, file_suffix %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(localdce.key), Long.valueOf(localdce.aaHS), Integer.valueOf(localdce.length), Integer.valueOf(localdce.aaHT) });
        this.HHf.put(paramInt, localdce);
        close(localByteArrayOutputStream);
        AppMethodBeat.o(111287);
        return;
      }
      finally
      {
        try
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
  }
  
  final void fAx()
  {
    AppMethodBeat.i(111279);
    u localu = new u(this.HHd, "cache.idx");
    Object localObject2 = new dcd();
    Object localObject3 = ah.v(localu.jKT());
    Log.d("MicroMsg.DiskCache", "pennqin debug disk cache path: %s.", new Object[] { localObject3 });
    Object localObject1 = localObject2;
    if (!Util.isNullOrNil((String)localObject3)) {}
    try
    {
      localObject3 = Util.readFromFile((String)localObject3);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        ((dcd)localObject2).parseFrom((byte[])localObject3);
        localObject1 = localObject2;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.DiskCache", "load index file error");
        Log.printErrStackTrace("MicroMsg.DiskCache", localException, "", new Object[0]);
        Wy(-1);
        dcd localdcd1 = new dcd();
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        Log.e("MicroMsg.DiskCache", "load index file error, OOM, index length %s", new Object[] { Long.valueOf(localu.length()) });
        Log.printErrStackTrace("MicroMsg.DiskCache", localOutOfMemoryError, "", new Object[0]);
        Wy(-1);
        dcd localdcd2 = new dcd();
      }
      AppMethodBeat.o(111279);
    }
    this.HHf.clear();
    localObject1 = ((dcd)localObject1).aaHR.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (dce)((Iterator)localObject1).next();
      this.HHf.put(((dce)localObject2).key, localObject2);
    }
  }
  
  final void fAy()
  {
    AppMethodBeat.i(111284);
    dcd localdcd = new dcd();
    int i = 0;
    for (;;)
    {
      if (i < this.HHf.size()) {
        try
        {
          dce localdce = (dce)this.HHf.valueAt(i);
          if (localdce != null)
          {
            localdcd.aaHR.add(localdce);
            Log.v("MicroMsg.DiskCache", "index info{key[%s] beg[%d] length[%d] file_suffix[%d]}", new Object[] { Integer.valueOf(localdce.key), Long.valueOf(localdce.aaHS), Integer.valueOf(localdce.length), Integer.valueOf(localdce.aaHT) });
          }
          i += 1;
        }
        catch (ClassCastException localClassCastException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.DiskCache", localClassCastException, "saveIndex ClassCastException.", new Object[0]);
            localu = null;
          }
        }
      }
    }
    u localu = new u(this.HHd, "cache.idx");
    try
    {
      Util.writeToFile(ah.v(localu.jKT()), localdcd.toByteArray());
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
  
  final void fAz()
  {
    AppMethodBeat.i(111285);
    if ((this.HHe == null) || (this.HHe.size() <= 0))
    {
      AppMethodBeat.o(111285);
      return;
    }
    int i = 0;
    while (i < this.HHe.size())
    {
      close((RandomAccessFile)this.HHe.valueAt(i));
      i += 1;
    }
    this.HHe.clear();
    AppMethodBeat.o(111285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.f
 * JD-Core Version:    0.7.0.1
 */