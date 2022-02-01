package com.tencent.mm.plugin.finder.webview.ad;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/webview/ad/ScrollFrameLayout;", "Lcom/tencent/mm/ui/widget/RoundedCornerFrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "", "isAllowHorizontalIntercept", "()Z", "setAllowHorizontalIntercept", "(Z)V", "isAllowVerticalIntercept", "setAllowVerticalIntercept", "isAnimating", "setAnimating", "isForceHandleEvent", "setForceHandleEvent", "mDownX", "", "getMDownX", "()F", "setMDownX", "(F)V", "mDownY", "getMDownY", "setMDownY", "mInterceptX", "getMInterceptX", "setMInterceptX", "mInterceptY", "getMInterceptY", "setMInterceptY", "mPointerTranslateY", "getMPointerTranslateY", "setMPointerTranslateY", "mVelocityTracker", "Landroid/view/VelocityTracker;", "getMVelocityTracker", "()Landroid/view/VelocityTracker;", "setMVelocityTracker", "(Landroid/view/VelocityTracker;)V", "scrollDownLimit", "getScrollDownLimit", "setScrollDownLimit", "scrollUpLimit", "getScrollUpLimit", "setScrollUpLimit", "animatePosition", "", "toTranslationY", "isIntercept", "duration", "finishRunnable", "Ljava/lang/Runnable;", "cancel", "clear", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "getMoveDistanceByOffsetX", "offsetX", "getMoveDistanceByOffsetY", "offsetY", "interceptHorizontal", "distanceX", "distanceY", "velocityX", "velocityY", "interceptVertical", "onActionCancel", "onActionUp", "onInterceptTouchEvent", "onTouchEvent", "scroll", "distance", "scrollHorizontal", "scrollVertical", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class ScrollFrameLayout
  extends RoundedCornerFrameLayout
{
  public static final ScrollFrameLayout.a GYN = new ScrollFrameLayout.a((byte)0);
  private static float mkm;
  private static float mkn;
  private float GYO;
  private float GYP;
  private float GYQ;
  private float GYR;
  private float GYS;
  private boolean GYT;
  private boolean GYU;
  private boolean GYV;
  private boolean isAnimating;
  private VelocityTracker mVelocityTracker;
  private float puO;
  private float puP;
  
  public ScrollFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ScrollFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.GYR = paramContext.getResources().getDimension(e.c.Edge_10A);
  }
  
  public final void a(float paramFloat, boolean paramBoolean, int paramInt, final Runnable paramRunnable)
  {
    if (this.GYO == 0.0F) {}
    for (int i = 1; (i != 0) && (paramBoolean); i = 0) {
      return;
    }
    animate().cancel();
    animate().translationY(paramFloat).setDuration(paramInt).setInterpolator((TimeInterpolator)new DecelerateInterpolator()).setListener((Animator.AnimatorListener)new b(this, paramRunnable)).start();
  }
  
  public boolean c(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    return (paramFloat2 >= 10.0F) && (Math.abs(paramFloat2) >= 10.0F) && (Math.abs(paramInt2) > Math.abs(paramInt1)) && (Math.abs(paramFloat2) > Math.abs(paramFloat1)) && (paramFloat2 >= 0.0F);
  }
  
  public void clear()
  {
    this.GYP = 0.0F;
    this.GYQ = 0.0F;
    this.puO = 0.0F;
    this.puP = 0.0F;
    setAllowVerticalIntercept(false);
    setAllowHorizontalIntercept(false);
  }
  
  public abstract void ct(float paramFloat);
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    s.u(paramMotionEvent, "ev");
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void fql()
  {
    a(this, 0.0F, false, 0, null, 15);
    clear();
  }
  
  public void fqm()
  {
    a(this, 0.0F, false, 0, null, 15);
    clear();
  }
  
  protected final float getMDownX()
  {
    return this.puO;
  }
  
  protected final float getMDownY()
  {
    return this.puP;
  }
  
  protected final float getMInterceptX()
  {
    return this.GYP;
  }
  
  protected final float getMInterceptY()
  {
    return this.GYQ;
  }
  
  protected final float getMPointerTranslateY()
  {
    return this.GYO;
  }
  
  protected final VelocityTracker getMVelocityTracker()
  {
    return this.mVelocityTracker;
  }
  
  public final float getScrollDownLimit()
  {
    return this.GYR;
  }
  
  public final float getScrollUpLimit()
  {
    return this.GYS;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    s.u(paramMotionEvent, "ev");
    if (paramMotionEvent.getAction() == 0)
    {
      mkm = paramMotionEvent.getX();
      mkn = paramMotionEvent.getY();
    }
    if ((!this.GYT) && (!this.GYU)) {
      return false;
    }
    boolean bool3 = super.onInterceptTouchEvent(paramMotionEvent);
    if (bool3) {
      return bool3;
    }
    if (paramMotionEvent.getAction() == 0)
    {
      localVelocityTracker = this.mVelocityTracker;
      if (localVelocityTracker != null)
      {
        localVelocityTracker.recycle();
        setMVelocityTracker(null);
      }
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    VelocityTracker localVelocityTracker = this.mVelocityTracker;
    if (localVelocityTracker != null) {
      localVelocityTracker.addMovement(paramMotionEvent);
    }
    localVelocityTracker = this.mVelocityTracker;
    if (localVelocityTracker != null) {
      localVelocityTracker.computeCurrentVelocity(1000);
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
      bool1 = bool2;
    }
    for (;;)
    {
      Log.i("Finder.WebViewFrameLayout", s.X("isIntercept:", Boolean.valueOf(bool1)));
      return bool1;
      this.GYP = paramMotionEvent.getRawX();
      this.GYQ = paramMotionEvent.getRawY();
      bool1 = bool2;
      continue;
      localVelocityTracker = this.mVelocityTracker;
      s.checkNotNull(localVelocityTracker);
      int j = (int)localVelocityTracker.getXVelocity();
      localVelocityTracker = this.mVelocityTracker;
      s.checkNotNull(localVelocityTracker);
      int k = (int)localVelocityTracker.getYVelocity();
      Log.i("Finder.WebViewFrameLayout", "onInterceptTouchEvent mInterceptX:" + this.GYP + " mInterceptY:" + this.GYQ);
      if (this.GYP == 0.0F)
      {
        i = 1;
        label312:
        if (i == 0) {
          break label369;
        }
        if (this.GYQ != 0.0F) {
          break label363;
        }
      }
      label363:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label369;
        }
        this.GYP = paramMotionEvent.getRawX();
        this.GYQ = paramMotionEvent.getRawY();
        bool1 = bool2;
        break;
        i = 0;
        break label312;
      }
      label369:
      float f1 = paramMotionEvent.getRawX() - this.GYP;
      float f2 = paramMotionEvent.getRawY() - this.GYQ;
      if ((!this.GYT) || (!c(f1, f2, j, k)))
      {
        label481:
        label485:
        for (;;)
        {
          if (this.GYU) {
            if ((f1 < 10.0F) || (Math.abs(f1) < 10.0F) || (Math.abs(j) <= Math.abs(k)) || (Math.abs(f1) <= Math.abs(f2)) || (f1 < 0.0F)) {
              break label481;
            }
          }
          for (i = 1;; i = 0)
          {
            if (i != 0) {
              break label485;
            }
            bool1 = false;
            break;
          }
        }
        clear();
        bool1 = bool2;
        continue;
        clear();
        bool1 = bool2;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    s.u(paramMotionEvent, "ev");
    Log.i("Finder.WebViewFrameLayout", "onTouchEvent:" + paramMotionEvent + " action:" + paramMotionEvent.getAction() + " isAnimating:" + this.isAnimating);
    if (this.isAnimating) {
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    while (this.GYV)
    {
      return true;
      this.puO = paramMotionEvent.getRawX();
      this.puP = paramMotionEvent.getRawY();
      continue;
      if (this.puO == 0.0F) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label191;
        }
        i = j;
        if (this.puP == 0.0F) {
          i = 1;
        }
        if (i == 0) {
          break label191;
        }
        this.puO = paramMotionEvent.getRawX();
        this.puP = paramMotionEvent.getRawY();
        break;
      }
      label191:
      float f1 = paramMotionEvent.getRawX() - this.puO;
      float f2 = paramMotionEvent.getRawY() - this.puP;
      this.puO = paramMotionEvent.getRawX();
      this.puP = paramMotionEvent.getRawY();
      if ((this.GYT) || (this.GYV))
      {
        if (Math.abs(f2) < Math.abs(f1)) {
          Log.i("Finder.WebViewFrameLayout", "scrollVertical return");
        } else {
          ct(0.65F * f2);
        }
      }
      else if ((this.GYU) || (this.GYV)) {
        if (Math.abs(f1) < Math.abs(f2))
        {
          Log.i("Finder.WebViewFrameLayout", "scrollHorizontal return");
        }
        else
        {
          ct(f1 * 0.85F);
          continue;
          fqm();
          continue;
          fql();
        }
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public final void setAllowHorizontalIntercept(boolean paramBoolean)
  {
    Log.i("Finder.WebViewFrameLayout", s.X("isAllowHorizontalIntercept :", Boolean.valueOf(paramBoolean)));
    this.GYU = paramBoolean;
  }
  
  public final void setAllowVerticalIntercept(boolean paramBoolean)
  {
    Log.i("Finder.WebViewFrameLayout", s.X("isAllowVerticalIntercept :", Boolean.valueOf(paramBoolean)));
    this.GYT = paramBoolean;
  }
  
  protected final void setAnimating(boolean paramBoolean)
  {
    this.isAnimating = paramBoolean;
  }
  
  public final void setForceHandleEvent(boolean paramBoolean)
  {
    this.GYV = paramBoolean;
  }
  
  protected final void setMDownX(float paramFloat)
  {
    this.puO = paramFloat;
  }
  
  protected final void setMDownY(float paramFloat)
  {
    this.puP = paramFloat;
  }
  
  protected final void setMInterceptX(float paramFloat)
  {
    this.GYP = paramFloat;
  }
  
  protected final void setMInterceptY(float paramFloat)
  {
    this.GYQ = paramFloat;
  }
  
  protected final void setMPointerTranslateY(float paramFloat)
  {
    this.GYO = paramFloat;
  }
  
  protected final void setMVelocityTracker(VelocityTracker paramVelocityTracker)
  {
    this.mVelocityTracker = paramVelocityTracker;
  }
  
  public final void setScrollDownLimit(float paramFloat)
  {
    this.GYR = paramFloat;
  }
  
  public final void setScrollUpLimit(float paramFloat)
  {
    this.GYS = paramFloat;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/webview/ad/ScrollFrameLayout$animatePosition$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Animator.AnimatorListener
  {
    b(ScrollFrameLayout paramScrollFrameLayout, Runnable paramRunnable) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(334609);
      Log.i("Finder.WebViewFrameLayout", s.X("onAnimationCancel ", Float.valueOf(this.GYW.getTranslationY())));
      this.GYW.setAnimating(false);
      this.GYW.setMPointerTranslateY(0.0F);
      paramAnimator = paramRunnable;
      if (paramAnimator != null) {
        paramAnimator.run();
      }
      AppMethodBeat.o(334609);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(334605);
      Log.i("Finder.WebViewFrameLayout", s.X("onAnimationEnd : ", Float.valueOf(this.GYW.getTranslationY())));
      this.GYW.setAnimating(false);
      this.GYW.setMPointerTranslateY(0.0F);
      paramAnimator = paramRunnable;
      if (paramAnimator != null) {
        paramAnimator.run();
      }
      AppMethodBeat.o(334605);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(334600);
      Log.i("Finder.WebViewFrameLayout", s.X("onAnimationStart ", Float.valueOf(this.GYW.getTranslationY())));
      this.GYW.setAnimating(true);
      this.GYW.setMPointerTranslateY(0.0F);
      AppMethodBeat.o(334600);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.webview.ad.ScrollFrameLayout
 * JD-Core Version:    0.7.0.1
 */