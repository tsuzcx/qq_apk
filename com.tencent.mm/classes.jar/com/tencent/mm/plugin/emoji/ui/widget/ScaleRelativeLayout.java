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
  public float aGN = 3.0F;
  private float aGO = 0.5F;
  private float uQK = 1.0F;
  private float uQL = 1.0F;
  private float uQM = 0.0F;
  private float uQN = 0.0F;
  public float uQO = 6.0F;
  private float uQP = 0.3F;
  private View uQQ;
  private boolean uQR = false;
  private ValueAnimator uQS;
  
  public ScaleRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ScaleRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void cWY()
  {
    AppMethodBeat.i(256050);
    View localView = this.uQQ;
    if (localView != null)
    {
      localView.setScaleX(this.uQK);
      localView.setScaleY(this.uQK);
    }
    AppMethodBeat.o(256050);
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
    if ((!this.uQR) && (paramMotionEvent.getPointerCount() == 2))
    {
      this.uQR = true;
      this.uQM = ((float)Math.hypot(paramMotionEvent.getX(0) - paramMotionEvent.getX(1), paramMotionEvent.getY(0) - paramMotionEvent.getY(1)));
      this.uQL = this.uQK;
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
        if (this.uQM <= 0.0F) {
          this.uQM = 0.1F;
        }
        cWY();
        AppMethodBeat.o(109436);
        return true;
        if (paramMotionEvent.getPointerCount() == 2)
        {
          f2 = (float)Math.hypot(paramMotionEvent.getX(0) - paramMotionEvent.getX(1), paramMotionEvent.getY(0) - paramMotionEvent.getY(1));
          f1 = this.uQL * f2 / this.uQM;
          if (f1 > this.uQO)
          {
            f1 = this.uQO;
            this.uQN = (this.uQM * f1);
          }
          for (;;)
          {
            this.uQK = f1;
            if (this.uQS == null) {
              break;
            }
            this.uQS.cancel();
            break;
            if (f1 < this.uQP)
            {
              f1 = this.uQP;
              this.uQN = (this.uQM * f1);
            }
            else
            {
              this.uQN = f2;
            }
          }
          if (paramMotionEvent.getPointerCount() == 2)
          {
            this.uQM = this.uQN;
            this.uQL = this.uQK;
            this.uQR = false;
          }
        }
      }
    }
    float f2 = this.uQK;
    float f1 = this.uQK;
    if (this.uQK < this.aGO) {
      f1 = this.aGO;
    }
    for (;;)
    {
      if (this.uQS != null) {
        this.uQS.cancel();
      }
      this.uQS = ValueAnimator.ofFloat(new float[] { f2, f1 });
      this.uQS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(109434);
          ScaleRelativeLayout.a(ScaleRelativeLayout.this, ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
          ScaleRelativeLayout.a(ScaleRelativeLayout.this);
          AppMethodBeat.o(109434);
        }
      });
      this.uQS.start();
      break;
      if (this.uQK > this.aGN) {
        f1 = this.aGN;
      }
    }
  }
  
  public void setScaleChild(View paramView)
  {
    this.uQQ = paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.widget.ScaleRelativeLayout
 * JD-Core Version:    0.7.0.1
 */