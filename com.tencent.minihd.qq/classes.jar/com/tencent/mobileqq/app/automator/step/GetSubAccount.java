package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.subaccount.SubAccountProtocManager;
import com.tencent.qphone.base.util.QLog;

public class GetSubAccount
  extends AsyncStep
{
  protected int a()
  {
    SubAccountProtocManager localSubAccountProtocManager = (SubAccountProtocManager)this.a.a.getManager(27);
    if (localSubAccountProtocManager != null) {
      localSubAccountProtocManager.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "subaccount onGetSubAccountBind start int QQInitHandler...");
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetSubAccount
 * JD-Core Version:    0.7.0.1
 */