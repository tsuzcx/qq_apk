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
  private View RT;
  private float VA;
  boolean VB;
  private boolean VC;
  private final DecelerateInterpolator VD;
  c VE;
  private int VF = -1;
  float VG;
  protected int VH;
  int VI;
  int VJ;
  d VK;
  private Animation VL;
  private Animation VM;
  private Animation VN;
  private Animation VO;
  private Animation VP;
  boolean VQ;
  private int VR;
  boolean VS;
  private a VT;
  private Animation.AnimationListener VU = new Animation.AnimationListener()
  {
    public final void onAnimationEnd(Animation paramAnonymousAnimation)
    {
      if (SwipeRefreshLayout.this.Vr)
      {
        SwipeRefreshLayout.this.VK.setAlpha(255);
        SwipeRefreshLayout.this.VK.start();
        SwipeRefreshLayout.this.Vz = SwipeRefreshLayout.this.VE.getTop();
        return;
      }
      SwipeRefreshLayout.this.reset();
    }
    
    public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
    
    public final void onAnimationStart(Animation paramAnonymousAnimation) {}
  };
  private final Animation VV = new Animation()
  {
    public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
    {
      if (!SwipeRefreshLayout.this.VS) {}
      for (int i = SwipeRefreshLayout.this.VI - Math.abs(SwipeRefreshLayout.this.VH);; i = SwipeRefreshLayout.this.VI)
      {
        int j = SwipeRefreshLayout.this.mFrom;
        i = (int)((i - SwipeRefreshLayout.this.mFrom) * paramAnonymousFloat);
        int k = SwipeRefreshLayout.this.VE.getTop();
        SwipeRefreshLayout.this.setTargetOffsetTopAndBottom(i + j - k);
        SwipeRefreshLayout.this.VK.C(1.0F - paramAnonymousFloat);
        return;
      }
    }
  };
  private final Animation VW = new Animation()
  {
    public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
    {
      SwipeRefreshLayout.this.M(paramAnonymousFloat);
    }
  };
  b Vq;
  boolean Vr = false;
  private float Vs = -1.0F;
  private float Vt;
  private final l Vu;
  private final int[] Vv = new int[2];
  private final int[] Vw = new int[2];
  private boolean Vx;
  private int Vy;
  int Vz;
  private int mActivePointerId = -1;
  protected int mFrom;
  private float mInitialMotionY;
  private boolean mIsBeingDragged;
  private int mTouchSlop;
  private final o qy;
  
  public SwipeRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.Vy = getResources().getInteger(17694721);
    setWillNotDraw(false);
    this.VD = new DecelerateInterpolator(2.0F);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.VR = ((int)(40.0F * localDisplayMetrics.density));
    this.VE = new c(getContext());
    this.VK = new d(getContext());
    this.VK.setStyle(1);
    this.VE.setImageDrawable(this.VK);
    this.VE.setVisibility(8);
    addView(this.VE);
    setChildrenDrawingOrderEnabled(true);
    this.VI = ((int)(localDisplayMetrics.density * 64.0F));
    this.Vs = this.VI;
    this.qy = new o(this);
    this.Vu = new l(this);
    setNestedScrollingEnabled(true);
    int i = -this.VR;
    this.Vz = i;
    this.VH = i;
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
        SwipeRefreshLayout.this.VK.setAlpha((int)(paramInt1 + (paramInt2 - paramInt1) * paramAnonymousFloat));
      }
    };
    local4.setDuration(300L);
    this.VE.Sq = null;
    this.VE.clearAnimation();
    this.VE.startAnimation(local4);
    return local4;
  }
  
  private void J(float paramFloat)
  {
    this.VK.N(true);
    float f1 = Math.min(1.0F, Math.abs(paramFloat / this.Vs));
    float f2 = Math.max((float)(f1 - 0.4D), 0.0F) * 5.0F / 3.0F;
    float f4 = Math.abs(paramFloat);
    float f5 = this.Vs;
    int i;
    int j;
    if (this.VJ > 0)
    {
      i = this.VJ;
      float f3 = i;
      f4 = Math.max(0.0F, Math.min(f4 - f5, f3 * 2.0F) / f3);
      f4 = (float)(f4 / 4.0F - Math.pow(f4 / 4.0F, 2.0D)) * 2.0F;
      i = this.VH;
      j = (int)(f3 * f1 + f3 * f4 * 2.0F);
      if (this.VE.getVisibility() != 0) {
        this.VE.setVisibility(0);
      }
      if (!this.VB)
      {
        this.VE.setScaleX(1.0F);
        this.VE.setScaleY(1.0F);
      }
      if (this.VB) {
        setAnimationProgress(Math.min(1.0F, paramFloat / this.Vs));
      }
      if (paramFloat >= this.Vs) {
        break label337;
      }
      if ((this.VK.getAlpha() > 76) && (!a(this.VN))) {
        ga();
      }
    }
    for (;;)
    {
      this.VK.D(Math.min(0.8F, f2 * 0.8F));
      this.VK.C(Math.min(1.0F, f2));
      this.VK.E((-0.25F + f2 * 0.4F + f4 * 2.0F) * 0.5F);
      setTargetOffsetTopAndBottom(j + i - this.Vz);
      return;
      if (this.VS)
      {
        i = this.VI - this.VH;
        break;
      }
      i = this.VI;
      break;
      label337:
      if ((this.VK.getAlpha() < 255) && (!a(this.VO))) {
        gb();
      }
    }
  }
  
  private void K(float paramFloat)
  {
    if (paramFloat > this.Vs)
    {
      f(true, true);
      return;
    }
    this.Vr = false;
    this.VK.D(0.0F);
    Animation.AnimationListener local5 = null;
    if (!this.VB) {
      local5 = new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          if (!SwipeRefreshLayout.this.VB) {
            SwipeRefreshLayout.this.a(null);
          }
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      };
    }
    b(this.Vz, local5);
    this.VK.N(false);
  }
  
  private void L(float paramFloat)
  {
    if ((paramFloat - this.VA > this.mTouchSlop) && (!this.mIsBeingDragged))
    {
      this.mInitialMotionY = (this.VA + this.mTouchSlop);
      this.mIsBeingDragged = true;
      this.VK.setAlpha(76);
    }
  }
  
  private void a(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    this.mFrom = paramInt;
    this.VV.reset();
    this.VV.setDuration(200L);
    this.VV.setInterpolator(this.VD);
    if (paramAnimationListener != null) {
      this.VE.Sq = paramAnimationListener;
    }
    this.VE.clearAnimation();
    this.VE.startAnimation(this.VV);
  }
  
  private static boolean a(Animation paramAnimation)
  {
    return (paramAnimation != null) && (paramAnimation.hasStarted()) && (!paramAnimation.hasEnded());
  }
  
  private void b(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    if (this.VB)
    {
      c(paramInt, paramAnimationListener);
      return;
    }
    this.mFrom = paramInt;
    this.VW.reset();
    this.VW.setDuration(200L);
    this.VW.setInterpolator(this.VD);
    if (paramAnimationListener != null) {
      this.VE.Sq = paramAnimationListener;
    }
    this.VE.clearAnimation();
    this.VE.startAnimation(this.VW);
  }
  
  private void c(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    this.mFrom = paramInt;
    this.VG = this.VE.getScaleX();
    this.VP = new Animation()
    {
      public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        float f1 = SwipeRefreshLayout.this.VG;
        float f2 = -SwipeRefreshLayout.this.VG;
        SwipeRefreshLayout.this.setAnimationProgress(f1 + f2 * paramAnonymousFloat);
        SwipeRefreshLayout.this.M(paramAnonymousFloat);
      }
    };
    this.VP.setDuration(150L);
    if (paramAnimationListener != null) {
      this.VE.Sq = paramAnimationListener;
    }
    this.VE.clearAnimation();
    this.VE.startAnimation(this.VP);
  }
  
  private void f(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.Vr != paramBoolean1)
    {
      this.VQ = paramBoolean2;
      gd();
      this.Vr = paramBoolean1;
      if (this.Vr) {
        a(this.Vz, this.VU);
      }
    }
    else
    {
      return;
    }
    a(this.VU);
  }
  
  private void ga()
  {
    this.VN = G(this.VK.getAlpha(), 76);
  }
  
  private void gb()
  {
    this.VO = G(this.VK.getAlpha(), 255);
  }
  
  private void gd()
  {
    int i;
    if (this.RT == null) {
      i = 0;
    }
    for (;;)
    {
      if (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (!localView.equals(this.VE)) {
          this.RT = localView;
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  private boolean ge()
  {
    if (this.VT != null) {
      return this.VT.gf();
    }
    if ((this.RT instanceof ListView))
    {
      ListView localListView = (ListView)this.RT;
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
    return this.RT.canScrollVertically(-1);
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
    this.VE.getBackground().setAlpha(paramInt);
    this.VK.setAlpha(paramInt);
  }
  
  final void M(float paramFloat)
  {
    setTargetOffsetTopAndBottom(this.mFrom + (int)((this.VH - this.mFrom) * paramFloat) - this.VE.getTop());
  }
  
  final void a(Animation.AnimationListener paramAnimationListener)
  {
    this.VM = new Animation()
    {
      public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        SwipeRefreshLayout.this.setAnimationProgress(1.0F - paramAnonymousFloat);
      }
    };
    this.VM.setDuration(150L);
    this.VE.Sq = paramAnimationListener;
    this.VE.clearAnimation();
    this.VE.startAnimation(this.VM);
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return this.Vu.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return this.Vu.dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return this.Vu.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return this.Vu.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (this.VF < 0) {}
    do
    {
      return paramInt2;
      if (paramInt2 == paramInt1 - 1) {
        return this.VF;
      }
    } while (paramInt2 < this.VF);
    return paramInt2 + 1;
  }
  
  public int getNestedScrollAxes()
  {
    return this.qy.PP;
  }
  
  public int getProgressCircleDiameter()
  {
    return this.VR;
  }
  
  public int getProgressViewEndOffset()
  {
    return this.VI;
  }
  
  public int getProgressViewStartOffset()
  {
    return this.VH;
  }
  
  public boolean hasNestedScrollingParent()
  {
    return this.Vu.aN(0);
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return this.Vu.PM;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    reset();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    gd();
    int i = paramMotionEvent.getActionMasked();
    if ((this.VC) && (i == 0)) {
      this.VC = false;
    }
    if ((!isEnabled()) || (this.VC) || (ge()) || (this.Vr) || (this.Vx)) {
      return false;
    }
    switch (i)
    {
    }
    for (;;)
    {
      return this.mIsBeingDragged;
      setTargetOffsetTopAndBottom(this.VH - this.VE.getTop());
      this.mActivePointerId = paramMotionEvent.getPointerId(0);
      this.mIsBeingDragged = false;
      i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      if (i < 0) {
        break;
      }
      this.VA = paramMotionEvent.getY(i);
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
      if (this.RT == null) {
        gd();
      }
    } while (this.RT == null);
    View localView = this.RT;
    paramInt3 = getPaddingLeft();
    paramInt4 = getPaddingTop();
    localView.layout(paramInt3, paramInt4, paramInt1 - getPaddingLeft() - getPaddingRight() + paramInt3, paramInt2 - getPaddingTop() - getPaddingBottom() + paramInt4);
    paramInt2 = this.VE.getMeasuredWidth();
    paramInt3 = this.VE.getMeasuredHeight();
    this.VE.layout(paramInt1 / 2 - paramInt2 / 2, this.Vz, paramInt1 / 2 + paramInt2 / 2, this.Vz + paramInt3);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.RT == null) {
      gd();
    }
    if (this.RT == null) {}
    for (;;)
    {
      return;
      this.RT.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), 1073741824));
      this.VE.measure(View.MeasureSpec.makeMeasureSpec(this.VR, 1073741824), View.MeasureSpec.makeMeasureSpec(this.VR, 1073741824));
      this.VF = -1;
      paramInt1 = 0;
      while (paramInt1 < getChildCount())
      {
        if (getChildAt(paramInt1) == this.VE)
        {
          this.VF = paramInt1;
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
    if ((paramInt2 > 0) && (this.Vt > 0.0F))
    {
      if (paramInt2 <= this.Vt) {
        break label141;
      }
      paramArrayOfInt[1] = (paramInt2 - (int)this.Vt);
      this.Vt = 0.0F;
    }
    for (;;)
    {
      J(this.Vt);
      if ((this.VS) && (paramInt2 > 0) && (this.Vt == 0.0F) && (Math.abs(paramInt2 - paramArrayOfInt[1]) > 0)) {
        this.VE.setVisibility(8);
      }
      paramView = this.Vv;
      if (dispatchNestedPreScroll(paramInt1 - paramArrayOfInt[0], paramInt2 - paramArrayOfInt[1], paramView, null))
      {
        paramArrayOfInt[0] += paramView[0];
        paramInt1 = paramArrayOfInt[1];
        paramView[1] += paramInt1;
      }
      return;
      label141:
      this.Vt -= paramInt2;
      paramArrayOfInt[1] = paramInt2;
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.Vw);
    paramInt1 = this.Vw[1] + paramInt4;
    if ((paramInt1 < 0) && (!ge()))
    {
      float f = this.Vt;
      this.Vt = (Math.abs(paramInt1) + f);
      J(this.Vt);
    }
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    this.qy.PP = paramInt;
    startNestedScroll(paramInt & 0x2);
    this.Vt = 0.0F;
    this.Vx = true;
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return (isEnabled()) && (!this.VC) && (!this.Vr) && ((paramInt & 0x2) != 0);
  }
  
  public void onStopNestedScroll(View paramView)
  {
    this.qy.PP = 0;
    this.Vx = false;
    if (this.Vt > 0.0F)
    {
      K(this.Vt);
      this.Vt = 0.0F;
    }
    stopNestedScroll();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if ((this.VC) && (i == 0)) {
      this.VC = false;
    }
    if ((!isEnabled()) || (this.VC) || (ge()) || (this.Vr) || (this.Vx)) {}
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
    if (((Build.VERSION.SDK_INT >= 21) || (!(this.RT instanceof AbsListView))) && ((this.RT == null) || (t.av(this.RT)))) {
      super.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  final void reset()
  {
    this.VE.clearAnimation();
    this.VK.stop();
    this.VE.setVisibility(8);
    setColorViewAlpha(255);
    if (this.VB) {
      setAnimationProgress(0.0F);
    }
    for (;;)
    {
      this.Vz = this.VE.getTop();
      return;
      setTargetOffsetTopAndBottom(this.VH - this.Vz);
    }
  }
  
  void setAnimationProgress(float paramFloat)
  {
    this.VE.setScaleX(paramFloat);
    this.VE.setScaleY(paramFloat);
  }
  
  @Deprecated
  public void setColorScheme(int... paramVarArgs)
  {
    setColorSchemeResources(paramVarArgs);
  }
  
  public void setColorSchemeColors(int... paramVarArgs)
  {
    gd();
    d locald = this.VK;
    locald.Sy.setColors(paramVarArgs);
    locald.Sy.aU(0);
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
    this.Vs = paramInt;
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
    this.Vu.setNestedScrollingEnabled(paramBoolean);
  }
  
  public void setOnChildScrollUpCallback(a parama)
  {
    this.VT = parama;
  }
  
  public void setOnRefreshListener(b paramb)
  {
    this.Vq = paramb;
  }
  
  @Deprecated
  public void setProgressBackgroundColor(int paramInt)
  {
    setProgressBackgroundColorSchemeResource(paramInt);
  }
  
  public void setProgressBackgroundColorSchemeColor(int paramInt)
  {
    this.VE.setBackgroundColor(paramInt);
  }
  
  public void setProgressBackgroundColorSchemeResource(int paramInt)
  {
    setProgressBackgroundColorSchemeColor(b.n(getContext(), paramInt));
  }
  
  public void setRefreshing(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.Vr != paramBoolean))
    {
      this.Vr = paramBoolean;
      if (!this.VS) {}
      for (int i = this.VI + this.VH;; i = this.VI)
      {
        setTargetOffsetTopAndBottom(i - this.Vz);
        this.VQ = false;
        Animation.AnimationListener localAnimationListener = this.VU;
        this.VE.setVisibility(0);
        this.VK.setAlpha(255);
        this.VL = new Animation()
        {
          public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
          {
            SwipeRefreshLayout.this.setAnimationProgress(paramAnonymousFloat);
          }
        };
        this.VL.setDuration(this.Vy);
        if (localAnimationListener != null) {
          this.VE.Sq = localAnimationListener;
        }
        this.VE.clearAnimation();
        this.VE.startAnimation(this.VL);
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
    for (this.VR = ((int)(localDisplayMetrics.density * 56.0F));; this.VR = ((int)(localDisplayMetrics.density * 40.0F)))
    {
      this.VE.setImageDrawable(null);
      this.VK.setStyle(paramInt);
      this.VE.setImageDrawable(this.VK);
      return;
    }
  }
  
  public void setSlingshotDistance(int paramInt)
  {
    this.VJ = paramInt;
  }
  
  void setTargetOffsetTopAndBottom(int paramInt)
  {
    this.VE.bringToFront();
    t.s(this.VE, paramInt);
    this.Vz = this.VE.getTop();
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return this.Vu.A(paramInt, 0);
  }
  
  public void stopNestedScroll()
  {
    this.Vu.aM(0);
  }
  
  public static abstract interface a
  {
    public abstract boolean gf();
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.widget.SwipeRefreshLayout
 * JD-Core Version:    0.7.0.1
 */