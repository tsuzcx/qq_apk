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
import android.graphics.Point;
import android.graphics.PointF;
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
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.appbrand.ui.ac;
import com.tencent.mm.plugin.appbrand.ui.ac.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class AppBrandPipContainerView
  extends FrameLayout
{
  public static final int mWX;
  public static final int mWY;
  public static final int mWZ;
  public static final int mXa;
  public static final int mXb;
  public static final int mXc;
  public static final int mXd;
  public static final int mXe;
  private static final int mXf;
  private static final int mXg;
  private static final int mXh;
  private static final int mXi;
  private static final int mXj;
  private static final int mXk;
  public static final int mXl;
  public static final int mXm;
  public static final int mXn;
  public static final int mXo;
  public static final int mXp;
  public static final int mXq;
  private static final int mXr;
  private static final Point mXs;
  private PointF gNg;
  public Point htH;
  public int mCurOrientation;
  public boolean mXA;
  public int mXB;
  public int mXC;
  public Set<a> mXD;
  private Float mXE;
  public ViewOutlineProvider mXF;
  private ValueAnimator mXG;
  public ViewGroup mXH;
  private View mXI;
  public View mXJ;
  private ViewGroup mXK;
  private View mXL;
  private View mXM;
  private View mXN;
  private boolean mXO;
  public boolean mXP;
  private boolean mXQ;
  private ac mXR;
  public Integer mXt;
  private int mXu;
  public Point mXv;
  private boolean mXw;
  private PointF mXx;
  public float mXy;
  private boolean mXz;
  private int mrV;
  
  static
  {
    AppMethodBeat.i(176823);
    mWX = a.fromDPToPix(ak.getContext(), 196);
    mWY = a.fromDPToPix(ak.getContext(), 119);
    mWZ = a.fromDPToPix(ak.getContext(), 176);
    mXa = a.fromDPToPix(ak.getContext(), 99);
    mXb = a.fromDPToPix(ak.getContext(), 119);
    mXc = a.fromDPToPix(ak.getContext(), 196);
    mXd = a.fromDPToPix(ak.getContext(), 99);
    mXe = a.fromDPToPix(ak.getContext(), 176);
    mXf = a.fromDPToPix(ak.getContext(), 32);
    mXg = a.fromDPToPix(ak.getContext(), 56);
    mXh = a.fromDPToPix(ak.getContext(), 52);
    mXi = a.fromDPToPix(ak.getContext(), 6);
    mXj = a.fromDPToPix(ak.getContext(), 80);
    mXk = a.fromDPToPix(ak.getContext(), 52);
    mXl = a.fromDPToPix(ak.getContext(), 8);
    mXm = a.fromDPToPix(ak.getContext(), 10);
    mXn = a.fromDPToPix(ak.getContext(), 12);
    mXo = a.fromDPToPix(ak.getContext(), 1);
    mXp = a.fromDPToPix(ak.getContext(), 10);
    mXq = a.fromDPToPix(ak.getContext(), 2);
    mXr = a.fromDPToPix(ak.getContext(), 1);
    mXs = new Point();
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
    this.mXt = null;
    this.mXv = mXs;
    this.htH = mXs;
    this.mXw = false;
    this.gNg = new PointF();
    this.mXx = new PointF();
    this.mXy = -1.0F;
    this.mXz = false;
    this.mXA = false;
    this.mXD = null;
    this.mrV = mWZ;
    this.mXE = null;
    this.mXF = new AppBrandPipContainerView.1(this);
    this.mXO = true;
    this.mXP = true;
    this.mXQ = false;
    this.mXR = null;
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131493023, this);
    setBackgroundColor(0);
    this.mXM = paramAttributeSet.findViewById(2131296795);
    this.mXN = paramAttributeSet.findViewById(2131296794);
    this.mXN.setOutlineProvider(this.mXF);
    this.mXN.setClipToOutline(true);
    this.mXH = ((ViewGroup)paramAttributeSet.findViewById(2131296796));
    this.mXI = paramAttributeSet.findViewById(2131296793);
    this.mXJ = paramAttributeSet.findViewById(2131296797);
    this.mXJ.setVisibility(4);
    this.mXK = ((ViewGroup)paramAttributeSet.findViewById(2131296798));
    this.mXK.setVisibility(4);
    this.mXL = paramAttributeSet.findViewById(2131296799);
    this.mXL.setVisibility(4);
    b(this.mrV, mXm, mXl, mXn, mXo, mXp, mXq);
    this.mXu = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.mCurOrientation = paramContext.getResources().getConfiguration().orientation;
    this.htH = ck(paramContext);
    ae.i("MicroMsg.AppBrand.AppBrandPipContainerView", "init, mScreenSize: " + this.htH);
    AppMethodBeat.o(176792);
  }
  
  private boolean C(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(176806);
    if ((Math.abs(paramMotionEvent.getRawX() - this.gNg.x) > this.mXu) || (Math.abs(paramMotionEvent.getRawY() - this.gNg.y) > this.mXu))
    {
      AppMethodBeat.o(176806);
      return true;
    }
    AppMethodBeat.o(176806);
    return false;
  }
  
  private int D(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(176807);
    int j = this.mXv.x;
    int i = j;
    if (j <= 0)
    {
      i = this.htH.x;
      ae.w("MicroMsg.AppBrand.AppBrandPipContainerView", "getMotionEventNewPositionX, mParentViewSize: " + this.mXv + ", mScreenSize: " + this.htH);
    }
    i = (int)Math.max(Math.min(this.mXx.x + paramMotionEvent.getRawX() - this.gNg.x, i - getWidth()), 0.0F);
    AppMethodBeat.o(176807);
    return i;
  }
  
  private int E(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(176808);
    int j = this.mXv.y;
    int i = j;
    if (j <= 0)
    {
      i = this.htH.y;
      ae.w("MicroMsg.AppBrand.AppBrandPipContainerView", "getMotionEventNewPositionY, mParentViewSize: " + this.mXv + ", mScreenSize: " + this.htH);
    }
    i = (int)Math.max(Math.min(this.mXx.y + paramMotionEvent.getRawY() - this.gNg.y, i - getHeight()), 0.0F);
    AppMethodBeat.o(176808);
    return i;
  }
  
  private void K(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(208004);
    float f1 = getX();
    float f2 = getX();
    if ((f1 != paramFloat1) || (f2 != paramFloat2))
    {
      setX(paramFloat1);
      setY(paramFloat2);
      a(paramFloat2, false);
    }
    AppMethodBeat.o(208004);
  }
  
  public static Point ck(Context paramContext)
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
  
  private int ep(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(176810);
    int i = getMinX();
    if (!er(paramInt1, paramInt2)) {
      i = vW(paramInt2);
    }
    AppMethodBeat.o(176810);
    return i;
  }
  
  private boolean er(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(208005);
    int j = this.mXv.x;
    int i = j;
    if (j <= 0)
    {
      i = this.htH.x;
      ae.w("MicroMsg.AppBrand.AppBrandPipContainerView", "isPositionLeft, mParentViewSize: " + this.mXv + ", mScreenSize: " + this.htH);
    }
    if (paramInt2 / 2 + paramInt1 <= i / 2) {}
    for (boolean bool = true;; bool = false)
    {
      this.mXz = bool;
      bool = this.mXz;
      AppMethodBeat.o(208005);
      return bool;
    }
  }
  
  private int getMarginBottom()
  {
    if (1 == this.mCurOrientation) {
      return mXk;
    }
    return mXh;
  }
  
  private int getMarginHorizontal()
  {
    if (1 == this.mCurOrientation) {
      return mXi;
    }
    return mXf;
  }
  
  private int getMarginTopDefault()
  {
    if (1 == this.mCurOrientation) {
      return mXj;
    }
    return mXg;
  }
  
  public final void a(float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(176818);
    if (paramBoolean)
    {
      int i = getMinY();
      int j = vX(getHeight());
      this.mXy = ((Math.min(Math.max(paramFloat, i), j) - i) / (j - i));
    }
    AppMethodBeat.o(176818);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(208001);
    if (this.mXD == null) {
      this.mXD = new HashSet();
    }
    this.mXD.add(parama);
    AppMethodBeat.o(208001);
  }
  
  public final void aL(float paramFloat)
  {
    AppMethodBeat.i(176800);
    if (!this.mXP)
    {
      AppMethodBeat.o(176800);
      return;
    }
    this.mXK.setVisibility(0);
    this.mXL.setVisibility(0);
    ViewGroup.LayoutParams localLayoutParams = this.mXL.getLayoutParams();
    localLayoutParams.width = ((int)(this.mrV * paramFloat / 100.0F));
    this.mXL.setLayoutParams(localLayoutParams);
    this.mXE = Float.valueOf(paramFloat);
    AppMethodBeat.o(176800);
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    AppMethodBeat.i(176801);
    this.mrV = paramInt1;
    if (this.mXE != null) {
      aL(this.mXE.floatValue());
    }
    this.mXM.setPadding(paramInt2, paramInt3, paramInt2, paramInt4);
    Object localObject = (FrameLayout.LayoutParams)this.mXN.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).leftMargin = paramInt2;
    ((FrameLayout.LayoutParams)localObject).rightMargin = paramInt2;
    ((FrameLayout.LayoutParams)localObject).topMargin = paramInt3;
    ((FrameLayout.LayoutParams)localObject).bottomMargin = paramInt4;
    this.mXN.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new ac.a();
    ((ac.a)localObject).mLL = paramInt5;
    ((ac.a)localObject).mLO = Color.parseColor("#4C000000");
    ((ac.a)localObject).Sr = paramInt6;
    ((ac.a)localObject).mOffsetX = 0;
    ((ac.a)localObject).mOffsetY = paramInt7;
    localObject = ((ac.a)localObject).bAJ();
    if (this.mXQ)
    {
      ac.b(this.mXM, (Drawable)localObject);
      AppMethodBeat.o(176801);
      return;
    }
    this.mXR = ((ac)localObject);
    AppMethodBeat.o(176801);
  }
  
  public final void bCS()
  {
    AppMethodBeat.i(176798);
    ae.i("MicroMsg.AppBrand.AppBrandPipContainerView", "disableTouch");
    this.mXI.setVisibility(4);
    this.mXO = false;
    AppMethodBeat.o(176798);
  }
  
  public final void bCT()
  {
    AppMethodBeat.i(207999);
    ae.i("MicroMsg.AppBrand.AppBrandPipContainerView", "showOnLoadEnd");
    this.mXJ.setVisibility(4);
    AppMethodBeat.o(207999);
  }
  
  public final void bCU()
  {
    AppMethodBeat.i(208000);
    this.mXK.setVisibility(4);
    this.mXL.setVisibility(4);
    this.mXE = null;
    AppMethodBeat.o(208000);
  }
  
  public final void em(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(176802);
    this.mXB = ep(paramInt1, paramInt2);
    AppMethodBeat.o(176802);
  }
  
  public final void en(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(176803);
    this.mXC = eq(paramInt1, paramInt2);
    AppMethodBeat.o(176803);
  }
  
  public final void eo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(208003);
    if (this.mXD == null)
    {
      AppMethodBeat.o(208003);
      return;
    }
    Iterator localIterator = this.mXD.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).eh(paramInt1, paramInt2);
    }
    AppMethodBeat.o(208003);
  }
  
  public final int eq(int paramInt1, int paramInt2)
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
      i = vX(paramInt2);
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
    if (this.mXt != null)
    {
      i = this.mXt.intValue();
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
    ae.d("MicroMsg.AppBrand.AppBrandPipContainerView", "getStablePosX, mStablePosX: " + this.mXB);
    int i = this.mXB;
    AppMethodBeat.o(176804);
    return i;
  }
  
  public final int getStablePosY()
  {
    AppMethodBeat.i(176805);
    ae.d("MicroMsg.AppBrand.AppBrandPipContainerView", "getStablePosY, mStablePosY: " + this.mXC);
    int i = this.mXC;
    AppMethodBeat.o(176805);
    return i;
  }
  
  public final int getTargetPositionXWhenOrientationChanged()
  {
    AppMethodBeat.i(176819);
    int i = getMinX();
    if (!this.mXz) {
      i = vW(getWidth());
    }
    AppMethodBeat.o(176819);
    return i;
  }
  
  public final void hU(boolean paramBoolean)
  {
    AppMethodBeat.i(207998);
    ae.i("MicroMsg.AppBrand.AppBrandPipContainerView", "enableShadow, isEnabled: ".concat(String.valueOf(paramBoolean)));
    this.mXQ = paramBoolean;
    if (paramBoolean)
    {
      if (this.mXR != null)
      {
        ae.i("MicroMsg.AppBrand.AppBrandPipContainerView", "enableShadow, setShadowDrawable");
        ac.b(this.mXM, this.mXR);
        AppMethodBeat.o(207998);
      }
    }
    else {
      ac.b(this.mXM, null);
    }
    AppMethodBeat.o(207998);
  }
  
  public final void hV(boolean paramBoolean)
  {
    AppMethodBeat.i(176797);
    ae.i("MicroMsg.AppBrand.AppBrandPipContainerView", "enableTouch");
    View localView = this.mXI;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localView.setVisibility(i);
      this.mXO = true;
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
      ae.w("MicroMsg.AppBrand.AppBrandPipContainerView", "onLayout, null == parentView");
      AppMethodBeat.o(176794);
      return;
    }
    if (mXs == this.mXv)
    {
      this.mXv = new Point(localView.getWidth(), localView.getHeight());
      ae.i("MicroMsg.AppBrand.AppBrandPipContainerView", "onLayout, mParentViewSize: " + this.mXv);
      a(getY(), true);
    }
    AppMethodBeat.o(176794);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(176793);
    if (!this.mXO)
    {
      AppMethodBeat.o(176793);
      return true;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      for (;;)
      {
        boolean bool = super.onTouchEvent(paramMotionEvent);
        AppMethodBeat.o(176793);
        return bool;
        this.mXw = false;
        this.gNg.x = paramMotionEvent.getRawX();
        this.gNg.y = paramMotionEvent.getRawY();
        this.mXx.x = ((int)getX());
        this.mXx.y = ((int)getY());
        ae.i("MicroMsg.AppBrand.AppBrandPipContainerView", "recordPositionWhenActionDown, fingerPosOnDown: " + this.gNg + ", viewPosOnDown: " + this.mXx);
        continue;
        if ((!this.mXw) && (C(paramMotionEvent))) {
          this.mXw = true;
        }
        if (this.mXw) {
          K(D(paramMotionEvent), E(paramMotionEvent));
        }
      }
    } while ((!this.mXw) && (!C(paramMotionEvent)));
    if (this.mXw) {
      this.mXw = false;
    }
    int i = D(paramMotionEvent);
    int j = getWidth();
    int k = E(paramMotionEvent);
    int m = getHeight();
    ae.i("MicroMsg.AppBrand.AppBrandPipContainerView", "onTouchEvent, startPositionX: " + i + ", width: " + j + ", startPositionY: " + k + ", height: " + m);
    z(i, k, ep(i, j), eq(k, m));
    AppMethodBeat.o(176793);
    return true;
  }
  
  public final void setOnCloseButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(176799);
    this.mXI.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(176799);
  }
  
  public final void setStablePos(Point paramPoint)
  {
    AppMethodBeat.i(208002);
    ae.d("MicroMsg.AppBrand.AppBrandPipContainerView", "setStablePos, stablePos: ".concat(String.valueOf(paramPoint)));
    this.mXB = paramPoint.x;
    this.mXC = paramPoint.y;
    this.mXA = true;
    AppMethodBeat.o(208002);
  }
  
  public final int vW(int paramInt)
  {
    AppMethodBeat.i(176815);
    int i = this.mXv.x;
    int k = getMarginHorizontal();
    int j = i - paramInt - k;
    i = j;
    if (j < 0) {
      i = this.htH.x - paramInt - k;
    }
    AppMethodBeat.o(176815);
    return i;
  }
  
  public final int vX(int paramInt)
  {
    AppMethodBeat.i(176817);
    int i = this.mXv.y;
    int k = getMarginBottom();
    int j = i - paramInt - k;
    i = j;
    if (j < 0) {
      i = this.htH.y - paramInt - k;
    }
    AppMethodBeat.o(176817);
    return i;
  }
  
  public final void z(final int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4)
  {
    AppMethodBeat.i(176813);
    if ((this.mXG != null) && (this.mXG.isRunning())) {
      this.mXG.cancel();
    }
    this.mXG = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.mXG.setInterpolator(new AccelerateDecelerateInterpolator());
    this.mXG.setDuration(100L);
    this.mXG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
    this.mXG.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(176791);
        super.onAnimationEnd(paramAnonymousAnimator);
        AppBrandPipContainerView.a(AppBrandPipContainerView.this, AppBrandPipContainerView.this.getY());
        AppBrandPipContainerView.a(AppBrandPipContainerView.this, paramInt3);
        AppBrandPipContainerView.b(AppBrandPipContainerView.this, paramInt4);
        ae.i("MicroMsg.AppBrand.AppBrandPipContainerView", "startStickyAnimation, mStablePosX: " + AppBrandPipContainerView.a(AppBrandPipContainerView.this) + ", mStablePosY: " + AppBrandPipContainerView.b(AppBrandPipContainerView.this));
        AppBrandPipContainerView.a(AppBrandPipContainerView.this, AppBrandPipContainerView.a(AppBrandPipContainerView.this), AppBrandPipContainerView.b(AppBrandPipContainerView.this));
        AppMethodBeat.o(176791);
      }
    });
    this.mXG.start();
    AppMethodBeat.o(176813);
  }
  
  public static abstract interface a
  {
    public abstract void eh(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView
 * JD-Core Version:    0.7.0.1
 */