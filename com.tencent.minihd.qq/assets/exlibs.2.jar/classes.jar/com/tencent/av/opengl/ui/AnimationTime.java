package com.tencent.av.opengl.ui;

import android.os.SystemClock;

public class AnimationTime
{
  private static volatile long sTime;
  
  public static long get()
  {
    return sTime;
  }
  
  public static long startTime()
  {
    sTime = SystemClock.uptimeMillis();
    return sTime;
  }
  
  public static void update()
  {
    sTime = SystemClock.uptimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.av.opengl.ui.AnimationTime
 * JD-Core Version:    0.7.0.1
 */