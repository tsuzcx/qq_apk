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
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.widget.MMWebView.b;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/webview/ad/WebViewFrameLayout;", "Lcom/tencent/mm/ui/widget/RoundedCornerFrameLayout;", "Lcom/tencent/mm/ui/widget/MMWebView$MMScrollListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dialog", "Lcom/tencent/mm/ui/base/MMDialog;", "getDialog", "()Lcom/tencent/mm/ui/base/MMDialog;", "setDialog", "(Lcom/tencent/mm/ui/base/MMDialog;)V", "value", "", "isAllowHorizontalIntercept", "()Z", "setAllowHorizontalIntercept", "(Z)V", "isAllowVerticalIntercept", "setAllowVerticalIntercept", "isAnimating", "isForceHandleEvent", "setForceHandleEvent", "mDownX", "", "mDownY", "mInterceptX", "mInterceptY", "mTranslateY", "mVelocityTracker", "Landroid/view/VelocityTracker;", "scrollLimit", "cancel", "", "clear", "dismiss", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "getMoveDistanceByOffsetX", "offsetX", "getMoveDistanceByOffsetY", "offsetY", "interceptHorizontal", "distanceX", "distanceY", "velocityX", "velocityY", "interceptVertical", "onInterceptTouchEvent", "onOverScroll", "deltaX", "deltaY", "scrollX", "scrollY", "scrollRangeX", "scrollRangeY", "maxOverScrollX", "maxOverScrollY", "isTouchEvent", "onTouchEvent", "resetPosition", "scroll", "distance", "scrollHorizontal", "scrollVertical", "Companion", "plugin-finder_release"})
public final class WebViewFrameLayout
  extends RoundedCornerFrameLayout
  implements MMWebView.b
{
  public static final a Bsv;
  private static float jLa;
  private static float jLb;
  private float BpS;
  private i Bso;
  private float Bsp;
  private float Bsq;
  private float Bsr;
  private boolean Bss;
  private boolean Bst;
  private boolean Bsu;
  private float auy;
  private boolean isAnimating;
  private VelocityTracker mVelocityTracker;
  private float rpT;
  
  static
  {
    AppMethodBeat.i(290719);
    Bsv = new a((byte)0);
    AppMethodBeat.o(290719);
  }
  
  public WebViewFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(290717);
    AppMethodBeat.o(290717);
  }
  
  public WebViewFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(290718);
    this.Bsr = paramContext.getResources().getDimension(b.d.Edge_10A);
    AppMethodBeat.o(290718);
  }
  
  private final void bp(float paramFloat)
  {
    AppMethodBeat.i(290714);
    if (this.auy + paramFloat > this.Bsr) {
      dismiss();
    }
    for (;;)
    {
      setTranslationY(this.auy);
      Log.i("Finder.WebViewFrameLayout", "translationY :" + getTranslationY() + " offsetY:" + paramFloat);
      AppMethodBeat.o(290714);
      return;
      if (this.auy + paramFloat < 0.0F) {
        this.auy = 0.0F;
      } else {
        this.auy += paramFloat;
      }
    }
  }
  
  private final void clear()
  {
    AppMethodBeat.i(290713);
    this.Bsp = 0.0F;
    this.Bsq = 0.0F;
    this.BpS = 0.0F;
    this.rpT = 0.0F;
    setAllowVerticalIntercept(false);
    setAllowHorizontalIntercept(false);
    AppMethodBeat.o(290713);
  }
  
  private final void dismiss()
  {
    AppMethodBeat.i(290715);
    i locali = this.Bso;
    if (locali != null)
    {
      locali.dismiss();
      AppMethodBeat.o(290715);
      return;
    }
    AppMethodBeat.o(290715);
  }
  
  private final void emh()
  {
    AppMethodBeat.i(290716);
    if (this.auy == 0.0F)
    {
      AppMethodBeat.o(290716);
      return;
    }
    animate().cancel();
    animate().translationY(0.0F).setDuration(200L).setInterpolator((TimeInterpolator)new DecelerateInterpolator()).setListener((Animator.AnimatorListener)new b(this)).start();
    AppMethodBeat.o(290716);
  }
  
  public final boolean I(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return true;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(290710);
    p.k(paramMotionEvent, "ev");
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(290710);
    return bool;
  }
  
  public final i getDialog()
  {
    return this.Bso;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    AppMethodBeat.i(290711);
    p.k(paramMotionEvent, "ev");
    if (paramMotionEvent.getAction() == 0)
    {
      jLa = paramMotionEvent.getX();
      jLb = paramMotionEvent.getY();
    }
    if ((!this.Bss) && (!this.Bst))
    {
      AppMethodBeat.o(290711);
      return false;
    }
    boolean bool3 = super.onInterceptTouchEvent(paramMotionEvent);
    if (bool3)
    {
      AppMethodBeat.o(290711);
      return bool3;
    }
    if (paramMotionEvent.getAction() == 0)
    {
      localVelocityTracker = this.mVelocityTracker;
      if (localVelocityTracker != null)
      {
        localVelocityTracker.recycle();
        this.mVelocityTracker = null;
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
      Log.i("Finder.WebViewFrameLayout", "isIntercept:".concat(String.valueOf(bool1)));
      AppMethodBeat.o(290711);
      return bool1;
      this.Bsp = paramMotionEvent.getRawX();
      this.Bsq = paramMotionEvent.getRawY();
      bool1 = bool2;
      continue;
      localVelocityTracker = this.mVelocityTracker;
      if (localVelocityTracker == null) {
        p.iCn();
      }
      int j = (int)localVelocityTracker.getXVelocity();
      localVelocityTracker = this.mVelocityTracker;
      if (localVelocityTracker == null) {
        p.iCn();
      }
      int k = (int)localVelocityTracker.getYVelocity();
      Log.i("Finder.WebViewFrameLayout", "onInterceptTouchEvent mInterceptX:" + this.Bsp + " mInterceptY:" + this.Bsq);
      if ((this.Bsp == 0.0F) && (this.Bsq == 0.0F))
      {
        this.Bsp = paramMotionEvent.getRawX();
        this.Bsq = paramMotionEvent.getRawY();
        bool1 = bool2;
      }
      else
      {
        float f1 = paramMotionEvent.getRawX() - this.Bsp;
        float f2 = paramMotionEvent.getRawY() - this.Bsq;
        int i;
        if (this.Bss) {
          if ((f2 >= 20.0F) && (Math.abs(f2) >= 10.0F) && (Math.abs(k) > Math.abs(j)) && (Math.abs(f2) > Math.abs(f1)) && (f2 >= 0.0F))
          {
            i = 1;
            label451:
            if (i == 0) {
              break label465;
            }
          }
        }
        label536:
        label540:
        for (;;)
        {
          break;
          i = 0;
          break label451;
          label465:
          if (this.Bst) {
            if ((f1 < 20.0F) || (Math.abs(f1) < 10.0F) || (Math.abs(j) <= Math.abs(k)) || (Math.abs(f1) <= Math.abs(f2)) || (f1 < 0.0F)) {
              break label536;
            }
          }
          for (i = 1;; i = 0)
          {
            if (i != 0) {
              break label540;
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
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(290712);
    p.k(paramMotionEvent, "ev");
    Log.i("Finder.WebViewFrameLayout", "onTouchEvent:" + paramMotionEvent + " action:" + paramMotionEvent.getAction() + " isAnimating:" + this.isAnimating);
    if (this.isAnimating)
    {
      AppMethodBeat.o(290712);
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    while (this.Bsu)
    {
      AppMethodBeat.o(290712);
      return true;
      this.BpS = paramMotionEvent.getRawX();
      this.rpT = paramMotionEvent.getRawY();
      continue;
      if ((this.BpS == 0.0F) && (this.rpT == 0.0F))
      {
        this.BpS = paramMotionEvent.getRawX();
        this.rpT = paramMotionEvent.getRawY();
      }
      else
      {
        float f1 = paramMotionEvent.getRawX() - this.BpS;
        float f2 = paramMotionEvent.getRawY() - this.rpT;
        this.BpS = paramMotionEvent.getRawX();
        this.rpT = paramMotionEvent.getRawY();
        if ((this.Bss) || (this.Bsu))
        {
          if (Math.abs(f2) < Math.abs(f1)) {
            Log.i("Finder.WebViewFrameLayout", "scrollVertical return");
          } else {
            bp(0.68F * f2);
          }
        }
        else if ((this.Bst) || (this.Bsu)) {
          if (Math.abs(f1) < Math.abs(f2))
          {
            Log.i("Finder.WebViewFrameLayout", "scrollHorizontal return");
          }
          else
          {
            bp(f1 * 0.85F);
            continue;
            emh();
            clear();
            continue;
            emh();
            clear();
          }
        }
      }
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(290712);
    return bool;
  }
  
  public final void setAllowHorizontalIntercept(boolean paramBoolean)
  {
    AppMethodBeat.i(290709);
    Log.i("Finder.WebViewFrameLayout", "isAllowHorizontalIntercept :".concat(String.valueOf(paramBoolean)));
    this.Bst = paramBoolean;
    AppMethodBeat.o(290709);
  }
  
  public final void setAllowVerticalIntercept(boolean paramBoolean)
  {
    AppMethodBeat.i(290708);
    Log.i("Finder.WebViewFrameLayout", "isAllowVerticalIntercept :".concat(String.valueOf(paramBoolean)));
    this.Bss = paramBoolean;
    AppMethodBeat.o(290708);
  }
  
  public final void setDialog(i parami)
  {
    this.Bso = parami;
  }
  
  public final void setForceHandleEvent(boolean paramBoolean)
  {
    this.Bsu = paramBoolean;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/webview/ad/WebViewFrameLayout$Companion;", "", "()V", "FULL_SCREEN_MOVE_OFFSET_Y_FACTOR", "", "RESET_POS_ANIM_DURATION", "", "SCROLL_RIGHT_CLOSE_MOVE_OFFSET_X_FACTOR", "START_INTERCEPT_LIMIT", "TAG", "", "touchX", "getTouchX", "()F", "setTouchX", "(F)V", "touchY", "getTouchY", "setTouchY", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/webview/ad/WebViewFrameLayout$resetPosition$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class b
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(267327);
      Log.i("Finder.WebViewFrameLayout", "onAnimationCancel " + this.Bsw.getTranslationY());
      WebViewFrameLayout.a(this.Bsw, false);
      WebViewFrameLayout.a(this.Bsw);
      AppMethodBeat.o(267327);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(267326);
      Log.i("Finder.WebViewFrameLayout", "onAnimationEnd : " + this.Bsw.getTranslationY());
      WebViewFrameLayout.a(this.Bsw, false);
      WebViewFrameLayout.a(this.Bsw);
      AppMethodBeat.o(267326);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(267325);
      Log.i("Finder.WebViewFrameLayout", "onAnimationStart " + this.Bsw.getTranslationY());
      WebViewFrameLayout.a(this.Bsw, true);
      WebViewFrameLayout.a(this.Bsw);
      AppMethodBeat.o(267325);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.webview.ad.WebViewFrameLayout
 * JD-Core Version:    0.7.0.1
 */