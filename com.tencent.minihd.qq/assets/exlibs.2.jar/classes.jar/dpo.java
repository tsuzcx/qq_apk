import android.view.View;
import com.tencent.mobileqq.activity.ChatSettingForHotChat;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class dpo
  implements ActionSheet.OnButtonClickListener
{
  public dpo(ChatSettingForHotChat paramChatSettingForHotChat, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
      if (NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForHotChat))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForHotChat.jdField_a_of_type_ComTencentMobileqqAppBizTroopHandler == null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForHotChat.jdField_a_of_type_ComTencentMobileqqAppBizTroopHandler = ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForHotChat.app.a(21));
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForHotChat.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForHotChat.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
        this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForHotChat.jdField_a_of_type_ComTencentMobileqqAppHotChatHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForHotChat.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForHotChat.g), HotChatManager.HotChatStateWrapper.STATE_LEFT_NORMAL__ACTION_DELETE_SHELL);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForHotChat.app, "CliOper", "", "", "0X8004415", "0X8004415", 0, 0, "", "", "", "");
        this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForHotChat.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForHotChat, this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForHotChat.getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForHotChat.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setContentView(2130904387);
        this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForHotChat.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForHotChat.getString(2131367795));
        this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForHotChat.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
        this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForHotChat.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
      else
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForHotChat, 2130838242, this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForHotChat.getString(2131367136), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForHotChat.getTitleBarHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dpo
 * JD-Core Version:    0.7.0.1
 */