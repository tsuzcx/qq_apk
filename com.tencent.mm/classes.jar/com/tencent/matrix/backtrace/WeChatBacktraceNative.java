package com.tencent.matrix.backtrace;

import androidx.annotation.Keep;

@Keep
public class WeChatBacktraceNative
{
  @Keep
  static native String[] consumeRequestedQut();
  
  @Keep
  static native void enableLogger(boolean paramBoolean);
  
  @Keep
  static native void immediateGeneration(boolean paramBoolean);
  
  @Keep
  static native void notifyWarmedUp(String paramString, int paramInt);
  
  @Keep
  static void requestQutGenerate() {}
  
  @Keep
  static native void setBacktraceMode(int paramInt);
  
  @Keep
  static native void setPackageName(String paramString);
  
  @Keep
  static native void setQuickenAlwaysOn(boolean paramBoolean);
  
  @Keep
  static native void setSavingPath(String paramString);
  
  @Keep
  static native void setWarmedUp(boolean paramBoolean);
  
  @Keep
  static native int[] statistic(String paramString);
  
  @Keep
  static native boolean testLoadQut(String paramString, int paramInt);
  
  @Keep
  static native boolean warmUp(String paramString, int paramInt, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.backtrace.WeChatBacktraceNative
 * JD-Core Version:    0.7.0.1
 */