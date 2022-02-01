import com.tencent.feedback.eup.CrashReport;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class hnl
  implements Runnable
{
  public hnl(QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    CrashReport.setUserId(BaseApplication.getContext(), this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hnl
 * JD-Core Version:    0.7.0.1
 */