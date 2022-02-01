package com.tencent.mobileqq.app.automator.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import hrn;

public class GetSpecialSoundConfig
  extends AsyncStep
{
  protected int a()
  {
    QvipSpecialSoundManager localQvipSpecialSoundManager = new QvipSpecialSoundManager(BaseApplicationImpl.getContext(), this.a.a);
    if (localQvipSpecialSoundManager != null) {
      ThreadManager.a(new hrn(this, localQvipSpecialSoundManager));
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetSpecialSoundConfig
 * JD-Core Version:    0.7.0.1
 */