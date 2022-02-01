package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SaveTrafficHandler;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import hrp;

public class GetTroopAssisMsg
  extends AsyncStep
{
  private MessageObserver a;
  
  protected int a()
  {
    ((SaveTrafficHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.a(18)).b();
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.a().a(3, true);
    return 2;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new hrp(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.c(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetTroopAssisMsg
 * JD-Core Version:    0.7.0.1
 */