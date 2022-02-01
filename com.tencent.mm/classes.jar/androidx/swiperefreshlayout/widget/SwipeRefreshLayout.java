package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.ListView;
import androidx.core.g.k;
import androidx.core.g.n;
import androidx.core.g.o;
import androidx.core.g.r;
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SwipeRefreshLayout
  extends ViewGroup
  implements k, o
{
  private static final int[] LAYOUT_ATTRS;
  private static final String LOG_TAG;
  private final r Ho;
  private View Py;
  private final DecelerateInterpolator aju;
  b aoC;
  boolean aoD;
  private float aoE;
  private float aoF;
  private final n aoG;
  private final int[] aoH;
  private final int[] aoI;
  private boolean aoJ;
  private int aoK;
  int aoL;
  private float aoM;
  boolean aoN;
  private boolean aoO;
  a aoP;
  private int aoQ;
  float aoR;
  protected int aoS;
  int aoT;
  int aoU;
  b aoV;
  private Animation aoW;
  private Animation aoX;
  private Animation aoY;
  private Animation aoZ;
  private Animation apa;
  boolean apb;
  private int apc;
  boolean apd;
  private a ape;
  private Animation.AnimationListener apf;
  private final Animation apg;
  private final Animation aph;
  private int mActivePointerId;
  protected int mFrom;
  private float mInitialMotionY;
  private boolean mIsBeingDragged;
  private int mTouchSlop;
  
  static
  {
    AppMethodBeat.i(256480);
    LOG_TAG = SwipeRefreshLayout.class.getSimpleName();
    LAYOUT_ATTRS = new int[] { 16842766 };
    AppMethodBeat.o(256480);
  }
  
  public SwipeRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(256411);
    this.aoD = false;
    this.aoE = -1.0F;
    this.aoH = new int[2];
    this.aoI = new int[2];
    this.mActivePointerId = -1;
    this.aoQ = -1;
    this.apf = new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(256351);
        if (SwipeRefreshLayout.this.aoD)
        {
          SwipeRefreshLayout.this.aoV.setAlpha(255);
          SwipeRefreshLayout.this.aoV.start();
          SwipeRefreshLayout.this.aoL = SwipeRefreshLayout.this.aoP.getTop();
          AppMethodBeat.o(256351);
          return;
        }
        SwipeRefreshLayout.this.reset();
        AppMethodBeat.o(256351);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    };
    this.apg = new Animation()
    {
      public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        AppMethodBeat.i(256363);
        if (!SwipeRefreshLayout.this.apd) {}
        for (int i = SwipeRefreshLayout.this.aoT - Math.abs(SwipeRefreshLayout.this.aoS);; i = SwipeRefreshLayout.this.aoT)
        {
          int j = SwipeRefreshLayout.this.mFrom;
          i = (int)((i - SwipeRefreshLayout.this.mFrom) * paramAnonymousFloat);
          int k = SwipeRefreshLayout.this.aoP.getTop();
          SwipeRefreshLayout.this.setTargetOffsetTopAndBottom(i + j - k);
          SwipeRefreshLayout.this.aoV.v(1.0F - paramAnonymousFloat);
          AppMethodBeat.o(256363);
          return;
        }
      }
    };
    this.aph = new Animation()
    {
      public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        AppMethodBeat.i(256367);
        SwipeRefreshLayout.this.B(paramAnonymousFloat);
        AppMethodBeat.o(256367);
      }
    };
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.aoK = getResources().getInteger(17694721);
    setWillNotDraw(false);
    this.aju = new DecelerateInterpolator(2.0F);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.apc = ((int)(40.0F * localDisplayMetrics.density));
    this.aoP = new a(getContext());
    this.aoV = new b(getContext());
    this.aoV.setStyle(1);
    this.aoP.setImageDrawable(this.aoV);
    this.aoP.setVisibility(8);
    addView(this.aoP);
    setChildrenDrawingOrderEnabled(true);
    this.aoT = ((int)(localDisplayMetrics.density * 64.0F));
    this.aoE = this.aoT;
    this.Ho = new r();
    this.aoG = new n(this);
    setNestedScrollingEnabled(true);
    int i = -this.apc;
    this.aoL = i;
    this.aoS = i;
    B(1.0F);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, LAYOUT_ATTRS);
    setEnabled(paramContext.getBoolean(0, true));
    paramContext.recycle();
    AppMethodBeat.o(256411);
  }
  
  private void A(float paramFloat)
  {
    AppMethodBeat.i(256471);
    if ((paramFloat - this.aoM > this.mTouchSlop) && (!this.mIsBeingDragged))
    {
      this.mInitialMotionY = (this.aoM + this.mTouchSlop);
      this.mIsBeingDragged = true;
      this.aoV.setAlpha(76);
    }
    AppMethodBeat.o(256471);
  }
  
  private void a(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    AppMethodBeat.i(256473);
    this.mFrom = paramInt;
    this.apg.reset();
    this.apg.setDuration(200L);
    this.apg.setInterpolator(this.aju);
    if (paramAnimationListener != null) {
      this.aoP.aoa = paramAnimationListener;
    }
    this.aoP.clearAnimation();
    this.aoP.startAnimation(this.apg);
    AppMethodBeat.o(256473);
  }
  
  private static boolean a(Animation paramAnimation)
  {
    AppMethodBeat.i(256464);
    if ((paramAnimation != null) && (paramAnimation.hasStarted()) && (!paramAnimation.hasEnded()))
    {
      AppMethodBeat.o(256464);
      return true;
    }
    AppMethodBeat.o(256464);
    return false;
  }
  
  private Animation aW(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(256422);
    Animation local4 = new Animation()
    {
      public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        AppMethodBeat.i(256361);
        SwipeRefreshLayout.this.aoV.setAlpha((int)(paramInt1 + (paramInt2 - paramInt1) * paramAnonymousFloat));
        AppMethodBeat.o(256361);
      }
    };
    local4.setDuration(300L);
    this.aoP.aoa = null;
    this.aoP.clearAnimation();
    this.aoP.startAnimation(local4);
    AppMethodBeat.o(256422);
    return local4;
  }
  
  private void b(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    AppMethodBeat.i(256475);
    if (this.aoN)
    {
      c(paramInt, paramAnimationListener);
      AppMethodBeat.o(256475);
      return;
    }
    this.mFrom = paramInt;
    this.aph.reset();
    this.aph.setDuration(200L);
    this.aph.setInterpolator(this.aju);
    if (paramAnimationListener != null) {
      this.aoP.aoa = paramAnimationListener;
    }
    this.aoP.clearAnimation();
    this.aoP.startAnimation(this.aph);
    AppMethodBeat.o(256475);
  }
  
  private void c(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    AppMethodBeat.i(256477);
    this.mFrom = paramInt;
    this.aoR = this.aoP.getScaleX();
    this.apa = new Animation()
    {
      public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        AppMethodBeat.i(256369);
        float f1 = SwipeRefreshLayout.this.aoR;
        float f2 = -SwipeRefreshLayout.this.aoR;
        SwipeRefreshLayout.this.setAnimationProgress(f1 + f2 * paramAnonymousFloat);
        SwipeRefreshLayout.this.B(paramAnonymousFloat);
        AppMethodBeat.o(256369);
      }
    };
    this.apa.setDuration(150L);
    if (paramAnimationListener != null) {
      this.aoP.aoa = paramAnimationListener;
    }
    this.aoP.clearAnimation();
    this.aoP.startAnimation(this.apa);
    AppMethodBeat.o(256477);
  }
  
  private void f(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(256416);
    if (this.aoD != paramBoolean1)
    {
      this.apb = paramBoolean2;
      nc();
      this.aoD = paramBoolean1;
      if (this.aoD)
      {
        a(this.aoL, this.apf);
        AppMethodBeat.o(256416);
        return;
      }
      a(this.apf);
    }
    AppMethodBeat.o(256416);
  }
  
  private void na()
  {
    AppMethodBeat.i(256419);
    this.aoY = aW(this.aoV.getAlpha(), 76);
    AppMethodBeat.o(256419);
  }
  
  private void nb()
  {
    AppMethodBeat.i(256421);
    this.aoZ = aW(this.aoV.getAlpha(), 255);
    AppMethodBeat.o(256421);
  }
  
  private void nc()
  {
    AppMethodBeat.i(256436);
    if (this.Py == null)
    {
      int i = 0;
      while (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (!localView.equals(this.aoP))
        {
          this.Py = localView;
          AppMethodBeat.o(256436);
          return;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(256436);
  }
  
  private boolean nd()
  {
    AppMethodBeat.i(256443);
    if (this.ape != null)
    {
      bool = this.ape.ne();
      AppMethodBeat.o(256443);
      return bool;
    }
    if ((this.Py instanceof ListView))
    {
      ListView localListView = (ListView)this.Py;
      if (Build.VERSION.SDK_INT >= 19)
      {
        bool = localListView.canScrollList(-1);
        AppMethodBeat.o(256443);
        return bool;
      }
      if (localListView.getChildCount() != 0)
      {
        int i = localListView.getFirstVisiblePosition();
        int j = localListView.getChildAt(0).getTop();
        if ((i > 0) || (j < localListView.getListPaddingTop()))
        {
          AppMethodBeat.o(256443);
          return true;
        }
      }
      AppMethodBeat.o(256443);
      return false;
    }
    boolean bool = this.Py.canScrollVertically(-1);
    AppMethodBeat.o(256443);
    return bool;
  }
  
  private void onSecondaryPointerUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(256479);
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.mActivePointerId) {
      if (i != 0) {
        break label45;
      }
    }
    label45:
    for (i = 1;; i = 0)
    {
      this.mActivePointerId = paramMotionEvent.getPointerId(i);
      AppMethodBeat.o(256479);
      return;
    }
  }
  
  private void setColorViewAlpha(int paramInt)
  {
    AppMethodBeat.i(256408);
    this.aoP.getBackground().setAlpha(paramInt);
    this.aoV.setAlpha(paramInt);
    AppMethodBeat.o(256408);
  }
  
  private void y(float paramFloat)
  {
    AppMethodBeat.i(256465);
    this.aoV.aB(true);
    float f1 = Math.min(1.0F, Math.abs(paramFloat / this.aoE));
    float f2 = Math.max((float)(f1 - 0.4D), 0.0F) * 5.0F / 3.0F;
    float f4 = Math.abs(paramFloat);
    float f5 = this.aoE;
    int i;
    int j;
    if (this.aoU > 0)
    {
      i = this.aoU;
      float f3 = i;
      f4 = Math.max(0.0F, Math.min(f4 - f5, f3 * 2.0F) / f3);
      f4 = (float)(f4 / 4.0F - Math.pow(f4 / 4.0F, 2.0D)) * 2.0F;
      i = this.aoS;
      j = (int)(f3 * f1 + f3 * f4 * 2.0F);
      if (this.aoP.getVisibility() != 0) {
        this.aoP.setVisibility(0);
      }
      if (!this.aoN)
      {
        this.aoP.setScaleX(1.0F);
        this.aoP.setScaleY(1.0F);
      }
      if (this.aoN) {
        setAnimationProgress(Math.min(1.0F, paramFloat / this.aoE));
      }
      if (paramFloat >= this.aoE) {
        break label349;
      }
      if ((this.aoV.getAlpha() > 76) && (!a(this.aoY))) {
        na();
      }
    }
    for (;;)
    {
      this.aoV.w(Math.min(0.8F, f2 * 0.8F));
      this.aoV.v(Math.min(1.0F, f2));
      this.aoV.x((-0.25F + f2 * 0.4F + f4 * 2.0F) * 0.5F);
      setTargetOffsetTopAndBottom(j + i - this.aoL);
      AppMethodBeat.o(256465);
      return;
      if (this.apd)
      {
        i = this.aoT - this.aoS;
        break;
      }
      i = this.aoT;
      break;
      label349:
      if ((this.aoV.getAlpha() < 255) && (!a(this.aoZ))) {
        nb();
      }
    }
  }
  
  private void z(float paramFloat)
  {
    AppMethodBeat.i(256467);
    if (paramFloat > this.aoE)
    {
      f(true, true);
      AppMethodBeat.o(256467);
      return;
    }
    this.aoD = false;
    this.aoV.w(0.0F);
    Animation.AnimationListener local5 = null;
    if (!this.aoN) {
      local5 = new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(256362);
          if (!SwipeRefreshLayout.this.aoN) {
            SwipeRefreshLayout.this.a(null);
          }
          AppMethodBeat.o(256362);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      };
    }
    b(this.aoL, local5);
    this.aoV.aB(false);
    AppMethodBeat.o(256467);
  }
  
  final void B(float paramFloat)
  {
    AppMethodBeat.i(256476);
    setTargetOffsetTopAndBottom(this.mFrom + (int)((this.aoS - this.mFrom) * paramFloat) - this.aoP.getTop());
    AppMethodBeat.o(256476);
  }
  
  final void a(Animation.AnimationListener paramAnimationListener)
  {
    AppMethodBeat.i(256418);
    this.aoX = new Animation()
    {
      public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        AppMethodBeat.i(256360);
        SwipeRefreshLayout.this.setAnimationProgress(1.0F - paramAnonymousFloat);
        AppMethodBeat.o(256360);
      }
    };
    this.aoX.setDuration(150L);
    this.aoP.aoa = paramAnimationListener;
    this.aoP.clearAnimation();
    this.aoP.startAnimation(this.aoX);
    AppMethodBeat.o(256418);
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(256462);
    paramBoolean = this.aoG.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
    AppMethodBeat.o(256462);
    return paramBoolean;
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(256463);
    boolean bool = this.aoG.dispatchNestedPreFling(paramFloat1, paramFloat2);
    AppMethodBeat.o(256463);
    return bool;
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(256459);
    boolean bool = this.aoG.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
    AppMethodBeat.o(256459);
    return bool;
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(256457);
    boolean bool = this.aoG.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
    AppMethodBeat.o(256457);
    return bool;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (this.aoQ < 0) {}
    do
    {
      return paramInt2;
      if (paramInt2 == paramInt1 - 1) {
        return this.aoQ;
      }
    } while (paramInt2 < this.aoQ);
    return paramInt2 + 1;
  }
  
  public int getNestedScrollAxes()
  {
    AppMethodBeat.i(256450);
    int i = this.Ho.getNestedScrollAxes();
    AppMethodBeat.o(256450);
    return i;
  }
  
  public int getProgressCircleDiameter()
  {
    return this.apc;
  }
  
  public int getProgressViewEndOffset()
  {
    return this.aoT;
  }
  
  public int getProgressViewStartOffset()
  {
    return this.aoS;
  }
  
  public boolean hasNestedScrollingParent()
  {
    AppMethodBeat.i(256456);
    boolean bool = this.aoG.bx(0);
    AppMethodBeat.o(256456);
    return bool;
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return this.aoG.Np;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(256406);
    super.onDetachedFromWindow();
    reset();
    AppMethodBeat.o(256406);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(256445);
    nc();
    int i = paramMotionEvent.getActionMasked();
    if ((this.aoO) && (i == 0)) {
      this.aoO = false;
    }
    if ((!isEnabled()) || (this.aoO) || (nd()) || (this.aoD) || (this.aoJ))
    {
      AppMethodBeat.o(256445);
      return false;
    }
    switch (i)
    {
    }
    for (;;)
    {
      boolean bool = this.mIsBeingDragged;
      AppMethodBeat.o(256445);
      return bool;
      setTargetOffsetTopAndBottom(this.aoS - this.aoP.getTop());
      this.mActivePointerId = paramMotionEvent.getPointerId(0);
      this.mIsBeingDragged = false;
      i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      if (i < 0)
      {
        AppMethodBeat.o(256445);
        return false;
      }
      this.aoM = paramMotionEvent.getY(i);
      continue;
      if (this.mActivePointerId == -1)
      {
        AppMethodBeat.o(256445);
        return false;
      }
      i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      if (i < 0)
      {
        AppMethodBeat.o(256445);
        return false;
      }
      A(paramMotionEvent.getY(i));
      continue;
      onSecondaryPointerUp(paramMotionEvent);
      continue;
      this.mIsBeingDragged = false;
      this.mActivePointerId = -1;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(256440);
    paramInt1 = getMeasuredWidth();
    paramInt2 = getMeasuredHeight();
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(256440);
      return;
    }
    if (this.Py == null) {
      nc();
    }
    if (this.Py == null)
    {
      AppMethodBeat.o(256440);
      return;
    }
    View localView = this.Py;
    paramInt3 = getPaddingLeft();
    paramInt4 = getPaddingTop();
    localView.layout(paramInt3, paramInt4, paramInt1 - getPaddingLeft() - getPaddingRight() + paramInt3, paramInt2 - getPaddingTop() - getPaddingBottom() + paramInt4);
    paramInt2 = this.aoP.getMeasuredWidth();
    paramInt3 = this.aoP.getMeasuredHeight();
    this.aoP.layout(paramInt1 / 2 - paramInt2 / 2, this.aoL, paramInt1 / 2 + paramInt2 / 2, this.aoL + paramInt3);
    AppMethodBeat.o(256440);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(256441);
    super.onMeasure(paramInt1, paramInt2);
    if (this.Py == null) {
      nc();
    }
    if (this.Py == null)
    {
      AppMethodBeat.o(256441);
      return;
    }
    this.Py.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), 1073741824));
    this.aoP.measure(View.MeasureSpec.makeMeasureSpec(this.apc, 1073741824), View.MeasureSpec.makeMeasureSpec(this.apc, 1073741824));
    this.aoQ = -1;
    paramInt1 = 0;
    while (paramInt1 < getChildCount())
    {
      if (getChildAt(paramInt1) == this.aoP)
      {
        this.aoQ = paramInt1;
        AppMethodBeat.o(256441);
        return;
      }
      paramInt1 += 1;
    }
    AppMethodBeat.o(256441);
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(256461);
    paramBoolean = dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
    AppMethodBeat.o(256461);
    return paramBoolean;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(256460);
    boolean bool = dispatchNestedPreFling(paramFloat1, paramFloat2);
    AppMethodBeat.o(256460);
    return bool;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(256449);
    if ((paramInt2 > 0) && (this.aoF > 0.0F))
    {
      if (paramInt2 <= this.aoF) {
        break label153;
      }
      paramArrayOfInt[1] = (paramInt2 - (int)this.aoF);
      this.aoF = 0.0F;
    }
    for (;;)
    {
      y(this.aoF);
      if ((this.apd) && (paramInt2 > 0) && (this.aoF == 0.0F) && (Math.abs(paramInt2 - paramArrayOfInt[1]) > 0)) {
        this.aoP.setVisibility(8);
      }
      paramView = this.aoH;
      if (dispatchNestedPreScroll(paramInt1 - paramArrayOfInt[0], paramInt2 - paramArrayOfInt[1], paramView, null))
      {
        paramArrayOfInt[0] += paramView[0];
        paramInt1 = paramArrayOfInt[1];
        paramView[1] += paramInt1;
      }
      AppMethodBeat.o(256449);
      return;
      label153:
      this.aoF -= paramInt2;
      paramArrayOfInt[1] = paramInt2;
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(256452);
    dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.aoI);
    paramInt1 = this.aoI[1] + paramInt4;
    if ((paramInt1 < 0) && (!nd()))
    {
      float f = this.aoF;
      this.aoF = (Math.abs(paramInt1) + f);
      y(this.aoF);
    }
    AppMethodBeat.o(256452);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    AppMethodBeat.i(256448);
    this.Ho.F(paramInt, 0);
    startNestedScroll(paramInt & 0x2);
    this.aoF = 0.0F;
    this.aoJ = true;
    AppMethodBeat.o(256448);
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    AppMethodBeat.i(256447);
    if ((isEnabled()) && (!this.aoO) && (!this.aoD) && ((paramInt & 0x2) != 0))
    {
      AppMethodBeat.o(256447);
      return true;
    }
    AppMethodBeat.o(256447);
    return false;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    AppMethodBeat.i(256451);
    this.Ho.bz(0);
    this.aoJ = false;
    if (this.aoF > 0.0F)
    {
      z(this.aoF);
      this.aoF = 0.0F;
    }
    stopNestedScroll();
    AppMethodBeat.o(256451);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(256469);
    int i = paramMotionEvent.getActionMasked();
    if ((this.aoO) && (i == 0)) {
      this.aoO = false;
    }
    if ((!isEnabled()) || (this.aoO) || (nd()) || (this.aoD) || (this.aoJ))
    {
      AppMethodBeat.o(256469);
      return false;
    }
    float f1;
    switch (i)
    {
    case 4: 
    default: 
    case 0: 
    case 2: 
    case 5: 
    case 6: 
      for (;;)
      {
        AppMethodBeat.o(256469);
        return true;
        this.mActivePointerId = paramMotionEvent.getPointerId(0);
        this.mIsBeingDragged = false;
        continue;
        i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
        if (i < 0)
        {
          AppMethodBeat.o(256469);
          return false;
        }
        f1 = paramMotionEvent.getY(i);
        A(f1);
        if (this.mIsBeingDragged)
        {
          f1 = (f1 - this.mInitialMotionY) * 0.5F;
          if (f1 > 0.0F)
          {
            y(f1);
          }
          else
          {
            AppMethodBeat.o(256469);
            return false;
            i = paramMotionEvent.getActionIndex();
            if (i < 0)
            {
              AppMethodBeat.o(256469);
              return false;
            }
            this.mActivePointerId = paramMotionEvent.getPointerId(i);
            continue;
            onSecondaryPointerUp(paramMotionEvent);
          }
        }
      }
    case 1: 
      i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      if (i < 0)
      {
        AppMethodBeat.o(256469);
        return false;
      }
      if (this.mIsBeingDragged)
      {
        f1 = paramMotionEvent.getY(i);
        float f2 = this.mInitialMotionY;
        this.mIsBeingDragged = false;
        z((f1 - f2) * 0.5F);
      }
      this.mActivePointerId = -1;
      AppMethodBeat.o(256469);
      return false;
    }
    AppMethodBeat.o(256469);
    return false;
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(256446);
    if (((Build.VERSION.SDK_INT >= 21) || (!(this.Py instanceof AbsListView))) && ((this.Py == null) || (w.ae(this.Py)))) {
      super.requestDisallowInterceptTouchEvent(paramBoolean);
    }
    AppMethodBeat.o(256446);
  }
  
  final void reset()
  {
    AppMethodBeat.i(256402);
    this.aoP.clearAnimation();
    this.aoV.stop();
    this.aoP.setVisibility(8);
    setColorViewAlpha(255);
    if (this.aoN) {
      setAnimationProgress(0.0F);
    }
    for (;;)
    {
      this.aoL = this.aoP.getTop();
      AppMethodBeat.o(256402);
      return;
      setTargetOffsetTopAndBottom(this.aoS - this.aoL);
    }
  }
  
  void setAnimationProgress(float paramFloat)
  {
    AppMethodBeat.i(256414);
    this.aoP.setScaleX(paramFloat);
    this.aoP.setScaleY(paramFloat);
    AppMethodBeat.o(256414);
  }
  
  @Deprecated
  public void setColorScheme(@androidx.annotation.a int... paramVarArgs)
  {
    AppMethodBeat.i(256427);
    setColorSchemeResources(paramVarArgs);
    AppMethodBeat.o(256427);
  }
  
  public void setColorSchemeColors(int... paramVarArgs)
  {
    AppMethodBeat.i(256432);
    nc();
    b localb = this.aoV;
    localb.aoi.setColors(paramVarArgs);
    localb.aoi.dv(0);
    localb.invalidateSelf();
    AppMethodBeat.o(256432);
  }
  
  public void setColorSchemeResources(@androidx.annotation.a int... paramVarArgs)
  {
    AppMethodBeat.i(256429);
    Context localContext = getContext();
    int[] arrayOfInt = new int[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      arrayOfInt[i] = androidx.core.content.a.w(localContext, paramVarArgs[i]);
      i += 1;
    }
    setColorSchemeColors(arrayOfInt);
    AppMethodBeat.o(256429);
  }
  
  public void setDistanceToTriggerSync(int paramInt)
  {
    this.aoE = paramInt;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(256404);
    super.setEnabled(paramBoolean);
    if (!paramBoolean) {
      reset();
    }
    AppMethodBeat.o(256404);
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(256453);
    this.aoG.setNestedScrollingEnabled(paramBoolean);
    AppMethodBeat.o(256453);
  }
  
  public void setOnChildScrollUpCallback(a parama)
  {
    this.ape = parama;
  }
  
  public void setOnRefreshListener(b paramb)
  {
    this.aoC = paramb;
  }
  
  @Deprecated
  public void setProgressBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(256423);
    setProgressBackgroundColorSchemeResource(paramInt);
    AppMethodBeat.o(256423);
  }
  
  public void setProgressBackgroundColorSchemeColor(int paramInt)
  {
    AppMethodBeat.i(256426);
    this.aoP.setBackgroundColor(paramInt);
    AppMethodBeat.o(256426);
  }
  
  public void setProgressBackgroundColorSchemeResource(@androidx.annotation.a int paramInt)
  {
    AppMethodBeat.i(256424);
    setProgressBackgroundColorSchemeColor(androidx.core.content.a.w(getContext(), paramInt));
    AppMethodBeat.o(256424);
  }
  
  public void setRefreshing(boolean paramBoolean)
  {
    AppMethodBeat.i(256413);
    if ((paramBoolean) && (this.aoD != paramBoolean))
    {
      this.aoD = paramBoolean;
      if (!this.apd) {}
      for (int i = this.aoT + this.aoS;; i = this.aoT)
      {
        setTargetOffsetTopAndBottom(i - this.aoL);
        this.apb = false;
        Animation.AnimationListener localAnimationListener = this.apf;
        this.aoP.setVisibility(0);
        this.aoV.setAlpha(255);
        this.aoW = new Animation()
        {
          public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
          {
            AppMethodBeat.i(256356);
            SwipeRefreshLayout.this.setAnimationProgress(paramAnonymousFloat);
            AppMethodBeat.o(256356);
          }
        };
        this.aoW.setDuration(this.aoK);
        if (localAnimationListener != null) {
          this.aoP.aoa = localAnimationListener;
        }
        this.aoP.clearAnimation();
        this.aoP.startAnimation(this.aoW);
        AppMethodBeat.o(256413);
        return;
      }
    }
    f(paramBoolean, false);
    AppMethodBeat.o(256413);
  }
  
  public void setSize(int paramInt)
  {
    AppMethodBeat.i(256410);
    if ((paramInt != 0) && (paramInt != 1))
    {
      AppMethodBeat.o(256410);
      return;
    }
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    if (paramInt == 0) {}
    for (this.apc = ((int)(localDisplayMetrics.density * 56.0F));; this.apc = ((int)(localDisplayMetrics.density * 40.0F)))
    {
      this.aoP.setImageDrawable(null);
      this.aoV.setStyle(paramInt);
      this.aoP.setImageDrawable(this.aoV);
      AppMethodBeat.o(256410);
      return;
    }
  }
  
  public void setSlingshotDistance(int paramInt)
  {
    this.aoU = paramInt;
  }
  
  void setTargetOffsetTopAndBottom(int paramInt)
  {
    AppMethodBeat.i(256478);
    this.aoP.bringToFront();
    w.s(this.aoP, paramInt);
    this.aoL = this.aoP.getTop();
    AppMethodBeat.o(256478);
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    AppMethodBeat.i(256454);
    boolean bool = this.aoG.E(paramInt, 0);
    AppMethodBeat.o(256454);
    return bool;
  }
  
  public void stopNestedScroll()
  {
    AppMethodBeat.i(256455);
    this.aoG.bw(0);
    AppMethodBeat.o(256455);
  }
  
  public static abstract interface a
  {
    public abstract boolean ne();
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.swiperefreshlayout.widget.SwipeRefreshLayout
 * JD-Core Version:    0.7.0.1
 */