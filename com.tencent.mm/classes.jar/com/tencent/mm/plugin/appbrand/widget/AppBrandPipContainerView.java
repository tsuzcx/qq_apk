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
import com.tencent.mm.plugin.appbrand.ui.ai;
import com.tencent.mm.plugin.appbrand.ui.ai.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class AppBrandPipContainerView
  extends FrameLayout
{
  public static final int oka;
  public static final int okb;
  public static final int okc;
  public static final int okd;
  public static final int oke;
  public static final int okf;
  public static final int okg;
  public static final int okh;
  private static final int oki;
  private static final int okj;
  private static final int okk;
  private static final int okl;
  private static final int okm;
  private static final int okn;
  public static final int oko;
  public static final int okp;
  public static final int okq;
  public static final int okr;
  public static final int oks;
  public static final int okt;
  private static final int oku;
  private static final Point okv;
  public Point inq;
  public int mCurOrientation;
  private int nCG;
  private PointF okA;
  private PointF okB;
  public float okC;
  private boolean okD;
  public boolean okE;
  public int okF;
  public int okG;
  public Set<a> okH;
  private Float okI;
  public ViewOutlineProvider okJ;
  private ValueAnimator okK;
  public ViewGroup okL;
  private View okM;
  public View okN;
  private ViewGroup okO;
  private View okP;
  private View okQ;
  private View okR;
  private boolean okS;
  public boolean okT;
  private boolean okU;
  private ai okV;
  public Integer okw;
  private int okx;
  public Point oky;
  private boolean okz;
  
  static
  {
    AppMethodBeat.i(176823);
    oka = a.fromDPToPix(MMApplicationContext.getContext(), 196);
    okb = a.fromDPToPix(MMApplicationContext.getContext(), 119);
    okc = a.fromDPToPix(MMApplicationContext.getContext(), 176);
    okd = a.fromDPToPix(MMApplicationContext.getContext(), 99);
    oke = a.fromDPToPix(MMApplicationContext.getContext(), 119);
    okf = a.fromDPToPix(MMApplicationContext.getContext(), 196);
    okg = a.fromDPToPix(MMApplicationContext.getContext(), 99);
    okh = a.fromDPToPix(MMApplicationContext.getContext(), 176);
    oki = a.fromDPToPix(MMApplicationContext.getContext(), 32);
    okj = a.fromDPToPix(MMApplicationContext.getContext(), 56);
    okk = a.fromDPToPix(MMApplicationContext.getContext(), 52);
    okl = a.fromDPToPix(MMApplicationContext.getContext(), 6);
    okm = a.fromDPToPix(MMApplicationContext.getContext(), 80);
    okn = a.fromDPToPix(MMApplicationContext.getContext(), 52);
    oko = a.fromDPToPix(MMApplicationContext.getContext(), 8);
    okp = a.fromDPToPix(MMApplicationContext.getContext(), 10);
    okq = a.fromDPToPix(MMApplicationContext.getContext(), 12);
    okr = a.fromDPToPix(MMApplicationContext.getContext(), 1);
    oks = a.fromDPToPix(MMApplicationContext.getContext(), 10);
    okt = a.fromDPToPix(MMApplicationContext.getContext(), 2);
    oku = a.fromDPToPix(MMApplicationContext.getContext(), 1);
    okv = new Point();
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
    this.okw = null;
    this.oky = okv;
    this.inq = okv;
    this.okz = false;
    this.okA = new PointF();
    this.okB = new PointF();
    this.okC = -1.0F;
    this.okD = false;
    this.okE = false;
    this.okH = null;
    this.nCG = okc;
    this.okI = null;
    this.okJ = new AppBrandPipContainerView.1(this);
    this.okS = true;
    this.okT = true;
    this.okU = false;
    this.okV = null;
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131493062, this);
    setBackgroundColor(0);
    this.okQ = paramAttributeSet.findViewById(2131296877);
    this.okR = paramAttributeSet.findViewById(2131296876);
    this.okR.setOutlineProvider(this.okJ);
    this.okR.setClipToOutline(true);
    this.okL = ((ViewGroup)paramAttributeSet.findViewById(2131296878));
    this.okM = paramAttributeSet.findViewById(2131296875);
    this.okN = paramAttributeSet.findViewById(2131296881);
    this.okN.setVisibility(4);
    this.okO = ((ViewGroup)paramAttributeSet.findViewById(2131296882));
    this.okO.setVisibility(4);
    this.okP = paramAttributeSet.findViewById(2131296883);
    this.okP.setVisibility(4);
    b(this.nCG, okp, oko, okq, okr, oks, okt);
    this.okx = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.mCurOrientation = paramContext.getResources().getConfiguration().orientation;
    this.inq = az(paramContext);
    Log.i("MicroMsg.AppBrand.AppBrandPipContainerView", "init, mScreenSize: " + this.inq);
    AppMethodBeat.o(176792);
  }
  
  private boolean G(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(176806);
    if ((Math.abs(paramMotionEvent.getRawX() - this.okA.x) > this.okx) || (Math.abs(paramMotionEvent.getRawY() - this.okA.y) > this.okx))
    {
      AppMethodBeat.o(176806);
      return true;
    }
    AppMethodBeat.o(176806);
    return false;
  }
  
  private int H(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(176807);
    int j = this.oky.x;
    int i = j;
    if (j <= 0)
    {
      i = this.inq.x;
      Log.w("MicroMsg.AppBrand.AppBrandPipContainerView", "getMotionEventNewPositionX, mParentViewSize: " + this.oky + ", mScreenSize: " + this.inq);
    }
    i = (int)Math.max(Math.min(this.okB.x + paramMotionEvent.getRawX() - this.okA.x, i - getWidth()), 0.0F);
    AppMethodBeat.o(176807);
    return i;
  }
  
  private int I(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(176808);
    int j = this.oky.y;
    int i = j;
    if (j <= 0)
    {
      i = this.inq.y;
      Log.w("MicroMsg.AppBrand.AppBrandPipContainerView", "getMotionEventNewPositionY, mParentViewSize: " + this.oky + ", mScreenSize: " + this.inq);
    }
    i = (int)Math.max(Math.min(this.okB.y + paramMotionEvent.getRawY() - this.okA.y, i - getHeight()), 0.0F);
    AppMethodBeat.o(176808);
    return i;
  }
  
  private void O(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(219609);
    float f1 = getX();
    float f2 = getX();
    if ((f1 != paramFloat1) || (f2 != paramFloat2))
    {
      setX(paramFloat1);
      setY(paramFloat2);
      a(paramFloat2, false);
    }
    AppMethodBeat.o(219609);
  }
  
  public static Point az(Context paramContext)
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
  
  private int eD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(176810);
    int i = getMinX();
    if (!eF(paramInt1, paramInt2)) {
      i = zL(paramInt2);
    }
    AppMethodBeat.o(176810);
    return i;
  }
  
  private boolean eF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(219610);
    int j = this.oky.x;
    int i = j;
    if (j <= 0)
    {
      i = this.inq.x;
      Log.w("MicroMsg.AppBrand.AppBrandPipContainerView", "isPositionLeft, mParentViewSize: " + this.oky + ", mScreenSize: " + this.inq);
    }
    if (paramInt2 / 2 + paramInt1 <= i / 2) {}
    for (boolean bool = true;; bool = false)
    {
      this.okD = bool;
      bool = this.okD;
      AppMethodBeat.o(219610);
      return bool;
    }
  }
  
  private int getMarginBottom()
  {
    if (1 == this.mCurOrientation) {
      return okn;
    }
    return okk;
  }
  
  private int getMarginHorizontal()
  {
    if (1 == this.mCurOrientation) {
      return okl;
    }
    return oki;
  }
  
  private int getMarginTopDefault()
  {
    if (1 == this.mCurOrientation) {
      return okm;
    }
    return okj;
  }
  
  public final void a(float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(176818);
    if (paramBoolean)
    {
      int i = getMinY();
      int j = zM(getHeight());
      this.okC = ((Math.min(Math.max(paramFloat, i), j) - i) / (j - i));
    }
    AppMethodBeat.o(176818);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(219606);
    if (this.okH == null) {
      this.okH = new HashSet();
    }
    this.okH.add(parama);
    AppMethodBeat.o(219606);
  }
  
  public final void aV(float paramFloat)
  {
    AppMethodBeat.i(176800);
    if (!this.okT)
    {
      AppMethodBeat.o(176800);
      return;
    }
    this.okO.setVisibility(0);
    this.okP.setVisibility(0);
    ViewGroup.LayoutParams localLayoutParams = this.okP.getLayoutParams();
    localLayoutParams.width = ((int)(this.nCG * paramFloat / 100.0F));
    this.okP.setLayoutParams(localLayoutParams);
    this.okI = Float.valueOf(paramFloat);
    AppMethodBeat.o(176800);
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    AppMethodBeat.i(176801);
    this.nCG = paramInt1;
    if (this.okI != null) {
      aV(this.okI.floatValue());
    }
    this.okQ.setPadding(paramInt2, paramInt3, paramInt2, paramInt4);
    Object localObject = (FrameLayout.LayoutParams)this.okR.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).leftMargin = paramInt2;
    ((FrameLayout.LayoutParams)localObject).rightMargin = paramInt2;
    ((FrameLayout.LayoutParams)localObject).topMargin = paramInt3;
    ((FrameLayout.LayoutParams)localObject).bottomMargin = paramInt4;
    this.okR.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new ai.a();
    ((ai.a)localObject).nYT = paramInt5;
    ((ai.a)localObject).nYW = Color.parseColor("#4C000000");
    ((ai.a)localObject).SE = paramInt6;
    ((ai.a)localObject).mOffsetX = 0;
    ((ai.a)localObject).mOffsetY = paramInt7;
    localObject = ((ai.a)localObject).bXO();
    if (this.okU)
    {
      ai.b(this.okQ, (Drawable)localObject);
      AppMethodBeat.o(176801);
      return;
    }
    this.okV = ((ai)localObject);
    AppMethodBeat.o(176801);
  }
  
  public final void bZX()
  {
    AppMethodBeat.i(176798);
    Log.i("MicroMsg.AppBrand.AppBrandPipContainerView", "disableTouch");
    this.okM.setVisibility(4);
    this.okS = false;
    AppMethodBeat.o(176798);
  }
  
  public final void bZY()
  {
    AppMethodBeat.i(219604);
    Log.i("MicroMsg.AppBrand.AppBrandPipContainerView", "showOnLoadEnd");
    this.okN.setVisibility(4);
    AppMethodBeat.o(219604);
  }
  
  public final void bZZ()
  {
    AppMethodBeat.i(219605);
    this.okO.setVisibility(4);
    this.okP.setVisibility(4);
    this.okI = null;
    AppMethodBeat.o(219605);
  }
  
  public final void eA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(176802);
    this.okF = eD(paramInt1, paramInt2);
    AppMethodBeat.o(176802);
  }
  
  public final void eB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(176803);
    this.okG = eE(paramInt1, paramInt2);
    AppMethodBeat.o(176803);
  }
  
  public final void eC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(219608);
    if (this.okH == null)
    {
      AppMethodBeat.o(219608);
      return;
    }
    Iterator localIterator = this.okH.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).ev(paramInt1, paramInt2);
    }
    AppMethodBeat.o(219608);
  }
  
  public final int eE(int paramInt1, int paramInt2)
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
      i = zM(paramInt2);
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
    if (this.okw != null)
    {
      i = this.okw.intValue();
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
    Log.d("MicroMsg.AppBrand.AppBrandPipContainerView", "getStablePosX, mStablePosX: " + this.okF);
    int i = this.okF;
    AppMethodBeat.o(176804);
    return i;
  }
  
  public final int getStablePosY()
  {
    AppMethodBeat.i(176805);
    Log.d("MicroMsg.AppBrand.AppBrandPipContainerView", "getStablePosY, mStablePosY: " + this.okG);
    int i = this.okG;
    AppMethodBeat.o(176805);
    return i;
  }
  
  public final int getTargetPositionXWhenOrientationChanged()
  {
    AppMethodBeat.i(176819);
    int i = getMinX();
    if (!this.okD) {
      i = zL(getWidth());
    }
    AppMethodBeat.o(176819);
    return i;
  }
  
  public final void iZ(boolean paramBoolean)
  {
    AppMethodBeat.i(219603);
    Log.i("MicroMsg.AppBrand.AppBrandPipContainerView", "enableShadow, isEnabled: ".concat(String.valueOf(paramBoolean)));
    this.okU = paramBoolean;
    if (paramBoolean)
    {
      if (this.okV != null)
      {
        Log.i("MicroMsg.AppBrand.AppBrandPipContainerView", "enableShadow, setShadowDrawable");
        ai.b(this.okQ, this.okV);
        AppMethodBeat.o(219603);
      }
    }
    else {
      ai.b(this.okQ, null);
    }
    AppMethodBeat.o(219603);
  }
  
  public final void ja(boolean paramBoolean)
  {
    AppMethodBeat.i(176797);
    Log.i("MicroMsg.AppBrand.AppBrandPipContainerView", "enableTouch");
    View localView = this.okM;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localView.setVisibility(i);
      this.okS = true;
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
      Log.w("MicroMsg.AppBrand.AppBrandPipContainerView", "onLayout, null == parentView");
      AppMethodBeat.o(176794);
      return;
    }
    if (okv == this.oky)
    {
      this.oky = new Point(localView.getWidth(), localView.getHeight());
      Log.i("MicroMsg.AppBrand.AppBrandPipContainerView", "onLayout, mParentViewSize: " + this.oky);
      a(getY(), true);
    }
    AppMethodBeat.o(176794);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(176793);
    if (!this.okS)
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
        this.okz = false;
        this.okA.x = paramMotionEvent.getRawX();
        this.okA.y = paramMotionEvent.getRawY();
        this.okB.x = ((int)getX());
        this.okB.y = ((int)getY());
        Log.i("MicroMsg.AppBrand.AppBrandPipContainerView", "recordPositionWhenActionDown, fingerPosOnDown: " + this.okA + ", viewPosOnDown: " + this.okB);
        continue;
        if ((!this.okz) && (G(paramMotionEvent))) {
          this.okz = true;
        }
        if (this.okz) {
          O(H(paramMotionEvent), I(paramMotionEvent));
        }
      }
    } while ((!this.okz) && (!G(paramMotionEvent)));
    if (this.okz) {
      this.okz = false;
    }
    int i = H(paramMotionEvent);
    int j = getWidth();
    int k = I(paramMotionEvent);
    int m = getHeight();
    Log.i("MicroMsg.AppBrand.AppBrandPipContainerView", "onTouchEvent, startPositionX: " + i + ", width: " + j + ", startPositionY: " + k + ", height: " + m);
    z(i, k, eD(i, j), eE(k, m));
    AppMethodBeat.o(176793);
    return true;
  }
  
  public final void setOnCloseButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(176799);
    this.okM.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(176799);
  }
  
  public final void setStablePos(Point paramPoint)
  {
    AppMethodBeat.i(219607);
    Log.d("MicroMsg.AppBrand.AppBrandPipContainerView", "setStablePos, stablePos: ".concat(String.valueOf(paramPoint)));
    this.okF = paramPoint.x;
    this.okG = paramPoint.y;
    this.okE = true;
    AppMethodBeat.o(219607);
  }
  
  public final void z(final int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4)
  {
    AppMethodBeat.i(176813);
    if ((this.okK != null) && (this.okK.isRunning())) {
      this.okK.cancel();
    }
    this.okK = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.okK.setInterpolator(new AccelerateDecelerateInterpolator());
    this.okK.setDuration(100L);
    this.okK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
    this.okK.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(176791);
        super.onAnimationEnd(paramAnonymousAnimator);
        AppBrandPipContainerView.a(AppBrandPipContainerView.this, AppBrandPipContainerView.this.getY());
        AppBrandPipContainerView.a(AppBrandPipContainerView.this, paramInt3);
        AppBrandPipContainerView.b(AppBrandPipContainerView.this, paramInt4);
        Log.i("MicroMsg.AppBrand.AppBrandPipContainerView", "startStickyAnimation, mStablePosX: " + AppBrandPipContainerView.a(AppBrandPipContainerView.this) + ", mStablePosY: " + AppBrandPipContainerView.b(AppBrandPipContainerView.this));
        AppBrandPipContainerView.a(AppBrandPipContainerView.this, AppBrandPipContainerView.a(AppBrandPipContainerView.this), AppBrandPipContainerView.b(AppBrandPipContainerView.this));
        AppMethodBeat.o(176791);
      }
    });
    this.okK.start();
    AppMethodBeat.o(176813);
  }
  
  public final int zL(int paramInt)
  {
    AppMethodBeat.i(176815);
    int i = this.oky.x;
    int k = getMarginHorizontal();
    int j = i - paramInt - k;
    i = j;
    if (j < 0) {
      i = this.inq.x - paramInt - k;
    }
    AppMethodBeat.o(176815);
    return i;
  }
  
  public final int zM(int paramInt)
  {
    AppMethodBeat.i(176817);
    int i = this.oky.y;
    int k = getMarginBottom();
    int j = i - paramInt - k;
    i = j;
    if (j < 0) {
      i = this.inq.y - paramInt - k;
    }
    AppMethodBeat.o(176817);
    return i;
  }
  
  public static abstract interface a
  {
    public abstract void ev(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView
 * JD-Core Version:    0.7.0.1
 */