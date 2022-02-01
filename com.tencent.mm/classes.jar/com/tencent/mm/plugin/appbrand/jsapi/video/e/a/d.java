package com.tencent.mm.plugin.appbrand.jsapi.video.e.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.exoplayer2.h.g.a;
import com.google.android.exoplayer2.h.l;
import com.google.android.exoplayer2.h.n;
import com.google.android.exoplayer2.h.p;
import com.google.android.exoplayer2.h.s.b;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class d
{
  private static String appName;
  private static final l gHE;
  
  static
  {
    AppMethodBeat.i(194530);
    gHE = new l();
    AppMethodBeat.o(194530);
  }
  
  public static g.a a(Context paramContext, Map<String, String> paramMap)
  {
    AppMethodBeat.i(194525);
    l locall = gHE;
    paramContext = new n(paramContext, locall, a(locall, dA(paramContext), paramMap));
    AppMethodBeat.o(194525);
    return paramContext;
  }
  
  private static s.b a(l paraml, String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(194526);
    paraml = new p(paramString, paraml, true);
    if (paramMap != null)
    {
      paramString = paramMap.entrySet().iterator();
      while (paramString.hasNext())
      {
        paramMap = (Map.Entry)paramString.next();
        ac.i("MicroMsg.SameLayer.ExoMediaPlayerUtils", "buildDefaultHttpDataSourceFactory, header: %s: %s", new Object[] { paramMap.getKey(), paramMap.getValue() });
        paraml.setDefaultRequestProperty((String)paramMap.getKey(), (String)paramMap.getValue());
      }
    }
    AppMethodBeat.o(194526);
    return paraml;
  }
  
  public static String bkJ()
  {
    AppMethodBeat.i(194528);
    String str = tb(10);
    AppMethodBeat.o(194528);
    return str;
  }
  
  public static l bkK()
  {
    return gHE;
  }
  
  private static String dA(Context paramContext)
  {
    AppMethodBeat.i(194523);
    if (!bs.isNullOrNil(appName))
    {
      paramContext = appName;
      AppMethodBeat.o(194523);
      return paramContext;
    }
    appName = paramContext.getPackageName();
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(appName, 0);
      if ((localPackageInfo != null) && (localPackageInfo.applicationInfo != null) && (!bs.isNullOrNil(localPackageInfo.applicationInfo.name))) {
        appName = localPackageInfo.applicationInfo.name;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.SameLayer.ExoMediaPlayerUtils", localNameNotFoundException, "getUserAgent exception", new Object[0]);
      }
    }
    paramContext = x.i(paramContext, appName);
    AppMethodBeat.o(194523);
    return paramContext;
  }
  
  public static g.a dB(Context paramContext)
  {
    AppMethodBeat.i(194524);
    l locall = gHE;
    paramContext = new n(paramContext, locall, new p(dA(paramContext), locall, true));
    AppMethodBeat.o(194524);
    return paramContext;
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    AppMethodBeat.i(194527);
    boolean bool = ax.isNetworkConnected(paramContext);
    AppMethodBeat.o(194527);
    return bool;
  }
  
  /* Error */
  public static String tb(int paramInt)
  {
    // Byte code:
    //   0: ldc 174
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 180	java/lang/System:currentTimeMillis	()J
    //   8: lstore_3
    //   9: iload_0
    //   10: sipush 1000
    //   13: imul
    //   14: i2l
    //   15: lstore 5
    //   17: invokestatic 186	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   20: iconst_1
    //   21: invokevirtual 190	java/util/Calendar:get	(I)I
    //   24: istore_2
    //   25: new 192	java/text/SimpleDateFormat
    //   28: dup
    //   29: ldc 194
    //   31: invokestatic 200	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   34: invokespecial 203	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   37: astore 12
    //   39: iconst_0
    //   40: istore_0
    //   41: aconst_null
    //   42: astore 9
    //   44: new 205	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   51: astore 11
    //   53: invokestatic 212	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   56: iconst_4
    //   57: anewarray 92	java/lang/String
    //   60: dup
    //   61: iconst_0
    //   62: ldc 214
    //   64: aastore
    //   65: dup
    //   66: iconst_1
    //   67: ldc 216
    //   69: aastore
    //   70: dup
    //   71: iconst_2
    //   72: ldc 218
    //   74: aastore
    //   75: dup
    //   76: iconst_3
    //   77: ldc 220
    //   79: aastore
    //   80: invokevirtual 224	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   83: astore 10
    //   85: aload 10
    //   87: astore 9
    //   89: new 226	java/io/BufferedReader
    //   92: dup
    //   93: new 228	java/io/InputStreamReader
    //   96: dup
    //   97: aload 9
    //   99: invokevirtual 234	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   102: invokespecial 237	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   105: invokespecial 240	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   108: astore 10
    //   110: aload 10
    //   112: invokevirtual 243	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   115: astore 13
    //   117: aload 13
    //   119: ifnull +193 -> 312
    //   122: aload 13
    //   124: ldc 245
    //   126: invokevirtual 248	java/lang/String:matches	(Ljava/lang/String;)Z
    //   129: ifeq -19 -> 110
    //   132: aload 13
    //   134: iconst_0
    //   135: bipush 18
    //   137: invokevirtual 252	java/lang/String:substring	(II)Ljava/lang/String;
    //   140: astore 14
    //   142: aload 12
    //   144: new 205	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   151: iload_2
    //   152: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   155: ldc_w 258
    //   158: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload 14
    //   163: iconst_0
    //   164: bipush 18
    //   166: invokevirtual 252	java/lang/String:substring	(II)Ljava/lang/String;
    //   169: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokevirtual 268	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   178: invokevirtual 273	java/util/Date:getTime	()J
    //   181: lstore 7
    //   183: lload 7
    //   185: lload_3
    //   186: lcmp
    //   187: ifgt +125 -> 312
    //   190: lload 7
    //   192: lload_3
    //   193: lload 5
    //   195: lsub
    //   196: lcmp
    //   197: ifle -87 -> 110
    //   200: iload_0
    //   201: istore_1
    //   202: iload_0
    //   203: ifne +14 -> 217
    //   206: aload 11
    //   208: ldc_w 275
    //   211: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: iconst_1
    //   216: istore_1
    //   217: aload 11
    //   219: aload 13
    //   221: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: ldc_w 277
    //   227: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: iload_1
    //   232: istore_0
    //   233: goto -123 -> 110
    //   236: astore 10
    //   238: aload 11
    //   240: new 205	java/lang/StringBuilder
    //   243: dup
    //   244: ldc_w 279
    //   247: invokespecial 282	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   250: aload 10
    //   252: invokevirtual 283	java/lang/Throwable:toString	()Ljava/lang/String;
    //   255: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: ldc_w 285
    //   261: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: astore 10
    //   275: aload 9
    //   277: ifnull +27 -> 304
    //   280: aload 9
    //   282: invokevirtual 289	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   285: invokevirtual 294	java/io/OutputStream:close	()V
    //   288: aload 9
    //   290: invokevirtual 234	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   293: invokevirtual 297	java/io/InputStream:close	()V
    //   296: aload 9
    //   298: invokevirtual 300	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   301: invokevirtual 297	java/io/InputStream:close	()V
    //   304: ldc 174
    //   306: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   309: aload 10
    //   311: areturn
    //   312: aload 11
    //   314: ldc_w 302
    //   317: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: aload 11
    //   323: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: astore 10
    //   328: aload 9
    //   330: ifnull +27 -> 357
    //   333: aload 9
    //   335: invokevirtual 289	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   338: invokevirtual 294	java/io/OutputStream:close	()V
    //   341: aload 9
    //   343: invokevirtual 234	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   346: invokevirtual 297	java/io/InputStream:close	()V
    //   349: aload 9
    //   351: invokevirtual 300	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   354: invokevirtual 297	java/io/InputStream:close	()V
    //   357: ldc 174
    //   359: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   362: aload 10
    //   364: areturn
    //   365: astore 11
    //   367: ldc 77
    //   369: aload 11
    //   371: ldc_w 304
    //   374: iconst_0
    //   375: anewarray 4	java/lang/Object
    //   378: invokestatic 156	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   381: goto -40 -> 341
    //   384: astore 11
    //   386: ldc 77
    //   388: aload 11
    //   390: ldc_w 306
    //   393: iconst_0
    //   394: anewarray 4	java/lang/Object
    //   397: invokestatic 156	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   400: goto -51 -> 349
    //   403: astore 9
    //   405: ldc 77
    //   407: aload 9
    //   409: ldc_w 308
    //   412: iconst_0
    //   413: anewarray 4	java/lang/Object
    //   416: invokestatic 156	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   419: goto -62 -> 357
    //   422: astore 11
    //   424: ldc 77
    //   426: aload 11
    //   428: ldc_w 304
    //   431: iconst_0
    //   432: anewarray 4	java/lang/Object
    //   435: invokestatic 156	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   438: goto -150 -> 288
    //   441: astore 11
    //   443: ldc 77
    //   445: aload 11
    //   447: ldc_w 306
    //   450: iconst_0
    //   451: anewarray 4	java/lang/Object
    //   454: invokestatic 156	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   457: goto -161 -> 296
    //   460: astore 9
    //   462: ldc 77
    //   464: aload 9
    //   466: ldc_w 308
    //   469: iconst_0
    //   470: anewarray 4	java/lang/Object
    //   473: invokestatic 156	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   476: goto -172 -> 304
    //   479: astore 10
    //   481: aconst_null
    //   482: astore 9
    //   484: aload 9
    //   486: ifnull +27 -> 513
    //   489: aload 9
    //   491: invokevirtual 289	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   494: invokevirtual 294	java/io/OutputStream:close	()V
    //   497: aload 9
    //   499: invokevirtual 234	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   502: invokevirtual 297	java/io/InputStream:close	()V
    //   505: aload 9
    //   507: invokevirtual 300	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   510: invokevirtual 297	java/io/InputStream:close	()V
    //   513: ldc 174
    //   515: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   518: aload 10
    //   520: athrow
    //   521: astore 11
    //   523: ldc 77
    //   525: aload 11
    //   527: ldc_w 304
    //   530: iconst_0
    //   531: anewarray 4	java/lang/Object
    //   534: invokestatic 156	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   537: goto -40 -> 497
    //   540: astore 11
    //   542: ldc 77
    //   544: aload 11
    //   546: ldc_w 306
    //   549: iconst_0
    //   550: anewarray 4	java/lang/Object
    //   553: invokestatic 156	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   556: goto -51 -> 505
    //   559: astore 9
    //   561: ldc 77
    //   563: aload 9
    //   565: ldc_w 308
    //   568: iconst_0
    //   569: anewarray 4	java/lang/Object
    //   572: invokestatic 156	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   575: goto -62 -> 513
    //   578: astore 10
    //   580: goto -96 -> 484
    //   583: astore 10
    //   585: goto -101 -> 484
    //   588: astore 10
    //   590: goto -352 -> 238
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	593	0	paramInt	int
    //   201	31	1	i	int
    //   24	128	2	j	int
    //   8	185	3	l1	long
    //   15	179	5	l2	long
    //   181	10	7	l3	long
    //   42	308	9	localObject1	Object
    //   403	5	9	localIOException1	java.io.IOException
    //   460	5	9	localIOException2	java.io.IOException
    //   482	24	9	localObject2	Object
    //   559	5	9	localIOException3	java.io.IOException
    //   83	28	10	localObject3	Object
    //   236	15	10	localThrowable1	java.lang.Throwable
    //   273	90	10	str1	String
    //   479	40	10	localObject4	Object
    //   578	1	10	localObject5	Object
    //   583	1	10	localObject6	Object
    //   588	1	10	localThrowable2	java.lang.Throwable
    //   51	271	11	localStringBuilder	java.lang.StringBuilder
    //   365	5	11	localIOException4	java.io.IOException
    //   384	5	11	localException1	java.lang.Exception
    //   422	5	11	localIOException5	java.io.IOException
    //   441	5	11	localException2	java.lang.Exception
    //   521	5	11	localIOException6	java.io.IOException
    //   540	5	11	localException3	java.lang.Exception
    //   37	106	12	localSimpleDateFormat	java.text.SimpleDateFormat
    //   115	105	13	str2	String
    //   140	22	14	str3	String
    // Exception table:
    //   from	to	target	type
    //   89	110	236	java/lang/Throwable
    //   110	117	236	java/lang/Throwable
    //   122	183	236	java/lang/Throwable
    //   206	215	236	java/lang/Throwable
    //   217	231	236	java/lang/Throwable
    //   312	328	236	java/lang/Throwable
    //   333	341	365	java/io/IOException
    //   341	349	384	java/lang/Exception
    //   349	357	403	java/io/IOException
    //   280	288	422	java/io/IOException
    //   288	296	441	java/lang/Exception
    //   296	304	460	java/io/IOException
    //   53	85	479	finally
    //   489	497	521	java/io/IOException
    //   497	505	540	java/lang/Exception
    //   505	513	559	java/io/IOException
    //   89	110	578	finally
    //   110	117	578	finally
    //   122	183	578	finally
    //   206	215	578	finally
    //   217	231	578	finally
    //   312	328	578	finally
    //   238	275	583	finally
    //   53	85	588	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.a.d
 * JD-Core Version:    0.7.0.1
 */