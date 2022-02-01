package com.tencent.mobileqq.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.mobileqq.transfile.TlsSniSocketFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.http.HttpVersion;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpProtocolParams;

public class HttpDownloadUtil
{
  public static final int a = 2;
  static long jdField_a_of_type_Long = ;
  static ConnectivityManager jdField_a_of_type_AndroidNetConnectivityManager;
  static HttpDownloadUtil.IdleConnectionMonitorThread jdField_a_of_type_ComTencentMobileqqUtilsHttpDownloadUtil$IdleConnectionMonitorThread;
  public static final String a = "HttpDownloadUtil";
  public static final DefaultHttpClient a;
  private static boolean jdField_a_of_type_Boolean = false;
  public static final int b = 2;
  private static String jdField_b_of_type_JavaLangString;
  private static boolean jdField_b_of_type_Boolean = false;
  public static final int c = 0;
  public static final int d = 1;
  public static final int e = 2;
  public static final int f = 3;
  public static final int g = 4;
  public static final int h = 5;
  public static final int i = 6;
  @Deprecated
  public static final int j = 7;
  public static final int k = 8;
  public static final int l = 9;
  public static final int m = 10;
  public static final int n = 11;
  public static final int o = 12;
  public static final int p = 13;
  public static final int q = 14;
  public static final int r = 15;
  public static final int s = 16;
  public static final int t = 17;
  public static final int u = 18;
  public static final int v = 19;
  
