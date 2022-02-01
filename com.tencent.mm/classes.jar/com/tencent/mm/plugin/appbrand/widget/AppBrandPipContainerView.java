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
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.appbrand.ui.ab;
import com.tencent.mm.plugin.appbrand.ui.ab.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class AppBrandPipContainerView
  extends FrameLayout
{
  public static final int mRN;
  public static final int mRO;
  public static final int mRP;
  public static final int mRQ;
  public static final int mRR;
  public static final int mRS;
  public static final int mRT;
  public static final int mRU;
  private static final int mRV;
  private static final int mRW;
  private static final int mRX;
  private static final int mRY;
  private static final int mRZ;
  private static final int mSa;
  public static final int mSb;
  public static final int mSc;
  public static final int mSd;
  public static final int mSe;
  public static final int mSf;
  public static final int mSg;
  private static final int mSh;
  private static final Point mSi;
  private PointF gKx;
  public Point hqT;
  public int mCurOrientation;
  public View mSA;
  private ViewGroup mSB;
  private View mSC;
  private View mSD;
  private View mSE;
  private boolean mSF;
  public boolean mSG;
  private boolean mSH;
  private ab mSI;
  public Integer mSj;
  private int mSk;
  public Point mSl;
  private boolean mSm;
  private PointF mSn;
  public float mSp;
  private boolean mSq;
  public boolean mSr;
  public int mSs;
  public int mSt;
  public Set<a> mSu;
  private Float mSv;
  public ViewOutlineProvider mSw;
  private ValueAnimator mSx;
  public ViewGroup mSy;
  private View mSz;
  private int mmY;
  
  static
  {
    AppMethodBeat.i(176823);
    mRN = a.fromDPToPix(aj.getContext(), 196);
    mRO = a.fromDPToPix(aj.getContext(), 119);
    mRP = a.fromDPToPix(aj.getContext(), 176);
    mRQ = a.fromDPToPix(aj.getContext(), 99);
    mRR = a.fromDPToPix(aj.getContext(), 119);
    mRS = a.fromDPToPix(aj.getContext(), 196);
    mRT = a.fromDPToPix(aj.getContext(), 99);
    mRU = a.fromDPToPix(aj.getContext(), 176);
    mRV = a.fromDPToPix(aj.getContext(), 32);
    mRW = a.fromDPToPix(aj.getContext(), 56);
    mRX = a.fromDPToPix(aj.getContext(), 52);
    mRY = a.fromDPToPix(aj.getContext(), 6);
    mRZ = a.fromDPToPix(aj.getContext(), 80);
    mSa = a.fromDPToPix(aj.getContext(), 52);
    mSb = a.fromDPToPix(aj.getContext(), 8);
    mSc = a.fromDPToPix(aj.getContext(), 10);
    mSd = a.fromDPToPix(aj.getContext(), 12);
    mSe = a.fromDPToPix(aj.getContext(), 1);
    mSf = a.fromDPToPix(aj.getContext(), 10);
    mSg = a.fromDPToPix(aj.getContext(), 2);
    mSh = a.fromDPToPix(aj.getContext(), 1);
    mSi = new Point();
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
    this.mSj = null;
    this.mSl = mSi;
    this.hqT = mSi;
    this.mSm = false;
    this.gKx = new PointF();
    this.mSn = new PointF();
    this.mSp = -1.0F;
    this.mSq = false;
    this.mSr = false;
    this.mSu = null;
    this.mmY = mRP;
    this.mSv = null;
    this.mSw = new AppBrandPipContainerView.1(this);
    this.mSF = true;
    this.mSG = true;
    this.mSH = false;
    this.mSI = null;
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131493023, this);
    setBackgroundColor(0);
    this.mSD = paramAttributeSet.findViewById(2131296795);
    this.mSE = paramAttributeSet.findViewById(2131296794);
    this.mSE.setOutlineProvider(this.mSw);
    this.mSE.setClipToOutline(true);
    this.mSy = ((ViewGroup)paramAttributeSet.findViewById(2131296796));
    this.mSz = paramAttributeSet.findViewById(2131296793);
    this.mSA = paramAttributeSet.findViewById(2131296797);
    this.mSA.setVisibility(4);
    this.mSB = ((ViewGroup)paramAttributeSet.findViewById(2131296798));
    this.mSB.setVisibility(4);
    this.mSC = paramAttributeSet.findViewById(2131296799);
    this.mSC.setVisibility(4);
    b(this.mmY, mSc, mSb, mSd, mSe, mSf, mSg);
    this.mSk = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.mCurOrientation = paramContext.getResources().getConfiguration().orientation;
    this.hqT = ci(paramContext);
    ad.i("MicroMsg.AppBrand.AppBrandPipContainerView", "init, mScreenSize: " + this.hqT);
    AppMethodBeat.o(176792);
  }
  
  private boolean E(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(176806);
    if ((Math.abs(paramMotionEvent.getRawX() - this.gKx.x) > this.mSk) || (Math.abs(paramMotionEvent.getRawY() - this.gKx.y) > this.mSk))
    {
      AppMethodBeat.o(176806);
      return true;
    }
    AppMethodBeat.o(176806);
    return false;
  }
  
  private int F(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(176807);
    int j = this.mSl.x;
    int i = j;
    if (j <= 0)
    {
      i = this.hqT.x;
      ad.w("MicroMsg.AppBrand.AppBrandPipContainerView", "getMotionEventNewPositionX, mParentViewSize: " + this.mSl + ", mScreenSize: " + this.hqT);
    }
    i = (int)Math.max(Math.min(this.mSn.x + paramMotionEvent.getRawX() - this.gKx.x, i - getWidth()), 0.0F);
    AppMethodBeat.o(176807);
    return i;
  }
  
  private int G(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(176808);
    int j = this.mSl.y;
    int i = j;
    if (j <= 0)
    {
      i = this.hqT.y;
      ad.w("MicroMsg.AppBrand.AppBrandPipContainerView", "getMotionEventNewPositionY, mParentViewSize: " + this.mSl + ", mScreenSize: " + this.hqT);
    }
    i = (int)Math.max(Math.min(this.mSn.y + paramMotionEvent.getRawY() - this.gKx.y, i - getHeight()), 0.0F);
    AppMethodBeat.o(176808);
    return i;
  }
  
  private void K(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(197463);
    float f1 = getX();
    float f2 = getX();
    if ((f1 != paramFloat1) || (f2 != paramFloat2))
    {
      setX(paramFloat1);
      setY(paramFloat2);
      a(paramFloat2, false);
    }
    AppMethodBeat.o(197463);
  }
  
  public static Point ci(Context paramContext)
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
      i = vR(paramInt2);
    }
    AppMethodBeat.o(176810);
    return i;
  }
  
  private boolean er(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(197464);
    int j = this.mSl.x;
    int i = j;
    if (j <= 0)
    {
      i = this.hqT.x;
      ad.w("MicroMsg.AppBrand.AppBrandPipContainerView", "isPositionLeft, mParentViewSize: " + this.mSl + ", mScreenSize: " + this.hqT);
    }
    if (paramInt2 / 2 + paramInt1 <= i / 2) {}
    for (boolean bool = true;; bool = false)
    {
      this.mSq = bool;
      bool = this.mSq;
      AppMethodBeat.o(197464);
      return bool;
    }
  }
  
  private int getMarginBottom()
  {
    if (1 == this.mCurOrientation) {
      return mSa;
    }
    return mRX;
  }
  
  private int getMarginHorizontal()
  {
    if (1 == this.mCurOrientation) {
      return mRY;
    }
    return mRV;
  }
  
  private int getMarginTopDefault()
  {
    if (1 == this.mCurOrientation) {
      return mRZ;
    }
    return mRW;
  }
  
  public final void a(float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(176818);
    if (paramBoolean)
    {
      int i = getMinY();
      int j = vS(getHeight());
      this.mSp = ((Math.min(Math.max(paramFloat, i), j) - i) / (j - i));
    }
    AppMethodBeat.o(176818);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(197460);
    if (this.mSu == null) {
      this.mSu = new HashSet();
    }
    this.mSu.add(parama);
    AppMethodBeat.o(197460);
  }
  
  public final void aL(float paramFloat)
  {
    AppMethodBeat.i(176800);
    if (!this.mSG)
    {
      AppMethodBeat.o(176800);
      return;
    }
    this.mSB.setVisibility(0);
    this.mSC.setVisibility(0);
    ViewGroup.LayoutParams localLayoutParams = this.mSC.getLayoutParams();
    localLayoutParams.width = ((int)(this.mmY * paramFloat / 100.0F));
    this.mSC.setLayoutParams(localLayoutParams);
    this.mSv = Float.valueOf(paramFloat);
    AppMethodBeat.o(176800);
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    AppMethodBeat.i(176801);
    this.mmY = paramInt1;
    if (this.mSv != null) {
      aL(this.mSv.floatValue());
    }
    this.mSD.setPadding(paramInt2, paramInt3, paramInt2, paramInt4);
    Object localObject = (FrameLayout.LayoutParams)this.mSE.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).leftMargin = paramInt2;
    ((FrameLayout.LayoutParams)localObject).rightMargin = paramInt2;
    ((FrameLayout.LayoutParams)localObject).topMargin = paramInt3;
    ((FrameLayout.LayoutParams)localObject).bottomMargin = paramInt4;
    this.mSE.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new ab.a();
    ((ab.a)localObject).mGH = paramInt5;
    ((ab.a)localObject).mGK = Color.parseColor("#4C000000");
    ((ab.a)localObject).Sr = paramInt6;
    ((ab.a)localObject).mOffsetX = 0;
    ((ab.a)localObject).mOffsetY = paramInt7;
    localObject = ((ab.a)localObject).bzO();
    if (this.mSH)
    {
      ab.b(this.mSD, (Drawable)localObject);
      AppMethodBeat.o(176801);
      return;
    }
    this.mSI = ((ab)localObject);
    AppMethodBeat.o(176801);
  }
  
  public final void bBY()
  {
    AppMethodBeat.i(176798);
    ad.i("MicroMsg.AppBrand.AppBrandPipContainerView", "disableTouch");
    this.mSz.setVisibility(4);
    this.mSF = false;
    AppMethodBeat.o(176798);
  }
  
  public final void bBZ()
  {
    AppMethodBeat.i(197458);
    this.mSA.setVisibility(4);
    AppMethodBeat.o(197458);
  }
  
  public final void bCa()
  {
    AppMethodBeat.i(197459);
    this.mSB.setVisibility(4);
    this.mSC.setVisibility(4);
    this.mSv = null;
    AppMethodBeat.o(197459);
  }
  
  public final void em(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(176802);
    this.mSs = ep(paramInt1, paramInt2);
    AppMethodBeat.o(176802);
  }
  
  public final void en(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(176803);
    this.mSt = eq(paramInt1, paramInt2);
    AppMethodBeat.o(176803);
  }
  
  public final void eo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(197462);
    if (this.mSu == null)
    {
      AppMethodBeat.o(197462);
      return;
    }
    Iterator localIterator = this.mSu.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).eh(paramInt1, paramInt2);
    }
    AppMethodBeat.o(197462);
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
      i = vS(paramInt2);
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
    if (this.mSj != null)
    {
      i = this.mSj.intValue();
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
    ad.d("MicroMsg.AppBrand.AppBrandPipContainerView", "getStablePosX, mStablePosX: " + this.mSs);
    int i = this.mSs;
    AppMethodBeat.o(176804);
    return i;
  }
  
  public final int getStablePosY()
  {
    AppMethodBeat.i(176805);
    ad.d("MicroMsg.AppBrand.AppBrandPipContainerView", "getStablePosY, mStablePosY: " + this.mSt);
    int i = this.mSt;
    AppMethodBeat.o(176805);
    return i;
  }
  
  public final int getTargetPositionXWhenOrientationChanged()
  {
    AppMethodBeat.i(176819);
    int i = getMinX();
    if (!this.mSq) {
      i = vR(getWidth());
    }
    AppMethodBeat.o(176819);
    return i;
  }
  
  public final void hU(boolean paramBoolean)
  {
    AppMethodBeat.i(197457);
    ad.i("MicroMsg.AppBrand.AppBrandPipContainerView", "enableShadow, isEnabled: ".concat(String.valueOf(paramBoolean)));
    this.mSH = paramBoolean;
    if (paramBoolean)
    {
      if (this.mSI != null)
      {
        ad.i("MicroMsg.AppBrand.AppBrandPipContainerView", "enableShadow, setShadowDrawable");
        ab.b(this.mSD, this.mSI);
        AppMethodBeat.o(197457);
      }
    }
    else {
      ab.b(this.mSD, null);
    }
    AppMethodBeat.o(197457);
  }
  
  public final void hV(boolean paramBoolean)
  {
    AppMethodBeat.i(176797);
    ad.i("MicroMsg.AppBrand.AppBrandPipContainerView", "enableTouch");
    View localView = this.mSz;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localView.setVisibility(i);
      this.mSF = true;
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
    if (mSi == this.mSl)
    {
      this.mSl = new Point(localView.getWidth(), localView.getHeight());
      ad.i("MicroMsg.AppBrand.AppBrandPipContainerView", "onLayout, mParentViewSize: " + this.mSl);
      a(getY(), true);
    }
    AppMethodBeat.o(176794);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(176793);
    if (!this.mSF)
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
        this.mSm = false;
        this.gKx.x = paramMotionEvent.getRawX();
        this.gKx.y = paramMotionEvent.getRawY();
        this.mSn.x = ((int)getX());
        this.mSn.y = ((int)getY());
        ad.i("MicroMsg.AppBrand.AppBrandPipContainerView", "recordPositionWhenActionDown, fingerPosOnDown: " + this.gKx + ", viewPosOnDown: " + this.mSn);
        continue;
        if ((!this.mSm) && (E(paramMotionEvent))) {
          this.mSm = true;
        }
        if (this.mSm) {
          K(F(paramMotionEvent), G(paramMotionEvent));
        }
      }
    } while ((!this.mSm) && (!E(paramMotionEvent)));
    if (this.mSm) {
      this.mSm = false;
    }
    int i = F(paramMotionEvent);
    int j = getWidth();
    int k = G(paramMotionEvent);
    int m = getHeight();
    ad.i("MicroMsg.AppBrand.AppBrandPipContainerView", "onTouchEvent, startPositionX: " + i + ", width: " + j + ", startPositionY: " + k + ", height: " + m);
    z(i, k, ep(i, j), eq(k, m));
    AppMethodBeat.o(176793);
    return true;
  }
  
  public final void setOnCloseButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(176799);
    this.mSz.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(176799);
  }
  
  public final void setStablePos(Point paramPoint)
  {
    AppMethodBeat.i(197461);
    ad.d("MicroMsg.AppBrand.AppBrandPipContainerView", "setStablePos, stablePos: ".concat(String.valueOf(paramPoint)));
    this.mSs = paramPoint.x;
    this.mSt = paramPoint.y;
    this.mSr = true;
    AppMethodBeat.o(197461);
  }
  
  public final int vR(int paramInt)
  {
    AppMethodBeat.i(176815);
    int i = this.mSl.x;
    int k = getMarginHorizontal();
    int j = i - paramInt - k;
    i = j;
    if (j < 0) {
      i = this.hqT.x - paramInt - k;
    }
    AppMethodBeat.o(176815);
    return i;
  }
  
  public final int vS(int paramInt)
  {
    AppMethodBeat.i(176817);
    int i = this.mSl.y;
    int k = getMarginBottom();
    int j = i - paramInt - k;
    i = j;
    if (j < 0) {
      i = this.hqT.y - paramInt - k;
    }
    AppMethodBeat.o(176817);
    return i;
  }
  
  public final void z(final int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4)
  {
    AppMethodBeat.i(176813);
    if ((this.mSx != null) && (this.mSx.isRunning())) {
      this.mSx.cancel();
    }
    this.mSx = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.mSx.setInterpolator(new AccelerateDecelerateInterpolator());
    this.mSx.setDuration(100L);
    this.mSx.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
    this.mSx.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(176791);
        super.onAnimationEnd(paramAnonymousAnimator);
        AppBrandPipContainerView.a(AppBrandPipContainerView.this, AppBrandPipContainerView.this.getY());
        AppBrandPipContainerView.a(AppBrandPipContainerView.this, paramInt3);
        AppBrandPipContainerView.b(AppBrandPipContainerView.this, paramInt4);
        ad.i("MicroMsg.AppBrand.AppBrandPipContainerView", "startStickyAnimation, mStablePosX: " + AppBrandPipContainerView.a(AppBrandPipContainerView.this) + ", mStablePosY: " + AppBrandPipContainerView.b(AppBrandPipContainerView.this));
        AppBrandPipContainerView.a(AppBrandPipContainerView.this, AppBrandPipContainerView.a(AppBrandPipContainerView.this), AppBrandPipContainerView.b(AppBrandPipContainerView.this));
        AppMethodBeat.o(176791);
      }
    });
    this.mSx.start();
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