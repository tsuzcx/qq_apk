package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import hrx;

public class TimerCheckMsgCount
  extends AsyncStep
{
  protected int a()
  {
    ThreadManager.a(new hrx(this));
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.TimerCheckMsgCount
 * JD-Core Version:    0.7.0.1
 */