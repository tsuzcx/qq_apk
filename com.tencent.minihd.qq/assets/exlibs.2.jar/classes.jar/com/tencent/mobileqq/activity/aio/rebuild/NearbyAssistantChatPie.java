package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import gar;

public class NearbyAssistantChatPie
  extends BaseChatPie
{
  private final String K = "NearbyAssistantChatPie";
  protected MessageObserver a;
  
  public NearbyAssistantChatPie(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    super(paramQQAppInterface, paramBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new gar(this);
  }
  
  protected void T()
  {
    super.T();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  protected void U()
  {
    super.U();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  protected boolean a()
  {
    return false;
  }
  
  protected boolean a(MessageRecord paramMessageRecord)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(paramMessageRecord.frienduin);
  }
  
  protected void b(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("uinname");
    paramIntent = str;
    if (str == null) {
      paramIntent = a().getString(2131369992);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramIntent;
    this.b.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
  }
  
  protected boolean b()
  {
    return false;
  }
  
  protected void o()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  protected void p() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyAssistantChatPie
 * JD-Core Version:    0.7.0.1
 */