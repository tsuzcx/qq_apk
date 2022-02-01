package com.tencent.mobileqq.activity.flaotaio;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import gmu;

public class FriendFloatChatPie
  extends BaseFloatChatPie
{
  protected MessageObserver a;
  
  public FriendFloatChatPie(QQAppInterface paramQQAppInterface, FloatAioPage paramFloatAioPage)
  {
    super(paramQQAppInterface, paramFloatAioPage);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new gmu(this);
  }
  
  protected void m()
  {
    super.m();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  protected void n()
  {
    super.n();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.flaotaio.FriendFloatChatPie
 * JD-Core Version:    0.7.0.1
 */