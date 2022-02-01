import android.os.Handler;
import com.tencent.mobileqq.app.message.BaseMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.RefreshMessageContext;

public class hsi
  implements Runnable
{
  public hsi(BaseMessageManager paramBaseMessageManager, String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageManager.a.a("refreshMessageListHead uin = " + this.jdField_a_of_type_JavaLangString + ", type = " + this.jdField_a_of_type_Int + ", count = " + this.b + ", context = " + this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext, ", timestamp = " + System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageManager.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageManager.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageManager.a.a.post(new hsj(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hsi
 * JD-Core Version:    0.7.0.1
 */