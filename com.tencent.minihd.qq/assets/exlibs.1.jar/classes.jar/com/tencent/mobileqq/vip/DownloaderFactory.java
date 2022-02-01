package com.tencent.mobileqq.vip;

import android.content.Context;
import android.net.ConnectivityManager;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class DownloaderFactory
  implements Manager
{
  public static final int a = 2048;
  static ConnectivityManager a;
  public static final String a;
  public static ConcurrentHashMap a;
  public static boolean a = false;
  public static final int b = 600;
  public static ConcurrentHashMap b = null;
  public static final int c = 5;
  public static final int d = 3;
  public static final int e = 1;
  public static final int f = 2;
  protected AppInterface a;
  
  static
  {
    jdField_a_of_type_JavaLangString = DownloaderFactory.class.getSimpleName();
    jdField_a_of_type_AndroidNetConnectivityManager = null;
    jdField_a_of_type_Boolean = true;
  }
  
  public DownloaderFactory(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    b = new ConcurrentHashMap();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    if (jdField_a_of_type_AndroidNetConnectivityManager == null) {
      jdField_a_of_type_AndroidNetConnectivityManager = (ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity");
    }
  }
  
  /* Error */
  public static int a(DownloadTask paramDownloadTask, AppInterface paramAppInterface)
  {
    // Byte code:
    //   0: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: getstatic 35	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   9: iconst_2
    //   10: ldc 86
    //   12: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: bipush 254
    //   17: istore_2
    //   18: aload_0
    //   19: invokevirtual 94	com/tencent/mobileqq/vip/DownloadTask:a	()Lcom/tencent/mobileqq/vip/DownloadListener;
    //   22: ifnonnull +14 -> 36
    //   25: aload_0
    //   26: new 96	kvr
    //   29: dup
    //   30: invokespecial 97	kvr:<init>	()V
    //   33: invokevirtual 100	com/tencent/mobileqq/vip/DownloadTask:a	(Lcom/tencent/mobileqq/vip/DownloadListener;)V
    //   36: aload_1
    //   37: ifnull +29 -> 66
    //   40: aload_0
    //   41: getfield 103	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_ComTencentMobileqqVipDownloadTask$ReportInfo	Lcom/tencent/mobileqq/vip/DownloadTask$ReportInfo;
    //   44: getfield 108	com/tencent/mobileqq/vip/DownloadTask$ReportInfo:a	J
    //   47: lconst_0
    //   48: lcmp
    //   49: ifge +17 -> 66
    //   52: aload_0
    //   53: getfield 103	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_ComTencentMobileqqVipDownloadTask$ReportInfo	Lcom/tencent/mobileqq/vip/DownloadTask$ReportInfo;
    //   56: aload_1
    //   57: invokevirtual 112	com/tencent/common/app/AppInterface:a	()Ljava/lang/String;
    //   60: invokestatic 118	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   63: putfield 108	com/tencent/mobileqq/vip/DownloadTask$ReportInfo:a	J
    //   66: aload_0
    //   67: ifnull +280 -> 347
    //   70: iconst_m1
    //   71: istore_2
    //   72: aload_0
    //   73: invokevirtual 94	com/tencent/mobileqq/vip/DownloadTask:a	()Lcom/tencent/mobileqq/vip/DownloadListener;
    //   76: astore 37
    //   78: aload 37
    //   80: ifnull +60 -> 140
    //   83: aload 37
    //   85: aload_0
    //   86: invokevirtual 124	com/tencent/mobileqq/vip/DownloadListener:onStart	(Lcom/tencent/mobileqq/vip/DownloadTask;)Z
    //   89: ifne +51 -> 140
    //   92: aload_0
    //   93: bipush 147
    //   95: putfield 127	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   98: aload 37
    //   100: aload_0
    //   101: invokevirtual 131	com/tencent/mobileqq/vip/DownloadListener:onDone	(Lcom/tencent/mobileqq/vip/DownloadTask;)V
    //   104: iload_2
    //   105: istore_3
    //   106: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   109: ifeq +5044 -> 5153
    //   112: getstatic 35	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   115: iconst_2
    //   116: new 133	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   123: ldc 136
    //   125: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload_0
    //   129: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   138: iconst_m1
    //   139: ireturn
    //   140: new 148	org/apache/http/params/BasicHttpParams
    //   143: dup
    //   144: invokespecial 149	org/apache/http/params/BasicHttpParams:<init>	()V
    //   147: astore 38
    //   149: aload 38
    //   151: ldc 151
    //   153: sipush 10000
    //   156: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   159: invokeinterface 163 3 0
    //   164: pop
    //   165: aload 38
    //   167: ldc 165
    //   169: ldc 166
    //   171: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   174: invokeinterface 163 3 0
    //   179: pop
    //   180: aload_0
    //   181: getfield 169	com/tencent/mobileqq/vip/DownloadTask:i	Z
    //   184: iconst_1
    //   185: if_icmpne +198 -> 383
    //   188: ldc 171
    //   190: astore 28
    //   192: aload 38
    //   194: ldc 173
    //   196: aload 28
    //   198: invokeinterface 163 3 0
    //   203: pop
    //   204: aload_0
    //   205: getfield 176	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   208: ifnull +15 -> 223
    //   211: aload_0
    //   212: getfield 176	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   215: invokeinterface 182 1 0
    //   220: ifgt +170 -> 390
    //   223: aload_0
    //   224: bipush 149
    //   226: putfield 127	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   229: aload 37
    //   231: ifnull +9 -> 240
    //   234: aload 37
    //   236: aload_0
    //   237: invokevirtual 131	com/tencent/mobileqq/vip/DownloadListener:onDone	(Lcom/tencent/mobileqq/vip/DownloadTask;)V
    //   240: iload_2
    //   241: istore_3
    //   242: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   245: ifeq +4908 -> 5153
    //   248: getstatic 35	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   251: iconst_2
    //   252: new 133	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   259: ldc 184
    //   261: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: aload_0
    //   265: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   268: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   274: iconst_m1
    //   275: ireturn
    //   276: astore 28
    //   278: new 186	java/util/HashMap
    //   281: dup
    //   282: invokespecial 187	java/util/HashMap:<init>	()V
    //   285: astore_0
    //   286: bipush 141
    //   288: istore_2
    //   289: aload 28
    //   291: instanceof 74
    //   294: ifeq +4334 -> 4628
    //   297: bipush 145
    //   299: istore_2
    //   300: aload_0
    //   301: ldc 189
    //   303: iload_2
    //   304: invokestatic 194	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   307: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   310: pop
    //   311: aload_1
    //   312: ifnull +4753 -> 5065
    //   315: aload_1
    //   316: invokevirtual 112	com/tencent/common/app/AppInterface:a	()Ljava/lang/String;
    //   319: astore 28
    //   321: aload_1
    //   322: invokevirtual 201	com/tencent/common/app/AppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   325: invokevirtual 204	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   328: invokestatic 209	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   331: aload 28
    //   333: ldc 211
    //   335: iconst_0
    //   336: lconst_0
    //   337: lconst_0
    //   338: aload_0
    //   339: ldc 213
    //   341: iconst_0
    //   342: invokevirtual 216	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   345: iconst_m1
    //   346: istore_2
    //   347: iload_2
    //   348: istore_3
    //   349: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   352: ifeq +4801 -> 5153
    //   355: getstatic 35	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   358: iconst_2
    //   359: new 133	java/lang/StringBuilder
    //   362: dup
    //   363: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   366: ldc 218
    //   368: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: iload_2
    //   372: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   375: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   378: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   381: iload_2
    //   382: ireturn
    //   383: ldc 223
    //   385: astore 28
    //   387: goto -195 -> 192
    //   390: aload_0
    //   391: getfield 176	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   394: invokeinterface 182 1 0
    //   399: istore 6
    //   401: iconst_0
    //   402: istore 8
    //   404: aconst_null
    //   405: astore 28
    //   407: aconst_null
    //   408: astore 29
    //   410: aconst_null
    //   411: astore 30
    //   413: sipush 2048
    //   416: istore_3
    //   417: iload 8
    //   419: aload_0
    //   420: getfield 176	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   423: invokeinterface 182 1 0
    //   428: if_icmpge +4032 -> 4460
    //   431: invokestatic 229	java/lang/System:currentTimeMillis	()J
    //   434: lstore 24
    //   436: new 4	java/lang/Object
    //   439: dup
    //   440: invokespecial 46	java/lang/Object:<init>	()V
    //   443: astore 39
    //   445: lconst_0
    //   446: lstore 14
    //   448: aload_0
    //   449: getfield 176	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   452: iload 8
    //   454: invokeinterface 233 2 0
    //   459: checkcast 191	java/lang/String
    //   462: astore 31
    //   464: aload_0
    //   465: aload 31
    //   467: putfield 235	com/tencent/mobileqq/vip/DownloadTask:b	Ljava/lang/String;
    //   470: aload_0
    //   471: getfield 238	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   474: aload 31
    //   476: invokeinterface 243 2 0
    //   481: checkcast 245	java/io/File
    //   484: astore 35
    //   486: aload 35
    //   488: ifnull +3939 -> 4427
    //   491: aload 35
    //   493: invokevirtual 249	java/io/File:getParentFile	()Ljava/io/File;
    //   496: astore 40
    //   498: new 245	java/io/File
    //   501: dup
    //   502: aload 40
    //   504: new 133	java/lang/StringBuilder
    //   507: dup
    //   508: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   511: aload 35
    //   513: invokevirtual 252	java/io/File:getName	()Ljava/lang/String;
    //   516: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: ldc 254
    //   521: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   527: invokespecial 257	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   530: astore 41
    //   532: aload_0
    //   533: getfield 259	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   536: invokestatic 265	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   539: ifne +4531 -> 5070
    //   542: aload_0
    //   543: getfield 259	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   546: aload 31
    //   548: invokestatic 271	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   551: astore 33
    //   553: new 273	com/tencent/mobileqq/emoticon/DownloadInfo
    //   556: dup
    //   557: aload 33
    //   559: aconst_null
    //   560: iconst_0
    //   561: invokespecial 276	com/tencent/mobileqq/emoticon/DownloadInfo:<init>	(Ljava/lang/String;Ljava/io/File;I)V
    //   564: astore 36
    //   566: iconst_m1
    //   567: istore 9
    //   569: aload 30
    //   571: astore 31
    //   573: iconst_m1
    //   574: istore 4
    //   576: iconst_0
    //   577: istore 26
    //   579: iload_3
    //   580: istore_2
    //   581: lconst_0
    //   582: lstore 14
    //   584: lconst_0
    //   585: lstore 12
    //   587: iload 4
    //   589: istore_3
    //   590: aload 28
    //   592: astore 30
    //   594: aload 29
    //   596: astore 28
    //   598: aload 31
    //   600: astore 29
    //   602: aload 30
    //   604: astore 34
    //   606: aload 36
    //   608: invokevirtual 278	com/tencent/mobileqq/emoticon/DownloadInfo:a	()V
    //   611: aload 40
    //   613: ifnull +628 -> 1241
    //   616: aload 30
    //   618: astore 34
    //   620: aload 40
    //   622: invokevirtual 281	java/io/File:exists	()Z
    //   625: ifne +616 -> 1241
    //   628: aload 30
    //   630: astore 34
    //   632: aload 40
    //   634: invokevirtual 284	java/io/File:mkdirs	()Z
    //   637: istore 27
    //   639: iload 27
    //   641: ifne +600 -> 1241
    //   644: aload 30
    //   646: astore 34
    //   648: aload_0
    //   649: bipush 153
    //   651: putfield 127	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   654: new 76	java/lang/Exception
    //   657: dup
    //   658: new 133	java/lang/StringBuilder
    //   661: dup
    //   662: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   665: ldc_w 286
    //   668: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: aload 40
    //   673: invokevirtual 289	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   676: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   682: invokespecial 292	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   685: athrow
    //   686: astore 32
    //   688: aload 30
    //   690: astore 31
    //   692: bipush 153
    //   694: istore 7
    //   696: aload 29
    //   698: astore 30
    //   700: aload 28
    //   702: astore 29
    //   704: iload_2
    //   705: istore 4
    //   707: iconst_1
    //   708: istore_3
    //   709: iconst_0
    //   710: istore 5
    //   712: iload 7
    //   714: istore_2
    //   715: aload 31
    //   717: astore 28
    //   719: aload 32
    //   721: astore 31
    //   723: iconst_0
    //   724: istore 7
    //   726: aload 31
    //   728: instanceof 294
    //   731: ifne +4424 -> 5155
    //   734: aload 31
    //   736: instanceof 296
    //   739: ifne +4416 -> 5155
    //   742: aload 31
    //   744: instanceof 298
    //   747: ifeq +6 -> 753
    //   750: goto +4405 -> 5155
    //   753: aload_0
    //   754: bipush 141
    //   756: putfield 127	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   759: aload 31
    //   761: instanceof 74
    //   764: ifeq +3492 -> 4256
    //   767: aload_0
    //   768: bipush 145
    //   770: putfield 127	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   773: iload 5
    //   775: ifne +18 -> 793
    //   778: iload 7
    //   780: ifeq +13 -> 793
    //   783: iload 26
    //   785: ifeq +3530 -> 4315
    //   788: aload_0
    //   789: iconst_1
    //   790: putfield 300	com/tencent/mobileqq/vip/DownloadTask:jdField_f_of_type_Boolean	Z
    //   793: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   796: ifeq +58 -> 854
    //   799: getstatic 35	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   802: iconst_2
    //   803: new 133	java/lang/StringBuilder
    //   806: dup
    //   807: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   810: ldc_w 302
    //   813: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: aload 33
    //   818: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   821: ldc_w 304
    //   824: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   827: aload 31
    //   829: invokevirtual 307	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   832: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   835: ldc_w 309
    //   838: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   841: aload_0
    //   842: getfield 127	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   845: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   848: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   851: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   854: iload_2
    //   855: ifeq +84 -> 939
    //   858: aload_0
    //   859: invokevirtual 311	com/tencent/mobileqq/vip/DownloadTask:b	()Z
    //   862: ifne +77 -> 939
    //   865: aload_0
    //   866: getfield 313	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Boolean	Z
    //   869: ifeq +70 -> 939
    //   872: aload 36
    //   874: getfield 314	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Boolean	Z
    //   877: ifeq +3452 -> 4329
    //   880: invokestatic 319	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	()Lcom/tencent/mobileqq/transfile/FMTSrvAddrProvider;
    //   883: astore 31
    //   885: aload 31
    //   887: ifnull +18 -> 905
    //   890: aload 31
    //   892: aload 36
    //   894: getfield 321	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_d_of_type_Int	I
    //   897: aload 36
    //   899: getfield 322	com/tencent/mobileqq/emoticon/DownloadInfo:b	Ljava/lang/String;
    //   902: invokevirtual 325	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	(ILjava/lang/String;)V
    //   905: aload_1
    //   906: ifnull +3417 -> 4323
    //   909: aload_1
    //   910: invokevirtual 201	com/tencent/common/app/AppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   913: invokevirtual 204	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   916: astore 31
    //   918: aload 36
    //   920: getfield 322	com/tencent/mobileqq/emoticon/DownloadInfo:b	Ljava/lang/String;
    //   923: aload 35
    //   925: invokevirtual 252	java/io/File:getName	()Ljava/lang/String;
    //   928: iconst_m1
    //   929: aload 31
    //   931: invokestatic 328	com/tencent/mobileqq/vip/DownloaderFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/content/Context;)V
    //   934: aload_0
    //   935: iconst_0
    //   936: putfield 330	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_Boolean	Z
    //   939: iload 9
    //   941: iconst_1
    //   942: iadd
    //   943: istore 9
    //   945: aload 28
    //   947: ifnull +10 -> 957
    //   950: aload 28
    //   952: invokeinterface 335 1 0
    //   957: aload 29
    //   959: ifnull +8 -> 967
    //   962: aload 29
    //   964: invokevirtual 340	java/io/InputStream:close	()V
    //   967: aload 30
    //   969: ifnull +8 -> 977
    //   972: aload 30
    //   974: invokevirtual 343	java/io/FileOutputStream:close	()V
    //   977: aload 28
    //   979: astore 31
    //   981: iload 4
    //   983: istore 7
    //   985: aload 30
    //   987: astore 28
    //   989: iload_3
    //   990: istore 5
    //   992: iload 9
    //   994: istore_3
    //   995: lload 14
    //   997: lstore 16
    //   999: aload 31
    //   1001: astore 30
    //   1003: lload 12
    //   1005: lstore 14
    //   1007: iload_2
    //   1008: istore 4
    //   1010: iload 7
    //   1012: istore_2
    //   1013: lload 16
    //   1015: lstore 12
    //   1017: iload 4
    //   1019: ifeq +4142 -> 5161
    //   1022: iload 5
    //   1024: ifne +4137 -> 5161
    //   1027: iload_3
    //   1028: aload_0
    //   1029: getfield 346	com/tencent/mobileqq/vip/DownloadTask:A	I
    //   1032: if_icmpge +4129 -> 5161
    //   1035: aload_0
    //   1036: invokevirtual 311	com/tencent/mobileqq/vip/DownloadTask:b	()Z
    //   1039: ifeq +4081 -> 5120
    //   1042: goto +4119 -> 5161
    //   1045: aload 37
    //   1047: ifnull +9 -> 1056
    //   1050: aload 37
    //   1052: aload_0
    //   1053: invokevirtual 349	com/tencent/mobileqq/vip/DownloadListener:onDoneFile	(Lcom/tencent/mobileqq/vip/DownloadTask;)V
    //   1056: new 186	java/util/HashMap
    //   1059: dup
    //   1060: invokespecial 187	java/util/HashMap:<init>	()V
    //   1063: astore 32
    //   1065: aload 32
    //   1067: ldc_w 351
    //   1070: aload 31
    //   1072: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1075: pop
    //   1076: aload 32
    //   1078: ldc 189
    //   1080: aload_0
    //   1081: getfield 127	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   1084: invokestatic 194	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1087: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1090: pop
    //   1091: aload 32
    //   1093: ldc_w 353
    //   1096: iload_3
    //   1097: invokestatic 194	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1100: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1103: pop
    //   1104: aload 32
    //   1106: ldc_w 355
    //   1109: lload 12
    //   1111: invokestatic 358	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1114: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1117: pop
    //   1118: aload 32
    //   1120: ldc_w 360
    //   1123: aload_0
    //   1124: getfield 176	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1127: invokeinterface 182 1 0
    //   1132: invokestatic 194	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1135: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1138: pop
    //   1139: aload 32
    //   1141: ldc_w 362
    //   1144: aload_0
    //   1145: getfield 364	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1148: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1151: pop
    //   1152: iload_2
    //   1153: ifne +4255 -> 5408
    //   1156: iconst_1
    //   1157: istore 26
    //   1159: invokestatic 229	java/lang/System:currentTimeMillis	()J
    //   1162: lstore 12
    //   1164: aload_1
    //   1165: ifnull +40 -> 1205
    //   1168: aload_1
    //   1169: invokevirtual 112	com/tencent/common/app/AppInterface:a	()Ljava/lang/String;
    //   1172: astore 31
    //   1174: aload_1
    //   1175: invokevirtual 201	com/tencent/common/app/AppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1178: invokevirtual 204	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   1181: invokestatic 209	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1184: aload 31
    //   1186: ldc 211
    //   1188: iload 26
    //   1190: lload 12
    //   1192: lload 24
    //   1194: lsub
    //   1195: lload 14
    //   1197: aload 32
    //   1199: ldc 213
    //   1201: iconst_0
    //   1202: invokevirtual 216	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1205: iload_2
    //   1206: ifne +3246 -> 4452
    //   1209: iload 6
    //   1211: iconst_1
    //   1212: isub
    //   1213: istore_3
    //   1214: iload 8
    //   1216: iconst_1
    //   1217: iadd
    //   1218: istore 8
    //   1220: iload_3
    //   1221: istore 6
    //   1223: aload 30
    //   1225: astore 31
    //   1227: iload 4
    //   1229: istore_3
    //   1230: aload 28
    //   1232: astore 30
    //   1234: aload 31
    //   1236: astore 28
    //   1238: goto -821 -> 417
    //   1241: aload 30
    //   1243: astore 34
    //   1245: getstatic 37	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_AndroidNetConnectivityManager	Landroid/net/ConnectivityManager;
    //   1248: ifnonnull +21 -> 1269
    //   1251: aload 30
    //   1253: astore 34
    //   1255: invokestatic 59	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   1258: ldc 61
    //   1260: invokevirtual 67	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1263: checkcast 69	android/net/ConnectivityManager
    //   1266: putstatic 37	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_AndroidNetConnectivityManager	Landroid/net/ConnectivityManager;
    //   1269: aload 30
    //   1271: astore 34
    //   1273: getstatic 37	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_AndroidNetConnectivityManager	Landroid/net/ConnectivityManager;
    //   1276: invokevirtual 368	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   1279: astore 43
    //   1281: aload 43
    //   1283: ifnonnull +78 -> 1361
    //   1286: aload 30
    //   1288: astore 34
    //   1290: aload_0
    //   1291: bipush 152
    //   1293: putfield 127	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   1296: new 76	java/lang/Exception
    //   1299: dup
    //   1300: new 133	java/lang/StringBuilder
    //   1303: dup
    //   1304: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   1307: ldc_w 370
    //   1310: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1313: aload 33
    //   1315: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1318: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1321: invokespecial 292	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1324: athrow
    //   1325: astore 31
    //   1327: bipush 152
    //   1329: istore 7
    //   1331: iconst_0
    //   1332: istore 5
    //   1334: iconst_0
    //   1335: istore_3
    //   1336: aload 30
    //   1338: astore 32
    //   1340: iload_2
    //   1341: istore 4
    //   1343: aload 29
    //   1345: astore 30
    //   1347: aload 28
    //   1349: astore 29
    //   1351: aload 32
    //   1353: astore 28
    //   1355: iload 7
    //   1357: istore_2
    //   1358: goto -635 -> 723
    //   1361: aload 30
    //   1363: astore 34
    //   1365: new 372	org/apache/http/client/methods/HttpGet
    //   1368: dup
    //   1369: aload 33
    //   1371: invokespecial 373	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   1374: astore 32
    //   1376: aload 30
    //   1378: astore 34
    //   1380: aload_0
    //   1381: invokevirtual 376	com/tencent/mobileqq/vip/DownloadTask:a	()Ljava/util/Map;
    //   1384: astore 31
    //   1386: aload 31
    //   1388: ifnull +138 -> 1526
    //   1391: aload 30
    //   1393: astore 34
    //   1395: aload 31
    //   1397: invokeinterface 380 1 0
    //   1402: invokeinterface 386 1 0
    //   1407: astore 42
    //   1409: aload 30
    //   1411: astore 34
    //   1413: aload 42
    //   1415: invokeinterface 391 1 0
    //   1420: ifeq +106 -> 1526
    //   1423: aload 30
    //   1425: astore 34
    //   1427: aload 42
    //   1429: invokeinterface 395 1 0
    //   1434: checkcast 191	java/lang/String
    //   1437: astore 44
    //   1439: aload 30
    //   1441: astore 34
    //   1443: aload 31
    //   1445: aload 44
    //   1447: invokeinterface 243 2 0
    //   1452: checkcast 191	java/lang/String
    //   1455: astore 45
    //   1457: aload 30
    //   1459: astore 34
    //   1461: aload 32
    //   1463: aload 44
    //   1465: aload 45
    //   1467: invokevirtual 399	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   1470: aload 30
    //   1472: astore 34
    //   1474: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1477: ifeq -68 -> 1409
    //   1480: aload 30
    //   1482: astore 34
    //   1484: getstatic 35	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1487: iconst_2
    //   1488: new 133	java/lang/StringBuilder
    //   1491: dup
    //   1492: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   1495: ldc_w 401
    //   1498: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1501: aload 44
    //   1503: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1506: ldc_w 403
    //   1509: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1512: aload 45
    //   1514: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1517: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1520: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1523: goto -114 -> 1409
    //   1526: aload 41
    //   1528: ifnull +107 -> 1635
    //   1531: aload 30
    //   1533: astore 34
    //   1535: aload 41
    //   1537: invokevirtual 281	java/io/File:exists	()Z
    //   1540: ifeq +95 -> 1635
    //   1543: aload 30
    //   1545: astore 34
    //   1547: aload 41
    //   1549: invokevirtual 406	java/io/File:length	()J
    //   1552: lstore 16
    //   1554: aload 30
    //   1556: astore 34
    //   1558: aload 32
    //   1560: ldc_w 408
    //   1563: new 133	java/lang/StringBuilder
    //   1566: dup
    //   1567: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   1570: ldc_w 410
    //   1573: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1576: lload 16
    //   1578: invokevirtual 413	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1581: ldc_w 415
    //   1584: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1587: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1590: invokevirtual 399	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   1593: aload 30
    //   1595: astore 34
    //   1597: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1600: ifeq +35 -> 1635
    //   1603: aload 30
    //   1605: astore 34
    //   1607: getstatic 35	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1610: iconst_2
    //   1611: new 133	java/lang/StringBuilder
    //   1614: dup
    //   1615: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   1618: ldc_w 417
    //   1621: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1624: lload 16
    //   1626: invokevirtual 413	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1629: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1632: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1635: aload 30
    //   1637: astore 34
    //   1639: aload_0
    //   1640: getfield 420	com/tencent/mobileqq/vip/DownloadTask:h	Z
    //   1643: ifeq +160 -> 1803
    //   1646: aload 35
    //   1648: ifnull +155 -> 1803
    //   1651: aload 30
    //   1653: astore 34
    //   1655: aload 35
    //   1657: invokevirtual 281	java/io/File:exists	()Z
    //   1660: ifeq +143 -> 1803
    //   1663: aload 30
    //   1665: astore 34
    //   1667: aload 35
    //   1669: invokevirtual 423	java/io/File:lastModified	()J
    //   1672: lstore 16
    //   1674: lload 16
    //   1676: lconst_0
    //   1677: lcmp
    //   1678: ifle +125 -> 1803
    //   1681: aload 30
    //   1683: astore 34
    //   1685: new 425	java/text/SimpleDateFormat
    //   1688: dup
    //   1689: ldc_w 427
    //   1692: getstatic 433	java/util/Locale:US	Ljava/util/Locale;
    //   1695: invokespecial 436	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   1698: astore 31
    //   1700: aload 30
    //   1702: astore 34
    //   1704: aload 31
    //   1706: ldc_w 438
    //   1709: invokestatic 444	java/util/TimeZone:getTimeZone	(Ljava/lang/String;)Ljava/util/TimeZone;
    //   1712: invokevirtual 448	java/text/SimpleDateFormat:setTimeZone	(Ljava/util/TimeZone;)V
    //   1715: aload 30
    //   1717: astore 34
    //   1719: aload 31
    //   1721: new 450	java/util/Date
    //   1724: dup
    //   1725: lload 16
    //   1727: invokespecial 453	java/util/Date:<init>	(J)V
    //   1730: invokevirtual 457	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   1733: astore 31
    //   1735: aload 30
    //   1737: astore 34
    //   1739: aload 31
    //   1741: invokestatic 265	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1744: ifne +59 -> 1803
    //   1747: aload 30
    //   1749: astore 34
    //   1751: aload 32
    //   1753: ldc_w 459
    //   1756: aload 31
    //   1758: invokevirtual 399	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   1761: aload 30
    //   1763: astore 34
    //   1765: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1768: ifeq +35 -> 1803
    //   1771: aload 30
    //   1773: astore 34
    //   1775: getstatic 35	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1778: iconst_2
    //   1779: new 133	java/lang/StringBuilder
    //   1782: dup
    //   1783: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   1786: ldc_w 461
    //   1789: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1792: aload 31
    //   1794: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1797: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1800: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1803: aload 30
    //   1805: astore 34
    //   1807: getstatic 39	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_Boolean	Z
    //   1810: ifeq +84 -> 1894
    //   1813: aload 30
    //   1815: astore 34
    //   1817: aload_0
    //   1818: getfield 313	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Boolean	Z
    //   1821: ifeq +73 -> 1894
    //   1824: aload 30
    //   1826: astore 34
    //   1828: aload_0
    //   1829: getfield 330	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_Boolean	Z
    //   1832: ifeq +62 -> 1894
    //   1835: aload 30
    //   1837: astore 34
    //   1839: aload 36
    //   1841: invokestatic 466	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Lcom/tencent/mobileqq/emoticon/DownloadInfo;)V
    //   1844: aload 30
    //   1846: astore 34
    //   1848: aload 36
    //   1850: getfield 314	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Boolean	Z
    //   1853: ifeq +41 -> 1894
    //   1856: aload 30
    //   1858: astore 34
    //   1860: aload 32
    //   1862: new 468	java/net/URI
    //   1865: dup
    //   1866: aload 36
    //   1868: getfield 322	com/tencent/mobileqq/emoticon/DownloadInfo:b	Ljava/lang/String;
    //   1871: invokespecial 469	java/net/URI:<init>	(Ljava/lang/String;)V
    //   1874: invokevirtual 473	org/apache/http/client/methods/HttpGet:setURI	(Ljava/net/URI;)V
    //   1877: aload 30
    //   1879: astore 34
    //   1881: aload 32
    //   1883: ldc_w 475
    //   1886: aload 36
    //   1888: getfield 476	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1891: invokevirtual 399	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   1894: aload 30
    //   1896: astore 34
    //   1898: aload 43
    //   1900: invokevirtual 481	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   1903: invokestatic 486	com/tencent/mobileqq/utils/httputils/PkgTools:f	(Ljava/lang/String;)Ljava/lang/String;
    //   1906: astore 42
    //   1908: aload 30
    //   1910: astore 34
    //   1912: aload 42
    //   1914: aload_0
    //   1915: getfield 488	com/tencent/mobileqq/vip/DownloadTask:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1918: invokevirtual 492	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1921: ifne +22 -> 1943
    //   1924: aload 30
    //   1926: astore 34
    //   1928: aload_0
    //   1929: iconst_0
    //   1930: putfield 300	com/tencent/mobileqq/vip/DownloadTask:jdField_f_of_type_Boolean	Z
    //   1933: aload 30
    //   1935: astore 34
    //   1937: aload_0
    //   1938: aload 42
    //   1940: putfield 488	com/tencent/mobileqq/vip/DownloadTask:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1943: aconst_null
    //   1944: astore 31
    //   1946: iconst_0
    //   1947: istore 4
    //   1949: iconst_0
    //   1950: istore 5
    //   1952: aload 30
    //   1954: astore 34
    //   1956: aload 43
    //   1958: invokestatic 497	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   1961: ifeq +719 -> 2680
    //   1964: aload 30
    //   1966: astore 34
    //   1968: aload_0
    //   1969: getfield 300	com/tencent/mobileqq/vip/DownloadTask:jdField_f_of_type_Boolean	Z
    //   1972: ifne +3138 -> 5110
    //   1975: aload 30
    //   1977: astore 34
    //   1979: invokestatic 502	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   1982: astore 31
    //   1984: aload 30
    //   1986: astore 34
    //   1988: invokestatic 505	android/net/Proxy:getDefaultPort	()I
    //   1991: istore 4
    //   1993: aload 31
    //   1995: ifnull +3112 -> 5107
    //   1998: iload 4
    //   2000: ifle +3107 -> 5107
    //   2003: aload 30
    //   2005: astore 34
    //   2007: aload 38
    //   2009: ldc_w 507
    //   2012: new 509	org/apache/http/HttpHost
    //   2015: dup
    //   2016: aload 31
    //   2018: iload 4
    //   2020: invokespecial 512	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   2023: invokeinterface 163 3 0
    //   2028: pop
    //   2029: iconst_1
    //   2030: istore 26
    //   2032: aload 30
    //   2034: astore 34
    //   2036: aload 42
    //   2038: getstatic 513	com/tencent/mobileqq/utils/httputils/PkgTools:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   2041: invokevirtual 492	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2044: ifne +33 -> 2077
    //   2047: aload 30
    //   2049: astore 34
    //   2051: aload 42
    //   2053: getstatic 515	com/tencent/mobileqq/utils/httputils/PkgTools:f	Ljava/lang/String;
    //   2056: invokevirtual 492	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2059: ifne +18 -> 2077
    //   2062: aload 30
    //   2064: astore 34
    //   2066: aload 42
    //   2068: getstatic 517	com/tencent/mobileqq/utils/httputils/PkgTools:h	Ljava/lang/String;
    //   2071: invokevirtual 492	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2074: ifeq +3030 -> 5104
    //   2077: aload 30
    //   2079: astore 34
    //   2081: aload 32
    //   2083: ldc_w 519
    //   2086: aload 36
    //   2088: getfield 476	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   2091: invokevirtual 399	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   2094: aload 30
    //   2096: astore 34
    //   2098: aload_0
    //   2099: getfield 522	com/tencent/mobileqq/vip/DownloadTask:k	Z
    //   2102: ifne +26 -> 2128
    //   2105: aload 30
    //   2107: astore 34
    //   2109: invokestatic 59	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   2112: invokestatic 526	com/tencent/mobileqq/utils/NetworkUtil:g	(Landroid/content/Context;)Z
    //   2115: ifeq +13 -> 2128
    //   2118: aload 30
    //   2120: astore 34
    //   2122: aload 38
    //   2124: iconst_0
    //   2125: invokestatic 532	org/apache/http/client/params/HttpClientParams:setRedirecting	(Lorg/apache/http/params/HttpParams;Z)V
    //   2128: aload 30
    //   2130: astore 34
    //   2132: aload 38
    //   2134: ldc_w 534
    //   2137: iload_2
    //   2138: invokeinterface 538 3 0
    //   2143: pop
    //   2144: aload 30
    //   2146: astore 34
    //   2148: aload 32
    //   2150: aload 38
    //   2152: invokevirtual 542	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   2155: aload 30
    //   2157: astore 34
    //   2159: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2162: ifeq +148 -> 2310
    //   2165: aload 30
    //   2167: astore 34
    //   2169: new 544	java/lang/StringBuffer
    //   2172: dup
    //   2173: invokespecial 545	java/lang/StringBuffer:<init>	()V
    //   2176: astore 43
    //   2178: aload 30
    //   2180: astore 34
    //   2182: aload 43
    //   2184: ldc_w 547
    //   2187: invokevirtual 550	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2190: getstatic 39	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_Boolean	Z
    //   2193: invokevirtual 553	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   2196: ldc_w 555
    //   2199: invokevirtual 550	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2202: aload_0
    //   2203: getfield 313	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Boolean	Z
    //   2206: invokevirtual 553	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   2209: ldc_w 557
    //   2212: invokevirtual 550	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2215: aload_0
    //   2216: getfield 330	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_Boolean	Z
    //   2219: invokevirtual 553	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   2222: ldc_w 559
    //   2225: invokevirtual 550	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2228: aload_0
    //   2229: getfield 300	com/tencent/mobileqq/vip/DownloadTask:jdField_f_of_type_Boolean	Z
    //   2232: invokevirtual 553	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   2235: ldc_w 561
    //   2238: invokevirtual 550	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2241: iload 26
    //   2243: invokevirtual 553	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   2246: ldc_w 563
    //   2249: invokevirtual 550	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2252: aload 42
    //   2254: invokevirtual 550	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2257: ldc_w 565
    //   2260: invokevirtual 550	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2263: aload 31
    //   2265: invokevirtual 550	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2268: ldc_w 567
    //   2271: invokevirtual 550	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2274: iload 4
    //   2276: invokevirtual 570	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   2279: ldc_w 572
    //   2282: invokevirtual 550	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2285: aload 32
    //   2287: invokevirtual 576	org/apache/http/client/methods/HttpGet:getURI	()Ljava/net/URI;
    //   2290: invokevirtual 579	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   2293: pop
    //   2294: aload 30
    //   2296: astore 34
    //   2298: getstatic 35	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2301: iconst_2
    //   2302: aload 43
    //   2304: invokevirtual 580	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   2307: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2310: aload 30
    //   2312: astore 34
    //   2314: getstatic 583	com/tencent/mobileqq/utils/HttpDownloadUtil:a	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   2317: aload 32
    //   2319: invokevirtual 589	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   2322: astore 42
    //   2324: aload 30
    //   2326: astore 34
    //   2328: aload 30
    //   2330: astore 31
    //   2332: aload 42
    //   2334: invokeinterface 595 1 0
    //   2339: invokeinterface 600 1 0
    //   2344: istore 4
    //   2346: aload 30
    //   2348: astore 34
    //   2350: aload 30
    //   2352: astore 31
    //   2354: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2357: ifeq +39 -> 2396
    //   2360: aload 30
    //   2362: astore 34
    //   2364: aload 30
    //   2366: astore 31
    //   2368: getstatic 35	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2371: iconst_2
    //   2372: new 133	java/lang/StringBuilder
    //   2375: dup
    //   2376: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   2379: ldc_w 602
    //   2382: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2385: iload 4
    //   2387: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2390: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2393: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2396: aload 30
    //   2398: astore 34
    //   2400: aload 30
    //   2402: astore 31
    //   2404: aload 36
    //   2406: iload 4
    //   2408: putfield 604	com/tencent/mobileqq/emoticon/DownloadInfo:c	I
    //   2411: sipush 200
    //   2414: iload 4
    //   2416: if_icmpeq +11 -> 2427
    //   2419: sipush 206
    //   2422: iload 4
    //   2424: if_icmpne +1402 -> 3826
    //   2427: aload 30
    //   2429: astore 34
    //   2431: aload 30
    //   2433: astore 31
    //   2435: aload 42
    //   2437: invokeinterface 608 1 0
    //   2442: astore 30
    //   2444: aload 30
    //   2446: astore 34
    //   2448: aload 30
    //   2450: astore 31
    //   2452: aload 30
    //   2454: invokeinterface 611 1 0
    //   2459: lstore 18
    //   2461: aload 30
    //   2463: astore 34
    //   2465: lload 18
    //   2467: lstore 16
    //   2469: aload 42
    //   2471: ldc_w 613
    //   2474: invokeinterface 617 2 0
    //   2479: astore 31
    //   2481: aload 30
    //   2483: astore 34
    //   2485: lload 18
    //   2487: lstore 16
    //   2489: aload 42
    //   2491: ldc_w 619
    //   2494: invokeinterface 617 2 0
    //   2499: astore 32
    //   2501: aload 31
    //   2503: ifnull +187 -> 2690
    //   2506: aload 30
    //   2508: astore 34
    //   2510: lload 18
    //   2512: lstore 16
    //   2514: aload 31
    //   2516: invokeinterface 624 1 0
    //   2521: ldc_w 626
    //   2524: invokevirtual 630	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   2527: iconst_1
    //   2528: aaload
    //   2529: invokestatic 634	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2532: i2l
    //   2533: lstore 14
    //   2535: lload 14
    //   2537: lconst_1
    //   2538: lcmp
    //   2539: iflt +42 -> 2581
    //   2542: aload 30
    //   2544: astore 34
    //   2546: lload 14
    //   2548: lstore 16
    //   2550: aload_0
    //   2551: getfield 636	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Long	J
    //   2554: lconst_0
    //   2555: lcmp
    //   2556: ifle +167 -> 2723
    //   2559: aload 30
    //   2561: astore 34
    //   2563: lload 14
    //   2565: lstore 16
    //   2567: aload_0
    //   2568: getfield 636	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Long	J
    //   2571: lstore 18
    //   2573: lload 14
    //   2575: lload 18
    //   2577: lcmp
    //   2578: ifle +145 -> 2723
    //   2581: aload 30
    //   2583: astore 34
    //   2585: aload_0
    //   2586: bipush 151
    //   2588: putfield 127	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   2591: new 76	java/lang/Exception
    //   2594: dup
    //   2595: new 133	java/lang/StringBuilder
    //   2598: dup
    //   2599: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   2602: ldc_w 638
    //   2605: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2608: lload 14
    //   2610: invokevirtual 413	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2613: ldc_w 640
    //   2616: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2619: aload_0
    //   2620: getfield 636	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Long	J
    //   2623: invokevirtual 413	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2626: ldc_w 642
    //   2629: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2632: aload 33
    //   2634: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2637: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2640: invokespecial 292	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   2643: athrow
    //   2644: astore 31
    //   2646: aload 30
    //   2648: astore 32
    //   2650: iconst_1
    //   2651: istore 5
    //   2653: bipush 151
    //   2655: istore 7
    //   2657: iconst_1
    //   2658: istore_3
    //   2659: iload_2
    //   2660: istore 4
    //   2662: aload 29
    //   2664: astore 30
    //   2666: aload 28
    //   2668: astore 29
    //   2670: aload 32
    //   2672: astore 28
    //   2674: iload 7
    //   2676: istore_2
    //   2677: goto -1954 -> 723
    //   2680: iconst_0
    //   2681: istore 26
    //   2683: sipush 4096
    //   2686: istore_2
    //   2687: goto -593 -> 2094
    //   2690: lload 18
    //   2692: lstore 14
    //   2694: aload 32
    //   2696: ifnull -161 -> 2535
    //   2699: aload 30
    //   2701: astore 34
    //   2703: lload 18
    //   2705: lstore 16
    //   2707: aload 32
    //   2709: invokeinterface 624 1 0
    //   2714: invokestatic 634	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2717: i2l
    //   2718: lstore 14
    //   2720: goto -185 -> 2535
    //   2723: aload 30
    //   2725: astore 34
    //   2727: lload 14
    //   2729: lstore 16
    //   2731: aload 41
    //   2733: invokevirtual 406	java/io/File:length	()J
    //   2736: lstore 20
    //   2738: lload 20
    //   2740: lstore 18
    //   2742: lload 20
    //   2744: lload 14
    //   2746: lcmp
    //   2747: iflt +20 -> 2767
    //   2750: aload 30
    //   2752: astore 34
    //   2754: lload 14
    //   2756: lstore 16
    //   2758: aload 41
    //   2760: invokevirtual 645	java/io/File:delete	()Z
    //   2763: pop
    //   2764: lconst_0
    //   2765: lstore 18
    //   2767: lload 18
    //   2769: lconst_0
    //   2770: lcmp
    //   2771: ifeq +2442 -> 5213
    //   2774: iconst_1
    //   2775: istore 27
    //   2777: aload 30
    //   2779: astore 34
    //   2781: lload 14
    //   2783: lstore 16
    //   2785: new 342	java/io/FileOutputStream
    //   2788: dup
    //   2789: aload 41
    //   2791: iload 27
    //   2793: invokespecial 648	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   2796: astore 32
    //   2798: aload 30
    //   2800: invokeinterface 652 1 0
    //   2805: astore 29
    //   2807: lload 12
    //   2809: lstore 16
    //   2811: iload_2
    //   2812: newarray byte
    //   2814: astore 28
    //   2816: iconst_0
    //   2817: istore 4
    //   2819: lload 12
    //   2821: lstore 16
    //   2823: aload_0
    //   2824: invokevirtual 311	com/tencent/mobileqq/vip/DownloadTask:b	()Z
    //   2827: ifne +141 -> 2968
    //   2830: lload 12
    //   2832: lstore 16
    //   2834: aload 29
    //   2836: aload 28
    //   2838: invokevirtual 656	java/io/InputStream:read	([B)I
    //   2841: istore 5
    //   2843: iload 5
    //   2845: iconst_m1
    //   2846: if_icmpeq +122 -> 2968
    //   2849: lload 12
    //   2851: lstore 16
    //   2853: aload 32
    //   2855: aload 28
    //   2857: iconst_0
    //   2858: iload 5
    //   2860: invokevirtual 660	java/io/FileOutputStream:write	([BII)V
    //   2863: lload 18
    //   2865: iload 5
    //   2867: i2l
    //   2868: ladd
    //   2869: lstore 22
    //   2871: lload 12
    //   2873: iload 5
    //   2875: i2l
    //   2876: ladd
    //   2877: lstore 20
    //   2879: iload 4
    //   2881: iload 5
    //   2883: iadd
    //   2884: istore 5
    //   2886: iload 5
    //   2888: istore 4
    //   2890: lload 22
    //   2892: lstore 18
    //   2894: lload 20
    //   2896: lstore 12
    //   2898: aload 37
    //   2900: ifnull -81 -> 2819
    //   2903: iload 5
    //   2905: istore 4
    //   2907: lload 22
    //   2909: lstore 18
    //   2911: lload 20
    //   2913: lstore 12
    //   2915: lload 20
    //   2917: lstore 16
    //   2919: iload 5
    //   2921: i2l
    //   2922: aload_0
    //   2923: getfield 662	com/tencent/mobileqq/vip/DownloadTask:jdField_f_of_type_Long	J
    //   2926: lcmp
    //   2927: iflt -108 -> 2819
    //   2930: lload 20
    //   2932: lstore 16
    //   2934: aload_0
    //   2935: lload 14
    //   2937: lload 22
    //   2939: iload 8
    //   2941: invokevirtual 665	com/tencent/mobileqq/vip/DownloadTask:a	(JJI)V
    //   2944: lload 20
    //   2946: lstore 16
    //   2948: aload 37
    //   2950: aload_0
    //   2951: invokevirtual 668	com/tencent/mobileqq/vip/DownloadListener:onProgress	(Lcom/tencent/mobileqq/vip/DownloadTask;)V
    //   2954: iconst_0
    //   2955: istore 4
    //   2957: lload 22
    //   2959: lstore 18
    //   2961: lload 20
    //   2963: lstore 12
    //   2965: goto -146 -> 2819
    //   2968: lload 12
    //   2970: lstore 16
    //   2972: aload 41
    //   2974: invokevirtual 406	java/io/File:length	()J
    //   2977: lload 14
    //   2979: lcmp
    //   2980: ifne +648 -> 3628
    //   2983: iconst_0
    //   2984: istore 10
    //   2986: iconst_0
    //   2987: istore 11
    //   2989: iconst_0
    //   2990: istore 7
    //   2992: lload 12
    //   2994: lstore 16
    //   2996: aload_0
    //   2997: iconst_0
    //   2998: putfield 127	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   3001: iload 10
    //   3003: istore 4
    //   3005: iload 11
    //   3007: istore 5
    //   3009: aload 35
    //   3011: invokevirtual 281	java/io/File:exists	()Z
    //   3014: ifeq +17 -> 3031
    //   3017: iload 10
    //   3019: istore 4
    //   3021: iload 11
    //   3023: istore 5
    //   3025: aload 35
    //   3027: invokevirtual 645	java/io/File:delete	()Z
    //   3030: pop
    //   3031: iload 10
    //   3033: istore 4
    //   3035: iload 11
    //   3037: istore 5
    //   3039: aload 41
    //   3041: aload 35
    //   3043: invokevirtual 672	java/io/File:renameTo	(Ljava/io/File;)Z
    //   3046: pop
    //   3047: iload 7
    //   3049: istore_3
    //   3050: iload 10
    //   3052: istore 4
    //   3054: iload 11
    //   3056: istore 5
    //   3058: aload_0
    //   3059: getfield 420	com/tencent/mobileqq/vip/DownloadTask:h	Z
    //   3062: ifeq +220 -> 3282
    //   3065: iload 7
    //   3067: istore_3
    //   3068: iload 10
    //   3070: istore 4
    //   3072: iload 11
    //   3074: istore 5
    //   3076: aload 42
    //   3078: ldc_w 674
    //   3081: invokeinterface 678 2 0
    //   3086: ifeq +196 -> 3282
    //   3089: iload 10
    //   3091: istore 4
    //   3093: iload 11
    //   3095: istore 5
    //   3097: aload 42
    //   3099: ldc_w 674
    //   3102: invokeinterface 617 2 0
    //   3107: invokeinterface 624 1 0
    //   3112: astore 28
    //   3114: iload 10
    //   3116: istore 4
    //   3118: iload 11
    //   3120: istore 5
    //   3122: aload 28
    //   3124: invokestatic 265	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3127: istore 27
    //   3129: iload 7
    //   3131: istore_3
    //   3132: iload 27
    //   3134: ifne +148 -> 3282
    //   3137: iload 10
    //   3139: istore 4
    //   3141: iload 11
    //   3143: istore 5
    //   3145: new 425	java/text/SimpleDateFormat
    //   3148: dup
    //   3149: ldc_w 427
    //   3152: getstatic 433	java/util/Locale:US	Ljava/util/Locale;
    //   3155: invokespecial 436	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   3158: astore 31
    //   3160: iload 10
    //   3162: istore 4
    //   3164: iload 11
    //   3166: istore 5
    //   3168: aload 31
    //   3170: ldc_w 438
    //   3173: invokestatic 444	java/util/TimeZone:getTimeZone	(Ljava/lang/String;)Ljava/util/TimeZone;
    //   3176: invokevirtual 448	java/text/SimpleDateFormat:setTimeZone	(Ljava/util/TimeZone;)V
    //   3179: iload 10
    //   3181: istore 4
    //   3183: iload 11
    //   3185: istore 5
    //   3187: aload 31
    //   3189: aload 28
    //   3191: invokevirtual 682	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   3194: invokevirtual 685	java/util/Date:getTime	()J
    //   3197: lstore 16
    //   3199: iload 10
    //   3201: istore 4
    //   3203: iload 11
    //   3205: istore 5
    //   3207: aload 41
    //   3209: lload 16
    //   3211: invokevirtual 689	java/io/File:setLastModified	(J)Z
    //   3214: pop
    //   3215: iload 7
    //   3217: istore_3
    //   3218: iload 10
    //   3220: istore 4
    //   3222: iload 11
    //   3224: istore 5
    //   3226: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3229: ifeq +53 -> 3282
    //   3232: iload 10
    //   3234: istore 4
    //   3236: iload 11
    //   3238: istore 5
    //   3240: getstatic 35	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3243: iconst_2
    //   3244: new 133	java/lang/StringBuilder
    //   3247: dup
    //   3248: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   3251: ldc_w 691
    //   3254: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3257: aload 28
    //   3259: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3262: ldc_w 693
    //   3265: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3268: lload 16
    //   3270: invokevirtual 413	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3273: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3276: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3279: iload 7
    //   3281: istore_3
    //   3282: iconst_0
    //   3283: istore 4
    //   3285: aload 32
    //   3287: astore 28
    //   3289: iload 4
    //   3291: istore 7
    //   3293: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   3296: ifnonnull +17 -> 3313
    //   3299: iload 4
    //   3301: istore 7
    //   3303: new 50	java/util/concurrent/ConcurrentHashMap
    //   3306: dup
    //   3307: invokespecial 51	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   3310: putstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   3313: iload_3
    //   3314: ifeq +846 -> 4160
    //   3317: iload 4
    //   3319: istore 7
    //   3321: aload_0
    //   3322: invokevirtual 311	com/tencent/mobileqq/vip/DownloadTask:b	()Z
    //   3325: ifne +835 -> 4160
    //   3328: iload 4
    //   3330: istore 7
    //   3332: iload 9
    //   3334: aload_0
    //   3335: getfield 346	com/tencent/mobileqq/vip/DownloadTask:A	I
    //   3338: if_icmpge +719 -> 4057
    //   3341: iload 4
    //   3343: istore 7
    //   3345: aload 39
    //   3347: monitorenter
    //   3348: sipush 2000
    //   3351: i2l
    //   3352: lstore 16
    //   3354: aload 39
    //   3356: lload 16
    //   3358: invokevirtual 696	java/lang/Object:wait	(J)V
    //   3361: aload 39
    //   3363: monitorexit
    //   3364: iload_3
    //   3365: ifeq +84 -> 3449
    //   3368: aload_0
    //   3369: invokevirtual 311	com/tencent/mobileqq/vip/DownloadTask:b	()Z
    //   3372: ifne +77 -> 3449
    //   3375: aload_0
    //   3376: getfield 313	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Boolean	Z
    //   3379: ifeq +70 -> 3449
    //   3382: aload 36
    //   3384: getfield 314	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Boolean	Z
    //   3387: ifeq +797 -> 4184
    //   3390: invokestatic 319	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	()Lcom/tencent/mobileqq/transfile/FMTSrvAddrProvider;
    //   3393: astore 31
    //   3395: aload 31
    //   3397: ifnull +18 -> 3415
    //   3400: aload 31
    //   3402: aload 36
    //   3404: getfield 321	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_d_of_type_Int	I
    //   3407: aload 36
    //   3409: getfield 322	com/tencent/mobileqq/emoticon/DownloadInfo:b	Ljava/lang/String;
    //   3412: invokevirtual 325	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	(ILjava/lang/String;)V
    //   3415: aload_1
    //   3416: ifnull +762 -> 4178
    //   3419: aload_1
    //   3420: invokevirtual 201	com/tencent/common/app/AppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3423: invokevirtual 204	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   3426: astore 31
    //   3428: aload 36
    //   3430: getfield 322	com/tencent/mobileqq/emoticon/DownloadInfo:b	Ljava/lang/String;
    //   3433: aload 35
    //   3435: invokevirtual 252	java/io/File:getName	()Ljava/lang/String;
    //   3438: iconst_m1
    //   3439: aload 31
    //   3441: invokestatic 328	com/tencent/mobileqq/vip/DownloaderFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/content/Context;)V
    //   3444: aload_0
    //   3445: iconst_0
    //   3446: putfield 330	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_Boolean	Z
    //   3449: iload 9
    //   3451: iconst_1
    //   3452: iadd
    //   3453: istore 7
    //   3455: aload 30
    //   3457: ifnull +10 -> 3467
    //   3460: aload 30
    //   3462: invokeinterface 335 1 0
    //   3467: aload 29
    //   3469: ifnull +8 -> 3477
    //   3472: aload 29
    //   3474: invokevirtual 340	java/io/InputStream:close	()V
    //   3477: aload 28
    //   3479: ifnull +8 -> 3487
    //   3482: aload 28
    //   3484: invokevirtual 343	java/io/FileOutputStream:close	()V
    //   3487: iload 4
    //   3489: istore 5
    //   3491: iload_3
    //   3492: istore 4
    //   3494: lload 12
    //   3496: lstore 16
    //   3498: lload 14
    //   3500: lstore 12
    //   3502: iload 7
    //   3504: istore_3
    //   3505: lload 16
    //   3507: lstore 14
    //   3509: goto -2492 -> 1017
    //   3512: astore 31
    //   3514: iload 10
    //   3516: istore 4
    //   3518: iload 11
    //   3520: istore 5
    //   3522: aload 31
    //   3524: invokevirtual 699	java/lang/Exception:printStackTrace	()V
    //   3527: iload 7
    //   3529: istore_3
    //   3530: iload 10
    //   3532: istore 4
    //   3534: iload 11
    //   3536: istore 5
    //   3538: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3541: ifeq -259 -> 3282
    //   3544: iload 10
    //   3546: istore 4
    //   3548: iload 11
    //   3550: istore 5
    //   3552: getstatic 35	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3555: iconst_2
    //   3556: new 133	java/lang/StringBuilder
    //   3559: dup
    //   3560: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   3563: ldc_w 691
    //   3566: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3569: aload 28
    //   3571: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3574: ldc_w 701
    //   3577: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3580: aload 31
    //   3582: invokevirtual 702	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   3585: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3588: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3591: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3594: iload 7
    //   3596: istore_3
    //   3597: goto -315 -> 3282
    //   3600: astore 31
    //   3602: iconst_0
    //   3603: istore_3
    //   3604: aload 30
    //   3606: astore 28
    //   3608: iload 4
    //   3610: istore 7
    //   3612: iconst_1
    //   3613: istore 5
    //   3615: iload_2
    //   3616: istore 4
    //   3618: aload 32
    //   3620: astore 30
    //   3622: iload 7
    //   3624: istore_2
    //   3625: goto -2902 -> 723
    //   3628: lload 12
    //   3630: lstore 16
    //   3632: aload_0
    //   3633: invokevirtual 311	com/tencent/mobileqq/vip/DownloadTask:b	()Z
    //   3636: ifeq +23 -> 3659
    //   3639: bipush 150
    //   3641: istore 4
    //   3643: lload 12
    //   3645: lstore 16
    //   3647: aload_0
    //   3648: bipush 150
    //   3650: putfield 127	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   3653: iload 4
    //   3655: istore_3
    //   3656: goto -374 -> 3282
    //   3659: bipush 151
    //   3661: istore 7
    //   3663: lload 12
    //   3665: lstore 16
    //   3667: aload_0
    //   3668: bipush 151
    //   3670: putfield 127	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   3673: iload 7
    //   3675: istore 4
    //   3677: iload 7
    //   3679: istore 5
    //   3681: aload 41
    //   3683: invokevirtual 645	java/io/File:delete	()Z
    //   3686: pop
    //   3687: iload 7
    //   3689: istore_3
    //   3690: goto -408 -> 3282
    //   3693: astore 31
    //   3695: aload 29
    //   3697: astore 28
    //   3699: iload 5
    //   3701: istore_3
    //   3702: aload 32
    //   3704: astore 29
    //   3706: iload_3
    //   3707: ifeq +84 -> 3791
    //   3710: aload_0
    //   3711: invokevirtual 311	com/tencent/mobileqq/vip/DownloadTask:b	()Z
    //   3714: ifne +77 -> 3791
    //   3717: aload_0
    //   3718: getfield 313	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Boolean	Z
    //   3721: ifeq +70 -> 3791
    //   3724: aload 36
    //   3726: getfield 314	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Boolean	Z
    //   3729: ifeq +650 -> 4379
    //   3732: invokestatic 319	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	()Lcom/tencent/mobileqq/transfile/FMTSrvAddrProvider;
    //   3735: astore 32
    //   3737: aload 32
    //   3739: ifnull +18 -> 3757
    //   3742: aload 32
    //   3744: aload 36
    //   3746: getfield 321	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_d_of_type_Int	I
    //   3749: aload 36
    //   3751: getfield 322	com/tencent/mobileqq/emoticon/DownloadInfo:b	Ljava/lang/String;
    //   3754: invokevirtual 325	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	(ILjava/lang/String;)V
    //   3757: aload_1
    //   3758: ifnull +1615 -> 5373
    //   3761: aload_1
    //   3762: invokevirtual 201	com/tencent/common/app/AppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3765: invokevirtual 204	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   3768: astore 32
    //   3770: aload 36
    //   3772: getfield 322	com/tencent/mobileqq/emoticon/DownloadInfo:b	Ljava/lang/String;
    //   3775: aload 35
    //   3777: invokevirtual 252	java/io/File:getName	()Ljava/lang/String;
    //   3780: iconst_m1
    //   3781: aload 32
    //   3783: invokestatic 328	com/tencent/mobileqq/vip/DownloaderFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/content/Context;)V
    //   3786: aload_0
    //   3787: iconst_0
    //   3788: putfield 330	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_Boolean	Z
    //   3791: aload 30
    //   3793: ifnull +10 -> 3803
    //   3796: aload 30
    //   3798: invokeinterface 335 1 0
    //   3803: aload 28
    //   3805: ifnull +8 -> 3813
    //   3808: aload 28
    //   3810: invokevirtual 340	java/io/InputStream:close	()V
    //   3813: aload 29
    //   3815: ifnull +8 -> 3823
    //   3818: aload 29
    //   3820: invokevirtual 343	java/io/FileOutputStream:close	()V
    //   3823: aload 31
    //   3825: athrow
    //   3826: sipush 404
    //   3829: iload 4
    //   3831: if_icmpne +34 -> 3865
    //   3834: aload 30
    //   3836: astore 34
    //   3838: aload_0
    //   3839: iload 4
    //   3841: putfield 127	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   3844: iload 4
    //   3846: istore_3
    //   3847: aload 28
    //   3849: astore 31
    //   3851: aload 29
    //   3853: astore 28
    //   3855: iconst_1
    //   3856: istore 4
    //   3858: aload 31
    //   3860: astore 29
    //   3862: goto -573 -> 3289
    //   3865: sipush 302
    //   3868: iload 4
    //   3870: if_icmpeq +11 -> 3881
    //   3873: sipush 301
    //   3876: iload 4
    //   3878: if_icmpne +87 -> 3965
    //   3881: aload 30
    //   3883: astore 34
    //   3885: aload 30
    //   3887: astore 31
    //   3889: aload_0
    //   3890: getfield 522	com/tencent/mobileqq/vip/DownloadTask:k	Z
    //   3893: istore 27
    //   3895: iload 27
    //   3897: ifne +68 -> 3965
    //   3900: aload 30
    //   3902: astore 34
    //   3904: aload_0
    //   3905: iload 4
    //   3907: putfield 127	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   3910: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3913: ifeq +1170 -> 5083
    //   3916: getstatic 35	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3919: iconst_2
    //   3920: new 133	java/lang/StringBuilder
    //   3923: dup
    //   3924: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   3927: ldc_w 704
    //   3930: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3933: iload 4
    //   3935: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3938: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3941: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3944: iload 4
    //   3946: istore_3
    //   3947: aload 28
    //   3949: astore 31
    //   3951: aload 29
    //   3953: astore 28
    //   3955: iconst_1
    //   3956: istore 4
    //   3958: aload 31
    //   3960: astore 29
    //   3962: goto -673 -> 3289
    //   3965: sipush 304
    //   3968: iload 4
    //   3970: if_icmpne +36 -> 4006
    //   3973: aload 30
    //   3975: astore 34
    //   3977: aload 30
    //   3979: astore 31
    //   3981: aload_0
    //   3982: iconst_0
    //   3983: putfield 127	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   3986: aload 28
    //   3988: astore 31
    //   3990: aload 29
    //   3992: astore 28
    //   3994: iconst_0
    //   3995: istore 4
    //   3997: iconst_0
    //   3998: istore_3
    //   3999: aload 31
    //   4001: astore 29
    //   4003: goto -714 -> 3289
    //   4006: aload 30
    //   4008: astore 34
    //   4010: aload 30
    //   4012: astore 31
    //   4014: aload_0
    //   4015: iload 4
    //   4017: putfield 127	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   4020: aload 28
    //   4022: astore 31
    //   4024: aload 29
    //   4026: astore 28
    //   4028: iconst_0
    //   4029: istore 5
    //   4031: iload 4
    //   4033: istore_3
    //   4034: iload 5
    //   4036: istore 4
    //   4038: aload 31
    //   4040: astore 29
    //   4042: goto -753 -> 3289
    //   4045: astore 31
    //   4047: aload 39
    //   4049: monitorexit
    //   4050: iload 4
    //   4052: istore 7
    //   4054: aload 31
    //   4056: athrow
    //   4057: iload 4
    //   4059: istore 7
    //   4061: invokestatic 229	java/lang/System:currentTimeMillis	()J
    //   4064: ldc2_w 705
    //   4067: ldiv
    //   4068: l2i
    //   4069: istore 5
    //   4071: iload 4
    //   4073: istore 7
    //   4075: aload_0
    //   4076: getfield 708	com/tencent/mobileqq/vip/DownloadTask:jdField_c_of_type_Boolean	Z
    //   4079: ifeq +23 -> 4102
    //   4082: iload 4
    //   4084: istore 7
    //   4086: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   4089: aload_0
    //   4090: getfield 709	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4093: iload 5
    //   4095: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4098: invokevirtual 710	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4101: pop
    //   4102: iconst_1
    //   4103: istore 7
    //   4105: new 76	java/lang/Exception
    //   4108: dup
    //   4109: new 133	java/lang/StringBuilder
    //   4112: dup
    //   4113: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   4116: ldc_w 712
    //   4119: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4122: aload 33
    //   4124: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4127: ldc_w 714
    //   4130: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4133: aload_0
    //   4134: getfield 313	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Boolean	Z
    //   4137: invokevirtual 717	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4140: ldc_w 719
    //   4143: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4146: aload_0
    //   4147: getfield 330	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_Boolean	Z
    //   4150: invokevirtual 717	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4153: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4156: invokespecial 292	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   4159: athrow
    //   4160: iload 4
    //   4162: istore 7
    //   4164: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   4167: aload_0
    //   4168: getfield 709	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4171: invokevirtual 722	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4174: pop
    //   4175: goto -811 -> 3364
    //   4178: aconst_null
    //   4179: astore 31
    //   4181: goto -753 -> 3428
    //   4184: aload_0
    //   4185: iconst_1
    //   4186: putfield 330	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_Boolean	Z
    //   4189: goto -740 -> 3449
    //   4192: astore 31
    //   4194: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4197: ifeq +34 -> 4231
    //   4200: getstatic 35	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4203: iconst_2
    //   4204: new 133	java/lang/StringBuilder
    //   4207: dup
    //   4208: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   4211: ldc_w 724
    //   4214: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4217: aload 31
    //   4219: invokevirtual 725	java/io/IOException:getMessage	()Ljava/lang/String;
    //   4222: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4225: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4228: invokestatic 728	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4231: iload 4
    //   4233: istore 5
    //   4235: iload_3
    //   4236: istore 4
    //   4238: lload 12
    //   4240: lstore 16
    //   4242: lload 14
    //   4244: lstore 12
    //   4246: iload 7
    //   4248: istore_3
    //   4249: lload 16
    //   4251: lstore 14
    //   4253: goto -3236 -> 1017
    //   4256: aload 31
    //   4258: instanceof 730
    //   4261: ifeq +12 -> 4273
    //   4264: aload_0
    //   4265: bipush 144
    //   4267: putfield 127	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   4270: goto -3497 -> 773
    //   4273: aload 31
    //   4275: instanceof 294
    //   4278: ifne +11 -> 4289
    //   4281: aload 31
    //   4283: instanceof 296
    //   4286: ifeq +12 -> 4298
    //   4289: aload_0
    //   4290: bipush 143
    //   4292: putfield 127	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   4295: goto -3522 -> 773
    //   4298: aload 31
    //   4300: instanceof 298
    //   4303: ifeq -3530 -> 773
    //   4306: aload_0
    //   4307: bipush 142
    //   4309: putfield 127	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   4312: goto -3539 -> 773
    //   4315: aload_0
    //   4316: iconst_0
    //   4317: putfield 300	com/tencent/mobileqq/vip/DownloadTask:jdField_f_of_type_Boolean	Z
    //   4320: goto -3527 -> 793
    //   4323: aconst_null
    //   4324: astore 31
    //   4326: goto -3408 -> 918
    //   4329: aload_0
    //   4330: iconst_1
    //   4331: putfield 330	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_Boolean	Z
    //   4334: goto -3395 -> 939
    //   4337: astore 31
    //   4339: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4342: ifeq +988 -> 5330
    //   4345: getstatic 35	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4348: iconst_2
    //   4349: new 133	java/lang/StringBuilder
    //   4352: dup
    //   4353: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   4356: ldc_w 724
    //   4359: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4362: aload 31
    //   4364: invokevirtual 725	java/io/IOException:getMessage	()Ljava/lang/String;
    //   4367: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4370: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4373: invokestatic 728	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4376: goto +954 -> 5330
    //   4379: aload_0
    //   4380: iconst_1
    //   4381: putfield 330	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_Boolean	Z
    //   4384: goto -593 -> 3791
    //   4387: astore_0
    //   4388: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4391: ifeq -568 -> 3823
    //   4394: getstatic 35	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4397: iconst_2
    //   4398: new 133	java/lang/StringBuilder
    //   4401: dup
    //   4402: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   4405: ldc_w 724
    //   4408: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4411: aload_0
    //   4412: invokevirtual 725	java/io/IOException:getMessage	()Ljava/lang/String;
    //   4415: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4418: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4421: invokestatic 728	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4424: goto -601 -> 3823
    //   4427: aload_0
    //   4428: bipush 146
    //   4430: putfield 127	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   4433: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4436: ifeq +943 -> 5379
    //   4439: getstatic 35	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4442: iconst_2
    //   4443: ldc_w 732
    //   4446: invokestatic 728	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4449: goto +930 -> 5379
    //   4452: aload_0
    //   4453: getfield 735	com/tencent/mobileqq/vip/DownloadTask:j	Z
    //   4456: iconst_1
    //   4457: if_icmpne +620 -> 5077
    //   4460: iload_2
    //   4461: istore_3
    //   4462: iload 6
    //   4464: ifle +78 -> 4542
    //   4467: iload_2
    //   4468: istore_3
    //   4469: aload_0
    //   4470: getfield 176	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   4473: invokeinterface 182 1 0
    //   4478: iconst_1
    //   4479: if_icmple +63 -> 4542
    //   4482: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4485: ifeq +49 -> 4534
    //   4488: getstatic 35	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4491: iconst_2
    //   4492: new 133	java/lang/StringBuilder
    //   4495: dup
    //   4496: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   4499: ldc_w 737
    //   4502: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4505: iload 6
    //   4507: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4510: ldc_w 739
    //   4513: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4516: aload_0
    //   4517: getfield 176	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   4520: invokeinterface 182 1 0
    //   4525: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4528: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4531: invokestatic 728	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4534: aload_0
    //   4535: bipush 148
    //   4537: putfield 127	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   4540: iconst_m1
    //   4541: istore_3
    //   4542: iload_3
    //   4543: istore_2
    //   4544: aload 37
    //   4546: ifnull -4199 -> 347
    //   4549: aload_0
    //   4550: invokevirtual 311	com/tencent/mobileqq/vip/DownloadTask:b	()Z
    //   4553: ifeq +33 -> 4586
    //   4556: aload_0
    //   4557: getfield 741	com/tencent/mobileqq/vip/DownloadTask:g	Z
    //   4560: ifne +26 -> 4586
    //   4563: iload_3
    //   4564: istore_2
    //   4565: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4568: ifeq -4221 -> 347
    //   4571: getstatic 35	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4574: iconst_2
    //   4575: ldc_w 743
    //   4578: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4581: iload_3
    //   4582: istore_2
    //   4583: goto -4236 -> 347
    //   4586: aload_0
    //   4587: invokevirtual 311	com/tencent/mobileqq/vip/DownloadTask:b	()Z
    //   4590: ifeq +824 -> 5414
    //   4593: aload_0
    //   4594: iconst_2
    //   4595: invokevirtual 746	com/tencent/mobileqq/vip/DownloadTask:a	(I)V
    //   4598: aload 37
    //   4600: aload_0
    //   4601: invokevirtual 749	com/tencent/mobileqq/vip/DownloadListener:onCancel	(Lcom/tencent/mobileqq/vip/DownloadTask;)V
    //   4604: aload 37
    //   4606: aload_0
    //   4607: invokevirtual 131	com/tencent/mobileqq/vip/DownloadListener:onDone	(Lcom/tencent/mobileqq/vip/DownloadTask;)V
    //   4610: iload_3
    //   4611: istore_2
    //   4612: goto -4265 -> 347
    //   4615: aload_0
    //   4616: iload_2
    //   4617: invokevirtual 746	com/tencent/mobileqq/vip/DownloadTask:a	(I)V
    //   4620: goto -16 -> 4604
    //   4623: iconst_m1
    //   4624: istore_2
    //   4625: goto -10 -> 4615
    //   4628: aload 28
    //   4630: instanceof 730
    //   4633: ifeq -4333 -> 300
    //   4636: bipush 144
    //   4638: istore_2
    //   4639: goto -4339 -> 300
    //   4642: astore_0
    //   4643: iconst_m1
    //   4644: istore_2
    //   4645: goto -4298 -> 347
    //   4648: astore 31
    //   4650: goto -1289 -> 3361
    //   4653: astore 31
    //   4655: goto -3450 -> 1205
    //   4658: astore 31
    //   4660: aload 29
    //   4662: astore 28
    //   4664: aload 32
    //   4666: astore 29
    //   4668: goto -962 -> 3706
    //   4671: astore 31
    //   4673: aload 34
    //   4675: astore 30
    //   4677: goto -971 -> 3706
    //   4680: astore 31
    //   4682: bipush 153
    //   4684: istore_3
    //   4685: goto -979 -> 3706
    //   4688: astore 31
    //   4690: bipush 152
    //   4692: istore_3
    //   4693: goto -987 -> 3706
    //   4696: astore 31
    //   4698: bipush 151
    //   4700: istore_3
    //   4701: goto -995 -> 3706
    //   4704: astore 31
    //   4706: aload 32
    //   4708: astore 29
    //   4710: goto -1004 -> 3706
    //   4713: astore 31
    //   4715: iload 4
    //   4717: istore_3
    //   4718: goto -1012 -> 3706
    //   4721: astore 31
    //   4723: aload 30
    //   4725: astore 32
    //   4727: iload_3
    //   4728: istore 7
    //   4730: iconst_1
    //   4731: istore_3
    //   4732: iconst_0
    //   4733: istore 5
    //   4735: iload_2
    //   4736: istore 4
    //   4738: aload 29
    //   4740: astore 30
    //   4742: aload 28
    //   4744: astore 29
    //   4746: aload 32
    //   4748: astore 28
    //   4750: iload 7
    //   4752: istore_2
    //   4753: goto -4030 -> 723
    //   4756: astore 31
    //   4758: iload_3
    //   4759: istore 7
    //   4761: aload 30
    //   4763: astore 32
    //   4765: iconst_0
    //   4766: istore_3
    //   4767: iconst_0
    //   4768: istore 5
    //   4770: iload_2
    //   4771: istore 4
    //   4773: aload 29
    //   4775: astore 30
    //   4777: aload 28
    //   4779: astore 29
    //   4781: aload 32
    //   4783: astore 28
    //   4785: iload 7
    //   4787: istore_2
    //   4788: goto -4065 -> 723
    //   4791: astore 31
    //   4793: iconst_0
    //   4794: istore 5
    //   4796: iconst_0
    //   4797: istore 4
    //   4799: aload 30
    //   4801: astore 32
    //   4803: iload_3
    //   4804: istore 7
    //   4806: iload 4
    //   4808: istore_3
    //   4809: iload_2
    //   4810: istore 4
    //   4812: aload 29
    //   4814: astore 30
    //   4816: aload 28
    //   4818: astore 29
    //   4820: aload 32
    //   4822: astore 28
    //   4824: iload 7
    //   4826: istore_2
    //   4827: goto -4104 -> 723
    //   4830: astore 30
    //   4832: iconst_1
    //   4833: istore 5
    //   4835: iconst_0
    //   4836: istore 4
    //   4838: aload 31
    //   4840: astore 32
    //   4842: iload_3
    //   4843: istore 7
    //   4845: aload 30
    //   4847: astore 31
    //   4849: iload 4
    //   4851: istore_3
    //   4852: iload_2
    //   4853: istore 4
    //   4855: aload 29
    //   4857: astore 30
    //   4859: aload 28
    //   4861: astore 29
    //   4863: aload 32
    //   4865: astore 28
    //   4867: iload 7
    //   4869: istore_2
    //   4870: goto -4147 -> 723
    //   4873: astore 31
    //   4875: iconst_0
    //   4876: istore 4
    //   4878: aload 30
    //   4880: astore 32
    //   4882: iload_3
    //   4883: istore 7
    //   4885: iconst_1
    //   4886: istore 5
    //   4888: lload 16
    //   4890: lstore 14
    //   4892: iload 4
    //   4894: istore_3
    //   4895: iload_2
    //   4896: istore 4
    //   4898: aload 29
    //   4900: astore 30
    //   4902: aload 28
    //   4904: astore 29
    //   4906: aload 32
    //   4908: astore 28
    //   4910: iload 7
    //   4912: istore_2
    //   4913: goto -4190 -> 723
    //   4916: astore 31
    //   4918: aload 30
    //   4920: astore 32
    //   4922: iconst_1
    //   4923: istore 5
    //   4925: iload_3
    //   4926: istore 7
    //   4928: iconst_1
    //   4929: istore_3
    //   4930: iload_2
    //   4931: istore 4
    //   4933: aload 29
    //   4935: astore 30
    //   4937: aload 28
    //   4939: astore 29
    //   4941: aload 32
    //   4943: astore 28
    //   4945: iload 7
    //   4947: istore_2
    //   4948: goto -4225 -> 723
    //   4951: astore 31
    //   4953: iconst_0
    //   4954: istore 4
    //   4956: aload 30
    //   4958: astore 34
    //   4960: iload_3
    //   4961: istore 7
    //   4963: iconst_1
    //   4964: istore 5
    //   4966: iload 4
    //   4968: istore_3
    //   4969: iload_2
    //   4970: istore 4
    //   4972: aload 32
    //   4974: astore 30
    //   4976: aload 28
    //   4978: astore 29
    //   4980: aload 34
    //   4982: astore 28
    //   4984: iload 7
    //   4986: istore_2
    //   4987: goto -4264 -> 723
    //   4990: astore 31
    //   4992: aload 30
    //   4994: astore 32
    //   4996: iconst_1
    //   4997: istore 4
    //   4999: iconst_1
    //   5000: istore 5
    //   5002: iload_3
    //   5003: istore 7
    //   5005: iload 4
    //   5007: istore_3
    //   5008: iload_2
    //   5009: istore 4
    //   5011: aload 29
    //   5013: astore 30
    //   5015: aload 28
    //   5017: astore 29
    //   5019: aload 32
    //   5021: astore 28
    //   5023: iload 7
    //   5025: istore_2
    //   5026: goto -4303 -> 723
    //   5029: astore 31
    //   5031: aload 30
    //   5033: astore 32
    //   5035: iconst_1
    //   5036: istore_3
    //   5037: iconst_1
    //   5038: istore 5
    //   5040: iload 4
    //   5042: istore 7
    //   5044: iload_2
    //   5045: istore 4
    //   5047: aload 29
    //   5049: astore 30
    //   5051: aload 28
    //   5053: astore 29
    //   5055: aload 32
    //   5057: astore 28
    //   5059: iload 7
    //   5061: istore_2
    //   5062: goto -4339 -> 723
    //   5065: iconst_m1
    //   5066: istore_2
    //   5067: goto -4720 -> 347
    //   5070: aload 31
    //   5072: astore 33
    //   5074: goto -4521 -> 553
    //   5077: iload 6
    //   5079: istore_3
    //   5080: goto -3866 -> 1214
    //   5083: iload 4
    //   5085: istore_3
    //   5086: aload 28
    //   5088: astore 31
    //   5090: aload 29
    //   5092: astore 28
    //   5094: iconst_1
    //   5095: istore 4
    //   5097: aload 31
    //   5099: astore 29
    //   5101: goto -1812 -> 3289
    //   5104: goto -3010 -> 2094
    //   5107: goto -3075 -> 2032
    //   5110: aconst_null
    //   5111: astore 31
    //   5113: iload 5
    //   5115: istore 4
    //   5117: goto -3085 -> 2032
    //   5120: iload_3
    //   5121: istore 9
    //   5123: aload 29
    //   5125: astore 31
    //   5127: iload 4
    //   5129: istore_3
    //   5130: lload 12
    //   5132: lstore 16
    //   5134: lload 14
    //   5136: lstore 12
    //   5138: lload 16
    //   5140: lstore 14
    //   5142: aload 28
    //   5144: astore 29
    //   5146: aload 31
    //   5148: astore 28
    //   5150: goto -4548 -> 602
    //   5153: iload_3
    //   5154: ireturn
    //   5155: iconst_1
    //   5156: istore 7
    //   5158: goto -4405 -> 753
    //   5161: aload 33
    //   5163: astore 31
    //   5165: iload_2
    //   5166: istore 5
    //   5168: iload 4
    //   5170: istore_2
    //   5171: iload 5
    //   5173: istore 4
    //   5175: goto -4130 -> 1045
    //   5178: astore 31
    //   5180: iconst_0
    //   5181: istore 5
    //   5183: iload_3
    //   5184: istore 7
    //   5186: aload 30
    //   5188: astore 32
    //   5190: iconst_0
    //   5191: istore_3
    //   5192: iload_2
    //   5193: istore 4
    //   5195: aload 29
    //   5197: astore 30
    //   5199: aload 28
    //   5201: astore 29
    //   5203: aload 32
    //   5205: astore 28
    //   5207: iload 7
    //   5209: istore_2
    //   5210: goto -4487 -> 723
    //   5213: iconst_0
    //   5214: istore 27
    //   5216: goto -2439 -> 2777
    //   5219: astore 31
    //   5221: lload 16
    //   5223: lstore 12
    //   5225: iconst_0
    //   5226: istore 4
    //   5228: aload 30
    //   5230: astore 28
    //   5232: iload_3
    //   5233: istore 7
    //   5235: iconst_1
    //   5236: istore 5
    //   5238: iload 4
    //   5240: istore_3
    //   5241: iload_2
    //   5242: istore 4
    //   5244: aload 32
    //   5246: astore 30
    //   5248: iload 7
    //   5250: istore_2
    //   5251: goto -4528 -> 723
    //   5254: astore 31
    //   5256: iconst_1
    //   5257: istore 5
    //   5259: iload_3
    //   5260: istore 10
    //   5262: aload 30
    //   5264: astore 32
    //   5266: iload 7
    //   5268: istore_3
    //   5269: iload_2
    //   5270: istore 4
    //   5272: aload 28
    //   5274: astore 30
    //   5276: aload 32
    //   5278: astore 28
    //   5280: iload 10
    //   5282: istore_2
    //   5283: goto -4560 -> 723
    //   5286: astore 31
    //   5288: aload 29
    //   5290: astore 32
    //   5292: aload 28
    //   5294: astore 29
    //   5296: aload 32
    //   5298: astore 28
    //   5300: goto -1594 -> 3706
    //   5303: astore 31
    //   5305: aload 29
    //   5307: astore 32
    //   5309: aload 28
    //   5311: astore 33
    //   5313: aload 30
    //   5315: astore 29
    //   5317: aload 32
    //   5319: astore 28
    //   5321: aload 33
    //   5323: astore 30
    //   5325: iload_2
    //   5326: istore_3
    //   5327: goto -1621 -> 3706
    //   5330: aload 28
    //   5332: astore 31
    //   5334: aload 30
    //   5336: astore 28
    //   5338: iload_3
    //   5339: istore 5
    //   5341: iload 9
    //   5343: istore_3
    //   5344: iload_2
    //   5345: istore 7
    //   5347: lload 12
    //   5349: lstore 16
    //   5351: lload 14
    //   5353: lstore 12
    //   5355: iload 4
    //   5357: istore_2
    //   5358: iload 7
    //   5360: istore 4
    //   5362: lload 16
    //   5364: lstore 14
    //   5366: aload 31
    //   5368: astore 30
    //   5370: goto -4353 -> 1017
    //   5373: aconst_null
    //   5374: astore 32
    //   5376: goto -1606 -> 3770
    //   5379: aload 28
    //   5381: astore 32
    //   5383: iconst_m1
    //   5384: istore_2
    //   5385: lconst_0
    //   5386: lstore 12
    //   5388: iconst_m1
    //   5389: istore 5
    //   5391: iload_3
    //   5392: istore 4
    //   5394: aload 30
    //   5396: astore 28
    //   5398: iload 5
    //   5400: istore_3
    //   5401: aload 32
    //   5403: astore 30
    //   5405: goto -4360 -> 1045
    //   5408: iconst_0
    //   5409: istore 26
    //   5411: goto -4252 -> 1159
    //   5414: iload_3
    //   5415: ifne -792 -> 4623
    //   5418: iconst_3
    //   5419: istore_2
    //   5420: goto -805 -> 4615
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	5423	0	paramDownloadTask	DownloadTask
    //   0	5423	1	paramAppInterface	AppInterface
    //   17	5403	2	i	int
    //   105	5310	3	j	int
    //   574	4819	4	k	int
    //   710	4689	5	m	int
    //   399	4679	6	n	int
    //   694	4665	7	i1	int
    //   402	2538	8	i2	int
    //   567	4775	9	i3	int
    //   2984	2297	10	i4	int
    //   2987	562	11	i5	int
    //   585	4802	12	l1	long
    //   446	4919	14	l2	long
    //   997	4366	16	l3	long
    //   2459	501	18	l4	long
    //   2736	226	20	l5	long
    //   2869	89	22	l6	long
    //   434	759	24	l7	long
    //   577	4833	26	bool1	boolean
    //   637	4578	27	bool2	boolean
    //   190	7	28	str1	String
    //   276	14	28	localThrowable1	java.lang.Throwable
    //   319	5078	28	localObject1	Object
    //   408	4908	29	localObject2	Object
    //   411	4404	30	localObject3	Object
    //   4830	16	30	localThrowable2	java.lang.Throwable
    //   4857	547	30	localObject4	Object
    //   462	773	31	localObject5	Object
    //   1325	1	31	localThrowable3	java.lang.Throwable
    //   1384	1131	31	localObject6	Object
    //   2644	1	31	localThrowable4	java.lang.Throwable
    //   3158	282	31	localObject7	Object
    //   3512	69	31	localException	Exception
    //   3600	1	31	localThrowable5	java.lang.Throwable
    //   3693	131	31	localObject8	Object
    //   3849	190	31	localObject9	Object
    //   4045	10	31	localObject10	Object
    //   4179	1	31	localObject11	Object
    //   4192	107	31	localIOException1	java.io.IOException
    //   4324	1	31	localObject12	Object
    //   4337	26	31	localIOException2	java.io.IOException
    //   4648	1	31	localInterruptedException	java.lang.InterruptedException
    //   4653	1	31	localThrowable6	java.lang.Throwable
    //   4658	1	31	localObject13	Object
    //   4671	1	31	localObject14	Object
    //   4680	1	31	localObject15	Object
    //   4688	1	31	localObject16	Object
    //   4696	1	31	localObject17	Object
    //   4704	1	31	localObject18	Object
    //   4713	1	31	localObject19	Object
    //   4721	1	31	localThrowable7	java.lang.Throwable
    //   4756	1	31	localThrowable8	java.lang.Throwable
    //   4791	48	31	localThrowable9	java.lang.Throwable
    //   4847	1	31	localThrowable10	java.lang.Throwable
    //   4873	1	31	localThrowable11	java.lang.Throwable
    //   4916	1	31	localThrowable12	java.lang.Throwable
    //   4951	1	31	localThrowable13	java.lang.Throwable
    //   4990	1	31	localThrowable14	java.lang.Throwable
    //   5029	42	31	localThrowable15	java.lang.Throwable
    //   5088	76	31	localObject20	Object
    //   5178	1	31	localThrowable16	java.lang.Throwable
    //   5219	1	31	localThrowable17	java.lang.Throwable
    //   5254	1	31	localThrowable18	java.lang.Throwable
    //   5286	1	31	localObject21	Object
    //   5303	1	31	localObject22	Object
    //   5332	35	31	localObject23	Object
    //   686	34	32	localThrowable19	java.lang.Throwable
    //   1063	4339	32	localObject24	Object
    //   551	4771	33	localObject25	Object
    //   604	4377	34	localObject26	Object
    //   484	3292	35	localFile1	File
    //   564	3207	36	localDownloadInfo	com.tencent.mobileqq.emoticon.DownloadInfo
    //   76	4529	37	localDownloadListener	DownloadListener
    //   147	2004	38	localBasicHttpParams	org.apache.http.params.BasicHttpParams
    //   443	3605	39	localObject27	Object
    //   496	176	40	localFile2	File
    //   530	3152	41	localFile3	File
    //   1407	1691	42	localObject28	Object
    //   1279	1024	43	localObject29	Object
    //   1437	65	44	str2	String
    //   1455	58	45	str3	String
    // Exception table:
    //   from	to	target	type
    //   72	78	276	java/lang/Throwable
    //   83	104	276	java/lang/Throwable
    //   106	138	276	java/lang/Throwable
    //   140	188	276	java/lang/Throwable
    //   192	223	276	java/lang/Throwable
    //   223	229	276	java/lang/Throwable
    //   234	240	276	java/lang/Throwable
    //   242	274	276	java/lang/Throwable
    //   390	401	276	java/lang/Throwable
    //   417	445	276	java/lang/Throwable
    //   448	486	276	java/lang/Throwable
    //   491	553	276	java/lang/Throwable
    //   553	566	276	java/lang/Throwable
    //   858	885	276	java/lang/Throwable
    //   890	905	276	java/lang/Throwable
    //   909	918	276	java/lang/Throwable
    //   918	939	276	java/lang/Throwable
    //   950	957	276	java/lang/Throwable
    //   962	967	276	java/lang/Throwable
    //   972	977	276	java/lang/Throwable
    //   1027	1042	276	java/lang/Throwable
    //   1050	1056	276	java/lang/Throwable
    //   1056	1152	276	java/lang/Throwable
    //   1159	1164	276	java/lang/Throwable
    //   3368	3395	276	java/lang/Throwable
    //   3400	3415	276	java/lang/Throwable
    //   3419	3428	276	java/lang/Throwable
    //   3428	3449	276	java/lang/Throwable
    //   3460	3467	276	java/lang/Throwable
    //   3472	3477	276	java/lang/Throwable
    //   3482	3487	276	java/lang/Throwable
    //   3710	3737	276	java/lang/Throwable
    //   3742	3757	276	java/lang/Throwable
    //   3761	3770	276	java/lang/Throwable
    //   3770	3791	276	java/lang/Throwable
    //   3796	3803	276	java/lang/Throwable
    //   3808	3813	276	java/lang/Throwable
    //   3818	3823	276	java/lang/Throwable
    //   3823	3826	276	java/lang/Throwable
    //   4184	4189	276	java/lang/Throwable
    //   4194	4231	276	java/lang/Throwable
    //   4329	4334	276	java/lang/Throwable
    //   4339	4376	276	java/lang/Throwable
    //   4379	4384	276	java/lang/Throwable
    //   4388	4424	276	java/lang/Throwable
    //   4427	4449	276	java/lang/Throwable
    //   4452	4460	276	java/lang/Throwable
    //   4469	4534	276	java/lang/Throwable
    //   4534	4540	276	java/lang/Throwable
    //   4549	4563	276	java/lang/Throwable
    //   4565	4581	276	java/lang/Throwable
    //   4586	4604	276	java/lang/Throwable
    //   4604	4610	276	java/lang/Throwable
    //   4615	4620	276	java/lang/Throwable
    //   654	686	686	java/lang/Throwable
    //   1296	1325	1325	java/lang/Throwable
    //   2591	2644	2644	java/lang/Throwable
    //   3145	3160	3512	java/lang/Exception
    //   3168	3179	3512	java/lang/Exception
    //   3187	3199	3512	java/lang/Exception
    //   3207	3215	3512	java/lang/Exception
    //   3226	3232	3512	java/lang/Exception
    //   3240	3279	3512	java/lang/Exception
    //   3009	3017	3600	java/lang/Throwable
    //   3025	3031	3600	java/lang/Throwable
    //   3039	3047	3600	java/lang/Throwable
    //   3058	3065	3600	java/lang/Throwable
    //   3076	3089	3600	java/lang/Throwable
    //   3097	3114	3600	java/lang/Throwable
    //   3122	3129	3600	java/lang/Throwable
    //   3145	3160	3600	java/lang/Throwable
    //   3168	3179	3600	java/lang/Throwable
    //   3187	3199	3600	java/lang/Throwable
    //   3207	3215	3600	java/lang/Throwable
    //   3226	3232	3600	java/lang/Throwable
    //   3240	3279	3600	java/lang/Throwable
    //   3522	3527	3600	java/lang/Throwable
    //   3538	3544	3600	java/lang/Throwable
    //   3552	3594	3600	java/lang/Throwable
    //   3681	3687	3600	java/lang/Throwable
    //   3009	3017	3693	finally
    //   3025	3031	3693	finally
    //   3039	3047	3693	finally
    //   3058	3065	3693	finally
    //   3076	3089	3693	finally
    //   3097	3114	3693	finally
    //   3122	3129	3693	finally
    //   3145	3160	3693	finally
    //   3168	3179	3693	finally
    //   3187	3199	3693	finally
    //   3207	3215	3693	finally
    //   3226	3232	3693	finally
    //   3240	3279	3693	finally
    //   3522	3527	3693	finally
    //   3538	3544	3693	finally
    //   3552	3594	3693	finally
    //   3681	3687	3693	finally
    //   3354	3361	4045	finally
    //   3361	3364	4045	finally
    //   4047	4050	4045	finally
    //   3460	3467	4192	java/io/IOException
    //   3472	3477	4192	java/io/IOException
    //   3482	3487	4192	java/io/IOException
    //   950	957	4337	java/io/IOException
    //   962	967	4337	java/io/IOException
    //   972	977	4337	java/io/IOException
    //   3796	3803	4387	java/io/IOException
    //   3808	3813	4387	java/io/IOException
    //   3818	3823	4387	java/io/IOException
    //   315	345	4642	java/lang/Throwable
    //   3354	3361	4648	java/lang/InterruptedException
    //   1168	1205	4653	java/lang/Throwable
    //   2811	2816	4658	finally
    //   2823	2830	4658	finally
    //   2834	2843	4658	finally
    //   2853	2863	4658	finally
    //   2919	2930	4658	finally
    //   2934	2944	4658	finally
    //   2948	2954	4658	finally
    //   2972	2983	4658	finally
    //   2996	3001	4658	finally
    //   3632	3639	4658	finally
    //   3647	3653	4658	finally
    //   3667	3673	4658	finally
    //   606	611	4671	finally
    //   620	628	4671	finally
    //   632	639	4671	finally
    //   648	654	4671	finally
    //   1245	1251	4671	finally
    //   1255	1269	4671	finally
    //   1273	1281	4671	finally
    //   1290	1296	4671	finally
    //   1365	1376	4671	finally
    //   1380	1386	4671	finally
    //   1395	1409	4671	finally
    //   1413	1423	4671	finally
    //   1427	1439	4671	finally
    //   1443	1457	4671	finally
    //   1461	1470	4671	finally
    //   1474	1480	4671	finally
    //   1484	1523	4671	finally
    //   1535	1543	4671	finally
    //   1547	1554	4671	finally
    //   1558	1593	4671	finally
    //   1597	1603	4671	finally
    //   1607	1635	4671	finally
    //   1639	1646	4671	finally
    //   1655	1663	4671	finally
    //   1667	1674	4671	finally
    //   1685	1700	4671	finally
    //   1704	1715	4671	finally
    //   1719	1735	4671	finally
    //   1739	1747	4671	finally
    //   1751	1761	4671	finally
    //   1765	1771	4671	finally
    //   1775	1803	4671	finally
    //   1807	1813	4671	finally
    //   1817	1824	4671	finally
    //   1828	1835	4671	finally
    //   1839	1844	4671	finally
    //   1848	1856	4671	finally
    //   1860	1877	4671	finally
    //   1881	1894	4671	finally
    //   1898	1908	4671	finally
    //   1912	1924	4671	finally
    //   1928	1933	4671	finally
    //   1937	1943	4671	finally
    //   1956	1964	4671	finally
    //   1968	1975	4671	finally
    //   1979	1984	4671	finally
    //   1988	1993	4671	finally
    //   2007	2029	4671	finally
    //   2036	2047	4671	finally
    //   2051	2062	4671	finally
    //   2066	2077	4671	finally
    //   2081	2094	4671	finally
    //   2098	2105	4671	finally
    //   2109	2118	4671	finally
    //   2122	2128	4671	finally
    //   2132	2144	4671	finally
    //   2148	2155	4671	finally
    //   2159	2165	4671	finally
    //   2169	2178	4671	finally
    //   2182	2294	4671	finally
    //   2298	2310	4671	finally
    //   2314	2324	4671	finally
    //   2332	2346	4671	finally
    //   2354	2360	4671	finally
    //   2368	2396	4671	finally
    //   2404	2411	4671	finally
    //   2435	2444	4671	finally
    //   2452	2461	4671	finally
    //   2469	2481	4671	finally
    //   2489	2501	4671	finally
    //   2514	2535	4671	finally
    //   2550	2559	4671	finally
    //   2567	2573	4671	finally
    //   2585	2591	4671	finally
    //   2707	2720	4671	finally
    //   2731	2738	4671	finally
    //   2758	2764	4671	finally
    //   2785	2798	4671	finally
    //   3838	3844	4671	finally
    //   3889	3895	4671	finally
    //   3904	3910	4671	finally
    //   3981	3986	4671	finally
    //   4014	4020	4671	finally
    //   654	686	4680	finally
    //   1296	1325	4688	finally
    //   2591	2644	4696	finally
    //   2798	2807	4704	finally
    //   3910	3944	4713	finally
    //   648	654	4721	java/lang/Throwable
    //   2036	2047	4756	java/lang/Throwable
    //   2051	2062	4756	java/lang/Throwable
    //   2066	2077	4756	java/lang/Throwable
    //   2081	2094	4756	java/lang/Throwable
    //   2098	2105	4791	java/lang/Throwable
    //   2109	2118	4791	java/lang/Throwable
    //   2122	2128	4791	java/lang/Throwable
    //   2132	2144	4791	java/lang/Throwable
    //   2148	2155	4791	java/lang/Throwable
    //   2159	2165	4791	java/lang/Throwable
    //   2169	2178	4791	java/lang/Throwable
    //   2182	2294	4791	java/lang/Throwable
    //   2298	2310	4791	java/lang/Throwable
    //   2314	2324	4791	java/lang/Throwable
    //   2332	2346	4830	java/lang/Throwable
    //   2354	2360	4830	java/lang/Throwable
    //   2368	2396	4830	java/lang/Throwable
    //   2404	2411	4830	java/lang/Throwable
    //   2435	2444	4830	java/lang/Throwable
    //   2452	2461	4830	java/lang/Throwable
    //   3889	3895	4830	java/lang/Throwable
    //   3981	3986	4830	java/lang/Throwable
    //   4014	4020	4830	java/lang/Throwable
    //   2469	2481	4873	java/lang/Throwable
    //   2489	2501	4873	java/lang/Throwable
    //   2514	2535	4873	java/lang/Throwable
    //   2550	2559	4873	java/lang/Throwable
    //   2567	2573	4873	java/lang/Throwable
    //   2707	2720	4873	java/lang/Throwable
    //   2731	2738	4873	java/lang/Throwable
    //   2758	2764	4873	java/lang/Throwable
    //   2785	2798	4873	java/lang/Throwable
    //   2585	2591	4916	java/lang/Throwable
    //   2798	2807	4951	java/lang/Throwable
    //   3838	3844	4990	java/lang/Throwable
    //   3904	3910	4990	java/lang/Throwable
    //   3910	3944	5029	java/lang/Throwable
    //   606	611	5178	java/lang/Throwable
    //   620	628	5178	java/lang/Throwable
    //   632	639	5178	java/lang/Throwable
    //   1245	1251	5178	java/lang/Throwable
    //   1255	1269	5178	java/lang/Throwable
    //   1273	1281	5178	java/lang/Throwable
    //   1290	1296	5178	java/lang/Throwable
    //   1365	1376	5178	java/lang/Throwable
    //   1380	1386	5178	java/lang/Throwable
    //   1395	1409	5178	java/lang/Throwable
    //   1413	1423	5178	java/lang/Throwable
    //   1427	1439	5178	java/lang/Throwable
    //   1443	1457	5178	java/lang/Throwable
    //   1461	1470	5178	java/lang/Throwable
    //   1474	1480	5178	java/lang/Throwable
    //   1484	1523	5178	java/lang/Throwable
    //   1535	1543	5178	java/lang/Throwable
    //   1547	1554	5178	java/lang/Throwable
    //   1558	1593	5178	java/lang/Throwable
    //   1597	1603	5178	java/lang/Throwable
    //   1607	1635	5178	java/lang/Throwable
    //   1639	1646	5178	java/lang/Throwable
    //   1655	1663	5178	java/lang/Throwable
    //   1667	1674	5178	java/lang/Throwable
    //   1685	1700	5178	java/lang/Throwable
    //   1704	1715	5178	java/lang/Throwable
    //   1719	1735	5178	java/lang/Throwable
    //   1739	1747	5178	java/lang/Throwable
    //   1751	1761	5178	java/lang/Throwable
    //   1765	1771	5178	java/lang/Throwable
    //   1775	1803	5178	java/lang/Throwable
    //   1807	1813	5178	java/lang/Throwable
    //   1817	1824	5178	java/lang/Throwable
    //   1828	1835	5178	java/lang/Throwable
    //   1839	1844	5178	java/lang/Throwable
    //   1848	1856	5178	java/lang/Throwable
    //   1860	1877	5178	java/lang/Throwable
    //   1881	1894	5178	java/lang/Throwable
    //   1898	1908	5178	java/lang/Throwable
    //   1912	1924	5178	java/lang/Throwable
    //   1928	1933	5178	java/lang/Throwable
    //   1937	1943	5178	java/lang/Throwable
    //   1956	1964	5178	java/lang/Throwable
    //   1968	1975	5178	java/lang/Throwable
    //   1979	1984	5178	java/lang/Throwable
    //   1988	1993	5178	java/lang/Throwable
    //   2007	2029	5178	java/lang/Throwable
    //   2811	2816	5219	java/lang/Throwable
    //   2823	2830	5219	java/lang/Throwable
    //   2834	2843	5219	java/lang/Throwable
    //   2853	2863	5219	java/lang/Throwable
    //   2919	2930	5219	java/lang/Throwable
    //   2934	2944	5219	java/lang/Throwable
    //   2948	2954	5219	java/lang/Throwable
    //   2972	2983	5219	java/lang/Throwable
    //   2996	3001	5219	java/lang/Throwable
    //   3632	3639	5219	java/lang/Throwable
    //   3647	3653	5219	java/lang/Throwable
    //   3667	3673	5219	java/lang/Throwable
    //   3293	3299	5254	java/lang/Throwable
    //   3303	3313	5254	java/lang/Throwable
    //   3321	3328	5254	java/lang/Throwable
    //   3332	3341	5254	java/lang/Throwable
    //   3345	3348	5254	java/lang/Throwable
    //   4054	4057	5254	java/lang/Throwable
    //   4061	4071	5254	java/lang/Throwable
    //   4075	4082	5254	java/lang/Throwable
    //   4086	4102	5254	java/lang/Throwable
    //   4105	4160	5254	java/lang/Throwable
    //   4164	4175	5254	java/lang/Throwable
    //   3293	3299	5286	finally
    //   3303	3313	5286	finally
    //   3321	3328	5286	finally
    //   3332	3341	5286	finally
    //   3345	3348	5286	finally
    //   4054	4057	5286	finally
    //   4061	4071	5286	finally
    //   4075	4082	5286	finally
    //   4086	4102	5286	finally
    //   4105	4160	5286	finally
    //   4164	4175	5286	finally
    //   726	742	5303	finally
    //   742	750	5303	finally
    //   753	773	5303	finally
    //   788	793	5303	finally
    //   793	854	5303	finally
    //   4256	4270	5303	finally
    //   4273	4289	5303	finally
    //   4289	4295	5303	finally
    //   4298	4312	5303	finally
    //   4315	4320	5303	finally
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    paramContext = Integer.toString(NetworkUtil.a(paramContext));
    if (paramString2 != null) {}
    for (;;)
    {
      ReportController.b(null, "CliOper", "", "", "VipDownload", "ip", 0, paramInt, paramString1, paramContext, paramString2, "");
      return;
      paramString2 = "unknow";
    }
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      int i = NetworkUtil.a(paramContext);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "isQualityNetwork type=" + i);
      }
      if ((i != 3) && (i != 4))
      {
        bool1 = bool2;
        if (i != 1) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask == null) {
      return false;
    }
    if ((paramDownloadTask.jdField_a_of_type_JavaUtilList == null) || (paramDownloadTask.jdField_a_of_type_JavaUtilMap == null) || (paramDownloadTask.jdField_a_of_type_JavaUtilList.size() < 1) || (paramDownloadTask.jdField_a_of_type_JavaUtilMap.size() < 1) || (TextUtils.isEmpty(paramDownloadTask.jdField_a_of_type_JavaLangString))) {
      return false;
    }
    paramDownloadTask = paramDownloadTask.jdField_a_of_type_JavaUtilList.iterator();
    while (paramDownloadTask.hasNext())
    {
      String str = (String)paramDownloadTask.next();
      if ((TextUtils.isEmpty(str)) || (!URLUtil.isNetworkUrl(str))) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean a(File paramFile1, File paramFile2)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramFile1 != null) {}
    for (;;)
    {
      int i;
      try
      {
        bool2 = paramFile1.exists();
        if (!bool2)
        {
          bool2 = bool1;
          return bool2;
        }
        long l = System.currentTimeMillis();
        try
        {
          if (!paramFile2.exists()) {
            break label252;
          }
          File[] arrayOfFile1 = paramFile2.listFiles();
          i = 0;
          if (i >= arrayOfFile1.length) {
            break label257;
          }
          File localFile = arrayOfFile1[i];
          if (localFile.isDirectory())
          {
            File[] arrayOfFile2 = localFile.listFiles();
            if (arrayOfFile2 != null)
            {
              int k = arrayOfFile2.length;
              int j = 0;
              if (j < k)
              {
                arrayOfFile2[j].delete();
                j += 1;
                continue;
              }
              localFile.delete();
            }
          }
          else
          {
            arrayOfFile1[i].delete();
          }
        }
        catch (Exception paramFile1)
        {
          bool1 = bool3;
          if (QLog.isColorLevel())
          {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "unzipResource|unzip resource fail targetDir=" + paramFile2.getAbsolutePath());
            bool1 = bool3;
          }
        }
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "unzipResource|use time " + (System.currentTimeMillis() - l) + " targetDir=" + paramFile2.getAbsolutePath());
        bool2 = bool1;
        continue;
        paramFile2.mkdirs();
      }
      finally {}
      label252:
      ZipUtils.a(paramFile1, paramFile2.getAbsolutePath() + File.separatorChar);
      label257:
      paramFile1.delete();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "unzipResource|unzip resource succ targetDir=" + paramFile2.getAbsolutePath());
      }
      bool1 = true;
      continue;
      i += 1;
    }
  }
  
  public static boolean a(String paramString)
  {
    int i;
    if (b.containsKey(paramString)) {
      i = ((Integer)b.get(paramString)).intValue();
    }
    while (i > 0) {
      if ((int)(System.currentTimeMillis() / 1000L) < i + 600)
      {
        return true;
        i = 0;
      }
      else
      {
        b.remove(paramString);
        return false;
      }
    }
    return false;
  }
  
  /* Error */
  public DownloaderInterface a(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: getstatic 53	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   5: ifnull +174 -> 179
    //   8: getstatic 53	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   11: astore_3
    //   12: aload_3
    //   13: monitorenter
    //   14: iload_1
    //   15: tableswitch	default:+21 -> 36, 1:+25->40, 2:+97->112
    //   37: monitorexit
    //   38: aload_2
    //   39: areturn
    //   40: getstatic 53	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   43: iload_1
    //   44: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   47: invokevirtual 804	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   50: ifeq +20 -> 70
    //   53: getstatic 53	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   56: iload_1
    //   57: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   60: invokevirtual 805	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   63: checkcast 811	com/tencent/mobileqq/vip/DownloaderInterface
    //   66: astore_2
    //   67: goto -31 -> 36
    //   70: new 813	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig
    //   73: dup
    //   74: iconst_0
    //   75: invokespecial 816	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:<init>	(Z)V
    //   78: astore_2
    //   79: new 818	kvs
    //   82: dup
    //   83: aload_0
    //   84: getfield 48	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   87: aload_2
    //   88: invokespecial 821	kvs:<init>	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;)V
    //   91: astore_2
    //   92: getstatic 53	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   95: iload_1
    //   96: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   99: aload_2
    //   100: invokevirtual 710	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   103: pop
    //   104: goto -68 -> 36
    //   107: astore_2
    //   108: aload_3
    //   109: monitorexit
    //   110: aload_2
    //   111: athrow
    //   112: getstatic 53	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   115: iload_1
    //   116: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   119: invokevirtual 804	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   122: ifeq +20 -> 142
    //   125: getstatic 53	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   128: iload_1
    //   129: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   132: invokevirtual 805	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   135: checkcast 811	com/tencent/mobileqq/vip/DownloaderInterface
    //   138: astore_2
    //   139: goto -103 -> 36
    //   142: new 813	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig
    //   145: dup
    //   146: iconst_0
    //   147: invokespecial 816	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:<init>	(Z)V
    //   150: astore_2
    //   151: new 818	kvs
    //   154: dup
    //   155: aload_0
    //   156: getfield 48	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   159: aload_2
    //   160: invokespecial 821	kvs:<init>	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;)V
    //   163: astore_2
    //   164: getstatic 53	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   167: iload_1
    //   168: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   171: aload_2
    //   172: invokevirtual 710	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   175: pop
    //   176: goto -140 -> 36
    //   179: aconst_null
    //   180: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	DownloaderFactory
    //   0	181	1	paramInt	int
    //   1	99	2	localObject1	Object
    //   107	4	2	localObject2	Object
    //   138	34	2	localObject3	Object
    //   11	98	3	localConcurrentHashMap	ConcurrentHashMap
    // Exception table:
    //   from	to	target	type
    //   36	38	107	finally
    //   40	67	107	finally
    //   70	104	107	finally
    //   108	110	107	finally
    //   112	139	107	finally
    //   142	176	107	finally
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onDestroy...");
    }
    synchronized (b)
    {
      b.clear();
      synchronized (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
        if (localIterator.hasNext()) {
          ((DownloaderInterface)((Map.Entry)localIterator.next()).getValue()).a();
        }
      }
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vip.DownloaderFactory
 * JD-Core Version:    0.7.0.1
 */