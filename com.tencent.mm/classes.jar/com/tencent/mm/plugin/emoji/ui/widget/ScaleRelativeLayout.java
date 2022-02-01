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
  private float pPR = 1.0F;
  private float pPS = 1.0F;
  private float pPT = 0.0F;
  private float pPU = 0.0F;
  public float pPV = 6.0F;
  private float pPW = 0.3F;
  private boolean pPX = false;
  private ValueAnimator pPY;
  
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
    if ((!this.pPX) && (paramMotionEvent.getPointerCount() == 2))
    {
      this.pPX = true;
      this.pPT = ((float)Math.hypot(paramMotionEvent.getX(0) - paramMotionEvent.getX(1), paramMotionEvent.getY(0) - paramMotionEvent.getY(1)));
      this.pPS = this.pPR;
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
        if (this.pPT <= 0.0F) {
          this.pPT = 0.1F;
        }
        int i = 0;
        while (i < getChildCount())
        {
          paramMotionEvent = getChildAt(i);
          paramMotionEvent.setScaleX(this.pPR);
          paramMotionEvent.setScaleY(this.pPR);
          i += 1;
        }
        if (paramMotionEvent.getPointerCount() == 2)
        {
          f2 = (float)Math.hypot(paramMotionEvent.getX(0) - paramMotionEvent.getX(1), paramMotionEvent.getY(0) - paramMotionEvent.getY(1));
          f1 = this.pPS * f2 / this.pPT;
          if (f1 > this.pPV)
          {
            f1 = this.pPV;
            this.pPU = (this.pPT * f1);
          }
          for (;;)
          {
            this.pPR = f1;
            if (this.pPY == null) {
              break;
            }
            this.pPY.cancel();
            break;
            if (f1 < this.pPW)
            {
              f1 = this.pPW;
              this.pPU = (this.pPT * f1);
            }
            else
            {
              this.pPU = f2;
            }
          }
          if (paramMotionEvent.getPointerCount() == 2)
          {
            this.pPT = this.pPU;
            this.pPS = this.pPR;
            this.pPX = false;
          }
        }
      }
    }
    float f2 = this.pPR;
    float f1 = this.pPR;
    if (this.pPR < this.aXF) {
      f1 = this.aXF;
    }
    for (;;)
    {
      if (this.pPY != null) {
        this.pPY.cancel();
      }
      this.pPY = ValueAnimator.ofFloat(new float[] { f2, f1 });
      this.pPY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
      this.pPY.start();
      break;
      if (this.pPR > this.aXE) {
        f1 = this.aXE;
      }
    }
    AppMethodBeat.o(109436);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.widget.ScaleRelativeLayout
 * JD-Core Version:    0.7.0.1
 */