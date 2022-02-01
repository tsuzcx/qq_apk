package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThemeHandler;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class SendThemeAuth
  extends AsyncStep
{
  protected int a()
  {
    ThemeHandler localThemeHandler = (ThemeHandler)this.a.a.a(13);
    if (localThemeHandler != null) {
      localThemeHandler.a(null, null);
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.SendThemeAuth
 * JD-Core Version:    0.7.0.1
 */