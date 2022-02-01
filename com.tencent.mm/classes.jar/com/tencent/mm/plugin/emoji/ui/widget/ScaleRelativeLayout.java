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
  public float aXt = 3.0F;
  private float aXu = 0.5F;
  private float rnA = 0.3F;
  private boolean rnB = false;
  private ValueAnimator rnC;
  private float rnv = 1.0F;
  private float rnw = 1.0F;
  private float rnx = 0.0F;
  private float rny = 0.0F;
  public float rnz = 6.0F;
  
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
    if ((!this.rnB) && (paramMotionEvent.getPointerCount() == 2))
    {
      this.rnB = true;
      this.rnx = ((float)Math.hypot(paramMotionEvent.getX(0) - paramMotionEvent.getX(1), paramMotionEvent.getY(0) - paramMotionEvent.getY(1)));
      this.rnw = this.rnv;
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
        if (this.rnx <= 0.0F) {
          this.rnx = 0.1F;
        }
        int i = 0;
        while (i < getChildCount())
        {
          paramMotionEvent = getChildAt(i);
          paramMotionEvent.setScaleX(this.rnv);
          paramMotionEvent.setScaleY(this.rnv);
          i += 1;
        }
        if (paramMotionEvent.getPointerCount() == 2)
        {
          f2 = (float)Math.hypot(paramMotionEvent.getX(0) - paramMotionEvent.getX(1), paramMotionEvent.getY(0) - paramMotionEvent.getY(1));
          f1 = this.rnw * f2 / this.rnx;
          if (f1 > this.rnz)
          {
            f1 = this.rnz;
            this.rny = (this.rnx * f1);
          }
          for (;;)
          {
            this.rnv = f1;
            if (this.rnC == null) {
              break;
            }
            this.rnC.cancel();
            break;
            if (f1 < this.rnA)
            {
              f1 = this.rnA;
              this.rny = (this.rnx * f1);
            }
            else
            {
              this.rny = f2;
            }
          }
          if (paramMotionEvent.getPointerCount() == 2)
          {
            this.rnx = this.rny;
            this.rnw = this.rnv;
            this.rnB = false;
          }
        }
      }
    }
    float f2 = this.rnv;
    float f1 = this.rnv;
    if (this.rnv < this.aXu) {
      f1 = this.aXu;
    }
    for (;;)
    {
      if (this.rnC != null) {
        this.rnC.cancel();
      }
      this.rnC = ValueAnimator.ofFloat(new float[] { f2, f1 });
      this.rnC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
      this.rnC.start();
      break;
      if (this.rnv > this.aXt) {
        f1 = this.aXt;
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