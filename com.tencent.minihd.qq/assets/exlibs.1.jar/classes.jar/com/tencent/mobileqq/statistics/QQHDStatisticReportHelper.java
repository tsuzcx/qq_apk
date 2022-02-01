package com.tencent.mobileqq.statistics;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.util.DateUtil;
import com.tencent.util.SerializeHelper;

public class QQHDStatisticReportHelper
{
  public static final String A = "0X800611C";
  public static final String B = "0X800611D";
  public static final String C = "0X800611E";
  public static final String D = "0X800611F";
  public static final String E = "0X8006120";
  public static final String F = "0X8006280";
  public static final String G = "0X8006281";
  public static final String H = "0X8006282";
  public static final String I = "0X8006283";
  public static final String J = "0X8006284";
  public static final String K = "0X8006285";
  public static final String L = "0X8006286";
  public static final String M = "0X8006287";
  public static final String N = "0X8006288";
  public static final String O = "0X800627B";
  public static final String P = "0X800627C";
  public static final String Q = "0X800627E";
  public static final String R = "0X800627D";
  public static final String S = "0X8006126";
  public static final String T = "0X8006124";
  public static final String U = "0X80060E7";
  public static final String V = "com.tx.xingqubuluo.androidhd";
  public static final String W = "com.tx.gamecenter.android.hd";
  public static final String X = "com.tencent.gouwu.androidhd";
  public static final String Y = "com.androidhd.music";
  public static final String Z = "com.tencent.Health.androidhd";
  public static final int a = 1365;
  private static QQHDStatisticReportHelper.AppLiveSettings a;
  public static final String a;
  public static final String aa = "com.life.andoridhd";
  public static final String ab = "com.tencent.citylife.androidhd";
  public static final String ac = "com.tx.androidhd.txnews.new2";
  public static final String ad = "com.androidhd.ketang";
  public static final String ae = "com.tencent.zhibojian.androidhd";
  public static final String af = "com.tencent.xiaoshuo2.androidhd";
  public static final String ag = "com.tencent.manhua2.androidhd";
  public static final String ah = "com.tencent.donghua.androidhd";
  public static final String ai = "0X8006181";
  public static final String aj = "0X8006182";
  public static final String ak = "0X8006183";
  public static final String al = "0X8006184";
  public static final String am = "0X8006185";
  public static final String an = "0X8006186";
  public static final String ao = "0X800617E";
  public static final String ap = "0X800617F";
  public static final String aq = "0X8006180";
  public static final String ar = "0X800617C";
  public static final String as = "0X800617D";
  public static final String at = "0X800617A";
  public static final String au = "0X800617B";
  public static final String av = "0X800628A";
  public static final int b = 1258;
  public static final String b = "key_sp_app_live_settings_str";
  public static final int c = 1259;
  public static final String c = "0X80060D4";
  public static final int d = 1260;
  public static final String d = "0X80060D5";
  public static final int e = 1268;
  public static final String e = "1";
  public static final int f = 1263;
  public static final String f = "2";
  public static final int g = 1265;
  public static final String g = "3";
  public static final int h = 1264;
  public static final String h = "4";
  public static final int i = 1267;
  public static final String i = "5";
  public static final int j = 1266;
  public static final String j = "0X8005BFC";
  public static final int k = 1281;
  public static final String k = "0X8005BFE";
  public static final int l = 1283;
  public static final String l = "0X8006118";
  public static final int m = 1282;
  public static final String m = "0X8006121";
  public static final String n = "0X8006123";
  public static final String o = "0X8006125";
  public static final String p = "0X8006127";
  public static final String q = "0X8006122";
  public static final String r = "0";
  public static final String s = "1";
  public static final String t = "2";
  public static final String u = "3";
  public static final String v = "4";
  public static final String w = "0X8006143";
  public static final String x = "0X8006119";
  public static final String y = "0X800611A";
  public static final String z = "0X800611B";
  
  static
  {
    jdField_a_of_type_JavaLangString = QQHDStatisticReportHelper.class.getSimpleName();
  }
  