  static
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
    HttpProtocolParams.setContentCharset(localBasicHttpParams, "ISO-8859-1");
    HttpProtocolParams.setUseExpectContinue(localBasicHttpParams, true);
    Object localObject = new SchemeRegistry();
    ((SchemeRegistry)localObject).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    try
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        SSLSocketFactory localSSLSocketFactory = SSLSocketFactory.getSocketFactory();
        localSSLSocketFactory.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        ((SchemeRegistry)localObject).register(new Scheme("https", localSSLSocketFactory, 443));
      }
      for (;;)
      {
        localObject = new ThreadSafeClientConnManager(localBasicHttpParams, (SchemeRegistry)localObject);
        jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient = new DefaultHttpClient((ClientConnectionManager)localObject, localBasicHttpParams);
        jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient.setHttpRequestRetryHandler(new DefaultHttpRequestRetryHandler());
        jdField_a_of_type_ComTencentMobileqqUtilsHttpDownloadUtil$IdleConnectionMonitorThread = new HttpDownloadUtil.IdleConnectionMonitorThread((ClientConnectionManager)localObject);
        jdField_a_of_type_ComTencentMobileqqUtilsHttpDownloadUtil$IdleConnectionMonitorThread.start();
        jdField_a_of_type_AndroidNetConnectivityManager = (ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity");
        jdField_b_of_type_JavaLangString = null;
        jdField_a_of_type_Boolean = false;
        jdField_b_of_type_Boolean = false;
        return;
        ((SchemeRegistry)localObject).register(new Scheme("https", new TlsSniSocketFactory(HttpDownloadUtil.class.getSimpleName()), 443));
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("HttpDownloadUtil", 2, "createHttpClient():Can't support https on this devices.", localException);
        }
      }
    }
  }
  
  /* Error */
  private static int a(AppInterface paramAppInterface, DownloadInfo paramDownloadInfo, NetworkInfo paramNetworkInfo, HttpDownloadUtil.HttpDownloadListener paramHttpDownloadListener)
  {
    // Byte code:
    //   0: new 225	java/net/URL
    //   3: dup
    //   4: aload_1
    //   5: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   8: invokespecial 229	java/net/URL:<init>	(Ljava/lang/String;)V
    //   11: astore 27
    //   13: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   16: lstore 12
    //   18: new 4	java/lang/Object
    //   21: dup
    //   22: invokespecial 214	java/lang/Object:<init>	()V
    //   25: astore 28
    //   27: aload_1
    //   28: getfield 232	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   31: invokevirtual 238	java/io/File:getParentFile	()Ljava/io/File;
    //   34: astore 17
    //   36: aload 17
    //   38: ifnull +145 -> 183
    //   41: aload 17
    //   43: invokevirtual 241	java/io/File:exists	()Z
    //   46: ifne +137 -> 183
    //   49: aload 17
    //   51: invokevirtual 244	java/io/File:mkdirs	()Z
    //   54: ifne +129 -> 183
    //   57: aload_3
    //   58: ifnull +15 -> 73
    //   61: aload_3
    //   62: aload 27
    //   64: invokevirtual 247	java/net/URL:toString	()Ljava/lang/String;
    //   67: iconst_4
    //   68: invokeinterface 252 3 0
    //   73: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   76: ifeq +32 -> 108
    //   79: ldc 15
    //   81: iconst_2
    //   82: new 254	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   89: ldc_w 257
    //   92: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload_1
    //   96: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   99: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   108: iconst_4
    //   109: istore 6
    //   111: iload 6
    //   113: ireturn
    //   114: astore_0
    //   115: aload_0
    //   116: invokevirtual 268	java/net/MalformedURLException:printStackTrace	()V
    //   119: aload_1
    //   120: aload_0
    //   121: invokestatic 274	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   124: putfield 276	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   127: iconst_5
    //   128: ireturn
    //   129: astore_0
    //   130: aload_3
    //   131: ifnull +15 -> 146
    //   134: aload_3
    //   135: aload 27
    //   137: invokevirtual 247	java/net/URL:toString	()Ljava/lang/String;
    //   140: iconst_4
    //   141: invokeinterface 252 3 0
    //   146: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   149: ifeq +32 -> 181
    //   152: ldc 15
    //   154: iconst_2
    //   155: new 254	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   162: ldc_w 257
    //   165: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload_1
    //   169: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   172: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   181: iconst_4
    //   182: ireturn
    //   183: aconst_null
    //   184: astore 19
    //   186: aload_1
    //   187: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   190: astore 17
    //   192: new 278	org/apache/http/client/methods/HttpGet
    //   195: dup
    //   196: aload 17
    //   198: invokespecial 279	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   201: astore 26
    //   203: new 72	org/apache/http/params/BasicHttpParams
    //   206: dup
    //   207: invokespecial 75	org/apache/http/params/BasicHttpParams:<init>	()V
    //   210: astore 29
    //   212: aload 29
    //   214: ldc_w 281
    //   217: ldc_w 282
    //   220: invokestatic 287	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   223: invokeinterface 293 3 0
    //   228: pop
    //   229: aload 29
    //   231: ldc_w 295
    //   234: ldc_w 282
    //   237: invokestatic 287	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   240: invokeinterface 293 3 0
    //   245: pop
    //   246: invokestatic 300	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   249: astore 17
    //   251: invokestatic 304	android/net/Proxy:getDefaultPort	()I
    //   254: istore 5
    //   256: iconst_0
    //   257: istore 4
    //   259: aload_2
    //   260: ifnull +96 -> 356
    //   263: aload_2
    //   264: invokevirtual 309	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   267: astore 18
    //   269: aload_2
    //   270: invokestatic 314	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   273: ifeq +51 -> 324
    //   276: aload 18
    //   278: ifnull +14 -> 292
    //   281: aload 18
    //   283: ldc_w 316
    //   286: invokevirtual 320	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   289: ifeq +35 -> 324
    //   292: aload 17
    //   294: ifnull +30 -> 324
    //   297: iload 5
    //   299: ifle +25 -> 324
    //   302: aload 29
    //   304: ldc_w 322
    //   307: new 324	org/apache/http/HttpHost
    //   310: dup
    //   311: aload 17
    //   313: iload 5
    //   315: invokespecial 326	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   318: invokeinterface 293 3 0
    //   323: pop
    //   324: aload_2
    //   325: invokestatic 314	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   328: ifeq +574 -> 902
    //   331: sipush 2048
    //   334: istore 4
    //   336: aload 29
    //   338: ldc_w 328
    //   341: iload 4
    //   343: invokeinterface 332 3 0
    //   348: pop
    //   349: aload 26
    //   351: aload 29
    //   353: invokevirtual 336	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   356: new 234	java/io/File
    //   359: dup
    //   360: aload_1
    //   361: invokevirtual 338	com/tencent/mobileqq/emoticon/DownloadInfo:a	()Ljava/lang/String;
    //   364: invokespecial 339	java/io/File:<init>	(Ljava/lang/String;)V
    //   367: astore 30
    //   369: aload 30
    //   371: invokevirtual 241	java/io/File:exists	()Z
    //   374: ifeq +9 -> 383
    //   377: aload 30
    //   379: invokevirtual 342	java/io/File:delete	()Z
    //   382: pop
    //   383: aconst_null
    //   384: astore 17
    //   386: iconst_m1
    //   387: istore 9
    //   389: iconst_5
    //   390: istore 10
    //   392: iload 9
    //   394: ifne +38 -> 432
    //   397: aload 29
    //   399: ldc_w 322
    //   402: new 324	org/apache/http/HttpHost
    //   405: dup
    //   406: aload 27
    //   408: invokevirtual 345	java/net/URL:getHost	()Ljava/lang/String;
    //   411: aload 27
    //   413: invokevirtual 348	java/net/URL:getPort	()I
    //   416: invokespecial 326	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   419: invokeinterface 293 3 0
    //   424: pop
    //   425: aload 26
    //   427: aload 29
    //   429: invokevirtual 336	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   432: aload 19
    //   434: astore 24
    //   436: aload 17
    //   438: astore 20
    //   440: iload 4
    //   442: istore 6
    //   444: aload 19
    //   446: astore 23
    //   448: aload 17
    //   450: astore 21
    //   452: iload 4
    //   454: istore 8
    //   456: aload 19
    //   458: astore 25
    //   460: aload 17
    //   462: astore 22
    //   464: iload 10
    //   466: istore 7
    //   468: getstatic 149	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   471: new 324	org/apache/http/HttpHost
    //   474: dup
    //   475: aload 27
    //   477: invokevirtual 345	java/net/URL:getHost	()Ljava/lang/String;
    //   480: invokespecial 349	org/apache/http/HttpHost:<init>	(Ljava/lang/String;)V
    //   483: aload 26
    //   485: invokevirtual 353	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpResponse;
    //   488: astore 18
    //   490: aload 19
    //   492: astore 24
    //   494: aload 17
    //   496: astore 20
    //   498: iload 4
    //   500: istore 6
    //   502: aload 19
    //   504: astore 23
    //   506: aload 17
    //   508: astore 21
    //   510: iload 4
    //   512: istore 8
    //   514: aload 19
    //   516: astore 25
    //   518: aload 17
    //   520: astore 22
    //   522: iload 10
    //   524: istore 7
    //   526: aload 18
    //   528: invokeinterface 359 1 0
    //   533: astore 31
    //   535: aload 19
    //   537: astore 24
    //   539: aload 17
    //   541: astore 20
    //   543: iload 4
    //   545: istore 6
    //   547: aload 19
    //   549: astore 23
    //   551: aload 17
    //   553: astore 21
    //   555: iload 4
    //   557: istore 8
    //   559: aload 19
    //   561: astore 25
    //   563: aload 17
    //   565: astore 22
    //   567: iload 10
    //   569: istore 7
    //   571: aload 18
    //   573: invokeinterface 363 1 0
    //   578: pop
    //   579: aload 19
    //   581: astore 24
    //   583: aload 17
    //   585: astore 20
    //   587: iload 4
    //   589: istore 6
    //   591: aload 19
    //   593: astore 23
    //   595: aload 17
    //   597: astore 21
    //   599: iload 4
    //   601: istore 8
    //   603: aload 19
    //   605: astore 25
    //   607: aload 17
    //   609: astore 22
    //   611: iload 10
    //   613: istore 7
    //   615: aload 31
    //   617: invokeinterface 368 1 0
    //   622: istore 5
    //   624: aload_3
    //   625: ifnull +52 -> 677
    //   628: aload 19
    //   630: astore 24
    //   632: aload 17
    //   634: astore 20
    //   636: iload 4
    //   638: istore 6
    //   640: aload 19
    //   642: astore 23
    //   644: aload 17
    //   646: astore 21
    //   648: iload 4
    //   650: istore 8
    //   652: aload 19
    //   654: astore 25
    //   656: aload 17
    //   658: astore 22
    //   660: iload 10
    //   662: istore 7
    //   664: aload_3
    //   665: aload 27
    //   667: invokevirtual 247	java/net/URL:toString	()Ljava/lang/String;
    //   670: iload 5
    //   672: invokeinterface 370 3 0
    //   677: aload 19
    //   679: astore 24
    //   681: aload 17
    //   683: astore 20
    //   685: iload 4
    //   687: istore 6
    //   689: aload 19
    //   691: astore 23
    //   693: aload 17
    //   695: astore 21
    //   697: iload 4
    //   699: istore 8
    //   701: aload 19
    //   703: astore 25
    //   705: aload 17
    //   707: astore 22
    //   709: iload 10
    //   711: istore 7
    //   713: aload 18
    //   715: invokeinterface 374 1 0
    //   720: astore 17
    //   722: sipush 200
    //   725: iload 5
    //   727: if_icmpne +1433 -> 2160
    //   730: aload 19
    //   732: astore 24
    //   734: aload 17
    //   736: astore 20
    //   738: iload 4
    //   740: istore 6
    //   742: aload 19
    //   744: astore 23
    //   746: aload 17
    //   748: astore 21
    //   750: iload 4
    //   752: istore 8
    //   754: aload 19
    //   756: astore 25
    //   758: aload 17
    //   760: astore 22
    //   762: iload 10
    //   764: istore 7
    //   766: aload 17
    //   768: invokeinterface 379 1 0
    //   773: lstore 14
    //   775: aconst_null
    //   776: astore 20
    //   778: iconst_0
    //   779: istore 5
    //   781: new 381	java/io/FileOutputStream
    //   784: dup
    //   785: aload 30
    //   787: invokespecial 384	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   790: astore 18
    //   792: aload 17
    //   794: invokeinterface 388 1 0
    //   799: astore 19
    //   801: aload 19
    //   803: astore 20
    //   805: iload 4
    //   807: ifne +1888 -> 2695
    //   810: sipush 2048
    //   813: istore 4
    //   815: iload 4
    //   817: newarray byte
    //   819: astore 19
    //   821: iload 5
    //   823: i2l
    //   824: lload 14
    //   826: lcmp
    //   827: ifge +83 -> 910
    //   830: aload 20
    //   832: aload 19
    //   834: invokevirtual 394	java/io/InputStream:read	([B)I
    //   837: istore 6
    //   839: aload 18
    //   841: aload 19
    //   843: iconst_0
    //   844: iload 6
    //   846: invokevirtual 400	java/io/OutputStream:write	([BII)V
    //   849: iload 5
    //   851: iload 6
    //   853: iadd
    //   854: istore 5
    //   856: aload_3
    //   857: ifnull +1835 -> 2692
    //   860: aload_3
    //   861: aload 27
    //   863: invokevirtual 247	java/net/URL:toString	()Ljava/lang/String;
    //   866: lload 14
    //   868: iload 5
    //   870: i2l
    //   871: invokeinterface 403 6 0
    //   876: goto -55 -> 821
    //   879: astore 18
    //   881: new 278	org/apache/http/client/methods/HttpGet
    //   884: dup
    //   885: aload 17
    //   887: invokestatic 406	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   890: invokespecial 279	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   893: astore 26
    //   895: goto -692 -> 203
    //   898: astore_0
    //   899: bipush 13
    //   901: ireturn
    //   902: sipush 4096
    //   905: istore 4
    //   907: goto -571 -> 336
    //   910: iload 5
    //   912: i2l
    //   913: lload 14
    //   915: lcmp
    //   916: ifne +655 -> 1571
    //   919: iconst_0
    //   920: istore 10
    //   922: iconst_0
    //   923: istore 11
    //   925: iconst_0
    //   926: istore 8
    //   928: iload 8
    //   930: istore 5
    //   932: iload 10
    //   934: istore 6
    //   936: iload 11
    //   938: istore 7
    //   940: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   943: ifeq +44 -> 987
    //   946: iload 10
    //   948: istore 6
    //   950: iload 11
    //   952: istore 7
    //   954: ldc 15
    //   956: iconst_2
    //   957: new 254	java/lang/StringBuilder
    //   960: dup
    //   961: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   964: ldc_w 408
    //   967: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   970: aload_1
    //   971: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   974: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   977: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   980: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   983: iload 8
    //   985: istore 5
    //   987: iload 5
    //   989: istore 6
    //   991: iload 5
    //   993: istore 7
    //   995: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   998: ifeq +53 -> 1051
    //   1001: iload 5
    //   1003: istore 6
    //   1005: iload 5
    //   1007: istore 7
    //   1009: ldc_w 410
    //   1012: iconst_2
    //   1013: new 254	java/lang/StringBuilder
    //   1016: dup
    //   1017: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   1020: ldc_w 412
    //   1023: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1026: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   1029: invokevirtual 415	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1032: ldc_w 417
    //   1035: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1038: aload_1
    //   1039: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1042: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1045: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1048: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1051: aload_1
    //   1052: ifnull +107 -> 1159
    //   1055: iload 5
    //   1057: istore 6
    //   1059: iload 5
    //   1061: istore 7
    //   1063: aload_1
    //   1064: getfield 419	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Int	I
    //   1067: tableswitch	default:+1631 -> 2698, 10001:+664->1731
    //   1085: iconst_2
    //   1086: istore 6
    //   1088: iload 5
    //   1090: istore 7
    //   1092: aload_2
    //   1093: invokestatic 314	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   1096: ifeq +1001 -> 2097
    //   1099: iload 5
    //   1101: istore 6
    //   1103: iload 5
    //   1105: istore 7
    //   1107: iconst_3
    //   1108: anewarray 270	java/lang/String
    //   1111: astore 19
    //   1113: aload 19
    //   1115: iconst_0
    //   1116: ldc_w 421
    //   1119: aastore
    //   1120: aload 19
    //   1122: iconst_1
    //   1123: ldc_w 423
    //   1126: aastore
    //   1127: aload 19
    //   1129: iconst_2
    //   1130: ldc_w 425
    //   1133: aastore
    //   1134: aload 19
    //   1136: ifnull +23 -> 1159
    //   1139: iload 5
    //   1141: istore 6
    //   1143: iload 5
    //   1145: istore 7
    //   1147: aload_0
    //   1148: aload_0
    //   1149: invokevirtual 428	com/tencent/common/app/AppInterface:a	()Ljava/lang/String;
    //   1152: aload 19
    //   1154: lload 14
    //   1156: invokevirtual 431	com/tencent/common/app/AppInterface:a	(Ljava/lang/String;[Ljava/lang/String;J)V
    //   1159: iload 5
    //   1161: istore 6
    //   1163: iload 5
    //   1165: istore 7
    //   1167: aload 30
    //   1169: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   1172: invokevirtual 435	java/io/File:setLastModified	(J)Z
    //   1175: pop
    //   1176: iload 5
    //   1178: istore 6
    //   1180: iload 5
    //   1182: istore 7
    //   1184: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1187: ifeq +66 -> 1253
    //   1190: iload 5
    //   1192: istore 6
    //   1194: iload 5
    //   1196: istore 7
    //   1198: ldc 15
    //   1200: iconst_2
    //   1201: new 254	java/lang/StringBuilder
    //   1204: dup
    //   1205: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   1208: ldc_w 437
    //   1211: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1214: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   1217: lload 12
    //   1219: lsub
    //   1220: invokevirtual 415	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1223: ldc_w 439
    //   1226: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1229: lload 14
    //   1231: invokevirtual 415	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1234: ldc_w 441
    //   1237: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1240: aload_1
    //   1241: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1244: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1247: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1250: invokestatic 443	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1253: aload 20
    //   1255: ifnull +1434 -> 2689
    //   1258: iload 5
    //   1260: istore 7
    //   1262: iload 4
    //   1264: istore 6
    //   1266: aload 18
    //   1268: astore 21
    //   1270: iload 4
    //   1272: istore 8
    //   1274: aload 18
    //   1276: astore 22
    //   1278: aload 18
    //   1280: astore 23
    //   1282: aload 20
    //   1284: invokevirtual 446	java/io/InputStream:close	()V
    //   1287: iload 5
    //   1289: ifne +92 -> 1381
    //   1292: aload 18
    //   1294: astore 24
    //   1296: aload 17
    //   1298: astore 20
    //   1300: iload 4
    //   1302: istore 6
    //   1304: aload 18
    //   1306: astore 23
    //   1308: aload 17
    //   1310: astore 21
    //   1312: iload 4
    //   1314: istore 8
    //   1316: aload 18
    //   1318: astore 25
    //   1320: aload 17
    //   1322: astore 22
    //   1324: iload 5
    //   1326: istore 7
    //   1328: aload_1
    //   1329: getfield 232	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   1332: ifnull +49 -> 1381
    //   1335: aload 18
    //   1337: astore 24
    //   1339: aload 17
    //   1341: astore 20
    //   1343: iload 4
    //   1345: istore 6
    //   1347: aload 18
    //   1349: astore 23
    //   1351: aload 17
    //   1353: astore 21
    //   1355: iload 4
    //   1357: istore 8
    //   1359: aload 18
    //   1361: astore 25
    //   1363: aload 17
    //   1365: astore 22
    //   1367: iload 5
    //   1369: istore 7
    //   1371: aload 30
    //   1373: aload_1
    //   1374: getfield 232	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   1377: invokevirtual 450	java/io/File:renameTo	(Ljava/io/File;)Z
    //   1380: pop
    //   1381: aload_3
    //   1382: ifnull +52 -> 1434
    //   1385: aload 18
    //   1387: astore 24
    //   1389: aload 17
    //   1391: astore 20
    //   1393: iload 4
    //   1395: istore 6
    //   1397: aload 18
    //   1399: astore 23
    //   1401: aload 17
    //   1403: astore 21
    //   1405: iload 4
    //   1407: istore 8
    //   1409: aload 18
    //   1411: astore 25
    //   1413: aload 17
    //   1415: astore 22
    //   1417: iload 5
    //   1419: istore 7
    //   1421: aload_3
    //   1422: aload 27
    //   1424: invokevirtual 247	java/net/URL:toString	()Ljava/lang/String;
    //   1427: iload 5
    //   1429: invokeinterface 252 3 0
    //   1434: aload 17
    //   1436: ifnull +10 -> 1446
    //   1439: aload 17
    //   1441: invokeinterface 453 1 0
    //   1446: aload 18
    //   1448: ifnull +1227 -> 2675
    //   1451: aload 18
    //   1453: invokevirtual 454	java/io/OutputStream:close	()V
    //   1456: aload 18
    //   1458: astore 20
    //   1460: aload 17
    //   1462: astore 19
    //   1464: iload 9
    //   1466: iconst_1
    //   1467: iadd
    //   1468: istore 9
    //   1470: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1473: ifeq +43 -> 1516
    //   1476: ldc 15
    //   1478: iconst_2
    //   1479: new 254	java/lang/StringBuilder
    //   1482: dup
    //   1483: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   1486: ldc_w 456
    //   1489: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1492: iload 5
    //   1494: invokevirtual 459	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1497: ldc_w 461
    //   1500: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1503: aload_1
    //   1504: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1507: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1510: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1513: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1516: iload 9
    //   1518: iconst_2
    //   1519: if_icmpge +22 -> 1541
    //   1522: iload 5
    //   1524: ifeq +17 -> 1541
    //   1527: aload 28
    //   1529: monitorenter
    //   1530: aload 28
    //   1532: ldc2_w 462
    //   1535: invokevirtual 467	java/lang/Object:wait	(J)V
    //   1538: aload 28
    //   1540: monitorexit
    //   1541: iload 5
    //   1543: istore 6
    //   1545: iload 5
    //   1547: ifeq -1436 -> 111
    //   1550: iload 5
    //   1552: istore 6
    //   1554: iload 9
    //   1556: iconst_2
    //   1557: if_icmpge -1446 -> 111
    //   1560: aload 19
    //   1562: astore 17
    //   1564: aload 20
    //   1566: astore 19
    //   1568: goto -1179 -> 389
    //   1571: bipush 8
    //   1573: istore 8
    //   1575: iload 8
    //   1577: istore 6
    //   1579: iload 8
    //   1581: istore 7
    //   1583: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1586: ifeq +62 -> 1648
    //   1589: iload 8
    //   1591: istore 6
    //   1593: iload 8
    //   1595: istore 7
    //   1597: ldc 15
    //   1599: iconst_2
    //   1600: new 254	java/lang/StringBuilder
    //   1603: dup
    //   1604: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   1607: ldc_w 469
    //   1610: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1613: iload 5
    //   1615: invokevirtual 459	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1618: ldc_w 471
    //   1621: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1624: lload 14
    //   1626: invokevirtual 415	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1629: ldc_w 473
    //   1632: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1635: aload_1
    //   1636: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1639: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1642: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1645: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1648: iload 8
    //   1650: istore 5
    //   1652: iload 8
    //   1654: istore 6
    //   1656: iload 8
    //   1658: istore 7
    //   1660: aload 30
    //   1662: invokevirtual 241	java/io/File:exists	()Z
    //   1665: ifeq -678 -> 987
    //   1668: iload 8
    //   1670: istore 6
    //   1672: iload 8
    //   1674: istore 7
    //   1676: aload 30
    //   1678: invokevirtual 342	java/io/File:delete	()Z
    //   1681: pop
    //   1682: iload 8
    //   1684: istore 5
    //   1686: goto -699 -> 987
    //   1689: astore 19
    //   1691: iload 6
    //   1693: istore 5
    //   1695: aload 19
    //   1697: instanceof 475
    //   1700: ifne +15 -> 1715
    //   1703: aload 19
    //   1705: instanceof 477
    //   1708: istore 16
    //   1710: iload 16
    //   1712: ifeq +423 -> 2135
    //   1715: iconst_3
    //   1716: istore 5
    //   1718: aload 20
    //   1720: ifnull +966 -> 2686
    //   1723: aload 20
    //   1725: invokevirtual 446	java/io/InputStream:close	()V
    //   1728: goto -441 -> 1287
    //   1731: iload 5
    //   1733: istore 6
    //   1735: iload 5
    //   1737: istore 7
    //   1739: aload_2
    //   1740: invokestatic 314	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   1743: ifeq +316 -> 2059
    //   1746: iload 5
    //   1748: istore 6
    //   1750: iload 5
    //   1752: istore 7
    //   1754: iconst_3
    //   1755: anewarray 270	java/lang/String
    //   1758: astore 19
    //   1760: aload 19
    //   1762: iconst_0
    //   1763: ldc_w 479
    //   1766: aastore
    //   1767: aload 19
    //   1769: iconst_1
    //   1770: ldc_w 423
    //   1773: aastore
    //   1774: aload 19
    //   1776: iconst_2
    //   1777: ldc_w 425
    //   1780: aastore
    //   1781: goto -647 -> 1134
    //   1784: astore 19
    //   1786: iload 7
    //   1788: istore 5
    //   1790: aload 20
    //   1792: ifnull +32 -> 1824
    //   1795: iload 5
    //   1797: istore 7
    //   1799: iload 4
    //   1801: istore 6
    //   1803: aload 18
    //   1805: astore 21
    //   1807: iload 4
    //   1809: istore 8
    //   1811: aload 18
    //   1813: astore 22
    //   1815: aload 18
    //   1817: astore 23
    //   1819: aload 20
    //   1821: invokevirtual 446	java/io/InputStream:close	()V
    //   1824: iload 5
    //   1826: istore 7
    //   1828: iload 4
    //   1830: istore 6
    //   1832: aload 18
    //   1834: astore 21
    //   1836: iload 4
    //   1838: istore 8
    //   1840: aload 18
    //   1842: astore 22
    //   1844: aload 18
    //   1846: astore 23
    //   1848: aload 19
    //   1850: athrow
    //   1851: astore 19
    //   1853: aload 21
    //   1855: astore 18
    //   1857: iload 7
    //   1859: istore 5
    //   1861: aload 17
    //   1863: astore 21
    //   1865: aload 18
    //   1867: astore 20
    //   1869: aload 19
    //   1871: invokevirtual 480	java/io/IOException:printStackTrace	()V
    //   1874: aload 17
    //   1876: astore 21
    //   1878: aload 18
    //   1880: astore 20
    //   1882: aload 19
    //   1884: instanceof 482
    //   1887: ifeq +340 -> 2227
    //   1890: bipush 10
    //   1892: istore 7
    //   1894: aload 17
    //   1896: astore 21
    //   1898: aload 18
    //   1900: astore 20
    //   1902: ldc 15
    //   1904: iconst_2
    //   1905: new 254	java/lang/StringBuilder
    //   1908: dup
    //   1909: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   1912: ldc_w 484
    //   1915: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1918: iload 7
    //   1920: invokevirtual 459	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1923: ldc_w 486
    //   1926: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1929: aload_1
    //   1930: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1933: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1936: ldc_w 488
    //   1939: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1942: aload 19
    //   1944: invokevirtual 491	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1947: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1950: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1953: invokestatic 494	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1956: aload_3
    //   1957: ifnull +24 -> 1981
    //   1960: aload 17
    //   1962: astore 21
    //   1964: aload 18
    //   1966: astore 20
    //   1968: aload_3
    //   1969: aload 27
    //   1971: invokevirtual 247	java/net/URL:toString	()Ljava/lang/String;
    //   1974: iload 7
    //   1976: invokeinterface 252 3 0
    //   1981: aload 17
    //   1983: ifnull +10 -> 1993
    //   1986: aload 17
    //   1988: invokeinterface 453 1 0
    //   1993: aload 17
    //   1995: astore 19
    //   1997: iload 6
    //   1999: istore 4
    //   2001: aload 18
    //   2003: astore 20
    //   2005: iload 7
    //   2007: istore 5
    //   2009: aload 18
    //   2011: ifnull -547 -> 1464
    //   2014: aload 18
    //   2016: invokevirtual 454	java/io/OutputStream:close	()V
    //   2019: aload 17
    //   2021: astore 19
    //   2023: iload 6
    //   2025: istore 4
    //   2027: aload 18
    //   2029: astore 20
    //   2031: iload 7
    //   2033: istore 5
    //   2035: goto -571 -> 1464
    //   2038: astore 19
    //   2040: aload 17
    //   2042: astore 19
    //   2044: iload 6
    //   2046: istore 4
    //   2048: aload 18
    //   2050: astore 20
    //   2052: iload 7
    //   2054: istore 5
    //   2056: goto -592 -> 1464
    //   2059: iload 5
    //   2061: istore 6
    //   2063: iload 5
    //   2065: istore 7
    //   2067: iconst_3
    //   2068: anewarray 270	java/lang/String
    //   2071: astore 19
    //   2073: aload 19
    //   2075: iconst_0
    //   2076: ldc_w 496
    //   2079: aastore
    //   2080: aload 19
    //   2082: iconst_1
    //   2083: ldc_w 498
    //   2086: aastore
    //   2087: aload 19
    //   2089: iconst_2
    //   2090: ldc_w 425
    //   2093: aastore
    //   2094: goto -960 -> 1134
    //   2097: iload 5
    //   2099: istore 6
    //   2101: iload 5
    //   2103: istore 7
    //   2105: iconst_3
    //   2106: anewarray 270	java/lang/String
    //   2109: astore 19
    //   2111: aload 19
    //   2113: iconst_0
    //   2114: ldc_w 500
    //   2117: aastore
    //   2118: aload 19
    //   2120: iconst_1
    //   2121: ldc_w 498
    //   2124: aastore
    //   2125: aload 19
    //   2127: iconst_2
    //   2128: ldc_w 425
    //   2131: aastore
    //   2132: goto -998 -> 1134
    //   2135: aload 19
    //   2137: instanceof 502
    //   2140: istore 16
    //   2142: iload 16
    //   2144: ifeq +10 -> 2154
    //   2147: bipush 11
    //   2149: istore 5
    //   2151: goto -433 -> 1718
    //   2154: iconst_4
    //   2155: istore 5
    //   2157: goto -439 -> 1718
    //   2160: aload_3
    //   2161: ifnull +36 -> 2197
    //   2164: aload 19
    //   2166: astore 24
    //   2168: aload 17
    //   2170: astore 20
    //   2172: iload 4
    //   2174: istore 6
    //   2176: aload 19
    //   2178: astore 23
    //   2180: aload 17
    //   2182: astore 21
    //   2184: aload_3
    //   2185: aload 27
    //   2187: invokevirtual 247	java/net/URL:toString	()Ljava/lang/String;
    //   2190: iload 5
    //   2192: invokeinterface 252 3 0
    //   2197: aload 19
    //   2199: astore 18
    //   2201: goto -767 -> 1434
    //   2204: astore 19
    //   2206: aload 19
    //   2208: invokevirtual 480	java/io/IOException:printStackTrace	()V
    //   2211: goto -765 -> 1446
    //   2214: astore 19
    //   2216: aload 17
    //   2218: astore 19
    //   2220: aload 18
    //   2222: astore 20
    //   2224: goto -760 -> 1464
    //   2227: aload 17
    //   2229: astore 21
    //   2231: aload 18
    //   2233: astore 20
    //   2235: aload 19
    //   2237: instanceof 475
    //   2240: ifne +461 -> 2701
    //   2243: aload 17
    //   2245: astore 21
    //   2247: aload 18
    //   2249: astore 20
    //   2251: aload 19
    //   2253: instanceof 477
    //   2256: ifeq +6 -> 2262
    //   2259: goto +442 -> 2701
    //   2262: aload 17
    //   2264: astore 21
    //   2266: aload 18
    //   2268: astore 20
    //   2270: aload 19
    //   2272: instanceof 502
    //   2275: ifeq +24 -> 2299
    //   2278: aload 17
    //   2280: astore 21
    //   2282: aload 18
    //   2284: astore 20
    //   2286: aload_1
    //   2287: bipush 11
    //   2289: putfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   2292: iload 5
    //   2294: istore 7
    //   2296: goto -402 -> 1894
    //   2299: iconst_4
    //   2300: istore 7
    //   2302: goto -408 -> 1894
    //   2305: astore 19
    //   2307: aload 19
    //   2309: invokevirtual 480	java/io/IOException:printStackTrace	()V
    //   2312: goto -319 -> 1993
    //   2315: astore 19
    //   2317: iload 8
    //   2319: istore 6
    //   2321: aload 22
    //   2323: astore 18
    //   2325: aload 17
    //   2327: astore 21
    //   2329: aload 18
    //   2331: astore 20
    //   2333: aload 19
    //   2335: invokevirtual 505	java/lang/Exception:printStackTrace	()V
    //   2338: iconst_5
    //   2339: istore 7
    //   2341: aload_3
    //   2342: ifnull +23 -> 2365
    //   2345: aload 17
    //   2347: astore 21
    //   2349: aload 18
    //   2351: astore 20
    //   2353: aload_3
    //   2354: aload 27
    //   2356: invokevirtual 247	java/net/URL:toString	()Ljava/lang/String;
    //   2359: iconst_5
    //   2360: invokeinterface 252 3 0
    //   2365: aload 17
    //   2367: ifnull +10 -> 2377
    //   2370: aload 17
    //   2372: invokeinterface 453 1 0
    //   2377: aload 17
    //   2379: astore 19
    //   2381: iload 6
    //   2383: istore 4
    //   2385: aload 18
    //   2387: astore 20
    //   2389: iload 7
    //   2391: istore 5
    //   2393: aload 18
    //   2395: ifnull -931 -> 1464
    //   2398: aload 18
    //   2400: invokevirtual 454	java/io/OutputStream:close	()V
    //   2403: aload 17
    //   2405: astore 19
    //   2407: iload 6
    //   2409: istore 4
    //   2411: aload 18
    //   2413: astore 20
    //   2415: iload 7
    //   2417: istore 5
    //   2419: goto -955 -> 1464
    //   2422: astore 19
    //   2424: aload 17
    //   2426: astore 19
    //   2428: iload 6
    //   2430: istore 4
    //   2432: aload 18
    //   2434: astore 20
    //   2436: iload 7
    //   2438: istore 5
    //   2440: goto -976 -> 1464
    //   2443: astore 19
    //   2445: aload 19
    //   2447: invokevirtual 480	java/io/IOException:printStackTrace	()V
    //   2450: goto -73 -> 2377
    //   2453: astore_0
    //   2454: aload 23
    //   2456: astore_1
    //   2457: aload 17
    //   2459: ifnull +10 -> 2469
    //   2462: aload 17
    //   2464: invokeinterface 453 1 0
    //   2469: aload_1
    //   2470: ifnull +7 -> 2477
    //   2473: aload_1
    //   2474: invokevirtual 454	java/io/OutputStream:close	()V
    //   2477: aload_0
    //   2478: athrow
    //   2479: astore_2
    //   2480: aload_2
    //   2481: invokevirtual 480	java/io/IOException:printStackTrace	()V
    //   2484: goto -15 -> 2469
    //   2487: astore_0
    //   2488: aload 28
    //   2490: monitorexit
    //   2491: aload_0
    //   2492: athrow
    //   2493: astore_1
    //   2494: goto -17 -> 2477
    //   2497: astore 17
    //   2499: goto -961 -> 1538
    //   2502: astore_0
    //   2503: aload 18
    //   2505: astore_1
    //   2506: goto -49 -> 2457
    //   2509: astore_0
    //   2510: aload 24
    //   2512: astore_1
    //   2513: aload 20
    //   2515: astore 17
    //   2517: goto -60 -> 2457
    //   2520: astore_0
    //   2521: aload 21
    //   2523: astore 17
    //   2525: aload 20
    //   2527: astore_1
    //   2528: goto -71 -> 2457
    //   2531: astore 19
    //   2533: iload 4
    //   2535: istore 6
    //   2537: goto -212 -> 2325
    //   2540: astore 19
    //   2542: aload 23
    //   2544: astore 18
    //   2546: aload 21
    //   2548: astore 17
    //   2550: goto -225 -> 2325
    //   2553: astore 19
    //   2555: iload 4
    //   2557: istore 6
    //   2559: goto -698 -> 1861
    //   2562: astore 19
    //   2564: iload 8
    //   2566: istore 6
    //   2568: aload 25
    //   2570: astore 18
    //   2572: aload 22
    //   2574: astore 17
    //   2576: iload 7
    //   2578: istore 5
    //   2580: goto -719 -> 1861
    //   2583: astore 20
    //   2585: aload 19
    //   2587: astore 18
    //   2589: aload 20
    //   2591: astore 19
    //   2593: iload 4
    //   2595: istore 6
    //   2597: goto -736 -> 1861
    //   2600: astore 19
    //   2602: iconst_5
    //   2603: istore 5
    //   2605: goto -815 -> 1790
    //   2608: astore 19
    //   2610: goto -820 -> 1790
    //   2613: astore 21
    //   2615: aconst_null
    //   2616: astore 20
    //   2618: aload 19
    //   2620: astore 18
    //   2622: iconst_5
    //   2623: istore 5
    //   2625: aload 21
    //   2627: astore 19
    //   2629: goto -839 -> 1790
    //   2632: astore 19
    //   2634: aconst_null
    //   2635: astore 20
    //   2637: iconst_5
    //   2638: istore 5
    //   2640: goto -850 -> 1790
    //   2643: astore 19
    //   2645: iconst_5
    //   2646: istore 5
    //   2648: goto -953 -> 1695
    //   2651: astore 21
    //   2653: aload 19
    //   2655: astore 18
    //   2657: iconst_5
    //   2658: istore 5
    //   2660: aload 21
    //   2662: astore 19
    //   2664: goto -969 -> 1695
    //   2667: astore 19
    //   2669: iconst_5
    //   2670: istore 5
    //   2672: goto -977 -> 1695
    //   2675: aload 17
    //   2677: astore 19
    //   2679: aload 18
    //   2681: astore 20
    //   2683: goto -1219 -> 1464
    //   2686: goto -1399 -> 1287
    //   2689: goto -1402 -> 1287
    //   2692: goto -1871 -> 821
    //   2695: goto -1880 -> 815
    //   2698: goto -1614 -> 1084
    //   2701: iconst_2
    //   2702: istore 7
    //   2704: goto -810 -> 1894
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2707	0	paramAppInterface	AppInterface
    //   0	2707	1	paramDownloadInfo	DownloadInfo
    //   0	2707	2	paramNetworkInfo	NetworkInfo
    //   0	2707	3	paramHttpDownloadListener	HttpDownloadUtil.HttpDownloadListener
    //   257	2337	4	i1	int
    //   254	2417	5	i2	int
    //   109	2487	6	i3	int
    //   466	2237	7	i4	int
    //   454	2111	8	i5	int
    //   387	1171	9	i6	int
    //   390	557	10	i7	int
    //   923	28	11	i8	int
    //   16	1202	12	l1	long
    //   773	852	14	l2	long
    //   1708	435	16	bool	boolean
    //   34	2429	17	localObject1	Object
    //   2497	1	17	localInterruptedException	java.lang.InterruptedException
    //   2515	161	17	localObject2	Object
    //   267	573	18	localObject3	Object
    //   879	966	18	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   1855	825	18	localObject4	Object
    //   184	1383	19	localObject5	Object
    //   1689	15	19	localIOException1	java.io.IOException
    //   1758	17	19	arrayOfString	String[]
    //   1784	65	19	localObject6	Object
    //   1851	92	19	localIOException2	java.io.IOException
    //   1995	27	19	localObject7	Object
    //   2038	1	19	localIOException3	java.io.IOException
    //   2042	156	19	localObject8	Object
    //   2204	3	19	localIOException4	java.io.IOException
    //   2214	1	19	localIOException5	java.io.IOException
    //   2218	53	19	localObject9	Object
    //   2305	3	19	localIOException6	java.io.IOException
    //   2315	19	19	localException1	Exception
    //   2379	27	19	localObject10	Object
    //   2422	1	19	localIOException7	java.io.IOException
    //   2426	1	19	localObject11	Object
    //   2443	3	19	localIOException8	java.io.IOException
    //   2531	1	19	localException2	Exception
    //   2540	1	19	localException3	Exception
    //   2553	1	19	localIOException9	java.io.IOException
    //   2562	24	19	localIOException10	java.io.IOException
    //   2591	1	19	localObject12	Object
    //   2600	1	19	localObject13	Object
    //   2608	11	19	localObject14	Object
    //   2627	1	19	localObject15	Object
    //   2632	1	19	localObject16	Object
    //   2643	11	19	localIOException11	java.io.IOException
    //   2662	1	19	localObject17	Object
    //   2667	1	19	localIOException12	java.io.IOException
    //   2677	1	19	localObject18	Object
    //   438	2088	20	localObject19	Object
    //   2583	7	20	localIOException13	java.io.IOException
    //   2616	66	20	localObject20	Object
    //   450	2097	21	localObject21	Object
    //   2613	13	21	localObject22	Object
    //   2651	10	21	localIOException14	java.io.IOException
    //   462	2111	22	localObject23	Object
    //   446	2097	23	localObject24	Object
    //   434	2077	24	localObject25	Object
    //   458	2111	25	localObject26	Object
    //   201	693	26	localHttpGet	org.apache.http.client.methods.HttpGet
    //   11	2344	27	localURL	URL
    //   25	2464	28	localObject27	Object
    //   210	218	29	localBasicHttpParams	BasicHttpParams
    //   367	1310	30	localFile	File
    //   533	83	31	localStatusLine	org.apache.http.StatusLine
    // Exception table:
    //   from	to	target	type
    //   0	13	114	java/net/MalformedURLException
    //   27	36	129	java/lang/Exception
    //   41	57	129	java/lang/Exception
    //   61	73	129	java/lang/Exception
    //   73	108	129	java/lang/Exception
    //   192	203	879	java/lang/IllegalArgumentException
    //   881	895	898	java/lang/IllegalArgumentException
    //   940	946	1689	java/io/IOException
    //   954	983	1689	java/io/IOException
    //   995	1001	1689	java/io/IOException
    //   1009	1051	1689	java/io/IOException
    //   1063	1084	1689	java/io/IOException
    //   1092	1099	1689	java/io/IOException
    //   1107	1113	1689	java/io/IOException
    //   1147	1159	1689	java/io/IOException
    //   1167	1176	1689	java/io/IOException
    //   1184	1190	1689	java/io/IOException
    //   1198	1253	1689	java/io/IOException
    //   1583	1589	1689	java/io/IOException
    //   1597	1648	1689	java/io/IOException
    //   1660	1668	1689	java/io/IOException
    //   1676	1682	1689	java/io/IOException
    //   1739	1746	1689	java/io/IOException
    //   1754	1760	1689	java/io/IOException
    //   2067	2073	1689	java/io/IOException
    //   2105	2111	1689	java/io/IOException
    //   940	946	1784	finally
    //   954	983	1784	finally
    //   995	1001	1784	finally
    //   1009	1051	1784	finally
    //   1063	1084	1784	finally
    //   1092	1099	1784	finally
    //   1107	1113	1784	finally
    //   1147	1159	1784	finally
    //   1167	1176	1784	finally
    //   1184	1190	1784	finally
    //   1198	1253	1784	finally
    //   1583	1589	1784	finally
    //   1597	1648	1784	finally
    //   1660	1668	1784	finally
    //   1676	1682	1784	finally
    //   1739	1746	1784	finally
    //   1754	1760	1784	finally
    //   2067	2073	1784	finally
    //   2105	2111	1784	finally
    //   1282	1287	1851	java/io/IOException
    //   1819	1824	1851	java/io/IOException
    //   1848	1851	1851	java/io/IOException
    //   2014	2019	2038	java/io/IOException
    //   1439	1446	2204	java/io/IOException
    //   1451	1456	2214	java/io/IOException
    //   1986	1993	2305	java/io/IOException
    //   1282	1287	2315	java/lang/Exception
    //   1819	1824	2315	java/lang/Exception
    //   1848	1851	2315	java/lang/Exception
    //   2398	2403	2422	java/io/IOException
    //   2370	2377	2443	java/io/IOException
    //   1282	1287	2453	finally
    //   1819	1824	2453	finally
    //   1848	1851	2453	finally
    //   2462	2469	2479	java/io/IOException
    //   1530	1538	2487	finally
    //   1538	1541	2487	finally
    //   2488	2491	2487	finally
    //   2473	2477	2493	java/io/IOException
    //   1530	1538	2497	java/lang/InterruptedException
    //   1723	1728	2502	finally
    //   468	490	2509	finally
    //   526	535	2509	finally
    //   571	579	2509	finally
    //   615	624	2509	finally
    //   664	677	2509	finally
    //   713	722	2509	finally
    //   766	775	2509	finally
    //   1328	1335	2509	finally
    //   1371	1381	2509	finally
    //   1421	1434	2509	finally
    //   2184	2197	2509	finally
    //   1869	1874	2520	finally
    //   1882	1890	2520	finally
    //   1902	1956	2520	finally
    //   1968	1981	2520	finally
    //   2235	2243	2520	finally
    //   2251	2259	2520	finally
    //   2270	2278	2520	finally
    //   2286	2292	2520	finally
    //   2333	2338	2520	finally
    //   2353	2365	2520	finally
    //   1723	1728	2531	java/lang/Exception
    //   468	490	2540	java/lang/Exception
    //   526	535	2540	java/lang/Exception
    //   571	579	2540	java/lang/Exception
    //   615	624	2540	java/lang/Exception
    //   664	677	2540	java/lang/Exception
    //   713	722	2540	java/lang/Exception
    //   766	775	2540	java/lang/Exception
    //   1328	1335	2540	java/lang/Exception
    //   1371	1381	2540	java/lang/Exception
    //   1421	1434	2540	java/lang/Exception
    //   2184	2197	2540	java/lang/Exception
    //   1723	1728	2553	java/io/IOException
    //   468	490	2562	java/io/IOException
    //   526	535	2562	java/io/IOException
    //   571	579	2562	java/io/IOException
    //   615	624	2562	java/io/IOException
    //   664	677	2562	java/io/IOException
    //   713	722	2562	java/io/IOException
    //   766	775	2562	java/io/IOException
    //   1328	1335	2562	java/io/IOException
    //   1371	1381	2562	java/io/IOException
    //   1421	1434	2562	java/io/IOException
    //   2184	2197	2583	java/io/IOException
    //   815	821	2600	finally
    //   830	849	2600	finally
    //   860	876	2600	finally
    //   1695	1710	2608	finally
    //   2135	2142	2608	finally
    //   781	792	2613	finally
    //   792	801	2632	finally
    //   815	821	2643	java/io/IOException
    //   830	849	2643	java/io/IOException
    //   860	876	2643	java/io/IOException
    //   781	792	2651	java/io/IOException
    //   792	801	2667	java/io/IOException
  }
  
  public static int a(AppInterface paramAppInterface, DownloadInfo paramDownloadInfo, HttpDownloadUtil.HttpDownloadListener paramHttpDownloadListener)
  {
    NetworkInfo localNetworkInfo = jdField_a_of_type_AndroidNetConnectivityManager.getActiveNetworkInfo();
    if (localNetworkInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("HttpDownloadUtil", 2, "Download failed-----------activeNetworkInfo is null");
      }
      return 9;
    }
    return a(paramAppInterface, paramDownloadInfo, localNetworkInfo, paramHttpDownloadListener);
  }
  
  /* Error */
  public static int a(AppInterface paramAppInterface, String paramString, HttpDownloadUtil.DownloadInfoListener paramDownloadInfoListener)
  {
    // Byte code:
    //   0: new 227	com/tencent/mobileqq/emoticon/DownloadInfo
    //   3: dup
    //   4: aload_1
    //   5: aconst_null
    //   6: iconst_0
    //   7: invokespecial 518	com/tencent/mobileqq/emoticon/DownloadInfo:<init>	(Ljava/lang/String;Ljava/io/File;I)V
    //   10: astore 8
    //   12: getstatic 184	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_AndroidNetConnectivityManager	Landroid/net/ConnectivityManager;
    //   15: invokevirtual 510	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   18: astore 10
    //   20: aload 10
    //   22: ifnonnull +34 -> 56
    //   25: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   28: ifeq +12 -> 40
    //   31: ldc 15
    //   33: iconst_2
    //   34: ldc_w 520
    //   37: invokestatic 494	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   40: aload 8
    //   42: iconst_1
    //   43: putfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   46: aload_2
    //   47: aload 8
    //   49: invokeinterface 525 2 0
    //   54: iconst_1
    //   55: ireturn
    //   56: new 225	java/net/URL
    //   59: dup
    //   60: aload 8
    //   62: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   65: invokespecial 229	java/net/URL:<init>	(Ljava/lang/String;)V
    //   68: pop
    //   69: new 4	java/lang/Object
    //   72: dup
    //   73: invokespecial 214	java/lang/Object:<init>	()V
    //   76: astore 9
    //   78: aload 8
    //   80: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   83: astore 6
    //   85: new 278	org/apache/http/client/methods/HttpGet
    //   88: dup
    //   89: aload 6
    //   91: invokespecial 279	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   94: pop
    //   95: aconst_null
    //   96: astore_0
    //   97: iconst_m1
    //   98: istore 5
    //   100: aconst_null
    //   101: astore_1
    //   102: aload 10
    //   104: ifnull +9 -> 113
    //   107: aload 10
    //   109: invokevirtual 309	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   112: astore_1
    //   113: aload_1
    //   114: invokestatic 529	com/tencent/mobileqq/utils/httputils/PkgTools:f	(Ljava/lang/String;)Ljava/lang/String;
    //   117: astore 7
    //   119: aload 7
    //   121: getstatic 186	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   124: invokevirtual 533	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   127: ifne +12 -> 139
    //   130: iconst_0
    //   131: putstatic 188	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_Boolean	Z
    //   134: aload 7
    //   136: putstatic 186	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   139: invokestatic 300	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   142: astore 11
    //   144: invokestatic 304	android/net/Proxy:getDefaultPort	()I
    //   147: istore_3
    //   148: aload 10
    //   150: invokestatic 314	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   153: ifeq +414 -> 567
    //   156: aload 11
    //   158: ifnull +409 -> 567
    //   161: iload_3
    //   162: ifle +405 -> 567
    //   165: getstatic 188	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_Boolean	Z
    //   168: ifne +399 -> 567
    //   171: aload_1
    //   172: ifnull +381 -> 553
    //   175: aload 7
    //   177: getstatic 535	com/tencent/mobileqq/utils/httputils/PkgTools:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   180: invokevirtual 533	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   183: ifne +25 -> 208
    //   186: aload 7
    //   188: getstatic 537	com/tencent/mobileqq/utils/httputils/PkgTools:f	Ljava/lang/String;
    //   191: invokevirtual 533	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   194: ifne +14 -> 208
    //   197: aload 7
    //   199: getstatic 539	com/tencent/mobileqq/utils/httputils/PkgTools:h	Ljava/lang/String;
    //   202: invokevirtual 533	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   205: ifeq +309 -> 514
    //   208: aload 6
    //   210: aload 11
    //   212: iload_3
    //   213: invokestatic 542	com/tencent/mobileqq/utils/httputils/PkgTools:b	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   216: astore_1
    //   217: aload_1
    //   218: astore_0
    //   219: aload_0
    //   220: astore_1
    //   221: aload_0
    //   222: ldc_w 544
    //   225: ldc_w 546
    //   228: invokevirtual 552	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   231: aload_0
    //   232: astore_1
    //   233: aload_0
    //   234: sipush 30000
    //   237: invokevirtual 556	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   240: aload_0
    //   241: astore_1
    //   242: aload_0
    //   243: sipush 30000
    //   246: invokevirtual 559	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   249: aload_0
    //   250: astore_1
    //   251: aload_0
    //   252: iconst_1
    //   253: invokevirtual 563	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   256: aload_0
    //   257: astore_1
    //   258: aload_0
    //   259: invokevirtual 566	java/net/HttpURLConnection:connect	()V
    //   262: aload_0
    //   263: astore_1
    //   264: aload 8
    //   266: aload_0
    //   267: invokevirtual 569	java/net/HttpURLConnection:getResponseCode	()I
    //   270: putfield 571	com/tencent/mobileqq/emoticon/DownloadInfo:c	I
    //   273: aload_0
    //   274: astore_1
    //   275: aload 8
    //   277: aload_0
    //   278: invokevirtual 573	java/net/HttpURLConnection:getContentLength	()I
    //   281: putfield 575	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_e_of_type_Int	I
    //   284: aload_0
    //   285: astore_1
    //   286: aload 8
    //   288: aload_0
    //   289: invokevirtual 578	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   292: putfield 579	com/tencent/mobileqq/emoticon/DownloadInfo:h	Ljava/lang/String;
    //   295: aload_0
    //   296: astore_1
    //   297: aload 8
    //   299: aload_0
    //   300: invokevirtual 582	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   303: putfield 584	com/tencent/mobileqq/emoticon/DownloadInfo:i	Ljava/lang/String;
    //   306: aload_0
    //   307: astore_1
    //   308: aload 8
    //   310: iconst_0
    //   311: putfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   314: iconst_0
    //   315: istore_3
    //   316: aload_0
    //   317: astore_1
    //   318: iload_3
    //   319: istore 4
    //   321: aload_0
    //   322: ifnull +12 -> 334
    //   325: aload_0
    //   326: invokevirtual 587	java/net/HttpURLConnection:disconnect	()V
    //   329: iload_3
    //   330: istore 4
    //   332: aload_0
    //   333: astore_1
    //   334: iload 5
    //   336: iconst_1
    //   337: iadd
    //   338: istore 5
    //   340: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   343: ifeq +44 -> 387
    //   346: ldc 15
    //   348: iconst_2
    //   349: new 254	java/lang/StringBuilder
    //   352: dup
    //   353: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   356: ldc_w 589
    //   359: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: iload 4
    //   364: invokevirtual 459	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   367: ldc_w 461
    //   370: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: aload 8
    //   375: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   378: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   384: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   387: iload 5
    //   389: iconst_2
    //   390: if_icmpge +22 -> 412
    //   393: iload 4
    //   395: ifeq +17 -> 412
    //   398: aload 9
    //   400: monitorenter
    //   401: aload 9
    //   403: ldc2_w 590
    //   406: invokevirtual 467	java/lang/Object:wait	(J)V
    //   409: aload 9
    //   411: monitorexit
    //   412: iload 4
    //   414: ifeq +9 -> 423
    //   417: iload 5
    //   419: iconst_2
    //   420: if_icmplt +475 -> 895
    //   423: aload 8
    //   425: iload 4
    //   427: putfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   430: aload_2
    //   431: aload 8
    //   433: invokeinterface 525 2 0
    //   438: iload 4
    //   440: ireturn
    //   441: astore_0
    //   442: aload_0
    //   443: invokevirtual 268	java/net/MalformedURLException:printStackTrace	()V
    //   446: aload 8
    //   448: aload_0
    //   449: invokestatic 274	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   452: putfield 276	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   455: aload 8
    //   457: iconst_5
    //   458: putfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   461: aload_2
    //   462: aload 8
    //   464: invokeinterface 525 2 0
    //   469: iconst_5
    //   470: ireturn
    //   471: astore_0
    //   472: new 278	org/apache/http/client/methods/HttpGet
    //   475: dup
    //   476: aload 6
    //   478: invokestatic 406	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   481: invokespecial 279	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   484: pop
    //   485: aload 6
    //   487: invokestatic 406	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   490: astore 6
    //   492: goto -397 -> 95
    //   495: astore_0
    //   496: aload 8
    //   498: bipush 13
    //   500: putfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   503: aload_2
    //   504: aload 8
    //   506: invokeinterface 525 2 0
    //   511: bipush 13
    //   513: ireturn
    //   514: aload 7
    //   516: getstatic 592	com/tencent/mobileqq/utils/httputils/PkgTools:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   519: invokevirtual 533	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   522: ifeq +17 -> 539
    //   525: aload 6
    //   527: aload 11
    //   529: iload_3
    //   530: invokestatic 594	com/tencent/mobileqq/utils/httputils/PkgTools:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   533: astore_1
    //   534: aload_1
    //   535: astore_0
    //   536: goto -317 -> 219
    //   539: aload 6
    //   541: aload 11
    //   543: iload_3
    //   544: invokestatic 594	com/tencent/mobileqq/utils/httputils/PkgTools:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   547: astore_1
    //   548: aload_1
    //   549: astore_0
    //   550: goto -331 -> 219
    //   553: aload 6
    //   555: aload 11
    //   557: iload_3
    //   558: invokestatic 594	com/tencent/mobileqq/utils/httputils/PkgTools:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   561: astore_1
    //   562: aload_1
    //   563: astore_0
    //   564: goto -345 -> 219
    //   567: new 225	java/net/URL
    //   570: dup
    //   571: aload 6
    //   573: invokespecial 229	java/net/URL:<init>	(Ljava/lang/String;)V
    //   576: invokevirtual 598	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   579: checkcast 548	java/net/HttpURLConnection
    //   582: astore_1
    //   583: aload_1
    //   584: astore_0
    //   585: goto -366 -> 219
    //   588: astore 7
    //   590: aload_0
    //   591: astore_1
    //   592: aload 7
    //   594: invokevirtual 480	java/io/IOException:printStackTrace	()V
    //   597: aload_0
    //   598: astore_1
    //   599: aload 7
    //   601: instanceof 482
    //   604: ifeq +91 -> 695
    //   607: bipush 10
    //   609: istore_3
    //   610: aload_0
    //   611: astore_1
    //   612: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   615: ifeq +59 -> 674
    //   618: aload_0
    //   619: astore_1
    //   620: ldc 15
    //   622: iconst_2
    //   623: new 254	java/lang/StringBuilder
    //   626: dup
    //   627: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   630: ldc_w 600
    //   633: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: iload_3
    //   637: invokevirtual 459	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   640: ldc_w 486
    //   643: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: aload 8
    //   648: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   651: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: ldc_w 602
    //   657: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: aload 7
    //   662: invokevirtual 491	java/io/IOException:getMessage	()Ljava/lang/String;
    //   665: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   671: invokestatic 494	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   674: aload_0
    //   675: astore_1
    //   676: iload_3
    //   677: istore 4
    //   679: aload_0
    //   680: ifnull -346 -> 334
    //   683: aload_0
    //   684: invokevirtual 587	java/net/HttpURLConnection:disconnect	()V
    //   687: aload_0
    //   688: astore_1
    //   689: iload_3
    //   690: istore 4
    //   692: goto -358 -> 334
    //   695: aload_0
    //   696: astore_1
    //   697: aload 7
    //   699: instanceof 475
    //   702: ifne +198 -> 900
    //   705: aload_0
    //   706: astore_1
    //   707: aload 7
    //   709: instanceof 477
    //   712: ifeq +6 -> 718
    //   715: goto +185 -> 900
    //   718: aload_0
    //   719: astore_1
    //   720: aload 7
    //   722: instanceof 502
    //   725: ifeq +17 -> 742
    //   728: aload_0
    //   729: astore_1
    //   730: aload 8
    //   732: bipush 11
    //   734: putfield 504	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   737: iconst_5
    //   738: istore_3
    //   739: goto -129 -> 610
    //   742: aload_0
    //   743: astore_1
    //   744: aload 7
    //   746: instanceof 217
    //   749: ifeq +156 -> 905
    //   752: bipush 13
    //   754: istore_3
    //   755: goto -145 -> 610
    //   758: aload_0
    //   759: astore_1
    //   760: aload 7
    //   762: invokevirtual 505	java/lang/Exception:printStackTrace	()V
    //   765: iconst_5
    //   766: istore_3
    //   767: aload_0
    //   768: astore_1
    //   769: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   772: ifeq +59 -> 831
    //   775: aload_0
    //   776: astore_1
    //   777: ldc 15
    //   779: iconst_2
    //   780: new 254	java/lang/StringBuilder
    //   783: dup
    //   784: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   787: ldc_w 600
    //   790: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   793: iconst_5
    //   794: invokevirtual 459	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   797: ldc_w 486
    //   800: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: aload 8
    //   805: getfield 228	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   808: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   811: ldc_w 488
    //   814: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   817: aload 7
    //   819: invokevirtual 603	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   822: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   825: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   828: invokestatic 494	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   831: aload_0
    //   832: astore_1
    //   833: iload_3
    //   834: istore 4
    //   836: aload_0
    //   837: ifnull -503 -> 334
    //   840: aload_0
    //   841: invokevirtual 587	java/net/HttpURLConnection:disconnect	()V
    //   844: aload_0
    //   845: astore_1
    //   846: iload_3
    //   847: istore 4
    //   849: goto -515 -> 334
    //   852: astore_0
    //   853: aload_1
    //   854: astore_2
    //   855: aload_0
    //   856: astore_1
    //   857: aload_2
    //   858: ifnull +7 -> 865
    //   861: aload_2
    //   862: invokevirtual 587	java/net/HttpURLConnection:disconnect	()V
    //   865: aload_1
    //   866: athrow
    //   867: astore_0
    //   868: aload 9
    //   870: monitorexit
    //   871: aload_0
    //   872: athrow
    //   873: astore_0
    //   874: goto -465 -> 409
    //   877: astore_1
    //   878: aload_0
    //   879: astore_2
    //   880: goto -23 -> 857
    //   883: astore_1
    //   884: aload_1
    //   885: astore 7
    //   887: goto -129 -> 758
    //   890: astore 7
    //   892: goto -302 -> 590
    //   895: aload_1
    //   896: astore_0
    //   897: goto -797 -> 100
    //   900: iconst_2
    //   901: istore_3
    //   902: goto -292 -> 610
    //   905: iconst_4
    //   906: istore_3
    //   907: goto -297 -> 610
    //   910: astore 7
    //   912: goto -154 -> 758
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	915	0	paramAppInterface	AppInterface
    //   0	915	1	paramString	String
    //   0	915	2	paramDownloadInfoListener	HttpDownloadUtil.DownloadInfoListener
    //   147	760	3	i1	int
    //   319	529	4	i2	int
    //   98	323	5	i3	int
    //   83	489	6	str1	String
    //   117	398	7	str2	String
    //   588	230	7	localIOException1	java.io.IOException
    //   885	1	7	str3	String
    //   890	1	7	localIOException2	java.io.IOException
    //   910	1	7	localException	Exception
    //   10	794	8	localDownloadInfo	DownloadInfo
    //   76	793	9	localObject	Object
    //   18	131	10	localNetworkInfo	NetworkInfo
    //   142	414	11	str4	String
    // Exception table:
    //   from	to	target	type
    //   56	69	441	java/net/MalformedURLException
    //   85	95	471	java/lang/IllegalArgumentException
    //   472	492	495	java/lang/IllegalArgumentException
    //   221	231	588	java/io/IOException
    //   233	240	588	java/io/IOException
    //   242	249	588	java/io/IOException
    //   251	256	588	java/io/IOException
    //   258	262	588	java/io/IOException
    //   264	273	588	java/io/IOException
    //   275	284	588	java/io/IOException
    //   286	295	588	java/io/IOException
    //   297	306	588	java/io/IOException
    //   308	314	588	java/io/IOException
    //   221	231	852	finally
    //   233	240	852	finally
    //   242	249	852	finally
    //   251	256	852	finally
    //   258	262	852	finally
    //   264	273	852	finally
    //   275	284	852	finally
    //   286	295	852	finally
    //   297	306	852	finally
    //   308	314	852	finally
    //   592	597	852	finally
    //   599	607	852	finally
    //   612	618	852	finally
    //   620	674	852	finally
    //   697	705	852	finally
    //   707	715	852	finally
    //   720	728	852	finally
    //   730	737	852	finally
    //   744	752	852	finally
    //   760	765	852	finally
    //   769	775	852	finally
    //   777	831	852	finally
    //   401	409	867	finally
    //   409	412	867	finally
    //   868	871	867	finally
    //   401	409	873	java/lang/InterruptedException
    //   107	113	877	finally
    //   113	139	877	finally
    //   139	156	877	finally
    //   165	171	877	finally
    //   175	208	877	finally
    //   208	217	877	finally
    //   514	534	877	finally
    //   539	548	877	finally
    //   553	562	877	finally
    //   567	583	877	finally
    //   107	113	883	java/lang/Exception
    //   113	139	883	java/lang/Exception
    //   139	156	883	java/lang/Exception
    //   165	171	883	java/lang/Exception
    //   175	208	883	java/lang/Exception
    //   208	217	883	java/lang/Exception
    //   514	534	883	java/lang/Exception
    //   539	548	883	java/lang/Exception
    //   553	562	883	java/lang/Exception
    //   567	583	883	java/lang/Exception
    //   107	113	890	java/io/IOException
    //   113	139	890	java/io/IOException
    //   139	156	890	java/io/IOException
    //   165	171	890	java/io/IOException
    //   175	208	890	java/io/IOException
    //   208	217	890	java/io/IOException
    //   514	534	890	java/io/IOException
    //   539	548	890	java/io/IOException
    //   553	562	890	java/io/IOException
    //   567	583	890	java/io/IOException
    //   221	231	910	java/lang/Exception
    //   233	240	910	java/lang/Exception
    //   242	249	910	java/lang/Exception
    //   251	256	910	java/lang/Exception
    //   258	262	910	java/lang/Exception
    //   264	273	910	java/lang/Exception
    //   275	284	910	java/lang/Exception
    //   286	295	910	java/lang/Exception
    //   297	306	910	java/lang/Exception
    //   308	314	910	java/lang/Exception
  }
  
  public static int a(AppInterface paramAppInterface, String paramString, File paramFile)
  {
    NetworkInfo localNetworkInfo = jdField_a_of_type_AndroidNetConnectivityManager.getActiveNetworkInfo();
    if (localNetworkInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("HttpDownloadUtil", 2, "Download failed-----------activeNetworkInfo is null");
      }
      return 1;
    }
    try
    {
      paramString = new URL(paramString);
      return a(paramAppInterface, paramString, paramFile, localNetworkInfo);
    }
    catch (MalformedURLException paramAppInterface)
    {
      paramAppInterface.printStackTrace();
    }
    return 5;
  }
  
  /* Error */
  public static int a(AppInterface paramAppInterface, URL paramURL, File paramFile, NetworkInfo paramNetworkInfo)
  {
    // Byte code:
    //   0: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   3: lstore 11
    //   5: new 4	java/lang/Object
    //   8: dup
    //   9: invokespecial 214	java/lang/Object:<init>	()V
    //   12: astore 26
    //   14: aload_2
    //   15: invokevirtual 238	java/io/File:getParentFile	()Ljava/io/File;
    //   18: astore_0
    //   19: aload_0
    //   20: ifnull +15 -> 35
    //   23: aload_0
    //   24: invokevirtual 241	java/io/File:exists	()Z
    //   27: ifne +8 -> 35
    //   30: aload_0
    //   31: invokevirtual 244	java/io/File:mkdirs	()Z
    //   34: pop
    //   35: aconst_null
    //   36: astore_0
    //   37: aload_1
    //   38: invokevirtual 247	java/net/URL:toString	()Ljava/lang/String;
    //   41: astore 16
    //   43: new 278	org/apache/http/client/methods/HttpGet
    //   46: dup
    //   47: aload 16
    //   49: invokespecial 279	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   52: astore 24
    //   54: new 72	org/apache/http/params/BasicHttpParams
    //   57: dup
    //   58: invokespecial 75	org/apache/http/params/BasicHttpParams:<init>	()V
    //   61: astore 27
    //   63: sipush 20000
    //   66: istore 5
    //   68: ldc_w 282
    //   71: istore 4
    //   73: aload_3
    //   74: ifnull +105 -> 179
    //   77: invokestatic 300	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   80: astore 16
    //   82: invokestatic 304	android/net/Proxy:getDefaultPort	()I
    //   85: istore 4
    //   87: aload_3
    //   88: invokevirtual 309	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   91: astore 17
    //   93: aload_3
    //   94: invokestatic 314	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   97: ifeq +51 -> 148
    //   100: aload 17
    //   102: ifnull +14 -> 116
    //   105: aload 17
    //   107: ldc_w 316
    //   110: invokevirtual 320	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   113: ifeq +35 -> 148
    //   116: aload 16
    //   118: ifnull +30 -> 148
    //   121: iload 4
    //   123: ifle +25 -> 148
    //   126: aload 27
    //   128: ldc_w 322
    //   131: new 324	org/apache/http/HttpHost
    //   134: dup
    //   135: aload 16
    //   137: iload 4
    //   139: invokespecial 326	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   142: invokeinterface 293 3 0
    //   147: pop
    //   148: aload_3
    //   149: invokestatic 314	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   152: ifeq +810 -> 962
    //   155: sipush 20000
    //   158: istore 5
    //   160: ldc_w 282
    //   163: istore 4
    //   165: aload 27
    //   167: ldc_w 328
    //   170: sipush 2048
    //   173: invokeinterface 332 3 0
    //   178: pop
    //   179: aload 27
    //   181: ldc_w 281
    //   184: iload 5
    //   186: invokestatic 287	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   189: invokeinterface 293 3 0
    //   194: pop
    //   195: aload 27
    //   197: ldc_w 295
    //   200: iload 4
    //   202: invokestatic 287	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   205: invokeinterface 293 3 0
    //   210: pop
    //   211: aload 24
    //   213: aload 27
    //   215: invokevirtual 336	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   218: aconst_null
    //   219: astore 16
    //   221: iconst_m1
    //   222: istore 6
    //   224: aload_0
    //   225: astore_3
    //   226: aload 16
    //   228: astore_0
    //   229: iload 6
    //   231: ifne +36 -> 267
    //   234: aload 27
    //   236: ldc_w 322
    //   239: new 324	org/apache/http/HttpHost
    //   242: dup
    //   243: aload_1
    //   244: invokevirtual 345	java/net/URL:getHost	()Ljava/lang/String;
    //   247: aload_1
    //   248: invokevirtual 348	java/net/URL:getPort	()I
    //   251: invokespecial 326	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   254: invokeinterface 293 3 0
    //   259: pop
    //   260: aload 24
    //   262: aload 27
    //   264: invokevirtual 336	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   267: iconst_5
    //   268: istore 4
    //   270: aload_0
    //   271: astore 23
    //   273: aload_3
    //   274: astore 16
    //   276: aload_0
    //   277: astore 20
    //   279: aload_3
    //   280: astore 17
    //   282: aload_0
    //   283: astore 21
    //   285: aload_3
    //   286: astore 18
    //   288: aload_0
    //   289: astore 22
    //   291: aload_3
    //   292: astore 19
    //   294: getstatic 149	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   297: new 324	org/apache/http/HttpHost
    //   300: dup
    //   301: aload_1
    //   302: invokevirtual 345	java/net/URL:getHost	()Ljava/lang/String;
    //   305: invokespecial 349	org/apache/http/HttpHost:<init>	(Ljava/lang/String;)V
    //   308: aload 24
    //   310: invokevirtual 353	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpResponse;
    //   313: astore 25
    //   315: aload_0
    //   316: astore 23
    //   318: aload_3
    //   319: astore 16
    //   321: aload_0
    //   322: astore 20
    //   324: aload_3
    //   325: astore 17
    //   327: aload_0
    //   328: astore 21
    //   330: aload_3
    //   331: astore 18
    //   333: aload_0
    //   334: astore 22
    //   336: aload_3
    //   337: astore 19
    //   339: aload 25
    //   341: invokeinterface 359 1 0
    //   346: invokeinterface 368 1 0
    //   351: istore 5
    //   353: aload_0
    //   354: astore 23
    //   356: aload_3
    //   357: astore 16
    //   359: aload_0
    //   360: astore 20
    //   362: aload_3
    //   363: astore 17
    //   365: aload_0
    //   366: astore 21
    //   368: aload_3
    //   369: astore 18
    //   371: aload_0
    //   372: astore 22
    //   374: aload_3
    //   375: astore 19
    //   377: aload 25
    //   379: invokeinterface 374 1 0
    //   384: astore_0
    //   385: sipush 200
    //   388: iload 5
    //   390: if_icmpne +677 -> 1067
    //   393: aload_0
    //   394: astore 23
    //   396: aload_3
    //   397: astore 16
    //   399: aload_0
    //   400: astore 20
    //   402: aload_3
    //   403: astore 17
    //   405: aload_0
    //   406: astore 21
    //   408: aload_3
    //   409: astore 18
    //   411: aload_0
    //   412: astore 22
    //   414: aload_3
    //   415: astore 19
    //   417: aload_0
    //   418: invokeinterface 379 1 0
    //   423: lstore 13
    //   425: lconst_0
    //   426: lstore 9
    //   428: aload_2
    //   429: ifnull +121 -> 550
    //   432: aload_0
    //   433: astore 20
    //   435: aload_3
    //   436: astore 17
    //   438: aload_0
    //   439: astore 21
    //   441: aload_3
    //   442: astore 18
    //   444: aload_0
    //   445: astore 22
    //   447: aload_3
    //   448: astore 19
    //   450: aload_2
    //   451: invokevirtual 241	java/io/File:exists	()Z
    //   454: ifeq +96 -> 550
    //   457: aload_0
    //   458: astore 20
    //   460: aload_3
    //   461: astore 17
    //   463: aload_0
    //   464: astore 21
    //   466: aload_3
    //   467: astore 18
    //   469: aload_0
    //   470: astore 22
    //   472: aload_3
    //   473: astore 19
    //   475: aload_2
    //   476: invokevirtual 342	java/io/File:delete	()Z
    //   479: istore 15
    //   481: aload_0
    //   482: astore 20
    //   484: aload_3
    //   485: astore 17
    //   487: aload_0
    //   488: astore 21
    //   490: aload_3
    //   491: astore 18
    //   493: aload_0
    //   494: astore 22
    //   496: aload_3
    //   497: astore 19
    //   499: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   502: ifeq +48 -> 550
    //   505: aload_0
    //   506: astore 20
    //   508: aload_3
    //   509: astore 17
    //   511: aload_0
    //   512: astore 21
    //   514: aload_3
    //   515: astore 18
    //   517: aload_0
    //   518: astore 22
    //   520: aload_3
    //   521: astore 19
    //   523: ldc 15
    //   525: iconst_2
    //   526: new 254	java/lang/StringBuilder
    //   529: dup
    //   530: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   533: ldc_w 611
    //   536: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: iload 15
    //   541: invokevirtual 614	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   544: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   547: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   550: aload_0
    //   551: astore 20
    //   553: aload_3
    //   554: astore 17
    //   556: aload_0
    //   557: astore 21
    //   559: aload_3
    //   560: astore 18
    //   562: aload_0
    //   563: astore 22
    //   565: aload_3
    //   566: astore 19
    //   568: new 381	java/io/FileOutputStream
    //   571: dup
    //   572: aload_2
    //   573: invokespecial 384	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   576: astore 16
    //   578: lload 9
    //   580: lstore 7
    //   582: aload_0
    //   583: aload 16
    //   585: invokeinterface 618 2 0
    //   590: lload 9
    //   592: lstore 7
    //   594: aload_2
    //   595: invokevirtual 621	java/io/File:length	()J
    //   598: lstore 9
    //   600: lload 9
    //   602: lstore 7
    //   604: aload_2
    //   605: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   608: invokevirtual 435	java/io/File:setLastModified	(J)Z
    //   611: pop
    //   612: lload 9
    //   614: lstore 7
    //   616: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   619: ifeq +59 -> 678
    //   622: lload 9
    //   624: lstore 7
    //   626: ldc 15
    //   628: iconst_2
    //   629: new 254	java/lang/StringBuilder
    //   632: dup
    //   633: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   636: ldc_w 437
    //   639: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   645: lload 11
    //   647: lsub
    //   648: invokevirtual 415	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   651: ldc_w 623
    //   654: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   657: lload 9
    //   659: invokevirtual 415	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   662: ldc_w 441
    //   665: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: aload_1
    //   669: invokevirtual 626	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   672: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   675: invokestatic 443	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   678: iconst_0
    //   679: istore 4
    //   681: aload 16
    //   683: astore_3
    //   684: lload 9
    //   686: lstore 7
    //   688: iload 4
    //   690: istore 5
    //   692: lload 13
    //   694: lconst_0
    //   695: lcmp
    //   696: ifle +75 -> 771
    //   699: iload 4
    //   701: istore 5
    //   703: lload 7
    //   705: lload 13
    //   707: lcmp
    //   708: ifge +63 -> 771
    //   711: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   714: ifeq +53 -> 767
    //   717: ldc 15
    //   719: iconst_2
    //   720: new 254	java/lang/StringBuilder
    //   723: dup
    //   724: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   727: ldc_w 628
    //   730: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   733: lload 13
    //   735: invokevirtual 415	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   738: ldc_w 630
    //   741: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   744: aload_2
    //   745: invokevirtual 621	java/io/File:length	()J
    //   748: invokevirtual 415	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   751: ldc_w 461
    //   754: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: aload_1
    //   758: invokevirtual 626	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   761: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   764: invokestatic 494	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   767: bipush 8
    //   769: istore 5
    //   771: iload 5
    //   773: istore 4
    //   775: aload_0
    //   776: ifnull +9 -> 785
    //   779: aload_0
    //   780: invokeinterface 453 1 0
    //   785: aload_3
    //   786: ifnull +7 -> 793
    //   789: aload_3
    //   790: invokevirtual 454	java/io/OutputStream:close	()V
    //   793: iload 4
    //   795: ifeq +1136 -> 1931
    //   798: aload_2
    //   799: ifnull +49 -> 848
    //   802: aload_2
    //   803: invokevirtual 241	java/io/File:exists	()Z
    //   806: ifeq +42 -> 848
    //   809: aload_2
    //   810: invokevirtual 342	java/io/File:delete	()Z
    //   813: istore 15
    //   815: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   818: ifeq +30 -> 848
    //   821: ldc 15
    //   823: iconst_2
    //   824: new 254	java/lang/StringBuilder
    //   827: dup
    //   828: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   831: ldc_w 632
    //   834: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   837: iload 15
    //   839: invokevirtual 614	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   842: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   845: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   848: iload 6
    //   850: iconst_1
    //   851: iadd
    //   852: istore 6
    //   854: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   857: ifeq +40 -> 897
    //   860: ldc 15
    //   862: iconst_2
    //   863: new 254	java/lang/StringBuilder
    //   866: dup
    //   867: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   870: ldc_w 456
    //   873: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   876: iload 4
    //   878: invokevirtual 459	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   881: ldc_w 461
    //   884: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   887: aload_1
    //   888: invokevirtual 626	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   891: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   894: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   897: iload 4
    //   899: ifeq +23 -> 922
    //   902: iload 6
    //   904: iconst_2
    //   905: if_icmpge +17 -> 922
    //   908: aload 26
    //   910: monitorenter
    //   911: aload 26
    //   913: ldc2_w 633
    //   916: invokevirtual 467	java/lang/Object:wait	(J)V
    //   919: aload 26
    //   921: monitorexit
    //   922: iload 4
    //   924: ifeq +9 -> 933
    //   927: iload 6
    //   929: iconst_2
    //   930: if_icmplt +998 -> 1928
    //   933: iload 4
    //   935: ireturn
    //   936: astore_0
    //   937: iconst_4
    //   938: ireturn
    //   939: astore 17
    //   941: new 278	org/apache/http/client/methods/HttpGet
    //   944: dup
    //   945: aload 16
    //   947: invokestatic 406	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   950: invokespecial 279	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   953: astore 24
    //   955: goto -901 -> 54
    //   958: astore_0
    //   959: bipush 13
    //   961: ireturn
    //   962: sipush 10000
    //   965: istore 5
    //   967: sipush 30000
    //   970: istore 4
    //   972: aload 27
    //   974: ldc_w 328
    //   977: sipush 4096
    //   980: invokeinterface 332 3 0
    //   985: pop
    //   986: goto -807 -> 179
    //   989: astore 25
    //   991: aload 16
    //   993: astore_3
    //   994: aload_0
    //   995: astore 23
    //   997: aload_3
    //   998: astore 16
    //   1000: aload_0
    //   1001: astore 20
    //   1003: aload_3
    //   1004: astore 17
    //   1006: aload_0
    //   1007: astore 21
    //   1009: aload_3
    //   1010: astore 18
    //   1012: aload_0
    //   1013: astore 22
    //   1015: aload_3
    //   1016: astore 19
    //   1018: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1021: ifeq +40 -> 1061
    //   1024: aload_0
    //   1025: astore 23
    //   1027: aload_3
    //   1028: astore 16
    //   1030: aload_0
    //   1031: astore 20
    //   1033: aload_3
    //   1034: astore 17
    //   1036: aload_0
    //   1037: astore 21
    //   1039: aload_3
    //   1040: astore 18
    //   1042: aload_0
    //   1043: astore 22
    //   1045: aload_3
    //   1046: astore 19
    //   1048: ldc 15
    //   1050: iconst_2
    //   1051: aload 25
    //   1053: invokevirtual 491	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1056: aload 25
    //   1058: invokestatic 636	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1061: iconst_4
    //   1062: istore 4
    //   1064: goto -376 -> 688
    //   1067: iload 5
    //   1069: istore 4
    //   1071: goto -296 -> 775
    //   1074: astore 16
    //   1076: aload 16
    //   1078: invokevirtual 480	java/io/IOException:printStackTrace	()V
    //   1081: goto -296 -> 785
    //   1084: astore 16
    //   1086: goto -238 -> 848
    //   1089: astore_0
    //   1090: iconst_5
    //   1091: istore 4
    //   1093: aload 16
    //   1095: astore 17
    //   1097: aload 23
    //   1099: astore 16
    //   1101: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1104: ifeq +30 -> 1134
    //   1107: ldc 15
    //   1109: iconst_2
    //   1110: new 254	java/lang/StringBuilder
    //   1113: dup
    //   1114: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   1117: ldc_w 638
    //   1120: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1123: aload_1
    //   1124: invokevirtual 626	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1127: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1130: aload_0
    //   1131: invokestatic 636	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1134: iconst_1
    //   1135: istore 5
    //   1137: aload 16
    //   1139: ifnull +10 -> 1149
    //   1142: aload 16
    //   1144: invokeinterface 453 1 0
    //   1149: aload 17
    //   1151: ifnull +8 -> 1159
    //   1154: aload 17
    //   1156: invokevirtual 454	java/io/OutputStream:close	()V
    //   1159: aload 16
    //   1161: astore_0
    //   1162: aload 17
    //   1164: astore_3
    //   1165: iload 5
    //   1167: istore 4
    //   1169: aload_2
    //   1170: ifnull -322 -> 848
    //   1173: aload 16
    //   1175: astore_0
    //   1176: aload 17
    //   1178: astore_3
    //   1179: iload 5
    //   1181: istore 4
    //   1183: aload_2
    //   1184: invokevirtual 241	java/io/File:exists	()Z
    //   1187: ifeq -339 -> 848
    //   1190: aload_2
    //   1191: invokevirtual 342	java/io/File:delete	()Z
    //   1194: istore 15
    //   1196: aload 16
    //   1198: astore_0
    //   1199: aload 17
    //   1201: astore_3
    //   1202: iload 5
    //   1204: istore 4
    //   1206: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1209: ifeq -361 -> 848
    //   1212: ldc 15
    //   1214: iconst_2
    //   1215: new 254	java/lang/StringBuilder
    //   1218: dup
    //   1219: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   1222: ldc_w 632
    //   1225: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1228: iload 15
    //   1230: invokevirtual 614	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1233: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1236: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1239: aload 16
    //   1241: astore_0
    //   1242: aload 17
    //   1244: astore_3
    //   1245: iload 5
    //   1247: istore 4
    //   1249: goto -401 -> 848
    //   1252: astore_0
    //   1253: aload 16
    //   1255: astore_0
    //   1256: aload 17
    //   1258: astore_3
    //   1259: iload 5
    //   1261: istore 4
    //   1263: goto -415 -> 848
    //   1266: astore_0
    //   1267: aload_0
    //   1268: invokevirtual 480	java/io/IOException:printStackTrace	()V
    //   1271: goto -122 -> 1149
    //   1274: astore 18
    //   1276: iload 4
    //   1278: istore 5
    //   1280: aload 16
    //   1282: astore 17
    //   1284: aload_0
    //   1285: astore 16
    //   1287: aload 16
    //   1289: astore_0
    //   1290: aload 17
    //   1292: astore_3
    //   1293: iload 5
    //   1295: istore 4
    //   1297: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1300: ifeq +41 -> 1341
    //   1303: aload 16
    //   1305: astore_0
    //   1306: aload 17
    //   1308: astore_3
    //   1309: iload 5
    //   1311: istore 4
    //   1313: ldc 15
    //   1315: iconst_2
    //   1316: new 254	java/lang/StringBuilder
    //   1319: dup
    //   1320: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   1323: ldc_w 640
    //   1326: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1329: aload_1
    //   1330: invokevirtual 626	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1333: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1336: aload 18
    //   1338: invokestatic 636	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1341: iconst_5
    //   1342: istore 5
    //   1344: aload 16
    //   1346: ifnull +10 -> 1356
    //   1349: aload 16
    //   1351: invokeinterface 453 1 0
    //   1356: aload 17
    //   1358: ifnull +8 -> 1366
    //   1361: aload 17
    //   1363: invokevirtual 454	java/io/OutputStream:close	()V
    //   1366: aload 16
    //   1368: astore_0
    //   1369: aload 17
    //   1371: astore_3
    //   1372: iload 5
    //   1374: istore 4
    //   1376: aload_2
    //   1377: ifnull -529 -> 848
    //   1380: aload 16
    //   1382: astore_0
    //   1383: aload 17
    //   1385: astore_3
    //   1386: iload 5
    //   1388: istore 4
    //   1390: aload_2
    //   1391: invokevirtual 241	java/io/File:exists	()Z
    //   1394: ifeq -546 -> 848
    //   1397: aload_2
    //   1398: invokevirtual 342	java/io/File:delete	()Z
    //   1401: istore 15
    //   1403: aload 16
    //   1405: astore_0
    //   1406: aload 17
    //   1408: astore_3
    //   1409: iload 5
    //   1411: istore 4
    //   1413: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1416: ifeq -568 -> 848
    //   1419: ldc 15
    //   1421: iconst_2
    //   1422: new 254	java/lang/StringBuilder
    //   1425: dup
    //   1426: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   1429: ldc_w 632
    //   1432: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1435: iload 15
    //   1437: invokevirtual 614	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1440: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1443: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1446: aload 16
    //   1448: astore_0
    //   1449: aload 17
    //   1451: astore_3
    //   1452: iload 5
    //   1454: istore 4
    //   1456: goto -608 -> 848
    //   1459: astore_0
    //   1460: aload 16
    //   1462: astore_0
    //   1463: aload 17
    //   1465: astore_3
    //   1466: iload 5
    //   1468: istore 4
    //   1470: goto -622 -> 848
    //   1473: astore_0
    //   1474: aload_0
    //   1475: invokevirtual 480	java/io/IOException:printStackTrace	()V
    //   1478: goto -122 -> 1356
    //   1481: astore 18
    //   1483: iload 4
    //   1485: istore 5
    //   1487: aload 16
    //   1489: astore 17
    //   1491: aload_0
    //   1492: astore 16
    //   1494: aload 16
    //   1496: astore_0
    //   1497: aload 17
    //   1499: astore_3
    //   1500: iload 5
    //   1502: istore 4
    //   1504: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1507: ifeq +41 -> 1548
    //   1510: aload 16
    //   1512: astore_0
    //   1513: aload 17
    //   1515: astore_3
    //   1516: iload 5
    //   1518: istore 4
    //   1520: ldc 15
    //   1522: iconst_2
    //   1523: new 254	java/lang/StringBuilder
    //   1526: dup
    //   1527: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   1530: ldc_w 640
    //   1533: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1536: aload_1
    //   1537: invokevirtual 626	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1540: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1543: aload 18
    //   1545: invokestatic 636	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1548: iconst_5
    //   1549: istore 5
    //   1551: aload 16
    //   1553: ifnull +10 -> 1563
    //   1556: aload 16
    //   1558: invokeinterface 453 1 0
    //   1563: aload 17
    //   1565: ifnull +8 -> 1573
    //   1568: aload 17
    //   1570: invokevirtual 454	java/io/OutputStream:close	()V
    //   1573: aload 16
    //   1575: astore_0
    //   1576: aload 17
    //   1578: astore_3
    //   1579: iload 5
    //   1581: istore 4
    //   1583: aload_2
    //   1584: ifnull -736 -> 848
    //   1587: aload 16
    //   1589: astore_0
    //   1590: aload 17
    //   1592: astore_3
    //   1593: iload 5
    //   1595: istore 4
    //   1597: aload_2
    //   1598: invokevirtual 241	java/io/File:exists	()Z
    //   1601: ifeq -753 -> 848
    //   1604: aload_2
    //   1605: invokevirtual 342	java/io/File:delete	()Z
    //   1608: istore 15
    //   1610: aload 16
    //   1612: astore_0
    //   1613: aload 17
    //   1615: astore_3
    //   1616: iload 5
    //   1618: istore 4
    //   1620: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1623: ifeq -775 -> 848
    //   1626: ldc 15
    //   1628: iconst_2
    //   1629: new 254	java/lang/StringBuilder
    //   1632: dup
    //   1633: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   1636: ldc_w 632
    //   1639: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1642: iload 15
    //   1644: invokevirtual 614	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1647: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1650: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1653: aload 16
    //   1655: astore_0
    //   1656: aload 17
    //   1658: astore_3
    //   1659: iload 5
    //   1661: istore 4
    //   1663: goto -815 -> 848
    //   1666: astore_0
    //   1667: aload 16
    //   1669: astore_0
    //   1670: aload 17
    //   1672: astore_3
    //   1673: iload 5
    //   1675: istore 4
    //   1677: goto -829 -> 848
    //   1680: astore_0
    //   1681: aload_0
    //   1682: invokevirtual 480	java/io/IOException:printStackTrace	()V
    //   1685: goto -122 -> 1563
    //   1688: astore_1
    //   1689: aload 16
    //   1691: astore_3
    //   1692: aload_0
    //   1693: ifnull +9 -> 1702
    //   1696: aload_0
    //   1697: invokeinterface 453 1 0
    //   1702: aload_3
    //   1703: ifnull +7 -> 1710
    //   1706: aload_3
    //   1707: invokevirtual 454	java/io/OutputStream:close	()V
    //   1710: iload 4
    //   1712: ifeq +53 -> 1765
    //   1715: aload_2
    //   1716: ifnull +49 -> 1765
    //   1719: aload_2
    //   1720: invokevirtual 241	java/io/File:exists	()Z
    //   1723: ifeq +42 -> 1765
    //   1726: aload_2
    //   1727: invokevirtual 342	java/io/File:delete	()Z
    //   1730: istore 15
    //   1732: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1735: ifeq +30 -> 1765
    //   1738: ldc 15
    //   1740: iconst_2
    //   1741: new 254	java/lang/StringBuilder
    //   1744: dup
    //   1745: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   1748: ldc_w 632
    //   1751: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1754: iload 15
    //   1756: invokevirtual 614	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1759: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1762: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1765: aload_1
    //   1766: athrow
    //   1767: astore_0
    //   1768: aload_0
    //   1769: invokevirtual 480	java/io/IOException:printStackTrace	()V
    //   1772: goto -70 -> 1702
    //   1775: astore_0
    //   1776: aload 26
    //   1778: monitorexit
    //   1779: aload_0
    //   1780: athrow
    //   1781: astore 16
    //   1783: goto -990 -> 793
    //   1786: astore_0
    //   1787: goto -628 -> 1159
    //   1790: astore_0
    //   1791: goto -425 -> 1366
    //   1794: astore_0
    //   1795: goto -222 -> 1573
    //   1798: astore_0
    //   1799: goto -89 -> 1710
    //   1802: astore 16
    //   1804: goto -885 -> 919
    //   1807: astore_0
    //   1808: goto -43 -> 1765
    //   1811: astore_1
    //   1812: aload 20
    //   1814: astore_0
    //   1815: aload 17
    //   1817: astore_3
    //   1818: goto -126 -> 1692
    //   1821: astore_1
    //   1822: goto -130 -> 1692
    //   1825: astore_1
    //   1826: aload 17
    //   1828: astore_3
    //   1829: aload 16
    //   1831: astore_0
    //   1832: goto -140 -> 1692
    //   1835: astore_1
    //   1836: goto -144 -> 1692
    //   1839: astore_0
    //   1840: aload 21
    //   1842: astore 16
    //   1844: aload 18
    //   1846: astore 17
    //   1848: aload_0
    //   1849: astore 18
    //   1851: iload 4
    //   1853: istore 5
    //   1855: goto -361 -> 1494
    //   1858: astore 18
    //   1860: aload_0
    //   1861: astore 16
    //   1863: aload_3
    //   1864: astore 17
    //   1866: iload 4
    //   1868: istore 5
    //   1870: goto -376 -> 1494
    //   1873: astore 18
    //   1875: aload 22
    //   1877: astore 16
    //   1879: aload 19
    //   1881: astore 17
    //   1883: iload 4
    //   1885: istore 5
    //   1887: goto -600 -> 1287
    //   1890: astore 18
    //   1892: aload_0
    //   1893: astore 16
    //   1895: aload_3
    //   1896: astore 17
    //   1898: iload 4
    //   1900: istore 5
    //   1902: goto -615 -> 1287
    //   1905: astore 18
    //   1907: aload_0
    //   1908: astore 16
    //   1910: aload_3
    //   1911: astore 17
    //   1913: aload 18
    //   1915: astore_0
    //   1916: goto -815 -> 1101
    //   1919: astore 25
    //   1921: lload 9
    //   1923: lstore 7
    //   1925: goto -931 -> 994
    //   1928: goto -1699 -> 229
    //   1931: goto -1083 -> 848
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1934	0	paramAppInterface	AppInterface
    //   0	1934	1	paramURL	URL
    //   0	1934	2	paramFile	File
    //   0	1934	3	paramNetworkInfo	NetworkInfo
    //   71	1828	4	i1	int
    //   66	1835	5	i2	int
    //   222	709	6	i3	int
    //   580	1344	7	l1	long
    //   426	1496	9	l2	long
    //   3	643	11	l3	long
    //   423	311	13	l4	long
    //   479	1276	15	bool	boolean
    //   41	988	16	localObject1	Object
    //   1074	3	16	localIOException1	java.io.IOException
    //   1084	10	16	localException1	Exception
    //   1099	591	16	localObject2	Object
    //   1781	1	16	localIOException2	java.io.IOException
    //   1802	28	16	localInterruptedException	java.lang.InterruptedException
    //   1842	67	16	localObject3	Object
    //   91	464	17	localObject4	Object
    //   939	1	17	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   1004	908	17	localObject5	Object
    //   286	755	18	localNetworkInfo1	NetworkInfo
    //   1274	63	18	localException2	Exception
    //   1481	364	18	localThrowable1	java.lang.Throwable
    //   1849	1	18	localAppInterface1	AppInterface
    //   1858	1	18	localThrowable2	java.lang.Throwable
    //   1873	1	18	localException3	Exception
    //   1890	1	18	localException4	Exception
    //   1905	9	18	localIOException3	java.io.IOException
    //   292	1588	19	localNetworkInfo2	NetworkInfo
    //   277	1536	20	localAppInterface2	AppInterface
    //   283	1558	21	localAppInterface3	AppInterface
    //   289	1587	22	localAppInterface4	AppInterface
    //   271	827	23	localAppInterface5	AppInterface
    //   52	902	24	localHttpGet	org.apache.http.client.methods.HttpGet
    //   313	65	25	localHttpResponse	org.apache.http.HttpResponse
    //   989	68	25	localIOException4	java.io.IOException
    //   1919	1	25	localIOException5	java.io.IOException
    //   12	1765	26	localObject6	Object
    //   61	912	27	localBasicHttpParams	BasicHttpParams
    // Exception table:
    //   from	to	target	type
    //   14	19	936	java/lang/Exception
    //   23	35	936	java/lang/Exception
    //   43	54	939	java/lang/IllegalArgumentException
    //   941	955	958	java/lang/IllegalArgumentException
    //   582	590	989	java/io/IOException
    //   594	600	989	java/io/IOException
    //   604	612	989	java/io/IOException
    //   616	622	989	java/io/IOException
    //   626	678	989	java/io/IOException
    //   779	785	1074	java/io/IOException
    //   802	848	1084	java/lang/Exception
    //   294	315	1089	java/io/IOException
    //   339	353	1089	java/io/IOException
    //   377	385	1089	java/io/IOException
    //   417	425	1089	java/io/IOException
    //   1018	1024	1089	java/io/IOException
    //   1048	1061	1089	java/io/IOException
    //   1183	1196	1252	java/lang/Exception
    //   1206	1239	1252	java/lang/Exception
    //   1142	1149	1266	java/io/IOException
    //   582	590	1274	java/lang/Exception
    //   594	600	1274	java/lang/Exception
    //   604	612	1274	java/lang/Exception
    //   616	622	1274	java/lang/Exception
    //   626	678	1274	java/lang/Exception
    //   1390	1403	1459	java/lang/Exception
    //   1413	1446	1459	java/lang/Exception
    //   1349	1356	1473	java/io/IOException
    //   582	590	1481	java/lang/Throwable
    //   594	600	1481	java/lang/Throwable
    //   604	612	1481	java/lang/Throwable
    //   616	622	1481	java/lang/Throwable
    //   626	678	1481	java/lang/Throwable
    //   1597	1610	1666	java/lang/Exception
    //   1620	1653	1666	java/lang/Exception
    //   1556	1563	1680	java/io/IOException
    //   582	590	1688	finally
    //   594	600	1688	finally
    //   604	612	1688	finally
    //   616	622	1688	finally
    //   626	678	1688	finally
    //   1696	1702	1767	java/io/IOException
    //   911	919	1775	finally
    //   919	922	1775	finally
    //   1776	1779	1775	finally
    //   789	793	1781	java/io/IOException
    //   1154	1159	1786	java/io/IOException
    //   1361	1366	1790	java/io/IOException
    //   1568	1573	1794	java/io/IOException
    //   1706	1710	1798	java/io/IOException
    //   911	919	1802	java/lang/InterruptedException
    //   1719	1765	1807	java/lang/Exception
    //   294	315	1811	finally
    //   339	353	1811	finally
    //   377	385	1811	finally
    //   417	425	1811	finally
    //   450	457	1811	finally
    //   475	481	1811	finally
    //   499	505	1811	finally
    //   523	550	1811	finally
    //   568	578	1811	finally
    //   1018	1024	1811	finally
    //   1048	1061	1811	finally
    //   711	767	1821	finally
    //   1101	1134	1825	finally
    //   1297	1303	1835	finally
    //   1313	1341	1835	finally
    //   1504	1510	1835	finally
    //   1520	1548	1835	finally
    //   294	315	1839	java/lang/Throwable
    //   339	353	1839	java/lang/Throwable
    //   377	385	1839	java/lang/Throwable
    //   417	425	1839	java/lang/Throwable
    //   450	457	1839	java/lang/Throwable
    //   475	481	1839	java/lang/Throwable
    //   499	505	1839	java/lang/Throwable
    //   523	550	1839	java/lang/Throwable
    //   568	578	1839	java/lang/Throwable
    //   1018	1024	1839	java/lang/Throwable
    //   1048	1061	1839	java/lang/Throwable
    //   711	767	1858	java/lang/Throwable
    //   294	315	1873	java/lang/Exception
    //   339	353	1873	java/lang/Exception
    //   377	385	1873	java/lang/Exception
    //   417	425	1873	java/lang/Exception
    //   450	457	1873	java/lang/Exception
    //   475	481	1873	java/lang/Exception
    //   499	505	1873	java/lang/Exception
    //   523	550	1873	java/lang/Exception
    //   568	578	1873	java/lang/Exception
    //   1018	1024	1873	java/lang/Exception
    //   1048	1061	1873	java/lang/Exception
    //   711	767	1890	java/lang/Exception
    //   711	767	1905	java/io/IOException
    //   450	457	1919	java/io/IOException
    //   475	481	1919	java/io/IOException
    //   499	505	1919	java/io/IOException
    //   523	550	1919	java/io/IOException
    //   568	578	1919	java/io/IOException
  }
  
  public static String a(String paramString)
  {
    return paramString.replaceAll("\\{", "%7B").replaceAll("\\}", "%7D").replaceAll("\\|", "%7C");
  }
  
  public static void a(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo == null) || (paramDownloadInfo.jdField_a_of_type_JavaLangString == null) || (paramDownloadInfo.jdField_a_of_type_JavaLangString.length() == 0)) {}
    label245:
    do
    {
      do
      {
        int i1;
        int i2;
        String str1;
        do
        {
          return;
          i1 = "http://".length();
          i2 = paramDownloadInfo.jdField_a_of_type_JavaLangString.indexOf("/", i1);
          str1 = paramDownloadInfo.jdField_a_of_type_JavaLangString.substring(i1, i2);
        } while ((i2 <= i1) && (TextUtils.isEmpty(str1)));
        if ("imgcache.qq.com".equalsIgnoreCase(str1)) {
          i1 = 12;
        }
        for (;;)
        {
          String str2 = FMTSrvAddrProvider.a().a(i1);
          if ((str2 == null) || (str2.length() <= 0)) {
            break label300;
          }
          str2 = paramDownloadInfo.jdField_a_of_type_JavaLangString.replaceFirst("http://[^/\\s]*/", str2);
          paramDownloadInfo.jdField_d_of_type_JavaLangString = str1;
          paramDownloadInfo.jdField_b_of_type_JavaLangString = str2;
          paramDownloadInfo.jdField_a_of_type_Boolean = true;
          paramDownloadInfo.jdField_d_of_type_Int = i1;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.emoji.EmoDown", 2, "replaceDomainWithIp " + paramDownloadInfo.jdField_a_of_type_Boolean + " url[" + paramDownloadInfo.jdField_a_of_type_JavaLangString + "] resetIP[" + str2 + "] host[" + paramDownloadInfo.jdField_d_of_type_JavaLangString + "]");
          return;
          if ("imgcache.gtimg.cn".equalsIgnoreCase(str1))
          {
            i1 = 13;
          }
          else
          {
            if (!"i.gtimg.cn".equalsIgnoreCase(str1)) {
              break label245;
            }
            i1 = 14;
          }
        }
        paramDownloadInfo.jdField_d_of_type_JavaLangString = null;
        paramDownloadInfo.jdField_b_of_type_JavaLangString = paramDownloadInfo.jdField_a_of_type_JavaLangString;
        paramDownloadInfo.jdField_a_of_type_Boolean = false;
      } while (!QLog.isColorLevel());
      QLog.d("Q.emoji.EmoDown", 2, "unknow domain url=" + paramDownloadInfo.jdField_a_of_type_Boolean);
      return;
      paramDownloadInfo.jdField_d_of_type_JavaLangString = null;
      paramDownloadInfo.jdField_b_of_type_JavaLangString = paramDownloadInfo.jdField_a_of_type_JavaLangString;
      paramDownloadInfo.jdField_a_of_type_Boolean = false;
    } while (!QLog.isColorLevel());
    label300:
    QLog.d("Q.emoji.EmoDown", 2, "replaceDomainWithIp false.url[" + paramDownloadInfo.jdField_b_of_type_JavaLangString + "]");
  }
  
  public static boolean a(AppInterface paramAppInterface, String paramString, File paramFile)
  {
    return a(paramAppInterface, paramString, paramFile) == 0;
  }
  
  public static boolean a(AppInterface paramAppInterface, URL paramURL, File paramFile)
  {
    return a(paramAppInterface, paramURL, paramFile, jdField_a_of_type_AndroidNetConnectivityManager.getActiveNetworkInfo()) == 0;
  }
  
  private static boolean a(DownloadInfo paramDownloadInfo, int paramInt1, int paramInt2)
  {
    if (paramDownloadInfo == null) {
      if (paramInt1 > paramInt2) {}
    }
    while ((paramDownloadInfo.jdField_b_of_type_Int != 0) && (paramInt1 <= paramInt2) && (paramDownloadInfo.jdField_b_of_type_Int != 16) && (paramDownloadInfo.jdField_b_of_type_Int != 6) && (NetworkUtil.e(BaseApplication.getContext())))
    {
      return true;
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.HttpDownloadUtil
 * JD-Core Version:    0.7.0.1
 */