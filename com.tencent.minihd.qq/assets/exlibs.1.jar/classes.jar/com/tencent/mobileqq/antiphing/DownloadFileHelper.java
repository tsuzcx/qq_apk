package com.tencent.mobileqq.antiphing;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.apache.http.impl.client.DefaultHttpClient;

public class DownloadFileHelper
{
  public static ConnectivityManager a;
  public static DefaultHttpClient a;
  public Context a;
  
  static
  {
    jdField_a_of_type_AndroidNetConnectivityManager = null;
    jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient = null;
  }
  
  public DownloadFileHelper(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public static String a(String paramString)
  {
    return paramString.replaceAll("\\{", "%7B").replaceAll("\\}", "%7D").replaceAll("\\|", "%7C");
  }
  
  private void a(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (!paramString2.endsWith("/")) {
      str = paramString2 + "/";
    }
    paramString2 = new byte[4096];
    for (;;)
    {
      try
      {
        paramString1 = new ZipFile(paramString1);
        Enumeration localEnumeration = paramString1.entries();
        if (!localEnumeration.hasMoreElements()) {
          continue;
        }
        localObject2 = (ZipEntry)localEnumeration.nextElement();
        localInputStream = paramString1.getInputStream((ZipEntry)localObject2);
        localObject1 = new File(str + ((ZipEntry)localObject2).getName());
        if (!((ZipEntry)localObject2).isDirectory()) {
          continue;
        }
        ((File)localObject1).mkdirs();
      }
      catch (IOException paramString1)
      {
        InputStream localInputStream;
        paramString1.printStackTrace();
        return;
        Object localObject2 = ((File)localObject1).getParentFile();
        if (((File)localObject2).exists()) {
          continue;
        }
        ((File)localObject2).mkdirs();
        Object localObject1 = new FileOutputStream((File)localObject1);
        int i = localInputStream.read(paramString2);
        if (i <= 0) {
          continue;
        }
        ((FileOutputStream)localObject1).write(paramString2, 0, i);
        continue;
        ((FileOutputStream)localObject1).close();
        continue;
      }
      catch (Exception paramString1) {}
      localInputStream.close();
    }
  }
  
  public static boolean a(NetworkInfo paramNetworkInfo)
  {
    if (paramNetworkInfo == null) {}
    while ((paramNetworkInfo.getType() != 0) && (50 != paramNetworkInfo.getType())) {
      return false;
    }
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (jdField_a_of_type_AndroidNetConnectivityManager == null) {
      jdField_a_of_type_AndroidNetConnectivityManager = (ConnectivityManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("connectivity");
    }
    if ((jdField_a_of_type_AndroidNetConnectivityManager == null) || (paramString2 == null)) {
      return false;
    }
    localObject = null;
    try
    {
      NetworkInfo localNetworkInfo = jdField_a_of_type_AndroidNetConnectivityManager.getActiveNetworkInfo();
      localObject = localNetworkInfo;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
      localObject.getType();
      try
      {
        paramString1 = new URL(paramString1);
        return a(paramString1, paramString2, paramString3, paramBoolean, localObject);
      }
      catch (MalformedURLException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    return localObject != null;
  }
  
  /* Error */
  public boolean a(URL paramURL, String paramString1, String paramString2, boolean paramBoolean, NetworkInfo paramNetworkInfo)
  {
    // Byte code:
    //   0: iload 4
    //   2: ifne +66 -> 68
    //   5: new 53	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   12: aload_2
    //   13: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: ldc 164
    //   18: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: astore 12
    //   26: new 89	java/io/File
    //   29: dup
    //   30: aload 12
    //   32: invokespecial 93	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore 11
    //   37: new 89	java/io/File
    //   40: dup
    //   41: aload_2
    //   42: invokespecial 93	java/io/File:<init>	(Ljava/lang/String;)V
    //   45: astore 14
    //   47: aload_2
    //   48: astore 13
    //   50: aload 14
    //   52: astore_2
    //   53: aload_2
    //   54: ifnull +8 -> 62
    //   57: aload 11
    //   59: ifnonnull +113 -> 172
    //   62: iconst_0
    //   63: istore 10
    //   65: iload 10
    //   67: ireturn
    //   68: aload_2
    //   69: invokevirtual 167	java/lang/String:trim	()Ljava/lang/String;
    //   72: astore 11
    //   74: aload 11
    //   76: astore_2
    //   77: aload 11
    //   79: ldc 47
    //   81: invokevirtual 51	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   84: ifne +37 -> 121
    //   87: aload 11
    //   89: astore_2
    //   90: aload 11
    //   92: ldc 169
    //   94: invokevirtual 51	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   97: ifne +24 -> 121
    //   100: new 53	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   107: aload 11
    //   109: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: ldc 47
    //   114: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: astore_2
    //   121: new 53	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   128: aload_2
    //   129: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: ldc 171
    //   134: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: astore 12
    //   142: new 89	java/io/File
    //   145: dup
    //   146: aload 12
    //   148: invokespecial 93	java/io/File:<init>	(Ljava/lang/String;)V
    //   151: astore 11
    //   153: new 89	java/io/File
    //   156: dup
    //   157: aload_2
    //   158: invokespecial 93	java/io/File:<init>	(Ljava/lang/String;)V
    //   161: astore 14
    //   163: aload_2
    //   164: astore 13
    //   166: aload 14
    //   168: astore_2
    //   169: goto -116 -> 53
    //   172: aload 11
    //   174: invokevirtual 114	java/io/File:exists	()Z
    //   177: ifeq +13 -> 190
    //   180: aload 11
    //   182: invokevirtual 174	java/io/File:delete	()Z
    //   185: ifne +5 -> 190
    //   188: iconst_0
    //   189: ireturn
    //   190: aload 11
    //   192: invokevirtual 111	java/io/File:getParentFile	()Ljava/io/File;
    //   195: astore 14
    //   197: aload 14
    //   199: ifnull +17 -> 216
    //   202: aload 14
    //   204: invokevirtual 114	java/io/File:exists	()Z
    //   207: ifne +9 -> 216
    //   210: aload 14
    //   212: invokevirtual 99	java/io/File:mkdirs	()Z
    //   215: pop
    //   216: aload_1
    //   217: invokevirtual 175	java/net/URL:toString	()Ljava/lang/String;
    //   220: astore 15
    //   222: new 177	org/apache/http/client/methods/HttpGet
    //   225: dup
    //   226: aload 15
    //   228: invokespecial 178	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   231: astore 14
    //   233: new 180	org/apache/http/params/BasicHttpParams
    //   236: dup
    //   237: invokespecial 181	org/apache/http/params/BasicHttpParams:<init>	()V
    //   240: astore 15
    //   242: sipush 20000
    //   245: istore 7
    //   247: sipush 10000
    //   250: istore 6
    //   252: aload 5
    //   254: ifnull +104 -> 358
    //   257: invokestatic 186	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   260: astore 16
    //   262: invokestatic 189	android/net/Proxy:getDefaultPort	()I
    //   265: istore 6
    //   267: aload 5
    //   269: invokevirtual 192	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   272: astore 17
    //   274: aload 5
    //   276: invokestatic 194	com/tencent/mobileqq/antiphing/DownloadFileHelper:a	(Landroid/net/NetworkInfo;)Z
    //   279: ifeq +49 -> 328
    //   282: aload 17
    //   284: ifnull +13 -> 297
    //   287: aload 17
    //   289: ldc 196
    //   291: invokevirtual 51	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   294: ifeq +34 -> 328
    //   297: aload 16
    //   299: ifnull +29 -> 328
    //   302: iload 6
    //   304: ifle +24 -> 328
    //   307: aload 15
    //   309: ldc 198
    //   311: new 200	org/apache/http/HttpHost
    //   314: dup
    //   315: aload 16
    //   317: iload 6
    //   319: invokespecial 203	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   322: invokeinterface 209 3 0
    //   327: pop
    //   328: aload 5
    //   330: invokestatic 194	com/tencent/mobileqq/antiphing/DownloadFileHelper:a	(Landroid/net/NetworkInfo;)Z
    //   333: ifeq +414 -> 747
    //   336: sipush 20000
    //   339: istore 7
    //   341: ldc 210
    //   343: istore 6
    //   345: aload 15
    //   347: ldc 212
    //   349: sipush 2048
    //   352: invokeinterface 216 3 0
    //   357: pop
    //   358: aload 15
    //   360: ldc 218
    //   362: iload 7
    //   364: invokestatic 224	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   367: invokeinterface 209 3 0
    //   372: pop
    //   373: aload 15
    //   375: ldc 226
    //   377: iload 6
    //   379: invokestatic 224	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   382: invokeinterface 209 3 0
    //   387: pop
    //   388: aload 14
    //   390: aload 15
    //   392: invokevirtual 230	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   395: iconst_0
    //   396: istore 6
    //   398: iconst_0
    //   399: istore 9
    //   401: iload 6
    //   403: iconst_1
    //   404: if_icmpne +20 -> 424
    //   407: aload 15
    //   409: ldc 198
    //   411: invokeinterface 233 2 0
    //   416: pop
    //   417: aload 14
    //   419: aload 15
    //   421: invokevirtual 230	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   424: iload 6
    //   426: iconst_1
    //   427: iadd
    //   428: istore 7
    //   430: new 180	org/apache/http/params/BasicHttpParams
    //   433: dup
    //   434: invokespecial 181	org/apache/http/params/BasicHttpParams:<init>	()V
    //   437: astore 5
    //   439: aload 5
    //   441: getstatic 239	org/apache/http/HttpVersion:HTTP_1_1	Lorg/apache/http/HttpVersion;
    //   444: invokestatic 245	org/apache/http/params/HttpProtocolParams:setVersion	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/ProtocolVersion;)V
    //   447: aload 5
    //   449: ldc 247
    //   451: invokestatic 251	org/apache/http/params/HttpProtocolParams:setContentCharset	(Lorg/apache/http/params/HttpParams;Ljava/lang/String;)V
    //   454: aload 5
    //   456: iconst_1
    //   457: invokestatic 255	org/apache/http/params/HttpProtocolParams:setUseExpectContinue	(Lorg/apache/http/params/HttpParams;Z)V
    //   460: new 257	org/apache/http/conn/scheme/SchemeRegistry
    //   463: dup
    //   464: invokespecial 258	org/apache/http/conn/scheme/SchemeRegistry:<init>	()V
    //   467: astore 16
    //   469: aload 16
    //   471: new 260	org/apache/http/conn/scheme/Scheme
    //   474: dup
    //   475: ldc_w 262
    //   478: invokestatic 268	org/apache/http/conn/scheme/PlainSocketFactory:getSocketFactory	()Lorg/apache/http/conn/scheme/PlainSocketFactory;
    //   481: bipush 80
    //   483: invokespecial 271	org/apache/http/conn/scheme/Scheme:<init>	(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V
    //   486: invokevirtual 275	org/apache/http/conn/scheme/SchemeRegistry:register	(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;
    //   489: pop
    //   490: new 277	org/apache/http/impl/client/DefaultHttpClient
    //   493: dup
    //   494: new 279	org/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager
    //   497: dup
    //   498: aload 5
    //   500: aload 16
    //   502: invokespecial 282	org/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager:<init>	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/scheme/SchemeRegistry;)V
    //   505: aload 5
    //   507: invokespecial 285	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V
    //   510: putstatic 14	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   513: getstatic 14	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   516: new 287	org/apache/http/impl/client/DefaultHttpRequestRetryHandler
    //   519: dup
    //   520: invokespecial 288	org/apache/http/impl/client/DefaultHttpRequestRetryHandler:<init>	()V
    //   523: invokevirtual 292	org/apache/http/impl/client/DefaultHttpClient:setHttpRequestRetryHandler	(Lorg/apache/http/client/HttpRequestRetryHandler;)V
    //   526: getstatic 14	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   529: new 200	org/apache/http/HttpHost
    //   532: dup
    //   533: aload_1
    //   534: invokevirtual 295	java/net/URL:getHost	()Ljava/lang/String;
    //   537: invokespecial 296	org/apache/http/HttpHost:<init>	(Ljava/lang/String;)V
    //   540: aload 14
    //   542: invokevirtual 300	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpResponse;
    //   545: astore 5
    //   547: iload 9
    //   549: istore 8
    //   551: sipush 200
    //   554: aload 5
    //   556: invokeinterface 306 1 0
    //   561: invokeinterface 311 1 0
    //   566: if_icmpne +109 -> 675
    //   569: aload 5
    //   571: invokeinterface 315 1 0
    //   576: astore 5
    //   578: aload 5
    //   580: invokeinterface 321 1 0
    //   585: pop2
    //   586: new 116	java/io/FileOutputStream
    //   589: dup
    //   590: aload 11
    //   592: invokespecial 119	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   595: astore 16
    //   597: aload 5
    //   599: aload 16
    //   601: invokeinterface 325 2 0
    //   606: aload 11
    //   608: invokevirtual 328	java/io/File:length	()J
    //   611: pop2
    //   612: aload 11
    //   614: invokestatic 333	java/lang/System:currentTimeMillis	()J
    //   617: invokevirtual 337	java/io/File:setLastModified	(J)Z
    //   620: pop
    //   621: aload 16
    //   623: invokevirtual 340	java/io/OutputStream:close	()V
    //   626: aload 12
    //   628: invokestatic 344	com/tencent/open/base/MD5Utils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   631: aload_3
    //   632: invokevirtual 347	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   635: ifeq +171 -> 806
    //   638: ldc_w 349
    //   641: iconst_1
    //   642: ldc_w 351
    //   645: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   648: iload 4
    //   650: iconst_1
    //   651: if_icmpne +122 -> 773
    //   654: ldc_w 349
    //   657: iconst_2
    //   658: ldc_w 359
    //   661: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   664: aload_0
    //   665: aload 12
    //   667: aload 13
    //   669: invokespecial 361	com/tencent/mobileqq/antiphing/DownloadFileHelper:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   672: iconst_1
    //   673: istore 8
    //   675: getstatic 14	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   678: ifnull +18 -> 696
    //   681: getstatic 14	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   684: invokevirtual 365	org/apache/http/impl/client/DefaultHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   687: invokeinterface 370 1 0
    //   692: aconst_null
    //   693: putstatic 14	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   696: iload 8
    //   698: istore 10
    //   700: iload 8
    //   702: ifne -637 -> 65
    //   705: iload 8
    //   707: istore 9
    //   709: iload 7
    //   711: istore 6
    //   713: iload 7
    //   715: iconst_2
    //   716: if_icmplt -315 -> 401
    //   719: iload 8
    //   721: ireturn
    //   722: astore_1
    //   723: iconst_0
    //   724: ireturn
    //   725: astore 14
    //   727: new 177	org/apache/http/client/methods/HttpGet
    //   730: dup
    //   731: aload 15
    //   733: invokestatic 371	com/tencent/mobileqq/antiphing/DownloadFileHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   736: invokespecial 178	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   739: astore 14
    //   741: goto -508 -> 233
    //   744: astore_1
    //   745: iconst_0
    //   746: ireturn
    //   747: sipush 10000
    //   750: istore 7
    //   752: sipush 30000
    //   755: istore 6
    //   757: aload 15
    //   759: ldc 212
    //   761: sipush 4096
    //   764: invokeinterface 216 3 0
    //   769: pop
    //   770: goto -412 -> 358
    //   773: ldc_w 349
    //   776: iconst_2
    //   777: ldc_w 373
    //   780: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   783: aload_2
    //   784: invokevirtual 114	java/io/File:exists	()Z
    //   787: ifeq +8 -> 795
    //   790: aload_2
    //   791: invokevirtual 174	java/io/File:delete	()Z
    //   794: pop
    //   795: aload 11
    //   797: aload_2
    //   798: invokevirtual 377	java/io/File:renameTo	(Ljava/io/File;)Z
    //   801: istore 8
    //   803: goto -128 -> 675
    //   806: ldc_w 349
    //   809: iconst_1
    //   810: ldc_w 379
    //   813: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   816: iload 9
    //   818: istore 10
    //   820: getstatic 14	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   823: ifnull -758 -> 65
    //   826: getstatic 14	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   829: invokevirtual 365	org/apache/http/impl/client/DefaultHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   832: invokeinterface 370 1 0
    //   837: aconst_null
    //   838: putstatic 14	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   841: iload 9
    //   843: ireturn
    //   844: astore_1
    //   845: aload_1
    //   846: invokevirtual 153	java/lang/Exception:printStackTrace	()V
    //   849: iload 9
    //   851: istore 10
    //   853: getstatic 14	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   856: ifnull -791 -> 65
    //   859: getstatic 14	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   862: invokevirtual 365	org/apache/http/impl/client/DefaultHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   865: invokeinterface 370 1 0
    //   870: aconst_null
    //   871: putstatic 14	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   874: iload 9
    //   876: ireturn
    //   877: astore_1
    //   878: aload_1
    //   879: invokevirtual 153	java/lang/Exception:printStackTrace	()V
    //   882: iload 9
    //   884: istore 10
    //   886: getstatic 14	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   889: ifnull -824 -> 65
    //   892: getstatic 14	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   895: invokevirtual 365	org/apache/http/impl/client/DefaultHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   898: invokeinterface 370 1 0
    //   903: aconst_null
    //   904: putstatic 14	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   907: iload 9
    //   909: ireturn
    //   910: astore_1
    //   911: getstatic 14	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   914: ifnull +18 -> 932
    //   917: getstatic 14	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   920: invokevirtual 365	org/apache/http/impl/client/DefaultHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   923: invokeinterface 370 1 0
    //   928: aconst_null
    //   929: putstatic 14	com/tencent/mobileqq/antiphing/DownloadFileHelper:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   932: aload_1
    //   933: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	934	0	this	DownloadFileHelper
    //   0	934	1	paramURL	URL
    //   0	934	2	paramString1	String
    //   0	934	3	paramString2	String
    //   0	934	4	paramBoolean	boolean
    //   0	934	5	paramNetworkInfo	NetworkInfo
    //   250	506	6	i	int
    //   245	506	7	j	int
    //   549	253	8	bool1	boolean
    //   399	509	9	bool2	boolean
    //   63	822	10	bool3	boolean
    //   35	761	11	localObject1	Object
    //   24	642	12	str1	String
    //   48	620	13	str2	String
    //   45	496	14	localObject2	Object
    //   725	1	14	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   739	1	14	localHttpGet	org.apache.http.client.methods.HttpGet
    //   220	538	15	localObject3	Object
    //   260	362	16	localObject4	Object
    //   272	16	17	str3	String
    // Exception table:
    //   from	to	target	type
    //   190	197	722	java/lang/Exception
    //   202	216	722	java/lang/Exception
    //   222	233	725	java/lang/IllegalArgumentException
    //   727	741	744	java/lang/Exception
    //   586	648	844	java/lang/Exception
    //   654	672	844	java/lang/Exception
    //   773	795	844	java/lang/Exception
    //   795	803	844	java/lang/Exception
    //   806	816	844	java/lang/Exception
    //   430	547	877	java/lang/Exception
    //   551	586	877	java/lang/Exception
    //   845	849	877	java/lang/Exception
    //   430	547	910	finally
    //   551	586	910	finally
    //   586	648	910	finally
    //   654	672	910	finally
    //   773	795	910	finally
    //   795	803	910	finally
    //   806	816	910	finally
    //   845	849	910	finally
    //   878	882	910	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.antiphing.DownloadFileHelper
 * JD-Core Version:    0.7.0.1
 */