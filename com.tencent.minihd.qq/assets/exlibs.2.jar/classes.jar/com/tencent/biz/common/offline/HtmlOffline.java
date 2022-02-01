package com.tencent.biz.common.offline;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import cdj;
import cdk;
import cdl;
import cdm;
import cdn;
import cdo;
import cdp;
import cdq;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.download.OfflineDownloader;
import com.tencent.biz.common.util.LoadedCallBack;
import com.tencent.biz.common.util.OfflineSecurity;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.biz.webviewplugin.MyFileInputStream;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.base.BspatchUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HtmlOffline
{
  public static final int A = 13;
  public static final int B = 0;
  public static final int C = 1;
  public static final int D = 0;
  public static final int E = 1;
  public static final int F = 2;
  public static final int G = 3;
  public static final int H = 0;
  public static final int I = 1;
  protected static final int J = 0;
  public static final int a = 0;
  private static Context a;
  public static final String a = "updateNotification";
  protected static ArrayList a;
  public static HashMap a;
  protected static final String[] a;
  public static final int b = 1;
  public static final String b = "wording";
  protected static final String[] b = { "0", "1" };
  public static final int c = 2;
  public static final String c = "wifiUpdatingText";
  public static final int d = 3;
  public static final String d = "nonWifiUpdatingText";
  public static final int e = 4;
  public static final String e = "updateCompletedText";
  public static final int f = 5;
  public static final String f = "expirelist";
  public static final int g = 6;
  public static final String g = "bid";
  public static final int h = 7;
  public static final String h = "expired";
  public static final int i = 8;
  public static final String i = "tencent/MobileQQ/qbiz/";
  public static final int j = 13;
  public static final String j = "tencent/MobileQQ/qbiz/html5/";
  public static final int k = 9;
  protected static String k = "qbiz/";
  public static final int l = -1;
  public static String l;
  protected static final int m = 30;
  protected static String m;
  protected static final int n = 1;
  protected static String n;
  protected static final int o = 5;
  protected static String o;
  protected static final int p = 60;
  protected static final String p = "config.json";
  public static final int q = 0;
  protected static final String q = "local_html";
  public static final int r = 2;
  protected static final String r = "https://offline.qq.com/offline/check";
  public static final int s = 3;
  protected static final String s = "HtmlCheckUpdate";
  public static final int t = 4;
  public static final String t = "QQBrowserOffline";
  public static final int u = 5;
  protected static final String u = "OfflineCheckFile";
  public static final int v = 6;
  public static final int w = 7;
  public static final int x = 8;
  public static final int y = 9;
  public static final int z = 10;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "config.json", "verify.json", "verify.signature" };
  }
  
  public static int a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("local_html", 0).getInt("expire_" + paramString, 0);
  }
  
  protected static long a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("local_html", 0).getLong("last_up_" + paramString, 0L);
  }
  
  @SuppressLint({"NewApi"})
  public static WebResourceResponse a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (TextUtils.isEmpty(paramString2)) || (!paramString2.startsWith("http"))) {
      if (QLog.isColorLevel()) {
        QLog.i("HtmlCheckUpdate", 2, "shouldInterceptRequest: businessId null ");
      }
    }
    Object localObject;
    do
    {
      do
      {
        return null;
        localObject = a(paramString1);
      } while (TextUtils.isEmpty((CharSequence)localObject));
      paramString1 = (String)localObject + paramString1;
      paramString2 = g(paramString2);
      paramString1 = paramString1 + "/" + paramString2;
      if (new File(paramString1).exists()) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("HtmlCheckUpdate", 4, "getResponse local file not exists :" + paramString2);
    return null;
    for (;;)
    {
      try
      {
        localObject = new MyFileInputStream(paramString1);
        paramString1 = "text/html";
        if (!paramString2.contains(".css")) {
          break label248;
        }
        paramString1 = "text/css";
        if (QLog.isDevelopLevel()) {
          QLog.i("HtmlCheckUpdate", 4, "getResponse ****************** :" + paramString2);
        }
        return new WebResourceResponse(paramString1, "utf-8", (InputStream)localObject);
      }
      catch (FileNotFoundException paramString1)
      {
        paramString1.printStackTrace();
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i("HtmlCheckUpdate", 4, "getResponse get local file fail:" + paramString2);
      return null;
      label248:
      if (paramString2.contains(".js")) {
        paramString1 = "application/x-javascript";
      } else if ((paramString2.contains(".jpg")) || (paramString2.contains(".gif")) || (paramString2.contains(".png")) || (paramString2.contains(".jpeg"))) {
        paramString1 = "image/*";
      }
    }
  }
  
  public static String a()
  {
    Object localObject2 = null;
    StringBuffer localStringBuffer = new StringBuffer();
    String str;
    if (Environment.getExternalStorageState().equals("mounted"))
    {
      str = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator;
      str = d(str + "tencent/MobileQQ/qbiz/" + "html5/");
      if (!TextUtils.isEmpty(str)) {
        localStringBuffer.append(str);
      }
    }
    if (jdField_a_of_type_AndroidContentContext == null) {
      return null;
    }
    try
    {
      str = jdField_a_of_type_AndroidContentContext.getFilesDir().toString() + File.separator + k;
      if (!TextUtils.isEmpty(str))
      {
        str = d(str + "html5/");
        if (!TextUtils.isEmpty(str))
        {
          if (localStringBuffer.length() > 0) {
            localStringBuffer.append(",");
          }
          localStringBuffer.append(str);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("HtmlCheckUpdate", 2, "getLocalOfflineVersions:" + localStringBuffer.toString());
      }
      return localStringBuffer.toString();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.i("HtmlCheckUpdate", 2, "getLocalOfflineVersions getFilesDir error");
          localObject1 = localObject2;
        }
      }
    }
  }
  
  public static String a(Context paramContext, ArrayList paramArrayList, String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap(paramArrayList.size());
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      Object localObject = a(str);
      if (localObject != null)
      {
        localObject = ((JSONObject)localObject).optString("version");
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localHashMap.put(str, localObject);
        }
      }
      else
      {
        localHashMap.put(str, "0");
      }
    }
    if (localHashMap.size() > 0) {
      return a(paramContext, localHashMap, paramString, paramInt);
    }
    return null;
  }
  
  /* Error */
  public static String a(Context paramContext, HashMap paramHashMap, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload 5
    //   5: astore 4
    //   7: aload_1
    //   8: ifnull +14 -> 22
    //   11: aload_1
    //   12: invokevirtual 331	java/util/HashMap:size	()I
    //   15: ifne +10 -> 25
    //   18: aload 5
    //   20: astore 4
    //   22: aload 4
    //   24: areturn
    //   25: ldc_w 342
    //   28: astore 4
    //   30: aload_0
    //   31: invokevirtual 346	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   34: aload_0
    //   35: invokevirtual 349	android/content/Context:getPackageName	()Ljava/lang/String;
    //   38: iconst_0
    //   39: invokevirtual 355	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   42: getfield 360	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   45: astore 5
    //   47: aload 5
    //   49: astore 4
    //   51: ldc_w 342
    //   54: astore 5
    //   56: getstatic 365	android/os/Build:BRAND	Ljava/lang/String;
    //   59: ldc_w 367
    //   62: invokestatic 373	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   65: astore 6
    //   67: aload 6
    //   69: astore 5
    //   71: ldc_w 342
    //   74: astore 6
    //   76: getstatic 376	android/os/Build:MODEL	Ljava/lang/String;
    //   79: ldc_w 367
    //   82: invokestatic 373	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   85: astore 7
    //   87: aload 7
    //   89: astore 6
    //   91: ldc_w 342
    //   94: astore 7
    //   96: getstatic 381	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   99: ldc_w 367
    //   102: invokestatic 373	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   105: astore 8
    //   107: aload 8
    //   109: astore 7
    //   111: new 243	java/lang/StringBuffer
    //   114: dup
    //   115: ldc 77
    //   117: invokespecial 382	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   120: astore 8
    //   122: aload 8
    //   124: ldc_w 384
    //   127: invokevirtual 272	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   130: aload 4
    //   132: invokevirtual 272	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   135: pop
    //   136: aload 8
    //   138: ldc_w 386
    //   141: invokevirtual 272	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   144: getstatic 389	android/os/Build$VERSION:SDK_INT	I
    //   147: invokevirtual 392	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   150: pop
    //   151: aload 8
    //   153: ldc_w 394
    //   156: invokevirtual 272	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   159: aload 7
    //   161: invokevirtual 272	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   164: pop
    //   165: aload 8
    //   167: ldc_w 396
    //   170: invokevirtual 272	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   173: aload 5
    //   175: invokevirtual 272	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   178: pop
    //   179: aload 8
    //   181: ldc_w 398
    //   184: invokevirtual 272	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   187: aload 6
    //   189: invokevirtual 272	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   192: pop
    //   193: aload 8
    //   195: ldc_w 400
    //   198: invokevirtual 272	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   201: new 125	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   208: iload_3
    //   209: invokevirtual 403	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   212: ldc_w 342
    //   215: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokevirtual 272	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   224: pop
    //   225: aload 8
    //   227: ldc_w 405
    //   230: invokevirtual 272	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   233: pop
    //   234: aload 8
    //   236: ldc_w 407
    //   239: invokevirtual 272	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   242: pop
    //   243: aload 8
    //   245: ldc_w 409
    //   248: invokevirtual 272	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   251: aload_2
    //   252: invokevirtual 272	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   255: pop
    //   256: aload 8
    //   258: ldc_w 411
    //   261: invokevirtual 272	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   264: invokestatic 417	java/lang/System:currentTimeMillis	()J
    //   267: invokevirtual 420	java/lang/StringBuffer:append	(J)Ljava/lang/StringBuffer;
    //   270: pop
    //   271: aload_1
    //   272: invokevirtual 331	java/util/HashMap:size	()I
    //   275: iconst_1
    //   276: if_icmpne +131 -> 407
    //   279: aload_1
    //   280: invokevirtual 424	java/util/HashMap:keySet	()Ljava/util/Set;
    //   283: invokeinterface 427 1 0
    //   288: astore_2
    //   289: aload_2
    //   290: invokeinterface 312 1 0
    //   295: ifeq +48 -> 343
    //   298: aload_2
    //   299: invokeinterface 316 1 0
    //   304: checkcast 100	java/lang/String
    //   307: astore_2
    //   308: aload_1
    //   309: aload_2
    //   310: invokevirtual 431	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   313: checkcast 100	java/lang/String
    //   316: astore_1
    //   317: aload 8
    //   319: ldc_w 433
    //   322: invokevirtual 272	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   325: aload_1
    //   326: invokevirtual 272	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   329: ldc_w 435
    //   332: invokevirtual 272	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   335: aload_2
    //   336: invokevirtual 438	java/lang/String:trim	()Ljava/lang/String;
    //   339: invokevirtual 272	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   342: pop
    //   343: invokestatic 440	com/tencent/biz/common/offline/HtmlOffline:a	()Ljava/lang/String;
    //   346: astore_1
    //   347: aload_1
    //   348: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   351: ifne +19 -> 370
    //   354: aload 8
    //   356: ldc_w 442
    //   359: invokevirtual 272	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   362: aload_1
    //   363: invokestatic 444	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   366: invokevirtual 272	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   369: pop
    //   370: aload_0
    //   371: aload 8
    //   373: invokevirtual 287	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   376: ldc_w 446
    //   379: aconst_null
    //   380: aconst_null
    //   381: invokestatic 451	com/tencent/biz/common/util/HttpUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;)Ljava/lang/String;
    //   384: astore_0
    //   385: aload_0
    //   386: areturn
    //   387: astore 5
    //   389: aload 5
    //   391: invokevirtual 452	android/content/pm/PackageManager$NameNotFoundException:printStackTrace	()V
    //   394: goto -343 -> 51
    //   397: astore 5
    //   399: aload 5
    //   401: invokevirtual 290	java/lang/Exception:printStackTrace	()V
    //   404: goto -353 -> 51
    //   407: aload_1
    //   408: invokevirtual 424	java/util/HashMap:keySet	()Ljava/util/Set;
    //   411: invokeinterface 427 1 0
    //   416: astore_2
    //   417: new 243	java/lang/StringBuffer
    //   420: dup
    //   421: invokespecial 244	java/lang/StringBuffer:<init>	()V
    //   424: astore 4
    //   426: aload_2
    //   427: invokeinterface 312 1 0
    //   432: ifeq +53 -> 485
    //   435: aload_2
    //   436: invokeinterface 316 1 0
    //   441: checkcast 100	java/lang/String
    //   444: astore 5
    //   446: aload_1
    //   447: aload 5
    //   449: invokevirtual 431	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   452: checkcast 100	java/lang/String
    //   455: astore 6
    //   457: aload 4
    //   459: aload 5
    //   461: invokevirtual 272	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   464: ldc_w 454
    //   467: invokevirtual 272	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   470: aload 6
    //   472: invokevirtual 272	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   475: ldc_w 456
    //   478: invokevirtual 272	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   481: pop
    //   482: goto -56 -> 426
    //   485: aload 4
    //   487: invokevirtual 282	java/lang/StringBuffer:length	()I
    //   490: istore_3
    //   491: iload_3
    //   492: iconst_1
    //   493: if_icmple -150 -> 343
    //   496: aload 4
    //   498: iload_3
    //   499: iconst_1
    //   500: isub
    //   501: invokevirtual 459	java/lang/StringBuffer:deleteCharAt	(I)Ljava/lang/StringBuffer;
    //   504: pop
    //   505: aload 8
    //   507: ldc_w 461
    //   510: invokevirtual 272	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   513: aload 4
    //   515: invokevirtual 287	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   518: invokestatic 444	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   521: invokevirtual 272	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   524: pop
    //   525: goto -182 -> 343
    //   528: astore_0
    //   529: aload_0
    //   530: invokevirtual 462	org/apache/http/client/ClientProtocolException:printStackTrace	()V
    //   533: ldc_w 464
    //   536: astore 4
    //   538: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   541: ifeq -519 -> 22
    //   544: ldc 80
    //   546: iconst_2
    //   547: ldc_w 466
    //   550: invokestatic 178	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   553: ldc_w 464
    //   556: areturn
    //   557: astore_0
    //   558: aload_0
    //   559: invokevirtual 467	java/io/IOException:printStackTrace	()V
    //   562: ldc_w 469
    //   565: astore 4
    //   567: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   570: ifeq -548 -> 22
    //   573: ldc 80
    //   575: iconst_2
    //   576: ldc_w 471
    //   579: invokestatic 178	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   582: ldc_w 469
    //   585: areturn
    //   586: astore 8
    //   588: goto -477 -> 111
    //   591: astore 7
    //   593: goto -502 -> 91
    //   596: astore 6
    //   598: goto -527 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	601	0	paramContext	Context
    //   0	601	1	paramHashMap	HashMap
    //   0	601	2	paramString	String
    //   0	601	3	paramInt	int
    //   5	561	4	localObject1	Object
    //   1	173	5	localObject2	Object
    //   387	3	5	localNameNotFoundException	PackageManager.NameNotFoundException
    //   397	3	5	localException1	Exception
    //   444	16	5	str	String
    //   65	406	6	localObject3	Object
    //   596	1	6	localException2	Exception
    //   85	75	7	localObject4	Object
    //   591	1	7	localException3	Exception
    //   105	401	8	localObject5	Object
    //   586	1	8	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   30	47	387	android/content/pm/PackageManager$NameNotFoundException
    //   30	47	397	java/lang/Exception
    //   370	385	528	org/apache/http/client/ClientProtocolException
    //   370	385	557	java/io/IOException
    //   96	107	586	java/lang/Exception
    //   76	87	591	java/lang/Exception
    //   56	67	596	java/lang/Exception
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!a(paramString)) {
      return null;
    }
    if (b(paramString)) {
      return l;
    }
    return n;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return paramString1;
    }
    if (paramString1.contains("#"))
    {
      String[] arrayOfString = paramString1.split("\\#");
      String str = arrayOfString[0];
      paramString1 = "";
      int i1 = 1;
      int i2 = arrayOfString.length;
      while (i1 < i2)
      {
        paramString1 = paramString1 + "#" + arrayOfString[i1];
        i1 += 1;
      }
      if (str.contains("?")) {
        return str.replace("?", new StringBuilder().append("?").append(paramString2).append("&").toString()) + paramString1;
      }
      return str + "?" + paramString2 + paramString1;
    }
    if (paramString1.contains("?")) {
      return paramString1.replace("?", "?" + paramString2 + "&");
    }
    return paramString1 + "?" + paramString2;
  }
  
  public static String a(String[] paramArrayOfString)
  {
    Object localObject = null;
    StringBuffer localStringBuffer = new StringBuffer();
    if (Environment.getExternalStorageState().equals("mounted"))
    {
      paramArrayOfString = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator;
      paramArrayOfString = d(paramArrayOfString + "tencent/MobileQQ/qbiz/" + "html5/");
      if (!TextUtils.isEmpty(paramArrayOfString)) {
        localStringBuffer.append(paramArrayOfString);
      }
    }
    if (jdField_a_of_type_AndroidContentContext == null) {
      return null;
    }
    try
    {
      paramArrayOfString = jdField_a_of_type_AndroidContentContext.getFilesDir().toString() + File.separator + k;
      if (!TextUtils.isEmpty(paramArrayOfString))
      {
        paramArrayOfString = d(paramArrayOfString + "html5/");
        if (!TextUtils.isEmpty(paramArrayOfString))
        {
          if (localStringBuffer.length() > 0) {
            localStringBuffer.append(",");
          }
          localStringBuffer.append(paramArrayOfString);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("HtmlCheckUpdate", 2, "getLocalOfflineVersions:" + localStringBuffer.toString());
      }
      return localStringBuffer.toString();
    }
    catch (Exception paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
        paramArrayOfString = localObject;
        if (QLog.isColorLevel())
        {
          QLog.i("HtmlCheckUpdate", 2, "getLocalOfflineVersions getFilesDir error");
          paramArrayOfString = localObject;
        }
      }
    }
  }
  
  /* Error */
  public static JSONObject a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifeq +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: new 125	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   20: aload_1
    //   21: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc 185
    //   26: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc 71
    //   31: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: astore_1
    //   38: new 125	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   45: ldc_w 267
    //   48: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload_1
    //   52: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: astore_1
    //   59: aload_0
    //   60: invokevirtual 503	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   63: aload_1
    //   64: invokevirtual 509	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   67: astore_1
    //   68: aload_1
    //   69: invokestatic 514	com/tencent/biz/common/util/Util:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   72: astore_0
    //   73: aload_1
    //   74: invokevirtual 519	java/io/InputStream:close	()V
    //   77: new 323	org/json/JSONObject
    //   80: dup
    //   81: aload_0
    //   82: invokespecial 520	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   85: astore_0
    //   86: aload_0
    //   87: areturn
    //   88: astore_0
    //   89: aload_0
    //   90: invokevirtual 521	org/json/JSONException:printStackTrace	()V
    //   93: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   96: ifeq +12 -> 108
    //   99: ldc 80
    //   101: iconst_2
    //   102: ldc_w 523
    //   105: invokestatic 178	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   108: aconst_null
    //   109: areturn
    //   110: astore_0
    //   111: aconst_null
    //   112: areturn
    //   113: astore_1
    //   114: aload_1
    //   115: invokevirtual 467	java/io/IOException:printStackTrace	()V
    //   118: goto -41 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	paramContext	Context
    //   0	121	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   77	86	88	org/json/JSONException
    //   59	68	110	java/io/IOException
    //   73	77	113	java/io/IOException
  }
  
  public static JSONObject a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      String str = a(paramString);
      if (!TextUtils.isEmpty(str))
      {
        paramString = new File(str + paramString + "/" + "config.json");
        if (paramString.exists()) {
          try
          {
            paramString = new FileInputStream(paramString);
            if (paramString != null) {
              str = Util.a(paramString);
            }
          }
          catch (IOException paramString)
          {
            try
            {
              paramString.close();
              try
              {
                paramString = new JSONObject(str);
                return paramString;
              }
              catch (JSONException paramString)
              {
                paramString.printStackTrace();
                return null;
              }
              catch (Exception paramString)
              {
                paramString.printStackTrace();
              }
              paramString = paramString;
              paramString.printStackTrace();
              paramString = null;
            }
            catch (IOException paramString)
            {
              for (;;)
              {
                paramString.printStackTrace();
              }
            }
          }
        }
      }
    }
    return null;
  }
  
  protected static void a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("local_html", 0);
    paramString = "last_up_" + paramString;
    paramContext = paramContext.edit();
    paramContext.putLong(paramString, System.currentTimeMillis());
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("local_html", 0);
    paramString = "expire_" + paramString;
    paramContext = paramContext.edit();
    paramContext.putInt(paramString, paramInt);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    a(paramContext, paramString1, paramString2, true, new cdk());
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, AsyncBack paramAsyncBack)
  {
    if (paramAsyncBack == null) {
      return;
    }
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      paramAsyncBack.a(null, 1);
      return;
    }
    String str = b(paramString1);
    if (TextUtils.isEmpty(str))
    {
      paramAsyncBack.a(null, 3);
      return;
    }
    JSONObject localJSONObject = a(paramString1);
    if (localJSONObject != null)
    {
      l1 = 30L;
      try
      {
        l2 = localJSONObject.getLong("frequency");
        l1 = l2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          long l2;
          localException.printStackTrace();
        }
      }
      l2 = (System.currentTimeMillis() - a(paramContext, paramString1)) / 60000L;
      if (QLog.isColorLevel()) {
        QLog.i("HtmlCheckUpdate", 2, "checkUpdate check freq:" + l1 + ", time:" + l2);
      }
      if (l2 < l1)
      {
        paramAsyncBack.a(null, 5);
        return;
      }
    }
    if (f(paramString1))
    {
      paramAsyncBack.a(null, 7);
      return;
    }
    a(paramString1);
    str = str + paramString1 + ".zip";
    long l1 = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    localHashMap.put("Accept-Encoding", "gzip");
    OfflineDownloader.a(paramContext, paramString2, paramString1, str, new cdo(l1, paramString1, paramAsyncBack, paramContext), localHashMap);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, AsyncBack paramAsyncBack)
  {
    if (paramAsyncBack == null) {
      return;
    }
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)))
    {
      paramAsyncBack.a(null, 1);
      return;
    }
    a(paramContext, paramString1, paramString2, false, paramAsyncBack);
  }
  
  protected static void a(Context paramContext, String paramString1, String paramString2, AsyncBack paramAsyncBack, boolean paramBoolean)
  {
    if (jdField_a_of_type_JavaUtilArrayList == null) {
      jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    if (QLog.isColorLevel()) {
      QLog.i("HtmlCheckUpdate", 2, "addDownloadToQueue: add to queue:" + paramString1);
    }
    int i2 = jdField_a_of_type_JavaUtilArrayList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      if (paramString1.equals(cdq.a((cdq)jdField_a_of_type_JavaUtilArrayList.get(i1)))) {
        return;
      }
      i1 += 1;
    }
    paramContext = new cdq(paramContext, paramString1, paramString2, paramAsyncBack, paramBoolean);
    jdField_a_of_type_JavaUtilArrayList.add(paramContext);
  }
  
  protected static void a(Context paramContext, String paramString1, String paramString2, AsyncBack paramAsyncBack, boolean paramBoolean, int paramInt)
  {
    if (paramAsyncBack == null) {}
    do
    {
      return;
      if (!a(paramString1))
      {
        paramAsyncBack.a(null, 3);
        return;
      }
      if ((paramContext == null) || (TextUtils.isEmpty(paramString1)))
      {
        paramAsyncBack.a(null, 1);
        return;
      }
    } while ((Arrays.asList(b).contains(paramString1)) || (paramInt > 60) || (paramInt < 0));
    JSONObject localJSONObject = a(paramString1);
    long l2 = 30L;
    long l1 = l2;
    if (localJSONObject != null) {}
    try
    {
      l1 = localJSONObject.getLong("frequency");
      l2 = (System.currentTimeMillis() - a(paramContext, paramString1)) / 60000L;
      if (QLog.isColorLevel()) {
        QLog.i("HtmlCheckUpdate", 2, "checkUpdate check freq:" + l1 + ", time:" + l2);
      }
      if (l2 < l1)
      {
        paramAsyncBack.a(null, 5);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        l1 = l2;
      }
      if (f(paramString1))
      {
        if (QLog.isColorLevel()) {
          QLog.i("HtmlCheckUpdate", 2, paramString1 + " is downloading");
        }
        paramAsyncBack.a(null, 7);
        return;
      }
      a(paramContext, paramString1);
      new cdl(paramInt, paramString1, paramContext, paramString2, paramAsyncBack, paramBoolean).start();
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, LoadedCallBack paramLoadedCallBack)
  {
    b(paramContext, Uri.parse(paramString1).getQueryParameter("_bid"), paramString2, paramLoadedCallBack);
  }
  
  protected static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, AsyncBack paramAsyncBack)
  {
    if (paramAsyncBack == null) {
      return;
    }
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)))
    {
      paramAsyncBack.a(null, 1);
      return;
    }
    String str = Uri.parse(paramString1).getQueryParameter("_bid");
    int i2 = AuthorizeConfig.a().a(paramString1);
    int i1 = i2;
    if (i2 == 0) {
      i1 = 5;
    }
    a(paramContext, str, paramString2, paramAsyncBack, paramBoolean, i1);
  }
  
  public static void a(Context paramContext, ArrayList paramArrayList, String paramString, int paramInt)
  {
    ThreadManager.a(new cdp(paramContext, paramArrayList, paramString, paramInt));
  }
  
  public static void a(Context paramContext, ArrayList paramArrayList, String paramString, LoadedCallBack paramLoadedCallBack)
  {
    if (paramLoadedCallBack == null) {
      return;
    }
    if ((paramContext == null) || (paramArrayList.size() == 0))
    {
      paramLoadedCallBack.a("{\"r\":-1}");
      return;
    }
    ThreadManager.a(new cdm(paramContext, paramArrayList, paramString, paramLoadedCallBack));
  }
  
  public static void a(cdq paramcdq)
  {
    if (jdField_a_of_type_JavaUtilArrayList == null) {
      jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    int i2 = jdField_a_of_type_JavaUtilArrayList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      cdq localcdq = (cdq)jdField_a_of_type_JavaUtilArrayList.get(i1);
      if (cdq.a(paramcdq).equals(cdq.a(localcdq))) {
        return;
      }
      i1 += 1;
    }
    jdField_a_of_type_JavaUtilArrayList.add(paramcdq);
  }
  
  public static void a(String paramString)
  {
    if (jdField_a_of_type_JavaUtilHashMap == null) {
      jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    if (jdField_a_of_type_JavaUtilHashMap.get(paramString) == null)
    {
      jdField_a_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(1));
      if (QLog.isColorLevel()) {
        QLog.i("HtmlCheckUpdate", 2, "addDownloadingState:" + paramString);
      }
    }
  }
  
  public static void a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    a(paramString, paramInt1, paramLong, paramInt2, "lixian_update", "");
  }
  
  public static void a(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    try
    {
      i1 = Integer.valueOf(paramString1).intValue();
      if (paramString3 == null)
      {
        paramString1 = "";
        paramString3 = "";
        try
        {
          String str = jdField_a_of_type_AndroidContentContext.getPackageManager().getPackageInfo(jdField_a_of_type_AndroidContentContext.getPackageName(), 0).versionName;
          paramString3 = str;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          for (;;)
          {
            int i2;
            localNameNotFoundException.printStackTrace();
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
        i2 = paramInt2;
        if (paramInt2 == -1)
        {
          i2 = paramInt2;
          if (jdField_a_of_type_AndroidContentContext != null) {
            i2 = NetworkUtil.b(jdField_a_of_type_AndroidContentContext);
          }
        }
        ReportController.a(null, "P_CliOper", "Pb_account_lifeservice", paramString3, "mp_msg_sys_14", paramString2, i1, paramInt1, "" + paramLong, "3", "" + i2, paramString1);
        return;
      }
    }
    catch (NumberFormatException paramString1)
    {
      for (;;)
      {
        int i1 = -1;
        continue;
        paramString1 = paramString3;
      }
    }
  }
  
  public static boolean a(Context paramContext, String paramString, AsyncCallBack paramAsyncCallBack)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    String str = Uri.parse(paramString).getQueryParameter("_bid");
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    if (paramContext == null)
    {
      a(str, 3, 0L, 4, "lixian_cover", "0");
      return false;
    }
    if (!a(str))
    {
      a(str, 2, 0L, NetworkUtil.b(paramContext), "lixian_cover", "0");
      return false;
    }
    if (Arrays.asList(b).contains(str))
    {
      a(str, 4, 0L, NetworkUtil.b(paramContext), "lixian_cover", "0");
      return false;
    }
    new cdj(paramContext, paramString, paramAsyncCallBack).start();
    return true;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = paramContext.getAssets().open(paramString1);
      paramString1 = new FileOutputStream(new File(paramString2));
      paramString2 = new byte[4096];
      for (;;)
      {
        int i1 = paramContext.read(paramString2);
        if (i1 == -1)
        {
          paramString1.flush();
          paramContext.close();
          paramString1.close();
          return true;
        }
        paramString1.write(paramString2, 0, i1);
      }
      return false;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  protected static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject;
    for (;;)
    {
      return false;
      boolean bool = b(paramString);
      jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.a();
      if (bool) {
        try
        {
          if (!Environment.getExternalStorageState().equals("mounted"))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.i("HtmlCheckUpdate", 2, "no sd");
            return false;
          }
        }
        catch (Exception paramString)
        {
          paramString = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator;
          paramString = paramString + "tencent/MobileQQ/qbiz/";
          localObject = paramString + "html5/";
          l = (String)localObject;
          m = paramString + "tmp/";
        }
      }
    }
    for (;;)
    {
      localObject = new File((String)localObject);
      if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs())) {
        break;
      }
      paramString = new File(paramString + "tmp/");
      if (!paramString.exists()) {
        paramString.mkdirs();
      }
      return true;
      if (jdField_a_of_type_AndroidContentContext == null) {
        break;
      }
      try
      {
        localObject = jdField_a_of_type_AndroidContentContext.getFilesDir().toString() + File.separator + k;
        paramString = (String)localObject;
        localObject = paramString + "html5/";
        n = (String)localObject;
        o = paramString + "tmp/";
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.i("HtmlCheckUpdate", 2, "getFilesDir error");
        }
        a(paramString, 0, 0L, -1, "lixian_error", "0");
      }
    }
    return false;
  }
  
  protected static boolean a(String paramString, int paramInt, JSONObject paramJSONObject)
  {
    int i1 = 0;
    paramString = new File(paramString);
    if ((!paramString.exists()) || (!paramString.isDirectory())) {}
    do
    {
      return false;
      paramString = paramString.listFiles();
    } while (paramString == null);
    List localList = Arrays.asList(jdField_a_of_type_ArrayOfJavaLangString);
    if (i1 < paramString.length)
    {
      if (paramString[i1] == null) {}
      for (;;)
      {
        i1 += 1;
        break;
        try
        {
          String str1 = paramString[i1].getCanonicalPath();
          if (!paramString[i1].isFile()) {
            break label192;
          }
          String str2 = paramString[i1].getName();
          if (((!TextUtils.isEmpty(str2)) && (localList.contains(str2))) || (str2.equals("b.zip"))) {
            continue;
          }
          str1 = str1.substring(paramInt);
          try
          {
            paramJSONObject.get(str1);
          }
          catch (JSONException localJSONException)
          {
            if (QLog.isColorLevel()) {
              QLog.i("HtmlCheckUpdate", 2, " delete :" + str1);
            }
            paramString[i1].delete();
          }
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
        }
        continue;
        label192:
        if (paramString[i1].isDirectory()) {
          a(localIOException, paramInt, paramJSONObject);
        }
      }
    }
    return true;
  }
  
  public static boolean a(String paramString1, Context paramContext, String paramString2, AsyncCallBack paramAsyncCallBack)
  {
    return a(paramContext, "http://" + paramString1 + "?_bid=" + paramString2, paramAsyncCallBack);
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      if (QLog.isColorLevel()) {
        QLog.i("HtmlCheckUpdate", 2, "verfyFile: businessId null ");
      }
    }
    long l1;
    do
    {
      return false;
      String str = a(paramString1);
      if (TextUtils.isEmpty(str)) {
        return true;
      }
      str = str + paramString1;
      if (!new File(str).exists()) {
        return true;
      }
      paramString2 = g(paramString2);
      l1 = System.currentTimeMillis();
      if (OfflineSecurity.c(paramString2, str, paramString1)) {
        break;
      }
      Util.a(str);
    } while (!QLog.isColorLevel());
    QLog.i("HtmlCheckUpdate", 2, "verfySingleFile fail :" + paramString2);
    return false;
    if (QLog.isDevelopLevel()) {
      QLog.d("OfflineCheckFile", 4, "verifyFile:time=" + (System.currentTimeMillis() - l1) + ", file:" + paramString2);
    }
    return true;
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!a(paramString)) {
      return null;
    }
    if (b(paramString)) {
      return m;
    }
    return o;
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2, AsyncBack paramAsyncBack)
  {
    a(paramContext, paramString1, paramString2, paramAsyncBack, false, 5);
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2, LoadedCallBack paramLoadedCallBack)
  {
    if (paramLoadedCallBack == null) {
      return;
    }
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)))
    {
      paramLoadedCallBack.a("{\"r\":-1}");
      return;
    }
    if (TextUtils.isEmpty(paramString2)) {
      paramString2 = "0";
    }
    for (;;)
    {
      new cdn(a(paramString1), paramString1, paramContext, paramString2, paramLoadedCallBack).start();
      return;
    }
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, AsyncBack paramAsyncBack)
  {
    a(paramContext, paramString1, paramString2, paramAsyncBack, paramBoolean, 5);
  }
  
  public static void b(String paramString)
  {
    int i1;
    if (jdField_a_of_type_JavaUtilHashMap == null) {
      if (jdField_a_of_type_JavaUtilArrayList != null)
      {
        i1 = 0;
        if (i1 < jdField_a_of_type_JavaUtilArrayList.size())
        {
          if (!cdq.a((cdq)jdField_a_of_type_JavaUtilArrayList.get(i1)).equals(paramString)) {
            break label53;
          }
          jdField_a_of_type_JavaUtilArrayList.remove(i1);
        }
      }
    }
    label53:
    do
    {
      do
      {
        return;
        i1 += 1;
        break;
        if (jdField_a_of_type_JavaUtilHashMap.get(paramString) != null) {
          jdField_a_of_type_JavaUtilHashMap.remove(paramString);
        }
      } while ((jdField_a_of_type_JavaUtilArrayList == null) || (jdField_a_of_type_JavaUtilArrayList.isEmpty()));
      paramString = (cdq)jdField_a_of_type_JavaUtilArrayList.remove(0);
    } while (cdq.a(paramString) == null);
    if (QLog.isColorLevel()) {
      QLog.i("HtmlCheckUpdate", 2, "start checkUpByBusinessId from queue:" + cdq.a(paramString));
    }
    cdq.a(paramString);
  }
  
  protected static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      for (;;)
      {
        return true;
        try
        {
          int i1 = Integer.valueOf(paramString).intValue();
          if ((i1 >= 1000) && (i1 < 2000)) {
            return false;
          }
        }
        catch (NumberFormatException paramString)
        {
          paramString.printStackTrace();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i("HtmlCheckUpdate", 2, "initEnv NumberFormatException");
    return true;
  }
  
  public static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    long l1;
    long l2;
    do
    {
      do
      {
        do
        {
          return null;
        } while (!a(paramString));
        paramString = a(paramString);
      } while (paramString == null);
      l1 = System.currentTimeMillis();
      l2 = paramString.optLong("expired", 0L);
    } while ((l2 > 0L) && (l1 > l2));
    try
    {
      paramString = paramString.getString("version");
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private static void c(Context paramContext, ArrayList paramArrayList, String paramString, int paramInt)
  {
    Object localObject = a(paramContext, paramArrayList, paramString, paramInt);
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.i("HtmlCheckUpdate", 2, "getUpdateConfig: null");
      }
    }
    label109:
    String str;
    label132:
    label159:
    do
    {
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              return;
              try
              {
                localObject = new JSONObject((String)localObject);
                paramInt = ((JSONObject)localObject).optInt("r", -1);
                if (paramInt == 0) {
                  break label109;
                }
                if (QLog.isColorLevel())
                {
                  QLog.i("HtmlCheckUpdate", 2, "doCheckUp get config fail: r=：" + paramInt);
                  return;
                }
              }
              catch (JSONException paramContext)
              {
                paramContext.printStackTrace();
              }
            }
          } while (!QLog.isColorLevel());
          QLog.i("HtmlCheckUpdate", 2, "get config fail:JSONException");
          return;
          if (paramArrayList.size() <= 1) {
            break;
          }
          paramArrayList = ((JSONObject)localObject).optJSONArray("list");
        } while (paramArrayList == null);
        paramInt = 0;
        if (paramInt < paramArrayList.length())
        {
          localObject = paramArrayList.optJSONObject(paramInt);
          if (localObject != null) {
            break label159;
          }
        }
        for (;;)
        {
          paramInt += 1;
          break label132;
          break;
          if (((JSONObject)localObject).optInt("type", -1) > 0)
          {
            str = ((JSONObject)localObject).optString("url");
            if (!TextUtils.isEmpty(str))
            {
              cdq localcdq = new cdq(paramContext, ((JSONObject)localObject).optInt("bid") + "", paramString, null, true);
              localcdq.c = ((JSONObject)localObject).optInt("version");
              int i1 = ((JSONObject)localObject).optInt("filesize", 0);
              cdq.a(localcdq, str, ((JSONObject)localObject).optString("full_package_url"), i1, ((JSONObject)localObject).optInt("base_filesize"));
            }
          }
        }
      } while (((JSONObject)localObject).optInt("type", -1) <= 0);
      str = ((JSONObject)localObject).optString("url");
    } while (TextUtils.isEmpty(str));
    paramContext = new cdq(paramContext, (String)paramArrayList.get(0), paramString, null, false);
    paramContext.c = ((JSONObject)localObject).optInt("version");
    paramInt = ((JSONObject)localObject).optInt("filesize", 0);
    cdq.a(paramContext, str, ((JSONObject)localObject).optString("full_package_url"), paramInt, ((JSONObject)localObject).optInt("base_filesize"));
  }
  
  public static boolean c(String paramString)
  {
    boolean bool2 = false;
    String str1 = b(paramString);
    str1 = str1 + paramString + ".zip";
    String str2 = a(paramString);
    str2 = str2 + paramString;
    File localFile = new File(str2 + "/b.zip");
    if (QLog.isColorLevel()) {
      QLog.i("HtmlCheckUpdate", 2, "combine zip" + paramString);
    }
    boolean bool1 = bool2;
    if (localFile.exists())
    {
      bool1 = bool2;
      if (!new File(str1).exists()) {}
    }
    try
    {
      bool1 = BspatchUtil.a(str2 + "/b.zip", str1, str1);
      return bool1;
    }
    catch (Throwable paramString)
    {
      LogUtility.c("HtmlCheckUpdate", "mergeFile error : ", paramString);
    }
    return false;
  }
  
  protected static String d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    paramString = new File(paramString);
    if ((paramString.exists()) && (paramString.isDirectory()))
    {
      paramString = paramString.listFiles();
      if ((paramString != null) && (paramString.length > 0))
      {
        int i1 = 0;
        for (;;)
        {
          if ((i1 < paramString.length) && (i1 < 100))
          {
            Object localObject = paramString[i1];
            JSONObject localJSONObject;
            if ((localObject.isDirectory()) && (TextUtils.isDigitsOnly(localObject.getName())))
            {
              localJSONObject = a(localObject.getName());
              if (localJSONObject == null) {}
            }
            try
            {
              localStringBuffer.append(localObject.getName() + "|" + localJSONObject.getString("version") + ",");
              i1 += 1;
            }
            catch (JSONException localJSONException)
            {
              for (;;)
              {
                localJSONException.printStackTrace();
              }
            }
          }
        }
        if (localStringBuffer.length() > 0) {
          localStringBuffer.delete(localStringBuffer.length() - 1, localStringBuffer.length());
        }
      }
    }
    return localStringBuffer.toString();
  }
  
  public static boolean d(String paramString)
  {
    boolean bool1 = false;
    for (;;)
    {
      int i1;
      try
      {
        bool2 = TextUtils.isEmpty(paramString);
        if (bool2)
        {
          bool1 = false;
          return bool1;
        }
        String str1 = b(paramString);
        if (TextUtils.isEmpty(str1))
        {
          bool1 = false;
          continue;
        }
        str1 = str1 + paramString + ".zip";
        File localFile1 = new File(str1);
        if (!localFile1.exists())
        {
          if (!QLog.isColorLevel()) {
            break label374;
          }
          QLog.i("HtmlCheckUpdate", 2, "doUpdate: no zip ! : businessId:" + paramString);
          break label374;
        }
        String str2 = a(paramString);
        str2 = str2 + paramString;
        File localFile2 = new File(str2);
        if ((!localFile2.exists()) && (!localFile2.mkdirs()))
        {
          if (!QLog.isColorLevel()) {
            break label379;
          }
          QLog.d("QQBrowserOffline", 2, "error : mkdirs: error:" + str2);
          break label379;
        }
        long l1 = System.currentTimeMillis();
        i1 = ZipUtils.a(str1, str2);
        if (i1 > 0)
        {
          Util.a(str2);
          Util.b(str1);
          a(paramString, 13, 0L, i1, "lixian_update", "0");
          if (!QLog.isColorLevel()) {
            break label369;
          }
          QLog.i("HtmlCheckUpdate", 2, "unZipFolder fail!");
          bool2 = false;
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("HtmlCheckUpdate", 2, "time of unzip：" + (System.currentTimeMillis() - l1));
          bool1 = bool2;
          continue;
        }
        localFile1.renameTo(new File(str2 + "/b.zip"));
      }
      finally {}
      bool1 = true;
      a(paramString, 13, 0L, i1, "lixian_time", "0");
      label369:
      boolean bool2 = bool1;
      continue;
      label374:
      bool1 = false;
      continue;
      label379:
      bool1 = false;
    }
  }
  
  public static String e(String paramString)
  {
    String str = "file://" + Environment.getExternalStorageDirectory().getPath() + "/" + "tencent/MobileQQ/qbiz/html5/";
    if ((paramString == null) || (!paramString.startsWith(str))) {
      return "";
    }
    paramString = paramString.substring(str.length());
    int i1 = paramString.indexOf('/');
    if (i1 <= 0) {
      return "";
    }
    try
    {
      Integer.parseInt(paramString.substring(0, i1), 10);
      paramString = paramString.substring(i1 + 1);
      if (paramString.length() > 0) {
        return "http://" + paramString;
      }
    }
    catch (NumberFormatException paramString)
    {
      return "";
    }
    return "";
  }
  
  protected static boolean e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject;
    do
    {
      return false;
      if (QLog.isDevelopLevel()) {
        QLog.i("HtmlCheckUpdate", 4, "checkOfflineFiles " + paramString);
      }
      localObject = a(paramString);
    } while (TextUtils.isEmpty((CharSequence)localObject));
    paramString = (String)localObject + paramString + "/";
    try
    {
      localObject = new FileInputStream(new File(paramString + "verify.json"));
      JSONObject localJSONObject = new JSONObject(OfflineSecurity.a((InputStream)localObject));
      ((InputStream)localObject).close();
      a(paramString, paramString.length(), localJSONObject);
      return true;
    }
    catch (FileNotFoundException paramString)
    {
      paramString.printStackTrace();
      return false;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      return false;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public static boolean f(String paramString)
  {
    if (jdField_a_of_type_JavaUtilHashMap == null) {}
    while (jdField_a_of_type_JavaUtilHashMap.get(paramString) == null) {
      return false;
    }
    return true;
  }
  
  private static String g(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String[] arrayOfString = paramString.substring(paramString.indexOf(":") + 3).split("\\?");
    paramString = arrayOfString;
    if (arrayOfString[0].contains("#")) {
      paramString = arrayOfString[0].split("\\#");
    }
    return paramString[0];
  }
  
  public static boolean g(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.i("HtmlCheckUpdate", 2, "verfySign: businessId null ");
      }
    }
    do
    {
      return false;
      String str = a(paramString);
      if (TextUtils.isEmpty(str)) {
        return true;
      }
      str = str + paramString;
      if (!new File(str).exists()) {
        return true;
      }
      if (OfflineSecurity.b(str, paramString)) {
        return true;
      }
      Util.a(str);
    } while (!QLog.isColorLevel());
    QLog.i("HtmlCheckUpdate", 2, "verfySign fail :" + paramString);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.common.offline.HtmlOffline
 * JD-Core Version:    0.7.0.1
 */