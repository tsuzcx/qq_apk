import android.os.Handler;
import com.tencent.mobileqq.activity.ConversationHotChatCtrl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.widget.QQProgressDialog;

class dtw
  extends HotChatObserver
{
  dtw(dtv paramdtv) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this);
    if (paramBoolean) {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a.isShowing()) && (!this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a.a(paramString2);
        this.a.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a.c(2130838252);
        this.a.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a.b(false);
        this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new dtx(this), 1500L);
      }
    }
    while ((this.a.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a.isShowing()) || (this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a.a(paramString2);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a.c(2130838242);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a.b(false);
    this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new dty(this), 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dtw
 * JD-Core Version:    0.7.0.1
 */