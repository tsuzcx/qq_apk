package com.tencent.e.f;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Proxy;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

public final class d
{
  public static String awE(String paramString)
  {
    AppMethodBeat.i(114608);
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
        h.cU(" getBuildPropByReflect: ".concat(String.valueOf(localThrowable)));
      }
    }
    AppMethodBeat.o(114608);
    return paramString;
  }
  
  public static int dUQ()
  {
    AppMethodBeat.i(114603);
    try
    {
      int i = Integer.parseInt(Build.VERSION.SDK);
      AppMethodBeat.o(114603);
      return i;
    }
    catch (Throwable localThrowable)
    {
      h.cU("getSDKVersion: ".concat(String.valueOf(localThrowable)));
      AppMethodBeat.o(114603);
    }
    return 0;
  }
  
  /* Error */
  public static String dUR()
  {
    // Byte code:
    //   0: ldc 84
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 86	java/io/FileInputStream
    //   8: dup
    //   9: ldc 88
    //   11: invokespecial 92	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: astore_0
    //   15: new 94	java/io/BufferedReader
    //   18: dup
    //   19: new 96	java/io/InputStreamReader
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 99	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   27: sipush 8192
    //   30: invokespecial 102	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   33: astore_2
    //   34: new 104	java/lang/StringBuilder
    //   37: dup
    //   38: ldc 45
    //   40: invokespecial 105	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   43: astore_1
    //   44: aload_2
    //   45: invokevirtual 108	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   48: astore_3
    //   49: aload_3
    //   50: ifnull +50 -> 100
    //   53: aload_1
    //   54: aload_3
    //   55: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: goto -15 -> 44
    //   62: astore_3
    //   63: aload_3
    //   64: invokestatic 115	com/tencent/e/f/h:cV	(Ljava/lang/Object;)V
    //   67: aload_2
    //   68: invokevirtual 119	java/io/BufferedReader:close	()V
    //   71: aload_0
    //   72: invokevirtual 122	java/io/InputStream:close	()V
    //   75: aload_1
    //   76: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: astore_0
    //   80: ldc 84
    //   82: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: aload_0
    //   86: areturn
    //   87: astore_0
    //   88: aload_0
    //   89: invokestatic 115	com/tencent/e/f/h:cV	(Ljava/lang/Object;)V
    //   92: ldc 84
    //   94: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: ldc 45
    //   99: areturn
    //   100: aload_2
    //   101: invokevirtual 119	java/io/BufferedReader:close	()V
    //   104: aload_0
    //   105: invokevirtual 122	java/io/InputStream:close	()V
    //   108: aload_1
    //   109: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: astore_0
    //   113: goto -33 -> 80
    //   116: astore_2
    //   117: aload_2
    //   118: invokestatic 115	com/tencent/e/f/h:cV	(Ljava/lang/Object;)V
    //   121: goto -17 -> 104
    //   124: astore_0
    //   125: aload_0
    //   126: invokestatic 115	com/tencent/e/f/h:cV	(Ljava/lang/Object;)V
    //   129: goto -21 -> 108
    //   132: astore_2
    //   133: aload_2
    //   134: invokestatic 115	com/tencent/e/f/h:cV	(Ljava/lang/Object;)V
    //   137: goto -66 -> 71
    //   140: astore_0
    //   141: aload_0
    //   142: invokestatic 115	com/tencent/e/f/h:cV	(Ljava/lang/Object;)V
    //   145: goto -70 -> 75
    //   148: astore_1
    //   149: aload_2
    //   150: invokevirtual 119	java/io/BufferedReader:close	()V
    //   153: aload_0
    //   154: invokevirtual 122	java/io/InputStream:close	()V
    //   157: ldc 84
    //   159: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: aload_1
    //   163: athrow
    //   164: astore_2
    //   165: aload_2
    //   166: invokestatic 115	com/tencent/e/f/h:cV	(Ljava/lang/Object;)V
    //   169: goto -16 -> 153
    //   172: astore_0
    //   173: aload_0
    //   174: invokestatic 115	com/tencent/e/f/h:cV	(Ljava/lang/Object;)V
    //   177: goto -20 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   14	72	0	localObject1	Object
    //   87	18	0	localThrowable1	Throwable
    //   112	1	0	str1	String
    //   124	2	0	localThrowable2	Throwable
    //   140	14	0	localThrowable3	Throwable
    //   172	2	0	localThrowable4	Throwable
    //   43	66	1	localStringBuilder	StringBuilder
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
  
  private static String dUS()
  {
    AppMethodBeat.i(114610);
    try
    {
      localObject1 = NetworkInterface.getNetworkInterfaces();
      if (localObject1 == null)
      {
        h.cU("[tomys] getMac2, itfs is null.");
        AppMethodBeat.o(114610);
        return "";
      }
      localObject1 = Collections.list((Enumeration)localObject1).iterator();
      Object localObject2;
      do
      {
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (NetworkInterface)((Iterator)localObject1).next();
        } while (!((NetworkInterface)localObject2).getName().equalsIgnoreCase("wlan0"));
        localObject2 = ((NetworkInterface)localObject2).getHardwareAddress();
      } while (localObject2 == null);
      localObject1 = new StringBuilder();
      int j = localObject2.length;
      int i = 0;
      while (i < j)
      {
        ((StringBuilder)localObject1).append(String.format("%02x:", new Object[] { Byte.valueOf(localObject2[i]) }));
        i += 1;
      }
      if (((StringBuilder)localObject1).length() > 0) {
        ((StringBuilder)localObject1).deleteCharAt(((StringBuilder)localObject1).length() - 1);
      }
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject1;
        h.cU("getMac2: ".concat(String.valueOf(localThrowable)));
        String str = "";
      }
    }
    AppMethodBeat.o(114610);
    return localObject1;
  }
  
  public static String getIMEI(Context paramContext)
  {
    AppMethodBeat.i(114601);
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      AppMethodBeat.o(114601);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        h.cU("getIMEI: ".concat(String.valueOf(paramContext)));
        paramContext = "";
      }
    }
  }
  
  public static String jb(Context paramContext)
  {
    AppMethodBeat.i(114602);
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
      AppMethodBeat.o(114602);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        h.cU("getIMSI: ".concat(String.valueOf(paramContext)));
        paramContext = "";
      }
    }
  }
  
  public static String jc(Context paramContext)
  {
    AppMethodBeat.i(114604);
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      AppMethodBeat.o(114604);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      h.cU("getAndroidId: ".concat(String.valueOf(paramContext)));
      AppMethodBeat.o(114604);
    }
    return "";
  }
  
  public static d.a jd(Context paramContext)
  {
    AppMethodBeat.i(114607);
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo == null) || ((localNetworkInfo.getState() != NetworkInfo.State.CONNECTING) && (localNetworkInfo.getState() != NetworkInfo.State.CONNECTED)))
    {
      paramContext = d.a.BlF;
      AppMethodBeat.o(114607);
      return paramContext;
    }
    if (localNetworkInfo.getType() == 1)
    {
      paramContext = d.a.BlC;
      AppMethodBeat.o(114607);
      return paramContext;
    }
    if (localNetworkInfo.getType() == 0)
    {
      if ((Proxy.getDefaultHost() != null) || (Proxy.getHost(paramContext) != null))
      {
        paramContext = d.a.BlD;
        AppMethodBeat.o(114607);
        return paramContext;
      }
      paramContext = d.a.BlE;
      AppMethodBeat.o(114607);
      return paramContext;
    }
    paramContext = d.a.BlF;
    AppMethodBeat.o(114607);
    return paramContext;
  }
  
  public static String je(Context paramContext)
  {
    AppMethodBeat.i(114609);
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      if (paramContext == null) {
        break label74;
      }
      paramContext = paramContext.getMacAddress();
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        Object localObject;
        h.cU("getMac: ".concat(String.valueOf(paramContext)));
        paramContext = "";
      }
    }
    if (!TextUtils.isEmpty(paramContext))
    {
      localObject = paramContext;
      if (!paramContext.equals("02:00:00:00:00:00")) {}
    }
    else
    {
      localObject = dUS();
    }
    AppMethodBeat.o(114609);
    return localObject;
  }
  
  /* Error */
  public static String rU(boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc_w 319
    //   6: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: iload_0
    //   10: ifeq +142 -> 152
    //   13: ldc_w 321
    //   16: astore_2
    //   17: ldc_w 323
    //   20: astore_1
    //   21: new 94	java/io/BufferedReader
    //   24: dup
    //   25: new 325	java/io/FileReader
    //   28: dup
    //   29: new 104	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   36: aload_2
    //   37: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc_w 327
    //   43: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokespecial 328	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   52: invokespecial 331	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   55: astore_3
    //   56: aload_3
    //   57: invokevirtual 108	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   60: astore 6
    //   62: aload 5
    //   64: astore 4
    //   66: aload 6
    //   68: ifnull +98 -> 166
    //   71: aload 5
    //   73: astore 4
    //   75: aload 6
    //   77: invokevirtual 334	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   80: aload_1
    //   81: invokevirtual 310	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   84: ifeq +82 -> 166
    //   87: new 94	java/io/BufferedReader
    //   90: dup
    //   91: new 325	java/io/FileReader
    //   94: dup
    //   95: new 104	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   102: aload_2
    //   103: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: ldc_w 336
    //   109: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokespecial 328	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   118: invokespecial 331	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   121: astore_1
    //   122: aload_1
    //   123: invokevirtual 108	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   126: astore_2
    //   127: aload_2
    //   128: ifnull +35 -> 163
    //   131: aload_2
    //   132: invokevirtual 339	java/lang/String:trim	()Ljava/lang/String;
    //   135: astore_2
    //   136: aload_3
    //   137: invokevirtual 119	java/io/BufferedReader:close	()V
    //   140: aload_1
    //   141: invokevirtual 119	java/io/BufferedReader:close	()V
    //   144: ldc_w 319
    //   147: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: aload_2
    //   151: areturn
    //   152: ldc_w 341
    //   155: astore_2
    //   156: ldc_w 343
    //   159: astore_1
    //   160: goto -139 -> 21
    //   163: aload_1
    //   164: astore 4
    //   166: aload_3
    //   167: invokevirtual 119	java/io/BufferedReader:close	()V
    //   170: aload 4
    //   172: ifnull +8 -> 180
    //   175: aload 4
    //   177: invokevirtual 119	java/io/BufferedReader:close	()V
    //   180: ldc_w 319
    //   183: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   186: ldc 45
    //   188: areturn
    //   189: astore_1
    //   190: aconst_null
    //   191: astore_2
    //   192: aconst_null
    //   193: astore_3
    //   194: ldc_w 345
    //   197: aload_1
    //   198: invokestatic 54	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   201: invokevirtual 57	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   204: invokestatic 63	com/tencent/e/f/h:cU	(Ljava/lang/Object;)V
    //   207: aload_3
    //   208: ifnull +7 -> 215
    //   211: aload_3
    //   212: invokevirtual 119	java/io/BufferedReader:close	()V
    //   215: aload_2
    //   216: ifnull -36 -> 180
    //   219: aload_2
    //   220: invokevirtual 119	java/io/BufferedReader:close	()V
    //   223: goto -43 -> 180
    //   226: astore_1
    //   227: goto -47 -> 180
    //   230: astore_1
    //   231: aconst_null
    //   232: astore_2
    //   233: aconst_null
    //   234: astore_3
    //   235: aload_3
    //   236: ifnull +7 -> 243
    //   239: aload_3
    //   240: invokevirtual 119	java/io/BufferedReader:close	()V
    //   243: aload_2
    //   244: ifnull +7 -> 251
    //   247: aload_2
    //   248: invokevirtual 119	java/io/BufferedReader:close	()V
    //   251: ldc_w 319
    //   254: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   257: aload_1
    //   258: athrow
    //   259: astore_3
    //   260: goto -120 -> 140
    //   263: astore_1
    //   264: goto -120 -> 144
    //   267: astore_1
    //   268: goto -98 -> 170
    //   271: astore_1
    //   272: goto -92 -> 180
    //   275: astore_1
    //   276: goto -61 -> 215
    //   279: astore_3
    //   280: goto -37 -> 243
    //   283: astore_2
    //   284: goto -33 -> 251
    //   287: astore_1
    //   288: aconst_null
    //   289: astore_2
    //   290: goto -55 -> 235
    //   293: astore 4
    //   295: aload_1
    //   296: astore_2
    //   297: aload 4
    //   299: astore_1
    //   300: goto -65 -> 235
    //   303: astore_1
    //   304: goto -69 -> 235
    //   307: astore_1
    //   308: aconst_null
    //   309: astore_2
    //   310: goto -116 -> 194
    //   313: astore 4
    //   315: aload_1
    //   316: astore_2
    //   317: aload 4
    //   319: astore_1
    //   320: goto -126 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	paramBoolean	boolean
    //   20	144	1	localObject1	Object
    //   189	9	1	localThrowable1	Throwable
    //   226	1	1	localIOException1	java.io.IOException
    //   230	28	1	localObject2	Object
    //   263	1	1	localIOException2	java.io.IOException
    //   267	1	1	localIOException3	java.io.IOException
    //   271	1	1	localIOException4	java.io.IOException
    //   275	1	1	localIOException5	java.io.IOException
    //   287	9	1	localObject3	Object
    //   299	1	1	localObject4	Object
    //   303	1	1	localObject5	Object
    //   307	9	1	localThrowable2	Throwable
    //   319	1	1	localObject6	Object
    //   16	232	2	str1	String
    //   283	1	2	localIOException6	java.io.IOException
    //   289	28	2	localObject7	Object
    //   55	185	3	localBufferedReader	java.io.BufferedReader
    //   259	1	3	localIOException7	java.io.IOException
    //   279	1	3	localIOException8	java.io.IOException
    //   64	112	4	localObject8	Object
    //   293	5	4	localObject9	Object
    //   313	5	4	localThrowable3	Throwable
    //   1	71	5	localObject10	Object
    //   60	16	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   21	56	189	java/lang/Throwable
    //   219	223	226	java/io/IOException
    //   21	56	230	finally
    //   136	140	259	java/io/IOException
    //   140	144	263	java/io/IOException
    //   166	170	267	java/io/IOException
    //   175	180	271	java/io/IOException
    //   211	215	275	java/io/IOException
    //   239	243	279	java/io/IOException
    //   247	251	283	java/io/IOException
    //   56	62	287	finally
    //   75	122	287	finally
    //   122	127	293	finally
    //   131	136	293	finally
    //   194	207	303	finally
    //   56	62	307	java/lang/Throwable
    //   75	122	307	java/lang/Throwable
    //   122	127	313	java/lang/Throwable
    //   131	136	313	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.e.f.d
 * JD-Core Version:    0.7.0.1
 */