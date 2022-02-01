package com.tencent.mobileqq.activity.recent.cur;

public abstract interface IDragView
{
  public static final int a = -1;
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 3;
  
  public abstract IDragView.OnChangeModeListener a();
  
  public abstract void setOnModeChangeListener(IDragView.OnChangeModeListener paramOnChangeModeListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.cur.IDragView
 * JD-Core Version:    0.7.0.1
 */