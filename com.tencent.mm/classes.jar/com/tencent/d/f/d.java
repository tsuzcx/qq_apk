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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.reflect.Method;

public final class d
{
  /* Error */
  public static String Ip(boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc 14
    //   5: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: iload_0
    //   9: ifeq +137 -> 146
    //   12: ldc 22
    //   14: astore_2
    //   15: ldc 24
    //   17: astore_1
    //   18: new 26	java/io/BufferedReader
    //   21: dup
    //   22: new 28	java/io/FileReader
    //   25: dup
    //   26: new 30	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   33: aload_2
    //   34: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc 40
    //   39: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokespecial 47	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   48: invokespecial 50	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   51: astore_3
    //   52: aload_3
    //   53: invokevirtual 53	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   56: astore 6
    //   58: aload 5
    //   60: astore 4
    //   62: aload 6
    //   64: ifnull +94 -> 158
    //   67: aload 5
    //   69: astore 4
    //   71: aload 6
    //   73: invokevirtual 58	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   76: aload_1
    //   77: invokevirtual 62	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   80: ifeq +78 -> 158
    //   83: new 26	java/io/BufferedReader
    //   86: dup
    //   87: new 28	java/io/FileReader
    //   90: dup
    //   91: new 30	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   98: aload_2
    //   99: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: ldc 64
    //   104: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokespecial 47	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   113: invokespecial 50	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   116: astore_1
    //   117: aload_1
    //   118: invokevirtual 53	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   121: astore_2
    //   122: aload_2
    //   123: ifnull +32 -> 155
    //   126: aload_2
    //   127: invokevirtual 67	java/lang/String:trim	()Ljava/lang/String;
    //   130: astore_2
    //   131: aload_3
    //   132: invokevirtual 70	java/io/BufferedReader:close	()V
    //   135: aload_1
    //   136: invokevirtual 70	java/io/BufferedReader:close	()V
    //   139: ldc 14
    //   141: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   144: aload_2
    //   145: areturn
    //   146: ldc 75
    //   148: astore_2
    //   149: ldc 77
    //   151: astore_1
    //   152: goto -134 -> 18
    //   155: aload_1
    //   156: astore 4
    //   158: aload_3
    //   159: invokevirtual 70	java/io/BufferedReader:close	()V
    //   162: aload 4
    //   164: ifnull +8 -> 172
    //   167: aload 4
    //   169: invokevirtual 70	java/io/BufferedReader:close	()V
    //   172: ldc 14
    //   174: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   177: ldc 79
    //   179: areturn
    //   180: astore_1
    //   181: aconst_null
    //   182: astore_2
    //   183: aconst_null
    //   184: astore_3
    //   185: ldc 81
    //   187: aload_1
    //   188: invokestatic 85	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   191: invokevirtual 89	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   194: invokestatic 95	com/tencent/d/f/h:eF	(Ljava/lang/Object;)V
    //   197: aload_3
    //   198: ifnull +7 -> 205
    //   201: aload_3
    //   202: invokevirtual 70	java/io/BufferedReader:close	()V
    //   205: aload_2
    //   206: ifnull -34 -> 172
    //   209: aload_2
    //   210: invokevirtual 70	java/io/BufferedReader:close	()V
    //   213: goto -41 -> 172
    //   216: astore_1
    //   217: goto -45 -> 172
    //   220: astore_1
    //   221: aconst_null
    //   222: astore_2
    //   223: aconst_null
    //   224: astore_3
    //   225: aload_3
    //   226: ifnull +7 -> 233
    //   229: aload_3
    //   230: invokevirtual 70	java/io/BufferedReader:close	()V
    //   233: aload_2
    //   234: ifnull +7 -> 241
    //   237: aload_2
    //   238: invokevirtual 70	java/io/BufferedReader:close	()V
    //   241: ldc 14
    //   243: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   246: aload_1
    //   247: athrow
    //   248: astore_3
    //   249: goto -114 -> 135
    //   252: astore_1
    //   253: goto -114 -> 139
    //   256: astore_1
    //   257: goto -95 -> 162
    //   260: astore_1
    //   261: goto -89 -> 172
    //   264: astore_1
    //   265: goto -60 -> 205
    //   268: astore_3
    //   269: goto -36 -> 233
    //   272: astore_2
    //   273: goto -32 -> 241
    //   276: astore_1
    //   277: aconst_null
    //   278: astore_2
    //   279: goto -54 -> 225
    //   282: astore 4
    //   284: aload_1
    //   285: astore_2
    //   286: aload 4
    //   288: astore_1
    //   289: goto -64 -> 225
    //   292: astore_1
    //   293: goto -68 -> 225
    //   296: astore_1
    //   297: aconst_null
    //   298: astore_2
    //   299: goto -114 -> 185
    //   302: astore 4
    //   304: aload_1
    //   305: astore_2
    //   306: aload 4
    //   308: astore_1
    //   309: goto -124 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	paramBoolean	boolean
    //   17	139	1	localObject1	Object
    //   180	8	1	localThrowable1	Throwable
    //   216	1	1	localIOException1	java.io.IOException
    //   220	27	1	localObject2	Object
    //   252	1	1	localIOException2	java.io.IOException
    //   256	1	1	localIOException3	java.io.IOException
    //   260	1	1	localIOException4	java.io.IOException
    //   264	1	1	localIOException5	java.io.IOException
    //   276	9	1	localObject3	Object
    //   288	1	1	localObject4	Object
    //   292	1	1	localObject5	Object
    //   296	9	1	localThrowable2	Throwable
    //   308	1	1	localObject6	Object
    //   14	224	2	str1	String
    //   272	1	2	localIOException6	java.io.IOException
    //   278	28	2	localObject7	Object
    //   51	179	3	localBufferedReader	java.io.BufferedReader
    //   248	1	3	localIOException7	java.io.IOException
    //   268	1	3	localIOException8	java.io.IOException
    //   60	108	4	localObject8	Object
    //   282	5	4	localObject9	Object
    //   302	5	4	localThrowable3	Throwable
    //   1	67	5	localObject10	Object
    //   56	16	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   18	52	180	java/lang/Throwable
    //   209	213	216	java/io/IOException
    //   18	52	220	finally
    //   131	135	248	java/io/IOException
    //   135	139	252	java/io/IOException
    //   158	162	256	java/io/IOException
    //   167	172	260	java/io/IOException
    //   201	205	264	java/io/IOException
    //   229	233	268	java/io/IOException
    //   237	241	272	java/io/IOException
    //   52	58	276	finally
    //   71	117	276	finally
    //   117	122	282	finally
    //   126	131	282	finally
    //   185	197	292	finally
    //   52	58	296	java/lang/Throwable
    //   71	117	296	java/lang/Throwable
    //   117	122	302	java/lang/Throwable
    //   126	131	302	java/lang/Throwable
  }
  
