package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.a;
import android.support.v4.view.a.b;
import android.support.v4.view.k;
import android.support.v4.view.l;
import android.support.v4.view.n;
import android.support.v4.view.o;
import android.support.v4.view.t;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityRecord;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.OverScroller;
import android.widget.ScrollView;
import java.util.ArrayList;
import java.util.List;

public class NestedScrollView
  extends FrameLayout
  implements k, n
{
  private static final a KS = new a();
  private static final int[] KT = { 16843130 };
  private long KF;
  private EdgeEffect KG;
  private EdgeEffect KH;
  private boolean KI = true;
  private boolean KJ = false;
  private View KK = null;
  private boolean KL;
  private boolean KM = true;
  private final int[] KN = new int[2];
  private final int[] KO = new int[2];
  private int KP;
  private int KQ;
  private SavedState KR;
  private final o KU;
  private final l KV;
  private float KW;
  private b KX;
  private OverScroller jR = new OverScroller(getContext());
  private int jS;
  private int mActivePointerId = -1;
  private boolean mIsBeingDragged = false;
  private int mMaximumVelocity;
  private int mMinimumVelocity;
  private final Rect mTempRect = new Rect();
  private int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  
  public NestedScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NestedScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setFocusable(true);
    setDescendantFocusability(262144);
    setWillNotDraw(false);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    this.mTouchSlop = localViewConfiguration.getScaledTouchSlop();
    this.mMinimumVelocity = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.mMaximumVelocity = localViewConfiguration.getScaledMaximumFlingVelocity();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, KT, paramInt, 0);
    setFillViewport(paramContext.getBoolean(0, false));
    paramContext.recycle();
    this.KU = new o(this);
    this.KV = new l(this);
    setNestedScrollingEnabled(true);
    t.a(this, KS);
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, int paramInt5)
  {
    return this.KV.a(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, paramInt5);
  }
  
  private boolean a(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt3)
  {
    return this.KV.a(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, paramInt3);
  }
  
  private void aG(int paramInt)
  {
    if (paramInt != 0)
    {
      if (this.KM) {
        smoothScrollBy(0, paramInt);
      }
    }
    else {
      return;
    }
    scrollBy(0, paramInt);
  }
  
  private void aI(int paramInt)
  {
    int i = getScrollY();
    if (((i > 0) || (paramInt > 0)) && ((i < getScrollRange()) || (paramInt < 0))) {}
    for (boolean bool = true;; bool = false)
    {
      if (!dispatchNestedPreFling(0.0F, paramInt))
      {
        dispatchNestedFling(0.0F, paramInt, bool);
        fling(paramInt);
      }
      return;
    }
  }
  
  private boolean aM(View paramView)
  {
    boolean bool = false;
    if (!h(paramView, 0, getHeight())) {
      bool = true;
    }
    return bool;
  }
  
  private void aN(View paramView)
  {
    paramView.getDrawingRect(this.mTempRect);
    offsetDescendantRectToMyCoords(paramView, this.mTempRect);
    int i = computeScrollDeltaToGetChildRectOnScreen(this.mTempRect);
    if (i != 0) {
      scrollBy(0, i);
    }
  }
  
  private boolean arrowScroll(int paramInt)
  {
    View localView1 = findFocus();
    if (localView1 == this) {
      localView1 = null;
    }
    for (;;)
    {
      View localView2 = FocusFinder.getInstance().findNextFocus(this, localView1, paramInt);
      int i = getMaxScrollAmount();
      if ((localView2 != null) && (h(localView2, i, getHeight())))
      {
        localView2.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(localView2, this.mTempRect);
        aG(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
        localView2.requestFocus(paramInt);
        if ((localView1 != null) && (localView1.isFocused()) && (aM(localView1)))
        {
          paramInt = getDescendantFocusability();
          setDescendantFocusability(131072);
          requestFocus();
          setDescendantFocusability(paramInt);
        }
        return true;
      }
      if ((paramInt == 33) && (getScrollY() < i)) {
        i = getScrollY();
      }
      for (;;)
      {
        if (i == 0)
        {
          return false;
          if ((paramInt == 130) && (getChildCount() > 0))
          {
            localView2 = getChildAt(0);
            FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView2.getLayoutParams();
            int j = localView2.getBottom();
            i = Math.min(localLayoutParams.bottomMargin + j - (getScrollY() + getHeight() - getPaddingBottom()), i);
          }
        }
        else
        {
          if (paramInt == 130) {}
          for (;;)
          {
            aG(i);
            break;
            i = -i;
          }
        }
      }
    }
  }
  
  private boolean au(int paramInt)
  {
    return this.KV.au(paramInt);
  }
  
  private void av(int paramInt)
  {
    this.KV.av(paramInt);
  }
  
  private View b(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = getFocusables(2);
    Object localObject = null;
    int n = localArrayList.size();
    int k = 0;
    int i = 0;
    View localView;
    int m;
    int i1;
    int j;
    if (k < n)
    {
      localView = (View)localArrayList.get(k);
      m = localView.getTop();
      i1 = localView.getBottom();
      if ((paramInt1 >= i1) || (m >= paramInt2)) {
        break label204;
      }
      if ((paramInt1 < m) && (i1 < paramInt2))
      {
        j = 1;
        label87:
        if (localObject != null) {
          break label115;
        }
        i = j;
        localObject = localView;
      }
    }
    label174:
    label204:
    for (;;)
    {
      k += 1;
      break;
      j = 0;
      break label87;
      label115:
      if (((paramBoolean) && (m < localObject.getTop())) || ((!paramBoolean) && (i1 > localObject.getBottom()))) {}
      for (m = 1;; m = 0)
      {
        if (i == 0) {
          break label174;
        }
        if ((j == 0) || (m == 0)) {
          break label204;
        }
        localObject = localView;
        break;
      }
      if (j != 0)
      {
        i = 1;
        localObject = localView;
      }
      else if (m != 0)
      {
        localObject = localView;
        continue;
        return localObject;
      }
    }
  }
  
  private static boolean b(View paramView1, View paramView2)
  {
    if (paramView1 == paramView2) {
      return true;
    }
    paramView1 = paramView1.getParent();
    return ((paramView1 instanceof ViewGroup)) && (b((View)paramView1, paramView2));
  }
  
  private static int clamp(int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    if ((paramInt2 >= paramInt3) || (paramInt1 < 0)) {
      i = 0;
    }
    do
    {
      return i;
      i = paramInt1;
    } while (paramInt2 + paramInt1 <= paramInt3);
    return paramInt3 - paramInt2;
  }
  
  private int computeScrollDeltaToGetChildRectOnScreen(Rect paramRect)
  {
    if (getChildCount() == 0) {
      return 0;
    }
    int m = getHeight();
    int i = getScrollY();
    int k = i + m;
    int j = getVerticalFadingEdgeLength();
    if (paramRect.top > 0) {
      i += j;
    }
    for (;;)
    {
      View localView = getChildAt(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
      if (paramRect.bottom < localView.getHeight() + localLayoutParams.topMargin + localLayoutParams.bottomMargin) {}
      for (j = k - j;; j = k)
      {
        if ((paramRect.bottom > j) && (paramRect.top > i)) {
          if (paramRect.height() > m)
          {
            i = paramRect.top - i + 0;
            j = localView.getBottom();
            i = Math.min(i, localLayoutParams.bottomMargin + j - k);
          }
        }
        for (;;)
        {
          return i;
          i = paramRect.bottom - j + 0;
          break;
          if ((paramRect.top < i) && (paramRect.bottom < j))
          {
            if (paramRect.height() > m) {}
            for (i = 0 - (j - paramRect.bottom);; i = 0 - (i - paramRect.top))
            {
              i = Math.max(i, -getScrollY());
              break;
            }
          }
          i = 0;
        }
      }
    }
  }
  
  private boolean dI()
  {
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
      int i = localView.getHeight();
      int j = localLayoutParams.topMargin;
      return localLayoutParams.bottomMargin + (i + j) > getHeight() - getPaddingTop() - getPaddingBottom();
    }
    return false;
  }
  
  private void ed()
  {
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
  }
  
  private void ee()
  {
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  private void ef()
  {
    if (getOverScrollMode() != 2)
    {
      if (this.KG == null)
      {
        Context localContext = getContext();
        this.KG = new EdgeEffect(localContext);
        this.KH = new EdgeEffect(localContext);
      }
      return;
    }
    this.KG = null;
    this.KH = null;
  }
  
  private void endDrag()
  {
    this.mIsBeingDragged = false;
    ee();
    av(0);
    if (this.KG != null)
    {
      this.KG.onRelease();
      this.KH.onRelease();
    }
  }
  
  private boolean f(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = false;
    int j = getHeight();
    int i = getScrollY();
    j = i + j;
    if (paramInt1 == 33) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      View localView = b(bool1, paramInt2, paramInt3);
      Object localObject = localView;
      if (localView == null) {
        localObject = this;
      }
      if ((paramInt2 < i) || (paramInt3 > j)) {
        break;
      }
      bool1 = bool2;
      if (localObject != findFocus()) {
        ((View)localObject).requestFocus(paramInt1);
      }
      return bool1;
    }
    if (bool1) {
      paramInt2 -= i;
    }
    for (;;)
    {
      aG(paramInt2);
      bool1 = true;
      break;
      paramInt2 = paramInt3 - j;
    }
  }
  
  private boolean fullScroll(int paramInt)
  {
    if (paramInt == 130) {}
    for (int i = 1;; i = 0)
    {
      int j = getHeight();
      this.mTempRect.top = 0;
      this.mTempRect.bottom = j;
      if (i != 0)
      {
        i = getChildCount();
        if (i > 0)
        {
          View localView = getChildAt(i - 1);
          FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
          Rect localRect = this.mTempRect;
          i = localView.getBottom();
          localRect.bottom = (localLayoutParams.bottomMargin + i + getPaddingBottom());
          this.mTempRect.top = (this.mTempRect.bottom - j);
        }
      }
      return f(paramInt, this.mTempRect.top, this.mTempRect.bottom);
    }
  }
  
  private boolean g(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool3 = false;
    getOverScrollMode();
    computeHorizontalScrollRange();
    computeHorizontalScrollExtent();
    computeVerticalScrollRange();
    computeVerticalScrollExtent();
    int i = paramInt2 + 0;
    paramInt2 = paramInt3 + paramInt1;
    paramInt3 = paramInt4 + 0;
    boolean bool1;
    if (i > 0)
    {
      paramInt1 = 0;
      bool1 = true;
    }
    for (;;)
    {
      boolean bool2;
      if (paramInt2 > paramInt3)
      {
        bool2 = true;
        paramInt2 = paramInt3;
      }
      for (;;)
      {
        if ((bool2) && (!au(1))) {
          this.jR.springBack(paramInt1, paramInt2, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(paramInt1, paramInt2, bool1, bool2);
        if (!bool1)
        {
          bool1 = bool3;
          if (!bool2) {}
        }
        else
        {
          bool1 = true;
        }
        return bool1;
        if (i >= 0) {
          break label153;
        }
        paramInt1 = 0;
        bool1 = true;
        break;
        if (paramInt2 < 0)
        {
          bool2 = true;
          paramInt2 = 0;
        }
        else
        {
          bool2 = false;
        }
      }
      label153:
      bool1 = false;
      paramInt1 = i;
    }
  }
  
  private float getVerticalScrollFactorCompat()
  {
    if (this.KW == 0.0F)
    {
      TypedValue localTypedValue = new TypedValue();
      Context localContext = getContext();
      if (!localContext.getTheme().resolveAttribute(16842829, localTypedValue, true)) {
        throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
      }
      this.KW = localTypedValue.getDimension(localContext.getResources().getDisplayMetrics());
    }
    return this.KW;
  }
  
  private boolean h(View paramView, int paramInt1, int paramInt2)
  {
    paramView.getDrawingRect(this.mTempRect);
    offsetDescendantRectToMyCoords(paramView, this.mTempRect);
    return (this.mTempRect.bottom + paramInt1 >= getScrollY()) && (this.mTempRect.top - paramInt1 <= getScrollY() + paramInt2);
  }
  
  private void onSecondaryPointerUp(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.mActivePointerId) {
      if (i != 0) {
        break label57;
      }
    }
    label57:
    for (i = 1;; i = 0)
    {
      this.jS = ((int)paramMotionEvent.getY(i));
      this.mActivePointerId = paramMotionEvent.getPointerId(i);
      if (this.mVelocityTracker != null) {
        this.mVelocityTracker.clear();
      }
      return;
    }
  }
  
  private boolean pageScroll(int paramInt)
  {
    int i;
    int j;
    if (paramInt == 130)
    {
      i = 1;
      j = getHeight();
      if (i == 0) {
        break label142;
      }
      this.mTempRect.top = (getScrollY() + j);
      i = getChildCount();
      if (i > 0)
      {
        View localView = getChildAt(i - 1);
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
        i = localView.getBottom();
        i = localLayoutParams.bottomMargin + i + getPaddingBottom();
        if (this.mTempRect.top + j > i) {
          this.mTempRect.top = (i - j);
        }
      }
    }
    for (;;)
    {
      this.mTempRect.bottom = (this.mTempRect.top + j);
      return f(paramInt, this.mTempRect.top, this.mTempRect.bottom);
      i = 0;
      break;
      label142:
      this.mTempRect.top = (getScrollY() - j);
      if (this.mTempRect.top < 0) {
        this.mTempRect.top = 0;
      }
    }
  }
  
  private boolean r(int paramInt1, int paramInt2)
  {
    return this.KV.r(paramInt1, paramInt2);
  }
  
  private void smoothScrollBy(int paramInt1, int paramInt2)
  {
    if (getChildCount() == 0) {
      return;
    }
    if (AnimationUtils.currentAnimationTimeMillis() - this.KF > 250L)
    {
      View localView = getChildAt(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
      int i = localView.getHeight();
      int j = localLayoutParams.topMargin;
      int k = localLayoutParams.bottomMargin;
      int m = getHeight();
      int n = getPaddingTop();
      int i1 = getPaddingBottom();
      paramInt1 = getScrollY();
      paramInt2 = Math.max(0, Math.min(paramInt1 + paramInt2, Math.max(0, k + (i + j) - (m - n - i1))));
      this.KQ = getScrollY();
      this.jR.startScroll(getScrollX(), paramInt1, 0, paramInt2 - paramInt1);
      t.R(this);
    }
    for (;;)
    {
      this.KF = AnimationUtils.currentAnimationTimeMillis();
      return;
      if (!this.jR.isFinished()) {
        this.jR.abortAnimation();
      }
      scrollBy(paramInt1, paramInt2);
    }
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    a(paramInt1, paramInt2, paramArrayOfInt, null, paramInt3);
  }
  
  public final void aH(int paramInt)
  {
    smoothScrollBy(0 - getScrollX(), paramInt - getScrollY());
  }
  
  public void addView(View paramView)
  {
    if (getChildCount() > 0) {
      throw new IllegalStateException("ScrollView can host only one direct child");
    }
    super.addView(paramView);
  }
  
  public void addView(View paramView, int paramInt)
  {
    if (getChildCount() > 0) {
      throw new IllegalStateException("ScrollView can host only one direct child");
    }
    super.addView(paramView, paramInt);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (getChildCount() > 0) {
      throw new IllegalStateException("ScrollView can host only one direct child");
    }
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (getChildCount() > 0) {
      throw new IllegalStateException("ScrollView can host only one direct child");
    }
    super.addView(paramView, paramLayoutParams);
  }
  
  public int computeHorizontalScrollExtent()
  {
    return super.computeHorizontalScrollExtent();
  }
  
  public int computeHorizontalScrollOffset()
  {
    return super.computeHorizontalScrollOffset();
  }
  
  public int computeHorizontalScrollRange()
  {
    return super.computeHorizontalScrollRange();
  }
  
  public void computeScroll()
  {
    int j = 0;
    if (this.jR.computeScrollOffset())
    {
      this.jR.getCurrX();
      int m = this.jR.getCurrY();
      int k = m - this.KQ;
      int i = k;
      if (a(0, k, this.KO, null, 1)) {
        i = k - this.KO[1];
      }
      int n;
      if (i != 0)
      {
        k = getScrollRange();
        n = getScrollY();
        g(i, getScrollX(), n, k);
        int i1 = getScrollY() - n;
        if (!a(0, i1, 0, i - i1, null, 1))
        {
          i1 = getOverScrollMode();
          if (i1 != 0)
          {
            i = j;
            if (i1 == 1)
            {
              i = j;
              if (k <= 0) {}
            }
          }
          else
          {
            i = 1;
          }
          if (i != 0)
          {
            ef();
            if ((m > 0) || (n <= 0)) {
              break label188;
            }
            this.KG.onAbsorb((int)this.jR.getCurrVelocity());
          }
        }
      }
      for (;;)
      {
        this.KQ = m;
        t.R(this);
        return;
        label188:
        if ((m >= k) && (n < k)) {
          this.KH.onAbsorb((int)this.jR.getCurrVelocity());
        }
      }
    }
    if (au(1)) {
      av(1);
    }
    this.KQ = 0;
  }
  
  public int computeVerticalScrollExtent()
  {
    return super.computeVerticalScrollExtent();
  }
  
  public int computeVerticalScrollOffset()
  {
    return Math.max(0, super.computeVerticalScrollOffset());
  }
  
  public int computeVerticalScrollRange()
  {
    int j = getChildCount();
    int i = getHeight() - getPaddingBottom() - getPaddingTop();
    if (j == 0) {}
    int k;
    int m;
    do
    {
      return i;
      View localView = getChildAt(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
      j = localView.getBottom();
      j = localLayoutParams.bottomMargin + j;
      k = getScrollY();
      m = Math.max(0, j - i);
      if (k < 0) {
        return j - k;
      }
      i = j;
    } while (k <= m);
    return j + (k - m);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (super.dispatchKeyEvent(paramKeyEvent)) || (executeKeyEvent(paramKeyEvent));
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return this.KV.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return this.KV.dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return a(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, 0);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return a(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, 0);
  }
  
  public void draw(Canvas paramCanvas)
  {
    int n = 0;
    super.draw(paramCanvas);
    int i3;
    int i4;
    int j;
    int i2;
    int i1;
    if (this.KG != null)
    {
      i3 = getScrollY();
      if (!this.KG.isFinished())
      {
        i4 = paramCanvas.save();
        j = getWidth();
        i2 = getHeight();
        i1 = Math.min(0, i3);
        if ((Build.VERSION.SDK_INT >= 21) && (!getClipToPadding())) {
          break label374;
        }
        j -= getPaddingLeft() + getPaddingRight();
      }
    }
    label374:
    for (int i = getPaddingLeft() + 0;; i = 0)
    {
      int m = i1;
      int k = i2;
      if (Build.VERSION.SDK_INT >= 21)
      {
        m = i1;
        k = i2;
        if (getClipToPadding())
        {
          k = i2 - (getPaddingTop() + getPaddingBottom());
          m = i1 + getPaddingTop();
        }
      }
      paramCanvas.translate(i, m);
      this.KG.setSize(j, k);
      if (this.KG.draw(paramCanvas)) {
        t.R(this);
      }
      paramCanvas.restoreToCount(i4);
      if (!this.KH.isFinished())
      {
        i4 = paramCanvas.save();
        k = getWidth();
        i1 = getHeight();
        i2 = Math.max(getScrollRange(), i3) + i1;
        if (Build.VERSION.SDK_INT >= 21)
        {
          i = k;
          j = n;
          if (!getClipToPadding()) {}
        }
        else
        {
          i = k - (getPaddingLeft() + getPaddingRight());
          j = getPaddingLeft() + 0;
        }
        m = i2;
        k = i1;
        if (Build.VERSION.SDK_INT >= 21)
        {
          m = i2;
          k = i1;
          if (getClipToPadding())
          {
            k = i1 - (getPaddingTop() + getPaddingBottom());
            m = i2 - getPaddingBottom();
          }
        }
        paramCanvas.translate(j - i, m);
        paramCanvas.rotate(180.0F, i, 0.0F);
        this.KH.setSize(i, k);
        if (this.KH.draw(paramCanvas)) {
          t.R(this);
        }
        paramCanvas.restoreToCount(i4);
      }
      return;
    }
  }
  
  public final boolean e(View paramView, int paramInt1, int paramInt2)
  {
    return (paramInt1 & 0x2) != 0;
  }
  
  public final boolean executeKeyEvent(KeyEvent paramKeyEvent)
  {
    int i = 33;
    boolean bool2 = false;
    this.mTempRect.setEmpty();
    boolean bool1;
    if (!dI())
    {
      bool1 = bool2;
      if (isFocused())
      {
        bool1 = bool2;
        if (paramKeyEvent.getKeyCode() != 4)
        {
          View localView = findFocus();
          paramKeyEvent = localView;
          if (localView == this) {
            paramKeyEvent = null;
          }
          paramKeyEvent = FocusFinder.getInstance().findNextFocus(this, paramKeyEvent, 130);
          bool1 = bool2;
          if (paramKeyEvent != null)
          {
            bool1 = bool2;
            if (paramKeyEvent != this)
            {
              bool1 = bool2;
              if (paramKeyEvent.requestFocus(130)) {
                bool1 = true;
              }
            }
          }
        }
      }
      return bool1;
    }
    if (paramKeyEvent.getAction() == 0) {}
    switch (paramKeyEvent.getKeyCode())
    {
    default: 
      bool1 = false;
    case 19: 
    case 20: 
      for (;;)
      {
        return bool1;
        if (!paramKeyEvent.isAltPressed())
        {
          bool1 = arrowScroll(33);
        }
        else
        {
          bool1 = fullScroll(33);
          continue;
          if (!paramKeyEvent.isAltPressed()) {
            bool1 = arrowScroll(130);
          } else {
            bool1 = fullScroll(130);
          }
        }
      }
    }
    if (paramKeyEvent.isShiftPressed()) {}
    for (;;)
    {
      pageScroll(i);
      break;
      i = 130;
    }
  }
  
  public final void f(View paramView, int paramInt1, int paramInt2)
  {
    this.KU.Gd = paramInt1;
    r(2, paramInt2);
  }
  
  public void fling(int paramInt)
  {
    if (getChildCount() > 0)
    {
      r(2, 1);
      this.jR.fling(getScrollX(), getScrollY(), 0, paramInt, 0, 0, -2147483648, 2147483647, 0, 0);
      this.KQ = getScrollY();
      t.R(this);
    }
  }
  
  protected float getBottomFadingEdgeStrength()
  {
    if (getChildCount() == 0) {
      return 0.0F;
    }
    View localView = getChildAt(0);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
    int i = getVerticalFadingEdgeLength();
    int j = getHeight();
    int k = getPaddingBottom();
    int m = localView.getBottom();
    j = localLayoutParams.bottomMargin + m - getScrollY() - (j - k);
    if (j < i) {
      return j / i;
    }
    return 1.0F;
  }
  
  public int getMaxScrollAmount()
  {
    return (int)(0.5F * getHeight());
  }
  
  public int getNestedScrollAxes()
  {
    return this.KU.Gd;
  }
  
  int getScrollRange()
  {
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
      int i = localView.getHeight();
      int j = localLayoutParams.topMargin;
      return Math.max(0, localLayoutParams.bottomMargin + (i + j) - (getHeight() - getPaddingTop() - getPaddingBottom()));
    }
    return 0;
  }
  
  protected float getTopFadingEdgeStrength()
  {
    if (getChildCount() == 0) {
      return 0.0F;
    }
    int i = getVerticalFadingEdgeLength();
    int j = getScrollY();
    if (j < i) {
      return j / i;
    }
    return 1.0F;
  }
  
  public final void h(int paramInt1, int paramInt2)
  {
    int i = getScrollY();
    scrollBy(0, paramInt1);
    i = getScrollY() - i;
    a(0, i, 0, paramInt1 - i, null, paramInt2);
  }
  
  public boolean hasNestedScrollingParent()
  {
    return au(0);
  }
  
  public final void i(View paramView, int paramInt)
  {
    this.KU.Gd = 0;
    av(paramInt);
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return this.KV.Ga;
  }
  
  protected void measureChild(View paramView, int paramInt1, int paramInt2)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    paramView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight(), localLayoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
  }
  
  protected void measureChildWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    paramInt1 = getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin + paramInt2, localMarginLayoutParams.width);
    paramInt2 = localMarginLayoutParams.topMargin;
    paramView.measure(paramInt1, View.MeasureSpec.makeMeasureSpec(localMarginLayoutParams.bottomMargin + paramInt2, 0));
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.KJ = false;
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getSource() & 0x2) != 0) {
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      return false;
      if (!this.mIsBeingDragged)
      {
        float f = paramMotionEvent.getAxisValue(9);
        if (f != 0.0F)
        {
          int i = (int)(f * getVerticalScrollFactorCompat());
          int j = getScrollRange();
          int m = getScrollY();
          int k = m - i;
          if (k < 0) {
            i = 0;
          }
          while (i != m)
          {
            super.scrollTo(getScrollX(), i);
            return true;
            i = j;
            if (k <= j) {
              i = k;
            }
          }
        }
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    int i = paramMotionEvent.getAction();
    if ((i == 2) && (this.mIsBeingDragged)) {
      return true;
    }
    switch (i & 0xFF)
    {
    }
    for (;;)
    {
      return this.mIsBeingDragged;
      i = this.mActivePointerId;
      if (i != -1)
      {
        int j = paramMotionEvent.findPointerIndex(i);
        if (j == -1)
        {
          new StringBuilder("Invalid pointerId=").append(i).append(" in onInterceptTouchEvent");
        }
        else
        {
          i = (int)paramMotionEvent.getY(j);
          if ((Math.abs(i - this.jS) > this.mTouchSlop) && ((getNestedScrollAxes() & 0x2) == 0))
          {
            this.mIsBeingDragged = true;
            this.jS = i;
            ed();
            this.mVelocityTracker.addMovement(paramMotionEvent);
            this.KP = 0;
            paramMotionEvent = getParent();
            if (paramMotionEvent != null)
            {
              paramMotionEvent.requestDisallowInterceptTouchEvent(true);
              continue;
              j = (int)paramMotionEvent.getY();
              i = (int)paramMotionEvent.getX();
              if (getChildCount() > 0)
              {
                int k = getScrollY();
                View localView = getChildAt(0);
                if ((j >= localView.getTop() - k) && (j < localView.getBottom() - k) && (i >= localView.getLeft()) && (i < localView.getRight())) {
                  i = 1;
                }
              }
              for (;;)
              {
                if (i != 0) {
                  break label298;
                }
                this.mIsBeingDragged = false;
                ee();
                break;
                i = 0;
                continue;
                i = 0;
              }
              label298:
              this.jS = j;
              this.mActivePointerId = paramMotionEvent.getPointerId(0);
              if (this.mVelocityTracker == null)
              {
                this.mVelocityTracker = VelocityTracker.obtain();
                label326:
                this.mVelocityTracker.addMovement(paramMotionEvent);
                this.jR.computeScrollOffset();
                if (this.jR.isFinished()) {
                  break label378;
                }
              }
              for (;;)
              {
                this.mIsBeingDragged = bool;
                r(2, 0);
                break;
                this.mVelocityTracker.clear();
                break label326;
                label378:
                bool = false;
              }
              this.mIsBeingDragged = false;
              this.mActivePointerId = -1;
              ee();
              if (this.jR.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                t.R(this);
              }
              av(0);
              continue;
              onSecondaryPointerUp(paramMotionEvent);
            }
          }
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 0;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.KI = false;
    if ((this.KK != null) && (b(this.KK, this))) {
      aN(this.KK);
    }
    this.KK = null;
    if (!this.KJ)
    {
      if (this.KR != null)
      {
        scrollTo(getScrollX(), this.KR.KY);
        this.KR = null;
      }
      paramInt1 = i;
      if (getChildCount() > 0)
      {
        View localView = getChildAt(0);
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
        paramInt1 = localView.getMeasuredHeight();
        paramInt3 = localLayoutParams.topMargin;
        paramInt1 = localLayoutParams.bottomMargin + (paramInt1 + paramInt3);
      }
      i = getPaddingTop();
      int j = getPaddingBottom();
      paramInt3 = getScrollY();
      paramInt1 = clamp(paramInt3, paramInt4 - paramInt2 - i - j, paramInt1);
      if (paramInt1 != paramInt3) {
        scrollTo(getScrollX(), paramInt1);
      }
    }
    scrollTo(getScrollX(), getScrollY());
    this.KJ = true;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (!this.KL) {}
    View localView;
    FrameLayout.LayoutParams localLayoutParams;
    int i;
    do
    {
      do
      {
        return;
      } while ((View.MeasureSpec.getMode(paramInt2) == 0) || (getChildCount() <= 0));
      localView = getChildAt(0);
      localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
      paramInt2 = localView.getMeasuredHeight();
      i = getMeasuredHeight() - getPaddingTop() - getPaddingBottom() - localLayoutParams.topMargin - localLayoutParams.bottomMargin;
    } while (paramInt2 >= i);
    localView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + localLayoutParams.leftMargin + localLayoutParams.rightMargin, localLayoutParams.width), View.MeasureSpec.makeMeasureSpec(i, 1073741824));
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      aI((int)paramFloat2);
      return true;
    }
    return false;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    a(paramView, paramInt1, paramInt2, paramArrayOfInt, 0);
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    h(paramInt4, 0);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    f(paramView2, paramInt, 0);
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.scrollTo(paramInt1, paramInt2);
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int i;
    View localView;
    if (paramInt == 2)
    {
      i = 130;
      if (paramRect != null) {
        break label44;
      }
      localView = FocusFinder.getInstance().findNextFocus(this, null, i);
      label24:
      if (localView != null) {
        break label58;
      }
    }
    label44:
    label58:
    while (aM(localView))
    {
      return false;
      i = paramInt;
      if (paramInt != 1) {
        break;
      }
      i = 33;
      break;
      localView = FocusFinder.getInstance().findNextFocusFromRect(this, paramRect, i);
      break label24;
    }
    return localView.requestFocus(i, paramRect);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.KR = paramParcelable;
    requestLayout();
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.KY = getScrollY();
    return localSavedState;
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.KX != null) {
      this.KX.a(this);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = findFocus();
    if ((localView == null) || (this == localView)) {}
    while (!h(localView, 0, paramInt4)) {
      return;
    }
    localView.getDrawingRect(this.mTempRect);
    offsetDescendantRectToMyCoords(localView, this.mTempRect);
    aG(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return e(paramView1, paramInt, 0);
  }
  
  public void onStopNestedScroll(View paramView)
  {
    i(paramView, 0);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    ed();
    MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      this.KP = 0;
    }
    localMotionEvent.offsetLocation(0.0F, this.KP);
    int k;
    int m;
    int j;
    switch (i)
    {
    case 4: 
    default: 
    case 0: 
    case 2: 
      ViewParent localViewParent;
      for (;;)
      {
        if (this.mVelocityTracker != null) {
          this.mVelocityTracker.addMovement(localMotionEvent);
        }
        localMotionEvent.recycle();
        return true;
        if (getChildCount() == 0) {
          return false;
        }
        if (!this.jR.isFinished()) {}
        for (boolean bool = true;; bool = false)
        {
          this.mIsBeingDragged = bool;
          if (bool)
          {
            localViewParent = getParent();
            if (localViewParent != null) {
              localViewParent.requestDisallowInterceptTouchEvent(true);
            }
          }
          if (!this.jR.isFinished()) {
            this.jR.abortAnimation();
          }
          this.jS = ((int)paramMotionEvent.getY());
          this.mActivePointerId = paramMotionEvent.getPointerId(0);
          r(2, 0);
          break;
        }
        k = paramMotionEvent.findPointerIndex(this.mActivePointerId);
        if (k != -1) {
          break;
        }
        new StringBuilder("Invalid pointerId=").append(this.mActivePointerId).append(" in onTouchEvent");
      }
      m = (int)paramMotionEvent.getY(k);
      j = this.jS - m;
      i = j;
      if (a(0, j, this.KO, this.KN, 0))
      {
        i = j - this.KO[1];
        localMotionEvent.offsetLocation(0.0F, this.KN[1]);
        this.KP += this.KN[1];
      }
      if ((!this.mIsBeingDragged) && (Math.abs(i) > this.mTouchSlop))
      {
        localViewParent = getParent();
        if (localViewParent != null) {
          localViewParent.requestDisallowInterceptTouchEvent(true);
        }
        this.mIsBeingDragged = true;
        if (i > 0) {
          i -= this.mTouchSlop;
        }
      }
      break;
    }
    label376:
    while (this.mIsBeingDragged)
    {
      this.jS = (m - this.KN[1]);
      int n = getScrollY();
      m = getScrollRange();
      j = getOverScrollMode();
      if ((j == 0) || ((j == 1) && (m > 0))) {}
      for (j = 1;; j = 0)
      {
        if ((g(i, 0, getScrollY(), m)) && (!au(0))) {
          this.mVelocityTracker.clear();
        }
        int i1 = getScrollY() - n;
        if (!a(0, i1, 0, i - i1, this.KN, 0)) {
          break label549;
        }
        this.jS -= this.KN[1];
        localMotionEvent.offsetLocation(0.0F, this.KN[1]);
        this.KP += this.KN[1];
        break;
        i += this.mTouchSlop;
        break label376;
      }
      if (j == 0) {
        break;
      }
      ef();
      j = n + i;
      if (j < 0)
      {
        i.a(this.KG, i / getHeight(), paramMotionEvent.getX(k) / getWidth());
        if (!this.KH.isFinished()) {
          this.KH.onRelease();
        }
      }
      while ((this.KG != null) && ((!this.KG.isFinished()) || (!this.KH.isFinished())))
      {
        t.R(this);
        break;
        if (j > m)
        {
          i.a(this.KH, i / getHeight(), 1.0F - paramMotionEvent.getX(k) / getWidth());
          if (!this.KG.isFinished()) {
            this.KG.onRelease();
          }
        }
      }
      paramMotionEvent = this.mVelocityTracker;
      paramMotionEvent.computeCurrentVelocity(1000, this.mMaximumVelocity);
      i = (int)paramMotionEvent.getYVelocity(this.mActivePointerId);
      if (Math.abs(i) > this.mMinimumVelocity) {
        aI(-i);
      }
      for (;;)
      {
        this.mActivePointerId = -1;
        endDrag();
        break;
        if (this.jR.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
          t.R(this);
        }
      }
      if ((this.mIsBeingDragged) && (getChildCount() > 0) && (this.jR.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()))) {
        t.R(this);
      }
      this.mActivePointerId = -1;
      endDrag();
      break;
      i = paramMotionEvent.getActionIndex();
      this.jS = ((int)paramMotionEvent.getY(i));
      this.mActivePointerId = paramMotionEvent.getPointerId(i);
      break;
      onSecondaryPointerUp(paramMotionEvent);
      this.jS = ((int)paramMotionEvent.getY(paramMotionEvent.findPointerIndex(this.mActivePointerId)));
      break;
    }
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    if (!this.KI) {
      aN(paramView2);
    }
    for (;;)
    {
      super.requestChildFocus(paramView1, paramView2);
      return;
      this.KK = paramView2;
    }
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    paramRect.offset(paramView.getLeft() - paramView.getScrollX(), paramView.getTop() - paramView.getScrollY());
    int i = computeScrollDeltaToGetChildRectOnScreen(paramRect);
    if (i != 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        if (!paramBoolean) {
          break;
        }
        scrollBy(0, i);
      }
      return bool;
    }
    smoothScrollBy(0, i);
    return bool;
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (paramBoolean) {
      ee();
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void requestLayout()
  {
    this.KI = true;
    super.requestLayout();
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
      int i2 = getWidth();
      int i3 = getPaddingLeft();
      int i4 = getPaddingRight();
      int i5 = localView.getWidth();
      int i6 = localLayoutParams.leftMargin;
      int i7 = localLayoutParams.rightMargin;
      int i = getHeight();
      int j = getPaddingTop();
      int k = getPaddingBottom();
      int m = localView.getHeight();
      int n = localLayoutParams.topMargin;
      int i1 = localLayoutParams.bottomMargin;
      paramInt1 = clamp(paramInt1, i2 - i3 - i4, i5 + i6 + i7);
      paramInt2 = clamp(paramInt2, i - j - k, i1 + (m + n));
      if ((paramInt1 != getScrollX()) || (paramInt2 != getScrollY())) {
        super.scrollTo(paramInt1, paramInt2);
      }
    }
  }
  
  public void setFillViewport(boolean paramBoolean)
  {
    if (paramBoolean != this.KL)
    {
      this.KL = paramBoolean;
      requestLayout();
    }
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    this.KV.setNestedScrollingEnabled(paramBoolean);
  }
  
  public void setOnScrollChangeListener(b paramb)
  {
    this.KX = paramb;
  }
  
  public void setSmoothScrollingEnabled(boolean paramBoolean)
  {
    this.KM = paramBoolean;
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return true;
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return r(paramInt, 0);
  }
  
  public void stopNestedScroll()
  {
    av(0);
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
    public int KY;
    
    SavedState(Parcel paramParcel)
    {
      super();
      this.KY = paramParcel.readInt();
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.KY + "}";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.KY);
    }
  }
  
  static final class a
    extends a
  {
    public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramView = (NestedScrollView)paramView;
      paramAccessibilityEvent.setClassName(ScrollView.class.getName());
      if (paramView.getScrollRange() > 0) {}
      for (boolean bool = true;; bool = false)
      {
        paramAccessibilityEvent.setScrollable(bool);
        paramAccessibilityEvent.setScrollX(paramView.getScrollX());
        paramAccessibilityEvent.setScrollY(paramView.getScrollY());
        int i = paramView.getScrollX();
        if (Build.VERSION.SDK_INT >= 15) {
          paramAccessibilityEvent.setMaxScrollX(i);
        }
        i = paramView.getScrollRange();
        if (Build.VERSION.SDK_INT >= 15) {
          paramAccessibilityEvent.setMaxScrollY(i);
        }
        return;
      }
    }
    
    public final void onInitializeAccessibilityNodeInfo(View paramView, b paramb)
    {
      super.onInitializeAccessibilityNodeInfo(paramView, paramb);
      paramView = (NestedScrollView)paramView;
      paramb.setClassName(ScrollView.class.getName());
      if (paramView.isEnabled())
      {
        int i = paramView.getScrollRange();
        if (i > 0)
        {
          paramb.setScrollable(true);
          if (paramView.getScrollY() > 0) {
            paramb.addAction(8192);
          }
          if (paramView.getScrollY() < i) {
            paramb.addAction(4096);
          }
        }
      }
    }
    
    public final boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
    {
      if (super.performAccessibilityAction(paramView, paramInt, paramBundle)) {
        return true;
      }
      paramView = (NestedScrollView)paramView;
      if (!paramView.isEnabled()) {
        return false;
      }
      switch (paramInt)
      {
      default: 
        return false;
      case 4096: 
        paramInt = Math.min(paramView.getHeight() - paramView.getPaddingBottom() - paramView.getPaddingTop() + paramView.getScrollY(), paramView.getScrollRange());
        if (paramInt != paramView.getScrollY())
        {
          paramView.aH(paramInt);
          return true;
        }
        return false;
      }
      paramInt = paramView.getHeight();
      int i = paramView.getPaddingBottom();
      int j = paramView.getPaddingTop();
      paramInt = Math.max(paramView.getScrollY() - (paramInt - i - j), 0);
      if (paramInt != paramView.getScrollY())
      {
        paramView.aH(paramInt);
        return true;
      }
      return false;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(NestedScrollView paramNestedScrollView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.widget.NestedScrollView
 * JD-Core Version:    0.7.0.1
 */