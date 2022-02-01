package com.tencent.mobileqq.startup.step;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources.NotFoundException;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.startup.director.StartupDirector;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import jwg;
import mqq.app.AppActivity;

public class SetSplash
  extends Step
{
  static final int jdField_a_of_type_Int = 3;
  static final long jdField_a_of_type_Long = 86400000L;
  static final String jdField_a_of_type_JavaLangString = "splashshowtime";
  private static final String c = "splash";
  
  private static int a(long paramLong, String paramString)
  {
    int i = Calendar.getInstance().get(1);
    paramString = i + "-" + paramString;
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    try
    {
      paramLong = (localSimpleDateFormat.parse(paramString).getTime() - paramLong) / 86400000L;
      return (int)paramLong;
    }
    catch (ParseException paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  /* Error */
  public static long a(android.app.Activity paramActivity)
  {
    // Byte code:
    //   0: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +28 -> 31
    //   6: ldc 85
    //   8: iconst_2
    //   9: new 36	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   16: ldc 87
    //   18: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_0
    //   22: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: invokestatic 99	java/lang/System:currentTimeMillis	()J
    //   34: lstore 14
    //   36: ldc2_w 100
    //   39: lstore 6
    //   41: aload_0
    //   42: invokestatic 107	com/tencent/mobileqq/util/SizeMeasure:b	(Landroid/content/Context;)V
    //   45: aload_0
    //   46: instanceof 109
    //   49: ifeq +756 -> 805
    //   52: aload_0
    //   53: checkcast 109	com/tencent/mobileqq/app/IphoneTitleBarActivity
    //   56: ldc 110
    //   58: invokevirtual 114	com/tencent/mobileqq/app/IphoneTitleBarActivity:setContentViewNoTitle	(I)V
    //   61: aload_0
    //   62: ldc 115
    //   64: invokevirtual 121	android/app/Activity:findViewById	(I)Landroid/view/View;
    //   67: checkcast 123	android/widget/ImageView
    //   70: astore 24
    //   72: aload_0
    //   73: ldc 124
    //   75: invokevirtual 121	android/app/Activity:findViewById	(I)Landroid/view/View;
    //   78: checkcast 126	android/widget/TextView
    //   81: astore 25
    //   83: aconst_null
    //   84: astore 21
    //   86: aconst_null
    //   87: astore 18
    //   89: aload_0
    //   90: invokestatic 131	com/tencent/mobileqq/utils/SharedPreUtils:b	(Landroid/content/Context;)Ljava/lang/String;
    //   93: astore 22
    //   95: aload_0
    //   96: invokevirtual 135	android/app/Activity:getFilesDir	()Ljava/io/File;
    //   99: astore 23
    //   101: aload 23
    //   103: ifnull +746 -> 849
    //   106: aload 23
    //   108: invokevirtual 140	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   111: astore 20
    //   113: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   116: ifeq +34 -> 150
    //   119: ldc 142
    //   121: iconst_2
    //   122: new 36	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   129: ldc 144
    //   131: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload 22
    //   136: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload 23
    //   141: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 147	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: invokestatic 99	java/lang/System:currentTimeMillis	()J
    //   153: lstore 8
    //   155: aload 21
    //   157: astore 19
    //   159: lload 6
    //   161: lstore 4
    //   163: aload 23
    //   165: ifnull +203 -> 368
    //   168: aload 21
    //   170: astore 19
    //   172: lload 6
    //   174: lstore 4
    //   176: aload 22
    //   178: ldc 149
    //   180: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   183: ifne +185 -> 368
    //   186: aload 21
    //   188: astore 19
    //   190: lload 6
    //   192: lstore 4
    //   194: lload 8
    //   196: aload 22
    //   198: invokestatic 157	com/tencent/mobileqq/startup/step/SetSplash:a	(JLjava/lang/String;)I
    //   201: ifne +167 -> 368
    //   204: new 36	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   211: aload 20
    //   213: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: ldc 159
    //   218: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: aload_0
    //   222: invokestatic 161	com/tencent/mobileqq/utils/SharedPreUtils:a	(Landroid/content/Context;)Ljava/lang/String;
    //   225: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: ldc 159
    //   230: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: ldc 163
    //   235: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: astore 22
    //   243: new 137	java/io/File
    //   246: dup
    //   247: aload 22
    //   249: invokespecial 164	java/io/File:<init>	(Ljava/lang/String;)V
    //   252: astore 23
    //   254: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   257: ifeq +37 -> 294
    //   260: ldc 142
    //   262: iconst_2
    //   263: new 36	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   270: aload 22
    //   272: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: ldc 166
    //   277: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: aload 23
    //   282: invokevirtual 169	java/io/File:exists	()Z
    //   285: invokevirtual 172	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   288: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: invokestatic 175	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   294: aload 21
    //   296: astore 19
    //   298: lload 6
    //   300: lstore 4
    //   302: aload 23
    //   304: invokevirtual 169	java/io/File:exists	()Z
    //   307: ifeq +61 -> 368
    //   310: new 177	android/graphics/drawable/BitmapDrawable
    //   313: dup
    //   314: aload_0
    //   315: invokevirtual 181	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   318: aload 22
    //   320: invokestatic 186	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   323: invokespecial 189	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   326: astore 19
    //   328: aload 19
    //   330: ifnull +527 -> 857
    //   333: lconst_1
    //   334: lstore 4
    //   336: aload 19
    //   338: astore 18
    //   340: lload 4
    //   342: lstore 6
    //   344: aload 18
    //   346: astore 19
    //   348: lload 6
    //   350: lstore 4
    //   352: aload 18
    //   354: ifnull +14 -> 368
    //   357: invokestatic 191	com/tencent/mobileqq/startup/step/SetSplash:a	()V
    //   360: lload 6
    //   362: lstore 4
    //   364: aload 18
    //   366: astore 19
    //   368: aload 19
    //   370: ifnonnull +1196 -> 1566
    //   373: aload_0
    //   374: instanceof 193
    //   377: ifne +1189 -> 1566
    //   380: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   383: ifeq +11 -> 394
    //   386: ldc 195
    //   388: iconst_2
    //   389: ldc 197
    //   391: invokestatic 147	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   394: new 36	java/lang/StringBuilder
    //   397: dup
    //   398: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   401: aload 20
    //   403: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: ldc 199
    //   408: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: astore 26
    //   416: new 137	java/io/File
    //   419: dup
    //   420: new 36	java/lang/StringBuilder
    //   423: dup
    //   424: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   427: aload 20
    //   429: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: ldc 201
    //   434: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   440: invokespecial 164	java/io/File:<init>	(Ljava/lang/String;)V
    //   443: astore 18
    //   445: aconst_null
    //   446: astore 22
    //   448: aload 18
    //   450: ifnull +1106 -> 1556
    //   453: aload 18
    //   455: invokevirtual 169	java/io/File:exists	()Z
    //   458: ifeq +1098 -> 1556
    //   461: aload 18
    //   463: invokevirtual 204	java/io/File:isDirectory	()Z
    //   466: ifeq +1090 -> 1556
    //   469: aload 18
    //   471: invokevirtual 208	java/io/File:listFiles	()[Ljava/io/File;
    //   474: astore 27
    //   476: aload 27
    //   478: arraylength
    //   479: istore_2
    //   480: iconst_0
    //   481: istore_1
    //   482: ldc 149
    //   484: astore 21
    //   486: aconst_null
    //   487: astore 20
    //   489: aconst_null
    //   490: astore 18
    //   492: lconst_0
    //   493: lstore 12
    //   495: lconst_0
    //   496: lstore 10
    //   498: iload_1
    //   499: iload_2
    //   500: if_icmpge +513 -> 1013
    //   503: aload 27
    //   505: iload_1
    //   506: aaload
    //   507: astore 28
    //   509: aload 28
    //   511: ifnull +1018 -> 1529
    //   514: aload 28
    //   516: invokevirtual 211	java/io/File:getName	()Ljava/lang/String;
    //   519: astore 29
    //   521: aload 29
    //   523: ldc 213
    //   525: invokevirtual 217	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   528: astore 30
    //   530: aload 30
    //   532: ifnull +997 -> 1529
    //   535: aload 30
    //   537: arraylength
    //   538: iconst_3
    //   539: if_icmpne +990 -> 1529
    //   542: aload 30
    //   544: iconst_0
    //   545: aaload
    //   546: astore 21
    //   548: aload 30
    //   550: iconst_1
    //   551: aaload
    //   552: astore 23
    //   554: lload 12
    //   556: lstore 6
    //   558: lload 10
    //   560: lstore 8
    //   562: aload 21
    //   564: ifnull +57 -> 621
    //   567: lload 12
    //   569: lstore 6
    //   571: lload 10
    //   573: lstore 8
    //   575: aload 21
    //   577: invokevirtual 220	java/lang/String:trim	()Ljava/lang/String;
    //   580: ldc 149
    //   582: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   585: ifne +36 -> 621
    //   588: aload 21
    //   590: ldc 222
    //   592: invokevirtual 226	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   595: istore_3
    //   596: aload 21
    //   598: iconst_0
    //   599: iload_3
    //   600: invokevirtual 230	java/lang/String:substring	(II)Ljava/lang/String;
    //   603: invokestatic 236	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   606: lstore 8
    //   608: aload 21
    //   610: iload_3
    //   611: iconst_1
    //   612: iadd
    //   613: invokevirtual 239	java/lang/String:substring	(I)Ljava/lang/String;
    //   616: invokestatic 236	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   619: lstore 6
    //   621: lload 8
    //   623: lload 6
    //   625: invokestatic 242	com/tencent/mobileqq/startup/step/SetSplash:a	(JJ)Z
    //   628: ifeq +275 -> 903
    //   631: aload 18
    //   633: astore 22
    //   635: aload 20
    //   637: astore 21
    //   639: aload 20
    //   641: ifnonnull +361 -> 1002
    //   644: new 137	java/io/File
    //   647: dup
    //   648: new 36	java/lang/StringBuilder
    //   651: dup
    //   652: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   655: aload 26
    //   657: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: aload 30
    //   662: iconst_1
    //   663: aaload
    //   664: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   670: invokespecial 164	java/io/File:<init>	(Ljava/lang/String;)V
    //   673: astore 20
    //   675: aload 28
    //   677: invokevirtual 245	java/io/File:length	()J
    //   680: lconst_0
    //   681: lcmp
    //   682: ifle +11 -> 693
    //   685: aload 28
    //   687: aload_0
    //   688: invokestatic 248	com/tencent/mobileqq/startup/step/SetSplash:a	(Ljava/io/File;Landroid/app/Activity;)Lcom/tencent/mobileqq/utils/JumpAction;
    //   691: astore 18
    //   693: aload 18
    //   695: astore 22
    //   697: aload 20
    //   699: astore 21
    //   701: invokestatic 251	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   704: ifeq +298 -> 1002
    //   707: ldc 195
    //   709: iconst_4
    //   710: ldc 253
    //   712: invokestatic 147	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   715: aload 20
    //   717: astore 21
    //   719: aload 18
    //   721: astore 20
    //   723: aload 21
    //   725: astore 18
    //   727: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   730: ifeq +32 -> 762
    //   733: ldc 195
    //   735: iconst_2
    //   736: new 36	java/lang/StringBuilder
    //   739: dup
    //   740: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   743: ldc 255
    //   745: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: aload 28
    //   750: invokevirtual 140	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   753: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   756: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   759: invokestatic 147	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   762: aload 23
    //   764: astore 22
    //   766: aload 18
    //   768: astore 21
    //   770: aload 22
    //   772: astore 18
    //   774: iload_1
    //   775: iconst_1
    //   776: iadd
    //   777: istore_1
    //   778: aload 18
    //   780: astore 22
    //   782: aload 20
    //   784: astore 18
    //   786: aload 21
    //   788: astore 20
    //   790: lload 6
    //   792: lstore 12
    //   794: lload 8
    //   796: lstore 10
    //   798: aload 22
    //   800: astore 21
    //   802: goto -304 -> 498
    //   805: aload_0
    //   806: ldc 110
    //   808: invokevirtual 258	android/app/Activity:setContentView	(I)V
    //   811: goto -750 -> 61
    //   814: astore 18
    //   816: aload 18
    //   818: invokestatic 264	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   821: astore 18
    //   823: ldc_w 266
    //   826: iconst_1
    //   827: aload 18
    //   829: invokestatic 175	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   832: aload_0
    //   833: ldc_w 268
    //   836: aload 18
    //   838: invokestatic 273	com/tencent/mobileqq/app/InjectUtils:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   841: aload_0
    //   842: invokevirtual 276	android/app/Activity:finish	()V
    //   845: ldc2_w 100
    //   848: lreturn
    //   849: ldc_w 278
    //   852: astore 20
    //   854: goto -741 -> 113
    //   857: ldc2_w 100
    //   860: lstore 4
    //   862: goto -526 -> 336
    //   865: astore 19
    //   867: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   870: ifeq +14 -> 884
    //   873: ldc 142
    //   875: iconst_2
    //   876: ldc_w 280
    //   879: aload 19
    //   881: invokestatic 283	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   884: aload 19
    //   886: invokevirtual 284	java/lang/Throwable:printStackTrace	()V
    //   889: goto -545 -> 344
    //   892: astore 21
    //   894: lconst_0
    //   895: lstore 8
    //   897: lconst_0
    //   898: lstore 6
    //   900: goto -279 -> 621
    //   903: aload 18
    //   905: astore 22
    //   907: aload 20
    //   909: astore 21
    //   911: lload 6
    //   913: invokestatic 99	java/lang/System:currentTimeMillis	()J
    //   916: lcmp
    //   917: ifge +85 -> 1002
    //   920: new 137	java/io/File
    //   923: dup
    //   924: new 36	java/lang/StringBuilder
    //   927: dup
    //   928: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   931: aload 26
    //   933: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   936: aload 29
    //   938: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   941: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   944: invokespecial 164	java/io/File:<init>	(Ljava/lang/String;)V
    //   947: astore 29
    //   949: aload 18
    //   951: astore 22
    //   953: aload 20
    //   955: astore 21
    //   957: aload 29
    //   959: invokevirtual 169	java/io/File:exists	()Z
    //   962: ifeq +40 -> 1002
    //   965: aload 29
    //   967: invokevirtual 287	java/io/File:delete	()Z
    //   970: pop
    //   971: aload 18
    //   973: astore 22
    //   975: aload 20
    //   977: astore 21
    //   979: invokestatic 251	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   982: ifeq +20 -> 1002
    //   985: ldc 195
    //   987: iconst_4
    //   988: ldc_w 289
    //   991: invokestatic 147	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   994: aload 20
    //   996: astore 21
    //   998: aload 18
    //   1000: astore 22
    //   1002: aload 22
    //   1004: astore 20
    //   1006: aload 21
    //   1008: astore 18
    //   1010: goto -283 -> 727
    //   1013: aload 20
    //   1015: astore 22
    //   1017: aload 18
    //   1019: astore 20
    //   1021: aload 21
    //   1023: astore 18
    //   1025: aload 22
    //   1027: ifnull +484 -> 1511
    //   1030: aload 22
    //   1032: invokevirtual 169	java/io/File:exists	()Z
    //   1035: ifeq +476 -> 1511
    //   1038: aload 22
    //   1040: invokevirtual 292	java/io/File:isFile	()Z
    //   1043: ifeq +468 -> 1511
    //   1046: new 177	android/graphics/drawable/BitmapDrawable
    //   1049: dup
    //   1050: aload_0
    //   1051: invokevirtual 181	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1054: aload 22
    //   1056: invokevirtual 140	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1059: invokestatic 186	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   1062: invokespecial 189	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   1065: astore 21
    //   1067: aload 21
    //   1069: ifnull +343 -> 1412
    //   1072: lconst_1
    //   1073: lstore 4
    //   1075: iconst_1
    //   1076: istore 16
    //   1078: invokestatic 251	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1081: ifeq +12 -> 1093
    //   1084: ldc 195
    //   1086: iconst_4
    //   1087: ldc_w 294
    //   1090: invokestatic 147	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1093: iconst_1
    //   1094: istore 16
    //   1096: aload 21
    //   1098: astore 19
    //   1100: aload 19
    //   1102: ifnull +394 -> 1496
    //   1105: aload 20
    //   1107: astore 21
    //   1109: invokestatic 191	com/tencent/mobileqq/startup/step/SetSplash:a	()V
    //   1112: aload 19
    //   1114: astore 20
    //   1116: aload 21
    //   1118: astore 19
    //   1120: aload 20
    //   1122: ifnonnull +368 -> 1490
    //   1125: aload 24
    //   1127: ldc_w 295
    //   1130: invokevirtual 298	android/widget/ImageView:setImageResource	(I)V
    //   1133: iconst_1
    //   1134: istore 17
    //   1136: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1139: ifeq +41 -> 1180
    //   1142: ldc 16
    //   1144: iconst_2
    //   1145: new 36	java/lang/StringBuilder
    //   1148: dup
    //   1149: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1152: ldc_w 300
    //   1155: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1158: iload 17
    //   1160: invokevirtual 172	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1163: ldc_w 302
    //   1166: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1169: iload 16
    //   1171: invokevirtual 172	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1174: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1177: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1180: aload 20
    //   1182: ifnull +134 -> 1316
    //   1185: iload 16
    //   1187: ifeq +122 -> 1309
    //   1190: aload 19
    //   1192: ifnonnull +258 -> 1450
    //   1195: ldc_w 304
    //   1198: astore 21
    //   1200: aconst_null
    //   1201: ldc_w 306
    //   1204: ldc 149
    //   1206: ldc 149
    //   1208: ldc_w 308
    //   1211: ldc_w 308
    //   1214: iconst_0
    //   1215: iconst_0
    //   1216: aload 21
    //   1218: ldc 149
    //   1220: aload 18
    //   1222: ldc 149
    //   1224: invokestatic 313	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1227: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1230: ifeq +30 -> 1260
    //   1233: ldc 16
    //   1235: iconst_2
    //   1236: new 36	java/lang/StringBuilder
    //   1239: dup
    //   1240: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1243: ldc_w 315
    //   1246: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1249: aload 18
    //   1251: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1254: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1257: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1260: aload 25
    //   1262: iconst_0
    //   1263: invokevirtual 318	android/widget/TextView:setVisibility	(I)V
    //   1266: aload 25
    //   1268: iconst_1
    //   1269: invokevirtual 322	android/widget/TextView:setEnabled	(Z)V
    //   1272: aload 25
    //   1274: new 324	jwe
    //   1277: dup
    //   1278: aload 21
    //   1280: aload 18
    //   1282: invokespecial 327	jwe:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1285: invokevirtual 331	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1288: aload 19
    //   1290: ifnull +19 -> 1309
    //   1293: aload 24
    //   1295: new 333	jwf
    //   1298: dup
    //   1299: aload 18
    //   1301: aload 19
    //   1303: invokespecial 336	jwf:<init>	(Ljava/lang/String;Lcom/tencent/mobileqq/utils/JumpAction;)V
    //   1306: invokevirtual 337	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1309: aload 24
    //   1311: aload 20
    //   1313: invokevirtual 341	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1316: aload 24
    //   1318: invokevirtual 345	android/widget/ImageView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   1321: astore 18
    //   1323: iload 17
    //   1325: ifne +77 -> 1402
    //   1328: aload 18
    //   1330: ifnull +72 -> 1402
    //   1333: aload 18
    //   1335: instanceof 177
    //   1338: ifne +11 -> 1349
    //   1341: aload 18
    //   1343: instanceof 347
    //   1346: ifeq +56 -> 1402
    //   1349: aload 18
    //   1351: invokevirtual 353	android/graphics/drawable/Drawable:getIntrinsicWidth	()I
    //   1354: istore_1
    //   1355: aload 18
    //   1357: invokevirtual 356	android/graphics/drawable/Drawable:getIntrinsicHeight	()I
    //   1360: iload_1
    //   1361: if_icmplt +97 -> 1458
    //   1364: bipush 7
    //   1366: istore_1
    //   1367: aload_0
    //   1368: iload_1
    //   1369: invokevirtual 359	android/app/Activity:setRequestedOrientation	(I)V
    //   1372: aload 24
    //   1374: invokevirtual 363	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   1377: astore_0
    //   1378: aload_0
    //   1379: iconst_m1
    //   1380: putfield 368	android/view/ViewGroup$LayoutParams:width	I
    //   1383: aload_0
    //   1384: iconst_m1
    //   1385: putfield 371	android/view/ViewGroup$LayoutParams:height	I
    //   1388: aload 24
    //   1390: aload_0
    //   1391: invokevirtual 375	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1394: aload 24
    //   1396: getstatic 381	android/widget/ImageView$ScaleType:FIT_XY	Landroid/widget/ImageView$ScaleType;
    //   1399: invokevirtual 385	android/widget/ImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   1402: invokestatic 99	java/lang/System:currentTimeMillis	()J
    //   1405: lload 14
    //   1407: lsub
    //   1408: lload 4
    //   1410: lmul
    //   1411: lreturn
    //   1412: ldc2_w 100
    //   1415: lstore 4
    //   1417: goto -342 -> 1075
    //   1420: astore 21
    //   1422: iconst_0
    //   1423: istore 16
    //   1425: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1428: ifeq +14 -> 1442
    //   1431: ldc 142
    //   1433: iconst_2
    //   1434: ldc_w 280
    //   1437: aload 21
    //   1439: invokestatic 283	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1442: aload 21
    //   1444: invokevirtual 284	java/lang/Throwable:printStackTrace	()V
    //   1447: goto -347 -> 1100
    //   1450: ldc_w 387
    //   1453: astore 21
    //   1455: goto -255 -> 1200
    //   1458: bipush 6
    //   1460: istore_1
    //   1461: goto -94 -> 1367
    //   1464: astore_0
    //   1465: aload_0
    //   1466: invokevirtual 284	java/lang/Throwable:printStackTrace	()V
    //   1469: ldc2_w 100
    //   1472: lstore 4
    //   1474: goto -72 -> 1402
    //   1477: astore 22
    //   1479: aload 21
    //   1481: astore 19
    //   1483: aload 22
    //   1485: astore 21
    //   1487: goto -62 -> 1425
    //   1490: iconst_0
    //   1491: istore 17
    //   1493: goto -357 -> 1136
    //   1496: aload 19
    //   1498: astore 21
    //   1500: aload 20
    //   1502: astore 19
    //   1504: aload 21
    //   1506: astore 20
    //   1508: goto -388 -> 1120
    //   1511: aload 19
    //   1513: astore 21
    //   1515: iconst_0
    //   1516: istore 16
    //   1518: aload 20
    //   1520: astore 19
    //   1522: aload 21
    //   1524: astore 20
    //   1526: goto -406 -> 1120
    //   1529: aload 18
    //   1531: astore 22
    //   1533: aload 21
    //   1535: astore 18
    //   1537: aload 20
    //   1539: astore 21
    //   1541: lload 12
    //   1543: lstore 6
    //   1545: lload 10
    //   1547: lstore 8
    //   1549: aload 22
    //   1551: astore 20
    //   1553: goto -779 -> 774
    //   1556: aconst_null
    //   1557: astore 20
    //   1559: ldc 149
    //   1561: astore 18
    //   1563: goto -538 -> 1025
    //   1566: aconst_null
    //   1567: astore 21
    //   1569: aload 19
    //   1571: astore 20
    //   1573: iconst_0
    //   1574: istore 16
    //   1576: ldc 149
    //   1578: astore 18
    //   1580: aload 21
    //   1582: astore 19
    //   1584: goto -464 -> 1120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1587	0	paramActivity	android.app.Activity
    //   481	980	1	i	int
    //   479	22	2	j	int
    //   595	18	3	k	int
    //   161	1312	4	l1	long
    //   39	1505	6	l2	long
    //   153	1395	8	l3	long
    //   496	1050	10	l4	long
    //   493	1049	12	l5	long
    //   34	1372	14	l6	long
    //   1076	499	16	bool1	boolean
    //   1134	358	17	bool2	boolean
    //   87	698	18	localObject1	Object
    //   814	3	18	localNotFoundException	Resources.NotFoundException
    //   821	758	18	localObject2	Object
    //   157	212	19	localObject3	Object
    //   865	20	19	localThrowable1	java.lang.Throwable
    //   1098	485	19	localObject4	Object
    //   111	1461	20	localObject5	Object
    //   84	717	21	localObject6	Object
    //   892	1	21	localException	Exception
    //   909	370	21	localObject7	Object
    //   1420	23	21	localThrowable2	java.lang.Throwable
    //   1453	128	21	localObject8	Object
    //   93	962	22	localObject9	Object
    //   1477	7	22	localThrowable3	java.lang.Throwable
    //   1531	19	22	localObject10	Object
    //   99	664	23	localFile1	File
    //   70	1325	24	localImageView	android.widget.ImageView
    //   81	1192	25	localTextView	android.widget.TextView
    //   414	518	26	str	String
    //   474	30	27	arrayOfFile	File[]
    //   507	242	28	localFile2	File
    //   519	447	29	localObject11	Object
    //   528	133	30	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   45	61	814	android/content/res/Resources$NotFoundException
    //   805	811	814	android/content/res/Resources$NotFoundException
    //   310	328	865	java/lang/Throwable
    //   588	621	892	java/lang/Exception
    //   1046	1067	1420	java/lang/Throwable
    //   1316	1323	1464	java/lang/Throwable
    //   1333	1349	1464	java/lang/Throwable
    //   1349	1364	1464	java/lang/Throwable
    //   1367	1402	1464	java/lang/Throwable
    //   1078	1093	1477	java/lang/Throwable
  }
  
  /* Error */
  private static com.tencent.mobileqq.utils.JumpAction a(File paramFile, android.app.Activity paramActivity)
  {
    // Byte code:
    //   0: new 389	java/io/BufferedReader
    //   3: dup
    //   4: new 391	java/io/InputStreamReader
    //   7: dup
    //   8: new 393	java/io/FileInputStream
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 396	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   16: ldc_w 398
    //   19: invokespecial 401	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   22: invokespecial 404	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   25: astore_0
    //   26: aload_0
    //   27: invokevirtual 407	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   30: ldc_w 409
    //   33: invokevirtual 217	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   36: astore_2
    //   37: aload_2
    //   38: arraylength
    //   39: bipush 7
    //   41: if_icmpne +56 -> 97
    //   44: aload_2
    //   45: iconst_5
    //   46: aaload
    //   47: ldc_w 411
    //   50: invokevirtual 413	java/lang/String:length	()I
    //   53: invokevirtual 239	java/lang/String:substring	(I)Ljava/lang/String;
    //   56: invokestatic 418	com/tencent/mobileqq/utils/httputils/PkgTools:c	(Ljava/lang/String;)Ljava/lang/String;
    //   59: astore_2
    //   60: aload_2
    //   61: ifnull +36 -> 97
    //   64: aload_2
    //   65: invokevirtual 413	java/lang/String:length	()I
    //   68: ifle +29 -> 97
    //   71: getstatic 424	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   74: aconst_null
    //   75: invokevirtual 428	mqq/app/MobileQQ:waitAppRuntime	(Lmqq/app/BaseActivity;)Lmqq/app/AppRuntime;
    //   78: checkcast 430	com/tencent/mobileqq/app/QQAppInterface
    //   81: aload_1
    //   82: aload_2
    //   83: invokestatic 435	com/tencent/mobileqq/utils/JumpParser:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/mobileqq/utils/JumpAction;
    //   86: astore_1
    //   87: aload_0
    //   88: ifnull +7 -> 95
    //   91: aload_0
    //   92: invokevirtual 438	java/io/BufferedReader:close	()V
    //   95: aload_1
    //   96: areturn
    //   97: aload_0
    //   98: ifnull +7 -> 105
    //   101: aload_0
    //   102: invokevirtual 438	java/io/BufferedReader:close	()V
    //   105: aconst_null
    //   106: areturn
    //   107: astore_0
    //   108: aconst_null
    //   109: astore_0
    //   110: aload_0
    //   111: ifnull -6 -> 105
    //   114: aload_0
    //   115: invokevirtual 438	java/io/BufferedReader:close	()V
    //   118: goto -13 -> 105
    //   121: astore_0
    //   122: goto -17 -> 105
    //   125: astore_1
    //   126: aconst_null
    //   127: astore_0
    //   128: aload_0
    //   129: ifnull +7 -> 136
    //   132: aload_0
    //   133: invokevirtual 438	java/io/BufferedReader:close	()V
    //   136: aload_1
    //   137: athrow
    //   138: astore_0
    //   139: aload_1
    //   140: areturn
    //   141: astore_0
    //   142: goto -37 -> 105
    //   145: astore_0
    //   146: goto -10 -> 136
    //   149: astore_1
    //   150: goto -22 -> 128
    //   153: astore_1
    //   154: goto -44 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	paramFile	File
    //   0	157	1	paramActivity	android.app.Activity
    //   36	47	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	26	107	java/lang/Exception
    //   114	118	121	java/lang/Exception
    //   0	26	125	finally
    //   91	95	138	java/lang/Exception
    //   101	105	141	java/lang/Exception
    //   132	136	145	java/lang/Exception
    //   26	60	149	finally
    //   64	87	149	finally
    //   26	60	153	java/lang/Exception
    //   64	87	153	java/lang/Exception
  }
  
  private static void a()
  {
    ThreadManager.a().postDelayed(new jwg(), 5000L);
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    if ((paramLong1 == 0L) || (paramLong2 == 0L)) {}
    long l;
    do
    {
      return false;
      l = System.currentTimeMillis();
    } while ((l < paramLong1) || (l > paramLong2));
    return true;
  }
  
  public static boolean b()
  {
    long l1 = BaseApplicationImpl.a().getSharedPreferences("banner_and_splash", 0).getLong("splashshowtime", 0L);
    long l2 = System.currentTimeMillis();
    if ((l2 > l1) && (l2 <= 86400000L + l1)) {
      return false;
    }
    if (l2 > l1 + 86400000L)
    {
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
      Object localObject1 = localBaseApplicationImpl.getFilesDir();
      int j;
      long l4;
      long l3;
      int i;
      if (localObject1 != null)
      {
        localObject1 = ((File)localObject1).getAbsolutePath();
        localObject2 = new File((String)localObject1 + "/splashpic");
        if ((localObject2 != null) && (((File)localObject2).exists()) && (((File)localObject2).isDirectory()))
        {
          localObject2 = ((File)localObject2).listFiles();
          if (localObject2 != null)
          {
            j = localObject2.length;
            l4 = 0L;
            l3 = 0L;
            i = 0;
          }
        }
      }
      else
      {
        for (;;)
        {
          long l5;
          long l6;
          for (;;)
          {
            if (i >= j) {
              break label338;
            }
            Object localObject3 = localObject2[i];
            l5 = l4;
            l6 = l3;
            if (localObject3 != null)
            {
              localObject3 = ((File)localObject3).getName().split("_");
              l5 = l4;
              l6 = l3;
              if (localObject3 != null)
              {
                l5 = l4;
                l6 = l3;
                if (localObject3.length == 3)
                {
                  localObject3 = localObject3[0];
                  l1 = l4;
                  l2 = l3;
                  if (localObject3 != null)
                  {
                    l1 = l4;
                    l2 = l3;
                    if (((String)localObject3).trim().equals("")) {}
                  }
                  try
                  {
                    int k = ((String)localObject3).indexOf("|");
                    l2 = Long.parseLong(((String)localObject3).substring(0, k));
                    l1 = Long.parseLong(((String)localObject3).substring(k + 1));
                    l5 = l1;
                    l6 = l2;
                    if (a(l2, l1))
                    {
                      return true;
                      localObject1 = "/data/data/com.tencent.minihd.qq/files";
                    }
                  }
                  catch (Exception localException)
                  {
                    for (;;)
                    {
                      l2 = 0L;
                      l1 = 0L;
                    }
                  }
                }
              }
            }
          }
          i += 1;
          l4 = l5;
          l3 = l6;
        }
      }
      label338:
      Object localObject2 = SharedPreUtils.b(BaseApplicationImpl.getContext());
      if (QLog.isColorLevel()) {
        QLog.i("SetSplash", 2, "bir = " + (String)localObject2);
      }
      if ((!((String)localObject2).equals("")) && (a(System.currentTimeMillis(), (String)localObject2) == 0))
      {
        localObject1 = new File((String)localObject1 + "/" + SharedPreUtils.a(localBaseApplicationImpl) + "/" + "birthdayflashlogo.png");
        if ((localObject1 != null) && (((File)localObject1).exists()) && (((File)localObject1).length() > 1L)) {
          return true;
        }
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SetSplash", 2, "now time less than last show time , something is worng");
    }
    return false;
  }
  
  protected boolean a()
  {
    AppActivity localAppActivity = this.a.a;
    try
    {
      boolean bool = localAppActivity.showPreview();
      if (bool) {
        return true;
      }
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SetSplash", 2, "doStep fail init activity preview:" + localNotFoundException.getMessage());
      }
      long l = a(localAppActivity);
      if (l > 0L)
      {
        BaseApplicationImpl.jdField_a_of_type_Long = 0L;
        BaseApplicationImpl.b = 0L;
        BaseApplicationImpl.c = 0L;
        this.a.c = 0L;
      }
      this.a.b = l;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.SetSplash
 * JD-Core Version:    0.7.0.1
 */