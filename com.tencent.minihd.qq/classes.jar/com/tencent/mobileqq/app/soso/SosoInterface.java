package com.tencent.mobileqq.app.soso;

import NearbyGroup.Attr;
import NearbyGroup.Cell;
import NearbyGroup.GPS;
import NearbyGroup.LBSInfo;
import NearbyGroup.Wifi;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.map.geolocation.internal.TencentLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.highway.utils.HwNetworkUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import hum;
import hun;
import huo;
import hup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public class SosoInterface
  implements TencentLog
{
  public static final int a = -10000;
  public static long a = 0L;
  private static TencentLocationListener jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener = new hum();
  private static TencentLog jdField_a_of_type_ComTencentMapGeolocationInternalTencentLog;
  private static final SosoInterface.OnLocationListener jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener = new hun(0, false, 0L, false, false, "reqRawData");
  public static SosoInterface.SosoLbsInfo a;
  public static final Object a;
  public static final String a = "qq_";
  private static final ArrayList jdField_a_of_type_JavaUtilArrayList;
  private static final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private static long[] jdField_a_of_type_ArrayOfLong;
  public static final int b = 30000;
  public static long b = 0L;
  public static final int c = 1000;
  private static long c = 0L;
  public static final int d = 0;
  public static final int e = 1;
  public static final int f = 2;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    jdField_a_of_type_ArrayOfLong = new long[] { 0L, 0L, 0L, 0L, 0L };
  }
  
  public static LBSInfo a()
  {
    return a(a());
  }
  
  public static LBSInfo a(SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    Attr localAttr = null;
    if (paramSosoLbsInfo == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    if (paramSosoLbsInfo.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject1 = paramSosoLbsInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (SosoInterface.SosoCell)((Iterator)localObject1).next();
        localArrayList.add(new Cell((short)((SosoInterface.SosoCell)localObject2).jdField_a_of_type_Int, (short)((SosoInterface.SosoCell)localObject2).jdField_b_of_type_Int, ((SosoInterface.SosoCell)localObject2).c, ((SosoInterface.SosoCell)localObject2).d, (short)((SosoInterface.SosoCell)localObject2).e));
      }
    }
    if (paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation != null) {}
    for (Object localObject1 = new GPS((int)(paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_a_of_type_Double * 1000000.0D), (int)(paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_b_of_type_Double * 1000000.0D), -1, 0);; localObject1 = null)
    {
      localObject2 = new ArrayList();
      if (paramSosoLbsInfo.jdField_b_of_type_JavaUtilArrayList != null)
      {
        Iterator localIterator = paramSosoLbsInfo.jdField_b_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          SosoInterface.SosoWifi localSosoWifi = (SosoInterface.SosoWifi)localIterator.next();
          if (localSosoWifi != null) {
            ((ArrayList)localObject2).add(new Wifi(localSosoWifi.jdField_a_of_type_Long, (short)localSosoWifi.jdField_a_of_type_Int));
          }
        }
      }
      if (paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute != null) {
        localAttr = new Attr(paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute.jdField_a_of_type_JavaLangString, paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute.jdField_b_of_type_JavaLangString, paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute.jdField_c_of_type_JavaLangString);
      }
      return new LBSInfo((GPS)localObject1, (ArrayList)localObject2, localArrayList, localAttr);
    }
  }
  
  public static SosoInterface.SosoLbsInfo a()
  {
    if (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo == null) {
      return null;
    }
    SosoInterface.SosoLbsInfo localSosoLbsInfo = new SosoInterface.SosoLbsInfo();
    localSosoLbsInfo.jdField_a_of_type_ArrayOfByte = jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ArrayOfByte;
    localSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation = jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation;
    localSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute = jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute;
    localSosoLbsInfo.jdField_a_of_type_JavaUtilArrayList = jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_JavaUtilArrayList;
    localSosoLbsInfo.jdField_b_of_type_JavaUtilArrayList = jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_b_of_type_JavaUtilArrayList;
    localSosoLbsInfo.jdField_a_of_type_Long = jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_Long;
    localSosoLbsInfo.jdField_a_of_type_JavaLangString = jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_JavaLangString;
    localSosoLbsInfo.jdField_b_of_type_JavaLangString = jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_b_of_type_JavaLangString;
    return localSosoLbsInfo;
  }
  
  public static void a()
  {
    if (TencentLocationManager.hasListener())
    {
      ??? = TencentLocationManager.getInstance(BaseApplicationImpl.getContext());
      if (jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener != null) {
        ((TencentLocationManager)???).removeUpdates(jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener);
      }
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      jdField_a_of_type_JavaUtilArrayList.clear();
      return;
    }
  }
  
  /* Error */
  @java.lang.Deprecated
  public static void a(long paramLong, String paramString)
  {
    // Byte code:
    //   0: invokestatic 215	com/tencent/mobileqq/app/ThreadManager:a	()Ljava/lang/Thread;
    //   3: invokestatic 220	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   6: if_acmpeq +15 -> 21
    //   9: invokestatic 220	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   12: invokestatic 226	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   15: invokevirtual 229	android/os/Looper:getThread	()Ljava/lang/Thread;
    //   18: if_acmpne +30 -> 48
    //   21: new 231	android/util/AndroidRuntimeException
    //   24: dup
    //   25: new 233	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 234	java/lang/StringBuilder:<init>	()V
    //   32: ldc 236
    //   34: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_2
    //   38: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokespecial 247	android/util/AndroidRuntimeException:<init>	(Ljava/lang/String;)V
    //   47: athrow
    //   48: lload_0
    //   49: lconst_0
    //   50: lcmp
    //   51: ifle +122 -> 173
    //   54: invokestatic 252	android/os/SystemClock:elapsedRealtime	()J
    //   57: getstatic 253	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_Long	J
    //   60: lload_0
    //   61: ladd
    //   62: lcmp
    //   63: ifge +110 -> 173
    //   66: invokestatic 258	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   69: ifeq +30 -> 99
    //   72: ldc_w 260
    //   75: iconst_2
    //   76: new 233	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 234	java/lang/StringBuilder:<init>	()V
    //   83: ldc_w 262
    //   86: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_2
    //   90: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   99: new 267	java/util/HashMap
    //   102: dup
    //   103: invokespecial 268	java/util/HashMap:<init>	()V
    //   106: astore 10
    //   108: aload_2
    //   109: ifnull +20 -> 129
    //   112: aload_2
    //   113: invokevirtual 274	java/lang/String:length	()I
    //   116: ifle +13 -> 129
    //   119: aload 10
    //   121: ldc_w 276
    //   124: aload_2
    //   125: invokevirtual 280	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   128: pop
    //   129: aload 10
    //   131: ldc_w 282
    //   134: getstatic 288	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   137: invokevirtual 291	java/lang/Boolean:booleanValue	()Z
    //   140: invokestatic 294	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   143: invokevirtual 280	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   146: pop
    //   147: invokestatic 298	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:a	()Ljava/lang/String;
    //   150: astore_2
    //   151: invokestatic 192	com/tencent/common/app/BaseApplicationImpl:getContext	()Landroid/content/Context;
    //   154: invokestatic 303	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   157: aload_2
    //   158: ldc_w 305
    //   161: iconst_1
    //   162: lconst_0
    //   163: lconst_0
    //   164: aload 10
    //   166: ldc_w 307
    //   169: invokevirtual 310	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   172: return
    //   173: invokestatic 258	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   176: ifeq +40 -> 216
    //   179: ldc_w 260
    //   182: iconst_2
    //   183: new 233	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 234	java/lang/StringBuilder:<init>	()V
    //   190: ldc_w 312
    //   193: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: aload_2
    //   197: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: ldc_w 314
    //   203: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: lload_0
    //   207: invokevirtual 317	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   210: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   216: getstatic 68	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener	Lcom/tencent/mobileqq/app/soso/SosoInterface$OnLocationListener;
    //   219: new 233	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 234	java/lang/StringBuilder:<init>	()V
    //   226: ldc_w 319
    //   229: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: aload_2
    //   233: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: putfield 322	com/tencent/mobileqq/app/soso/SosoInterface$OnLocationListener:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   242: getstatic 68	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener	Lcom/tencent/mobileqq/app/soso/SosoInterface$OnLocationListener;
    //   245: invokestatic 325	com/tencent/mobileqq/app/soso/SosoInterface:a	(Lcom/tencent/mobileqq/app/soso/SosoInterface$OnLocationListener;)V
    //   248: invokestatic 252	android/os/SystemClock:elapsedRealtime	()J
    //   251: lstore_0
    //   252: iconst_0
    //   253: istore 9
    //   255: iconst_0
    //   256: istore 8
    //   258: iload 8
    //   260: istore 7
    //   262: getstatic 40	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   265: astore 11
    //   267: iload 8
    //   269: istore 7
    //   271: aload 11
    //   273: monitorenter
    //   274: iload 9
    //   276: istore 8
    //   278: invokestatic 252	android/os/SystemClock:elapsedRealtime	()J
    //   281: lstore_3
    //   282: iload 9
    //   284: istore 8
    //   286: getstatic 253	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_Long	J
    //   289: lstore 5
    //   291: lload_3
    //   292: lload 5
    //   294: ldc2_w 326
    //   297: ladd
    //   298: lcmp
    //   299: ifge +80 -> 379
    //   302: iconst_1
    //   303: istore 7
    //   305: aload 11
    //   307: monitorexit
    //   308: invokestatic 258	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   311: ifeq -139 -> 172
    //   314: ldc_w 260
    //   317: iconst_2
    //   318: new 233	java/lang/StringBuilder
    //   321: dup
    //   322: invokespecial 234	java/lang/StringBuilder:<init>	()V
    //   325: ldc_w 329
    //   328: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: getstatic 333	com/tencent/mobileqq/app/LBSHandler:D	I
    //   334: invokevirtual 336	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   337: ldc_w 338
    //   340: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: aload_2
    //   344: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: ldc_w 340
    //   350: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: iload 7
    //   355: invokevirtual 343	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   358: ldc_w 345
    //   361: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: invokestatic 252	android/os/SystemClock:elapsedRealtime	()J
    //   367: lload_0
    //   368: lsub
    //   369: invokevirtual 317	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   372: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   378: return
    //   379: iload 9
    //   381: istore 8
    //   383: getstatic 40	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   386: ldc2_w 346
    //   389: invokevirtual 351	java/lang/Object:wait	(J)V
    //   392: iconst_0
    //   393: istore 7
    //   395: goto -90 -> 305
    //   398: iload 7
    //   400: istore 8
    //   402: aload 11
    //   404: monitorexit
    //   405: aload 10
    //   407: athrow
    //   408: astore 10
    //   410: bipush 245
    //   412: putstatic 333	com/tencent/mobileqq/app/LBSHandler:D	I
    //   415: goto -107 -> 308
    //   418: astore 10
    //   420: goto -22 -> 398
    //   423: astore 10
    //   425: iload 8
    //   427: istore 7
    //   429: goto -31 -> 398
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	432	0	paramLong	long
    //   0	432	2	paramString	String
    //   281	11	3	l1	long
    //   289	4	5	l2	long
    //   260	168	7	bool1	boolean
    //   256	170	8	bool2	boolean
    //   253	127	9	bool3	boolean
    //   106	300	10	localHashMap	HashMap
    //   408	1	10	localInterruptedException	java.lang.InterruptedException
    //   418	1	10	localObject1	Object
    //   423	1	10	localObject2	Object
    //   265	138	11	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   262	267	408	java/lang/InterruptedException
    //   271	274	408	java/lang/InterruptedException
    //   405	408	408	java/lang/InterruptedException
    //   305	308	418	finally
    //   278	282	423	finally
    //   286	291	423	finally
    //   383	392	423	finally
    //   402	405	423	finally
  }
  
  public static void a(SosoInterface.OnLocationListener paramOnLocationListener)
  {
    boolean bool = true;
    if (paramOnLocationListener == null) {}
    label60:
    long l;
    label161:
    int i;
    Object localObject2;
    for (;;)
    {
      return;
      try
      {
        if (HwNetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext())) {
          break label60;
        }
        localObject1 = b();
        if (paramOnLocationListener.jdField_e_of_type_Boolean)
        {
          a(paramOnLocationListener, 1, (SosoInterface.SosoLbsInfo)localObject1);
          continue;
        }
      }
      finally {}
      paramOnLocationListener.a(1, (SosoInterface.SosoLbsInfo)localObject1);
      continue;
      if ((QLog.isColorLevel()) && (jdField_a_of_type_ComTencentMapGeolocationInternalTencentLog == null))
      {
        jdField_a_of_type_ComTencentMapGeolocationInternalTencentLog = new SosoInterface();
        TencentExtraKeys.setTencentLog(jdField_a_of_type_ComTencentMapGeolocationInternalTencentLog);
      }
      if (paramOnLocationListener.jdField_e_of_type_Long <= 0L) {
        break label736;
      }
      l = SystemClock.elapsedRealtime();
      if (!paramOnLocationListener.g) {
        break label317;
      }
      if ((jdField_a_of_type_ArrayOfLong[paramOnLocationListener.jdField_b_of_type_Int] <= 0L) || (l >= jdField_a_of_type_ArrayOfLong[paramOnLocationListener.jdField_b_of_type_Int] + paramOnLocationListener.jdField_e_of_type_Long)) {
        break label736;
      }
      localObject1 = b();
      if (!paramOnLocationListener.jdField_e_of_type_Boolean) {
        break;
      }
      a(paramOnLocationListener, 0, (SosoInterface.SosoLbsInfo)localObject1);
      break label741;
      if (i == 0) {
        break label376;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SOSO.LBS", 2, "startLocation() lis=" + paramOnLocationListener.jdField_b_of_type_JavaLangString + " use cache and callback now");
      }
      localObject1 = new HashMap();
      if ((paramOnLocationListener.jdField_b_of_type_JavaLangString != null) && (paramOnLocationListener.jdField_b_of_type_JavaLangString.length() > 0)) {
        ((HashMap)localObject1).put("param_caller", paramOnLocationListener.jdField_b_of_type_JavaLangString);
      }
      ((HashMap)localObject1).put("param_useCache", Boolean.toString(Boolean.TRUE.booleanValue()));
      localObject2 = EarlyDownloadManager.a();
      StatisticCollector localStatisticCollector = StatisticCollector.a(BaseApplicationImpl.getContext());
      if (!paramOnLocationListener.g) {
        break label751;
      }
      paramOnLocationListener = "actSosoLocation";
      label288:
      localStatisticCollector.a((String)localObject2, paramOnLocationListener, true, 0L, 0L, (HashMap)localObject1, "");
    }
    paramOnLocationListener.a(0, (SosoInterface.SosoLbsInfo)localObject1);
    break label741;
    label317:
    if ((jdField_a_of_type_Long > 0L) && (l < jdField_a_of_type_Long + paramOnLocationListener.jdField_e_of_type_Long) && (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo != null))
    {
      localObject1 = a();
      if (paramOnLocationListener.jdField_e_of_type_Boolean)
      {
        a(paramOnLocationListener, 0, (SosoInterface.SosoLbsInfo)localObject1);
        break label746;
      }
      paramOnLocationListener.a(0, (SosoInterface.SosoLbsInfo)localObject1);
      break label746;
      label376:
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("startLocation() reqLoc=").append(paramOnLocationListener.g).append(" level=");
        if (paramOnLocationListener.jdField_b_of_type_Int != 3) {
          break label658;
        }
        localObject1 = "ADMIN_AREA";
        localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(" caller=").append(paramOnLocationListener.jdField_b_of_type_JavaLangString).append(" ui=").append(paramOnLocationListener.jdField_e_of_type_Boolean).append(" goon=").append(paramOnLocationListener.f);
        if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0) {
          break label766;
        }
      }
    }
    label423:
    label731:
    label736:
    label741:
    label746:
    label751:
    label758:
    label766:
    for (Object localObject1 = " do startLocation";; localObject1 = " waitting...")
    {
      QLog.d("SOSO.LBS", 2, (String)localObject1);
      c(paramOnLocationListener);
      if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0) {
        break;
      }
      if (paramOnLocationListener == jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener)
      {
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
        paramOnLocationListener.d = SystemClock.elapsedRealtime();
        localObject1 = TencentLocationRequest.create();
        ((TencentLocationRequest)localObject1).setInterval(1000L);
        ((TencentLocationRequest)localObject1).setRequestLevel(paramOnLocationListener.jdField_b_of_type_Int);
        ((TencentLocationRequest)localObject1).setAllowCache(true);
        TencentExtraKeys.setAllowGps((TencentLocationRequest)localObject1, true);
        if (paramOnLocationListener.g) {
          break label731;
        }
      }
      for (;;)
      {
        TencentExtraKeys.setRequestRawData((TencentLocationRequest)localObject1, bool);
        ((TencentLocationRequest)localObject1).getExtras().putInt("qq_level", paramOnLocationListener.jdField_b_of_type_Int);
        ((TencentLocationRequest)localObject1).getExtras().putBoolean("qq_reqLocation", paramOnLocationListener.g);
        ((TencentLocationRequest)localObject1).getExtras().putString("qq_caller", paramOnLocationListener.jdField_b_of_type_JavaLangString);
        c = SystemClock.elapsedRealtime();
        ThreadManager.b().post(new hup((TencentLocationRequest)localObject1));
        break;
        if (paramOnLocationListener.jdField_b_of_type_Int == 5)
        {
          localObject1 = "FORMATTED_ADDRESS";
          break label423;
        }
        if (paramOnLocationListener.jdField_b_of_type_Int == 0)
        {
          localObject1 = "GEO";
          break label423;
        }
        if (paramOnLocationListener.jdField_b_of_type_Int == 1)
        {
          localObject1 = "NAME";
          break label423;
        }
        if (paramOnLocationListener.jdField_b_of_type_Int != 4) {
          break label758;
        }
        localObject1 = "POI";
        break label423;
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
        break label529;
        bool = false;
      }
      i = 0;
      break label161;
      i = 1;
      break label161;
      i = 1;
      break label161;
      paramOnLocationListener = "actSosoRawData";
      break label288;
      localObject1 = "unknown";
      break label423;
    }
  }
  
  public static void a(SosoInterface.OnLocationListener paramOnLocationListener, int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramOnLocationListener == null) || (paramSosoLbsInfo == null)) {
      return;
    }
    ThreadManager.c().post(new huo(paramOnLocationListener, paramInt, paramSosoLbsInfo));
  }
  
  public static SosoInterface.SosoLbsInfo b()
  {
    if ((jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo == null) || (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation == null)) {
      return null;
    }
    SosoInterface.SosoLbsInfo localSosoLbsInfo = new SosoInterface.SosoLbsInfo();
    localSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation = jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation;
    return localSosoLbsInfo;
  }
  
  private static void b(int paramInt, TencentLocation paramTencentLocation)
  {
    if (paramTencentLocation == null) {
      return;
    }
    if (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo == null)
    {
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo = new SosoInterface.SosoLbsInfo();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation = new SosoInterface.SosoLocation(paramTencentLocation.getLatitude(), paramTencentLocation.getLongitude());
    }
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_b_of_type_Double = paramTencentLocation.getLongitude();
        jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_a_of_type_Double = paramTencentLocation.getLatitude();
        switch (paramInt)
        {
        case 2: 
          b = SystemClock.elapsedRealtime();
          return;
        }
      }
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_a_of_type_JavaUtilList = paramTencentLocation.getPoiList();
      jdField_a_of_type_ArrayOfLong[4] = SystemClock.elapsedRealtime();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_c_of_type_JavaLangString = paramTencentLocation.getNation();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.d = paramTencentLocation.getProvince();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.e = paramTencentLocation.getCity();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.f = paramTencentLocation.getDistrict();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.g = paramTencentLocation.getTown();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.h = paramTencentLocation.getVillage();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.i = paramTencentLocation.getStreet();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.j = paramTencentLocation.getStreetNo();
      jdField_a_of_type_ArrayOfLong[3] = SystemClock.elapsedRealtime();
      if (paramInt == 1)
      {
        jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_a_of_type_JavaLangString = paramTencentLocation.getName();
        jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_b_of_type_JavaLangString = paramTencentLocation.getAddress();
        jdField_a_of_type_ArrayOfLong[1] = SystemClock.elapsedRealtime();
      }
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_c_of_type_Double = paramTencentLocation.getAltitude();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_a_of_type_Float = paramTencentLocation.getAccuracy();
      jdField_a_of_type_ArrayOfLong[0] = SystemClock.elapsedRealtime();
    }
  }
  
  public static void b(SosoInterface.OnLocationListener paramOnLocationListener)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      jdField_a_of_type_JavaUtilArrayList.remove(paramOnLocationListener);
      if (QLog.isColorLevel()) {
        QLog.d("SOSO.LBS", 2, "removeOnLocationListener() lis=" + paramOnLocationListener.jdField_b_of_type_JavaLangString + " removed.");
      }
      if (jdField_a_of_type_JavaUtilArrayList.size() == 0)
      {
        TencentLocationManager.getInstance(BaseApplicationImpl.getContext()).removeUpdates(jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener);
        if (QLog.isColorLevel()) {
          QLog.d("SOSO.LBS", 4, "removeOnLocationListener() listener is empty. remveUpdate and stop LBS");
        }
      }
      return;
    }
  }
  
  /* Error */
  private static void b(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: getstatic 172	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo	Lcom/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo;
    //   8: ifnonnull +13 -> 21
    //   11: new 82	com/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo
    //   14: dup
    //   15: invokespecial 173	com/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo:<init>	()V
    //   18: putstatic 172	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo	Lcom/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo;
    //   21: getstatic 172	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo	Lcom/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo;
    //   24: aload_1
    //   25: putfield 176	com/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo:jdField_a_of_type_ArrayOfByte	[B
    //   28: new 601	org/json/JSONObject
    //   31: dup
    //   32: new 270	java/lang/String
    //   35: dup
    //   36: aload_1
    //   37: ldc_w 603
    //   40: invokespecial 606	java/lang/String:<init>	([BLjava/lang/String;)V
    //   43: invokespecial 607	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   46: astore 20
    //   48: dconst_0
    //   49: dstore 4
    //   51: dload 4
    //   53: dstore_2
    //   54: aload 20
    //   56: ldc_w 609
    //   59: invokevirtual 613	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   62: astore_1
    //   63: dload 4
    //   65: dstore_2
    //   66: aload_1
    //   67: ldc_w 615
    //   70: invokevirtual 619	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   73: dstore 4
    //   75: dload 4
    //   77: dstore_2
    //   78: aload_1
    //   79: ldc_w 621
    //   82: invokevirtual 619	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   85: dstore 6
    //   87: dload 6
    //   89: dstore_2
    //   90: aload 20
    //   92: ldc_w 623
    //   95: invokevirtual 613	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   98: astore_1
    //   99: new 154	com/tencent/mobileqq/app/soso/SosoInterface$SosoAttribute
    //   102: dup
    //   103: aload_1
    //   104: ldc_w 625
    //   107: invokevirtual 629	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   110: aload_1
    //   111: ldc_w 631
    //   114: invokevirtual 629	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   117: aload_1
    //   118: ldc_w 633
    //   121: invokevirtual 629	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   124: aload_1
    //   125: ldc_w 635
    //   128: invokevirtual 629	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   131: aload_1
    //   132: ldc_w 637
    //   135: invokevirtual 641	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   138: invokespecial 644	com/tencent/mobileqq/app/soso/SosoInterface$SosoAttribute:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   141: astore 18
    //   143: new 42	java/util/ArrayList
    //   146: dup
    //   147: invokespecial 43	java/util/ArrayList:<init>	()V
    //   150: astore 21
    //   152: aload 20
    //   154: ldc_w 646
    //   157: invokevirtual 650	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   160: astore_1
    //   161: aload_1
    //   162: invokevirtual 653	org/json/JSONArray:length	()I
    //   165: istore 9
    //   167: iconst_0
    //   168: istore 8
    //   170: iload 8
    //   172: iload 9
    //   174: if_icmpge +129 -> 303
    //   177: aload_1
    //   178: iload 8
    //   180: invokevirtual 656	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   183: astore 19
    //   185: aload 19
    //   187: ldc_w 658
    //   190: invokevirtual 662	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   193: istore 10
    //   195: aload 19
    //   197: ldc_w 664
    //   200: invokevirtual 662	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   203: istore 11
    //   205: aload 19
    //   207: ldc_w 666
    //   210: invokevirtual 662	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   213: istore 12
    //   215: aload 19
    //   217: ldc_w 668
    //   220: invokevirtual 662	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   223: istore 13
    //   225: aload 19
    //   227: ldc_w 670
    //   230: invokevirtual 662	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   233: istore 14
    //   235: iload 8
    //   237: ifne +330 -> 567
    //   240: iconst_1
    //   241: istore 15
    //   243: aload 21
    //   245: new 99	com/tencent/mobileqq/app/soso/SosoInterface$SosoCell
    //   248: dup
    //   249: iload 10
    //   251: iload 11
    //   253: iload 12
    //   255: iload 13
    //   257: iload 14
    //   259: iload 15
    //   261: invokespecial 673	com/tencent/mobileqq/app/soso/SosoInterface$SosoCell:<init>	(IIIIIZ)V
    //   264: invokevirtual 118	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   267: pop
    //   268: iload 8
    //   270: iconst_1
    //   271: iadd
    //   272: istore 8
    //   274: goto -104 -> 170
    //   277: astore_1
    //   278: new 154	com/tencent/mobileqq/app/soso/SosoInterface$SosoAttribute
    //   281: dup
    //   282: ldc_w 307
    //   285: ldc_w 307
    //   288: ldc_w 307
    //   291: ldc_w 307
    //   294: iconst_0
    //   295: invokespecial 644	com/tencent/mobileqq/app/soso/SosoInterface$SosoAttribute:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   298: astore 18
    //   300: goto -157 -> 143
    //   303: new 42	java/util/ArrayList
    //   306: dup
    //   307: invokespecial 43	java/util/ArrayList:<init>	()V
    //   310: astore 22
    //   312: aload 20
    //   314: ldc_w 675
    //   317: invokevirtual 650	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   320: astore_1
    //   321: iconst_0
    //   322: istore 8
    //   324: aload_1
    //   325: invokevirtual 653	org/json/JSONArray:length	()I
    //   328: istore 9
    //   330: iload 8
    //   332: iload 9
    //   334: if_icmpge +49 -> 383
    //   337: aload_1
    //   338: iload 8
    //   340: invokevirtual 656	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   343: astore 19
    //   345: aload 22
    //   347: new 139	com/tencent/mobileqq/app/soso/SosoInterface$SosoWifi
    //   350: dup
    //   351: aload 19
    //   353: ldc_w 677
    //   356: invokevirtual 629	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   359: aload 19
    //   361: ldc_w 679
    //   364: invokevirtual 662	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   367: invokespecial 681	com/tencent/mobileqq/app/soso/SosoInterface$SosoWifi:<init>	(Ljava/lang/String;I)V
    //   370: invokevirtual 118	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   373: pop
    //   374: iload 8
    //   376: iconst_1
    //   377: iadd
    //   378: istore 8
    //   380: goto -50 -> 330
    //   383: ldc_w 307
    //   386: astore_1
    //   387: aload 20
    //   389: ldc_w 683
    //   392: invokevirtual 629	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   395: astore 19
    //   397: aload 19
    //   399: astore_1
    //   400: aload 20
    //   402: ldc_w 685
    //   405: invokevirtual 662	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   408: pop
    //   409: aload 19
    //   411: astore_1
    //   412: aload 20
    //   414: ldc_w 687
    //   417: invokevirtual 691	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   420: lstore 16
    //   422: aload 19
    //   424: astore_1
    //   425: getstatic 40	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   428: astore 19
    //   430: aload 19
    //   432: monitorenter
    //   433: getstatic 172	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo	Lcom/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo;
    //   436: getfield 121	com/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo:jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation	Lcom/tencent/mobileqq/app/soso/SosoInterface$SosoLocation;
    //   439: ifnonnull +91 -> 530
    //   442: getstatic 172	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo	Lcom/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo;
    //   445: new 125	com/tencent/mobileqq/app/soso/SosoInterface$SosoLocation
    //   448: dup
    //   449: dload 4
    //   451: dload_2
    //   452: invokespecial 512	com/tencent/mobileqq/app/soso/SosoInterface$SosoLocation:<init>	(DD)V
    //   455: putfield 121	com/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo:jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation	Lcom/tencent/mobileqq/app/soso/SosoInterface$SosoLocation;
    //   458: getstatic 172	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo	Lcom/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo;
    //   461: aload 18
    //   463: putfield 150	com/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo:jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute	Lcom/tencent/mobileqq/app/soso/SosoInterface$SosoAttribute;
    //   466: getstatic 172	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo	Lcom/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo;
    //   469: aload 21
    //   471: putfield 83	com/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   474: getstatic 172	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo	Lcom/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo;
    //   477: aload 22
    //   479: putfield 137	com/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   482: getstatic 172	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo	Lcom/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo;
    //   485: lload 16
    //   487: putfield 177	com/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo:jdField_a_of_type_Long	J
    //   490: getstatic 172	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo	Lcom/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo;
    //   493: aload_1
    //   494: putfield 178	com/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   497: getstatic 172	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo	Lcom/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo;
    //   500: aload_0
    //   501: putfield 179	com/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   504: invokestatic 252	android/os/SystemClock:elapsedRealtime	()J
    //   507: putstatic 253	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_Long	J
    //   510: aload 19
    //   512: monitorexit
    //   513: return
    //   514: astore_0
    //   515: aload 19
    //   517: monitorexit
    //   518: aload_0
    //   519: athrow
    //   520: astore_0
    //   521: return
    //   522: astore 19
    //   524: lconst_0
    //   525: lstore 16
    //   527: goto -102 -> 425
    //   530: getstatic 172	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo	Lcom/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo;
    //   533: getfield 121	com/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo:jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation	Lcom/tencent/mobileqq/app/soso/SosoInterface$SosoLocation;
    //   536: dload 4
    //   538: putfield 128	com/tencent/mobileqq/app/soso/SosoInterface$SosoLocation:jdField_a_of_type_Double	D
    //   541: getstatic 172	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo	Lcom/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo;
    //   544: getfield 121	com/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo:jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation	Lcom/tencent/mobileqq/app/soso/SosoInterface$SosoLocation;
    //   547: dload_2
    //   548: putfield 132	com/tencent/mobileqq/app/soso/SosoInterface$SosoLocation:jdField_b_of_type_Double	D
    //   551: goto -93 -> 458
    //   554: astore_1
    //   555: dconst_0
    //   556: dstore 6
    //   558: dload_2
    //   559: dstore 4
    //   561: dload 6
    //   563: dstore_2
    //   564: goto -474 -> 90
    //   567: iconst_0
    //   568: istore 15
    //   570: goto -327 -> 243
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	573	0	paramString	String
    //   0	573	1	paramArrayOfByte	byte[]
    //   53	511	2	d1	double
    //   49	511	4	d2	double
    //   85	477	6	d3	double
    //   168	211	8	i	int
    //   165	170	9	j	int
    //   193	57	10	k	int
    //   203	49	11	m	int
    //   213	41	12	n	int
    //   223	33	13	i1	int
    //   233	25	14	i2	int
    //   241	328	15	bool	boolean
    //   420	106	16	l	long
    //   141	321	18	localSosoAttribute	SosoInterface.SosoAttribute
    //   522	1	19	localJSONException	org.json.JSONException
    //   46	367	20	localJSONObject	org.json.JSONObject
    //   150	320	21	localArrayList1	ArrayList
    //   310	168	22	localArrayList2	ArrayList
    // Exception table:
    //   from	to	target	type
    //   90	143	277	org/json/JSONException
    //   433	458	514	finally
    //   458	513	514	finally
    //   515	518	514	finally
    //   530	551	514	finally
    //   21	48	520	java/lang/Exception
    //   54	63	520	java/lang/Exception
    //   66	75	520	java/lang/Exception
    //   78	87	520	java/lang/Exception
    //   90	143	520	java/lang/Exception
    //   143	167	520	java/lang/Exception
    //   177	235	520	java/lang/Exception
    //   243	268	520	java/lang/Exception
    //   278	300	520	java/lang/Exception
    //   303	321	520	java/lang/Exception
    //   324	330	520	java/lang/Exception
    //   337	374	520	java/lang/Exception
    //   387	397	520	java/lang/Exception
    //   400	409	520	java/lang/Exception
    //   412	422	520	java/lang/Exception
    //   425	433	520	java/lang/Exception
    //   518	520	520	java/lang/Exception
    //   387	397	522	org/json/JSONException
    //   400	409	522	org/json/JSONException
    //   412	422	522	org/json/JSONException
    //   54	63	554	org/json/JSONException
    //   66	75	554	org/json/JSONException
    //   78	87	554	org/json/JSONException
  }
  
  private static void c(SosoInterface.OnLocationListener paramOnLocationListener)
  {
    if (paramOnLocationListener == null) {
      return;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (!jdField_a_of_type_JavaUtilArrayList.contains(paramOnLocationListener)) {
        jdField_a_of_type_JavaUtilArrayList.add(paramOnLocationListener);
      }
      return;
    }
  }
  
  public void println(String paramString1, int paramInt, String paramString2)
  {
    if (paramString2 != null)
    {
      String str = paramString2;
      if (paramString2.length() > 50) {
        str = paramString2.substring(0, 50);
      }
      QLog.d(paramString1, 1, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.soso.SosoInterface
 * JD-Core Version:    0.7.0.1
 */