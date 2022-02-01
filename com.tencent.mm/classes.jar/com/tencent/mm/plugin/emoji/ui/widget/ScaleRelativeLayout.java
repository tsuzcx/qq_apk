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
  public float aMu = 3.0F;
  private float aMv = 0.5F;
  private float oIR = 1.0F;
  private float oIS = 1.0F;
  private float oIT = 0.0F;
  private float oIU = 0.0F;
  public float oIV = 6.0F;
  private float oIW = 0.3F;
  private boolean oIX = false;
  private ValueAnimator oIY;
  
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
    if ((!this.oIX) && (paramMotionEvent.getPointerCount() == 2))
    {
      this.oIX = true;
      this.oIT = ((float)Math.hypot(paramMotionEvent.getX(0) - paramMotionEvent.getX(1), paramMotionEvent.getY(0) - paramMotionEvent.getY(1)));
      this.oIS = this.oIR;
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
        if (this.oIT <= 0.0F) {
          this.oIT = 0.1F;
        }
        int i = 0;
        while (i < getChildCount())
        {
          paramMotionEvent = getChildAt(i);
          paramMotionEvent.setScaleX(this.oIR);
          paramMotionEvent.setScaleY(this.oIR);
          i += 1;
        }
        if (paramMotionEvent.getPointerCount() == 2)
        {
          f2 = (float)Math.hypot(paramMotionEvent.getX(0) - paramMotionEvent.getX(1), paramMotionEvent.getY(0) - paramMotionEvent.getY(1));
          f1 = this.oIS * f2 / this.oIT;
          if (f1 > this.oIV)
          {
            f1 = this.oIV;
            this.oIU = (this.oIT * f1);
          }
          for (;;)
          {
            this.oIR = f1;
            if (this.oIY == null) {
              break;
            }
            this.oIY.cancel();
            break;
            if (f1 < this.oIW)
            {
              f1 = this.oIW;
              this.oIU = (this.oIT * f1);
            }
            else
            {
              this.oIU = f2;
            }
          }
          if (paramMotionEvent.getPointerCount() == 2)
          {
            this.oIT = this.oIU;
            this.oIS = this.oIR;
            this.oIX = false;
          }
        }
      }
    }
    float f2 = this.oIR;
    float f1 = this.oIR;
    if (this.oIR < this.aMv) {
      f1 = this.aMv;
    }
    for (;;)
    {
      if (this.oIY != null) {
        this.oIY.cancel();
      }
      this.oIY = ValueAnimator.ofFloat(new float[] { f2, f1 });
      this.oIY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
      this.oIY.start();
      break;
      if (this.oIR > this.aMu) {
        f1 = this.aMu;
      }
    }
    AppMethodBeat.o(109436);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.widget.ScaleRelativeLayout
 * JD-Core Version:    0.7.0.1
 */