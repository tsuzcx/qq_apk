package androidx.core.widget;

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
import androidx.core.a.a;
import androidx.core.g.a;
import androidx.core.g.a.d.a;
import androidx.core.g.m;
import androidx.core.g.n;
import androidx.core.g.q;
import androidx.core.g.r;
import androidx.core.g.w;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class NestedScrollView
  extends FrameLayout
  implements m, q, w
{
  private static final a bwN;
  private static final int[] bwO;
  private EdgeEffect bwA;
  private EdgeEffect bwB;
  private int bwC;
  private boolean bwD;
  private boolean bwE;
  private View bwF;
  private boolean bwG;
  private boolean bwH;
  private final int[] bwI;
  private final int[] bwJ;
  private int bwK;
  private int bwL;
  private SavedState bwM;
  private final n bwP;
  private float bwQ;
  private NestedScrollView.b bwR;
  private long bwy;
  private OverScroller bwz;
  private int mActivePointerId;
  private boolean mIsBeingDragged;
  private int mMaximumVelocity;
  private int mMinimumVelocity;
  private final Rect mTempRect;
  private int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  private final r pE;
  
  static
  {
    AppMethodBeat.i(195659);
    bwN = new a();
    bwO = new int[] { 16843130 };
    AppMethodBeat.o(195659);
  }
  
  public NestedScrollView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NestedScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.bnN);
  }
  
  public NestedScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(195423);
    this.mTempRect = new Rect();
    this.bwD = true;
    this.bwE = false;
    this.bwF = null;
    this.mIsBeingDragged = false;
    this.bwH = true;
    this.mActivePointerId = -1;
    this.bwI = new int[2];
    this.bwJ = new int[2];
    this.bwz = new OverScroller(getContext());
    setFocusable(true);
    setDescendantFocusability(262144);
    setWillNotDraw(false);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    this.mTouchSlop = localViewConfiguration.getScaledTouchSlop();
    this.mMinimumVelocity = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.mMaximumVelocity = localViewConfiguration.getScaledMaximumFlingVelocity();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, bwO, paramInt, 0);
    setFillViewport(paramContext.getBoolean(0, false));
    paramContext.recycle();
    this.pE = new r();
    this.bwP = new n(this);
    setNestedScrollingEnabled(true);
    z.a(this, bwN);
    AppMethodBeat.o(195423);
  }
  
  private boolean Fj()
  {
    AppMethodBeat.i(195467);
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
      int i = localView.getHeight();
      int j = localLayoutParams.topMargin;
      if (localLayoutParams.bottomMargin + (i + j) > getHeight() - getPaddingTop() - getPaddingBottom())
      {
        AppMethodBeat.o(195467);
        return true;
      }
      AppMethodBeat.o(195467);
      return false;
    }
    AppMethodBeat.o(195467);
    return false;
  }
  
  private void Fk()
  {
    AppMethodBeat.i(195476);
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    AppMethodBeat.o(195476);
  }
  
  private void Fl()
  {
    AppMethodBeat.i(195484);
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
    AppMethodBeat.o(195484);
  }
  
  private void Fm()
  {
    AppMethodBeat.i(195608);
    this.bwz.abortAnimation();
    em(1);
    AppMethodBeat.o(195608);
  }
  
  private void Fn()
  {
    AppMethodBeat.i(195642);
    if (getOverScrollMode() != 2)
    {
      if (this.bwA == null)
      {
        Context localContext = getContext();
        this.bwA = new EdgeEffect(localContext);
        this.bwB = new EdgeEffect(localContext);
        AppMethodBeat.o(195642);
      }
    }
    else
    {
      this.bwA = null;
      this.bwB = null;
    }
    AppMethodBeat.o(195642);
  }
  
  private void a(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(195428);
    this.bwP.a(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2);
    AppMethodBeat.o(195428);
  }
  
  private boolean a(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt3)
  {
    AppMethodBeat.i(195450);
    boolean bool = this.bwP.a(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, paramInt3);
    AppMethodBeat.o(195450);
    return bool;
  }
  
  private void aN(boolean paramBoolean)
  {
    AppMethodBeat.i(195601);
    if (paramBoolean) {
      az(2, 1);
    }
    for (;;)
    {
      this.bwL = getScrollY();
      z.Q(this);
      AppMethodBeat.o(195601);
      return;
      em(1);
    }
  }
  
  private boolean aO(View paramView)
  {
    AppMethodBeat.i(195567);
    if (!e(paramView, 0, getHeight()))
    {
      AppMethodBeat.o(195567);
      return true;
    }
    AppMethodBeat.o(195567);
    return false;
  }
  
  private void aP(View paramView)
  {
    AppMethodBeat.i(195617);
    paramView.getDrawingRect(this.mTempRect);
    offsetDescendantRectToMyCoords(paramView, this.mTempRect);
    int i = n(this.mTempRect);
    if (i != 0) {
      scrollBy(0, i);
    }
    AppMethodBeat.o(195617);
  }
  
  private boolean arrowScroll(int paramInt)
  {
    AppMethodBeat.i(195562);
    View localView1 = findFocus();
    if (localView1 == this) {
      localView1 = null;
    }
    for (;;)
    {
      View localView2 = FocusFinder.getInstance().findNextFocus(this, localView1, paramInt);
      int i = getMaxScrollAmount();
      if ((localView2 != null) && (e(localView2, i, getHeight())))
      {
        localView2.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(localView2, this.mTempRect);
        eH(n(this.mTempRect));
        localView2.requestFocus(paramInt);
        if ((localView1 != null) && (localView1.isFocused()) && (aO(localView1)))
        {
          paramInt = getDescendantFocusability();
          setDescendantFocusability(131072);
          requestFocus();
          setDescendantFocusability(paramInt);
        }
        AppMethodBeat.o(195562);
        return true;
      }
      if ((paramInt == 33) && (getScrollY() < i)) {
        i = getScrollY();
      }
      for (;;)
      {
        if (i == 0)
        {
          AppMethodBeat.o(195562);
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
            eH(i);
            break;
            i = -i;
          }
        }
      }
    }
  }
  
  private boolean az(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195435);
    boolean bool = this.bwP.az(paramInt1, paramInt2);
    AppMethodBeat.o(195435);
    return bool;
  }
  
  private View c(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195526);
    ArrayList localArrayList = getFocusables(2);
    Object localObject = null;
    int i = 0;
    int n = localArrayList.size();
    int k = 0;
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
        break label216;
      }
      if ((paramInt1 < m) && (i1 < paramInt2))
      {
        j = 1;
        label93:
        if (localObject != null) {
          break label121;
        }
        i = j;
        localObject = localView;
      }
    }
    label180:
    label216:
    for (;;)
    {
      k += 1;
      break;
      j = 0;
      break label93;
      label121:
      if (((paramBoolean) && (m < localObject.getTop())) || ((!paramBoolean) && (i1 > localObject.getBottom()))) {}
      for (m = 1;; m = 0)
      {
        if (i == 0) {
          break label180;
        }
        if ((j == 0) || (m == 0)) {
          break label216;
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
        AppMethodBeat.o(195526);
        return localObject;
      }
    }
  }
  
  private void c(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(195459);
    int i = getScrollY();
    scrollBy(0, paramInt1);
    i = getScrollY() - i;
    if (paramArrayOfInt != null) {
      paramArrayOfInt[1] += i;
    }
    this.bwP.a(i, paramInt1 - i, null, paramInt2, paramArrayOfInt);
    AppMethodBeat.o(195459);
  }
  
  private static boolean c(View paramView1, View paramView2)
  {
    AppMethodBeat.i(195623);
    if (paramView1 == paramView2)
    {
      AppMethodBeat.o(195623);
      return true;
    }
    paramView1 = paramView1.getParent();
    if (((paramView1 instanceof ViewGroup)) && (c((View)paramView1, paramView2)))
    {
      AppMethodBeat.o(195623);
      return true;
    }
    AppMethodBeat.o(195623);
    return false;
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
  
  private void e(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(195593);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(195593);
      return;
    }
    if (AnimationUtils.currentAnimationTimeMillis() - this.bwy > 250L)
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
      this.bwz.startScroll(getScrollX(), paramInt1, 0, paramInt2 - paramInt1, 250);
      aN(paramBoolean);
    }
    for (;;)
    {
      this.bwy = AnimationUtils.currentAnimationTimeMillis();
      AppMethodBeat.o(195593);
      return;
      if (!this.bwz.isFinished()) {
        Fm();
      }
      scrollBy(paramInt1, paramInt2);
    }
  }
  
  private boolean e(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195575);
    paramView.getDrawingRect(this.mTempRect);
    offsetDescendantRectToMyCoords(paramView, this.mTempRect);
    if ((this.mTempRect.bottom + paramInt1 >= getScrollY()) && (this.mTempRect.top - paramInt1 <= getScrollY() + paramInt2))
    {
      AppMethodBeat.o(195575);
      return true;
    }
    AppMethodBeat.o(195575);
    return false;
  }
  
  private boolean eF(int paramInt)
  {
    AppMethodBeat.i(195540);
    int i;
    int j;
    if (paramInt == 130)
    {
      i = 1;
      j = getHeight();
      if (i == 0) {
        break label158;
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
      boolean bool = r(paramInt, this.mTempRect.top, this.mTempRect.bottom);
      AppMethodBeat.o(195540);
      return bool;
      i = 0;
      break;
      label158:
      this.mTempRect.top = (getScrollY() - j);
      if (this.mTempRect.top < 0) {
        this.mTempRect.top = 0;
      }
    }
  }
  
  private void eH(int paramInt)
  {
    AppMethodBeat.i(195582);
    if (paramInt != 0)
    {
      if (this.bwH)
      {
        e(0, paramInt, false);
        AppMethodBeat.o(195582);
        return;
      }
      scrollBy(0, paramInt);
    }
    AppMethodBeat.o(195582);
  }
  
  private boolean en(int paramInt)
  {
    AppMethodBeat.i(195439);
    boolean bool = this.bwP.en(paramInt);
    AppMethodBeat.o(195439);
    return bool;
  }
  
  private void endDrag()
  {
    AppMethodBeat.i(195632);
    this.mIsBeingDragged = false;
    Fl();
    em(0);
    if (this.bwA != null)
    {
      this.bwA.onRelease();
      this.bwB.onRelease();
    }
    AppMethodBeat.o(195632);
  }
  
  private float getVerticalScrollFactorCompat()
  {
    AppMethodBeat.i(195501);
    if (this.bwQ == 0.0F)
    {
      Object localObject = new TypedValue();
      Context localContext = getContext();
      if (!localContext.getTheme().resolveAttribute(16842829, (TypedValue)localObject, true))
      {
        localObject = new IllegalStateException("Expected theme to define listPreferredItemHeight.");
        AppMethodBeat.o(195501);
        throw ((Throwable)localObject);
      }
      this.bwQ = ((TypedValue)localObject).getDimension(localContext.getResources().getDisplayMetrics());
    }
    float f = this.bwQ;
    AppMethodBeat.o(195501);
    return f;
  }
  
  private boolean o(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(195513);
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
        if ((bool2) && (!en(1))) {
          this.bwz.springBack(paramInt1, paramInt2, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(paramInt1, paramInt2, bool1, bool2);
        if ((bool1) || (bool2))
        {
          AppMethodBeat.o(195513);
          return true;
          if (i >= 0) {
            break label162;
          }
          paramInt1 = 0;
          bool1 = true;
          break;
          if (paramInt2 >= 0) {
            break label156;
          }
          bool2 = true;
          paramInt2 = 0;
          continue;
        }
        AppMethodBeat.o(195513);
        return false;
        label156:
        bool2 = false;
      }
      label162:
      bool1 = false;
      paramInt1 = i;
    }
  }
  
  private void onSecondaryPointerUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(195492);
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.mActivePointerId) {
      if (i != 0) {
        break label69;
      }
    }
    label69:
    for (i = 1;; i = 0)
    {
      this.bwC = ((int)paramMotionEvent.getY(i));
      this.mActivePointerId = paramMotionEvent.getPointerId(i);
      if (this.mVelocityTracker != null) {
        this.mVelocityTracker.clear();
      }
      AppMethodBeat.o(195492);
      return;
    }
  }
  
  private boolean r(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = false;
    AppMethodBeat.i(195551);
    int j = getHeight();
    int i = getScrollY();
    j = i + j;
    if (paramInt1 == 33) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      View localView = c(bool1, paramInt2, paramInt3);
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
      AppMethodBeat.o(195551);
      return bool1;
    }
    if (bool1) {
      paramInt2 -= i;
    }
    for (;;)
    {
      eH(paramInt2);
      bool1 = true;
      break;
      paramInt2 = paramInt3 - j;
    }
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(195783);
    c(paramInt4, paramInt5, null);
    AppMethodBeat.o(195783);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    AppMethodBeat.i(195792);
    a(paramInt1, paramInt2, paramArrayOfInt, null, paramInt3);
    AppMethodBeat.o(195792);
  }
  
  public final boolean a(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    return (paramInt1 & 0x2) != 0;
  }
  
  public void addView(View paramView)
  {
    AppMethodBeat.i(195913);
    if (getChildCount() > 0)
    {
      paramView = new IllegalStateException("ScrollView can host only one direct child");
      AppMethodBeat.o(195913);
      throw paramView;
    }
    super.addView(paramView);
    AppMethodBeat.o(195913);
  }
  
  public void addView(View paramView, int paramInt)
  {
    AppMethodBeat.i(195920);
    if (getChildCount() > 0)
    {
      paramView = new IllegalStateException("ScrollView can host only one direct child");
      AppMethodBeat.o(195920);
      throw paramView;
    }
    super.addView(paramView, paramInt);
    AppMethodBeat.o(195920);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(195939);
    if (getChildCount() > 0)
    {
      paramView = new IllegalStateException("ScrollView can host only one direct child");
      AppMethodBeat.o(195939);
      throw paramView;
    }
    super.addView(paramView, paramInt, paramLayoutParams);
    AppMethodBeat.o(195939);
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(195932);
    if (getChildCount() > 0)
    {
      paramView = new IllegalStateException("ScrollView can host only one direct child");
      AppMethodBeat.o(195932);
      throw paramView;
    }
    super.addView(paramView, paramLayoutParams);
    AppMethodBeat.o(195932);
  }
  
  public final void b(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(195739);
    c(paramInt1, paramInt2, paramArrayOfInt);
    AppMethodBeat.o(195739);
  }
  
  public final void b(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195761);
    this.pE.aA(paramInt1, paramInt2);
    az(2, paramInt2);
    AppMethodBeat.o(195761);
  }
  
  public int computeHorizontalScrollExtent()
  {
    AppMethodBeat.i(196126);
    int i = super.computeHorizontalScrollExtent();
    AppMethodBeat.o(196126);
    return i;
  }
  
  public int computeHorizontalScrollOffset()
  {
    AppMethodBeat.i(196119);
    int i = super.computeHorizontalScrollOffset();
    AppMethodBeat.o(196119);
    return i;
  }
  
  public int computeHorizontalScrollRange()
  {
    AppMethodBeat.i(196107);
    int i = super.computeHorizontalScrollRange();
    AppMethodBeat.o(196107);
    return i;
  }
  
  public void computeScroll()
  {
    int k = 0;
    AppMethodBeat.i(196156);
    if (this.bwz.isFinished())
    {
      AppMethodBeat.o(196156);
      return;
    }
    this.bwz.computeScrollOffset();
    int i = this.bwz.getCurrY();
    int j = i - this.bwL;
    this.bwL = i;
    this.bwJ[1] = 0;
    a(0, j, this.bwJ, null, 1);
    j -= this.bwJ[1];
    int m = getScrollRange();
    i = j;
    if (j != 0)
    {
      i = getScrollY();
      o(j, getScrollX(), i, m);
      i = getScrollY() - i;
      j -= i;
      this.bwJ[1] = 0;
      a(i, j, this.bwI, 1, this.bwJ);
      i = j - this.bwJ[1];
    }
    if (i != 0)
    {
      int n = getOverScrollMode();
      if (n != 0)
      {
        j = k;
        if (n == 1)
        {
          j = k;
          if (m <= 0) {}
        }
      }
      else
      {
        j = 1;
      }
      if (j != 0)
      {
        Fn();
        if (i >= 0) {
          break label248;
        }
        if (this.bwA.isFinished()) {
          this.bwA.onAbsorb((int)this.bwz.getCurrVelocity());
        }
      }
    }
    for (;;)
    {
      Fm();
      if (this.bwz.isFinished()) {
        break;
      }
      z.Q(this);
      AppMethodBeat.o(196156);
      return;
      label248:
      if (this.bwB.isFinished()) {
        this.bwB.onAbsorb((int)this.bwz.getCurrVelocity());
      }
    }
    em(1);
    AppMethodBeat.o(196156);
  }
  
  public int computeVerticalScrollExtent()
  {
    AppMethodBeat.i(196098);
    int i = super.computeVerticalScrollExtent();
    AppMethodBeat.o(196098);
    return i;
  }
  
  public int computeVerticalScrollOffset()
  {
    AppMethodBeat.i(196089);
    int i = Math.max(0, super.computeVerticalScrollOffset());
    AppMethodBeat.o(196089);
    return i;
  }
  
  public int computeVerticalScrollRange()
  {
    AppMethodBeat.i(196078);
    int j = getChildCount();
    int i = getHeight() - getPaddingBottom() - getPaddingTop();
    if (j == 0)
    {
      AppMethodBeat.o(196078);
      return i;
    }
    View localView = getChildAt(0);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
    j = localView.getBottom();
    j = localLayoutParams.bottomMargin + j;
    int k = getScrollY();
    int m = Math.max(0, j - i);
    if (k < 0) {
      i = j - k;
    }
    for (;;)
    {
      AppMethodBeat.o(196078);
      return i;
      i = j;
      if (k > m) {
        i = j + (k - m);
      }
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(195971);
    if ((super.dispatchKeyEvent(paramKeyEvent)) || (executeKeyEvent(paramKeyEvent)))
    {
      AppMethodBeat.o(195971);
      return true;
    }
    AppMethodBeat.o(195971);
    return false;
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(195714);
    paramBoolean = this.bwP.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
    AppMethodBeat.o(195714);
    return paramBoolean;
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(195730);
    boolean bool = this.bwP.dispatchNestedPreFling(paramFloat1, paramFloat2);
    AppMethodBeat.o(195730);
    return bool;
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(195708);
    boolean bool = a(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, 0);
    AppMethodBeat.o(195708);
    return bool;
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(195701);
    boolean bool = this.bwP.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
    AppMethodBeat.o(195701);
    return bool;
  }
  
  public void draw(Canvas paramCanvas)
  {
    int n = 0;
    AppMethodBeat.i(196270);
    super.draw(paramCanvas);
    int i3;
    int i4;
    int j;
    int i2;
    int i1;
    if (this.bwA != null)
    {
      i3 = getScrollY();
      if (!this.bwA.isFinished())
      {
        i4 = paramCanvas.save();
        j = getWidth();
        i2 = getHeight();
        i1 = Math.min(0, i3);
        if ((Build.VERSION.SDK_INT >= 21) && (!getClipToPadding())) {
          break label386;
        }
        j -= getPaddingLeft() + getPaddingRight();
      }
    }
    label386:
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
      this.bwA.setSize(j, k);
      if (this.bwA.draw(paramCanvas)) {
        z.Q(this);
      }
      paramCanvas.restoreToCount(i4);
      if (!this.bwB.isFinished())
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
        this.bwB.setSize(i, k);
        if (this.bwB.draw(paramCanvas)) {
          z.Q(this);
        }
        paramCanvas.restoreToCount(i4);
      }
      AppMethodBeat.o(196270);
      return;
    }
  }
  
  public final boolean eG(int paramInt)
  {
    AppMethodBeat.i(196053);
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
      boolean bool = r(paramInt, this.mTempRect.top, this.mTempRect.bottom);
      AppMethodBeat.o(196053);
      return bool;
    }
  }
  
  final void eI(int paramInt)
  {
    AppMethodBeat.i(196061);
    e(0 - getScrollX(), paramInt - getScrollY(), true);
    AppMethodBeat.o(196061);
  }
  
  public void eJ(int paramInt)
  {
    AppMethodBeat.i(196243);
    if (getChildCount() > 0)
    {
      this.bwz.fling(getScrollX(), getScrollY(), 0, paramInt, 0, 0, -2147483648, 2147483647, 0, 0);
      aN(true);
    }
    AppMethodBeat.o(196243);
  }
  
  public final void em(int paramInt)
  {
    AppMethodBeat.i(195666);
    this.bwP.em(paramInt);
    AppMethodBeat.o(195666);
  }
  
  public final boolean executeKeyEvent(KeyEvent paramKeyEvent)
  {
    int i = 33;
    AppMethodBeat.i(195983);
    this.mTempRect.setEmpty();
    if (!Fj())
    {
      if ((isFocused()) && (paramKeyEvent.getKeyCode() != 4))
      {
        View localView = findFocus();
        paramKeyEvent = localView;
        if (localView == this) {
          paramKeyEvent = null;
        }
        paramKeyEvent = FocusFinder.getInstance().findNextFocus(this, paramKeyEvent, 130);
        if ((paramKeyEvent != null) && (paramKeyEvent != this) && (paramKeyEvent.requestFocus(130)))
        {
          AppMethodBeat.o(195983);
          return true;
        }
        AppMethodBeat.o(195983);
        return false;
      }
      AppMethodBeat.o(195983);
      return false;
    }
    if (paramKeyEvent.getAction() == 0) {}
    boolean bool;
    switch (paramKeyEvent.getKeyCode())
    {
    default: 
      bool = false;
    case 19: 
    case 20: 
      for (;;)
      {
        AppMethodBeat.o(195983);
        return bool;
        if (!paramKeyEvent.isAltPressed())
        {
          bool = arrowScroll(33);
        }
        else
        {
          bool = eG(33);
          continue;
          if (!paramKeyEvent.isAltPressed()) {
            bool = arrowScroll(130);
          } else {
            bool = eG(130);
          }
        }
      }
    }
    if (paramKeyEvent.isShiftPressed()) {}
    for (;;)
    {
      eF(i);
      break;
      i = 130;
    }
  }
  
  protected float getBottomFadingEdgeStrength()
  {
    AppMethodBeat.i(195898);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(195898);
      return 0.0F;
    }
    View localView = getChildAt(0);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
    int i = getVerticalFadingEdgeLength();
    int j = getHeight();
    int k = getPaddingBottom();
    int m = localView.getBottom();
    j = localLayoutParams.bottomMargin + m - getScrollY() - (j - k);
    if (j < i)
    {
      float f = j / i;
      AppMethodBeat.o(195898);
      return f;
    }
    AppMethodBeat.o(195898);
    return 1.0F;
  }
  
  public int getMaxScrollAmount()
  {
    AppMethodBeat.i(195903);
    int i = (int)(0.5F * getHeight());
    AppMethodBeat.o(195903);
    return i;
  }
  
  public int getNestedScrollAxes()
  {
    AppMethodBeat.i(195874);
    int i = this.pE.getNestedScrollAxes();
    AppMethodBeat.o(195874);
    return i;
  }
  
  int getScrollRange()
  {
    AppMethodBeat.i(196044);
    FrameLayout.LayoutParams localLayoutParams;
    int j;
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
      i = localView.getHeight();
      j = localLayoutParams.topMargin;
    }
    for (int i = Math.max(0, localLayoutParams.bottomMargin + (i + j) - (getHeight() - getPaddingTop() - getPaddingBottom()));; i = 0)
    {
      AppMethodBeat.o(196044);
      return i;
    }
  }
  
  protected float getTopFadingEdgeStrength()
  {
    AppMethodBeat.i(195889);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(195889);
      return 0.0F;
    }
    int i = getVerticalFadingEdgeLength();
    int j = getScrollY();
    if (j < i)
    {
      float f = j / i;
      AppMethodBeat.o(195889);
      return f;
    }
    AppMethodBeat.o(195889);
    return 1.0F;
  }
  
  public boolean hasNestedScrollingParent()
  {
    AppMethodBeat.i(195695);
    boolean bool = en(0);
    AppMethodBeat.o(195695);
    return bool;
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return this.bwP.bts;
  }
  
  public final void l(View paramView, int paramInt)
  {
    AppMethodBeat.i(195773);
    this.pE.eq(paramInt);
    em(paramInt);
    AppMethodBeat.o(195773);
  }
  
  protected void measureChild(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(196139);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    paramView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight(), localLayoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
    AppMethodBeat.o(196139);
  }
  
  protected void measureChildWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(196148);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    paramInt1 = getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin + paramInt2, localMarginLayoutParams.width);
    paramInt2 = localMarginLayoutParams.topMargin;
    paramView.measure(paramInt1, View.MeasureSpec.makeMeasureSpec(localMarginLayoutParams.bottomMargin + paramInt2, 0));
    AppMethodBeat.o(196148);
  }
  
  protected int n(Rect paramRect)
  {
    AppMethodBeat.i(196167);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(196167);
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
          AppMethodBeat.o(196167);
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
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(196222);
    super.onAttachedToWindow();
    this.bwE = false;
    AppMethodBeat.o(196222);
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(196028);
    if ((paramMotionEvent.getSource() & 0x2) != 0) {
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(196028);
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
            AppMethodBeat.o(196028);
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
    AppMethodBeat.i(196003);
    int i = paramMotionEvent.getAction();
    if ((i == 2) && (this.mIsBeingDragged))
    {
      AppMethodBeat.o(196003);
      return true;
    }
    switch (i & 0xFF)
    {
    }
    for (;;)
    {
      bool = this.mIsBeingDragged;
      AppMethodBeat.o(196003);
      return bool;
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
          if ((Math.abs(i - this.bwC) > this.mTouchSlop) && ((getNestedScrollAxes() & 0x2) == 0))
          {
            this.mIsBeingDragged = true;
            this.bwC = i;
            Fk();
            this.mVelocityTracker.addMovement(paramMotionEvent);
            this.bwK = 0;
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
                  break label320;
                }
                this.mIsBeingDragged = false;
                Fl();
                break;
                i = 0;
                continue;
                i = 0;
              }
              label320:
              this.bwC = j;
              this.mActivePointerId = paramMotionEvent.getPointerId(0);
              if (this.mVelocityTracker == null)
              {
                this.mVelocityTracker = VelocityTracker.obtain();
                label348:
                this.mVelocityTracker.addMovement(paramMotionEvent);
                this.bwz.computeScrollOffset();
                if (this.bwz.isFinished()) {
                  break label400;
                }
              }
              for (;;)
              {
                this.mIsBeingDragged = bool;
                az(2, 0);
                break;
                this.mVelocityTracker.clear();
                break label348;
                label400:
                bool = false;
              }
              this.mIsBeingDragged = false;
              this.mActivePointerId = -1;
              Fl();
              if (this.bwz.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                z.Q(this);
              }
              em(0);
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
    AppMethodBeat.i(196215);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.bwD = false;
    if ((this.bwF != null) && (c(this.bwF, this))) {
      aP(this.bwF);
    }
    this.bwF = null;
    if (!this.bwE)
    {
      if (this.bwM != null)
      {
        scrollTo(getScrollX(), this.bwM.bwS);
        this.bwM = null;
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
    this.bwE = true;
    AppMethodBeat.o(196215);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195966);
    super.onMeasure(paramInt1, paramInt2);
    if (!this.bwG)
    {
      AppMethodBeat.o(195966);
      return;
    }
    if (View.MeasureSpec.getMode(paramInt2) == 0)
    {
      AppMethodBeat.o(195966);
      return;
    }
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
      paramInt2 = localView.getMeasuredHeight();
      int i = getMeasuredHeight() - getPaddingTop() - getPaddingBottom() - localLayoutParams.topMargin - localLayoutParams.bottomMargin;
      if (paramInt2 < i) {
        localView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + localLayoutParams.leftMargin + localLayoutParams.rightMargin, localLayoutParams.width), View.MeasureSpec.makeMeasureSpec(i, 1073741824));
      }
    }
    AppMethodBeat.o(195966);
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(195854);
    if (!paramBoolean)
    {
      dispatchNestedFling(0.0F, paramFloat2, true);
      eJ((int)paramFloat2);
      AppMethodBeat.o(195854);
      return true;
    }
    AppMethodBeat.o(195854);
    return false;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(195865);
    boolean bool = dispatchNestedPreFling(paramFloat1, paramFloat2);
    AppMethodBeat.o(195865);
    return bool;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(195845);
    a(paramView, paramInt1, paramInt2, paramArrayOfInt, 0);
    AppMethodBeat.o(195845);
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(195837);
    c(paramInt4, 0, null);
    AppMethodBeat.o(195837);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    AppMethodBeat.i(195814);
    b(paramView1, paramView2, paramInt, 0);
    AppMethodBeat.o(195814);
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(196034);
    super.scrollTo(paramInt1, paramInt2);
    AppMethodBeat.o(196034);
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    AppMethodBeat.i(196186);
    int i;
    if (paramInt == 2)
    {
      i = 130;
      if (paramRect != null) {
        break label56;
      }
    }
    label56:
    for (View localView = FocusFinder.getInstance().findNextFocus(this, null, i);; localView = FocusFinder.getInstance().findNextFocusFromRect(this, paramRect, i))
    {
      if (localView != null) {
        break label70;
      }
      AppMethodBeat.o(196186);
      return false;
      i = paramInt;
      if (paramInt != 1) {
        break;
      }
      i = 33;
      break;
    }
    label70:
    if (aO(localView))
    {
      AppMethodBeat.o(196186);
      return false;
    }
    boolean bool = localView.requestFocus(i, paramRect);
    AppMethodBeat.o(196186);
    return bool;
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(196275);
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(196275);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.bwM = paramParcelable;
    requestLayout();
    AppMethodBeat.o(196275);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(196284);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.bwS = getScrollY();
    AppMethodBeat.o(196284);
    return localSavedState;
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(195958);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.bwR != null) {
      this.bwR.onScrollChange(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(195958);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(196233);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = findFocus();
    if ((localView == null) || (this == localView))
    {
      AppMethodBeat.o(196233);
      return;
    }
    if (e(localView, 0, paramInt4))
    {
      localView.getDrawingRect(this.mTempRect);
      offsetDescendantRectToMyCoords(localView, this.mTempRect);
      eH(n(this.mTempRect));
    }
    AppMethodBeat.o(196233);
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    AppMethodBeat.i(195803);
    boolean bool = a(paramView1, paramView2, paramInt, 0);
    AppMethodBeat.o(195803);
    return bool;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    AppMethodBeat.i(195825);
    l(paramView, 0);
    AppMethodBeat.o(195825);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(196021);
    Fk();
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      this.bwK = 0;
    }
    MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
    localMotionEvent.offsetLocation(0.0F, this.bwK);
    switch (i)
    {
    }
    label647:
    for (;;)
    {
      if (this.mVelocityTracker != null) {
        this.mVelocityTracker.addMovement(localMotionEvent);
      }
      localMotionEvent.recycle();
      AppMethodBeat.o(196021);
      return true;
      if (getChildCount() == 0)
      {
        AppMethodBeat.o(196021);
        return false;
      }
      if (!this.bwz.isFinished()) {}
      ViewParent localViewParent;
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
        if (!this.bwz.isFinished()) {
          Fm();
        }
        this.bwC = ((int)paramMotionEvent.getY());
        this.mActivePointerId = paramMotionEvent.getPointerId(0);
        az(2, 0);
        break;
      }
      int k = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      label433:
      if (k == -1)
      {
        new StringBuilder("Invalid pointerId=").append(this.mActivePointerId).append(" in onTouchEvent");
      }
      else
      {
        int m = (int)paramMotionEvent.getY(k);
        int j = this.bwC - m;
        i = j;
        if (!this.mIsBeingDragged)
        {
          i = j;
          if (Math.abs(j) > this.mTouchSlop)
          {
            localViewParent = getParent();
            if (localViewParent != null) {
              localViewParent.requestDisallowInterceptTouchEvent(true);
            }
            this.mIsBeingDragged = true;
            if (j <= 0) {
              break label632;
            }
            i = j - this.mTouchSlop;
          }
        }
        label336:
        if (this.mIsBeingDragged)
        {
          j = i;
          if (a(0, i, this.bwJ, this.bwI, 0))
          {
            j = i - this.bwJ[1];
            this.bwK += this.bwI[1];
          }
          this.bwC = (m - this.bwI[1]);
          int n = getScrollY();
          m = getScrollRange();
          i = getOverScrollMode();
          if ((i == 0) || ((i == 1) && (m > 0)))
          {
            i = 1;
            if ((o(j, 0, getScrollY(), m)) && (!en(0))) {
              this.mVelocityTracker.clear();
            }
            int i1 = getScrollY() - n;
            this.bwJ[1] = 0;
            a(i1, j - i1, this.bwI, 0, this.bwJ);
            this.bwC -= this.bwI[1];
            this.bwK += this.bwI[1];
            if (i == 0) {
              continue;
            }
            i = j - this.bwJ[1];
            Fn();
            j = n + i;
            if (j >= 0) {
              break label647;
            }
            d.a(this.bwA, i / getHeight(), paramMotionEvent.getX(k) / getWidth());
            if (!this.bwB.isFinished()) {
              this.bwB.onRelease();
            }
          }
          while ((this.bwA != null) && ((!this.bwA.isFinished()) || (!this.bwB.isFinished())))
          {
            z.Q(this);
            break;
            label632:
            i = j + this.mTouchSlop;
            break label336;
            i = 0;
            break label433;
            if (j > m)
            {
              d.a(this.bwB, i / getHeight(), 1.0F - paramMotionEvent.getX(k) / getWidth());
              if (!this.bwA.isFinished()) {
                this.bwA.onRelease();
              }
            }
          }
          paramMotionEvent = this.mVelocityTracker;
          paramMotionEvent.computeCurrentVelocity(1000, this.mMaximumVelocity);
          i = (int)paramMotionEvent.getYVelocity(this.mActivePointerId);
          if (Math.abs(i) >= this.mMinimumVelocity) {
            if (!dispatchNestedPreFling(0.0F, -i))
            {
              dispatchNestedFling(0.0F, -i, true);
              eJ(-i);
            }
          }
          for (;;)
          {
            this.mActivePointerId = -1;
            endDrag();
            break;
            if (this.bwz.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
              z.Q(this);
            }
          }
          if ((this.mIsBeingDragged) && (getChildCount() > 0) && (this.bwz.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()))) {
            z.Q(this);
          }
          this.mActivePointerId = -1;
          endDrag();
          continue;
          i = paramMotionEvent.getActionIndex();
          this.bwC = ((int)paramMotionEvent.getY(i));
          this.mActivePointerId = paramMotionEvent.getPointerId(i);
          continue;
          onSecondaryPointerUp(paramMotionEvent);
          this.bwC = ((int)paramMotionEvent.getY(paramMotionEvent.findPointerIndex(this.mActivePointerId)));
        }
      }
    }
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    AppMethodBeat.i(196174);
    if (!this.bwD) {
      aP(paramView2);
    }
    for (;;)
    {
      super.requestChildFocus(paramView1, paramView2);
      AppMethodBeat.o(196174);
      return;
      this.bwF = paramView2;
    }
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    AppMethodBeat.i(196200);
    paramRect.offset(paramView.getLeft() - paramView.getScrollX(), paramView.getTop() - paramView.getScrollY());
    int i = n(paramRect);
    boolean bool;
    if (i != 0)
    {
      bool = true;
      if (bool)
      {
        if (!paramBoolean) {
          break label74;
        }
        scrollBy(0, i);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(196200);
      return bool;
      bool = false;
      break;
      label74:
      e(0, i, false);
    }
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(195989);
    if (paramBoolean) {
      Fl();
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    AppMethodBeat.o(195989);
  }
  
  public void requestLayout()
  {
    AppMethodBeat.i(196208);
    this.bwD = true;
    super.requestLayout();
    AppMethodBeat.o(196208);
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(196253);
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
    AppMethodBeat.o(196253);
  }
  
  public void setFillViewport(boolean paramBoolean)
  {
    AppMethodBeat.i(195950);
    if (paramBoolean != this.bwG)
    {
      this.bwG = paramBoolean;
      requestLayout();
    }
    AppMethodBeat.o(195950);
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(195674);
    this.bwP.setNestedScrollingEnabled(paramBoolean);
    AppMethodBeat.o(195674);
  }
  
  public void setOnScrollChangeListener(NestedScrollView.b paramb)
  {
    this.bwR = paramb;
  }
  
  public void setSmoothScrollingEnabled(boolean paramBoolean)
  {
    this.bwH = paramBoolean;
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return true;
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    AppMethodBeat.i(195684);
    boolean bool = az(paramInt, 0);
    AppMethodBeat.o(195684);
    return bool;
  }
  
  public void stopNestedScroll()
  {
    AppMethodBeat.i(195690);
    em(0);
    AppMethodBeat.o(195690);
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    public int bwS;
    
    static
    {
      AppMethodBeat.i(195387);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(195387);
    }
    
    SavedState(Parcel paramParcel)
    {
      super();
      AppMethodBeat.i(195382);
      this.bwS = paramParcel.readInt();
      AppMethodBeat.o(195382);
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      AppMethodBeat.i(195404);
      String str = "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.bwS + "}";
      AppMethodBeat.o(195404);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(195394);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.bwS);
      AppMethodBeat.o(195394);
    }
  }
  
  static final class a
    extends a
  {
    public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      AppMethodBeat.i(195409);
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
        AppMethodBeat.o(195409);
        return;
      }
    }
    
    public final void onInitializeAccessibilityNodeInfo(View paramView, androidx.core.g.a.d paramd)
    {
      AppMethodBeat.i(195398);
      super.onInitializeAccessibilityNodeInfo(paramView, paramd);
      paramView = (NestedScrollView)paramView;
      paramd.v(ScrollView.class.getName());
      if (paramView.isEnabled())
      {
        int i = paramView.getScrollRange();
        if (i > 0)
        {
          paramd.aH(true);
          if (paramView.getScrollY() > 0)
          {
            paramd.a(d.a.bvf);
            paramd.a(d.a.bvq);
          }
          if (paramView.getScrollY() < i)
          {
            paramd.a(d.a.bve);
            paramd.a(d.a.bvs);
          }
        }
      }
      AppMethodBeat.o(195398);
    }
    
    public final boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(195392);
      if (super.performAccessibilityAction(paramView, paramInt, paramBundle))
      {
        AppMethodBeat.o(195392);
        return true;
      }
      paramView = (NestedScrollView)paramView;
      if (!paramView.isEnabled())
      {
        AppMethodBeat.o(195392);
        return false;
      }
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(195392);
        return false;
      case 4096: 
      case 16908346: 
        paramInt = Math.min(paramView.getHeight() - paramView.getPaddingBottom() - paramView.getPaddingTop() + paramView.getScrollY(), paramView.getScrollRange());
        if (paramInt != paramView.getScrollY())
        {
          paramView.eI(paramInt);
          AppMethodBeat.o(195392);
          return true;
        }
        AppMethodBeat.o(195392);
        return false;
      }
      paramInt = paramView.getHeight();
      int i = paramView.getPaddingBottom();
      int j = paramView.getPaddingTop();
      paramInt = Math.max(paramView.getScrollY() - (paramInt - i - j), 0);
      if (paramInt != paramView.getScrollY())
      {
        paramView.eI(paramInt);
        AppMethodBeat.o(195392);
        return true;
      }
      AppMethodBeat.o(195392);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.core.widget.NestedScrollView
 * JD-Core Version:    0.7.0.1
 */