package com.tencent.mobileqq.activity;

import android.view.animation.Interpolator;

public class HongbaoShowerActivity$BounceInterpolator
  implements Interpolator
{
  public HongbaoShowerActivity$BounceInterpolator(HongbaoShowerActivity paramHongbaoShowerActivity) {}
  
  private float a(float paramFloat)
  {
    return paramFloat * paramFloat * 8.0F;
  }
  
  public float getInterpolation(float paramFloat)
  {
    paramFloat = 1.1226F * paramFloat;
    if (paramFloat < 0.3535F) {
      return a(paramFloat);
    }
    if (paramFloat < 0.7408F) {
      return a(paramFloat - 0.54719F) + 0.7F;
    }
    if (paramFloat < 0.9644F) {
      return a(paramFloat - 0.8526F) + 0.9F;
    }
    return a(paramFloat - 1.0435F) + 0.95F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.HongbaoShowerActivity.BounceInterpolator
 * JD-Core Version:    0.7.0.1
 */