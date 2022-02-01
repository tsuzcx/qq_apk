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
  public float maxScale = 3.0F;
  private float minScale = 0.5F;
  private float ydA = 0.3F;
  private View ydB;
  private boolean ydC = false;
  private ValueAnimator ydD;
  private float ydv = 1.0F;
  private float ydw = 1.0F;
  private float ydx = 0.0F;
  private float ydy = 0.0F;
  public float ydz = 6.0F;
  
  public ScaleRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ScaleRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void dDo()
  {
    AppMethodBeat.i(270747);
    View localView = this.ydB;
    if (localView != null)
    {
      localView.setScaleX(this.ydv);
      localView.setScaleY(this.ydv);
    }
    AppMethodBeat.o(270747);
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
    if ((!this.ydC) && (paramMotionEvent.getPointerCount() == 2))
    {
      this.ydC = true;
      this.ydx = ((float)Math.hypot(paramMotionEvent.getX(0) - paramMotionEvent.getX(1), paramMotionEvent.getY(0) - paramMotionEvent.getY(1)));
      this.ydw = this.ydv;
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
        if (this.ydx <= 0.0F) {
          this.ydx = 0.1F;
        }
        dDo();
        AppMethodBeat.o(109436);
        return true;
        if (paramMotionEvent.getPointerCount() == 2)
        {
          f2 = (float)Math.hypot(paramMotionEvent.getX(0) - paramMotionEvent.getX(1), paramMotionEvent.getY(0) - paramMotionEvent.getY(1));
          f1 = this.ydw * f2 / this.ydx;
          if (f1 > this.ydz)
          {
            f1 = this.ydz;
            this.ydy = (this.ydx * f1);
          }
          for (;;)
          {
            this.ydv = f1;
            if (this.ydD == null) {
              break;
            }
            this.ydD.cancel();
            break;
            if (f1 < this.ydA)
            {
              f1 = this.ydA;
              this.ydy = (this.ydx * f1);
            }
            else
            {
              this.ydy = f2;
            }
          }
          if (paramMotionEvent.getPointerCount() == 2)
          {
            this.ydx = this.ydy;
            this.ydw = this.ydv;
            this.ydC = false;
          }
        }
      }
    }
    float f2 = this.ydv;
    float f1 = this.ydv;
    if (this.ydv < this.minScale) {
      f1 = this.minScale;
    }
    for (;;)
    {
      if (this.ydD != null) {
        this.ydD.cancel();
      }
      this.ydD = ValueAnimator.ofFloat(new float[] { f2, f1 });
      this.ydD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(109434);
          ScaleRelativeLayout.a(ScaleRelativeLayout.this, ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
          ScaleRelativeLayout.a(ScaleRelativeLayout.this);
          AppMethodBeat.o(109434);
        }
      });
      this.ydD.start();
      break;
      if (this.ydv > this.maxScale) {
        f1 = this.maxScale;
      }
    }
  }
  
  public void setScaleChild(View paramView)
  {
    this.ydB = paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.widget.ScaleRelativeLayout
 * JD-Core Version:    0.7.0.1
 */