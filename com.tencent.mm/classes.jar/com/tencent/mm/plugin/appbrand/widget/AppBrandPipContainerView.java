package com.tencent.mm.plugin.appbrand.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewOutlineProvider;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.appbrand.ui.aa;
import com.tencent.mm.plugin.appbrand.ui.aa.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.lang.reflect.Method;

public final class AppBrandPipContainerView
  extends FrameLayout
{
  private static final int lPA;
  private static final Point lPB;
  public static final int lPg;
  public static final int lPh;
  public static final int lPi;
  public static final int lPj;
  public static final int lPk;
  public static final int lPl;
  public static final int lPm;
  public static final int lPn;
  private static final int lPo;
  private static final int lPp;
  private static final int lPq;
  private static final int lPr;
  private static final int lPs;
  private static final int lPt;
  public static final int lPu;
  public static final int lPv;
  public static final int lPw;
  public static final int lPx;
  public static final int lPy;
  public static final int lPz;
  public Point gyp;
  public Integer lPC;
  private int lPD;
  public Point lPE;
  private boolean lPF;
  private PointF lPG;
  private PointF lPH;
  public float lPI;
  private boolean lPJ;
  public boolean lPK;
  private int lPL;
  private int lPM;
  private a lPN;
  private Float lPO;
  public ViewOutlineProvider lPP;
  private ValueAnimator lPQ;
  public ViewGroup lPR;
  private View lPS;
  public View lPT;
  private ViewGroup lPU;
  private View lPV;
  private View lPW;
  private View lPX;
  private boolean lPY;
  public boolean lPZ;
  private int lcu;
  public int mCurOrientation;
  
  static
  {
    AppMethodBeat.i(176823);
    lPg = a.fromDPToPix(aj.getContext(), 196);
    lPh = a.fromDPToPix(aj.getContext(), 119);
    lPi = a.fromDPToPix(aj.getContext(), 176);
    lPj = a.fromDPToPix(aj.getContext(), 99);
    lPk = a.fromDPToPix(aj.getContext(), 119);
    lPl = a.fromDPToPix(aj.getContext(), 196);
    lPm = a.fromDPToPix(aj.getContext(), 99);
    lPn = a.fromDPToPix(aj.getContext(), 176);
    lPo = a.fromDPToPix(aj.getContext(), 32);
    lPp = a.fromDPToPix(aj.getContext(), 56);
    lPq = a.fromDPToPix(aj.getContext(), 52);
    lPr = a.fromDPToPix(aj.getContext(), 6);
    lPs = a.fromDPToPix(aj.getContext(), 80);
    lPt = a.fromDPToPix(aj.getContext(), 52);
    lPu = a.fromDPToPix(aj.getContext(), 8);
    lPv = a.fromDPToPix(aj.getContext(), 10);
    lPw = a.fromDPToPix(aj.getContext(), 12);
    lPx = a.fromDPToPix(aj.getContext(), 1);
    lPy = a.fromDPToPix(aj.getContext(), 10);
    lPz = a.fromDPToPix(aj.getContext(), 2);
    lPA = a.fromDPToPix(aj.getContext(), 1);
    lPB = new Point();
    AppMethodBeat.o(176823);
  }
  
  public AppBrandPipContainerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppBrandPipContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AppBrandPipContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(176792);
    this.lPC = null;
    this.lPE = lPB;
    this.gyp = lPB;
    this.lPF = false;
    this.lPG = new PointF();
    this.lPH = new PointF();
    this.lPI = -1.0F;
    this.lPJ = false;
    this.lPK = false;
    this.lPN = null;
    this.lcu = lPi;
    this.lPO = null;
    this.lPP = new ViewOutlineProvider()
    {
      public final void getOutline(View paramAnonymousView, Outline paramAnonymousOutline)
      {
        AppMethodBeat.i(176789);
        paramAnonymousOutline.setRoundRect(new Rect(0, 0, paramAnonymousView.getWidth(), paramAnonymousView.getHeight()), AppBrandPipContainerView.lPA);
        AppMethodBeat.o(176789);
      }
    };
    this.lPY = true;
    this.lPZ = true;
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131493023, this);
    this.lPW = paramAttributeSet.findViewById(2131296795);
    this.lPX = paramAttributeSet.findViewById(2131296794);
    this.lPX.setOutlineProvider(this.lPP);
    this.lPX.setClipToOutline(true);
    this.lPR = ((ViewGroup)paramAttributeSet.findViewById(2131296796));
    this.lPS = paramAttributeSet.findViewById(2131296793);
    this.lPT = paramAttributeSet.findViewById(2131296797);
    this.lPT.setVisibility(4);
    this.lPU = ((ViewGroup)paramAttributeSet.findViewById(2131296798));
    this.lPU.setVisibility(4);
    this.lPV = paramAttributeSet.findViewById(2131296799);
    this.lPV.setVisibility(4);
    b(this.lcu, lPv, lPu, lPw, lPx, lPy, lPz);
    this.lPD = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.mCurOrientation = paramContext.getResources().getConfiguration().orientation;
    this.gyp = cf(paramContext);
    ad.i("MicroMsg.AppBrand.AppBrandPipContainerView", "init, mScreenSize: " + this.gyp);
    AppMethodBeat.o(176792);
  }
  
  private boolean I(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(176806);
    if ((Math.abs(paramMotionEvent.getRawX() - this.lPG.x) > this.lPD) || (Math.abs(paramMotionEvent.getRawY() - this.lPG.y) > this.lPD))
    {
      AppMethodBeat.o(176806);
      return true;
    }
    AppMethodBeat.o(176806);
    return false;
  }
  
  private int J(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(176807);
    int j = this.lPE.x;
    int i = j;
    if (j <= 0)
    {
      i = this.gyp.x;
      ad.w("MicroMsg.AppBrand.AppBrandPipContainerView", "getMotionEventNewPositionX, mParentViewSize: " + this.lPE + ", mScreenSize: " + this.gyp);
    }
    i = (int)Math.max(Math.min(this.lPH.x + paramMotionEvent.getRawX() - this.lPG.x, i - getWidth()), 0.0F);
    AppMethodBeat.o(176807);
    return i;
  }
  
  private int K(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(176808);
    int j = this.lPE.y;
    int i = j;
    if (j <= 0)
    {
      i = this.gyp.y;
      ad.w("MicroMsg.AppBrand.AppBrandPipContainerView", "getMotionEventNewPositionY, mParentViewSize: " + this.lPE + ", mScreenSize: " + this.gyp);
    }
    i = (int)Math.max(Math.min(this.lPH.y + paramMotionEvent.getRawY() - this.lPG.y, i - getHeight()), 0.0F);
    AppMethodBeat.o(176808);
    return i;
  }
  
  private void a(float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(176818);
    if (paramBoolean)
    {
      int i = getMinY();
      int j = uv(getHeight());
      this.lPI = ((Math.min(Math.max(paramFloat, i), j) - i) / (j - i));
    }
    AppMethodBeat.o(176818);
  }
  
  public static Point cf(Context paramContext)
  {
    AppMethodBeat.i(176820);
    Point localPoint = new Point();
    if (paramContext == null)
    {
      AppMethodBeat.o(176820);
      return localPoint;
    }
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (Build.VERSION.SDK_INT >= 17) {
      paramContext.getRealSize(localPoint);
    }
    for (;;)
    {
      AppMethodBeat.o(176820);
      return localPoint;
      if (Build.VERSION.SDK_INT >= 14) {
        try
        {
          Method localMethod = Display.class.getMethod("getRawHeight", new Class[0]);
          localPoint.x = ((Integer)Display.class.getMethod("getRawWidth", new Class[0]).invoke(paramContext, new Object[0])).intValue();
          localPoint.y = ((Integer)localMethod.invoke(paramContext, new Object[0])).intValue();
        }
        catch (Exception localException) {}
      } else {
        paramContext.getSize(localPoint);
      }
    }
  }
  
  private void d(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(176809);
    float f1 = getX();
    float f2 = getX();
    if ((f1 != paramFloat1) || (f2 != paramFloat2))
    {
      setX(paramFloat1);
      setY(paramFloat2);
      a(paramFloat2, paramBoolean);
    }
    AppMethodBeat.o(176809);
  }
  
  private void ej(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(176802);
    this.lPL = el(paramInt1, paramInt2);
    AppMethodBeat.o(176802);
  }
  
  private void ek(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(176803);
    this.lPM = em(paramInt1, paramInt2);
    AppMethodBeat.o(176803);
  }
  
  private int el(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(176810);
    int i = getMinX();
    if (!ut(paramInt1)) {
      i = uu(paramInt2);
    }
    AppMethodBeat.o(176810);
    return i;
  }
  
  private int getMarginBottom()
  {
    if (1 == this.mCurOrientation) {
      return lPt;
    }
    return lPq;
  }
  
  private int getMarginHorizontal()
  {
    if (1 == this.mCurOrientation) {
      return lPr;
    }
    return lPo;
  }
  
  private int getMarginTopDefault()
  {
    if (1 == this.mCurOrientation) {
      return lPs;
    }
    return lPp;
  }
  
  private boolean ut(int paramInt)
  {
    AppMethodBeat.i(176812);
    int j = this.lPE.x;
    int i = j;
    if (j <= 0)
    {
      i = this.gyp.x;
      ad.w("MicroMsg.AppBrand.AppBrandPipContainerView", "isPositionLeft, mParentViewSize: " + this.lPE + ", mScreenSize: " + this.gyp);
    }
    if (getWidth() / 2 + paramInt <= i / 2) {}
    for (boolean bool = true;; bool = false)
    {
      this.lPJ = bool;
      bool = this.lPJ;
      AppMethodBeat.o(176812);
      return bool;
    }
  }
  
  public final void aE(float paramFloat)
  {
    AppMethodBeat.i(176800);
    if (!this.lPZ)
    {
      AppMethodBeat.o(176800);
      return;
    }
    this.lPU.setVisibility(0);
    this.lPV.setVisibility(0);
    ViewGroup.LayoutParams localLayoutParams = this.lPV.getLayoutParams();
    localLayoutParams.width = ((int)(this.lcu * paramFloat / 100.0F));
    this.lPV.setLayoutParams(localLayoutParams);
    this.lPO = Float.valueOf(paramFloat);
    AppMethodBeat.o(176800);
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    AppMethodBeat.i(176801);
    this.lcu = paramInt1;
    if (this.lPO != null) {
      aE(this.lPO.floatValue());
    }
    this.lPW.setPadding(paramInt2, paramInt3, paramInt2, paramInt4);
    Object localObject = (FrameLayout.LayoutParams)this.lPX.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).leftMargin = paramInt2;
    ((FrameLayout.LayoutParams)localObject).rightMargin = paramInt2;
    ((FrameLayout.LayoutParams)localObject).topMargin = paramInt3;
    ((FrameLayout.LayoutParams)localObject).bottomMargin = paramInt4;
    this.lPX.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new aa.a();
    ((aa.a)localObject).lEm = paramInt5;
    ((aa.a)localObject).lEp = Color.parseColor("#4C000000");
    ((aa.a)localObject).PH = paramInt6;
    ((aa.a)localObject).mOffsetX = 0;
    ((aa.a)localObject).mOffsetY = paramInt7;
    localObject = ((aa.a)localObject).boN();
    aa.b(this.lPW, (Drawable)localObject);
    AppMethodBeat.o(176801);
  }
  
  public final void bqS()
  {
    AppMethodBeat.i(176798);
    ad.i("MicroMsg.AppBrand.AppBrandPipContainerView", "disableTouch");
    this.lPS.setVisibility(4);
    this.lPY = false;
    AppMethodBeat.o(176798);
  }
  
  public final void bqT()
  {
    AppMethodBeat.i(194540);
    this.lPT.setVisibility(4);
    AppMethodBeat.o(194540);
  }
  
  public final void bqU()
  {
    AppMethodBeat.i(194541);
    this.lPU.setVisibility(4);
    this.lPV.setVisibility(4);
    this.lPO = null;
    AppMethodBeat.o(194541);
  }
  
  public final boolean ei(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(176796);
    if (this.lPK)
    {
      ad.d("MicroMsg.AppBrand.AppBrandPipContainerView", "setInitPosition, true == mStablePosChangedAfterInit");
      AppMethodBeat.o(176796);
      return false;
    }
    int i = uu(paramInt1);
    int j = uv(paramInt2);
    ad.i("MicroMsg.AppBrand.AppBrandPipContainerView", "setInitPosition, x: " + i + ", y: " + j);
    setX(i);
    setY(j);
    a(getY(), true);
    ej(i, paramInt1);
    ek(j, paramInt2);
    ad.i("MicroMsg.AppBrand.AppBrandPipContainerView", "setPosition, mStablePosX: " + this.lPL + ", mStablePosY: " + this.lPM);
    if (this.lPN != null) {
      this.lPN.bki();
    }
    AppMethodBeat.o(176796);
    return true;
  }
  
  public final int em(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(176811);
    int i = getMinY();
    if (paramInt1 < i) {
      paramInt2 = i;
    }
    for (;;)
    {
      AppMethodBeat.o(176811);
      return paramInt2;
      i = uv(paramInt2);
      paramInt2 = paramInt1;
      if (paramInt1 > i) {
        paramInt2 = i;
      }
    }
  }
  
  public final int getMinX()
  {
    AppMethodBeat.i(176814);
    int i = getMarginHorizontal();
    AppMethodBeat.o(176814);
    return i;
  }
  
  public final int getMinY()
  {
    AppMethodBeat.i(176816);
    if (this.lPC != null)
    {
      i = this.lPC.intValue();
      AppMethodBeat.o(176816);
      return i;
    }
    int i = getMarginTopDefault();
    AppMethodBeat.o(176816);
    return i;
  }
  
  public final int getStablePosX()
  {
    AppMethodBeat.i(176804);
    ad.d("MicroMsg.AppBrand.AppBrandPipContainerView", "getStablePosX, mStablePosX: " + this.lPL);
    int i = this.lPL;
    AppMethodBeat.o(176804);
    return i;
  }
  
  public final int getStablePosY()
  {
    AppMethodBeat.i(176805);
    ad.d("MicroMsg.AppBrand.AppBrandPipContainerView", "getStablePosY, mStablePosY: " + this.lPM);
    int i = this.lPM;
    AppMethodBeat.o(176805);
    return i;
  }
  
  public final int getTargetPositionXWhenOrientationChanged()
  {
    AppMethodBeat.i(176819);
    int i = getMinX();
    if (!this.lPJ) {
      i = uu(getWidth());
    }
    AppMethodBeat.o(176819);
    return i;
  }
  
  public final void hn(boolean paramBoolean)
  {
    AppMethodBeat.i(176797);
    ad.i("MicroMsg.AppBrand.AppBrandPipContainerView", "enableTouch");
    View localView = this.lPS;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localView.setVisibility(i);
      this.lPY = true;
      AppMethodBeat.o(176797);
      return;
    }
  }
  
  @SuppressLint({"DrawAllocation"})
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(176794);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = (View)getParent();
    if (localView == null)
    {
      ad.w("MicroMsg.AppBrand.AppBrandPipContainerView", "onLayout, null == parentView");
      AppMethodBeat.o(176794);
      return;
    }
    if (lPB == this.lPE)
    {
      this.lPE = new Point(localView.getWidth(), localView.getHeight());
      ad.i("MicroMsg.AppBrand.AppBrandPipContainerView", "onLayout, mParentViewSize: " + this.lPE);
      a(getY(), true);
    }
    AppMethodBeat.o(176794);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(176793);
    if (!this.lPY)
    {
      AppMethodBeat.o(176793);
      return true;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(176793);
      return bool;
      this.lPF = false;
      this.lPG.x = paramMotionEvent.getRawX();
      this.lPG.y = paramMotionEvent.getRawY();
      this.lPH.x = ((int)getX());
      this.lPH.y = ((int)getY());
      ad.i("MicroMsg.AppBrand.AppBrandPipContainerView", "recordPositionWhenActionDown, fingerPosOnDown: " + this.lPG + ", viewPosOnDown: " + this.lPH);
      continue;
      if ((!this.lPF) && (I(paramMotionEvent))) {
        this.lPF = true;
      }
      if (this.lPF)
      {
        d(J(paramMotionEvent), K(paramMotionEvent), false);
        continue;
        if ((this.lPF) || (I(paramMotionEvent))) {
          break;
        }
        d(this.lPH.x, this.lPH.y, true);
        i = (int)this.lPH.x;
        j = (int)this.lPH.y;
        ad.i("MicroMsg.AppBrand.AppBrandPipContainerView", "onTouchEvent, posX: " + i + ", posY: " + j);
        ej(i, getWidth());
        ek(j, getHeight());
        ad.i("MicroMsg.AppBrand.AppBrandPipContainerView", "onTouchEvent, mStablePosX: " + this.lPL + ", mStablePosY: " + this.lPM);
        this.lPK = true;
        if (this.lPN != null) {
          this.lPN.bki();
        }
      }
    }
    if (this.lPF) {
      this.lPF = false;
    }
    int i = J(paramMotionEvent);
    int j = getWidth();
    int k = K(paramMotionEvent);
    int m = getHeight();
    ad.i("MicroMsg.AppBrand.AppBrandPipContainerView", "onTouchEvent, startPositionX: " + i + ", width: " + j + ", startPositionY: " + k + ", height: " + m);
    y(i, k, el(i, j), em(k, m));
    AppMethodBeat.o(176793);
    return true;
  }
  
  public final void setOnCloseButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(176799);
    this.lPS.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(176799);
  }
  
  public final void setOnStablePositionChangeListener(a parama)
  {
    this.lPN = parama;
  }
  
  public final int uu(int paramInt)
  {
    AppMethodBeat.i(176815);
    int i = this.lPE.x;
    int k = getMarginHorizontal();
    int j = i - paramInt - k;
    i = j;
    if (j < 0) {
      i = this.gyp.x - paramInt - k;
    }
    AppMethodBeat.o(176815);
    return i;
  }
  
  public final int uv(int paramInt)
  {
    AppMethodBeat.i(176817);
    int i = this.lPE.y;
    int k = getMarginBottom();
    int j = i - paramInt - k;
    i = j;
    if (j < 0) {
      i = this.gyp.y - paramInt - k;
    }
    AppMethodBeat.o(176817);
    return i;
  }
  
  public final void y(final int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4)
  {
    AppMethodBeat.i(176813);
    if ((this.lPQ != null) && (this.lPQ.isRunning())) {
      this.lPQ.cancel();
    }
    this.lPQ = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.lPQ.setInterpolator(new AccelerateDecelerateInterpolator());
    this.lPQ.setDuration(100L);
    this.lPQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(176790);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        int i = paramInt1;
        int j = (int)((paramInt3 * 1.0F - paramInt1) * f);
        int k = paramInt2;
        int m = (int)(f * (paramInt4 * 1.0F - paramInt2));
        AppBrandPipContainerView.a(AppBrandPipContainerView.this, i + j, m + k);
        AppMethodBeat.o(176790);
      }
    });
    this.lPQ.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(176791);
        super.onAnimationEnd(paramAnonymousAnimator);
        AppBrandPipContainerView.a(AppBrandPipContainerView.this, AppBrandPipContainerView.this.getY());
        AppBrandPipContainerView.a(AppBrandPipContainerView.this, paramInt3);
        AppBrandPipContainerView.b(AppBrandPipContainerView.this, paramInt4);
        ad.i("MicroMsg.AppBrand.AppBrandPipContainerView", "startStickyAnimation, mStablePosX: " + AppBrandPipContainerView.a(AppBrandPipContainerView.this) + ", mStablePosY: " + AppBrandPipContainerView.b(AppBrandPipContainerView.this));
        AppBrandPipContainerView.c(AppBrandPipContainerView.this);
        if (AppBrandPipContainerView.d(AppBrandPipContainerView.this) != null)
        {
          paramAnonymousAnimator = AppBrandPipContainerView.d(AppBrandPipContainerView.this);
          AppBrandPipContainerView.a(AppBrandPipContainerView.this);
          AppBrandPipContainerView.b(AppBrandPipContainerView.this);
          paramAnonymousAnimator.bki();
        }
        AppMethodBeat.o(176791);
      }
    });
    this.lPQ.start();
    AppMethodBeat.o(176813);
  }
  
  public static abstract interface a
  {
    public abstract void bki();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView
 * JD-Core Version:    0.7.0.1
 */