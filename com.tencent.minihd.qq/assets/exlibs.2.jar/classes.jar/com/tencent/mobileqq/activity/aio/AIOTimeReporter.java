package com.tencent.mobileqq.activity.aio;

import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.PerformanceReportUtils;
import com.tencent.qphone.base.util.QLog;
import foq;
import java.util.Random;

public class AIOTimeReporter
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 1;
  private static String jdField_c_of_type_JavaLangString = "HighDeviceFirstOpenAIOBusiness";
  public static final int d = 2;
  private static String d = "HighDeviceFirstOpenAIOBase";
  public static final int e = 3;
  private static String e = "HighDeviceNotFirstOpenAIOBusiness";
  public static final int f = 0;
  private static String f = "HighDeviceNotFirstOpenAIOBase";
  public static final int g = 1;
  private static String g = "MidDeviceFirstOpenAIOBusiness";
  private static String jdField_h_of_type_JavaLangString = "MidDeviceFirstOpenAIOBase";
  private static String i = "MidDeviceNotFirstOpenAIOBusiness";
  private static String j = "MidDeviceNotFirstOpenAIOBase";
  private static String k = "LowDeviceFirstOpenAIOBusiness";
  private static String l = "LowDeviceFirstOpenAIOBase";
  private static String m = "LowDeviceNotFirstOpenAIOBusiness";
  private static String n = "LowDeviceNotFirstOpenAIOBase";
  private long jdField_a_of_type_Long = 0L;
  String jdField_a_of_type_JavaLangString = "AIOTimeReporter";
  private boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long = 0L;
  private String jdField_b_of_type_JavaLangString = "0";
  private long jdField_c_of_type_Long = 0L;
  private int jdField_h_of_type_Int = -1;
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    if (new Random().nextInt(100) != 1) {
      return;
    }
    ThreadManager.a(new foq(this));
  }
  
  public void a(int paramInt)
  {
    long l1;
    if (!this.jdField_a_of_type_Boolean)
    {
      l1 = SystemClock.uptimeMillis();
      switch (paramInt)
      {
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_Long = l1;
      return;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_Long = l1;
      this.jdField_b_of_type_JavaLangString = "0";
      this.jdField_b_of_type_JavaLangString = PerformanceReportUtils.a();
      this.jdField_c_of_type_Long = (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long);
    } while (this.jdField_c_of_type_Long <= 4000L);
    if (QLog.isDevelopLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 4, "AIOTime open aio time out : " + this.jdField_c_of_type_Long);
    }
    DeviceInfoUtil.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOTimeReporter
 * JD-Core Version:    0.7.0.1
 */