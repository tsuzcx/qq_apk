package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.StepFactory;
import com.tencent.qphone.base.util.QLog;

public class StartService
  extends Step
{
  protected boolean a()
  {
    Object localObject = null;
    if (StartService.StartServiceState.a) {}
    for (;;)
    {
      return true;
      StartService.StartServiceState.a = true;
      try
      {
        QLog.init(BaseApplicationImpl.a);
        label20:
        if (BaseApplicationImpl.g != 4)
        {
          BaseApplicationImpl.a.startService();
          localObject = BaseApplicationImpl.a.waitAppRuntime(null);
        }
        if ((localObject == null) || (!(localObject instanceof QQAppInterface))) {
          continue;
        }
        QQAppInterface localQQAppInterface = (QQAppInterface)localObject;
        localQQAppInterface.onGuardEvent(6, 0L, 0L);
        if (localQQAppInterface.e())
        {
          Automator localAutomator1 = localQQAppInterface.a;
          Automator localAutomator2 = localQQAppInterface.a;
          if (this.D == 21) {}
          for (localObject = "{[11,12,14],17,20,21,22}";; localObject = "{{4,3,5,6},[11,12,14],17,20,21,54,55,22,40,41,[60,25,10,26,27,28,29,30,31,33,34,36,37,38,39,43,44,45,50,64,65,66,46,48,49,57,59,69,62],52,70}")
          {
            localAutomator1.a(StepFactory.a(localAutomator2, (String)localObject));
            localQQAppInterface.start(false);
            return true;
          }
        }
        BaseApplicationImpl.c = 0L;
        return true;
      }
      catch (Exception localException)
      {
        break label20;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.StartService
 * JD-Core Version:    0.7.0.1
 */