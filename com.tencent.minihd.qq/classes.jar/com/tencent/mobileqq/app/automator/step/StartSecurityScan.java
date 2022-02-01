package com.tencent.mobileqq.app.automator.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.utils.ZebraBlacklistUtils;

public class StartSecurityScan
  extends AsyncStep
{
  protected int a()
  {
    if (this.a.a.t()) {
      this.a.a.z();
    }
    ZebraBlacklistUtils.a(BaseApplicationImpl.a()).a();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.StartSecurityScan
 * JD-Core Version:    0.7.0.1
 */