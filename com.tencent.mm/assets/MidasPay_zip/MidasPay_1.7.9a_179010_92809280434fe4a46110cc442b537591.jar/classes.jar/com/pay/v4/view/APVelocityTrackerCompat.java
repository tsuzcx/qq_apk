package com.pay.v4.view;

import android.os.Build.VERSION;
import android.view.VelocityTracker;

public class APVelocityTrackerCompat
{
  public static final VelocityTrackerVersionImpl IMPL = new BaseVelocityTrackerVersionImpl();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      IMPL = new HoneycombVelocityTrackerVersionImpl();
      return;
    }
  }
  
  public static float getXVelocity(VelocityTracker paramVelocityTracker, int paramInt)
  {
    return IMPL.getXVelocity(paramVelocityTracker, paramInt);
  }
  
  public static float getYVelocity(VelocityTracker paramVelocityTracker, int paramInt)
  {
    return IMPL.getYVelocity(paramVelocityTracker, paramInt);
  }
  
  public static class BaseVelocityTrackerVersionImpl
    implements APVelocityTrackerCompat.VelocityTrackerVersionImpl
  {
    public float getXVelocity(VelocityTracker paramVelocityTracker, int paramInt)
    {
      return paramVelocityTracker.getXVelocity();
    }
    
    public float getYVelocity(VelocityTracker paramVelocityTracker, int paramInt)
    {
      return paramVelocityTracker.getYVelocity();
    }
  }
  
  public static class HoneycombVelocityTrackerVersionImpl
    implements APVelocityTrackerCompat.VelocityTrackerVersionImpl
  {
    public float getXVelocity(VelocityTracker paramVelocityTracker, int paramInt)
    {
      return APVelocityTrackerCompatHoneycomb.getXVelocity(paramVelocityTracker, paramInt);
    }
    
    public float getYVelocity(VelocityTracker paramVelocityTracker, int paramInt)
    {
      return APVelocityTrackerCompatHoneycomb.getYVelocity(paramVelocityTracker, paramInt);
    }
  }
  
  public static abstract interface VelocityTrackerVersionImpl
  {
    public abstract float getXVelocity(VelocityTracker paramVelocityTracker, int paramInt);
    
    public abstract float getYVelocity(VelocityTracker paramVelocityTracker, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.v4.view.APVelocityTrackerCompat
 * JD-Core Version:    0.7.0.1
 */