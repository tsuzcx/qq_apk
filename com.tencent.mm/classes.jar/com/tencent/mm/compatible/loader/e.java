package com.tencent.mm.compatible.loader;

import android.app.Application;
import android.content.res.Configuration;

@Deprecated
public abstract class e
{
  public Application app;
  
  public abstract void onConfigurationChanged(Configuration paramConfiguration);
  
  public abstract void onCreate();
  
  public void onTerminate() {}
  
  public void onTrimMemory(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.loader.e
 * JD-Core Version:    0.7.0.1
 */