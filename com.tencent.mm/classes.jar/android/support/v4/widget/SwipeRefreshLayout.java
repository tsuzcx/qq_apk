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
  private View Qe;
  b TA;
  boolean TB = false;
  private float TC = -1.0F;
  private float TD;
  private final l TE;
  private final int[] TF = new int[2];
  private final int[] TG = new int[2];
  private boolean TH;
  private int TI;
  int TJ;
  private float TK;
  boolean TL;
  private boolean TM;
  private final DecelerateInterpolator TN;
  c TO;
  private int TP = -1;
  float TQ;
  protected int TR;
  int TS;
  int TT;
  d TU;
  private Animation TV;
  private Animation TW;
  private Animation TX;
  private Animation TY;
  private Animation TZ;
  boolean Ua;
  private int Ub;
  boolean Uc;
  private a Ud;
  private Animation.AnimationListener Ue = new Animation.AnimationListener()
  {
    public final void onAnimationEnd(Animation paramAnonymousAnimation)
    {
      if (SwipeRefreshLayout.this.TB)
      {
        SwipeRefreshLayout.this.TU.setAlpha(255);
        SwipeRefreshLayout.this.TU.start();
        SwipeRefreshLayout.this.TJ = SwipeRefreshLayout.this.TO.getTop();
        return;
      }
      SwipeRefreshLayout.this.reset();
    }
    
    public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
    
    public final void onAnimationStart(Animation paramAnonymousAnimation) {}
  };
  private final Animation Uf = new Animation()
  {
    public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
    {
      if (!SwipeRefreshLayout.this.Uc) {}
      for (int i = SwipeRefreshLayout.this.TS - Math.abs(SwipeRefreshLayout.this.TR);; i = SwipeRefreshLayout.this.TS)
      {
        int j = SwipeRefreshLayout.this.mFrom;
        i = (int)((i - SwipeRefreshLayout.this.mFrom) * paramAnonymousFloat);
        int k = SwipeRefreshLayout.this.TO.getTop();
        SwipeRefreshLayout.this.setTargetOffsetTopAndBottom(i + j - k);
        SwipeRefreshLayout.this.TU.E(1.0F - paramAnonymousFloat);
        return;
      }
    }
  };
  private final Animation Ug = new Animation()
  {
    public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
    {
      SwipeRefreshLayout.this.O(paramAnonymousFloat);
    }
  };
  private int mActivePointerId = -1;
  protected int mFrom;
  private float mInitialMotionY;
  private boolean mIsBeingDragged;
  private int mTouchSlop;
  private final o oF;
  
  public SwipeRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.TI = getResources().getInteger(17694721);
    setWillNotDraw(false);
    this.TN = new DecelerateInterpolator(2.0F);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.Ub = ((int)(40.0F * localDisplayMetrics.density));
    this.TO = new c(getContext());
    this.TU = new d(getContext());
    this.TU.setStyle(1);
    this.TO.setImageDrawable(this.TU);
    this.TO.setVisibility(8);
    addView(this.TO);
    setChildrenDrawingOrderEnabled(true);
    this.TS = ((int)(localDisplayMetrics.density * 64.0F));
    this.TC = this.TS;
    this.oF = new o(this);
    this.TE = new l(this);
    setNestedScrollingEnabled(true);
    int i = -this.Ub;
    this.TJ = i;
    this.TR = i;
    O(1.0F);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, LAYOUT_ATTRS);
    setEnabled(paramContext.getBoolean(0, true));
    paramContext.recycle();
  }
  
  private void L(float paramFloat)
  {
    this.TU.N(true);
    float f1 = Math.min(1.0F, Math.abs(paramFloat / this.TC));
    float f2 = Math.max((float)(f1 - 0.4D), 0.0F) * 5.0F / 3.0F;
    float f4 = Math.abs(paramFloat);
    float f5 = this.TC;
    int i;
    int j;
    if (this.TT > 0)
    {
      i = this.TT;
      float f3 = i;
      f4 = Math.max(0.0F, Math.min(f4 - f5, f3 * 2.0F) / f3);
      f4 = (float)(f4 / 4.0F - Math.pow(f4 / 4.0F, 2.0D)) * 2.0F;
      i = this.TR;
      j = (int)(f3 * f1 + f3 * f4 * 2.0F);
      if (this.TO.getVisibility() != 0) {
        this.TO.setVisibility(0);
      }
      if (!this.TL)
      {
        this.TO.setScaleX(1.0F);
        this.TO.setScaleY(1.0F);
      }
      if (this.TL) {
        setAnimationProgress(Math.min(1.0F, paramFloat / this.TC));
      }
      if (paramFloat >= this.TC) {
        break label337;
      }
      if ((this.TU.getAlpha() > 76) && (!a(this.TX))) {
        fJ();
      }
    }
    for (;;)
    {
      this.TU.F(Math.min(0.8F, f2 * 0.8F));
      this.TU.E(Math.min(1.0F, f2));
      this.TU.G((-0.25F + f2 * 0.4F + f4 * 2.0F) * 0.5F);
      setTargetOffsetTopAndBottom(j + i - this.TJ);
      return;
      if (this.Uc)
      {
        i = this.TS - this.TR;
        break;
      }
      i = this.TS;
      break;
      label337:
      if ((this.TU.getAlpha() < 255) && (!a(this.TY))) {
        fK();
      }
    }
  }
  
  private void M(float paramFloat)
  {
    if (paramFloat > this.TC)
    {
      f(true, true);
      return;
    }
    this.TB = false;
    this.TU.F(0.0F);
    Animation.AnimationListener local5 = null;
    if (!this.TL) {
      local5 = new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          if (!SwipeRefreshLayout.this.TL) {
            SwipeRefreshLayout.this.a(null);
          }
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      };
    }
    b(this.TJ, local5);
    this.TU.N(false);
  }
  
  private void N(float paramFloat)
  {
    if ((paramFloat - this.TK > this.mTouchSlop) && (!this.mIsBeingDragged))
    {
      this.mInitialMotionY = (this.TK + this.mTouchSlop);
      this.mIsBeingDragged = true;
      this.TU.setAlpha(76);
    }
  }
  
  private void a(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    this.mFrom = paramInt;
    this.Uf.reset();
    this.Uf.setDuration(200L);
    this.Uf.setInterpolator(this.TN);
    if (paramAnimationListener != null) {
      this.TO.QB = paramAnimationListener;
    }
    this.TO.clearAnimation();
    this.TO.startAnimation(this.Uf);
  }
  
  private static boolean a(Animation paramAnimation)
  {
    return (paramAnimation != null) && (paramAnimation.hasStarted()) && (!paramAnimation.hasEnded());
  }
  
  private void b(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    if (this.TL)
    {
      c(paramInt, paramAnimationListener);
      return;
    }
    this.mFrom = paramInt;
    this.Ug.reset();
    this.Ug.setDuration(200L);
    this.Ug.setInterpolator(this.TN);
    if (paramAnimationListener != null) {
      this.TO.QB = paramAnimationListener;
    }
    this.TO.clearAnimation();
    this.TO.startAnimation(this.Ug);
  }
  
  private void c(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    this.mFrom = paramInt;
    this.TQ = this.TO.getScaleX();
    this.TZ = new Animation()
    {
      public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        float f1 = SwipeRefreshLayout.this.TQ;
        float f2 = -SwipeRefreshLayout.this.TQ;
        SwipeRefreshLayout.this.setAnimationProgress(f1 + f2 * paramAnonymousFloat);
        SwipeRefreshLayout.this.O(paramAnonymousFloat);
      }
    };
    this.TZ.setDuration(150L);
    if (paramAnimationListener != null) {
      this.TO.QB = paramAnimationListener;
    }
    this.TO.clearAnimation();
    this.TO.startAnimation(this.TZ);
  }
  
  private void f(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.TB != paramBoolean1)
    {
      this.Ua = paramBoolean2;
      fL();
      this.TB = paramBoolean1;
      if (this.TB) {
        a(this.TJ, this.Ue);
      }
    }
    else
    {
      return;
    }
    a(this.Ue);
  }
  
  private void fJ()
  {
    this.TX = z(this.TU.getAlpha(), 76);
  }
  
  private void fK()
  {
    this.TY = z(this.TU.getAlpha(), 255);
  }
  
  private void fL()
  {
    int i;
    if (this.Qe == null) {
      i = 0;
    }
    for (;;)
    {
      if (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (!localView.equals(this.TO)) {
          this.Qe = localView;
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  private boolean fM()
  {
    if (this.Ud != null) {
      return this.Ud.fN();
    }
    if ((this.Qe instanceof ListView))
    {
      ListView localListView = (ListView)this.Qe;
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
    return this.Qe.canScrollVertically(-1);
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
    this.TO.getBackground().setAlpha(paramInt);
    this.TU.setAlpha(paramInt);
  }
  
  private Animation z(final int paramInt1, final int paramInt2)
  {
    Animation local4 = new Animation()
    {
      public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        SwipeRefreshLayout.this.TU.setAlpha((int)(paramInt1 + (paramInt2 - paramInt1) * paramAnonymousFloat));
      }
    };
    local4.setDuration(300L);
    this.TO.QB = null;
    this.TO.clearAnimation();
    this.TO.startAnimation(local4);
    return local4;
  }
  
  final void O(float paramFloat)
  {
    setTargetOffsetTopAndBottom(this.mFrom + (int)((this.TR - this.mFrom) * paramFloat) - this.TO.getTop());
  }
  
  final void a(Animation.AnimationListener paramAnimationListener)
  {
    this.TW = new Animation()
    {
      public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        SwipeRefreshLayout.this.setAnimationProgress(1.0F - paramAnonymousFloat);
      }
    };
    this.TW.setDuration(150L);
    this.TO.QB = paramAnimationListener;
    this.TO.clearAnimation();
    this.TO.startAnimation(this.TW);
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return this.TE.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return this.TE.dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return this.TE.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return this.TE.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (this.TP < 0) {}
    do
    {
      return paramInt2;
      if (paramInt2 == paramInt1 - 1) {
        return this.TP;
      }
    } while (paramInt2 < this.TP);
    return paramInt2 + 1;
  }
  
  public int getNestedScrollAxes()
  {
    return this.oF.NY;
  }
  
  public int getProgressCircleDiameter()
  {
    return this.Ub;
  }
  
  public int getProgressViewEndOffset()
  {
    return this.TS;
  }
  
  public int getProgressViewStartOffset()
  {
    return this.TR;
  }
  
  public boolean hasNestedScrollingParent()
  {
    return this.TE.aN(0);
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return this.TE.NV;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    reset();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    fL();
    int i = paramMotionEvent.getActionMasked();
    if ((this.TM) && (i == 0)) {
      this.TM = false;
    }
    if ((!isEnabled()) || (this.TM) || (fM()) || (this.TB) || (this.TH)) {
      return false;
    }
    switch (i)
    {
    }
    for (;;)
    {
      return this.mIsBeingDragged;
      setTargetOffsetTopAndBottom(this.TR - this.TO.getTop());
      this.mActivePointerId = paramMotionEvent.getPointerId(0);
      this.mIsBeingDragged = false;
      i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      if (i < 0) {
        break;
      }
      this.TK = paramMotionEvent.getY(i);
      continue;
      if (this.mActivePointerId == -1) {
        break;
      }
      i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      if (i < 0) {
        break;
      }
      N(paramMotionEvent.getY(i));
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
      if (this.Qe == null) {
        fL();
      }
    } while (this.Qe == null);
    View localView = this.Qe;
    paramInt3 = getPaddingLeft();
    paramInt4 = getPaddingTop();
    localView.layout(paramInt3, paramInt4, paramInt1 - getPaddingLeft() - getPaddingRight() + paramInt3, paramInt2 - getPaddingTop() - getPaddingBottom() + paramInt4);
    paramInt2 = this.TO.getMeasuredWidth();
    paramInt3 = this.TO.getMeasuredHeight();
    this.TO.layout(paramInt1 / 2 - paramInt2 / 2, this.TJ, paramInt1 / 2 + paramInt2 / 2, this.TJ + paramInt3);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.Qe == null) {
      fL();
    }
    if (this.Qe == null) {}
    for (;;)
    {
      return;
      this.Qe.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), 1073741824));
      this.TO.measure(View.MeasureSpec.makeMeasureSpec(this.Ub, 1073741824), View.MeasureSpec.makeMeasureSpec(this.Ub, 1073741824));
      this.TP = -1;
      paramInt1 = 0;
      while (paramInt1 < getChildCount())
      {
        if (getChildAt(paramInt1) == this.TO)
        {
          this.TP = paramInt1;
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
    if ((paramInt2 > 0) && (this.TD > 0.0F))
    {
      if (paramInt2 <= this.TD) {
        break label141;
      }
      paramArrayOfInt[1] = (paramInt2 - (int)this.TD);
      this.TD = 0.0F;
    }
    for (;;)
    {
      L(this.TD);
      if ((this.Uc) && (paramInt2 > 0) && (this.TD == 0.0F) && (Math.abs(paramInt2 - paramArrayOfInt[1]) > 0)) {
        this.TO.setVisibility(8);
      }
      paramView = this.TF;
      if (dispatchNestedPreScroll(paramInt1 - paramArrayOfInt[0], paramInt2 - paramArrayOfInt[1], paramView, null))
      {
        paramArrayOfInt[0] += paramView[0];
        paramInt1 = paramArrayOfInt[1];
        paramView[1] += paramInt1;
      }
      return;
      label141:
      this.TD -= paramInt2;
      paramArrayOfInt[1] = paramInt2;
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.TG);
    paramInt1 = this.TG[1] + paramInt4;
    if ((paramInt1 < 0) && (!fM()))
    {
      float f = this.TD;
      this.TD = (Math.abs(paramInt1) + f);
      L(this.TD);
    }
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    this.oF.NY = paramInt;
    startNestedScroll(paramInt & 0x2);
    this.TD = 0.0F;
    this.TH = true;
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return (isEnabled()) && (!this.TM) && (!this.TB) && ((paramInt & 0x2) != 0);
  }
  
  public void onStopNestedScroll(View paramView)
  {
    this.oF.NY = 0;
    this.TH = false;
    if (this.TD > 0.0F)
    {
      M(this.TD);
      this.TD = 0.0F;
    }
    stopNestedScroll();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if ((this.TM) && (i == 0)) {
      this.TM = false;
    }
    if ((!isEnabled()) || (this.TM) || (fM()) || (this.TB) || (this.TH)) {}
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
          N(f1);
          if (this.mIsBeingDragged)
          {
            f1 = (f1 - this.mInitialMotionY) * 0.5F;
            if (f1 <= 0.0F) {
              break;
            }
            L(f1);
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
      M((f1 - f2) * 0.5F);
    }
    this.mActivePointerId = -1;
    return false;
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (((Build.VERSION.SDK_INT >= 21) || (!(this.Qe instanceof AbsListView))) && ((this.Qe == null) || (t.av(this.Qe)))) {
      super.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  final void reset()
  {
    this.TO.clearAnimation();
    this.TU.stop();
    this.TO.setVisibility(8);
    setColorViewAlpha(255);
    if (this.TL) {
      setAnimationProgress(0.0F);
    }
    for (;;)
    {
      this.TJ = this.TO.getTop();
      return;
      setTargetOffsetTopAndBottom(this.TR - this.TJ);
    }
  }
  
  void setAnimationProgress(float paramFloat)
  {
    this.TO.setScaleX(paramFloat);
    this.TO.setScaleY(paramFloat);
  }
  
  @Deprecated
  public void setColorScheme(int... paramVarArgs)
  {
    setColorSchemeResources(paramVarArgs);
  }
  
  public void setColorSchemeColors(int... paramVarArgs)
  {
    fL();
    d locald = this.TU;
    locald.QJ.setColors(paramVarArgs);
    locald.QJ.aU(0);
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
    this.TC = paramInt;
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
    this.TE.setNestedScrollingEnabled(paramBoolean);
  }
  
  public void setOnChildScrollUpCallback(a parama)
  {
    this.Ud = parama;
  }
  
  public void setOnRefreshListener(b paramb)
  {
    this.TA = paramb;
  }
  
  @Deprecated
  public void setProgressBackgroundColor(int paramInt)
  {
    setProgressBackgroundColorSchemeResource(paramInt);
  }
  
  public void setProgressBackgroundColorSchemeColor(int paramInt)
  {
    this.TO.setBackgroundColor(paramInt);
  }
  
  public void setProgressBackgroundColorSchemeResource(int paramInt)
  {
    setProgressBackgroundColorSchemeColor(b.n(getContext(), paramInt));
  }
  
  public void setRefreshing(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.TB != paramBoolean))
    {
      this.TB = paramBoolean;
      if (!this.Uc) {}
      for (int i = this.TS + this.TR;; i = this.TS)
      {
        setTargetOffsetTopAndBottom(i - this.TJ);
        this.Ua = false;
        Animation.AnimationListener localAnimationListener = this.Ue;
        this.TO.setVisibility(0);
        this.TU.setAlpha(255);
        this.TV = new Animation()
        {
          public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
          {
            SwipeRefreshLayout.this.setAnimationProgress(paramAnonymousFloat);
          }
        };
        this.TV.setDuration(this.TI);
        if (localAnimationListener != null) {
          this.TO.QB = localAnimationListener;
        }
        this.TO.clearAnimation();
        this.TO.startAnimation(this.TV);
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
    for (this.Ub = ((int)(localDisplayMetrics.density * 56.0F));; this.Ub = ((int)(localDisplayMetrics.density * 40.0F)))
    {
      this.TO.setImageDrawable(null);
      this.TU.setStyle(paramInt);
      this.TO.setImageDrawable(this.TU);
      return;
    }
  }
  
  public void setSlingshotDistance(int paramInt)
  {
    this.TT = paramInt;
  }
  
  void setTargetOffsetTopAndBottom(int paramInt)
  {
    this.TO.bringToFront();
    t.s(this.TO, paramInt);
    this.TJ = this.TO.getTop();
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return this.TE.t(paramInt, 0);
  }
  
  public void stopNestedScroll()
  {
    this.TE.aM(0);
  }
  
  public static abstract interface a
  {
    public abstract boolean fN();
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.widget.SwipeRefreshLayout
 * JD-Core Version:    0.7.0.1
 */