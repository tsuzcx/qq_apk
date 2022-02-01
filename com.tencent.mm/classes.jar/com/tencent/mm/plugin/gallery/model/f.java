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
import com.tencent.mm.protocal.protobuf.blg;
import com.tencent.mm.protocal.protobuf.blh;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
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
  private int sJE;
  private e sJF;
  private SparseArray<RandomAccessFile> sJG;
  private SparseArray<blh> sJH;
  int sJI;
  
  f()
  {
    AppMethodBeat.i(111278);
    this.sJE = 5;
    Object localObject1 = PreferenceManager.getDefaultSharedPreferences(ai.getContext());
    if (((SharedPreferences)localObject1).getInt("com.tencent.mm.plugin.gallery.cache.cache-up-to-date", 0) == 0)
    {
      ((SharedPreferences)localObject1).edit().putInt("com.tencent.mm.plugin.gallery.cache.cache-up-to-date", 1).apply();
      localObject1 = cMJ();
      ac.i("MicroMsg.DiskCache", (String)localObject1);
      i.cU((String)localObject1, true);
    }
    long l1 = 0L;
    try
    {
      localObject1 = new StatFs(b.apb());
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
    ac.d("MicroMsg.DiskCache", "adjustCacheFileNum: %s gb: %s.", new Object[] { Long.valueOf(l1), Integer.valueOf(i) });
    if (i < 64)
    {
      this.sJE = 5;
      i = PreferenceManager.getDefaultSharedPreferences(ai.getContext()).getInt("com.tencent.mm.plugin.gallery.cache.cache-file-num", 0);
      if ((i == 0) || (i != this.sJE))
      {
        localObject1 = cMK();
        if (localObject1 == null) {
          break label354;
        }
        ac.i("MicroMsg.DiskCache", "cache path: %s.", new Object[] { localObject1 });
        i.cU((String)localObject1, true);
      }
    }
    for (;;)
    {
      PreferenceManager.getDefaultSharedPreferences(ai.getContext()).edit().putInt("com.tencent.mm.plugin.gallery.cache.cache-file-num", this.sJE).apply();
      String str = cMK();
      localObject1 = str;
      if (str == null)
      {
        ac.i("MicroMsg.DiskCache", "wtf!!! use old dir!!!");
        localObject1 = cMJ();
      }
      if (bs.isNullOrNil((String)localObject1)) {
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
        this.sJE = 10;
        break;
      }
      if (i < 256)
      {
        this.sJE = 20;
        break;
      }
      this.sJE = 25;
      break;
      label354:
      ac.e("MicroMsg.DiskCache", "wtf!!! shared storage is not currently available.");
    }
    label364:
    if (!((e)localObject1).isDirectory())
    {
      bool = ((e)localObject1).mkdirs();
      ac.d("MicroMsg.DiskCache", "dir[%s] not exist, try to create it, result[%B]", new Object[] { q.B(((e)localObject1).fxV()), Boolean.valueOf(bool) });
    }
    this.sJF = ((e)localObject1);
    this.sJH = new SparseArray();
    AppMethodBeat.o(111278);
  }
  
  private void FQ(int paramInt)
  {
    AppMethodBeat.i(111281);
    ac.d("MicroMsg.DiskCache", "pennqin debug disk cache deleteDataAndIndex: %s.", new Object[] { Integer.valueOf(paramInt) });
    if ((this.sJG == null) || (this.sJG.size() <= 0))
    {
      if (this.sJG == null) {}
      for (boolean bool = true;; bool = false)
      {
        ac.w("MicroMsg.DiskCache", "file map is invalid, is null? [%s]", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(111281);
        return;
      }
    }
    if (paramInt < 0)
    {
      ac.d("MicroMsg.DiskCache", "pennqin debug disk cache delete res: %s.", new Object[] { Boolean.valueOf(new e(this.sJF, "cache.idx").delete()) });
      this.sJH.clear();
    }
    while (paramInt < 0)
    {
      cMF();
      cMG();
      AppMethodBeat.o(111281);
      return;
      SparseArray localSparseArray = new SparseArray();
      int i = 0;
      while (i < this.sJH.size())
      {
        blh localblh = (blh)this.sJH.valueAt(i);
        if (localblh.FaQ != paramInt) {
          localSparseArray.put(this.sJH.keyAt(i), localblh);
        }
        ac.v("MicroMsg.DiskCache", "index info{key[%s] beg[%d] length[%d]}", new Object[] { Integer.valueOf(localblh.key), Long.valueOf(localblh.FaP), Integer.valueOf(localblh.length) });
        i += 1;
      }
      this.sJH = localSparseArray;
      cME();
    }
    close((Closeable)this.sJG.get(paramInt));
    ac.d("MicroMsg.DiskCache", "pennqin debug disk cache deleteDataAndIndex delete file res: %s.", new Object[] { Boolean.valueOf(new e(this.sJF, FT(paramInt)).delete()) });
    AppMethodBeat.o(111281);
  }
  
  private void FR(int paramInt)
  {
    AppMethodBeat.i(111282);
    ac.d("MicroMsg.DiskCache", "jacks reset Index and Data: %d", new Object[] { Integer.valueOf(paramInt) });
    FQ(paramInt);
    FP(paramInt);
    AppMethodBeat.o(111282);
  }
  
  private static String FT(int paramInt)
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
  
  private void cMG()
  {
    AppMethodBeat.i(111286);
    ac.d("MicroMsg.DiskCache", "pennqin debug disk cache !!!delete all cache file!!!");
    int i = 0;
    while (i < this.sJE)
    {
      ac.d("MicroMsg.DiskCache", "pennqin debug disk cache deleteDataAndIndex delete file res: %s.", new Object[] { Boolean.valueOf(new e(this.sJF, FT(this.sJE)).delete()) });
      i += 1;
    }
    AppMethodBeat.o(111286);
  }
  
  private int cMH()
  {
    int i = 0;
    AppMethodBeat.i(111290);
    if ((this.sJG == null) || (this.sJG.size() <= 0))
    {
      ac.d("MicroMsg.DiskCache", "checkDataSize, cache file invalid.");
      AppMethodBeat.o(111290);
      return -1;
    }
    int j = cMI();
    if (j < 0)
    {
      ac.d("MicroMsg.DiskCache", "jacks checkDataSize currentSuffix: %d", new Object[] { Integer.valueOf(this.sJI) });
      if (this.sJI + 1 >= this.sJE) {
        FR(i);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(111290);
      return i;
      i = this.sJI + 1;
      break;
      i = j;
    }
  }
  
  private int cMI()
  {
    AppMethodBeat.i(111291);
    if ((this.sJG == null) || (this.sJG.size() <= 0))
    {
      AppMethodBeat.o(111291);
      return -1;
    }
    int i = 0;
    try
    {
      while (i < this.sJG.size())
      {
        RandomAccessFile localRandomAccessFile = (RandomAccessFile)this.sJG.valueAt(i);
        ac.d("MicroMsg.DiskCache", "pennqin debug disk cache r.length[%s] MAX_CACHE_FILE_SIZE[%s]", new Object[] { Long.valueOf(localRandomAccessFile.length()), Integer.valueOf(52428800) });
        if (localRandomAccessFile.length() < 52428800L)
        {
          ac.d("MicroMsg.DiskCache", "pennqin debug disk cache getUsedSuffix, %s.", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(111291);
          return i;
        }
        i += 1;
      }
      return -1;
    }
    catch (IOException localIOException)
    {
      ac.printErrStackTrace("MicroMsg.DiskCache", localIOException, "", new Object[0]);
      AppMethodBeat.o(111291);
    }
  }
  
  private static String cMJ()
  {
    AppMethodBeat.i(111292);
    String str = b.aph() + "diskcache";
    AppMethodBeat.o(111292);
    return str;
  }
  
  private static String cMK()
  {
    AppMethodBeat.i(111293);
    try
    {
      Object localObject = e.U(ai.getContext().getExternalCacheDir());
      localObject = q.B(((e)localObject).fxV()) + "/imgcache";
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
        ac.e("MicroMsg.DiskCache", "want close %s fail: %s", new Object[] { paramCloseable.getClass().getName(), localException.getMessage() });
        ac.printErrStackTrace("MicroMsg.DiskCache", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(111283);
  }
  
  final void FP(int paramInt)
  {
    AppMethodBeat.i(111280);
    if (this.sJG == null) {}
    for (boolean bool = true;; bool = false)
    {
      ac.d("MicroMsg.DiskCache", "pennqin debug disk cache fileSuffix: %s, mDataFileMap == null? [%s].", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      try
      {
        RandomAccessFile localRandomAccessFile1;
        if (this.sJG == null)
        {
          this.sJG = new SparseArray();
          paramInt = 0;
          while (paramInt < this.sJE)
          {
            localRandomAccessFile1 = i.cY(this.sJF + "/" + FT(paramInt), true);
            this.sJG.put(paramInt, localRandomAccessFile1);
            paramInt += 1;
          }
          AppMethodBeat.o(111280);
          return;
        }
        if (paramInt < 0)
        {
          cMF();
          paramInt = 0;
          while (paramInt < this.sJE)
          {
            localRandomAccessFile1 = i.cY(this.sJF + "/" + FT(paramInt), true);
            this.sJG.put(paramInt, localRandomAccessFile1);
            paramInt += 1;
          }
          AppMethodBeat.o(111280);
          return;
        }
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.DiskCache", "load data file error: %s", new Object[] { localException.getMessage() });
        ac.printErrStackTrace("MicroMsg.DiskCache", localException, "", new Object[0]);
        this.sJG = null;
        AppMethodBeat.o(111280);
        return;
      }
      RandomAccessFile localRandomAccessFile2 = i.cY(this.sJF + "/" + FT(paramInt), true);
      close((Closeable)this.sJG.get(paramInt));
      this.sJG.put(paramInt, localRandomAccessFile2);
      AppMethodBeat.o(111280);
      return;
    }
  }
  
  public final Bitmap FS(int paramInt)
  {
    AppMethodBeat.i(111288);
    if ((this.sJG == null) || (this.sJG.size() <= 0))
    {
      ac.e("MicroMsg.DiskCache", "want to get bitmap, but data file is null");
      AppMethodBeat.o(111288);
      return null;
    }
    Object localObject = (blh)this.sJH.get(paramInt);
    if (localObject != null) {
      try
      {
        byte[] arrayOfByte = new byte[((blh)localObject).length];
        ac.d("MicroMsg.DiskCache", "read data, beg pos %d, length %d", new Object[] { Long.valueOf(((blh)localObject).FaP), Integer.valueOf(((blh)localObject).length) });
        RandomAccessFile localRandomAccessFile = (RandomAccessFile)this.sJG.get(((blh)localObject).FaQ);
        localRandomAccessFile.seek(((blh)localObject).FaP);
        localRandomAccessFile.read(arrayOfByte, 0, ((blh)localObject).length);
        localObject = com.tencent.mm.sdk.platformtools.f.ck(arrayOfByte);
        if (localObject != null) {
          ac.d("MicroMsg.DiskCache", "get bitmap from disk cache ok, wh[%d, %d]", new Object[] { Integer.valueOf(((Bitmap)localObject).getWidth()), Integer.valueOf(((Bitmap)localObject).getHeight()) });
        }
        for (;;)
        {
          AppMethodBeat.o(111288);
          return localObject;
          this.sJH.remove(paramInt);
        }
        ac.w("MicroMsg.DiskCache", "oh!!! indexNode is null!!!");
      }
      catch (Throwable localThrowable)
      {
        ac.w("MicroMsg.DiskCache", "read data fail, key[%d]: %s", new Object[] { Integer.valueOf(paramInt), localThrowable.getMessage() });
        ac.printErrStackTrace("MicroMsg.DiskCache", localThrowable, "", new Object[0]);
        this.sJH.remove(paramInt);
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
    if ((this.sJG == null) || (this.sJG.size() <= 0))
    {
      if (this.sJG == null) {}
      for (;;)
      {
        ac.e("MicroMsg.DiskCache", "want to put bitmap, but data file is invalid, is null?[%s]", new Object[] { Boolean.valueOf(bool1) });
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
        ac.e("MicroMsg.DiskCache", "put bmp, value error, bmp is null? [%s]", new Object[] { Boolean.valueOf(bool1) });
        AppMethodBeat.o(111287);
        return;
      }
    }
    ac.d("MicroMsg.DiskCache", "put bmp key[%d] size[%d, %d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) });
    int i = cMH();
    if (i < 0)
    {
      ac.e("MicroMsg.DiskCache", "impossible!!! put bmp, file suffix < 0");
      AppMethodBeat.o(111287);
      return;
    }
    blh localblh = (blh)this.sJH.get(paramInt);
    if (localblh == null)
    {
      localblh = new blh();
      localblh.key = paramInt;
    }
    for (;;)
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      try
      {
        paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
        long l = System.currentTimeMillis();
        paramBitmap = (RandomAccessFile)this.sJG.get(i);
        localblh.FaP = paramBitmap.length();
        localblh.FaQ = i;
        localblh.length = localByteArrayOutputStream.size();
        byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
        paramBitmap.seek(localblh.FaP);
        paramBitmap.write(arrayOfByte);
        this.sJI = i;
        ac.d("MicroMsg.DiskCache", "jacks [time: %d]save data ok, key[%d] beg pos %d, length %d, file_suffix %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(localblh.key), Long.valueOf(localblh.FaP), Integer.valueOf(localblh.length), Integer.valueOf(localblh.FaQ) });
        this.sJH.put(paramInt, localblh);
        return;
      }
      catch (Throwable paramBitmap)
      {
        ac.e("MicroMsg.DiskCache", "error:%s", new Object[] { paramBitmap.getMessage() });
        ac.printErrStackTrace("MicroMsg.DiskCache", paramBitmap, "", new Object[0]);
        return;
      }
      finally
      {
        close(localByteArrayOutputStream);
        AppMethodBeat.o(111287);
      }
    }
  }
  
  final void cMD()
  {
    AppMethodBeat.i(111279);
    e locale = new e(this.sJF, "cache.idx");
    Object localObject2 = new blg();
    Object localObject3 = q.B(locale.fxV());
    ac.d("MicroMsg.DiskCache", "pennqin debug disk cache path: %s.", new Object[] { localObject3 });
    Object localObject1 = localObject2;
    if (!bs.isNullOrNil((String)localObject3)) {}
    try
    {
      localObject3 = bs.readFromFile((String)localObject3);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        ((blg)localObject2).parseFrom((byte[])localObject3);
        localObject1 = localObject2;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.DiskCache", "load index file error");
        ac.printErrStackTrace("MicroMsg.DiskCache", localException, "", new Object[0]);
        FQ(-1);
        blg localblg1 = new blg();
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        ac.e("MicroMsg.DiskCache", "load index file error, OOM, index length %s", new Object[] { Long.valueOf(locale.length()) });
        ac.printErrStackTrace("MicroMsg.DiskCache", localOutOfMemoryError, "", new Object[0]);
        FQ(-1);
        blg localblg2 = new blg();
      }
      AppMethodBeat.o(111279);
    }
    this.sJH.clear();
    localObject1 = ((blg)localObject1).FaO.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (blh)((Iterator)localObject1).next();
      this.sJH.put(((blh)localObject2).key, localObject2);
    }
  }
  
  final void cME()
  {
    AppMethodBeat.i(111284);
    blg localblg = new blg();
    int i = 0;
    for (;;)
    {
      if (i < this.sJH.size()) {
        try
        {
          blh localblh = (blh)this.sJH.valueAt(i);
          if (localblh != null)
          {
            localblg.FaO.add(localblh);
            ac.v("MicroMsg.DiskCache", "index info{key[%s] beg[%d] length[%d] file_suffix[%d]}", new Object[] { Integer.valueOf(localblh.key), Long.valueOf(localblh.FaP), Integer.valueOf(localblh.length), Integer.valueOf(localblh.FaQ) });
          }
          i += 1;
        }
        catch (ClassCastException localClassCastException)
        {
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.DiskCache", localClassCastException, "saveIndex ClassCastException.", new Object[0]);
            locale = null;
          }
        }
      }
    }
    e locale = new e(this.sJF, "cache.idx");
    try
    {
      bs.t(q.B(locale.fxV()), localblg.toByteArray());
      AppMethodBeat.o(111284);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.DiskCache", "save index data error: %s", new Object[] { localException.getMessage() });
      ac.printErrStackTrace("MicroMsg.DiskCache", localException, "", new Object[0]);
      AppMethodBeat.o(111284);
    }
  }
  
  final void cMF()
  {
    AppMethodBeat.i(111285);
    if ((this.sJG == null) || (this.sJG.size() <= 0))
    {
      AppMethodBeat.o(111285);
      return;
    }
    int i = 0;
    while (i < this.sJG.size())
    {
      close((RandomAccessFile)this.sJG.valueAt(i));
      i += 1;
    }
    this.sJG.clear();
    AppMethodBeat.o(111285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.f
 * JD-Core Version:    0.7.0.1
 */