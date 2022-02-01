package com.tencent.matrix.backtrace;

public class WeChatBacktraceNative
{
  static native String[] consumeRequestedQut();
  
  static native void enableLogger(boolean paramBoolean);
  
  static native void immediateGeneration(boolean paramBoolean);
  
  static native void notifyWarmedUp(String paramString, int paramInt);
  
  static void requestQutGenerate() {}
  
  static native void setBacktraceMode(int paramInt);
  
  static native void setPackageName(String paramString);
  
  static native void setQuickenAlwaysOn(boolean paramBoolean);
  
  static native void setSavingPath(String paramString);
  
  static native void setWarmedUp(boolean paramBoolean);
  
  static native int[] statistic(String paramString);
  
  static native boolean testLoadQut(String paramString, int paramInt);
  
  static native boolean warmUp(String paramString, int paramInt, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.backtrace.WeChatBacktraceNative
 * JD-Core Version:    0.7.0.1
 */