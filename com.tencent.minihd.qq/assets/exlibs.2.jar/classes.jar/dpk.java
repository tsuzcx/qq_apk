import android.os.Handler;
import com.tencent.mobileqq.activity.ChatSettingForHotChat;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class dpk
  extends HotChatObserver
{
  public dpk(ChatSettingForHotChat paramChatSettingForHotChat) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    this.a.removeObserver(this);
    if (paramBoolean) {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (!this.a.isFinishing()))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString2);
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2130838252);
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(false);
        this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new dpl(this), 1500L);
      }
    }
    while ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) || (this.a.isFinishing())) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString2);
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2130838242);
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(false);
    this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new dpm(this), 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dpk
 * JD-Core Version:    0.7.0.1
 */