package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginRecoverReceiver;
import jwa;

public class SetPlugin
  extends Step
{
  protected boolean a()
  {
    PluginRecoverReceiver.register(BaseApplicationImpl.a, new jwa());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.SetPlugin
 * JD-Core Version:    0.7.0.1
 */