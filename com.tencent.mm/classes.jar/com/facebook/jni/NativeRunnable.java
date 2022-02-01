package com.facebook.jni;

public class NativeRunnable
  implements Runnable
{
  private final HybridData mHybridData;
  
  private NativeRunnable(HybridData paramHybridData)
  {
    this.mHybridData = paramHybridData;
  }
  
  public native void run();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.facebook.jni.NativeRunnable
 * JD-Core Version:    0.7.0.1
 */