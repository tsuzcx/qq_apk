package com.tencent.luggage.natives;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class LuggageNativeViewJni
{
  public static String TAG;
  public long cbN;
  
  static
  {
    AppMethodBeat.i(140472);
    TAG = "LuggageNativeViewJni";
    System.loadLibrary("wechatlv");
    AppMethodBeat.o(140472);
  }
  
  public LuggageNativeViewJni()
  {
    AppMethodBeat.i(140466);
    this.cbN = -1L;
    AppMethodBeat.o(140466);
  }
  
  public native long createNativeRender();
  
  public native void destroyNativeRender(long paramLong);
  
  public native long getPageViewPtr(long paramLong);
  
  public native void initJsBinding(long paramLong1, long paramLong2, long paramLong3);
  
  public native void onPageViewCreate(long paramLong, String paramString);
  
  public native void setDisplayParams(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, float paramFloat5);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.natives.LuggageNativeViewJni
 * JD-Core Version:    0.7.0.1
 */