package com.tencent.mm.plugin.gallery.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.util.SparseArray;
import com.tencent.mm.protocal.c.aqh;
import com.tencent.mm.protocal.c.aqi;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
{
  boolean dirty = true;
  private File kGJ;
  List<RandomAccessFile> kGK;
  SparseArray<aqi> kGL;
  int kGM;
  
  d(File paramFile)
  {
    if (!paramFile.isDirectory())
    {
      boolean bool = paramFile.mkdirs();
      y.d("MicroMsg.DiskCache", "dir[%s] not exist, try to create it, result[%B]", new Object[] { paramFile.getAbsolutePath(), Boolean.valueOf(bool) });
    }
    this.kGJ = paramFile;
    this.kGL = new SparseArray();
  }
  
  static void d(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.DiskCache", "want close %s fail: %s", new Object[] { paramCloseable.getClass().getName(), localException.getMessage() });
      y.printErrStackTrace("MicroMsg.DiskCache", localException, "", new Object[0]);
    }
  }
  
  private static String rM(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("cache.data");
    if (paramInt == 0) {}
    for (String str = "";; str = "." + paramInt) {
      return str;
    }
  }
  
  final void aXj()
  {
    File localFile = new File(this.kGJ, "cache.idx");
    Object localObject2 = new aqh();
    String str = localFile.getAbsolutePath();
    Object localObject1 = localObject2;
    if (!bk.bl(str)) {}
    try
    {
      ((aqh)localObject2).aH(bk.readFromFile(str));
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.DiskCache", "load index file error");
        y.printErrStackTrace("MicroMsg.DiskCache", localException, "", new Object[0]);
        rK(-1);
        aqh localaqh1 = new aqh();
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        y.e("MicroMsg.DiskCache", "load index file error, OOM, index length %s", new Object[] { Long.valueOf(localFile.length()) });
        y.printErrStackTrace("MicroMsg.DiskCache", localOutOfMemoryError, "", new Object[0]);
        rK(-1);
        aqh localaqh2 = new aqh();
      }
    }
    this.kGL.clear();
    localObject1 = ((aqh)localObject1).tmn.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (aqi)((Iterator)localObject1).next();
      this.kGL.put(((aqi)localObject2).key, localObject2);
    }
  }
  
  final void aXk()
  {
    aqh localaqh = new aqh();
    int i = 0;
    while (i < this.kGL.size())
    {
      localObject = (aqi)this.kGL.valueAt(i);
      localaqh.tmn.add(0, localObject);
      y.v("MicroMsg.DiskCache", "index info{key[%s] beg[%d] length[%d] file_suffix[%d]}", new Object[] { Integer.valueOf(((aqi)localObject).key), Long.valueOf(((aqi)localObject).tmo), Integer.valueOf(((aqi)localObject).length), Integer.valueOf(((aqi)localObject).tmp) });
      i += 1;
    }
    Object localObject = new File(this.kGJ, "cache.idx");
    try
    {
      bk.r(((File)localObject).getAbsolutePath(), localaqh.toByteArray());
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.DiskCache", "save index data error: %s", new Object[] { localException.getMessage() });
      y.printErrStackTrace("MicroMsg.DiskCache", localException, "", new Object[0]);
    }
  }
  
  /* Error */
  final void aXl()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 232	com/tencent/mm/plugin/gallery/model/d:kGK	Ljava/util/List;
    //   6: ifnull +17 -> 23
    //   9: aload_0
    //   10: getfield 232	com/tencent/mm/plugin/gallery/model/d:kGK	Ljava/util/List;
    //   13: invokeinterface 235 1 0
    //   18: istore_1
    //   19: iload_1
    //   20: ifgt +6 -> 26
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: getfield 232	com/tencent/mm/plugin/gallery/model/d:kGK	Ljava/util/List;
    //   30: invokeinterface 236 1 0
    //   35: astore_2
    //   36: aload_2
    //   37: invokeinterface 155 1 0
    //   42: ifeq -19 -> 23
    //   45: aload_2
    //   46: invokeinterface 159 1 0
    //   51: checkcast 238	java/io/RandomAccessFile
    //   54: invokestatic 240	com/tencent/mm/plugin/gallery/model/d:d	(Ljava/io/Closeable;)V
    //   57: goto -21 -> 36
    //   60: astore_2
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_2
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	d
    //   18	2	1	i	int
    //   35	11	2	localIterator	Iterator
    //   60	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	60	finally
    //   26	36	60	finally
    //   36	57	60	finally
  }
  
  /* Error */
  public final int aXm()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: iload_2
    //   5: istore_1
    //   6: aload_0
    //   7: getfield 232	com/tencent/mm/plugin/gallery/model/d:kGK	Ljava/util/List;
    //   10: ifnull +19 -> 29
    //   13: aload_0
    //   14: getfield 232	com/tencent/mm/plugin/gallery/model/d:kGK	Ljava/util/List;
    //   17: invokeinterface 235 1 0
    //   22: istore_1
    //   23: iload_1
    //   24: ifgt +9 -> 33
    //   27: iload_2
    //   28: istore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: iload_1
    //   32: ireturn
    //   33: aload_0
    //   34: getfield 232	com/tencent/mm/plugin/gallery/model/d:kGK	Ljava/util/List;
    //   37: invokeinterface 236 1 0
    //   42: astore 5
    //   44: iconst_m1
    //   45: istore_1
    //   46: aload 5
    //   48: invokeinterface 155 1 0
    //   53: ifeq +40 -> 93
    //   56: aload 5
    //   58: invokeinterface 159 1 0
    //   63: checkcast 238	java/io/RandomAccessFile
    //   66: astore 6
    //   68: iload_1
    //   69: iconst_1
    //   70: iadd
    //   71: istore_2
    //   72: aload 6
    //   74: invokevirtual 244	java/io/RandomAccessFile:length	()J
    //   77: lstore_3
    //   78: iload_2
    //   79: istore_1
    //   80: lload_3
    //   81: ldc2_w 245
    //   84: lcmp
    //   85: ifge -39 -> 46
    //   88: iload_2
    //   89: istore_1
    //   90: goto -61 -> 29
    //   93: iconst_m1
    //   94: istore_1
    //   95: goto -66 -> 29
    //   98: astore 5
    //   100: ldc 34
    //   102: aload 5
    //   104: ldc 87
    //   106: iconst_0
    //   107: anewarray 4	java/lang/Object
    //   110: invokestatic 91	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   113: iconst_m1
    //   114: istore_1
    //   115: goto -86 -> 29
    //   118: astore 5
    //   120: aload_0
    //   121: monitorexit
    //   122: aload 5
    //   124: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	d
    //   5	110	1	i	int
    //   1	88	2	j	int
    //   77	4	3	l	long
    //   42	15	5	localIterator	Iterator
    //   98	5	5	localIOException	java.io.IOException
    //   118	5	5	localObject	Object
    //   66	7	6	localRandomAccessFile	RandomAccessFile
    // Exception table:
    //   from	to	target	type
    //   33	44	98	java/io/IOException
    //   46	68	98	java/io/IOException
    //   72	78	98	java/io/IOException
    //   6	23	118	finally
    //   33	44	118	finally
    //   46	68	118	finally
    //   72	78	118	finally
    //   100	113	118	finally
  }
  
  public final void aXn()
  {
    ae.getContext().getSharedPreferences(ae.cqR(), 0).edit().putInt("com.tencent.mm.gallery.cache.suffix", this.kGM).commit();
  }
  
  final void rJ(int paramInt)
  {
    int i = 0;
    if (paramInt >= 0) {}
    try
    {
      if (this.kGK == null)
      {
        this.kGK = new ArrayList();
        paramInt = i;
        while (paramInt < 25)
        {
          localRandomAccessFile = new RandomAccessFile(new File(this.kGJ, rM(paramInt)), "rw");
          this.kGK.add(localRandomAccessFile);
          paramInt += 1;
        }
      }
      RandomAccessFile localRandomAccessFile = new RandomAccessFile(new File(this.kGJ, rM(paramInt)), "rw");
      this.kGK.remove(paramInt);
      this.kGK.add(paramInt, localRandomAccessFile);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.DiskCache", "create data file error: %s", new Object[] { localException.getMessage() });
        y.printErrStackTrace("MicroMsg.DiskCache", localException, "", new Object[0]);
        this.kGK = null;
      }
    }
    finally {}
  }
  
  final void rK(int paramInt)
  {
    int j = 0;
    if ((this.kGK == null) || (this.kGK.size() <= 0)) {
      return;
    }
    if (paramInt < 0)
    {
      new File(this.kGJ, "cache.idx").delete();
      this.kGL.clear();
    }
    for (;;)
    {
      if (paramInt >= 0) {
        break label217;
      }
      aXl();
      paramInt = j;
      while (paramInt < 25)
      {
        new File(this.kGJ, rM(25)).delete();
        paramInt += 1;
      }
      break;
      SparseArray localSparseArray = new SparseArray();
      int i = 0;
      while (i < this.kGL.size())
      {
        aqi localaqi = (aqi)this.kGL.valueAt(i);
        if (localaqi.tmp != paramInt) {
          localSparseArray.put(this.kGL.keyAt(i), localaqi);
        }
        y.v("MicroMsg.DiskCache", "index info{key[%s] beg[%d] length[%d]}", new Object[] { Integer.valueOf(localaqi.key), Long.valueOf(localaqi.tmo), Integer.valueOf(localaqi.length) });
        i += 1;
      }
      this.kGL = localSparseArray;
      aXk();
    }
    label217:
    d((Closeable)this.kGK.get(paramInt));
    new File(this.kGJ, rM(paramInt)).delete();
  }
  
  public final Bitmap rL(int paramInt)
  {
    if ((this.kGK == null) || (this.kGK.size() <= 0))
    {
      y.e("MicroMsg.DiskCache", "want to get bitmap, but data file is null");
      return null;
    }
    Object localObject = (aqi)this.kGL.get(paramInt);
    if (localObject != null)
    {
      byte[] arrayOfByte = new byte[((aqi)localObject).length];
      try
      {
        y.d("MicroMsg.DiskCache", "read data, beg pos %d, length %d", new Object[] { Long.valueOf(((aqi)localObject).tmo), Integer.valueOf(((aqi)localObject).length) });
        RandomAccessFile localRandomAccessFile = (RandomAccessFile)this.kGK.get(((aqi)localObject).tmp);
        localRandomAccessFile.seek(((aqi)localObject).tmo);
        localRandomAccessFile.read(arrayOfByte, 0, ((aqi)localObject).length);
        localObject = c.bu(arrayOfByte);
        if (localObject != null)
        {
          y.d("MicroMsg.DiskCache", "get bitmap from disk cache ok, wh[%d, %d]", new Object[] { Integer.valueOf(((Bitmap)localObject).getWidth()), Integer.valueOf(((Bitmap)localObject).getHeight()) });
          return localObject;
        }
      }
      catch (Exception localException)
      {
        y.w("MicroMsg.DiskCache", "read data fail, key[%d]: %s", new Object[] { Integer.valueOf(paramInt), localException.getMessage() });
        y.printErrStackTrace("MicroMsg.DiskCache", localException, "", new Object[0]);
        this.kGL.remove(paramInt);
        return null;
      }
      this.kGL.remove(paramInt);
      return localException;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.d
 * JD-Core Version:    0.7.0.1
 */