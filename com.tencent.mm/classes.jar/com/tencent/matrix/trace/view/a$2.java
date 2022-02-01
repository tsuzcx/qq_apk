package com.tencent.matrix.trace.view;

import android.animation.Animator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateInterpolator;

final class a$2
  implements View.OnTouchListener
{
  float dit = 0.0F;
  float diu = 0.0F;
  int div = 0;
  int diw = 0;
  
  a$2(a parama, FloatFrameView paramFloatFrameView) {}
  
  public final boolean onTouch(final View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        return true;
        this.dit = paramMotionEvent.getX();
        this.diu = paramMotionEvent.getY();
        this.div = a.a(this.dis).x;
        this.diw = a.a(this.dis).y;
        return true;
        float f2 = paramMotionEvent.getX();
        float f1 = paramMotionEvent.getY();
        paramMotionEvent = a.a(this.dis);
        float f3 = paramMotionEvent.x;
        paramMotionEvent.x = ((int)((f2 - this.dit) / 3.0F + f3));
        paramMotionEvent = a.a(this.dis);
        f2 = paramMotionEvent.y;
        paramMotionEvent.y = ((int)((f1 - this.diu) / 3.0F + f2));
      } while (paramView == null);
      a.b(this.dis).updateViewLayout(paramView, a.a(this.dis));
      return true;
    }
    int j = a.a(this.dis).x;
    if (a.a(this.dis).x > a.c(this.dis).widthPixels / 2) {}
    for (int i = a.c(this.dis).widthPixels - this.dix.getWidth();; i = 0)
    {
      paramMotionEvent = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofInt("trans", new int[] { j, i }) });
      ((ValueAnimator)paramMotionEvent).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          if (!a.d(a.2.this.dis)) {
            return;
          }
          int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue("trans")).intValue();
          a.a(a.2.this.dis).x = i;
          a.b(a.2.this.dis).updateViewLayout(paramView, a.a(a.2.this.dis));
        }
      });
      paramMotionEvent.setInterpolator(new AccelerateInterpolator());
      paramMotionEvent.setDuration(180L).start();
      i = a.a(this.dis).x;
      j = a.a(this.dis).y;
      if ((Math.abs(i - this.div) > 20) || (Math.abs(j - this.diw) > 20) || (a.e(this.dis) == null)) {
        break;
      }
      a.e(this.dis).onClick(paramView);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.trace.view.a.2
 * JD-Core Version:    0.7.0.1
 */