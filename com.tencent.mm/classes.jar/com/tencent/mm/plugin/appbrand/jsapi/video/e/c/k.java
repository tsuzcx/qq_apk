package com.tencent.mm.plugin.appbrand.jsapi.video.e.c;

import android.content.Context;
import com.google.android.exoplayer2.b.d;
import com.google.android.exoplayer2.h.g.a;
import com.google.android.exoplayer2.h.n;
import com.google.android.exoplayer2.h.s.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.threadpool.i;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class k
{
  public static final com.tencent.mm.plugin.appbrand.jsapi.video.e.a.a sGC;
  public static final d sGD;
  
  static
  {
    AppMethodBeat.i(328798);
    sGC = new com.tencent.mm.plugin.appbrand.jsapi.video.e.a.a((byte)0);
    sGD = new d();
    AppMethodBeat.o(328798);
  }
  
  private static s.b a(com.tencent.mm.plugin.appbrand.jsapi.video.e.a.a parama, String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(328717);
    parama = new b(paramString, parama);
    if (paramMap != null)
    {
      paramString = paramMap.entrySet().iterator();
      while (paramString.hasNext())
      {
        paramMap = (Map.Entry)paramString.next();
        Log.i("MicroMsg.SameLayer.ExoMediaPlayerUtils", "buildDefaultHttpDataSourceFactory, header: %s: %s", new Object[] { paramMap.getKey(), paramMap.getValue() });
        parama.setDefaultRequestProperty((String)paramMap.getKey(), (String)paramMap.getValue());
      }
    }
    AppMethodBeat.o(328717);
    return parama;
  }
  
  public static void a(final int paramInt, androidx.a.a.c.a<String, Void> parama)
  {
    AppMethodBeat.i(328737);
    if (!MMHandlerThread.isMainThread())
    {
      parama.apply(j(0, null, paramInt));
      AppMethodBeat.o(328737);
      return;
    }
    com.tencent.threadpool.h.ahAA.bm(new com.tencent.threadpool.i.h()
    {
      public final String getKey()
      {
        return "MicroMsg.SameLayer.ExoMediaPlayerUtils";
      }
      
      public final void run()
      {
        AppMethodBeat.i(328723);
        k.this.apply(k.k(this.sGF, this.oiH, paramInt));
        AppMethodBeat.o(328723);
      }
    });
    AppMethodBeat.o(328737);
  }
  
  public static g.a b(Context paramContext, Map<String, String> paramMap)
  {
    AppMethodBeat.i(328711);
    com.tencent.mm.plugin.appbrand.jsapi.video.e.a.a locala = sGC;
    paramContext = new n(paramContext, locala, a(locala, com.tencent.mm.plugin.appbrand.jsapi.video.e.k.eP(paramContext), paramMap));
    AppMethodBeat.o(328711);
    return paramContext;
  }
  
  public static void b(androidx.a.a.c.a<String, Void> parama)
  {
    AppMethodBeat.i(328732);
    a(10, parama);
    AppMethodBeat.o(328732);
  }
  
  public static com.tencent.mm.plugin.appbrand.jsapi.video.e.a.a cwV()
  {
    return sGC;
  }
  
  public static g.a eQ(Context paramContext)
  {
    AppMethodBeat.i(328704);
    com.tencent.mm.plugin.appbrand.jsapi.video.e.a.a locala = sGC;
    paramContext = new n(paramContext, locala, new b(com.tencent.mm.plugin.appbrand.jsapi.video.e.k.eP(paramContext), locala));
    AppMethodBeat.o(328704);
    return paramContext;
  }
  
  public static String f(d paramd)
  {
    AppMethodBeat.i(328782);
    if (paramd == null)
    {
      paramd = String.valueOf(null);
      AppMethodBeat.o(328782);
      return paramd;
    }
    paramd = "DecoderCounters{decoderInitCount=" + paramd.cKI + ", decoderReleaseCount=" + paramd.cKJ + ", inputBufferCount=" + paramd.cKK + ", renderedOutputBufferCount=" + paramd.cKL + ", skippedOutputBufferCount=" + paramd.cKM + ", droppedOutputBufferCount=" + paramd.cKN + ", maxConsecutiveDroppedOutputBufferCount=" + paramd.cKO + '}';
    AppMethodBeat.o(328782);
    return paramd;
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    AppMethodBeat.i(328722);
    boolean bool = NetStatusUtil.isNetworkConnected(paramContext);
    AppMethodBeat.o(328722);
    return bool;
  }
  
  /* Error */
  @java.lang.Deprecated
  private static String j(int paramInt1, String paramString, int paramInt2)
  {
    // Byte code:
    //   0: ldc 230
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 236	java/lang/System:currentTimeMillis	()J
    //   8: lstore 5
    //   10: iload_2
    //   11: sipush 1000
    //   14: imul
    //   15: i2l
    //   16: lstore 7
    //   18: invokestatic 242	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   21: iconst_1
    //   22: invokevirtual 246	java/util/Calendar:get	(I)I
    //   25: istore 4
    //   27: new 248	java/text/SimpleDateFormat
    //   30: dup
    //   31: ldc 250
    //   33: invokestatic 256	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   36: invokespecial 259	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   39: astore 14
    //   41: aload_1
    //   42: ifnonnull +309 -> 351
    //   45: iconst_4
    //   46: anewarray 86	java/lang/String
    //   49: astore_1
    //   50: aload_1
    //   51: iconst_0
    //   52: ldc_w 261
    //   55: aastore
    //   56: aload_1
    //   57: iconst_1
    //   58: ldc_w 263
    //   61: aastore
    //   62: aload_1
    //   63: iconst_2
    //   64: ldc_w 265
    //   67: aastore
    //   68: aload_1
    //   69: iconst_3
    //   70: ldc_w 267
    //   73: aastore
    //   74: aconst_null
    //   75: astore 12
    //   77: new 163	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 268	java/lang/StringBuilder:<init>	()V
    //   84: astore 13
    //   86: invokestatic 274	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   89: aload_1
    //   90: invokevirtual 278	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   93: astore_1
    //   94: new 280	java/io/BufferedReader
    //   97: dup
    //   98: new 282	java/io/InputStreamReader
    //   101: dup
    //   102: aload_1
    //   103: invokevirtual 288	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   106: invokespecial 291	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   109: invokespecial 294	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   112: astore 11
    //   114: iconst_0
    //   115: istore_2
    //   116: aload 11
    //   118: invokevirtual 297	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   121: astore 12
    //   123: aload 12
    //   125: ifnull +279 -> 404
    //   128: aload 12
    //   130: ldc_w 299
    //   133: invokevirtual 303	java/lang/String:matches	(Ljava/lang/String;)Z
    //   136: ifeq -20 -> 116
    //   139: aload 12
    //   141: iconst_0
    //   142: bipush 18
    //   144: invokevirtual 307	java/lang/String:substring	(II)Ljava/lang/String;
    //   147: astore 15
    //   149: aload 14
    //   151: new 163	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 268	java/lang/StringBuilder:<init>	()V
    //   158: iload 4
    //   160: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   163: ldc_w 309
    //   166: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload 15
    //   171: iconst_0
    //   172: bipush 18
    //   174: invokevirtual 307	java/lang/String:substring	(II)Ljava/lang/String;
    //   177: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokevirtual 313	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   186: invokevirtual 318	java/util/Date:getTime	()J
    //   189: lstore 9
    //   191: lload 9
    //   193: lload 5
    //   195: lcmp
    //   196: ifgt +208 -> 404
    //   199: iload_2
    //   200: istore_3
    //   201: lload 9
    //   203: lload 5
    //   205: lload 7
    //   207: lsub
    //   208: lcmp
    //   209: ifle +34 -> 243
    //   212: iload_2
    //   213: istore_3
    //   214: iload_2
    //   215: ifne +14 -> 229
    //   218: aload 13
    //   220: ldc_w 320
    //   223: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: iconst_1
    //   228: istore_3
    //   229: aload 13
    //   231: aload 12
    //   233: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: ldc_w 322
    //   239: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: iload_3
    //   244: istore_2
    //   245: iload_0
    //   246: ifle -130 -> 116
    //   249: iload_3
    //   250: istore_2
    //   251: aload 13
    //   253: invokevirtual 326	java/lang/StringBuilder:length	()I
    //   256: iload_0
    //   257: if_icmple -141 -> 116
    //   260: aload 13
    //   262: iconst_0
    //   263: aload 13
    //   265: invokevirtual 326	java/lang/StringBuilder:length	()I
    //   268: iload_0
    //   269: isub
    //   270: invokevirtual 330	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: iload_3
    //   275: istore_2
    //   276: goto -160 -> 116
    //   279: astore 11
    //   281: aload 13
    //   283: new 163	java/lang/StringBuilder
    //   286: dup
    //   287: ldc_w 332
    //   290: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   293: aload 11
    //   295: invokevirtual 335	java/lang/Throwable:toString	()Ljava/lang/String;
    //   298: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: ldc_w 337
    //   304: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: astore 11
    //   318: aload_1
    //   319: ifnull +24 -> 343
    //   322: aload_1
    //   323: invokevirtual 341	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   326: invokevirtual 346	java/io/OutputStream:close	()V
    //   329: aload_1
    //   330: invokevirtual 288	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   333: invokevirtual 349	java/io/InputStream:close	()V
    //   336: aload_1
    //   337: invokevirtual 352	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   340: invokevirtual 349	java/io/InputStream:close	()V
    //   343: ldc 230
    //   345: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   348: aload 11
    //   350: areturn
    //   351: bipush 6
    //   353: anewarray 86	java/lang/String
    //   356: astore 11
    //   358: aload 11
    //   360: iconst_0
    //   361: ldc_w 261
    //   364: aastore
    //   365: aload 11
    //   367: iconst_1
    //   368: ldc_w 263
    //   371: aastore
    //   372: aload 11
    //   374: iconst_2
    //   375: ldc_w 265
    //   378: aastore
    //   379: aload 11
    //   381: iconst_3
    //   382: ldc_w 267
    //   385: aastore
    //   386: aload 11
    //   388: iconst_4
    //   389: ldc_w 354
    //   392: aastore
    //   393: aload 11
    //   395: iconst_5
    //   396: aload_1
    //   397: aastore
    //   398: aload 11
    //   400: astore_1
    //   401: goto -327 -> 74
    //   404: aload 13
    //   406: ldc_w 356
    //   409: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: aload 13
    //   415: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   418: astore 11
    //   420: aload_1
    //   421: ifnull +24 -> 445
    //   424: aload_1
    //   425: invokevirtual 341	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   428: invokevirtual 346	java/io/OutputStream:close	()V
    //   431: aload_1
    //   432: invokevirtual 288	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   435: invokevirtual 349	java/io/InputStream:close	()V
    //   438: aload_1
    //   439: invokevirtual 352	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   442: invokevirtual 349	java/io/InputStream:close	()V
    //   445: ldc 230
    //   447: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   450: aload 11
    //   452: areturn
    //   453: astore 12
    //   455: ldc 71
    //   457: aload 12
    //   459: ldc_w 358
    //   462: iconst_0
    //   463: anewarray 4	java/lang/Object
    //   466: invokestatic 362	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   469: goto -38 -> 431
    //   472: astore 12
    //   474: ldc 71
    //   476: aload 12
    //   478: ldc_w 364
    //   481: iconst_0
    //   482: anewarray 4	java/lang/Object
    //   485: invokestatic 362	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   488: goto -50 -> 438
    //   491: astore_1
    //   492: ldc 71
    //   494: aload_1
    //   495: ldc_w 366
    //   498: iconst_0
    //   499: anewarray 4	java/lang/Object
    //   502: invokestatic 362	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   505: goto -60 -> 445
    //   508: astore 12
    //   510: ldc 71
    //   512: aload 12
    //   514: ldc_w 358
    //   517: iconst_0
    //   518: anewarray 4	java/lang/Object
    //   521: invokestatic 362	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   524: goto -195 -> 329
    //   527: astore 12
    //   529: ldc 71
    //   531: aload 12
    //   533: ldc_w 364
    //   536: iconst_0
    //   537: anewarray 4	java/lang/Object
    //   540: invokestatic 362	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   543: goto -207 -> 336
    //   546: astore_1
    //   547: ldc 71
    //   549: aload_1
    //   550: ldc_w 366
    //   553: iconst_0
    //   554: anewarray 4	java/lang/Object
    //   557: invokestatic 362	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   560: goto -217 -> 343
    //   563: astore 11
    //   565: aload_1
    //   566: ifnull +24 -> 590
    //   569: aload_1
    //   570: invokevirtual 341	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   573: invokevirtual 346	java/io/OutputStream:close	()V
    //   576: aload_1
    //   577: invokevirtual 288	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   580: invokevirtual 349	java/io/InputStream:close	()V
    //   583: aload_1
    //   584: invokevirtual 352	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   587: invokevirtual 349	java/io/InputStream:close	()V
    //   590: ldc 230
    //   592: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   595: aload 11
    //   597: athrow
    //   598: astore 12
    //   600: ldc 71
    //   602: aload 12
    //   604: ldc_w 358
    //   607: iconst_0
    //   608: anewarray 4	java/lang/Object
    //   611: invokestatic 362	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   614: goto -38 -> 576
    //   617: astore 12
    //   619: ldc 71
    //   621: aload 12
    //   623: ldc_w 364
    //   626: iconst_0
    //   627: anewarray 4	java/lang/Object
    //   630: invokestatic 362	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   633: goto -50 -> 583
    //   636: astore_1
    //   637: ldc 71
    //   639: aload_1
    //   640: ldc_w 366
    //   643: iconst_0
    //   644: anewarray 4	java/lang/Object
    //   647: invokestatic 362	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   650: goto -60 -> 590
    //   653: astore 11
    //   655: aload 12
    //   657: astore_1
    //   658: goto -377 -> 281
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	661	0	paramInt1	int
    //   0	661	1	paramString	String
    //   0	661	2	paramInt2	int
    //   200	75	3	i	int
    //   25	134	4	j	int
    //   8	196	5	l1	long
    //   16	190	7	l2	long
    //   189	13	9	l3	long
    //   112	5	11	localBufferedReader	java.io.BufferedReader
    //   279	15	11	localObject1	Object
    //   316	135	11	localObject2	Object
    //   563	33	11	localObject3	Object
    //   653	1	11	localObject4	Object
    //   75	157	12	str1	String
    //   453	5	12	localIOException1	java.io.IOException
    //   472	5	12	localException1	java.lang.Exception
    //   508	5	12	localIOException2	java.io.IOException
    //   527	5	12	localException2	java.lang.Exception
    //   598	5	12	localIOException3	java.io.IOException
    //   617	39	12	localException3	java.lang.Exception
    //   84	330	13	localStringBuilder	java.lang.StringBuilder
    //   39	111	14	localSimpleDateFormat	java.text.SimpleDateFormat
    //   147	23	15	str2	String
    // Exception table:
    //   from	to	target	type
    //   94	114	279	finally
    //   116	123	279	finally
    //   128	191	279	finally
    //   218	227	279	finally
    //   229	243	279	finally
    //   251	274	279	finally
    //   404	420	279	finally
    //   424	431	453	java/io/IOException
    //   431	438	472	java/lang/Exception
    //   438	445	491	java/io/IOException
    //   322	329	508	java/io/IOException
    //   329	336	527	java/lang/Exception
    //   336	343	546	java/io/IOException
    //   281	318	563	finally
    //   569	576	598	java/io/IOException
    //   576	583	617	java/lang/Exception
    //   583	590	636	java/io/IOException
    //   86	94	653	finally
  }
  
  public static String t(Throwable paramThrowable)
  {
    AppMethodBeat.i(328770);
    if (paramThrowable == null)
    {
      paramThrowable = String.valueOf(null);
      AppMethodBeat.o(328770);
      return paramThrowable;
    }
    paramThrowable = paramThrowable.toString();
    AppMethodBeat.o(328770);
    return paramThrowable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.c.k
 * JD-Core Version:    0.7.0.1
 */