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
import android.support.v4.view.h;
import android.support.v4.view.j;
import android.support.v4.view.l;
import android.support.v4.view.q;
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
  implements h, j
{
  private static final a Lh = new a();
  private static final int[] Li = { 16843130 };
  private int GU;
  private int GV;
  private long KU;
  private EdgeEffect KV;
  private EdgeEffect KW;
  private boolean KX = true;
  private boolean KY = false;
  private View KZ = null;
  private boolean La;
  private boolean Lb = true;
  private final int[] Lc = new int[2];
  private final int[] Ld = new int[2];
  private int Le;
  private int Lf;
  private SavedState Lg;
  private final l Lj;
  private final android.support.v4.view.i Lk;
  private float Ll;
  private b Lm;
  private final Rect ec = new Rect();
  private VelocityTracker fB;
  private int fC = -1;
  private OverScroller iY = new OverScroller(getContext());
  private boolean iZ = false;
  private int ja;
  private int jb;
  
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
    this.jb = localViewConfiguration.getScaledTouchSlop();
    this.GU = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.GV = localViewConfiguration.getScaledMaximumFlingVelocity();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, Li, paramInt, 0);
    setFillViewport(paramContext.getBoolean(0, false));
    paramContext.recycle();
    this.Lj = new l(this);
    this.Lk = new android.support.v4.view.i(this);
    setNestedScrollingEnabled(true);
    q.a(this, Lh);
  }
  
  private boolean a(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    return this.Lk.a(0, paramInt1, 0, paramInt2, paramArrayOfInt, paramInt3);
  }
  
  private boolean a(int paramInt1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt2)
  {
    return this.Lk.a(0, paramInt1, paramArrayOfInt1, paramArrayOfInt2, paramInt2);
  }
  
  private boolean aF(View paramView)
  {
    boolean bool = false;
    if (!d(paramView, 0, getHeight())) {
      bool = true;
    }
    return bool;
  }
  
  private void aG(View paramView)
  {
    paramView.getDrawingRect(this.ec);
    offsetDescendantRectToMyCoords(paramView, this.ec);
    int i = computeScrollDeltaToGetChildRectOnScreen(this.ec);
    if (i != 0) {
      scrollBy(0, i);
    }
  }
  
  private boolean aJ(int paramInt)
  {
    return this.Lk.r(2, paramInt);
  }
  
  private void aK(int paramInt)
  {
    if (paramInt != 0)
    {
      if (this.Lb) {
        smoothScrollBy(0, paramInt);
      }
    }
    else {
      return;
    }
    scrollBy(0, paramInt);
  }
  
  private void aM(int paramInt)
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
  
  private boolean arrowScroll(int paramInt)
  {
    View localView2 = findFocus();
    View localView1 = localView2;
    if (localView2 == this) {
      localView1 = null;
    }
    localView2 = FocusFinder.getInstance().findNextFocus(this, localView1, paramInt);
    int j = getMaxScrollAmount();
    if ((localView2 != null) && (d(localView2, j, getHeight())))
    {
      localView2.getDrawingRect(this.ec);
      offsetDescendantRectToMyCoords(localView2, this.ec);
      aK(computeScrollDeltaToGetChildRectOnScreen(this.ec));
      localView2.requestFocus(paramInt);
      if ((localView1 != null) && (localView1.isFocused()) && (aF(localView1)))
      {
        paramInt = getDescendantFocusability();
        setDescendantFocusability(131072);
        requestFocus();
        setDescendantFocusability(paramInt);
      }
      return true;
    }
    int i;
    if ((paramInt == 33) && (getScrollY() < j)) {
      i = getScrollY();
    }
    while (i == 0)
    {
      return false;
      i = j;
      if (paramInt == 130)
      {
        i = j;
        if (getChildCount() > 0)
        {
          int k = getChildAt(0).getBottom();
          int m = getScrollY() + getHeight() - getPaddingBottom();
          i = j;
          if (k - m < j) {
            i = k - m;
          }
        }
      }
    }
    if (paramInt == 130) {}
    for (;;)
    {
      aK(i);
      break;
      i = -i;
    }
  }
  
  private boolean au(int paramInt)
  {
    return this.Lk.au(paramInt);
  }
  
  private void av(int paramInt)
  {
    this.Lk.av(paramInt);
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
    int n = getVerticalFadingEdgeLength();
    int j = i;
    if (paramRect.top > 0) {
      j = i + n;
    }
    i = k;
    if (paramRect.bottom < getChildAt(0).getHeight()) {
      i = k - n;
    }
    if ((paramRect.bottom > i) && (paramRect.top > j)) {
      if (paramRect.height() > m)
      {
        j = paramRect.top - j + 0;
        i = Math.min(j, getChildAt(0).getBottom() - i);
      }
    }
    for (;;)
    {
      return i;
      j = paramRect.bottom - i + 0;
      break;
      if ((paramRect.top < j) && (paramRect.bottom < i))
      {
        if (paramRect.height() > m) {}
        for (i = 0 - (i - paramRect.bottom);; i = 0 - (j - paramRect.top))
        {
          i = Math.max(i, -getScrollY());
          break;
        }
      }
      i = 0;
    }
  }
  
  private void d(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.fC) {
      if (i != 0) {
        break label57;
      }
    }
    label57:
    for (i = 1;; i = 0)
    {
      this.ja = ((int)paramMotionEvent.getY(i));
      this.fC = paramMotionEvent.getPointerId(i);
      if (this.fB != null) {
        this.fB.clear();
      }
      return;
    }
  }
  
  private boolean d(View paramView, int paramInt1, int paramInt2)
  {
    paramView.getDrawingRect(this.ec);
    offsetDescendantRectToMyCoords(paramView, this.ec);
    return (this.ec.bottom + paramInt1 >= getScrollY()) && (this.ec.top - paramInt1 <= getScrollY() + paramInt2);
  }
  
  private void dM()
  {
    if (this.fB == null) {
      this.fB = VelocityTracker.obtain();
    }
  }
  
  private void dN()
  {
    if (this.fB != null)
    {
      this.fB.recycle();
      this.fB = null;
    }
  }
  
  private void dO()
  {
    this.iZ = false;
    dN();
    av(0);
    if (this.KV != null)
    {
      this.KV.onRelease();
      this.KW.onRelease();
    }
  }
  
  private void dP()
  {
    if (getOverScrollMode() != 2)
    {
      if (this.KV == null)
      {
        Context localContext = getContext();
        this.KV = new EdgeEffect(localContext);
        this.KW = new EdgeEffect(localContext);
      }
      return;
    }
    this.KV = null;
    this.KW = null;
  }
  
  private boolean f(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = getHeight();
    int i1 = getScrollY();
    int i2 = i1 + i;
    int k;
    Object localObject1;
    int m;
    label53:
    Object localObject2;
    int n;
    int i4;
    int j;
    if (paramInt1 == 33)
    {
      k = 1;
      ArrayList localArrayList = getFocusables(2);
      localObject1 = null;
      i = 0;
      int i3 = localArrayList.size();
      m = 0;
      if (m >= i3) {
        break label237;
      }
      localObject2 = (View)localArrayList.get(m);
      n = ((View)localObject2).getTop();
      i4 = ((View)localObject2).getBottom();
      if ((paramInt2 >= i4) || (n >= paramInt3)) {
        break label312;
      }
      if ((paramInt2 >= n) || (i4 >= paramInt3)) {
        break label143;
      }
      j = 1;
      label115:
      if (localObject1 != null) {
        break label149;
      }
      i = j;
      localObject1 = localObject2;
    }
    label143:
    label149:
    label312:
    for (;;)
    {
      m += 1;
      break label53;
      k = 0;
      break;
      j = 0;
      break label115;
      if (((k != 0) && (n < localObject1.getTop())) || ((k == 0) && (i4 > localObject1.getBottom()))) {}
      for (n = 1;; n = 0)
      {
        if (i == 0) {
          break label210;
        }
        if ((j == 0) || (n == 0)) {
          break label312;
        }
        localObject1 = localObject2;
        break;
      }
      label210:
      if (j != 0)
      {
        i = 1;
        localObject1 = localObject2;
      }
      else if (n != 0)
      {
        localObject1 = localObject2;
        continue;
        label237:
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = this;
        }
        boolean bool;
        if ((paramInt2 >= i1) && (paramInt3 <= i2))
        {
          bool = false;
          if (localObject2 != findFocus()) {
            ((View)localObject2).requestFocus(paramInt1);
          }
          return bool;
        }
        if (k != 0) {
          paramInt2 -= i1;
        }
        for (;;)
        {
          aK(paramInt2);
          bool = true;
          break;
          paramInt2 = paramInt3 - i2;
        }
      }
    }
  }
  
  private boolean fullScroll(int paramInt)
  {
    if (paramInt == 130) {}
    for (int i = 1;; i = 0)
    {
      int j = getHeight();
      this.ec.top = 0;
      this.ec.bottom = j;
      if (i != 0)
      {
        i = getChildCount();
        if (i > 0)
        {
          View localView = getChildAt(i - 1);
          this.ec.bottom = (localView.getBottom() + getPaddingBottom());
          this.ec.top = (this.ec.bottom - j);
        }
      }
      return f(paramInt, this.ec.top, this.ec.bottom);
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
          this.iY.springBack(paramInt1, paramInt2, 0, 0, 0, getScrollRange());
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
    if (this.Ll == 0.0F)
    {
      TypedValue localTypedValue = new TypedValue();
      Context localContext = getContext();
      if (!localContext.getTheme().resolveAttribute(16842829, localTypedValue, true)) {
        throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
      }
      this.Ll = localTypedValue.getDimension(localContext.getResources().getDisplayMetrics());
    }
    return this.Ll;
  }
  
  private void smoothScrollBy(int paramInt1, int paramInt2)
  {
    if (getChildCount() == 0) {
      return;
    }
    if (AnimationUtils.currentAnimationTimeMillis() - this.KU > 250L)
    {
      paramInt1 = getHeight();
      int i = getPaddingBottom();
      int j = getPaddingTop();
      i = Math.max(0, getChildAt(0).getHeight() - (paramInt1 - i - j));
      paramInt1 = getScrollY();
      paramInt2 = Math.max(0, Math.min(paramInt1 + paramInt2, i));
      this.iY.startScroll(getScrollX(), paramInt1, 0, paramInt2 - paramInt1);
      q.O(this);
    }
    for (;;)
    {
      this.KU = AnimationUtils.currentAnimationTimeMillis();
      return;
      if (!this.iY.isFinished()) {
        this.iY.abortAnimation();
      }
      scrollBy(paramInt1, paramInt2);
    }
  }
  
  public final void aL(int paramInt)
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
    if (this.iY.computeScrollOffset())
    {
      this.iY.getCurrX();
      int m = this.iY.getCurrY();
      int k = m - this.Lf;
      int i = k;
      if (a(k, this.Ld, null, 1)) {
        i = k - this.Ld[1];
      }
      int n;
      if (i != 0)
      {
        k = getScrollRange();
        n = getScrollY();
        g(i, getScrollX(), n, k);
        int i1 = getScrollY() - n;
        if (!a(i1, i - i1, null, 1))
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
            dP();
            if ((m > 0) || (n <= 0)) {
              break label185;
            }
            this.KV.onAbsorb((int)this.iY.getCurrVelocity());
          }
        }
      }
      for (;;)
      {
        this.Lf = m;
        q.O(this);
        return;
        label185:
        if ((m >= k) && (n < k)) {
          this.KW.onAbsorb((int)this.iY.getCurrVelocity());
        }
      }
    }
    if (au(1)) {
      av(1);
    }
    this.Lf = 0;
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
      j = getChildAt(0).getBottom();
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
    return this.Lk.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return this.Lk.dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return this.Lk.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return this.Lk.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
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
    if (this.KV != null)
    {
      i3 = getScrollY();
      if (!this.KV.isFinished())
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
      this.KV.setSize(j, k);
      if (this.KV.draw(paramCanvas)) {
        q.O(this);
      }
      paramCanvas.restoreToCount(i4);
      if (!this.KW.isFinished())
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
        this.KW.setSize(i, k);
        if (this.KW.draw(paramCanvas)) {
          q.O(this);
        }
        paramCanvas.restoreToCount(i4);
      }
      return;
    }
  }
  
  public final boolean executeKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    this.ec.setEmpty();
    View localView = getChildAt(0);
    int i;
    boolean bool1;
    if (localView != null)
    {
      i = localView.getHeight();
      if (getHeight() < i + getPaddingTop() + getPaddingBottom())
      {
        i = 1;
        if (i != 0) {
          break label151;
        }
        bool1 = bool2;
        if (isFocused())
        {
          bool1 = bool2;
          if (paramKeyEvent.getKeyCode() != 4)
          {
            localView = findFocus();
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
      }
    }
    label151:
    do
    {
      return bool1;
      i = 0;
      break;
      i = 0;
      break;
      bool1 = bool2;
    } while (paramKeyEvent.getAction() != 0);
    switch (paramKeyEvent.getKeyCode())
    {
    default: 
      return false;
    case 19: 
      if (!paramKeyEvent.isAltPressed()) {
        return arrowScroll(33);
      }
      return fullScroll(33);
    case 20: 
      if (!paramKeyEvent.isAltPressed()) {
        return arrowScroll(130);
      }
      return fullScroll(130);
    }
    int j;
    label265:
    int k;
    if (paramKeyEvent.isShiftPressed())
    {
      i = 33;
      if (i != 130) {
        break label383;
      }
      j = 1;
      k = getHeight();
      if (j == 0) {
        break label388;
      }
      this.ec.top = (getScrollY() + k);
      j = getChildCount();
      if (j > 0)
      {
        paramKeyEvent = getChildAt(j - 1);
        if (this.ec.top + k > paramKeyEvent.getBottom()) {
          this.ec.top = (paramKeyEvent.getBottom() - k);
        }
      }
    }
    for (;;)
    {
      this.ec.bottom = (k + this.ec.top);
      f(i, this.ec.top, this.ec.bottom);
      return false;
      i = 130;
      break;
      label383:
      j = 0;
      break label265;
      label388:
      this.ec.top = (getScrollY() - k);
      if (this.ec.top < 0) {
        this.ec.top = 0;
      }
    }
  }
  
  public void fling(int paramInt)
  {
    if (getChildCount() > 0)
    {
      aJ(1);
      this.iY.fling(getScrollX(), getScrollY(), 0, paramInt, 0, 0, -2147483648, 2147483647, 0, 0);
      this.Lf = getScrollY();
      q.O(this);
    }
  }
  
  protected float getBottomFadingEdgeStrength()
  {
    if (getChildCount() == 0) {
      return 0.0F;
    }
    int i = getVerticalFadingEdgeLength();
    int j = getHeight();
    int k = getPaddingBottom();
    j = getChildAt(0).getBottom() - getScrollY() - (j - k);
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
    return this.Lj.Fs;
  }
  
  int getScrollRange()
  {
    int i = 0;
    if (getChildCount() > 0) {
      i = Math.max(0, getChildAt(0).getHeight() - (getHeight() - getPaddingBottom() - getPaddingTop()));
    }
    return i;
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
  
  public boolean hasNestedScrollingParent()
  {
    return this.Lk.au(0);
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return this.Lk.Fp;
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
    this.KY = false;
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
      if (!this.iZ)
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
    if ((i == 2) && (this.iZ)) {
      return true;
    }
    switch (i & 0xFF)
    {
    }
    for (;;)
    {
      return this.iZ;
      i = this.fC;
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
          if ((Math.abs(i - this.ja) > this.jb) && ((getNestedScrollAxes() & 0x2) == 0))
          {
            this.iZ = true;
            this.ja = i;
            dM();
            this.fB.addMovement(paramMotionEvent);
            this.Le = 0;
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
                this.iZ = false;
                dN();
                break;
                i = 0;
                continue;
                i = 0;
              }
              label298:
              this.ja = j;
              this.fC = paramMotionEvent.getPointerId(0);
              if (this.fB == null)
              {
                this.fB = VelocityTracker.obtain();
                label326:
                this.fB.addMovement(paramMotionEvent);
                this.iY.computeScrollOffset();
                if (this.iY.isFinished()) {
                  break label377;
                }
              }
              for (;;)
              {
                this.iZ = bool;
                aJ(0);
                break;
                this.fB.clear();
                break label326;
                label377:
                bool = false;
              }
              this.iZ = false;
              this.fC = -1;
              dN();
              if (this.iY.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                q.O(this);
              }
              av(0);
              continue;
              d(paramMotionEvent);
            }
          }
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.KX = false;
    if ((this.KZ != null) && (b(this.KZ, this))) {
      aG(this.KZ);
    }
    this.KZ = null;
    if (!this.KY)
    {
      if (this.Lg != null)
      {
        scrollTo(getScrollX(), this.Lg.Ln);
        this.Lg = null;
      }
      if (getChildCount() <= 0) {
        break label153;
      }
      paramInt1 = getChildAt(0).getMeasuredHeight();
      paramInt1 = Math.max(0, paramInt1 - (paramInt4 - paramInt2 - getPaddingBottom() - getPaddingTop()));
      if (getScrollY() <= paramInt1) {
        break label158;
      }
      scrollTo(getScrollX(), paramInt1);
    }
    for (;;)
    {
      scrollTo(getScrollX(), getScrollY());
      this.KY = true;
      return;
      label153:
      paramInt1 = 0;
      break;
      label158:
      if (getScrollY() < 0) {
        scrollTo(getScrollX(), 0);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (!this.La) {}
    View localView;
    do
    {
      do
      {
        return;
      } while ((View.MeasureSpec.getMode(paramInt2) == 0) || (getChildCount() <= 0));
      localView = getChildAt(0);
      paramInt2 = getMeasuredHeight();
    } while (localView.getMeasuredHeight() >= paramInt2);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
    localView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight(), localLayoutParams.width), View.MeasureSpec.makeMeasureSpec(paramInt2 - getPaddingTop() - getPaddingBottom(), 1073741824));
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      aM((int)paramFloat2);
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
    dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt, null);
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = getScrollY();
    scrollBy(0, paramInt4);
    paramInt1 = getScrollY() - paramInt1;
    dispatchNestedScroll(0, paramInt1, 0, paramInt4 - paramInt1, null);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    this.Lj.Fs = paramInt;
    startNestedScroll(2);
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
    while (aF(localView))
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
    this.Lg = paramParcelable;
    requestLayout();
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.Ln = getScrollY();
    return localSavedState;
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.Lm != null) {
      this.Lm.a(this);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = findFocus();
    if ((localView == null) || (this == localView)) {}
    while (!d(localView, 0, paramInt4)) {
      return;
    }
    localView.getDrawingRect(this.ec);
    offsetDescendantRectToMyCoords(localView, this.ec);
    aK(computeScrollDeltaToGetChildRectOnScreen(this.ec));
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    this.Lj.Fs = 0;
    stopNestedScroll();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    dM();
    MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      this.Le = 0;
    }
    localMotionEvent.offsetLocation(0.0F, this.Le);
    switch (i)
    {
    }
    for (;;)
    {
      if (this.fB != null) {
        this.fB.addMovement(localMotionEvent);
      }
      localMotionEvent.recycle();
      bool = true;
      do
      {
        return bool;
      } while (getChildCount() == 0);
      if (!this.iY.isFinished()) {}
      ViewParent localViewParent;
      for (bool = true;; bool = false)
      {
        this.iZ = bool;
        if (bool)
        {
          localViewParent = getParent();
          if (localViewParent != null) {
            localViewParent.requestDisallowInterceptTouchEvent(true);
          }
        }
        if (!this.iY.isFinished()) {
          this.iY.abortAnimation();
        }
        this.ja = ((int)paramMotionEvent.getY());
        this.fC = paramMotionEvent.getPointerId(0);
        aJ(0);
        break;
      }
      int k = paramMotionEvent.findPointerIndex(this.fC);
      label536:
      label551:
      if (k == -1)
      {
        new StringBuilder("Invalid pointerId=").append(this.fC).append(" in onTouchEvent");
      }
      else
      {
        int m = (int)paramMotionEvent.getY(k);
        i = this.ja - m;
        int j = i;
        if (a(i, this.Ld, this.Lc, 0))
        {
          j = i - this.Ld[1];
          localMotionEvent.offsetLocation(0.0F, this.Lc[1]);
          this.Le += this.Lc[1];
        }
        i = j;
        if (!this.iZ)
        {
          i = j;
          if (Math.abs(j) > this.jb)
          {
            localViewParent = getParent();
            if (localViewParent != null) {
              localViewParent.requestDisallowInterceptTouchEvent(true);
            }
            this.iZ = true;
            if (j <= 0) {
              break label536;
            }
            i = j - this.jb;
          }
        }
        label380:
        if (this.iZ)
        {
          this.ja = (m - this.Lc[1]);
          int n = getScrollY();
          m = getScrollRange();
          j = getOverScrollMode();
          if ((j == 0) || ((j == 1) && (m > 0))) {}
          for (j = 1;; j = 0)
          {
            if ((g(i, 0, getScrollY(), m)) && (!au(0))) {
              this.fB.clear();
            }
            int i1 = getScrollY() - n;
            if (!a(i1, i - i1, this.Lc, 0)) {
              break label551;
            }
            this.ja -= this.Lc[1];
            localMotionEvent.offsetLocation(0.0F, this.Lc[1]);
            this.Le += this.Lc[1];
            break;
            i = j + this.jb;
            break label380;
          }
          if (j != 0)
          {
            dP();
            j = n + i;
            if (j < 0)
            {
              i.a(this.KV, i / getHeight(), paramMotionEvent.getX(k) / getWidth());
              if (!this.KW.isFinished()) {
                this.KW.onRelease();
              }
            }
            while ((this.KV != null) && ((!this.KV.isFinished()) || (!this.KW.isFinished())))
            {
              q.O(this);
              break;
              if (j > m)
              {
                i.a(this.KW, i / getHeight(), 1.0F - paramMotionEvent.getX(k) / getWidth());
                if (!this.KV.isFinished()) {
                  this.KV.onRelease();
                }
              }
            }
            paramMotionEvent = this.fB;
            paramMotionEvent.computeCurrentVelocity(1000, this.GV);
            i = (int)paramMotionEvent.getYVelocity(this.fC);
            if (Math.abs(i) > this.GU) {
              aM(-i);
            }
            for (;;)
            {
              this.fC = -1;
              dO();
              break;
              if (this.iY.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                q.O(this);
              }
            }
            if ((this.iZ) && (getChildCount() > 0) && (this.iY.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()))) {
              q.O(this);
            }
            this.fC = -1;
            dO();
            continue;
            i = paramMotionEvent.getActionIndex();
            this.ja = ((int)paramMotionEvent.getY(i));
            this.fC = paramMotionEvent.getPointerId(i);
            continue;
            d(paramMotionEvent);
            this.ja = ((int)paramMotionEvent.getY(paramMotionEvent.findPointerIndex(this.fC)));
          }
        }
      }
    }
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    if (!this.KX) {
      aG(paramView2);
    }
    for (;;)
    {
      super.requestChildFocus(paramView1, paramView2);
      return;
      this.KZ = paramView2;
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
      dN();
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void requestLayout()
  {
    this.KX = true;
    super.requestLayout();
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      paramInt1 = clamp(paramInt1, getWidth() - getPaddingRight() - getPaddingLeft(), localView.getWidth());
      paramInt2 = clamp(paramInt2, getHeight() - getPaddingBottom() - getPaddingTop(), localView.getHeight());
      if ((paramInt1 != getScrollX()) || (paramInt2 != getScrollY())) {
        super.scrollTo(paramInt1, paramInt2);
      }
    }
  }
  
  public void setFillViewport(boolean paramBoolean)
  {
    if (paramBoolean != this.La)
    {
      this.La = paramBoolean;
      requestLayout();
    }
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    this.Lk.setNestedScrollingEnabled(paramBoolean);
  }
  
  public void setOnScrollChangeListener(b paramb)
  {
    this.Lm = paramb;
  }
  
  public void setSmoothScrollingEnabled(boolean paramBoolean)
  {
    this.Lb = paramBoolean;
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return true;
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return this.Lk.r(paramInt, 0);
  }
  
  public void stopNestedScroll()
  {
    this.Lk.av(0);
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
    public int Ln;
    
    SavedState(Parcel paramParcel)
    {
      super();
      this.Ln = paramParcel.readInt();
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.Ln + "}";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.Ln);
    }
  }
  
  static final class a
    extends android.support.v4.view.a
  {
    public final void a(View paramView, android.support.v4.view.a.a parama)
    {
      super.a(paramView, parama);
      paramView = (NestedScrollView)paramView;
      parama.setClassName(ScrollView.class.getName());
      if (paramView.isEnabled())
      {
        int i = paramView.getScrollRange();
        if (i > 0)
        {
          parama.setScrollable(true);
          if (paramView.getScrollY() > 0) {
            parama.addAction(8192);
          }
          if (paramView.getScrollY() < i) {
            parama.addAction(4096);
          }
        }
      }
    }
    
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
          paramView.aL(paramInt);
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
        paramView.aL(paramInt);
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