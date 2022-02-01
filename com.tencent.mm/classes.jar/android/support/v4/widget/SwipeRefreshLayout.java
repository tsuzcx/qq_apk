package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.content.b;
import android.support.v4.view.j;
import android.support.v4.view.l;
import android.support.v4.view.m;
import android.support.v4.view.o;
import android.support.v4.view.t;
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

public class SwipeRefreshLayout
  extends ViewGroup
  implements j, m
{
  private static final int[] LAYOUT_ATTRS = { 16842766 };
  private static final String LOG_TAG = SwipeRefreshLayout.class.getSimpleName();
  private View Pj;
  b SF;
  boolean SG = false;
  private float SH = -1.0F;
  private float SI;
  private final l SJ;
  private final int[] SK = new int[2];
  private final int[] SL = new int[2];
  private boolean SM;
  private int SN;
  int SO;
  private float SP;
  boolean SQ;
  private boolean SR;
  private final DecelerateInterpolator SS;
  c ST;
  private int SU = -1;
  float SV;
  protected int SW;
  int SX;
  int SY;
  d SZ;
  private Animation Ta;
  private Animation Tb;
  private Animation Tc;
  private Animation Td;
  private Animation Te;
  boolean Tf;
  private int Tg;
  boolean Th;
  private a Ti;
  private Animation.AnimationListener Tj = new Animation.AnimationListener()
  {
    public final void onAnimationEnd(Animation paramAnonymousAnimation)
    {
      if (SwipeRefreshLayout.this.SG)
      {
        SwipeRefreshLayout.this.SZ.setAlpha(255);
        SwipeRefreshLayout.this.SZ.start();
        SwipeRefreshLayout.this.SO = SwipeRefreshLayout.this.ST.getTop();
        return;
      }
      SwipeRefreshLayout.this.reset();
    }
    
    public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
    
    public final void onAnimationStart(Animation paramAnonymousAnimation) {}
  };
  private final Animation Tk = new Animation()
  {
    public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
    {
      if (!SwipeRefreshLayout.this.Th) {}
      for (int i = SwipeRefreshLayout.this.SX - Math.abs(SwipeRefreshLayout.this.SW);; i = SwipeRefreshLayout.this.SX)
      {
        int j = SwipeRefreshLayout.this.mFrom;
        i = (int)((i - SwipeRefreshLayout.this.mFrom) * paramAnonymousFloat);
        int k = SwipeRefreshLayout.this.ST.getTop();
        SwipeRefreshLayout.this.setTargetOffsetTopAndBottom(i + j - k);
        SwipeRefreshLayout.this.SZ.A(1.0F - paramAnonymousFloat);
        return;
      }
    }
  };
  private final Animation Tl = new Animation()
  {
    public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
    {
      SwipeRefreshLayout.this.K(paramAnonymousFloat);
    }
  };
  private int mActivePointerId = -1;
  protected int mFrom;
  private float mInitialMotionY;
  private boolean mIsBeingDragged;
  private int mTouchSlop;
  private final o nE;
  
  public SwipeRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.SN = getResources().getInteger(17694721);
    setWillNotDraw(false);
    this.SS = new DecelerateInterpolator(2.0F);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.Tg = ((int)(40.0F * localDisplayMetrics.density));
    this.ST = new c(getContext());
    this.SZ = new d(getContext());
    this.SZ.setStyle(1);
    this.ST.setImageDrawable(this.SZ);
    this.ST.setVisibility(8);
    addView(this.ST);
    setChildrenDrawingOrderEnabled(true);
    this.SX = ((int)(localDisplayMetrics.density * 64.0F));
    this.SH = this.SX;
    this.nE = new o(this);
    this.SJ = new l(this);
    setNestedScrollingEnabled(true);
    int i = -this.Tg;
    this.SO = i;
    this.SW = i;
    K(1.0F);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, LAYOUT_ATTRS);
    setEnabled(paramContext.getBoolean(0, true));
    paramContext.recycle();
  }
  
  private void H(float paramFloat)
  {
    this.SZ.N(true);
    float f1 = Math.min(1.0F, Math.abs(paramFloat / this.SH));
    float f2 = Math.max((float)(f1 - 0.4D), 0.0F) * 5.0F / 3.0F;
    float f4 = Math.abs(paramFloat);
    float f5 = this.SH;
    int i;
    int j;
    if (this.SY > 0)
    {
      i = this.SY;
      float f3 = i;
      f4 = Math.max(0.0F, Math.min(f4 - f5, f3 * 2.0F) / f3);
      f4 = (float)(f4 / 4.0F - Math.pow(f4 / 4.0F, 2.0D)) * 2.0F;
      i = this.SW;
      j = (int)(f3 * f1 + f3 * f4 * 2.0F);
      if (this.ST.getVisibility() != 0) {
        this.ST.setVisibility(0);
      }
      if (!this.SQ)
      {
        this.ST.setScaleX(1.0F);
        this.ST.setScaleY(1.0F);
      }
      if (this.SQ) {
        setAnimationProgress(Math.min(1.0F, paramFloat / this.SH));
      }
      if (paramFloat >= this.SH) {
        break label337;
      }
      if ((this.SZ.getAlpha() > 76) && (!a(this.Tc))) {
        fB();
      }
    }
    for (;;)
    {
      this.SZ.B(Math.min(0.8F, f2 * 0.8F));
      this.SZ.A(Math.min(1.0F, f2));
      this.SZ.C((-0.25F + f2 * 0.4F + f4 * 2.0F) * 0.5F);
      setTargetOffsetTopAndBottom(j + i - this.SO);
      return;
      if (this.Th)
      {
        i = this.SX - this.SW;
        break;
      }
      i = this.SX;
      break;
      label337:
      if ((this.SZ.getAlpha() < 255) && (!a(this.Td))) {
        fC();
      }
    }
  }
  
  private void I(float paramFloat)
  {
    if (paramFloat > this.SH)
    {
      f(true, true);
      return;
    }
    this.SG = false;
    this.SZ.B(0.0F);
    Animation.AnimationListener local5 = null;
    if (!this.SQ) {
      local5 = new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          if (!SwipeRefreshLayout.this.SQ) {
            SwipeRefreshLayout.this.a(null);
          }
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      };
    }
    b(this.SO, local5);
    this.SZ.N(false);
  }
  
  private void J(float paramFloat)
  {
    if ((paramFloat - this.SP > this.mTouchSlop) && (!this.mIsBeingDragged))
    {
      this.mInitialMotionY = (this.SP + this.mTouchSlop);
      this.mIsBeingDragged = true;
      this.SZ.setAlpha(76);
    }
  }
  
  private void a(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    this.mFrom = paramInt;
    this.Tk.reset();
    this.Tk.setDuration(200L);
    this.Tk.setInterpolator(this.SS);
    if (paramAnimationListener != null) {
      this.ST.PG = paramAnimationListener;
    }
    this.ST.clearAnimation();
    this.ST.startAnimation(this.Tk);
  }
  
  private static boolean a(Animation paramAnimation)
  {
    return (paramAnimation != null) && (paramAnimation.hasStarted()) && (!paramAnimation.hasEnded());
  }
  
  private void b(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    if (this.SQ)
    {
      c(paramInt, paramAnimationListener);
      return;
    }
    this.mFrom = paramInt;
    this.Tl.reset();
    this.Tl.setDuration(200L);
    this.Tl.setInterpolator(this.SS);
    if (paramAnimationListener != null) {
      this.ST.PG = paramAnimationListener;
    }
    this.ST.clearAnimation();
    this.ST.startAnimation(this.Tl);
  }
  
  private void c(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    this.mFrom = paramInt;
    this.SV = this.ST.getScaleX();
    this.Te = new Animation()
    {
      public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        float f1 = SwipeRefreshLayout.this.SV;
        float f2 = -SwipeRefreshLayout.this.SV;
        SwipeRefreshLayout.this.setAnimationProgress(f1 + f2 * paramAnonymousFloat);
        SwipeRefreshLayout.this.K(paramAnonymousFloat);
      }
    };
    this.Te.setDuration(150L);
    if (paramAnimationListener != null) {
      this.ST.PG = paramAnimationListener;
    }
    this.ST.clearAnimation();
    this.ST.startAnimation(this.Te);
  }
  
  private void f(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.SG != paramBoolean1)
    {
      this.Tf = paramBoolean2;
      fD();
      this.SG = paramBoolean1;
      if (this.SG) {
        a(this.SO, this.Tj);
      }
    }
    else
    {
      return;
    }
    a(this.Tj);
  }
  
  private void fB()
  {
    this.Tc = z(this.SZ.getAlpha(), 76);
  }
  
  private void fC()
  {
    this.Td = z(this.SZ.getAlpha(), 255);
  }
  
  private void fD()
  {
    int i;
    if (this.Pj == null) {
      i = 0;
    }
    for (;;)
    {
      if (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (!localView.equals(this.ST)) {
          this.Pj = localView;
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  private boolean fE()
  {
    if (this.Ti != null) {
      return this.Ti.fF();
    }
    if ((this.Pj instanceof ListView))
    {
      ListView localListView = (ListView)this.Pj;
      if (Build.VERSION.SDK_INT >= 19) {
        return localListView.canScrollList(-1);
      }
      if (localListView.getChildCount() != 0)
      {
        int i = localListView.getFirstVisiblePosition();
        int j = localListView.getChildAt(0).getTop();
        if ((i > 0) || (j < localListView.getListPaddingTop())) {
          return true;
        }
      }
      return false;
    }
    return this.Pj.canScrollVertically(-1);
  }
  
  private void onSecondaryPointerUp(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.mActivePointerId) {
      if (i != 0) {
        break label33;
      }
    }
    label33:
    for (i = 1;; i = 0)
    {
      this.mActivePointerId = paramMotionEvent.getPointerId(i);
      return;
    }
  }
  
  private void setColorViewAlpha(int paramInt)
  {
    this.ST.getBackground().setAlpha(paramInt);
    this.SZ.setAlpha(paramInt);
  }
  
  private Animation z(final int paramInt1, final int paramInt2)
  {
    Animation local4 = new Animation()
    {
      public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        SwipeRefreshLayout.this.SZ.setAlpha((int)(paramInt1 + (paramInt2 - paramInt1) * paramAnonymousFloat));
      }
    };
    local4.setDuration(300L);
    this.ST.PG = null;
    this.ST.clearAnimation();
    this.ST.startAnimation(local4);
    return local4;
  }
  
  final void K(float paramFloat)
  {
    setTargetOffsetTopAndBottom(this.mFrom + (int)((this.SW - this.mFrom) * paramFloat) - this.ST.getTop());
  }
  
  final void a(Animation.AnimationListener paramAnimationListener)
  {
    this.Tb = new Animation()
    {
      public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        SwipeRefreshLayout.this.setAnimationProgress(1.0F - paramAnonymousFloat);
      }
    };
    this.Tb.setDuration(150L);
    this.ST.PG = paramAnimationListener;
    this.ST.clearAnimation();
    this.ST.startAnimation(this.Tb);
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return this.SJ.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return this.SJ.dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return this.SJ.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return this.SJ.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (this.SU < 0) {}
    do
    {
      return paramInt2;
      if (paramInt2 == paramInt1 - 1) {
        return this.SU;
      }
    } while (paramInt2 < this.SU);
    return paramInt2 + 1;
  }
  
  public int getNestedScrollAxes()
  {
    return this.nE.Nd;
  }
  
  public int getProgressCircleDiameter()
  {
    return this.Tg;
  }
  
  public int getProgressViewEndOffset()
  {
    return this.SX;
  }
  
  public int getProgressViewStartOffset()
  {
    return this.SW;
  }
  
  public boolean hasNestedScrollingParent()
  {
    return this.SJ.aN(0);
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return this.SJ.Na;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    reset();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    fD();
    int i = paramMotionEvent.getActionMasked();
    if ((this.SR) && (i == 0)) {
      this.SR = false;
    }
    if ((!isEnabled()) || (this.SR) || (fE()) || (this.SG) || (this.SM)) {
      return false;
    }
    switch (i)
    {
    }
    for (;;)
    {
      return this.mIsBeingDragged;
      setTargetOffsetTopAndBottom(this.SW - this.ST.getTop());
      this.mActivePointerId = paramMotionEvent.getPointerId(0);
      this.mIsBeingDragged = false;
      i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      if (i < 0) {
        break;
      }
      this.SP = paramMotionEvent.getY(i);
      continue;
      if (this.mActivePointerId == -1) {
        break;
      }
      i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      if (i < 0) {
        break;
      }
      J(paramMotionEvent.getY(i));
      continue;
      onSecondaryPointerUp(paramMotionEvent);
      continue;
      this.mIsBeingDragged = false;
      this.mActivePointerId = -1;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = getMeasuredWidth();
    paramInt2 = getMeasuredHeight();
    if (getChildCount() == 0) {}
    do
    {
      return;
      if (this.Pj == null) {
        fD();
      }
    } while (this.Pj == null);
    View localView = this.Pj;
    paramInt3 = getPaddingLeft();
    paramInt4 = getPaddingTop();
    localView.layout(paramInt3, paramInt4, paramInt1 - getPaddingLeft() - getPaddingRight() + paramInt3, paramInt2 - getPaddingTop() - getPaddingBottom() + paramInt4);
    paramInt2 = this.ST.getMeasuredWidth();
    paramInt3 = this.ST.getMeasuredHeight();
    this.ST.layout(paramInt1 / 2 - paramInt2 / 2, this.SO, paramInt1 / 2 + paramInt2 / 2, this.SO + paramInt3);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.Pj == null) {
      fD();
    }
    if (this.Pj == null) {}
    for (;;)
    {
      return;
      this.Pj.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), 1073741824));
      this.ST.measure(View.MeasureSpec.makeMeasureSpec(this.Tg, 1073741824), View.MeasureSpec.makeMeasureSpec(this.Tg, 1073741824));
      this.SU = -1;
      paramInt1 = 0;
      while (paramInt1 < getChildCount())
      {
        if (getChildAt(paramInt1) == this.ST)
        {
          this.SU = paramInt1;
          return;
        }
        paramInt1 += 1;
      }
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    if ((paramInt2 > 0) && (this.SI > 0.0F))
    {
      if (paramInt2 <= this.SI) {
        break label141;
      }
      paramArrayOfInt[1] = (paramInt2 - (int)this.SI);
      this.SI = 0.0F;
    }
    for (;;)
    {
      H(this.SI);
      if ((this.Th) && (paramInt2 > 0) && (this.SI == 0.0F) && (Math.abs(paramInt2 - paramArrayOfInt[1]) > 0)) {
        this.ST.setVisibility(8);
      }
      paramView = this.SK;
      if (dispatchNestedPreScroll(paramInt1 - paramArrayOfInt[0], paramInt2 - paramArrayOfInt[1], paramView, null))
      {
        paramArrayOfInt[0] += paramView[0];
        paramInt1 = paramArrayOfInt[1];
        paramView[1] += paramInt1;
      }
      return;
      label141:
      this.SI -= paramInt2;
      paramArrayOfInt[1] = paramInt2;
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.SL);
    paramInt1 = this.SL[1] + paramInt4;
    if ((paramInt1 < 0) && (!fE()))
    {
      float f = this.SI;
      this.SI = (Math.abs(paramInt1) + f);
      H(this.SI);
    }
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    this.nE.Nd = paramInt;
    startNestedScroll(paramInt & 0x2);
    this.SI = 0.0F;
    this.SM = true;
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return (isEnabled()) && (!this.SR) && (!this.SG) && ((paramInt & 0x2) != 0);
  }
  
  public void onStopNestedScroll(View paramView)
  {
    this.nE.Nd = 0;
    this.SM = false;
    if (this.SI > 0.0F)
    {
      I(this.SI);
      this.SI = 0.0F;
    }
    stopNestedScroll();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if ((this.SR) && (i == 0)) {
      this.SR = false;
    }
    if ((!isEnabled()) || (this.SR) || (fE()) || (this.SG) || (this.SM)) {}
    float f1;
    do
    {
      return false;
      switch (i)
      {
      case 3: 
      case 4: 
      default: 
      case 0: 
      case 2: 
      case 5: 
      case 6: 
        for (;;)
        {
          return true;
          this.mActivePointerId = paramMotionEvent.getPointerId(0);
          this.mIsBeingDragged = false;
          continue;
          i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
          if (i < 0) {
            break;
          }
          f1 = paramMotionEvent.getY(i);
          J(f1);
          if (this.mIsBeingDragged)
          {
            f1 = (f1 - this.mInitialMotionY) * 0.5F;
            if (f1 <= 0.0F) {
              break;
            }
            H(f1);
            continue;
            i = paramMotionEvent.getActionIndex();
            if (i < 0) {
              break;
            }
            this.mActivePointerId = paramMotionEvent.getPointerId(i);
            continue;
            onSecondaryPointerUp(paramMotionEvent);
          }
        }
      }
      i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
    } while (i < 0);
    if (this.mIsBeingDragged)
    {
      f1 = paramMotionEvent.getY(i);
      float f2 = this.mInitialMotionY;
      this.mIsBeingDragged = false;
      I((f1 - f2) * 0.5F);
    }
    this.mActivePointerId = -1;
    return false;
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (((Build.VERSION.SDK_INT >= 21) || (!(this.Pj instanceof AbsListView))) && ((this.Pj == null) || (t.av(this.Pj)))) {
      super.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  final void reset()
  {
    this.ST.clearAnimation();
    this.SZ.stop();
    this.ST.setVisibility(8);
    setColorViewAlpha(255);
    if (this.SQ) {
      setAnimationProgress(0.0F);
    }
    for (;;)
    {
      this.SO = this.ST.getTop();
      return;
      setTargetOffsetTopAndBottom(this.SW - this.SO);
    }
  }
  
  void setAnimationProgress(float paramFloat)
  {
    this.ST.setScaleX(paramFloat);
    this.ST.setScaleY(paramFloat);
  }
  
  @Deprecated
  public void setColorScheme(int... paramVarArgs)
  {
    setColorSchemeResources(paramVarArgs);
  }
  
  public void setColorSchemeColors(int... paramVarArgs)
  {
    fD();
    d locald = this.SZ;
    locald.PO.setColors(paramVarArgs);
    locald.PO.aU(0);
    locald.invalidateSelf();
  }
  
  public void setColorSchemeResources(int... paramVarArgs)
  {
    Context localContext = getContext();
    int[] arrayOfInt = new int[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      arrayOfInt[i] = b.n(localContext, paramVarArgs[i]);
      i += 1;
    }
    setColorSchemeColors(arrayOfInt);
  }
  
  public void setDistanceToTriggerSync(int paramInt)
  {
    this.SH = paramInt;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    if (!paramBoolean) {
      reset();
    }
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    this.SJ.setNestedScrollingEnabled(paramBoolean);
  }
  
  public void setOnChildScrollUpCallback(a parama)
  {
    this.Ti = parama;
  }
  
  public void setOnRefreshListener(b paramb)
  {
    this.SF = paramb;
  }
  
  @Deprecated
  public void setProgressBackgroundColor(int paramInt)
  {
    setProgressBackgroundColorSchemeResource(paramInt);
  }
  
  public void setProgressBackgroundColorSchemeColor(int paramInt)
  {
    this.ST.setBackgroundColor(paramInt);
  }
  
  public void setProgressBackgroundColorSchemeResource(int paramInt)
  {
    setProgressBackgroundColorSchemeColor(b.n(getContext(), paramInt));
  }
  
  public void setRefreshing(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.SG != paramBoolean))
    {
      this.SG = paramBoolean;
      if (!this.Th) {}
      for (int i = this.SX + this.SW;; i = this.SX)
      {
        setTargetOffsetTopAndBottom(i - this.SO);
        this.Tf = false;
        Animation.AnimationListener localAnimationListener = this.Tj;
        this.ST.setVisibility(0);
        this.SZ.setAlpha(255);
        this.Ta = new Animation()
        {
          public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
          {
            SwipeRefreshLayout.this.setAnimationProgress(paramAnonymousFloat);
          }
        };
        this.Ta.setDuration(this.SN);
        if (localAnimationListener != null) {
          this.ST.PG = localAnimationListener;
        }
        this.ST.clearAnimation();
        this.ST.startAnimation(this.Ta);
        return;
      }
    }
    f(paramBoolean, false);
  }
  
  public void setSize(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      return;
    }
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    if (paramInt == 0) {}
    for (this.Tg = ((int)(localDisplayMetrics.density * 56.0F));; this.Tg = ((int)(localDisplayMetrics.density * 40.0F)))
    {
      this.ST.setImageDrawable(null);
      this.SZ.setStyle(paramInt);
      this.ST.setImageDrawable(this.SZ);
      return;
    }
  }
  
  public void setSlingshotDistance(int paramInt)
  {
    this.SY = paramInt;
  }
  
  void setTargetOffsetTopAndBottom(int paramInt)
  {
    this.ST.bringToFront();
    t.s(this.ST, paramInt);
    this.SO = this.ST.getTop();
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return this.SJ.t(paramInt, 0);
  }
  
  public void stopNestedScroll()
  {
    this.SJ.aM(0);
  }
  
  public static abstract interface a
  {
    public abstract boolean fF();
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.widget.SwipeRefreshLayout
 * JD-Core Version:    0.7.0.1
 */