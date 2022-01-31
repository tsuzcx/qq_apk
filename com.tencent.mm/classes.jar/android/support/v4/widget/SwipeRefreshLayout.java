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
import android.widget.AbsListView;
import android.widget.ListView;

public class SwipeRefreshLayout
  extends ViewGroup
  implements j, m
{
  private static final int[] LAYOUT_ATTRS = { 16842766 };
  private static final String LOG_TAG = SwipeRefreshLayout.class.getSimpleName();
  private View Ij;
  SwipeRefreshLayout.b LC;
  boolean LD = false;
  private float LE = -1.0F;
  private float LF;
  private final l LG;
  private final int[] LH = new int[2];
  private final int[] LI = new int[2];
  private boolean LJ;
  private int LK;
  int LL;
  private float LM;
  boolean LN;
  private boolean LO;
  private final DecelerateInterpolator LP;
  c LQ;
  private int LR = -1;
  float LS;
  protected int LU;
  int LV;
  int LW;
  d LX;
  private Animation LY;
  private Animation LZ;
  private Animation Ma;
  private Animation Mb;
  private Animation Mc;
  boolean Md;
  private int Me;
  boolean Mf;
  private SwipeRefreshLayout.a Mg;
  private Animation.AnimationListener Mh = new SwipeRefreshLayout.1(this);
  private final Animation Mi = new SwipeRefreshLayout.6(this);
  private final Animation Mj = new SwipeRefreshLayout.7(this);
  private final o iK;
  private int mActivePointerId = -1;
  protected int mFrom;
  private float mInitialMotionY;
  private boolean mIsBeingDragged;
  private int mTouchSlop;
  
  public SwipeRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.LK = getResources().getInteger(17694721);
    setWillNotDraw(false);
    this.LP = new DecelerateInterpolator(2.0F);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.Me = ((int)(40.0F * localDisplayMetrics.density));
    this.LQ = new c(getContext());
    this.LX = new d(getContext());
    this.LX.aC(1);
    this.LQ.setImageDrawable(this.LX);
    this.LQ.setVisibility(8);
    addView(this.LQ);
    setChildrenDrawingOrderEnabled(true);
    this.LV = ((int)(localDisplayMetrics.density * 64.0F));
    this.LE = this.LV;
    this.iK = new o(this);
    this.LG = new l(this);
    setNestedScrollingEnabled(true);
    int i = -this.Me;
    this.LL = i;
    this.LU = i;
    K(1.0F);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, LAYOUT_ATTRS);
    setEnabled(paramContext.getBoolean(0, true));
    paramContext.recycle();
  }
  
  private void H(float paramFloat)
  {
    this.LX.H(true);
    float f1 = Math.min(1.0F, Math.abs(paramFloat / this.LE));
    float f2 = Math.max((float)(f1 - 0.4D), 0.0F) * 5.0F / 3.0F;
    float f4 = Math.abs(paramFloat);
    float f5 = this.LE;
    int i;
    int j;
    if (this.LW > 0)
    {
      i = this.LW;
      float f3 = i;
      f4 = Math.max(0.0F, Math.min(f4 - f5, f3 * 2.0F) / f3);
      f4 = (float)(f4 / 4.0F - Math.pow(f4 / 4.0F, 2.0D)) * 2.0F;
      i = this.LU;
      j = (int)(f3 * f1 + f3 * f4 * 2.0F);
      if (this.LQ.getVisibility() != 0) {
        this.LQ.setVisibility(0);
      }
      if (!this.LN)
      {
        this.LQ.setScaleX(1.0F);
        this.LQ.setScaleY(1.0F);
      }
      if (this.LN) {
        setAnimationProgress(Math.min(1.0F, paramFloat / this.LE));
      }
      if (paramFloat >= this.LE) {
        break label337;
      }
      if ((this.LX.getAlpha() > 76) && (!a(this.Ma))) {
        ej();
      }
    }
    for (;;)
    {
      this.LX.B(Math.min(0.8F, f2 * 0.8F));
      this.LX.A(Math.min(1.0F, f2));
      this.LX.C((-0.25F + f2 * 0.4F + f4 * 2.0F) * 0.5F);
      setTargetOffsetTopAndBottom(j + i - this.LL);
      return;
      if (this.Mf)
      {
        i = this.LV - this.LU;
        break;
      }
      i = this.LV;
      break;
      label337:
      if ((this.LX.getAlpha() < 255) && (!a(this.Mb))) {
        ek();
      }
    }
  }
  
  private void I(float paramFloat)
  {
    if (paramFloat > this.LE)
    {
      f(true, true);
      return;
    }
    this.LD = false;
    this.LX.B(0.0F);
    SwipeRefreshLayout.5 local5 = null;
    if (!this.LN) {
      local5 = new SwipeRefreshLayout.5(this);
    }
    b(this.LL, local5);
    this.LX.H(false);
  }
  
  private void J(float paramFloat)
  {
    if ((paramFloat - this.LM > this.mTouchSlop) && (!this.mIsBeingDragged))
    {
      this.mInitialMotionY = (this.LM + this.mTouchSlop);
      this.mIsBeingDragged = true;
      this.LX.setAlpha(76);
    }
  }
  
  private void a(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    this.mFrom = paramInt;
    this.Mi.reset();
    this.Mi.setDuration(200L);
    this.Mi.setInterpolator(this.LP);
    if (paramAnimationListener != null) {
      this.LQ.IH = paramAnimationListener;
    }
    this.LQ.clearAnimation();
    this.LQ.startAnimation(this.Mi);
  }
  
  private static boolean a(Animation paramAnimation)
  {
    return (paramAnimation != null) && (paramAnimation.hasStarted()) && (!paramAnimation.hasEnded());
  }
  
  private void b(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    if (this.LN)
    {
      c(paramInt, paramAnimationListener);
      return;
    }
    this.mFrom = paramInt;
    this.Mj.reset();
    this.Mj.setDuration(200L);
    this.Mj.setInterpolator(this.LP);
    if (paramAnimationListener != null) {
      this.LQ.IH = paramAnimationListener;
    }
    this.LQ.clearAnimation();
    this.LQ.startAnimation(this.Mj);
  }
  
  private void c(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    this.mFrom = paramInt;
    this.LS = this.LQ.getScaleX();
    this.Mc = new SwipeRefreshLayout.8(this);
    this.Mc.setDuration(150L);
    if (paramAnimationListener != null) {
      this.LQ.IH = paramAnimationListener;
    }
    this.LQ.clearAnimation();
    this.LQ.startAnimation(this.Mc);
  }
  
  private void ej()
  {
    this.Ma = x(this.LX.getAlpha(), 76);
  }
  
  private void ek()
  {
    this.Mb = x(this.LX.getAlpha(), 255);
  }
  
  private void el()
  {
    int i;
    if (this.Ij == null) {
      i = 0;
    }
    for (;;)
    {
      if (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (!localView.equals(this.LQ)) {
          this.Ij = localView;
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  private boolean em()
  {
    if (this.Mg != null) {
      return this.Mg.en();
    }
    if ((this.Ij instanceof ListView))
    {
      ListView localListView = (ListView)this.Ij;
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
    return this.Ij.canScrollVertically(-1);
  }
  
  private void f(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.LD != paramBoolean1)
    {
      this.Md = paramBoolean2;
      el();
      this.LD = paramBoolean1;
      if (this.LD) {
        a(this.LL, this.Mh);
      }
    }
    else
    {
      return;
    }
    a(this.Mh);
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
    this.LQ.getBackground().setAlpha(paramInt);
    this.LX.setAlpha(paramInt);
  }
  
  private Animation x(int paramInt1, int paramInt2)
  {
    SwipeRefreshLayout.4 local4 = new SwipeRefreshLayout.4(this, paramInt1, paramInt2);
    local4.setDuration(300L);
    this.LQ.IH = null;
    this.LQ.clearAnimation();
    this.LQ.startAnimation(local4);
    return local4;
  }
  
  final void K(float paramFloat)
  {
    setTargetOffsetTopAndBottom(this.mFrom + (int)((this.LU - this.mFrom) * paramFloat) - this.LQ.getTop());
  }
  
  final void a(Animation.AnimationListener paramAnimationListener)
  {
    this.LZ = new SwipeRefreshLayout.3(this);
    this.LZ.setDuration(150L);
    this.LQ.IH = paramAnimationListener;
    this.LQ.clearAnimation();
    this.LQ.startAnimation(this.LZ);
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return this.LG.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return this.LG.dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return this.LG.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return this.LG.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (this.LR < 0) {}
    do
    {
      return paramInt2;
      if (paramInt2 == paramInt1 - 1) {
        return this.LR;
      }
    } while (paramInt2 < this.LR);
    return paramInt2 + 1;
  }
  
  public int getNestedScrollAxes()
  {
    return this.iK.Gd;
  }
  
  public int getProgressCircleDiameter()
  {
    return this.Me;
  }
  
  public int getProgressViewEndOffset()
  {
    return this.LV;
  }
  
  public int getProgressViewStartOffset()
  {
    return this.LU;
  }
  
  public boolean hasNestedScrollingParent()
  {
    return this.LG.au(0);
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return this.LG.Ga;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    reset();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    el();
    int i = paramMotionEvent.getActionMasked();
    if ((this.LO) && (i == 0)) {
      this.LO = false;
    }
    if ((!isEnabled()) || (this.LO) || (em()) || (this.LD) || (this.LJ)) {
      return false;
    }
    switch (i)
    {
    }
    for (;;)
    {
      return this.mIsBeingDragged;
      setTargetOffsetTopAndBottom(this.LU - this.LQ.getTop());
      this.mActivePointerId = paramMotionEvent.getPointerId(0);
      this.mIsBeingDragged = false;
      i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      if (i < 0) {
        break;
      }
      this.LM = paramMotionEvent.getY(i);
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
      if (this.Ij == null) {
        el();
      }
    } while (this.Ij == null);
    View localView = this.Ij;
    paramInt3 = getPaddingLeft();
    paramInt4 = getPaddingTop();
    localView.layout(paramInt3, paramInt4, paramInt1 - getPaddingLeft() - getPaddingRight() + paramInt3, paramInt2 - getPaddingTop() - getPaddingBottom() + paramInt4);
    paramInt2 = this.LQ.getMeasuredWidth();
    paramInt3 = this.LQ.getMeasuredHeight();
    this.LQ.layout(paramInt1 / 2 - paramInt2 / 2, this.LL, paramInt1 / 2 + paramInt2 / 2, this.LL + paramInt3);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.Ij == null) {
      el();
    }
    if (this.Ij == null) {}
    for (;;)
    {
      return;
      this.Ij.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), 1073741824));
      this.LQ.measure(View.MeasureSpec.makeMeasureSpec(this.Me, 1073741824), View.MeasureSpec.makeMeasureSpec(this.Me, 1073741824));
      this.LR = -1;
      paramInt1 = 0;
      while (paramInt1 < getChildCount())
      {
        if (getChildAt(paramInt1) == this.LQ)
        {
          this.LR = paramInt1;
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
    if ((paramInt2 > 0) && (this.LF > 0.0F))
    {
      if (paramInt2 <= this.LF) {
        break label141;
      }
      paramArrayOfInt[1] = (paramInt2 - (int)this.LF);
      this.LF = 0.0F;
    }
    for (;;)
    {
      H(this.LF);
      if ((this.Mf) && (paramInt2 > 0) && (this.LF == 0.0F) && (Math.abs(paramInt2 - paramArrayOfInt[1]) > 0)) {
        this.LQ.setVisibility(8);
      }
      paramView = this.LH;
      if (dispatchNestedPreScroll(paramInt1 - paramArrayOfInt[0], paramInt2 - paramArrayOfInt[1], paramView, null))
      {
        paramArrayOfInt[0] += paramView[0];
        paramInt1 = paramArrayOfInt[1];
        paramView[1] += paramInt1;
      }
      return;
      label141:
      this.LF -= paramInt2;
      paramArrayOfInt[1] = paramInt2;
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.LI);
    paramInt1 = this.LI[1] + paramInt4;
    if ((paramInt1 < 0) && (!em()))
    {
      float f = this.LF;
      this.LF = (Math.abs(paramInt1) + f);
      H(this.LF);
    }
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    this.iK.Gd = paramInt;
    startNestedScroll(paramInt & 0x2);
    this.LF = 0.0F;
    this.LJ = true;
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return (isEnabled()) && (!this.LO) && (!this.LD) && ((paramInt & 0x2) != 0);
  }
  
  public void onStopNestedScroll(View paramView)
  {
    this.iK.Gd = 0;
    this.LJ = false;
    if (this.LF > 0.0F)
    {
      I(this.LF);
      this.LF = 0.0F;
    }
    stopNestedScroll();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if ((this.LO) && (i == 0)) {
      this.LO = false;
    }
    if ((!isEnabled()) || (this.LO) || (em()) || (this.LD) || (this.LJ)) {}
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
    if (((Build.VERSION.SDK_INT >= 21) || (!(this.Ij instanceof AbsListView))) && ((this.Ij == null) || (t.aq(this.Ij)))) {
      super.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  final void reset()
  {
    this.LQ.clearAnimation();
    this.LX.stop();
    this.LQ.setVisibility(8);
    setColorViewAlpha(255);
    if (this.LN) {
      setAnimationProgress(0.0F);
    }
    for (;;)
    {
      this.LL = this.LQ.getTop();
      return;
      setTargetOffsetTopAndBottom(this.LU - this.LL);
    }
  }
  
  void setAnimationProgress(float paramFloat)
  {
    this.LQ.setScaleX(paramFloat);
    this.LQ.setScaleY(paramFloat);
  }
  
  @Deprecated
  public void setColorScheme(int... paramVarArgs)
  {
    setColorSchemeResources(paramVarArgs);
  }
  
  public void setColorSchemeColors(int... paramVarArgs)
  {
    el();
    d locald = this.LX;
    locald.IP.setColors(paramVarArgs);
    locald.IP.aD(0);
    locald.invalidateSelf();
  }
  
  public void setColorSchemeResources(int... paramVarArgs)
  {
    Context localContext = getContext();
    int[] arrayOfInt = new int[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      arrayOfInt[i] = b.m(localContext, paramVarArgs[i]);
      i += 1;
    }
    setColorSchemeColors(arrayOfInt);
  }
  
  public void setDistanceToTriggerSync(int paramInt)
  {
    this.LE = paramInt;
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
    this.LG.setNestedScrollingEnabled(paramBoolean);
  }
  
  public void setOnChildScrollUpCallback(SwipeRefreshLayout.a parama)
  {
    this.Mg = parama;
  }
  
  public void setOnRefreshListener(SwipeRefreshLayout.b paramb)
  {
    this.LC = paramb;
  }
  
  @Deprecated
  public void setProgressBackgroundColor(int paramInt)
  {
    setProgressBackgroundColorSchemeResource(paramInt);
  }
  
  public void setProgressBackgroundColorSchemeColor(int paramInt)
  {
    this.LQ.setBackgroundColor(paramInt);
  }
  
  public void setProgressBackgroundColorSchemeResource(int paramInt)
  {
    setProgressBackgroundColorSchemeColor(b.m(getContext(), paramInt));
  }
  
  public void setRefreshing(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.LD != paramBoolean))
    {
      this.LD = paramBoolean;
      if (!this.Mf) {}
      for (int i = this.LV + this.LU;; i = this.LV)
      {
        setTargetOffsetTopAndBottom(i - this.LL);
        this.Md = false;
        Animation.AnimationListener localAnimationListener = this.Mh;
        this.LQ.setVisibility(0);
        this.LX.setAlpha(255);
        this.LY = new SwipeRefreshLayout.2(this);
        this.LY.setDuration(this.LK);
        if (localAnimationListener != null) {
          this.LQ.IH = localAnimationListener;
        }
        this.LQ.clearAnimation();
        this.LQ.startAnimation(this.LY);
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
    for (this.Me = ((int)(localDisplayMetrics.density * 56.0F));; this.Me = ((int)(localDisplayMetrics.density * 40.0F)))
    {
      this.LQ.setImageDrawable(null);
      this.LX.aC(paramInt);
      this.LQ.setImageDrawable(this.LX);
      return;
    }
  }
  
  public void setSlingshotDistance(int paramInt)
  {
    this.LW = paramInt;
  }
  
  void setTargetOffsetTopAndBottom(int paramInt)
  {
    this.LQ.bringToFront();
    t.q(this.LQ, paramInt);
    this.LL = this.LQ.getTop();
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return this.LG.r(paramInt, 0);
  }
  
  public void stopNestedScroll()
  {
    this.LG.av(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v4.widget.SwipeRefreshLayout
 * JD-Core Version:    0.7.0.1
 */