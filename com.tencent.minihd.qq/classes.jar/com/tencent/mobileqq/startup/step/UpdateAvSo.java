package com.tencent.mobileqq.startup.step;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class UpdateAvSo
  extends Step
{
  private static final String a = "so_sp";
  private static final String c = "AVModuleExtract";
  private static final String d = "key_so_version_";
  private static final String e = "first_qq_lauch_";
  private static final String f = "first_av_lauch_";
  
  public static long a()
  {
    long l = SystemClock.uptimeMillis();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.a.getSharedPreferences("so_sp", 0);
    if (localSharedPreferences.getLong("first_av_lauch_2cb8ec", 0L) != 0L) {
      return 0L;
    }
    localSharedPreferences.edit().putLong("first_av_lauch_2cb8ec", l).commit();
    return l - b();
  }
  
  public static String a()
  {
    File localFile = BaseApplicationImpl.a.getFilesDir();
    if (localFile == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AVModuleExtract", 2, "getFilesDir is null");
      }
      return "";
    }
    return localFile.getParent() + "/txlib/";
  }
  
  private static String a(String paramString)
  {
    return "lib" + paramString + ".so";
  }
  
  public static void a()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.a;
    c(localBaseApplicationImpl, "VideoCtrl");
    c(localBaseApplicationImpl, "qq_sharp");
    c(localBaseApplicationImpl, "traeimp-armeabi-v7a");
    c(localBaseApplicationImpl, "qav_graphics");
    c(localBaseApplicationImpl, "qav_gaudio_engine");
  }
  
  public static boolean a(Context paramContext)
  {
    return (b(paramContext, "qq_vqq")) && (b(paramContext, "TcHevcEnc")) && (b(paramContext, "TcVp8Codec"));
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVModuleExtract", 2, "start LoadExtractedSo: " + paramString);
    }
    try
    {
      System.load(paramContext.getFilesDir().getParent() + "/txlib/" + a(paramString));
      bool = true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
    {
      for (;;)
      {
        boolean bool;
        HashMap localHashMap;
        c(paramContext, paramString);
        try
        {
          System.load(paramContext.getFilesDir().getParent() + "/txlib/" + a(paramString));
          bool = true;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
        {
          bool = false;
        }
      }
    }
    if (!bool)
    {
      QLog.e("AVModuleExtract", 1, "LoadExtractedSo failed: " + paramString);
      localHashMap = new HashMap();
      localHashMap.put("soname", paramString);
      StatisticCollector.a(paramContext).a("", "AV_LOAD_SO_FAILED", false, 0L, 0L, localHashMap, "");
    }
    return bool;
  }
  
  private static long b()
  {
    long l2 = BaseApplicationImpl.a.getSharedPreferences("so_sp", 0).getLong("first_qq_lauch_2cb8ec", 0L);
    long l1 = l2;
    if (l2 == 0L) {
      l1 = BaseApplicationImpl.c;
    }
    return l1;
  }
  
  private static String b()
  {
    return "lib/armeabi/";
  }
  
  private static void b()
  {
    Object localObject = BaseApplicationImpl.a.getSharedPreferences("so_sp", 0);
    if (QLog.isColorLevel()) {
      QLog.d("AVModuleExtract", 2, "setQQFirstLauchTime:" + BaseApplicationImpl.c);
    }
    localObject = ((SharedPreferences)localObject).edit();
    if (BaseApplicationImpl.c > 0L) {}
    for (long l = BaseApplicationImpl.c;; l = SystemClock.uptimeMillis())
    {
      ((SharedPreferences.Editor)localObject).putLong("first_qq_lauch_2cb8ec", l).commit();
      return;
    }
  }
  
  public static boolean b(Context paramContext)
  {
    return (b(paramContext, "TcHevcDec")) && (b(paramContext, "TcVpxDec")) && (b(paramContext, "TcVpxEnc"));
  }
  
  @TargetApi(9)
  public static boolean b(Context paramContext, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 9) {}
    for (paramContext = paramContext.getApplicationInfo().nativeLibraryDir + "/";; paramContext = paramContext.getApplicationInfo().dataDir + "/lib/")
    {
      paramContext = new File(paramContext + a(paramString));
      File localFile = new File(a() + a(paramString));
      if ((!paramContext.exists()) && (!localFile.exists())) {
        break;
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.e("AVModuleExtract", 2, "fail to find so:" + paramString);
    }
    return false;
  }
  
  /* Error */
  public static boolean c(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 8
    //   3: iconst_0
    //   4: invokevirtual 42	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   7: astore 30
    //   9: ldc 227
    //   11: invokestatic 233	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   14: invokevirtual 237	java/lang/Integer:intValue	()I
    //   17: istore_2
    //   18: new 87	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   25: ldc 14
    //   27: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_1
    //   31: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: astore 31
    //   39: ldc 85
    //   41: astore 23
    //   43: aload 30
    //   45: aload 31
    //   47: iconst_m1
    //   48: invokeinterface 241 3 0
    //   53: istore_3
    //   54: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   57: ifeq +46 -> 103
    //   60: ldc 11
    //   62: iconst_2
    //   63: new 87	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   70: ldc 243
    //   72: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_1
    //   76: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: ldc 245
    //   81: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: iload_3
    //   85: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   88: ldc 250
    //   90: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: iload_2
    //   94: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   97: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 83	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: invokestatic 208	com/tencent/mobileqq/startup/step/UpdateAvSo:a	()Ljava/lang/String;
    //   106: astore 33
    //   108: aload 33
    //   110: invokestatic 256	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   113: ifeq +16 -> 129
    //   116: iconst_0
    //   117: istore 4
    //   119: iload 4
    //   121: ireturn
    //   122: astore 12
    //   124: iconst_0
    //   125: istore_2
    //   126: goto -108 -> 18
    //   129: new 90	java/io/File
    //   132: dup
    //   133: new 87	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   140: aload 33
    //   142: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload_1
    //   146: invokestatic 135	com/tencent/mobileqq/startup/step/UpdateAvSo:a	(Ljava/lang/String;)Ljava/lang/String;
    //   149: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokespecial 206	java/io/File:<init>	(Ljava/lang/String;)V
    //   158: astore 32
    //   160: iload_3
    //   161: iload_2
    //   162: if_icmpne +13 -> 175
    //   165: aload 32
    //   167: invokevirtual 211	java/io/File:exists	()Z
    //   170: ifeq +5 -> 175
    //   173: iconst_1
    //   174: ireturn
    //   175: invokestatic 31	android/os/SystemClock:uptimeMillis	()J
    //   178: lstore 10
    //   180: aload 32
    //   182: invokevirtual 259	java/io/File:delete	()Z
    //   185: pop
    //   186: aload 32
    //   188: invokevirtual 211	java/io/File:exists	()Z
    //   191: ifne +1193 -> 1384
    //   194: aload_0
    //   195: invokevirtual 263	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   198: pop
    //   199: aconst_null
    //   200: astore 24
    //   202: aconst_null
    //   203: astore 25
    //   205: aconst_null
    //   206: astore 22
    //   208: aconst_null
    //   209: astore 26
    //   211: aconst_null
    //   212: astore 29
    //   214: aconst_null
    //   215: astore 21
    //   217: aconst_null
    //   218: astore 12
    //   220: aconst_null
    //   221: astore 27
    //   223: aconst_null
    //   224: astore 28
    //   226: aconst_null
    //   227: astore 20
    //   229: aconst_null
    //   230: astore 13
    //   232: aload 27
    //   234: astore 17
    //   236: aload 12
    //   238: astore 15
    //   240: aload 24
    //   242: astore 19
    //   244: aload 28
    //   246: astore 16
    //   248: aload 29
    //   250: astore 14
    //   252: aload 25
    //   254: astore 18
    //   256: new 90	java/io/File
    //   259: dup
    //   260: aload 33
    //   262: invokespecial 206	java/io/File:<init>	(Ljava/lang/String;)V
    //   265: astore 34
    //   267: aload 27
    //   269: astore 17
    //   271: aload 12
    //   273: astore 15
    //   275: aload 24
    //   277: astore 19
    //   279: aload 28
    //   281: astore 16
    //   283: aload 29
    //   285: astore 14
    //   287: aload 25
    //   289: astore 18
    //   291: aload 34
    //   293: invokevirtual 211	java/io/File:exists	()Z
    //   296: ifne +39 -> 335
    //   299: aload 27
    //   301: astore 17
    //   303: aload 12
    //   305: astore 15
    //   307: aload 24
    //   309: astore 19
    //   311: aload 28
    //   313: astore 16
    //   315: aload 29
    //   317: astore 14
    //   319: aload 25
    //   321: astore 18
    //   323: aload 34
    //   325: invokevirtual 266	java/io/File:mkdir	()Z
    //   328: istore 4
    //   330: iload 4
    //   332: ifeq +1035 -> 1367
    //   335: aload 27
    //   337: astore 17
    //   339: aload 12
    //   341: astore 15
    //   343: aload 24
    //   345: astore 19
    //   347: aload 28
    //   349: astore 16
    //   351: aload 29
    //   353: astore 14
    //   355: aload 25
    //   357: astore 18
    //   359: aload_0
    //   360: invokevirtual 263	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   363: new 87	java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   370: invokestatic 268	com/tencent/mobileqq/startup/step/UpdateAvSo:b	()Ljava/lang/String;
    //   373: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: aload_1
    //   377: invokestatic 135	com/tencent/mobileqq/startup/step/UpdateAvSo:a	(Ljava/lang/String;)Ljava/lang/String;
    //   380: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   386: invokevirtual 274	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   389: astore 12
    //   391: aload 26
    //   393: astore_0
    //   394: aload 12
    //   396: ifnull +58 -> 454
    //   399: aload 13
    //   401: astore 17
    //   403: aload 12
    //   405: astore 15
    //   407: aload 24
    //   409: astore 19
    //   411: aload 13
    //   413: astore 16
    //   415: aload 12
    //   417: astore 14
    //   419: aload 25
    //   421: astore 18
    //   423: new 276	java/io/FileOutputStream
    //   426: dup
    //   427: new 87	java/lang/StringBuilder
    //   430: dup
    //   431: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   434: aload 33
    //   436: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: aload_1
    //   440: invokestatic 135	com/tencent/mobileqq/startup/step/UpdateAvSo:a	(Ljava/lang/String;)Ljava/lang/String;
    //   443: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   449: iconst_1
    //   450: invokespecial 279	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   453: astore_0
    //   454: lconst_0
    //   455: lstore 6
    //   457: aload 13
    //   459: astore 17
    //   461: aload 12
    //   463: astore 15
    //   465: aload_0
    //   466: astore 19
    //   468: aload 13
    //   470: astore 16
    //   472: aload 12
    //   474: astore 14
    //   476: aload_0
    //   477: astore 18
    //   479: sipush 2048
    //   482: newarray byte
    //   484: astore 20
    //   486: lload 6
    //   488: lstore 8
    //   490: aload 12
    //   492: ifnull +226 -> 718
    //   495: aload 13
    //   497: astore 17
    //   499: aload 12
    //   501: astore 15
    //   503: aload_0
    //   504: astore 19
    //   506: aload 13
    //   508: astore 16
    //   510: aload 12
    //   512: astore 14
    //   514: aload_0
    //   515: astore 18
    //   517: aload 12
    //   519: aload 20
    //   521: iconst_0
    //   522: aload 20
    //   524: arraylength
    //   525: invokevirtual 285	java/io/InputStream:read	([BII)I
    //   528: istore_3
    //   529: lload 6
    //   531: lstore 8
    //   533: iload_3
    //   534: iconst_m1
    //   535: if_icmpeq +183 -> 718
    //   538: aload 13
    //   540: astore 17
    //   542: aload 12
    //   544: astore 15
    //   546: aload_0
    //   547: astore 19
    //   549: aload 13
    //   551: astore 16
    //   553: aload 12
    //   555: astore 14
    //   557: aload_0
    //   558: astore 18
    //   560: aload_0
    //   561: aload 20
    //   563: iconst_0
    //   564: iload_3
    //   565: invokevirtual 291	java/io/OutputStream:write	([BII)V
    //   568: lload 6
    //   570: iload_3
    //   571: i2l
    //   572: ladd
    //   573: lstore 6
    //   575: goto -89 -> 486
    //   578: astore 12
    //   580: aconst_null
    //   581: astore 14
    //   583: aconst_null
    //   584: astore 15
    //   586: aload 27
    //   588: astore 17
    //   590: aload 24
    //   592: astore 19
    //   594: aload 28
    //   596: astore 16
    //   598: aload 25
    //   600: astore 18
    //   602: aload_0
    //   603: invokevirtual 263	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   606: new 87	java/lang/StringBuilder
    //   609: dup
    //   610: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   613: invokestatic 268	com/tencent/mobileqq/startup/step/UpdateAvSo:b	()Ljava/lang/String;
    //   616: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: aload_1
    //   620: invokestatic 135	com/tencent/mobileqq/startup/step/UpdateAvSo:a	(Ljava/lang/String;)Ljava/lang/String;
    //   623: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: ldc_w 293
    //   629: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   635: invokevirtual 274	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   638: astore 20
    //   640: aload 20
    //   642: astore 12
    //   644: aload 20
    //   646: ifnull -255 -> 391
    //   649: aload 27
    //   651: astore 17
    //   653: aload 20
    //   655: astore 15
    //   657: aload 24
    //   659: astore 19
    //   661: aload 28
    //   663: astore 16
    //   665: aload 20
    //   667: astore 14
    //   669: aload 25
    //   671: astore 18
    //   673: aload_0
    //   674: invokevirtual 263	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   677: new 87	java/lang/StringBuilder
    //   680: dup
    //   681: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   684: invokestatic 268	com/tencent/mobileqq/startup/step/UpdateAvSo:b	()Ljava/lang/String;
    //   687: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   690: aload_1
    //   691: invokestatic 135	com/tencent/mobileqq/startup/step/UpdateAvSo:a	(Ljava/lang/String;)Ljava/lang/String;
    //   694: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: ldc_w 295
    //   700: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   703: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   706: invokevirtual 274	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   709: astore 13
    //   711: aload 20
    //   713: astore 12
    //   715: goto -324 -> 391
    //   718: aload 13
    //   720: ifnull +82 -> 802
    //   723: aload 13
    //   725: astore 17
    //   727: aload 12
    //   729: astore 15
    //   731: aload_0
    //   732: astore 19
    //   734: aload 13
    //   736: astore 16
    //   738: aload 12
    //   740: astore 14
    //   742: aload_0
    //   743: astore 18
    //   745: aload 13
    //   747: aload 20
    //   749: iconst_0
    //   750: aload 20
    //   752: arraylength
    //   753: invokevirtual 285	java/io/InputStream:read	([BII)I
    //   756: istore_3
    //   757: iload_3
    //   758: iconst_m1
    //   759: if_icmpeq +43 -> 802
    //   762: aload 13
    //   764: astore 17
    //   766: aload 12
    //   768: astore 15
    //   770: aload_0
    //   771: astore 19
    //   773: aload 13
    //   775: astore 16
    //   777: aload 12
    //   779: astore 14
    //   781: aload_0
    //   782: astore 18
    //   784: aload_0
    //   785: aload 20
    //   787: iconst_0
    //   788: iload_3
    //   789: invokevirtual 291	java/io/OutputStream:write	([BII)V
    //   792: lload 8
    //   794: iload_3
    //   795: i2l
    //   796: ladd
    //   797: lstore 8
    //   799: goto -81 -> 718
    //   802: aload 13
    //   804: astore 17
    //   806: aload 12
    //   808: astore 15
    //   810: aload_0
    //   811: astore 19
    //   813: aload 13
    //   815: astore 16
    //   817: aload 12
    //   819: astore 14
    //   821: aload_0
    //   822: astore 18
    //   824: aload 13
    //   826: astore 20
    //   828: aload 12
    //   830: astore 21
    //   832: aload_0
    //   833: astore 22
    //   835: aload 32
    //   837: invokevirtual 211	java/io/File:exists	()Z
    //   840: ifeq +527 -> 1367
    //   843: aload 13
    //   845: astore 17
    //   847: aload 12
    //   849: astore 15
    //   851: aload_0
    //   852: astore 19
    //   854: aload 13
    //   856: astore 16
    //   858: aload 12
    //   860: astore 14
    //   862: aload_0
    //   863: astore 18
    //   865: lload 8
    //   867: aload 32
    //   869: invokevirtual 298	java/io/File:length	()J
    //   872: lcmp
    //   873: ifeq +209 -> 1082
    //   876: aload 13
    //   878: astore 17
    //   880: aload 12
    //   882: astore 15
    //   884: aload_0
    //   885: astore 19
    //   887: aload 13
    //   889: astore 16
    //   891: aload 12
    //   893: astore 14
    //   895: aload_0
    //   896: astore 18
    //   898: aload 32
    //   900: invokevirtual 259	java/io/File:delete	()Z
    //   903: pop
    //   904: aload 13
    //   906: astore 17
    //   908: aload 12
    //   910: astore 15
    //   912: aload_0
    //   913: astore 19
    //   915: aload 13
    //   917: astore 16
    //   919: aload 12
    //   921: astore 14
    //   923: aload_0
    //   924: astore 18
    //   926: new 87	java/lang/StringBuilder
    //   929: dup
    //   930: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   933: ldc 85
    //   935: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   938: ldc_w 300
    //   941: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   944: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   947: astore 20
    //   949: aload 13
    //   951: astore 16
    //   953: aload 12
    //   955: astore 14
    //   957: aload_0
    //   958: astore 18
    //   960: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   963: ifeq +398 -> 1361
    //   966: aload 13
    //   968: astore 16
    //   970: aload 12
    //   972: astore 14
    //   974: aload_0
    //   975: astore 18
    //   977: ldc 11
    //   979: iconst_2
    //   980: aload 20
    //   982: invokestatic 178	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   985: iconst_0
    //   986: istore 4
    //   988: aload_0
    //   989: ifnull +7 -> 996
    //   992: aload_0
    //   993: invokevirtual 303	java/io/OutputStream:close	()V
    //   996: aload 12
    //   998: ifnull +8 -> 1006
    //   1001: aload 12
    //   1003: invokevirtual 304	java/io/InputStream:close	()V
    //   1006: iload 4
    //   1008: istore 5
    //   1010: aload 13
    //   1012: ifnull +12 -> 1024
    //   1015: aload 13
    //   1017: invokevirtual 304	java/io/InputStream:close	()V
    //   1020: iload 4
    //   1022: istore 5
    //   1024: invokestatic 31	android/os/SystemClock:uptimeMillis	()J
    //   1027: lstore 6
    //   1029: iload 5
    //   1031: istore 4
    //   1033: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1036: ifeq -917 -> 119
    //   1039: ldc 11
    //   1041: iconst_2
    //   1042: new 87	java/lang/StringBuilder
    //   1045: dup
    //   1046: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   1049: ldc_w 306
    //   1052: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1055: aload_1
    //   1056: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1059: ldc_w 308
    //   1062: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1065: lload 6
    //   1067: lload 10
    //   1069: lsub
    //   1070: invokevirtual 176	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1073: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1076: invokestatic 178	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1079: iload 5
    //   1081: ireturn
    //   1082: iload_2
    //   1083: ifne +49 -> 1132
    //   1086: aload 13
    //   1088: astore 17
    //   1090: aload 12
    //   1092: astore 15
    //   1094: aload_0
    //   1095: astore 19
    //   1097: aload 13
    //   1099: astore 16
    //   1101: aload 12
    //   1103: astore 14
    //   1105: aload_0
    //   1106: astore 18
    //   1108: aload 30
    //   1110: invokeinterface 54 1 0
    //   1115: aload 31
    //   1117: iconst_m1
    //   1118: invokeinterface 312 3 0
    //   1123: invokeinterface 64 1 0
    //   1128: pop
    //   1129: goto +261 -> 1390
    //   1132: aload 13
    //   1134: astore 17
    //   1136: aload 12
    //   1138: astore 15
    //   1140: aload_0
    //   1141: astore 19
    //   1143: aload 13
    //   1145: astore 16
    //   1147: aload 12
    //   1149: astore 14
    //   1151: aload_0
    //   1152: astore 18
    //   1154: aload 30
    //   1156: invokeinterface 54 1 0
    //   1161: aload 31
    //   1163: iload_2
    //   1164: invokeinterface 312 3 0
    //   1169: invokeinterface 64 1 0
    //   1174: pop
    //   1175: goto +215 -> 1390
    //   1178: astore 14
    //   1180: aload 23
    //   1182: astore 20
    //   1184: aload 19
    //   1186: astore_0
    //   1187: aload 15
    //   1189: astore 12
    //   1191: aload 17
    //   1193: astore 13
    //   1195: aload 14
    //   1197: astore 15
    //   1199: iconst_0
    //   1200: istore 4
    //   1202: aload 13
    //   1204: astore 16
    //   1206: aload 12
    //   1208: astore 14
    //   1210: aload_0
    //   1211: astore 18
    //   1213: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1216: ifeq +24 -> 1240
    //   1219: aload 13
    //   1221: astore 16
    //   1223: aload 12
    //   1225: astore 14
    //   1227: aload_0
    //   1228: astore 18
    //   1230: ldc 11
    //   1232: iconst_2
    //   1233: aload 20
    //   1235: aload 15
    //   1237: invokestatic 315	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1240: aload_0
    //   1241: ifnull +7 -> 1248
    //   1244: aload_0
    //   1245: invokevirtual 303	java/io/OutputStream:close	()V
    //   1248: aload 12
    //   1250: ifnull +8 -> 1258
    //   1253: aload 12
    //   1255: invokevirtual 304	java/io/InputStream:close	()V
    //   1258: iload 4
    //   1260: istore 5
    //   1262: aload 13
    //   1264: ifnull -240 -> 1024
    //   1267: aload 13
    //   1269: invokevirtual 304	java/io/InputStream:close	()V
    //   1272: iload 4
    //   1274: istore 5
    //   1276: goto -252 -> 1024
    //   1279: astore_0
    //   1280: iload 4
    //   1282: istore 5
    //   1284: goto -260 -> 1024
    //   1287: astore_0
    //   1288: aload 18
    //   1290: ifnull +8 -> 1298
    //   1293: aload 18
    //   1295: invokevirtual 303	java/io/OutputStream:close	()V
    //   1298: aload 14
    //   1300: ifnull +8 -> 1308
    //   1303: aload 14
    //   1305: invokevirtual 304	java/io/InputStream:close	()V
    //   1308: aload 16
    //   1310: ifnull +8 -> 1318
    //   1313: aload 16
    //   1315: invokevirtual 304	java/io/InputStream:close	()V
    //   1318: aload_0
    //   1319: athrow
    //   1320: astore_0
    //   1321: goto -325 -> 996
    //   1324: astore_0
    //   1325: goto -319 -> 1006
    //   1328: astore_0
    //   1329: iload 4
    //   1331: istore 5
    //   1333: goto -309 -> 1024
    //   1336: astore_0
    //   1337: goto -89 -> 1248
    //   1340: astore_0
    //   1341: goto -83 -> 1258
    //   1344: astore_1
    //   1345: goto -47 -> 1298
    //   1348: astore_1
    //   1349: goto -41 -> 1308
    //   1352: astore_1
    //   1353: goto -35 -> 1318
    //   1356: astore 15
    //   1358: goto -159 -> 1199
    //   1361: iconst_0
    //   1362: istore 4
    //   1364: goto -376 -> 988
    //   1367: iconst_0
    //   1368: istore 4
    //   1370: aload 20
    //   1372: astore 13
    //   1374: aload 21
    //   1376: astore 12
    //   1378: aload 22
    //   1380: astore_0
    //   1381: goto -393 -> 988
    //   1384: iconst_0
    //   1385: istore 5
    //   1387: goto -363 -> 1024
    //   1390: iconst_1
    //   1391: istore 4
    //   1393: goto -405 -> 988
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1396	0	paramContext	Context
    //   0	1396	1	paramString	String
    //   17	1147	2	i	int
    //   53	742	3	j	int
    //   117	1275	4	bool1	boolean
    //   1008	378	5	bool2	boolean
    //   455	611	6	l1	long
    //   488	378	8	l2	long
    //   178	890	10	l3	long
    //   122	1	12	localNumberFormatException	java.lang.NumberFormatException
    //   218	336	12	localInputStream	java.io.InputStream
    //   578	1	12	localFileNotFoundException	java.io.FileNotFoundException
    //   642	735	12	localObject1	Object
    //   230	1143	13	localObject2	Object
    //   250	900	14	localObject3	Object
    //   1178	18	14	localIOException1	java.io.IOException
    //   1208	96	14	localObject4	Object
    //   238	998	15	localObject5	Object
    //   1356	1	15	localIOException2	java.io.IOException
    //   246	1068	16	localObject6	Object
    //   234	958	17	localObject7	Object
    //   254	1040	18	localObject8	Object
    //   242	943	19	localObject9	Object
    //   227	1144	20	localObject10	Object
    //   215	1160	21	localObject11	Object
    //   206	1173	22	localContext	Context
    //   41	1140	23	str1	String
    //   200	458	24	localObject12	Object
    //   203	467	25	localObject13	Object
    //   209	183	26	localObject14	Object
    //   221	429	27	localObject15	Object
    //   224	438	28	localObject16	Object
    //   212	140	29	localObject17	Object
    //   7	1148	30	localSharedPreferences	SharedPreferences
    //   37	1125	31	str2	String
    //   158	741	32	localFile1	File
    //   106	329	33	str3	String
    //   265	59	34	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   9	18	122	java/lang/NumberFormatException
    //   359	391	578	java/io/FileNotFoundException
    //   256	267	1178	java/io/IOException
    //   291	299	1178	java/io/IOException
    //   323	330	1178	java/io/IOException
    //   359	391	1178	java/io/IOException
    //   423	454	1178	java/io/IOException
    //   479	486	1178	java/io/IOException
    //   517	529	1178	java/io/IOException
    //   560	568	1178	java/io/IOException
    //   602	640	1178	java/io/IOException
    //   673	711	1178	java/io/IOException
    //   745	757	1178	java/io/IOException
    //   784	792	1178	java/io/IOException
    //   835	843	1178	java/io/IOException
    //   865	876	1178	java/io/IOException
    //   898	904	1178	java/io/IOException
    //   926	949	1178	java/io/IOException
    //   1108	1129	1178	java/io/IOException
    //   1154	1175	1178	java/io/IOException
    //   1267	1272	1279	java/io/IOException
    //   256	267	1287	finally
    //   291	299	1287	finally
    //   323	330	1287	finally
    //   359	391	1287	finally
    //   423	454	1287	finally
    //   479	486	1287	finally
    //   517	529	1287	finally
    //   560	568	1287	finally
    //   602	640	1287	finally
    //   673	711	1287	finally
    //   745	757	1287	finally
    //   784	792	1287	finally
    //   835	843	1287	finally
    //   865	876	1287	finally
    //   898	904	1287	finally
    //   926	949	1287	finally
    //   960	966	1287	finally
    //   977	985	1287	finally
    //   1108	1129	1287	finally
    //   1154	1175	1287	finally
    //   1213	1219	1287	finally
    //   1230	1240	1287	finally
    //   992	996	1320	java/io/IOException
    //   1001	1006	1324	java/io/IOException
    //   1015	1020	1328	java/io/IOException
    //   1244	1248	1336	java/io/IOException
    //   1253	1258	1340	java/io/IOException
    //   1293	1298	1344	java/io/IOException
    //   1303	1308	1348	java/io/IOException
    //   1313	1318	1352	java/io/IOException
    //   960	966	1356	java/io/IOException
    //   977	985	1356	java/io/IOException
  }
  
  protected boolean a()
  {
    a();
    b();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.UpdateAvSo
 * JD-Core Version:    0.7.0.1
 */