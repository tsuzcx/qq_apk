package cooperation.qlink;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import lyc;
import lyd;

public class QlinkReliableReport
{
  private static QlinkReliableReport jdField_a_of_type_CooperationQlinkQlinkReliableReport;
  private static final String jdField_a_of_type_JavaLangString = "QlinkReliableReport";
  private final List jdField_a_of_type_JavaUtilList = new ArrayList();
  private Timer jdField_a_of_type_JavaUtilTimer;
  
  public static QlinkReliableReport a()
  {
    if (jdField_a_of_type_CooperationQlinkQlinkReliableReport == null) {}
    try
    {
      if (jdField_a_of_type_CooperationQlinkQlinkReliableReport == null) {
        jdField_a_of_type_CooperationQlinkQlinkReliableReport = new QlinkReliableReport();
      }
      return jdField_a_of_type_CooperationQlinkQlinkReliableReport;
    }
    finally {}
  }
  
  public static void a()
  {
    QlinkReliableReport localQlinkReliableReport = a();
    if (localQlinkReliableReport != null) {
      localQlinkReliableReport.e();
    }
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap paramHashMap)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QlinkReliableReport", 2, "collectPerformance:tagName[" + paramString2 + "]");
    }
    QlinkReliableReport localQlinkReliableReport = a();
    if (localQlinkReliableReport != null) {
      localQlinkReliableReport.a(new lyd(paramString1, paramString2, paramBoolean, paramLong1, paramLong2, paramHashMap));
    }
  }
  
  private void a(lyd paramlyd)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QlinkReliableReport", 2, "addPerformanceReporting:" + paramlyd);
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.add(paramlyd);
      return;
    }
  }
  
  public static void b()
  {
    QlinkReliableReport localQlinkReliableReport = a();
    if (localQlinkReliableReport != null) {
      localQlinkReliableReport.f();
    }
  }
  
  private static void h()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QlinkReliableReport", 2, "start:");
    }
    QlinkReliableReport localQlinkReliableReport = a();
    if (localQlinkReliableReport != null) {
      localQlinkReliableReport.i();
    }
  }
  
  private void i()
  {
    if (!NetworkUtil.e(BaseApplication.getContext())) {
      if (QLog.isDevelopLevel()) {
        QLog.d("QlinkReliableReport", 2, "doReportPerformance: network is not surpport");
      }
    }
    do
    {
      return;
      if (QLog.isDevelopLevel()) {
        QLog.d("QlinkReliableReport", 2, "doReportPerformance: size[" + this.jdField_a_of_type_JavaUtilList.size() + "]");
      }
    } while (this.jdField_a_of_type_JavaUtilList.size() == 0);
    StatisticCollector localStatisticCollector = StatisticCollector.a(BaseApplication.getContext());
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      if (localIterator.hasNext())
      {
        lyd locallyd = (lyd)localIterator.next();
        localStatisticCollector.a(locallyd.a(), locallyd.b(), locallyd.a(), locallyd.a(), locallyd.b(), locallyd.a(), null);
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  protected void c() {}
  
  protected void d()
  {
    f();
    try
    {
      jdField_a_of_type_CooperationQlinkQlinkReliableReport = null;
      return;
    }
    finally {}
  }
  
  public void e()
  {
    QLog.d("QlinkReliableReport", 2, "doStartReportTimer");
    if (this.jdField_a_of_type_JavaUtilTimer == null)
    {
      this.jdField_a_of_type_JavaUtilTimer = new Timer();
      this.jdField_a_of_type_JavaUtilTimer.schedule(new lyc(this), 60000L);
    }
  }
  
  public void f()
  {
    QLog.d("QlinkReliableReport", 2, "doStopReportTimer");
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qlink.QlinkReliableReport
 * JD-Core Version:    0.7.0.1
 */