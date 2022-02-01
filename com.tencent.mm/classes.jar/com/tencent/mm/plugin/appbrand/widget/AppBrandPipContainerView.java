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
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.appbrand.ui.z;
import com.tencent.mm.plugin.appbrand.ui.z.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class AppBrandPipContainerView
  extends FrameLayout
{
  public static final int mrA;
  public static final int mrB;
  private static final int mrC;
  private static final Point mrD;
  public static final int mri;
  public static final int mrj;
  public static final int mrk;
  public static final int mrl;
  public static final int mrm;
  public static final int mrn;
  public static final int mro;
  public static final int mrp;
  private static final int mrq;
  private static final int mrr;
  private static final int mrs;
  private static final int mrt;
  private static final int mru;
  private static final int mrv;
  public static final int mrw;
  public static final int mrx;
  public static final int mry;
  public static final int mrz;
  public Point gYN;
  private PointF gqN;
  private int lNl;
  public int mCurOrientation;
  public Integer mrE;
  private int mrF;
  public Point mrG;
  private boolean mrH;
  private PointF mrI;
  public float mrJ;
  private boolean mrK;
  public boolean mrL;
  public int mrM;
  public int mrN;
  public Set<a> mrO;
  private Float mrP;
  public ViewOutlineProvider mrQ;
  private ValueAnimator mrR;
  public ViewGroup mrS;
  private View mrT;
  public View mrU;
  private ViewGroup mrV;
  private View mrW;
  private View mrX;
  private View mrY;
  private boolean mrZ;
  public boolean msa;
  private boolean msb;
  private z msc;
  
  static
  {
    AppMethodBeat.i(176823);
    mri = a.fromDPToPix(ai.getContext(), 196);
    mrj = a.fromDPToPix(ai.getContext(), 119);
    mrk = a.fromDPToPix(ai.getContext(), 176);
    mrl = a.fromDPToPix(ai.getContext(), 99);
    mrm = a.fromDPToPix(ai.getContext(), 119);
    mrn = a.fromDPToPix(ai.getContext(), 196);
    mro = a.fromDPToPix(ai.getContext(), 99);
    mrp = a.fromDPToPix(ai.getContext(), 176);
    mrq = a.fromDPToPix(ai.getContext(), 32);
    mrr = a.fromDPToPix(ai.getContext(), 56);
    mrs = a.fromDPToPix(ai.getContext(), 52);
    mrt = a.fromDPToPix(ai.getContext(), 6);
    mru = a.fromDPToPix(ai.getContext(), 80);
    mrv = a.fromDPToPix(ai.getContext(), 52);
    mrw = a.fromDPToPix(ai.getContext(), 8);
    mrx = a.fromDPToPix(ai.getContext(), 10);
    mry = a.fromDPToPix(ai.getContext(), 12);
    mrz = a.fromDPToPix(ai.getContext(), 1);
    mrA = a.fromDPToPix(ai.getContext(), 10);
    mrB = a.fromDPToPix(ai.getContext(), 2);
    mrC = a.fromDPToPix(ai.getContext(), 1);
    mrD = new Point();
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
    this.mrE = null;
    this.mrG = mrD;
    this.gYN = mrD;
    this.mrH = false;
    this.gqN = new PointF();
    this.mrI = new PointF();
    this.mrJ = -1.0F;
    this.mrK = false;
    this.mrL = false;
    this.mrO = null;
    this.lNl = mrk;
    this.mrP = null;
    this.mrQ = new ViewOutlineProvider()
    {
      public final void getOutline(View paramAnonymousView, Outline paramAnonymousOutline)
      {
        AppMethodBeat.i(176789);
        paramAnonymousOutline.setRoundRect(new Rect(0, 0, paramAnonymousView.getWidth(), paramAnonymousView.getHeight()), AppBrandPipContainerView.mrC);
        AppMethodBeat.o(176789);
      }
    };
    this.mrZ = true;
    this.msa = true;
    this.msb = false;
    this.msc = null;
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131493023, this);
    setBackgroundColor(0);
    this.mrX = paramAttributeSet.findViewById(2131296795);
    this.mrY = paramAttributeSet.findViewById(2131296794);
    this.mrY.setOutlineProvider(this.mrQ);
    this.mrY.setClipToOutline(true);
    this.mrS = ((ViewGroup)paramAttributeSet.findViewById(2131296796));
    this.mrT = paramAttributeSet.findViewById(2131296793);
    this.mrU = paramAttributeSet.findViewById(2131296797);
    this.mrU.setVisibility(4);
    this.mrV = ((ViewGroup)paramAttributeSet.findViewById(2131296798));
    this.mrV.setVisibility(4);
    this.mrW = paramAttributeSet.findViewById(2131296799);
    this.mrW.setVisibility(4);
    b(this.lNl, mrx, mrw, mry, mrz, mrA, mrB);
    this.mrF = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.mCurOrientation = paramContext.getResources().getConfiguration().orientation;
    this.gYN = cl(paramContext);
    ac.i("MicroMsg.AppBrand.AppBrandPipContainerView", "init, mScreenSize: " + this.gYN);
    AppMethodBeat.o(176792);
  }
  
  private boolean G(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(176806);
    if ((Math.abs(paramMotionEvent.getRawX() - this.gqN.x) > this.mrF) || (Math.abs(paramMotionEvent.getRawY() - this.gqN.y) > this.mrF))
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
    int j = this.mrG.x;
    int i = j;
    if (j <= 0)
    {
      i = this.gYN.x;
      ac.w("MicroMsg.AppBrand.AppBrandPipContainerView", "getMotionEventNewPositionX, mParentViewSize: " + this.mrG + ", mScreenSize: " + this.gYN);
    }
    i = (int)Math.max(Math.min(this.mrI.x + paramMotionEvent.getRawX() - this.gqN.x, i - getWidth()), 0.0F);
    AppMethodBeat.o(176807);
    return i;
  }
  
  private int I(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(176808);
    int j = this.mrG.y;
    int i = j;
    if (j <= 0)
    {
      i = this.gYN.y;
      ac.w("MicroMsg.AppBrand.AppBrandPipContainerView", "getMotionEventNewPositionY, mParentViewSize: " + this.mrG + ", mScreenSize: " + this.gYN);
    }
    i = (int)Math.max(Math.min(this.mrI.y + paramMotionEvent.getRawY() - this.gqN.y, i - getHeight()), 0.0F);
    AppMethodBeat.o(176808);
    return i;
  }
  
  public static Point cl(Context paramContext)
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
  
  private int en(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(176810);
    int i = getMinX();
    if (!ep(paramInt1, paramInt2)) {
      i = vl(paramInt2);
    }
    AppMethodBeat.o(176810);
    return i;
  }
  
  private boolean ep(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193542);
    int j = this.mrG.x;
    int i = j;
    if (j <= 0)
    {
      i = this.gYN.x;
      ac.w("MicroMsg.AppBrand.AppBrandPipContainerView", "isPositionLeft, mParentViewSize: " + this.mrG + ", mScreenSize: " + this.gYN);
    }
    if (paramInt2 / 2 + paramInt1 <= i / 2) {}
    for (boolean bool = true;; bool = false)
    {
      this.mrK = bool;
      bool = this.mrK;
      AppMethodBeat.o(193542);
      return bool;
    }
  }
  
  private int getMarginBottom()
  {
    if (1 == this.mCurOrientation) {
      return mrv;
    }
    return mrs;
  }
  
  private int getMarginHorizontal()
  {
    if (1 == this.mCurOrientation) {
      return mrt;
    }
    return mrq;
  }
  
  private int getMarginTopDefault()
  {
    if (1 == this.mCurOrientation) {
      return mru;
    }
    return mrr;
  }
  
  public final void a(float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(176818);
    if (paramBoolean)
    {
      int i = getMinY();
      int j = vm(getHeight());
      this.mrJ = ((Math.min(Math.max(paramFloat, i), j) - i) / (j - i));
    }
    AppMethodBeat.o(176818);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(193539);
    if (this.mrO == null) {
      this.mrO = new HashSet();
    }
    this.mrO.add(parama);
    AppMethodBeat.o(193539);
  }
  
  public final void aI(float paramFloat)
  {
    AppMethodBeat.i(176800);
    if (!this.msa)
    {
      AppMethodBeat.o(176800);
      return;
    }
    this.mrV.setVisibility(0);
    this.mrW.setVisibility(0);
    ViewGroup.LayoutParams localLayoutParams = this.mrW.getLayoutParams();
    localLayoutParams.width = ((int)(this.lNl * paramFloat / 100.0F));
    this.mrW.setLayoutParams(localLayoutParams);
    this.mrP = Float.valueOf(paramFloat);
    AppMethodBeat.o(176800);
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    AppMethodBeat.i(176801);
    this.lNl = paramInt1;
    if (this.mrP != null) {
      aI(this.mrP.floatValue());
    }
    this.mrX.setPadding(paramInt2, paramInt3, paramInt2, paramInt4);
    Object localObject = (FrameLayout.LayoutParams)this.mrY.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).leftMargin = paramInt2;
    ((FrameLayout.LayoutParams)localObject).rightMargin = paramInt2;
    ((FrameLayout.LayoutParams)localObject).topMargin = paramInt3;
    ((FrameLayout.LayoutParams)localObject).bottomMargin = paramInt4;
    this.mrY.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new z.a();
    ((z.a)localObject).mgg = paramInt5;
    ((z.a)localObject).mgj = Color.parseColor("#4C000000");
    ((z.a)localObject).QC = paramInt6;
    ((z.a)localObject).mOffsetX = 0;
    ((z.a)localObject).mOffsetY = paramInt7;
    localObject = ((z.a)localObject).bvI();
    if (this.msb)
    {
      z.b(this.mrX, (Drawable)localObject);
      AppMethodBeat.o(176801);
      return;
    }
    this.msc = ((z)localObject);
    AppMethodBeat.o(176801);
  }
  
  public final void bxS()
  {
    AppMethodBeat.i(176798);
    ac.i("MicroMsg.AppBrand.AppBrandPipContainerView", "disableTouch");
    this.mrT.setVisibility(4);
    this.mrZ = false;
    AppMethodBeat.o(176798);
  }
  
  public final void bxT()
  {
    AppMethodBeat.i(193537);
    this.mrU.setVisibility(4);
    AppMethodBeat.o(193537);
  }
  
  public final void bxU()
  {
    AppMethodBeat.i(193538);
    this.mrV.setVisibility(4);
    this.mrW.setVisibility(4);
    this.mrP = null;
    AppMethodBeat.o(193538);
  }
  
  public final void ek(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(176802);
    this.mrM = en(paramInt1, paramInt2);
    AppMethodBeat.o(176802);
  }
  
  public final void el(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(176803);
    this.mrN = eo(paramInt1, paramInt2);
    AppMethodBeat.o(176803);
  }
  
  public final void em(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193541);
    if (this.mrO == null)
    {
      AppMethodBeat.o(193541);
      return;
    }
    Iterator localIterator = this.mrO.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).ef(paramInt1, paramInt2);
    }
    AppMethodBeat.o(193541);
  }
  
  public final int eo(int paramInt1, int paramInt2)
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
      i = vm(paramInt2);
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
    if (this.mrE != null)
    {
      i = this.mrE.intValue();
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
    ac.d("MicroMsg.AppBrand.AppBrandPipContainerView", "getStablePosX, mStablePosX: " + this.mrM);
    int i = this.mrM;
    AppMethodBeat.o(176804);
    return i;
  }
  
  public final int getStablePosY()
  {
    AppMethodBeat.i(176805);
    ac.d("MicroMsg.AppBrand.AppBrandPipContainerView", "getStablePosY, mStablePosY: " + this.mrN);
    int i = this.mrN;
    AppMethodBeat.o(176805);
    return i;
  }
  
  public final int getTargetPositionXWhenOrientationChanged()
  {
    AppMethodBeat.i(176819);
    int i = getMinX();
    if (!this.mrK) {
      i = vl(getWidth());
    }
    AppMethodBeat.o(176819);
    return i;
  }
  
  public final void hK(boolean paramBoolean)
  {
    AppMethodBeat.i(193536);
    ac.i("MicroMsg.AppBrand.AppBrandPipContainerView", "enableShadow, isEnabled: ".concat(String.valueOf(paramBoolean)));
    this.msb = paramBoolean;
    if (paramBoolean)
    {
      if (this.msc != null)
      {
        ac.i("MicroMsg.AppBrand.AppBrandPipContainerView", "enableShadow, setShadowDrawable");
        z.b(this.mrX, this.msc);
        AppMethodBeat.o(193536);
      }
    }
    else {
      z.b(this.mrX, null);
    }
    AppMethodBeat.o(193536);
  }
  
  public final void hL(boolean paramBoolean)
  {
    AppMethodBeat.i(176797);
    ac.i("MicroMsg.AppBrand.AppBrandPipContainerView", "enableTouch");
    View localView = this.mrT;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localView.setVisibility(i);
      this.mrZ = true;
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
      ac.w("MicroMsg.AppBrand.AppBrandPipContainerView", "onLayout, null == parentView");
      AppMethodBeat.o(176794);
      return;
    }
    if (mrD == this.mrG)
    {
      this.mrG = new Point(localView.getWidth(), localView.getHeight());
      ac.i("MicroMsg.AppBrand.AppBrandPipContainerView", "onLayout, mParentViewSize: " + this.mrG);
      a(getY(), true);
    }
    AppMethodBeat.o(176794);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(176793);
    if (!this.mrZ)
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
      this.mrH = false;
      this.gqN.x = paramMotionEvent.getRawX();
      this.gqN.y = paramMotionEvent.getRawY();
      this.mrI.x = ((int)getX());
      this.mrI.y = ((int)getY());
      ac.i("MicroMsg.AppBrand.AppBrandPipContainerView", "recordPositionWhenActionDown, fingerPosOnDown: " + this.gqN + ", viewPosOnDown: " + this.mrI);
      continue;
      if ((!this.mrH) && (G(paramMotionEvent))) {
        this.mrH = true;
      }
      if (this.mrH)
      {
        d(H(paramMotionEvent), I(paramMotionEvent), false);
        continue;
        if ((this.mrH) || (G(paramMotionEvent))) {
          break;
        }
        d(this.mrI.x, this.mrI.y, true);
        i = (int)this.mrI.x;
        j = (int)this.mrI.y;
        ac.i("MicroMsg.AppBrand.AppBrandPipContainerView", "onTouchEvent, posX: " + i + ", posY: " + j);
        ek(i, getWidth());
        el(j, getHeight());
        ac.i("MicroMsg.AppBrand.AppBrandPipContainerView", "onTouchEvent, mStablePosX: " + this.mrM + ", mStablePosY: " + this.mrN);
        em(this.mrM, this.mrN);
      }
    }
    if (this.mrH) {
      this.mrH = false;
    }
    int i = H(paramMotionEvent);
    int j = getWidth();
    int k = I(paramMotionEvent);
    int m = getHeight();
    ac.i("MicroMsg.AppBrand.AppBrandPipContainerView", "onTouchEvent, startPositionX: " + i + ", width: " + j + ", startPositionY: " + k + ", height: " + m);
    y(i, k, en(i, j), eo(k, m));
    AppMethodBeat.o(176793);
    return true;
  }
  
  public final void setOnCloseButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(176799);
    this.mrT.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(176799);
  }
  
  public final void setStablePos(Point paramPoint)
  {
    AppMethodBeat.i(193540);
    ac.d("MicroMsg.AppBrand.AppBrandPipContainerView", "setStablePos, stablePos: ".concat(String.valueOf(paramPoint)));
    this.mrM = paramPoint.x;
    this.mrN = paramPoint.y;
    this.mrL = true;
    AppMethodBeat.o(193540);
  }
  
  public final int vl(int paramInt)
  {
    AppMethodBeat.i(176815);
    int i = this.mrG.x;
    int k = getMarginHorizontal();
    int j = i - paramInt - k;
    i = j;
    if (j < 0) {
      i = this.gYN.x - paramInt - k;
    }
    AppMethodBeat.o(176815);
    return i;
  }
  
  public final int vm(int paramInt)
  {
    AppMethodBeat.i(176817);
    int i = this.mrG.y;
    int k = getMarginBottom();
    int j = i - paramInt - k;
    i = j;
    if (j < 0) {
      i = this.gYN.y - paramInt - k;
    }
    AppMethodBeat.o(176817);
    return i;
  }
  
  public final void y(final int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4)
  {
    AppMethodBeat.i(176813);
    if ((this.mrR != null) && (this.mrR.isRunning())) {
      this.mrR.cancel();
    }
    this.mrR = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.mrR.setInterpolator(new AccelerateDecelerateInterpolator());
    this.mrR.setDuration(100L);
    this.mrR.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
    this.mrR.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(176791);
        super.onAnimationEnd(paramAnonymousAnimator);
        AppBrandPipContainerView.a(AppBrandPipContainerView.this, AppBrandPipContainerView.this.getY());
        AppBrandPipContainerView.a(AppBrandPipContainerView.this, paramInt3);
        AppBrandPipContainerView.b(AppBrandPipContainerView.this, paramInt4);
        ac.i("MicroMsg.AppBrand.AppBrandPipContainerView", "startStickyAnimation, mStablePosX: " + AppBrandPipContainerView.a(AppBrandPipContainerView.this) + ", mStablePosY: " + AppBrandPipContainerView.b(AppBrandPipContainerView.this));
        AppBrandPipContainerView.a(AppBrandPipContainerView.this, AppBrandPipContainerView.a(AppBrandPipContainerView.this), AppBrandPipContainerView.b(AppBrandPipContainerView.this));
        AppMethodBeat.o(176791);
      }
    });
    this.mrR.start();
    AppMethodBeat.o(176813);
  }
  
  public static abstract interface a
  {
    public abstract void ef(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView
 * JD-Core Version:    0.7.0.1
 */