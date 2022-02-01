import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.PrinterHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class hms
  extends TimerTask
{
  public hms(PrinterHandler paramPrinterHandler, DataLineHandler paramDataLineHandler, Timer paramTimer) {}
  
  public void run()
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppPrinterHandler.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqAppPrinterHandler.jdField_a_of_type_JavaUtilHashMap.size() > 0))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("dataline.Printer", 4, " pc下线了");
      }
      while (this.jdField_a_of_type_ComTencentMobileqqAppPrinterHandler.jdField_a_of_type_JavaUtilHashMap.size() > 0)
      {
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqAppPrinterHandler.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
        if (localIterator.hasNext())
        {
          long l = ((Long)localIterator.next()).longValue();
          this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a(0, l, true);
          this.jdField_a_of_type_ComTencentMobileqqAppPrinterHandler.a(Long.valueOf(l), false);
        }
      }
    }
    this.jdField_a_of_type_JavaUtilTimer.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hms
 * JD-Core Version:    0.7.0.1
 */