import com.tencent.mobileqq.activity.aio.AIOReporterGetDeviceInfo;
import com.tencent.mobileqq.activity.aio.AIOTimeReporter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class foq
  implements Runnable
{
  public foq(AIOTimeReporter paramAIOTimeReporter) {}
  
  public void run()
  {
    AIOReporterGetDeviceInfo localAIOReporterGetDeviceInfo = AIOReporterGetDeviceInfo.a();
    AIOTimeReporter.a(this.a, localAIOReporterGetDeviceInfo.a());
    if ((AIOTimeReporter.a(this.a) == 0L) || (AIOTimeReporter.b(this.a) == 0L)) {}
    while (AIOTimeReporter.c(this.a) < 0L) {
      return;
    }
    String str = "";
    switch (AIOTimeReporter.a(this.a))
    {
    default: 
      return;
    case 1: 
      switch (localAIOReporterGetDeviceInfo.a)
      {
      }
      for (;;)
      {
        StatisticCollector.a(BaseApplication.getContext()).a(null, str, true, AIOTimeReporter.c(this.a), 0L, null, "");
        if (QLog.isDevelopLevel()) {
          QLog.d("AutoMonitor", 4, "reportAIOTime: " + str + " cost : " + AIOTimeReporter.c(this.a));
        }
        return;
        if (!AIOTimeReporter.a(this.a).equalsIgnoreCase("0"))
        {
          str = AIOTimeReporter.a();
        }
        else
        {
          str = AIOTimeReporter.b();
          continue;
          if (!AIOTimeReporter.a(this.a).equalsIgnoreCase("0")) {
            str = AIOTimeReporter.c();
          } else {
            str = AIOTimeReporter.d();
          }
        }
      }
    case 2: 
      switch (localAIOReporterGetDeviceInfo.a)
      {
      }
      for (;;)
      {
        break;
        if (!AIOTimeReporter.a(this.a).equalsIgnoreCase("0"))
        {
          str = AIOTimeReporter.e();
        }
        else
        {
          str = AIOTimeReporter.f();
          continue;
          if (!AIOTimeReporter.a(this.a).equalsIgnoreCase("0")) {
            str = AIOTimeReporter.g();
          } else {
            str = AIOTimeReporter.h();
          }
        }
      }
    }
    switch (localAIOReporterGetDeviceInfo.a)
    {
    }
    for (;;)
    {
      break;
      if (!AIOTimeReporter.a(this.a).equalsIgnoreCase("0"))
      {
        str = AIOTimeReporter.i();
      }
      else
      {
        str = AIOTimeReporter.j();
        continue;
        if (!AIOTimeReporter.a(this.a).equalsIgnoreCase("0")) {
          str = AIOTimeReporter.k();
        } else {
          str = AIOTimeReporter.l();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     foq
 * JD-Core Version:    0.7.0.1
 */