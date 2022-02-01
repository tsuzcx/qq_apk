import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mobileqq.activity.flaotaio.FloatAioController;
import com.tencent.mobileqq.activity.flaotaio.FloatMsgBar;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.text.QQText;

public class glh
  implements Runnable
{
  public glh(FloatAioController paramFloatAioController, String paramString1, CharSequence paramCharSequence, QQMessageFacade.Message paramMessage, String paramString2, QQText paramQQText, Bitmap paramBitmap) {}
  
  public void run()
  {
    FloatAioController.a(this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatAioController).a.jdField_a_of_type_JavaLangCharSequence = this.jdField_a_of_type_JavaLangString;
    FloatAioController.a(this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatAioController).a.b = this.jdField_a_of_type_JavaLangCharSequence;
    FloatAioController.a(this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatAioController).a().setOnClickListener(new gli(this));
    FloatAioController.a(this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatAioController).a(FloatAioController.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message));
    FloatAioController.a(this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatAioController).a(this.b, this.jdField_a_of_type_ComTencentMobileqqTextQQText, this.jdField_a_of_type_AndroidGraphicsBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     glh
 * JD-Core Version:    0.7.0.1
 */