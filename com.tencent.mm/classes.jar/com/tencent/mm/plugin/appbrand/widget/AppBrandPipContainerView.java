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
import com.tencent.luggage.wxa.a.d;
import com.tencent.luggage.wxa.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
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
  private static final int rmA;
  private static final int rmB;
  private static final int rmC;
  private static final int rmD;
  private static final int rmE;
  private static final int rmF;
  public static final int rmG;
  public static final int rmH;
  public static final int rmI;
  public static final int rmJ;
  public static final int rmK;
  public static final int rmL;
  private static final int rmM;
  private static final Point rmN;
  public static final int rms;
  public static final int rmt;
  public static final int rmu;
  public static final int rmv;
  public static final int rmw;
  public static final int rmx;
  public static final int rmy;
  public static final int rmz;
  public Point lct;
  public int mCurOrientation;
  private int qER;
  public Integer rmO;
  private int rmP;
  public Point rmQ;
  private boolean rmR;
  private PointF rmS;
  private PointF rmT;
  public float rmU;
  private boolean rmV;
  public boolean rmW;
  public int rmX;
  public int rmY;
  public Set<a> rmZ;
  private Float rna;
  public ViewOutlineProvider rnb;
  private ValueAnimator rnc;
  public ViewGroup rnd;
  private View rne;
  public View rnf;
  private ViewGroup rng;
  private View rnh;
  private View rni;
  private View rnj;
  private boolean rnk;
  public boolean rnl;
  private boolean rnm;
  private ai rnn;
  
  static
  {
    AppMethodBeat.i(176823);
    rms = a.fromDPToPix(MMApplicationContext.getContext(), 196);
    rmt = a.fromDPToPix(MMApplicationContext.getContext(), 119);
    rmu = a.fromDPToPix(MMApplicationContext.getContext(), 176);
    rmv = a.fromDPToPix(MMApplicationContext.getContext(), 99);
    rmw = a.fromDPToPix(MMApplicationContext.getContext(), 119);
    rmx = a.fromDPToPix(MMApplicationContext.getContext(), 196);
    rmy = a.fromDPToPix(MMApplicationContext.getContext(), 99);
    rmz = a.fromDPToPix(MMApplicationContext.getContext(), 176);
    rmA = a.fromDPToPix(MMApplicationContext.getContext(), 32);
    rmB = a.fromDPToPix(MMApplicationContext.getContext(), 56);
    rmC = a.fromDPToPix(MMApplicationContext.getContext(), 52);
    rmD = a.fromDPToPix(MMApplicationContext.getContext(), 6);
    rmE = a.fromDPToPix(MMApplicationContext.getContext(), 80);
    rmF = a.fromDPToPix(MMApplicationContext.getContext(), 52);
    rmG = a.fromDPToPix(MMApplicationContext.getContext(), 8);
    rmH = a.fromDPToPix(MMApplicationContext.getContext(), 10);
    rmI = a.fromDPToPix(MMApplicationContext.getContext(), 12);
    rmJ = a.fromDPToPix(MMApplicationContext.getContext(), 1);
    rmK = a.fromDPToPix(MMApplicationContext.getContext(), 10);
    rmL = a.fromDPToPix(MMApplicationContext.getContext(), 2);
    rmM = a.fromDPToPix(MMApplicationContext.getContext(), 1);
    rmN = new Point();
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
    this.rmO = null;
    this.rmQ = rmN;
    this.lct = rmN;
    this.rmR = false;
    this.rmS = new PointF();
    this.rmT = new PointF();
    this.rmU = -1.0F;
    this.rmV = false;
    this.rmW = false;
    this.rmZ = null;
    this.qER = rmu;
    this.rna = null;
    this.rnb = new ViewOutlineProvider()
    {
      public final void getOutline(View paramAnonymousView, Outline paramAnonymousOutline)
      {
        AppMethodBeat.i(176789);
        paramAnonymousOutline.setRoundRect(new Rect(0, 0, paramAnonymousView.getWidth(), paramAnonymousView.getHeight()), AppBrandPipContainerView.rmM);
        AppMethodBeat.o(176789);
      }
    };
    this.rnk = true;
    this.rnl = true;
    this.rnm = false;
    this.rnn = null;
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(a.e.app_brand_pip_container_view, this);
    setBackgroundColor(0);
    this.rni = paramAttributeSet.findViewById(a.d.app_brand_pip_container_bg);
    this.rnj = paramAttributeSet.findViewById(a.d.app_brand_pip_container);
    this.rnj.setOutlineProvider(this.rnb);
    this.rnj.setClipToOutline(true);
    this.rnd = ((ViewGroup)paramAttributeSet.findViewById(a.d.app_brand_pip_video_container));
    this.rne = paramAttributeSet.findViewById(a.d.app_brand_pip_close_btn);
    this.rnf = paramAttributeSet.findViewById(a.d.app_brand_pip_video_loading_view);
    this.rnf.setVisibility(4);
    this.rng = ((ViewGroup)paramAttributeSet.findViewById(a.d.app_brand_pip_video_progress_container));
    this.rng.setVisibility(4);
    this.rnh = paramAttributeSet.findViewById(a.d.app_brand_pip_video_progress_view);
    this.rnh.setVisibility(4);
    a(this.qER, rmH, rmG, rmI, rmJ, rmK, rmL);
    this.rmP = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.mCurOrientation = paramContext.getResources().getConfiguration().orientation;
    this.lct = au(paramContext);
    Log.i("MicroMsg.AppBrand.AppBrandPipContainerView", "init, mScreenSize: " + this.lct);
    AppMethodBeat.o(176792);
  }
  
  private boolean F(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(176806);
    if ((Math.abs(paramMotionEvent.getRawX() - this.rmS.x) > this.rmP) || (Math.abs(paramMotionEvent.getRawY() - this.rmS.y) > this.rmP))
    {
      AppMethodBeat.o(176806);
      return true;
    }
    AppMethodBeat.o(176806);
    return false;
  }
  
  private int G(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(176807);
    int j = this.rmQ.x;
    int i = j;
    if (j <= 0)
    {
      i = this.lct.x;
      Log.w("MicroMsg.AppBrand.AppBrandPipContainerView", "getMotionEventNewPositionX, mParentViewSize: " + this.rmQ + ", mScreenSize: " + this.lct);
    }
    i = (int)Math.max(Math.min(this.rmT.x + paramMotionEvent.getRawX() - this.rmS.x, i - getWidth()), 0.0F);
    AppMethodBeat.o(176807);
    return i;
  }
  
  private int H(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(176808);
    int j = this.rmQ.y;
    int i = j;
    if (j <= 0)
    {
      i = this.lct.y;
      Log.w("MicroMsg.AppBrand.AppBrandPipContainerView", "getMotionEventNewPositionY, mParentViewSize: " + this.rmQ + ", mScreenSize: " + this.lct);
    }
    i = (int)Math.max(Math.min(this.rmT.y + paramMotionEvent.getRawY() - this.rmS.y, i - getHeight()), 0.0F);
    AppMethodBeat.o(176808);
    return i;
  }
  
  private void P(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(244401);
    float f1 = getX();
    float f2 = getX();
    if ((f1 != paramFloat1) || (f2 != paramFloat2))
    {
      setX(paramFloat1);
      setY(paramFloat2);
      a(paramFloat2, false);
    }
    AppMethodBeat.o(244401);
  }
  
  public static Point au(Context paramContext)
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
  
  private int fc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(176810);
    int i = getMinX();
    if (!fe(paramInt1, paramInt2)) {
      i = Du(paramInt2);
    }
    AppMethodBeat.o(176810);
    return i;
  }
  
  private boolean fe(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(244403);
    int j = this.rmQ.x;
    int i = j;
    if (j <= 0)
    {
      i = this.lct.x;
      Log.w("MicroMsg.AppBrand.AppBrandPipContainerView", "isPositionLeft, mParentViewSize: " + this.rmQ + ", mScreenSize: " + this.lct);
    }
    if (paramInt2 / 2 + paramInt1 <= i / 2) {}
    for (boolean bool = true;; bool = false)
    {
      this.rmV = bool;
      bool = this.rmV;
      AppMethodBeat.o(244403);
      return bool;
    }
  }
  
  private int getMarginBottom()
  {
    if (1 == this.mCurOrientation) {
      return rmF;
    }
    return rmC;
  }
  
  private int getMarginHorizontal()
  {
    if (1 == this.mCurOrientation) {
      return rmD;
    }
    return rmA;
  }
  
  private int getMarginTopDefault()
  {
    if (1 == this.mCurOrientation) {
      return rmE;
    }
    return rmB;
  }
  
  public final void B(final int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4)
  {
    AppMethodBeat.i(176813);
    if ((this.rnc != null) && (this.rnc.isRunning())) {
      this.rnc.cancel();
    }
    this.rnc = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.rnc.setInterpolator(new AccelerateDecelerateInterpolator());
    this.rnc.setDuration(100L);
    this.rnc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
    this.rnc.addListener(new AnimatorListenerAdapter()
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
    this.rnc.start();
    AppMethodBeat.o(176813);
  }
  
  public final int Du(int paramInt)
  {
    AppMethodBeat.i(176815);
    int i = this.rmQ.x;
    int k = getMarginHorizontal();
    int j = i - paramInt - k;
    i = j;
    if (j < 0) {
      i = this.lct.x - paramInt - k;
    }
    AppMethodBeat.o(176815);
    return i;
  }
  
  public final int Dv(int paramInt)
  {
    AppMethodBeat.i(176817);
    int i = this.rmQ.y;
    int k = getMarginBottom();
    int j = i - paramInt - k;
    i = j;
    if (j < 0) {
      i = this.lct.y - paramInt - k;
    }
    AppMethodBeat.o(176817);
    return i;
  }
  
  public final void a(float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(176818);
    if (paramBoolean)
    {
      int i = getMinY();
      int j = Dv(getHeight());
      this.rmU = ((Math.min(Math.max(paramFloat, i), j) - i) / (j - i));
    }
    AppMethodBeat.o(176818);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    AppMethodBeat.i(176801);
    this.qER = paramInt1;
    if (this.rna != null) {
      aW(this.rna.floatValue());
    }
    this.rni.setPadding(paramInt2, paramInt3, paramInt2, paramInt4);
    Object localObject = (FrameLayout.LayoutParams)this.rnj.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).leftMargin = paramInt2;
    ((FrameLayout.LayoutParams)localObject).rightMargin = paramInt2;
    ((FrameLayout.LayoutParams)localObject).topMargin = paramInt3;
    ((FrameLayout.LayoutParams)localObject).bottomMargin = paramInt4;
    this.rnj.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new ai.a();
    ((ai.a)localObject).raE = paramInt5;
    ((ai.a)localObject).raH = Color.parseColor("#4C000000");
    ((ai.a)localObject).aob = paramInt6;
    ((ai.a)localObject).CL = 0;
    ((ai.a)localObject).CM = paramInt7;
    localObject = ((ai.a)localObject).cky();
    if (this.rnm)
    {
      ai.b(this.rni, (Drawable)localObject);
      AppMethodBeat.o(176801);
      return;
    }
    this.rnn = ((ai)localObject);
    AppMethodBeat.o(176801);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(244398);
    if (this.rmZ == null) {
      this.rmZ = new HashSet();
    }
    this.rmZ.add(parama);
    AppMethodBeat.o(244398);
  }
  
  public final void aW(float paramFloat)
  {
    AppMethodBeat.i(176800);
    if (!this.rnl)
    {
      AppMethodBeat.o(176800);
      return;
    }
    this.rng.setVisibility(0);
    this.rnh.setVisibility(0);
    ViewGroup.LayoutParams localLayoutParams = this.rnh.getLayoutParams();
    localLayoutParams.width = ((int)(this.qER * paramFloat / 100.0F));
    this.rnh.setLayoutParams(localLayoutParams);
    this.rna = Float.valueOf(paramFloat);
    AppMethodBeat.o(176800);
  }
  
  public final void cmS()
  {
    AppMethodBeat.i(176798);
    Log.i("MicroMsg.AppBrand.AppBrandPipContainerView", "disableTouch");
    this.rne.setVisibility(4);
    this.rnk = false;
    AppMethodBeat.o(176798);
  }
  
  public final void cmT()
  {
    AppMethodBeat.i(244396);
    Log.i("MicroMsg.AppBrand.AppBrandPipContainerView", "showOnLoadEnd");
    this.rnf.setVisibility(4);
    AppMethodBeat.o(244396);
  }
  
  public final void cmU()
  {
    AppMethodBeat.i(244397);
    this.rng.setVisibility(4);
    this.rnh.setVisibility(4);
    this.rna = null;
    AppMethodBeat.o(244397);
  }
  
  public final void eZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(176802);
    this.rmX = fc(paramInt1, paramInt2);
    AppMethodBeat.o(176802);
  }
  
  public final void fa(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(176803);
    this.rmY = fd(paramInt1, paramInt2);
    AppMethodBeat.o(176803);
  }
  
  public final void fb(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(244400);
    if (this.rmZ == null)
    {
      AppMethodBeat.o(244400);
      return;
    }
    Iterator localIterator = this.rmZ.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).eU(paramInt1, paramInt2);
    }
    AppMethodBeat.o(244400);
  }
  
  public final int fd(int paramInt1, int paramInt2)
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
      i = Dv(paramInt2);
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
    if (this.rmO != null)
    {
      i = this.rmO.intValue();
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
    Log.d("MicroMsg.AppBrand.AppBrandPipContainerView", "getStablePosX, mStablePosX: " + this.rmX);
    int i = this.rmX;
    AppMethodBeat.o(176804);
    return i;
  }
  
  public final int getStablePosY()
  {
    AppMethodBeat.i(176805);
    Log.d("MicroMsg.AppBrand.AppBrandPipContainerView", "getStablePosY, mStablePosY: " + this.rmY);
    int i = this.rmY;
    AppMethodBeat.o(176805);
    return i;
  }
  
  public final int getTargetPositionXWhenOrientationChanged()
  {
    AppMethodBeat.i(176819);
    int i = getMinX();
    if (!this.rmV) {
      i = Du(getWidth());
    }
    AppMethodBeat.o(176819);
    return i;
  }
  
  public final void jZ(boolean paramBoolean)
  {
    AppMethodBeat.i(244394);
    Log.i("MicroMsg.AppBrand.AppBrandPipContainerView", "enableShadow, isEnabled: ".concat(String.valueOf(paramBoolean)));
    this.rnm = paramBoolean;
    if (paramBoolean)
    {
      if (this.rnn != null)
      {
        Log.i("MicroMsg.AppBrand.AppBrandPipContainerView", "enableShadow, setShadowDrawable");
        ai.b(this.rni, this.rnn);
        AppMethodBeat.o(244394);
      }
    }
    else {
      ai.b(this.rni, null);
    }
    AppMethodBeat.o(244394);
  }
  
  public final void ka(boolean paramBoolean)
  {
    AppMethodBeat.i(176797);
    Log.i("MicroMsg.AppBrand.AppBrandPipContainerView", "enableTouch");
    View localView = this.rne;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localView.setVisibility(i);
      this.rnk = true;
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
    if (rmN == this.rmQ)
    {
      this.rmQ = new Point(localView.getWidth(), localView.getHeight());
      Log.i("MicroMsg.AppBrand.AppBrandPipContainerView", "onLayout, mParentViewSize: " + this.rmQ);
      a(getY(), true);
    }
    AppMethodBeat.o(176794);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(176793);
    if (!this.rnk)
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
        this.rmR = false;
        this.rmS.x = paramMotionEvent.getRawX();
        this.rmS.y = paramMotionEvent.getRawY();
        this.rmT.x = ((int)getX());
        this.rmT.y = ((int)getY());
        Log.i("MicroMsg.AppBrand.AppBrandPipContainerView", "recordPositionWhenActionDown, fingerPosOnDown: " + this.rmS + ", viewPosOnDown: " + this.rmT);
        continue;
        if ((!this.rmR) && (F(paramMotionEvent))) {
          this.rmR = true;
        }
        if (this.rmR) {
          P(G(paramMotionEvent), H(paramMotionEvent));
        }
      }
    } while ((!this.rmR) && (!F(paramMotionEvent)));
    if (this.rmR) {
      this.rmR = false;
    }
    int i = G(paramMotionEvent);
    int j = getWidth();
    int k = H(paramMotionEvent);
    int m = getHeight();
    Log.i("MicroMsg.AppBrand.AppBrandPipContainerView", "onTouchEvent, startPositionX: " + i + ", width: " + j + ", startPositionY: " + k + ", height: " + m);
    B(i, k, fc(i, j), fd(k, m));
    AppMethodBeat.o(176793);
    return true;
  }
  
  public final void setOnCloseButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(176799);
    this.rne.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(176799);
  }
  
  public final void setStablePos(Point paramPoint)
  {
    AppMethodBeat.i(244399);
    Log.d("MicroMsg.AppBrand.AppBrandPipContainerView", "setStablePos, stablePos: ".concat(String.valueOf(paramPoint)));
    this.rmX = paramPoint.x;
    this.rmY = paramPoint.y;
    this.rmW = true;
    AppMethodBeat.o(244399);
  }
  
  public static abstract interface a
  {
    public abstract void eU(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView
 * JD-Core Version:    0.7.0.1
 */