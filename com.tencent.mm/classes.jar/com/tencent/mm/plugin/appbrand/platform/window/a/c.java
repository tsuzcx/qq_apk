package com.tencent.mm.plugin.appbrand.platform.window.a;

import android.content.res.Configuration;
import com.tencent.mm.plugin.appbrand.platform.window.e;

public abstract interface c
  extends e
{
  public abstract void onConfigurationChanged(Configuration paramConfiguration);
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.a.c
 * JD-Core Version:    0.7.0.1
 */