package com.tencent.d.f;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Proxy;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.reflect.Method;

public final class d
{
  public static String aZm(String paramString)
  {
    AppMethodBeat.i(138471);
    try
    {
      Object localObject = Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class });
      ((Method)localObject).setAccessible(true);
      localObject = (String)((Method)localObject).invoke(null, new Object[] { paramString });
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = "";
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        paramString = "";
        h.es(" getBuildPropByReflect: ".concat(String.valueOf(localThrowable)));
      }
    }
    AppMethodBeat.o(138471);
    return paramString;
  }
  
  /* Error */
  public static String fUe()
  {
    // Byte code:
    //   0: ldc 67
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 69	java/io/FileInputStream
    //   8: dup
    //   9: ldc 71
    //   11: invokespecial 75	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: astore_0
    //   15: new 77	java/io/BufferedReader
    //   18: dup
    //   19: new 79	java/io/InputStreamReader
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 82	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   27: sipush 8192
    //   30: invokespecial 85	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   33: astore_2
    //   34: new 87	java/lang/StringBuilder
    //   37: dup
    //   38: ldc 45
    //   40: invokespecial 88	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   43: astore_1
    //   44: aload_2
    //   45: invokevirtual 91	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   48: astore_3
    //   49: aload_3
    //   50: ifnull +50 -> 100
    //   53: aload_1
    //   54: aload_3
    //   55: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: goto -15 -> 44
    //   62: astore_3
    //   63: aload_3
    //   64: invokestatic 98	com/tencent/d/f/h:et	(Ljava/lang/Object;)V
    //   67: aload_2
    //   68: invokevirtual 102	java/io/BufferedReader:close	()V
    //   71: aload_0
    //   72: invokevirtual 105	java/io/InputStream:close	()V
    //   75: aload_1
    //   76: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: astore_0
    //   80: ldc 67
    //   82: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: aload_0
    //   86: areturn
    //   87: astore_0
    //   88: aload_0
    //   89: invokestatic 98	com/tencent/d/f/h:et	(Ljava/lang/Object;)V
    //   92: ldc 67
    //   94: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: ldc 45
    //   99: areturn
    //   100: aload_2
    //   101: invokevirtual 102	java/io/BufferedReader:close	()V
    //   104: aload_0
    //   105: invokevirtual 105	java/io/InputStream:close	()V
    //   108: aload_1
    //   109: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: astore_0
    //   113: goto -33 -> 80
    //   116: astore_2
    //   117: aload_2
    //   118: invokestatic 98	com/tencent/d/f/h:et	(Ljava/lang/Object;)V
    //   121: goto -17 -> 104
    //   124: astore_0
    //   125: aload_0
    //   126: invokestatic 98	com/tencent/d/f/h:et	(Ljava/lang/Object;)V
    //   129: goto -21 -> 108
    //   132: astore_2
    //   133: aload_2
    //   134: invokestatic 98	com/tencent/d/f/h:et	(Ljava/lang/Object;)V
    //   137: goto -66 -> 71
    //   140: astore_0
    //   141: aload_0
    //   142: invokestatic 98	com/tencent/d/f/h:et	(Ljava/lang/Object;)V
    //   145: goto -70 -> 75
    //   148: astore_1
    //   149: aload_2
    //   150: invokevirtual 102	java/io/BufferedReader:close	()V
    //   153: aload_0
    //   154: invokevirtual 105	java/io/InputStream:close	()V
    //   157: ldc 67
    //   159: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: aload_1
    //   163: athrow
    //   164: astore_2
    //   165: aload_2
    //   166: invokestatic 98	com/tencent/d/f/h:et	(Ljava/lang/Object;)V
    //   169: goto -16 -> 153
    //   172: astore_0
    //   173: aload_0
    //   174: invokestatic 98	com/tencent/d/f/h:et	(Ljava/lang/Object;)V
    //   177: goto -20 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   14	72	0	localObject1	Object
    //   87	18	0	localThrowable1	Throwable
    //   112	1	0	str1	String
    //   124	2	0	localThrowable2	Throwable
    //   140	14	0	localThrowable3	Throwable
    //   172	2	0	localThrowable4	Throwable
    //   43	66	1	localStringBuilder	java.lang.StringBuilder
    //   148	15	1	localObject2	Object
    //   33	68	2	localBufferedReader	java.io.BufferedReader
    //   116	2	2	localThrowable5	Throwable
    //   132	18	2	localThrowable6	Throwable
    //   164	2	2	localThrowable7	Throwable
    //   48	7	3	str2	String
    //   62	2	3	localThrowable8	Throwable
    // Exception table:
    //   from	to	target	type
    //   44	49	62	java/lang/Throwable
    //   53	59	62	java/lang/Throwable
    //   5	15	87	java/lang/Throwable
    //   100	104	116	java/lang/Throwable
    //   104	108	124	java/lang/Throwable
    //   67	71	132	java/lang/Throwable
    //   71	75	140	java/lang/Throwable
    //   44	49	148	finally
    //   53	59	148	finally
    //   63	67	148	finally
    //   149	153	164	java/lang/Throwable
    //   153	157	172	java/lang/Throwable
  }
  
  public static String getIMEI(Context paramContext)
  {
    AppMethodBeat.i(138464);
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      ad.d("DeviceUtil", "READ_PHONE_STATE.getDeviceId, %s", new Object[] { bt.flS() });
      paramContext = paramContext.getDeviceId();
      AppMethodBeat.o(138464);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        h.es("getIMEI: ".concat(String.valueOf(paramContext)));
        paramContext = "";
      }
    }
  }
  
  public static int getSDKVersion()
  {
    AppMethodBeat.i(138466);
    try
    {
      int i = Integer.parseInt(Build.VERSION.SDK);
      AppMethodBeat.o(138466);
      return i;
    }
    catch (Throwable localThrowable)
    {
      h.es("getSDKVersion: ".concat(String.valueOf(localThrowable)));
      AppMethodBeat.o(138466);
    }
    return 0;
  }
  
  public static String kW(Context paramContext)
  {
    AppMethodBeat.i(138465);
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      ad.d("DeviceUtil", "READ_PHONE_STATE.getSubscriberId, %s", new Object[] { bt.flS() });
      paramContext = paramContext.getSubscriberId();
      AppMethodBeat.o(138465);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        h.es("getIMSI: ".concat(String.valueOf(paramContext)));
        paramContext = "";
      }
    }
  }
  
  public static String kX(Context paramContext)
  {
    AppMethodBeat.i(138467);
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      AppMethodBeat.o(138467);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      h.es("getAndroidId: ".concat(String.valueOf(paramContext)));
      AppMethodBeat.o(138467);
    }
    return "";
  }
  
  public static d.a kY(Context paramContext)
  {
    AppMethodBeat.i(138470);
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo == null) || ((localNetworkInfo.getState() != NetworkInfo.State.CONNECTING) && (localNetworkInfo.getState() != NetworkInfo.State.CONNECTED)))
    {
      paramContext = d.a.LOC;
      AppMethodBeat.o(138470);
      return paramContext;
    }
    if (localNetworkInfo.getType() == 1)
    {
      paramContext = d.a.LOz;
      AppMethodBeat.o(138470);
      return paramContext;
    }
    if (localNetworkInfo.getType() == 0)
    {
      if ((Proxy.getDefaultHost() != null) || (Proxy.getHost(paramContext) != null))
      {
        paramContext = d.a.LOA;
        AppMethodBeat.o(138470);
        return paramContext;
      }
      paramContext = d.a.LOB;
      AppMethodBeat.o(138470);
      return paramContext;
    }
    paramContext = d.a.LOC;
    AppMethodBeat.o(138470);
    return paramContext;
  }
  
  /* Error */
  public static String zq(boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc 239
    //   5: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: iload_0
    //   9: ifeq +138 -> 147
    //   12: ldc 241
    //   14: astore_2
    //   15: ldc 243
    //   17: astore_1
    //   18: new 77	java/io/BufferedReader
    //   21: dup
    //   22: new 245	java/io/FileReader
    //   25: dup
    //   26: new 87	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   33: aload_2
    //   34: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc 249
    //   39: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokespecial 250	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   48: invokespecial 253	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   51: astore_3
    //   52: aload_3
    //   53: invokevirtual 91	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   56: astore 6
    //   58: aload 5
    //   60: astore 4
    //   62: aload 6
    //   64: ifnull +97 -> 161
    //   67: aload 5
    //   69: astore 4
    //   71: aload 6
    //   73: invokevirtual 256	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   76: aload_1
    //   77: invokevirtual 260	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   80: ifeq +81 -> 161
    //   83: new 77	java/io/BufferedReader
    //   86: dup
    //   87: new 245	java/io/FileReader
    //   90: dup
    //   91: new 87	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   98: aload_2
    //   99: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: ldc_w 262
    //   105: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokespecial 250	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   114: invokespecial 253	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   117: astore_1
    //   118: aload_1
    //   119: invokevirtual 91	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   122: astore_2
    //   123: aload_2
    //   124: ifnull +34 -> 158
    //   127: aload_2
    //   128: invokevirtual 265	java/lang/String:trim	()Ljava/lang/String;
    //   131: astore_2
    //   132: aload_3
    //   133: invokevirtual 102	java/io/BufferedReader:close	()V
    //   136: aload_1
    //   137: invokevirtual 102	java/io/BufferedReader:close	()V
    //   140: ldc 239
    //   142: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: aload_2
    //   146: areturn
    //   147: ldc_w 267
    //   150: astore_2
    //   151: ldc_w 269
    //   154: astore_1
    //   155: goto -137 -> 18
    //   158: aload_1
    //   159: astore 4
    //   161: aload_3
    //   162: invokevirtual 102	java/io/BufferedReader:close	()V
    //   165: aload 4
    //   167: ifnull +8 -> 175
    //   170: aload 4
    //   172: invokevirtual 102	java/io/BufferedReader:close	()V
    //   175: ldc 239
    //   177: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   180: ldc 45
    //   182: areturn
    //   183: astore_1
    //   184: aconst_null
    //   185: astore_2
    //   186: aconst_null
    //   187: astore_3
    //   188: ldc_w 271
    //   191: aload_1
    //   192: invokestatic 54	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   195: invokevirtual 57	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   198: invokestatic 63	com/tencent/d/f/h:es	(Ljava/lang/Object;)V
    //   201: aload_3
    //   202: ifnull +7 -> 209
    //   205: aload_3
    //   206: invokevirtual 102	java/io/BufferedReader:close	()V
    //   209: aload_2
    //   210: ifnull -35 -> 175
    //   213: aload_2
    //   214: invokevirtual 102	java/io/BufferedReader:close	()V
    //   217: goto -42 -> 175
    //   220: astore_1
    //   221: goto -46 -> 175
    //   224: astore_1
    //   225: aconst_null
    //   226: astore_2
    //   227: aconst_null
    //   228: astore_3
    //   229: aload_3
    //   230: ifnull +7 -> 237
    //   233: aload_3
    //   234: invokevirtual 102	java/io/BufferedReader:close	()V
    //   237: aload_2
    //   238: ifnull +7 -> 245
    //   241: aload_2
    //   242: invokevirtual 102	java/io/BufferedReader:close	()V
    //   245: ldc 239
    //   247: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   250: aload_1
    //   251: athrow
    //   252: astore_3
    //   253: goto -117 -> 136
    //   256: astore_1
    //   257: goto -117 -> 140
    //   260: astore_1
    //   261: goto -96 -> 165
    //   264: astore_1
    //   265: goto -90 -> 175
    //   268: astore_1
    //   269: goto -60 -> 209
    //   272: astore_3
    //   273: goto -36 -> 237
    //   276: astore_2
    //   277: goto -32 -> 245
    //   280: astore_1
    //   281: aconst_null
    //   282: astore_2
    //   283: goto -54 -> 229
    //   286: astore 4
    //   288: aload_1
    //   289: astore_2
    //   290: aload 4
    //   292: astore_1
    //   293: goto -64 -> 229
    //   296: astore_1
    //   297: goto -68 -> 229
    //   300: astore_1
    //   301: aconst_null
    //   302: astore_2
    //   303: goto -115 -> 188
    //   306: astore 4
    //   308: aload_1
    //   309: astore_2
    //   310: aload 4
    //   312: astore_1
    //   313: goto -125 -> 188
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	316	0	paramBoolean	boolean
    //   17	142	1	localObject1	Object
    //   183	9	1	localThrowable1	Throwable
    //   220	1	1	localIOException1	java.io.IOException
    //   224	27	1	localObject2	Object
    //   256	1	1	localIOException2	java.io.IOException
    //   260	1	1	localIOException3	java.io.IOException
    //   264	1	1	localIOException4	java.io.IOException
    //   268	1	1	localIOException5	java.io.IOException
    //   280	9	1	localObject3	Object
    //   292	1	1	localObject4	Object
    //   296	1	1	localObject5	Object
    //   300	9	1	localThrowable2	Throwable
    //   312	1	1	localObject6	Object
    //   14	228	2	str1	String
    //   276	1	2	localIOException6	java.io.IOException
    //   282	28	2	localObject7	Object
    //   51	183	3	localBufferedReader	java.io.BufferedReader
    //   252	1	3	localIOException7	java.io.IOException
    //   272	1	3	localIOException8	java.io.IOException
    //   60	111	4	localObject8	Object
    //   286	5	4	localObject9	Object
    //   306	5	4	localThrowable3	Throwable
    //   1	67	5	localObject10	Object
    //   56	16	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   18	52	183	java/lang/Throwable
    //   213	217	220	java/io/IOException
    //   18	52	224	finally
    //   132	136	252	java/io/IOException
    //   136	140	256	java/io/IOException
    //   161	165	260	java/io/IOException
    //   170	175	264	java/io/IOException
    //   205	209	268	java/io/IOException
    //   233	237	272	java/io/IOException
    //   241	245	276	java/io/IOException
    //   52	58	280	finally
    //   71	118	280	finally
    //   118	123	286	finally
    //   127	132	286	finally
    //   188	201	296	finally
    //   52	58	300	java/lang/Throwable
    //   71	118	300	java/lang/Throwable
    //   118	123	306	java/lang/Throwable
    //   127	132	306	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.f.d
 * JD-Core Version:    0.7.0.1
 */