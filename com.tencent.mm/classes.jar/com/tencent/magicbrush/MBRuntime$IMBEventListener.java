package com.tencent.magicbrush;

import android.support.annotation.Keep;

@Keep
public abstract interface MBRuntime$IMBEventListener
{
  public abstract void onConsoleOutput(String paramString);
  
  public abstract void onError(int paramInt);
  
  public abstract void onFirstFrameRendered();
  
  public abstract void onJsExceptionOccurred(String paramString1, String paramString2, int paramInt);
  
  public abstract void onMainCanvasCreated(int paramInt);
  
  public abstract void onMainCanvasTypeDefined(int paramInt);
  
  public abstract void onRendererReady(int paramInt1, int paramInt2);
  
  public abstract void onSystemSizeChanged(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.MBRuntime.IMBEventListener
 * JD-Core Version:    0.7.0.1
 */