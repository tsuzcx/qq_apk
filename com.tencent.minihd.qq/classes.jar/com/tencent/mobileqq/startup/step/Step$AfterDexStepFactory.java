package com.tencent.mobileqq.startup.step;

import com.tencent.mobileqq.startup.director.StartupDirector;

public class Step$AfterDexStepFactory
  implements Step.IStepFactory
{
  public Step a(int paramInt, StartupDirector paramStartupDirector, int[] paramArrayOfInt)
  {
    switch (paramInt)
    {
    case 8: 
    case 9: 
    case 10: 
    case 13: 
    case 20: 
    default: 
      return new Step();
    case 7: 
    case 19: 
      return new LoadData();
    case 6: 
      return new NewRuntime();
    case 11: 
      return new Step();
    case 12: 
      return new InitUrlDrawable();
    case 14: 
      return new Rdm();
    case 15: 
      return new ManageThread();
    case 17: 
      return new LoadUi();
    case 18: 
      return new LoadOtherStuff();
    case 22: 
      return new StartServiceLiteCmp();
    case 23: 
      return new UpdateBubbleZip();
    case 24: 
      return new UpdateAvSo();
    case 25: 
      return new SetPlugin();
    case 26: 
      return new UpdatePluginVersion();
    case 27: 
      return new WebP();
    case 16: 
      return new InitLeakInspector();
    }
    return new StartService();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.Step.AfterDexStepFactory
 * JD-Core Version:    0.7.0.1
 */