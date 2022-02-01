package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import hrk;

public class GetJoinedHotChatListStep
  extends AsyncStep
{
  private HotChatObserver a;
  
  protected int a()
  {
    if (!HotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a)) {
      return 7;
    }
    HotChatHandler localHotChatHandler = (HotChatHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.a(37);
    localHotChatHandler.d();
    this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver = new hrk(this, null);
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.a(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
    localHotChatHandler.a();
    return 2;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.c(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetJoinedHotChatListStep
 * JD-Core Version:    0.7.0.1
 */