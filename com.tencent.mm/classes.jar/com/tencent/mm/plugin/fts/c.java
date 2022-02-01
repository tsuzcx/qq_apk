package com.tencent.mm.plugin.fts;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
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
  private ConcurrentHashMap<String, c.a> BFo;
  private Vector<String> BFp;
  private boolean BFq;
  private int BFr;
  private MMHandler[] BFs;
  private ConcurrentHashMap<Long, ByteArrayOutputStream> BFt;
  private ConcurrentHashMap<Long, byte[]> BFu;
  private MMHandler BFv;
  private Set<String> BFw;
  private MMHandler knk;
  
  public c()
  {
    AppMethodBeat.i(52509);
    this.BFq = true;
    this.BFr = 0;
    this.knk = new MMHandler(Looper.getMainLooper());
    this.BFs = new MMHandler[2];
    this.BFt = null;
    this.BFu = null;
    this.BFv = null;
    Log.i("MicroMsg.FTS.FTSImageLoader", "create SearchImageLoader");
    if (d.qV(19)) {}
    for (MAX_CACHE_SIZE = 64;; MAX_CACHE_SIZE = 32)
    {
      this.BFo = new ConcurrentHashMap();
      this.BFp = new Vector();
      this.BFt = new ConcurrentHashMap();
      this.BFu = new ConcurrentHashMap();
      this.BFw = Collections.synchronizedSet(new HashSet());
      while (i < 2)
      {
        if (this.BFs[i] == null) {
          this.BFs[i] = new MMHandler("SearchImageLoader_loadImage_handler");
        }
        i += 1;
      }
    }
    this.BFv = new MMHandler("SearchImageLoader_saveImage_handler");
    AppMethodBeat.o(52509);
  }
  
  private Bitmap Wo(String paramString)
  {
    AppMethodBeat.i(52518);
    c.a locala = (c.a)this.BFo.get(paramString);
    if ((locala != null) && (locala.bitmap != null) && (!locala.bitmap.isRecycled()))
    {
      this.BFp.remove(paramString);
      this.BFp.add(0, paramString);
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
  
  private void aHy(String paramString)
  {
    AppMethodBeat.i(52522);
    c.a locala = (c.a)this.BFo.get(paramString);
    this.BFp.remove(paramString);
    this.BFo.remove(paramString);
    if ((locala != null) && (locala.bitmap != null))
    {
      if (!locala.bitmap.isRecycled())
      {
        Log.i("MicroMsg.FTS.FTSImageLoader", "bitmap recycle %s", new Object[] { locala.bitmap });
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
    //   0: ldc 254
    //   2: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 241	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifeq +10 -> 19
    //   12: ldc 254
    //   14: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: aconst_null
    //   18: areturn
    //   19: aload_0
    //   20: getfield 79	com/tencent/mm/plugin/fts/c:BFt	Ljava/util/concurrent/ConcurrentHashMap;
    //   23: invokestatic 260	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   26: invokevirtual 264	java/lang/Thread:getId	()J
    //   29: invokestatic 270	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   32: invokevirtual 136	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   35: checkcast 272	java/io/ByteArrayOutputStream
    //   38: astore 7
    //   40: aload 7
    //   42: astore 9
    //   44: aload 7
    //   46: ifnonnull +34 -> 80
    //   49: new 272	java/io/ByteArrayOutputStream
    //   52: dup
    //   53: ldc_w 273
    //   56: invokespecial 275	java/io/ByteArrayOutputStream:<init>	(I)V
    //   59: astore 9
    //   61: aload_0
    //   62: getfield 79	com/tencent/mm/plugin/fts/c:BFt	Ljava/util/concurrent/ConcurrentHashMap;
    //   65: invokestatic 260	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   68: invokevirtual 264	java/lang/Thread:getId	()J
    //   71: invokestatic 270	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   74: aload 9
    //   76: invokevirtual 191	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   79: pop
    //   80: aload 9
    //   82: invokevirtual 278	java/io/ByteArrayOutputStream:reset	()V
    //   85: aload_0
    //   86: invokespecial 282	com/tencent/mm/plugin/fts/c:getBuffer	()[B
    //   89: astore 10
    //   91: aload_1
    //   92: sipush 10000
    //   95: sipush 20000
    //   98: invokestatic 288	com/tencent/mm/network/d:x	(Ljava/lang/String;II)Ljava/io/InputStream;
    //   101: astore 8
    //   103: aload 8
    //   105: ifnonnull +416 -> 521
    //   108: aload 8
    //   110: astore 7
    //   112: ldc 85
    //   114: ldc_w 290
    //   117: iconst_1
    //   118: anewarray 4	java/lang/Object
    //   121: dup
    //   122: iconst_0
    //   123: aload_1
    //   124: aastore
    //   125: invokestatic 293	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   128: aload 8
    //   130: ifnull +8 -> 138
    //   133: aload 8
    //   135: invokevirtual 298	java/io/InputStream:close	()V
    //   138: ldc 254
    //   140: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   143: aconst_null
    //   144: areturn
    //   145: astore_1
    //   146: ldc 85
    //   148: aload_1
    //   149: ldc_w 300
    //   152: iconst_0
    //   153: anewarray 4	java/lang/Object
    //   156: invokestatic 304	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   159: goto -21 -> 138
    //   162: aload 8
    //   164: astore 7
    //   166: aload 8
    //   168: aload 10
    //   170: invokevirtual 308	java/io/InputStream:read	([B)I
    //   173: istore 6
    //   175: iload 6
    //   177: iconst_m1
    //   178: if_icmpeq +84 -> 262
    //   181: iload 5
    //   183: iload 6
    //   185: iadd
    //   186: istore 5
    //   188: aload 8
    //   190: astore 7
    //   192: aload 9
    //   194: aload 10
    //   196: iconst_0
    //   197: iload 6
    //   199: invokevirtual 312	java/io/ByteArrayOutputStream:write	([BII)V
    //   202: goto -40 -> 162
    //   205: astore 9
    //   207: aload 8
    //   209: astore 7
    //   211: ldc 85
    //   213: aload 9
    //   215: ldc_w 300
    //   218: iconst_0
    //   219: anewarray 4	java/lang/Object
    //   222: invokestatic 304	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   225: aload 8
    //   227: astore 7
    //   229: ldc 85
    //   231: ldc_w 314
    //   234: iconst_1
    //   235: anewarray 4	java/lang/Object
    //   238: dup
    //   239: iconst_0
    //   240: aload_1
    //   241: aastore
    //   242: invokestatic 293	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   245: aload 8
    //   247: ifnull +8 -> 255
    //   250: aload 8
    //   252: invokevirtual 298	java/io/InputStream:close	()V
    //   255: ldc 254
    //   257: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   260: aconst_null
    //   261: areturn
    //   262: aload 8
    //   264: astore 7
    //   266: aload 9
    //   268: invokevirtual 317	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   271: astore 9
    //   273: iload_3
    //   274: ifle +112 -> 386
    //   277: iload 4
    //   279: ifle +107 -> 386
    //   282: aload 8
    //   284: astore 7
    //   286: aload 9
    //   288: iload_3
    //   289: iload 4
    //   291: invokestatic 323	com/tencent/mm/sdk/platformtools/BitmapUtil:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   294: astore 9
    //   296: aload 8
    //   298: astore 7
    //   300: ldc 85
    //   302: ldc_w 325
    //   305: iconst_4
    //   306: anewarray 4	java/lang/Object
    //   309: dup
    //   310: iconst_0
    //   311: aload_1
    //   312: aastore
    //   313: dup
    //   314: iconst_1
    //   315: iload 5
    //   317: invokestatic 330	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   320: aastore
    //   321: dup
    //   322: iconst_2
    //   323: aload 9
    //   325: invokevirtual 333	android/graphics/Bitmap:getWidth	()I
    //   328: invokestatic 330	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   331: aastore
    //   332: dup
    //   333: iconst_3
    //   334: aload 9
    //   336: invokevirtual 336	android/graphics/Bitmap:getHeight	()I
    //   339: invokestatic 330	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   342: aastore
    //   343: invokestatic 339	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   346: iload_2
    //   347: ifeq +70 -> 417
    //   350: aload 8
    //   352: astore 7
    //   354: aload 9
    //   356: iconst_1
    //   357: aload 9
    //   359: invokevirtual 333	android/graphics/Bitmap:getWidth	()I
    //   362: i2f
    //   363: invokestatic 343	com/tencent/mm/sdk/platformtools/BitmapUtil:getRoundedCornerBitmap	(Landroid/graphics/Bitmap;ZF)Landroid/graphics/Bitmap;
    //   366: astore 9
    //   368: aload 8
    //   370: ifnull +8 -> 378
    //   373: aload 8
    //   375: invokevirtual 298	java/io/InputStream:close	()V
    //   378: ldc 254
    //   380: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   383: aload 9
    //   385: areturn
    //   386: aload 8
    //   388: astore 7
    //   390: aload 9
    //   392: invokestatic 346	com/tencent/mm/sdk/platformtools/BitmapUtil:decodeByteArray	([B)Landroid/graphics/Bitmap;
    //   395: astore 9
    //   397: goto -101 -> 296
    //   400: astore_1
    //   401: ldc 85
    //   403: aload_1
    //   404: ldc_w 300
    //   407: iconst_0
    //   408: anewarray 4	java/lang/Object
    //   411: invokestatic 304	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   414: goto -36 -> 378
    //   417: aload 8
    //   419: ifnull +8 -> 427
    //   422: aload 8
    //   424: invokevirtual 298	java/io/InputStream:close	()V
    //   427: ldc 254
    //   429: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   432: aload 9
    //   434: areturn
    //   435: astore_1
    //   436: ldc 85
    //   438: aload_1
    //   439: ldc_w 300
    //   442: iconst_0
    //   443: anewarray 4	java/lang/Object
    //   446: invokestatic 304	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   449: goto -22 -> 427
    //   452: astore_1
    //   453: ldc 85
    //   455: aload_1
    //   456: ldc_w 300
    //   459: iconst_0
    //   460: anewarray 4	java/lang/Object
    //   463: invokestatic 304	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   466: goto -211 -> 255
    //   469: astore_1
    //   470: aconst_null
    //   471: astore 7
    //   473: aload 7
    //   475: ifnull +8 -> 483
    //   478: aload 7
    //   480: invokevirtual 298	java/io/InputStream:close	()V
    //   483: ldc 254
    //   485: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   488: aload_1
    //   489: athrow
    //   490: astore 7
    //   492: ldc 85
    //   494: aload 7
    //   496: ldc_w 300
    //   499: iconst_0
    //   500: anewarray 4	java/lang/Object
    //   503: invokestatic 304	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   506: goto -23 -> 483
    //   509: astore_1
    //   510: goto -37 -> 473
    //   513: astore 9
    //   515: aconst_null
    //   516: astore 8
    //   518: goto -311 -> 207
    //   521: iconst_0
    //   522: istore 5
    //   524: goto -362 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	527	0	this	c
    //   0	527	1	paramString	String
    //   0	527	2	paramBoolean	boolean
    //   0	527	3	paramInt1	int
    //   0	527	4	paramInt2	int
    //   181	342	5	i	int
    //   173	25	6	j	int
    //   38	441	7	localObject1	Object
    //   490	5	7	localIOException	IOException
    //   101	416	8	localInputStream	java.io.InputStream
    //   42	151	9	localObject2	Object
    //   205	62	9	localException1	java.lang.Exception
    //   271	162	9	localObject3	Object
    //   513	1	9	localException2	java.lang.Exception
    //   89	106	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   133	138	145	java/io/IOException
    //   112	128	205	java/lang/Exception
    //   166	175	205	java/lang/Exception
    //   192	202	205	java/lang/Exception
    //   266	273	205	java/lang/Exception
    //   286	296	205	java/lang/Exception
    //   300	346	205	java/lang/Exception
    //   354	368	205	java/lang/Exception
    //   390	397	205	java/lang/Exception
    //   373	378	400	java/io/IOException
    //   422	427	435	java/io/IOException
    //   250	255	452	java/io/IOException
    //   91	103	469	finally
    //   478	483	490	java/io/IOException
    //   112	128	509	finally
    //   166	175	509	finally
    //   192	202	509	finally
    //   211	225	509	finally
    //   229	245	509	finally
    //   266	273	509	finally
    //   286	296	509	finally
    //   300	346	509	finally
    //   354	368	509	finally
    //   390	397	509	finally
    //   91	103	513	java/lang/Exception
  }
  
  private static String d(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(52520);
    paramString1 = Util.nullAs(paramString1, "null") + Util.nullAs(paramString2, "null") + paramBoolean + paramInt1 + "_" + paramInt2;
    paramString1 = "fts_search_" + g.getMessageDigest(paramString1.getBytes());
    AppMethodBeat.o(52520);
    return paramString1;
  }
  
  private byte[] getBuffer()
  {
    try
    {
      AppMethodBeat.i(52519);
      byte[] arrayOfByte2 = (byte[])this.BFu.get(Long.valueOf(Thread.currentThread().getId()));
      byte[] arrayOfByte1 = arrayOfByte2;
      if (arrayOfByte2 == null)
      {
        arrayOfByte1 = new byte[1024];
        this.BFu.put(Long.valueOf(Thread.currentThread().getId()), arrayOfByte1);
      }
      AppMethodBeat.o(52519);
      return arrayOfByte1;
    }
    finally {}
  }
  
  public final String a(ImageView paramImageView, String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(52511);
    paramString1 = d(paramString1, paramString2, paramBoolean, paramInt1, paramInt2);
    paramImageView.setTag(paramString1);
    Log.d("MicroMsg.FTS.FTSImageLoader", "update image view cache key: hashcode=%d | cacheKey=%s", new Object[] { Integer.valueOf(paramImageView.hashCode()), paramString1 });
    AppMethodBeat.o(52511);
    return paramString1;
  }
  
  public final void a(final Context paramContext, final ImageView paramImageView, String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(52510);
    String str = a(paramImageView, paramString1, paramString2, paramBoolean, paramInt1, paramInt2);
    if (!this.BFq)
    {
      AppMethodBeat.o(52510);
      return;
    }
    paramContext = new b(str, paramString1, paramString2, paramBoolean, paramInt1, paramInt2, new c()
    {
      public final void bF(final String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(183537);
        Log.v("MicroMsg.FTS.FTSImageLoader", "LoadBitmapJob finish: %s %b", new Object[] { paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
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
              if (paramAnonymousString.equals(c.1.this.kOW.getTag())) {
                com.tencent.mm.plugin.fts.a.d.c.a.a(c.1.this.val$context.getResources(), localBitmap, c.1.this.kOW);
              }
              AppMethodBeat.o(183536);
            }
          });
        }
        AppMethodBeat.o(183537);
      }
    });
    if (this.BFw.add(str))
    {
      this.BFr += 1;
      this.BFr %= 2;
      this.BFs[this.BFr].post(paramContext);
      AppMethodBeat.o(52510);
      return;
    }
    Log.v("MicroMsg.FTS.FTSImageLoader", "cacheKey: %s | runningJobTask: %s", new Object[] { str, this.BFw.toString() });
    AppMethodBeat.o(52510);
  }
  
  public final Bitmap c(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(52517);
    paramString1 = Wo(d(paramString1, paramString2, paramBoolean, paramInt1, paramInt2));
    AppMethodBeat.o(52517);
    return paramString1;
  }
  
  public final boolean eqA()
  {
    return this.BFq;
  }
  
  public final void eqB()
  {
    AppMethodBeat.i(52514);
    Log.d("MicroMsg.FTS.FTSImageLoader", "startLoadImage");
    this.BFq = true;
    AppMethodBeat.o(52514);
  }
  
  public final void eqC()
  {
    AppMethodBeat.i(52515);
    Log.d("MicroMsg.FTS.FTSImageLoader", "clearCacheAndTask %s", new Object[] { Integer.valueOf(this.BFo.size()) });
    eqy();
    Iterator localIterator = this.BFo.entrySet().iterator();
    while (localIterator.hasNext()) {
      aHy((String)((Map.Entry)localIterator.next()).getKey());
    }
    this.BFp.clear();
    this.BFw.clear();
    AppMethodBeat.o(52515);
  }
  
  public final void eqD()
  {
    AppMethodBeat.i(52516);
    eqC();
    Log.d("MicroMsg.FTS.FTSImageLoader", "destoryLoader");
    int i = 0;
    while (i < 2)
    {
      if (this.BFs[i] != null) {
        this.BFs[i].quit();
      }
      i += 1;
    }
    Iterator localIterator = this.BFt.values().iterator();
    while (localIterator.hasNext())
    {
      ByteArrayOutputStream localByteArrayOutputStream = (ByteArrayOutputStream)localIterator.next();
      try
      {
        localByteArrayOutputStream.close();
      }
      catch (IOException localIOException) {}
    }
    this.BFt.clear();
    this.BFu.clear();
    this.BFv.quit();
    AppMethodBeat.o(52516);
  }
  
  public final void eqy()
  {
    AppMethodBeat.i(52512);
    Log.d("MicroMsg.FTS.FTSImageLoader", "stopLoadImageTask");
    int i = 0;
    while (i < 2)
    {
      if (this.BFs[i] != null) {
        this.BFs[i].removeCallbacksAndMessages(null);
      }
      i += 1;
    }
    AppMethodBeat.o(52512);
  }
  
  public final void eqz()
  {
    AppMethodBeat.i(52513);
    Log.d("MicroMsg.FTS.FTSImageLoader", "stopLoadImage");
    this.BFq = false;
    eqy();
    AppMethodBeat.o(52513);
  }
  
  final class b
    implements Runnable
  {
    private c.c BFz;
    private String cacheKey;
    private String fNU;
    private int height;
    private boolean kOk;
    private String url;
    private int width;
    
    public b(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, c.c paramc)
    {
      this.cacheKey = paramString1;
      this.url = paramString2;
      this.fNU = paramString3;
      this.BFz = paramc;
      this.kOk = paramBoolean;
      this.width = paramInt1;
      this.height = paramInt2;
    }
    
    public final void run()
    {
      AppMethodBeat.i(52507);
      Log.d("MicroMsg.FTS.FTSImageLoader", "Start to run load bitmap job %s", new Object[] { this.cacheKey });
      if (Util.isNullOrNil(this.fNU)) {
        this.fNU = c.aHz(this.cacheKey);
      }
      long l2 = System.currentTimeMillis();
      Bitmap localBitmap = c.al(this.fNU, this.width, this.height);
      long l1 = System.currentTimeMillis();
      if (localBitmap != null)
      {
        Log.d("MicroMsg.FTS.FTSImageLoader", "Found image in local %s | localPath %s | use time %d", new Object[] { this.url, this.fNU, Long.valueOf(l1 - l2) });
        c.a(c.this, this.cacheKey, this.fNU, localBitmap);
        this.BFz.bF(this.cacheKey, true);
        AppMethodBeat.o(52507);
        return;
      }
      localBitmap = c.a(c.this, this.url, this.kOk, this.width, this.height);
      l2 = System.currentTimeMillis();
      Log.d("MicroMsg.FTS.FTSImageLoader", "Get image from net %s | localPath %s | use time %d", new Object[] { this.url, this.fNU, Long.valueOf(l2 - l1) });
      if (localBitmap != null)
      {
        c.a(c.this, this.cacheKey, this.fNU, localBitmap);
        this.BFz.bF(this.cacheKey, true);
        AppMethodBeat.o(52507);
        return;
      }
      this.BFz.bF(this.cacheKey, false);
      AppMethodBeat.o(52507);
    }
  }
  
  static abstract interface c
  {
    public abstract void bF(String paramString, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.c
 * JD-Core Version:    0.7.0.1
 */