  private static QQHDStatisticReportHelper.AppLiveSettings a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = null;
    if (paramQQAppInterface == null) {
      return null;
    }
    String str = paramQQAppInterface.getPreferences().getString("key_sp_app_live_settings_str", "");
    paramQQAppInterface = localObject;
    if (!TextUtils.isEmpty(str)) {
      paramQQAppInterface = SerializeHelper.a(str);
    }
    return (QQHDStatisticReportHelper.AppLiveSettings)paramQQAppInterface;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_ComTencentMobileqqStatisticsQQHDStatisticReportHelper$AppLiveSettings == null) {
      jdField_a_of_type_ComTencentMobileqqStatisticsQQHDStatisticReportHelper$AppLiveSettings = new QQHDStatisticReportHelper.AppLiveSettings(null);
    }
    jdField_a_of_type_ComTencentMobileqqStatisticsQQHDStatisticReportHelper$AppLiveSettings.startTime = DateUtil.a();
    jdField_a_of_type_ComTencentMobileqqStatisticsQQHDStatisticReportHelper$AppLiveSettings.startTimeStr = DateUtil.a(jdField_a_of_type_ComTencentMobileqqStatisticsQQHDStatisticReportHelper$AppLiveSettings.startTime + "", "yyyy-MM-dd HH:mm:ss");
  }
  
  private static void a(QQAppInterface paramQQAppInterface, QQHDStatisticReportHelper.AppLiveSettings paramAppLiveSettings)
  {
    paramAppLiveSettings = SerializeHelper.a(paramAppLiveSettings);
    if (!TextUtils.isEmpty(paramAppLiveSettings))
    {
      paramQQAppInterface.getPreferences().edit().putString("key_sp_app_live_settings_str", paramAppLiveSettings).commit();
      Log.d(jdField_a_of_type_JavaLangString, "saveAppLiveSettings");
      jdField_a_of_type_ComTencentMobileqqStatisticsQQHDStatisticReportHelper$AppLiveSettings = null;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_ComTencentMobileqqStatisticsQQHDStatisticReportHelper$AppLiveSettings == null) {
      return;
    }
    jdField_a_of_type_ComTencentMobileqqStatisticsQQHDStatisticReportHelper$AppLiveSettings.endTime = DateUtil.a();
    jdField_a_of_type_ComTencentMobileqqStatisticsQQHDStatisticReportHelper$AppLiveSettings.endTimeStr = DateUtil.a(jdField_a_of_type_ComTencentMobileqqStatisticsQQHDStatisticReportHelper$AppLiveSettings.endTime + "", "yyyy-MM-dd HH:mm:ss");
    jdField_a_of_type_ComTencentMobileqqStatisticsQQHDStatisticReportHelper$AppLiveSettings.liveTime = (jdField_a_of_type_ComTencentMobileqqStatisticsQQHDStatisticReportHelper$AppLiveSettings.endTime - jdField_a_of_type_ComTencentMobileqqStatisticsQQHDStatisticReportHelper$AppLiveSettings.startTime);
    ReportController.a(paramQQAppInterface, "CliOper", "", "", "0X80060E7", "0X80060E7", 0, 0, jdField_a_of_type_ComTencentMobileqqStatisticsQQHDStatisticReportHelper$AppLiveSettings.liveTime + "", "", jdField_a_of_type_ComTencentMobileqqStatisticsQQHDStatisticReportHelper$AppLiveSettings.startTimeStr, jdField_a_of_type_ComTencentMobileqqStatisticsQQHDStatisticReportHelper$AppLiveSettings.endTimeStr);
    Log.d(jdField_a_of_type_JavaLangString, "tag:CliOper - actionName:app live - live time:" + jdField_a_of_type_ComTencentMobileqqStatisticsQQHDStatisticReportHelper$AppLiveSettings.liveTime + "start time string:" + jdField_a_of_type_ComTencentMobileqqStatisticsQQHDStatisticReportHelper$AppLiveSettings.startTimeStr + "end time string:" + jdField_a_of_type_ComTencentMobileqqStatisticsQQHDStatisticReportHelper$AppLiveSettings.endTimeStr);
    jdField_a_of_type_ComTencentMobileqqStatisticsQQHDStatisticReportHelper$AppLiveSettings = null;
  }
  
  private static void c(QQAppInterface paramQQAppInterface)
  {
    QQHDStatisticReportHelper.AppLiveSettings localAppLiveSettings = a(paramQQAppInterface);
    if (localAppLiveSettings != null)
    {
      ReportController.a(paramQQAppInterface, "CliOper", "", "", "0X80060E7", "0X80060E7", 0, 0, localAppLiveSettings.liveTime + "", localAppLiveSettings.startTimeStr, localAppLiveSettings.endTimeStr, "");
      Log.d(jdField_a_of_type_JavaLangString, "tag:CliOper - actionName:app live - live time:" + localAppLiveSettings.liveTime + "start time string:" + localAppLiveSettings.startTimeStr + "end time string:" + localAppLiveSettings.endTimeStr);
    }
    d(paramQQAppInterface);
  }
  
  private static void d(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface.getPreferences().edit().remove("key_sp_app_live_settings_str").commit();
    Log.d(jdField_a_of_type_JavaLangString, "cleanAppLiveSettings");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.QQHDStatisticReportHelper
 * JD-Core Version:    0.7.0.1
 */