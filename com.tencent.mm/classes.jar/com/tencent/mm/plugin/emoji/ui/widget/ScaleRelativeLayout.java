package com.tencent.mm.plugin.emoji.ui.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ScaleRelativeLayout
  extends RelativeLayout
{
  public float arJ = 3.0F;
  private float arK = 0.5F;
  private float lsA = 0.0F;
  private float lsB = 0.0F;
  public float lsC = 6.0F;
  private float lsD = 0.3F;
  private boolean lsE = false;
  private ValueAnimator lsF;
  private float lsy = 1.0F;
  private float lsz = 1.0F;
  
  public ScaleRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ScaleRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(53860);
    if (paramMotionEvent.getPointerCount() > 1)
    {
      AppMethodBeat.o(53860);
      return true;
    }
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(53860);
    return bool;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(53861);
    if ((!this.lsE) && (paramMotionEvent.getPointerCount() == 2))
    {
      this.lsE = true;
      this.lsA = ((float)Math.hypot(paramMotionEvent.getX(0) - paramMotionEvent.getX(1), paramMotionEvent.getY(0) - paramMotionEvent.getY(1)));
      this.lsz = this.lsy;
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
        if (this.lsA <= 0.0F) {
          this.lsA = 0.1F;
        }
        int i = 0;
        while (i < getChildCount())
        {
          paramMotionEvent = getChildAt(i);
          paramMotionEvent.setScaleX(this.lsy);
          paramMotionEvent.setScaleY(this.lsy);
          i += 1;
        }
        if (paramMotionEvent.getPointerCount() == 2)
        {
          f2 = (float)Math.hypot(paramMotionEvent.getX(0) - paramMotionEvent.getX(1), paramMotionEvent.getY(0) - paramMotionEvent.getY(1));
          f1 = this.lsz * f2 / this.lsA;
          if (f1 > this.lsC)
          {
            f1 = this.lsC;
            this.lsB = (this.lsA * f1);
          }
          for (;;)
          {
            this.lsy = f1;
            if (this.lsF == null) {
              break;
            }
            this.lsF.cancel();
            break;
            if (f1 < this.lsD)
            {
              f1 = this.lsD;
              this.lsB = (this.lsA * f1);
            }
            else
            {
              this.lsB = f2;
            }
          }
          if (paramMotionEvent.getPointerCount() == 2)
          {
            this.lsA = this.lsB;
            this.lsz = this.lsy;
            this.lsE = false;
          }
        }
      }
    }
    float f2 = this.lsy;
    float f1 = this.lsy;
    if (this.lsy < this.arK) {
      f1 = this.arK;
    }
    for (;;)
    {
      if (this.lsF != null) {
        this.lsF.cancel();
      }
      this.lsF = ValueAnimator.ofFloat(new float[] { f2, f1 });
      this.lsF.addUpdateListener(new ScaleRelativeLayout.1(this));
      this.lsF.start();
      break;
      if (this.lsy > this.arJ) {
        f1 = this.arJ;
      }
    }
    AppMethodBeat.o(53861);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.widget.ScaleRelativeLayout
 * JD-Core Version:    0.7.0.1
 */