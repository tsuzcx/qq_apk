package com.tencent.mm.plugin.appbrand.widget.c;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.WeAppHalfScreenStatusChangeListener;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.page.at;
import com.tencent.mm.plugin.appbrand.page.capsulebar.AppBrandSingleCloseCapsuleBar;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.plugin.appbrand.widget.f;
import com.tencent.mm.plugin.appbrand.widget.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import kotlin.g.a.b;
import kotlin.l;
import kotlin.m;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/WxaHalfScreenGestureControllerImp;", "Lcom/tencent/mm/plugin/appbrand/widget/IWxaHalfScreenGestureController;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandWebViewOverScrollListener;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;)V", "alwaysInTapRegion", "", "container", "Lcom/tencent/mm/plugin/appbrand/widget/AppBrandRuntimeFrameLayout;", "kotlin.jvm.PlatformType", "containerHeightAtGestureStart", "", "context", "Landroid/content/Context;", "currentViewStatus", "Lcom/tencent/mm/plugin/appbrand/widget/ViewStatus;", "initialContainerHeight", "isAnimating", "()Z", "setAnimating", "(Z)V", "isGestureStartInnerContainerView", "lastMotionEvent", "Landroid/view/MotionEvent;", "lastStatusChangedAnimator", "Landroid/animation/ValueAnimator;", "getLastStatusChangedAnimator", "()Landroid/animation/ValueAnimator;", "setLastStatusChangedAnimator", "(Landroid/animation/ValueAnimator;)V", "mDragState", "Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/HalfScreenDragStatus;", "maxVelocity", "", "motionEventAtGestureStart", "moveDistanceVerticalPending", "overScrolledY", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "touchSlop", "velocityTracker", "Landroid/view/VelocityTracker;", "viewStatusAtGestureStart", "addOverScrollListener", "", "animateContainer", "type", "Lcom/tencent/mm/plugin/appbrand/widget/ContainerAnimateType;", "canPerformScrollContainer", "moveDistanceY", "checkIsInTapRegion", "ev", "checkVerticalFillParent", "dpToPx", "dp", "getCurrentStatus", "getMaxVerticalDistForContainer", "getMoveDistanceX", "getMoveDistanceXFromStart", "getMoveDistanceY", "getMoveDistanceYFromStart", "handleInterceptTouchEvent", "handleTouchEvent", "isInteractsContainerView", "onInterceptTapToFullScreen", "onLayout", "left", "top", "right", "bottom", "onOverScrolled", "scrollX", "scrollY", "clampedX", "clampedY", "onStatusChanged", "viewStatus", "removeOverScrollListener", "resetAfterGesture", "saveLastMotionEvent", "setDefaultViewHeight", "height", "setDragStatus", "status", "trackVelocity", "tryPerformAnimationWhenScrollRelease", "slideDistanceVertical", "AnimatorListenerAdapter", "Companion", "plugin-appbrand-integration_release"})
public final class g
  implements at, i
{
  public static final g.b rtr;
  private MotionEvent aHh;
  private int bvH;
  private VelocityTracker bvI;
  private final Context context;
  volatile boolean isAnimating;
  final com.tencent.mm.plugin.appbrand.t nAH;
  private MotionEvent rtd;
  private d rte;
  private int rtf;
  private final com.tencent.mm.plugin.appbrand.widget.d rtg;
  private int rth;
  private float rti;
  private boolean rtj;
  private boolean rtk;
  private com.tencent.mm.plugin.appbrand.widget.p rtm;
  private com.tencent.mm.plugin.appbrand.widget.p rtn;
  private int rto;
  private boolean rtp;
  private ValueAnimator rtq;
  
  static
  {
    AppMethodBeat.i(274646);
    rtr = new g.b((byte)0);
    AppMethodBeat.o(274646);
  }
  
  public g(com.tencent.mm.plugin.appbrand.t paramt)
  {
    AppMethodBeat.i(274645);
    this.nAH = paramt;
    this.rte = d.rsX;
    this.rtg = this.nAH.bBZ();
    paramt = this.rtg;
    kotlin.g.b.p.j(paramt, "this.container");
    paramt = paramt.getContext();
    kotlin.g.b.p.j(paramt, "this.container.context");
    this.context = paramt;
    this.rtm = com.tencent.mm.plugin.appbrand.widget.p.roa;
    this.rtn = this.rtm;
    paramt = ViewConfiguration.get(this.context);
    kotlin.g.b.p.j(paramt, "vc");
    this.bvH = paramt.getScaledTouchSlop();
    this.rti = paramt.getScaledMaximumFlingVelocity();
    Log.i("MicroMsg.WxaHalfScreenGestureControllerImp", "init: touchSlop[" + this.bvH + "]  maxVelocity[" + this.rti + ']');
    b(d.rsX);
    AppMethodBeat.o(274645);
  }
  
  private final boolean DH(int paramInt)
  {
    AppMethodBeat.i(274636);
    boolean bool = cnS();
    if (paramInt > 0) {}
    for (paramInt = 1; (!bool) || ((bool) && (paramInt != 0)); paramInt = 0)
    {
      AppMethodBeat.o(274636);
      return true;
    }
    AppMethodBeat.o(274636);
    return false;
  }
  
  private final float DI(int paramInt)
  {
    AppMethodBeat.i(274643);
    float f = paramInt;
    Resources localResources = this.context.getResources();
    kotlin.g.b.p.j(localResources, "context.resources");
    f = TypedValue.applyDimension(1, f, localResources.getDisplayMetrics());
    AppMethodBeat.o(274643);
    return f;
  }
  
  private final boolean O(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(274629);
    Rect localRect = new Rect();
    if (this.nAH.bBZ() == null)
    {
      AppMethodBeat.o(274629);
      return false;
    }
    this.nAH.bBZ().getHitRect(localRect);
    boolean bool = localRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    AppMethodBeat.o(274629);
    return bool;
  }
  
  private final void P(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(274631);
    if ((Math.abs(R(paramMotionEvent)) >= this.bvH) || (Math.abs(S(paramMotionEvent)) >= this.bvH)) {
      this.rtk = false;
    }
    AppMethodBeat.o(274631);
  }
  
  private final void Q(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(274632);
    MotionEvent localMotionEvent = this.aHh;
    if (localMotionEvent != null) {
      localMotionEvent.recycle();
    }
    this.aHh = MotionEvent.obtain(paramMotionEvent);
    AppMethodBeat.o(274632);
  }
  
  private final int R(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(274637);
    float f2 = paramMotionEvent.getRawY();
    paramMotionEvent = this.rtd;
    if (paramMotionEvent != null) {}
    for (float f1 = paramMotionEvent.getRawY();; f1 = 0.0F)
    {
      int i = (int)(f2 - f1);
      AppMethodBeat.o(274637);
      return i;
    }
  }
  
  private final int S(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(274638);
    float f2 = paramMotionEvent.getRawX();
    paramMotionEvent = this.rtd;
    if (paramMotionEvent != null) {}
    for (float f1 = paramMotionEvent.getRawX();; f1 = 0.0F)
    {
      int i = (int)(f2 - f1);
      AppMethodBeat.o(274638);
      return i;
    }
  }
  
  private final void b(d paramd)
  {
    AppMethodBeat.i(274642);
    if (this.rte == paramd)
    {
      AppMethodBeat.o(274642);
      return;
    }
    this.rte = paramd;
    paramd = this.nAH.bDM();
    if (paramd != null)
    {
      paramd.a(this.rte);
      AppMethodBeat.o(274642);
      return;
    }
    AppMethodBeat.o(274642);
  }
  
  private final void cnP()
  {
    AppMethodBeat.i(274627);
    b(d.rsX);
    Object localObject = this.aHh;
    if (localObject != null) {
      ((MotionEvent)localObject).recycle();
    }
    this.aHh = null;
    localObject = this.bvI;
    if (localObject != null) {
      ((VelocityTracker)localObject).recycle();
    }
    this.bvI = null;
    localObject = this.rtd;
    if (localObject != null) {
      ((MotionEvent)localObject).recycle();
    }
    this.rtd = null;
    this.rtj = false;
    this.rtk = false;
    this.rto = 0;
    this.rtf = 0;
    this.rtp = false;
    cnR();
    AppMethodBeat.o(274627);
  }
  
  private final void cnQ()
  {
    AppMethodBeat.i(274633);
    Object localObject = this.nAH.bDz();
    kotlin.g.b.p.j(localObject, "runtime.pageContainer");
    localObject = ((y)localObject).getPageView();
    if ((localObject instanceof ah)) {
      ((ah)localObject).a((at)this);
    }
    AppMethodBeat.o(274633);
  }
  
  private final void cnR()
  {
    AppMethodBeat.i(274634);
    Object localObject = this.nAH.bDz();
    kotlin.g.b.p.j(localObject, "runtime.pageContainer");
    localObject = ((y)localObject).getPageView();
    if ((localObject instanceof ah)) {
      ((ah)localObject).b((at)this);
    }
    AppMethodBeat.o(274634);
  }
  
  private final boolean cnS()
  {
    AppMethodBeat.i(274639);
    Object localObject = this.rtg;
    kotlin.g.b.p.j(localObject, "container");
    if (((com.tencent.mm.plugin.appbrand.widget.d)localObject).getHeight() == cnT()) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = new StringBuilder("fillParent=").append(bool).append("  currentH=");
      com.tencent.mm.plugin.appbrand.widget.d locald = this.rtg;
      kotlin.g.b.p.j(locald, "this.container");
      Log.d("MicroMsg.WxaHalfScreenGestureControllerImp", locald.getHeight());
      AppMethodBeat.o(274639);
      return bool;
    }
  }
  
  private final int cnT()
  {
    AppMethodBeat.i(274640);
    Object localObject = this.rtg;
    kotlin.g.b.p.j(localObject, "container");
    localObject = ((com.tencent.mm.plugin.appbrand.widget.d)localObject).getLayoutParams();
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(274640);
      throw ((Throwable)localObject);
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    int j = ((ViewGroup.MarginLayoutParams)localObject).bottomMargin;
    int k = ((ViewGroup.MarginLayoutParams)localObject).topMargin;
    localObject = this.rtg;
    kotlin.g.b.p.j(localObject, "container");
    ViewParent localViewParent = ((com.tencent.mm.plugin.appbrand.widget.d)localObject).getParent();
    localObject = localViewParent;
    if (!(localViewParent instanceof View)) {
      localObject = null;
    }
    localObject = (View)localObject;
    int i;
    int m;
    if (localObject != null)
    {
      i = ((View)localObject).getHeight();
      m = ((View)localObject).getPaddingTop();
      i -= ((View)localObject).getPaddingBottom() + m;
    }
    for (;;)
    {
      m = ar.getStatusBarHeight(this.context);
      Log.d("MicroMsg.WxaHalfScreenGestureControllerImp", "getCurrentMaxVerticalDistance statusBarHeight=".concat(String.valueOf(m)));
      i = i - (j + k) - m;
      Log.d("MicroMsg.WxaHalfScreenGestureControllerImp", "getCurrentMaxVerticalDistance=".concat(String.valueOf(i)));
      AppMethodBeat.o(274640);
      return i;
      i = 0;
    }
  }
  
  public final void C(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(274625);
    Log.d("MicroMsg.WxaHalfScreenGestureControllerImp", "onLayout: top[" + paramInt2 + "] bottom[" + paramInt4 + "] height[" + (paramInt4 - paramInt2) + ']');
    paramInt1 = paramInt4 - paramInt2;
    Object localObject1;
    if (paramInt1 == 0) {
      localObject1 = com.tencent.mm.plugin.appbrand.widget.p.rod;
    }
    while (localObject1 != this.rtm)
    {
      Log.i("MicroMsg.WxaHalfScreenGestureControllerImp", "onStatusChanged  new[" + localObject1 + "]  old[" + this.rtm + "]  dragState[" + this.rte + ']');
      Object localObject2 = this.rtm;
      this.rtm = ((com.tencent.mm.plugin.appbrand.widget.p)localObject1);
      if (localObject2 != com.tencent.mm.plugin.appbrand.widget.p.roa)
      {
        localObject1 = (b)new g.f(this);
        localObject2 = this.rtq;
        if (localObject2 != null) {
          ((ValueAnimator)localObject2).cancel();
        }
        this.rtq = null;
        localObject2 = this.rtm;
        Bundle localBundle;
        switch (h.jLJ[localObject2.ordinal()])
        {
        default: 
          this.rtq = ((ValueAnimator)((b)localObject1).invoke(Boolean.FALSE));
          localObject1 = this.nAH.bDM();
          if (localObject1 != null)
          {
            kotlin.g.b.p.k(this.rte, "dragState");
            localObject2 = ((e)localObject1).nAH.bDy().nBE.nZG;
            if (localObject2 != null)
            {
              localObject2 = ((WeAppHalfScreenStatusChangeListener)localObject2).cAX;
              if (localObject2 != null)
              {
                localBundle = new Bundle();
                localBundle.putInt("Status", 0);
                ((ResultReceiver)localObject2).send(0, localBundle);
              }
            }
            ((e)localObject1).cnO();
            AppMethodBeat.o(274625);
            return;
            if (paramInt1 == cnT()) {
              localObject1 = com.tencent.mm.plugin.appbrand.widget.p.roc;
            } else {
              localObject1 = com.tencent.mm.plugin.appbrand.widget.p.rob;
            }
          }
          break;
        case 1: 
          this.rtq = ((ValueAnimator)((b)localObject1).invoke(Boolean.TRUE));
          localObject1 = this.nAH.bDM();
          if (localObject1 != null)
          {
            localObject2 = this.rte;
            kotlin.g.b.p.k(localObject2, "dragState");
            if (localObject2 == d.rsX) {
              ((e)localObject1).cnM();
            }
            localObject2 = ((e)localObject1).nAH.bDy().nBE.nZG;
            if (localObject2 != null)
            {
              localObject2 = ((WeAppHalfScreenStatusChangeListener)localObject2).cAX;
              if (localObject2 != null)
              {
                localBundle = new Bundle();
                localBundle.putInt("Status", 1);
                ((ResultReceiver)localObject2).send(0, localBundle);
              }
            }
            ((e)localObject1).cnO();
            AppMethodBeat.o(274625);
            return;
          }
          AppMethodBeat.o(274625);
          return;
        }
      }
    }
    AppMethodBeat.o(274625);
  }
  
  public final void Dw(int paramInt)
  {
    AppMethodBeat.i(274641);
    this.rth = paramInt;
    Log.i("MicroMsg.WxaHalfScreenGestureControllerImp", "setDefaultViewHeight=".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(274641);
  }
  
  public final boolean I(MotionEvent paramMotionEvent)
  {
    float f1 = 0.0F;
    AppMethodBeat.i(274626);
    kotlin.g.b.p.k(paramMotionEvent, "ev");
    Log.d("MicroMsg.WxaHalfScreenGestureControllerImp", "handleTouchEvent: action[" + paramMotionEvent.getAction() + ']');
    if (this.bvI == null) {
      this.bvI = VelocityTracker.obtain();
    }
    Object localObject1 = this.bvI;
    if (localObject1 == null) {
      kotlin.g.b.p.iCn();
    }
    ((VelocityTracker)localObject1).addMovement(paramMotionEvent);
    float f2;
    int i;
    int j;
    switch (paramMotionEvent.getAction())
    {
    default: 
      if (this.rte == d.rsY)
      {
        AppMethodBeat.o(274626);
        return true;
      }
      break;
    case 0: 
      if (!this.rtp)
      {
        AppMethodBeat.o(274626);
        return false;
      }
      this.rtn = this.rtm;
      this.rtd = MotionEvent.obtain(paramMotionEvent);
      localObject1 = this.rtg;
      kotlin.g.b.p.j(localObject1, "container");
      this.rto = ((com.tencent.mm.plugin.appbrand.widget.d)localObject1).getHeight();
      this.rtk = true;
      cnQ();
      Q(paramMotionEvent);
      AppMethodBeat.o(274626);
      return true;
    case 2: 
      if (!this.rtp)
      {
        AppMethodBeat.o(274626);
        return false;
      }
      try
      {
        if (this.isAnimating)
        {
          Log.d("MicroMsg.WxaHalfScreenGestureControllerImp", "[handleTouchEvent] can not perform scroll container during animating");
          return false;
        }
        f2 = paramMotionEvent.getRawY();
        localObject1 = this.aHh;
        if (localObject1 != null) {
          f1 = ((MotionEvent)localObject1).getRawY();
        }
        i = (int)(f2 - f1);
        if (!DH(i))
        {
          Log.d("MicroMsg.WxaHalfScreenGestureControllerImp", "[handleTouchEvent] can not perform scroll container");
          return false;
        }
        P(paramMotionEvent);
        j = cnT();
        localObject1 = this.rtg;
        kotlin.g.b.p.j(localObject1, "container");
        localObject1 = ((com.tencent.mm.plugin.appbrand.widget.d)localObject1).getLayoutParams();
        this.rtf += i;
        int k = this.rto + -this.rtf;
        if (k > j) {}
        for (((ViewGroup.LayoutParams)localObject1).height = j;; ((ViewGroup.LayoutParams)localObject1).height = k)
        {
          this.rtg.requestLayout();
          Log.d("MicroMsg.WxaHalfScreenGestureControllerImp", "[handleTouchEvent] current height=" + ((ViewGroup.LayoutParams)localObject1).height + "  moveDistanceY=" + i);
          return true;
        }
        try
        {
          j = this.rtf;
          if (this.isAnimating) {
            Log.d("MicroMsg.WxaHalfScreenGestureControllerImp", "[tryPerformAnimationWhenScrollRelease] can not perform animation during animating");
          }
          for (;;)
          {
            if (!this.rtp)
            {
              bool = O(paramMotionEvent);
              if (bool)
              {
                return true;
                localObject3 = this.bvI;
                if (localObject3 != null) {
                  ((VelocityTracker)localObject3).computeCurrentVelocity(1000, this.rti);
                }
                localObject3 = this.bvI;
                if (localObject3 != null)
                {
                  f1 = ((VelocityTracker)localObject3).getYVelocity();
                  if (Math.abs(f1) >= DI(500))
                  {
                    bool = true;
                    f2 = DI(100);
                    Log.i("MicroMsg.WxaHalfScreenGestureControllerImp", "[tryPerformAnimationWhenScrollRelease] yVelocity=" + f1 + "  fastSliding= " + bool + " thresholdPx=" + f2 + " slideDistanceVertical=" + j + '}');
                    if ((!bool) || (f1 == 0.0F)) {
                      break label731;
                    }
                    if (f1 <= 0.0F) {
                      break label719;
                    }
                    i = 2;
                    if (i != 2) {
                      break label799;
                    }
                    if ((Math.abs(j) <= f2) && (!bool)) {
                      break label753;
                    }
                    Log.i("MicroMsg.WxaHalfScreenGestureControllerImp", "[handleTouchEvent] animate dismiss}");
                    a(f.rnM);
                  }
                }
                else
                {
                  f1 = 0.0F;
                }
              }
            }
          }
        }
        finally
        {
          cnP();
          AppMethodBeat.o(274626);
        }
      }
      finally
      {
        Q(paramMotionEvent);
        AppMethodBeat.o(274626);
      }
    }
    for (;;)
    {
      Object localObject3;
      continue;
      boolean bool = false;
      continue;
      label719:
      if (f1 < 0.0F)
      {
        i = 1;
        continue;
        label731:
        if (j > 0)
        {
          i = 2;
          continue;
        }
        if (j < 0)
        {
          i = 1;
          continue;
          label753:
          if (this.rtn == com.tencent.mm.plugin.appbrand.widget.p.rob)
          {
            Log.i("MicroMsg.WxaHalfScreenGestureControllerImp", "[handleTouchEvent] animate reset to initial height}");
            a(f.rnK);
            continue;
          }
          Log.i("MicroMsg.WxaHalfScreenGestureControllerImp", "[handleTouchEvent] animate expand}");
          a(f.rnL);
          continue;
          if (i != 1) {
            continue;
          }
          if ((Math.abs(j) > f2) || (bool))
          {
            Log.i("MicroMsg.WxaHalfScreenGestureControllerImp", "[handleTouchEvent] animate expand}");
            a(f.rnL);
            continue;
          }
          if (this.rtn == com.tencent.mm.plugin.appbrand.widget.p.rob)
          {
            Log.i("MicroMsg.WxaHalfScreenGestureControllerImp", "[handleTouchEvent] animate reset to initial height}");
            a(f.rnK);
            continue;
          }
          Log.i("MicroMsg.WxaHalfScreenGestureControllerImp", "[handleTouchEvent] animate expand}");
          a(f.rnL);
          continue;
          paramMotionEvent = this.rte;
          localObject3 = d.rsY;
          if (paramMotionEvent == localObject3)
          {
            cnP();
            AppMethodBeat.o(274626);
            return true;
          }
          cnP();
          break;
          AppMethodBeat.o(274626);
          return false;
        }
      }
      label799:
      i = 0;
    }
  }
  
  public final boolean J(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(274628);
    kotlin.g.b.p.k(paramMotionEvent, "ev");
    Log.d("MicroMsg.WxaHalfScreenGestureControllerImp", "handleOnInterceptTouchEvent: action[" + paramMotionEvent.getAction() + "]  X[" + paramMotionEvent.getRawX() + "] Y[" + paramMotionEvent.getRawY() + ']');
    switch (paramMotionEvent.getAction())
    {
    }
    label644:
    label668:
    for (;;)
    {
      Log.d("MicroMsg.WxaHalfScreenGestureControllerImp", "handleOnInterceptTouchEvent: action[" + paramMotionEvent.getAction() + "] return false");
      AppMethodBeat.o(274628);
      return false;
      this.rtp = O(paramMotionEvent);
      if (!this.rtp)
      {
        AppMethodBeat.o(274628);
        return false;
      }
      Q(paramMotionEvent);
      this.rtd = MotionEvent.obtain(paramMotionEvent);
      this.rtn = this.rtm;
      com.tencent.mm.plugin.appbrand.widget.d locald = this.rtg;
      kotlin.g.b.p.j(locald, "container");
      this.rto = locald.getHeight();
      this.rtk = true;
      cnQ();
      continue;
      if (!this.rtp)
      {
        AppMethodBeat.o(274628);
        return false;
      }
      int i;
      int j;
      boolean bool;
      try
      {
        i = S(paramMotionEvent);
        j = R(paramMotionEvent);
        Log.d("MicroMsg.WxaHalfScreenGestureControllerImp", "handleOnInterceptTouchEvent: moveDistanceY[" + j + "]  touchSlop[" + this.bvH + ']');
        if ((Math.abs(j) >= this.bvH) && (Math.abs(j) > Math.abs(i))) {
          if (cnS())
          {
            if (DH(j))
            {
              bool = this.rtj;
              Log.i("MicroMsg.WxaHalfScreenGestureControllerImp", "canOverScroll[" + bool + ']');
              if (!bool) {}
            }
          }
          else
          {
            b(d.rsY);
            return true;
          }
        }
        P(paramMotionEvent);
        Q(paramMotionEvent);
        continue;
      }
      finally
      {
        Q(paramMotionEvent);
        AppMethodBeat.o(274628);
      }
      try
      {
        if ((this.rtk) && (paramMotionEvent.getAction() == 1))
        {
          kotlin.g.b.p.k(paramMotionEvent, "ev");
          Object localObject2 = this.nAH.bDM();
          if (localObject2 == null) {
            break label638;
          }
          kotlin.g.b.p.k(paramMotionEvent, "ev");
          localObject2 = ((e)localObject2).cnN();
          if (localObject2 == null) {
            break label632;
          }
          float f1 = paramMotionEvent.getRawX();
          float f2 = paramMotionEvent.getRawY();
          int[] arrayOfInt = new int[2];
          ((AppBrandSingleCloseCapsuleBar)localObject2).qxs.getLocationOnScreen(arrayOfInt);
          i = arrayOfInt[0];
          j = arrayOfInt[1];
          int k = ((AppBrandSingleCloseCapsuleBar)localObject2).qxs.getWidth();
          int m = ((AppBrandSingleCloseCapsuleBar)localObject2).qxs.getHeight();
          if ((f1 < i) || (f1 > i + k) || (f2 < j) || (f2 > m + j)) {
            break label626;
          }
          i = 1;
          if (i != 0) {
            break label644;
          }
          a(f.rnL);
          Log.i("MicroMsg.WxaHalfScreenGestureControllerImp", "tap to full screen");
        }
        for (;;)
        {
          if (this.rtp) {
            break label668;
          }
          bool = O(paramMotionEvent);
          if (!bool) {
            break label668;
          }
          return true;
          label626:
          i = 0;
          break;
          label632:
          i = 0;
          break;
          label638:
          i = 0;
          break;
          Log.i("MicroMsg.WxaHalfScreenGestureControllerImp", "tap to full screen be intercepted");
        }
        cnP();
      }
      finally
      {
        cnP();
        AppMethodBeat.o(274628);
      }
    }
  }
  
  public final void a(final f paramf)
  {
    AppMethodBeat.i(274635);
    kotlin.g.b.p.k(paramf, "type");
    Log.i("MicroMsg.WxaHalfScreenGestureControllerImp", "[animateContainer] type[" + paramf + "]}");
    Object localObject;
    switch (h.$EnumSwitchMapping$0[paramf.ordinal()])
    {
    default: 
      paramf = new m();
      AppMethodBeat.o(274635);
      throw paramf;
    case 1: 
      localObject = this.rtg;
      kotlin.g.b.p.j(localObject, "container");
      if (((com.tencent.mm.plugin.appbrand.widget.d)localObject).getHeight() == this.rth) {
        localObject = null;
      }
      break;
    }
    while (localObject == null)
    {
      Log.d("MicroMsg.WxaHalfScreenGestureControllerImp", "[animateContainer] no animator need to be played");
      AppMethodBeat.o(274635);
      return;
      localObject = this.rtg;
      kotlin.g.b.p.j(localObject, "container");
      localObject = ValueAnimator.ofInt(new int[] { ((com.tencent.mm.plugin.appbrand.widget.d)localObject).getHeight(), this.rth });
      continue;
      localObject = this.rtg;
      kotlin.g.b.p.j(localObject, "container");
      localObject = ValueAnimator.ofInt(new int[] { ((com.tencent.mm.plugin.appbrand.widget.d)localObject).getHeight(), cnT() });
      continue;
      localObject = this.rtg;
      kotlin.g.b.p.j(localObject, "container");
      localObject = ValueAnimator.ofInt(new int[] { ((com.tencent.mm.plugin.appbrand.widget.d)localObject).getHeight(), 0 });
      ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new c(this));
    }
    ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new g.d(this));
    ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new e(this, paramf));
    ((ValueAnimator)localObject).setInterpolator((TimeInterpolator)new DecelerateInterpolator());
    ((ValueAnimator)localObject).setDuration(300L);
    ((ValueAnimator)localObject).start();
    AppMethodBeat.o(274635);
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.p cmX()
  {
    return this.rtm;
  }
  
  public final void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(274644);
    Log.i("MicroMsg.WxaHalfScreenGestureControllerImp", "onOverScrolled   scrollX=" + paramInt1 + "   scrollY=" + paramInt2 + "    clampedX=" + paramBoolean1 + "   clampedY=" + paramBoolean2);
    if (!this.rtj) {
      this.rtj = paramBoolean2;
    }
    AppMethodBeat.o(274644);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/WxaHalfScreenGestureControllerImp$AnimatorListenerAdapter;", "Landroid/animation/Animator$AnimatorListener;", "()V", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-appbrand-integration_release"})
  public static class a
    implements Animator.AnimatorListener
  {
    public void onAnimationCancel(Animator paramAnimator) {}
    
    public void onAnimationEnd(Animator paramAnimator) {}
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/widget/halfscreen/WxaHalfScreenGestureControllerImp$animateContainer$animator$1$1", "Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/WxaHalfScreenGestureControllerImp$AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-appbrand-integration_release"})
  public static final class c
    extends g.a
  {
    c(g paramg) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(266956);
      this.rts.nAH.close();
      AppMethodBeat.o(266956);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/widget/halfscreen/WxaHalfScreenGestureControllerImp$animateContainer$3", "Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/WxaHalfScreenGestureControllerImp$AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationStart", "plugin-appbrand-integration_release"})
  public static final class e
    extends g.a
  {
    e(f paramf) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(283603);
      super.onAnimationCancel(paramAnimator);
      Log.d("MicroMsg.WxaHalfScreenGestureControllerImp", "[animateContainer] type[" + paramf + "]} onAnimationCancel");
      this.rts.isAnimating = false;
      AppMethodBeat.o(283603);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(283602);
      super.onAnimationCancel(paramAnimator);
      Log.d("MicroMsg.WxaHalfScreenGestureControllerImp", "[animateContainer] type[" + paramf + "]} onAnimationEnd");
      this.rts.isAnimating = false;
      AppMethodBeat.o(283602);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(283604);
      super.onAnimationStart(paramAnimator);
      Log.d("MicroMsg.WxaHalfScreenGestureControllerImp", "[animateContainer] type[" + paramf + "]} onAnimationStart");
      this.rts.isAnimating = true;
      AppMethodBeat.o(283604);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.c.g
 * JD-Core Version:    0.7.0.1
 */