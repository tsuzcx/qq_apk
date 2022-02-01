package com.tencent.mm.plugin.finder.webview;

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
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.MMWebView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/webview/BaseBoxDialogView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animator", "Landroid/animation/ValueAnimator;", "backgroundListener", "Lcom/tencent/mm/plugin/finder/webview/BoxDialogMoveListener;", "backgroundOpContainer", "Landroid/widget/LinearLayout;", "backgroundOpView", "Lcom/tencent/mm/plugin/finder/webview/BoxDialogBackgroundOpViewModel;", "backgroundTouchListener", "Lcom/tencent/mm/plugin/finder/webview/BoxDialogBackgroundTouchListener;", "backgroundViewModel", "Lcom/tencent/mm/plugin/finder/webview/BoxDialogBackgroundViewModel;", "bgViewCurrentTranslationY", "", "boxWebView", "Lcom/tencent/mm/ui/widget/MMWebView;", "canMeasured", "", "closeButton", "Landroid/view/View;", "closeButtonLayoutHeight", "currentEnableTouchScroll", "dialog", "Lcom/tencent/mm/plugin/finder/webview/BoxDialogModel;", "dialogBg", "dialogContainer", "dialogContainerCurrentTranslationY", "dialogContainerHalfTranslationY", "dialogContainerHeight", "dialogContainerMinTranslationY", "dialogState", "enableCancelOutSide", "enableScrollRightClose", "enableScrollVertical", "fixedDialogHeight", "fixedDialogHeightRate", "fixedWebViewHeight", "fullScreenAnimationInfo", "Lcom/tencent/mm/plugin/finder/webview/BaseBoxDialogView$AnimationInfo;", "halfScreenAnimationInfo", "isAnimating", "isAtWebViewTop", "isExpand", "isFixedDialogHeight", "isShowing", "isTouchScrolling", "lastOrientation", "mDownX", "mDownY", "mInterceptTracker", "Landroid/view/VelocityTracker;", "mInterceptXDown", "mInterceptYDown", "mStatusBarHeight", "mTopEmptyHeight", "markViewOriginTranslationY", "maxWebViewHeight", "minWebViewHeight", "moveOffsetXFactor", "moveOffsetY", "navigationBarHeight", "screenHeight", "scrollingHorizontal", "scrollingVertical", "showAnimationInterpolator", "Landroid/view/animation/DecelerateInterpolator;", "topExtraHeight", "webViewContainer", "Lcom/tencent/mm/plugin/finder/webview/RelativeInterceptScrollLayout;", "webViewScrollHeight", "windowVisibleHeight", "animateDialogVerticalTranslation", "", "fromTranslationY", "targetTranslationY", "duration", "", "switchToFullScreen", "animateShowBackground", "attachDialog", "dialogModel", "attachWebView", "webView", "canCloseWhenFullScreen", "canCloseWhenHalfScreen", "canOpenWhenHalfScreen", "computeAnimationInfo", "computeFixedWebViewHeight", "dialogHeight", "computeFullScreenAnimationInfo", "computeHalfScreenAnimationInfo", "computeTargetValueByRef", "refStart", "refEnd", "refCurrent", "targetStart", "targetEnd", "dismiss", "exitType", "getCloseButton", "root", "getCloseLayoutHeight", "getLayoutId", "getMaxTranslationY", "getMoveDistanceByOffsetX", "offsetX", "getMoveDistanceByOffsetY", "offsetY", "handleScroll", "offset", "vertical", "init", "initBackgroundOpView", "initDialogBg", "initMoveOffsetXFactor", "initWebViewHeight", "initWindowVisibleHeight", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreateView", "view", "onDialogContainerTranslationYChanged", "transY", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onPause", "onResume", "onTouchEvent", "onTouchUp", "setBackgroundListener", "listener", "setBackgroundOpView", "opView", "setBackgroundTouchListener", "setBackgroundTranslationY", "setBackgroundViewModel", "model", "setCanceledOnTouchOutside", "cancel", "setEnableDialogScroll", "enableScroll", "setEnableScrollRightClose", "setEnableWebViewScroll", "setFixDialogHeight", "fixedHeight", "setFixDialogHeightRate", "rate", "setIsFixDialogHeight", "fixed", "setMinDialogHeight", "minHeight", "show", "switchToHalfScreen", "updateDialogContainerTranslationY", "updateLayoutHeight", "layout", "targetHeight", "needRequestLayout", "AnimationInfo", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class BaseBoxDialogView
  extends RelativeLayout
{
  public static final BaseBoxDialogView.b GWV = new BaseBoxDialogView.b((byte)0);
  private d GWW;
  private RelativeInterceptScrollLayout GWX;
  private LinearLayout GWY;
  private MMWebView GWZ;
  private e GXa;
  private b GXb;
  private c GXc;
  private a GXd;
  private float GXe;
  private float GXf;
  private int GXg;
  private int GXh;
  private int GXi;
  private int GXj;
  private a GXk = new a();
  private a GXl = new a();
  private final ValueAnimator animator = new ValueAnimator();
  private boolean fhR;
  private boolean isAnimating;
  private int lastOrientation;
  private int mStatusBarHeight;
  private float puO;
  private float puP;
  private float puQ;
  private float puR;
  private VelocityTracker puS;
  private View puU;
  private View puV;
  private View puX;
  private boolean pvA = true;
  private boolean pvB = true;
  private boolean pvC;
  private boolean pvD = true;
  private final DecelerateInterpolator pvE = new DecelerateInterpolator();
  private int pvF;
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
  private boolean pvo;
  private int pvp;
  private float pvr;
  private float pvt;
  private float pvu = 1.0F;
  private boolean pvv;
  private boolean pvw = true;
  private boolean pvx;
  private boolean pvy;
  private boolean pvz;
  
  public BaseBoxDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BaseBoxDialogView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setFitsSystemWindows(true);
    this.lastOrientation = getResources().getConfiguration().orientation;
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(getLayoutId(), (ViewGroup)this, true);
    s.s(paramAttributeSet, "view");
    s.u(paramAttributeSet, "view");
    View localView = paramAttributeSet.findViewById(e.e.dialog_container);
    s.s(localView, "view.findViewById(R.id.dialog_container)");
    this.puV = localView;
    localView = paramAttributeSet.findViewById(e.e.dialog_bg);
    s.s(localView, "view.findViewById(R.id.dialog_bg)");
    this.puU = localView;
    localView = paramAttributeSet.findViewById(e.e.webview_container);
    s.s(localView, "view.findViewById(R.id.webview_container)");
    this.GWX = ((RelativeInterceptScrollLayout)localView);
    this.puX = jdMethod_do(paramAttributeSet);
    this.GWY = ((LinearLayout)paramAttributeSet.findViewById(e.e.background_op_container));
    paramAttributeSet = this.GWY;
    if (paramAttributeSet != null) {
      paramAttributeSet.setVisibility(8);
    }
    this.pvk = bf.bk(paramContext);
    bSx();
    localView = this.puX;
    paramAttributeSet = localView;
    if (localView == null)
    {
      s.bIx("closeButton");
      paramAttributeSet = null;
    }
    paramAttributeSet.setOnClickListener(new BaseBoxDialogView..ExternalSyntheticLambda2(this));
    this.mStatusBarHeight = bf.getStatusBarHeight(paramContext);
    this.pvg = (com.tencent.mm.cd.a.mt(paramContext) + this.mStatusBarHeight);
    this.pvf = getCloseLayoutHeight();
    this.pvi = com.tencent.mm.cd.a.fromDPToPix(paramContext, 50);
    Log.i("MicroMsg.BaseBoxDialogView", "alvinluo initBoxDialogView orientation: %s, getScreenHeight: %d, statusBarHeight: %d, topEmptyHeight: %d", new Object[] { Integer.valueOf(this.lastOrientation), Integer.valueOf(this.pvg), Integer.valueOf(this.mStatusBarHeight), Integer.valueOf(this.pvi) });
    paramContext = this.puV;
    if (paramContext == null)
    {
      s.bIx("dialogContainer");
      paramContext = localObject;
    }
    for (;;)
    {
      paramContext.setTranslationY(this.pvg);
      bSy();
      return;
    }
  }
  
  private void Vx(final int paramInt)
  {
    float f2 = getMaxTranslationY();
    Object localObject = this.GXc;
    if (localObject == null) {}
    for (final float f1 = 0.0F;; f1 = ((c)localObject).getBackgroundTransY())
    {
      this.isAnimating = true;
      this.fhR = false;
      View localView = this.puV;
      localObject = localView;
      if (localView == null)
      {
        s.bIx("dialogContainer");
        localObject = null;
      }
      localObject = ((View)localObject).animate();
      if (localObject != null)
      {
        localObject = ((ViewPropertyAnimator)localObject).translationY(f2);
        if (localObject != null)
        {
          localObject = ((ViewPropertyAnimator)localObject).setDuration(300L);
          if (localObject != null)
          {
            localObject = ((ViewPropertyAnimator)localObject).setInterpolator((TimeInterpolator)new AccelerateInterpolator());
            if (localObject != null)
            {
              localObject = ((ViewPropertyAnimator)localObject).setListener((Animator.AnimatorListener)new d(this, paramInt));
              if (localObject != null)
              {
                localObject = ((ViewPropertyAnimator)localObject).setUpdateListener((ValueAnimator.AnimatorUpdateListener)new e(this, f1));
                if (localObject != null) {
                  ((ViewPropertyAnimator)localObject).start();
                }
              }
            }
          }
        }
      }
      return;
    }
  }
  
  private static final void a(BaseBoxDialogView paramBaseBoxDialogView, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramBaseBoxDialogView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/webview/BaseBoxDialogView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramBaseBoxDialogView, "this$0");
    paramBaseBoxDialogView.Vx(4);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/webview/BaseBoxDialogView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  private static final void a(BaseBoxDialogView paramBaseBoxDialogView, boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3, ValueAnimator paramValueAnimator)
  {
    s.u(paramBaseBoxDialogView, "this$0");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null) {
      throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
    float f2 = ((Float)paramValueAnimator).floatValue();
    paramBaseBoxDialogView.bu(f2);
    if (paramBoolean) {}
    for (float f1 = paramBaseBoxDialogView.GXl.GXn;; f1 = paramBaseBoxDialogView.GXk.GXn)
    {
      paramBaseBoxDialogView.setBackgroundTranslationY(c(paramFloat1, paramFloat2, f2, paramFloat3, f1));
      return;
    }
  }
  
  private static final void b(BaseBoxDialogView paramBaseBoxDialogView, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramBaseBoxDialogView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/webview/BaseBoxDialogView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramBaseBoxDialogView, "this$0");
    if (!paramBaseBoxDialogView.pvD)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/webview/BaseBoxDialogView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      return;
    }
    paramBaseBoxDialogView.Vx(3);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/webview/BaseBoxDialogView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  private final boolean bSA()
  {
    return (this.pvt < 0.0F) && (Math.abs(this.pvt) >= this.GXh * 0.05F);
  }
  
  private final boolean bSB()
  {
    return (this.pvt > 0.0F) && (Math.abs(this.pvt) >= this.GXh * 0.15F);
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
    localView1.setOnClickListener(new BaseBoxDialogView..ExternalSyntheticLambda1(this));
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
      Log.i("MicroMsg.BaseBoxDialogView", "alvinluo initWindowVisibleHeight: %s, height: %d, windowVisibleHeight: %d, navigationBarHeight: %d", new Object[] { localRect, Integer.valueOf(localRect.height()), Integer.valueOf(this.pvh), Integer.valueOf(this.pvk) });
    }
  }
  
  private final boolean bSz()
  {
    return (this.pvt > 0.0F) && (Math.abs(this.pvt) >= this.GXh * 0.15F);
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
    cs(paramFloat);
  }
  
  private static float c(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    return 1.0F * (paramFloat3 - paramFloat1) / (paramFloat2 - paramFloat1) * (paramFloat5 - paramFloat4) + paramFloat4;
  }
  
  private final void c(float paramFloat, boolean paramBoolean)
  {
    Object localObject1 = null;
    if (!this.pvA) {}
    label124:
    do
    {
      return;
      if (!this.pvz) {
        this.pvz = true;
      }
      localObject2 = this.GWZ;
      int i;
      if (localObject2 == null)
      {
        i = 0;
        this.GXg = i;
        if ((!fpJ()) || (this.GXh <= this.GXj)) {
          break label310;
        }
        i = Math.max(this.GXj, this.GXi);
        Log.d("MicroMsg.BaseBoxDialogView", "alvinluo handleScroll fixedWebViewHeight: %d, target: %d", new Object[] { Integer.valueOf(this.GXj), Integer.valueOf(i) });
        this.pvd = Math.max(this.pvd, this.GXh - i);
        if (!paramBoolean) {
          break label387;
        }
      }
      for (float f1 = 0.68F * paramFloat;; f1 = 0.85F * paramFloat)
      {
        float f2 = this.pvc;
        f2 = Math.max(this.pvd, f2 + f1);
        f2 = Math.min(this.pvb, f2);
        Log.d("MicroMsg.BaseBoxDialogView", "alvinluo handleScroll vertical: %b, offset: %f, moveDis: %f, currentTranslationY: %f, targetTranslationY: %f, minTranslationY: %f", new Object[] { Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat), Float.valueOf(f1), Float.valueOf(this.pvc), Float.valueOf(f2), Float.valueOf(this.pvd) });
        this.pvt = f1;
        bu(f2);
        if (f1 < 0.0F) {
          break label396;
        }
        paramFloat = this.pvc;
        f1 = this.pvb;
        localObject2 = this.puV;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("dialogContainer");
          localObject1 = null;
        }
        setBackgroundTranslationY(c(paramFloat, f1, localObject1.getTranslationY(), this.GXe, 0.0F));
        return;
        i = ((MMWebView)localObject2).getScrollHeight();
        break;
        if (this.GXh <= this.GXg) {
          break label124;
        }
        i = Math.max(this.GXg, this.GXi);
        Log.d("MicroMsg.BaseBoxDialogView", "alvinluo handleScroll webViewScrollHeight: %d, target: %d", new Object[] { Integer.valueOf(this.GXg), Integer.valueOf(i) });
        this.pvd = Math.max(this.pvd, this.GXh - i);
        break label124;
      }
    } while (this.pvc <= 0.0F);
    label310:
    paramFloat = this.pvc;
    label387:
    label396:
    Object localObject2 = this.puV;
    if (localObject2 == null) {
      s.bIx("dialogContainer");
    }
    for (;;)
    {
      setBackgroundTranslationY(c(paramFloat, 0.0F, localObject1.getTranslationY(), this.GXl.GXm, this.GXl.GXn));
      return;
      localObject1 = localObject2;
    }
  }
  
  private final void cs(float paramFloat)
  {
    Object localObject = this.GWY;
    a locala;
    int i;
    if (localObject != null)
    {
      locala = this.GXd;
      if (locala == null)
      {
        i = 0;
        ((LinearLayout)localObject).setTranslationY(paramFloat - i);
      }
    }
    else
    {
      i = this.pvb;
      localObject = this.GXd;
      if (localObject != null) {
        break label89;
      }
    }
    label89:
    for (localObject = null;; localObject = Integer.valueOf(((a)localObject).getVieHeight()))
    {
      Log.v("MicroMsg.BaseBoxDialogView", "alvinluo onDialogContainerTranslationYChanged: %f, dialogHeight: %s, backgroundOpViewHeight: %s", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(i), localObject });
      return;
      i = locala.getVieHeight();
      break;
    }
  }
  
  private final void f(float paramFloat1, float paramFloat2, final boolean paramBoolean)
  {
    Log.v("MicroMsg.BaseBoxDialogView", "alvinluo animateDialogVerticalTranslation from: %f, to: %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    if (paramFloat1 == paramFloat2) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.BaseBoxDialogView", "alvinluo animateDialogVerticalTranslation start equals end and ignore");
      return;
    }
    Object localObject = this.GXc;
    if (localObject == null) {}
    for (float f = 0.0F;; f = ((c)localObject).getBackgroundTransY())
    {
      localObject = ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 });
      ((ValueAnimator)localObject).setInterpolator((TimeInterpolator)new DecelerateInterpolator());
      ((ValueAnimator)localObject).setDuration(200L);
      ((ValueAnimator)localObject).addUpdateListener(new BaseBoxDialogView..ExternalSyntheticLambda0(this, paramBoolean, paramFloat1, paramFloat2, f));
      ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new c(this, paramBoolean));
      ((ValueAnimator)localObject).start();
      return;
    }
  }
  
  private final void f(View paramView, int paramInt, boolean paramBoolean)
  {
    ah localah = null;
    Object localObject;
    if (paramView != null)
    {
      if (paramView != null) {
        break label39;
      }
      localObject = localah;
    }
    for (;;)
    {
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (paramBoolean) {
        post(new BaseBoxDialogView..ExternalSyntheticLambda3(paramView));
      }
      return;
      label39:
      localObject = paramView.getLayoutParams();
      if (localObject == null)
      {
        localObject = localah;
      }
      else
      {
        ((ViewGroup.LayoutParams)localObject).height = paramInt;
        localah = ah.aiuX;
      }
    }
  }
  
  private final boolean fpJ()
  {
    return (this.pvo) && ((this.pvp > 0) || (this.pvr > 0.0F));
  }
  
  private final int getMaxTranslationY()
  {
    return this.pvb;
  }
  
  private static final void hn(View paramView)
  {
    if (paramView != null) {
      paramView.requestLayout();
    }
  }
  
  private final void setBackgroundTranslationY(float paramFloat)
  {
    Log.v("MicroMsg.BaseBoxDialogView", "alvinluo setBackgroundTranslationY: %f", new Object[] { Float.valueOf(paramFloat) });
  }
  
  public abstract View jdMethod_do(View paramView);
  
  public abstract int getCloseLayoutHeight();
  
  public abstract int getLayoutId();
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    Integer localInteger;
    if (paramConfiguration == null)
    {
      localInteger = null;
      Log.i("MicroMsg.BaseBoxDialogView", "alvinluo onConfigurationChanged newConfig orientation: %s, last: %s", new Object[] { localInteger, Integer.valueOf(this.lastOrientation) });
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
      Log.d("MicroMsg.BaseBoxDialogView", "alvinluo onInterceptTouchEvent %s", new Object[] { localObject1 });
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
      Log.v("MicroMsg.BaseBoxDialogView", "alvinluo onInterceptTouchEvent enableScrollVertical: %b, action: %s, isIntercept: %b, scrollingVertical: %b, scrollingHorizontal: %b", new Object[] { Boolean.valueOf(this.pvB), Integer.valueOf(paramMotionEvent.getAction()), Boolean.valueOf(bool1), Boolean.valueOf(this.pvx), Boolean.valueOf(this.pvy) });
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
        Log.d("MicroMsg.BaseBoxDialogView", "alvinluo onInterceptTouchEvent down: %f, %f, dialogContainer translationY: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(((View)localObject1).getTranslationY()) });
        this.puQ = paramMotionEvent.getRawX();
        this.puR = paramMotionEvent.getRawY();
        bool1 = false;
        break;
      }
      f1 = paramMotionEvent.getRawX() - this.puQ;
      f2 = paramMotionEvent.getRawY() - this.puR;
      Log.d("MicroMsg.BaseBoxDialogView", "alvinluo onInterceptTouchEvent action_move tx: %f, ty: %f, velocityX: %d, velocityY: %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
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
        Log.i("MicroMsg.BaseBoxDialogView", "alvinluo ViewPager onInterceptTouchEvent action: %d, dialogContainerCurrentTranslationY: %s", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Float.valueOf(this.pvc) });
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
        Log.d("MicroMsg.BaseBoxDialogView", "alvinluo onInterceptTouchEvent interceptXDown: %f, scrollLeftRight: %b", new Object[] { Float.valueOf(this.puQ), Boolean.valueOf(bool2) });
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
    boolean bool2;
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
      if (fpJ()) {
        this.pvj = getContext().getResources().getDimensionPixelSize(e.c.Edge_A);
      }
      this.GXh = (this.pvb - this.pvf - this.pvj);
      Log.v("MicroMsg.BaseBoxDialogView", "alvinluo onMeasure dialogContainerHeight: %d, extraHeight: %d, diff: %d, fixedDialogHeight: %b", new Object[] { Integer.valueOf(this.pvb), Integer.valueOf(this.pvj), Integer.valueOf(paramInt1), Boolean.valueOf(fpJ()) });
      if (this.GXi == 0) {
        this.GXi = (this.pvh / 2 - this.pvf);
      }
      localObject2 = this.puU;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("dialogBg");
        localObject1 = null;
      }
      Object localObject4 = this.puU;
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
      bool2 = fpJ();
      bool1 = bool2;
      if (bool2)
      {
        paramInt2 = this.pvb;
        if (this.pvp <= 0) {
          break label1092;
        }
        paramInt1 = this.pvp - this.pvf;
      }
    }
    for (;;)
    {
      paramInt1 = Math.min(this.GXh, paramInt1);
      Log.v("MicroMsg.BaseBoxDialogView", "alvinluo computeFixedWebViewHeight dialogHeight: %s, fixedDialogHeight: %s, fixedDiaogHeightRate: %s, fixedWebViewHeight: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(this.pvp), Float.valueOf(this.pvr), Integer.valueOf(paramInt1), Integer.valueOf(paramInt1) });
      this.GXj = paramInt1;
      if (this.GXj > 0)
      {
        this.GXi = this.GXj;
        bool1 = bool2;
        label440:
        localObject1 = this.GWZ;
        if (localObject1 != null) {
          break label1125;
        }
        paramInt1 = 0;
        label453:
        if (!bool1) {
          break label1157;
        }
        if (this.GWZ == null) {
          break label1585;
        }
        localObject1 = this.GWZ;
        s.checkNotNull(localObject1);
        if (((MMWebView)localObject1).getLayoutParams().height == this.GXj) {
          break label1585;
        }
        paramInt1 = this.GXj;
        f((View)this.GWZ, this.GXj, false);
      }
      label932:
      label1585:
      for (;;)
      {
        localObject2 = this.GWX;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("webViewContainer");
          localObject1 = null;
        }
        if (((RelativeInterceptScrollLayout)localObject1).getLayoutParams().height != this.GXh)
        {
          localObject2 = this.GWX;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("webViewContainer");
            localObject1 = null;
          }
          f((View)localObject1, this.GXh, true);
        }
        localObject2 = this.puV;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("dialogContainer");
          localObject1 = null;
        }
        int i;
        if (((View)localObject1).getTranslationY() == this.GXh - this.GXj)
        {
          i = 1;
          label635:
          paramInt2 = paramInt1;
          if (i == 0)
          {
            this.pvc = (this.GXh - this.GXj);
            this.pve = this.pvc;
            paramInt2 = paramInt1;
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
              paramInt2 = paramInt1;
            }
          }
          paramInt1 = this.GXh;
          i = this.GXi;
          localObject2 = this.puV;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("dialogContainer");
            localObject1 = null;
          }
          Log.i("MicroMsg.BaseBoxDialogView", "alvinluo initWebViewHeight maxWebViewHeight: %d, minWebVieHeight: %d, translationY: %s, dialogContainerCurrentTranslationY: %s, fixedDialog: %b, fixedWebViewHeight: %s, currentWebViewHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i), Float.valueOf(((View)localObject1).getTranslationY()), Float.valueOf(this.pvc), Boolean.valueOf(bool1), Integer.valueOf(this.GXj), Integer.valueOf(paramInt2) });
          paramInt1 = com.tencent.mm.cd.a.ms(getContext());
          localObject1 = this.puV;
          if (localObject1 != null) {
            break label1334;
          }
          s.bIx("dialogContainer");
          localObject1 = localObject3;
          label848:
          this.pvu = (((View)localObject1).getMeasuredHeight() / (0.5F * paramInt1));
          Log.d("MicroMsg.BaseBoxDialogView", "alvinluo initMoveOffsetXFactor %f", new Object[] { Float.valueOf(this.pvu) });
          this.GXk.GXm = 0.0F;
          this.GXk.GXo = true;
          paramInt1 = this.pvh - this.GXi - this.pvf;
          localObject1 = this.GXc;
          if (localObject1 != null) {
            break label1337;
          }
          f1 = 0.0F;
          localObject1 = this.GXc;
          if (localObject1 != null) {
            break label1348;
          }
        }
        label1092:
        label1348:
        for (float f2 = 0.0F;; f2 = ((c)localObject1).getMarkViewTransY())
        {
          Log.i("MicroMsg.BaseBoxDialogView", "alvinluo computeHalfScreenAnimationInfo temp: %f, %f, markViewTransY: %f", new Object[] { Float.valueOf(paramInt1 / 2.0F), Float.valueOf(this.pvh / 4.0F), Float.valueOf(f2) });
          if (f2 > paramInt1 / 2.0F - f1 / 2.0F) {
            break label1360;
          }
          Log.d("MicroMsg.BaseBoxDialogView", "alvinluo computeHalfScreenAnimationInfo not need animation");
          this.GXk.GXo = false;
          this.GXl.GXo = true;
          this.GXl.GXm = this.GXk.GXn;
          f1 = this.GXk.GXn;
          f2 = this.GXf + f1;
          if (f2 > this.pvi / 2.0F) {
            break label1457;
          }
          Log.d("MicroMsg.BaseBoxDialogView", "alvinluo computeFullScreenAnimationInfo not need animation");
          this.GXl.GXo = false;
          return;
          if (this.pvr <= 0.0F) {
            break label1588;
          }
          paramInt1 = (int)(this.pvr * paramInt2 - this.pvf);
          break;
          bool1 = false;
          break label440;
          label1125:
          localObject1 = ((MMWebView)localObject1).getLayoutParams();
          if (localObject1 == null)
          {
            paramInt1 = 0;
            break label453;
          }
          paramInt1 = ((ViewGroup.LayoutParams)localObject1).height;
          break label453;
          i = 0;
          break label635;
          paramInt2 = paramInt1;
          if (this.GWZ != null)
          {
            localObject1 = this.GWZ;
            s.checkNotNull(localObject1);
            paramInt2 = paramInt1;
            if (((MMWebView)localObject1).getLayoutParams().height != this.GXh)
            {
              paramInt2 = this.GXh;
              f((View)this.GWZ, this.GXh, true);
            }
          }
          localObject2 = this.puV;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("dialogContainer");
            localObject1 = null;
          }
          if (((View)localObject1).getTranslationY() == this.GXh - this.GXi) {}
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            if (paramInt1 == 0)
            {
              this.pvc = (this.GXh - this.GXi);
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
            break;
          }
          break label848;
          f1 = ((c)localObject1).getMarkViewHeight();
          break label932;
        }
        label1334:
        label1337:
        label1360:
        if (f2 >= this.pvh - paramInt1 / 2.0F - f1 / 2.0F) {}
        for (this.GXk.GXn = (-this.pve);; this.GXk.GXn = (paramInt1 / 2.0F - f1 / 2.0F - this.GXf))
        {
          Log.d("MicroMsg.BaseBoxDialogView", "alvinluo computeHalfScreenAnimationInfo current: %f, target: %f", new Object[] { Float.valueOf(this.GXk.GXm), Float.valueOf(this.GXk.GXn) });
          break;
        }
        label1457:
        if (f2 >= this.pvb / 2.0F - this.pvi / 2.0F)
        {
          this.GXl.GXn = (-this.pvb);
          Log.d("MicroMsg.BaseBoxDialogView", "alvinluo computeFullScreenAnimationInfo start: %f, target: %f", new Object[] { Float.valueOf(this.GXl.GXm), Float.valueOf(this.GXl.GXn) });
          return;
        }
        localObject1 = this.GXc;
        if (localObject1 == null) {}
        for (float f1 = 0.0F;; f1 = ((c)localObject1).getMarkViewHeight())
        {
          this.GXl.GXn = (this.GXk.GXn - f2 - (f1 - this.pvi) / 2.0F);
          break;
        }
      }
      label1157:
      label1588:
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
      if ((this.isAnimating) || (this.pvy) || (this.GXb == null)) {
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
      localObject1 = this.GXb;
      if (localObject1 != null) {
        break label210;
      }
      bool2 = false;
      Log.v("MicroMsg.BaseBoxDialogView", "alvinluo onTouchEvent handle by backgroundListener offsetY: %s, event.y: %s, handled: %s", new Object[] { Float.valueOf(f2 + f1), Float.valueOf(paramMotionEvent.getRawY()), Boolean.valueOf(bool2) });
      bool1 = bool3;
    } while (bool2);
    Log.d("MicroMsg.BaseBoxDialogView", "alvinluo onTouchEvent %s", new Object[] { Integer.valueOf(paramMotionEvent.getAction()) });
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
        if ((this.pvx) && (this.pvB)) {
          c(f2, true);
        } else if (this.pvy) {
          c(f1, false);
        } else {
          Log.v("MicroMsg.BaseBoxDialogView", "alvinluo handleScroll ignore");
        }
      }
    }
    this.puO = 0.0F;
    this.puP = 0.0F;
    Log.i("MicroMsg.BaseBoxDialogView", "alvinluo onTouchUp isExpand: %b, isTouchScrolling: %s, currentEnableTouchScroll: %s", new Object[] { Boolean.valueOf(this.pvv), Boolean.valueOf(this.pvz), Boolean.valueOf(this.pvA) });
    if (this.pvA)
    {
      if (this.pvz) {
        this.pvz = false;
      }
      if (this.pvv) {
        break label628;
      }
      Log.d("MicroMsg.BaseBoxDialogView", "alvinluo onTouchUp canClose: %b, canOpen: %b", new Object[] { Boolean.valueOf(bSz()), Boolean.valueOf(bSA()) });
      if (!bSz()) {
        break label580;
      }
      if (!this.pvx) {
        break label574;
      }
      i = 1;
      label550:
      Vx(i);
    }
    for (;;)
    {
      this.pvx = false;
      this.pvy = false;
      this.pvA = true;
      break;
      label574:
      i = 2;
      break label550;
      label580:
      if (bSA()) {
        break label677;
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
      label628:
      Log.d("MicroMsg.BaseBoxDialogView", "alvinluo onTouchUp canClose: %b", new Object[] { Boolean.valueOf(bSB()) });
      if (!bSB()) {
        break label677;
      }
      if (this.pvx) {
        i = 1;
      }
      Vx(i);
    }
    label677:
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
  
  public final void setBackgroundListener(e parame)
  {
    s.u(parame, "listener");
    this.GXa = parame;
  }
  
  public final void setBackgroundOpView(a parama)
  {
    s.u(parama, "opView");
    this.GXd = parama;
    if ((this.GXd instanceof View))
    {
      parama = this.GWY;
      if (parama != null) {
        parama.removeAllViews();
      }
      parama = this.GWY;
      if (parama != null)
      {
        a locala = this.GXd;
        if (locala == null) {
          throw new NullPointerException("null cannot be cast to non-null type android.view.View");
        }
        parama.addView((View)locala);
      }
      parama = this.GWY;
      if (parama != null) {
        parama.setVisibility(0);
      }
      requestLayout();
    }
    do
    {
      return;
      parama = this.GWY;
    } while (parama == null);
    parama.setVisibility(8);
  }
  
  public final void setBackgroundTouchListener(b paramb)
  {
    s.u(paramb, "listener");
    this.GXb = paramb;
  }
  
  public final void setBackgroundViewModel(c paramc)
  {
    s.u(paramc, "model");
    this.GXc = paramc;
    paramc = this.GXc;
    float f;
    if (paramc == null)
    {
      f = 0.0F;
      this.GXf = f;
      if (this.GXc != null)
      {
        paramc = this.GXc;
        s.checkNotNull(paramc);
        if (paramc.getMarkViewHeight() > this.pvi)
        {
          paramc = this.GXc;
          s.checkNotNull(paramc);
          this.pvi = ((int)paramc.getMarkViewHeight());
        }
      }
      paramc = this.GXc;
      if (paramc != null) {
        break label118;
      }
    }
    label118:
    for (paramc = null;; paramc = Float.valueOf(paramc.getMarkViewTransY()))
    {
      Log.v("MicroMsg.BaseBoxDialogView", "alvinluo setMarkView translationY: %s", new Object[] { paramc });
      return;
      f = paramc.getMarkViewTransY();
      break;
    }
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
  
  public final void setEnableDialogScroll(boolean paramBoolean)
  {
    this.pvB = paramBoolean;
  }
  
  public final void setEnableScrollRightClose(boolean paramBoolean)
  {
    this.pvC = paramBoolean;
  }
  
  public final void setEnableWebViewScroll(boolean paramBoolean)
  {
    RelativeInterceptScrollLayout localRelativeInterceptScrollLayout2 = this.GWX;
    RelativeInterceptScrollLayout localRelativeInterceptScrollLayout1 = localRelativeInterceptScrollLayout2;
    if (localRelativeInterceptScrollLayout2 == null)
    {
      s.bIx("webViewContainer");
      localRelativeInterceptScrollLayout1 = null;
    }
    localRelativeInterceptScrollLayout1.setEnableScroll(paramBoolean);
  }
  
  public final void setFixDialogHeight(int paramInt)
  {
    Log.v("MicroMsg.BaseBoxDialogView", "alvinluo setFixDialogHeight: %d", new Object[] { Integer.valueOf(paramInt) });
    this.pvp = paramInt;
  }
  
  public final void setFixDialogHeightRate(float paramFloat)
  {
    Log.v("MicroMsg.BaseBoxDialogView", "alvinluo setFixDialogHeightRate: %s", new Object[] { Float.valueOf(paramFloat) });
    this.pvr = paramFloat;
  }
  
  public final void setIsFixDialogHeight(boolean paramBoolean)
  {
    this.pvo = paramBoolean;
  }
  
  public final void setMinDialogHeight(int paramInt)
  {
    Log.v("MicroMsg.BaseBoxDialogView", "setMinHeight: %d", new Object[] { Integer.valueOf(paramInt) });
    this.GXi = paramInt;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/webview/BaseBoxDialogView$AnimationInfo;", "", "(Lcom/tencent/mm/plugin/finder/webview/BaseBoxDialogView;)V", "bgViewEndTranslationY", "", "getBgViewEndTranslationY", "()F", "setBgViewEndTranslationY", "(F)V", "bgViewNeedAnimation", "", "getBgViewNeedAnimation", "()Z", "setBgViewNeedAnimation", "(Z)V", "bgViewStartTranslationY", "getBgViewStartTranslationY", "setBgViewStartTranslationY", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  final class a
  {
    float GXm;
    float GXn;
    boolean GXo;
    
    public a()
    {
      AppMethodBeat.i(334502);
      AppMethodBeat.o(334502);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/webview/BaseBoxDialogView$animateDialogVerticalTranslation$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements Animator.AnimatorListener
  {
    c(BaseBoxDialogView paramBaseBoxDialogView, boolean paramBoolean) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(334539);
      BaseBoxDialogView.a(this.GXp, paramBoolean);
      BaseBoxDialogView localBaseBoxDialogView = this.GXp;
      Object localObject = BaseBoxDialogView.d(this.GXp);
      paramAnimator = (Animator)localObject;
      if (localObject == null)
      {
        s.bIx("dialogContainer");
        paramAnimator = null;
      }
      BaseBoxDialogView.c(localBaseBoxDialogView, paramAnimator.getTranslationY());
      paramAnimator = this.GXp;
      localObject = BaseBoxDialogView.e(this.GXp);
      float f;
      if (localObject == null)
      {
        f = 0.0F;
        BaseBoxDialogView.d(paramAnimator, f);
        paramAnimator = this.GXp;
        if (!paramBoolean) {
          break label117;
        }
      }
      label117:
      for (int i = 2;; i = 1)
      {
        BaseBoxDialogView.a(paramAnimator, i);
        AppMethodBeat.o(334539);
        return;
        f = ((c)localObject).getBackgroundTransY();
        break;
      }
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/webview/BaseBoxDialogView$dismiss$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements Animator.AnimatorListener
  {
    d(BaseBoxDialogView paramBaseBoxDialogView, int paramInt) {}
    
    private static final void b(BaseBoxDialogView paramBaseBoxDialogView, int paramInt)
    {
      AppMethodBeat.i(334528);
      s.u(paramBaseBoxDialogView, "this$0");
      BaseBoxDialogView.c(paramBaseBoxDialogView);
      AppMethodBeat.o(334528);
    }
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(334557);
      BaseBoxDialogView.a(this.GXp);
      AppMethodBeat.o(334557);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(334549);
      BaseBoxDialogView.a(this.GXp);
      BaseBoxDialogView.a(this.GXp, 0);
      BaseBoxDialogView.b(this.GXp);
      MMHandlerThread.postToMainThread(new BaseBoxDialogView.d..ExternalSyntheticLambda0(this.GXp, paramInt));
      AppMethodBeat.o(334549);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(334563);
      BaseBoxDialogView.b(this.GXp);
      AppMethodBeat.o(334563);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/webview/BaseBoxDialogView$dismiss$2", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "onAnimationUpdate", "", "animation", "Landroid/animation/ValueAnimator;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements ValueAnimator.AnimatorUpdateListener
  {
    e(BaseBoxDialogView paramBaseBoxDialogView, float paramFloat) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(334544);
      BaseBoxDialogView localBaseBoxDialogView = this.GXp;
      View localView2 = BaseBoxDialogView.d(this.GXp);
      View localView1 = localView2;
      if (localView2 == null)
      {
        s.bIx("dialogContainer");
        localView1 = null;
      }
      BaseBoxDialogView.a(localBaseBoxDialogView, localView1.getTranslationY());
      if (paramValueAnimator == null)
      {
        AppMethodBeat.o(334544);
        return;
      }
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(334544);
        throw paramValueAnimator;
      }
      float f1 = ((Float)paramValueAnimator).floatValue();
      float f2 = f1;
      float f3 = this.GXr;
      float f4 = f1;
      BaseBoxDialogView.b(this.GXp, f1 * (f3 - f4) + f2);
      AppMethodBeat.o(334544);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.webview.BaseBoxDialogView
 * JD-Core Version:    0.7.0.1
 */