package com.tencent.open.business.base.appreport;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.Settings.Secure;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.open.business.base.OpenConfig;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import lfb;
import lfc;

public class AppReport
{
  protected static final int a = 10;
  protected static final long a = 86400000L;
  protected static final String a = "AppReport";
  public static Lock a;
  public static boolean a = false;
  public static final int b = 70;
  public static final String b = "appcenter_app_report_storage_file.txt";
  public static final int c = 1;
  public static final String c = "appcenter_app_report";
  public static final int d = 2;
  public static final String d = "app_last_fullReport_success_time";
  public static final int e = 4;
  public static final String e = "is_app_last_fullReport_success";
  public static final int f = 8;
  protected static final String f = "full_report_date";
  protected static final String g = "full_report_day_times";
  public static final String h = "is_incremental_report_overflow";
  protected static final String i = "platform";
  protected static final String j = "version";
  protected static final String k = "android_id";
  protected static final String l = "imsi";
  protected static final String m = "mac_addr";
  protected static final String n = "imei";
  protected static final String o = "keystr";
  protected static final String p = "sid";
  protected static final String q = "uin";
  protected static final String r = "resolution";
  protected static final String s = "model_info";
  protected static final String t = "package";
  protected static final String u = "type";
  protected static final String v = "ALL";
  protected static final String w = "INC";
  protected static final String x = "https://fusionbase.qq.com/cgi-bin/appstage/sdk_update";
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
    jdField_a_of_type_Boolean = false;
  }
  
  public static Bundle a(Context paramContext, Map paramMap, String paramString1, String paramString2)
  {
    paramContext = new Bundle();
    paramContext.putString("platform", CommonDataAdapter.a().g());
    paramContext.putString("version", CommonDataAdapter.a().c());
    paramContext.putString("uin", paramString2);
    paramContext.putString("imei", MobileInfoUtil.c());
    paramContext.putString("imsi", MobileInfoUtil.d());
    paramContext.putString("android_id", Settings.Secure.getString(CommonDataAdapter.a().a().getContentResolver(), "android_id"));
    paramContext.putString("mac_addr", MobileInfoUtil.a());
    paramContext.putString("model_info", Build.MODEL);
    paramContext.putString("resolution", MobileInfoUtil.e());
    paramContext.putString("keystr", CommonDataAdapter.a().a());
    paramContext.putString("sid", CommonDataAdapter.a().a());
    paramContext.putString("package", paramMap.values().toString());
    paramContext.putString("type", paramString1);
    return paramContext;
  }
  
  protected static String a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    return a(paramString1, paramInt1, paramString2, paramInt2, "");
  }
  
  public static String a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[\"");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("\",");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",\"");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("\",");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(",\"");
    localStringBuilder.append(paramString3);
    localStringBuilder.append("\"");
    localStringBuilder.append("]");
    LogUtility.b("AppReport", "message to cgi: " + localStringBuilder.toString());
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static Map a(Context paramContext)
  {
    // Byte code:
    //   0: new 206	java/io/File
    //   3: dup
    //   4: new 168	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   11: aload_0
    //   12: invokevirtual 210	android/content/Context:getFilesDir	()Ljava/io/File;
    //   15: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   18: getstatic 216	java/io/File:separator	Ljava/lang/String;
    //   21: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc 20
    //   26: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokespecial 219	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: invokevirtual 223	java/io/File:exists	()Z
    //   38: ifne +5 -> 43
    //   41: aconst_null
    //   42: areturn
    //   43: getstatic 99	com/tencent/open/business/base/appreport/AppReport:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   46: invokeinterface 228 1 0
    //   51: aload_0
    //   52: ldc 20
    //   54: invokevirtual 232	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   57: astore 4
    //   59: new 234	java/io/ByteArrayOutputStream
    //   62: dup
    //   63: invokespecial 235	java/io/ByteArrayOutputStream:<init>	()V
    //   66: astore 5
    //   68: aload 5
    //   70: astore 6
    //   72: aload 4
    //   74: astore 7
    //   76: sipush 1024
    //   79: newarray byte
    //   81: astore 8
    //   83: aload 5
    //   85: astore 6
    //   87: aload 4
    //   89: astore 7
    //   91: aload 4
    //   93: aload 8
    //   95: invokevirtual 241	java/io/FileInputStream:read	([B)I
    //   98: istore_1
    //   99: iload_1
    //   100: iconst_m1
    //   101: if_icmpeq +64 -> 165
    //   104: aload 5
    //   106: astore 6
    //   108: aload 4
    //   110: astore 7
    //   112: aload 5
    //   114: aload 8
    //   116: iconst_0
    //   117: iload_1
    //   118: invokevirtual 245	java/io/ByteArrayOutputStream:write	([BII)V
    //   121: goto -38 -> 83
    //   124: astore 6
    //   126: aload 5
    //   128: astore_0
    //   129: aload 6
    //   131: astore 5
    //   133: aload 5
    //   135: invokevirtual 248	java/io/FileNotFoundException:printStackTrace	()V
    //   138: aload 4
    //   140: ifnull +8 -> 148
    //   143: aload 4
    //   145: invokevirtual 251	java/io/FileInputStream:close	()V
    //   148: aload_0
    //   149: ifnull -108 -> 41
    //   152: aload_0
    //   153: invokevirtual 252	java/io/ByteArrayOutputStream:close	()V
    //   156: aconst_null
    //   157: areturn
    //   158: astore_0
    //   159: aload_0
    //   160: invokevirtual 253	java/io/IOException:printStackTrace	()V
    //   163: aconst_null
    //   164: areturn
    //   165: aload 5
    //   167: astore 6
    //   169: aload 4
    //   171: astore 7
    //   173: getstatic 99	com/tencent/open/business/base/appreport/AppReport:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   176: invokeinterface 256 1 0
    //   181: aload 5
    //   183: astore 6
    //   185: aload 4
    //   187: astore 7
    //   189: new 258	java/lang/String
    //   192: dup
    //   193: aload 5
    //   195: invokevirtual 262	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   198: invokespecial 265	java/lang/String:<init>	([B)V
    //   201: invokevirtual 268	java/lang/String:trim	()Ljava/lang/String;
    //   204: astore 8
    //   206: aload 5
    //   208: astore 6
    //   210: aload 4
    //   212: astore 7
    //   214: aload 8
    //   216: invokevirtual 272	java/lang/String:length	()I
    //   219: ifle +620 -> 839
    //   222: aload 5
    //   224: astore 6
    //   226: aload 4
    //   228: astore 7
    //   230: aload 8
    //   232: iconst_0
    //   233: aload 8
    //   235: invokevirtual 272	java/lang/String:length	()I
    //   238: iconst_1
    //   239: isub
    //   240: invokevirtual 276	java/lang/String:substring	(II)Ljava/lang/String;
    //   243: ldc_w 278
    //   246: invokevirtual 282	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   249: astore 8
    //   251: aload 5
    //   253: astore 6
    //   255: aload 4
    //   257: astore 7
    //   259: new 284	java/util/HashMap
    //   262: dup
    //   263: invokespecial 285	java/util/HashMap:<init>	()V
    //   266: astore 9
    //   268: aload 8
    //   270: ifnull +428 -> 698
    //   273: aload 5
    //   275: astore 6
    //   277: aload 4
    //   279: astore 7
    //   281: aload 8
    //   283: arraylength
    //   284: ifle +414 -> 698
    //   287: aload 5
    //   289: astore 6
    //   291: aload 4
    //   293: astore 7
    //   295: aload 8
    //   297: arraylength
    //   298: istore_2
    //   299: iconst_0
    //   300: istore_1
    //   301: iload_1
    //   302: iload_2
    //   303: if_icmpge +395 -> 698
    //   306: aload 5
    //   308: astore 6
    //   310: aload 4
    //   312: astore 7
    //   314: aload 8
    //   316: iload_1
    //   317: aaload
    //   318: ldc_w 287
    //   321: invokevirtual 282	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   324: astore 10
    //   326: aload 5
    //   328: astore 6
    //   330: aload 4
    //   332: astore 7
    //   334: aload 10
    //   336: iconst_1
    //   337: aaload
    //   338: invokestatic 293	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   341: istore_3
    //   342: iload_3
    //   343: bipush 8
    //   345: if_icmpne +38 -> 383
    //   348: aload 5
    //   350: astore 6
    //   352: aload 4
    //   354: astore 7
    //   356: aload 9
    //   358: aload 10
    //   360: iconst_0
    //   361: aaload
    //   362: aload 10
    //   364: iconst_0
    //   365: aaload
    //   366: iconst_0
    //   367: ldc_w 295
    //   370: iload_3
    //   371: invokestatic 297	com/tencent/open/business/base/appreport/AppReport:a	(Ljava/lang/String;ILjava/lang/String;I)Ljava/lang/String;
    //   374: invokeinterface 301 3 0
    //   379: pop
    //   380: goto +465 -> 845
    //   383: aload 5
    //   385: astore 6
    //   387: aload 4
    //   389: astore 7
    //   391: aload_0
    //   392: invokevirtual 305	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   395: aload 10
    //   397: iconst_0
    //   398: aaload
    //   399: iconst_0
    //   400: invokevirtual 311	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   403: astore 11
    //   405: aload 5
    //   407: astore 6
    //   409: aload 4
    //   411: astore 7
    //   413: aload 9
    //   415: aload 10
    //   417: iconst_0
    //   418: aaload
    //   419: aload 10
    //   421: iconst_0
    //   422: aaload
    //   423: aload 11
    //   425: getfield 316	android/content/pm/PackageInfo:versionCode	I
    //   428: aload 11
    //   430: getfield 319	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   433: iload_3
    //   434: aload_0
    //   435: aload 10
    //   437: iconst_0
    //   438: aaload
    //   439: invokestatic 324	com/tencent/open/business/base/AppUtil:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   442: invokestatic 166	com/tencent/open/business/base/appreport/AppReport:a	(Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;)Ljava/lang/String;
    //   445: invokeinterface 301 3 0
    //   450: pop
    //   451: goto +394 -> 845
    //   454: astore 11
    //   456: aload 5
    //   458: astore 6
    //   460: aload 4
    //   462: astore 7
    //   464: ldc 13
    //   466: new 168	java/lang/StringBuilder
    //   469: dup
    //   470: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   473: ldc_w 326
    //   476: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: aload 10
    //   481: iconst_0
    //   482: aaload
    //   483: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: ldc_w 328
    //   489: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: aload 11
    //   494: invokevirtual 329	android/content/pm/PackageManager$NameNotFoundException:toString	()Ljava/lang/String;
    //   497: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   503: invokestatic 331	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   506: goto +339 -> 845
    //   509: astore 6
    //   511: aload 5
    //   513: astore_0
    //   514: aload 6
    //   516: astore 5
    //   518: aload_0
    //   519: astore 6
    //   521: aload 4
    //   523: astore 7
    //   525: aload 5
    //   527: invokevirtual 253	java/io/IOException:printStackTrace	()V
    //   530: aload 4
    //   532: ifnull +8 -> 540
    //   535: aload 4
    //   537: invokevirtual 251	java/io/FileInputStream:close	()V
    //   540: aload_0
    //   541: ifnull -500 -> 41
    //   544: aload_0
    //   545: invokevirtual 252	java/io/ByteArrayOutputStream:close	()V
    //   548: aconst_null
    //   549: areturn
    //   550: astore_0
    //   551: aload_0
    //   552: invokevirtual 253	java/io/IOException:printStackTrace	()V
    //   555: aconst_null
    //   556: areturn
    //   557: astore 11
    //   559: aload 5
    //   561: astore 6
    //   563: aload 4
    //   565: astore 7
    //   567: ldc 13
    //   569: new 168	java/lang/StringBuilder
    //   572: dup
    //   573: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   576: ldc_w 333
    //   579: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: aload 10
    //   584: iconst_0
    //   585: aaload
    //   586: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: ldc_w 328
    //   592: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: aload 11
    //   597: invokevirtual 334	java/lang/NumberFormatException:toString	()Ljava/lang/String;
    //   600: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   606: invokestatic 331	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   609: goto +236 -> 845
    //   612: astore_0
    //   613: aload 7
    //   615: astore 4
    //   617: aload 6
    //   619: astore 5
    //   621: aload 4
    //   623: ifnull +8 -> 631
    //   626: aload 4
    //   628: invokevirtual 251	java/io/FileInputStream:close	()V
    //   631: aload 5
    //   633: ifnull +8 -> 641
    //   636: aload 5
    //   638: invokevirtual 252	java/io/ByteArrayOutputStream:close	()V
    //   641: aload_0
    //   642: athrow
    //   643: astore 11
    //   645: aload 5
    //   647: astore 6
    //   649: aload 4
    //   651: astore 7
    //   653: ldc 13
    //   655: new 168	java/lang/StringBuilder
    //   658: dup
    //   659: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   662: ldc_w 333
    //   665: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: aload 10
    //   670: iconst_0
    //   671: aaload
    //   672: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: ldc_w 328
    //   678: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: aload 11
    //   683: invokevirtual 335	java/lang/Exception:toString	()Ljava/lang/String;
    //   686: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   692: invokestatic 331	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   695: goto +150 -> 845
    //   698: aload 4
    //   700: ifnull +8 -> 708
    //   703: aload 4
    //   705: invokevirtual 251	java/io/FileInputStream:close	()V
    //   708: aload 5
    //   710: ifnull +8 -> 718
    //   713: aload 5
    //   715: invokevirtual 252	java/io/ByteArrayOutputStream:close	()V
    //   718: aload 9
    //   720: areturn
    //   721: astore_0
    //   722: aload_0
    //   723: invokevirtual 253	java/io/IOException:printStackTrace	()V
    //   726: goto -18 -> 708
    //   729: astore_0
    //   730: aload_0
    //   731: invokevirtual 253	java/io/IOException:printStackTrace	()V
    //   734: goto -16 -> 718
    //   737: astore 4
    //   739: aload 4
    //   741: invokevirtual 253	java/io/IOException:printStackTrace	()V
    //   744: goto -596 -> 148
    //   747: astore 4
    //   749: aload 4
    //   751: invokevirtual 253	java/io/IOException:printStackTrace	()V
    //   754: goto -214 -> 540
    //   757: astore 4
    //   759: aload 4
    //   761: invokevirtual 253	java/io/IOException:printStackTrace	()V
    //   764: goto -133 -> 631
    //   767: astore 4
    //   769: aload 4
    //   771: invokevirtual 253	java/io/IOException:printStackTrace	()V
    //   774: goto -133 -> 641
    //   777: astore_0
    //   778: aconst_null
    //   779: astore 5
    //   781: aconst_null
    //   782: astore 4
    //   784: goto -163 -> 621
    //   787: astore_0
    //   788: aconst_null
    //   789: astore 5
    //   791: goto -170 -> 621
    //   794: astore 6
    //   796: aload_0
    //   797: astore 5
    //   799: aload 6
    //   801: astore_0
    //   802: goto -181 -> 621
    //   805: astore 5
    //   807: aconst_null
    //   808: astore_0
    //   809: aconst_null
    //   810: astore 4
    //   812: goto -294 -> 518
    //   815: astore 5
    //   817: aconst_null
    //   818: astore_0
    //   819: goto -301 -> 518
    //   822: astore 5
    //   824: aconst_null
    //   825: astore_0
    //   826: aconst_null
    //   827: astore 4
    //   829: goto -696 -> 133
    //   832: astore 5
    //   834: aconst_null
    //   835: astore_0
    //   836: goto -703 -> 133
    //   839: aconst_null
    //   840: astore 8
    //   842: goto -591 -> 251
    //   845: iload_1
    //   846: iconst_1
    //   847: iadd
    //   848: istore_1
    //   849: goto -548 -> 301
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	852	0	paramContext	Context
    //   98	751	1	i1	int
    //   298	6	2	i2	int
    //   341	93	3	i3	int
    //   57	647	4	localObject1	Object
    //   737	3	4	localIOException1	IOException
    //   747	3	4	localIOException2	IOException
    //   757	3	4	localIOException3	IOException
    //   767	3	4	localIOException4	IOException
    //   782	46	4	localObject2	Object
    //   66	732	5	localObject3	Object
    //   805	1	5	localIOException5	IOException
    //   815	1	5	localIOException6	IOException
    //   822	1	5	localFileNotFoundException1	FileNotFoundException
    //   832	1	5	localFileNotFoundException2	FileNotFoundException
    //   70	37	6	localObject4	Object
    //   124	6	6	localFileNotFoundException3	FileNotFoundException
    //   167	292	6	localObject5	Object
    //   509	6	6	localIOException7	IOException
    //   519	129	6	localObject6	Object
    //   794	6	6	localObject7	Object
    //   74	578	7	localObject8	Object
    //   81	760	8	localObject9	Object
    //   266	453	9	localHashMap	java.util.HashMap
    //   324	345	10	arrayOfString	String[]
    //   403	26	11	localPackageInfo	android.content.pm.PackageInfo
    //   454	39	11	localNameNotFoundException	android.content.pm.PackageManager.NameNotFoundException
    //   557	39	11	localNumberFormatException	java.lang.NumberFormatException
    //   643	39	11	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   76	83	124	java/io/FileNotFoundException
    //   91	99	124	java/io/FileNotFoundException
    //   112	121	124	java/io/FileNotFoundException
    //   173	181	124	java/io/FileNotFoundException
    //   189	206	124	java/io/FileNotFoundException
    //   214	222	124	java/io/FileNotFoundException
    //   230	251	124	java/io/FileNotFoundException
    //   259	268	124	java/io/FileNotFoundException
    //   281	287	124	java/io/FileNotFoundException
    //   295	299	124	java/io/FileNotFoundException
    //   314	326	124	java/io/FileNotFoundException
    //   334	342	124	java/io/FileNotFoundException
    //   356	380	124	java/io/FileNotFoundException
    //   391	405	124	java/io/FileNotFoundException
    //   413	451	124	java/io/FileNotFoundException
    //   464	506	124	java/io/FileNotFoundException
    //   567	609	124	java/io/FileNotFoundException
    //   653	695	124	java/io/FileNotFoundException
    //   152	156	158	java/io/IOException
    //   334	342	454	android/content/pm/PackageManager$NameNotFoundException
    //   356	380	454	android/content/pm/PackageManager$NameNotFoundException
    //   391	405	454	android/content/pm/PackageManager$NameNotFoundException
    //   413	451	454	android/content/pm/PackageManager$NameNotFoundException
    //   76	83	509	java/io/IOException
    //   91	99	509	java/io/IOException
    //   112	121	509	java/io/IOException
    //   173	181	509	java/io/IOException
    //   189	206	509	java/io/IOException
    //   214	222	509	java/io/IOException
    //   230	251	509	java/io/IOException
    //   259	268	509	java/io/IOException
    //   281	287	509	java/io/IOException
    //   295	299	509	java/io/IOException
    //   314	326	509	java/io/IOException
    //   334	342	509	java/io/IOException
    //   356	380	509	java/io/IOException
    //   391	405	509	java/io/IOException
    //   413	451	509	java/io/IOException
    //   464	506	509	java/io/IOException
    //   567	609	509	java/io/IOException
    //   653	695	509	java/io/IOException
    //   544	548	550	java/io/IOException
    //   334	342	557	java/lang/NumberFormatException
    //   356	380	557	java/lang/NumberFormatException
    //   391	405	557	java/lang/NumberFormatException
    //   413	451	557	java/lang/NumberFormatException
    //   76	83	612	finally
    //   91	99	612	finally
    //   112	121	612	finally
    //   173	181	612	finally
    //   189	206	612	finally
    //   214	222	612	finally
    //   230	251	612	finally
    //   259	268	612	finally
    //   281	287	612	finally
    //   295	299	612	finally
    //   314	326	612	finally
    //   334	342	612	finally
    //   356	380	612	finally
    //   391	405	612	finally
    //   413	451	612	finally
    //   464	506	612	finally
    //   525	530	612	finally
    //   567	609	612	finally
    //   653	695	612	finally
    //   334	342	643	java/lang/Exception
    //   356	380	643	java/lang/Exception
    //   391	405	643	java/lang/Exception
    //   413	451	643	java/lang/Exception
    //   703	708	721	java/io/IOException
    //   713	718	729	java/io/IOException
    //   143	148	737	java/io/IOException
    //   535	540	747	java/io/IOException
    //   626	631	757	java/io/IOException
    //   636	641	767	java/io/IOException
    //   43	59	777	finally
    //   59	68	787	finally
    //   133	138	794	finally
    //   43	59	805	java/io/IOException
    //   59	68	815	java/io/IOException
    //   43	59	822	java/io/FileNotFoundException
    //   59	68	832	java/io/FileNotFoundException
  }
  
  public static void a(Context paramContext)
  {
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("appcenter_app_report", 0).edit();
    localEditor.putLong("app_last_fullReport_success_time", SystemClock.currentThreadTimeMillis());
    localEditor.putBoolean("is_app_last_fullReport_success", true);
    localEditor.putBoolean("is_incremental_report_overflow", false);
    localEditor.commit();
    if (new File(paramContext.getFilesDir() + File.separator + "appcenter_app_report_storage_file.txt").exists())
    {
      jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
      paramContext.deleteFile("appcenter_app_report_storage_file.txt");
      jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    LogUtility.b("AppReport", "save package <" + paramString + " : " + paramInt + "> to local");
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject4 = null;
    Object localObject2 = localObject4;
    Object localObject3 = localObject5;
    localObject1 = localObject6;
    try
    {
      jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
      localObject2 = localObject4;
      localObject3 = localObject5;
      localObject1 = localObject6;
      paramContext = paramContext.openFileOutput("appcenter_app_report_storage_file.txt", 32768);
      localObject2 = paramContext;
      localObject3 = paramContext;
      localObject1 = paramContext;
      paramContext.write((paramString + ":" + paramInt + ",").getBytes());
      if (paramContext != null) {}
      try
      {
        paramContext.close();
        jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        return;
      }
      catch (IOException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
      }
      try
      {
        ((FileOutputStream)localObject1).close();
        jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        throw paramContext;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
    }
    catch (FileNotFoundException paramContext)
    {
      localObject1 = localObject2;
      paramContext.printStackTrace();
      if (localObject2 != null) {}
      try
      {
        ((FileOutputStream)localObject2).close();
        jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        return;
      }
      catch (IOException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
      }
    }
    catch (IOException paramContext)
    {
      localObject1 = localObject3;
      paramContext.printStackTrace();
      if (localObject3 != null) {}
      try
      {
        ((FileOutputStream)localObject3).close();
        jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        return;
      }
      catch (IOException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
      }
    }
    finally
    {
      if (localObject1 == null) {}
    }
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt, String paramString2, WebView paramWebView, String paramString3)
  {
    ThreadManager.a(new lfb(paramString1, paramInt, paramContext, paramString2, paramWebView, paramString3));
  }
  
  public static void a(Context paramContext, String paramString1, WebView paramWebView, String paramString2)
  {
    ThreadManager.a(new lfc(paramContext, paramString1, paramWebView, paramString2));
  }
  
  public static boolean a()
  {
    boolean bool = OpenConfig.a(CommonDataAdapter.a().a(), null).b("C_Full_Report");
    LogUtility.c("AppReport", "<AppReport>, app full report switch : " + bool);
    return bool;
  }
  
  public static boolean a(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("appcenter_app_report", 0);
    long l1 = localSharedPreferences.getLong("full_report_date", 0L);
    int i1 = localSharedPreferences.getInt("full_report_day_times", 0);
    if (SystemClock.currentThreadTimeMillis() - l1 > 86400000L)
    {
      paramContext = paramContext.getSharedPreferences("appcenter_app_report", 0).edit();
      paramContext.putLong("full_report_date", SystemClock.currentThreadTimeMillis());
      paramContext.putInt("full_report_day_times", 0);
      paramContext.commit();
      return true;
    }
    if (i1 > 10) {
      return false;
    }
    paramContext = paramContext.getSharedPreferences("appcenter_app_report", 0).edit();
    paramContext.putInt("full_report_day_times", i1 + 1);
    paramContext.commit();
    return true;
  }
  
  public static void b(Context paramContext)
  {
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("appcenter_app_report", 0).edit();
    localEditor.putBoolean("is_app_last_fullReport_success", false);
    localEditor.commit();
    if (new File(paramContext.getFilesDir() + File.separator + "appcenter_app_report_storage_file.txt").exists())
    {
      jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
      paramContext.deleteFile("appcenter_app_report_storage_file.txt");
      jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.business.base.appreport.AppReport
 * JD-Core Version:    0.7.0.1
 */