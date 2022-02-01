package com.tencent.mobileqq.app;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import hjz;
import hlf;
import hlg;
import hlh;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class MemoryManager
{
  private static final byte jdField_a_of_type_Byte = 1;
  private static final long jdField_a_of_type_Long = 1048576L;
  private static MemoryManager jdField_a_of_type_ComTencentMobileqqAppMemoryManager = null;
  public static final String a = "Q.Memory.MemoryManager";
  private static List jdField_a_of_type_JavaUtilList = null;
  private static final byte jdField_b_of_type_Byte = 2;
  private static long jdField_b_of_type_Long = 0L;
  public static final String b = "com.tencent.process.exit";
  private static List jdField_b_of_type_JavaUtilList = null;
  public static final String c = "MemoryInfomation";
  private static List c = null;
  public static final String d = "MemoryAlertAutoClear";
  private hlg jdField_a_of_type_Hlg = null;
  private hlh jdField_a_of_type_Hlh = null;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  
  public static long a()
  {
    if (jdField_b_of_type_Long > 0L) {
      return jdField_b_of_type_Long;
    }
    long l1 = DeviceInfoUtil.c();
    long l2 = DeviceInfoUtil.d();
    long l3 = (3L * l1 + 7L * l2) / 10L;
    long l4 = DeviceInfoUtil.e();
    if (l3 <= 157286400L) {
      jdField_b_of_type_Long = Math.min(25165824L, l4);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.Memory.MemoryManager", 2, "getAvailClassSize, availClassSize=" + jdField_b_of_type_Long / 1048576L + "M, totalMemSize=" + l1 / 1048576L + "M, remainMemSize=" + l2 / 1048576L + "M, availMemSize=" + l3 / 1048576L + "M, classMemSize=" + l4 / 1048576L + "M");
      }
      return jdField_b_of_type_Long;
      if (l3 <= 262144000L) {
        jdField_b_of_type_Long = Math.min(37748736L, l4);
      } else if (l3 <= 419430400L) {
        jdField_b_of_type_Long = Math.min(67108864L, l4);
      } else if (l3 <= 524288000L) {
        jdField_b_of_type_Long = Math.min(134217728L, l4);
      } else {
        jdField_b_of_type_Long = Math.min(268435456L, l4);
      }
    }
  }
  
  public static long a(int paramInt)
  {
    try
    {
      Debug.MemoryInfo[] arrayOfMemoryInfo = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getProcessMemoryInfo(new int[] { paramInt });
      if ((arrayOfMemoryInfo != null) && (arrayOfMemoryInfo.length > 0))
      {
        int i = arrayOfMemoryInfo[0].getTotalPss();
        return i * 1024L;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.Memory.MemoryManager", 2, "getMemory ex pid=" + paramInt, localException);
      }
    }
    return 62914560L;
  }
  
  public static MemoryManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqAppMemoryManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqAppMemoryManager == null) {
        jdField_a_of_type_ComTencentMobileqqAppMemoryManager = new MemoryManager();
      }
      return jdField_a_of_type_ComTencentMobileqqAppMemoryManager;
    }
    finally {}
  }
  
  private hlg a()
  {
    if (this.jdField_a_of_type_Hlg == null)
    {
      this.jdField_a_of_type_Hlg = new hlg(this);
      this.jdField_a_of_type_Hlg.a();
    }
    return this.jdField_a_of_type_Hlg;
  }
  
  public void a()
  {
    b();
    c();
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      hlg localhlg = a();
      localhlg.jdField_a_of_type_Long += paramLong2;
      localhlg.jdField_b_of_type_Long += paramLong1;
      localhlg.jdField_a_of_type_Int += 1;
      localhlg.c();
      return;
    }
  }
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.j)) {}
    while (!MemoryConfigs.a().b) {
      return;
    }
    paramQQAppInterface.a(new hlf(paramQQAppInterface, paramContext, 2));
  }
  
  protected void b()
  {
    Object localObject1 = (ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity");
    if (this.jdField_a_of_type_Hlh == null)
    {
      this.jdField_a_of_type_Hlh = new hlh(this);
      this.jdField_a_of_type_Hlh.a();
    }
    if (this.jdField_a_of_type_Hlh.jdField_b_of_type_Long == 0L) {
      this.jdField_a_of_type_Hlh.jdField_b_of_type_Long = DeviceInfoUtil.c();
    }
    if (this.jdField_a_of_type_Hlh.jdField_c_of_type_Long == 0L) {
      this.jdField_a_of_type_Hlh.jdField_c_of_type_Long = DeviceInfoUtil.e();
    }
    long l3 = DeviceInfoUtil.d();
    long l4 = a(Process.myPid());
    localObject1 = ((ActivityManager)localObject1).getRunningAppProcesses();
    long l1;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      for (l1 = 0L;; l1 += a(((ActivityManager.RunningAppProcessInfo)localObject2).pid))
      {
        l2 = l1;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
        String str = ((ActivityManager.RunningAppProcessInfo)localObject2).processName;
        if ((!str.startsWith("com.tencent.minihd.qq")) || (str.equals("com.tencent.minihd.qq"))) {
          break label1238;
        }
      }
    }
    long l2 = 0L;
    if ((l3 < 0L) || (l4 < 0L) || (l2 < 0L)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Hlh.jdField_a_of_type_Long == 0L) {
        this.jdField_a_of_type_Hlh.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      localObject1 = this.jdField_a_of_type_Hlh;
      ((hlh)localObject1).d = (l3 + ((hlh)localObject1).d);
      localObject1 = this.jdField_a_of_type_Hlh;
      ((hlh)localObject1).e = (l2 + ((hlh)localObject1).e);
      localObject1 = this.jdField_a_of_type_Hlh;
      ((hlh)localObject1).f += l4;
      localObject1 = this.jdField_a_of_type_Hlh;
      ((hlh)localObject1).jdField_a_of_type_Int += 1;
      localObject1 = BaseApplicationImpl.a;
      localObject2 = this.jdField_a_of_type_Hlh;
      ((hlh)localObject2).g += ((MQLruCache)localObject1).maxSize();
      localObject2 = this.jdField_a_of_type_Hlh;
      ((hlh)localObject2).h += ((MQLruCache)localObject1).size();
      localObject2 = this.jdField_a_of_type_Hlh;
      ((hlh)localObject2).jdField_c_of_type_Int += ((MQLruCache)localObject1).hitCount();
      localObject2 = this.jdField_a_of_type_Hlh;
      i = ((hlh)localObject2).jdField_b_of_type_Int;
      ((hlh)localObject2).jdField_b_of_type_Int = (((MQLruCache)localObject1).missCount() + i);
      l1 = System.currentTimeMillis();
      try
      {
        if (l1 - this.jdField_a_of_type_Hlh.jdField_a_of_type_Long <= 86400000L) {
          break label1040;
        }
        i = this.jdField_a_of_type_Hlh.jdField_a_of_type_Int;
        localObject1 = new HashMap();
        l2 = this.jdField_a_of_type_Hlh.jdField_b_of_type_Long / 1024L;
        if (l2 <= 0L) {
          throw new IllegalStateException("sysTotalMemory illegal");
        }
      }
      catch (IllegalStateException localIllegalStateException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.Memory.MemoryManager", 2, "reportMemoryInfo exception", localIllegalStateException);
        }
        this.jdField_a_of_type_Hlh.b();
        this.jdField_a_of_type_Hlh.c();
        return;
        localIllegalStateException.put("sysTotalMemory", String.valueOf(l2));
        l2 = this.jdField_a_of_type_Hlh.jdField_c_of_type_Long / 1024L;
        if (l2 > 0L) {
          break;
        }
        throw new IllegalStateException("sysClassMemory illegal");
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.d("Q.Memory.MemoryManager", 2, "reportMemoryInfo exception", localException);
    return;
    localException.put("sysClassMemory", String.valueOf(l2));
    l2 = this.jdField_a_of_type_Hlh.d / (i * 1024);
    if (l2 <= 0L) {
      throw new IllegalStateException("sysAvailableMemory illegal");
    }
    localException.put("sysAvailableMemory", String.valueOf(l2));
    l2 = this.jdField_a_of_type_Hlh.e / (i * 1024);
    if (l2 < 0L) {
      throw new IllegalStateException("qqOtherUsedMemory illegal");
    }
    localException.put("qqOtherUsedMemory", String.valueOf(l2));
    l2 = this.jdField_a_of_type_Hlh.f / (i * 1024);
    if (l2 <= 0L) {
      throw new IllegalStateException("qqUsedMemory illegal");
    }
    localException.put("qqUsedMemory", String.valueOf(l2));
    l2 = this.jdField_a_of_type_Hlh.g / (i * 1024);
    if (l2 < 0L) {
      throw new IllegalStateException("imageCacheMax illegal");
    }
    localException.put("imageCacheMax", String.valueOf(l2));
    l2 = this.jdField_a_of_type_Hlh.h / (i * 1024);
    if (l2 < 0L) {
      throw new IllegalStateException("imageCacheUsed illegal");
    }
    localException.put("imageCacheUsed", String.valueOf(l2));
    l2 = this.jdField_a_of_type_Hlh.jdField_c_of_type_Int / i;
    if (l2 < 0L) {
      throw new IllegalStateException("imageHitCount illegal");
    }
    localException.put("imageHitCount", String.valueOf(l2));
    if (this.jdField_a_of_type_Hlh.jdField_c_of_type_Int + this.jdField_a_of_type_Hlh.jdField_b_of_type_Int != 0) {}
    for (int i = this.jdField_a_of_type_Hlh.jdField_c_of_type_Int * 100 / (this.jdField_a_of_type_Hlh.jdField_c_of_type_Int + this.jdField_a_of_type_Hlh.jdField_b_of_type_Int);; i = 0)
    {
      l2 = i;
      if (l2 < 0L) {
        throw new IllegalStateException("imageHitRate illegal");
      }
      localException.put("imageHitRate", String.valueOf(l2));
      localException.put("guardConfigId", hjz.a().a());
      localException.put("memoryConfigId", MemoryConfigs.a().a);
      localException.put("osVersion", Build.VERSION.RELEASE);
      localException.put("resolution", DeviceInfoUtil.k());
      StatisticCollector.a(BaseApplicationImpl.a()).a(null, "actMemory", true, 0L, 0L, localException, null);
      this.jdField_a_of_type_Hlh.jdField_a_of_type_Long = l1;
      this.jdField_a_of_type_Hlh.b();
      label1040:
      if (QLog.isColorLevel()) {
        QLog.d("Q.Memory.MemoryManager", 2, "reportMemoryInfo, startTime=" + this.jdField_a_of_type_Hlh.jdField_a_of_type_Long + ", statCount=" + this.jdField_a_of_type_Hlh.jdField_a_of_type_Int + ", sysTotalMemory=" + this.jdField_a_of_type_Hlh.jdField_b_of_type_Long + ", sysAvailableMemory=" + this.jdField_a_of_type_Hlh.d + ", qqOtherUsedMemory=" + this.jdField_a_of_type_Hlh.e + ", qqUsedMemory=" + this.jdField_a_of_type_Hlh.f + ",imageCacheMax=" + this.jdField_a_of_type_Hlh.g + ",imageCacheUsed=" + this.jdField_a_of_type_Hlh.h + ",imageHitCount=" + this.jdField_a_of_type_Hlh.jdField_c_of_type_Int + ",imageHitTotal=" + (this.jdField_a_of_type_Hlh.jdField_c_of_type_Int + this.jdField_a_of_type_Hlh.jdField_b_of_type_Int));
      }
      this.jdField_a_of_type_Hlh.c();
      return;
      label1238:
      break;
    }
  }
  
  public void b(long paramLong1, long paramLong2)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      hlg localhlg = a();
      localhlg.jdField_c_of_type_Long += paramLong2;
      localhlg.d += paramLong1;
      localhlg.jdField_b_of_type_Int += 1;
      localhlg.c();
      return;
    }
  }
  
  protected void c()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      localhlg = a();
      l1 = System.currentTimeMillis();
      long l2 = localhlg.e;
      if (l1 - l2 > 86400000L) {}
      for (;;)
      {
        try
        {
          i = localhlg.jdField_a_of_type_Int;
          j = localhlg.jdField_b_of_type_Int;
          HashMap localHashMap = new HashMap();
          localHashMap.put("sysTotalMemory", String.valueOf(DeviceInfoUtil.c() / 1024L));
          if (i != 0) {
            continue;
          }
          str = "0";
          localHashMap.put("lowWarningMemory", str);
          if (i != 0) {
            continue;
          }
          str = "0";
          localHashMap.put("lowRemainMemory", str);
          localHashMap.put("lowMemoryCount", String.valueOf(i));
          if (j != 0) {
            continue;
          }
          str = "0";
          localHashMap.put("clearWarningMemory", str);
          if (j != 0) {
            continue;
          }
          str = "0";
          localHashMap.put("clearRemainMemory", str);
          localHashMap.put("clearCount", String.valueOf(j));
          StatisticCollector.a(BaseApplicationImpl.a()).a(null, "LowMemoryStat", true, 0L, 0L, localHashMap, null);
          if (QLog.isColorLevel()) {
            QLog.d("Q.Memory.MemoryManager", 2, "reportLowMemory, sysTotalMemory=" + String.valueOf(DeviceInfoUtil.c() / 1024L) + ", lowWarningMemory=" + localhlg.jdField_b_of_type_Long + ", lowRemainMemory=" + localhlg.jdField_a_of_type_Long + ", lowMemoryCount=" + i + ", clearWarningMemory=" + localhlg.d + ", clearRemainMemory=" + localhlg.jdField_c_of_type_Long + ",clearCount=" + j);
          }
        }
        catch (Exception localException)
        {
          int i;
          int j;
          String str;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.Memory.MemoryManager", 2, "reportMemoryInfo exception", localException);
          localhlg.b();
          localhlg.e = l1;
          continue;
          localObject1 = finally;
          throw localObject1;
        }
        finally
        {
          localhlg.b();
          localhlg.e = l1;
        }
        localhlg.c();
        return;
        str = String.valueOf(localhlg.jdField_b_of_type_Long / (i * 1024));
        continue;
        str = String.valueOf(localhlg.jdField_a_of_type_Long / (i * 1024));
        continue;
        str = String.valueOf(localhlg.d / (j * 1024));
      }
      l2 = localhlg.jdField_c_of_type_Long / (j * 1024);
      str = String.valueOf(l2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.MemoryManager
 * JD-Core Version:    0.7.0.1
 */