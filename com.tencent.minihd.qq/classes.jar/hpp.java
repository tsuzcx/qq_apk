import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.vas.SignatureTemplateConfig.SignatureTemplateType;
import com.tencent.qphone.base.util.QLog;

public class hpp
  implements Handler.Callback
{
  public hpp(SignatureManager paramSignatureManager) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (2 == paramMessage.what)
    {
      SignatureManager.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType = (SignatureTemplateConfig.SignatureTemplateType[])paramMessage.obj;
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(EditActivity.class);
        if (paramMessage != null) {
          paramMessage.sendEmptyMessageDelayed(2, 50L);
        }
        if (QLog.isColorLevel()) {
          QLog.d("SignatureManager", 2, "update sign tpl info...");
        }
      }
    }
    for (;;)
    {
      return true;
      if ((3 == paramMessage.what) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
      {
        paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(EditActivity.class);
        if (paramMessage != null) {
          paramMessage.sendEmptyMessageDelayed(7, 50L);
        }
        if (QLog.isColorLevel()) {
          QLog.d("SignatureManager", 2, "update sign tpl animation ...");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hpp
 * JD-Core Version:    0.7.0.1
 */