package com.tencent.mm.openim.ui.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.comm.c.c;
import com.tencent.mm.plugin.comm.c.e;
import com.tencent.mm.plugin.comm.c.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bf;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/ui/view/BaseDialogView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backgroundListener", "Lcom/tencent/mm/openim/ui/view/DialogMoveListener;", "backgroundTouchListener", "Lcom/tencent/mm/openim/ui/view/DialogBackgroundTouchListener;", "canMeasured", "", "closeButton", "Landroid/view/View;", "closeButtonLayoutHeight", "closeClickListener", "Lcom/tencent/mm/openim/ui/view/BaseDialogModel$OnCloseClickListener;", "contentContainer", "currentEnableTouchScroll", "dialog", "Lcom/tencent/mm/openim/ui/view/BaseDialogModel;", "dialogBg", "dialogContainer", "dialogContainerCurrentTranslationY", "", "dialogContainerHalfTranslationY", "dialogContainerHeight", "dialogContainerMinTranslationY", "dialogState", "enableCancelOutSide", "enableScrollRightClose", "enableScrollVertical", "fixedContentViewHeight", "fixedDialogHeight", "fixedDialogHeightRate", "isAnimating", "isAtWebViewTop", "isContentViewWrapContent", "isExpand", "isFixedDialogHeight", "isShowing", "isTouchScrolling", "lastOrientation", "mDownX", "mDownY", "mInterceptTracker", "Landroid/view/VelocityTracker;", "mInterceptXDown", "mInterceptYDown", "mStatusBarHeight", "mTopEmptyHeight", "maxContentViewHeight", "minContentViewHeight", "moveOffsetXFactor", "moveOffsetY", "navigationBarHeight", "screenHeight", "scrollingHorizontal", "scrollingVertical", "showAnimationInterpolator", "Landroid/view/animation/DecelerateInterpolator;", "topExtraHeight", "windowVisibleHeight", "animateDialogVerticalTranslation", "", "fromTranslationY", "targetTranslationY", "duration", "", "switchToFullScreen", "attachContentView", "attachDialog", "dialogModel", "canCloseWhenFullScreen", "canCloseWhenHalfScreen", "canOpenWhenHalfScreen", "computeFixedContentViewHeight", "dialogHeight", "computeTargetValueByRef", "refStart", "refEnd", "refCurrent", "targetStart", "targetEnd", "dismiss", "exitType", "getCloseButton", "root", "getCloseLayoutHeight", "getContentViewLayoutId", "getMaxTranslationY", "getMoveDistanceByOffsetX", "offsetX", "getMoveDistanceByOffsetY", "offsetY", "handleScroll", "offset", "vertical", "init", "initContentViewHeight", "initDialogBg", "initMoveOffsetXFactor", "initWindowVisibleHeight", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onContentViewAttached", "view", "onCreateView", "onDialogContainerTranslationYChanged", "transY", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onPause", "onResume", "onTouchEvent", "onTouchUp", "setBackgroundListener", "listener", "setBackgroundTouchListener", "setCanceledOnTouchOutside", "cancel", "setContentViewWrapContent", "wrapContent", "setEnableDialogScroll", "enableScroll", "setEnableScrollRightClose", "setFixDialogHeight", "fixedHeight", "setFixDialogHeightRate", "rate", "setIsFixDialogHeight", "fixed", "setOnCloseClickListener", "show", "switchToHalfScreen", "updateDialogContainerTranslationY", "updateLayoutHeight", "layout", "targetHeight", "needRequestLayout", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class BaseDialogView
  extends RelativeLayout
{
  public static final BaseDialogView.a puN = new BaseDialogView.a((byte)0);
  public boolean fhR;
  public boolean isAnimating;
  private int lastOrientation;
  private int mStatusBarHeight;
  private float puO;
  private float puP;
  private float puQ;
  private float puR;
  private VelocityTracker puS;
  public a puT;
  private View puU;
  public View puV;
  private RelativeLayout puW;
  private View puX;
  private c puY;
  private b puZ;
  private boolean pvA = true;
  private boolean pvB = true;
  private boolean pvC;
  private boolean pvD = true;
  private final DecelerateInterpolator pvE = new DecelerateInterpolator();
  private int pvF;
  private a.b pva;
  private int pvb;
  private float pvc;
  private float pvd;
  private float pve;
  private int pvf;
  private int pvg;
  private int pvh;
  private int pvi;
  private int pvj;
  private int pvk;
  private boolean pvl = true;
  private int pvm;
  private int pvn;
  private boolean pvo;
  private int pvp;
  private int pvq;
  private float pvr;
  private boolean pvs = true;
  private float pvt;
  private float pvu = 1.0F;
  private boolean pvv;
  private boolean pvw = true;
  private boolean pvx;
  private boolean pvy;
  private boolean pvz;
  
  public BaseDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BaseDialogView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setFitsSystemWindows(true);
    this.lastOrientation = getResources().getConfiguration().orientation;
    View localView = LayoutInflater.from(paramContext).inflate(c.f.layout_base_dialog_view, (ViewGroup)this, true);
    s.s(localView, "view");
    s.u(localView, "view");
    paramAttributeSet = localView.findViewById(c.e.content_container);
    s.s(paramAttributeSet, "view.findViewById(R.id.content_container)");
    this.puW = ((RelativeLayout)paramAttributeSet);
    LayoutInflater localLayoutInflater = LayoutInflater.from(getContext());
    paramInt = getContentViewLayoutId();
    Object localObject2 = this.puW;
    paramAttributeSet = (AttributeSet)localObject2;
    if (localObject2 == null)
    {
      s.bIx("contentContainer");
      paramAttributeSet = null;
    }
    localLayoutInflater.inflate(paramInt, (ViewGroup)paramAttributeSet, true);
    paramAttributeSet = localView.findViewById(c.e.dialog_container);
    s.s(paramAttributeSet, "view.findViewById(R.id.dialog_container)");
    this.puV = paramAttributeSet;
    paramAttributeSet = localView.findViewById(c.e.dialog_bg);
    s.s(paramAttributeSet, "view.findViewById(R.id.dialog_bg)");
    this.puU = paramAttributeSet;
    this.puX = jdMethod_do(localView);
    bSx();
    localObject2 = this.puX;
    paramAttributeSet = (AttributeSet)localObject2;
    if (localObject2 == null)
    {
      s.bIx("closeButton");
      paramAttributeSet = null;
    }
    paramAttributeSet.setOnClickListener(new BaseDialogView..ExternalSyntheticLambda3(this));
    localObject2 = this.puW;
    paramAttributeSet = (AttributeSet)localObject2;
    if (localObject2 == null)
    {
      s.bIx("contentContainer");
      paramAttributeSet = null;
    }
    dp((View)paramAttributeSet);
    this.pvk = bf.bk(paramContext);
    this.mStatusBarHeight = bf.getStatusBarHeight(paramContext);
    this.pvg = (com.tencent.mm.cd.a.mt(paramContext) + this.mStatusBarHeight);
    this.pvf = getCloseLayoutHeight();
    this.pvi = com.tencent.mm.cd.a.fromDPToPix(paramContext, 50);
    Log.i("MicroMsg.BaseDialogView", "alvinluo initBoxDialogView orientation: %s, getScreenHeight: %d, statusBarHeight: %d, topEmptyHeight: %d", new Object[] { Integer.valueOf(this.lastOrientation), Integer.valueOf(this.pvg), Integer.valueOf(this.mStatusBarHeight), Integer.valueOf(this.pvi) });
    paramContext = this.puV;
    if (paramContext == null)
    {
      s.bIx("dialogContainer");
      paramContext = localObject1;
    }
    for (;;)
    {
      paramContext.setTranslationY(this.pvg);
      bSy();
      return;
    }
  }
  
  private static final void a(BaseDialogView paramBaseDialogView, ValueAnimator paramValueAnimator)
  {
    Object localObject = null;
    s.u(paramBaseDialogView, "this$0");
    View localView = paramBaseDialogView.puV;
    paramValueAnimator = localView;
    if (localView == null)
    {
      s.bIx("dialogContainer");
      paramValueAnimator = null;
    }
    paramBaseDialogView.pvc = paramValueAnimator.getTranslationY();
    paramBaseDialogView = paramBaseDialogView.puV;
    if (paramBaseDialogView == null)
    {
      s.bIx("dialogContainer");
      paramBaseDialogView = localObject;
    }
    for (;;)
    {
      paramBaseDialogView.getTranslationY();
      return;
    }
  }
  
  private static final void a(BaseDialogView paramBaseDialogView, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramBaseDialogView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/openim/ui/view/BaseDialogView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramBaseDialogView, "this$0");
    paramBaseDialogView = paramBaseDialogView.pva;
    if (paramBaseDialogView != null) {
      paramBaseDialogView.xL(4);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/openim/ui/view/BaseDialogView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  private static final void b(BaseDialogView paramBaseDialogView, ValueAnimator paramValueAnimator)
  {
    s.u(paramBaseDialogView, "this$0");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null) {
      throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
    paramBaseDialogView.bu(((Float)paramValueAnimator).floatValue());
  }
  
  private static final void b(BaseDialogView paramBaseDialogView, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramBaseDialogView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/openim/ui/view/BaseDialogView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramBaseDialogView, "this$0");
    if (!paramBaseDialogView.pvD)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/openim/ui/view/BaseDialogView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      return;
    }
    paramBaseDialogView = paramBaseDialogView.pva;
    if (paramBaseDialogView != null) {
      paramBaseDialogView.xL(3);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/openim/ui/view/BaseDialogView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  private final boolean bSA()
  {
    return (this.pvt < 0.0F) && (Math.abs(this.pvt) >= this.pvm * 0.05F);
  }
  
  private final boolean bSB()
  {
    return (this.pvt > 0.0F) && (Math.abs(this.pvt) >= this.pvm * 0.15F);
  }
  
  private final void bSx()
  {
    View localView2 = this.puU;
    View localView1 = localView2;
    if (localView2 == null)
    {
      s.bIx("dialogBg");
      localView1 = null;
    }
    localView1.setOnClickListener(new BaseDialogView..ExternalSyntheticLambda2(this));
  }
  
  private final void bSy()
  {
    if ((getContext() instanceof Activity))
    {
      Rect localRect = new Rect();
      Object localObject = getContext();
      if (localObject == null) {
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      }
      localObject = ((Activity)localObject).getWindow();
      if (localObject != null)
      {
        localObject = ((Window)localObject).getDecorView();
        if (localObject != null) {
          ((View)localObject).getWindowVisibleDisplayFrame(localRect);
        }
      }
      this.pvh = localRect.height();
      Log.i("MicroMsg.BaseDialogView", "alvinluo initWindowVisibleHeight: %s, height: %d, windowVisibleHeight: %d, navigationBarHeight: %d", new Object[] { localRect, Integer.valueOf(localRect.height()), Integer.valueOf(this.pvh), Integer.valueOf(this.pvk) });
    }
  }
  
  private final boolean bSz()
  {
    return (this.pvt > 0.0F) && (Math.abs(this.pvt) >= this.pvm * 0.15F);
  }
  
  private final void bu(float paramFloat)
  {
    View localView2 = this.puV;
    View localView1 = localView2;
    if (localView2 == null)
    {
      s.bIx("dialogContainer");
      localView1 = null;
    }
    localView1.setTranslationY(paramFloat);
  }
  
  private final void c(float paramFloat, boolean paramBoolean)
  {
    if (!this.pvA) {
      return;
    }
    if (!this.pvz) {
      this.pvz = true;
    }
    if ((this.pvo) && (this.pvm > this.pvq))
    {
      int i = Math.max(this.pvq, this.pvn);
      Log.d("MicroMsg.BaseDialogView", "alvinluo handleScroll fixedContentViewHeight: %d, target: %d", new Object[] { Integer.valueOf(this.pvq), Integer.valueOf(i) });
      this.pvd = Math.max(this.pvd, this.pvm - i);
    }
    if (paramBoolean) {}
    for (float f1 = 0.68F * paramFloat;; f1 = 0.85F * paramFloat)
    {
      float f2 = this.pvc;
      f2 = Math.max(this.pvd, f2 + f1);
      f2 = Math.min(this.pvb, f2);
      Log.d("MicroMsg.BaseDialogView", "alvinluo handleScroll vertical: %b, offset: %f, moveDis: %f, currentTranslationY: %f, targetTranslationY: %f, minTranslationY: %f", new Object[] { Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat), Float.valueOf(f1), Float.valueOf(this.pvc), Float.valueOf(f2), Float.valueOf(this.pvd) });
      this.pvt = f1;
      bu(f2);
      return;
    }
  }
  
  private static final void dq(View paramView)
  {
    if (paramView != null) {
      paramView.requestLayout();
    }
  }
  
  private final void f(float paramFloat1, float paramFloat2, final boolean paramBoolean)
  {
    Log.v("MicroMsg.BaseDialogView", "alvinluo animateDialogVerticalTranslation from: %f, to: %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    if (paramFloat1 == paramFloat2) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.BaseDialogView", "alvinluo animateDialogVerticalTranslation start equals end and ignore");
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 });
    localValueAnimator.setInterpolator((TimeInterpolator)new DecelerateInterpolator());
    localValueAnimator.setDuration(200L);
    localValueAnimator.addUpdateListener(new BaseDialogView..ExternalSyntheticLambda0(this));
    localValueAnimator.addListener((Animator.AnimatorListener)new b(this, paramBoolean));
    localValueAnimator.start();
  }
  
  public abstract View jdMethod_do(View paramView);
  
  public void dp(View paramView)
  {
    s.u(paramView, "view");
  }
  
  public abstract int getCloseLayoutHeight();
  
  public abstract int getContentViewLayoutId();
  
  public final int getMaxTranslationY()
  {
    return this.pvb;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    Integer localInteger;
    if (paramConfiguration == null)
    {
      localInteger = null;
      Log.i("MicroMsg.BaseDialogView", "alvinluo onConfigurationChanged newConfig orientation: %s, last: %s", new Object[] { localInteger, Integer.valueOf(this.lastOrientation) });
      i = this.lastOrientation;
      if ((paramConfiguration == null) || (i != paramConfiguration.orientation)) {
        break label77;
      }
    }
    label77:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        bSy();
      }
      return;
      localInteger = Integer.valueOf(paramConfiguration.orientation);
      break;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    boolean bool1 = false;
    boolean bool2;
    if (paramMotionEvent == null)
    {
      localObject1 = null;
      Log.d("MicroMsg.BaseDialogView", "alvinluo onInterceptTouchEvent %s", new Object[] { localObject1 });
      bool2 = super.onInterceptTouchEvent(paramMotionEvent);
      if (!bool2) {
        break label65;
      }
      bool1 = bool2;
    }
    label65:
    while (paramMotionEvent == null)
    {
      return bool1;
      localObject1 = Integer.valueOf(paramMotionEvent.getAction());
      break;
    }
    if (this.puS == null) {
      this.puS = VelocityTracker.obtain();
    }
    Object localObject1 = this.puS;
    s.checkNotNull(localObject1);
    ((VelocityTracker)localObject1).addMovement(paramMotionEvent);
    localObject1 = this.puS;
    s.checkNotNull(localObject1);
    ((VelocityTracker)localObject1).computeCurrentVelocity(1000);
    localObject1 = this.puS;
    s.checkNotNull(localObject1);
    int i = (int)((VelocityTracker)localObject1).getXVelocity();
    localObject1 = this.puS;
    s.checkNotNull(localObject1);
    int j = (int)((VelocityTracker)localObject1).getYVelocity();
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      bool1 = false;
    }
    for (;;)
    {
      Log.v("MicroMsg.BaseDialogView", "alvinluo onInterceptTouchEvent enableScrollVertical: %b, action: %s, isIntercept: %b, scrollingVertical: %b, scrollingHorizontal: %b", new Object[] { Boolean.valueOf(this.pvB), Integer.valueOf(paramMotionEvent.getAction()), Boolean.valueOf(bool1), Boolean.valueOf(this.pvx), Boolean.valueOf(this.pvy) });
      return bool1;
      float f1 = paramMotionEvent.getRawX();
      float f2 = paramMotionEvent.getRawY();
      localObject1 = this.puV;
      if (localObject1 == null)
      {
        s.bIx("dialogContainer");
        localObject1 = localObject2;
      }
      for (;;)
      {
        Log.d("MicroMsg.BaseDialogView", "alvinluo onInterceptTouchEvent down: %f, %f, dialogContainer translationY: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(((View)localObject1).getTranslationY()) });
        this.puQ = paramMotionEvent.getRawX();
        this.puR = paramMotionEvent.getRawY();
        bool1 = false;
        break;
      }
      f1 = paramMotionEvent.getRawX() - this.puQ;
      f2 = paramMotionEvent.getRawY() - this.puR;
      Log.d("MicroMsg.BaseDialogView", "alvinluo onInterceptTouchEvent action_move tx: %f, ty: %f, velocityX: %d, velocityY: %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
      float f3 = paramMotionEvent.getRawY();
      localObject1 = this.puV;
      if (localObject1 == null)
      {
        s.bIx("dialogContainer");
        localObject1 = localObject3;
        label443:
        if (f3 < ((View)localObject1).getTranslationY()) {
          break label729;
        }
        if ((Math.abs(f2) < 5.0F) || (!this.pvB) || (Math.abs(f1) > 250.0F) || (Math.abs(j) <= Math.abs(i)) || (Math.abs(j) <= 0) || (Math.abs(f2) <= Math.abs(f1))) {
          break label619;
        }
        Log.i("MicroMsg.BaseDialogView", "alvinluo ViewPager onInterceptTouchEvent action: %d, dialogContainerCurrentTranslationY: %s", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Float.valueOf(this.pvc) });
        if (this.pvc > this.pvd) {
          break label613;
        }
        if (!this.pvw) {
          break label607;
        }
        if (f2 < 0.0F) {
          break label601;
        }
        bool2 = true;
      }
      for (;;)
      {
        bool1 = bool2;
        if (!bool2) {
          break;
        }
        this.pvx = true;
        bool1 = bool2;
        break;
        break label443;
        label601:
        bool2 = false;
        continue;
        label607:
        bool2 = false;
        continue;
        label613:
        bool2 = true;
      }
      label619:
      if (!this.pvC) {
        break;
      }
      if ((Math.abs(i) > Math.abs(j)) && (f1 > 0.0F) && (Math.abs(f1) > Math.abs(f2)) && (this.puQ <= 20.0F)) {}
      for (bool2 = true;; bool2 = false)
      {
        Log.d("MicroMsg.BaseDialogView", "alvinluo onInterceptTouchEvent interceptXDown: %f, scrollLeftRight: %b", new Object[] { Float.valueOf(this.puQ), Boolean.valueOf(bool2) });
        bool1 = bool2;
        if (!bool2) {
          break;
        }
        this.pvy = true;
        bool1 = bool2;
        break;
      }
      label729:
      bool1 = false;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Object localObject3 = null;
    super.onMeasure(paramInt1, paramInt2);
    if (this.pvh == 0) {
      bSy();
    }
    Object localObject2 = this.puV;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("dialogContainer");
      localObject1 = null;
    }
    Object localObject4;
    boolean bool1;
    if ((((View)localObject1).getMeasuredHeight() != this.pvb) && (this.pvl))
    {
      localObject2 = this.puV;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("dialogContainer");
        localObject1 = null;
      }
      this.pvb = ((View)localObject1).getMeasuredHeight();
      paramInt1 = Math.max(0, this.pvh - this.pvb);
      this.pvj = Math.max(0, this.pvi - paramInt1);
      if (this.pvo) {
        this.pvj = getContext().getResources().getDimensionPixelSize(c.c.Edge_A);
      }
      this.pvm = (this.pvb - this.pvf - this.pvj);
      Log.v("MicroMsg.BaseDialogView", "alvinluo onMeasure dialogContainerHeight: %d, extraHeight: %d, diff: %d, fixedDialogHeight: %b", new Object[] { Integer.valueOf(this.pvb), Integer.valueOf(this.pvj), Integer.valueOf(paramInt1), Boolean.valueOf(this.pvo) });
      this.pvn = (this.pvh / 2 - this.pvf);
      localObject2 = this.puU;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("dialogBg");
        localObject1 = null;
      }
      localObject4 = this.puU;
      localObject2 = localObject4;
      if (localObject4 == null)
      {
        s.bIx("dialogBg");
        localObject2 = null;
      }
      localObject2 = ((View)localObject2).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).height = (this.pvh / 2);
      localObject4 = ah.aiuX;
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      boolean bool2 = this.pvo;
      if (!bool2)
      {
        bool1 = bool2;
        if (!this.pvs) {}
      }
      else
      {
        if (!this.pvs) {
          break label854;
        }
        localObject2 = this.puW;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("contentContainer");
          localObject1 = null;
        }
        paramInt1 = ((RelativeLayout)localObject1).getMeasuredHeight();
        this.pvq = paramInt1;
        this.pvm = this.pvq;
        if (this.pvq <= 0) {
          break label962;
        }
        this.pvn = this.pvq;
        bool1 = bool2;
      }
      label400:
      localObject2 = this.puW;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("contentContainer");
        localObject1 = null;
      }
      localObject1 = ((RelativeLayout)localObject1).getLayoutParams();
      if (localObject1 != null) {
        break label968;
      }
      paramInt1 = 0;
      label438:
      if ((!bool1) && (!this.pvs)) {
        break label1014;
      }
      if (bool1)
      {
        localObject2 = this.puW;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("contentContainer");
          localObject1 = null;
        }
        if (((RelativeLayout)localObject1).getLayoutParams().height != this.pvq)
        {
          localObject2 = this.puW;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("contentContainer");
            localObject1 = null;
          }
          localObject2 = (View)localObject1;
          paramInt2 = this.pvq;
          if (localObject2 != null)
          {
            if (localObject2 != null) {
              break label977;
            }
            localObject1 = null;
            label543:
            ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
          post(new BaseDialogView..ExternalSyntheticLambda4((View)localObject2));
        }
      }
      localObject2 = this.puV;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("dialogContainer");
        localObject1 = null;
      }
      if (((View)localObject1).getTranslationY() != this.pvm - this.pvq) {
        break label1009;
      }
      paramInt2 = 1;
      label609:
      if (paramInt2 == 0)
      {
        this.pvc = (this.pvm - this.pvq);
        this.pve = this.pvc;
        if (this.fhR)
        {
          localObject2 = this.puV;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("dialogContainer");
            localObject1 = null;
          }
          ((View)localObject1).setTranslationY(this.pvc);
        }
      }
      label675:
      paramInt2 = this.pvm;
      int i = this.pvn;
      localObject2 = this.puV;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("dialogContainer");
        localObject1 = null;
      }
      Log.i("MicroMsg.BaseDialogView", "alvinluo initContentViewHeight maxContentViewHeight: %d, minContentViewHeight: %d, translationY: %s, dialogContainerCurrentTranslationY: %s, fixedDialog: %b, fixedContentViewHeight: %s, currentContentHeight: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(i), Float.valueOf(((View)localObject1).getTranslationY()), Float.valueOf(this.pvc), Boolean.valueOf(bool1), Integer.valueOf(this.pvq), Integer.valueOf(paramInt1) });
      paramInt1 = com.tencent.mm.cd.a.ms(getContext());
      localObject1 = this.puV;
      if (localObject1 != null) {
        break label1189;
      }
      s.bIx("dialogContainer");
      localObject1 = localObject3;
      label813:
      this.pvu = (((View)localObject1).getMeasuredHeight() / (0.5F * paramInt1));
      Log.d("MicroMsg.BaseDialogView", "alvinluo initMoveOffsetXFactor %f", new Object[] { Float.valueOf(this.pvu) });
    }
    else
    {
      return;
    }
    label854:
    paramInt2 = this.pvb;
    if (this.pvp > 0) {
      paramInt1 = this.pvp - this.pvf;
    }
    for (;;)
    {
      paramInt1 = Math.min(this.pvm, paramInt1);
      Log.v("MicroMsg.BaseDialogView", "alvinluo computeFixedContentViewHeight dialogHeight: %s, fixedDialogHeight: %s, fixedDialogHeightRate: %s, fixedContentViewHeight: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(this.pvp), Float.valueOf(this.pvr), Integer.valueOf(paramInt1) });
      break;
      if (this.pvr > 0.0F)
      {
        paramInt1 = (int)(this.pvr * paramInt2 - this.pvf);
        continue;
        label962:
        bool1 = false;
        break label400;
        label968:
        paramInt1 = ((ViewGroup.LayoutParams)localObject1).height;
        break label438;
        label977:
        localObject1 = ((View)localObject2).getLayoutParams();
        if (localObject1 == null)
        {
          localObject1 = null;
          break label543;
        }
        ((ViewGroup.LayoutParams)localObject1).height = paramInt2;
        localObject4 = ah.aiuX;
        break label543;
        label1009:
        paramInt2 = 0;
        break label609;
        label1014:
        localObject2 = this.puW;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("contentContainer");
          localObject1 = null;
        }
        this.pvn = ((RelativeLayout)localObject1).getMeasuredHeight();
        Log.i("MicroMsg.BaseDialogView", "alvinluo initContentViewHeight: %s", new Object[] { Integer.valueOf(this.pvn) });
        localObject2 = this.puV;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("dialogContainer");
          localObject1 = null;
        }
        if (((View)localObject1).getTranslationY() == this.pvm - this.pvn) {}
        for (paramInt2 = 1;; paramInt2 = 0)
        {
          if (paramInt2 != 0) {
            break label1187;
          }
          this.pvc = (this.pvm - this.pvn);
          this.pve = this.pvc;
          if (!this.fhR) {
            break;
          }
          localObject2 = this.puV;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("dialogContainer");
            localObject1 = null;
          }
          ((View)localObject1).setTranslationY(this.pvc);
          break;
        }
        label1187:
        break label675;
        label1189:
        break label813;
      }
      paramInt1 = 0;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    int i = 2;
    boolean bool3 = true;
    boolean bool1;
    if (paramMotionEvent == null) {
      bool1 = super.onTouchEvent(paramMotionEvent);
    }
    float f1;
    float f2;
    boolean bool2;
    label97:
    do
    {
      return bool1;
      if ((this.isAnimating) || (this.pvy) || (this.puZ == null)) {
        break;
      }
      View localView = this.puV;
      localObject1 = localView;
      if (localView == null)
      {
        s.bIx("dialogContainer");
        localObject1 = null;
      }
      f1 = ((View)localObject1).getTranslationY();
      f2 = this.pvj;
      localObject1 = this.puZ;
      if (localObject1 != null) {
        break label210;
      }
      bool2 = false;
      Log.v("MicroMsg.BaseDialogView", "alvinluo onTouchEvent handle by backgroundListener offsetY: %s, event.y: %s, handled: %s", new Object[] { Float.valueOf(f2 + f1), Float.valueOf(paramMotionEvent.getRawY()), Boolean.valueOf(bool2) });
      bool1 = bool3;
    } while (bool2);
    Log.d("MicroMsg.BaseDialogView", "alvinluo onTouchEvent %s", new Object[] { Integer.valueOf(paramMotionEvent.getAction()) });
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
    case 0: 
    case 2: 
      for (;;)
      {
        return super.onTouchEvent(paramMotionEvent);
        label210:
        bool2 = ((b)localObject1).bSD();
        break label97;
        this.puO = paramMotionEvent.getRawX();
        this.puP = paramMotionEvent.getRawY();
        bool1 = bool3;
        if (!this.isAnimating) {
          break;
        }
        this.pvA = false;
        return true;
        if (this.isAnimating) {
          this.pvA = false;
        }
        if (this.puO == 0.0F)
        {
          i = 1;
          label280:
          if (i == 0) {
            break label333;
          }
          if (this.puP != 0.0F) {
            break label327;
          }
        }
        label327:
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label333;
          }
          this.puO = paramMotionEvent.getRawX();
          this.puP = paramMotionEvent.getRawY();
          break;
          i = 0;
          break label280;
        }
        label333:
        f1 = paramMotionEvent.getRawX() - this.puO;
        f2 = paramMotionEvent.getRawY() - this.puP;
        if (Math.abs(f2) > Math.abs(f1)) {
          this.pvx = true;
        }
        for (;;)
        {
          if ((!this.pvx) || ((!this.pvB) && (!this.pvC))) {
            break label415;
          }
          c(f2, true);
          break;
          if (this.pvC) {
            this.pvy = true;
          }
        }
        label415:
        if (this.pvy) {
          c(f1, false);
        } else {
          Log.v("MicroMsg.BaseDialogView", "alvinluo handleScroll ignore");
        }
      }
    }
    this.puO = 0.0F;
    this.puP = 0.0F;
    Log.i("MicroMsg.BaseDialogView", "alvinluo onTouchUp isExpand: %b, isTouchScrolling: %s, currentEnableTouchScroll: %s, dialogContainerHalfTranslationY: %s", new Object[] { Boolean.valueOf(this.pvv), Boolean.valueOf(this.pvz), Boolean.valueOf(this.pvA), Float.valueOf(this.pve) });
    if (this.pvA)
    {
      if (this.pvz) {
        this.pvz = false;
      }
      if (this.pvv) {
        break label674;
      }
      Log.d("MicroMsg.BaseDialogView", "alvinluo onTouchUp canClose: %b, canOpen: %b", new Object[] { Boolean.valueOf(bSz()), Boolean.valueOf(bSA()) });
      if (!bSz()) {
        break label626;
      }
      localObject1 = this.pva;
      if (localObject1 != null)
      {
        if (!this.pvx) {
          break label620;
        }
        i = 1;
        label593:
        ((a.b)localObject1).xL(i);
      }
    }
    for (;;)
    {
      this.pvx = false;
      this.pvy = false;
      this.pvA = true;
      break;
      label620:
      i = 2;
      break label593;
      label626:
      if (bSA()) {
        break label737;
      }
      localObject1 = this.puV;
      if (localObject1 == null)
      {
        s.bIx("dialogContainer");
        localObject1 = localObject2;
      }
      for (;;)
      {
        f(((View)localObject1).getTranslationY(), this.pve, false);
        break;
      }
      label674:
      Log.d("MicroMsg.BaseDialogView", "alvinluo onTouchUp canClose: %b", new Object[] { Boolean.valueOf(bSB()) });
      if (!bSB()) {
        break label737;
      }
      localObject1 = this.pva;
      if (localObject1 != null)
      {
        if (this.pvx) {
          i = 1;
        }
        ((a.b)localObject1).xL(i);
      }
    }
    label737:
    Object localObject1 = this.puV;
    if (localObject1 == null)
    {
      s.bIx("dialogContainer");
      localObject1 = localObject3;
    }
    for (;;)
    {
      f(((View)localObject1).getTranslationY(), this.pvd, true);
      break;
    }
  }
  
  public final void setBackgroundListener(c paramc)
  {
    s.u(paramc, "listener");
    this.puY = paramc;
  }
  
  public final void setBackgroundTouchListener(b paramb)
  {
    s.u(paramb, "listener");
    this.puZ = paramb;
  }
  
  public final void setCanceledOnTouchOutside(boolean paramBoolean)
  {
    Object localObject = null;
    this.pvD = paramBoolean;
    if (!this.pvD)
    {
      localView = this.puU;
      localObject = localView;
      if (localView == null)
      {
        s.bIx("dialogBg");
        localObject = null;
      }
      localObject.setVisibility(8);
      localView = this.puU;
      localObject = localView;
      if (localView == null)
      {
        s.bIx("dialogBg");
        localObject = null;
      }
      localObject.setOnClickListener(null);
      return;
    }
    View localView = this.puU;
    if (localView == null) {
      s.bIx("dialogBg");
    }
    for (;;)
    {
      localObject.setVisibility(0);
      bSx();
      return;
      localObject = localView;
    }
  }
  
  public final void setContentViewWrapContent(boolean paramBoolean)
  {
    this.pvs = paramBoolean;
  }
  
  public final void setEnableDialogScroll(boolean paramBoolean)
  {
    this.pvB = paramBoolean;
  }
  
  public final void setEnableScrollRightClose(boolean paramBoolean)
  {
    this.pvC = paramBoolean;
  }
  
  public final void setFixDialogHeight(int paramInt)
  {
    Log.v("MicroMsg.BaseDialogView", "alvinluo setFixDialogHeight: %d", new Object[] { Integer.valueOf(paramInt) });
    this.pvp = paramInt;
  }
  
  public final void setFixDialogHeightRate(float paramFloat)
  {
    Log.v("MicroMsg.BaseDialogView", "alvinluo setFixDialogHeightRate: %s", new Object[] { Float.valueOf(paramFloat) });
    this.pvr = paramFloat;
  }
  
  public final void setIsFixDialogHeight(boolean paramBoolean)
  {
    this.pvo = paramBoolean;
  }
  
  protected final void setOnCloseClickListener(a.b paramb)
  {
    s.u(paramb, "listener");
    this.pva = paramb;
  }
  
  public final void show()
  {
    Object localObject2 = null;
    Log.v("MicroMsg.BaseDialogView", "alvinluo showDialog");
    this.pvv = false;
    this.isAnimating = true;
    this.pvF = 0;
    final float f1 = getMaxTranslationY();
    final float f2 = this.pve;
    View localView = this.puV;
    Object localObject1 = localView;
    if (localView == null)
    {
      s.bIx("dialogContainer");
      localObject1 = null;
    }
    ((View)localObject1).setTranslationY(f1);
    localObject1 = this.puV;
    if (localObject1 == null)
    {
      s.bIx("dialogContainer");
      localObject1 = localObject2;
    }
    for (;;)
    {
      localObject1 = ((View)localObject1).animate();
      if (localObject1 != null)
      {
        localObject1 = ((ViewPropertyAnimator)localObject1).translationY(f2);
        if (localObject1 != null)
        {
          localObject1 = ((ViewPropertyAnimator)localObject1).setInterpolator((TimeInterpolator)this.pvE);
          if (localObject1 != null)
          {
            localObject1 = ((ViewPropertyAnimator)localObject1).setUpdateListener(new BaseDialogView..ExternalSyntheticLambda1(this));
            if (localObject1 != null)
            {
              localObject1 = ((ViewPropertyAnimator)localObject1).setListener((Animator.AnimatorListener)new e(this, f1, f2));
              if (localObject1 != null)
              {
                localObject1 = ((ViewPropertyAnimator)localObject1).setDuration(300L);
                if (localObject1 != null) {
                  ((ViewPropertyAnimator)localObject1).start();
                }
              }
            }
          }
        }
      }
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/openim/ui/view/BaseDialogView$animateDialogVerticalTranslation$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Animator.AnimatorListener
  {
    b(BaseDialogView paramBaseDialogView, boolean paramBoolean) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(235968);
      BaseDialogView.a(this.pvG, paramBoolean);
      BaseDialogView localBaseDialogView = this.pvG;
      View localView = BaseDialogView.d(this.pvG);
      paramAnimator = localView;
      if (localView == null)
      {
        s.bIx("dialogContainer");
        paramAnimator = null;
      }
      BaseDialogView.a(localBaseDialogView, paramAnimator.getTranslationY());
      paramAnimator = this.pvG;
      if (paramBoolean) {}
      for (int i = 2;; i = 1)
      {
        BaseDialogView.a(paramAnimator, i);
        AppMethodBeat.o(235968);
        return;
      }
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/openim/ui/view/BaseDialogView$dismiss$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements Animator.AnimatorListener
  {
    public c(BaseDialogView paramBaseDialogView) {}
    
    private static final void b(BaseDialogView paramBaseDialogView, int paramInt)
    {
      AppMethodBeat.i(235960);
      s.u(paramBaseDialogView, "this$0");
      paramBaseDialogView = BaseDialogView.c(paramBaseDialogView);
      if (paramBaseDialogView != null) {
        paramBaseDialogView.xM(paramInt);
      }
      AppMethodBeat.o(235960);
    }
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(235985);
      BaseDialogView.a(this.pvG);
      AppMethodBeat.o(235985);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(235978);
      BaseDialogView.a(this.pvG);
      BaseDialogView.a(this.pvG, 0);
      BaseDialogView.b(this.pvG);
      h.ahAA.bk(new BaseDialogView.c..ExternalSyntheticLambda0(this.pvG, this.pvI));
      AppMethodBeat.o(235978);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(235991);
      BaseDialogView.b(this.pvG);
      AppMethodBeat.o(235991);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/openim/ui/view/BaseDialogView$dismiss$2", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "onAnimationUpdate", "", "animation", "Landroid/animation/ValueAnimator;", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements ValueAnimator.AnimatorUpdateListener
  {
    public d(BaseDialogView paramBaseDialogView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(235966);
      View localView = BaseDialogView.d(this.pvG);
      paramValueAnimator = localView;
      if (localView == null)
      {
        s.bIx("dialogContainer");
        paramValueAnimator = null;
      }
      paramValueAnimator.getTranslationY();
      BaseDialogView.bSC();
      AppMethodBeat.o(235966);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/openim/ui/view/BaseDialogView$show$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements Animator.AnimatorListener
  {
    e(BaseDialogView paramBaseDialogView, float paramFloat1, float paramFloat2) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(235974);
      BaseDialogView.a(this.pvG);
      AppMethodBeat.o(235974);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(235969);
      BaseDialogView.b(this.pvG);
      BaseDialogView.e(this.pvG);
      BaseDialogView.a(this.pvG);
      View localView = BaseDialogView.d(this.pvG);
      paramAnimator = localView;
      if (localView == null)
      {
        s.bIx("dialogContainer");
        paramAnimator = null;
      }
      Log.v("MicroMsg.BaseDialogView", "alvinluo show onAnimationEnd current translationY: %f", new Object[] { Float.valueOf(paramAnimator.getTranslationY()) });
      AppMethodBeat.o(235969);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(235980);
      if (BaseDialogView.b(this.pvG) != null) {
        BaseDialogView.f(this.pvG);
      }
      AppMethodBeat.o(235980);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.openim.ui.view.BaseDialogView
 * JD-Core Version:    0.7.0.1
 */