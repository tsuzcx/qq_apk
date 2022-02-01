package com.tencent.mobileqq.pluginsdk;

import android.os.Bundle;

public abstract interface IPluginAdapter
{
  public static final int CMD_IS_NIGHT_MODE = 1;
  
  public abstract Object invoke(int paramInt, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.IPluginAdapter
 * JD-Core Version:    0.7.0.1
 */