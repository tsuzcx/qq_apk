import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.messagesearch.MessageSearchDialog;
import com.tencent.qphone.base.util.QLog;

public class dmp
  implements DialogInterface.OnDismissListener
{
  public dmp(ChatHistory paramChatHistory, View paramView1, int paramInt, View paramView2, TranslateAnimation paramTranslateAnimation) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(-this.jdField_a_of_type_Int);
    this.b.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    paramDialogInterface = (MessageSearchDialog)paramDialogInterface;
    int i = paramDialogInterface.b();
    boolean bool = paramDialogInterface.a();
    if (QLog.isColorLevel()) {
      QLog.i("ChatHistory", 2, "onDismiss, recordCount : " + i);
    }
    if (i <= 0) {}
    int j;
    do
    {
      return;
      j = (i - 1) / 8 + 1;
      if (QLog.isColorLevel()) {
        QLog.i("ChatHistory", 2, "onDismiss, pageIndex = " + j);
      }
    } while (j < 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.jdField_a_of_type_Int = ((i - 1) % 8);
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_AndroidWidgetEditText.setText(String.valueOf(j));
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_AndroidWidgetEditText.getText().length());
    if (bool)
    {
      ChatHistory.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory).setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131366374));
      return;
    }
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getIntent().getExtras().getString("leftViewText");
    ChatHistory.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory).setText(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dmp
 * JD-Core Version:    0.7.0.1
 */