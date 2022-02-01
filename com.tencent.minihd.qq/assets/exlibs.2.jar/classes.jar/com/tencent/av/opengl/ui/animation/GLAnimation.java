package com.tencent.av.opengl.ui.animation;

import com.tencent.av.opengl.ui.GLView;
import java.util.List;

public class GLAnimation
{
  private static final byte DEFAULE = 0;
  public static final byte HOLD_END = 1;
  public static final byte HOLD_START = 2;
  public static final byte SPRING = 3;
  private float currentAlpha = 0.0F;
  private float currentRotateX = 0.0F;
  private float currentRotateY = 0.0F;
  private float currentRotateZ = 0.0F;
  private float currentScaleX = 0.0F;
  private float currentScaleY = 0.0F;
  private float currentX = 0.0F;
  private float currentY = 0.0F;
  private float currentZ = 0.0F;
  private float fromAlpha = 1.0F;
  private float fromRotateX = 0.0F;
  private float fromRotateY = 0.0F;
  private float fromRotateZ = 0.0F;
  private float fromScaleX = 1.0F;
  private float fromScaleY = 1.0F;
  private float fromX = 0.0F;
  private float fromY = 0.0F;
  private float fromZ = 0.0F;
  private boolean isAlpha = false;
  private boolean isEnd = false;
  private boolean isRotate = false;
  private boolean isScale = false;
  private boolean isTranslate = false;
  private AnimationListenerGL listener;
  private int mDuration = 1000;
  private long mStartTime = 0L;
  private GLView mView;
  private int speedType = 0;
  private float toAlpha = 1.0F;
  private float toRotateX = 0.0F;
  private float toRotateY = 0.0F;
  private float toRotateZ = 0.0F;
  private float toScaleX = 1.0F;
  private float toScaleY = 1.0F;
  private float toX = 0.0F;
  private float toY = 0.0F;
  private float toZ = 0.0F;
  
  public static GLAnimation getAnimByList(List<GLAnimation> paramList)
  {
    GLAnimation localGLAnimation1 = null;
    if (paramList != null)
    {
      for (;;)
      {
        try
        {
          if (paramList.size() != 0)
          {
            localGLAnimation1 = new GLAnimation();
            i1 = 0;
            f12 = 0.0F;
            f11 = 0.0F;
            f9 = 0.0F;
            n = 0;
            f10 = 0.0F;
            k = 0;
            f8 = 0.0F;
            f5 = 0.0F;
            f4 = 0.0F;
            f2 = 0.0F;
            f1 = 0.0F;
            j = 0;
            i = 0;
          }
        }
        finally
        {
          int i1;
          float f12;
          float f11;
          float f9;
          int n;
          float f10;
          int k;
          float f8;
          float f5;
          float f4;
          float f2;
          float f1;
          int j;
          int i;
          continue;
        }
        try
        {
          if (i < paramList.size())
          {
            GLAnimation localGLAnimation2 = (GLAnimation)paramList.get(i);
            int m = i1;
            float f7 = f12;
            float f6 = f11;
            float f3 = f9;
            if (localGLAnimation2.isTranslate)
            {
              localGLAnimation1.isTranslate = true;
              m = i1 + 1;
              f7 = f12 + localGLAnimation2.currentX;
              f6 = f11 + localGLAnimation2.currentY;
              f3 = f9 + localGLAnimation2.currentZ;
            }
            i1 = n;
            f9 = f10;
            if (localGLAnimation2.isAlpha)
            {
              localGLAnimation1.isAlpha = true;
              i1 = n + 1;
              f9 = f10 + localGLAnimation2.currentAlpha;
            }
            int i2 = k;
            f12 = f8;
            f11 = f5;
            if (localGLAnimation2.isScale)
            {
              localGLAnimation1.isScale = true;
              i2 = k + 1;
              f12 = f8 + localGLAnimation2.currentScaleX;
              f11 = f5 + localGLAnimation2.currentScaleY;
            }
            k = j;
            float f13 = f4;
            f8 = f2;
            f5 = f1;
            if (localGLAnimation2.isRotate)
            {
              localGLAnimation1.isRotate = true;
              k = j + 1;
              f13 = f4 + localGLAnimation2.currentRotateX;
              f8 = f2 + localGLAnimation2.currentRotateY;
              f5 = f1 + localGLAnimation2.currentRotateZ;
            }
            if (i == paramList.size() - 1)
            {
              if (localGLAnimation1.isTranslate)
              {
                localGLAnimation1.currentX = (f7 / m);
                localGLAnimation1.currentY = (f6 / m);
                localGLAnimation1.currentZ = (f3 / m);
              }
              if (localGLAnimation1.isAlpha) {
                localGLAnimation1.currentAlpha = (f9 / i1);
              }
              if (localGLAnimation1.isScale)
              {
                localGLAnimation1.currentScaleX = (f12 / i2);
                localGLAnimation1.currentScaleY = (f11 / i2);
              }
              if (localGLAnimation1.isRotate)
              {
                localGLAnimation1.currentRotateX = (f13 / k);
                localGLAnimation1.currentRotateY = (f8 / k);
                localGLAnimation1.currentRotateZ = (f5 / k);
              }
            }
            i += 1;
            n = i1;
            j = k;
            k = i2;
            i1 = m;
            f10 = f9;
            f4 = f13;
            f2 = f8;
            f1 = f5;
            f8 = f12;
            f5 = f11;
            f12 = f7;
            f11 = f6;
            f9 = f3;
          }
          else
          {
            return localGLAnimation1;
          }
        }
        finally {}
      }
      throw localGLAnimation1;
    }
    return null;
  }
  
