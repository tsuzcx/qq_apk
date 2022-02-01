package com.tencent.open.appcommon;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.BspatchUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.http.HttpBaseUtil.NetworkUnavailableException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class ResourceUpdater
{
  protected static final int a = 0;
  public static final String a = ResourceUpdater.class.getName();
  protected static final int b = 1;
  protected static String b = "https://appsupport.qq.com/cgi-bin/appstage/check_update";
  protected static final int c = 2;
  protected static final String c = "fusion_res_inc_update_qq_";
  protected static final int d = 3;
  protected static final String d = "fusion_res_full_update_qq_";
  public static String e = null;
  
  public static InputStream a(HttpResponse paramHttpResponse)
  {
    Object localObject1 = paramHttpResponse.getEntity();
    try
    {
      if (paramHttpResponse.containsHeader("Content-Length"))
      {
        long l = Long.parseLong(paramHttpResponse.getFirstHeader("Content-Length").getValue());
        LogUtility.c(a, "readHttpResponse content-Length = " + l);
      }
      localObject1 = ((HttpEntity)localObject1).getContent();
      Header localHeader = paramHttpResponse.getFirstHeader("Content-Encoding");
      if ((localHeader != null) && (localHeader.getValue().toLowerCase().indexOf("gzip") > -1))
      {
        LogUtility.b(a, "readHttpResponse -> GZIPInputStream");
        return new GZIPInputStream((InputStream)localObject1);
      }
      LogUtility.b(a, "readHttpResponse -> InputStream");
      return localObject1;
    }
    catch (Exception localException)
    {
      LogUtility.e(a, "readHttpResponse error : " + localException.toString());
      paramHttpResponse = paramHttpResponse.getAllHeaders();
      int j = paramHttpResponse.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = paramHttpResponse[i];
        LogUtility.e(a, "header >>> " + localObject2.getName() + ": " + localObject2.getValue());
        i += 1;
      }
    }
    return null;
  }
  
  protected static HttpResponse a(String paramString, int paramInt)
  {
    return a(paramString, null, paramInt, Integer.valueOf(1));
  }
  
  protected static HttpResponse a(String paramString, Map paramMap, int paramInt, Integer paramInteger)
  {
    Object localObject1 = CommonDataAdapter.a().a();
    if (localObject1 == null) {
      paramString = null;
    }
    Object localObject2;
    label188:
    label355:
    label490:
    do
    {
      do
      {
        return paramString;
        localObject2 = (ConnectivityManager)((Context)localObject1).getSystemService("connectivity");
        if (localObject2 != null)
        {
          localObject2 = ((ConnectivityManager)localObject2).getActiveNetworkInfo();
          if ((localObject2 == null) || (!((NetworkInfo)localObject2).isAvailable())) {
            throw new HttpBaseUtil.NetworkUnavailableException("network unavailable");
          }
        }
        localObject2 = new DefaultHttpClient();
        HttpConnectionParams.setConnectionTimeout(((HttpClient)localObject2).getParams(), 60000);
        HttpConnectionParams.setSoTimeout(((HttpClient)localObject2).getParams(), paramInt * 1000);
        Object localObject3;
        int i;
        if (APNUtil.a((Context)localObject1))
        {
          localObject3 = APNUtil.c((Context)localObject1);
          i = APNUtil.a((Context)localObject1);
          if (localObject3 != null)
          {
            localObject1 = new HttpHost((String)localObject3, i);
            ((HttpClient)localObject2).getParams().setParameter("http.route.default-proxy", localObject1);
          }
        }
        if (paramString.indexOf("?") == -1)
        {
          localObject1 = paramString + "?";
          paramString = (String)localObject1 + "sid=" + CommonDataAdapter.a().a();
          if (paramMap != null) {
            break label355;
          }
          LogUtility.c(a, "httpRequest url " + paramString);
          paramString = new HttpGet(paramString);
          paramString.addHeader("Accept-Encoding", "gzip");
        }
        for (;;)
        {
          localObject1 = ((HttpClient)localObject2).execute(paramString);
          i = ((HttpResponse)localObject1).getStatusLine().getStatusCode();
          if (302 != i)
          {
            paramString = (String)localObject1;
            if (301 != i) {
              break;
            }
          }
          if (paramInteger.intValue() <= 5) {
            break label490;
          }
          return null;
          localObject1 = paramString;
          if (paramString.endsWith("&")) {
            break label188;
          }
          localObject1 = paramString + "&";
          break label188;
          paramString = new HttpPost(paramString);
          paramString.addHeader("Accept-Encoding", "gzip");
          localObject1 = new ArrayList();
          localObject3 = paramMap.entrySet().iterator();
          while (((Iterator)localObject3).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
            ((List)localObject1).add(new BasicNameValuePair((String)localEntry.getKey(), (String)localEntry.getValue()));
          }
          ((HttpPost)paramString).setEntity(new UrlEncodedFormEntity((List)localObject1, "UTF-8"));
          paramString.getParams().setBooleanParameter("http.protocol.expect-continue", false);
        }
        localObject2 = ((HttpResponse)localObject1).getFirstHeader("Location");
        paramString = (String)localObject1;
      } while (localObject2 == null);
      paramString = (String)localObject1;
    } while (((Header)localObject2).getValue() == null);
    return a(((Header)localObject2).getValue(), paramMap, paramInt, Integer.valueOf(paramInteger.intValue() + 1));
  }
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 29	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   6: ldc_w 329
    //   9: invokestatic 112	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: invokestatic 334	com/tencent/open/appcommon/Common:q	()Ljava/lang/String;
    //   15: astore 4
    //   17: invokestatic 337	com/tencent/open/appcommon/Common:r	()Ljava/lang/String;
    //   20: astore 5
    //   22: invokestatic 340	com/tencent/open/appcommon/Common:i	()Ljava/lang/String;
    //   25: invokestatic 345	com/tencent/open/base/MD5Utils:c	(Ljava/lang/String;)Ljava/lang/String;
    //   28: astore_3
    //   29: invokestatic 348	com/tencent/open/appcommon/Common:m	()Ljava/lang/String;
    //   32: invokestatic 350	com/tencent/open/base/MD5Utils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   35: astore_2
    //   36: getstatic 29	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   39: new 71	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   46: ldc_w 352
    //   49: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload 4
    //   54: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: ldc_w 354
    //   60: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload 5
    //   65: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: ldc_w 356
    //   71: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokestatic 340	com/tencent/open/appcommon/Common:i	()Ljava/lang/String;
    //   77: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: ldc_w 358
    //   83: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload_3
    //   87: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: ldc_w 360
    //   93: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload_2
    //   97: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokestatic 112	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   106: new 362	java/io/File
    //   109: dup
    //   110: invokestatic 348	com/tencent/open/appcommon/Common:m	()Ljava/lang/String;
    //   113: invokespecial 363	java/io/File:<init>	(Ljava/lang/String;)V
    //   116: invokevirtual 366	java/io/File:exists	()Z
    //   119: ifeq +634 -> 753
    //   122: aload 5
    //   124: invokestatic 372	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   127: ifeq +515 -> 642
    //   130: aload_2
    //   131: astore_1
    //   132: getstatic 29	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   135: new 71	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   142: ldc_w 374
    //   145: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokestatic 340	com/tencent/open/appcommon/Common:i	()Ljava/lang/String;
    //   151: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: ldc_w 376
    //   157: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload 5
    //   162: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc_w 360
    //   168: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload_2
    //   172: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: ldc_w 378
    //   178: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload 4
    //   183: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: ldc_w 380
    //   189: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload_1
    //   193: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: ldc_w 382
    //   199: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload_3
    //   203: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokestatic 89	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   212: aload_1
    //   213: invokestatic 384	com/tencent/open/appcommon/Common:b	(Ljava/lang/String;)V
    //   216: aload 4
    //   218: invokestatic 372	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   221: ifne +744 -> 965
    //   224: aload 4
    //   226: aload_3
    //   227: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   230: ifne +735 -> 965
    //   233: getstatic 29	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   236: new 71	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   243: ldc_w 389
    //   246: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: invokestatic 340	com/tencent/open/appcommon/Common:i	()Ljava/lang/String;
    //   252: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: ldc_w 378
    //   258: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload 4
    //   263: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: ldc_w 382
    //   269: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: aload_3
    //   273: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: invokestatic 89	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   282: iconst_1
    //   283: istore_0
    //   284: aload_3
    //   285: invokestatic 372	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   288: ifne +13 -> 301
    //   291: iload_0
    //   292: ifne +9 -> 301
    //   295: invokestatic 391	com/tencent/open/appcommon/ResourceUpdater:b	()Z
    //   298: ifeq +650 -> 948
    //   301: getstatic 29	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   304: new 71	java/lang/StringBuilder
    //   307: dup
    //   308: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   311: ldc_w 393
    //   314: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: aload_1
    //   318: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: ldc_w 395
    //   324: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: aload_3
    //   328: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: invokestatic 89	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   337: aload_3
    //   338: invokestatic 372	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   341: ifeq +619 -> 960
    //   344: ldc_w 397
    //   347: astore_2
    //   348: aload_1
    //   349: invokestatic 372	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   352: ifeq +3 -> 355
    //   355: new 399	android/os/Bundle
    //   358: dup
    //   359: invokespecial 400	android/os/Bundle:<init>	()V
    //   362: astore_3
    //   363: aload_3
    //   364: ldc_w 402
    //   367: aload_2
    //   368: invokevirtual 405	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   371: aload_3
    //   372: ldc_w 407
    //   375: aload_1
    //   376: invokevirtual 405	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   379: aload_3
    //   380: ldc_w 409
    //   383: ldc_w 411
    //   386: invokevirtual 405	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   389: aload_3
    //   390: ldc_w 413
    //   393: invokestatic 148	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   396: invokevirtual 415	com/tencent/open/adapter/CommonDataAdapter:c	()Ljava/lang/String;
    //   399: invokevirtual 405	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   402: aload_3
    //   403: ldc_w 417
    //   406: new 71	java/lang/StringBuilder
    //   409: dup
    //   410: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   413: ldc_w 419
    //   416: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: invokestatic 148	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   422: invokevirtual 421	com/tencent/open/adapter/CommonDataAdapter:d	()Ljava/lang/String;
    //   425: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   431: invokevirtual 405	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   434: aload_3
    //   435: ldc_w 423
    //   438: invokestatic 148	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   441: invokevirtual 426	com/tencent/open/adapter/CommonDataAdapter:g	()Ljava/lang/String;
    //   444: invokevirtual 405	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   447: aload_3
    //   448: ldc_w 428
    //   451: new 71	java/lang/StringBuilder
    //   454: dup
    //   455: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   458: invokestatic 148	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   461: invokevirtual 431	com/tencent/open/adapter/CommonDataAdapter:a	()J
    //   464: invokevirtual 81	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   467: ldc_w 397
    //   470: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   476: invokevirtual 405	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   479: aload_3
    //   480: ldc_w 433
    //   483: getstatic 438	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   486: invokevirtual 405	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   489: aload_3
    //   490: ldc_w 440
    //   493: invokestatic 444	com/tencent/open/business/base/MobileInfoUtil:e	()Ljava/lang/String;
    //   496: invokevirtual 405	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   499: aload_3
    //   500: ldc_w 446
    //   503: getstatic 451	android/os/Build:MODEL	Ljava/lang/String;
    //   506: invokevirtual 405	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   509: invokestatic 453	com/tencent/open/base/LogUtility:a	()Z
    //   512: ifeq +64 -> 576
    //   515: invokestatic 148	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   518: invokevirtual 151	com/tencent/open/adapter/CommonDataAdapter:a	()Landroid/content/Context;
    //   521: astore_1
    //   522: aload_1
    //   523: ifnull +53 -> 576
    //   526: aload_1
    //   527: invokestatic 459	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   530: ldc_w 461
    //   533: ldc_w 463
    //   536: invokeinterface 469 3 0
    //   541: astore_1
    //   542: aload_3
    //   543: ldc_w 471
    //   546: aload_1
    //   547: invokevirtual 405	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   550: aload_1
    //   551: ldc_w 473
    //   554: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   557: ifne +13 -> 570
    //   560: aload_1
    //   561: ldc_w 475
    //   564: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   567: ifeq +9 -> 576
    //   570: ldc_w 477
    //   573: putstatic 33	com/tencent/open/appcommon/ResourceUpdater:b	Ljava/lang/String;
    //   576: new 479	java/util/concurrent/CountDownLatch
    //   579: dup
    //   580: iconst_1
    //   581: invokespecial 482	java/util/concurrent/CountDownLatch:<init>	(I)V
    //   584: astore_1
    //   585: getstatic 29	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   588: ldc_w 484
    //   591: invokestatic 112	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   594: new 486	com/tencent/open/base/http/HttpCgiAsyncTask
    //   597: dup
    //   598: ldc_w 488
    //   601: getstatic 33	com/tencent/open/appcommon/ResourceUpdater:b	Ljava/lang/String;
    //   604: invokestatic 493	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   607: ldc_w 495
    //   610: new 497	com/tencent/open/appcommon/ResourceUpdater$CheckUpdateCallback
    //   613: dup
    //   614: aload_1
    //   615: aload_2
    //   616: invokespecial 500	com/tencent/open/appcommon/ResourceUpdater$CheckUpdateCallback:<init>	(Ljava/util/concurrent/CountDownLatch;Ljava/lang/String;)V
    //   619: invokespecial 503	com/tencent/open/base/http/HttpCgiAsyncTask:<init>	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/open/base/http/HttpCgiAsyncTask$Callback;)V
    //   622: iconst_1
    //   623: anewarray 399	android/os/Bundle
    //   626: dup
    //   627: iconst_0
    //   628: aload_3
    //   629: aastore
    //   630: invokevirtual 506	com/tencent/open/base/http/HttpCgiAsyncTask:execute	([Ljava/lang/Object;)Landroid/os/AsyncTask;
    //   633: pop
    //   634: aload_1
    //   635: invokevirtual 509	java/util/concurrent/CountDownLatch:await	()V
    //   638: ldc 2
    //   640: monitorexit
    //   641: return
    //   642: aload 5
    //   644: aload_2
    //   645: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   648: ifne +322 -> 970
    //   651: invokestatic 148	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   654: invokevirtual 151	com/tencent/open/adapter/CommonDataAdapter:a	()Landroid/content/Context;
    //   657: astore_1
    //   658: aload_1
    //   659: ifnull +311 -> 970
    //   662: aload_1
    //   663: ldc_w 511
    //   666: invokestatic 514	com/tencent/open/appcommon/Common:j	()Ljava/lang/String;
    //   669: invokestatic 519	com/tencent/open/base/FileUtils:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   672: invokestatic 514	com/tencent/open/appcommon/Common:j	()Ljava/lang/String;
    //   675: invokestatic 348	com/tencent/open/appcommon/Common:m	()Ljava/lang/String;
    //   678: invokestatic 523	com/tencent/open/base/ZipUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   681: new 362	java/io/File
    //   684: dup
    //   685: invokestatic 514	com/tencent/open/appcommon/Common:j	()Ljava/lang/String;
    //   688: invokespecial 363	java/io/File:<init>	(Ljava/lang/String;)V
    //   691: astore_1
    //   692: aload_1
    //   693: invokevirtual 366	java/io/File:exists	()Z
    //   696: ifeq +8 -> 704
    //   699: aload_1
    //   700: invokestatic 526	com/tencent/open/base/FileUtils:a	(Ljava/io/File;)Z
    //   703: pop
    //   704: invokestatic 348	com/tencent/open/appcommon/Common:m	()Ljava/lang/String;
    //   707: invokestatic 350	com/tencent/open/base/MD5Utils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   710: astore_1
    //   711: goto -579 -> 132
    //   714: astore_1
    //   715: getstatic 29	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   718: new 71	java/lang/StringBuilder
    //   721: dup
    //   722: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   725: ldc_w 528
    //   728: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: aload_1
    //   732: invokevirtual 122	java/lang/Exception:toString	()Ljava/lang/String;
    //   735: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   741: invokestatic 124	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   744: goto -63 -> 681
    //   747: astore_1
    //   748: ldc 2
    //   750: monitorexit
    //   751: aload_1
    //   752: athrow
    //   753: invokestatic 148	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   756: invokevirtual 151	com/tencent/open/adapter/CommonDataAdapter:a	()Landroid/content/Context;
    //   759: astore 6
    //   761: aload_2
    //   762: astore_1
    //   763: aload 6
    //   765: ifnull -553 -> 212
    //   768: aload 6
    //   770: ldc_w 511
    //   773: invokestatic 514	com/tencent/open/appcommon/Common:j	()Ljava/lang/String;
    //   776: invokestatic 519	com/tencent/open/base/FileUtils:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   779: invokestatic 514	com/tencent/open/appcommon/Common:j	()Ljava/lang/String;
    //   782: invokestatic 348	com/tencent/open/appcommon/Common:m	()Ljava/lang/String;
    //   785: invokestatic 523	com/tencent/open/base/ZipUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   788: new 362	java/io/File
    //   791: dup
    //   792: invokestatic 514	com/tencent/open/appcommon/Common:j	()Ljava/lang/String;
    //   795: invokespecial 363	java/io/File:<init>	(Ljava/lang/String;)V
    //   798: astore_1
    //   799: aload_1
    //   800: invokevirtual 366	java/io/File:exists	()Z
    //   803: ifeq +8 -> 811
    //   806: aload_1
    //   807: invokestatic 526	com/tencent/open/base/FileUtils:a	(Ljava/io/File;)Z
    //   810: pop
    //   811: invokestatic 348	com/tencent/open/appcommon/Common:m	()Ljava/lang/String;
    //   814: invokestatic 350	com/tencent/open/base/MD5Utils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   817: astore_1
    //   818: getstatic 29	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   821: new 71	java/lang/StringBuilder
    //   824: dup
    //   825: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   828: ldc_w 530
    //   831: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   834: invokestatic 340	com/tencent/open/appcommon/Common:i	()Ljava/lang/String;
    //   837: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   840: ldc_w 376
    //   843: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   846: aload 5
    //   848: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   851: ldc_w 360
    //   854: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: aload_2
    //   858: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   861: ldc_w 378
    //   864: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   867: aload 4
    //   869: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   872: ldc_w 380
    //   875: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   878: aload_1
    //   879: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   882: ldc_w 382
    //   885: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   888: aload_3
    //   889: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   892: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   895: invokestatic 89	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   898: goto -686 -> 212
    //   901: astore_1
    //   902: getstatic 29	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   905: new 71	java/lang/StringBuilder
    //   908: dup
    //   909: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   912: ldc_w 528
    //   915: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   918: aload_1
    //   919: invokevirtual 122	java/lang/Exception:toString	()Ljava/lang/String;
    //   922: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   925: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   928: invokestatic 124	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   931: goto -143 -> 788
    //   934: astore_1
    //   935: getstatic 29	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   938: ldc_w 532
    //   941: aload_1
    //   942: invokestatic 535	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   945: goto -307 -> 638
    //   948: getstatic 29	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   951: ldc_w 537
    //   954: invokestatic 112	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   957: goto -319 -> 638
    //   960: aload_3
    //   961: astore_2
    //   962: goto -614 -> 348
    //   965: iconst_0
    //   966: istore_0
    //   967: goto -683 -> 284
    //   970: aload_2
    //   971: astore_1
    //   972: goto -840 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   283	684	0	i	int
    //   131	580	1	localObject1	Object
    //   714	18	1	localException1	Exception
    //   747	5	1	localObject2	Object
    //   762	117	1	localObject3	Object
    //   901	18	1	localException2	Exception
    //   934	8	1	localInterruptedException	java.lang.InterruptedException
    //   971	1	1	localObject4	Object
    //   35	936	2	localObject5	Object
    //   28	933	3	localObject6	Object
    //   15	853	4	str1	String
    //   20	827	5	str2	String
    //   759	10	6	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   672	681	714	java/lang/Exception
    //   3	130	747	finally
    //   132	212	747	finally
    //   212	282	747	finally
    //   284	291	747	finally
    //   295	301	747	finally
    //   301	344	747	finally
    //   348	355	747	finally
    //   355	522	747	finally
    //   526	570	747	finally
    //   570	576	747	finally
    //   576	634	747	finally
    //   634	638	747	finally
    //   642	658	747	finally
    //   662	672	747	finally
    //   672	681	747	finally
    //   681	704	747	finally
    //   704	711	747	finally
    //   715	744	747	finally
    //   753	761	747	finally
    //   768	779	747	finally
    //   779	788	747	finally
    //   788	811	747	finally
    //   811	898	747	finally
    //   902	931	747	finally
    //   935	945	747	finally
    //   948	957	747	finally
    //   779	788	901	java/lang/Exception
    //   634	638	934	java/lang/InterruptedException
  }
  
  /* Error */
  public static boolean a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: iconst_0
    //   4: istore_1
    //   5: getstatic 29	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   8: ldc_w 541
    //   11: invokestatic 89	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: new 362	java/io/File
    //   17: dup
    //   18: invokestatic 348	com/tencent/open/appcommon/Common:m	()Ljava/lang/String;
    //   21: invokespecial 363	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: invokevirtual 366	java/io/File:exists	()Z
    //   27: ifne +5 -> 32
    //   30: iconst_0
    //   31: ireturn
    //   32: invokestatic 348	com/tencent/open/appcommon/Common:m	()Ljava/lang/String;
    //   35: invokestatic 350	com/tencent/open/base/MD5Utils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   38: astore 6
    //   40: getstatic 29	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   43: new 71	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   50: ldc_w 543
    //   53: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload 6
    //   58: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 89	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: invokestatic 340	com/tencent/open/appcommon/Common:i	()Ljava/lang/String;
    //   70: astore_3
    //   71: getstatic 29	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   74: new 71	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   81: ldc_w 545
    //   84: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_3
    //   88: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokestatic 89	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: invokestatic 548	com/tencent/open/appcommon/Common:t	()Ljava/lang/String;
    //   100: invokestatic 372	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   103: ifne +23 -> 126
    //   106: invokestatic 548	com/tencent/open/appcommon/Common:t	()Ljava/lang/String;
    //   109: invokestatic 372	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   112: ifne +552 -> 664
    //   115: invokestatic 548	com/tencent/open/appcommon/Common:t	()Ljava/lang/String;
    //   118: aload 6
    //   120: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   123: ifne +541 -> 664
    //   126: new 71	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   133: invokestatic 549	com/tencent/open/appcommon/Common:e	()Ljava/lang/String;
    //   136: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: getstatic 552	java/io/File:separator	Ljava/lang/String;
    //   142: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload 6
    //   147: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: astore_3
    //   154: iconst_1
    //   155: istore_0
    //   156: new 362	java/io/File
    //   159: dup
    //   160: aload_3
    //   161: invokespecial 363	java/io/File:<init>	(Ljava/lang/String;)V
    //   164: astore 9
    //   166: aload 9
    //   168: invokevirtual 366	java/io/File:exists	()Z
    //   171: ifne +9 -> 180
    //   174: aload 9
    //   176: invokevirtual 555	java/io/File:mkdirs	()Z
    //   179: pop
    //   180: new 557	java/util/HashSet
    //   183: dup
    //   184: invokespecial 558	java/util/HashSet:<init>	()V
    //   187: astore 7
    //   189: new 560	java/util/zip/ZipFile
    //   192: dup
    //   193: new 362	java/io/File
    //   196: dup
    //   197: invokestatic 348	com/tencent/open/appcommon/Common:m	()Ljava/lang/String;
    //   200: invokespecial 363	java/io/File:<init>	(Ljava/lang/String;)V
    //   203: invokespecial 563	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   206: astore 8
    //   208: aload 8
    //   210: invokevirtual 567	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   213: astore 10
    //   215: aload 10
    //   217: invokeinterface 572 1 0
    //   222: ifeq +297 -> 519
    //   225: aload 10
    //   227: invokeinterface 575 1 0
    //   232: checkcast 577	java/util/zip/ZipEntry
    //   235: astore_3
    //   236: aload_3
    //   237: invokevirtual 578	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   240: astore 11
    //   242: aload 11
    //   244: ifnull -29 -> 215
    //   247: aload 11
    //   249: ldc_w 580
    //   252: invokevirtual 583	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   255: ifne -40 -> 215
    //   258: aload_3
    //   259: invokevirtual 586	java/util/zip/ZipEntry:isDirectory	()Z
    //   262: ifeq +46 -> 308
    //   265: new 362	java/io/File
    //   268: dup
    //   269: aload 9
    //   271: invokevirtual 589	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   274: aload 11
    //   276: invokespecial 590	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   279: astore_3
    //   280: aload_3
    //   281: invokevirtual 366	java/io/File:exists	()Z
    //   284: ifne -69 -> 215
    //   287: aload_3
    //   288: invokevirtual 555	java/io/File:mkdirs	()Z
    //   291: pop
    //   292: goto -77 -> 215
    //   295: astore_3
    //   296: getstatic 29	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   299: ldc_w 592
    //   302: aload_3
    //   303: invokestatic 535	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   306: iconst_0
    //   307: ireturn
    //   308: new 362	java/io/File
    //   311: dup
    //   312: aload 9
    //   314: invokevirtual 589	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   317: aload 11
    //   319: invokespecial 590	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   322: astore 5
    //   324: aload 5
    //   326: invokevirtual 366	java/io/File:exists	()Z
    //   329: ifeq +9 -> 338
    //   332: aload 5
    //   334: invokevirtual 595	java/io/File:delete	()Z
    //   337: pop
    //   338: aload 7
    //   340: aload 11
    //   342: invokevirtual 102	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   345: invokeinterface 596 2 0
    //   350: pop
    //   351: aload 8
    //   353: aload_3
    //   354: invokevirtual 600	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   357: astore_3
    //   358: new 602	java/io/FileOutputStream
    //   361: dup
    //   362: aload 5
    //   364: invokespecial 603	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   367: astore 5
    //   369: sipush 1024
    //   372: newarray byte
    //   374: astore 11
    //   376: aload_3
    //   377: ifnull +77 -> 454
    //   380: aload_3
    //   381: aload 11
    //   383: invokevirtual 609	java/io/InputStream:read	([B)I
    //   386: istore_2
    //   387: iload_2
    //   388: iconst_m1
    //   389: if_icmpeq +65 -> 454
    //   392: aload 5
    //   394: aload 11
    //   396: iconst_0
    //   397: iload_2
    //   398: invokevirtual 615	java/io/OutputStream:write	([BII)V
    //   401: goto -21 -> 380
    //   404: astore 6
    //   406: aload_3
    //   407: astore 4
    //   409: aload 5
    //   411: astore_3
    //   412: aload 6
    //   414: astore 5
    //   416: getstatic 29	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   419: ldc_w 592
    //   422: aload 5
    //   424: invokestatic 535	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   427: aload 4
    //   429: ifnull +8 -> 437
    //   432: aload 4
    //   434: invokevirtual 618	java/io/InputStream:close	()V
    //   437: aload_3
    //   438: ifnull -408 -> 30
    //   441: aload_3
    //   442: invokevirtual 619	java/io/OutputStream:close	()V
    //   445: iconst_0
    //   446: ireturn
    //   447: astore_3
    //   448: aload_3
    //   449: invokevirtual 622	java/io/IOException:printStackTrace	()V
    //   452: iconst_0
    //   453: ireturn
    //   454: aload_3
    //   455: ifnull +7 -> 462
    //   458: aload_3
    //   459: invokevirtual 618	java/io/InputStream:close	()V
    //   462: aload 5
    //   464: ifnull -249 -> 215
    //   467: aload 5
    //   469: invokevirtual 619	java/io/OutputStream:close	()V
    //   472: goto -257 -> 215
    //   475: astore_3
    //   476: aload_3
    //   477: invokevirtual 622	java/io/IOException:printStackTrace	()V
    //   480: goto -265 -> 215
    //   483: astore 4
    //   485: aconst_null
    //   486: astore 5
    //   488: aconst_null
    //   489: astore_3
    //   490: aload_3
    //   491: ifnull +7 -> 498
    //   494: aload_3
    //   495: invokevirtual 618	java/io/InputStream:close	()V
    //   498: aload 5
    //   500: ifnull +8 -> 508
    //   503: aload 5
    //   505: invokevirtual 619	java/io/OutputStream:close	()V
    //   508: aload 4
    //   510: athrow
    //   511: astore_3
    //   512: aload_3
    //   513: invokevirtual 622	java/io/IOException:printStackTrace	()V
    //   516: goto -8 -> 508
    //   519: aload 9
    //   521: invokevirtual 626	java/io/File:listFiles	()[Ljava/io/File;
    //   524: astore_3
    //   525: aload_3
    //   526: ifnull +55 -> 581
    //   529: aload_3
    //   530: arraylength
    //   531: istore_2
    //   532: iload_1
    //   533: iload_2
    //   534: if_icmpge +47 -> 581
    //   537: aload_3
    //   538: iload_1
    //   539: aaload
    //   540: astore 4
    //   542: aload 4
    //   544: invokevirtual 627	java/io/File:isDirectory	()Z
    //   547: ifne +27 -> 574
    //   550: aload 7
    //   552: aload 4
    //   554: invokevirtual 628	java/io/File:getName	()Ljava/lang/String;
    //   557: invokevirtual 102	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   560: invokeinterface 630 2 0
    //   565: ifne +9 -> 574
    //   568: aload 4
    //   570: invokevirtual 595	java/io/File:delete	()Z
    //   573: pop
    //   574: iload_1
    //   575: iconst_1
    //   576: iadd
    //   577: istore_1
    //   578: goto -46 -> 532
    //   581: aload 8
    //   583: ifnull +8 -> 591
    //   586: aload 8
    //   588: invokevirtual 631	java/util/zip/ZipFile:close	()V
    //   591: iload_0
    //   592: ifeq +13 -> 605
    //   595: aload 6
    //   597: invokestatic 633	com/tencent/open/appcommon/Common:d	(Ljava/lang/String;)V
    //   600: aload 6
    //   602: invokestatic 384	com/tencent/open/appcommon/Common:b	(Ljava/lang/String;)V
    //   605: iconst_1
    //   606: ireturn
    //   607: astore_3
    //   608: goto -17 -> 591
    //   611: astore 4
    //   613: aconst_null
    //   614: astore 5
    //   616: goto -126 -> 490
    //   619: astore 4
    //   621: goto -131 -> 490
    //   624: astore 5
    //   626: aload 4
    //   628: astore 6
    //   630: aload 5
    //   632: astore 4
    //   634: aload_3
    //   635: astore 5
    //   637: aload 6
    //   639: astore_3
    //   640: goto -150 -> 490
    //   643: astore 5
    //   645: aconst_null
    //   646: astore_3
    //   647: goto -231 -> 416
    //   650: astore 5
    //   652: aconst_null
    //   653: astore 6
    //   655: aload_3
    //   656: astore 4
    //   658: aload 6
    //   660: astore_3
    //   661: goto -245 -> 416
    //   664: iconst_0
    //   665: istore_0
    //   666: goto -510 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   155	511	0	i	int
    //   4	574	1	j	int
    //   386	149	2	k	int
    //   70	218	3	localObject1	Object
    //   295	59	3	localException1	Exception
    //   357	85	3	localObject2	Object
    //   447	12	3	localIOException1	java.io.IOException
    //   475	2	3	localIOException2	java.io.IOException
    //   489	6	3	localObject3	Object
    //   511	2	3	localIOException3	java.io.IOException
    //   524	14	3	arrayOfFile	java.io.File[]
    //   607	28	3	localIOException4	java.io.IOException
    //   639	22	3	localObject4	Object
    //   1	432	4	localObject5	Object
    //   483	26	4	localObject6	Object
    //   540	29	4	localObject7	Object
    //   611	1	4	localObject8	Object
    //   619	8	4	localObject9	Object
    //   632	25	4	localObject10	Object
    //   322	293	5	localObject11	Object
    //   624	7	5	localObject12	Object
    //   635	1	5	localIOException5	java.io.IOException
    //   643	1	5	localException2	Exception
    //   650	1	5	localException3	Exception
    //   38	108	6	str	String
    //   404	197	6	localException4	Exception
    //   628	31	6	localObject13	Object
    //   187	364	7	localHashSet	java.util.HashSet
    //   206	381	8	localZipFile	java.util.zip.ZipFile
    //   164	356	9	localFile	java.io.File
    //   213	13	10	localEnumeration	java.util.Enumeration
    //   240	155	11	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   189	208	295	java/lang/Exception
    //   369	376	404	java/lang/Exception
    //   380	387	404	java/lang/Exception
    //   392	401	404	java/lang/Exception
    //   432	437	447	java/io/IOException
    //   441	445	447	java/io/IOException
    //   458	462	475	java/io/IOException
    //   467	472	475	java/io/IOException
    //   351	358	483	finally
    //   494	498	511	java/io/IOException
    //   503	508	511	java/io/IOException
    //   586	591	607	java/io/IOException
    //   358	369	611	finally
    //   369	376	619	finally
    //   380	387	619	finally
    //   392	401	619	finally
    //   416	427	624	finally
    //   351	358	643	java/lang/Exception
    //   358	369	650	java/lang/Exception
  }
  
  /* Error */
  public static boolean a(String paramString)
  {
    // Byte code:
    //   0: bipush 250
    //   2: istore_1
    //   3: iconst_0
    //   4: istore 4
    //   6: iconst_0
    //   7: istore_3
    //   8: invokestatic 642	android/os/SystemClock:elapsedRealtime	()J
    //   11: lstore 13
    //   13: aload_0
    //   14: invokevirtual 645	java/lang/String:length	()I
    //   17: i2l
    //   18: lstore 15
    //   20: lconst_0
    //   21: lstore 11
    //   23: aload_0
    //   24: sipush 180
    //   27: invokestatic 647	com/tencent/open/appcommon/ResourceUpdater:a	(Ljava/lang/String;I)Lorg/apache/http/HttpResponse;
    //   30: astore 17
    //   32: aload 17
    //   34: ifnonnull +164 -> 198
    //   37: ldc_w 649
    //   40: astore 17
    //   42: aconst_null
    //   43: astore 19
    //   45: lconst_0
    //   46: lstore 5
    //   48: iload_3
    //   49: istore 4
    //   51: lload 5
    //   53: lstore 7
    //   55: iload_1
    //   56: istore_2
    //   57: aload 17
    //   59: astore 18
    //   61: aload 19
    //   63: ifnull +750 -> 813
    //   66: aload 19
    //   68: invokevirtual 618	java/io/InputStream:close	()V
    //   71: invokestatic 654	com/tencent/open/business/cgireport/ReportManager:a	()Lcom/tencent/open/business/cgireport/ReportManager;
    //   74: new 71	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   81: ldc 18
    //   83: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokestatic 148	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   89: invokevirtual 421	com/tencent/open/adapter/CommonDataAdapter:d	()Ljava/lang/String;
    //   92: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: lload 13
    //   100: lload 15
    //   102: lload 5
    //   104: iload_1
    //   105: invokestatic 148	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   108: invokevirtual 431	com/tencent/open/adapter/CommonDataAdapter:a	()J
    //   111: ldc_w 656
    //   114: aload 17
    //   116: invokevirtual 659	com/tencent/open/business/cgireport/ReportManager:a	(Ljava/lang/String;JJJIJLjava/lang/String;Ljava/lang/String;)V
    //   119: iload_3
    //   120: ifeq +588 -> 708
    //   123: ldc_w 661
    //   126: astore 17
    //   128: getstatic 29	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   131: new 71	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   138: aload 17
    //   140: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_0
    //   144: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: ldc_w 663
    //   150: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: lload 13
    //   155: invokevirtual 81	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   158: ldc_w 663
    //   161: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: lload 15
    //   166: invokevirtual 81	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   169: ldc_w 663
    //   172: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: lload 5
    //   177: invokevirtual 81	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   180: ldc_w 663
    //   183: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: iload_1
    //   187: invokevirtual 666	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   190: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 89	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   196: iload_3
    //   197: ireturn
    //   198: aload 17
    //   200: invokeinterface 247 1 0
    //   205: invokeinterface 253 1 0
    //   210: istore_2
    //   211: iload_2
    //   212: sipush 200
    //   215: if_icmpne +154 -> 369
    //   218: aload 17
    //   220: invokestatic 668	com/tencent/open/appcommon/ResourceUpdater:a	(Lorg/apache/http/HttpResponse;)Ljava/io/InputStream;
    //   223: astore 17
    //   225: aload 17
    //   227: ifnull +104 -> 331
    //   230: aload 17
    //   232: astore 18
    //   234: lload 11
    //   236: lstore 7
    //   238: lload 11
    //   240: lstore 9
    //   242: aload 17
    //   244: invokestatic 549	com/tencent/open/appcommon/Common:e	()Ljava/lang/String;
    //   247: ldc_w 670
    //   250: invokestatic 673	com/tencent/open/appcommon/Common:a	(Ljava/io/InputStream;Ljava/lang/String;Ljava/lang/String;)J
    //   253: lstore 5
    //   255: aload 17
    //   257: astore 18
    //   259: lload 5
    //   261: lstore 7
    //   263: lload 5
    //   265: lstore 9
    //   267: lload 5
    //   269: lstore 11
    //   271: invokestatic 674	com/tencent/open/appcommon/ResourceUpdater:a	()Z
    //   274: ifeq +21 -> 295
    //   277: aconst_null
    //   278: astore 18
    //   280: iconst_0
    //   281: istore_1
    //   282: iconst_1
    //   283: istore_3
    //   284: aload 17
    //   286: astore 19
    //   288: aload 18
    //   290: astore 17
    //   292: goto -244 -> 48
    //   295: aload 17
    //   297: astore 18
    //   299: lload 5
    //   301: lstore 7
    //   303: getstatic 29	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   306: ldc_w 676
    //   309: invokestatic 124	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   312: ldc_w 678
    //   315: astore 18
    //   317: bipush 200
    //   319: istore_1
    //   320: aload 17
    //   322: astore 19
    //   324: aload 18
    //   326: astore 17
    //   328: goto -280 -> 48
    //   331: aload 17
    //   333: astore 18
    //   335: lload 11
    //   337: lstore 7
    //   339: lload 11
    //   341: lstore 9
    //   343: getstatic 29	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   346: ldc_w 680
    //   349: invokestatic 124	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   352: aconst_null
    //   353: astore 18
    //   355: lconst_0
    //   356: lstore 5
    //   358: aload 17
    //   360: astore 19
    //   362: aload 18
    //   364: astore 17
    //   366: goto -318 -> 48
    //   369: aconst_null
    //   370: astore 17
    //   372: iload_2
    //   373: istore_1
    //   374: aconst_null
    //   375: astore 19
    //   377: lconst_0
    //   378: lstore 5
    //   380: goto -332 -> 48
    //   383: astore 18
    //   385: aload 18
    //   387: invokevirtual 622	java/io/IOException:printStackTrace	()V
    //   390: goto -319 -> 71
    //   393: astore 20
    //   395: aconst_null
    //   396: astore 17
    //   398: lconst_0
    //   399: lstore 5
    //   401: aconst_null
    //   402: astore 19
    //   404: aload 19
    //   406: astore 18
    //   408: getstatic 29	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   411: ldc_w 682
    //   414: aload 20
    //   416: invokestatic 535	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   419: bipush 249
    //   421: istore_1
    //   422: lload 5
    //   424: lstore 7
    //   426: iload_1
    //   427: istore_2
    //   428: aload 17
    //   430: astore 18
    //   432: aload 19
    //   434: ifnull +379 -> 813
    //   437: aload 19
    //   439: invokevirtual 618	java/io/InputStream:close	()V
    //   442: iconst_0
    //   443: istore_3
    //   444: goto -373 -> 71
    //   447: astore 18
    //   449: aload 18
    //   451: invokevirtual 622	java/io/IOException:printStackTrace	()V
    //   454: iconst_0
    //   455: istore_3
    //   456: goto -385 -> 71
    //   459: astore 20
    //   461: aconst_null
    //   462: astore 17
    //   464: lconst_0
    //   465: lstore 5
    //   467: aconst_null
    //   468: astore 19
    //   470: aload 19
    //   472: astore 18
    //   474: getstatic 29	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   477: ldc_w 682
    //   480: aload 20
    //   482: invokestatic 535	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   485: bipush 248
    //   487: istore_1
    //   488: lload 5
    //   490: lstore 7
    //   492: iload_1
    //   493: istore_2
    //   494: aload 17
    //   496: astore 18
    //   498: aload 19
    //   500: ifnull +313 -> 813
    //   503: aload 19
    //   505: invokevirtual 618	java/io/InputStream:close	()V
    //   508: iconst_0
    //   509: istore_3
    //   510: goto -439 -> 71
    //   513: astore 18
    //   515: aload 18
    //   517: invokevirtual 622	java/io/IOException:printStackTrace	()V
    //   520: iconst_0
    //   521: istore_3
    //   522: goto -451 -> 71
    //   525: astore_0
    //   526: aconst_null
    //   527: astore 17
    //   529: aload 17
    //   531: astore 18
    //   533: getstatic 29	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   536: ldc_w 682
    //   539: aload_0
    //   540: invokestatic 535	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   543: aload 17
    //   545: ifnull +8 -> 553
    //   548: aload 17
    //   550: invokevirtual 618	java/io/InputStream:close	()V
    //   553: iconst_0
    //   554: ireturn
    //   555: astore_0
    //   556: aload_0
    //   557: invokevirtual 622	java/io/IOException:printStackTrace	()V
    //   560: goto -7 -> 553
    //   563: astore 19
    //   565: lconst_0
    //   566: lstore 5
    //   568: aconst_null
    //   569: astore 17
    //   571: aload 17
    //   573: astore 18
    //   575: getstatic 29	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   578: new 71	java/lang/StringBuilder
    //   581: dup
    //   582: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   585: ldc_w 684
    //   588: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: aload 19
    //   593: invokevirtual 687	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   596: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   602: aload 19
    //   604: invokestatic 535	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   607: aload 17
    //   609: astore 18
    //   611: new 71	java/lang/StringBuilder
    //   614: dup
    //   615: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   618: ldc_w 689
    //   621: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: aload 19
    //   626: invokevirtual 687	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   629: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   635: astore 19
    //   637: lload 5
    //   639: lstore 7
    //   641: iload_1
    //   642: istore_2
    //   643: aload 19
    //   645: astore 18
    //   647: aload 17
    //   649: ifnull +164 -> 813
    //   652: aload 17
    //   654: invokevirtual 618	java/io/InputStream:close	()V
    //   657: iconst_0
    //   658: istore_3
    //   659: aload 19
    //   661: astore 17
    //   663: goto -592 -> 71
    //   666: astore 17
    //   668: aload 17
    //   670: invokevirtual 622	java/io/IOException:printStackTrace	()V
    //   673: iconst_0
    //   674: istore_3
    //   675: aload 19
    //   677: astore 17
    //   679: goto -608 -> 71
    //   682: astore_0
    //   683: aconst_null
    //   684: astore 18
    //   686: aload 18
    //   688: ifnull +8 -> 696
    //   691: aload 18
    //   693: invokevirtual 618	java/io/InputStream:close	()V
    //   696: aload_0
    //   697: athrow
    //   698: astore 17
    //   700: aload 17
    //   702: invokevirtual 622	java/io/IOException:printStackTrace	()V
    //   705: goto -9 -> 696
    //   708: ldc_w 691
    //   711: astore 17
    //   713: goto -585 -> 128
    //   716: astore_0
    //   717: goto -31 -> 686
    //   720: astore_0
    //   721: goto -35 -> 686
    //   724: astore 19
    //   726: lload 7
    //   728: lstore 5
    //   730: goto -159 -> 571
    //   733: astore_0
    //   734: goto -205 -> 529
    //   737: astore 20
    //   739: aconst_null
    //   740: astore 18
    //   742: lload 9
    //   744: lstore 5
    //   746: aload 17
    //   748: astore 19
    //   750: aload 18
    //   752: astore 17
    //   754: goto -284 -> 470
    //   757: astore 20
    //   759: ldc_w 678
    //   762: astore 18
    //   764: aload 17
    //   766: astore 19
    //   768: aload 18
    //   770: astore 17
    //   772: goto -302 -> 470
    //   775: astore 20
    //   777: aconst_null
    //   778: astore 18
    //   780: lload 11
    //   782: lstore 5
    //   784: aload 17
    //   786: astore 19
    //   788: aload 18
    //   790: astore 17
    //   792: goto -388 -> 404
    //   795: astore 20
    //   797: ldc_w 678
    //   800: astore 18
    //   802: aload 17
    //   804: astore 19
    //   806: aload 18
    //   808: astore 17
    //   810: goto -406 -> 404
    //   813: iload 4
    //   815: istore_3
    //   816: lload 7
    //   818: lstore 5
    //   820: iload_2
    //   821: istore_1
    //   822: aload 18
    //   824: astore 17
    //   826: goto -755 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	829	0	paramString	String
    //   2	820	1	i	int
    //   56	765	2	j	int
    //   7	809	3	bool1	boolean
    //   4	810	4	bool2	boolean
    //   46	773	5	l1	long
    //   53	764	7	l2	long
    //   240	503	9	l3	long
    //   21	760	11	l4	long
    //   11	143	13	l5	long
    //   18	147	15	l6	long
    //   30	632	17	localObject1	Object
    //   666	3	17	localIOException1	java.io.IOException
    //   677	1	17	localObject2	Object
    //   698	3	17	localIOException2	java.io.IOException
    //   711	114	17	localObject3	Object
    //   59	304	18	localObject4	Object
    //   383	3	18	localIOException3	java.io.IOException
    //   406	25	18	localObject5	Object
    //   447	3	18	localIOException4	java.io.IOException
    //   472	25	18	localObject6	Object
    //   513	3	18	localIOException5	java.io.IOException
    //   531	292	18	localObject7	Object
    //   43	461	19	localObject8	Object
    //   563	62	19	localException1	Exception
    //   635	41	19	str	String
    //   724	1	19	localException2	Exception
    //   748	57	19	localObject9	Object
    //   393	22	20	localConnectTimeoutException1	org.apache.http.conn.ConnectTimeoutException
    //   459	22	20	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   737	1	20	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   757	1	20	localSocketTimeoutException3	java.net.SocketTimeoutException
    //   775	1	20	localConnectTimeoutException2	org.apache.http.conn.ConnectTimeoutException
    //   795	1	20	localConnectTimeoutException3	org.apache.http.conn.ConnectTimeoutException
    // Exception table:
    //   from	to	target	type
    //   66	71	383	java/io/IOException
    //   23	32	393	org/apache/http/conn/ConnectTimeoutException
    //   198	211	393	org/apache/http/conn/ConnectTimeoutException
    //   218	225	393	org/apache/http/conn/ConnectTimeoutException
    //   437	442	447	java/io/IOException
    //   23	32	459	java/net/SocketTimeoutException
    //   198	211	459	java/net/SocketTimeoutException
    //   218	225	459	java/net/SocketTimeoutException
    //   503	508	513	java/io/IOException
    //   23	32	525	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   198	211	525	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   218	225	525	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   548	553	555	java/io/IOException
    //   23	32	563	java/lang/Exception
    //   198	211	563	java/lang/Exception
    //   218	225	563	java/lang/Exception
    //   652	657	666	java/io/IOException
    //   23	32	682	finally
    //   198	211	682	finally
    //   218	225	682	finally
    //   691	696	698	java/io/IOException
    //   242	255	716	finally
    //   271	277	716	finally
    //   303	312	716	finally
    //   343	352	716	finally
    //   533	543	716	finally
    //   408	419	720	finally
    //   474	485	720	finally
    //   575	607	720	finally
    //   611	637	720	finally
    //   242	255	724	java/lang/Exception
    //   271	277	724	java/lang/Exception
    //   303	312	724	java/lang/Exception
    //   343	352	724	java/lang/Exception
    //   242	255	733	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   271	277	733	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   303	312	733	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   343	352	733	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   242	255	737	java/net/SocketTimeoutException
    //   271	277	737	java/net/SocketTimeoutException
    //   343	352	737	java/net/SocketTimeoutException
    //   303	312	757	java/net/SocketTimeoutException
    //   242	255	775	org/apache/http/conn/ConnectTimeoutException
    //   271	277	775	org/apache/http/conn/ConnectTimeoutException
    //   343	352	775	org/apache/http/conn/ConnectTimeoutException
    //   303	312	795	org/apache/http/conn/ConnectTimeoutException
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: iconst_0
    //   4: istore 8
    //   6: iconst_0
    //   7: istore 9
    //   9: iconst_0
    //   10: istore 10
    //   12: iconst_0
    //   13: istore 4
    //   15: invokestatic 642	android/os/SystemClock:elapsedRealtime	()J
    //   18: lstore 19
    //   20: aload_0
    //   21: invokevirtual 645	java/lang/String:length	()I
    //   24: i2l
    //   25: lstore 21
    //   27: lconst_0
    //   28: lstore 11
    //   30: iconst_0
    //   31: istore_2
    //   32: aconst_null
    //   33: astore 31
    //   35: aconst_null
    //   36: astore 29
    //   38: aconst_null
    //   39: astore 23
    //   41: aconst_null
    //   42: astore 32
    //   44: aconst_null
    //   45: astore 33
    //   47: aconst_null
    //   48: astore 34
    //   50: aconst_null
    //   51: astore 35
    //   53: aconst_null
    //   54: astore 30
    //   56: lload 11
    //   58: lstore 13
    //   60: aload 23
    //   62: astore 27
    //   64: iload 8
    //   66: istore 5
    //   68: aload 32
    //   70: astore 26
    //   72: iload 9
    //   74: istore 6
    //   76: lload 11
    //   78: lstore 15
    //   80: aload 33
    //   82: astore 25
    //   84: aload 34
    //   86: astore 24
    //   88: lload 11
    //   90: lstore 17
    //   92: aload 35
    //   94: astore 28
    //   96: aload_0
    //   97: sipush 180
    //   100: invokestatic 647	com/tencent/open/appcommon/ResourceUpdater:a	(Ljava/lang/String;I)Lorg/apache/http/HttpResponse;
    //   103: astore 36
    //   105: aload 36
    //   107: ifnonnull +179 -> 286
    //   110: ldc_w 649
    //   113: astore 23
    //   115: iconst_0
    //   116: istore 4
    //   118: lconst_0
    //   119: lstore 13
    //   121: bipush 250
    //   123: istore_3
    //   124: aload 30
    //   126: astore 24
    //   128: iload 4
    //   130: istore 5
    //   132: lload 13
    //   134: lstore 11
    //   136: iload_3
    //   137: istore_2
    //   138: aload 23
    //   140: astore_1
    //   141: aload 24
    //   143: ifnull +2083 -> 2226
    //   146: aload 24
    //   148: invokevirtual 618	java/io/InputStream:close	()V
    //   151: aload 23
    //   153: astore_1
    //   154: iload_3
    //   155: istore_2
    //   156: lload 13
    //   158: lstore 11
    //   160: invokestatic 654	com/tencent/open/business/cgireport/ReportManager:a	()Lcom/tencent/open/business/cgireport/ReportManager;
    //   163: new 71	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   170: ldc 14
    //   172: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokestatic 148	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   178: invokevirtual 421	com/tencent/open/adapter/CommonDataAdapter:d	()Ljava/lang/String;
    //   181: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: lload 19
    //   189: lload 21
    //   191: lload 11
    //   193: iload_2
    //   194: invokestatic 148	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   197: invokevirtual 431	com/tencent/open/adapter/CommonDataAdapter:a	()J
    //   200: ldc_w 656
    //   203: aload_1
    //   204: invokevirtual 659	com/tencent/open/business/cgireport/ReportManager:a	(Ljava/lang/String;JJJIJLjava/lang/String;Ljava/lang/String;)V
    //   207: iload 4
    //   209: ifeq +1972 -> 2181
    //   212: ldc_w 694
    //   215: astore_1
    //   216: getstatic 29	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   219: new 71	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   226: aload_1
    //   227: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: aload_0
    //   231: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: ldc_w 663
    //   237: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: lload 19
    //   242: invokevirtual 81	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   245: ldc_w 663
    //   248: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: lload 21
    //   253: invokevirtual 81	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   256: ldc_w 663
    //   259: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: lload 11
    //   264: invokevirtual 81	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   267: ldc_w 663
    //   270: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: iload_2
    //   274: invokevirtual 666	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   277: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokestatic 89	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   283: iload 4
    //   285: ireturn
    //   286: lload 11
    //   288: lstore 13
    //   290: aload 23
    //   292: astore 27
    //   294: iload 8
    //   296: istore 5
    //   298: aload 32
    //   300: astore 26
    //   302: iload 9
    //   304: istore 6
    //   306: lload 11
    //   308: lstore 15
    //   310: aload 33
    //   312: astore 25
    //   314: aload 34
    //   316: astore 24
    //   318: lload 11
    //   320: lstore 17
    //   322: aload 35
    //   324: astore 28
    //   326: aload 36
    //   328: invokeinterface 247 1 0
    //   333: invokeinterface 253 1 0
    //   338: istore_3
    //   339: iload_3
    //   340: sipush 200
    //   343: if_icmpne +1488 -> 1831
    //   346: lload 11
    //   348: lstore 13
    //   350: aload 23
    //   352: astore 27
    //   354: iload 8
    //   356: istore 5
    //   358: aload 32
    //   360: astore 26
    //   362: iload 9
    //   364: istore 6
    //   366: lload 11
    //   368: lstore 15
    //   370: aload 33
    //   372: astore 25
    //   374: aload 34
    //   376: astore 24
    //   378: lload 11
    //   380: lstore 17
    //   382: aload 35
    //   384: astore 28
    //   386: aload 36
    //   388: invokestatic 668	com/tencent/open/appcommon/ResourceUpdater:a	(Lorg/apache/http/HttpResponse;)Ljava/io/InputStream;
    //   391: astore 23
    //   393: aload 23
    //   395: ifnonnull +74 -> 469
    //   398: lload 11
    //   400: lstore 13
    //   402: aload 23
    //   404: astore 27
    //   406: iload 8
    //   408: istore 5
    //   410: aload 23
    //   412: astore 26
    //   414: iload 9
    //   416: istore 6
    //   418: lload 11
    //   420: lstore 15
    //   422: aload 23
    //   424: astore 25
    //   426: aload 23
    //   428: astore 24
    //   430: lload 11
    //   432: lstore 17
    //   434: aload 23
    //   436: astore 28
    //   438: getstatic 29	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   441: ldc_w 696
    //   444: invokestatic 124	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   447: iconst_0
    //   448: istore 4
    //   450: aload 23
    //   452: ifnull -169 -> 283
    //   455: aload 23
    //   457: invokevirtual 618	java/io/InputStream:close	()V
    //   460: iconst_0
    //   461: ireturn
    //   462: astore_0
    //   463: aload_0
    //   464: invokevirtual 622	java/io/IOException:printStackTrace	()V
    //   467: iconst_0
    //   468: ireturn
    //   469: lload 11
    //   471: lstore 13
    //   473: aload 23
    //   475: astore 27
    //   477: iload 8
    //   479: istore 5
    //   481: aload 23
    //   483: astore 26
    //   485: iload 9
    //   487: istore 6
    //   489: lload 11
    //   491: lstore 15
    //   493: aload 23
    //   495: astore 25
    //   497: aload 23
    //   499: astore 24
    //   501: lload 11
    //   503: lstore 17
    //   505: aload 23
    //   507: astore 28
    //   509: new 362	java/io/File
    //   512: dup
    //   513: invokestatic 348	com/tencent/open/appcommon/Common:m	()Ljava/lang/String;
    //   516: invokespecial 363	java/io/File:<init>	(Ljava/lang/String;)V
    //   519: astore 30
    //   521: lload 11
    //   523: lstore 13
    //   525: aload 23
    //   527: astore 27
    //   529: iload 8
    //   531: istore 5
    //   533: aload 23
    //   535: astore 26
    //   537: iload 9
    //   539: istore 6
    //   541: lload 11
    //   543: lstore 15
    //   545: aload 23
    //   547: astore 25
    //   549: aload 23
    //   551: astore 24
    //   553: lload 11
    //   555: lstore 17
    //   557: aload 23
    //   559: astore 28
    //   561: aload 30
    //   563: invokevirtual 366	java/io/File:exists	()Z
    //   566: ifne +67 -> 633
    //   569: lload 11
    //   571: lstore 13
    //   573: aload 23
    //   575: astore 27
    //   577: iload 8
    //   579: istore 5
    //   581: aload 23
    //   583: astore 26
    //   585: iload 9
    //   587: istore 6
    //   589: lload 11
    //   591: lstore 15
    //   593: aload 23
    //   595: astore 25
    //   597: aload 23
    //   599: astore 24
    //   601: lload 11
    //   603: lstore 17
    //   605: aload 23
    //   607: astore 28
    //   609: getstatic 29	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   612: ldc_w 698
    //   615: invokestatic 89	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   618: bipush 199
    //   620: istore_2
    //   621: iconst_0
    //   622: istore 4
    //   624: lconst_0
    //   625: lstore 13
    //   627: aload 31
    //   629: astore_1
    //   630: goto +1603 -> 2233
    //   633: lload 11
    //   635: lstore 13
    //   637: aload 23
    //   639: astore 27
    //   641: iload 8
    //   643: istore 5
    //   645: aload 23
    //   647: astore 26
    //   649: iload 9
    //   651: istore 6
    //   653: lload 11
    //   655: lstore 15
    //   657: aload 23
    //   659: astore 25
    //   661: aload 23
    //   663: astore 24
    //   665: lload 11
    //   667: lstore 17
    //   669: aload 23
    //   671: astore 28
    //   673: aload 23
    //   675: invokestatic 549	com/tencent/open/appcommon/Common:e	()Ljava/lang/String;
    //   678: ldc_w 700
    //   681: invokestatic 673	com/tencent/open/appcommon/Common:a	(Ljava/io/InputStream;Ljava/lang/String;Ljava/lang/String;)J
    //   684: lstore 11
    //   686: lload 11
    //   688: lstore 13
    //   690: aload 23
    //   692: astore 27
    //   694: iload 8
    //   696: istore 5
    //   698: aload 23
    //   700: astore 26
    //   702: iload 9
    //   704: istore 6
    //   706: lload 11
    //   708: lstore 15
    //   710: aload 23
    //   712: astore 25
    //   714: aload 23
    //   716: astore 24
    //   718: lload 11
    //   720: lstore 17
    //   722: aload 23
    //   724: astore 28
    //   726: invokestatic 702	com/tencent/open/appcommon/ResourceUpdater:c	()Z
    //   729: ifeq +995 -> 1724
    //   732: lload 11
    //   734: lstore 13
    //   736: aload 23
    //   738: astore 27
    //   740: iload 8
    //   742: istore 5
    //   744: aload 23
    //   746: astore 26
    //   748: iload 9
    //   750: istore 6
    //   752: lload 11
    //   754: lstore 15
    //   756: aload 23
    //   758: astore 25
    //   760: aload 23
    //   762: astore 24
    //   764: lload 11
    //   766: lstore 17
    //   768: aload 23
    //   770: astore 28
    //   772: invokestatic 705	com/tencent/open/appcommon/Common:o	()Ljava/lang/String;
    //   775: invokestatic 350	com/tencent/open/base/MD5Utils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   778: astore 31
    //   780: lload 11
    //   782: lstore 13
    //   784: aload 23
    //   786: astore 27
    //   788: iload 8
    //   790: istore 5
    //   792: aload 23
    //   794: astore 26
    //   796: iload 9
    //   798: istore 6
    //   800: lload 11
    //   802: lstore 15
    //   804: aload 23
    //   806: astore 25
    //   808: aload 23
    //   810: astore 24
    //   812: lload 11
    //   814: lstore 17
    //   816: aload 23
    //   818: astore 28
    //   820: aload_1
    //   821: aload 31
    //   823: invokevirtual 387	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   826: ifne +243 -> 1069
    //   829: lload 11
    //   831: lstore 13
    //   833: aload 23
    //   835: astore 27
    //   837: iload 8
    //   839: istore 5
    //   841: aload 23
    //   843: astore 26
    //   845: iload 9
    //   847: istore 6
    //   849: lload 11
    //   851: lstore 15
    //   853: aload 23
    //   855: astore 25
    //   857: aload 23
    //   859: astore 24
    //   861: lload 11
    //   863: lstore 17
    //   865: aload 23
    //   867: astore 28
    //   869: getstatic 29	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   872: ldc_w 707
    //   875: invokestatic 124	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   878: lload 11
    //   880: lstore 13
    //   882: aload 23
    //   884: astore 27
    //   886: iload 8
    //   888: istore 5
    //   890: aload 23
    //   892: astore 26
    //   894: iload 9
    //   896: istore 6
    //   898: lload 11
    //   900: lstore 15
    //   902: aload 23
    //   904: astore 25
    //   906: aload 23
    //   908: astore 24
    //   910: lload 11
    //   912: lstore 17
    //   914: aload 23
    //   916: astore 28
    //   918: getstatic 29	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   921: new 71	java/lang/StringBuilder
    //   924: dup
    //   925: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   928: ldc_w 709
    //   931: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   934: aload_1
    //   935: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   938: ldc_w 711
    //   941: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   944: aload 31
    //   946: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   949: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   952: invokestatic 124	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   955: lload 11
    //   957: lstore 13
    //   959: aload 23
    //   961: astore 27
    //   963: iload 8
    //   965: istore 5
    //   967: aload 23
    //   969: astore 26
    //   971: iload 9
    //   973: istore 6
    //   975: lload 11
    //   977: lstore 15
    //   979: aload 23
    //   981: astore 25
    //   983: aload 23
    //   985: astore 24
    //   987: lload 11
    //   989: lstore 17
    //   991: aload 23
    //   993: astore 28
    //   995: aload 30
    //   997: invokevirtual 595	java/io/File:delete	()Z
    //   1000: pop
    //   1001: iconst_0
    //   1002: istore 4
    //   1004: bipush 198
    //   1006: istore_2
    //   1007: aload 29
    //   1009: astore_1
    //   1010: aload_1
    //   1011: astore 27
    //   1013: iload 4
    //   1015: istore 7
    //   1017: iload 4
    //   1019: istore 5
    //   1021: aload 23
    //   1023: astore 26
    //   1025: iload 4
    //   1027: istore 6
    //   1029: lload 11
    //   1031: lstore 15
    //   1033: aload 23
    //   1035: astore 25
    //   1037: aload 23
    //   1039: astore 24
    //   1041: aload_1
    //   1042: astore 28
    //   1044: iload 4
    //   1046: istore 8
    //   1048: new 362	java/io/File
    //   1051: dup
    //   1052: invokestatic 714	com/tencent/open/appcommon/Common:n	()Ljava/lang/String;
    //   1055: invokespecial 363	java/io/File:<init>	(Ljava/lang/String;)V
    //   1058: invokevirtual 595	java/io/File:delete	()Z
    //   1061: pop
    //   1062: lload 11
    //   1064: lstore 13
    //   1066: goto +1167 -> 2233
    //   1069: lload 11
    //   1071: lstore 13
    //   1073: aload 23
    //   1075: astore 27
    //   1077: iload 8
    //   1079: istore 5
    //   1081: aload 23
    //   1083: astore 26
    //   1085: iload 9
    //   1087: istore 6
    //   1089: lload 11
    //   1091: lstore 15
    //   1093: aload 23
    //   1095: astore 25
    //   1097: aload 23
    //   1099: astore 24
    //   1101: lload 11
    //   1103: lstore 17
    //   1105: aload 23
    //   1107: astore 28
    //   1109: getstatic 29	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   1112: ldc_w 716
    //   1115: invokestatic 89	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   1118: lload 11
    //   1120: lstore 13
    //   1122: aload 23
    //   1124: astore 27
    //   1126: iload 8
    //   1128: istore 5
    //   1130: aload 23
    //   1132: astore 26
    //   1134: iload 9
    //   1136: istore 6
    //   1138: lload 11
    //   1140: lstore 15
    //   1142: aload 23
    //   1144: astore 25
    //   1146: aload 23
    //   1148: astore 24
    //   1150: lload 11
    //   1152: lstore 17
    //   1154: aload 23
    //   1156: astore 28
    //   1158: aload 30
    //   1160: invokevirtual 595	java/io/File:delete	()Z
    //   1163: ifeq +500 -> 1663
    //   1166: lload 11
    //   1168: lstore 13
    //   1170: aload 23
    //   1172: astore 27
    //   1174: iload 8
    //   1176: istore 5
    //   1178: aload 23
    //   1180: astore 26
    //   1182: iload 9
    //   1184: istore 6
    //   1186: lload 11
    //   1188: lstore 15
    //   1190: aload 23
    //   1192: astore 25
    //   1194: aload 23
    //   1196: astore 24
    //   1198: lload 11
    //   1200: lstore 17
    //   1202: aload 23
    //   1204: astore 28
    //   1206: getstatic 29	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   1209: ldc_w 718
    //   1212: invokestatic 89	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   1215: lload 11
    //   1217: lstore 13
    //   1219: aload 23
    //   1221: astore 27
    //   1223: iload 8
    //   1225: istore 5
    //   1227: aload 23
    //   1229: astore 26
    //   1231: iload 9
    //   1233: istore 6
    //   1235: lload 11
    //   1237: lstore 15
    //   1239: aload 23
    //   1241: astore 25
    //   1243: aload 23
    //   1245: astore 24
    //   1247: lload 11
    //   1249: lstore 17
    //   1251: aload 23
    //   1253: astore 28
    //   1255: new 362	java/io/File
    //   1258: dup
    //   1259: invokestatic 705	com/tencent/open/appcommon/Common:o	()Ljava/lang/String;
    //   1262: invokespecial 363	java/io/File:<init>	(Ljava/lang/String;)V
    //   1265: astore_1
    //   1266: lload 11
    //   1268: lstore 13
    //   1270: aload 23
    //   1272: astore 27
    //   1274: iload 8
    //   1276: istore 5
    //   1278: aload 23
    //   1280: astore 26
    //   1282: iload 9
    //   1284: istore 6
    //   1286: lload 11
    //   1288: lstore 15
    //   1290: aload 23
    //   1292: astore 25
    //   1294: aload 23
    //   1296: astore 24
    //   1298: lload 11
    //   1300: lstore 17
    //   1302: aload 23
    //   1304: astore 28
    //   1306: aload_1
    //   1307: aload 30
    //   1309: invokevirtual 721	java/io/File:renameTo	(Ljava/io/File;)Z
    //   1312: ifeq +245 -> 1557
    //   1315: lload 11
    //   1317: lstore 13
    //   1319: aload 23
    //   1321: astore 27
    //   1323: iload 8
    //   1325: istore 5
    //   1327: aload 23
    //   1329: astore 26
    //   1331: iload 9
    //   1333: istore 6
    //   1335: lload 11
    //   1337: lstore 15
    //   1339: aload 23
    //   1341: astore 25
    //   1343: aload 23
    //   1345: astore 24
    //   1347: lload 11
    //   1349: lstore 17
    //   1351: aload 23
    //   1353: astore 28
    //   1355: getstatic 29	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   1358: ldc_w 723
    //   1361: invokestatic 89	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   1364: lload 11
    //   1366: lstore 13
    //   1368: aload 23
    //   1370: astore 27
    //   1372: iload 8
    //   1374: istore 5
    //   1376: aload 23
    //   1378: astore 26
    //   1380: iload 9
    //   1382: istore 6
    //   1384: lload 11
    //   1386: lstore 15
    //   1388: aload 23
    //   1390: astore 25
    //   1392: aload 23
    //   1394: astore 24
    //   1396: lload 11
    //   1398: lstore 17
    //   1400: aload 23
    //   1402: astore 28
    //   1404: invokestatic 674	com/tencent/open/appcommon/ResourceUpdater:a	()Z
    //   1407: ifeq +12 -> 1419
    //   1410: iconst_1
    //   1411: istore 4
    //   1413: aload 29
    //   1415: astore_1
    //   1416: goto -406 -> 1010
    //   1419: bipush 200
    //   1421: istore_2
    //   1422: ldc_w 678
    //   1425: astore_1
    //   1426: aload_1
    //   1427: astore 27
    //   1429: iload 8
    //   1431: istore 5
    //   1433: aload 23
    //   1435: astore 26
    //   1437: iload 9
    //   1439: istore 6
    //   1441: lload 11
    //   1443: lstore 15
    //   1445: aload 23
    //   1447: astore 25
    //   1449: aload 23
    //   1451: astore 24
    //   1453: aload_1
    //   1454: astore 28
    //   1456: iload 10
    //   1458: istore 8
    //   1460: getstatic 29	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   1463: ldc_w 676
    //   1466: invokestatic 124	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1469: goto -459 -> 1010
    //   1472: astore_1
    //   1473: aload 27
    //   1475: astore 25
    //   1477: iload 7
    //   1479: istore 4
    //   1481: lload 11
    //   1483: lstore 13
    //   1485: aload 23
    //   1487: astore 24
    //   1489: getstatic 29	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   1492: new 71	java/lang/StringBuilder
    //   1495: dup
    //   1496: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   1499: ldc_w 725
    //   1502: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1505: aload_1
    //   1506: invokevirtual 726	org/apache/http/conn/ConnectTimeoutException:getMessage	()Ljava/lang/String;
    //   1509: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1512: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1515: aload_1
    //   1516: invokestatic 535	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1519: bipush 249
    //   1521: istore_3
    //   1522: iload 4
    //   1524: istore 5
    //   1526: lload 13
    //   1528: lstore 11
    //   1530: iload_3
    //   1531: istore_2
    //   1532: aload 25
    //   1534: astore_1
    //   1535: aload 23
    //   1537: ifnull +689 -> 2226
    //   1540: aload 23
    //   1542: invokevirtual 618	java/io/InputStream:close	()V
    //   1545: lload 13
    //   1547: lstore 11
    //   1549: iload_3
    //   1550: istore_2
    //   1551: aload 25
    //   1553: astore_1
    //   1554: goto -1394 -> 160
    //   1557: lload 11
    //   1559: lstore 13
    //   1561: aload 23
    //   1563: astore 27
    //   1565: iload 8
    //   1567: istore 5
    //   1569: aload 23
    //   1571: astore 26
    //   1573: iload 9
    //   1575: istore 6
    //   1577: lload 11
    //   1579: lstore 15
    //   1581: aload 23
    //   1583: astore 25
    //   1585: aload 23
    //   1587: astore 24
    //   1589: lload 11
    //   1591: lstore 17
    //   1593: aload 23
    //   1595: astore 28
    //   1597: aload_1
    //   1598: invokevirtual 595	java/io/File:delete	()Z
    //   1601: pop
    //   1602: lload 11
    //   1604: lstore 13
    //   1606: aload 23
    //   1608: astore 27
    //   1610: iload 8
    //   1612: istore 5
    //   1614: aload 23
    //   1616: astore 26
    //   1618: iload 9
    //   1620: istore 6
    //   1622: lload 11
    //   1624: lstore 15
    //   1626: aload 23
    //   1628: astore 25
    //   1630: aload 23
    //   1632: astore 24
    //   1634: lload 11
    //   1636: lstore 17
    //   1638: aload 23
    //   1640: astore 28
    //   1642: getstatic 29	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   1645: ldc_w 728
    //   1648: invokestatic 124	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1651: iconst_0
    //   1652: istore 4
    //   1654: bipush 197
    //   1656: istore_2
    //   1657: aload 29
    //   1659: astore_1
    //   1660: goto -650 -> 1010
    //   1663: lload 11
    //   1665: lstore 13
    //   1667: aload 23
    //   1669: astore 27
    //   1671: iload 8
    //   1673: istore 5
    //   1675: aload 23
    //   1677: astore 26
    //   1679: iload 9
    //   1681: istore 6
    //   1683: lload 11
    //   1685: lstore 15
    //   1687: aload 23
    //   1689: astore 25
    //   1691: aload 23
    //   1693: astore 24
    //   1695: lload 11
    //   1697: lstore 17
    //   1699: aload 23
    //   1701: astore 28
    //   1703: getstatic 29	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   1706: ldc_w 730
    //   1709: invokestatic 124	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1712: iconst_0
    //   1713: istore 4
    //   1715: bipush 196
    //   1717: istore_2
    //   1718: aload 29
    //   1720: astore_1
    //   1721: goto -711 -> 1010
    //   1724: lload 11
    //   1726: lstore 13
    //   1728: aload 23
    //   1730: astore 27
    //   1732: iload 8
    //   1734: istore 5
    //   1736: aload 23
    //   1738: astore 26
    //   1740: iload 9
    //   1742: istore 6
    //   1744: lload 11
    //   1746: lstore 15
    //   1748: aload 23
    //   1750: astore 25
    //   1752: aload 23
    //   1754: astore 24
    //   1756: lload 11
    //   1758: lstore 17
    //   1760: aload 23
    //   1762: astore 28
    //   1764: aload 30
    //   1766: invokevirtual 595	java/io/File:delete	()Z
    //   1769: pop
    //   1770: lload 11
    //   1772: lstore 13
    //   1774: aload 23
    //   1776: astore 27
    //   1778: iload 8
    //   1780: istore 5
    //   1782: aload 23
    //   1784: astore 26
    //   1786: iload 9
    //   1788: istore 6
    //   1790: lload 11
    //   1792: lstore 15
    //   1794: aload 23
    //   1796: astore 25
    //   1798: aload 23
    //   1800: astore 24
    //   1802: lload 11
    //   1804: lstore 17
    //   1806: aload 23
    //   1808: astore 28
    //   1810: getstatic 29	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   1813: ldc_w 732
    //   1816: invokestatic 124	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1819: iconst_0
    //   1820: istore 4
    //   1822: bipush 195
    //   1824: istore_2
    //   1825: aload 29
    //   1827: astore_1
    //   1828: goto -818 -> 1010
    //   1831: aconst_null
    //   1832: astore 23
    //   1834: iconst_0
    //   1835: istore 4
    //   1837: lconst_0
    //   1838: lstore 13
    //   1840: aload 30
    //   1842: astore 24
    //   1844: goto -1716 -> 128
    //   1847: astore_1
    //   1848: aload_1
    //   1849: invokevirtual 622	java/io/IOException:printStackTrace	()V
    //   1852: lload 13
    //   1854: lstore 11
    //   1856: iload_3
    //   1857: istore_2
    //   1858: aload 23
    //   1860: astore_1
    //   1861: goto -1701 -> 160
    //   1864: astore_1
    //   1865: aload_1
    //   1866: invokevirtual 622	java/io/IOException:printStackTrace	()V
    //   1869: lload 13
    //   1871: lstore 11
    //   1873: iload_3
    //   1874: istore_2
    //   1875: aload 25
    //   1877: astore_1
    //   1878: goto -1718 -> 160
    //   1881: astore_1
    //   1882: aconst_null
    //   1883: astore 23
    //   1885: iconst_0
    //   1886: istore 4
    //   1888: aload 27
    //   1890: astore 24
    //   1892: getstatic 29	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   1895: new 71	java/lang/StringBuilder
    //   1898: dup
    //   1899: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   1902: ldc_w 725
    //   1905: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1908: aload_1
    //   1909: invokevirtual 733	java/net/SocketTimeoutException:getMessage	()Ljava/lang/String;
    //   1912: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1915: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1918: aload_1
    //   1919: invokestatic 535	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1922: bipush 248
    //   1924: istore_3
    //   1925: iload 4
    //   1927: istore 5
    //   1929: lload 13
    //   1931: lstore 11
    //   1933: iload_3
    //   1934: istore_2
    //   1935: aload 23
    //   1937: astore_1
    //   1938: aload 27
    //   1940: ifnull +286 -> 2226
    //   1943: aload 27
    //   1945: invokevirtual 618	java/io/InputStream:close	()V
    //   1948: lload 13
    //   1950: lstore 11
    //   1952: iload_3
    //   1953: istore_2
    //   1954: aload 23
    //   1956: astore_1
    //   1957: goto -1797 -> 160
    //   1960: astore_1
    //   1961: aload_1
    //   1962: invokevirtual 622	java/io/IOException:printStackTrace	()V
    //   1965: lload 13
    //   1967: lstore 11
    //   1969: iload_3
    //   1970: istore_2
    //   1971: aload 23
    //   1973: astore_1
    //   1974: goto -1814 -> 160
    //   1977: astore_0
    //   1978: aload 26
    //   1980: astore 24
    //   1982: getstatic 29	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   1985: new 71	java/lang/StringBuilder
    //   1988: dup
    //   1989: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   1992: ldc_w 725
    //   1995: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1998: aload_0
    //   1999: invokevirtual 734	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException:getMessage	()Ljava/lang/String;
    //   2002: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2005: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2008: aload_0
    //   2009: invokestatic 535	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2012: iload 5
    //   2014: istore 4
    //   2016: aload 26
    //   2018: ifnull -1735 -> 283
    //   2021: aload 26
    //   2023: invokevirtual 618	java/io/InputStream:close	()V
    //   2026: iload 5
    //   2028: ireturn
    //   2029: astore_0
    //   2030: aload_0
    //   2031: invokevirtual 622	java/io/IOException:printStackTrace	()V
    //   2034: iload 5
    //   2036: ireturn
    //   2037: astore_1
    //   2038: iload 6
    //   2040: istore 4
    //   2042: aload 25
    //   2044: astore 24
    //   2046: getstatic 29	com/tencent/open/appcommon/ResourceUpdater:a	Ljava/lang/String;
    //   2049: new 71	java/lang/StringBuilder
    //   2052: dup
    //   2053: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   2056: ldc_w 725
    //   2059: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2062: aload_1
    //   2063: invokevirtual 687	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2066: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2069: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2072: aload_1
    //   2073: invokestatic 535	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2076: aload 25
    //   2078: astore 24
    //   2080: new 71	java/lang/StringBuilder
    //   2083: dup
    //   2084: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   2087: ldc_w 689
    //   2090: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2093: aload_1
    //   2094: invokevirtual 687	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2097: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2100: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2103: astore 23
    //   2105: bipush 250
    //   2107: istore_3
    //   2108: iload 4
    //   2110: istore 5
    //   2112: lload 15
    //   2114: lstore 11
    //   2116: iload_3
    //   2117: istore_2
    //   2118: aload 23
    //   2120: astore_1
    //   2121: aload 25
    //   2123: ifnull +103 -> 2226
    //   2126: aload 25
    //   2128: invokevirtual 618	java/io/InputStream:close	()V
    //   2131: lload 15
    //   2133: lstore 11
    //   2135: iload_3
    //   2136: istore_2
    //   2137: aload 23
    //   2139: astore_1
    //   2140: goto -1980 -> 160
    //   2143: astore_1
    //   2144: aload_1
    //   2145: invokevirtual 622	java/io/IOException:printStackTrace	()V
    //   2148: lload 15
    //   2150: lstore 11
    //   2152: iload_3
    //   2153: istore_2
    //   2154: aload 23
    //   2156: astore_1
    //   2157: goto -1997 -> 160
    //   2160: astore_0
    //   2161: aload 24
    //   2163: ifnull +8 -> 2171
    //   2166: aload 24
    //   2168: invokevirtual 618	java/io/InputStream:close	()V
    //   2171: aload_0
    //   2172: athrow
    //   2173: astore_1
    //   2174: aload_1
    //   2175: invokevirtual 622	java/io/IOException:printStackTrace	()V
    //   2178: goto -7 -> 2171
    //   2181: ldc_w 736
    //   2184: astore_1
    //   2185: goto -1969 -> 216
    //   2188: astore_1
    //   2189: iload 8
    //   2191: istore 4
    //   2193: lload 11
    //   2195: lstore 13
    //   2197: aload 23
    //   2199: astore 27
    //   2201: aload 28
    //   2203: astore 23
    //   2205: goto -317 -> 1888
    //   2208: astore_1
    //   2209: aconst_null
    //   2210: astore 25
    //   2212: iconst_0
    //   2213: istore 4
    //   2215: lload 17
    //   2217: lstore 13
    //   2219: aload 28
    //   2221: astore 23
    //   2223: goto -738 -> 1485
    //   2226: iload 5
    //   2228: istore 4
    //   2230: goto -2070 -> 160
    //   2233: iload_2
    //   2234: istore_3
    //   2235: aload 23
    //   2237: astore 24
    //   2239: aload_1
    //   2240: astore 23
    //   2242: goto -2114 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2245	0	paramString1	String
    //   0	2245	1	paramString2	String
    //   31	2203	2	i	int
    //   123	2112	3	j	int
    //   13	2216	4	bool1	boolean
    //   66	2161	5	bool2	boolean
    //   74	1965	6	bool3	boolean
    //   1	1477	7	bool4	boolean
    //   4	2186	8	bool5	boolean
    //   7	1780	9	bool6	boolean
    //   10	1447	10	bool7	boolean
    //   28	2166	11	l1	long
    //   58	2160	13	l2	long
    //   78	2071	15	l3	long
    //   90	2126	17	l4	long
    //   18	223	19	l5	long
    //   25	227	21	l6	long
    //   39	2202	23	localObject1	Object
    //   86	2152	24	localObject2	Object
    //   82	2129	25	localObject3	Object
    //   70	1952	26	localObject4	Object
    //   62	2138	27	localObject5	Object
    //   94	2126	28	localObject6	Object
    //   36	1790	29	localObject7	Object
    //   54	1787	30	localFile	java.io.File
    //   33	912	31	str	String
    //   42	317	32	localObject8	Object
    //   45	326	33	localObject9	Object
    //   48	327	34	localObject10	Object
    //   51	332	35	localObject11	Object
    //   103	284	36	localHttpResponse	HttpResponse
    // Exception table:
    //   from	to	target	type
    //   455	460	462	java/io/IOException
    //   1048	1062	1472	org/apache/http/conn/ConnectTimeoutException
    //   1460	1469	1472	org/apache/http/conn/ConnectTimeoutException
    //   146	151	1847	java/io/IOException
    //   1540	1545	1864	java/io/IOException
    //   96	105	1881	java/net/SocketTimeoutException
    //   326	339	1881	java/net/SocketTimeoutException
    //   386	393	1881	java/net/SocketTimeoutException
    //   438	447	1881	java/net/SocketTimeoutException
    //   509	521	1881	java/net/SocketTimeoutException
    //   561	569	1881	java/net/SocketTimeoutException
    //   609	618	1881	java/net/SocketTimeoutException
    //   673	686	1881	java/net/SocketTimeoutException
    //   726	732	1881	java/net/SocketTimeoutException
    //   772	780	1881	java/net/SocketTimeoutException
    //   820	829	1881	java/net/SocketTimeoutException
    //   869	878	1881	java/net/SocketTimeoutException
    //   918	955	1881	java/net/SocketTimeoutException
    //   995	1001	1881	java/net/SocketTimeoutException
    //   1109	1118	1881	java/net/SocketTimeoutException
    //   1158	1166	1881	java/net/SocketTimeoutException
    //   1206	1215	1881	java/net/SocketTimeoutException
    //   1255	1266	1881	java/net/SocketTimeoutException
    //   1306	1315	1881	java/net/SocketTimeoutException
    //   1355	1364	1881	java/net/SocketTimeoutException
    //   1404	1410	1881	java/net/SocketTimeoutException
    //   1597	1602	1881	java/net/SocketTimeoutException
    //   1642	1651	1881	java/net/SocketTimeoutException
    //   1703	1712	1881	java/net/SocketTimeoutException
    //   1764	1770	1881	java/net/SocketTimeoutException
    //   1810	1819	1881	java/net/SocketTimeoutException
    //   1943	1948	1960	java/io/IOException
    //   96	105	1977	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   326	339	1977	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   386	393	1977	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   438	447	1977	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   509	521	1977	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   561	569	1977	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   609	618	1977	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   673	686	1977	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   726	732	1977	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   772	780	1977	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   820	829	1977	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   869	878	1977	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   918	955	1977	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   995	1001	1977	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   1048	1062	1977	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   1109	1118	1977	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   1158	1166	1977	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   1206	1215	1977	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   1255	1266	1977	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   1306	1315	1977	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   1355	1364	1977	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   1404	1410	1977	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   1460	1469	1977	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   1597	1602	1977	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   1642	1651	1977	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   1703	1712	1977	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   1764	1770	1977	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   1810	1819	1977	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   2021	2026	2029	java/io/IOException
    //   96	105	2037	java/lang/Exception
    //   326	339	2037	java/lang/Exception
    //   386	393	2037	java/lang/Exception
    //   438	447	2037	java/lang/Exception
    //   509	521	2037	java/lang/Exception
    //   561	569	2037	java/lang/Exception
    //   609	618	2037	java/lang/Exception
    //   673	686	2037	java/lang/Exception
    //   726	732	2037	java/lang/Exception
    //   772	780	2037	java/lang/Exception
    //   820	829	2037	java/lang/Exception
    //   869	878	2037	java/lang/Exception
    //   918	955	2037	java/lang/Exception
    //   995	1001	2037	java/lang/Exception
    //   1048	1062	2037	java/lang/Exception
    //   1109	1118	2037	java/lang/Exception
    //   1158	1166	2037	java/lang/Exception
    //   1206	1215	2037	java/lang/Exception
    //   1255	1266	2037	java/lang/Exception
    //   1306	1315	2037	java/lang/Exception
    //   1355	1364	2037	java/lang/Exception
    //   1404	1410	2037	java/lang/Exception
    //   1460	1469	2037	java/lang/Exception
    //   1597	1602	2037	java/lang/Exception
    //   1642	1651	2037	java/lang/Exception
    //   1703	1712	2037	java/lang/Exception
    //   1764	1770	2037	java/lang/Exception
    //   1810	1819	2037	java/lang/Exception
    //   2126	2131	2143	java/io/IOException
    //   96	105	2160	finally
    //   326	339	2160	finally
    //   386	393	2160	finally
    //   438	447	2160	finally
    //   509	521	2160	finally
    //   561	569	2160	finally
    //   609	618	2160	finally
    //   673	686	2160	finally
    //   726	732	2160	finally
    //   772	780	2160	finally
    //   820	829	2160	finally
    //   869	878	2160	finally
    //   918	955	2160	finally
    //   995	1001	2160	finally
    //   1048	1062	2160	finally
    //   1109	1118	2160	finally
    //   1158	1166	2160	finally
    //   1206	1215	2160	finally
    //   1255	1266	2160	finally
    //   1306	1315	2160	finally
    //   1355	1364	2160	finally
    //   1404	1410	2160	finally
    //   1460	1469	2160	finally
    //   1489	1519	2160	finally
    //   1597	1602	2160	finally
    //   1642	1651	2160	finally
    //   1703	1712	2160	finally
    //   1764	1770	2160	finally
    //   1810	1819	2160	finally
    //   1892	1922	2160	finally
    //   1982	2012	2160	finally
    //   2046	2076	2160	finally
    //   2080	2105	2160	finally
    //   2166	2171	2173	java/io/IOException
    //   1048	1062	2188	java/net/SocketTimeoutException
    //   1460	1469	2188	java/net/SocketTimeoutException
    //   96	105	2208	org/apache/http/conn/ConnectTimeoutException
    //   326	339	2208	org/apache/http/conn/ConnectTimeoutException
    //   386	393	2208	org/apache/http/conn/ConnectTimeoutException
    //   438	447	2208	org/apache/http/conn/ConnectTimeoutException
    //   509	521	2208	org/apache/http/conn/ConnectTimeoutException
    //   561	569	2208	org/apache/http/conn/ConnectTimeoutException
    //   609	618	2208	org/apache/http/conn/ConnectTimeoutException
    //   673	686	2208	org/apache/http/conn/ConnectTimeoutException
    //   726	732	2208	org/apache/http/conn/ConnectTimeoutException
    //   772	780	2208	org/apache/http/conn/ConnectTimeoutException
    //   820	829	2208	org/apache/http/conn/ConnectTimeoutException
    //   869	878	2208	org/apache/http/conn/ConnectTimeoutException
    //   918	955	2208	org/apache/http/conn/ConnectTimeoutException
    //   995	1001	2208	org/apache/http/conn/ConnectTimeoutException
    //   1109	1118	2208	org/apache/http/conn/ConnectTimeoutException
    //   1158	1166	2208	org/apache/http/conn/ConnectTimeoutException
    //   1206	1215	2208	org/apache/http/conn/ConnectTimeoutException
    //   1255	1266	2208	org/apache/http/conn/ConnectTimeoutException
    //   1306	1315	2208	org/apache/http/conn/ConnectTimeoutException
    //   1355	1364	2208	org/apache/http/conn/ConnectTimeoutException
    //   1404	1410	2208	org/apache/http/conn/ConnectTimeoutException
    //   1597	1602	2208	org/apache/http/conn/ConnectTimeoutException
    //   1642	1651	2208	org/apache/http/conn/ConnectTimeoutException
    //   1703	1712	2208	org/apache/http/conn/ConnectTimeoutException
    //   1764	1770	2208	org/apache/http/conn/ConnectTimeoutException
    //   1810	1819	2208	org/apache/http/conn/ConnectTimeoutException
  }
  
  protected static boolean b()
  {
    boolean bool = false;
    try
    {
      long[] arrayOfLong = Common.a();
      long l1 = arrayOfLong[0];
      long l2 = arrayOfLong[1];
      long l3 = System.currentTimeMillis();
      LogUtility.c(a, "lastReportTime=" + l2 + " currentTime=" + l3 + " maxAge=" + l1);
      if ((l3 > l1 * 1000L + l2) || (l3 < l2)) {
        bool = true;
      }
      return bool;
    }
    finally {}
  }
  
  protected static boolean c()
  {
    String str1 = Common.m();
    String str2 = Common.o();
    String str3 = Common.n();
    LogUtility.c(a, "mergeFile oldfile=" + str1 + ",newfile=" + str2 + ",patchfile=" + str3);
    try
    {
      boolean bool = BspatchUtil.a(str1, str3, str2);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      LogUtility.c(a, "mergeFile error : ", localThrowable);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.appcommon.ResourceUpdater
 * JD-Core Version:    0.7.0.1
 */