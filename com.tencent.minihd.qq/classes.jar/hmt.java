import com.tencent.mobileqq.app.PrinterHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class hmt
  extends TimerTask
{
  public hmt(PrinterHandler paramPrinterHandler, long paramLong, Timer paramTimer) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppPrinterHandler.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(this.jdField_a_of_type_Long)))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppPrinterHandler.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004021", "0X8004021", (int)this.jdField_a_of_type_Long, -1, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqAppPrinterHandler.a(Long.valueOf(this.jdField_a_of_type_Long), false);
      if (QLog.isDevelopLevel()) {
        QLog.d("dataline.Printer", 4, "printID=" + this.jdField_a_of_type_Long + ", 超时到了");
      }
    }
    this.jdField_a_of_type_JavaUtilTimer.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hmt
 * JD-Core Version:    0.7.0.1
 */