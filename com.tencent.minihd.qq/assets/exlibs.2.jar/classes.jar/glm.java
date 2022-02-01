import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.activity.flaotaio.BaseFloatChatPie;
import com.tencent.mobileqq.activity.flaotaio.FloatAioController.MsgBarInfo;
import com.tencent.mobileqq.activity.flaotaio.FloatAioPage;

public class glm
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public glm(FloatAioPage paramFloatAioPage, FloatAioController.MsgBarInfo paramMsgBarInfo) {}
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage.a.a().getViewTreeObserver().removeGlobalOnLayoutListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage.b(true, this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatAioController$MsgBarInfo);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage.a.a().postDelayed(new gln(this), 20L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     glm
 * JD-Core Version:    0.7.0.1
 */