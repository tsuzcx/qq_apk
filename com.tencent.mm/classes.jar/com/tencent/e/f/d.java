package com.tencent.e.f;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Proxy;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.reflect.Method;

public final class d
{
  /* Error */
  public static String Or(boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc 12
    //   5: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: iload_0
    //   9: ifeq +138 -> 147
    //   12: ldc 20
    //   14: astore_2
    //   15: ldc 22
    //   17: astore_1
    //   18: new 24	java/io/BufferedReader
    //   21: dup
    //   22: new 26	java/io/FileReader
    //   25: dup
    //   26: new 28	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   33: aload_2
    //   34: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc 38
    //   39: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokespecial 45	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   48: invokespecial 48	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   51: astore 4
    //   53: aload 4
    //   55: invokevirtual 51	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   58: astore 6
    //   60: aload 5
    //   62: astore_3
    //   63: aload 6
    //   65: ifnull +93 -> 158
    //   68: aload 5
    //   70: astore_3
    //   71: aload 6
    //   73: invokevirtual 56	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   76: aload_1
    //   77: invokevirtual 60	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   80: ifeq +78 -> 158
    //   83: new 24	java/io/BufferedReader
    //   86: dup
    //   87: new 26	java/io/FileReader
    //   90: dup
    //   91: new 28	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   98: aload_2
    //   99: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: ldc 62
    //   104: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokespecial 45	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   113: invokespecial 48	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   116: astore_1
    //   117: aload_1
    //   118: invokevirtual 51	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   121: astore_2
    //   122: aload_2
    //   123: ifnull +33 -> 156
    //   126: aload_2
    //   127: invokevirtual 65	java/lang/String:trim	()Ljava/lang/String;
    //   130: astore_2
    //   131: aload 4
    //   133: invokevirtual 68	java/io/BufferedReader:close	()V
    //   136: aload_1
    //   137: invokevirtual 68	java/io/BufferedReader:close	()V
    //   140: ldc 12
    //   142: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: aload_2
    //   146: areturn
    //   147: ldc 73
    //   149: astore_2
    //   150: ldc 75
    //   152: astore_1
    //   153: goto -135 -> 18
    //   156: aload_1
    //   157: astore_3
    //   158: aload 4
    //   160: invokevirtual 68	java/io/BufferedReader:close	()V
    //   163: aload_3
    //   164: ifnull +7 -> 171
    //   167: aload_3
    //   168: invokevirtual 68	java/io/BufferedReader:close	()V
    //   171: ldc 12
    //   173: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   176: ldc 77
    //   178: areturn
    //   179: astore_2
    //   180: aconst_null
    //   181: astore_1
    //   182: aconst_null
    //   183: astore_3
    //   184: ldc 79
    //   186: aload_2
    //   187: invokestatic 83	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   190: invokevirtual 87	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   193: invokestatic 93	com/tencent/e/f/h:hd	(Ljava/lang/Object;)V
    //   196: aload_3
    //   197: ifnull +7 -> 204
    //   200: aload_3
    //   201: invokevirtual 68	java/io/BufferedReader:close	()V
    //   204: aload_1
    //   205: ifnull -34 -> 171
    //   208: aload_1
    //   209: invokevirtual 68	java/io/BufferedReader:close	()V
    //   212: goto -41 -> 171
    //   215: astore_1
    //   216: goto -45 -> 171
    //   219: astore_2
    //   220: aload_3
    //   221: ifnull +7 -> 228
    //   224: aload_3
    //   225: invokevirtual 68	java/io/BufferedReader:close	()V
    //   228: aload_1
    //   229: ifnull +7 -> 236
    //   232: aload_1
    //   233: invokevirtual 68	java/io/BufferedReader:close	()V
    //   236: ldc 12
    //   238: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   241: aload_2
    //   242: athrow
    //   243: astore_3
    //   244: goto -108 -> 136
    //   247: astore_1
    //   248: goto -108 -> 140
    //   251: astore_1
    //   252: goto -89 -> 163
    //   255: astore_1
    //   256: goto -85 -> 171
    //   259: astore_2
    //   260: goto -56 -> 204
    //   263: astore_3
    //   264: goto -36 -> 228
    //   267: astore_1
    //   268: goto -32 -> 236
    //   271: astore_2
    //   272: aconst_null
    //   273: astore_1
    //   274: aload 4
    //   276: astore_3
    //   277: goto -93 -> 184
    //   280: astore_2
    //   281: aload 4
    //   283: astore_3
    //   284: goto -100 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	paramBoolean	boolean
    //   17	192	1	localObject1	Object
    //   215	18	1	localIOException1	java.io.IOException
    //   247	1	1	localIOException2	java.io.IOException
    //   251	1	1	localIOException3	java.io.IOException
    //   255	1	1	localIOException4	java.io.IOException
    //   267	1	1	localIOException5	java.io.IOException
    //   273	1	1	localObject2	Object
    //   14	136	2	str1	String
    //   179	8	2	localObject3	Object
    //   219	23	2	localObject4	Object
    //   259	1	2	localIOException6	java.io.IOException
    //   271	1	2	localObject5	Object
    //   280	1	2	localObject6	Object
    //   62	163	3	localObject7	Object
    //   243	1	3	localIOException7	java.io.IOException
    //   263	1	3	localIOException8	java.io.IOException
    //   276	8	3	localBufferedReader1	java.io.BufferedReader
    //   51	231	4	localBufferedReader2	java.io.BufferedReader
    //   1	68	5	localObject8	Object
    //   58	14	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   18	53	179	finally
    //   208	212	215	java/io/IOException
    //   184	196	219	finally
    //   131	136	243	java/io/IOException
    //   136	140	247	java/io/IOException
    //   158	163	251	java/io/IOException
    //   167	171	255	java/io/IOException
    //   200	204	259	java/io/IOException
    //   224	228	263	java/io/IOException
    //   232	236	267	java/io/IOException
    //   53	60	271	finally
    //   71	117	271	finally
    //   117	122	280	finally
    //   126	131	280	finally
  }
  
