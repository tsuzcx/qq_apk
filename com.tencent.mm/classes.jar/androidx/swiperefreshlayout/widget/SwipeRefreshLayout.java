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
import androidx.core.g.z;
import androidx.core.widget.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SwipeRefreshLayout
  extends ViewGroup
  implements k, o
{
  private static final int[] LAYOUT_ATTRS;
  private static final String LOG_TAG;
  private final DecelerateInterpolator bXY;
  private final r bnp;
  private View bvQ;
  private int cdA;
  float cdB;
  protected int cdC;
  int cdD;
  int cdE;
  b cdF;
  private Animation cdG;
  private Animation cdH;
  private Animation cdI;
  private Animation cdJ;
  private Animation cdK;
  boolean cdL;
  private int cdM;
  boolean cdN;
  private a cdO;
  private Animation.AnimationListener cdP;
  private final Animation cdQ;
  private final Animation cdR;
  b cdm;
  boolean cdn;
  private float cdo;
  private float cdp;
  private final n cdq;
  private final int[] cdr;
  private final int[] cds;
  private boolean cdt;
  private int cdu;
  int cdv;
  private float cdw;
  boolean cdx;
  private boolean cdy;
  a cdz;
  private int mActivePointerId;
  protected int mFrom;
  private float mInitialMotionY;
  private boolean mIsBeingDragged;
  private int mTouchSlop;
  
  static
  {
    AppMethodBeat.i(193314);
    LOG_TAG = SwipeRefreshLayout.class.getSimpleName();
    LAYOUT_ATTRS = new int[] { 16842766 };
    AppMethodBeat.o(193314);
  }
  
  public SwipeRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(193210);
    this.cdn = false;
    this.cdo = -1.0F;
    this.cdr = new int[2];
    this.cds = new int[2];
    this.mActivePointerId = -1;
    this.cdA = -1;
    this.cdP = new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(193224);
        if (SwipeRefreshLayout.this.cdn)
        {
          SwipeRefreshLayout.this.cdF.setAlpha(255);
          SwipeRefreshLayout.this.cdF.start();
          SwipeRefreshLayout.this.cdv = SwipeRefreshLayout.this.cdz.getTop();
          AppMethodBeat.o(193224);
          return;
        }
        SwipeRefreshLayout.this.reset();
        AppMethodBeat.o(193224);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    };
    this.cdQ = new Animation()
    {
      public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        AppMethodBeat.i(193203);
        if (!SwipeRefreshLayout.this.cdN) {}
        for (int i = SwipeRefreshLayout.this.cdD - Math.abs(SwipeRefreshLayout.this.cdC);; i = SwipeRefreshLayout.this.cdD)
        {
          int j = SwipeRefreshLayout.this.mFrom;
          i = (int)((i - SwipeRefreshLayout.this.mFrom) * paramAnonymousFloat);
          int k = SwipeRefreshLayout.this.cdz.getTop();
          SwipeRefreshLayout.this.setTargetOffsetTopAndBottom(i + j - k);
          SwipeRefreshLayout.this.cdF.aC(1.0F - paramAnonymousFloat);
          AppMethodBeat.o(193203);
          return;
        }
      }
    };
    this.cdR = new Animation()
    {
      public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        AppMethodBeat.i(193214);
        SwipeRefreshLayout.this.aI(paramAnonymousFloat);
        AppMethodBeat.o(193214);
      }
    };
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.cdu = getResources().getInteger(17694721);
    setWillNotDraw(false);
    this.bXY = new DecelerateInterpolator(2.0F);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.cdM = ((int)(40.0F * localDisplayMetrics.density));
    this.cdz = new a(getContext());
    this.cdF = new b(getContext());
    this.cdF.setStyle(1);
    this.cdz.setImageDrawable(this.cdF);
    this.cdz.setVisibility(8);
    addView(this.cdz);
    setChildrenDrawingOrderEnabled(true);
    this.cdD = ((int)(localDisplayMetrics.density * 64.0F));
    this.cdo = this.cdD;
    this.bnp = new r();
    this.cdq = new n(this);
    setNestedScrollingEnabled(true);
    int i = -this.cdM;
    this.cdv = i;
    this.cdC = i;
    aI(1.0F);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, LAYOUT_ATTRS);
    setEnabled(paramContext.getBoolean(0, true));
    paramContext.recycle();
    AppMethodBeat.o(193210);
  }
  
  private void LC()
  {
    AppMethodBeat.i(193223);
    this.cdI = bQ(this.cdF.getAlpha(), 76);
    AppMethodBeat.o(193223);
  }
  
  private void LD()
  {
    AppMethodBeat.i(193231);
    this.cdJ = bQ(this.cdF.getAlpha(), 255);
    AppMethodBeat.o(193231);
  }
  
  private void LE()
  {
    AppMethodBeat.i(193243);
    if (this.bvQ == null)
    {
      int i = 0;
      while (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (!localView.equals(this.cdz))
        {
          this.bvQ = localView;
          AppMethodBeat.o(193243);
          return;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(193243);
  }
  
  private boolean LF()
  {
    AppMethodBeat.i(193252);
    if (this.cdO != null)
    {
      bool = this.cdO.LG();
      AppMethodBeat.o(193252);
      return bool;
    }
    if ((this.bvQ instanceof ListView))
    {
      bool = g.a((ListView)this.bvQ);
      AppMethodBeat.o(193252);
      return bool;
    }
    boolean bool = this.bvQ.canScrollVertically(-1);
    AppMethodBeat.o(193252);
    return bool;
  }
  
  private void a(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    AppMethodBeat.i(193288);
    this.mFrom = paramInt;
    this.cdQ.reset();
    this.cdQ.setDuration(200L);
    this.cdQ.setInterpolator(this.bXY);
    if (paramAnimationListener != null) {
      this.cdz.ccK = paramAnimationListener;
    }
    this.cdz.clearAnimation();
    this.cdz.startAnimation(this.cdQ);
    AppMethodBeat.o(193288);
  }
  
  private static boolean a(Animation paramAnimation)
  {
    AppMethodBeat.i(193259);
    if ((paramAnimation != null) && (paramAnimation.hasStarted()) && (!paramAnimation.hasEnded()))
    {
      AppMethodBeat.o(193259);
      return true;
    }
    AppMethodBeat.o(193259);
    return false;
  }
  
  private void aF(float paramFloat)
  {
    AppMethodBeat.i(193270);
    this.cdF.bj(true);
    float f1 = Math.min(1.0F, Math.abs(paramFloat / this.cdo));
    float f2 = Math.max((float)(f1 - 0.4D), 0.0F) * 5.0F / 3.0F;
    float f4 = Math.abs(paramFloat);
    float f5 = this.cdo;
    int i;
    int j;
    if (this.cdE > 0)
    {
      i = this.cdE;
      float f3 = i;
      f4 = Math.max(0.0F, Math.min(f4 - f5, f3 * 2.0F) / f3);
      f4 = (float)(f4 / 4.0F - Math.pow(f4 / 4.0F, 2.0D)) * 2.0F;
      i = this.cdC;
      j = (int)(f3 * f1 + f3 * f4 * 2.0F);
      if (this.cdz.getVisibility() != 0) {
        this.cdz.setVisibility(0);
      }
      if (!this.cdx)
      {
        this.cdz.setScaleX(1.0F);
        this.cdz.setScaleY(1.0F);
      }
      if (this.cdx) {
        setAnimationProgress(Math.min(1.0F, paramFloat / this.cdo));
      }
      if (paramFloat >= this.cdo) {
        break label349;
      }
      if ((this.cdF.getAlpha() > 76) && (!a(this.cdI))) {
        LC();
      }
    }
    for (;;)
    {
      this.cdF.aD(Math.min(0.8F, f2 * 0.8F));
      this.cdF.aC(Math.min(1.0F, f2));
      this.cdF.aE((-0.25F + f2 * 0.4F + f4 * 2.0F) * 0.5F);
      setTargetOffsetTopAndBottom(j + i - this.cdv);
      AppMethodBeat.o(193270);
      return;
      if (this.cdN)
      {
        i = this.cdD - this.cdC;
        break;
      }
      i = this.cdD;
      break;
      label349:
      if ((this.cdF.getAlpha() < 255) && (!a(this.cdJ))) {
        LD();
      }
    }
  }
  
  private void aG(float paramFloat)
  {
    AppMethodBeat.i(193275);
    if (paramFloat > this.cdo)
    {
      i(true, true);
      AppMethodBeat.o(193275);
      return;
    }
    this.cdn = false;
    this.cdF.aD(0.0F);
    Animation.AnimationListener local5 = null;
    if (!this.cdx) {
      local5 = new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(193218);
          if (!SwipeRefreshLayout.this.cdx) {
            SwipeRefreshLayout.this.a(null);
          }
          AppMethodBeat.o(193218);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      };
    }
    b(this.cdv, local5);
    this.cdF.bj(false);
    AppMethodBeat.o(193275);
  }
  
  private void aH(float paramFloat)
  {
    AppMethodBeat.i(193281);
    if ((paramFloat - this.cdw > this.mTouchSlop) && (!this.mIsBeingDragged))
    {
      this.mInitialMotionY = (this.cdw + this.mTouchSlop);
      this.mIsBeingDragged = true;
      this.cdF.setAlpha(76);
    }
    AppMethodBeat.o(193281);
  }
  
  private void b(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    AppMethodBeat.i(193293);
    if (this.cdx)
    {
      c(paramInt, paramAnimationListener);
      AppMethodBeat.o(193293);
      return;
    }
    this.mFrom = paramInt;
    this.cdR.reset();
    this.cdR.setDuration(200L);
    this.cdR.setInterpolator(this.bXY);
    if (paramAnimationListener != null) {
      this.cdz.ccK = paramAnimationListener;
    }
    this.cdz.clearAnimation();
    this.cdz.startAnimation(this.cdR);
    AppMethodBeat.o(193293);
  }
  
  private Animation bQ(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(193240);
    Animation local4 = new Animation()
    {
      public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        AppMethodBeat.i(193208);
        SwipeRefreshLayout.this.cdF.setAlpha((int)(paramInt1 + (paramInt2 - paramInt1) * paramAnonymousFloat));
        AppMethodBeat.o(193208);
      }
    };
    local4.setDuration(300L);
    this.cdz.ccK = null;
    this.cdz.clearAnimation();
    this.cdz.startAnimation(local4);
    AppMethodBeat.o(193240);
    return local4;
  }
  
  private void c(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    AppMethodBeat.i(193300);
    this.mFrom = paramInt;
    this.cdB = this.cdz.getScaleX();
    this.cdK = new Animation()
    {
      public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        AppMethodBeat.i(193198);
        float f1 = SwipeRefreshLayout.this.cdB;
        float f2 = -SwipeRefreshLayout.this.cdB;
        SwipeRefreshLayout.this.setAnimationProgress(f1 + f2 * paramAnonymousFloat);
        SwipeRefreshLayout.this.aI(paramAnonymousFloat);
        AppMethodBeat.o(193198);
      }
    };
    this.cdK.setDuration(150L);
    if (paramAnimationListener != null) {
      this.cdz.ccK = paramAnimationListener;
    }
    this.cdz.clearAnimation();
    this.cdz.startAnimation(this.cdK);
    AppMethodBeat.o(193300);
  }
  
  private void i(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(193219);
    if (this.cdn != paramBoolean1)
    {
      this.cdL = paramBoolean2;
      LE();
      this.cdn = paramBoolean1;
      if (this.cdn)
      {
        a(this.cdv, this.cdP);
        AppMethodBeat.o(193219);
        return;
      }
      a(this.cdP);
    }
    AppMethodBeat.o(193219);
  }
  
  private void onSecondaryPointerUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(193307);
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
      AppMethodBeat.o(193307);
      return;
    }
  }
  
  private void setColorViewAlpha(int paramInt)
  {
    AppMethodBeat.i(193201);
    this.cdz.getBackground().setAlpha(paramInt);
    this.cdF.setAlpha(paramInt);
    AppMethodBeat.o(193201);
  }
  
  final void a(Animation.AnimationListener paramAnimationListener)
  {
    AppMethodBeat.i(193392);
    this.cdH = new Animation()
    {
      public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        AppMethodBeat.i(193213);
        SwipeRefreshLayout.this.setAnimationProgress(1.0F - paramAnonymousFloat);
        AppMethodBeat.o(193213);
      }
    };
    this.cdH.setDuration(150L);
    this.cdz.ccK = paramAnimationListener;
    this.cdz.clearAnimation();
    this.cdz.startAnimation(this.cdH);
    AppMethodBeat.o(193392);
  }
  
  final void aI(float paramFloat)
  {
    AppMethodBeat.i(193632);
    setTargetOffsetTopAndBottom(this.mFrom + (int)((this.cdC - this.mFrom) * paramFloat) - this.cdz.getTop());
    AppMethodBeat.o(193632);
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(193596);
    paramBoolean = this.cdq.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
    AppMethodBeat.o(193596);
    return paramBoolean;
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(193606);
    boolean bool = this.cdq.dispatchNestedPreFling(paramFloat1, paramFloat2);
    AppMethodBeat.o(193606);
    return bool;
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(193575);
    boolean bool = this.cdq.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
    AppMethodBeat.o(193575);
    return bool;
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(193565);
    boolean bool = this.cdq.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
    AppMethodBeat.o(193565);
    return bool;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (this.cdA < 0) {}
    do
    {
      return paramInt2;
      if (paramInt2 == paramInt1 - 1) {
        return this.cdA;
      }
    } while (paramInt2 < this.cdA);
    return paramInt2 + 1;
  }
  
  public int getNestedScrollAxes()
  {
    AppMethodBeat.i(193508);
    int i = this.bnp.getNestedScrollAxes();
    AppMethodBeat.o(193508);
    return i;
  }
  
  public int getProgressCircleDiameter()
  {
    return this.cdM;
  }
  
  public int getProgressViewEndOffset()
  {
    return this.cdD;
  }
  
  public int getProgressViewStartOffset()
  {
    return this.cdC;
  }
  
  public boolean hasNestedScrollingParent()
  {
    AppMethodBeat.i(193560);
    boolean bool = this.cdq.hasNestedScrollingParent();
    AppMethodBeat.o(193560);
    return bool;
  }
  
  public boolean isNestedScrollingEnabled()
  {
    AppMethodBeat.i(193536);
    boolean bool = this.cdq.isNestedScrollingEnabled();
    AppMethodBeat.o(193536);
    return bool;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(193331);
    super.onDetachedFromWindow();
    reset();
    AppMethodBeat.o(193331);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(193477);
    LE();
    int i = paramMotionEvent.getActionMasked();
    if ((this.cdy) && (i == 0)) {
      this.cdy = false;
    }
    if ((!isEnabled()) || (this.cdy) || (LF()) || (this.cdn) || (this.cdt))
    {
      AppMethodBeat.o(193477);
      return false;
    }
    switch (i)
    {
    }
    for (;;)
    {
      boolean bool = this.mIsBeingDragged;
      AppMethodBeat.o(193477);
      return bool;
      setTargetOffsetTopAndBottom(this.cdC - this.cdz.getTop());
      this.mActivePointerId = paramMotionEvent.getPointerId(0);
      this.mIsBeingDragged = false;
      i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      if (i < 0)
      {
        AppMethodBeat.o(193477);
        return false;
      }
      this.cdw = paramMotionEvent.getY(i);
      continue;
      if (this.mActivePointerId == -1)
      {
        AppMethodBeat.o(193477);
        return false;
      }
      i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      if (i < 0)
      {
        AppMethodBeat.o(193477);
        return false;
      }
      aH(paramMotionEvent.getY(i));
      continue;
      onSecondaryPointerUp(paramMotionEvent);
      continue;
      this.mIsBeingDragged = false;
      this.mActivePointerId = -1;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(193446);
    paramInt1 = getMeasuredWidth();
    paramInt2 = getMeasuredHeight();
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(193446);
      return;
    }
    if (this.bvQ == null) {
      LE();
    }
    if (this.bvQ == null)
    {
      AppMethodBeat.o(193446);
      return;
    }
    View localView = this.bvQ;
    paramInt3 = getPaddingLeft();
    paramInt4 = getPaddingTop();
    localView.layout(paramInt3, paramInt4, paramInt1 - getPaddingLeft() - getPaddingRight() + paramInt3, paramInt2 - getPaddingTop() - getPaddingBottom() + paramInt4);
    paramInt2 = this.cdz.getMeasuredWidth();
    paramInt3 = this.cdz.getMeasuredHeight();
    this.cdz.layout(paramInt1 / 2 - paramInt2 / 2, this.cdv, paramInt1 / 2 + paramInt2 / 2, this.cdv + paramInt3);
    AppMethodBeat.o(193446);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193457);
    super.onMeasure(paramInt1, paramInt2);
    if (this.bvQ == null) {
      LE();
    }
    if (this.bvQ == null)
    {
      AppMethodBeat.o(193457);
      return;
    }
    this.bvQ.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), 1073741824));
    this.cdz.measure(View.MeasureSpec.makeMeasureSpec(this.cdM, 1073741824), View.MeasureSpec.makeMeasureSpec(this.cdM, 1073741824));
    this.cdA = -1;
    paramInt1 = 0;
    while (paramInt1 < getChildCount())
    {
      if (getChildAt(paramInt1) == this.cdz)
      {
        this.cdA = paramInt1;
        AppMethodBeat.o(193457);
        return;
      }
      paramInt1 += 1;
    }
    AppMethodBeat.o(193457);
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(193588);
    paramBoolean = dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
    AppMethodBeat.o(193588);
    return paramBoolean;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(193581);
    boolean bool = dispatchNestedPreFling(paramFloat1, paramFloat2);
    AppMethodBeat.o(193581);
    return bool;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(193500);
    if ((paramInt2 > 0) && (this.cdp > 0.0F))
    {
      if (paramInt2 <= this.cdp) {
        break label153;
      }
      paramArrayOfInt[1] = (paramInt2 - (int)this.cdp);
      this.cdp = 0.0F;
    }
    for (;;)
    {
      aF(this.cdp);
      if ((this.cdN) && (paramInt2 > 0) && (this.cdp == 0.0F) && (Math.abs(paramInt2 - paramArrayOfInt[1]) > 0)) {
        this.cdz.setVisibility(8);
      }
      paramView = this.cdr;
      if (dispatchNestedPreScroll(paramInt1 - paramArrayOfInt[0], paramInt2 - paramArrayOfInt[1], paramView, null))
      {
        paramArrayOfInt[0] += paramView[0];
        paramInt1 = paramArrayOfInt[1];
        paramView[1] += paramInt1;
      }
      AppMethodBeat.o(193500);
      return;
      label153:
      this.cdp -= paramInt2;
      paramArrayOfInt[1] = paramInt2;
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(193523);
    dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.cds);
    paramInt1 = this.cds[1] + paramInt4;
    if ((paramInt1 < 0) && (!LF()))
    {
      float f = this.cdp;
      this.cdp = (Math.abs(paramInt1) + f);
      aF(this.cdp);
    }
    AppMethodBeat.o(193523);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    AppMethodBeat.i(193493);
    this.bnp.ep(paramInt);
    startNestedScroll(paramInt & 0x2);
    this.cdp = 0.0F;
    this.cdt = true;
    AppMethodBeat.o(193493);
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    AppMethodBeat.i(193487);
    if ((isEnabled()) && (!this.cdy) && (!this.cdn) && ((paramInt & 0x2) != 0))
    {
      AppMethodBeat.o(193487);
      return true;
    }
    AppMethodBeat.o(193487);
    return false;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    AppMethodBeat.i(193516);
    this.bnp.Eg();
    this.cdt = false;
    if (this.cdp > 0.0F)
    {
      aG(this.cdp);
      this.cdp = 0.0F;
    }
    stopNestedScroll();
    AppMethodBeat.o(193516);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(193620);
    int i = paramMotionEvent.getActionMasked();
    if ((this.cdy) && (i == 0)) {
      this.cdy = false;
    }
    if ((!isEnabled()) || (this.cdy) || (LF()) || (this.cdn) || (this.cdt))
    {
      AppMethodBeat.o(193620);
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
        AppMethodBeat.o(193620);
        return true;
        this.mActivePointerId = paramMotionEvent.getPointerId(0);
        this.mIsBeingDragged = false;
        continue;
        i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
        if (i < 0)
        {
          AppMethodBeat.o(193620);
          return false;
        }
        f1 = paramMotionEvent.getY(i);
        aH(f1);
        if (this.mIsBeingDragged)
        {
          f1 = (f1 - this.mInitialMotionY) * 0.5F;
          if (f1 > 0.0F)
          {
            aF(f1);
          }
          else
          {
            AppMethodBeat.o(193620);
            return false;
            i = paramMotionEvent.getActionIndex();
            if (i < 0)
            {
              AppMethodBeat.o(193620);
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
        AppMethodBeat.o(193620);
        return false;
      }
      if (this.mIsBeingDragged)
      {
        f1 = paramMotionEvent.getY(i);
        float f2 = this.mInitialMotionY;
        this.mIsBeingDragged = false;
        aG((f1 - f2) * 0.5F);
      }
      this.mActivePointerId = -1;
      AppMethodBeat.o(193620);
      return false;
    }
    AppMethodBeat.o(193620);
    return false;
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(193482);
    if (((Build.VERSION.SDK_INT >= 21) || (!(this.bvQ instanceof AbsListView))) && ((this.bvQ == null) || (z.ar(this.bvQ)))) {
      super.requestDisallowInterceptTouchEvent(paramBoolean);
    }
    AppMethodBeat.o(193482);
  }
  
  final void reset()
  {
    AppMethodBeat.i(193319);
    this.cdz.clearAnimation();
    this.cdF.stop();
    this.cdz.setVisibility(8);
    setColorViewAlpha(255);
    if (this.cdx) {
      setAnimationProgress(0.0F);
    }
    for (;;)
    {
      this.cdv = this.cdz.getTop();
      AppMethodBeat.o(193319);
      return;
      setTargetOffsetTopAndBottom(this.cdC - this.cdv);
    }
  }
  
  void setAnimationProgress(float paramFloat)
  {
    AppMethodBeat.i(193387);
    this.cdz.setScaleX(paramFloat);
    this.cdz.setScaleY(paramFloat);
    AppMethodBeat.o(193387);
  }
  
  @Deprecated
  public void setColorScheme(int... paramVarArgs)
  {
    AppMethodBeat.i(193421);
    setColorSchemeResources(paramVarArgs);
    AppMethodBeat.o(193421);
  }
  
  public void setColorSchemeColors(int... paramVarArgs)
  {
    AppMethodBeat.i(193435);
    LE();
    b localb = this.cdF;
    localb.ccS.setColors(paramVarArgs);
    localb.ccS.gF(0);
    localb.invalidateSelf();
    AppMethodBeat.o(193435);
  }
  
  public void setColorSchemeResources(int... paramVarArgs)
  {
    AppMethodBeat.i(193431);
    Context localContext = getContext();
    int[] arrayOfInt = new int[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      arrayOfInt[i] = androidx.core.content.a.w(localContext, paramVarArgs[i]);
      i += 1;
    }
    setColorSchemeColors(arrayOfInt);
    AppMethodBeat.o(193431);
  }
  
  public void setDistanceToTriggerSync(int paramInt)
  {
    this.cdo = paramInt;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(193326);
    super.setEnabled(paramBoolean);
    if (!paramBoolean) {
      reset();
    }
    AppMethodBeat.o(193326);
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(193529);
    this.cdq.setNestedScrollingEnabled(paramBoolean);
    AppMethodBeat.o(193529);
  }
  
  public void setOnChildScrollUpCallback(a parama)
  {
    this.cdO = parama;
  }
  
  public void setOnRefreshListener(b paramb)
  {
    this.cdm = paramb;
  }
  
  @Deprecated
  public void setProgressBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(193401);
    setProgressBackgroundColorSchemeResource(paramInt);
    AppMethodBeat.o(193401);
  }
  
  public void setProgressBackgroundColorSchemeColor(int paramInt)
  {
    AppMethodBeat.i(193416);
    this.cdz.setBackgroundColor(paramInt);
    AppMethodBeat.o(193416);
  }
  
  public void setProgressBackgroundColorSchemeResource(int paramInt)
  {
    AppMethodBeat.i(193409);
    setProgressBackgroundColorSchemeColor(androidx.core.content.a.w(getContext(), paramInt));
    AppMethodBeat.o(193409);
  }
  
  public void setRefreshing(boolean paramBoolean)
  {
    AppMethodBeat.i(193376);
    if ((paramBoolean) && (this.cdn != paramBoolean))
    {
      this.cdn = paramBoolean;
      if (!this.cdN) {}
      for (int i = this.cdD + this.cdC;; i = this.cdD)
      {
        setTargetOffsetTopAndBottom(i - this.cdv);
        this.cdL = false;
        Animation.AnimationListener localAnimationListener = this.cdP;
        this.cdz.setVisibility(0);
        this.cdF.setAlpha(255);
        this.cdG = new Animation()
        {
          public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
          {
            AppMethodBeat.i(193222);
            SwipeRefreshLayout.this.setAnimationProgress(paramAnonymousFloat);
            AppMethodBeat.o(193222);
          }
        };
        this.cdG.setDuration(this.cdu);
        if (localAnimationListener != null) {
          this.cdz.ccK = localAnimationListener;
        }
        this.cdz.clearAnimation();
        this.cdz.startAnimation(this.cdG);
        AppMethodBeat.o(193376);
        return;
      }
    }
    i(paramBoolean, false);
    AppMethodBeat.o(193376);
  }
  
  public void setSize(int paramInt)
  {
    AppMethodBeat.i(193358);
    if ((paramInt != 0) && (paramInt != 1))
    {
      AppMethodBeat.o(193358);
      return;
    }
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    if (paramInt == 0) {}
    for (this.cdM = ((int)(localDisplayMetrics.density * 56.0F));; this.cdM = ((int)(localDisplayMetrics.density * 40.0F)))
    {
      this.cdz.setImageDrawable(null);
      this.cdF.setStyle(paramInt);
      this.cdz.setImageDrawable(this.cdF);
      AppMethodBeat.o(193358);
      return;
    }
  }
  
  public void setSlingshotDistance(int paramInt)
  {
    this.cdE = paramInt;
  }
  
  void setTargetOffsetTopAndBottom(int paramInt)
  {
    AppMethodBeat.i(193637);
    this.cdz.bringToFront();
    z.s(this.cdz, paramInt);
    this.cdv = this.cdz.getTop();
    AppMethodBeat.o(193637);
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    AppMethodBeat.i(193544);
    boolean bool = this.cdq.startNestedScroll(paramInt);
    AppMethodBeat.o(193544);
    return bool;
  }
  
  public void stopNestedScroll()
  {
    AppMethodBeat.i(193552);
    this.cdq.stopNestedScroll();
    AppMethodBeat.o(193552);
  }
  
  public static abstract interface a
  {
    public abstract boolean LG();
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.swiperefreshlayout.widget.SwipeRefreshLayout
 * JD-Core Version:    0.7.0.1
 */