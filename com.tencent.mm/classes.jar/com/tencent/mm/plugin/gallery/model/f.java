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
import com.tencent.mm.protocal.protobuf.clv;
import com.tencent.mm.protocal.protobuf.clw;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
{
  private int BUH;
  private q BUI;
  private SparseArray<RandomAccessFile> BUJ;
  private SparseArray<clw> BUK;
  int BUL;
  
  f()
  {
    AppMethodBeat.i(111278);
    this.BUH = 5;
    Object localObject1 = PreferenceManager.getDefaultSharedPreferences(MMApplicationContext.getContext());
    if (((SharedPreferences)localObject1).getInt("com.tencent.mm.plugin.gallery.cache.cache-up-to-date", 0) == 0)
    {
      ((SharedPreferences)localObject1).edit().putInt("com.tencent.mm.plugin.gallery.cache.cache-up-to-date", 1).apply();
      localObject1 = etB();
      Log.i("MicroMsg.DiskCache", (String)localObject1);
      u.deleteDir((String)localObject1);
    }
    long l1 = 0L;
    try
    {
      localObject1 = new StatFs(b.aSF());
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
      this.BUH = 5;
      i = PreferenceManager.getDefaultSharedPreferences(MMApplicationContext.getContext()).getInt("com.tencent.mm.plugin.gallery.cache.cache-file-num", 0);
      if ((i == 0) || (i != this.BUH))
      {
        localObject1 = etC();
        if (localObject1 == null) {
          break label327;
        }
        Log.i("MicroMsg.DiskCache", "cache path: %s.", new Object[] { localObject1 });
        u.deleteDir((String)localObject1);
      }
    }
    for (;;)
    {
      PreferenceManager.getDefaultSharedPreferences(MMApplicationContext.getContext()).edit().putInt("com.tencent.mm.plugin.gallery.cache.cache-file-num", this.BUH).apply();
      String str = etC();
      localObject1 = str;
      if (str == null)
      {
        Log.i("MicroMsg.DiskCache", "wtf!!! use old dir!!!");
        localObject1 = etB();
      }
      if (Util.isNullOrNil((String)localObject1)) {
        break label407;
      }
      localObject1 = new q((String)localObject1);
      if (localObject1 != null) {
        break label337;
      }
      localObject1 = new IllegalArgumentException("save dir is null");
      AppMethodBeat.o(111278);
      throw ((Throwable)localObject1);
      if (i >= 128) {
        break;
      }
      this.BUH = 10;
      break;
      label327:
      Log.e("MicroMsg.DiskCache", "wtf!!! shared storage is not currently available.");
    }
    label337:
    if (!((q)localObject1).isDirectory())
    {
      bool = ((q)localObject1).ifL();
      Log.d("MicroMsg.DiskCache", "dir[%s] not exist, try to create it, result[%B]", new Object[] { ((q)localObject1).bOF(), Boolean.valueOf(bool) });
    }
    this.BUI = ((q)localObject1);
    this.BUK = new SparseArray();
    AppMethodBeat.o(111278);
  }
  
  private void SQ(int paramInt)
  {
    AppMethodBeat.i(111281);
    Log.d("MicroMsg.DiskCache", "pennqin debug disk cache deleteDataAndIndex: %s.", new Object[] { Integer.valueOf(paramInt) });
    if ((this.BUJ == null) || (this.BUJ.size() <= 0))
    {
      if (this.BUJ == null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.w("MicroMsg.DiskCache", "file map is invalid, is null? [%s]", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(111281);
        return;
      }
    }
    if (paramInt < 0)
    {
      Log.d("MicroMsg.DiskCache", "pennqin debug disk cache delete res: %s.", new Object[] { Boolean.valueOf(new q(this.BUI, "cache.idx").cFq()) });
      this.BUK.clear();
    }
    while (paramInt < 0)
    {
      etx();
      ety();
      AppMethodBeat.o(111281);
      return;
      SparseArray localSparseArray = new SparseArray();
      int i = 0;
      while (i < this.BUK.size())
      {
        clw localclw = (clw)this.BUK.valueAt(i);
        if (localclw.TtI != paramInt) {
          localSparseArray.put(this.BUK.keyAt(i), localclw);
        }
        Log.v("MicroMsg.DiskCache", "index info{key[%s] beg[%d] length[%d]}", new Object[] { Integer.valueOf(localclw.key), Long.valueOf(localclw.TtH), Integer.valueOf(localclw.length) });
        i += 1;
      }
      this.BUK = localSparseArray;
      etw();
    }
    close((Closeable)this.BUJ.get(paramInt));
    Log.d("MicroMsg.DiskCache", "pennqin debug disk cache deleteDataAndIndex delete file res: %s.", new Object[] { Boolean.valueOf(new q(this.BUI, ST(paramInt)).cFq()) });
    AppMethodBeat.o(111281);
  }
  
  private void SR(int paramInt)
  {
    AppMethodBeat.i(111282);
    Log.d("MicroMsg.DiskCache", "jacks reset Index and Data: %d", new Object[] { Integer.valueOf(paramInt) });
    SQ(paramInt);
    SP(paramInt);
    AppMethodBeat.o(111282);
  }
  
  private static String ST(int paramInt)
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
  
  private int etA()
  {
    AppMethodBeat.i(111291);
    if ((this.BUJ == null) || (this.BUJ.size() <= 0))
    {
      AppMethodBeat.o(111291);
      return -1;
    }
    int i = 0;
    try
    {
      while (i < this.BUJ.size())
      {
        RandomAccessFile localRandomAccessFile = (RandomAccessFile)this.BUJ.valueAt(i);
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
  
  private static String etB()
  {
    AppMethodBeat.i(111292);
    String str = b.aSL() + "diskcache";
    AppMethodBeat.o(111292);
    return str;
  }
  
  private static String etC()
  {
    AppMethodBeat.i(111293);
    try
    {
      Object localObject = q.Q(MMApplicationContext.getContext().getExternalCacheDir());
      localObject = ((q)localObject).bOF() + "/imgcache";
      AppMethodBeat.o(111293);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(111293);
    }
    return null;
  }
  
  private void ety()
  {
    AppMethodBeat.i(111286);
    Log.d("MicroMsg.DiskCache", "pennqin debug disk cache !!!delete all cache file!!!");
    int i = 0;
    while (i < this.BUH)
    {
      Log.d("MicroMsg.DiskCache", "pennqin debug disk cache deleteDataAndIndex delete file res: %s.", new Object[] { Boolean.valueOf(new q(this.BUI, ST(this.BUH)).cFq()) });
      i += 1;
    }
    AppMethodBeat.o(111286);
  }
  
  private int etz()
  {
    int i = 0;
    AppMethodBeat.i(111290);
    if ((this.BUJ == null) || (this.BUJ.size() <= 0))
    {
      Log.d("MicroMsg.DiskCache", "checkDataSize, cache file invalid.");
      AppMethodBeat.o(111290);
      return -1;
    }
    int j = etA();
    if (j < 0)
    {
      Log.d("MicroMsg.DiskCache", "jacks checkDataSize currentSuffix: %d", new Object[] { Integer.valueOf(this.BUL) });
      if (this.BUL + 1 >= this.BUH) {
        SR(i);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(111290);
      return i;
      i = this.BUL + 1;
      break;
      i = j;
    }
  }
  
  final void SP(int paramInt)
  {
    AppMethodBeat.i(111280);
    if (this.BUJ == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.DiskCache", "pennqin debug disk cache fileSuffix: %s, mDataFileMap == null? [%s].", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      try
      {
        RandomAccessFile localRandomAccessFile1;
        if (this.BUJ == null)
        {
          this.BUJ = new SparseArray();
          paramInt = 0;
          while (paramInt < this.BUH)
          {
            localRandomAccessFile1 = u.dO(this.BUI + "/" + ST(paramInt), true);
            this.BUJ.put(paramInt, localRandomAccessFile1);
            paramInt += 1;
          }
          AppMethodBeat.o(111280);
          return;
        }
        if (paramInt < 0)
        {
          etx();
          paramInt = 0;
          while (paramInt < this.BUH)
          {
            localRandomAccessFile1 = u.dO(this.BUI + "/" + ST(paramInt), true);
            this.BUJ.put(paramInt, localRandomAccessFile1);
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
        this.BUJ = null;
        AppMethodBeat.o(111280);
        return;
      }
      RandomAccessFile localRandomAccessFile2 = u.dO(this.BUI + "/" + ST(paramInt), true);
      close((Closeable)this.BUJ.get(paramInt));
      this.BUJ.put(paramInt, localRandomAccessFile2);
      AppMethodBeat.o(111280);
      return;
    }
  }
  
  public final Bitmap SS(int paramInt)
  {
    AppMethodBeat.i(111288);
    if ((this.BUJ == null) || (this.BUJ.size() <= 0))
    {
      Log.e("MicroMsg.DiskCache", "want to get bitmap, but data file is null");
      AppMethodBeat.o(111288);
      return null;
    }
    Object localObject = (clw)this.BUK.get(paramInt);
    if (localObject != null) {
      try
      {
        byte[] arrayOfByte = new byte[((clw)localObject).length];
        Log.d("MicroMsg.DiskCache", "read data, beg pos %d, length %d", new Object[] { Long.valueOf(((clw)localObject).TtH), Integer.valueOf(((clw)localObject).length) });
        RandomAccessFile localRandomAccessFile = (RandomAccessFile)this.BUJ.get(((clw)localObject).TtI);
        localRandomAccessFile.seek(((clw)localObject).TtH);
        localRandomAccessFile.read(arrayOfByte, 0, ((clw)localObject).length);
        localObject = BitmapUtil.decodeByteArray(arrayOfByte);
        if (localObject != null) {
          Log.d("MicroMsg.DiskCache", "get bitmap from disk cache ok, wh[%d, %d]", new Object[] { Integer.valueOf(((Bitmap)localObject).getWidth()), Integer.valueOf(((Bitmap)localObject).getHeight()) });
        }
        for (;;)
        {
          AppMethodBeat.o(111288);
          return localObject;
          this.BUK.remove(paramInt);
        }
        Log.w("MicroMsg.DiskCache", "oh!!! indexNode is null!!!");
      }
      catch (Throwable localThrowable)
      {
        Log.w("MicroMsg.DiskCache", "read data fail, key[%d]: %s", new Object[] { Integer.valueOf(paramInt), localThrowable.getMessage() });
        Log.printErrStackTrace("MicroMsg.DiskCache", localThrowable, "", new Object[0]);
        this.BUK.remove(paramInt);
        AppMethodBeat.o(111288);
        return null;
      }
    }
    AppMethodBeat.o(111288);
    return null;
  }
  
  public final void b(int paramInt, Bitmap paramBitmap)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(111287);
    if ((this.BUJ == null) || (this.BUJ.size() <= 0))
    {
      if (this.BUJ == null) {}
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
    int i = etz();
    if (i < 0)
    {
      Log.e("MicroMsg.DiskCache", "impossible!!! put bmp, file suffix < 0");
      AppMethodBeat.o(111287);
      return;
    }
    clw localclw = (clw)this.BUK.get(paramInt);
    if (localclw == null)
    {
      localclw = new clw();
      localclw.key = paramInt;
    }
    for (;;)
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      try
      {
        paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
        long l = System.currentTimeMillis();
        paramBitmap = (RandomAccessFile)this.BUJ.get(i);
        localclw.TtH = paramBitmap.length();
        localclw.TtI = i;
        localclw.length = localByteArrayOutputStream.size();
        byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
        paramBitmap.seek(localclw.TtH);
        paramBitmap.write(arrayOfByte);
        this.BUL = i;
        Log.d("MicroMsg.DiskCache", "jacks [time: %d]save data ok, key[%d] beg pos %d, length %d, file_suffix %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(localclw.key), Long.valueOf(localclw.TtH), Integer.valueOf(localclw.length), Integer.valueOf(localclw.TtI) });
        this.BUK.put(paramInt, localclw);
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
  
  final void etv()
  {
    AppMethodBeat.i(111279);
    q localq = new q(this.BUI, "cache.idx");
    Object localObject2 = new clv();
    Object localObject3 = localq.bOF();
    Log.d("MicroMsg.DiskCache", "pennqin debug disk cache path: %s.", new Object[] { localObject3 });
    Object localObject1 = localObject2;
    if (!Util.isNullOrNil((String)localObject3)) {}
    try
    {
      localObject3 = Util.readFromFile((String)localObject3);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        ((clv)localObject2).parseFrom((byte[])localObject3);
        localObject1 = localObject2;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.DiskCache", "load index file error");
        Log.printErrStackTrace("MicroMsg.DiskCache", localException, "", new Object[0]);
        SQ(-1);
        clv localclv1 = new clv();
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        Log.e("MicroMsg.DiskCache", "load index file error, OOM, index length %s", new Object[] { Long.valueOf(localq.length()) });
        Log.printErrStackTrace("MicroMsg.DiskCache", localOutOfMemoryError, "", new Object[0]);
        SQ(-1);
        clv localclv2 = new clv();
      }
      AppMethodBeat.o(111279);
    }
    this.BUK.clear();
    localObject1 = ((clv)localObject1).TtG.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (clw)((Iterator)localObject1).next();
      this.BUK.put(((clw)localObject2).key, localObject2);
    }
  }
  
  final void etw()
  {
    AppMethodBeat.i(111284);
    clv localclv = new clv();
    int i = 0;
    for (;;)
    {
      if (i < this.BUK.size()) {
        try
        {
          clw localclw = (clw)this.BUK.valueAt(i);
          if (localclw != null)
          {
            localclv.TtG.add(localclw);
            Log.v("MicroMsg.DiskCache", "index info{key[%s] beg[%d] length[%d] file_suffix[%d]}", new Object[] { Integer.valueOf(localclw.key), Long.valueOf(localclw.TtH), Integer.valueOf(localclw.length), Integer.valueOf(localclw.TtI) });
          }
          i += 1;
        }
        catch (ClassCastException localClassCastException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.DiskCache", localClassCastException, "saveIndex ClassCastException.", new Object[0]);
            localq = null;
          }
        }
      }
    }
    q localq = new q(this.BUI, "cache.idx");
    try
    {
      Util.writeToFile(localq.bOF(), localclv.toByteArray());
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
  
  final void etx()
  {
    AppMethodBeat.i(111285);
    if ((this.BUJ == null) || (this.BUJ.size() <= 0))
    {
      AppMethodBeat.o(111285);
      return;
    }
    int i = 0;
    while (i < this.BUJ.size())
    {
      close((RandomAccessFile)this.BUJ.valueAt(i));
      i += 1;
    }
    this.BUJ.clear();
    AppMethodBeat.o(111285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.f
 * JD-Core Version:    0.7.0.1
 */