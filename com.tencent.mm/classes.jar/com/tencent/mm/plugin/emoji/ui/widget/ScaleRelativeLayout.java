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
  public float aNk = 3.0F;
  private float aNl = 0.5F;
  private float pmr = 1.0F;
  private float pms = 1.0F;
  private float pmt = 0.0F;
  private float pmu = 0.0F;
  public float pmv = 6.0F;
  private float pmw = 0.3F;
  private boolean pmx = false;
  private ValueAnimator pmy;
  
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
    if ((!this.pmx) && (paramMotionEvent.getPointerCount() == 2))
    {
      this.pmx = true;
      this.pmt = ((float)Math.hypot(paramMotionEvent.getX(0) - paramMotionEvent.getX(1), paramMotionEvent.getY(0) - paramMotionEvent.getY(1)));
      this.pms = this.pmr;
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
        if (this.pmt <= 0.0F) {
          this.pmt = 0.1F;
        }
        int i = 0;
        while (i < getChildCount())
        {
          paramMotionEvent = getChildAt(i);
          paramMotionEvent.setScaleX(this.pmr);
          paramMotionEvent.setScaleY(this.pmr);
          i += 1;
        }
        if (paramMotionEvent.getPointerCount() == 2)
        {
          f2 = (float)Math.hypot(paramMotionEvent.getX(0) - paramMotionEvent.getX(1), paramMotionEvent.getY(0) - paramMotionEvent.getY(1));
          f1 = this.pms * f2 / this.pmt;
          if (f1 > this.pmv)
          {
            f1 = this.pmv;
            this.pmu = (this.pmt * f1);
          }
          for (;;)
          {
            this.pmr = f1;
            if (this.pmy == null) {
              break;
            }
            this.pmy.cancel();
            break;
            if (f1 < this.pmw)
            {
              f1 = this.pmw;
              this.pmu = (this.pmt * f1);
            }
            else
            {
              this.pmu = f2;
            }
          }
          if (paramMotionEvent.getPointerCount() == 2)
          {
            this.pmt = this.pmu;
            this.pms = this.pmr;
            this.pmx = false;
          }
        }
      }
    }
    float f2 = this.pmr;
    float f1 = this.pmr;
    if (this.pmr < this.aNl) {
      f1 = this.aNl;
    }
    for (;;)
    {
      if (this.pmy != null) {
        this.pmy.cancel();
      }
      this.pmy = ValueAnimator.ofFloat(new float[] { f2, f1 });
      this.pmy.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
      this.pmy.start();
      break;
      if (this.pmr > this.aNk) {
        f1 = this.aNk;
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