package com.tencent.mm.plugin.appbrand.jsapi.video.e.b;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.exoplayer2.h.g.a;
import com.google.android.exoplayer2.h.n;
import com.google.android.exoplayer2.h.p;
import com.google.android.exoplayer2.h.s.b;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class d
{
  private static String appName;
  private static final a lvJ;
  
  static
  {
    AppMethodBeat.i(211372);
    lvJ = new a((byte)0);
    AppMethodBeat.o(211372);
  }
  
  public static String V(Throwable paramThrowable)
  {
    AppMethodBeat.i(224440);
    if (paramThrowable == null)
    {
      paramThrowable = String.valueOf(null);
      AppMethodBeat.o(224440);
      return paramThrowable;
    }
    paramThrowable = paramThrowable.toString();
    AppMethodBeat.o(224440);
    return paramThrowable;
  }
  
  public static g.a a(Context paramContext, Map<String, String> paramMap)
  {
    AppMethodBeat.i(211367);
    a locala = lvJ;
    paramContext = new n(paramContext, locala, a(locala, dC(paramContext), paramMap));
    AppMethodBeat.o(211367);
    return paramContext;
  }
  
  private static s.b a(a parama, String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(211368);
    parama = new p(paramString, parama, true);
    if (paramMap != null)
    {
      paramString = paramMap.entrySet().iterator();
      while (paramString.hasNext())
      {
        paramMap = (Map.Entry)paramString.next();
        ae.i("MicroMsg.SameLayer.ExoMediaPlayerUtils", "buildDefaultHttpDataSourceFactory, header: %s: %s", new Object[] { paramMap.getKey(), paramMap.getValue() });
        parama.setDefaultRequestProperty((String)paramMap.getKey(), (String)paramMap.getValue());
      }
    }
    AppMethodBeat.o(211368);
    return parama;
  }
  
  public static String bpe()
  {
    AppMethodBeat.i(211370);
    String str = tJ(10);
    AppMethodBeat.o(211370);
    return str;
  }
  
  public static a bpf()
  {
    return lvJ;
  }
  
  private static String dC(Context paramContext)
  {
    AppMethodBeat.i(211365);
    if (!bu.isNullOrNil(appName))
    {
      paramContext = appName;
      AppMethodBeat.o(211365);
      return paramContext;
    }
    appName = paramContext.getPackageName();
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(appName, 0);
      if ((localPackageInfo != null) && (localPackageInfo.applicationInfo != null) && (!bu.isNullOrNil(localPackageInfo.applicationInfo.name))) {
        appName = localPackageInfo.applicationInfo.name;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.SameLayer.ExoMediaPlayerUtils", localNameNotFoundException, "getUserAgent exception", new Object[0]);
      }
    }
    paramContext = x.h(paramContext, appName);
    AppMethodBeat.o(211365);
    return paramContext;
  }
  
  public static g.a dD(Context paramContext)
  {
    AppMethodBeat.i(211366);
    a locala = lvJ;
    paramContext = new n(paramContext, locala, new p(dC(paramContext), locala, true));
    AppMethodBeat.o(211366);
    return paramContext;
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    AppMethodBeat.i(211369);
    boolean bool = az.isNetworkConnected(paramContext);
    AppMethodBeat.o(211369);
    return bool;
  }
  
  /* Error */
  public static String tJ(int paramInt)
  {
    // Byte code:
    //   0: ldc 186
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 192	java/lang/System:currentTimeMillis	()J
    //   8: lstore_3
    //   9: iload_0
    //   10: sipush 1000
    //   13: imul
    //   14: i2l
    //   15: lstore 5
    //   17: invokestatic 198	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   20: iconst_1
    //   21: invokevirtual 202	java/util/Calendar:get	(I)I
    //   24: istore_2
    //   25: new 204	java/text/SimpleDateFormat
    //   28: dup
    //   29: ldc 206
    //   31: invokestatic 212	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   34: invokespecial 215	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   37: astore 12
    //   39: iconst_0
    //   40: istore_0
    //   41: aconst_null
    //   42: astore 9
    //   44: new 217	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   51: astore 11
    //   53: invokestatic 225	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   56: iconst_4
    //   57: anewarray 34	java/lang/String
    //   60: dup
    //   61: iconst_0
    //   62: ldc 227
    //   64: aastore
    //   65: dup
    //   66: iconst_1
    //   67: ldc 229
    //   69: aastore
    //   70: dup
    //   71: iconst_2
    //   72: ldc 231
    //   74: aastore
    //   75: dup
    //   76: iconst_3
    //   77: ldc 233
    //   79: aastore
    //   80: invokevirtual 237	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   83: astore 10
    //   85: aload 10
    //   87: astore 9
    //   89: new 239	java/io/BufferedReader
    //   92: dup
    //   93: new 241	java/io/InputStreamReader
    //   96: dup
    //   97: aload 9
    //   99: invokevirtual 247	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   102: invokespecial 250	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   105: invokespecial 253	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   108: astore 10
    //   110: aload 10
    //   112: invokevirtual 256	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   115: astore 13
    //   117: aload 13
    //   119: ifnull +194 -> 313
    //   122: aload 13
    //   124: ldc_w 258
    //   127: invokevirtual 261	java/lang/String:matches	(Ljava/lang/String;)Z
    //   130: ifeq -20 -> 110
    //   133: aload 13
    //   135: iconst_0
    //   136: bipush 18
    //   138: invokevirtual 265	java/lang/String:substring	(II)Ljava/lang/String;
    //   141: astore 14
    //   143: aload 12
    //   145: new 217	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   152: iload_2
    //   153: invokevirtual 269	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   156: ldc_w 271
    //   159: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload 14
    //   164: iconst_0
    //   165: bipush 18
    //   167: invokevirtual 265	java/lang/String:substring	(II)Ljava/lang/String;
    //   170: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokevirtual 279	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   179: invokevirtual 284	java/util/Date:getTime	()J
    //   182: lstore 7
    //   184: lload 7
    //   186: lload_3
    //   187: lcmp
    //   188: ifgt +125 -> 313
    //   191: lload 7
    //   193: lload_3
    //   194: lload 5
    //   196: lsub
    //   197: lcmp
    //   198: ifle -88 -> 110
    //   201: iload_0
    //   202: istore_1
    //   203: iload_0
    //   204: ifne +14 -> 218
    //   207: aload 11
    //   209: ldc_w 286
    //   212: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: iconst_1
    //   217: istore_1
    //   218: aload 11
    //   220: aload 13
    //   222: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: ldc_w 288
    //   228: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: iload_1
    //   233: istore_0
    //   234: goto -124 -> 110
    //   237: astore 10
    //   239: aload 11
    //   241: new 217	java/lang/StringBuilder
    //   244: dup
    //   245: ldc_w 290
    //   248: invokespecial 293	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   251: aload 10
    //   253: invokevirtual 44	java/lang/Throwable:toString	()Ljava/lang/String;
    //   256: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: ldc_w 295
    //   262: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: astore 10
    //   276: aload 9
    //   278: ifnull +27 -> 305
    //   281: aload 9
    //   283: invokevirtual 299	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   286: invokevirtual 304	java/io/OutputStream:close	()V
    //   289: aload 9
    //   291: invokevirtual 247	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   294: invokevirtual 307	java/io/InputStream:close	()V
    //   297: aload 9
    //   299: invokevirtual 310	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   302: invokevirtual 307	java/io/InputStream:close	()V
    //   305: ldc 186
    //   307: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   310: aload 10
    //   312: areturn
    //   313: aload 11
    //   315: ldc_w 312
    //   318: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: aload 11
    //   324: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: astore 10
    //   329: aload 9
    //   331: ifnull +27 -> 358
    //   334: aload 9
    //   336: invokevirtual 299	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   339: invokevirtual 304	java/io/OutputStream:close	()V
    //   342: aload 9
    //   344: invokevirtual 247	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   347: invokevirtual 307	java/io/InputStream:close	()V
    //   350: aload 9
    //   352: invokevirtual 310	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   355: invokevirtual 307	java/io/InputStream:close	()V
    //   358: ldc 186
    //   360: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   363: aload 10
    //   365: areturn
    //   366: astore 11
    //   368: ldc 93
    //   370: aload 11
    //   372: ldc_w 314
    //   375: iconst_0
    //   376: anewarray 4	java/lang/Object
    //   379: invokestatic 170	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   382: goto -40 -> 342
    //   385: astore 11
    //   387: ldc 93
    //   389: aload 11
    //   391: ldc_w 316
    //   394: iconst_0
    //   395: anewarray 4	java/lang/Object
    //   398: invokestatic 170	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   401: goto -51 -> 350
    //   404: astore 9
    //   406: ldc 93
    //   408: aload 9
    //   410: ldc_w 318
    //   413: iconst_0
    //   414: anewarray 4	java/lang/Object
    //   417: invokestatic 170	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   420: goto -62 -> 358
    //   423: astore 11
    //   425: ldc 93
    //   427: aload 11
    //   429: ldc_w 314
    //   432: iconst_0
    //   433: anewarray 4	java/lang/Object
    //   436: invokestatic 170	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   439: goto -150 -> 289
    //   442: astore 11
    //   444: ldc 93
    //   446: aload 11
    //   448: ldc_w 316
    //   451: iconst_0
    //   452: anewarray 4	java/lang/Object
    //   455: invokestatic 170	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   458: goto -161 -> 297
    //   461: astore 9
    //   463: ldc 93
    //   465: aload 9
    //   467: ldc_w 318
    //   470: iconst_0
    //   471: anewarray 4	java/lang/Object
    //   474: invokestatic 170	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   477: goto -172 -> 305
    //   480: astore 10
    //   482: aconst_null
    //   483: astore 9
    //   485: aload 9
    //   487: ifnull +27 -> 514
    //   490: aload 9
    //   492: invokevirtual 299	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   495: invokevirtual 304	java/io/OutputStream:close	()V
    //   498: aload 9
    //   500: invokevirtual 247	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   503: invokevirtual 307	java/io/InputStream:close	()V
    //   506: aload 9
    //   508: invokevirtual 310	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   511: invokevirtual 307	java/io/InputStream:close	()V
    //   514: ldc 186
    //   516: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   519: aload 10
    //   521: athrow
    //   522: astore 11
    //   524: ldc 93
    //   526: aload 11
    //   528: ldc_w 314
    //   531: iconst_0
    //   532: anewarray 4	java/lang/Object
    //   535: invokestatic 170	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   538: goto -40 -> 498
    //   541: astore 11
    //   543: ldc 93
    //   545: aload 11
    //   547: ldc_w 316
    //   550: iconst_0
    //   551: anewarray 4	java/lang/Object
    //   554: invokestatic 170	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   557: goto -51 -> 506
    //   560: astore 9
    //   562: ldc 93
    //   564: aload 9
    //   566: ldc_w 318
    //   569: iconst_0
    //   570: anewarray 4	java/lang/Object
    //   573: invokestatic 170	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   576: goto -62 -> 514
    //   579: astore 10
    //   581: goto -96 -> 485
    //   584: astore 10
    //   586: goto -101 -> 485
    //   589: astore 10
    //   591: goto -352 -> 239
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	594	0	paramInt	int
    //   202	31	1	i	int
    //   24	129	2	j	int
    //   8	186	3	l1	long
    //   15	180	5	l2	long
    //   182	10	7	l3	long
    //   42	309	9	localObject1	Object
    //   404	5	9	localIOException1	java.io.IOException
    //   461	5	9	localIOException2	java.io.IOException
    //   483	24	9	localObject2	Object
    //   560	5	9	localIOException3	java.io.IOException
    //   83	28	10	localObject3	Object
    //   237	15	10	localThrowable1	Throwable
    //   274	90	10	str1	String
    //   480	40	10	localObject4	Object
    //   579	1	10	localObject5	Object
    //   584	1	10	localObject6	Object
    //   589	1	10	localThrowable2	Throwable
    //   51	272	11	localStringBuilder	java.lang.StringBuilder
    //   366	5	11	localIOException4	java.io.IOException
    //   385	5	11	localException1	java.lang.Exception
    //   423	5	11	localIOException5	java.io.IOException
    //   442	5	11	localException2	java.lang.Exception
    //   522	5	11	localIOException6	java.io.IOException
    //   541	5	11	localException3	java.lang.Exception
    //   37	107	12	localSimpleDateFormat	java.text.SimpleDateFormat
    //   115	106	13	str2	String
    //   141	22	14	str3	String
    // Exception table:
    //   from	to	target	type
    //   89	110	237	java/lang/Throwable
    //   110	117	237	java/lang/Throwable
    //   122	184	237	java/lang/Throwable
    //   207	216	237	java/lang/Throwable
    //   218	232	237	java/lang/Throwable
    //   313	329	237	java/lang/Throwable
    //   334	342	366	java/io/IOException
    //   342	350	385	java/lang/Exception
    //   350	358	404	java/io/IOException
    //   281	289	423	java/io/IOException
    //   289	297	442	java/lang/Exception
    //   297	305	461	java/io/IOException
    //   53	85	480	finally
    //   490	498	522	java/io/IOException
    //   498	506	541	java/lang/Exception
    //   506	514	560	java/io/IOException
    //   89	110	579	finally
    //   110	117	579	finally
    //   122	184	579	finally
    //   207	216	579	finally
    //   218	232	579	finally
    //   313	329	579	finally
    //   239	276	584	finally
    //   53	85	589	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.b.d
 * JD-Core Version:    0.7.0.1
 */