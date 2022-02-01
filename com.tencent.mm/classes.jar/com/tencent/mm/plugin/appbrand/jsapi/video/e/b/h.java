package com.tencent.mm.plugin.appbrand.jsapi.video.e.b;

import android.content.Context;
import com.google.android.exoplayer2.b.d;
import com.google.android.exoplayer2.h.g.a;
import com.google.android.exoplayer2.h.n;
import com.google.android.exoplayer2.h.p;
import com.google.android.exoplayer2.h.s.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class h
{
  private static final a pBA;
  public static final d pBB;
  
  static
  {
    AppMethodBeat.i(227869);
    pBA = new a((byte)0);
    pBB = new d();
    AppMethodBeat.o(227869);
  }
  
  /* Error */
  public static String Bf(int paramInt)
  {
    // Byte code:
    //   0: ldc 44
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 50	java/lang/System:currentTimeMillis	()J
    //   8: lstore_3
    //   9: iload_0
    //   10: sipush 1000
    //   13: imul
    //   14: i2l
    //   15: lstore 5
    //   17: invokestatic 56	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   20: iconst_1
    //   21: invokevirtual 60	java/util/Calendar:get	(I)I
    //   24: istore_2
    //   25: new 62	java/text/SimpleDateFormat
    //   28: dup
    //   29: ldc 64
    //   31: invokestatic 70	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   34: invokespecial 73	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   37: astore 12
    //   39: iconst_0
    //   40: istore_0
    //   41: aconst_null
    //   42: astore 9
    //   44: new 75	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   51: astore 11
    //   53: invokestatic 82	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   56: iconst_4
    //   57: anewarray 84	java/lang/String
    //   60: dup
    //   61: iconst_0
    //   62: ldc 86
    //   64: aastore
    //   65: dup
    //   66: iconst_1
    //   67: ldc 88
    //   69: aastore
    //   70: dup
    //   71: iconst_2
    //   72: ldc 90
    //   74: aastore
    //   75: dup
    //   76: iconst_3
    //   77: ldc 92
    //   79: aastore
    //   80: invokevirtual 96	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   83: astore 10
    //   85: aload 10
    //   87: astore 9
    //   89: new 98	java/io/BufferedReader
    //   92: dup
    //   93: new 100	java/io/InputStreamReader
    //   96: dup
    //   97: aload 9
    //   99: invokevirtual 106	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   102: invokespecial 109	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   105: invokespecial 112	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   108: astore 10
    //   110: aload 10
    //   112: invokevirtual 116	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   115: astore 13
    //   117: aload 13
    //   119: ifnull +188 -> 307
    //   122: aload 13
    //   124: ldc 118
    //   126: invokevirtual 122	java/lang/String:matches	(Ljava/lang/String;)Z
    //   129: ifeq -19 -> 110
    //   132: aload 13
    //   134: iconst_0
    //   135: bipush 18
    //   137: invokevirtual 126	java/lang/String:substring	(II)Ljava/lang/String;
    //   140: astore 14
    //   142: aload 12
    //   144: new 75	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   151: iload_2
    //   152: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   155: ldc 132
    //   157: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload 14
    //   162: iconst_0
    //   163: bipush 18
    //   165: invokevirtual 126	java/lang/String:substring	(II)Ljava/lang/String;
    //   168: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokevirtual 142	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   177: invokevirtual 147	java/util/Date:getTime	()J
    //   180: lstore 7
    //   182: lload 7
    //   184: lload_3
    //   185: lcmp
    //   186: ifgt +121 -> 307
    //   189: lload 7
    //   191: lload_3
    //   192: lload 5
    //   194: lsub
    //   195: lcmp
    //   196: ifle -86 -> 110
    //   199: iload_0
    //   200: istore_1
    //   201: iload_0
    //   202: ifne +13 -> 215
    //   205: aload 11
    //   207: ldc 149
    //   209: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: iconst_1
    //   214: istore_1
    //   215: aload 11
    //   217: aload 13
    //   219: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: ldc 151
    //   224: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: iload_1
    //   229: istore_0
    //   230: goto -120 -> 110
    //   233: astore 10
    //   235: aload 11
    //   237: new 75	java/lang/StringBuilder
    //   240: dup
    //   241: ldc 153
    //   243: invokespecial 156	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   246: aload 10
    //   248: invokevirtual 157	java/lang/Throwable:toString	()Ljava/lang/String;
    //   251: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: ldc 159
    //   256: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: astore 10
    //   270: aload 9
    //   272: ifnull +27 -> 299
    //   275: aload 9
    //   277: invokevirtual 163	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   280: invokevirtual 168	java/io/OutputStream:close	()V
    //   283: aload 9
    //   285: invokevirtual 106	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   288: invokevirtual 171	java/io/InputStream:close	()V
    //   291: aload 9
    //   293: invokevirtual 174	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   296: invokevirtual 171	java/io/InputStream:close	()V
    //   299: ldc 44
    //   301: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   304: aload 10
    //   306: areturn
    //   307: aload 11
    //   309: ldc 176
    //   311: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: aload 11
    //   317: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: astore 10
    //   322: aload 9
    //   324: ifnull +27 -> 351
    //   327: aload 9
    //   329: invokevirtual 163	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   332: invokevirtual 168	java/io/OutputStream:close	()V
    //   335: aload 9
    //   337: invokevirtual 106	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   340: invokevirtual 171	java/io/InputStream:close	()V
    //   343: aload 9
    //   345: invokevirtual 174	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   348: invokevirtual 171	java/io/InputStream:close	()V
    //   351: ldc 44
    //   353: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   356: aload 10
    //   358: areturn
    //   359: astore 11
    //   361: ldc 178
    //   363: aload 11
    //   365: ldc 180
    //   367: iconst_0
    //   368: anewarray 4	java/lang/Object
    //   371: invokestatic 186	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   374: goto -39 -> 335
    //   377: astore 11
    //   379: ldc 178
    //   381: aload 11
    //   383: ldc 188
    //   385: iconst_0
    //   386: anewarray 4	java/lang/Object
    //   389: invokestatic 186	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   392: goto -49 -> 343
    //   395: astore 9
    //   397: ldc 178
    //   399: aload 9
    //   401: ldc 190
    //   403: iconst_0
    //   404: anewarray 4	java/lang/Object
    //   407: invokestatic 186	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   410: goto -59 -> 351
    //   413: astore 11
    //   415: ldc 178
    //   417: aload 11
    //   419: ldc 180
    //   421: iconst_0
    //   422: anewarray 4	java/lang/Object
    //   425: invokestatic 186	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   428: goto -145 -> 283
    //   431: astore 11
    //   433: ldc 178
    //   435: aload 11
    //   437: ldc 188
    //   439: iconst_0
    //   440: anewarray 4	java/lang/Object
    //   443: invokestatic 186	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   446: goto -155 -> 291
    //   449: astore 9
    //   451: ldc 178
    //   453: aload 9
    //   455: ldc 190
    //   457: iconst_0
    //   458: anewarray 4	java/lang/Object
    //   461: invokestatic 186	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   464: goto -165 -> 299
    //   467: astore 10
    //   469: aconst_null
    //   470: astore 9
    //   472: aload 9
    //   474: ifnull +27 -> 501
    //   477: aload 9
    //   479: invokevirtual 163	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   482: invokevirtual 168	java/io/OutputStream:close	()V
    //   485: aload 9
    //   487: invokevirtual 106	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   490: invokevirtual 171	java/io/InputStream:close	()V
    //   493: aload 9
    //   495: invokevirtual 174	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   498: invokevirtual 171	java/io/InputStream:close	()V
    //   501: ldc 44
    //   503: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   506: aload 10
    //   508: athrow
    //   509: astore 11
    //   511: ldc 178
    //   513: aload 11
    //   515: ldc 180
    //   517: iconst_0
    //   518: anewarray 4	java/lang/Object
    //   521: invokestatic 186	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   524: goto -39 -> 485
    //   527: astore 11
    //   529: ldc 178
    //   531: aload 11
    //   533: ldc 188
    //   535: iconst_0
    //   536: anewarray 4	java/lang/Object
    //   539: invokestatic 186	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   542: goto -49 -> 493
    //   545: astore 9
    //   547: ldc 178
    //   549: aload 9
    //   551: ldc 190
    //   553: iconst_0
    //   554: anewarray 4	java/lang/Object
    //   557: invokestatic 186	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   560: goto -59 -> 501
    //   563: astore 10
    //   565: goto -93 -> 472
    //   568: astore 10
    //   570: goto -98 -> 472
    //   573: astore 10
    //   575: goto -340 -> 235
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	578	0	paramInt	int
    //   200	29	1	i	int
    //   24	128	2	j	int
    //   8	184	3	l1	long
    //   15	178	5	l2	long
    //   180	10	7	l3	long
    //   42	302	9	localObject1	Object
    //   395	5	9	localIOException1	java.io.IOException
    //   449	5	9	localIOException2	java.io.IOException
    //   470	24	9	localObject2	Object
    //   545	5	9	localIOException3	java.io.IOException
    //   83	28	10	localObject3	Object
    //   233	14	10	localThrowable1	Throwable
    //   268	89	10	str1	String
    //   467	40	10	localObject4	Object
    //   563	1	10	localObject5	Object
    //   568	1	10	localObject6	Object
    //   573	1	10	localThrowable2	Throwable
    //   51	265	11	localStringBuilder	java.lang.StringBuilder
    //   359	5	11	localIOException4	java.io.IOException
    //   377	5	11	localException1	java.lang.Exception
    //   413	5	11	localIOException5	java.io.IOException
    //   431	5	11	localException2	java.lang.Exception
    //   509	5	11	localIOException6	java.io.IOException
    //   527	5	11	localException3	java.lang.Exception
    //   37	106	12	localSimpleDateFormat	java.text.SimpleDateFormat
    //   115	103	13	str2	String
    //   140	21	14	str3	String
    // Exception table:
    //   from	to	target	type
    //   89	110	233	java/lang/Throwable
    //   110	117	233	java/lang/Throwable
    //   122	182	233	java/lang/Throwable
    //   205	213	233	java/lang/Throwable
    //   215	228	233	java/lang/Throwable
    //   307	322	233	java/lang/Throwable
    //   327	335	359	java/io/IOException
    //   335	343	377	java/lang/Exception
    //   343	351	395	java/io/IOException
    //   275	283	413	java/io/IOException
    //   283	291	431	java/lang/Exception
    //   291	299	449	java/io/IOException
    //   53	85	467	finally
    //   477	485	509	java/io/IOException
    //   485	493	527	java/lang/Exception
    //   493	501	545	java/io/IOException
    //   89	110	563	finally
    //   110	117	563	finally
    //   122	182	563	finally
    //   205	213	563	finally
    //   215	228	563	finally
    //   307	322	563	finally
    //   235	270	568	finally
    //   53	85	573	java/lang/Throwable
  }
  
  private static s.b a(a parama, String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(227843);
    parama = new p(paramString, parama, true);
    if (paramMap != null)
    {
      paramString = paramMap.entrySet().iterator();
      while (paramString.hasNext())
      {
        paramMap = (Map.Entry)paramString.next();
        Log.i("MicroMsg.SameLayer.ExoMediaPlayerUtils", "buildDefaultHttpDataSourceFactory, header: %s: %s", new Object[] { paramMap.getKey(), paramMap.getValue() });
        parama.n((String)paramMap.getKey(), (String)paramMap.getValue());
      }
    }
    AppMethodBeat.o(227843);
    return parama;
  }
  
  public static g.a b(Context paramContext, Map<String, String> paramMap)
  {
    AppMethodBeat.i(227838);
    a locala = pBA;
    paramContext = new n(paramContext, locala, a(locala, k.dV(paramContext), paramMap));
    AppMethodBeat.o(227838);
    return paramContext;
  }
  
  public static String bWG()
  {
    AppMethodBeat.i(227845);
    String str = Bf(10);
    AppMethodBeat.o(227845);
    return str;
  }
  
  public static a bWH()
  {
    return pBA;
  }
  
  public static g.a dW(Context paramContext)
  {
    AppMethodBeat.i(227836);
    a locala = pBA;
    paramContext = new n(paramContext, locala, new p(k.dV(paramContext), locala, true));
    AppMethodBeat.o(227836);
    return paramContext;
  }
  
  public static String f(d paramd)
  {
    AppMethodBeat.i(227863);
    if (paramd == null)
    {
      paramd = String.valueOf(null);
      AppMethodBeat.o(227863);
      return paramd;
    }
    paramd = "DecoderCounters{decoderInitCount=" + paramd.aQM + ", decoderReleaseCount=" + paramd.aQN + ", inputBufferCount=" + paramd.aQO + ", renderedOutputBufferCount=" + paramd.aQP + ", skippedOutputBufferCount=" + paramd.aQQ + ", droppedOutputBufferCount=" + paramd.aQR + ", maxConsecutiveDroppedOutputBufferCount=" + paramd.aQS + '}';
    AppMethodBeat.o(227863);
    return paramd;
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    AppMethodBeat.i(227844);
    boolean bool = NetStatusUtil.isNetworkConnected(paramContext);
    AppMethodBeat.o(227844);
    return bool;
  }
  
  public static String j(Throwable paramThrowable)
  {
    AppMethodBeat.i(227858);
    if (paramThrowable == null)
    {
      paramThrowable = String.valueOf(null);
      AppMethodBeat.o(227858);
      return paramThrowable;
    }
    paramThrowable = paramThrowable.toString();
    AppMethodBeat.o(227858);
    return paramThrowable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.b.h
 * JD-Core Version:    0.7.0.1
 */