  public void atEnd()
  {
    if (this.mView != null) {}
    synchronized (this.mView.getListAnim())
    {
      this.mView.getListAnim().remove(this);
      if (this.listener != null)
      {
        this.listener.onAnimationEnd();
        this.listener = null;
      }
      return;
    }
  }
  
  public float getCurrentAlpha()
  {
    return this.currentAlpha;
  }
  
  public float getCurrentRotateX()
  {
    return this.currentRotateX;
  }
  
  public float getCurrentRotateY()
  {
    return this.currentRotateY;
  }
  
  public float getCurrentRotateZ()
  {
    return this.currentRotateZ;
  }
  
  public float getCurrentScaleX()
  {
    return this.currentScaleX;
  }
  
  public float getCurrentScaleY()
  {
    return this.currentScaleY;
  }
  
  public float getCurrentX()
  {
    return this.currentX;
  }
  
  public float getCurrentY()
  {
    return this.currentY;
  }
  
  public float getCurrentZ()
  {
    return this.currentZ;
  }
  
  public boolean isAlpha()
  {
    return this.isAlpha;
  }
  
  public boolean isEnd()
  {
    return this.isEnd;
  }
  
  public boolean isRotate()
  {
    return this.isRotate;
  }
  
  public boolean isScale()
  {
    return this.isScale;
  }
  
  public boolean isTranslate()
  {
    return this.isTranslate;
  }
  
  public boolean runAnimation(long paramLong)
  {
    if (this.isEnd)
    {
      atEnd();
      return this.isEnd;
    }
    if (this.mStartTime == -1L) {
      this.mStartTime = paramLong;
    }
    long l = paramLong - this.mStartTime;
    if (l == 0L) {
      return false;
    }
    paramLong = l;
    if (l >= this.mDuration)
    {
      paramLong = this.mDuration;
      this.isEnd = true;
      atEnd();
    }
    float f = 1.0F;
    if (this.speedType == 0) {
      f = 1.0F * (float)paramLong / this.mDuration;
    }
    for (;;)
    {
      if (this.isTranslate)
      {
        this.currentX = (this.fromX + (this.toX - this.fromX) * f);
        this.currentY = (this.fromY + (this.toY - this.fromY) * f);
        this.currentZ = (this.fromZ + (this.toZ - this.fromZ) * f);
      }
      if (this.isScale)
      {
        this.currentScaleX = (this.fromScaleX + (this.toScaleX - this.fromScaleX) * f);
        this.currentScaleY = (this.fromScaleY + (this.toScaleY - this.fromScaleY) * f);
      }
      if (this.isRotate)
      {
        this.currentRotateX = (this.fromRotateX + (this.toRotateX - this.fromRotateX) * f);
        this.currentRotateY = (this.fromRotateY + (this.toRotateY - this.fromRotateY) * f);
        this.currentRotateZ = (this.fromRotateZ + (this.toRotateZ - this.fromRotateZ) * f);
      }
      if (!this.isAlpha) {
        break;
      }
      this.currentAlpha = (this.fromAlpha + (this.toAlpha - this.fromAlpha) * f);
      break;
      if (this.speedType == 1)
      {
        f = 1.0F * (float)paramLong * (float)paramLong / this.mDuration / this.mDuration;
      }
      else if (this.speedType == 2)
      {
        l = this.mDuration;
        if (paramLong == 0L) {
          f = 0.0F;
        } else {
          f = 1.0F * (float)paramLong * (float)paramLong / (float)l / (float)l * (2.0F * (float)l / (float)paramLong - 1.0F);
        }
      }
    }
  }
  
