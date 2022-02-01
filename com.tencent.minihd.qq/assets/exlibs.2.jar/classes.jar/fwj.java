import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.ShakeItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.qphone.base.util.QLog;

public class fwj
  implements View.OnClickListener
{
  public fwj(ShakeItemBuilder paramShakeItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.shakemsg", 2, "shake msg onClick() is called");
    }
    AIOUtils.h = true;
    if (ShakeItemBuilder.a(this.a)) {
      return;
    }
    paramView = (MessageForShakeWindow)AIOUtils.a(paramView);
    if ((this.a.jdField_a_of_type_AndroidContentContext instanceof ChatActivity))
    {
      ((ChatActivity)this.a.jdField_a_of_type_AndroidContentContext).a().W();
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramView.frienduin, false);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramView.frienduin, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fwj
 * JD-Core Version:    0.7.0.1
 */