  public static String bCV(String paramString)
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
        h.eF(" getBuildPropByReflect: ".concat(String.valueOf(localThrowable)));
      }
    }
    AppMethodBeat.o(138471);
    return paramString;
  }
  
  public static String getIMEI(Context paramContext)
  {
    AppMethodBeat.i(138464);
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      Log.d("DeviceUtil", "READ_PHONE_STATE.getDeviceId, %s", new Object[] { Util.getStack() });
      paramContext = paramContext.getDeviceId();
      AppMethodBeat.o(138464);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        h.eF("getIMEI: ".concat(String.valueOf(paramContext)));
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
      h.eF("getSDKVersion: ".concat(String.valueOf(localThrowable)));
      AppMethodBeat.o(138466);
    }
    return 0;
  }
  
  /* Error */
  public static String ioo()
  {
    // Byte code:
    //   0: ldc 177
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 179	java/io/FileInputStream
    //   8: dup
    //   9: ldc 181
    //   11: invokespecial 182	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: astore_0
    //   15: new 26	java/io/BufferedReader
    //   18: dup
    //   19: new 184	java/io/InputStreamReader
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 187	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   27: sipush 8192
    //   30: invokespecial 190	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   33: astore_2
    //   34: new 30	java/lang/StringBuilder
    //   37: dup
    //   38: ldc 79
    //   40: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   43: astore_1
    //   44: aload_2
    //   45: invokevirtual 53	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   48: astore_3
    //   49: aload_3
    //   50: ifnull +50 -> 100
    //   53: aload_1
    //   54: aload_3
    //   55: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: goto -15 -> 44
    //   62: astore_3
    //   63: aload_3
    //   64: invokestatic 194	com/tencent/d/f/h:eG	(Ljava/lang/Object;)V
    //   67: aload_2
    //   68: invokevirtual 70	java/io/BufferedReader:close	()V
    //   71: aload_0
    //   72: invokevirtual 197	java/io/InputStream:close	()V
    //   75: aload_1
    //   76: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: astore_0
    //   80: ldc 177
    //   82: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: aload_0
    //   86: areturn
    //   87: astore_0
    //   88: aload_0
    //   89: invokestatic 194	com/tencent/d/f/h:eG	(Ljava/lang/Object;)V
    //   92: ldc 177
    //   94: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: ldc 79
    //   99: areturn
    //   100: aload_2
    //   101: invokevirtual 70	java/io/BufferedReader:close	()V
    //   104: aload_0
    //   105: invokevirtual 197	java/io/InputStream:close	()V
    //   108: aload_1
    //   109: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: astore_0
    //   113: goto -33 -> 80
    //   116: astore_2
    //   117: aload_2
    //   118: invokestatic 194	com/tencent/d/f/h:eG	(Ljava/lang/Object;)V
    //   121: goto -17 -> 104
    //   124: astore_0
    //   125: aload_0
    //   126: invokestatic 194	com/tencent/d/f/h:eG	(Ljava/lang/Object;)V
    //   129: goto -21 -> 108
    //   132: astore_2
    //   133: aload_2
    //   134: invokestatic 194	com/tencent/d/f/h:eG	(Ljava/lang/Object;)V
    //   137: goto -66 -> 71
    //   140: astore_0
    //   141: aload_0
    //   142: invokestatic 194	com/tencent/d/f/h:eG	(Ljava/lang/Object;)V
    //   145: goto -70 -> 75
    //   148: astore_1
    //   149: aload_2
    //   150: invokevirtual 70	java/io/BufferedReader:close	()V
    //   153: aload_0
    //   154: invokevirtual 197	java/io/InputStream:close	()V
    //   157: ldc 177
    //   159: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: aload_1
    //   163: athrow
    //   164: astore_2
    //   165: aload_2
    //   166: invokestatic 194	com/tencent/d/f/h:eG	(Ljava/lang/Object;)V
    //   169: goto -16 -> 153
    //   172: astore_0
    //   173: aload_0
    //   174: invokestatic 194	com/tencent/d/f/h:eG	(Ljava/lang/Object;)V
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
  
  public static String lW(Context paramContext)
  {
    AppMethodBeat.i(138465);
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      Log.d("DeviceUtil", "READ_PHONE_STATE.getSubscriberId, %s", new Object[] { Util.getStack() });
      paramContext = paramContext.getSubscriberId();
      AppMethodBeat.o(138465);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        h.eF("getIMSI: ".concat(String.valueOf(paramContext)));
        paramContext = "";
      }
    }
  }
  
  public static String lX(Context paramContext)
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
      h.eF("getAndroidId: ".concat(String.valueOf(paramContext)));
      AppMethodBeat.o(138467);
    }
    return "";
  }
  
  public static a lY(Context paramContext)
  {
    AppMethodBeat.i(138470);
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo == null) || ((localNetworkInfo.getState() != NetworkInfo.State.CONNECTING) && (localNetworkInfo.getState() != NetworkInfo.State.CONNECTED)))
    {
      paramContext = a.ZqH;
      AppMethodBeat.o(138470);
      return paramContext;
    }
    if (localNetworkInfo.getType() == 1)
    {
      paramContext = a.ZqE;
      AppMethodBeat.o(138470);
      return paramContext;
    }
    if (localNetworkInfo.getType() == 0)
    {
      if ((Proxy.getDefaultHost() != null) || (Proxy.getHost(paramContext) != null))
      {
        paramContext = a.ZqF;
        AppMethodBeat.o(138470);
        return paramContext;
      }
      paramContext = a.ZqG;
      AppMethodBeat.o(138470);
      return paramContext;
    }
    paramContext = a.ZqH;
    AppMethodBeat.o(138470);
    return paramContext;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(138463);
      ZqE = new a("CONN_WIFI", 0);
      ZqF = new a("CONN_CMWAP", 1);
      ZqG = new a("CONN_CMNET", 2);
      ZqH = new a("CONN_NONE", 3);
      ZqI = new a[] { ZqE, ZqF, ZqG, ZqH };
      AppMethodBeat.o(138463);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.f.d
 * JD-Core Version:    0.7.0.1
 */