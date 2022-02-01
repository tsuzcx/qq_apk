package com.tencent.mm.plugin.appbrand.widget.d;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.page.at;
import com.tencent.mm.plugin.appbrand.page.capsulebar.BaseAppBrandSingleCloseCapsuleBar;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.plugin.appbrand.ui.wxa_container.a;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.appbrand.widget.e;
import com.tencent.mm.plugin.appbrand.widget.g;
import com.tencent.mm.plugin.appbrand.widget.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.aw;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.u;
import kotlin.p;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/WxaHalfScreenGestureControllerImp;", "Lcom/tencent/mm/plugin/appbrand/widget/IWxaHalfScreenGestureController;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandWebViewOverScrollListener;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;)V", "alwaysInTapRegion", "", "configForbidSlidingUpGesture", "configGesture", "container", "Lcom/tencent/mm/plugin/appbrand/widget/AppBrandRuntimeFrameLayout;", "kotlin.jvm.PlatformType", "containerHeightAtGestureStart", "", "context", "Landroid/content/Context;", "currentViewStatus", "Lcom/tencent/mm/plugin/appbrand/widget/ViewStatus;", "initialContainerHeight", "isAnimating", "()Z", "setAnimating", "(Z)V", "isGestureStartInnerContainerView", "lastMotionEvent", "Landroid/view/MotionEvent;", "lastStatusChangedAnimator", "Landroid/animation/ValueAnimator;", "getLastStatusChangedAnimator", "()Landroid/animation/ValueAnimator;", "setLastStatusChangedAnimator", "(Landroid/animation/ValueAnimator;)V", "mDragState", "Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/HalfScreenDragStatus;", "maxVelocity", "", "motionEventAtGestureStart", "moveDistanceVerticalPending", "overScrolledY", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "touchSlop", "velocityTracker", "Landroid/view/VelocityTracker;", "viewStatusAtGestureStart", "wxaHalfScreenEmptyAreaClickHandler", "Lcom/tencent/mm/plugin/appbrand/widget/IWxaHalfScreenEmptyAreaClickHandler;", "addOverScrollListener", "", "animateContainer", "type", "Lcom/tencent/mm/plugin/appbrand/widget/ContainerAnimateType;", "calculateContainerMaxHeight", "canGesture", "canPerformScrollContainer", "moveDistanceY", "changeContainerHeight", "newHeight", "checkIsInTapRegion", "ev", "checkVerticalFillParent", "dpToPx", "dp", "getCurrentStatus", "getMoveDistanceX", "getMoveDistanceXFromStart", "getMoveDistanceY", "getMoveDistanceYFromStart", "getParentMaxVerticalDistForContainer", "handleInterceptTouchEvent", "handleTouchEvent", "isCurrentSystemUiFullScreen", "isEmptyAreaClicked", "isInteractsContainerView", "notifyEmptyAreaClicked", "onInterceptTapToFullScreen", "onLayout", "left", "top", "right", "bottom", "onOverScrolled", "scrollX", "scrollY", "clampedX", "clampedY", "onStatusChanged", "viewStatus", "reachMaxVerticalHeight", "removeOverScrollListener", "resetAfterGesture", "saveLastMotionEvent", "setDefaultViewHeight", "height", "setDragStatus", "status", "setGestureConfig", "forbidSlidingUpGesture", "setWxaHalfScreenEmptyAreaClickHandler", "handler", "trackVelocity", "tryPerformAnimationWhenScrollRelease", "slideDistanceVertical", "AnimatorListenerAdapter", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements at, l
{
  public static final f.b uDN;
  private final Context context;
  private int doK;
  private VelocityTracker doL;
  volatile boolean isAnimating;
  private MotionEvent lastMotionEvent;
  final w qxC;
  private MotionEvent uDO;
  private c uDP;
  private int uDQ;
  private final e uDR;
  private boolean uDS;
  private boolean uDT;
  private int uDU;
  private float uDV;
  private boolean uDW;
  private boolean uDX;
  private com.tencent.mm.plugin.appbrand.widget.s uDY;
  private com.tencent.mm.plugin.appbrand.widget.s uDZ;
  private int uEa;
  private boolean uEb;
  private com.tencent.mm.plugin.appbrand.widget.k uEc;
  private ValueAnimator uEd;
  
  static
  {
    AppMethodBeat.i(324438);
    uDN = new f.b((byte)0);
    AppMethodBeat.o(324438);
  }
  
  public f(w paramw)
  {
    AppMethodBeat.i(324313);
    this.qxC = paramw;
    this.uDP = c.uDA;
    this.uDR = this.qxC.qsk;
    paramw = this.uDR.getContext();
    kotlin.g.b.s.s(paramw, "this.container.context");
    this.context = paramw;
    this.uDY = com.tencent.mm.plugin.appbrand.widget.s.uxV;
    this.uDZ = this.uDY;
    paramw = ViewConfiguration.get(this.context);
    this.doK = paramw.getScaledTouchSlop();
    this.uDV = paramw.getScaledMaximumFlingVelocity();
    Log.i("MicroMsg.WxaHalfScreenGestureControllerImp", "init: touchSlop[" + this.doK + "]  maxVelocity[" + this.uDV + ']');
    d(c.uDA);
    AppMethodBeat.o(324313);
  }
  
  private final void Eg(int paramInt)
  {
    AppMethodBeat.i(324321);
    int i = cQg();
    if (kotlin.k.k.bQ(paramInt, 0, i) != this.uDR.getLayoutParams().height)
    {
      this.uDR.getLayoutParams().height = kotlin.k.k.bQ(paramInt, 0, i);
      this.uDR.requestLayout();
    }
    AppMethodBeat.o(324321);
  }
  
  private final boolean Eh(int paramInt)
  {
    AppMethodBeat.i(324394);
    boolean bool = cQj();
    if (paramInt > 0) {}
    for (paramInt = 1; (!bool) || ((bool) && (paramInt != 0)); paramInt = 0)
    {
      AppMethodBeat.o(324394);
      return true;
    }
    AppMethodBeat.o(324394);
    return false;
  }
  
  private final float Ei(int paramInt)
  {
    AppMethodBeat.i(324432);
    float f = TypedValue.applyDimension(1, paramInt, this.context.getResources().getDisplayMetrics());
    AppMethodBeat.o(324432);
    return f;
  }
  
  private final boolean Q(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(324360);
    Object localObject = new Rect();
    if (this.qxC.qsk == null)
    {
      AppMethodBeat.o(324360);
      return false;
    }
    this.qxC.qsk.getHitRect((Rect)localObject);
    if (((Rect)localObject).contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
    {
      AppMethodBeat.o(324360);
      return true;
    }
    localObject = this.qxC.qsk.getRootView().findViewById(ba.f.app_brand_activity_container_view);
    kotlin.g.b.s.checkNotNull(localObject);
    if (((localObject instanceof a)) && (((a)localObject).E(paramMotionEvent)))
    {
      AppMethodBeat.o(324360);
      return true;
    }
    AppMethodBeat.o(324360);
    return false;
  }
  
  private final void R(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(324366);
    if ((Math.abs(T(paramMotionEvent)) >= this.doK) || (Math.abs(U(paramMotionEvent)) >= this.doK)) {
      this.uDX = false;
    }
    AppMethodBeat.o(324366);
  }
  
  private final void S(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(324372);
    MotionEvent localMotionEvent = this.lastMotionEvent;
    if (localMotionEvent != null) {
      localMotionEvent.recycle();
    }
    this.lastMotionEvent = MotionEvent.obtain(paramMotionEvent);
    AppMethodBeat.o(324372);
  }
  
  private final int T(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(324400);
    float f2 = paramMotionEvent.getRawY();
    paramMotionEvent = this.uDO;
    if (paramMotionEvent == null) {}
    for (float f1 = 0.0F;; f1 = paramMotionEvent.getRawY())
    {
      int i = (int)(f2 - f1);
      AppMethodBeat.o(324400);
      return i;
    }
  }
  
  private final int U(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(324405);
    float f2 = paramMotionEvent.getRawX();
    paramMotionEvent = this.uDO;
    if (paramMotionEvent == null) {}
    for (float f1 = 0.0F;; f1 = paramMotionEvent.getRawX())
    {
      int i = (int)(f2 - f1);
      AppMethodBeat.o(324405);
      return i;
    }
  }
  
  private static final void a(f paramf, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(324435);
    kotlin.g.b.s.u(paramf, "this$0");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramf = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(324435);
      throw paramf;
    }
    paramf.Eg(((Integer)paramValueAnimator).intValue());
    AppMethodBeat.o(324435);
  }
  
  private final int cQg()
  {
    AppMethodBeat.i(324328);
    int i = cQn();
    if (this.uDS) {
      i = this.uDU;
    }
    AppMethodBeat.o(324328);
    return i;
  }
  
  private final void cQh()
  {
    AppMethodBeat.i(324337);
    d(c.uDA);
    Object localObject = this.lastMotionEvent;
    if (localObject != null) {
      ((MotionEvent)localObject).recycle();
    }
    this.lastMotionEvent = null;
    localObject = this.doL;
    if (localObject != null) {
      ((VelocityTracker)localObject).recycle();
    }
    this.doL = null;
    localObject = this.uDO;
    if (localObject != null) {
      ((MotionEvent)localObject).recycle();
    }
    this.uDO = null;
    this.uDW = false;
    this.uDX = false;
    this.uEa = 0;
    this.uDQ = 0;
    this.uEb = false;
    cQl();
    AppMethodBeat.o(324337);
  }
  
  private final boolean cQi()
  {
    AppMethodBeat.i(324345);
    y localy = this.qxC.ccN();
    if ((this.uDT) && (localy.getPageCount() == 1))
    {
      AppMethodBeat.o(324345);
      return true;
    }
    AppMethodBeat.o(324345);
    return false;
  }
  
  private final boolean cQj()
  {
    AppMethodBeat.i(324353);
    if (this.uDS)
    {
      if (this.uDR.getHeight() == this.uDU)
      {
        AppMethodBeat.o(324353);
        return true;
      }
      AppMethodBeat.o(324353);
      return false;
    }
    boolean bool = cQm();
    AppMethodBeat.o(324353);
    return bool;
  }
  
  private final void cQk()
  {
    AppMethodBeat.i(324380);
    ad localad = this.qxC.ccN().getPageView();
    if ((localad instanceof ah)) {
      ((ah)localad).a((at)this);
    }
    AppMethodBeat.o(324380);
  }
  
  private final void cQl()
  {
    AppMethodBeat.i(324388);
    ad localad = this.qxC.ccN().getPageView();
    if ((localad instanceof ah)) {
      ((ah)localad).b((at)this);
    }
    AppMethodBeat.o(324388);
  }
  
  private final boolean cQm()
  {
    AppMethodBeat.i(324412);
    if (this.uDR.getHeight() == cQn()) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.WxaHalfScreenGestureControllerImp", "fillParent=" + bool + "  currentH=" + this.uDR.getHeight());
      AppMethodBeat.o(324412);
      return bool;
    }
  }
  
  private final int cQn()
  {
    AppMethodBeat.i(324417);
    Object localObject = this.uDR.getLayoutParams();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(324417);
      throw ((Throwable)localObject);
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    int k = ((ViewGroup.MarginLayoutParams)localObject).bottomMargin;
    int m = ((ViewGroup.MarginLayoutParams)localObject).topMargin;
    localObject = this.uDR.getParent();
    int i;
    if ((localObject instanceof View))
    {
      localObject = (View)localObject;
      if (localObject != null) {
        break label162;
      }
      i = 0;
      label92:
      if (!cQo()) {
        break label187;
      }
    }
    label162:
    label187:
    for (int j = 0;; j = aw.getStatusBarHeight(this.context))
    {
      Log.d("MicroMsg.WxaHalfScreenGestureControllerImp", kotlin.g.b.s.X("getCurrentMaxVerticalDistance statusBarHeight=", Integer.valueOf(j)));
      i = i - (k + m) - j;
      Log.d("MicroMsg.WxaHalfScreenGestureControllerImp", kotlin.g.b.s.X("getCurrentMaxVerticalDistance=", Integer.valueOf(i)));
      i = Math.max(0, i);
      AppMethodBeat.o(324417);
      return i;
      localObject = null;
      break;
      i = ((View)localObject).getHeight();
      j = ((View)localObject).getPaddingTop();
      i -= ((View)localObject).getPaddingBottom() + j;
      break label92;
    }
  }
  
  private final boolean cQo()
  {
    AppMethodBeat.i(324421);
    Object localObject = AndroidContextUtil.castActivityOrNull(this.qxC.mContext);
    int i;
    if (localObject == null) {
      i = 0;
    }
    while ((i & 0x4) != 0)
    {
      AppMethodBeat.o(324421);
      return true;
      localObject = ((Activity)localObject).getWindow();
      if (localObject == null)
      {
        i = 0;
      }
      else
      {
        localObject = ((Window)localObject).getDecorView();
        if (localObject == null) {
          i = 0;
        } else {
          i = ((View)localObject).getSystemUiVisibility();
        }
      }
    }
    AppMethodBeat.o(324421);
    return false;
  }
  
  private final void d(c paramc)
  {
    AppMethodBeat.i(324428);
    if (this.uDP == paramc)
    {
      AppMethodBeat.o(324428);
      return;
    }
    this.uDP = paramc;
    paramc = this.qxC.qvN;
    if (paramc != null) {
      paramc.a(this.uDP);
    }
    AppMethodBeat.o(324428);
  }
  
  public final void DV(int paramInt)
  {
    AppMethodBeat.i(324486);
    this.uDU = paramInt;
    Log.i("MicroMsg.WxaHalfScreenGestureControllerImp", kotlin.g.b.s.X("setDefaultViewHeight=", Integer.valueOf(paramInt)));
    AppMethodBeat.o(324486);
  }
  
  public final void G(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.uDS = paramBoolean2;
    this.uDT = paramBoolean1;
  }
  
  public final void I(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(324448);
    Log.d("MicroMsg.WxaHalfScreenGestureControllerImp", "onLayout: top[" + paramInt2 + "] bottom[" + paramInt4 + "] height[" + (paramInt4 - paramInt2) + ']');
    paramInt1 = paramInt4 - paramInt2;
    Object localObject1;
    if (paramInt1 == 0) {
      localObject1 = com.tencent.mm.plugin.appbrand.widget.s.uxY;
    }
    while ((localObject1 != this.uDY) && (this.uDT))
    {
      Log.i("MicroMsg.WxaHalfScreenGestureControllerImp", "onStatusChanged  new[" + localObject1 + "]  old[" + this.uDY + "]  dragState[" + this.uDP + ']');
      Object localObject2 = this.uDY;
      this.uDY = ((com.tencent.mm.plugin.appbrand.widget.s)localObject1);
      if (localObject2 != com.tencent.mm.plugin.appbrand.widget.s.uxV)
      {
        localObject1 = (b)new f(this);
        localObject2 = this.uEd;
        if (localObject2 != null) {
          ((ValueAnimator)localObject2).cancel();
        }
        this.uEd = null;
        localObject2 = this.uDY;
        if (c.avl[localObject2.ordinal()] == 1)
        {
          this.uEd = ((ValueAnimator)((b)localObject1).invoke(Boolean.TRUE));
          localObject1 = this.qxC.qvN;
          if (localObject1 != null)
          {
            ((d)localObject1).b(this.uDP);
            AppMethodBeat.o(324448);
            return;
            if (paramInt1 == cQn()) {
              localObject1 = com.tencent.mm.plugin.appbrand.widget.s.uxX;
            } else {
              localObject1 = com.tencent.mm.plugin.appbrand.widget.s.uxW;
            }
          }
        }
        else
        {
          this.uEd = ((ValueAnimator)((b)localObject1).invoke(Boolean.FALSE));
          localObject1 = this.qxC.qvN;
          if (localObject1 != null) {
            ((d)localObject1).c(this.uDP);
          }
        }
      }
    }
    AppMethodBeat.o(324448);
  }
  
  public final boolean K(MotionEvent paramMotionEvent)
  {
    float f1 = 0.0F;
    boolean bool2 = true;
    AppMethodBeat.i(324463);
    kotlin.g.b.s.u(paramMotionEvent, "ev");
    Log.d("MicroMsg.WxaHalfScreenGestureControllerImp", "handleTouchEvent: action[" + paramMotionEvent.getAction() + ']');
    if (this.doL == null) {
      this.doL = VelocityTracker.obtain();
    }
    Object localObject1 = this.doL;
    kotlin.g.b.s.checkNotNull(localObject1);
    ((VelocityTracker)localObject1).addMovement(paramMotionEvent);
    float f2;
    int i;
    switch (paramMotionEvent.getAction())
    {
    default: 
      if (this.uDP == c.uDB)
      {
        AppMethodBeat.o(324463);
        return true;
      }
      break;
    case 0: 
      this.uDZ = this.uDY;
      this.uDO = MotionEvent.obtain(paramMotionEvent);
      this.uEa = this.uDR.getHeight();
      this.uDX = true;
      cQk();
      S(paramMotionEvent);
      AppMethodBeat.o(324463);
      return true;
    case 2: 
      if (!this.uEb)
      {
        AppMethodBeat.o(324463);
        return true;
      }
      try
      {
        if (this.isAnimating)
        {
          Log.d("MicroMsg.WxaHalfScreenGestureControllerImp", "[handleTouchEvent] can not perform scroll container during animating");
          return false;
        }
        f2 = paramMotionEvent.getRawY();
        localObject1 = this.lastMotionEvent;
        if (localObject1 == null) {}
        for (;;)
        {
          i = (int)(f2 - f1);
          if (Eh(i)) {
            break;
          }
          Log.d("MicroMsg.WxaHalfScreenGestureControllerImp", "[handleTouchEvent] can not perform scroll container");
          return false;
          f1 = ((MotionEvent)localObject1).getRawY();
        }
        R(paramMotionEvent);
        this.uDQ += i;
        Eg(this.uEa + -this.uDQ);
        Log.d("MicroMsg.WxaHalfScreenGestureControllerImp", "[handleTouchEvent] current height=" + this.uDR.getLayoutParams().height + "  moveDistanceY=" + i);
        return true;
      }
      finally
      {
        S(paramMotionEvent);
        AppMethodBeat.o(324463);
      }
    }
    for (;;)
    {
      boolean bool3;
      int j;
      Object localObject3;
      boolean bool1;
      try
      {
        bool3 = Q(paramMotionEvent);
        Log.i("MicroMsg.WxaHalfScreenGestureControllerImp", "interactsContainerView[" + bool3 + ']');
        if ((this.uEb) && (bool3))
        {
          j = this.uDQ;
          if (this.isAnimating) {
            Log.d("MicroMsg.WxaHalfScreenGestureControllerImp", "[tryPerformAnimationWhenScrollRelease] can not perform animation during animating");
          }
        }
        else
        {
          if ((this.uEb) || (Q(paramMotionEvent)) || (paramMotionEvent.getAction() != 1) || (paramMotionEvent.getEventTime() - paramMotionEvent.getDownTime() > ViewConfiguration.getTapTimeout())) {
            break label1097;
          }
          i = 1;
          if (i == 0) {
            break label957;
          }
          Log.i("MicroMsg.WxaHalfScreenGestureControllerImp", "Empty area clicked");
          localObject3 = this.uEc;
          if (localObject3 == null) {
            break label1103;
          }
          bool1 = ((com.tencent.mm.plugin.appbrand.widget.k)localObject3).I(paramMotionEvent);
          if (bool1) {
            break label1103;
          }
          i = 1;
          if (i != 0) {
            break label1109;
          }
          bool1 = bool2;
          return bool1;
        }
        localObject3 = this.doL;
        if (localObject3 != null) {
          ((VelocityTracker)localObject3).computeCurrentVelocity(1000, this.uDV);
        }
        localObject3 = this.doL;
        if (localObject3 != null) {
          break label792;
        }
        f1 = 0.0F;
        if (Math.abs(f1) < Ei(500)) {
          break label1051;
        }
        bool1 = true;
        f2 = Ei(100);
        Log.i("MicroMsg.WxaHalfScreenGestureControllerImp", "[tryPerformAnimationWhenScrollRelease] yVelocity=" + f1 + "  fastSliding= " + bool1 + " thresholdPx=" + f2 + " slideDistanceVertical=" + j + '}');
        if (!bool1) {
          break label1075;
        }
        if (f1 != 0.0F) {
          break label1057;
        }
        i = 1;
      }
      finally
      {
        label707:
        cQh();
        AppMethodBeat.o(324463);
      }
      if (i == 2)
      {
        Log.i("MicroMsg.WxaHalfScreenGestureControllerImp", "[tryPerformAnimationWhenScrollRelease] slide_orientation_down  viewStatusAtGestureStart[" + this.uDZ + ']');
        if ((Math.abs(j) > f2) || (bool1))
        {
          Log.i("MicroMsg.WxaHalfScreenGestureControllerImp", "[tryPerformAnimationWhenScrollRelease] animate dismiss}");
          a(g.uxH);
          continue;
          label792:
          f1 = ((VelocityTracker)localObject3).getYVelocity();
        }
        else if (this.uDZ == com.tencent.mm.plugin.appbrand.widget.s.uxW)
        {
          Log.i("MicroMsg.WxaHalfScreenGestureControllerImp", "[tryPerformAnimationWhenScrollRelease] animate reset to initial height}");
          a(g.uxF);
        }
        else
        {
          Log.i("MicroMsg.WxaHalfScreenGestureControllerImp", "[tryPerformAnimationWhenScrollRelease] animate expand}");
          a(g.uxG);
        }
      }
      else if (i == 1)
      {
        Log.i("MicroMsg.WxaHalfScreenGestureControllerImp", "[tryPerformAnimationWhenScrollRelease] slide_orientation_up viewStatusAtGestureStart[" + this.uDZ + ']');
        if (((Math.abs(j) <= f2) && (!bool1)) || ((this.uDS) && (this.uDZ == com.tencent.mm.plugin.appbrand.widget.s.uxW)))
        {
          Log.i("MicroMsg.WxaHalfScreenGestureControllerImp", "[tryPerformAnimationWhenScrollRelease] animate reset to initial height}");
          a(g.uxF);
        }
        else
        {
          Log.i("MicroMsg.WxaHalfScreenGestureControllerImp", "[tryPerformAnimationWhenScrollRelease] animate expand}");
          a(g.uxG);
          continue;
          label957:
          bool1 = this.uEb;
          if ((!bool1) && (bool3))
          {
            cQh();
            AppMethodBeat.o(324463);
            return true;
          }
          paramMotionEvent = this.uDP;
          localObject3 = c.uDB;
          if (paramMotionEvent == localObject3)
          {
            cQh();
            AppMethodBeat.o(324463);
            return true;
          }
          cQh();
          break;
          AppMethodBeat.o(324463);
          return false;
          label1051:
          label1057:
          label1063:
          label1075:
          do
          {
            do
            {
              i = 0;
              break label707;
              for (;;)
              {
                if (i != 0) {
                  break label1075;
                }
                if (f1 <= 0.0F) {
                  break label1063;
                }
                i = 2;
                break label707;
                bool1 = false;
                break;
                i = 0;
              }
            } while (f1 >= 0.0F);
            i = 1;
            break label707;
            if (j > 0)
            {
              i = 2;
              break label707;
            }
          } while (j >= 0);
          i = 1;
          continue;
          label1097:
          i = 0;
          continue;
          label1103:
          i = 0;
          continue;
          label1109:
          bool1 = false;
        }
      }
    }
  }
  
  public final boolean L(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(324473);
    kotlin.g.b.s.u(paramMotionEvent, "ev");
    Log.d("MicroMsg.WxaHalfScreenGestureControllerImp", "handleOnInterceptTouchEvent: action[" + paramMotionEvent.getAction() + "]  X[" + paramMotionEvent.getRawX() + "] Y[" + paramMotionEvent.getRawY() + ']');
    boolean bool;
    int i;
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      for (;;)
      {
        Log.d("MicroMsg.WxaHalfScreenGestureControllerImp", "handleOnInterceptTouchEvent: action[" + paramMotionEvent.getAction() + "] return false");
        AppMethodBeat.o(324473);
        return false;
        this.uEb = Q(paramMotionEvent);
        S(paramMotionEvent);
        this.uDO = MotionEvent.obtain(paramMotionEvent);
        this.uDZ = this.uDY;
        this.uEa = this.uDR.getHeight();
        this.uDX = true;
        cQk();
        com.tencent.mm.plugin.appbrand.widget.k localk;
        if (!this.uEb)
        {
          localk = this.uEc;
          if (localk == null) {}
          for (bool = true; bool; bool = localk.J(paramMotionEvent))
          {
            AppMethodBeat.o(324473);
            return true;
          }
        }
        AppMethodBeat.o(324473);
        return false;
        if (!this.uEb)
        {
          localk = this.uEc;
          if ((localk != null) && (!localk.J(paramMotionEvent))) {}
          for (i = 1; i == 0; i = 0)
          {
            AppMethodBeat.o(324473);
            return true;
          }
        }
        if (!cQi())
        {
          AppMethodBeat.o(324473);
          return false;
        }
        try
        {
          i = U(paramMotionEvent);
          int j = T(paramMotionEvent);
          Log.d("MicroMsg.WxaHalfScreenGestureControllerImp", "handleOnInterceptTouchEvent: moveDistanceY[" + j + "]  touchSlop[" + this.doK + ']');
          bool = this.uDS;
          if ((bool) && (j < 0)) {
            return false;
          }
          if ((Math.abs(j) >= this.doK) && (Math.abs(j) > Math.abs(i))) {
            if (cQj())
            {
              if (Eh(j))
              {
                bool = this.uDW;
                Log.i("MicroMsg.WxaHalfScreenGestureControllerImp", "canOverScroll[" + bool + ']');
                if (!bool) {}
              }
            }
            else
            {
              d(c.uDB);
              return true;
            }
          }
          R(paramMotionEvent);
          S(paramMotionEvent);
        }
        finally
        {
          S(paramMotionEvent);
          AppMethodBeat.o(324473);
        }
      }
    }
    for (;;)
    {
      try
      {
        bool = cQi();
        if (!bool) {
          return false;
        }
        d locald;
        if ((this.uDX) && (paramMotionEvent.getAction() == 1))
        {
          kotlin.g.b.s.u(paramMotionEvent, "ev");
          locald = this.qxC.qvN;
          if (locald == null) {
            break label732;
          }
          kotlin.g.b.s.u(paramMotionEvent, "ev");
          BaseAppBrandSingleCloseCapsuleBar localBaseAppBrandSingleCloseCapsuleBar = locald.cPZ();
          if ((localBaseAppBrandSingleCloseCapsuleBar != null) && (localBaseAppBrandSingleCloseCapsuleBar.au(paramMotionEvent.getRawX(), paramMotionEvent.getRawY()) == true))
          {
            i = 1;
            break label723;
            if (i != 0) {
              continue;
            }
            a(g.uxG);
            Log.i("MicroMsg.WxaHalfScreenGestureControllerImp", "tap to full screen");
          }
        }
        else
        {
          if (this.uEb) {
            break label716;
          }
          bool = Q(paramMotionEvent);
          if (!bool) {
            break label716;
          }
          return true;
        }
        i = 0;
        break label723;
        if (locald.cQc().qZZ) {
          break label732;
        }
        i = 1;
        continue;
        Log.i("MicroMsg.WxaHalfScreenGestureControllerImp", "tap to full screen be intercepted");
        continue;
        cQh();
      }
      finally
      {
        cQh();
        AppMethodBeat.o(324473);
      }
      label716:
      break;
      label723:
      if (i != 0)
      {
        i = 1;
        continue;
        label732:
        i = 0;
      }
    }
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(324480);
    kotlin.g.b.s.u(paramg, "type");
    Log.i("MicroMsg.WxaHalfScreenGestureControllerImp", "[animateContainer] type[" + paramg + "]}");
    ValueAnimator localValueAnimator;
    switch (c.$EnumSwitchMapping$0[paramg.ordinal()])
    {
    default: 
      paramg = new p();
      AppMethodBeat.o(324480);
      throw paramg;
    case 1: 
      if (this.uDR.getHeight() == this.uDU) {
        localValueAnimator = null;
      }
      break;
    }
    while (localValueAnimator == null)
    {
      Log.d("MicroMsg.WxaHalfScreenGestureControllerImp", "[animateContainer] no animator need to be played");
      AppMethodBeat.o(324480);
      return;
      localValueAnimator = ValueAnimator.ofInt(new int[] { this.uDR.getHeight(), this.uDU });
      continue;
      localValueAnimator = ValueAnimator.ofInt(new int[] { this.uDR.getHeight(), Math.min(cQg(), cQn()) });
      continue;
      localValueAnimator = ValueAnimator.ofInt(new int[] { this.uDR.getHeight(), 0 });
      localValueAnimator.addListener((Animator.AnimatorListener)new e(this));
    }
    localValueAnimator.addUpdateListener(new f..ExternalSyntheticLambda0(this));
    localValueAnimator.addListener((Animator.AnimatorListener)new d(paramg, this));
    localValueAnimator.setInterpolator((TimeInterpolator)new DecelerateInterpolator());
    localValueAnimator.setDuration(300L);
    localValueAnimator.start();
    AppMethodBeat.o(324480);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.widget.k paramk)
  {
    this.uEc = paramk;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.s cOP()
  {
    return this.uDY;
  }
  
  public final void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(324491);
    Log.i("MicroMsg.WxaHalfScreenGestureControllerImp", "onOverScrolled   scrollX=" + paramInt1 + "   scrollY=" + paramInt2 + "    clampedX=" + paramBoolean1 + "   clampedY=" + paramBoolean2);
    if (!this.uDW) {
      this.uDW = paramBoolean2;
    }
    AppMethodBeat.o(324491);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/WxaHalfScreenGestureControllerImp$AnimatorListenerAdapter;", "Landroid/animation/Animator$AnimatorListener;", "()V", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static class a
    implements Animator.AnimatorListener
  {
    public void onAnimationCancel(Animator paramAnimator) {}
    
    public void onAnimationEnd(Animator paramAnimator) {}
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/widget/halfscreen/WxaHalfScreenGestureControllerImp$animateContainer$3", "Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/WxaHalfScreenGestureControllerImp$AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationStart", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends f.a
  {
    d(g paramg, f paramf) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(324364);
      super.onAnimationCancel(paramAnimator);
      Log.d("MicroMsg.WxaHalfScreenGestureControllerImp", "[animateContainer] type[" + this.uEe + "]} onAnimationCancel");
      jdField_this.isAnimating = false;
      AppMethodBeat.o(324364);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(324359);
      super.onAnimationCancel(paramAnimator);
      Log.d("MicroMsg.WxaHalfScreenGestureControllerImp", "[animateContainer] type[" + this.uEe + "]} onAnimationEnd");
      jdField_this.isAnimating = false;
      AppMethodBeat.o(324359);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(324371);
      super.onAnimationStart(paramAnimator);
      Log.d("MicroMsg.WxaHalfScreenGestureControllerImp", "[animateContainer] type[" + this.uEe + "]} onAnimationStart");
      jdField_this.isAnimating = true;
      AppMethodBeat.o(324371);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/widget/halfscreen/WxaHalfScreenGestureControllerImp$animateContainer$animator$1$1", "Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/WxaHalfScreenGestureControllerImp$AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends f.a
  {
    e(f paramf) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(324355);
      this.uEf.qxC.close();
      AppMethodBeat.o(324355);
    }
  }
  
  @Metadata(d1={""}, d2={"<no name provided>", "Landroid/animation/ValueAnimator;", "darkStatusBar", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements b<Boolean, ValueAnimator>
  {
    f(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.d.f
 * JD-Core Version:    0.7.0.1
 */