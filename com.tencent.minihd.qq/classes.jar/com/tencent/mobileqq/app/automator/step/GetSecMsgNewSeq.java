package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecMsgManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;

public class GetSecMsgNewSeq
  extends AsyncStep
{
  protected int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "GetSecMsgNewSeq start in QQInitHandler...");
    }
    SecMsgManager localSecMsgManager = (SecMsgManager)this.a.a.getManager(55);
    if (localSecMsgManager != null) {
      localSecMsgManager.a();
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetSecMsgNewSeq
 * JD-Core Version:    0.7.0.1
 */