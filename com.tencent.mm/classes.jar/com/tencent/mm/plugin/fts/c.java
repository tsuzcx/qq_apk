package com.tencent.mm.plugin.fts;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public final class c
  implements com.tencent.mm.plugin.fts.a.d.c
{
  private static int kty = 32;
  private ah dPi = new ah(Looper.getMainLooper());
  private Vector<String> ktA;
  private boolean ktB = true;
  private int ktC = 0;
  private ah[] ktD = new ah[2];
  private ConcurrentHashMap<Long, ByteArrayOutputStream> ktE = null;
  private ConcurrentHashMap<Long, byte[]> ktF = null;
  private ah ktG = null;
  private Set<String> ktH;
  private ConcurrentHashMap<String, c.a> ktz;
  
  public c()
  {
    y.i("MicroMsg.FTS.FTSImageLoader", "create SearchImageLoader");
    if (d.gF(19)) {}
    for (kty = 64;; kty = 32)
    {
      this.ktz = new ConcurrentHashMap();
      this.ktA = new Vector();
      this.ktE = new ConcurrentHashMap();
      this.ktF = new ConcurrentHashMap();
      this.ktH = Collections.synchronizedSet(new HashSet());
      while (i < 2)
      {
        if (this.ktD[i] == null) {
          e.c(new c.1(this, i), "SearchImageLoader_loadImage_handler", 1).start();
        }
        i += 1;
      }
    }
    e.c(new c.2(this), "SearchImageLoader_saveImage_handler", 1).start();
  }
  
  private void DG(String paramString)
  {
    c.a locala = (c.a)this.ktz.get(paramString);
    this.ktA.remove(paramString);
    this.ktz.remove(paramString);
    if ((locala != null) && (locala.bitmap != null))
    {
      if (!locala.bitmap.isRecycled())
      {
        y.i("MicroMsg.FTS.FTSImageLoader", "bitmap recycle %s", new Object[] { locala.bitmap });
        locala.bitmap.recycle();
      }
      locala.bitmap = null;
    }
  }
  
  /* Error */
  private Bitmap b(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 188	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   4: ifeq +7 -> 11
    //   7: aconst_null
    //   8: astore_1
    //   9: aload_1
    //   10: areturn
    //   11: aload_0
    //   12: getfield 67	com/tencent/mm/plugin/fts/c:ktE	Ljava/util/concurrent/ConcurrentHashMap;
    //   15: invokestatic 251	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   18: invokevirtual 255	java/lang/Thread:getId	()J
    //   21: invokestatic 261	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   24: invokevirtual 138	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   27: checkcast 263	java/io/ByteArrayOutputStream
    //   30: astore 7
    //   32: aload 7
    //   34: astore 9
    //   36: aload 7
    //   38: ifnonnull +34 -> 72
    //   41: new 263	java/io/ByteArrayOutputStream
    //   44: dup
    //   45: ldc_w 264
    //   48: invokespecial 267	java/io/ByteArrayOutputStream:<init>	(I)V
    //   51: astore 9
    //   53: aload_0
    //   54: getfield 67	com/tencent/mm/plugin/fts/c:ktE	Ljava/util/concurrent/ConcurrentHashMap;
    //   57: invokestatic 251	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   60: invokevirtual 255	java/lang/Thread:getId	()J
    //   63: invokestatic 261	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   66: aload 9
    //   68: invokevirtual 233	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   71: pop
    //   72: aload 9
    //   74: invokevirtual 270	java/io/ByteArrayOutputStream:reset	()V
    //   77: aload_0
    //   78: invokespecial 274	com/tencent/mm/plugin/fts/c:getBuffer	()[B
    //   81: astore 10
    //   83: aload_1
    //   84: sipush 10000
    //   87: sipush 20000
    //   90: invokestatic 280	com/tencent/mm/network/b:n	(Ljava/lang/String;II)Ljava/io/InputStream;
    //   93: astore 7
    //   95: aload 7
    //   97: ifnonnull +401 -> 498
    //   100: aload 7
    //   102: astore 8
    //   104: ldc 73
    //   106: ldc_w 282
    //   109: iconst_1
    //   110: anewarray 4	java/lang/Object
    //   113: dup
    //   114: iconst_0
    //   115: aload_1
    //   116: aastore
    //   117: invokestatic 285	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   120: aload 7
    //   122: ifnull +8 -> 130
    //   125: aload 7
    //   127: invokevirtual 290	java/io/InputStream:close	()V
    //   130: aconst_null
    //   131: areturn
    //   132: astore_1
    //   133: ldc 73
    //   135: aload_1
    //   136: ldc_w 292
    //   139: iconst_0
    //   140: anewarray 4	java/lang/Object
    //   143: invokestatic 296	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   146: goto -16 -> 130
    //   149: aload 7
    //   151: astore 8
    //   153: aload 7
    //   155: aload 10
    //   157: invokevirtual 300	java/io/InputStream:read	([B)I
    //   160: istore 6
    //   162: iload 6
    //   164: iconst_m1
    //   165: if_icmpeq +79 -> 244
    //   168: iload 5
    //   170: iload 6
    //   172: iadd
    //   173: istore 5
    //   175: aload 7
    //   177: astore 8
    //   179: aload 9
    //   181: aload 10
    //   183: iconst_0
    //   184: iload 6
    //   186: invokevirtual 304	java/io/ByteArrayOutputStream:write	([BII)V
    //   189: goto -40 -> 149
    //   192: astore 9
    //   194: aload 7
    //   196: astore 8
    //   198: ldc 73
    //   200: aload 9
    //   202: ldc_w 292
    //   205: iconst_0
    //   206: anewarray 4	java/lang/Object
    //   209: invokestatic 296	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   212: aload 7
    //   214: astore 8
    //   216: ldc 73
    //   218: ldc_w 306
    //   221: iconst_1
    //   222: anewarray 4	java/lang/Object
    //   225: dup
    //   226: iconst_0
    //   227: aload_1
    //   228: aastore
    //   229: invokestatic 285	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   232: aload 7
    //   234: ifnull +8 -> 242
    //   237: aload 7
    //   239: invokevirtual 290	java/io/InputStream:close	()V
    //   242: aconst_null
    //   243: areturn
    //   244: aload 7
    //   246: astore 8
    //   248: aload 9
    //   250: invokevirtual 309	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   253: astore 9
    //   255: iload_3
    //   256: ifle +131 -> 387
    //   259: iload 4
    //   261: ifle +126 -> 387
    //   264: aload 7
    //   266: astore 8
    //   268: aload 9
    //   270: iload_3
    //   271: iload 4
    //   273: invokestatic 315	com/tencent/mm/sdk/platformtools/c:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   276: astore 9
    //   278: aload 7
    //   280: astore 8
    //   282: ldc 73
    //   284: ldc_w 317
    //   287: iconst_4
    //   288: anewarray 4	java/lang/Object
    //   291: dup
    //   292: iconst_0
    //   293: aload_1
    //   294: aastore
    //   295: dup
    //   296: iconst_1
    //   297: iload 5
    //   299: invokestatic 322	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   302: aastore
    //   303: dup
    //   304: iconst_2
    //   305: aload 9
    //   307: invokevirtual 325	android/graphics/Bitmap:getWidth	()I
    //   310: invokestatic 322	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   313: aastore
    //   314: dup
    //   315: iconst_3
    //   316: aload 9
    //   318: invokevirtual 328	android/graphics/Bitmap:getHeight	()I
    //   321: invokestatic 322	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   324: aastore
    //   325: invokestatic 331	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   328: iload_2
    //   329: ifeq +72 -> 401
    //   332: aload 7
    //   334: astore 8
    //   336: aload 9
    //   338: iconst_1
    //   339: aload 9
    //   341: invokevirtual 325	android/graphics/Bitmap:getWidth	()I
    //   344: i2f
    //   345: invokestatic 334	com/tencent/mm/sdk/platformtools/c:a	(Landroid/graphics/Bitmap;ZF)Landroid/graphics/Bitmap;
    //   348: astore 9
    //   350: aload 9
    //   352: astore 8
    //   354: aload 8
    //   356: astore_1
    //   357: aload 7
    //   359: ifnull -350 -> 9
    //   362: aload 7
    //   364: invokevirtual 290	java/io/InputStream:close	()V
    //   367: aload 8
    //   369: areturn
    //   370: astore_1
    //   371: ldc 73
    //   373: aload_1
    //   374: ldc_w 292
    //   377: iconst_0
    //   378: anewarray 4	java/lang/Object
    //   381: invokestatic 296	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   384: aload 8
    //   386: areturn
    //   387: aload 7
    //   389: astore 8
    //   391: aload 9
    //   393: invokestatic 338	com/tencent/mm/sdk/platformtools/c:bu	([B)Landroid/graphics/Bitmap;
    //   396: astore 9
    //   398: goto -120 -> 278
    //   401: aload 9
    //   403: astore_1
    //   404: aload 7
    //   406: ifnull -397 -> 9
    //   409: aload 7
    //   411: invokevirtual 290	java/io/InputStream:close	()V
    //   414: aload 9
    //   416: areturn
    //   417: astore_1
    //   418: ldc 73
    //   420: aload_1
    //   421: ldc_w 292
    //   424: iconst_0
    //   425: anewarray 4	java/lang/Object
    //   428: invokestatic 296	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   431: aload 9
    //   433: areturn
    //   434: astore_1
    //   435: ldc 73
    //   437: aload_1
    //   438: ldc_w 292
    //   441: iconst_0
    //   442: anewarray 4	java/lang/Object
    //   445: invokestatic 296	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   448: goto -206 -> 242
    //   451: astore_1
    //   452: aconst_null
    //   453: astore 8
    //   455: aload 8
    //   457: ifnull +8 -> 465
    //   460: aload 8
    //   462: invokevirtual 290	java/io/InputStream:close	()V
    //   465: aload_1
    //   466: athrow
    //   467: astore 7
    //   469: ldc 73
    //   471: aload 7
    //   473: ldc_w 292
    //   476: iconst_0
    //   477: anewarray 4	java/lang/Object
    //   480: invokestatic 296	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   483: goto -18 -> 465
    //   486: astore_1
    //   487: goto -32 -> 455
    //   490: astore 9
    //   492: aconst_null
    //   493: astore 7
    //   495: goto -301 -> 194
    //   498: iconst_0
    //   499: istore 5
    //   501: goto -352 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	504	0	this	c
    //   0	504	1	paramString	String
    //   0	504	2	paramBoolean	boolean
    //   0	504	3	paramInt1	int
    //   0	504	4	paramInt2	int
    //   168	332	5	i	int
    //   160	25	6	j	int
    //   30	380	7	localObject1	Object
    //   467	5	7	localIOException	IOException
    //   493	1	7	localObject2	Object
    //   102	359	8	localObject3	Object
    //   34	146	9	localObject4	Object
    //   192	57	9	localException1	java.lang.Exception
    //   253	179	9	localObject5	Object
    //   490	1	9	localException2	java.lang.Exception
    //   81	101	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   125	130	132	java/io/IOException
    //   104	120	192	java/lang/Exception
    //   153	162	192	java/lang/Exception
    //   179	189	192	java/lang/Exception
    //   248	255	192	java/lang/Exception
    //   268	278	192	java/lang/Exception
    //   282	328	192	java/lang/Exception
    //   336	350	192	java/lang/Exception
    //   391	398	192	java/lang/Exception
    //   362	367	370	java/io/IOException
    //   409	414	417	java/io/IOException
    //   237	242	434	java/io/IOException
    //   83	95	451	finally
    //   460	465	467	java/io/IOException
    //   104	120	486	finally
    //   153	162	486	finally
    //   179	189	486	finally
    //   198	212	486	finally
    //   216	232	486	finally
    //   248	255	486	finally
    //   268	278	486	finally
    //   282	328	486	finally
    //   336	350	486	finally
    //   391	398	486	finally
    //   83	95	490	java/lang/Exception
  }
  
  private static String b(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    paramString1 = bk.aM(paramString1, "null") + bk.aM(paramString2, "null") + paramBoolean + paramInt1 + "_" + paramInt2;
    return "fts_search_" + g.o(paramString1.getBytes());
  }
  
  private byte[] getBuffer()
  {
    try
    {
      byte[] arrayOfByte2 = (byte[])this.ktF.get(Long.valueOf(Thread.currentThread().getId()));
      byte[] arrayOfByte1 = arrayOfByte2;
      if (arrayOfByte2 == null)
      {
        arrayOfByte1 = new byte[1024];
        this.ktF.put(Long.valueOf(Thread.currentThread().getId()), arrayOfByte1);
      }
      return arrayOfByte1;
    }
    finally {}
  }
  
  private Bitmap mr(String paramString)
  {
    c.a locala = (c.a)this.ktz.get(paramString);
    if ((locala != null) && (locala.bitmap != null) && (!locala.bitmap.isRecycled()))
    {
      this.ktA.remove(paramString);
      this.ktA.add(0, paramString);
    }
    if (locala == null) {
      return null;
    }
    return locala.bitmap;
  }
  
  public final Bitmap a(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    return mr(b(paramString1, paramString2, paramBoolean, paramInt1, paramInt2));
  }
  
  public final String a(ImageView paramImageView, String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    paramString1 = b(paramString1, paramString2, paramBoolean, paramInt1, paramInt2);
    paramImageView.setTag(paramString1);
    y.d("MicroMsg.FTS.FTSImageLoader", "update image view cache key: hashcode=%d | cacheKey=%s", new Object[] { Integer.valueOf(paramImageView.hashCode()), paramString1 });
    return paramString1;
  }
  
  public final void a(Context paramContext, ImageView paramImageView, String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    String str = a(paramImageView, paramString1, paramString2, paramBoolean, paramInt1, paramInt2);
    if (!this.ktB) {
      return;
    }
    paramContext = new c.b(this, str, paramString1, paramString2, paramBoolean, paramInt1, paramInt2, new c.3(this, paramImageView, paramContext));
    if (this.ktH.add(str))
    {
      this.ktC += 1;
      this.ktC %= 2;
      this.ktD[this.ktC].post(paramContext);
      return;
    }
    y.v("MicroMsg.FTS.FTSImageLoader", "cacheKey: %s | runningJobTask: %s", new Object[] { str, this.ktH.toString() });
  }
  
  public final void aVj()
  {
    y.d("MicroMsg.FTS.FTSImageLoader", "stopLoadImageTask");
    int i = 0;
    while (i < 2)
    {
      if (this.ktD[i] != null) {
        this.ktD[i].removeCallbacksAndMessages(null);
      }
      i += 1;
    }
  }
  
  public final void aVk()
  {
    y.d("MicroMsg.FTS.FTSImageLoader", "stopLoadImage");
    this.ktB = false;
    aVj();
  }
  
  public final boolean aVl()
  {
    return this.ktB;
  }
  
  public final void aVm()
  {
    y.d("MicroMsg.FTS.FTSImageLoader", "startLoadImage");
    this.ktB = true;
  }
  
  public final void aVn()
  {
    y.d("MicroMsg.FTS.FTSImageLoader", "clearCacheAndTask %s", new Object[] { Integer.valueOf(this.ktz.size()) });
    aVj();
    Iterator localIterator = this.ktz.entrySet().iterator();
    while (localIterator.hasNext()) {
      DG((String)((Map.Entry)localIterator.next()).getKey());
    }
    this.ktA.clear();
    this.ktH.clear();
  }
  
  public final void aVo()
  {
    aVn();
    y.d("MicroMsg.FTS.FTSImageLoader", "destoryLoader");
    int i = 0;
    while (i < 2)
    {
      if (this.ktD[i] != null) {
        this.ktD[i].getLooper().quit();
      }
      i += 1;
    }
    Iterator localIterator = this.ktE.values().iterator();
    while (localIterator.hasNext())
    {
      ByteArrayOutputStream localByteArrayOutputStream = (ByteArrayOutputStream)localIterator.next();
      try
      {
        localByteArrayOutputStream.close();
      }
      catch (IOException localIOException) {}
    }
    this.ktE.clear();
    this.ktF.clear();
    this.ktG.getLooper().quit();
  }
  
  static abstract interface c
  {
    public abstract void aC(String paramString, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.c
 * JD-Core Version:    0.7.0.1
 */