package com.dataline.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.Uri;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.DefaultHttpRoutePlanner;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class HttpUtil
{
  private static final Uri a = Uri.parse("content://telephony/carriers/preferapn");
  public static final String a = "wifi";
  
  private static int a()
  {
    int i = -1;
    if (DatalinePlatformUtil.a() < 11) {
      i = Proxy.getDefaultPort();
    }
    String str;
    do
    {
      return i;
      str = System.getProperty("http.proxyPort");
    } while (a(str));
    try
    {
      i = Integer.parseInt(str);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
    }
    return -1;
  }
  
  public static HttpUtil.NetworkProxy a()
  {
    String str;
    if (a())
    {
      str = a();
      if (str != null)
      {
        if (str.equalsIgnoreCase("cmwap")) {
          return new HttpUtil.NetworkProxy("10.0.0.172", 80, null);
        }
        if (str.equalsIgnoreCase("3gwap")) {
          return new HttpUtil.NetworkProxy("10.0.0.172", 80, null);
        }
        if (str.equalsIgnoreCase("uniwap")) {
          return new HttpUtil.NetworkProxy("10.0.0.172", 80, null);
        }
        if (str.equalsIgnoreCase("ctwap")) {
          return new HttpUtil.NetworkProxy("10.0.0.200", 80, null);
        }
      }
    }
    else
    {
      str = b();
      int i = a();
      if ((!a(str)) && (i >= 0)) {
        return new HttpUtil.NetworkProxy(str, i, null);
      }
    }
    return null;
  }
  
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_0
    //   2: invokestatic 98	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   5: astore_1
    //   6: aload_1
    //   7: ifnonnull +5 -> 12
    //   10: aconst_null
    //   11: areturn
    //   12: aload_1
    //   13: ldc 100
    //   15: invokevirtual 106	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   18: checkcast 108	android/net/ConnectivityManager
    //   21: invokevirtual 112	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   24: astore 4
    //   26: aload 4
    //   28: ifnull -18 -> 10
    //   31: aload 4
    //   33: invokevirtual 117	android/net/NetworkInfo:getType	()I
    //   36: iconst_1
    //   37: if_icmpne +19 -> 56
    //   40: ldc 9
    //   42: astore_0
    //   43: aload_0
    //   44: astore_1
    //   45: aload_0
    //   46: ifnull +8 -> 54
    //   49: aload_0
    //   50: invokevirtual 120	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   53: astore_1
    //   54: aload_1
    //   55: areturn
    //   56: aload 4
    //   58: invokestatic 125	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   61: ifeq +159 -> 220
    //   64: invokestatic 32	com/dataline/util/DatalinePlatformUtil:a	()I
    //   67: bipush 17
    //   69: if_icmpge +146 -> 215
    //   72: aload_1
    //   73: invokevirtual 129	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   76: getstatic 21	com/dataline/util/HttpUtil:a	Landroid/net/Uri;
    //   79: aconst_null
    //   80: aconst_null
    //   81: aconst_null
    //   82: aconst_null
    //   83: invokevirtual 135	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   86: astore_2
    //   87: aconst_null
    //   88: astore_0
    //   89: aload_2
    //   90: ifnull +32 -> 122
    //   93: aload_2
    //   94: invokeinterface 140 1 0
    //   99: ifeq +23 -> 122
    //   102: aload_2
    //   103: aload_2
    //   104: ldc 142
    //   106: invokeinterface 145 2 0
    //   111: invokeinterface 149 2 0
    //   116: astore_1
    //   117: aload_1
    //   118: astore_0
    //   119: goto -30 -> 89
    //   122: aload_0
    //   123: astore_1
    //   124: aload_2
    //   125: ifnull +11 -> 136
    //   128: aload_2
    //   129: invokeinterface 152 1 0
    //   134: aload_0
    //   135: astore_1
    //   136: aload_1
    //   137: astore_0
    //   138: aload_1
    //   139: invokestatic 158	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   142: ifeq -99 -> 43
    //   145: aload 4
    //   147: invokevirtual 161	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   150: astore_0
    //   151: goto -108 -> 43
    //   154: astore_1
    //   155: aconst_null
    //   156: astore_2
    //   157: aload_1
    //   158: invokevirtual 162	java/lang/Throwable:printStackTrace	()V
    //   161: aload_2
    //   162: astore_1
    //   163: aload_0
    //   164: ifnull -28 -> 136
    //   167: aload_0
    //   168: invokeinterface 152 1 0
    //   173: aload_2
    //   174: astore_1
    //   175: goto -39 -> 136
    //   178: astore_0
    //   179: aconst_null
    //   180: astore_2
    //   181: aload_2
    //   182: ifnull +9 -> 191
    //   185: aload_2
    //   186: invokeinterface 152 1 0
    //   191: aload_0
    //   192: athrow
    //   193: astore_0
    //   194: goto -13 -> 181
    //   197: astore_1
    //   198: aload_0
    //   199: astore_2
    //   200: aload_1
    //   201: astore_0
    //   202: goto -21 -> 181
    //   205: astore_1
    //   206: aload_2
    //   207: astore_3
    //   208: aload_0
    //   209: astore_2
    //   210: aload_3
    //   211: astore_0
    //   212: goto -55 -> 157
    //   215: aconst_null
    //   216: astore_1
    //   217: goto -81 -> 136
    //   220: aconst_null
    //   221: astore_0
    //   222: goto -179 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	167	0	localObject1	Object
    //   178	14	0	localObject2	Object
    //   193	6	0	localObject3	Object
    //   201	21	0	localObject4	Object
    //   5	134	1	localObject5	Object
    //   154	4	1	localThrowable1	java.lang.Throwable
    //   162	13	1	localObject6	Object
    //   197	4	1	localObject7	Object
    //   205	1	1	localThrowable2	java.lang.Throwable
    //   216	1	1	localObject8	Object
    //   86	124	2	localObject9	Object
    //   207	4	3	localObject10	Object
    //   24	122	4	localNetworkInfo	NetworkInfo
    // Exception table:
    //   from	to	target	type
    //   72	87	154	java/lang/Throwable
    //   72	87	178	finally
    //   93	117	193	finally
    //   157	161	197	finally
    //   93	117	205	java/lang/Throwable
  }
  
  public static HttpClient a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject2 = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout((HttpParams)localObject2, paramInt2);
    HttpConnectionParams.setSoTimeout((HttpParams)localObject2, paramInt3);
    Object localObject1 = new SchemeRegistry();
    ((SchemeRegistry)localObject1).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), paramInt1));
    if (paramBoolean) {}
    for (localObject1 = new ThreadSafeClientConnManager((HttpParams)localObject2, (SchemeRegistry)localObject1);; localObject1 = new SingleClientConnManager((HttpParams)localObject2, (SchemeRegistry)localObject1))
    {
      localObject2 = new DefaultHttpClient((ClientConnectionManager)localObject1, (HttpParams)localObject2);
      ((DefaultHttpClient)localObject2).setRoutePlanner(new DefaultHttpRoutePlanner(((ClientConnectionManager)localObject1).getSchemeRegistry()));
      return localObject2;
    }
  }
  
  public static HttpClient a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    Object localObject2 = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout((HttpParams)localObject2, paramInt1);
    HttpConnectionParams.setSoTimeout((HttpParams)localObject2, paramInt2);
    if (paramBoolean2 == true) {
      return new DefaultHttpClient((HttpParams)localObject2);
    }
    Object localObject1 = new SchemeRegistry();
    ((SchemeRegistry)localObject1).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    try
    {
      ((SchemeRegistry)localObject1).register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
      if (paramBoolean1)
      {
        localObject1 = new ThreadSafeClientConnManager((HttpParams)localObject2, (SchemeRegistry)localObject1);
        localObject2 = new DefaultHttpClient((ClientConnectionManager)localObject1, (HttpParams)localObject2);
        ((DefaultHttpClient)localObject2).setRoutePlanner(new DefaultHttpRoutePlanner(((ClientConnectionManager)localObject1).getSchemeRegistry()));
        return localObject2;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        localObject1 = new SingleClientConnManager((HttpParams)localObject2, (SchemeRegistry)localObject1);
      }
    }
  }
  
  public static boolean a()
  {
    Object localObject = BaseApplication.getContext();
    if (localObject == null) {
      return false;
    }
    localObject = ((ConnectivityManager)((Context)localObject).getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localObject != null) && (NetworkUtil.a((NetworkInfo)localObject))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  private static String b()
  {
    if (DatalinePlatformUtil.a() < 11) {
      return Proxy.getDefaultHost();
    }
    return System.getProperty("http.proxyHost");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.dataline.util.HttpUtil
 * JD-Core Version:    0.7.0.1
 */