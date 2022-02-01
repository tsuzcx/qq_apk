package com.tencent.mm.plugin.emoji.ui.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ScaleRelativeLayout
  extends RelativeLayout
{
  public float aXE = 3.0F;
  private float aXF = 0.5F;
  public float pWA = 6.0F;
  private float pWB = 0.3F;
  private boolean pWC = false;
  private ValueAnimator pWD;
  private float pWw = 1.0F;
  private float pWx = 1.0F;
  private float pWy = 0.0F;
  private float pWz = 0.0F;
  
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
    AppMethodBeat.i(109435);
    if (paramMotionEvent.getPointerCount() > 1)
    {
      AppMethodBeat.o(109435);
      return true;
    }
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(109435);
    return bool;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(109436);
    if ((!this.pWC) && (paramMotionEvent.getPointerCount() == 2))
    {
      this.pWC = true;
      this.pWy = ((float)Math.hypot(paramMotionEvent.getX(0) - paramMotionEvent.getX(1), paramMotionEvent.getY(0) - paramMotionEvent.getY(1)));
      this.pWx = this.pWw;
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
        if (this.pWy <= 0.0F) {
          this.pWy = 0.1F;
        }
        int i = 0;
        while (i < getChildCount())
        {
          paramMotionEvent = getChildAt(i);
          paramMotionEvent.setScaleX(this.pWw);
          paramMotionEvent.setScaleY(this.pWw);
          i += 1;
        }
        if (paramMotionEvent.getPointerCount() == 2)
        {
          f2 = (float)Math.hypot(paramMotionEvent.getX(0) - paramMotionEvent.getX(1), paramMotionEvent.getY(0) - paramMotionEvent.getY(1));
          f1 = this.pWx * f2 / this.pWy;
          if (f1 > this.pWA)
          {
            f1 = this.pWA;
            this.pWz = (this.pWy * f1);
          }
          for (;;)
          {
            this.pWw = f1;
            if (this.pWD == null) {
              break;
            }
            this.pWD.cancel();
            break;
            if (f1 < this.pWB)
            {
              f1 = this.pWB;
              this.pWz = (this.pWy * f1);
            }
            else
            {
              this.pWz = f2;
            }
          }
          if (paramMotionEvent.getPointerCount() == 2)
          {
            this.pWy = this.pWz;
            this.pWx = this.pWw;
            this.pWC = false;
          }
        }
      }
    }
    float f2 = this.pWw;
    float f1 = this.pWw;
    if (this.pWw < this.aXF) {
      f1 = this.aXF;
    }
    for (;;)
    {
      if (this.pWD != null) {
        this.pWD.cancel();
      }
      this.pWD = ValueAnimator.ofFloat(new float[] { f2, f1 });
      this.pWD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(109434);
          ScaleRelativeLayout.a(ScaleRelativeLayout.this, ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
          int i = 0;
          while (i < ScaleRelativeLayout.this.getChildCount())
          {
            paramAnonymousValueAnimator = ScaleRelativeLayout.this.getChildAt(i);
            paramAnonymousValueAnimator.setScaleX(ScaleRelativeLayout.a(ScaleRelativeLayout.this));
            paramAnonymousValueAnimator.setScaleY(ScaleRelativeLayout.a(ScaleRelativeLayout.this));
            i += 1;
          }
          AppMethodBeat.o(109434);
        }
      });
      this.pWD.start();
      break;
      if (this.pWw > this.aXE) {
        f1 = this.aXE;
      }
    }
    AppMethodBeat.o(109436);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.widget.ScaleRelativeLayout
 * JD-Core Version:    0.7.0.1
 */