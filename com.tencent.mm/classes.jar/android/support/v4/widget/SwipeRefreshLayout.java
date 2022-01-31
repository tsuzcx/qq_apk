package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.content.b;
import android.support.v4.view.g;
import android.support.v4.view.i;
import android.support.v4.view.j;
import android.support.v4.view.l;
import android.support.v4.view.q;
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
  implements g, j
{
  private static final int[] Gr = { 16842766 };
  private static final String LT = SwipeRefreshLayout.class.getSimpleName();
  private float FI;
  private View Iy;
  SwipeRefreshLayout.b LU;
  boolean LV = false;
  private float LW = -1.0F;
  private float LX;
  private final i LY;
  private final int[] LZ = new int[2];
  private final int[] Ma = new int[2];
  private boolean Mb;
  private int Mc;
  int Md;
  private float Me;
  boolean Mf;
  private boolean Mg;
  private final DecelerateInterpolator Mh;
  c Mi;
  private int Mj = -1;
  float Mk;
  protected int Ml;
  int Mm;
  d Mn;
  private Animation Mo;
  private Animation Mp;
  private Animation Mq;
  private Animation Mr;
  private Animation Ms;
  boolean Mt;
  private int Mu;
  boolean Mv;
  private SwipeRefreshLayout.a Mw;
  private Animation.AnimationListener Mx = new SwipeRefreshLayout.1(this);
  private final Animation My = new SwipeRefreshLayout.6(this);
  private final Animation Mz = new SwipeRefreshLayout.7(this);
  private int fC = -1;
  private final l hN;
  private boolean iZ;
  private int jb;
  protected int mFrom;
  
  public SwipeRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jb = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.Mc = getResources().getInteger(17694721);
    setWillNotDraw(false);
    this.Mh = new DecelerateInterpolator(2.0F);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.Mu = ((int)(40.0F * localDisplayMetrics.density));
    this.Mi = new c(getContext());
    this.Mn = new d(getContext());
    this.Mn.aF(1);
    this.Mi.setImageDrawable(this.Mn);
    this.Mi.setVisibility(8);
    addView(this.Mi);
    setChildrenDrawingOrderEnabled(true);
    this.Mm = ((int)(localDisplayMetrics.density * 64.0F));
    this.LW = this.Mm;
    this.hN = new l(this);
    this.LY = new i(this);
    setNestedScrollingEnabled(true);
    int i = -this.Mu;
    this.Md = i;
    this.Ml = i;
    J(1.0F);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, Gr);
    setEnabled(paramContext.getBoolean(0, true));
    paramContext.recycle();
  }
  
  private void G(float paramFloat)
  {
    this.Mn.I(true);
    float f2 = Math.min(1.0F, Math.abs(paramFloat / this.LW));
    float f3 = (float)Math.max(f2 - 0.4D, 0.0D) * 5.0F / 3.0F;
    float f4 = Math.abs(paramFloat);
    float f5 = this.LW;
    float f1;
    int i;
    int j;
    if (this.Mv)
    {
      f1 = this.Mm - this.Ml;
      f4 = Math.max(0.0F, Math.min(f4 - f5, f1 * 2.0F) / f1);
      f4 = (float)(f4 / 4.0F - Math.pow(f4 / 4.0F, 2.0D)) * 2.0F;
      i = this.Ml;
      j = (int)(f1 * f2 + f1 * f4 * 2.0F);
      if (this.Mi.getVisibility() != 0) {
        this.Mi.setVisibility(0);
      }
      if (!this.Mf)
      {
        this.Mi.setScaleX(1.0F);
        this.Mi.setScaleY(1.0F);
      }
      if (this.Mf) {
        setAnimationProgress(Math.min(1.0F, paramFloat / this.LW));
      }
      if (paramFloat >= this.LW) {
        break label341;
      }
      if ((this.Mn.getAlpha() > 76) && (!f(this.Mq))) {
        this.Mq = w(this.Mn.getAlpha(), 76);
      }
    }
    for (;;)
    {
      this.Mn.B(Math.min(0.8F, f3 * 0.8F));
      this.Mn.A(Math.min(1.0F, f3));
      d locald = this.Mn;
      locald.Jg.gb = ((-0.25F + f3 * 0.4F + f4 * 2.0F) * 0.5F);
      locald.invalidateSelf();
      setTargetOffsetTopAndBottom(j + i - this.Md);
      return;
      f1 = this.Mm;
      break;
      label341:
      if ((this.Mn.getAlpha() < 255) && (!f(this.Mr))) {
        this.Mr = w(this.Mn.getAlpha(), 255);
      }
    }
  }
  
  private void H(float paramFloat)
  {
    if (paramFloat > this.LW)
    {
      e(true, true);
      return;
    }
    this.LV = false;
    this.Mn.B(0.0F);
    SwipeRefreshLayout.5 local5 = null;
    if (!this.Mf) {
      local5 = new SwipeRefreshLayout.5(this);
    }
    int i = this.Md;
    if (this.Mf)
    {
      this.mFrom = i;
      this.Mk = this.Mi.getScaleX();
      this.Ms = new SwipeRefreshLayout.8(this);
      this.Ms.setDuration(150L);
      if (local5 != null) {
        this.Mi.IZ = local5;
      }
      this.Mi.clearAnimation();
      this.Mi.startAnimation(this.Ms);
    }
    for (;;)
    {
      this.Mn.I(false);
      return;
      this.mFrom = i;
      this.Mz.reset();
      this.Mz.setDuration(200L);
      this.Mz.setInterpolator(this.Mh);
      if (local5 != null) {
        this.Mi.IZ = local5;
      }
      this.Mi.clearAnimation();
      this.Mi.startAnimation(this.Mz);
    }
  }
  
  private void I(float paramFloat)
  {
    if ((paramFloat - this.Me > this.jb) && (!this.iZ))
    {
      this.FI = (this.Me + this.jb);
      this.iZ = true;
      this.Mn.setAlpha(76);
    }
  }
  
  private void d(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.fC) {
      if (i != 0) {
        break label33;
      }
    }
    label33:
    for (i = 1;; i = 0)
    {
      this.fC = paramMotionEvent.getPointerId(i);
      return;
    }
  }
  
  private void dT()
  {
    int i;
    if (this.Iy == null) {
      i = 0;
    }
    for (;;)
    {
      if (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (!localView.equals(this.Mi)) {
          this.Iy = localView;
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  private boolean dU()
  {
    if (this.Mw != null) {
      return this.Mw.dV();
    }
    if ((this.Iy instanceof ListView))
    {
      ListView localListView = (ListView)this.Iy;
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
    return this.Iy.canScrollVertically(-1);
  }
  
  private void e(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.LV != paramBoolean1)
    {
      this.Mt = paramBoolean2;
      dT();
      this.LV = paramBoolean1;
      if (this.LV)
      {
        int i = this.Md;
        Animation.AnimationListener localAnimationListener = this.Mx;
        this.mFrom = i;
        this.My.reset();
        this.My.setDuration(200L);
        this.My.setInterpolator(this.Mh);
        if (localAnimationListener != null) {
          this.Mi.IZ = localAnimationListener;
        }
        this.Mi.clearAnimation();
        this.Mi.startAnimation(this.My);
      }
    }
    else
    {
      return;
    }
    a(this.Mx);
  }
  
  private static boolean f(Animation paramAnimation)
  {
    return (paramAnimation != null) && (paramAnimation.hasStarted()) && (!paramAnimation.hasEnded());
  }
  
  private void setColorViewAlpha(int paramInt)
  {
    this.Mi.getBackground().setAlpha(paramInt);
    this.Mn.setAlpha(paramInt);
  }
  
  private Animation w(int paramInt1, int paramInt2)
  {
    SwipeRefreshLayout.4 local4 = new SwipeRefreshLayout.4(this, paramInt1, paramInt2);
    local4.setDuration(300L);
    this.Mi.IZ = null;
    this.Mi.clearAnimation();
    this.Mi.startAnimation(local4);
    return local4;
  }
  
  final void J(float paramFloat)
  {
    setTargetOffsetTopAndBottom(this.mFrom + (int)((this.Ml - this.mFrom) * paramFloat) - this.Mi.getTop());
  }
  
  final void a(Animation.AnimationListener paramAnimationListener)
  {
    this.Mp = new Animation()
    {
      public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        SwipeRefreshLayout.this.setAnimationProgress(1.0F - paramAnonymousFloat);
      }
    };
    this.Mp.setDuration(150L);
    this.Mi.IZ = paramAnimationListener;
    this.Mi.clearAnimation();
    this.Mi.startAnimation(this.Mp);
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return this.LY.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return this.LY.dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return this.LY.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return this.LY.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (this.Mj < 0) {}
    do
    {
      return paramInt2;
      if (paramInt2 == paramInt1 - 1) {
        return this.Mj;
      }
    } while (paramInt2 < this.Mj);
    return paramInt2 + 1;
  }
  
  public int getNestedScrollAxes()
  {
    return this.hN.Fs;
  }
  
  public int getProgressCircleDiameter()
  {
    return this.Mu;
  }
  
  public int getProgressViewEndOffset()
  {
    return this.Mm;
  }
  
  public int getProgressViewStartOffset()
  {
    return this.Ml;
  }
  
  public boolean hasNestedScrollingParent()
  {
    return this.LY.au(0);
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return this.LY.Fp;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    reset();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    dT();
    int i = paramMotionEvent.getActionMasked();
    if ((this.Mg) && (i == 0)) {
      this.Mg = false;
    }
    if ((!isEnabled()) || (this.Mg) || (dU()) || (this.LV) || (this.Mb)) {
      return false;
    }
    switch (i)
    {
    }
    for (;;)
    {
      return this.iZ;
      setTargetOffsetTopAndBottom(this.Ml - this.Mi.getTop());
      this.fC = paramMotionEvent.getPointerId(0);
      this.iZ = false;
      i = paramMotionEvent.findPointerIndex(this.fC);
      if (i < 0) {
        break;
      }
      this.Me = paramMotionEvent.getY(i);
      continue;
      if (this.fC == -1) {
        break;
      }
      i = paramMotionEvent.findPointerIndex(this.fC);
      if (i < 0) {
        break;
      }
      I(paramMotionEvent.getY(i));
      continue;
      d(paramMotionEvent);
      continue;
      this.iZ = false;
      this.fC = -1;
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
      if (this.Iy == null) {
        dT();
      }
    } while (this.Iy == null);
    View localView = this.Iy;
    paramInt3 = getPaddingLeft();
    paramInt4 = getPaddingTop();
    localView.layout(paramInt3, paramInt4, paramInt1 - getPaddingLeft() - getPaddingRight() + paramInt3, paramInt2 - getPaddingTop() - getPaddingBottom() + paramInt4);
    paramInt2 = this.Mi.getMeasuredWidth();
    paramInt3 = this.Mi.getMeasuredHeight();
    this.Mi.layout(paramInt1 / 2 - paramInt2 / 2, this.Md, paramInt1 / 2 + paramInt2 / 2, this.Md + paramInt3);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.Iy == null) {
      dT();
    }
    if (this.Iy == null) {}
    for (;;)
    {
      return;
      this.Iy.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), 1073741824));
      this.Mi.measure(View.MeasureSpec.makeMeasureSpec(this.Mu, 1073741824), View.MeasureSpec.makeMeasureSpec(this.Mu, 1073741824));
      this.Mj = -1;
      paramInt1 = 0;
      while (paramInt1 < getChildCount())
      {
        if (getChildAt(paramInt1) == this.Mi)
        {
          this.Mj = paramInt1;
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
    if ((paramInt2 > 0) && (this.LX > 0.0F))
    {
      if (paramInt2 <= this.LX) {
        break label141;
      }
      paramArrayOfInt[1] = (paramInt2 - (int)this.LX);
      this.LX = 0.0F;
    }
    for (;;)
    {
      G(this.LX);
      if ((this.Mv) && (paramInt2 > 0) && (this.LX == 0.0F) && (Math.abs(paramInt2 - paramArrayOfInt[1]) > 0)) {
        this.Mi.setVisibility(8);
      }
      paramView = this.LZ;
      if (dispatchNestedPreScroll(paramInt1 - paramArrayOfInt[0], paramInt2 - paramArrayOfInt[1], paramView, null))
      {
        paramArrayOfInt[0] += paramView[0];
        paramInt1 = paramArrayOfInt[1];
        paramView[1] += paramInt1;
      }
      return;
      label141:
      this.LX -= paramInt2;
      paramArrayOfInt[1] = paramInt2;
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.Ma);
    paramInt1 = this.Ma[1] + paramInt4;
    if ((paramInt1 < 0) && (!dU()))
    {
      float f = this.LX;
      this.LX = (Math.abs(paramInt1) + f);
      G(this.LX);
    }
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    this.hN.Fs = paramInt;
    startNestedScroll(paramInt & 0x2);
    this.LX = 0.0F;
    this.Mb = true;
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return (isEnabled()) && (!this.Mg) && (!this.LV) && ((paramInt & 0x2) != 0);
  }
  
  public void onStopNestedScroll(View paramView)
  {
    this.hN.Fs = 0;
    this.Mb = false;
    if (this.LX > 0.0F)
    {
      H(this.LX);
      this.LX = 0.0F;
    }
    stopNestedScroll();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if ((this.Mg) && (i == 0)) {
      this.Mg = false;
    }
    if ((!isEnabled()) || (this.Mg) || (dU()) || (this.LV) || (this.Mb)) {}
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
          this.fC = paramMotionEvent.getPointerId(0);
          this.iZ = false;
          continue;
          i = paramMotionEvent.findPointerIndex(this.fC);
          if (i < 0) {
            break;
          }
          f1 = paramMotionEvent.getY(i);
          I(f1);
          if (this.iZ)
          {
            f1 = (f1 - this.FI) * 0.5F;
            if (f1 <= 0.0F) {
              break;
            }
            G(f1);
            continue;
            i = paramMotionEvent.getActionIndex();
            if (i < 0) {
              break;
            }
            this.fC = paramMotionEvent.getPointerId(i);
            continue;
            d(paramMotionEvent);
          }
        }
      }
      i = paramMotionEvent.findPointerIndex(this.fC);
    } while (i < 0);
    if (this.iZ)
    {
      f1 = paramMotionEvent.getY(i);
      float f2 = this.FI;
      this.iZ = false;
      H((f1 - f2) * 0.5F);
    }
    this.fC = -1;
    return false;
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (((Build.VERSION.SDK_INT >= 21) || (!(this.Iy instanceof AbsListView))) && ((this.Iy == null) || (q.aj(this.Iy)))) {
      super.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  final void reset()
  {
    this.Mi.clearAnimation();
    this.Mn.stop();
    this.Mi.setVisibility(8);
    setColorViewAlpha(255);
    if (this.Mf) {
      setAnimationProgress(0.0F);
    }
    for (;;)
    {
      this.Md = this.Mi.getTop();
      return;
      setTargetOffsetTopAndBottom(this.Ml - this.Md);
    }
  }
  
  void setAnimationProgress(float paramFloat)
  {
    this.Mi.setScaleX(paramFloat);
    this.Mi.setScaleY(paramFloat);
  }
  
  @Deprecated
  public void setColorScheme(int... paramVarArgs)
  {
    setColorSchemeResources(paramVarArgs);
  }
  
  public void setColorSchemeColors(int... paramVarArgs)
  {
    dT();
    d locald = this.Mn;
    locald.Jg.setColors(paramVarArgs);
    locald.Jg.aG(0);
    locald.invalidateSelf();
  }
  
  public void setColorSchemeResources(int... paramVarArgs)
  {
    Context localContext = getContext();
    int[] arrayOfInt = new int[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      arrayOfInt[i] = b.i(localContext, paramVarArgs[i]);
      i += 1;
    }
    setColorSchemeColors(arrayOfInt);
  }
  
  public void setDistanceToTriggerSync(int paramInt)
  {
    this.LW = paramInt;
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
    this.LY.setNestedScrollingEnabled(paramBoolean);
  }
  
  public void setOnChildScrollUpCallback(SwipeRefreshLayout.a parama)
  {
    this.Mw = parama;
  }
  
  public void setOnRefreshListener(SwipeRefreshLayout.b paramb)
  {
    this.LU = paramb;
  }
  
  @Deprecated
  public void setProgressBackgroundColor(int paramInt)
  {
    setProgressBackgroundColorSchemeResource(paramInt);
  }
  
  public void setProgressBackgroundColorSchemeColor(int paramInt)
  {
    this.Mi.setBackgroundColor(paramInt);
  }
  
  public void setProgressBackgroundColorSchemeResource(int paramInt)
  {
    setProgressBackgroundColorSchemeColor(b.i(getContext(), paramInt));
  }
  
  public void setRefreshing(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.LV != paramBoolean))
    {
      this.LV = paramBoolean;
      if (!this.Mv) {}
      for (int i = this.Mm + this.Ml;; i = this.Mm)
      {
        setTargetOffsetTopAndBottom(i - this.Md);
        this.Mt = false;
        Animation.AnimationListener localAnimationListener = this.Mx;
        this.Mi.setVisibility(0);
        this.Mn.setAlpha(255);
        this.Mo = new SwipeRefreshLayout.2(this);
        this.Mo.setDuration(this.Mc);
        if (localAnimationListener != null) {
          this.Mi.IZ = localAnimationListener;
        }
        this.Mi.clearAnimation();
        this.Mi.startAnimation(this.Mo);
        return;
      }
    }
    e(paramBoolean, false);
  }
  
  public void setSize(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      return;
    }
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    if (paramInt == 0) {}
    for (this.Mu = ((int)(localDisplayMetrics.density * 56.0F));; this.Mu = ((int)(localDisplayMetrics.density * 40.0F)))
    {
      this.Mi.setImageDrawable(null);
      this.Mn.aF(paramInt);
      this.Mi.setImageDrawable(this.Mn);
      return;
    }
  }
  
  void setTargetOffsetTopAndBottom(int paramInt)
  {
    this.Mi.bringToFront();
    q.p(this.Mi, paramInt);
    this.Md = this.Mi.getTop();
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return this.LY.r(paramInt, 0);
  }
  
  public void stopNestedScroll()
  {
    this.LY.av(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v4.widget.SwipeRefreshLayout
 * JD-Core Version:    0.7.0.1
 */