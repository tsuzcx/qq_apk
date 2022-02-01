import com.tencent.qphone.base.util.QLog;
import cooperation.qlink.QlinkReliableReport;
import java.util.TimerTask;

public class lyc
  extends TimerTask
{
  public lyc(QlinkReliableReport paramQlinkReliableReport) {}
  
  public void run()
  {
    QLog.d("QlinkReliableReport", 2, "doStopReportTimer :  on timer");
    QlinkReliableReport.a(this.a, null);
    QlinkReliableReport.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lyc
 * JD-Core Version:    0.7.0.1
 */