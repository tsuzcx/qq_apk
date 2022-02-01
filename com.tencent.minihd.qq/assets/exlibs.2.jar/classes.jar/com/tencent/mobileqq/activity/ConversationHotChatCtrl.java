package com.tencent.mobileqq.activity;

import android.os.Handler;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import dtv;
import mqq.app.Constants.LogoutReason;

public class ConversationHotChatCtrl
{
  private Conversation jdField_a_of_type_ComTencentMobileqqActivityConversation = null;
  private HotChatObserver jdField_a_of_type_ComTencentMobileqqAppHotChatObserver = null;
  public QQCustomDialog a;
  public QQProgressDialog a;
  
  public ConversationHotChatCtrl(Conversation paramConversation)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation = paramConversation;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityConversation.app.c(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
    }
  }
  
  public void a(RecentUser paramRecentUser)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.app;
    Conversation localConversation = this.jdField_a_of_type_ComTencentMobileqqActivityConversation;
    Handler localHandler = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a;
    HotChatManager localHotChatManager = (HotChatManager)localQQAppInterface.getManager(58);
    if (HotChatManager.b(paramRecentUser.uin))
    {
      localHotChatManager.b();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = HotChatHelper.a(localQQAppInterface);
      ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8004D28", "0X8004D28", 0, 0, "", "", "", "");
    }
    HotChatInfo localHotChatInfo;
    do
    {
      do
      {
        return;
      } while (!localHotChatManager.d(paramRecentUser.uin));
      localHotChatManager.a(paramRecentUser.uin);
      localHotChatInfo = localHotChatManager.a(paramRecentUser.uin);
    } while (localHotChatInfo == null);
    if (localHotChatInfo.state != 0)
    {
      if (localHotChatInfo.isWifiHotChat) {}
      for (i = 1;; i = 2)
      {
        ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8004D2A", "0X8004D2A", i, 0, "", "", "", "");
        return;
      }
    }
    if (localHotChatInfo.isWifiHotChat) {}
    for (int i = 1;; i = 2)
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8004D29", "0X8004D29", i, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = HotChatHelper.a(localQQAppInterface, localHotChatManager.a(paramRecentUser.uin), new dtv(this, localHotChatInfo, localQQAppInterface, localConversation, localHandler));
      return;
    }
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationHotChatCtrl
 * JD-Core Version:    0.7.0.1
 */