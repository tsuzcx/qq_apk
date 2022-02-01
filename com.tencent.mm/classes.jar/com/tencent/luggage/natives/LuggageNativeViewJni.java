package com.tencent.luggage.natives;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class LuggageNativeViewJni
{
  private static String TAG;
  private long cwE = -1L;
  
  static
  {
    AppMethodBeat.i(140472);
    TAG = "LuggageNativeViewJni";
    System.loadLibrary("wechatlv");
    AppMethodBeat.o(140472);
  }
  
  private native long createNativeRender();
  
  private native void destroyNativeRender(long paramLong);
  
  private native long getPageViewPtr(long paramLong);
  
  private native void initJsBinding(long paramLong1, long paramLong2, long paramLong3);
  
  private native void onPageViewCreate(long paramLong, String paramString);
  
  private native void setDisplayParams(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, float paramFloat5);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.natives.LuggageNativeViewJni
 * JD-Core Version:    0.7.0.1
 */