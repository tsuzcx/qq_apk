package com.tencent.kinda.gen;

public abstract interface KScrollView
  extends KViewLayout
{
  public abstract boolean getScrollToDimissKeyboardEnabled();
  
  public abstract boolean getShowScrollBar();
  
  public abstract boolean getVertical();
  
  public abstract void scrollTo(KView paramKView);
  
  public abstract void setContent(KView paramKView);
  
  public abstract void setContentInsect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  public abstract void setOnScrollCallback(KScrollViewOnScrollCallback paramKScrollViewOnScrollCallback);
  
  public abstract void setScrollToDimissKeyboardEnabled(boolean paramBoolean);
  
  public abstract void setShowScrollBar(boolean paramBoolean);
  
  public abstract void setVertical(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.gen.KScrollView
 * JD-Core Version:    0.7.0.1
 */