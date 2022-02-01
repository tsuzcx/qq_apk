import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;

public class jya
  extends TimerTask
{
  public jya(SubAccountControll paramSubAccountControll, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("launchTimedMsgTask() run. startAllSubMessageAccountMsg(false) app.isRunning=");
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        break label70;
      }
    }
    label70:
    for (Object localObject = "null";; localObject = Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRunning()))
    {
      QLog.d("SUB_ACCOUNT", 2, localObject);
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRunning())) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f(false);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jya
 * JD-Core Version:    0.7.0.1
 */