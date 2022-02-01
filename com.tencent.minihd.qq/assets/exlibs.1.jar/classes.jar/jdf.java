import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.log.ReportLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class jdf
  implements Runnable
{
  public jdf(ReportLog paramReportLog, MobileQQ paramMobileQQ) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_MqqAppMobileQQ instanceof BaseApplicationImpl))
    {
      AppRuntime localAppRuntime = ((BaseApplicationImpl)this.jdField_a_of_type_MqqAppMobileQQ).a();
      if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
        ((QQAppInterface)localAppRuntime).b(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jdf
 * JD-Core Version:    0.7.0.1
 */