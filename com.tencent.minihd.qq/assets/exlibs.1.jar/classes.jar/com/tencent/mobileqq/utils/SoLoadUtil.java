package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SoLoadUtil
{
  private static final int jdField_a_of_type_Int = 5;
  public static final String a = "/txlib/";
  private static SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
  private static Set jdField_a_of_type_JavaUtilSet = new HashSet();
  private static final String b = "SoLoadUtil";
  private static final String c = "so_load_sp";
  private static final String d = "so_sp";
  private static final String e = "key_so_crc";
  private static final String f = "key_so_version_";
  
  static
  {
    jdField_a_of_type_JavaUtilSet.add("libamrnb.so");
    jdField_a_of_type_JavaUtilSet.add("libSync_mq.so");
  }
  
  private static native int Decode(AssetManager paramAssetManager, String paramString1, String paramString2, String paramString3, String paramString4);
  
  private static int a(int paramInt1, int paramInt2)
  {
    return paramInt1 | paramInt2;
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    Object localObject1 = paramContext;
    if (paramContext == null) {
      localObject1 = BaseApplicationImpl.getContext();
    }
    Object localObject2 = ((Context)localObject1).getAssets();
    int i = 0;
    int j = 0;
    try
    {
      paramContext = ((AssetManager)localObject2).openFd(paramString2);
      i = j;
      if (paramContext != null)
      {
        i = 1;
        j = 1;
        paramContext.close();
        i = j;
      }
    }
    catch (IOException paramContext)
    {
      for (;;)
      {
        try
        {
          System.loadLibrary("DecodeSoEx");
          i = Decode(null, paramContext + (String)localObject1, paramString1, "armeabi", paramString3);
          if (Build.VERSION.SDK_INT < 9)
          {
            paramContext = new File(paramContext + (String)localObject1);
            if (paramContext.exists()) {
              paramContext.delete();
            }
          }
          if (i == 0) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("SoLoadUtil", 2, "decode so fail error: " + i);
          }
          return i;
          paramContext = paramContext;
          paramContext.printStackTrace();
          continue;
          ((BufferedOutputStream)localObject2).flush();
          paramString2.close();
          ((BufferedOutputStream)localObject2).close();
          continue;
          j = 8;
        }
        catch (UnsatisfiedLinkError paramString1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SoLoadUtil", 2, "Unsatisfied Link error: " + paramString1.toString() + "abi:" + a());
          }
          i = 2;
          continue;
        }
        label461:
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("SoLoadUtil", 2, "cannot create andorid decode22 file. ");
          i = j;
          continue;
          try
          {
            System.loadLibrary("DecodeSo");
            i = Decode((AssetManager)localObject2, paramString2, paramString1, "armeabi", paramString3);
          }
          catch (UnsatisfiedLinkError paramString1)
          {
            if (QLog.isColorLevel()) {
              QLog.d("SoLoadUtil", 2, "Unsatisfied Link error: " + paramString1.toString() + "abi:" + a());
            }
            i = 2;
          }
        }
      }
    }
    if (i != 0)
    {
      paramContext = new File(paramString1);
      if (!paramContext.exists()) {
        paramContext.mkdir();
      }
      j = 0;
      paramContext = ((Context)localObject1).getFilesDir().getAbsolutePath() + "/";
      localObject1 = paramString2 + Thread.currentThread().getName();
      if (Build.VERSION.SDK_INT < 9) {
        try
        {
          paramString2 = new BufferedInputStream(((AssetManager)localObject2).open(paramString2));
          localObject2 = new BufferedOutputStream(new FileOutputStream(new File(paramContext + (String)localObject1)));
          if ((paramString2 != null) && (localObject2 != null))
          {
            byte[] arrayOfByte = new byte[4096];
            for (;;)
            {
              i = paramString2.read(arrayOfByte);
              if (i == -1) {
                break;
              }
              ((BufferedOutputStream)localObject2).write(arrayOfByte, 0, i);
            }
            if (j != 0) {
              break label461;
            }
          }
        }
        catch (IOException paramString2)
        {
          paramString2.printStackTrace();
          j = 8;
        }
      }
    }
    return 0;
  }
  
  /* Error */
  private static String a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 210	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnull +20 -> 28
    //   11: aload_0
    //   12: ldc 212
    //   14: invokevirtual 218	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   17: ifeq +11 -> 28
    //   20: ldc 212
    //   22: astore_0
    //   23: ldc 2
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: aload_0
    //   29: ifnull +18 -> 47
    //   32: aload_0
    //   33: ldc 220
    //   35: invokevirtual 218	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   38: ifeq +9 -> 47
    //   41: ldc 222
    //   43: astore_0
    //   44: goto -21 -> 23
    //   47: ldc 171
    //   49: astore_0
    //   50: goto -27 -> 23
    //   53: astore_0
    //   54: ldc 2
    //   56: monitorexit
    //   57: aload_0
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	44	0	str	String
    //   53	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	53	finally
    //   11	20	53	finally
    //   32	41	53	finally
  }
  
  private static String a(String paramString)
  {
    return "lib" + paramString + ".so";
  }
  
  private static String a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return "lib/armeabi/";
    }
    return "lib/" + a() + "/";
  }
  
  private static final HashMap a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("osVersion", Build.VERSION.RELEASE);
    localHashMap.put("deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
    localHashMap.put("time", jdField_a_of_type_JavaTextSimpleDateFormat.format(new Date(System.currentTimeMillis())));
    localHashMap.put("libName", paramString);
    return localHashMap;
  }
  
  private static final void a(HashMap paramHashMap)
  {
    StatisticCollector.a(BaseApplication.getContext()).a("", "loadSo", false, 0L, 0L, paramHashMap, "");
  }
  
  private static final void a(HashMap paramHashMap, int paramInt, String paramString, long paramLong)
  {
    paramHashMap.put("message", paramString);
    paramHashMap.put("costTime", paramLong + "");
    StatisticCollector.a(paramHashMap, paramInt);
    a(paramHashMap);
  }
  
  public static boolean a(Context paramContext, String paramString, int paramInt)
  {
    return a(paramContext, paramString, paramInt, false);
  }
  
  /* Error */
  public static boolean a(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 181	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +29 -> 32
    //   6: ldc 15
    //   8: iconst_2
    //   9: new 100	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 316
    //   19: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 189	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: invokestatic 321	android/os/SystemClock:uptimeMillis	()J
    //   35: lstore 13
    //   37: aload_1
    //   38: invokestatic 323	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/util/HashMap;
    //   41: astore 25
    //   43: ldc 243
    //   45: astore 16
    //   47: iconst_0
    //   48: istore 8
    //   50: iconst_0
    //   51: istore 7
    //   53: iconst_0
    //   54: istore_2
    //   55: aload_0
    //   56: astore 15
    //   58: aload_0
    //   59: ifnonnull +8 -> 67
    //   62: invokestatic 71	com/tencent/common/app/BaseApplicationImpl:getContext	()Landroid/content/Context;
    //   65: astore 15
    //   67: new 100	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   74: aload 15
    //   76: invokevirtual 105	android/content/Context:getFilesDir	()Ljava/io/File;
    //   79: invokevirtual 326	java/io/File:getParent	()Ljava/lang/String;
    //   82: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: ldc 10
    //   87: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: astore 29
    //   95: new 100	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   102: aload 15
    //   104: invokevirtual 105	android/content/Context:getFilesDir	()Ljava/io/File;
    //   107: invokevirtual 326	java/io/File:getParent	()Ljava/lang/String;
    //   110: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: ldc_w 328
    //   116: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: astore 17
    //   124: invokestatic 181	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq +12 -> 139
    //   130: ldc 15
    //   132: iconst_2
    //   133: ldc_w 330
    //   136: invokestatic 189	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   139: iload 8
    //   141: istore 6
    //   143: aload 16
    //   145: astore_0
    //   146: iload_3
    //   147: ifeq +144 -> 291
    //   150: new 90	java/io/File
    //   153: dup
    //   154: new 100	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   161: aload 17
    //   163: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: aload_1
    //   167: invokestatic 332	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   170: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   179: astore_0
    //   180: aload_0
    //   181: invokevirtual 95	java/io/File:exists	()Z
    //   184: ifeq +858 -> 1042
    //   187: iload 7
    //   189: istore_3
    //   190: aload_0
    //   191: invokevirtual 109	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   194: invokestatic 335	java/lang/System:load	(Ljava/lang/String;)V
    //   197: iconst_1
    //   198: istore_3
    //   199: iconst_1
    //   200: istore 6
    //   202: aload 25
    //   204: iconst_0
    //   205: ldc 243
    //   207: invokestatic 321	android/os/SystemClock:uptimeMillis	()J
    //   210: lload 13
    //   212: lsub
    //   213: invokestatic 337	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/util/HashMap;ILjava/lang/String;J)V
    //   216: iload 6
    //   218: istore_3
    //   219: iload_3
    //   220: ireturn
    //   221: astore_0
    //   222: new 100	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   229: ldc 243
    //   231: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: ldc_w 339
    //   237: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: aload_0
    //   241: invokestatic 343	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   244: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: astore 16
    //   252: iconst_0
    //   253: iconst_2
    //   254: invokestatic 345	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   257: istore 4
    //   259: iload 4
    //   261: istore_2
    //   262: iload_3
    //   263: istore 6
    //   265: aload 16
    //   267: astore_0
    //   268: invokestatic 181	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   271: ifeq +20 -> 291
    //   274: ldc 15
    //   276: iconst_2
    //   277: aload 16
    //   279: invokestatic 189	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   282: aload 16
    //   284: astore_0
    //   285: iload_3
    //   286: istore 6
    //   288: iload 4
    //   290: istore_2
    //   291: new 90	java/io/File
    //   294: dup
    //   295: new 100	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   302: aload 29
    //   304: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: aload_1
    //   308: invokestatic 332	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   311: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   320: astore 26
    //   322: ldc_w 347
    //   325: invokestatic 353	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   328: invokevirtual 357	java/lang/Integer:intValue	()I
    //   331: istore 4
    //   333: new 100	java/lang/StringBuilder
    //   336: dup
    //   337: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   340: ldc 27
    //   342: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: aload_1
    //   346: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: astore 16
    //   354: new 100	java/lang/StringBuilder
    //   357: dup
    //   358: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   361: ldc 24
    //   363: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: aload_1
    //   367: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: astore 27
    //   375: aload 15
    //   377: ldc 21
    //   379: iconst_0
    //   380: invokevirtual 361	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   383: astore 28
    //   385: aload 28
    //   387: aload 16
    //   389: iconst_m1
    //   390: invokeinterface 367 3 0
    //   395: istore 5
    //   397: invokestatic 181	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   400: ifeq +51 -> 451
    //   403: ldc 15
    //   405: iconst_2
    //   406: new 100	java/lang/StringBuilder
    //   409: dup
    //   410: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   413: ldc_w 369
    //   416: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: aload_1
    //   420: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: ldc_w 371
    //   426: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: iload 5
    //   431: invokevirtual 186	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   434: ldc_w 373
    //   437: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: iload 4
    //   442: invokevirtual 186	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   445: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   448: invokestatic 189	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   451: iload 5
    //   453: iload 4
    //   455: if_icmpeq +43 -> 498
    //   458: aload 26
    //   460: invokevirtual 95	java/io/File:exists	()Z
    //   463: ifeq +9 -> 472
    //   466: aload 26
    //   468: invokevirtual 176	java/io/File:delete	()Z
    //   471: pop
    //   472: iload 4
    //   474: ifne +643 -> 1117
    //   477: aload 28
    //   479: invokeinterface 377 1 0
    //   484: aload 16
    //   486: iconst_m1
    //   487: invokeinterface 383 3 0
    //   492: invokeinterface 386 1 0
    //   497: pop
    //   498: invokestatic 181	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   501: ifeq +12 -> 513
    //   504: ldc 15
    //   506: iconst_2
    //   507: ldc_w 388
    //   510: invokestatic 189	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   513: invokestatic 181	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   516: ifeq +29 -> 545
    //   519: ldc 15
    //   521: iconst_2
    //   522: new 100	java/lang/StringBuilder
    //   525: dup
    //   526: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   529: ldc_w 390
    //   532: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: iconst_0
    //   536: invokevirtual 393	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   539: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   542: invokestatic 189	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   545: aload 26
    //   547: invokevirtual 95	java/io/File:exists	()Z
    //   550: ifne +1211 -> 1761
    //   553: aconst_null
    //   554: astore 20
    //   556: aconst_null
    //   557: astore 19
    //   559: aconst_null
    //   560: astore 23
    //   562: aconst_null
    //   563: astore 21
    //   565: aconst_null
    //   566: astore 22
    //   568: aconst_null
    //   569: astore 24
    //   571: ldc2_w 394
    //   574: lstore 11
    //   576: aload 21
    //   578: astore 18
    //   580: aload 22
    //   582: astore 16
    //   584: aload 19
    //   586: astore 17
    //   588: new 90	java/io/File
    //   591: dup
    //   592: aload 29
    //   594: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   597: astore 30
    //   599: aload 21
    //   601: astore 18
    //   603: aload 22
    //   605: astore 16
    //   607: aload 19
    //   609: astore 17
    //   611: aload 30
    //   613: invokevirtual 95	java/io/File:exists	()Z
    //   616: ifne +37 -> 653
    //   619: aload 21
    //   621: astore 18
    //   623: aload 22
    //   625: astore 16
    //   627: aload 19
    //   629: astore 17
    //   631: aload 30
    //   633: invokevirtual 98	java/io/File:mkdir	()Z
    //   636: istore_3
    //   637: lload 11
    //   639: lstore 9
    //   641: aload 24
    //   643: astore 17
    //   645: aload 23
    //   647: astore 16
    //   649: iload_3
    //   650: ifeq +113 -> 763
    //   653: aload 21
    //   655: astore 18
    //   657: aload 22
    //   659: astore 16
    //   661: aload 19
    //   663: astore 17
    //   665: aload 15
    //   667: invokevirtual 77	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   670: new 100	java/lang/StringBuilder
    //   673: dup
    //   674: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   677: iconst_0
    //   678: invokestatic 397	com/tencent/mobileqq/utils/SoLoadUtil:a	(Z)Ljava/lang/String;
    //   681: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: aload_1
    //   685: invokestatic 332	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   688: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   694: invokevirtual 138	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   697: astore 23
    //   699: aload 23
    //   701: astore 15
    //   703: aload 15
    //   705: astore 18
    //   707: aload 15
    //   709: astore 16
    //   711: aload 19
    //   713: astore 17
    //   715: new 145	java/io/FileOutputStream
    //   718: dup
    //   719: new 100	java/lang/StringBuilder
    //   722: dup
    //   723: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   726: aload 29
    //   728: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: aload_1
    //   732: invokestatic 332	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   735: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   741: invokespecial 398	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   744: astore 19
    //   746: aload 15
    //   748: aload 19
    //   750: invokestatic 403	com/tencent/mobileqq/app/InjectUtils:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   753: lstore 9
    //   755: aload 19
    //   757: astore 16
    //   759: aload 15
    //   761: astore 17
    //   763: aload 16
    //   765: ifnull +8 -> 773
    //   768: aload 16
    //   770: invokevirtual 406	java/io/OutputStream:close	()V
    //   773: iload_2
    //   774: istore 4
    //   776: aload_0
    //   777: astore 16
    //   779: lload 9
    //   781: lstore 11
    //   783: aload 17
    //   785: ifnull +966 -> 1751
    //   788: aload 17
    //   790: invokevirtual 409	java/io/InputStream:close	()V
    //   793: iload_2
    //   794: istore 4
    //   796: invokestatic 181	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   799: ifeq +12 -> 811
    //   802: ldc 15
    //   804: iconst_2
    //   805: ldc_w 411
    //   808: invokestatic 189	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   811: iload 4
    //   813: istore_2
    //   814: aload_0
    //   815: astore 15
    //   817: aload 26
    //   819: invokevirtual 95	java/io/File:exists	()Z
    //   822: ifeq +75 -> 897
    //   825: lload 9
    //   827: aload 26
    //   829: invokevirtual 414	java/io/File:length	()J
    //   832: lcmp
    //   833: ifeq +540 -> 1373
    //   836: aload 26
    //   838: invokevirtual 176	java/io/File:delete	()Z
    //   841: pop
    //   842: new 100	java/lang/StringBuilder
    //   845: dup
    //   846: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   849: aload_0
    //   850: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   853: ldc_w 416
    //   856: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   862: astore_0
    //   863: iload 4
    //   865: bipush 8
    //   867: invokestatic 345	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   870: istore 4
    //   872: iload 4
    //   874: istore_2
    //   875: aload_0
    //   876: astore 15
    //   878: invokestatic 181	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   881: ifeq +16 -> 897
    //   884: ldc 15
    //   886: iconst_2
    //   887: aload_0
    //   888: invokestatic 189	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   891: aload_0
    //   892: astore 15
    //   894: iload 4
    //   896: istore_2
    //   897: invokestatic 181	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   900: ifeq +12 -> 912
    //   903: ldc 15
    //   905: iconst_2
    //   906: ldc_w 418
    //   909: invokestatic 189	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   912: aload 26
    //   914: invokevirtual 95	java/io/File:exists	()Z
    //   917: ifeq +825 -> 1742
    //   920: aload 26
    //   922: invokevirtual 109	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   925: invokestatic 335	java/lang/System:load	(Ljava/lang/String;)V
    //   928: iconst_1
    //   929: istore_3
    //   930: aload 15
    //   932: astore_0
    //   933: iload_2
    //   934: istore 4
    //   936: iload_3
    //   937: istore 6
    //   939: aload_0
    //   940: astore 15
    //   942: iload_3
    //   943: ifne +31 -> 974
    //   946: invokestatic 181	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   949: ifeq +12 -> 961
    //   952: ldc 15
    //   954: iconst_2
    //   955: ldc_w 420
    //   958: invokestatic 189	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   961: aload_1
    //   962: invokestatic 169	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   965: iconst_1
    //   966: istore 6
    //   968: aload_0
    //   969: astore 15
    //   971: iload_2
    //   972: istore 4
    //   974: invokestatic 321	android/os/SystemClock:uptimeMillis	()J
    //   977: lload 13
    //   979: lsub
    //   980: lstore 9
    //   982: aload 25
    //   984: iload 4
    //   986: aload 15
    //   988: lload 9
    //   990: invokestatic 337	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/util/HashMap;ILjava/lang/String;J)V
    //   993: iload 6
    //   995: istore_3
    //   996: invokestatic 181	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   999: ifeq -780 -> 219
    //   1002: ldc 15
    //   1004: iconst_2
    //   1005: new 100	java/lang/StringBuilder
    //   1008: dup
    //   1009: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   1012: ldc_w 422
    //   1015: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1018: aload_1
    //   1019: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1022: ldc_w 424
    //   1025: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1028: lload 9
    //   1030: invokevirtual 301	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1033: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1036: invokestatic 189	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1039: iload 6
    //   1041: ireturn
    //   1042: new 100	java/lang/StringBuilder
    //   1045: dup
    //   1046: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   1049: ldc 243
    //   1051: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1054: ldc_w 426
    //   1057: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1060: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1063: astore 16
    //   1065: iconst_0
    //   1066: iconst_4
    //   1067: invokestatic 345	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   1070: istore 4
    //   1072: iload 4
    //   1074: istore_2
    //   1075: iload 8
    //   1077: istore 6
    //   1079: aload 16
    //   1081: astore_0
    //   1082: invokestatic 181	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1085: ifeq -794 -> 291
    //   1088: ldc 15
    //   1090: iconst_2
    //   1091: aload 16
    //   1093: invokestatic 189	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1096: iload 4
    //   1098: istore_2
    //   1099: iload 8
    //   1101: istore 6
    //   1103: aload 16
    //   1105: astore_0
    //   1106: goto -815 -> 291
    //   1109: astore 16
    //   1111: iconst_0
    //   1112: istore 4
    //   1114: goto -781 -> 333
    //   1117: aload 28
    //   1119: invokeinterface 377 1 0
    //   1124: aload 16
    //   1126: iload 4
    //   1128: invokeinterface 383 3 0
    //   1133: invokeinterface 386 1 0
    //   1138: pop
    //   1139: goto -641 -> 498
    //   1142: astore 16
    //   1144: aload 21
    //   1146: astore 18
    //   1148: aload 22
    //   1150: astore 16
    //   1152: aload 19
    //   1154: astore 17
    //   1156: aload 15
    //   1158: invokevirtual 77	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   1161: new 100	java/lang/StringBuilder
    //   1164: dup
    //   1165: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   1168: iconst_1
    //   1169: invokestatic 397	com/tencent/mobileqq/utils/SoLoadUtil:a	(Z)Ljava/lang/String;
    //   1172: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1175: aload_1
    //   1176: invokestatic 332	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1179: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1182: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1185: invokevirtual 138	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   1188: astore 15
    //   1190: goto -487 -> 703
    //   1193: astore 15
    //   1195: iload_2
    //   1196: istore 4
    //   1198: goto -402 -> 796
    //   1201: astore 16
    //   1203: aload 20
    //   1205: astore 19
    //   1207: aload 18
    //   1209: astore 15
    //   1211: aload 16
    //   1213: astore 18
    //   1215: aload 15
    //   1217: astore 16
    //   1219: aload 19
    //   1221: astore 17
    //   1223: new 100	java/lang/StringBuilder
    //   1226: dup
    //   1227: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   1230: aload_0
    //   1231: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1234: ldc_w 428
    //   1237: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1240: aload 18
    //   1242: invokestatic 343	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1245: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1248: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1251: astore_0
    //   1252: aload 15
    //   1254: astore 16
    //   1256: aload 19
    //   1258: astore 17
    //   1260: iload_2
    //   1261: bipush 16
    //   1263: invokestatic 345	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   1266: istore_2
    //   1267: aload 15
    //   1269: astore 16
    //   1271: aload 19
    //   1273: astore 17
    //   1275: invokestatic 181	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1278: ifeq +18 -> 1296
    //   1281: aload 15
    //   1283: astore 16
    //   1285: aload 19
    //   1287: astore 17
    //   1289: ldc 15
    //   1291: iconst_2
    //   1292: aload_0
    //   1293: invokestatic 189	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1296: aload 19
    //   1298: ifnull +8 -> 1306
    //   1301: aload 19
    //   1303: invokevirtual 406	java/io/OutputStream:close	()V
    //   1306: iload_2
    //   1307: istore 4
    //   1309: aload_0
    //   1310: astore 16
    //   1312: aload 15
    //   1314: ifnull +437 -> 1751
    //   1317: aload 15
    //   1319: invokevirtual 409	java/io/InputStream:close	()V
    //   1322: ldc2_w 394
    //   1325: lstore 9
    //   1327: iload_2
    //   1328: istore 4
    //   1330: goto -534 -> 796
    //   1333: astore 15
    //   1335: ldc2_w 394
    //   1338: lstore 9
    //   1340: iload_2
    //   1341: istore 4
    //   1343: goto -547 -> 796
    //   1346: astore_0
    //   1347: aload 16
    //   1349: astore 15
    //   1351: aload 17
    //   1353: ifnull +8 -> 1361
    //   1356: aload 17
    //   1358: invokevirtual 406	java/io/OutputStream:close	()V
    //   1361: aload 15
    //   1363: ifnull +8 -> 1371
    //   1366: aload 15
    //   1368: invokevirtual 409	java/io/InputStream:close	()V
    //   1371: aload_0
    //   1372: athrow
    //   1373: aload 26
    //   1375: invokestatic 434	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   1378: lstore 9
    //   1380: aload 28
    //   1382: invokeinterface 377 1 0
    //   1387: aload 27
    //   1389: lload 9
    //   1391: invokeinterface 438 4 0
    //   1396: invokeinterface 386 1 0
    //   1401: pop
    //   1402: iload 4
    //   1404: istore_2
    //   1405: aload_0
    //   1406: astore 15
    //   1408: goto -511 -> 897
    //   1411: astore_0
    //   1412: aload 26
    //   1414: invokestatic 434	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   1417: lstore 9
    //   1419: aload 28
    //   1421: aload 27
    //   1423: ldc2_w 394
    //   1426: invokeinterface 442 4 0
    //   1431: lstore 11
    //   1433: lload 9
    //   1435: ldc2_w 394
    //   1438: lcmp
    //   1439: ifeq +120 -> 1559
    //   1442: lload 9
    //   1444: lload 11
    //   1446: lcmp
    //   1447: ifeq +112 -> 1559
    //   1450: aload 26
    //   1452: invokevirtual 176	java/io/File:delete	()Z
    //   1455: pop
    //   1456: new 100	java/lang/StringBuilder
    //   1459: dup
    //   1460: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   1463: aload 15
    //   1465: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1468: ldc_w 444
    //   1471: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1474: lload 9
    //   1476: invokevirtual 301	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1479: ldc_w 446
    //   1482: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1485: lload 11
    //   1487: invokevirtual 301	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1490: ldc_w 448
    //   1493: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1496: aload 26
    //   1498: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1501: ldc_w 453
    //   1504: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1507: aload_0
    //   1508: invokestatic 343	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1511: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1514: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1517: astore 15
    //   1519: iload_2
    //   1520: sipush 128
    //   1523: invokestatic 345	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   1526: istore 4
    //   1528: iload 4
    //   1530: istore_2
    //   1531: aload 15
    //   1533: astore_0
    //   1534: invokestatic 181	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1537: ifeq +97 -> 1634
    //   1540: ldc 15
    //   1542: iconst_2
    //   1543: aload 15
    //   1545: invokestatic 189	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1548: iconst_0
    //   1549: istore_3
    //   1550: aload 15
    //   1552: astore_0
    //   1553: iload 4
    //   1555: istore_2
    //   1556: goto -623 -> 933
    //   1559: new 100	java/lang/StringBuilder
    //   1562: dup
    //   1563: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   1566: aload 15
    //   1568: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1571: ldc_w 455
    //   1574: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1577: aload 26
    //   1579: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1582: ldc_w 453
    //   1585: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1588: aload_0
    //   1589: invokestatic 343	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1592: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1595: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1598: astore 15
    //   1600: iload_2
    //   1601: bipush 32
    //   1603: invokestatic 345	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   1606: istore 4
    //   1608: iload 4
    //   1610: istore_2
    //   1611: aload 15
    //   1613: astore_0
    //   1614: invokestatic 181	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1617: ifeq +17 -> 1634
    //   1620: ldc 15
    //   1622: iconst_2
    //   1623: aload 15
    //   1625: invokestatic 189	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1628: aload 15
    //   1630: astore_0
    //   1631: iload 4
    //   1633: istore_2
    //   1634: iconst_0
    //   1635: istore_3
    //   1636: goto -703 -> 933
    //   1639: astore 15
    //   1641: new 100	java/lang/StringBuilder
    //   1644: dup
    //   1645: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   1648: aload_0
    //   1649: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1652: ldc_w 457
    //   1655: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1658: aload 15
    //   1660: invokestatic 343	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1663: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1666: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1669: astore_0
    //   1670: iload_2
    //   1671: bipush 64
    //   1673: invokestatic 345	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   1676: istore_2
    //   1677: iload_2
    //   1678: istore 4
    //   1680: iload_3
    //   1681: istore 6
    //   1683: aload_0
    //   1684: astore 15
    //   1686: invokestatic 181	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1689: ifeq -715 -> 974
    //   1692: ldc 15
    //   1694: iconst_2
    //   1695: aload_0
    //   1696: invokestatic 189	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1699: iload_2
    //   1700: istore 4
    //   1702: iload_3
    //   1703: istore 6
    //   1705: aload_0
    //   1706: astore 15
    //   1708: goto -734 -> 974
    //   1711: astore 15
    //   1713: goto -940 -> 773
    //   1716: astore 16
    //   1718: goto -412 -> 1306
    //   1721: astore_1
    //   1722: goto -361 -> 1361
    //   1725: astore_1
    //   1726: goto -355 -> 1371
    //   1729: astore_0
    //   1730: aload 19
    //   1732: astore 17
    //   1734: goto -383 -> 1351
    //   1737: astore 18
    //   1739: goto -524 -> 1215
    //   1742: aload 15
    //   1744: astore_0
    //   1745: iload 6
    //   1747: istore_3
    //   1748: goto -815 -> 933
    //   1751: aload 16
    //   1753: astore_0
    //   1754: lload 11
    //   1756: lstore 9
    //   1758: goto -962 -> 796
    //   1761: aload_0
    //   1762: astore 15
    //   1764: goto -867 -> 897
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1767	0	paramContext	Context
    //   0	1767	1	paramString	String
    //   0	1767	2	paramInt	int
    //   0	1767	3	paramBoolean	boolean
    //   257	1444	4	i	int
    //   395	61	5	j	int
    //   141	1605	6	bool1	boolean
    //   51	137	7	bool2	boolean
    //   48	1052	8	bool3	boolean
    //   639	1118	9	l1	long
    //   574	1181	11	l2	long
    //   35	943	13	l3	long
    //   56	1133	15	localObject1	Object
    //   1193	1	15	localIOException1	IOException
    //   1209	109	15	localObject2	Object
    //   1333	1	15	localIOException2	IOException
    //   1349	280	15	localObject3	Object
    //   1639	20	15	localUnsatisfiedLinkError	UnsatisfiedLinkError
    //   1684	23	15	localContext1	Context
    //   1711	32	15	localIOException3	IOException
    //   1762	1	15	localContext2	Context
    //   45	1059	16	localObject4	Object
    //   1109	16	16	localNumberFormatException	java.lang.NumberFormatException
    //   1142	1	16	localException	java.lang.Exception
    //   1150	1	16	localObject5	Object
    //   1201	11	16	localIOException4	IOException
    //   1217	131	16	localObject6	Object
    //   1716	36	16	localIOException5	IOException
    //   122	1611	17	localObject7	Object
    //   578	663	18	localObject8	Object
    //   1737	1	18	localIOException6	IOException
    //   557	1174	19	localObject9	Object
    //   554	650	20	localObject10	Object
    //   563	582	21	localObject11	Object
    //   566	583	22	localObject12	Object
    //   560	140	23	localInputStream	java.io.InputStream
    //   569	73	24	localObject13	Object
    //   41	942	25	localHashMap	HashMap
    //   320	1258	26	localFile1	File
    //   373	1049	27	str1	String
    //   383	1037	28	localSharedPreferences	android.content.SharedPreferences
    //   93	634	29	str2	String
    //   597	35	30	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   190	197	221	java/lang/UnsatisfiedLinkError
    //   202	216	221	java/lang/UnsatisfiedLinkError
    //   322	333	1109	java/lang/NumberFormatException
    //   665	699	1142	java/lang/Exception
    //   788	793	1193	java/io/IOException
    //   588	599	1201	java/io/IOException
    //   611	619	1201	java/io/IOException
    //   631	637	1201	java/io/IOException
    //   665	699	1201	java/io/IOException
    //   715	746	1201	java/io/IOException
    //   1156	1190	1201	java/io/IOException
    //   1317	1322	1333	java/io/IOException
    //   588	599	1346	finally
    //   611	619	1346	finally
    //   631	637	1346	finally
    //   665	699	1346	finally
    //   715	746	1346	finally
    //   1156	1190	1346	finally
    //   1223	1252	1346	finally
    //   1260	1267	1346	finally
    //   1275	1281	1346	finally
    //   1289	1296	1346	finally
    //   920	928	1411	java/lang/UnsatisfiedLinkError
    //   961	965	1639	java/lang/UnsatisfiedLinkError
    //   768	773	1711	java/io/IOException
    //   1301	1306	1716	java/io/IOException
    //   1356	1361	1721	java/io/IOException
    //   1366	1371	1725	java/io/IOException
    //   746	755	1729	finally
    //   746	755	1737	java/io/IOException
  }
  
  private static boolean a(String paramString)
  {
    return false;
  }
  
  /* Error */
  @java.lang.Deprecated
  private static boolean b(Context paramContext, String paramString, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: iconst_0
    //   4: istore_3
    //   5: iconst_0
    //   6: istore 4
    //   8: iconst_0
    //   9: istore 5
    //   11: new 100	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   18: ldc 225
    //   20: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_1
    //   24: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: ldc 227
    //   29: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: astore 11
    //   37: new 100	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   44: aload_0
    //   45: invokevirtual 105	android/content/Context:getFilesDir	()Ljava/io/File;
    //   48: invokevirtual 326	java/io/File:getParent	()Ljava/lang/String;
    //   51: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: ldc 10
    //   56: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: astore 13
    //   64: new 100	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   71: aload 13
    //   73: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload 11
    //   78: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: astore 12
    //   86: aload_0
    //   87: ldc 18
    //   89: iconst_0
    //   90: invokevirtual 361	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   93: astore 10
    //   95: iload 7
    //   97: istore 6
    //   99: aload 10
    //   101: aload 11
    //   103: iconst_m1
    //   104: invokeinterface 367 3 0
    //   109: iload_2
    //   110: if_icmpne +11 -> 121
    //   113: aload 12
    //   115: invokestatic 335	java/lang/System:load	(Ljava/lang/String;)V
    //   118: iconst_1
    //   119: istore 6
    //   121: iload 6
    //   123: istore 8
    //   125: iload 6
    //   127: ifne +718 -> 845
    //   130: aconst_null
    //   131: astore 9
    //   133: aconst_null
    //   134: astore_1
    //   135: aload_0
    //   136: invokevirtual 77	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   139: aload 11
    //   141: invokevirtual 138	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   144: astore_0
    //   145: aload_0
    //   146: astore_1
    //   147: aload_0
    //   148: astore 9
    //   150: new 90	java/io/File
    //   153: dup
    //   154: aload 13
    //   156: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   159: astore 13
    //   161: aload_0
    //   162: astore_1
    //   163: aload_0
    //   164: astore 9
    //   166: aload 13
    //   168: invokevirtual 95	java/io/File:exists	()Z
    //   171: ifne +20 -> 191
    //   174: aload_0
    //   175: astore_1
    //   176: iload 6
    //   178: istore 7
    //   180: aload_0
    //   181: astore 9
    //   183: aload 13
    //   185: invokevirtual 98	java/io/File:mkdir	()Z
    //   188: ifeq +596 -> 784
    //   191: aload_0
    //   192: astore_1
    //   193: aload_0
    //   194: astore 9
    //   196: new 90	java/io/File
    //   199: dup
    //   200: aload 12
    //   202: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   205: astore 13
    //   207: iconst_0
    //   208: istore_3
    //   209: iconst_0
    //   210: istore 5
    //   212: aload_0
    //   213: astore_1
    //   214: new 145	java/io/FileOutputStream
    //   217: dup
    //   218: aload 13
    //   220: invokespecial 148	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   223: astore 9
    //   225: aload_0
    //   226: aload 9
    //   228: invokestatic 403	com/tencent/mobileqq/app/InjectUtils:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   231: pop2
    //   232: iconst_1
    //   233: istore 5
    //   235: iload 5
    //   237: istore 4
    //   239: aload 9
    //   241: ifnull +14 -> 255
    //   244: aload_0
    //   245: astore_1
    //   246: aload 9
    //   248: invokevirtual 406	java/io/OutputStream:close	()V
    //   251: iload 5
    //   253: istore 4
    //   255: iload 4
    //   257: ifne +494 -> 751
    //   260: aload_0
    //   261: astore_1
    //   262: getstatic 36	com/tencent/mobileqq/utils/SoLoadUtil:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   265: aload 11
    //   267: invokeinterface 463 2 0
    //   272: istore 7
    //   274: iload 7
    //   276: ifeq +475 -> 751
    //   279: iload_3
    //   280: iconst_5
    //   281: if_icmpge +470 -> 751
    //   284: iload_3
    //   285: iconst_1
    //   286: iadd
    //   287: istore_3
    //   288: goto -79 -> 209
    //   291: astore_1
    //   292: iload 7
    //   294: istore 6
    //   296: invokestatic 181	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   299: ifeq -178 -> 121
    //   302: ldc 15
    //   304: iconst_2
    //   305: aload_1
    //   306: invokestatic 343	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   309: invokestatic 189	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   312: iload 7
    //   314: istore 6
    //   316: goto -195 -> 121
    //   319: astore 9
    //   321: aload_0
    //   322: astore_1
    //   323: aload 9
    //   325: invokevirtual 162	java/io/IOException:printStackTrace	()V
    //   328: iload 5
    //   330: istore 4
    //   332: goto -77 -> 255
    //   335: astore 10
    //   337: aload_0
    //   338: astore_1
    //   339: invokestatic 181	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   342: ifeq +74 -> 416
    //   345: aload_0
    //   346: astore_1
    //   347: new 100	java/lang/StringBuilder
    //   350: dup
    //   351: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   354: astore 9
    //   356: aload_0
    //   357: astore_1
    //   358: aload 9
    //   360: aload 11
    //   362: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: ldc_w 465
    //   368: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: new 90	java/io/File
    //   374: dup
    //   375: aload 12
    //   377: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   380: invokevirtual 95	java/io/File:exists	()Z
    //   383: invokevirtual 393	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   386: ldc_w 467
    //   389: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: aload 10
    //   394: invokevirtual 470	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   397: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: pop
    //   401: aload_0
    //   402: astore_1
    //   403: ldc 15
    //   405: iconst_2
    //   406: aload 9
    //   408: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   411: aload 10
    //   413: invokestatic 473	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   416: iload_3
    //   417: istore 4
    //   419: iload 6
    //   421: istore 8
    //   423: aload_0
    //   424: ifnull +421 -> 845
    //   427: aload_0
    //   428: invokevirtual 409	java/io/InputStream:close	()V
    //   431: invokestatic 181	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   434: ifeq +45 -> 479
    //   437: ldc 15
    //   439: iconst_2
    //   440: new 100	java/lang/StringBuilder
    //   443: dup
    //   444: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   447: aload 11
    //   449: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: ldc_w 475
    //   455: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: iload_2
    //   459: invokevirtual 186	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   462: ldc_w 477
    //   465: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: iload 6
    //   470: invokevirtual 393	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   473: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   476: invokestatic 189	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   479: invokestatic 283	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   482: invokestatic 288	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   485: astore_0
    //   486: new 235	java/util/HashMap
    //   489: dup
    //   490: invokespecial 236	java/util/HashMap:<init>	()V
    //   493: astore_1
    //   494: aload_1
    //   495: ldc_w 479
    //   498: iload 6
    //   500: invokestatic 481	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   503: invokevirtual 247	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   506: pop
    //   507: aload_1
    //   508: ldc_w 279
    //   511: aload 11
    //   513: invokevirtual 247	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   516: pop
    //   517: aload_1
    //   518: ldc 249
    //   520: getstatic 252	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   523: invokevirtual 247	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   526: pop
    //   527: aload_1
    //   528: ldc 254
    //   530: new 100	java/lang/StringBuilder
    //   533: dup
    //   534: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   537: getstatic 257	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   540: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: ldc_w 259
    //   546: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: getstatic 262	android/os/Build:MODEL	Ljava/lang/String;
    //   552: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   558: invokevirtual 247	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   561: pop
    //   562: aload_1
    //   563: ldc_w 264
    //   566: getstatic 55	com/tencent/mobileqq/utils/SoLoadUtil:jdField_a_of_type_JavaTextSimpleDateFormat	Ljava/text/SimpleDateFormat;
    //   569: new 266	java/util/Date
    //   572: dup
    //   573: invokestatic 270	java/lang/System:currentTimeMillis	()J
    //   576: invokespecial 273	java/util/Date:<init>	(J)V
    //   579: invokevirtual 277	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   582: invokevirtual 247	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   585: pop
    //   586: iload 6
    //   588: ifne +63 -> 651
    //   591: new 90	java/io/File
    //   594: dup
    //   595: aload 12
    //   597: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   600: astore 9
    //   602: aload 9
    //   604: ifnull +47 -> 651
    //   607: aload_1
    //   608: ldc_w 483
    //   611: aload 9
    //   613: invokevirtual 95	java/io/File:exists	()Z
    //   616: invokestatic 481	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   619: invokevirtual 247	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   622: pop
    //   623: aload_1
    //   624: ldc_w 485
    //   627: aload 9
    //   629: invokevirtual 414	java/io/File:length	()J
    //   632: invokestatic 488	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   635: invokevirtual 247	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   638: pop
    //   639: aload_1
    //   640: ldc_w 490
    //   643: iload_3
    //   644: invokestatic 493	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   647: invokevirtual 247	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   650: pop
    //   651: aload_0
    //   652: ldc 243
    //   654: ldc 15
    //   656: iload 6
    //   658: lconst_0
    //   659: lconst_0
    //   660: aload_1
    //   661: ldc 243
    //   663: invokevirtual 293	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   666: iload 6
    //   668: ireturn
    //   669: astore_1
    //   670: iload 5
    //   672: istore 4
    //   674: aload 9
    //   676: ifnull -421 -> 255
    //   679: aload_0
    //   680: astore_1
    //   681: aload 9
    //   683: invokevirtual 406	java/io/OutputStream:close	()V
    //   686: iload 5
    //   688: istore 4
    //   690: goto -435 -> 255
    //   693: astore 9
    //   695: aload_0
    //   696: astore_1
    //   697: aload 9
    //   699: invokevirtual 162	java/io/IOException:printStackTrace	()V
    //   702: iload 5
    //   704: istore 4
    //   706: goto -451 -> 255
    //   709: astore_0
    //   710: aload_1
    //   711: ifnull +7 -> 718
    //   714: aload_1
    //   715: invokevirtual 409	java/io/InputStream:close	()V
    //   718: aload_0
    //   719: athrow
    //   720: astore 10
    //   722: aload 9
    //   724: ifnull +10 -> 734
    //   727: aload_0
    //   728: astore_1
    //   729: aload 9
    //   731: invokevirtual 406	java/io/OutputStream:close	()V
    //   734: aload_0
    //   735: astore_1
    //   736: aload 10
    //   738: athrow
    //   739: astore 9
    //   741: aload_0
    //   742: astore_1
    //   743: aload 9
    //   745: invokevirtual 162	java/io/IOException:printStackTrace	()V
    //   748: goto -14 -> 734
    //   751: aload_0
    //   752: astore_1
    //   753: aload 10
    //   755: invokeinterface 377 1 0
    //   760: aload 11
    //   762: iload_2
    //   763: invokeinterface 383 3 0
    //   768: invokeinterface 386 1 0
    //   773: pop
    //   774: aload_0
    //   775: astore_1
    //   776: aload 12
    //   778: invokestatic 335	java/lang/System:load	(Ljava/lang/String;)V
    //   781: iconst_1
    //   782: istore 7
    //   784: iload_3
    //   785: istore 4
    //   787: iload 7
    //   789: istore 8
    //   791: aload_0
    //   792: ifnull +53 -> 845
    //   795: aload_0
    //   796: invokevirtual 409	java/io/InputStream:close	()V
    //   799: iload 7
    //   801: istore 6
    //   803: goto -372 -> 431
    //   806: astore_0
    //   807: aload_0
    //   808: invokevirtual 162	java/io/IOException:printStackTrace	()V
    //   811: iload 7
    //   813: istore 6
    //   815: goto -384 -> 431
    //   818: astore_0
    //   819: aload_0
    //   820: invokevirtual 162	java/io/IOException:printStackTrace	()V
    //   823: goto -392 -> 431
    //   826: astore_1
    //   827: aload_1
    //   828: invokevirtual 162	java/io/IOException:printStackTrace	()V
    //   831: goto -113 -> 718
    //   834: astore 10
    //   836: iload 5
    //   838: istore_3
    //   839: aload 9
    //   841: astore_0
    //   842: goto -505 -> 337
    //   845: iload 4
    //   847: istore_3
    //   848: iload 8
    //   850: istore 6
    //   852: goto -421 -> 431
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	855	0	paramContext	Context
    //   0	855	1	paramString	String
    //   0	855	2	paramInt	int
    //   4	844	3	i	int
    //   6	840	4	j	int
    //   9	828	5	k	int
    //   97	754	6	bool1	boolean
    //   1	811	7	bool2	boolean
    //   123	726	8	bool3	boolean
    //   131	116	9	localObject1	Object
    //   319	5	9	localIOException1	IOException
    //   354	328	9	localObject2	Object
    //   693	37	9	localIOException2	IOException
    //   739	101	9	localIOException3	IOException
    //   93	7	10	localSharedPreferences	android.content.SharedPreferences
    //   335	77	10	localThrowable1	java.lang.Throwable
    //   720	34	10	localObject3	Object
    //   834	1	10	localThrowable2	java.lang.Throwable
    //   35	726	11	str1	String
    //   84	693	12	str2	String
    //   62	157	13	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   113	118	291	java/lang/Throwable
    //   246	251	319	java/io/IOException
    //   214	225	335	java/lang/Throwable
    //   246	251	335	java/lang/Throwable
    //   262	274	335	java/lang/Throwable
    //   323	328	335	java/lang/Throwable
    //   681	686	335	java/lang/Throwable
    //   697	702	335	java/lang/Throwable
    //   729	734	335	java/lang/Throwable
    //   736	739	335	java/lang/Throwable
    //   743	748	335	java/lang/Throwable
    //   753	774	335	java/lang/Throwable
    //   776	781	335	java/lang/Throwable
    //   225	232	669	java/lang/Exception
    //   681	686	693	java/io/IOException
    //   135	145	709	finally
    //   150	161	709	finally
    //   166	174	709	finally
    //   183	191	709	finally
    //   196	207	709	finally
    //   214	225	709	finally
    //   246	251	709	finally
    //   262	274	709	finally
    //   323	328	709	finally
    //   339	345	709	finally
    //   347	356	709	finally
    //   358	401	709	finally
    //   403	416	709	finally
    //   681	686	709	finally
    //   697	702	709	finally
    //   729	734	709	finally
    //   736	739	709	finally
    //   743	748	709	finally
    //   753	774	709	finally
    //   776	781	709	finally
    //   225	232	720	finally
    //   729	734	739	java/io/IOException
    //   795	799	806	java/io/IOException
    //   427	431	818	java/io/IOException
    //   714	718	826	java/io/IOException
    //   135	145	834	java/lang/Throwable
    //   150	161	834	java/lang/Throwable
    //   166	174	834	java/lang/Throwable
    //   183	191	834	java/lang/Throwable
    //   196	207	834	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SoLoadUtil
 * JD-Core Version:    0.7.0.1
 */