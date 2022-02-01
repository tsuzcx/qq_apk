package com.tencent.mm.plugin.expt.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class b
{
  private static Boolean wdn;
  
  public static boolean No()
  {
    AppMethodBeat.i(255450);
    if ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED) || (CrashReportFactory.hasDebuger()))
    {
      AppMethodBeat.o(255450);
      return true;
    }
    AppMethodBeat.o(255450);
    return false;
  }
  
  /* Error */
  public static java.lang.String awj(java.lang.String paramString)
  {
    // Byte code:
    //   0: ldc 40
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore 4
    //   8: aconst_null
    //   9: astore_1
    //   10: aconst_null
    //   11: astore_3
    //   12: new 42	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   19: astore 5
    //   21: new 48	java/net/URL
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 51	java/net/URL:<init>	(Ljava/lang/String;)V
    //   29: invokevirtual 55	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   32: checkcast 57	java/net/HttpURLConnection
    //   35: astore_0
    //   36: aload_0
    //   37: ifnull +117 -> 154
    //   40: aload_0
    //   41: invokevirtual 60	java/net/HttpURLConnection:connect	()V
    //   44: aload_0
    //   45: invokevirtual 64	java/net/HttpURLConnection:getResponseCode	()I
    //   48: sipush 200
    //   51: if_icmpne +103 -> 154
    //   54: aload_0
    //   55: invokevirtual 68	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   58: astore_1
    //   59: aload_1
    //   60: ifnull +94 -> 154
    //   63: new 70	java/io/BufferedReader
    //   66: dup
    //   67: new 72	java/io/InputStreamReader
    //   70: dup
    //   71: aload_1
    //   72: invokespecial 75	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   75: invokespecial 78	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   78: astore_2
    //   79: aload_2
    //   80: invokevirtual 82	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   83: astore_3
    //   84: aload_3
    //   85: ifnull +61 -> 146
    //   88: aload 5
    //   90: aload_3
    //   91: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: goto -16 -> 79
    //   98: astore_2
    //   99: aload_0
    //   100: astore_1
    //   101: ldc 88
    //   103: new 42	java/lang/StringBuilder
    //   106: dup
    //   107: ldc 90
    //   109: invokespecial 91	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   112: aload_2
    //   113: invokevirtual 94	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   116: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 102	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   125: aload_0
    //   126: ifnull +7 -> 133
    //   129: aload_0
    //   130: invokevirtual 105	java/net/HttpURLConnection:disconnect	()V
    //   133: aload 5
    //   135: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: astore_0
    //   139: ldc 40
    //   141: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   144: aload_0
    //   145: areturn
    //   146: aload_2
    //   147: invokevirtual 108	java/io/BufferedReader:close	()V
    //   150: aload_1
    //   151: invokevirtual 111	java/io/InputStream:close	()V
    //   154: aload_0
    //   155: ifnull -22 -> 133
    //   158: aload_0
    //   159: invokevirtual 105	java/net/HttpURLConnection:disconnect	()V
    //   162: goto -29 -> 133
    //   165: astore_2
    //   166: aload 4
    //   168: astore_0
    //   169: aload_0
    //   170: astore_1
    //   171: ldc 88
    //   173: new 42	java/lang/StringBuilder
    //   176: dup
    //   177: ldc 90
    //   179: invokespecial 91	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   182: aload_2
    //   183: invokevirtual 112	java/io/IOException:getMessage	()Ljava/lang/String;
    //   186: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokestatic 102	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   195: aload_0
    //   196: ifnull -63 -> 133
    //   199: aload_0
    //   200: invokevirtual 105	java/net/HttpURLConnection:disconnect	()V
    //   203: goto -70 -> 133
    //   206: astore_0
    //   207: aload_1
    //   208: ifnull +7 -> 215
    //   211: aload_1
    //   212: invokevirtual 105	java/net/HttpURLConnection:disconnect	()V
    //   215: ldc 40
    //   217: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   220: aload_0
    //   221: athrow
    //   222: astore_2
    //   223: aload_0
    //   224: astore_1
    //   225: aload_2
    //   226: astore_0
    //   227: goto -20 -> 207
    //   230: astore_2
    //   231: goto -62 -> 169
    //   234: astore_2
    //   235: aload_3
    //   236: astore_0
    //   237: goto -138 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	paramString	java.lang.String
    //   9	216	1	localObject1	Object
    //   78	2	2	localBufferedReader	java.io.BufferedReader
    //   98	49	2	localMalformedURLException1	java.net.MalformedURLException
    //   165	18	2	localIOException1	java.io.IOException
    //   222	4	2	localObject2	Object
    //   230	1	2	localIOException2	java.io.IOException
    //   234	1	2	localMalformedURLException2	java.net.MalformedURLException
    //   11	225	3	str	java.lang.String
    //   6	161	4	localObject3	Object
    //   19	115	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   40	59	98	java/net/MalformedURLException
    //   63	79	98	java/net/MalformedURLException
    //   79	84	98	java/net/MalformedURLException
    //   88	95	98	java/net/MalformedURLException
    //   146	154	98	java/net/MalformedURLException
    //   21	36	165	java/io/IOException
    //   21	36	206	finally
    //   101	125	206	finally
    //   171	195	206	finally
    //   40	59	222	finally
    //   63	79	222	finally
    //   79	84	222	finally
    //   88	95	222	finally
    //   146	154	222	finally
    //   40	59	230	java/io/IOException
    //   63	79	230	java/io/IOException
    //   79	84	230	java/io/IOException
    //   88	95	230	java/io/IOException
    //   146	154	230	java/io/IOException
    //   21	36	234	java/net/MalformedURLException
  }
  
  public static MultiProcessMMKV dbA()
  {
    AppMethodBeat.i(255439);
    Object localObject = new StringBuilder("mmkv_name_edge_computing_cache_");
    d.dgX();
    localObject = MultiProcessMMKV.getMMKV(d.getUin());
    AppMethodBeat.o(255439);
    return localObject;
  }
  
  public static MultiProcessMMKV dbB()
  {
    AppMethodBeat.i(255440);
    Object localObject = new StringBuilder("mmkv_name_edge_computing_instant_cache_");
    d.dgX();
    localObject = MultiProcessMMKV.getMMKV(d.getUin());
    AppMethodBeat.o(255440);
    return localObject;
  }
  
  public static MultiProcessMMKV dbC()
  {
    AppMethodBeat.i(255441);
    Object localObject = new StringBuilder("mmkv_name_edge_computing_config_");
    d.dgX();
    localObject = MultiProcessMMKV.getMMKV(d.getUin());
    AppMethodBeat.o(255441);
    return localObject;
  }
  
  public static MultiProcessMMKV dbD()
  {
    AppMethodBeat.i(255443);
    Object localObject = new StringBuilder("mmkv_name_edge_computing_breaker_");
    d.dgX();
    localObject = MultiProcessMMKV.getMMKV(d.getUin());
    AppMethodBeat.o(255443);
    return localObject;
  }
  
  public static MultiProcessMMKV dbE()
  {
    AppMethodBeat.i(255445);
    Object localObject = new StringBuilder("mmkv_name_edge_computing_run_record_");
    d.dgX();
    localObject = MultiProcessMMKV.getMMKV(d.getUin());
    AppMethodBeat.o(255445);
    return localObject;
  }
  
  public static MultiProcessMMKV dbF()
  {
    AppMethodBeat.i(255447);
    Object localObject = new StringBuilder("mmkv_name_edge_computing_realtime_report_");
    d.dgX();
    localObject = MultiProcessMMKV.getMMKV(d.getUin());
    AppMethodBeat.o(255447);
    return localObject;
  }
  
  public static boolean dby()
  {
    AppMethodBeat.i(255435);
    if (wdn == null) {
      wdn = Boolean.valueOf(((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vXz, true));
    }
    if (!wdn.booleanValue())
    {
      Log.i("EdgeComputingUtils", "[EdgeComputingUtils] isOpenEdgeComputing cloudSwitch isClose!");
      AppMethodBeat.o(255435);
      return false;
    }
    AppMethodBeat.o(255435);
    return true;
  }
  
  public static MultiProcessMMKV dbz()
  {
    AppMethodBeat.i(255438);
    Object localObject = new StringBuilder("mmkv_name_edge_computing_default_");
    d.dgX();
    localObject = MultiProcessMMKV.getMMKV(d.getUin());
    AppMethodBeat.o(255438);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.b
 * JD-Core Version:    0.7.0.1
 */