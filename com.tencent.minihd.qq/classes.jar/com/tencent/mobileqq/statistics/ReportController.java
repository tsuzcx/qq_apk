package com.tencent.mobileqq.statistics;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.mobileqq.servlet.ReportServlet;
import com.tencent.qphone.base.util.QLog;
import jwo;
import mqq.app.NewIntent;

public class ReportController
{
  static final String a = "ReportController";
  public static final String b = "P_CliOper";
  public static final String c = "CliOper";
  @Deprecated
  public static final String d = "on_off";
  public static final String e = "CliStatus";
  public static final String f = "Pb_account_lifeservice";
  public static final String g = "Grp_tribe";
  public static final String h = "BizTechReport";
  private static final String i = "com.tencent.mobileqq.statistics.ReportControllerImpl";
  private static final String j = "${uin_unknown}";
  private static final String k = "${count_unknown}";
  
  private static String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramString1 != null) && (paramString1.length() > 0)) {
      localStringBuilder.append(paramString1).append('|');
    }
    localStringBuilder.append(paramString2).append('|');
    localStringBuilder.append(paramString3).append('|');
    localStringBuilder.append(paramString4).append('|');
    localStringBuilder.append(paramString5).append('|');
    localStringBuilder.append(paramInt1).append('|');
    localStringBuilder.append("${count_unknown}").append('|');
    localStringBuilder.append(paramInt2).append('|');
    localStringBuilder.append(paramString6).append('|');
    localStringBuilder.append(paramString7).append('|');
    localStringBuilder.append(paramString8).append('|');
    localStringBuilder.append(paramString9).append('|');
    return localStringBuilder.toString();
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "stopReportLooper");
    }
    paramQQAppInterface = paramQQAppInterface.a();
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a();
    }
  }
  
  static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramString1 == null) || (paramString2 == null)) {
      return;
    }
    Object localObject = paramString2;
    if (paramString2.contains("${uin_unknown}")) {
      localObject = paramString2.replace("${uin_unknown}", paramQQAppInterface.a());
    }
    paramString2 = ((String)localObject).replace("${count_unknown}", Integer.toString(paramInt));
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "ReportRuntime: " + paramString1 + ", " + paramString2);
    }
    localObject = new NewIntent(paramQQAppInterface.getApplication(), ReportServlet.class);
    ((NewIntent)localObject).putExtra("sendType", 2);
    ((NewIntent)localObject).putExtra("tag", paramString1);
    ((NewIntent)localObject).putExtra("content", paramString2);
    ((NewIntent)localObject).setWithouLogin(true);
    paramQQAppInterface.startServlet((NewIntent)localObject);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    if ((paramString2 == null) || (paramString4 == null) || (paramString5 == null)) {
      return;
    }
    if (paramQQAppInterface == null)
    {
      paramQQAppInterface = a(paramString2, "${uin_unknown}", paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
      paramString2 = new Intent();
      paramString2.setClassName(BaseApplicationImpl.a, "com.tencent.mobileqq.statistics.ReportReceiver");
      paramString2.putExtra("reporting_tag", paramString1);
      paramString2.putExtra("reporting_detail", paramQQAppInterface);
      paramString2.putExtra("reporting_count", paramInt3);
      paramString2.putExtra("is_runtime", 1);
      BaseApplicationImpl.a().sendBroadcast(paramString2);
      return;
    }
    a(paramQQAppInterface, paramString1, a(paramString2, paramQQAppInterface.a(), paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9), paramInt3);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    a(paramQQAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, 1, paramString6, paramString7, paramString8, paramString9);
  }
  
  public static void a(PluginRuntime paramPluginRuntime)
  {
    paramPluginRuntime.setClickEventReportor(new jwo());
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClassName(BaseApplicationImpl.a, "com.tencent.mobileqq.statistics.ReportReceiver");
    localIntent.putExtra("reporting_tag", paramString1);
    localIntent.putExtra("reporting_detail", paramString2);
    localIntent.putExtra("reporting_count", 0);
    localIntent.putExtra("is_runtime", 0);
    BaseApplicationImpl.a().sendBroadcast(localIntent);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "startReportLooper");
    }
    paramQQAppInterface = paramQQAppInterface.a();
    if (paramQQAppInterface != null) {
      if (paramBoolean) {
        break label36;
      }
    }
    label36:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramQQAppInterface.a(paramBoolean);
      return true;
    }
  }
  
  static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if (paramString2 != null)
    {
      ReportController localReportController = paramQQAppInterface.a();
      if (localReportController != null)
      {
        String str = paramString2;
        if (paramString2.contains("${uin_unknown}")) {
          str = paramString2.replace("${uin_unknown}", paramQQAppInterface.a());
        }
        localReportController.a(paramString1, str, paramInt);
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    if ((paramString2 == null) || (paramString4 == null) || (paramString5 == null)) {
      return;
    }
    if (paramQQAppInterface == null)
    {
      paramQQAppInterface = a(paramString2, "${uin_unknown}", paramString3, paramString4, paramString5, paramInt1, paramInt3, paramString6, paramString7, paramString8, paramString9);
      paramString2 = new Intent();
      paramString2.setClassName(BaseApplicationImpl.a, "com.tencent.mobileqq.statistics.ReportReceiver");
      paramString2.putExtra("reporting_tag", paramString1);
      paramString2.putExtra("reporting_detail", paramQQAppInterface);
      paramString2.putExtra("reporting_count", paramInt2);
      paramString2.putExtra("is_runtime", 0);
      BaseApplicationImpl.a().sendBroadcast(paramString2);
      return;
    }
    b(paramQQAppInterface, paramString1, a(paramString2, paramQQAppInterface.a(), paramString3, paramString4, paramString5, paramInt1, paramInt3, paramString6, paramString7, paramString8, paramString9), paramInt2);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    b(paramQQAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, 1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  protected void a() {}
  
  protected void a(String paramString1, String paramString2, int paramInt) {}
  
  protected void a(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.ReportController
 * JD-Core Version:    0.7.0.1
 */