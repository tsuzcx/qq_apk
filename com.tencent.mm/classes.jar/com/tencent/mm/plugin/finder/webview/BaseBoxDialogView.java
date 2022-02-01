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
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.widget.MMWebView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/webview/BaseBoxDialogView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animator", "Landroid/animation/ValueAnimator;", "backgroundListener", "Lcom/tencent/mm/plugin/finder/webview/BoxDialogMoveListener;", "backgroundOpContainer", "Landroid/widget/LinearLayout;", "backgroundOpView", "Lcom/tencent/mm/plugin/finder/webview/BoxDialogBackgroundOpViewModel;", "backgroundTouchListener", "Lcom/tencent/mm/plugin/finder/webview/BoxDialogBackgroundTouchListener;", "backgroundViewModel", "Lcom/tencent/mm/plugin/finder/webview/BoxDialogBackgroundViewModel;", "bgViewCurrentTranslationY", "", "boxWebView", "Lcom/tencent/mm/ui/widget/MMWebView;", "canMeasured", "", "closeButton", "Landroid/view/View;", "closeButtonLayoutHeight", "currentEnableTouchScroll", "dialog", "Lcom/tencent/mm/plugin/finder/webview/BoxDialogModel;", "dialogBg", "dialogContainer", "dialogContainerCurrentTranslationY", "dialogContainerHalfTranslationY", "dialogContainerHeight", "dialogContainerMinTranslationY", "dialogState", "enableCancelOutSide", "enableScrollRightClose", "enableScrollVertical", "fixedDialogHeight", "fixedDialogHeightRate", "fixedWebViewHeight", "fullScreenAnimationInfo", "Lcom/tencent/mm/plugin/finder/webview/BaseBoxDialogView$AnimationInfo;", "halfScreenAnimationInfo", "isAnimating", "isAtWebViewTop", "isExpand", "isFixedDialogHeight", "isShowing", "isTouchScrolling", "lastOrientation", "mDownX", "mDownY", "mInterceptTracker", "Landroid/view/VelocityTracker;", "mInterceptXDown", "mInterceptYDown", "mStatusBarHeight", "mTopEmptyHeight", "markViewOriginTranslationY", "maxWebViewHeight", "minWebViewHeight", "moveOffsetXFactor", "moveOffsetY", "navigationBarHeight", "screenHeight", "scrollingHorizontal", "scrollingVertical", "showAnimationInterpolator", "Landroid/view/animation/DecelerateInterpolator;", "topExtraHeight", "webViewContainer", "Lcom/tencent/mm/plugin/finder/webview/BoxWebViewContainer;", "webViewScrollHeight", "windowVisibleHeight", "animateDialogVerticalTranslation", "", "fromTranslationY", "targetTranslationY", "duration", "", "switchToFullScreen", "animateShowBackground", "attachDialog", "dialogModel", "attachWebView", "webView", "canCloseWhenFullScreen", "canCloseWhenHalfScreen", "canOpenWhenHalfScreen", "computeAnimationInfo", "computeFixedWebViewHeight", "dialogHeight", "computeFullScreenAnimationInfo", "computeHalfScreenAnimationInfo", "computeTargetValueByRef", "refStart", "refEnd", "refCurrent", "targetStart", "targetEnd", "dismiss", "exitType", "getCloseButton", "root", "getCloseLayoutHeight", "getLayoutId", "getMaxTranslationY", "getMoveDistanceByOffsetX", "offsetX", "getMoveDistanceByOffsetY", "offsetY", "handleScroll", "offset", "vertical", "init", "initBackgroundOpView", "initDialogBg", "initMoveOffsetXFactor", "initWebViewHeight", "initWindowVisibleHeight", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreateView", "view", "onDialogContainerTranslationYChanged", "transY", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onPause", "onResume", "onTouchEvent", "onTouchUp", "setBackgroundListener", "listener", "setBackgroundOpView", "opView", "setBackgroundTouchListener", "setBackgroundTranslationY", "setBackgroundViewModel", "model", "setCanceledOnTouchOutside", "cancel", "setEnableDialogScroll", "enableScroll", "setEnableScrollRightClose", "setEnableWebViewScroll", "setFixDialogHeight", "fixedHeight", "setFixDialogHeightRate", "rate", "setIsFixDialogHeight", "fixed", "setMinDialogHeight", "minHeight", "show", "switchToHalfScreen", "updateDialogContainerTranslationY", "updateLayoutHeight", "layout", "targetHeight", "needRequestLayout", "AnimationInfo", "Companion", "plugin-finder_release"})
public abstract class BaseBoxDialogView
  extends RelativeLayout
{
  public static final b BqO = new b((byte)0);
  private float BpS;
  private float BpT;
  private float BpU;
  private VelocityTracker BpV;
  private d BpW;
  private View BpX;
  private View BpY;
  private BoxWebViewContainer BpZ;
  private float BqA = 1.0F;
  private boolean BqB;
  private boolean BqC = true;
  private boolean BqD;
  private boolean BqE;
  private boolean BqF;
  private boolean BqG = true;
  private boolean BqH = true;
  private boolean BqI;
  private boolean BqJ = true;
  private a BqK = new a();
  private a BqL = new a();
  private final DecelerateInterpolator BqM = new DecelerateInterpolator();
  private int BqN;
  private View Bqa;
  private LinearLayout Bqb;
  private MMWebView Bqc;
  private e Bqd;
  private b Bqe;
  private c Bqf;
  private a Bqg;
  private float Bqh;
  private float Bqi;
  private int Bqj;
  private float Bqk;
  private float Bql;
  private float Bqm;
  private int Bqn;
  private int Bqo;
  private int Bqp;
  private int Bqq;
  private boolean Bqr = true;
  private int Bqs;
  private int Bqt;
  private int Bqu;
  private boolean Bqv;
  private int Bqw;
  private int Bqx;
  private float Bqy;
  private float Bqz;
  private final ValueAnimator animator = new ValueAnimator();
  private boolean dic;
  private boolean isAnimating;
  private int lastOrientation;
  private int mStatusBarHeight;
  private int pEk;
  private int qoA;
  private float rpT;
  
  public BaseBoxDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BaseBoxDialogView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setFitsSystemWindows(true);
    paramAttributeSet = getResources();
    p.j(paramAttributeSet, "resources");
    this.lastOrientation = paramAttributeSet.getConfiguration().orientation;
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(getLayoutId(), (ViewGroup)this, true);
    p.j(paramAttributeSet, "view");
    p.k(paramAttributeSet, "view");
    View localView = paramAttributeSet.findViewById(b.f.dialog_container);
    p.j(localView, "view.findViewById(R.id.dialog_container)");
    this.BpY = localView;
    localView = paramAttributeSet.findViewById(b.f.dialog_bg);
    p.j(localView, "view.findViewById(R.id.dialog_bg)");
    this.BpX = localView;
    localView = paramAttributeSet.findViewById(b.f.webview_container);
    p.j(localView, "view.findViewById(R.id.webview_container)");
    this.BpZ = ((BoxWebViewContainer)localView);
    this.Bqa = eW(paramAttributeSet);
    this.Bqb = ((LinearLayout)paramAttributeSet.findViewById(b.f.background_op_container));
    paramAttributeSet = this.Bqb;
    if (paramAttributeSet != null) {
      paramAttributeSet.setVisibility(8);
    }
    this.qoA = ax.aB(paramContext);
    elB();
    paramAttributeSet = this.Bqa;
    if (paramAttributeSet == null) {
      p.bGy("closeButton");
    }
    paramAttributeSet.setOnClickListener((View.OnClickListener)new g(this));
    this.mStatusBarHeight = ax.getStatusBarHeight(paramContext);
    this.pEk = (com.tencent.mm.ci.a.ks(paramContext) + this.mStatusBarHeight);
    this.Bqn = getCloseLayoutHeight();
    this.Bqp = com.tencent.mm.ci.a.fromDPToPix(paramContext, 50);
    Log.i("MicroMsg.BaseBoxDialogView", "alvinluo initBoxDialogView orientation: %s, getScreenHeight: %d, statusBarHeight: %d, topEmptyHeight: %d", new Object[] { Integer.valueOf(this.lastOrientation), Integer.valueOf(this.pEk), Integer.valueOf(this.mStatusBarHeight), Integer.valueOf(this.Bqp) });
    paramContext = this.BpY;
    if (paramContext == null) {
      p.bGy("dialogContainer");
    }
    paramContext.setTranslationY(this.pEk);
    elC();
  }
  
  private static float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    return 1.0F * (paramFloat3 - paramFloat1) / (paramFloat2 - paramFloat1) * (paramFloat5 - paramFloat4) + paramFloat4;
  }
  
  private final void bn(float paramFloat)
  {
    View localView = this.BpY;
    if (localView == null) {
      p.bGy("dialogContainer");
    }
    localView.setTranslationY(paramFloat);
    bo(paramFloat);
  }
  
  private final void bo(float paramFloat)
  {
    Object localObject = this.Bqb;
    int i;
    if (localObject != null)
    {
      a locala = this.Bqg;
      if (locala != null)
      {
        i = locala.getVieHeight();
        ((LinearLayout)localObject).setTranslationY(paramFloat - i);
      }
    }
    else
    {
      i = this.Bqj;
      localObject = this.Bqg;
      if (localObject == null) {
        break label97;
      }
    }
    label97:
    for (localObject = Integer.valueOf(((a)localObject).getVieHeight());; localObject = null)
    {
      Log.v("MicroMsg.BaseBoxDialogView", "alvinluo onDialogContainerTranslationYChanged: %f, dialogHeight: %s, backgroundOpViewHeight: %s", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(i), localObject });
      return;
      i = 0;
      break;
    }
  }
  
  private final void c(float paramFloat, boolean paramBoolean)
  {
    if (!this.BqG) {}
    label125:
    do
    {
      return;
      if (!this.BqF) {
        this.BqF = true;
      }
      localObject = this.Bqc;
      int i;
      if (localObject != null)
      {
        i = ((MMWebView)localObject).getScrollHeight();
        this.Bqs = i;
        if ((!elD()) || (this.Bqt <= this.Bqx)) {
          break label300;
        }
        i = Math.max(this.Bqx, this.Bqu);
        Log.d("MicroMsg.BaseBoxDialogView", "alvinluo handleScroll fixedWebViewHeight: %d, target: %d", new Object[] { Integer.valueOf(this.Bqx), Integer.valueOf(i) });
        this.Bql = Math.max(this.Bql, this.Bqt - i);
        if (!paramBoolean) {
          break label377;
        }
      }
      for (float f1 = 0.68F * paramFloat;; f1 = 0.85F * paramFloat)
      {
        float f2 = this.Bqk;
        f2 = Math.max(this.Bql, f2 + f1);
        f2 = Math.min(this.Bqj, f2);
        Log.d("MicroMsg.BaseBoxDialogView", "alvinluo handleScroll vertical: %b, offset: %f, moveDis: %f, currentTranslationY: %f, targetTranslationY: %f, minTranslationY: %f", new Object[] { Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat), Float.valueOf(f1), Float.valueOf(this.Bqk), Float.valueOf(f2), Float.valueOf(this.Bql) });
        this.Bqz = f1;
        bn(f2);
        if (f1 < 0.0F) {
          break label386;
        }
        paramFloat = this.Bqk;
        f1 = this.Bqj;
        localObject = this.BpY;
        if (localObject == null) {
          p.bGy("dialogContainer");
        }
        setBackgroundTranslationY(a(paramFloat, f1, ((View)localObject).getTranslationY(), this.Bqh, 0.0F));
        return;
        i = 0;
        break;
        if (this.Bqt <= this.Bqs) {
          break label125;
        }
        i = Math.max(this.Bqs, this.Bqu);
        Log.d("MicroMsg.BaseBoxDialogView", "alvinluo handleScroll webViewScrollHeight: %d, target: %d", new Object[] { Integer.valueOf(this.Bqs), Integer.valueOf(i) });
        this.Bql = Math.max(this.Bql, this.Bqt - i);
        break label125;
      }
    } while (this.Bqk <= 0.0F);
    label300:
    label377:
    paramFloat = this.Bqk;
    label386:
    Object localObject = this.BpY;
    if (localObject == null) {
      p.bGy("dialogContainer");
    }
    setBackgroundTranslationY(a(paramFloat, 0.0F, ((View)localObject).getTranslationY(), this.BqL.BqP, this.BqL.BqQ));
  }
  
  private final void d(View paramView, int paramInt, boolean paramBoolean)
  {
    ViewGroup.LayoutParams localLayoutParams;
    if (paramView != null)
    {
      localLayoutParams = paramView.getLayoutParams();
      if (localLayoutParams == null) {
        break label48;
      }
      localLayoutParams.height = paramInt;
    }
    for (;;)
    {
      paramView.setLayoutParams(localLayoutParams);
      if (paramBoolean) {
        post((Runnable)new i(paramView));
      }
      return;
      label48:
      localLayoutParams = null;
    }
  }
  
  private final void elB()
  {
    View localView = this.BpX;
    if (localView == null) {
      p.bGy("dialogBg");
    }
    localView.setOnClickListener((View.OnClickListener)new h(this));
  }
  
  private final void elC()
  {
    if ((getContext() instanceof Activity))
    {
      Rect localRect = new Rect();
      Object localObject = getContext();
      if (localObject == null) {
        throw new t("null cannot be cast to non-null type android.app.Activity");
      }
      localObject = ((Activity)localObject).getWindow();
      if (localObject != null)
      {
        localObject = ((Window)localObject).getDecorView();
        if (localObject != null) {
          ((View)localObject).getWindowVisibleDisplayFrame(localRect);
        }
      }
      this.Bqo = localRect.height();
      Log.i("MicroMsg.BaseBoxDialogView", "alvinluo initWindowVisibleHeight: %s, height: %d, windowVisibleHeight: %d, navigationBarHeight: %d", new Object[] { localRect, Integer.valueOf(localRect.height()), Integer.valueOf(this.Bqo), Integer.valueOf(this.qoA) });
    }
  }
  
  private final boolean elD()
  {
    return (this.Bqv) && ((this.Bqw > 0) || (this.Bqy > 0.0F));
  }
  
  private final boolean elE()
  {
    return (this.Bqz > 0.0F) && (Math.abs(this.Bqz) >= this.Bqt * 0.15F);
  }
  
  private final boolean elF()
  {
    return (this.Bqz < 0.0F) && (Math.abs(this.Bqz) >= this.Bqt * 0.05F);
  }
  
  private final boolean elG()
  {
    return (this.Bqz > 0.0F) && (Math.abs(this.Bqz) >= this.Bqt * 0.15F);
  }
  
  private final void f(final float paramFloat1, final float paramFloat2, final boolean paramBoolean)
  {
    Log.v("MicroMsg.BaseBoxDialogView", "alvinluo animateDialogVerticalTranslation from: %f, to: %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    if (paramFloat1 == paramFloat2)
    {
      Log.w("MicroMsg.BaseBoxDialogView", "alvinluo animateDialogVerticalTranslation start equals end and ignore");
      return;
    }
    Object localObject = this.Bqf;
    if (localObject != null) {}
    for (final float f = ((c)localObject).getBackgroundTransY();; f = 0.0F)
    {
      localObject = ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 });
      p.j(localObject, "animator");
      ((ValueAnimator)localObject).setInterpolator((TimeInterpolator)new DecelerateInterpolator());
      ((ValueAnimator)localObject).setDuration(200L);
      ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new c(this, paramBoolean, paramFloat1, paramFloat2, f));
      ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new d(this, paramBoolean));
      ((ValueAnimator)localObject).start();
      return;
    }
  }
  
  private final int getMaxTranslationY()
  {
    return this.Bqj;
  }
  
  private final void setBackgroundTranslationY(float paramFloat)
  {
    Log.v("MicroMsg.BaseBoxDialogView", "alvinluo setBackgroundTranslationY: %f", new Object[] { Float.valueOf(paramFloat) });
  }
  
  public final void Se(final int paramInt)
  {
    float f2 = getMaxTranslationY();
    Object localObject = this.Bqf;
    if (localObject != null) {}
    for (final float f1 = ((c)localObject).getBackgroundTransY();; f1 = 0.0F)
    {
      this.isAnimating = true;
      this.dic = false;
      localObject = this.BpY;
      if (localObject == null) {
        p.bGy("dialogContainer");
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
              localObject = ((ViewPropertyAnimator)localObject).setListener((Animator.AnimatorListener)new e(this, paramInt));
              if (localObject != null)
              {
                localObject = ((ViewPropertyAnimator)localObject).setUpdateListener((ValueAnimator.AnimatorUpdateListener)new f(this, f1));
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
  
  public abstract View eW(View paramView);
  
  public abstract int getCloseLayoutHeight();
  
  public abstract int getLayoutId();
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (paramConfiguration != null) {}
    for (Integer localInteger = Integer.valueOf(paramConfiguration.orientation);; localInteger = null)
    {
      Log.i("MicroMsg.BaseBoxDialogView", "alvinluo onConfigurationChanged newConfig orientation: %s, last: %s", new Object[] { localInteger, Integer.valueOf(this.lastOrientation) });
      int i = this.lastOrientation;
      if ((paramConfiguration == null) || (i != paramConfiguration.orientation)) {
        elC();
      }
      return;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = false;
    boolean bool2;
    if (paramMotionEvent != null)
    {
      localObject = Integer.valueOf(paramMotionEvent.getAction());
      Log.d("MicroMsg.BaseBoxDialogView", "alvinluo onInterceptTouchEvent %s", new Object[] { localObject });
      bool2 = super.onInterceptTouchEvent(paramMotionEvent);
      if (!bool2) {
        break label59;
      }
      bool1 = bool2;
    }
    label59:
    while (paramMotionEvent == null)
    {
      return bool1;
      localObject = null;
      break;
    }
    if (this.BpV == null) {
      this.BpV = VelocityTracker.obtain();
    }
    Object localObject = this.BpV;
    if (localObject == null) {
      p.iCn();
    }
    ((VelocityTracker)localObject).addMovement(paramMotionEvent);
    localObject = this.BpV;
    if (localObject == null) {
      p.iCn();
    }
    ((VelocityTracker)localObject).computeCurrentVelocity(1000);
    localObject = this.BpV;
    if (localObject == null) {
      p.iCn();
    }
    int i = (int)((VelocityTracker)localObject).getXVelocity();
    localObject = this.BpV;
    if (localObject == null) {
      p.iCn();
    }
    int j = (int)((VelocityTracker)localObject).getYVelocity();
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      bool1 = false;
    }
    for (;;)
    {
      Log.v("MicroMsg.BaseBoxDialogView", "alvinluo onInterceptTouchEvent enableScrollVertical: %b, action: %s, isIntercept: %b, scrollingVertical: %b, scrollingHorizontal: %b", new Object[] { Boolean.valueOf(this.BqH), Integer.valueOf(paramMotionEvent.getAction()), Boolean.valueOf(bool1), Boolean.valueOf(this.BqD), Boolean.valueOf(this.BqE) });
      return bool1;
      float f1 = paramMotionEvent.getRawX();
      float f2 = paramMotionEvent.getRawY();
      localObject = this.BpY;
      if (localObject == null) {
        p.bGy("dialogContainer");
      }
      Log.d("MicroMsg.BaseBoxDialogView", "alvinluo onInterceptTouchEvent down: %f, %f, dialogContainer translationY: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(((View)localObject).getTranslationY()) });
      this.BpT = paramMotionEvent.getRawX();
      this.BpU = paramMotionEvent.getRawY();
      bool1 = false;
      continue;
      f1 = paramMotionEvent.getRawX() - this.BpT;
      f2 = paramMotionEvent.getRawY() - this.BpU;
      Log.d("MicroMsg.BaseBoxDialogView", "alvinluo onInterceptTouchEvent action_move tx: %f, ty: %f, velocityX: %d, velocityY: %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
      float f3 = paramMotionEvent.getRawY();
      localObject = this.BpY;
      if (localObject == null) {
        p.bGy("dialogContainer");
      }
      if (f3 >= ((View)localObject).getTranslationY())
      {
        if ((Math.abs(f2) >= 5.0F) && (this.BqH) && (Math.abs(f1) <= 250.0F) && (Math.abs(j) > Math.abs(i)) && (Math.abs(j) > 0) && (Math.abs(f2) > Math.abs(f1)))
        {
          Log.i("MicroMsg.BaseBoxDialogView", "alvinluo ViewPager onInterceptTouchEvent action: %d, dialogContainerCurrentTranslationY: %s", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Float.valueOf(this.Bqk) });
          if (this.Bqk <= this.Bql) {
            if (this.BqC) {
              if (f2 >= 0.0F) {
                bool2 = true;
              }
            }
          }
          for (;;)
          {
            bool1 = bool2;
            if (!bool2) {
              break;
            }
            this.BqD = true;
            bool1 = bool2;
            break;
            bool2 = false;
            continue;
            bool2 = false;
            continue;
            bool2 = true;
          }
        }
        if (!this.BqI) {
          break;
        }
        if ((Math.abs(i) > Math.abs(j)) && (f1 > 0.0F) && (Math.abs(f1) > Math.abs(f2)) && (this.BpT <= 20.0F)) {}
        for (bool2 = true;; bool2 = false)
        {
          Log.d("MicroMsg.BaseBoxDialogView", "alvinluo onInterceptTouchEvent interceptXDown: %f, scrollLeftRight: %b", new Object[] { Float.valueOf(this.BpT), Boolean.valueOf(bool2) });
          bool1 = bool2;
          if (!bool2) {
            break;
          }
          this.BqE = true;
          bool1 = bool2;
          break;
        }
      }
      bool1 = false;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    float f3 = 0.0F;
    super.onMeasure(paramInt1, paramInt2);
    if (this.Bqo == 0) {
      elC();
    }
    Object localObject1 = this.BpY;
    if (localObject1 == null) {
      p.bGy("dialogContainer");
    }
    boolean bool2;
    boolean bool1;
    if ((((View)localObject1).getMeasuredHeight() != this.Bqj) && (this.Bqr))
    {
      localObject1 = this.BpY;
      if (localObject1 == null) {
        p.bGy("dialogContainer");
      }
      this.Bqj = ((View)localObject1).getMeasuredHeight();
      paramInt1 = Math.max(0, this.Bqo - this.Bqj);
      this.Bqq = Math.max(0, this.Bqp - paramInt1);
      if (elD())
      {
        localObject1 = getContext();
        p.j(localObject1, "context");
        this.Bqq = ((Context)localObject1).getResources().getDimensionPixelSize(b.d.Edge_A);
      }
      this.Bqt = (this.Bqj - this.Bqn - this.Bqq);
      Log.v("MicroMsg.BaseBoxDialogView", "alvinluo onMeasure dialogContainerHeight: %d, extraHeight: %d, diff: %d, fixedDialogHeight: %b", new Object[] { Integer.valueOf(this.Bqj), Integer.valueOf(this.Bqq), Integer.valueOf(paramInt1), Boolean.valueOf(elD()) });
      if (this.Bqu == 0) {
        this.Bqu = (this.Bqo / 2 - this.Bqn);
      }
      localObject1 = this.BpX;
      if (localObject1 == null) {
        p.bGy("dialogBg");
      }
      Object localObject2 = this.BpX;
      if (localObject2 == null) {
        p.bGy("dialogBg");
      }
      localObject2 = ((View)localObject2).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).height = (this.Bqo / 2);
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      bool2 = elD();
      bool1 = bool2;
      if (bool2)
      {
        paramInt2 = this.Bqj;
        if (this.Bqw <= 0) {
          break label1053;
        }
        paramInt1 = this.Bqw - this.Bqn;
      }
    }
    for (;;)
    {
      paramInt1 = Math.min(this.Bqt, paramInt1);
      Log.v("MicroMsg.BaseBoxDialogView", "alvinluo computeFixedWebViewHeight dialogHeight: %s, fixedDialogHeight: %s, fixedDiaogHeightRate: %s, fixedWebViewHeight: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(this.Bqw), Float.valueOf(this.Bqy), Integer.valueOf(paramInt1), Integer.valueOf(paramInt1) });
      this.Bqx = paramInt1;
      if (this.Bqx > 0)
      {
        this.Bqu = this.Bqx;
        bool1 = bool2;
        label419:
        localObject1 = this.Bqc;
        if (localObject1 == null) {
          break label1086;
        }
        localObject1 = ((MMWebView)localObject1).getLayoutParams();
        if (localObject1 == null) {
          break label1086;
        }
        paramInt1 = ((ViewGroup.LayoutParams)localObject1).height;
        label448:
        if (!bool1) {
          break label1091;
        }
        if (this.Bqc == null) {
          break label1480;
        }
        localObject1 = this.Bqc;
        if (localObject1 == null) {
          p.iCn();
        }
        if (((MMWebView)localObject1).getLayoutParams().height == this.Bqx) {
          break label1480;
        }
        paramInt1 = this.Bqx;
        d((View)this.Bqc, this.Bqx, false);
      }
      label670:
      label1086:
      label1091:
      label1480:
      for (;;)
      {
        localObject1 = this.BpZ;
        if (localObject1 == null) {
          p.bGy("webViewContainer");
        }
        if (((BoxWebViewContainer)localObject1).getLayoutParams().height != this.Bqt)
        {
          localObject1 = this.BpZ;
          if (localObject1 == null) {
            p.bGy("webViewContainer");
          }
          d((View)localObject1, this.Bqt, true);
        }
        localObject1 = this.BpY;
        if (localObject1 == null) {
          p.bGy("dialogContainer");
        }
        paramInt2 = paramInt1;
        if (((View)localObject1).getTranslationY() != this.Bqt - this.Bqx)
        {
          this.Bqk = (this.Bqt - this.Bqx);
          this.Bqm = this.Bqk;
          paramInt2 = paramInt1;
          if (this.dic)
          {
            localObject1 = this.BpY;
            if (localObject1 == null) {
              p.bGy("dialogContainer");
            }
            ((View)localObject1).setTranslationY(this.Bqk);
            paramInt2 = paramInt1;
          }
        }
        paramInt1 = this.Bqt;
        int i = this.Bqu;
        localObject1 = this.BpY;
        if (localObject1 == null) {
          p.bGy("dialogContainer");
        }
        Log.i("MicroMsg.BaseBoxDialogView", "alvinluo initWebViewHeight maxWebViewHeight: %d, minWebVieHeight: %d, translationY: %s, dialogContainerCurrentTranslationY: %s, fixedDialog: %b, fixedWebViewHeight: %s, currentWebViewHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i), Float.valueOf(((View)localObject1).getTranslationY()), Float.valueOf(this.Bqk), Boolean.valueOf(bool1), Integer.valueOf(this.Bqx), Integer.valueOf(paramInt2) });
        paramInt1 = com.tencent.mm.ci.a.kr(getContext());
        localObject1 = this.BpY;
        if (localObject1 == null) {
          p.bGy("dialogContainer");
        }
        this.BqA = (((View)localObject1).getMeasuredHeight() / (paramInt1 * 0.5F));
        Log.d("MicroMsg.BaseBoxDialogView", "alvinluo initMoveOffsetXFactor %f", new Object[] { Float.valueOf(this.BqA) });
        this.BqK.BqP = 0.0F;
        this.BqK.BqR = true;
        paramInt1 = this.Bqo - this.Bqu - this.Bqn;
        localObject1 = this.Bqf;
        float f1;
        if (localObject1 != null)
        {
          f1 = ((c)localObject1).getMarkViewHeight();
          label889:
          localObject1 = this.Bqf;
          if (localObject1 == null) {
            break label1251;
          }
        }
        label1251:
        for (float f2 = ((c)localObject1).getMarkViewTransY();; f2 = 0.0F)
        {
          Log.i("MicroMsg.BaseBoxDialogView", "alvinluo computeHalfScreenAnimationInfo temp: %f, %f, markViewTransY: %f", new Object[] { Float.valueOf(paramInt1 / 2.0F), Float.valueOf(this.Bqo / 4.0F), Float.valueOf(f2) });
          if (f2 > paramInt1 / 2.0F - f1 / 2.0F) {
            break label1257;
          }
          Log.d("MicroMsg.BaseBoxDialogView", "alvinluo computeHalfScreenAnimationInfo not need animation");
          this.BqK.BqR = false;
          this.BqL.BqR = true;
          this.BqL.BqP = this.BqK.BqQ;
          f2 = this.BqK.BqQ + this.Bqi;
          if (f2 > this.Bqp / 2.0F) {
            break label1354;
          }
          Log.d("MicroMsg.BaseBoxDialogView", "alvinluo computeFullScreenAnimationInfo not need animation");
          this.BqL.BqR = false;
          return;
          if (this.Bqy <= 0.0F) {
            break label1483;
          }
          paramInt1 = (int)(this.Bqy * paramInt2 - this.Bqn);
          break;
          bool1 = false;
          break label419;
          paramInt1 = 0;
          break label448;
          paramInt2 = paramInt1;
          if (this.Bqc != null)
          {
            localObject1 = this.Bqc;
            if (localObject1 == null) {
              p.iCn();
            }
            paramInt2 = paramInt1;
            if (((MMWebView)localObject1).getLayoutParams().height != this.Bqt)
            {
              paramInt2 = this.Bqt;
              d((View)this.Bqc, this.Bqt, true);
            }
          }
          localObject1 = this.BpY;
          if (localObject1 == null) {
            p.bGy("dialogContainer");
          }
          if (((View)localObject1).getTranslationY() != this.Bqt - this.Bqu)
          {
            this.Bqk = (this.Bqt - this.Bqu);
            this.Bqm = this.Bqk;
            if (this.dic)
            {
              localObject1 = this.BpY;
              if (localObject1 == null) {
                p.bGy("dialogContainer");
              }
              ((View)localObject1).setTranslationY(this.Bqk);
            }
          }
          break label670;
          f1 = 0.0F;
          break label889;
        }
        label1257:
        if (f2 >= this.Bqo - paramInt1 / 2.0F - f1 / 2.0F) {}
        for (this.BqK.BqQ = (-this.Bqm);; this.BqK.BqQ = (paramInt1 / 2.0F - f1 / 2.0F - this.Bqi))
        {
          Log.d("MicroMsg.BaseBoxDialogView", "alvinluo computeHalfScreenAnimationInfo current: %f, target: %f", new Object[] { Float.valueOf(this.BqK.BqP), Float.valueOf(this.BqK.BqQ) });
          break;
        }
        label1354:
        if (f2 >= this.Bqj / 2.0F - this.Bqp / 2.0F) {}
        for (this.BqL.BqQ = (-this.Bqj);; this.BqL.BqQ = (this.BqK.BqQ - f2 - (f1 - this.Bqp) / 2.0F))
        {
          Log.d("MicroMsg.BaseBoxDialogView", "alvinluo computeFullScreenAnimationInfo start: %f, target: %f", new Object[] { Float.valueOf(this.BqL.BqP), Float.valueOf(this.BqL.BqQ) });
          return;
          localObject1 = this.Bqf;
          f1 = f3;
          if (localObject1 != null) {
            f1 = ((c)localObject1).getMarkViewHeight();
          }
        }
      }
      label1053:
      label1483:
      paramInt1 = 0;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 2;
    boolean bool3 = true;
    boolean bool1;
    if (paramMotionEvent == null) {
      bool1 = super.onTouchEvent(paramMotionEvent);
    }
    Object localObject;
    float f1;
    float f2;
    boolean bool2;
    label90:
    do
    {
      return bool1;
      if ((this.isAnimating) || (this.BqE) || (this.Bqe == null)) {
        break;
      }
      localObject = this.BpY;
      if (localObject == null) {
        p.bGy("dialogContainer");
      }
      f1 = ((View)localObject).getTranslationY();
      f2 = this.Bqq;
      localObject = this.Bqe;
      if (localObject == null) {
        break label202;
      }
      bool2 = ((b)localObject).elH();
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
        label202:
        bool2 = false;
        break label90;
        this.BpS = paramMotionEvent.getRawX();
        this.rpT = paramMotionEvent.getRawY();
        bool1 = bool3;
        if (!this.isAnimating) {
          break;
        }
        this.BqG = false;
        return true;
        if (this.isAnimating) {
          this.BqG = false;
        }
        if ((this.BpS == 0.0F) && (this.rpT == 0.0F))
        {
          this.BpS = paramMotionEvent.getRawX();
          this.rpT = paramMotionEvent.getRawY();
        }
        else
        {
          f1 = paramMotionEvent.getRawX() - this.BpS;
          f2 = paramMotionEvent.getRawY() - this.rpT;
          if (Math.abs(f2) > Math.abs(f1)) {
            this.BqD = true;
          }
          if ((this.BqD) && (this.BqH)) {
            c(f2, true);
          } else if (this.BqE) {
            c(f1, false);
          } else {
            Log.v("MicroMsg.BaseBoxDialogView", "alvinluo handleScroll ignore");
          }
        }
      }
    }
    this.BpS = 0.0F;
    this.rpT = 0.0F;
    Log.i("MicroMsg.BaseBoxDialogView", "alvinluo onTouchUp isExpand: %b, isTouchScrolling: %s, currentEnableTouchScroll: %s", new Object[] { Boolean.valueOf(this.BqB), Boolean.valueOf(this.BqF), Boolean.valueOf(this.BqG) });
    if (this.BqG)
    {
      if (this.BqF) {
        this.BqF = false;
      }
      if (this.BqB) {
        break label579;
      }
      Log.d("MicroMsg.BaseBoxDialogView", "alvinluo onTouchUp canClose: %b, canOpen: %b", new Object[] { Boolean.valueOf(elE()), Boolean.valueOf(elF()) });
      if (!elE()) {
        break label538;
      }
      if (!this.BqD) {
        break label532;
      }
      i = 1;
      label508:
      Se(i);
    }
    for (;;)
    {
      this.BqD = false;
      this.BqE = false;
      this.BqG = true;
      break;
      label532:
      i = 2;
      break label508;
      label538:
      if (!elF())
      {
        localObject = this.BpY;
        if (localObject == null) {
          p.bGy("dialogContainer");
        }
        f(((View)localObject).getTranslationY(), this.Bqm, false);
        continue;
        label579:
        Log.d("MicroMsg.BaseBoxDialogView", "alvinluo onTouchUp canClose: %b", new Object[] { Boolean.valueOf(elG()) });
        if (elG())
        {
          if (this.BqD) {
            i = 1;
          }
          Se(i);
          continue;
        }
      }
      localObject = this.BpY;
      if (localObject == null) {
        p.bGy("dialogContainer");
      }
      f(((View)localObject).getTranslationY(), this.Bql, true);
    }
  }
  
  public final void setBackgroundListener(e parame)
  {
    p.k(parame, "listener");
    this.Bqd = parame;
  }
  
  public final void setBackgroundOpView(a parama)
  {
    p.k(parama, "opView");
    this.Bqg = parama;
    if ((this.Bqg instanceof View))
    {
      parama = this.Bqb;
      if (parama != null) {
        parama.removeAllViews();
      }
      parama = this.Bqb;
      if (parama != null)
      {
        a locala = this.Bqg;
        if (locala == null) {
          throw new t("null cannot be cast to non-null type android.view.View");
        }
        parama.addView((View)locala);
      }
      parama = this.Bqb;
      if (parama != null) {
        parama.setVisibility(0);
      }
      requestLayout();
    }
    do
    {
      return;
      parama = this.Bqb;
    } while (parama == null);
    parama.setVisibility(8);
  }
  
  public final void setBackgroundTouchListener(b paramb)
  {
    p.k(paramb, "listener");
    this.Bqe = paramb;
  }
  
  public final void setBackgroundViewModel(c paramc)
  {
    p.k(paramc, "model");
    this.Bqf = paramc;
    paramc = this.Bqf;
    float f;
    if (paramc != null)
    {
      f = paramc.getMarkViewTransY();
      this.Bqi = f;
      if (this.Bqf != null)
      {
        paramc = this.Bqf;
        if (paramc == null) {
          p.iCn();
        }
        if (paramc.getMarkViewHeight() > this.Bqp)
        {
          paramc = this.Bqf;
          if (paramc == null) {
            p.iCn();
          }
          this.Bqp = ((int)paramc.getMarkViewHeight());
        }
      }
      paramc = this.Bqf;
      if (paramc == null) {
        break label132;
      }
    }
    label132:
    for (paramc = Float.valueOf(paramc.getMarkViewTransY());; paramc = null)
    {
      Log.v("MicroMsg.BaseBoxDialogView", "alvinluo setMarkView translationY: %s", new Object[] { paramc });
      return;
      f = 0.0F;
      break;
    }
  }
  
  public final void setCanceledOnTouchOutside(boolean paramBoolean)
  {
    this.BqJ = paramBoolean;
    if (!this.BqJ)
    {
      localView = this.BpX;
      if (localView == null) {
        p.bGy("dialogBg");
      }
      localView.setVisibility(8);
      localView = this.BpX;
      if (localView == null) {
        p.bGy("dialogBg");
      }
      localView.setOnClickListener(null);
      return;
    }
    View localView = this.BpX;
    if (localView == null) {
      p.bGy("dialogBg");
    }
    localView.setVisibility(0);
    elB();
  }
  
  public final void setEnableDialogScroll(boolean paramBoolean)
  {
    this.BqH = paramBoolean;
  }
  
  public final void setEnableScrollRightClose(boolean paramBoolean)
  {
    this.BqI = paramBoolean;
  }
  
  public final void setEnableWebViewScroll(boolean paramBoolean)
  {
    BoxWebViewContainer localBoxWebViewContainer = this.BpZ;
    if (localBoxWebViewContainer == null) {
      p.bGy("webViewContainer");
    }
    localBoxWebViewContainer.setEnableScroll(paramBoolean);
  }
  
  public final void setFixDialogHeight(int paramInt)
  {
    Log.v("MicroMsg.BaseBoxDialogView", "alvinluo setFixDialogHeight: %d", new Object[] { Integer.valueOf(paramInt) });
    this.Bqw = paramInt;
  }
  
  public final void setFixDialogHeightRate(float paramFloat)
  {
    Log.v("MicroMsg.BaseBoxDialogView", "alvinluo setFixDialogHeightRate: %s", new Object[] { Float.valueOf(paramFloat) });
    this.Bqy = paramFloat;
  }
  
  public final void setIsFixDialogHeight(boolean paramBoolean)
  {
    this.Bqv = paramBoolean;
  }
  
  public final void setMinDialogHeight(int paramInt)
  {
    Log.v("MicroMsg.BaseBoxDialogView", "setMinHeight: %d", new Object[] { Integer.valueOf(paramInt) });
    this.Bqu = paramInt;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/webview/BaseBoxDialogView$AnimationInfo;", "", "(Lcom/tencent/mm/plugin/finder/webview/BaseBoxDialogView;)V", "bgViewEndTranslationY", "", "getBgViewEndTranslationY", "()F", "setBgViewEndTranslationY", "(F)V", "bgViewNeedAnimation", "", "getBgViewNeedAnimation", "()Z", "setBgViewNeedAnimation", "(Z)V", "bgViewStartTranslationY", "getBgViewStartTranslationY", "setBgViewStartTranslationY", "plugin-finder_release"})
  final class a
  {
    float BqP;
    float BqQ;
    boolean BqR;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/webview/BaseBoxDialogView$Companion;", "", "()V", "DIALOG_SHOW_ANIMATION_DURATION", "", "DIALOG_SWITCH_ANIMATION_DURATION", "FULL_SCREEN_DRAG_CLOSE_FACTOR", "", "FULL_SCREEN_MOVE_OFFSET_Y_FACTOR", "HALF_SCREEN_DRAG_CLOSE_FACTOR", "HALF_SCREEN_DRAG_OPEN_FACTOR", "SCROLL_RIGHT_CLOSE_MOVE_OFFSET_X_FACTOR", "TAG", "", "plugin-finder_release"})
  public static final class b {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class c
    implements ValueAnimator.AnimatorUpdateListener
  {
    c(BaseBoxDialogView paramBaseBoxDialogView, boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(272473);
      p.j(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(272473);
        throw paramValueAnimator;
      }
      float f2 = ((Float)paramValueAnimator).floatValue();
      BaseBoxDialogView.e(this.BqS, f2);
      if (paramBoolean) {}
      for (float f1 = BaseBoxDialogView.g(this.BqS).BqQ;; f1 = BaseBoxDialogView.h(this.BqS).BqQ)
      {
        f1 = BaseBoxDialogView.b(paramFloat1, paramFloat2, f2, f, f1);
        BaseBoxDialogView.b(this.BqS, f1);
        AppMethodBeat.o(272473);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/webview/BaseBoxDialogView$animateDialogVerticalTranslation$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class d
    implements Animator.AnimatorListener
  {
    d(boolean paramBoolean) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(272922);
      BaseBoxDialogView.a(this.BqS, paramBoolean);
      BaseBoxDialogView.c(this.BqS, BaseBoxDialogView.e(this.BqS).getTranslationY());
      paramAnimator = this.BqS;
      c localc = BaseBoxDialogView.f(this.BqS);
      float f;
      if (localc != null)
      {
        f = localc.getBackgroundTransY();
        BaseBoxDialogView.d(paramAnimator, f);
        paramAnimator = this.BqS;
        if (!paramBoolean) {
          break label95;
        }
      }
      label95:
      for (int i = 2;; i = 1)
      {
        BaseBoxDialogView.a(paramAnimator, i);
        AppMethodBeat.o(272922);
        return;
        f = 0.0F;
        break;
      }
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/webview/BaseBoxDialogView$dismiss$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class e
    implements Animator.AnimatorListener
  {
    e(int paramInt) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(283433);
      BaseBoxDialogView.b(this.BqS);
      AppMethodBeat.o(283433);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(283432);
      BaseBoxDialogView.b(this.BqS);
      BaseBoxDialogView.a(this.BqS, 0);
      BaseBoxDialogView.c(this.BqS);
      MMHandlerThread.postToMainThread((Runnable)new a(this));
      AppMethodBeat.o(283432);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(283434);
      BaseBoxDialogView.c(this.BqS);
      AppMethodBeat.o(283434);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(BaseBoxDialogView.e parame) {}
      
      public final void run()
      {
        AppMethodBeat.i(226063);
        BaseBoxDialogView.d(this.BqX.BqS);
        AppMethodBeat.o(226063);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/webview/BaseBoxDialogView$dismiss$2", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "onAnimationUpdate", "", "animation", "Landroid/animation/ValueAnimator;", "plugin-finder_release"})
  public static final class f
    implements ValueAnimator.AnimatorUpdateListener
  {
    f(float paramFloat) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(278510);
      BaseBoxDialogView.a(this.BqS, BaseBoxDialogView.e(this.BqS).getTranslationY());
      if (paramValueAnimator == null)
      {
        AppMethodBeat.o(278510);
        return;
      }
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(278510);
        throw paramValueAnimator;
      }
      float f1 = ((Float)paramValueAnimator).floatValue();
      float f2 = f1;
      float f3 = this.BqZ;
      float f4 = f1;
      BaseBoxDialogView.b(this.BqS, f1 * (f3 - f4) + f2);
      AppMethodBeat.o(278510);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(BaseBoxDialogView paramBaseBoxDialogView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(271671);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/webview/BaseBoxDialogView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.BqS.Se(4);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/webview/BaseBoxDialogView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(271671);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(BaseBoxDialogView paramBaseBoxDialogView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(258513);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/webview/BaseBoxDialogView$initDialogBg$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if (!BaseBoxDialogView.a(this.BqS))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/webview/BaseBoxDialogView$initDialogBg$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(258513);
        return;
      }
      this.BqS.Se(3);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/webview/BaseBoxDialogView$initDialogBg$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(258513);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(View paramView) {}
    
    public final void run()
    {
      AppMethodBeat.i(286379);
      View localView = this.AWI;
      if (localView != null)
      {
        localView.requestLayout();
        AppMethodBeat.o(286379);
        return;
      }
      AppMethodBeat.o(286379);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.webview.BaseBoxDialogView
 * JD-Core Version:    0.7.0.1
 */