  public void setAlpha(float paramFloat1, float paramFloat2)
  {
    this.isAlpha = true;
    this.fromAlpha = paramFloat1;
    this.currentAlpha = paramFloat1;
    this.toAlpha = paramFloat2;
  }
  
  public void setAnimationListener(AnimationListenerGL paramAnimationListenerGL)
  {
    this.listener = paramAnimationListenerGL;
  }
  
  public void setDuration(int paramInt)
  {
    this.mDuration = Math.abs(paramInt);
    if (this.mDuration == 0) {
      this.mDuration = 1;
    }
  }
  
  public void setRotate(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    this.isRotate = true;
    this.fromRotateX = paramFloat1;
    this.currentRotateX = paramFloat1;
    this.toRotateX = paramFloat2;
    this.fromRotateY = paramFloat3;
    this.currentRotateY = paramFloat3;
    this.toRotateY = paramFloat4;
    this.fromRotateZ = paramFloat5;
    this.currentRotateZ = paramFloat5;
    this.toRotateZ = paramFloat6;
  }
  
  public void setScale(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.isScale = true;
    this.fromScaleX = paramFloat1;
    this.currentScaleX = paramFloat1;
    this.fromScaleY = paramFloat2;
    this.currentScaleY = paramFloat2;
    this.toScaleX = paramFloat3;
    this.toScaleY = paramFloat4;
  }
  
  public void setSpeedType(int paramInt)
  {
    this.speedType = paramInt;
  }
  
  public void setTranslate(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    this.isTranslate = true;
    this.fromX = paramFloat1;
    this.currentX = paramFloat1;
    this.fromY = paramFloat2;
    this.currentY = paramFloat2;
    this.fromZ = paramFloat3;
    this.currentZ = paramFloat3;
    this.toX = paramFloat4;
    this.toY = paramFloat5;
    this.toZ = paramFloat6;
  }
  
  public void setmView(GLView paramGLView)
  {
    this.mView = paramGLView;
  }
  
  public void startAnimation()
  {
    this.mStartTime = -1L;
  }
  
  public static abstract interface AnimationListenerGL
  {
    public abstract void onAnimationEnd();
  }
  
  public static class AnimationType
  {
    public static final int SPEED_CONSTANT_TYPE = 0;
    public static final int SPEED_DOWN_TYPE = 2;
    public static final int SPEED_UP_TYPE = 1;
  }
  
  public static class LeInterpolator
  {
    private static final byte NORMAL = 34;
    private static byte flag = 34;
    
    public static float getInterpolation(float paramFloat)
    {
      float f = Math.abs(paramFloat);
      paramFloat = f;
      if (flag == 34)
      {
        if (f <= 0.4F) {
          paramFloat = (float)(3.0D * Math.pow(f, 2.0D));
        }
      }
      else {
        return paramFloat;
      }
      return (float)(1.0D - 6.0D * Math.pow(1.0F - f, 5.0D));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.av.opengl.ui.animation.GLAnimation
 * JD-Core Version:    0.7.0.1
 */