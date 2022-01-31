package com.tencent.d.f;

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
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

public final class d
{
  public static String afJ(String paramString)
  {
    try
    {
      Object localObject = Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class });
      ((Method)localObject).setAccessible(true);
      localObject = (String)((Method)localObject).invoke(null, new Object[] { paramString });
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = "";
      }
      return paramString;
    }
    catch (Throwable paramString)
    {
      h.co(" getBuildPropByReflect: " + paramString);
    }
    return "";
  }
  
  public static int cPa()
  {
    try
    {
      int i = Integer.parseInt(Build.VERSION.SDK);
      return i;
    }
    catch (Throwable localThrowable)
    {
      h.co("getSDKVersion: " + localThrowable);
    }
    return 0;
  }
  
  /* Error */
  public static String cPb()
  {
    // Byte code:
    //   0: new 80	java/io/FileInputStream
    //   3: dup
    //   4: ldc 82
    //   6: invokespecial 83	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   9: astore_0
    //   10: new 85	java/io/BufferedReader
    //   13: dup
    //   14: new 87	java/io/InputStreamReader
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 90	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   22: sipush 8192
    //   25: invokespecial 93	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   28: astore_2
    //   29: new 40	java/lang/StringBuilder
    //   32: dup
    //   33: ldc 38
    //   35: invokespecial 46	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   38: astore_1
    //   39: aload_2
    //   40: invokevirtual 96	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   43: astore_3
    //   44: aload_3
    //   45: ifnull +38 -> 83
    //   48: aload_1
    //   49: aload_3
    //   50: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: goto -15 -> 39
    //   57: astore_3
    //   58: aload_3
    //   59: invokestatic 102	com/tencent/d/f/h:cp	(Ljava/lang/Object;)V
    //   62: aload_2
    //   63: invokevirtual 106	java/io/BufferedReader:close	()V
    //   66: aload_0
    //   67: invokevirtual 109	java/io/InputStream:close	()V
    //   70: aload_1
    //   71: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: areturn
    //   75: astore_0
    //   76: aload_0
    //   77: invokestatic 102	com/tencent/d/f/h:cp	(Ljava/lang/Object;)V
    //   80: ldc 38
    //   82: areturn
    //   83: aload_2
    //   84: invokevirtual 106	java/io/BufferedReader:close	()V
    //   87: aload_0
    //   88: invokevirtual 109	java/io/InputStream:close	()V
    //   91: aload_1
    //   92: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: areturn
    //   96: astore_2
    //   97: aload_2
    //   98: invokestatic 102	com/tencent/d/f/h:cp	(Ljava/lang/Object;)V
    //   101: goto -14 -> 87
    //   104: astore_0
    //   105: aload_0
    //   106: invokestatic 102	com/tencent/d/f/h:cp	(Ljava/lang/Object;)V
    //   109: goto -18 -> 91
    //   112: astore_2
    //   113: aload_2
    //   114: invokestatic 102	com/tencent/d/f/h:cp	(Ljava/lang/Object;)V
    //   117: goto -51 -> 66
    //   120: astore_0
    //   121: aload_0
    //   122: invokestatic 102	com/tencent/d/f/h:cp	(Ljava/lang/Object;)V
    //   125: goto -55 -> 70
    //   128: astore_1
    //   129: aload_2
    //   130: invokevirtual 106	java/io/BufferedReader:close	()V
    //   133: aload_0
    //   134: invokevirtual 109	java/io/InputStream:close	()V
    //   137: aload_1
    //   138: athrow
    //   139: astore_2
    //   140: aload_2
    //   141: invokestatic 102	com/tencent/d/f/h:cp	(Ljava/lang/Object;)V
    //   144: goto -11 -> 133
    //   147: astore_0
    //   148: aload_0
    //   149: invokestatic 102	com/tencent/d/f/h:cp	(Ljava/lang/Object;)V
    //   152: goto -15 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   9	58	0	localFileInputStream	java.io.FileInputStream
    //   75	13	0	localThrowable1	Throwable
    //   104	2	0	localThrowable2	Throwable
    //   120	14	0	localThrowable3	Throwable
    //   147	2	0	localThrowable4	Throwable
    //   38	54	1	localStringBuilder	StringBuilder
    //   128	10	1	localObject	Object
    //   28	56	2	localBufferedReader	java.io.BufferedReader
    //   96	2	2	localThrowable5	Throwable
    //   112	18	2	localThrowable6	Throwable
    //   139	2	2	localThrowable7	Throwable
    //   43	7	3	str	String
    //   57	2	3	localThrowable8	Throwable
    // Exception table:
    //   from	to	target	type
    //   39	44	57	java/lang/Throwable
    //   48	54	57	java/lang/Throwable
    //   0	10	75	java/lang/Throwable
    //   83	87	96	java/lang/Throwable
    //   87	91	104	java/lang/Throwable
    //   62	66	112	java/lang/Throwable
    //   66	70	120	java/lang/Throwable
    //   39	44	128	finally
    //   48	54	128	finally
    //   58	62	128	finally
    //   129	133	139	java/lang/Throwable
    //   133	137	147	java/lang/Throwable
  }
  
  private static String cPc()
  {
    try
    {
      localObject1 = NetworkInterface.getNetworkInterfaces();
      if (localObject1 == null)
      {
        h.co("[tomys] getMac2, itfs is null.");
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
        h.co("getMac2: " + localThrowable);
        String str = "";
      }
    }
    return localObject1;
  }
  
  public static String getIMEI(Context paramContext)
  {
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      h.co("getIMEI: " + paramContext);
    }
    return "";
  }
  
  public static String hA(Context paramContext)
  {
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      h.co("getIMSI: " + paramContext);
    }
    return "";
  }
  
  public static String hB(Context paramContext)
  {
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      h.co("getAndroidId: " + paramContext);
    }
    return "";
  }
  
  public static d.a hC(Context paramContext)
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo == null) || ((localNetworkInfo.getState() != NetworkInfo.State.CONNECTING) && (localNetworkInfo.getState() != NetworkInfo.State.CONNECTED))) {
      return d.a.wOh;
    }
    if (localNetworkInfo.getType() == 1) {
      return d.a.wOe;
    }
    if (localNetworkInfo.getType() == 0)
    {
      if ((Proxy.getDefaultHost() != null) || (Proxy.getHost(paramContext) != null)) {
        return d.a.wOf;
      }
      return d.a.wOg;
    }
    return d.a.wOh;
  }
  
  public static String hD(Context paramContext)
  {
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      if (paramContext == null) {
        break label69;
      }
      paramContext = paramContext.getMacAddress();
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        Object localObject;
        h.co("getMac: " + paramContext);
        label69:
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
      localObject = cPc();
    }
    return localObject;
  }
  
  /* Error */
  public static String oi(boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: iload_0
    //   4: ifeq +136 -> 140
    //   7: ldc_w 299
    //   10: astore_2
    //   11: ldc_w 301
    //   14: astore_1
    //   15: new 85	java/io/BufferedReader
    //   18: dup
    //   19: new 303	java/io/FileReader
    //   22: dup
    //   23: new 40	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   30: aload_2
    //   31: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc_w 305
    //   37: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokespecial 306	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   46: invokespecial 309	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   49: astore_3
    //   50: aload_3
    //   51: invokevirtual 96	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   54: astore 6
    //   56: aload 5
    //   58: astore 4
    //   60: aload 6
    //   62: ifnull +92 -> 154
    //   65: aload 5
    //   67: astore 4
    //   69: aload 6
    //   71: invokevirtual 312	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   74: aload_1
    //   75: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   78: ifeq +76 -> 154
    //   81: new 85	java/io/BufferedReader
    //   84: dup
    //   85: new 303	java/io/FileReader
    //   88: dup
    //   89: new 40	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   96: aload_2
    //   97: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: ldc_w 314
    //   103: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokespecial 306	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   112: invokespecial 309	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   115: astore_1
    //   116: aload_1
    //   117: invokevirtual 96	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   120: astore_2
    //   121: aload_2
    //   122: ifnull +29 -> 151
    //   125: aload_2
    //   126: invokevirtual 317	java/lang/String:trim	()Ljava/lang/String;
    //   129: astore_2
    //   130: aload_3
    //   131: invokevirtual 106	java/io/BufferedReader:close	()V
    //   134: aload_1
    //   135: invokevirtual 106	java/io/BufferedReader:close	()V
    //   138: aload_2
    //   139: areturn
    //   140: ldc_w 319
    //   143: astore_2
    //   144: ldc_w 321
    //   147: astore_1
    //   148: goto -133 -> 15
    //   151: aload_1
    //   152: astore 4
    //   154: aload_3
    //   155: invokevirtual 106	java/io/BufferedReader:close	()V
    //   158: aload 4
    //   160: ifnull +8 -> 168
    //   163: aload 4
    //   165: invokevirtual 106	java/io/BufferedReader:close	()V
    //   168: ldc 38
    //   170: areturn
    //   171: astore_1
    //   172: aconst_null
    //   173: astore_2
    //   174: aconst_null
    //   175: astore_3
    //   176: new 40	java/lang/StringBuilder
    //   179: dup
    //   180: ldc_w 323
    //   183: invokespecial 46	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   186: aload_1
    //   187: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 60	com/tencent/d/f/h:co	(Ljava/lang/Object;)V
    //   196: aload_3
    //   197: ifnull +7 -> 204
    //   200: aload_3
    //   201: invokevirtual 106	java/io/BufferedReader:close	()V
    //   204: aload_2
    //   205: ifnull -37 -> 168
    //   208: aload_2
    //   209: invokevirtual 106	java/io/BufferedReader:close	()V
    //   212: goto -44 -> 168
    //   215: astore_1
    //   216: goto -48 -> 168
    //   219: astore_1
    //   220: aconst_null
    //   221: astore_2
    //   222: aconst_null
    //   223: astore_3
    //   224: aload_3
    //   225: ifnull +7 -> 232
    //   228: aload_3
    //   229: invokevirtual 106	java/io/BufferedReader:close	()V
    //   232: aload_2
    //   233: ifnull +7 -> 240
    //   236: aload_2
    //   237: invokevirtual 106	java/io/BufferedReader:close	()V
    //   240: aload_1
    //   241: athrow
    //   242: astore_3
    //   243: goto -109 -> 134
    //   246: astore_1
    //   247: aload_2
    //   248: areturn
    //   249: astore_1
    //   250: goto -92 -> 158
    //   253: astore_1
    //   254: goto -86 -> 168
    //   257: astore_1
    //   258: goto -54 -> 204
    //   261: astore_3
    //   262: goto -30 -> 232
    //   265: astore_2
    //   266: goto -26 -> 240
    //   269: astore_1
    //   270: aconst_null
    //   271: astore_2
    //   272: goto -48 -> 224
    //   275: astore 4
    //   277: aload_1
    //   278: astore_2
    //   279: aload 4
    //   281: astore_1
    //   282: goto -58 -> 224
    //   285: astore_1
    //   286: goto -62 -> 224
    //   289: astore_1
    //   290: aconst_null
    //   291: astore_2
    //   292: goto -116 -> 176
    //   295: astore 4
    //   297: aload_1
    //   298: astore_2
    //   299: aload 4
    //   301: astore_1
    //   302: goto -126 -> 176
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	305	0	paramBoolean	boolean
    //   14	138	1	localObject1	Object
    //   171	16	1	localThrowable1	Throwable
    //   215	1	1	localIOException1	java.io.IOException
    //   219	22	1	localObject2	Object
    //   246	1	1	localIOException2	java.io.IOException
    //   249	1	1	localIOException3	java.io.IOException
    //   253	1	1	localIOException4	java.io.IOException
    //   257	1	1	localIOException5	java.io.IOException
    //   269	9	1	localObject3	Object
    //   281	1	1	localObject4	Object
    //   285	1	1	localObject5	Object
    //   289	9	1	localThrowable2	Throwable
    //   301	1	1	localObject6	Object
    //   10	238	2	str1	String
    //   265	1	2	localIOException6	java.io.IOException
    //   271	28	2	localObject7	Object
    //   49	180	3	localBufferedReader	java.io.BufferedReader
    //   242	1	3	localIOException7	java.io.IOException
    //   261	1	3	localIOException8	java.io.IOException
    //   58	106	4	localObject8	Object
    //   275	5	4	localObject9	Object
    //   295	5	4	localThrowable3	Throwable
    //   1	65	5	localObject10	Object
    //   54	16	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   15	50	171	java/lang/Throwable
    //   208	212	215	java/io/IOException
    //   15	50	219	finally
    //   130	134	242	java/io/IOException
    //   134	138	246	java/io/IOException
    //   154	158	249	java/io/IOException
    //   163	168	253	java/io/IOException
    //   200	204	257	java/io/IOException
    //   228	232	261	java/io/IOException
    //   236	240	265	java/io/IOException
    //   50	56	269	finally
    //   69	116	269	finally
    //   116	121	275	finally
    //   125	130	275	finally
    //   176	196	285	finally
    //   50	56	289	java/lang/Throwable
    //   69	116	289	java/lang/Throwable
    //   116	121	295	java/lang/Throwable
    //   125	130	295	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.f.d
 * JD-Core Version:    0.7.0.1
 */