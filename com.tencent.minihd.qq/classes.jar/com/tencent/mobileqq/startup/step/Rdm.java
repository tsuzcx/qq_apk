package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.mobileqq.log.ReportLog;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneCrashHandler;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import jwb;

public class Rdm
  extends Step
{
  private static final ScheduledThreadPoolExecutor a = new ScheduledThreadPoolExecutor(3, new jwb());
  
  protected boolean a()
  {
    String str2 = BaseApplicationImpl.processName;
    QLog.d("Rdm", 1, "doStep...process: " + str2);
    if (!str2.endsWith(":MSF")) {}
    for (;;)
    {
      try
      {
        Object localObject = BaseApplicationImpl.a.getAllAccounts();
        if (localObject == null) {
          break label173;
        }
        localObject = (SimpleAccount)((List)localObject).get(0);
        if (localObject == null) {
          break label165;
        }
        localObject = ((SimpleAccount)localObject).getUin();
        if ((str2.equals("com.tencent.minihd.qq")) || (str2.endsWith(":web")))
        {
          Thread.setDefaultUncaughtExceptionHandler(new ReportLog());
          CrashReport.setThreadPoolService(a);
          StatisticCollector.a(BaseApplicationImpl.a).b((String)localObject);
          if (str2.endsWith(":openSdk")) {
            return true;
          }
        }
        else
        {
          if (!str2.endsWith(":qzone")) {
            continue;
          }
          Thread.setDefaultUncaughtExceptionHandler(new QZoneCrashHandler());
          continue;
        }
        StatisticCollector.a(BaseApplicationImpl.a).a(localException);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return true;
      }
      return true;
      label165:
      String str1 = "10000";
      continue;
      return true;
      label173:
      str1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.Rdm
 * JD-Core Version:    0.7.0.1
 */