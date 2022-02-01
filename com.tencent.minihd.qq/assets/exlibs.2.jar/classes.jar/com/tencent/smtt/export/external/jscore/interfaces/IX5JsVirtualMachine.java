package com.tencent.smtt.export.external.jscore.interfaces;

import android.os.Looper;

public abstract interface IX5JsVirtualMachine
{
  public abstract IX5JsContext createJsContext();
  
  public abstract void destroy();
  
  public abstract Looper getLooper();
  
  public abstract void onPause();
  
  public abstract void onResume();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.export.external.jscore.interfaces.IX5JsVirtualMachine
 * JD-Core Version:    0.7.0.1
 */