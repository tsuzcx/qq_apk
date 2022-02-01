import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class dgi
  extends Handler
{
  public dgi(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      if (!this.a.isFinishing())
      {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(this.a.getString(2131366677));
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2130841644);
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(false);
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 1000L);
      return;
    } while ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()));
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(this.a.getString(2131366676));
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.d(true);
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(false);
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dgi
 * JD-Core Version:    0.7.0.1
 */