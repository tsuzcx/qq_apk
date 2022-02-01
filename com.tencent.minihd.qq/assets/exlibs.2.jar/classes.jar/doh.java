import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.activity.messagesearch.MessageSearchDialog;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class doh
  implements DialogInterface.OnDismissListener
{
  public doh(ChatHistoryForC2C paramChatHistoryForC2C, View paramView1, int paramInt, View paramView2, TranslateAnimation paramTranslateAnimation) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(-this.jdField_a_of_type_Int);
    this.b.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    paramDialogInterface = (MessageSearchDialog)paramDialogInterface;
    int i = paramDialogInterface.b();
    boolean bool = paramDialogInterface.a();
    if (QLog.isColorLevel()) {
      QLog.i("ChatHistoryForC2C", 2, "onDismiss, recordCount : " + i);
    }
    if (i <= 0) {
      return;
    }
    ((MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.app.getManager(86)).a(paramDialogInterface.a());
    if (bool)
    {
      ChatHistoryForC2C.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C).setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.getString(2131366374));
      return;
    }
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.getIntent().getExtras().getString("leftViewText");
    ChatHistoryForC2C.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C).setText(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     doh
 * JD-Core Version:    0.7.0.1
 */