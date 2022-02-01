package com.tencent.mm.plugin.appbrand.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
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
import com.tencent.luggage.wxa.a.d;
import com.tencent.luggage.wxa.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.appbrand.ui.aq;
import com.tencent.mm.plugin.appbrand.ui.aq.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class AppBrandPipContainerView
  extends FrameLayout
{
  public static final int uwA;
  public static final int uwB;
  public static final int uwC;
  public static final int uwD;
  public static final int uwE;
  private static final int uwF;
  private static final Point uwG;
  public static final int uwl;
  public static final int uwm;
  public static final int uwn;
  public static final int uwo;
  public static final int uwp;
  public static final int uwq;
  public static final int uwr;
  public static final int uws;
  private static final int uwt;
  private static final int uwu;
  private static final int uwv;
  private static final int uww;
  private static final int uwx;
  private static final int uwy;
  public static final int uwz;
  public int mCurOrientation;
  public Point nHj;
  private int tJG;
  public Integer uwH;
  private int uwI;
  public Point uwJ;
  private boolean uwK;
  private PointF uwL;
  private PointF uwM;
  public float uwN;
  private boolean uwO;
  public boolean uwP;
  public int uwQ;
  public int uwR;
  public Set<a> uwS;
  private Float uwT;
  public ViewOutlineProvider uwU;
  private ValueAnimator uwV;
  public ViewGroup uwW;
  private View uwX;
  public View uwY;
  private ViewGroup uwZ;
  private View uxa;
  private View uxb;
  private View uxc;
  private boolean uxd;
  public boolean uxe;
  private boolean uxf;
  private aq uxg;
  
  static
  {
    AppMethodBeat.i(176823);
    uwl = a.fromDPToPix(MMApplicationContext.getContext(), 196);
    uwm = a.fromDPToPix(MMApplicationContext.getContext(), 119);
    uwn = a.fromDPToPix(MMApplicationContext.getContext(), 176);
    uwo = a.fromDPToPix(MMApplicationContext.getContext(), 99);
    uwp = a.fromDPToPix(MMApplicationContext.getContext(), 119);
    uwq = a.fromDPToPix(MMApplicationContext.getContext(), 196);
    uwr = a.fromDPToPix(MMApplicationContext.getContext(), 99);
    uws = a.fromDPToPix(MMApplicationContext.getContext(), 176);
    uwt = a.fromDPToPix(MMApplicationContext.getContext(), 32);
    uwu = a.fromDPToPix(MMApplicationContext.getContext(), 56);
    uwv = a.fromDPToPix(MMApplicationContext.getContext(), 52);
    uww = a.fromDPToPix(MMApplicationContext.getContext(), 6);
    uwx = a.fromDPToPix(MMApplicationContext.getContext(), 80);
    uwy = a.fromDPToPix(MMApplicationContext.getContext(), 52);
    uwz = a.fromDPToPix(MMApplicationContext.getContext(), 8);
    uwA = a.fromDPToPix(MMApplicationContext.getContext(), 10);
    uwB = a.fromDPToPix(MMApplicationContext.getContext(), 12);
    uwC = a.fromDPToPix(MMApplicationContext.getContext(), 1);
    uwD = a.fromDPToPix(MMApplicationContext.getContext(), 10);
    uwE = a.fromDPToPix(MMApplicationContext.getContext(), 2);
    uwF = a.fromDPToPix(MMApplicationContext.getContext(), 1);
    uwG = new Point();
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
    this.uwH = null;
    this.uwJ = uwG;
    this.nHj = uwG;
    this.uwK = false;
    this.uwL = new PointF();
    this.uwM = new PointF();
    this.uwN = -1.0F;
    this.uwO = false;
    this.uwP = false;
    this.uwS = null;
    this.tJG = uwn;
    this.uwT = null;
    this.uwU = new AppBrandPipContainerView.1(this);
    this.uxd = true;
    this.uxe = true;
    this.uxf = false;
    this.uxg = null;
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(a.e.app_brand_pip_container_view, this);
    setBackgroundColor(0);
    this.uxb = paramAttributeSet.findViewById(a.d.app_brand_pip_container_bg);
    this.uxc = paramAttributeSet.findViewById(a.d.app_brand_pip_container);
    this.uxc.setOutlineProvider(this.uwU);
    this.uxc.setClipToOutline(true);
    this.uwW = ((ViewGroup)paramAttributeSet.findViewById(a.d.app_brand_pip_video_container));
    this.uwX = paramAttributeSet.findViewById(a.d.app_brand_pip_close_btn);
    this.uwY = paramAttributeSet.findViewById(a.d.app_brand_pip_video_loading_view);
    this.uwY.setVisibility(4);
    this.uwZ = ((ViewGroup)paramAttributeSet.findViewById(a.d.app_brand_pip_video_progress_container));
    this.uwZ.setVisibility(4);
    this.uxa = paramAttributeSet.findViewById(a.d.app_brand_pip_video_progress_view);
    this.uxa.setVisibility(4);
    a(this.tJG, uwA, uwz, uwB, uwC, uwD, uwE);
    this.uwI = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.mCurOrientation = paramContext.getResources().getConfiguration().orientation;
    this.nHj = bf(paramContext);
    Log.i("MicroMsg.AppBrand.AppBrandPipContainerView", "init, mScreenSize: " + this.nHj);
    AppMethodBeat.o(176792);
  }
  
  private boolean F(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(176806);
    if ((Math.abs(paramMotionEvent.getRawX() - this.uwL.x) > this.uwI) || (Math.abs(paramMotionEvent.getRawY() - this.uwL.y) > this.uwI))
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
    int j = this.uwJ.x;
    int i = j;
    if (j <= 0)
    {
      i = this.nHj.x;
      Log.w("MicroMsg.AppBrand.AppBrandPipContainerView", "getMotionEventNewPositionX, mParentViewSize: " + this.uwJ + ", mScreenSize: " + this.nHj);
    }
    i = (int)Math.max(Math.min(this.uwM.x + paramMotionEvent.getRawX() - this.uwL.x, i - getWidth()), 0.0F);
    AppMethodBeat.o(176807);
    return i;
  }
  
  private int H(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(176808);
    int j = this.uwJ.y;
    int i = j;
    if (j <= 0)
    {
      i = this.nHj.y;
      Log.w("MicroMsg.AppBrand.AppBrandPipContainerView", "getMotionEventNewPositionY, mParentViewSize: " + this.uwJ + ", mScreenSize: " + this.nHj);
    }
    i = (int)Math.max(Math.min(this.uwM.y + paramMotionEvent.getRawY() - this.uwL.y, i - getHeight()), 0.0F);
    AppMethodBeat.o(176808);
    return i;
  }
  
  private void av(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(323985);
    float f1 = getX();
    float f2 = getX();
    if ((f1 != paramFloat1) || (f2 != paramFloat2))
    {
      setX(paramFloat1);
      setY(paramFloat2);
      d(paramFloat2, false);
    }
    AppMethodBeat.o(323985);
  }
  
  public static Point bf(Context paramContext)
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
  
  private int fU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(176810);
    int i = getMinX();
    if (!fW(paramInt1, paramInt2)) {
      i = DT(paramInt2);
    }
    AppMethodBeat.o(176810);
    return i;
  }
  
  private boolean fW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(323986);
    int j = this.uwJ.x;
    int i = j;
    if (j <= 0)
    {
      i = this.nHj.x;
      Log.w("MicroMsg.AppBrand.AppBrandPipContainerView", "isPositionLeft, mParentViewSize: " + this.uwJ + ", mScreenSize: " + this.nHj);
    }
    if (paramInt2 / 2 + paramInt1 <= i / 2) {}
    for (boolean bool = true;; bool = false)
    {
      this.uwO = bool;
      bool = this.uwO;
      AppMethodBeat.o(323986);
      return bool;
    }
  }
  
  private int getMarginBottom()
  {
    if (1 == this.mCurOrientation) {
      return uwy;
    }
    return uwv;
  }
  
  private int getMarginHorizontal()
  {
    if (1 == this.mCurOrientation) {
      return uww;
    }
    return uwt;
  }
  
  private int getMarginTopDefault()
  {
    if (1 == this.mCurOrientation) {
      return uwx;
    }
    return uwu;
  }
  
  public final int DT(int paramInt)
  {
    AppMethodBeat.i(176815);
    int i = this.uwJ.x;
    int k = getMarginHorizontal();
    int j = i - paramInt - k;
    i = j;
    if (j < 0) {
      i = this.nHj.x - paramInt - k;
    }
    AppMethodBeat.o(176815);
    return i;
  }
  
  public final int DU(int paramInt)
  {
    AppMethodBeat.i(176817);
    int i = this.uwJ.y;
    int k = getMarginBottom();
    int j = i - paramInt - k;
    i = j;
    if (j < 0) {
      i = this.nHj.y - paramInt - k;
    }
    AppMethodBeat.o(176817);
    return i;
  }
  
  public final void H(final int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4)
  {
    AppMethodBeat.i(176813);
    if ((this.uwV != null) && (this.uwV.isRunning())) {
      this.uwV.cancel();
    }
    this.uwV = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.uwV.setInterpolator(new AccelerateDecelerateInterpolator());
    this.uwV.setDuration(100L);
    this.uwV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
    this.uwV.addListener(new AnimatorListenerAdapter()
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
    this.uwV.start();
    AppMethodBeat.o(176813);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    AppMethodBeat.i(176801);
    this.tJG = paramInt1;
    if (this.uwT != null) {
      bY(this.uwT.floatValue());
    }
    this.uxb.setPadding(paramInt2, paramInt3, paramInt2, paramInt4);
    Object localObject = (FrameLayout.LayoutParams)this.uxc.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).leftMargin = paramInt2;
    ((FrameLayout.LayoutParams)localObject).rightMargin = paramInt2;
    ((FrameLayout.LayoutParams)localObject).topMargin = paramInt3;
    ((FrameLayout.LayoutParams)localObject).bottomMargin = paramInt4;
    this.uxc.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new aq.a();
    ((aq.a)localObject).ugu = paramInt5;
    ((aq.a)localObject).ugx = Color.parseColor("#4C000000");
    ((aq.a)localObject).ccL = paramInt6;
    ((aq.a)localObject).biT = 0;
    ((aq.a)localObject).biU = paramInt7;
    localObject = ((aq.a)localObject).cLM();
    if (this.uxf)
    {
      aq.b(this.uxb, (Drawable)localObject);
      AppMethodBeat.o(176801);
      return;
    }
    this.uxg = ((aq)localObject);
    AppMethodBeat.o(176801);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(324037);
    if (this.uwS == null) {
      this.uwS = new HashSet();
    }
    this.uwS.add(parama);
    AppMethodBeat.o(324037);
  }
  
  public final void bY(float paramFloat)
  {
    AppMethodBeat.i(176800);
    if (!this.uxe)
    {
      AppMethodBeat.o(176800);
      return;
    }
    this.uwZ.setVisibility(0);
    this.uxa.setVisibility(0);
    ViewGroup.LayoutParams localLayoutParams = this.uxa.getLayoutParams();
    localLayoutParams.width = ((int)(this.tJG * paramFloat / 100.0F));
    this.uxa.setLayoutParams(localLayoutParams);
    this.uwT = Float.valueOf(paramFloat);
    AppMethodBeat.o(176800);
  }
  
  public final void cOJ()
  {
    AppMethodBeat.i(176798);
    Log.i("MicroMsg.AppBrand.AppBrandPipContainerView", "disableTouch");
    this.uwX.setVisibility(4);
    this.uxd = false;
    AppMethodBeat.o(176798);
  }
  
  public final void cOK()
  {
    AppMethodBeat.i(324017);
    Log.i("MicroMsg.AppBrand.AppBrandPipContainerView", "showOnLoadEnd");
    this.uwY.setVisibility(4);
    AppMethodBeat.o(324017);
  }
  
  public final void cOL()
  {
    AppMethodBeat.i(324022);
    this.uwZ.setVisibility(4);
    this.uxa.setVisibility(4);
    this.uwT = null;
    AppMethodBeat.o(324022);
  }
  
  public final void d(float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(176818);
    if (paramBoolean)
    {
      int i = getMinY();
      int j = DU(getHeight());
      this.uwN = ((Math.min(Math.max(paramFloat, i), j) - i) / (j - i));
    }
    AppMethodBeat.o(176818);
  }
  
  public final void fR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(176802);
    this.uwQ = fU(paramInt1, paramInt2);
    AppMethodBeat.o(176802);
  }
  
  public final void fS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(176803);
    this.uwR = fV(paramInt1, paramInt2);
    AppMethodBeat.o(176803);
  }
  
  public final void fT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(324068);
    if (this.uwS == null)
    {
      AppMethodBeat.o(324068);
      return;
    }
    Iterator localIterator = this.uwS.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onStablePositionChange(paramInt1, paramInt2);
    }
    AppMethodBeat.o(324068);
  }
  
  public final int fV(int paramInt1, int paramInt2)
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
      i = DU(paramInt2);
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
    if (this.uwH != null)
    {
      i = this.uwH.intValue();
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
    Log.d("MicroMsg.AppBrand.AppBrandPipContainerView", "getStablePosX, mStablePosX: " + this.uwQ);
    int i = this.uwQ;
    AppMethodBeat.o(176804);
    return i;
  }
  
  public final int getStablePosY()
  {
    AppMethodBeat.i(176805);
    Log.d("MicroMsg.AppBrand.AppBrandPipContainerView", "getStablePosY, mStablePosY: " + this.uwR);
    int i = this.uwR;
    AppMethodBeat.o(176805);
    return i;
  }
  
  public final int getTargetPositionXWhenOrientationChanged()
  {
    AppMethodBeat.i(176819);
    int i = getMinX();
    if (!this.uwO) {
      i = DT(getWidth());
    }
    AppMethodBeat.o(176819);
    return i;
  }
  
  public final void lk(boolean paramBoolean)
  {
    AppMethodBeat.i(324007);
    Log.i("MicroMsg.AppBrand.AppBrandPipContainerView", "enableShadow, isEnabled: ".concat(String.valueOf(paramBoolean)));
    this.uxf = paramBoolean;
    if (paramBoolean)
    {
      if (this.uxg != null)
      {
        Log.i("MicroMsg.AppBrand.AppBrandPipContainerView", "enableShadow, setShadowDrawable");
        aq.b(this.uxb, this.uxg);
        AppMethodBeat.o(324007);
      }
    }
    else {
      aq.b(this.uxb, null);
    }
    AppMethodBeat.o(324007);
  }
  
  public final void ll(boolean paramBoolean)
  {
    AppMethodBeat.i(176797);
    Log.i("MicroMsg.AppBrand.AppBrandPipContainerView", "enableTouch");
    View localView = this.uwX;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localView.setVisibility(i);
      this.uxd = true;
      AppMethodBeat.o(176797);
      return;
    }
  }
  
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
    if (uwG == this.uwJ)
    {
      this.uwJ = new Point(localView.getWidth(), localView.getHeight());
      Log.i("MicroMsg.AppBrand.AppBrandPipContainerView", "onLayout, mParentViewSize: " + this.uwJ);
      d(getY(), true);
    }
    AppMethodBeat.o(176794);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(176793);
    if (!this.uxd)
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
        this.uwK = false;
        this.uwL.x = paramMotionEvent.getRawX();
        this.uwL.y = paramMotionEvent.getRawY();
        this.uwM.x = ((int)getX());
        this.uwM.y = ((int)getY());
        Log.i("MicroMsg.AppBrand.AppBrandPipContainerView", "recordPositionWhenActionDown, fingerPosOnDown: " + this.uwL + ", viewPosOnDown: " + this.uwM);
        continue;
        if ((!this.uwK) && (F(paramMotionEvent))) {
          this.uwK = true;
        }
        if (this.uwK) {
          av(G(paramMotionEvent), H(paramMotionEvent));
        }
      }
    } while ((!this.uwK) && (!F(paramMotionEvent)));
    if (this.uwK) {
      this.uwK = false;
    }
    int i = G(paramMotionEvent);
    int j = getWidth();
    int k = H(paramMotionEvent);
    int m = getHeight();
    Log.i("MicroMsg.AppBrand.AppBrandPipContainerView", "onTouchEvent, startPositionX: " + i + ", width: " + j + ", startPositionY: " + k + ", height: " + m);
    H(i, k, fU(i, j), fV(k, m));
    AppMethodBeat.o(176793);
    return true;
  }
  
  public final void setOnCloseButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(176799);
    this.uwX.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(176799);
  }
  
  public final void setStablePos(Point paramPoint)
  {
    AppMethodBeat.i(324043);
    Log.d("MicroMsg.AppBrand.AppBrandPipContainerView", "setStablePos, stablePos: ".concat(String.valueOf(paramPoint)));
    this.uwQ = paramPoint.x;
    this.uwR = paramPoint.y;
    this.uwP = true;
    AppMethodBeat.o(324043);
  }
  
  public static abstract interface a
  {
    public abstract void onStablePositionChange(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView
 * JD-Core Version:    0.7.0.1
 */