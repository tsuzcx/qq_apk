package com.tencent.mm.plugin.fts;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
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
  private static int MAX_CACHE_SIZE = 32;
  private ap gIf;
  private Vector<String> trA;
  private boolean trB;
  private int trC;
  private ap[] trD;
  private ConcurrentHashMap<Long, ByteArrayOutputStream> trE;
  private ConcurrentHashMap<Long, byte[]> trF;
  private ap trG;
  private Set<String> trH;
  private ConcurrentHashMap<String, c.a> trz;
  
  public c()
  {
    AppMethodBeat.i(52509);
    this.trB = true;
    this.trC = 0;
    this.gIf = new ap(Looper.getMainLooper());
    this.trD = new ap[2];
    this.trE = null;
    this.trF = null;
    this.trG = null;
    ad.i("MicroMsg.FTS.FTSImageLoader", "create SearchImageLoader");
    if (d.ly(19)) {}
    for (MAX_CACHE_SIZE = 64;; MAX_CACHE_SIZE = 32)
    {
      this.trz = new ConcurrentHashMap();
      this.trA = new Vector();
      this.trE = new ConcurrentHashMap();
      this.trF = new ConcurrentHashMap();
      this.trH = Collections.synchronizedSet(new HashSet());
      while (i < 2)
      {
        if (this.trD[i] == null) {
          this.trD[i] = new ap("SearchImageLoader_loadImage_handler");
        }
        i += 1;
      }
    }
    this.trG = new ap("SearchImageLoader_saveImage_handler");
    AppMethodBeat.o(52509);
  }
  
  private Bitmap FD(String paramString)
  {
    AppMethodBeat.i(52518);
    c.a locala = (c.a)this.trz.get(paramString);
    if ((locala != null) && (locala.bitmap != null) && (!locala.bitmap.isRecycled()))
    {
      this.trA.remove(paramString);
      this.trA.add(0, paramString);
    }
    if (locala == null)
    {
      AppMethodBeat.o(52518);
      return null;
    }
    paramString = locala.bitmap;
    AppMethodBeat.o(52518);
    return paramString;
  }
  
  private void akd(String paramString)
  {
    AppMethodBeat.i(52522);
    c.a locala = (c.a)this.trz.get(paramString);
    this.trA.remove(paramString);
    this.trz.remove(paramString);
    if ((locala != null) && (locala.bitmap != null))
    {
      if (!locala.bitmap.isRecycled())
      {
        ad.i("MicroMsg.FTS.FTSImageLoader", "bitmap recycle %s", new Object[] { locala.bitmap });
        locala.bitmap.recycle();
      }
      locala.bitmap = null;
    }
    AppMethodBeat.o(52522);
  }
  
  /* Error */
  private Bitmap b(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc_w 261
    //   3: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 215	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifeq +11 -> 21
    //   13: ldc_w 261
    //   16: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aconst_null
    //   20: areturn
    //   21: aload_0
    //   22: getfield 79	com/tencent/mm/plugin/fts/c:trE	Ljava/util/concurrent/ConcurrentHashMap;
    //   25: invokestatic 267	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   28: invokevirtual 271	java/lang/Thread:getId	()J
    //   31: invokestatic 277	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   34: invokevirtual 136	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   37: checkcast 279	java/io/ByteArrayOutputStream
    //   40: astore 7
    //   42: aload 7
    //   44: astore 9
    //   46: aload 7
    //   48: ifnonnull +34 -> 82
    //   51: new 279	java/io/ByteArrayOutputStream
    //   54: dup
    //   55: ldc_w 280
    //   58: invokespecial 282	java/io/ByteArrayOutputStream:<init>	(I)V
    //   61: astore 9
    //   63: aload_0
    //   64: getfield 79	com/tencent/mm/plugin/fts/c:trE	Ljava/util/concurrent/ConcurrentHashMap;
    //   67: invokestatic 267	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   70: invokevirtual 271	java/lang/Thread:getId	()J
    //   73: invokestatic 277	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   76: aload 9
    //   78: invokevirtual 191	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   81: pop
    //   82: aload 9
    //   84: invokevirtual 285	java/io/ByteArrayOutputStream:reset	()V
    //   87: aload_0
    //   88: invokespecial 289	com/tencent/mm/plugin/fts/c:getBuffer	()[B
    //   91: astore 10
    //   93: aload_1
    //   94: sipush 10000
    //   97: sipush 20000
    //   100: invokestatic 295	com/tencent/mm/network/b:w	(Ljava/lang/String;II)Ljava/io/InputStream;
    //   103: astore 8
    //   105: aload 8
    //   107: ifnonnull +421 -> 528
    //   110: aload 8
    //   112: astore 7
    //   114: ldc 85
    //   116: ldc_w 297
    //   119: iconst_1
    //   120: anewarray 4	java/lang/Object
    //   123: dup
    //   124: iconst_0
    //   125: aload_1
    //   126: aastore
    //   127: invokestatic 299	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   130: aload 8
    //   132: ifnull +8 -> 140
    //   135: aload 8
    //   137: invokevirtual 304	java/io/InputStream:close	()V
    //   140: ldc_w 261
    //   143: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: aconst_null
    //   147: areturn
    //   148: astore_1
    //   149: ldc 85
    //   151: aload_1
    //   152: ldc_w 306
    //   155: iconst_0
    //   156: anewarray 4	java/lang/Object
    //   159: invokestatic 310	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   162: goto -22 -> 140
    //   165: aload 8
    //   167: astore 7
    //   169: aload 8
    //   171: aload 10
    //   173: invokevirtual 314	java/io/InputStream:read	([B)I
    //   176: istore 6
    //   178: iload 6
    //   180: iconst_m1
    //   181: if_icmpeq +85 -> 266
    //   184: iload 5
    //   186: iload 6
    //   188: iadd
    //   189: istore 5
    //   191: aload 8
    //   193: astore 7
    //   195: aload 9
    //   197: aload 10
    //   199: iconst_0
    //   200: iload 6
    //   202: invokevirtual 318	java/io/ByteArrayOutputStream:write	([BII)V
    //   205: goto -40 -> 165
    //   208: astore 9
    //   210: aload 8
    //   212: astore 7
    //   214: ldc 85
    //   216: aload 9
    //   218: ldc_w 306
    //   221: iconst_0
    //   222: anewarray 4	java/lang/Object
    //   225: invokestatic 310	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   228: aload 8
    //   230: astore 7
    //   232: ldc 85
    //   234: ldc_w 320
    //   237: iconst_1
    //   238: anewarray 4	java/lang/Object
    //   241: dup
    //   242: iconst_0
    //   243: aload_1
    //   244: aastore
    //   245: invokestatic 299	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   248: aload 8
    //   250: ifnull +8 -> 258
    //   253: aload 8
    //   255: invokevirtual 304	java/io/InputStream:close	()V
    //   258: ldc_w 261
    //   261: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   264: aconst_null
    //   265: areturn
    //   266: aload 8
    //   268: astore 7
    //   270: aload 9
    //   272: invokevirtual 323	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   275: astore 9
    //   277: iload_3
    //   278: ifle +113 -> 391
    //   281: iload 4
    //   283: ifle +108 -> 391
    //   286: aload 8
    //   288: astore 7
    //   290: aload 9
    //   292: iload_3
    //   293: iload 4
    //   295: invokestatic 329	com/tencent/mm/sdk/platformtools/g:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   298: astore 9
    //   300: aload 8
    //   302: astore 7
    //   304: ldc 85
    //   306: ldc_w 331
    //   309: iconst_4
    //   310: anewarray 4	java/lang/Object
    //   313: dup
    //   314: iconst_0
    //   315: aload_1
    //   316: aastore
    //   317: dup
    //   318: iconst_1
    //   319: iload 5
    //   321: invokestatic 336	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   324: aastore
    //   325: dup
    //   326: iconst_2
    //   327: aload 9
    //   329: invokevirtual 339	android/graphics/Bitmap:getWidth	()I
    //   332: invokestatic 336	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   335: aastore
    //   336: dup
    //   337: iconst_3
    //   338: aload 9
    //   340: invokevirtual 342	android/graphics/Bitmap:getHeight	()I
    //   343: invokestatic 336	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   346: aastore
    //   347: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   350: iload_2
    //   351: ifeq +71 -> 422
    //   354: aload 8
    //   356: astore 7
    //   358: aload 9
    //   360: iconst_1
    //   361: aload 9
    //   363: invokevirtual 339	android/graphics/Bitmap:getWidth	()I
    //   366: i2f
    //   367: invokestatic 348	com/tencent/mm/sdk/platformtools/g:a	(Landroid/graphics/Bitmap;ZF)Landroid/graphics/Bitmap;
    //   370: astore 9
    //   372: aload 8
    //   374: ifnull +8 -> 382
    //   377: aload 8
    //   379: invokevirtual 304	java/io/InputStream:close	()V
    //   382: ldc_w 261
    //   385: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   388: aload 9
    //   390: areturn
    //   391: aload 8
    //   393: astore 7
    //   395: aload 9
    //   397: invokestatic 352	com/tencent/mm/sdk/platformtools/g:cr	([B)Landroid/graphics/Bitmap;
    //   400: astore 9
    //   402: goto -102 -> 300
    //   405: astore_1
    //   406: ldc 85
    //   408: aload_1
    //   409: ldc_w 306
    //   412: iconst_0
    //   413: anewarray 4	java/lang/Object
    //   416: invokestatic 310	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   419: goto -37 -> 382
    //   422: aload 8
    //   424: ifnull +8 -> 432
    //   427: aload 8
    //   429: invokevirtual 304	java/io/InputStream:close	()V
    //   432: ldc_w 261
    //   435: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   438: aload 9
    //   440: areturn
    //   441: astore_1
    //   442: ldc 85
    //   444: aload_1
    //   445: ldc_w 306
    //   448: iconst_0
    //   449: anewarray 4	java/lang/Object
    //   452: invokestatic 310	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   455: goto -23 -> 432
    //   458: astore_1
    //   459: ldc 85
    //   461: aload_1
    //   462: ldc_w 306
    //   465: iconst_0
    //   466: anewarray 4	java/lang/Object
    //   469: invokestatic 310	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   472: goto -214 -> 258
    //   475: astore_1
    //   476: aconst_null
    //   477: astore 7
    //   479: aload 7
    //   481: ifnull +8 -> 489
    //   484: aload 7
    //   486: invokevirtual 304	java/io/InputStream:close	()V
    //   489: ldc_w 261
    //   492: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   495: aload_1
    //   496: athrow
    //   497: astore 7
    //   499: ldc 85
    //   501: aload 7
    //   503: ldc_w 306
    //   506: iconst_0
    //   507: anewarray 4	java/lang/Object
    //   510: invokestatic 310	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   513: goto -24 -> 489
    //   516: astore_1
    //   517: goto -38 -> 479
    //   520: astore 9
    //   522: aconst_null
    //   523: astore 8
    //   525: goto -315 -> 210
    //   528: iconst_0
    //   529: istore 5
    //   531: goto -366 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	534	0	this	c
    //   0	534	1	paramString	String
    //   0	534	2	paramBoolean	boolean
    //   0	534	3	paramInt1	int
    //   0	534	4	paramInt2	int
    //   184	346	5	i	int
    //   176	25	6	j	int
    //   40	445	7	localObject1	Object
    //   497	5	7	localIOException	IOException
    //   103	421	8	localInputStream	java.io.InputStream
    //   44	152	9	localObject2	Object
    //   208	63	9	localException1	java.lang.Exception
    //   275	164	9	localObject3	Object
    //   520	1	9	localException2	java.lang.Exception
    //   91	107	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   135	140	148	java/io/IOException
    //   114	130	208	java/lang/Exception
    //   169	178	208	java/lang/Exception
    //   195	205	208	java/lang/Exception
    //   270	277	208	java/lang/Exception
    //   290	300	208	java/lang/Exception
    //   304	350	208	java/lang/Exception
    //   358	372	208	java/lang/Exception
    //   395	402	208	java/lang/Exception
    //   377	382	405	java/io/IOException
    //   427	432	441	java/io/IOException
    //   253	258	458	java/io/IOException
    //   93	105	475	finally
    //   484	489	497	java/io/IOException
    //   114	130	516	finally
    //   169	178	516	finally
    //   195	205	516	finally
    //   214	228	516	finally
    //   232	248	516	finally
    //   270	277	516	finally
    //   290	300	516	finally
    //   304	350	516	finally
    //   358	372	516	finally
    //   395	402	516	finally
    //   93	105	520	java/lang/Exception
  }
  
  private static String c(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(52520);
    paramString1 = bt.bI(paramString1, "null") + bt.bI(paramString2, "null") + paramBoolean + paramInt1 + "_" + paramInt2;
    paramString1 = "fts_search_" + g.getMessageDigest(paramString1.getBytes());
    AppMethodBeat.o(52520);
    return paramString1;
  }
  
  private byte[] getBuffer()
  {
    try
    {
      AppMethodBeat.i(52519);
      byte[] arrayOfByte2 = (byte[])this.trF.get(Long.valueOf(Thread.currentThread().getId()));
      byte[] arrayOfByte1 = arrayOfByte2;
      if (arrayOfByte2 == null)
      {
        arrayOfByte1 = new byte[1024];
        this.trF.put(Long.valueOf(Thread.currentThread().getId()), arrayOfByte1);
      }
      AppMethodBeat.o(52519);
      return arrayOfByte1;
    }
    finally {}
  }
  
  public final String a(ImageView paramImageView, String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(52511);
    paramString1 = c(paramString1, paramString2, paramBoolean, paramInt1, paramInt2);
    paramImageView.setTag(paramString1);
    ad.d("MicroMsg.FTS.FTSImageLoader", "update image view cache key: hashcode=%d | cacheKey=%s", new Object[] { Integer.valueOf(paramImageView.hashCode()), paramString1 });
    AppMethodBeat.o(52511);
    return paramString1;
  }
  
  public final void a(final Context paramContext, final ImageView paramImageView, String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(52510);
    String str = a(paramImageView, paramString1, paramString2, paramBoolean, paramInt1, paramInt2);
    if (!this.trB)
    {
      AppMethodBeat.o(52510);
      return;
    }
    paramContext = new b(str, paramString1, paramString2, paramBoolean, paramInt1, paramInt2, new c()
    {
      public final void bj(final String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(183537);
        ad.v("MicroMsg.FTS.FTSImageLoader", "LoadBitmapJob finish: %s %b", new Object[] { paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
        c.a(c.this).remove(paramAnonymousString);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(183537);
          return;
        }
        final Bitmap localBitmap = c.a(c.this, paramAnonymousString);
        if (paramAnonymousString.equals(paramImageView.getTag())) {
          c.b(c.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(183536);
              if (paramAnonymousString.equals(c.1.this.trI.getTag())) {
                com.tencent.mm.plugin.fts.a.d.c.a.a(c.1.this.val$context.getResources(), localBitmap, c.1.this.trI);
              }
              AppMethodBeat.o(183536);
            }
          });
        }
        AppMethodBeat.o(183537);
      }
    });
    if (this.trH.add(str))
    {
      this.trC += 1;
      this.trC %= 2;
      this.trD[this.trC].post(paramContext);
      AppMethodBeat.o(52510);
      return;
    }
    ad.v("MicroMsg.FTS.FTSImageLoader", "cacheKey: %s | runningJobTask: %s", new Object[] { str, this.trH.toString() });
    AppMethodBeat.o(52510);
  }
  
  public final Bitmap b(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(52517);
    paramString1 = FD(c(paramString1, paramString2, paramBoolean, paramInt1, paramInt2));
    AppMethodBeat.o(52517);
    return paramString1;
  }
  
  public final void cSA()
  {
    AppMethodBeat.i(52515);
    ad.d("MicroMsg.FTS.FTSImageLoader", "clearCacheAndTask %s", new Object[] { Integer.valueOf(this.trz.size()) });
    cSw();
    Iterator localIterator = this.trz.entrySet().iterator();
    while (localIterator.hasNext()) {
      akd((String)((Map.Entry)localIterator.next()).getKey());
    }
    this.trA.clear();
    this.trH.clear();
    AppMethodBeat.o(52515);
  }
  
  public final void cSB()
  {
    AppMethodBeat.i(52516);
    cSA();
    ad.d("MicroMsg.FTS.FTSImageLoader", "destoryLoader");
    int i = 0;
    while (i < 2)
    {
      if (this.trD[i] != null) {
        this.trD[i].quit();
      }
      i += 1;
    }
    Iterator localIterator = this.trE.values().iterator();
    while (localIterator.hasNext())
    {
      ByteArrayOutputStream localByteArrayOutputStream = (ByteArrayOutputStream)localIterator.next();
      try
      {
        localByteArrayOutputStream.close();
      }
      catch (IOException localIOException) {}
    }
    this.trE.clear();
    this.trF.clear();
    this.trG.quit();
    AppMethodBeat.o(52516);
  }
  
  public final void cSw()
  {
    AppMethodBeat.i(52512);
    ad.d("MicroMsg.FTS.FTSImageLoader", "stopLoadImageTask");
    int i = 0;
    while (i < 2)
    {
      if (this.trD[i] != null) {
        this.trD[i].removeCallbacksAndMessages(null);
      }
      i += 1;
    }
    AppMethodBeat.o(52512);
  }
  
  public final void cSx()
  {
    AppMethodBeat.i(52513);
    ad.d("MicroMsg.FTS.FTSImageLoader", "stopLoadImage");
    this.trB = false;
    cSw();
    AppMethodBeat.o(52513);
  }
  
  public final boolean cSy()
  {
    return this.trB;
  }
  
  public final void cSz()
  {
    AppMethodBeat.i(52514);
    ad.d("MicroMsg.FTS.FTSImageLoader", "startLoadImage");
    this.trB = true;
    AppMethodBeat.o(52514);
  }
  
  final class b
    implements Runnable
  {
    private String cacheKey;
    private String dBx;
    private boolean hdW;
    private int height;
    private c.c trL;
    private String url;
    private int width;
    
    public b(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, c.c paramc)
    {
      this.cacheKey = paramString1;
      this.url = paramString2;
      this.dBx = paramString3;
      this.trL = paramc;
      this.hdW = paramBoolean;
      this.width = paramInt1;
      this.height = paramInt2;
    }
    
    public final void run()
    {
      AppMethodBeat.i(52507);
      ad.d("MicroMsg.FTS.FTSImageLoader", "Start to run load bitmap job %s", new Object[] { this.cacheKey });
      if (bt.isNullOrNil(this.dBx)) {
        this.dBx = c.ake(this.cacheKey);
      }
      long l2 = System.currentTimeMillis();
      Bitmap localBitmap = c.ag(this.dBx, this.width, this.height);
      long l1 = System.currentTimeMillis();
      if (localBitmap != null)
      {
        ad.d("MicroMsg.FTS.FTSImageLoader", "Found image in local %s | localPath %s | use time %d", new Object[] { this.url, this.dBx, Long.valueOf(l1 - l2) });
        c.a(c.this, this.cacheKey, this.dBx, localBitmap);
        this.trL.bj(this.cacheKey, true);
        AppMethodBeat.o(52507);
        return;
      }
      localBitmap = c.a(c.this, this.url, this.hdW, this.width, this.height);
      l2 = System.currentTimeMillis();
      ad.d("MicroMsg.FTS.FTSImageLoader", "Get image from net %s | localPath %s | use time %d", new Object[] { this.url, this.dBx, Long.valueOf(l2 - l1) });
      if (localBitmap != null)
      {
        c.a(c.this, this.cacheKey, this.dBx, localBitmap);
        this.trL.bj(this.cacheKey, true);
        AppMethodBeat.o(52507);
        return;
      }
      this.trL.bj(this.cacheKey, false);
      AppMethodBeat.o(52507);
    }
  }
  
  static abstract interface c
  {
    public abstract void bj(String paramString, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.c
 * JD-Core Version:    0.7.0.1
 */