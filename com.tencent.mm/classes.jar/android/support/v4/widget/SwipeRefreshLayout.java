package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.a;
import android.support.v4.content.b;
import android.support.v4.view.j;
import android.support.v4.view.l;
import android.support.v4.view.m;
import android.support.v4.view.o;
import android.support.v4.view.u;
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
  private View Sg;
  b VD;
  boolean VE = false;
  private float VF = -1.0F;
  private float VG;
  private final l VH;
  private final int[] VI = new int[2];
  private final int[] VJ = new int[2];
  private boolean VK;
  private int VL;
  int VM;
  private float VN;
  boolean VO;
  private boolean VP;
  private final DecelerateInterpolator VQ;
  c VR;
  private int VS = -1;
  float VT;
  protected int VU;
  int VV;
  int VW;
  d VX;
  private Animation VY;
  private Animation VZ;
  private Animation Wa;
  private Animation Wb;
  private Animation Wc;
  boolean Wd;
  private int We;
  boolean Wf;
  private a Wg;
  private Animation.AnimationListener Wh = new Animation.AnimationListener()
  {
    public final void onAnimationEnd(Animation paramAnonymousAnimation)
    {
      if (SwipeRefreshLayout.this.VE)
      {
        SwipeRefreshLayout.this.VX.setAlpha(255);
        SwipeRefreshLayout.this.VX.start();
        SwipeRefreshLayout.this.VM = SwipeRefreshLayout.this.VR.getTop();
        return;
      }
      SwipeRefreshLayout.this.reset();
    }
    
    public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
    
    public final void onAnimationStart(Animation paramAnonymousAnimation) {}
  };
  private final Animation Wi = new Animation()
  {
    public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
    {
      if (!SwipeRefreshLayout.this.Wf) {}
      for (int i = SwipeRefreshLayout.this.VV - Math.abs(SwipeRefreshLayout.this.VU);; i = SwipeRefreshLayout.this.VV)
      {
        int j = SwipeRefreshLayout.this.mFrom;
        i = (int)((i - SwipeRefreshLayout.this.mFrom) * paramAnonymousFloat);
        int k = SwipeRefreshLayout.this.VR.getTop();
        SwipeRefreshLayout.this.setTargetOffsetTopAndBottom(i + j - k);
        SwipeRefreshLayout.this.VX.C(1.0F - paramAnonymousFloat);
        return;
      }
    }
  };
  private final Animation Wj = new Animation()
  {
    public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
    {
      SwipeRefreshLayout.this.M(paramAnonymousFloat);
    }
  };
  private int mActivePointerId = -1;
  protected int mFrom;
  private float mInitialMotionY;
  private boolean mIsBeingDragged;
  private int mTouchSlop;
  private final o qA;
  
  public SwipeRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.VL = getResources().getInteger(17694721);
    setWillNotDraw(false);
    this.VQ = new DecelerateInterpolator(2.0F);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.We = ((int)(40.0F * localDisplayMetrics.density));
    this.VR = new c(getContext());
    this.VX = new d(getContext());
    this.VX.setStyle(1);
    this.VR.setImageDrawable(this.VX);
    this.VR.setVisibility(8);
    addView(this.VR);
    setChildrenDrawingOrderEnabled(true);
    this.VV = ((int)(localDisplayMetrics.density * 64.0F));
    this.VF = this.VV;
    this.qA = new o(this);
    this.VH = new l(this);
    setNestedScrollingEnabled(true);
    int i = -this.We;
    this.VM = i;
    this.VU = i;
    M(1.0F);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, LAYOUT_ATTRS);
    setEnabled(paramContext.getBoolean(0, true));
    paramContext.recycle();
  }
  
  private Animation G(final int paramInt1, final int paramInt2)
  {
    Animation local4 = new Animation()
    {
      public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        SwipeRefreshLayout.this.VX.setAlpha((int)(paramInt1 + (paramInt2 - paramInt1) * paramAnonymousFloat));
      }
    };
    local4.setDuration(300L);
    this.VR.SD = null;
    this.VR.clearAnimation();
    this.VR.startAnimation(local4);
    return local4;
  }
  
  private void J(float paramFloat)
  {
    this.VX.M(true);
    float f1 = Math.min(1.0F, Math.abs(paramFloat / this.VF));
    float f2 = Math.max((float)(f1 - 0.4D), 0.0F) * 5.0F / 3.0F;
    float f4 = Math.abs(paramFloat);
    float f5 = this.VF;
    int i;
    int j;
    if (this.VW > 0)
    {
      i = this.VW;
      float f3 = i;
      f4 = Math.max(0.0F, Math.min(f4 - f5, f3 * 2.0F) / f3);
      f4 = (float)(f4 / 4.0F - Math.pow(f4 / 4.0F, 2.0D)) * 2.0F;
      i = this.VU;
      j = (int)(f3 * f1 + f3 * f4 * 2.0F);
      if (this.VR.getVisibility() != 0) {
        this.VR.setVisibility(0);
      }
      if (!this.VO)
      {
        this.VR.setScaleX(1.0F);
        this.VR.setScaleY(1.0F);
      }
      if (this.VO) {
        setAnimationProgress(Math.min(1.0F, paramFloat / this.VF));
      }
      if (paramFloat >= this.VF) {
        break label337;
      }
      if ((this.VX.getAlpha() > 76) && (!a(this.Wa))) {
        gi();
      }
    }
    for (;;)
    {
      this.VX.D(Math.min(0.8F, f2 * 0.8F));
      this.VX.C(Math.min(1.0F, f2));
      this.VX.E((-0.25F + f2 * 0.4F + f4 * 2.0F) * 0.5F);
      setTargetOffsetTopAndBottom(j + i - this.VM);
      return;
      if (this.Wf)
      {
        i = this.VV - this.VU;
        break;
      }
      i = this.VV;
      break;
      label337:
      if ((this.VX.getAlpha() < 255) && (!a(this.Wb))) {
        gj();
      }
    }
  }
  
  private void K(float paramFloat)
  {
    if (paramFloat > this.VF)
    {
      f(true, true);
      return;
    }
    this.VE = false;
    this.VX.D(0.0F);
    Animation.AnimationListener local5 = null;
    if (!this.VO) {
      local5 = new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          if (!SwipeRefreshLayout.this.VO) {
            SwipeRefreshLayout.this.a(null);
          }
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      };
    }
    b(this.VM, local5);
    this.VX.M(false);
  }
  
  private void L(float paramFloat)
  {
    if ((paramFloat - this.VN > this.mTouchSlop) && (!this.mIsBeingDragged))
    {
      this.mInitialMotionY = (this.VN + this.mTouchSlop);
      this.mIsBeingDragged = true;
      this.VX.setAlpha(76);
    }
  }
  
  private void a(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    this.mFrom = paramInt;
    this.Wi.reset();
    this.Wi.setDuration(200L);
    this.Wi.setInterpolator(this.VQ);
    if (paramAnimationListener != null) {
      this.VR.SD = paramAnimationListener;
    }
    this.VR.clearAnimation();
    this.VR.startAnimation(this.Wi);
  }
  
  private static boolean a(Animation paramAnimation)
  {
    return (paramAnimation != null) && (paramAnimation.hasStarted()) && (!paramAnimation.hasEnded());
  }
  
  private void b(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    if (this.VO)
    {
      c(paramInt, paramAnimationListener);
      return;
    }
    this.mFrom = paramInt;
    this.Wj.reset();
    this.Wj.setDuration(200L);
    this.Wj.setInterpolator(this.VQ);
    if (paramAnimationListener != null) {
      this.VR.SD = paramAnimationListener;
    }
    this.VR.clearAnimation();
    this.VR.startAnimation(this.Wj);
  }
  
  private void c(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    this.mFrom = paramInt;
    this.VT = this.VR.getScaleX();
    this.Wc = new Animation()
    {
      public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        float f1 = SwipeRefreshLayout.this.VT;
        float f2 = -SwipeRefreshLayout.this.VT;
        SwipeRefreshLayout.this.setAnimationProgress(f1 + f2 * paramAnonymousFloat);
        SwipeRefreshLayout.this.M(paramAnonymousFloat);
      }
    };
    this.Wc.setDuration(150L);
    if (paramAnimationListener != null) {
      this.VR.SD = paramAnimationListener;
    }
    this.VR.clearAnimation();
    this.VR.startAnimation(this.Wc);
  }
  
  private void f(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.VE != paramBoolean1)
    {
      this.Wd = paramBoolean2;
      gk();
      this.VE = paramBoolean1;
      if (this.VE) {
        a(this.VM, this.Wh);
      }
    }
    else
    {
      return;
    }
    a(this.Wh);
  }
  
  private void gi()
  {
    this.Wa = G(this.VX.getAlpha(), 76);
  }
  
  private void gj()
  {
    this.Wb = G(this.VX.getAlpha(), 255);
  }
  
  private void gk()
  {
    int i;
    if (this.Sg == null) {
      i = 0;
    }
    for (;;)
    {
      if (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (!localView.equals(this.VR)) {
          this.Sg = localView;
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  private boolean gl()
  {
    if (this.Wg != null) {
      return this.Wg.gm();
    }
    if ((this.Sg instanceof ListView))
    {
      ListView localListView = (ListView)this.Sg;
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
    return this.Sg.canScrollVertically(-1);
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
    this.VR.getBackground().setAlpha(paramInt);
    this.VX.setAlpha(paramInt);
  }
  
  final void M(float paramFloat)
  {
    setTargetOffsetTopAndBottom(this.mFrom + (int)((this.VU - this.mFrom) * paramFloat) - this.VR.getTop());
  }
  
  final void a(Animation.AnimationListener paramAnimationListener)
  {
    this.VZ = new Animation()
    {
      public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        SwipeRefreshLayout.this.setAnimationProgress(1.0F - paramAnonymousFloat);
      }
    };
    this.VZ.setDuration(150L);
    this.VR.SD = paramAnimationListener;
    this.VR.clearAnimation();
    this.VR.startAnimation(this.VZ);
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return this.VH.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return this.VH.dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return this.VH.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return this.VH.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (this.VS < 0) {}
    do
    {
      return paramInt2;
      if (paramInt2 == paramInt1 - 1) {
        return this.VS;
      }
    } while (paramInt2 < this.VS);
    return paramInt2 + 1;
  }
  
  public int getNestedScrollAxes()
  {
    return this.qA.Qb;
  }
  
  public int getProgressCircleDiameter()
  {
    return this.We;
  }
  
  public int getProgressViewEndOffset()
  {
    return this.VV;
  }
  
  public int getProgressViewStartOffset()
  {
    return this.VU;
  }
  
  public boolean hasNestedScrollingParent()
  {
    return this.VH.aN(0);
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return this.VH.PY;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    reset();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    gk();
    int i = paramMotionEvent.getActionMasked();
    if ((this.VP) && (i == 0)) {
      this.VP = false;
    }
    if ((!isEnabled()) || (this.VP) || (gl()) || (this.VE) || (this.VK)) {
      return false;
    }
    switch (i)
    {
    }
    for (;;)
    {
      return this.mIsBeingDragged;
      setTargetOffsetTopAndBottom(this.VU - this.VR.getTop());
      this.mActivePointerId = paramMotionEvent.getPointerId(0);
      this.mIsBeingDragged = false;
      i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      if (i < 0) {
        break;
      }
      this.VN = paramMotionEvent.getY(i);
      continue;
      if (this.mActivePointerId == -1) {
        break;
      }
      i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      if (i < 0) {
        break;
      }
      L(paramMotionEvent.getY(i));
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
      if (this.Sg == null) {
        gk();
      }
    } while (this.Sg == null);
    View localView = this.Sg;
    paramInt3 = getPaddingLeft();
    paramInt4 = getPaddingTop();
    localView.layout(paramInt3, paramInt4, paramInt1 - getPaddingLeft() - getPaddingRight() + paramInt3, paramInt2 - getPaddingTop() - getPaddingBottom() + paramInt4);
    paramInt2 = this.VR.getMeasuredWidth();
    paramInt3 = this.VR.getMeasuredHeight();
    this.VR.layout(paramInt1 / 2 - paramInt2 / 2, this.VM, paramInt1 / 2 + paramInt2 / 2, this.VM + paramInt3);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.Sg == null) {
      gk();
    }
    if (this.Sg == null) {}
    for (;;)
    {
      return;
      this.Sg.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), 1073741824));
      this.VR.measure(View.MeasureSpec.makeMeasureSpec(this.We, 1073741824), View.MeasureSpec.makeMeasureSpec(this.We, 1073741824));
      this.VS = -1;
      paramInt1 = 0;
      while (paramInt1 < getChildCount())
      {
        if (getChildAt(paramInt1) == this.VR)
        {
          this.VS = paramInt1;
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
    if ((paramInt2 > 0) && (this.VG > 0.0F))
    {
      if (paramInt2 <= this.VG) {
        break label141;
      }
      paramArrayOfInt[1] = (paramInt2 - (int)this.VG);
      this.VG = 0.0F;
    }
    for (;;)
    {
      J(this.VG);
      if ((this.Wf) && (paramInt2 > 0) && (this.VG == 0.0F) && (Math.abs(paramInt2 - paramArrayOfInt[1]) > 0)) {
        this.VR.setVisibility(8);
      }
      paramView = this.VI;
      if (dispatchNestedPreScroll(paramInt1 - paramArrayOfInt[0], paramInt2 - paramArrayOfInt[1], paramView, null))
      {
        paramArrayOfInt[0] += paramView[0];
        paramInt1 = paramArrayOfInt[1];
        paramView[1] += paramInt1;
      }
      return;
      label141:
      this.VG -= paramInt2;
      paramArrayOfInt[1] = paramInt2;
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.VJ);
    paramInt1 = this.VJ[1] + paramInt4;
    if ((paramInt1 < 0) && (!gl()))
    {
      float f = this.VG;
      this.VG = (Math.abs(paramInt1) + f);
      J(this.VG);
    }
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    this.qA.Qb = paramInt;
    startNestedScroll(paramInt & 0x2);
    this.VG = 0.0F;
    this.VK = true;
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return (isEnabled()) && (!this.VP) && (!this.VE) && ((paramInt & 0x2) != 0);
  }
  
  public void onStopNestedScroll(View paramView)
  {
    this.qA.Qb = 0;
    this.VK = false;
    if (this.VG > 0.0F)
    {
      K(this.VG);
      this.VG = 0.0F;
    }
    stopNestedScroll();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if ((this.VP) && (i == 0)) {
      this.VP = false;
    }
    if ((!isEnabled()) || (this.VP) || (gl()) || (this.VE) || (this.VK)) {}
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
          L(f1);
          if (this.mIsBeingDragged)
          {
            f1 = (f1 - this.mInitialMotionY) * 0.5F;
            if (f1 <= 0.0F) {
              break;
            }
            J(f1);
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
      K((f1 - f2) * 0.5F);
    }
    this.mActivePointerId = -1;
    return false;
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (((Build.VERSION.SDK_INT >= 21) || (!(this.Sg instanceof AbsListView))) && ((this.Sg == null) || (u.aw(this.Sg)))) {
      super.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  final void reset()
  {
    this.VR.clearAnimation();
    this.VX.stop();
    this.VR.setVisibility(8);
    setColorViewAlpha(255);
    if (this.VO) {
      setAnimationProgress(0.0F);
    }
    for (;;)
    {
      this.VM = this.VR.getTop();
      return;
      setTargetOffsetTopAndBottom(this.VU - this.VM);
    }
  }
  
  void setAnimationProgress(float paramFloat)
  {
    this.VR.setScaleX(paramFloat);
    this.VR.setScaleY(paramFloat);
  }
  
  @Deprecated
  public void setColorScheme(@a int... paramVarArgs)
  {
    setColorSchemeResources(paramVarArgs);
  }
  
  public void setColorSchemeColors(int... paramVarArgs)
  {
    gk();
    d locald = this.VX;
    locald.SL.setColors(paramVarArgs);
    locald.SL.aV(0);
    locald.invalidateSelf();
  }
  
  public void setColorSchemeResources(@a int... paramVarArgs)
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
    this.VF = paramInt;
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
    this.VH.setNestedScrollingEnabled(paramBoolean);
  }
  
  public void setOnChildScrollUpCallback(a parama)
  {
    this.Wg = parama;
  }
  
  public void setOnRefreshListener(b paramb)
  {
    this.VD = paramb;
  }
  
  @Deprecated
  public void setProgressBackgroundColor(int paramInt)
  {
    setProgressBackgroundColorSchemeResource(paramInt);
  }
  
  public void setProgressBackgroundColorSchemeColor(int paramInt)
  {
    this.VR.setBackgroundColor(paramInt);
  }
  
  public void setProgressBackgroundColorSchemeResource(@a int paramInt)
  {
    setProgressBackgroundColorSchemeColor(b.n(getContext(), paramInt));
  }
  
  public void setRefreshing(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.VE != paramBoolean))
    {
      this.VE = paramBoolean;
      if (!this.Wf) {}
      for (int i = this.VV + this.VU;; i = this.VV)
      {
        setTargetOffsetTopAndBottom(i - this.VM);
        this.Wd = false;
        Animation.AnimationListener localAnimationListener = this.Wh;
        this.VR.setVisibility(0);
        this.VX.setAlpha(255);
        this.VY = new Animation()
        {
          public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
          {
            SwipeRefreshLayout.this.setAnimationProgress(paramAnonymousFloat);
          }
        };
        this.VY.setDuration(this.VL);
        if (localAnimationListener != null) {
          this.VR.SD = localAnimationListener;
        }
        this.VR.clearAnimation();
        this.VR.startAnimation(this.VY);
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
    for (this.We = ((int)(localDisplayMetrics.density * 56.0F));; this.We = ((int)(localDisplayMetrics.density * 40.0F)))
    {
      this.VR.setImageDrawable(null);
      this.VX.setStyle(paramInt);
      this.VR.setImageDrawable(this.VX);
      return;
    }
  }
  
  public void setSlingshotDistance(int paramInt)
  {
    this.VW = paramInt;
  }
  
  void setTargetOffsetTopAndBottom(int paramInt)
  {
    this.VR.bringToFront();
    u.s(this.VR, paramInt);
    this.VM = this.VR.getTop();
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return this.VH.A(paramInt, 0);
  }
  
  public void stopNestedScroll()
  {
    this.VH.aM(0);
  }
  
  public static abstract interface a
  {
    public abstract boolean gm();
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.widget.SwipeRefreshLayout
 * JD-Core Version:    0.7.0.1
 */