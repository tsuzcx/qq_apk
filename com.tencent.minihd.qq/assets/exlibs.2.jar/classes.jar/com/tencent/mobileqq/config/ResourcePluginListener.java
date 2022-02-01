package com.tencent.mobileqq.config;

import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;

public class ResourcePluginListener
{
  public static final byte a = 1;
  public static final int a = 1;
  public static final byte b = 2;
  public static final int b = 2;
  public static final byte c = -1;
  public static final byte d = 3;
  public static final byte e = 4;
  public static final byte f = 5;
  
  public static void a(ResourcePluginListener paramResourcePluginListener, byte paramByte, int paramInt)
  {
    BaseApplicationImpl.a.post(new ResourcePluginListener.CallbackRunner(paramResourcePluginListener, paramByte, paramInt));
  }
  
  public void a(byte paramByte) {}
  
  public void b(byte paramByte) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.ResourcePluginListener
 * JD-Core Version:    0.7.0.1
 */