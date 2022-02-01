package com.tencent.mobileqq.app;

import android.os.Looper;
import android.os.SystemClock;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.qphone.base.util.QLog;
import hkz;

public class LooperMonitorHelper
{
  public static int a = 0;
  private static final String jdField_a_of_type_JavaLangString = "AutoMonitor";
  private static boolean jdField_a_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_Int = 100;
  }
  
  public static void a()
  {
    if (jdField_a_of_type_Boolean) {}
    long l;
    do
    {
      do
      {
        return;
        jdField_a_of_type_Boolean = true;
        l = 0L;
        if (QLog.isDevelopLevel()) {
          l = SystemClock.uptimeMillis();
        }
        UnifiedMonitor.a().a();
      } while (!UnifiedMonitor.a().b(0));
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "start monitor main looper");
      }
      int i = UnifiedMonitor.a().a(2, 0, 100);
      hkz localhkz = new hkz(null);
      localhkz.a(i, false);
      Looper.getMainLooper().setMessageLogging(localhkz);
    } while (!QLog.isDevelopLevel());
    QLog.d("AutoMonitor", 4, "looper's monitor started, cost=" + (SystemClock.uptimeMillis() - l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.LooperMonitorHelper
 * JD-Core Version:    0.7.0.1
 */