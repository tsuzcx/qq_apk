package com.tencent.mars;

public class BaseEvent
{
  public static native void onCreate();
  
  public static native void onDestroy();
  
  public static native void onExceptionCrash();
  
  public static native void onForeground(boolean paramBoolean);
  
  public static native void onInitConfigBeforeOnCreate(int paramInt);
  
  public static native void onNetworkChange();
  
  public static native void onSingalCrash(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mars.BaseEvent
 * JD-Core Version:    0.7.0.1
 */