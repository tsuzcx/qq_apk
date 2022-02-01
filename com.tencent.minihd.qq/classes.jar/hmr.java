import com.tencent.mobileqq.app.PrinterHandler;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.Timer;
import java.util.TimerTask;

public class hmr
  extends TimerTask
{
  public hmr(PrinterHandler paramPrinterHandler) {}
  
  public void run()
  {
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004023", "0X8004023", 0, 0, "", "", "", "");
    if (this.a.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.a.jdField_a_of_type_JavaUtilTimer.cancel();
      this.a.jdField_a_of_type_JavaUtilTimer = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hmr
 * JD-Core Version:    0.7.0.1
 */