package com.tencent.mobileqq.app.automator.step;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqwifi.QQWiFiCommonServlet;
import cooperation.qqwifi.QQWiFiHelper;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

public class ReportQQWifiInfo
  extends AsyncStep
{
  protected int a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReportQQWifiInfo", 2, "dostep");
    }
    if ((QQWiFiHelper.a(this.a.a.getApplication())) || (QQWiFiHelper.b(this.a.a.getApplication())))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ReportQQWifiInfo", 2, "start report");
      }
      QQWiFiHelper.a(this.a.a, true);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ReportQQWifiInfo", 2, "return ok");
      }
      if (QQWiFiHelper.b(this.a.a.getApplication().getApplicationContext(), this.a.a.a()))
      {
        localObject = new NewIntent(this.a.a.getApplication(), QQWiFiCommonServlet.class);
        ((NewIntent)localObject).putExtra("cmd", 1);
        this.a.a.startServlet((NewIntent)localObject);
      }
      Object localObject = BaseApplication.getContext().getSharedPreferences(this.a.a.a(), 0);
      int i = ((SharedPreferences)localObject).getInt("showQQWiFiNotifyCount", 0);
      if (i > 0)
      {
        ReportController.b(this.a.a, "CliOper", "", "", "QQWIFI", "showQQWiFiNotifyCount", 0, 0, "" + i, "", "", "");
        ((SharedPreferences)localObject).edit().putInt("showQQWiFiNotifyCount", 0).commit();
      }
      i = ((SharedPreferences)localObject).getInt("QQWiFiShowRedTouch", 0);
      if (i != 0)
      {
        ReportController.b(this.a.a, "CliOper", "", "", "QQWIFI", "QQWiFiShowRedTouch", 0, 0, "" + i, "", "", "");
        ((SharedPreferences)localObject).edit().putInt("QQWiFiShowRedTouch", 0).commit();
      }
      return 7;
      if (QLog.isColorLevel()) {
        QLog.i("ReportQQWifiInfo", 2, "do not need report");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.ReportQQWifiInfo
 * JD-Core Version:    0.7.0.1
 */