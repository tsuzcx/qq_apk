package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.StepFactory;

public class StartServiceLiteCmp
  extends Step
{
  protected boolean a()
  {
    Object localObject = BaseApplicationImpl.a.a();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if (((QQAppInterface)localObject).e()) {
        ((QQAppInterface)localObject).a.a(StepFactory.a(((QQAppInterface)localObject).a, "{{4,3,5,6},40,41,[60,25,10,26,27,28,29,30,31,33,34,36,37,38,39,43,44,45,50,64,65,66,46,48,49,57,59,69,62],52}"));
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.StartServiceLiteCmp
 * JD-Core Version:    0.7.0.1
 */