package com.tencent.mobileqq.servlet;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.AlarmManager;
import android.app.KeyguardManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.ContentObserver;
import android.text.TextUtils;
import com.tencent.common.config.provider.QZoneConfigProvider;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.model.QZonePreDownloadManager;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jvk;
import jvl;
import jvm;
import jvn;

public class QZonePreDownloadManagerImp
  extends BroadcastReceiver
  implements QZonePreDownloadManager
{
  static int jdField_a_of_type_Int = 5;
  private static QZonePreDownloadManagerImp jdField_a_of_type_ComTencentMobileqqServletQZonePreDownloadManagerImp;
  public static final String a = "QZonePreDownload";
  static SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat;
  static final int jdField_b_of_type_Int = 60000;
  static final long jdField_b_of_type_Long = 86400000L;
  private static int jdField_c_of_type_Int = 0;
  private static String jdField_c_of_type_JavaLangString;
  long jdField_a_of_type_Long;
  private AlarmManager jdField_a_of_type_AndroidAppAlarmManager;
  private PendingIntent jdField_a_of_type_AndroidAppPendingIntent;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private ContentObserver jdField_a_of_type_AndroidDatabaseContentObserver;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private String jdField_b_of_type_JavaLangString = "";
  ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    jdField_c_of_type_JavaLangString = "qz_predownload_config";
  }
  
  public QZonePreDownloadManagerImp(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QZonePreDownload", 4, "QZonePreDownloadManagerImp Creator");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    jdField_a_of_type_Int = 5;
    e();
  }
  
  private long a()
  {
    for (;;)
    {
      try
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("QZonePreDownload", 4, " cpu run");
        }
        Object localObject2 = "";
        Object localObject1 = localObject2;
        try
        {
          InputStream localInputStream = Runtime.getRuntime().exec("top -n 1").getInputStream();
          localObject1 = localObject2;
          BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localInputStream));
          localObject1 = localObject2;
          String str2 = localBufferedReader.readLine();
          localObject2 = str2;
          if (str2 == null) {
            continue;
          }
          localObject2 = str2;
          localObject1 = str2;
          if (!str2.startsWith("User")) {
            continue;
          }
          localObject1 = str2;
          localObject2 = localBufferedReader.readLine();
          localObject1 = localObject2;
          if (QLog.isDevelopLevel())
          {
            localObject1 = localObject2;
            QLog.d("QZonePreDownload", 4, "cpu run if " + (String)localObject2);
          }
          localObject1 = localObject2;
          if (localInputStream != null)
          {
            localObject1 = localObject2;
            localBufferedReader.close();
            localObject1 = localObject2;
            localInputStream.close();
            localObject1 = localObject2;
          }
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
          continue;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("QZonePreDownload", 4, "cpu run return" + localObject1);
        }
        if (localObject1 == null)
        {
          l = 0L;
          return l;
        }
      }
      finally {}
      long l = a(str1);
    }
  }
  
  private long a(String paramString)
  {
    long l2 = 0L;
    for (;;)
    {
      int i;
      try
      {
        paramString = paramString.split("\\=");
        if (paramString.length <= 1) {
          break label169;
        }
        l3 = Long.valueOf(paramString[1].trim()).longValue();
        paramString = paramString[0].split("\\+");
        l1 = 0L;
        i = 0;
        if (i >= paramString.length) {
          break label184;
        }
        String[] arrayOfString = paramString[i].trim().split(" ");
        l2 = l1;
        if (!"Idle".equals(arrayOfString[0])) {
          break label174;
        }
        l2 = l1;
        if (arrayOfString.length <= 1) {
          break label174;
        }
        l2 = Long.valueOf(arrayOfString[1]).longValue();
      }
      finally {}
      long l3 = 0L;
      if (l1 != 0L) {
        l3 = 100L - l2 * 100L / l1;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("QZonePreDownload", 4, "cpu usage:" + l3);
      }
      return l3;
      label169:
      long l1 = 0L;
      continue;
      label174:
      i += 1;
      l1 = l2;
      continue;
      label184:
      l2 = l1;
      l1 = l3;
    }
  }
  
  private void a(long paramLong)
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplication.getContext().getSharedPreferences(jdField_c_of_type_JavaLangString, 0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null) {
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "callQzoneTime" + paramLong;
    if (QLog.isDevelopLevel()) {
      QLog.d("QZonePreDownload", 4, "QZonePreDownloadManagerImp setCurPeriodDownLoadComplete save config key: " + str);
    }
    int i = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt(str, 0);
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt(str, i + 1).commit();
  }
  
  private void a(long paramLong1, long paramLong2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QZonePreDownload", 4, "setAlarm ,periodStartTime" + jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(paramLong1)) + " \n periodEndTime" + jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(paramLong2)) + "\n,interval:" + jdField_a_of_type_Int);
    }
    Intent localIntent = new Intent(this.jdField_b_of_type_JavaLangString);
    localIntent.setAction(this.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("periodStartTime", paramLong1);
    localIntent.putExtra("periodEndTime", paramLong2);
    localIntent.putExtra("interval", jdField_a_of_type_Int * 60000);
    this.jdField_a_of_type_AndroidAppPendingIntent = PendingIntent.getBroadcast(BaseApplication.getContext(), jdField_c_of_type_Int, localIntent, 268435456);
    this.jdField_a_of_type_AndroidAppAlarmManager = ((AlarmManager)BaseApplication.getContext().getSystemService("alarm"));
    this.jdField_a_of_type_AndroidAppAlarmManager.set(0, paramLong1, this.jdField_a_of_type_AndroidAppPendingIntent);
  }
  
  private void b(Context paramContext, Intent paramIntent)
  {
    ThreadManager.a(new jvl(this, paramContext, paramIntent));
  }
  
  private boolean b()
  {
    boolean bool2 = false;
    String str = BaseApplication.getContext().getPackageName();
    if (QLog.isDevelopLevel()) {
      QLog.d("QZonePreDownload", 4, "mainProcessName:" + str);
    }
    Object localObject = (ActivityManager)BaseApplication.getContext().getSystemService("activity");
    KeyguardManager localKeyguardManager = (KeyguardManager)BaseApplication.getContext().getSystemService("keyguard");
    localObject = ((ActivityManager)localObject).getRunningAppProcesses();
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
      do
      {
        bool1 = bool2;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      } while (!localRunningAppProcessInfo.processName.equals(str));
      if (QLog.isDevelopLevel()) {
        QLog.d("QZonePreDownload", 4, "runningAppProcessInfo.processName: " + localRunningAppProcessInfo.processName);
      }
      i = localRunningAppProcessInfo.importance;
      if (QLog.isDevelopLevel()) {
        QLog.d("QZonePreDownload", 4, "runningAppProcessInfo progress importance status: " + i);
      }
      if ((i == 200) || (i == 100)) {
        break label242;
      }
    }
    label242:
    for (int i = 1;; i = 0)
    {
      boolean bool3 = localKeyguardManager.inKeyguardRestrictedInputMode();
      if (i == 0)
      {
        bool1 = bool2;
        if (!bool3) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
  }
  
  private boolean c()
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplication.getContext().getSharedPreferences(jdField_c_of_type_JavaLangString, 0);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null) {
      return false;
    }
    Object localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "");
    if (QLog.isDevelopLevel()) {
      QLog.d("QZonePreDownload", 4, "QZonePreDownloadManagerImp parseConfig saveConfig:" + (String)localObject1);
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return false;
    }
    localObject1 = Pattern.compile("(\\{.*?\\})+").matcher((CharSequence)localObject1);
    long l = 0L;
    while (((Matcher)localObject1).find())
    {
      Object localObject2 = ((Matcher)localObject1).group();
      if (((String)localObject2).contains("LastEnterQzoneTime"))
      {
        localObject2 = Pattern.compile("\\d+").matcher((CharSequence)localObject2);
        while (((Matcher)localObject2).find())
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("QZonePreDownload", 4, "QZonePreDownloadManagerImp parseConfig LastEnterQzoneTime:" + ((Matcher)localObject2).group());
          }
          l = Long.valueOf(((Matcher)localObject2).group()).longValue();
        }
      }
    }
    if (l == 0L) {
      return false;
    }
    int i = QzoneConfig.a().a("PhotoDownload", "MaxDays", 5);
    if (QLog.isDevelopLevel()) {
      QLog.d("QZonePreDownload", 4, "QZonePreDownloadManagerImp maxDays: " + i);
    }
    this.jdField_a_of_type_Long = (l + i * 86400000L);
    if (QLog.isDevelopLevel()) {
      QLog.d("QZonePreDownload", 4, "QZonePreDownloadManagerImp parseConfig expireDate:" + jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(this.jdField_a_of_type_Long)));
    }
    if (System.currentTimeMillis() >= this.jdField_a_of_type_Long)
    {
      l();
      return false;
    }
    return true;
  }
  
  private boolean d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return false;
    }
    Object localObject1 = QzoneConfig.a().a("PhotoDownload", "TimeZone", "14:0-15:0|14:11-15:11|14:22-15:22|14:33-15:33|14:44-15:44|14:55-15:55|15:6-16:6|15:17-16:17|15:28-16:28|15:39-16:39|15:50-16:50|16:1-17:1|16:12-17:12|16:23-17:23|16:34-17:34|16:45-17:45|16:56-17:56|17:7-18:7|17:18-18:18|17:29-18:29|17:40-18:40|17:51-18:51|18:2-19:2|18:13-19:13|18:24-19:24");
    if (QLog.isDevelopLevel()) {
      QLog.d("QZonePreDownload", 4, "QZonePreDownloadManagerImp timeZoneConfigStr: " + (String)localObject1);
    }
    localObject1 = ((String)localObject1).split("\\|");
    localObject1 = localObject1[((int)(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin() % localObject1.length))];
    if (QLog.isDevelopLevel()) {
      QLog.d("QZonePreDownload", 4, "QZonePreDownloadManagerImp matchConfigStr: " + (String)localObject1);
    }
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      l();
      return false;
    }
    if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() != 0)) {
      this.jdField_b_of_type_JavaUtilArrayList.clear();
    }
    localObject1 = Pattern.compile("\\d+:\\d+").matcher((CharSequence)localObject1);
    while (((Matcher)localObject1).find())
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("QZonePreDownload", 4, "QZonePreDownloadManagerImp parseConfig period:" + ((Matcher)localObject1).group());
      }
      this.jdField_b_of_type_JavaUtilArrayList.add(((Matcher)localObject1).group());
    }
    long l2 = System.currentTimeMillis();
    localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).setTimeInMillis(l2);
    ((Calendar)localObject1).set(10, 0);
    ((Calendar)localObject1).set(12, 0);
    ((Calendar)localObject1).set(13, 0);
    ((Calendar)localObject1).set(14, 0);
    long l1 = ((Calendar)localObject1).getTimeInMillis();
    if (QLog.isDevelopLevel()) {
      QLog.d("QZonePreDownload", 4, ",curDay:" + jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(l1)));
    }
    Object localObject2 = new BigDecimal(this.jdField_a_of_type_Long - l2);
    Object localObject3 = new BigDecimal(86400000L);
    try
    {
      i = ((BigDecimal)localObject2).divide((BigDecimal)localObject3, 2, 1).intValue();
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() != 0)) {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("QZonePreDownload", 4, ",lefDays" + i);
      }
      j = 0;
      if (j <= i)
      {
        localObject2 = new ArrayList();
        l2 = j * 86400000L + l1;
        ((Calendar)localObject1).setTimeInMillis(l2);
        if (QLog.isDevelopLevel()) {
          QLog.d("QZonePreDownload", 4, ",shedule Day:" + jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(l2)));
        }
        localObject3 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          String[] arrayOfString = ((String)((Iterator)localObject3).next()).split(":");
          if (arrayOfString.length == 2)
          {
            if (QLog.isDevelopLevel()) {
              QLog.d("QZonePreDownload", 4, ",shedule hour:" + Integer.valueOf(arrayOfString[0]) + "and minute:" + Integer.valueOf(arrayOfString[1]));
            }
            ((Calendar)localObject1).set(11, Integer.valueOf(arrayOfString[0]).intValue());
            ((Calendar)localObject1).set(12, Integer.valueOf(arrayOfString[1]).intValue());
            ((Calendar)localObject1).set(13, 0);
            ((Calendar)localObject1).set(14, 0);
            l2 = ((Calendar)localObject1).getTimeInMillis();
            if (QLog.isDevelopLevel()) {
              QLog.d("QZonePreDownload", 4, ",shedule time:" + jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(l2)));
            }
            ((ArrayList)localObject2).add(Long.valueOf(l2));
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int j;
        localException.printStackTrace();
        int i = -1;
        continue;
        this.jdField_a_of_type_JavaUtilArrayList.add(localException);
        j += 1;
      }
    }
    return true;
  }
  
  private void e()
  {
    ThreadManager.a(new jvk(this));
  }
  
  private void f()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QZonePreDownload", 4, "QZonePreDownloadManagerImp cancleAlarm");
    }
    Intent localIntent = new Intent(this.jdField_b_of_type_JavaLangString);
    localIntent.setAction(this.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("periodStartTime", 0);
    localIntent.putExtra("periodEndTime", 0);
    localIntent.putExtra("interval", jdField_a_of_type_Int * 60000);
    this.jdField_a_of_type_AndroidAppPendingIntent = PendingIntent.getBroadcast(BaseApplication.getContext(), jdField_c_of_type_Int, localIntent, 268435456);
    this.jdField_a_of_type_AndroidAppAlarmManager = ((AlarmManager)BaseApplication.getContext().getSystemService("alarm"));
    this.jdField_a_of_type_AndroidAppAlarmManager.cancel(this.jdField_a_of_type_AndroidAppPendingIntent);
  }
  
  /* Error */
  private void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 67	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   5: ifeq +12 -> 17
    //   8: ldc 13
    //   10: iconst_4
    //   11: ldc_w 520
    //   14: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: aload_0
    //   18: invokespecial 523	com/tencent/mobileqq/servlet/QZonePreDownloadManagerImp:k	()V
    //   21: aload_0
    //   22: invokespecial 525	com/tencent/mobileqq/servlet/QZonePreDownloadManagerImp:c	()Z
    //   25: istore_1
    //   26: iload_1
    //   27: ifne +6 -> 33
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: aload_0
    //   34: invokespecial 527	com/tencent/mobileqq/servlet/QZonePreDownloadManagerImp:d	()Z
    //   37: istore_1
    //   38: iload_1
    //   39: ifne -9 -> 30
    //   42: goto -12 -> 30
    //   45: astore_2
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_2
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	QZonePreDownloadManagerImp
    //   25	14	1	bool	boolean
    //   45	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	45	finally
    //   17	26	45	finally
    //   33	38	45	finally
  }
  
  private void h()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QZonePreDownload", 4, "QZonePreDownloadManagerImp triggerAlarm");
    }
    long l = System.currentTimeMillis();
    if (QLog.isDevelopLevel()) {
      QLog.d("QZonePreDownload", 4, "triggerAlarm curTime:" + jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(l)) + ",expireDate:" + jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(this.jdField_a_of_type_Long)));
    }
    if (l > this.jdField_a_of_type_Long)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("QZonePreDownload", 4, "QZonePreDownloadManagerImp triggerAlarm  cancle alarm");
      }
      f();
    }
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("QZonePreDownload", 4, "QZonePreDownloadManagerImp triggerAlarm periods is empty");
        }
        g();
      }
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        int i = 0;
        while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          int k = ((ArrayList)this.jdField_a_of_type_JavaUtilArrayList.get(i)).size() / 2;
          if ((this.jdField_a_of_type_JavaUtilArrayList.get(i) != null) && (k > 0))
          {
            int j = 0;
            while (j < k)
            {
              Long localLong1 = (Long)((ArrayList)this.jdField_a_of_type_JavaUtilArrayList.get(i)).get(j * 2);
              Long localLong2 = (Long)((ArrayList)this.jdField_a_of_type_JavaUtilArrayList.get(i)).get(j * 2 + 1);
              if (QLog.isDevelopLevel()) {
                QLog.d("QZonePreDownload", 4, "QZonePreDownloadManagerImp triggerAlarm,curPeroidStartTime:" + jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(localLong1.longValue())) + ",curPeriodEndTime:" + jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(localLong2.longValue())) + ",curTime" + jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(l)));
              }
              if ((localLong1 != null) && (localLong2 != null))
              {
                if (l <= localLong1.longValue())
                {
                  a(localLong1.longValue(), localLong2.longValue());
                  return;
                }
                if ((localLong1.longValue() < l) && (l < localLong2.longValue()))
                {
                  a(l, localLong2.longValue());
                  return;
                }
                if (localLong2.longValue() >= l) {}
              }
              j += 1;
            }
          }
          i += 1;
        }
      }
    }
  }
  
  private void i()
  {
    if ((BaseApplication.getContext() != null) && (BaseApplication.getContext().getContentResolver() != null)) {}
    try
    {
      j();
      BaseApplication.getContext().getContentResolver().registerContentObserver(QZoneConfigProvider.g, true, this.jdField_a_of_type_AndroidDatabaseContentObserver);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isDevelopLevel()) {}
      QLog.d("QZonePreDownload", 4, "registObserver error", localException);
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_AndroidDatabaseContentObserver == null) {
      this.jdField_a_of_type_AndroidDatabaseContentObserver = new jvn(this, ThreadManager.b());
    }
  }
  
  private void k()
  {
    jdField_a_of_type_Int = QzoneConfig.a().a("PhotoDownload", "interval", 5);
  }
  
  private void l()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QZonePreDownload", 4, "QZonePreDownloadManagerImp cancelDownload");
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() != 0)) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    f();
  }
  
  private void m()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QZonePreDownload", 4, "QZonePreDownloadManagerImp triggerAlarm");
    }
    long l = System.currentTimeMillis();
    if (QLog.isDevelopLevel()) {
      QLog.d("QZonePreDownload", 4, "triggerAlarm curTime:" + jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(l)) + ",expireDate:" + jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(this.jdField_a_of_type_Long)));
    }
    if (l > this.jdField_a_of_type_Long)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("QZonePreDownload", 4, "QZonePreDownloadManagerImp triggerAlarm  cancle alarm");
      }
      f();
    }
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("QZonePreDownload", 4, "QZonePreDownloadManagerImp triggerAlarm periods is empty");
        }
        g();
      }
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        int i = 0;
        while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          int k = ((ArrayList)this.jdField_a_of_type_JavaUtilArrayList.get(i)).size() / 2;
          if ((this.jdField_a_of_type_JavaUtilArrayList.get(i) != null) && (k > 0))
          {
            int j = 0;
            if (j < k)
            {
              Long localLong1 = (Long)((ArrayList)this.jdField_a_of_type_JavaUtilArrayList.get(i)).get(j * 2);
              Long localLong2 = (Long)((ArrayList)this.jdField_a_of_type_JavaUtilArrayList.get(i)).get(j * 2 + 1);
              if (QLog.isDevelopLevel()) {
                QLog.d("QZonePreDownload", 4, "QZonePreDownloadManagerImp triggerAlarm,curPeroidStartTime:" + jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(localLong1.longValue())) + ",curPeriodEndTime:" + jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(localLong2.longValue())) + ",curTime" + jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(l)));
              }
              if ((localLong1 != null) && (localLong2 != null))
              {
                if (l <= localLong1.longValue())
                {
                  a(localLong1.longValue(), localLong2.longValue());
                  return;
                }
                if ((localLong1.longValue() >= l) || (l >= localLong2.longValue())) {
                  break label408;
                }
              }
              for (;;)
              {
                j += 1;
                break;
                label408:
                if (localLong2.longValue() >= l) {}
              }
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QZonePreDownload", 4, "UnregisterPreDownloadEvent");
    }
    f();
  }
  
  public void a(Context paramContext, Intent paramIntent)
  {
    long l2 = System.currentTimeMillis();
    long l3 = paramIntent.getLongExtra("periodStartTime", 0L);
    long l1 = paramIntent.getLongExtra("periodEndTime", 0L);
    if (QLog.isDevelopLevel()) {
      QLog.d("QZonePreDownload", 4, "QZonePreDownloadManagerImp onReceive,curPeroidStartTime:" + jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(l3)) + ",curPeriodEndTime:" + jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(l1)) + ",curTime" + jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(l2)));
    }
    if (l2 > l1)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("QZonePreDownload", 4, "onReceive curTime > curPeriodEndTime,start next alarm pair");
      }
      h();
    }
    boolean bool;
    do
    {
      return;
      if (QLog.isDevelopLevel()) {
        QLog.d("QZonePreDownload", 4, "QZonePreDownloadManagerImp onReceive prepare to download");
      }
      bool = a(l1);
      if (QLog.isDevelopLevel()) {
        QLog.d("QZonePreDownload", 4, "QZonePreDownloadManagerImp onReceive download config:" + bool);
      }
      if (!bool)
      {
        paramIntent = new Random();
        int i = Math.abs(paramIntent.nextInt());
        int j = jdField_a_of_type_Int;
        Math.abs(paramIntent.nextInt());
        int k = jdField_a_of_type_Int;
        l2 = System.currentTimeMillis();
        a((i % j + 1) * 60 * 1000 + l2, l1);
      }
    } while ((bool) || (!NetworkUtil.b(paramContext)) || (!a()) || (a() > 30L));
    if (QLog.isColorLevel()) {
      QLog.d("QZonePreDownload", 2, "QZonePreDownloadManagerImp onReceive start qzone process");
    }
    QZoneHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    long l = System.currentTimeMillis();
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplication.getContext().getSharedPreferences(jdField_c_of_type_JavaLangString, 0);
    }
    paramString2 = "{LastEnterQzoneTime:" + l + "}";
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString(paramString1, paramString2).commit();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplication.getContext().getSharedPreferences(jdField_c_of_type_JavaLangString, 0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null) {
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "curStartTime";
    long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(str, 0L);
    str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "curEndTime";
    long l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(str, 0L);
    long l3 = System.currentTimeMillis();
    if ((l1 < l3) && (l3 <= l2))
    {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "downloadCompleted" + l2;
      if (QLog.isDevelopLevel()) {
        QLog.d("QZonePreDownload", 4, "QZonePreDownloadManagerImp setCurPeriodDownLoadComplete save config key: " + str);
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean(str, paramBoolean).commit();
    }
    m();
  }
  
  /* Error */
  boolean a()
  {
    // Byte code:
    //   0: invokestatic 194	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   3: invokevirtual 308	android/content/Context:getPackageName	()Ljava/lang/String;
    //   6: astore 4
    //   8: invokestatic 194	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   11: ldc_w 312
    //   14: invokevirtual 279	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   17: checkcast 314	android/app/ActivityManager
    //   20: iconst_1
    //   21: invokevirtual 666	android/app/ActivityManager:getRunningTasks	(I)Ljava/util/List;
    //   24: astore 5
    //   26: aload 5
    //   28: ifnull +153 -> 181
    //   31: aload 5
    //   33: invokeinterface 667 1 0
    //   38: ifne +6 -> 44
    //   41: goto +140 -> 181
    //   44: aload 5
    //   46: iconst_0
    //   47: invokeinterface 668 2 0
    //   52: checkcast 670	android/app/ActivityManager$RunningTaskInfo
    //   55: getfield 674	android/app/ActivityManager$RunningTaskInfo:topActivity	Landroid/content/ComponentName;
    //   58: invokevirtual 677	android/content/ComponentName:getPackageName	()Ljava/lang/String;
    //   61: astore 5
    //   63: invokestatic 67	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   66: ifeq +30 -> 96
    //   69: ldc 13
    //   71: iconst_4
    //   72: new 125	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   79: ldc_w 679
    //   82: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload 5
    //   87: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   96: aload 4
    //   98: aload 5
    //   100: invokevirtual 177	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   103: istore_1
    //   104: iload_1
    //   105: ifeq +60 -> 165
    //   108: iconst_0
    //   109: istore_1
    //   110: iload_1
    //   111: istore_2
    //   112: iload_1
    //   113: istore_3
    //   114: invokestatic 67	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   117: ifeq +66 -> 183
    //   120: iload_1
    //   121: istore_2
    //   122: ldc 13
    //   124: iconst_4
    //   125: new 125	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   132: ldc_w 681
    //   135: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: iload_1
    //   139: invokevirtual 605	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   142: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   148: iload_1
    //   149: ireturn
    //   150: astore 4
    //   152: iload_1
    //   153: istore_2
    //   154: aload 4
    //   156: invokevirtual 508	java/lang/Exception:printStackTrace	()V
    //   159: iload_1
    //   160: ireturn
    //   161: astore 4
    //   163: iload_2
    //   164: ireturn
    //   165: iconst_1
    //   166: istore_1
    //   167: goto -57 -> 110
    //   170: astore 4
    //   172: iconst_0
    //   173: ireturn
    //   174: astore 4
    //   176: iconst_0
    //   177: istore_1
    //   178: goto -26 -> 152
    //   181: iconst_0
    //   182: istore_3
    //   183: iload_3
    //   184: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	QZonePreDownloadManagerImp
    //   103	75	1	bool1	boolean
    //   111	53	2	bool2	boolean
    //   113	71	3	bool3	boolean
    //   6	91	4	str	String
    //   150	5	4	localException1	Exception
    //   161	1	4	localObject1	Object
    //   170	1	4	localObject2	Object
    //   174	1	4	localException2	Exception
    //   24	75	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   114	120	150	java/lang/Exception
    //   122	148	150	java/lang/Exception
    //   114	120	161	finally
    //   122	148	161	finally
    //   154	159	161	finally
    //   0	26	170	finally
    //   31	41	170	finally
    //   44	96	170	finally
    //   96	104	170	finally
    //   0	26	174	java/lang/Exception
    //   31	41	174	java/lang/Exception
    //   44	96	174	java/lang/Exception
    //   96	104	174	java/lang/Exception
  }
  
  public boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplication.getContext().getSharedPreferences(jdField_c_of_type_JavaLangString, 0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null) {
      return false;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "downloadCompleted" + paramLong;
    if (QLog.isDevelopLevel()) {
      QLog.d("QZonePreDownload", 4, "QZonePreDownloadManagerImp isDowloadCompleted getconfig key: " + str);
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean(str, false);
  }
  
  public void b()
  {
    g();
    c();
    h();
  }
  
  public void c()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QZonePreDownload", 4, "QZonePreDownloadManagerImp registerBroadcastReceiver");
    }
    this.jdField_b_of_type_JavaLangString = (MsfSdkUtils.getProcessName(BaseApplication.getContext()) + "_" + getClass().hashCode());
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction(this.jdField_b_of_type_JavaLangString);
    BaseApplication.getContext().registerReceiver(this, localIntentFilter);
  }
  
  public void d()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QZonePreDownload", 4, "onConfigChange");
    }
    ThreadManager.a(new jvm(this));
  }
  
  public void onDestroy()
  {
    try
    {
      BaseApplication.getContext().unregisterReceiver(this);
      if (this.jdField_a_of_type_AndroidDatabaseContentObserver != null)
      {
        BaseApplication.getContext().getContentResolver().unregisterContentObserver(this.jdField_a_of_type_AndroidDatabaseContentObserver);
        this.jdField_a_of_type_AndroidDatabaseContentObserver = null;
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException = localException;
      } while (!QLog.isColorLevel());
      QLog.e("QZonePreDownload", 2, "onDestroy", localException);
      return;
    }
    finally {}
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QZonePreDownload", 4, "QZonePreDownloadManagerImp onReceive");
    }
    b(paramContext, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZonePreDownloadManagerImp
 * JD-Core Version:    0.7.0.1
 */