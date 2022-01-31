package com.tencent.mm.plugin.emoji.ui.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class ScaleRelativeLayout
  extends RelativeLayout
{
  public float apq = 3.0F;
  private float apr = 0.5F;
  private float jjG = 1.0F;
  private float jjH = 1.0F;
  private float jjI = 0.0F;
  private float jjJ = 0.0F;
  public float jjK = 6.0F;
  private float jjL = 0.3F;
  private boolean jjM = false;
  private ValueAnimator jjN;
  
  public ScaleRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ScaleRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    int i = paramCanvas.getWidth();
    int j = paramCanvas.getHeight();
    paramCanvas.save();
    paramCanvas.scale(this.jjG, this.jjG, i / 2, j / 2);
    super.dispatchDraw(paramCanvas);
    paramCanvas.restore();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerCount() > 1) {
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!this.jjM) && (paramMotionEvent.getPointerCount() == 2))
    {
      this.jjM = true;
      this.jjI = ((float)Math.hypot(paramMotionEvent.getX(0) - paramMotionEvent.getX(1), paramMotionEvent.getY(0) - paramMotionEvent.getY(1)));
      this.jjH = this.jjG;
    }
    switch (paramMotionEvent.getActionMasked())
    {
    case 3: 
    case 4: 
    case 5: 
    default: 
    case 2: 
    case 6: 
      for (;;)
      {
        if (this.jjI <= 0.0F) {
          this.jjI = 0.1F;
        }
        postInvalidate();
        return true;
        if (paramMotionEvent.getPointerCount() == 2)
        {
          f2 = (float)Math.hypot(paramMotionEvent.getX(0) - paramMotionEvent.getX(1), paramMotionEvent.getY(0) - paramMotionEvent.getY(1));
          f1 = this.jjH * f2 / this.jjI;
          if (f1 > this.jjK)
          {
            f1 = this.jjK;
            this.jjJ = (this.jjI * f1);
          }
          for (;;)
          {
            this.jjG = f1;
            if (this.jjN == null) {
              break;
            }
            this.jjN.cancel();
            break;
            if (f1 < this.jjL)
            {
              f1 = this.jjL;
              this.jjJ = (this.jjI * f1);
            }
            else
            {
              this.jjJ = f2;
            }
          }
          if (paramMotionEvent.getPointerCount() == 2)
          {
            this.jjI = this.jjJ;
            this.jjH = this.jjG;
            this.jjM = false;
          }
        }
      }
    }
    float f2 = this.jjG;
    float f1 = this.jjG;
    if (this.jjG < this.apr) {
      f1 = this.apr;
    }
    for (;;)
    {
      if (this.jjN != null) {
        this.jjN.cancel();
      }
      this.jjN = ValueAnimator.ofFloat(new float[] { f2, f1 });
      this.jjN.addUpdateListener(new ScaleRelativeLayout.1(this));
      this.jjN.start();
      break;
      if (this.jjG > this.apq) {
        f1 = this.apq;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.widget.ScaleRelativeLayout
 * JD-Core Version:    0.7.0.1
 */