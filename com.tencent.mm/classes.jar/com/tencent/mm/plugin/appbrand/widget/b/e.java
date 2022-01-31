package com.tencent.mm.plugin.appbrand.widget.b;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.plugin.appbrand.widget.k.a;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.LinkedList;

public final class e
  extends FrameLayout
  implements i
{
  private final g hsv = new g(this);
  public final LinkedList<h> hsw = new LinkedList();
  private final Runnable hsx = new e.2(this);
  private h hsy;
  private h hsz;
  private final View.OnClickListener mOnClickListener = new e.1(this);
  
  public e(Context paramContext)
  {
    super(paramContext);
    setVisibility(4);
    setBackgroundColor(0);
    setOnClickListener(this.mOnClickListener);
  }
  
  public final void b(h paramh)
  {
    if (!ai.isMainThread())
    {
      ai.d(new e.3(this, paramh));
      return;
    }
    com.tencent.luggage.j.e.af(getContext());
    Object localObject = this.hsv;
    int i;
    if ((((g)localObject).hsF != null) && (((g)localObject).hsF.isRunning()))
    {
      i = 1;
      if (i != 0)
      {
        localObject = this.hsv;
        if (((g)localObject).hsF != null) {
          ((g)localObject).hsF.cancel();
        }
      }
      localObject = paramh.getContentView();
      if (((View)localObject).getParent() != this) {
        if ((localObject != null) && (((View)localObject).getParent() != null)) {
          break label200;
        }
      }
    }
    for (;;)
    {
      addView((View)localObject, new FrameLayout.LayoutParams(-2, -2, 17));
      if (this.hsz != paramh)
      {
        ((View)localObject).clearAnimation();
        ((View)localObject).startAnimation(AnimationUtils.loadAnimation(getContext(), k.a.appbrand_dialog_enter));
      }
      this.hsz = paramh;
      ((View)localObject).setOnClickListener(this.mOnClickListener);
      this.hsw.add(paramh);
      paramh.a(this);
      setVisibility(0);
      this.hsv.c(Color.argb(127, 0, 0, 0), null);
      return;
      i = 0;
      break;
      label200:
      ((ViewGroup)((View)localObject).getParent()).removeView((View)localObject);
    }
  }
  
  public final void c(h paramh)
  {
    if (paramh.getContentView().getParent() != this) {}
    do
    {
      do
      {
        return;
      } while (this.hsy == paramh);
      this.hsy = paramh;
      View localView = paramh.getContentView();
      localView.animate().cancel();
      localView.clearAnimation();
      Object localObject = AnimationUtils.loadInterpolator(localView.getContext(), k.a.decelerate_quint_interpolator);
      Interpolator localInterpolator = AnimationUtils.loadInterpolator(localView.getContext(), k.a.decelerate_cubic_interpolator);
      AnimatorSet localAnimatorSet = new AnimatorSet();
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(localView, "scaleX", new float[] { 1.0F, 0.9F }).setDuration(220L);
      localObjectAnimator1.setInterpolator((TimeInterpolator)localObject);
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(localView, "scaleY", new float[] { 1.0F, 0.9F }).setDuration(220L);
      localObjectAnimator2.setInterpolator((TimeInterpolator)localObject);
      localObject = ObjectAnimator.ofFloat(localView, "alpha", new float[] { 1.0F, 0.0F }).setDuration(150L);
      ((Animator)localObject).setInterpolator(localInterpolator);
      localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObject });
      localAnimatorSet.addListener(new e.4(this, localView, paramh));
      localAnimatorSet.start();
    } while (this.hsw.size() > 1);
    this.hsv.c(0, this.hsx);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (getChildCount() == 0) {
      return false;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.e
 * JD-Core Version:    0.7.0.1
 */