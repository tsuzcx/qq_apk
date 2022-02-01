import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.QLog;

public class hnk
  implements Runnable
{
  public hnk(QQAppInterface paramQQAppInterface, StringBuilder paramStringBuilder) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i(QQAppInterface.b, 2, "isCallTabShow needupdate,result=" + this.jdField_a_of_type_JavaLangStringBuilder);
    }
    SettingCloneUtil.writeValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null, "qqsetting_calltab_show_key", this.jdField_a_of_type_JavaLangStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hnk
 * JD-Core Version:    0.7.0.1
 */