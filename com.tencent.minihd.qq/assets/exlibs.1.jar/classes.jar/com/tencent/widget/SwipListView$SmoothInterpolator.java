package com.tencent.widget;

import android.view.animation.Interpolator;

public class SwipListView$SmoothInterpolator
  implements Interpolator
{
  public float getInterpolation(float paramFloat)
  {
    return (float)(Math.pow(paramFloat - 1.0D, 5.0D) + 1.0D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.SwipListView.SmoothInterpolator
 * JD-Core Version:    0.7.0.1
 */