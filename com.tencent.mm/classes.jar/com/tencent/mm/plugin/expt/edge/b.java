package com.tencent.mm.plugin.expt.edge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.expt.e.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;

public final class b
{
  private static Boolean zym;
  private static Boolean zyn;
  
  private static boolean anH()
  {
    AppMethodBeat.i(299842);
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger()))
    {
      AppMethodBeat.o(299842);
      return true;
    }
    AppMethodBeat.o(299842);
    return false;
  }
  
  /* Error */
  public static String aqi(String paramString)
  {
    // Byte code:
    //   0: ldc 44
    //   2: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore 4
    //   8: aconst_null
    //   9: astore_1
    //   10: aconst_null
    //   11: astore_3
    //   12: new 46	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   19: astore 5
    //   21: new 52	java/net/URL
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 55	java/net/URL:<init>	(Ljava/lang/String;)V
    //   29: invokevirtual 59	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   32: checkcast 61	java/net/HttpURLConnection
    //   35: astore_0
    //   36: aload_0
    //   37: ifnull +117 -> 154
    //   40: aload_0
    //   41: invokevirtual 64	java/net/HttpURLConnection:connect	()V
    //   44: aload_0
    //   45: invokevirtual 68	java/net/HttpURLConnection:getResponseCode	()I
    //   48: sipush 200
    //   51: if_icmpne +103 -> 154
    //   54: aload_0
    //   55: invokevirtual 72	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   58: astore_1
    //   59: aload_1
    //   60: ifnull +94 -> 154
    //   63: new 74	java/io/BufferedReader
    //   66: dup
    //   67: new 76	java/io/InputStreamReader
    //   70: dup
    //   71: aload_1
    //   72: invokespecial 79	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   75: invokespecial 82	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   78: astore_2
    //   79: aload_2
    //   80: invokevirtual 86	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   83: astore_3
    //   84: aload_3
    //   85: ifnull +61 -> 146
    //   88: aload 5
    //   90: aload_3
    //   91: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: goto -16 -> 79
    //   98: astore_2
    //   99: aload_0
    //   100: astore_1
    //   101: ldc 92
    //   103: new 46	java/lang/StringBuilder
    //   106: dup
    //   107: ldc 94
    //   109: invokespecial 95	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   112: aload_2
    //   113: invokevirtual 98	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   116: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 106	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   125: aload_0
    //   126: ifnull +7 -> 133
    //   129: aload_0
    //   130: invokevirtual 109	java/net/HttpURLConnection:disconnect	()V
    //   133: aload 5
    //   135: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: astore_0
    //   139: ldc 44
    //   141: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   144: aload_0
    //   145: areturn
    //   146: aload_2
    //   147: invokevirtual 112	java/io/BufferedReader:close	()V
    //   150: aload_1
    //   151: invokevirtual 115	java/io/InputStream:close	()V
    //   154: aload_0
    //   155: ifnull -22 -> 133
    //   158: aload_0
    //   159: invokevirtual 109	java/net/HttpURLConnection:disconnect	()V
    //   162: goto -29 -> 133
    //   165: astore_2
    //   166: aload 4
    //   168: astore_0
    //   169: aload_0
    //   170: astore_1
    //   171: ldc 92
    //   173: new 46	java/lang/StringBuilder
    //   176: dup
    //   177: ldc 94
    //   179: invokespecial 95	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   182: aload_2
    //   183: invokevirtual 116	java/io/IOException:getMessage	()Ljava/lang/String;
    //   186: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokestatic 106	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   195: aload_0
    //   196: ifnull -63 -> 133
    //   199: aload_0
    //   200: invokevirtual 109	java/net/HttpURLConnection:disconnect	()V
    //   203: goto -70 -> 133
    //   206: astore_0
    //   207: aload_1
    //   208: ifnull +7 -> 215
    //   211: aload_1
    //   212: invokevirtual 109	java/net/HttpURLConnection:disconnect	()V
    //   215: ldc 44
    //   217: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	240	0	paramString	String
    //   9	216	1	localObject1	Object
    //   78	2	2	localBufferedReader	java.io.BufferedReader
    //   98	49	2	localMalformedURLException1	java.net.MalformedURLException
    //   165	18	2	localIOException1	java.io.IOException
    //   222	4	2	localObject2	Object
    //   230	1	2	localIOException2	java.io.IOException
    //   234	1	2	localMalformedURLException2	java.net.MalformedURLException
    //   11	225	3	str	String
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
  
  public static boolean dHV()
  {
    AppMethodBeat.i(299846);
    if (zym == null)
    {
      zym = Boolean.valueOf(((c)h.ax(c.class)).a(c.a.zqe, true));
      Log.i("EdgeComputingUtils", "[EdgeComputingUtils] isOpenEdgeComputing cloudSwitch : " + zym);
    }
    boolean bool = zym.booleanValue();
    AppMethodBeat.o(299846);
    return bool;
  }
  
  public static MultiProcessMMKV dHW()
  {
    AppMethodBeat.i(299862);
    Object localObject = new StringBuilder("mmkv_name_edge_computing_default_");
    d.dNI();
    localObject = MultiProcessMMKV.getMMKV(d.getUin());
    AppMethodBeat.o(299862);
    return localObject;
  }
  
  public static MultiProcessMMKV dHX()
  {
    AppMethodBeat.i(299867);
    Object localObject = new StringBuilder("mmkv_name_edge_computing_cache_");
    d.dNI();
    localObject = MultiProcessMMKV.getMMKV(d.getUin());
    AppMethodBeat.o(299867);
    return localObject;
  }
  
  public static MultiProcessMMKV dHY()
  {
    AppMethodBeat.i(299869);
    Object localObject = new StringBuilder("mmkv_name_edge_computing_instant_cache_");
    d.dNI();
    localObject = MultiProcessMMKV.getMMKV(d.getUin());
    AppMethodBeat.o(299869);
    return localObject;
  }
  
  public static MultiProcessMMKV dHZ()
  {
    AppMethodBeat.i(299873);
    Object localObject = new StringBuilder("mmkv_name_edge_computing_config_");
    d.dNI();
    localObject = MultiProcessMMKV.getMMKV(d.getUin());
    AppMethodBeat.o(299873);
    return localObject;
  }
  
  public static MultiProcessMMKV dIa()
  {
    AppMethodBeat.i(299876);
    Object localObject = new StringBuilder("mmkv_name_edge_computing_breaker_");
    d.dNI();
    localObject = MultiProcessMMKV.getMMKV(d.getUin());
    AppMethodBeat.o(299876);
    return localObject;
  }
  
  public static MultiProcessMMKV dIb()
  {
    AppMethodBeat.i(299880);
    Object localObject = new StringBuilder("mmkv_name_edge_computing_run_record_");
    d.dNI();
    localObject = MultiProcessMMKV.getMMKV(d.getUin());
    AppMethodBeat.o(299880);
    return localObject;
  }
  
  public static MultiProcessMMKV dIc()
  {
    AppMethodBeat.i(299884);
    Object localObject = new StringBuilder("mmkv_name_edge_computing_realtime_report_");
    d.dNI();
    localObject = MultiProcessMMKV.getMMKV(d.getUin());
    AppMethodBeat.o(299884);
    return localObject;
  }
  
  public static void hf(String paramString1, String paramString2)
  {
    AppMethodBeat.i(299820);
    if (isDebugMode()) {
      Log.i(paramString1, paramString2);
    }
    AppMethodBeat.o(299820);
  }
  
  public static boolean isDebugMode()
  {
    AppMethodBeat.i(299837);
    if (zyn == null)
    {
      zyn = Boolean.valueOf(((c)h.ax(c.class)).a(c.a.zqj, false));
      Log.i("EdgeComputingUtils", "[EdgeComputingUtils] isDebugMode : " + zyn);
    }
    if (anH()) {
      zyn = Boolean.TRUE;
    }
    boolean bool = zyn.booleanValue();
    AppMethodBeat.o(299837);
    return bool;
  }
  
  public static void o(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(299830);
    if (isDebugMode()) {
      Log.i(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(299830);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.edge.b
 * JD-Core Version:    0.7.0.1
 */