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
  float fif = 0.0F;
  float fig = 0.0F;
  int fih = 0;
  int fii = 0;
  
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
        this.fif = paramMotionEvent.getX();
        this.fig = paramMotionEvent.getY();
        this.fih = a.a(this.fie).x;
        this.fii = a.a(this.fie).y;
        return true;
        float f2 = paramMotionEvent.getX();
        float f1 = paramMotionEvent.getY();
        paramMotionEvent = a.a(this.fie);
        float f3 = paramMotionEvent.x;
        paramMotionEvent.x = ((int)((f2 - this.fif) / 3.0F + f3));
        paramMotionEvent = a.a(this.fie);
        f2 = paramMotionEvent.y;
        paramMotionEvent.y = ((int)((f1 - this.fig) / 3.0F + f2));
      } while (paramView == null);
      a.b(this.fie).updateViewLayout(paramView, a.a(this.fie));
      return true;
    }
    int j = a.a(this.fie).x;
    if (a.a(this.fie).x > a.c(this.fie).widthPixels / 2) {}
    for (int i = a.c(this.fie).widthPixels - this.fij.getWidth();; i = 0)
    {
      paramMotionEvent = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofInt("trans", new int[] { j, i }) });
      ((ValueAnimator)paramMotionEvent).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          if (!a.d(a.2.this.fie)) {
            return;
          }
          int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue("trans")).intValue();
          a.a(a.2.this.fie).x = i;
          a.b(a.2.this.fie).updateViewLayout(paramView, a.a(a.2.this.fie));
        }
      });
      paramMotionEvent.setInterpolator(new AccelerateInterpolator());
      paramMotionEvent.setDuration(180L).start();
      i = a.a(this.fie).x;
      j = a.a(this.fie).y;
      if ((Math.abs(i - this.fih) > 20) || (Math.abs(j - this.fii) > 20) || (a.e(this.fie) == null)) {
        break;
      }
      a.e(this.fie).onClick(paramView);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.matrix.trace.view.a.2
 * JD-Core Version:    0.7.0.1
 */