  public static String bFA(String paramString)
  {
    AppMethodBeat.i(138471);
    try
    {
      Object localObject1 = Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class });
      ((Method)localObject1).setAccessible(true);
      localObject1 = (String)((Method)localObject1).invoke(null, new Object[] { paramString });
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = "";
      }
    }
    finally
    {
      for (;;)
      {
        paramString = "";
        h.hd(" getBuildPropByReflect: ".concat(String.valueOf(localObject2)));
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
      paramContext = (String)a.a(paramContext, "com/tencent/riskscanner/utils/DeviceUtil", "getIMEI", "(Landroid/content/Context;)Ljava/lang/String;", "android/telephony/TelephonyManager", "getDeviceId", "()Ljava/lang/String;");
      AppMethodBeat.o(138464);
      return paramContext;
    }
    finally
    {
      for (;;)
      {
        h.hd("getIMEI: ".concat(String.valueOf(paramContext)));
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
    finally
    {
      h.hd("getSDKVersion: ".concat(String.valueOf(localObject)));
      AppMethodBeat.o(138466);
    }
    return 0;
  }
  
  public static String jXA()
  {
    AppMethodBeat.i(218414);
    try
    {
      String str = q.getAndroidId();
      AppMethodBeat.o(218414);
      return str;
    }
    finally
    {
      h.hd("getAndroidId: ".concat(String.valueOf(localObject)));
      AppMethodBeat.o(218414);
    }
    return "";
  }
  
  /* Error */
  public static String jXB()
  {
    // Byte code:
    //   0: ldc 194
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 196	java/io/FileInputStream
    //   8: dup
    //   9: ldc 198
    //   11: invokespecial 199	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: astore_0
    //   15: new 24	java/io/BufferedReader
    //   18: dup
    //   19: new 201	java/io/InputStreamReader
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 204	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   27: sipush 8192
    //   30: invokespecial 207	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   33: astore_2
    //   34: new 28	java/lang/StringBuilder
    //   37: dup
    //   38: ldc 77
    //   40: invokespecial 208	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   43: astore_1
    //   44: aload_2
    //   45: invokevirtual 51	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   48: astore_3
    //   49: aload_3
    //   50: ifnull +50 -> 100
    //   53: aload_1
    //   54: aload_3
    //   55: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: goto -15 -> 44
    //   62: astore_3
    //   63: aload_3
    //   64: invokestatic 211	com/tencent/e/f/h:he	(Ljava/lang/Object;)V
    //   67: aload_2
    //   68: invokevirtual 68	java/io/BufferedReader:close	()V
    //   71: aload_0
    //   72: invokevirtual 214	java/io/InputStream:close	()V
    //   75: aload_1
    //   76: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: astore_0
    //   80: ldc 194
    //   82: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: aload_0
    //   86: areturn
    //   87: astore_0
    //   88: aload_0
    //   89: invokestatic 211	com/tencent/e/f/h:he	(Ljava/lang/Object;)V
    //   92: ldc 194
    //   94: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: ldc 77
    //   99: areturn
    //   100: aload_2
    //   101: invokevirtual 68	java/io/BufferedReader:close	()V
    //   104: aload_0
    //   105: invokevirtual 214	java/io/InputStream:close	()V
    //   108: aload_1
    //   109: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: astore_0
    //   113: goto -33 -> 80
    //   116: astore_2
    //   117: aload_2
    //   118: invokestatic 211	com/tencent/e/f/h:he	(Ljava/lang/Object;)V
    //   121: goto -17 -> 104
    //   124: astore_0
    //   125: aload_0
    //   126: invokestatic 211	com/tencent/e/f/h:he	(Ljava/lang/Object;)V
    //   129: goto -21 -> 108
    //   132: astore_2
    //   133: aload_2
    //   134: invokestatic 211	com/tencent/e/f/h:he	(Ljava/lang/Object;)V
    //   137: goto -66 -> 71
    //   140: astore_0
    //   141: aload_0
    //   142: invokestatic 211	com/tencent/e/f/h:he	(Ljava/lang/Object;)V
    //   145: goto -70 -> 75
    //   148: astore_1
    //   149: aload_2
    //   150: invokevirtual 68	java/io/BufferedReader:close	()V
    //   153: aload_0
    //   154: invokevirtual 214	java/io/InputStream:close	()V
    //   157: ldc 194
    //   159: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: aload_1
    //   163: athrow
    //   164: astore_2
    //   165: aload_2
    //   166: invokestatic 211	com/tencent/e/f/h:he	(Ljava/lang/Object;)V
    //   169: goto -16 -> 153
    //   172: astore_0
    //   173: aload_0
    //   174: invokestatic 211	com/tencent/e/f/h:he	(Ljava/lang/Object;)V
    //   177: goto -20 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   14	72	0	localObject1	Object
    //   87	18	0	localObject2	Object
    //   112	1	0	str1	String
    //   124	2	0	localObject3	Object
    //   140	14	0	localObject4	Object
    //   172	2	0	localObject5	Object
    //   43	66	1	localStringBuilder	java.lang.StringBuilder
    //   148	15	1	localObject6	Object
    //   33	68	2	localBufferedReader	java.io.BufferedReader
    //   116	2	2	localObject7	Object
    //   132	18	2	localObject8	Object
    //   164	2	2	localObject9	Object
    //   48	7	3	str2	String
    //   62	2	3	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   44	49	62	finally
    //   53	59	62	finally
    //   5	15	87	finally
    //   100	104	116	finally
    //   104	108	124	finally
    //   67	71	132	finally
    //   71	75	140	finally
    //   63	67	148	finally
    //   149	153	164	finally
    //   153	157	172	finally
  }
  
  public static String oc(Context paramContext)
  {
    AppMethodBeat.i(138465);
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      Log.d("DeviceUtil", "READ_PHONE_STATE.getSubscriberId, %s", new Object[] { Util.getStack() });
      paramContext = (String)a.a(paramContext, "com/tencent/riskscanner/utils/DeviceUtil", "getIMSI", "(Landroid/content/Context;)Ljava/lang/String;", "android/telephony/TelephonyManager", "getSubscriberId", "()Ljava/lang/String;");
      AppMethodBeat.o(138465);
      return paramContext;
    }
    finally
    {
      for (;;)
      {
        h.hd("getIMSI: ".concat(String.valueOf(paramContext)));
        paramContext = "";
      }
    }
  }
  
  public static a od(Context paramContext)
  {
    AppMethodBeat.i(138470);
    NetworkInfo localNetworkInfo = ((ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo == null) || ((localNetworkInfo.getState() != NetworkInfo.State.CONNECTING) && (localNetworkInfo.getState() != NetworkInfo.State.CONNECTED)))
    {
      paramContext = a.ahvo;
      AppMethodBeat.o(138470);
      return paramContext;
    }
    if (localNetworkInfo.getType() == 1)
    {
      paramContext = a.ahvl;
      AppMethodBeat.o(138470);
      return paramContext;
    }
    if (localNetworkInfo.getType() == 0)
    {
      if ((Proxy.getDefaultHost() != null) || (Proxy.getHost(paramContext) != null))
      {
        paramContext = a.ahvm;
        AppMethodBeat.o(138470);
        return paramContext;
      }
      paramContext = a.ahvn;
      AppMethodBeat.o(138470);
      return paramContext;
    }
    paramContext = a.ahvo;
    AppMethodBeat.o(138470);
    return paramContext;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(138463);
      ahvl = new a("CONN_WIFI", 0);
      ahvm = new a("CONN_CMWAP", 1);
      ahvn = new a("CONN_CMNET", 2);
      ahvo = new a("CONN_NONE", 3);
      ahvp = new a[] { ahvl, ahvm, ahvn, ahvo };
      AppMethodBeat.o(138463);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.e.f.d
 * JD-Core Version:    0.7.0.1
 */