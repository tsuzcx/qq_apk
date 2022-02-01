package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class GetDatingUnreadCountStep
  extends AsyncStep
{
  protected int a()
  {
    CardHandler localCardHandler = (CardHandler)this.a.a.a(2);
    if (localCardHandler != null) {
      localCardHandler.h();
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetDatingUnreadCountStep
 * JD-Core Version:    0.7.0.1
 */