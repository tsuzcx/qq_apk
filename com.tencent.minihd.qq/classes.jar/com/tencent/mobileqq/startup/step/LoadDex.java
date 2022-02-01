package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.InjectUtils;

public class LoadDex
  extends Step
{
  protected boolean a()
  {
    if ((BaseApplicationImpl.g == 4) || ("Success".equals(BaseApplicationImpl.sInjectResult))) {}
    label78:
    label83:
    do
    {
      return true;
      boolean bool1;
      if (this.D == 1)
      {
        bool1 = true;
        BaseApplicationImpl.sInjectResult = InjectUtils.a(BaseApplicationImpl.a, bool1);
        if (bool1) {
          if (BaseApplicationImpl.sInjectResult != null) {
            break label78;
          }
        }
      }
      for (boolean bool2 = true;; bool2 = false)
      {
        BaseApplicationImpl.b = bool2;
        if ((bool1) || ("Success".equals(BaseApplicationImpl.sInjectResult))) {
          break label83;
        }
        return false;
        bool1 = false;
        break;
      }
    } while (!"Success".equals(BaseApplicationImpl.sInjectResult));
    try
    {
      Step.AmStepFactory.a();
      Step.AmStepFactory.b(16, this.a, null).c();
      return true;
    }
    catch (Exception localException) {}
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.LoadDex
 * JD-Core Version:    0.7.0.1
 */