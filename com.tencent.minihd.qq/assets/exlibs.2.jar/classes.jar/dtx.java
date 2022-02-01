import com.tencent.mobileqq.activity.ConversationHotChatCtrl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

class dtx
  implements Runnable
{
  dtx(dtw paramdtw) {}
  
  public void run()
  {
    if ((this.a.a.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a != null) && (this.a.a.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a.isShowing()) && (!this.a.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())) {
      this.a.a.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dtx
 * JD-Core Version:    0.7.0.1
 */