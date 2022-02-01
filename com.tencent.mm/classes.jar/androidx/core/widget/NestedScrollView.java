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
import androidx.core.g.a;
import androidx.core.g.a.d.a;
import androidx.core.g.m;
import androidx.core.g.n;
import androidx.core.g.q;
import androidx.core.g.r;
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class NestedScrollView
  extends FrameLayout
  implements m, q
{
  private static final a Qw;
  private static final int[] Qx;
  private NestedScrollView.b QA;
  private long Qh;
  private OverScroller Qi;
  private EdgeEffect Qj;
  private EdgeEffect Qk;
  private int Ql;
  private boolean Qm;
  private boolean Qn;
  private View Qo;
  private boolean Qp;
  private boolean Qq;
  private final int[] Qr;
  private final int[] Qs;
  private int Qt;
  private int Qu;
  private SavedState Qv;
  private final n Qy;
  private float Qz;
  private int mActivePointerId;
  private boolean mIsBeingDragged;
  private int mMaximumVelocity;
  private int mMinimumVelocity;
  private final Rect mTempRect;
  private int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  private final r oH;
  
  static
  {
    AppMethodBeat.i(253005);
    Qw = new a();
    Qx = new int[] { 16843130 };
    AppMethodBeat.o(253005);
  }
  
  public NestedScrollView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NestedScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NestedScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(252854);
    this.mTempRect = new Rect();
    this.Qm = true;
    this.Qn = false;
    this.Qo = null;
    this.mIsBeingDragged = false;
    this.Qq = true;
    this.mActivePointerId = -1;
    this.Qr = new int[2];
    this.Qs = new int[2];
    this.Qi = new OverScroller(getContext());
    setFocusable(true);
    setDescendantFocusability(262144);
    setWillNotDraw(false);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    this.mTouchSlop = localViewConfiguration.getScaledTouchSlop();
    this.mMinimumVelocity = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.mMaximumVelocity = localViewConfiguration.getScaledMaximumFlingVelocity();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, Qx, paramInt, 0);
    setFillViewport(paramContext.getBoolean(0, false));
    paramContext.recycle();
    this.oH = new r();
    this.Qy = new n(this);
    setNestedScrollingEnabled(true);
    w.a(this, Qw);
    AppMethodBeat.o(252854);
  }
  
  private boolean E(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(252857);
    boolean bool = this.Qy.E(paramInt1, paramInt2);
    AppMethodBeat.o(252857);
    return bool;
  }
  
  private void a(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(252855);
    this.Qy.a(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2);
    AppMethodBeat.o(252855);
  }
  
  private boolean a(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt3)
  {
    AppMethodBeat.i(252862);
    boolean bool = this.Qy.a(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, paramInt3);
    AppMethodBeat.o(252862);
    return bool;
  }
  
  private boolean aA(View paramView)
  {
    AppMethodBeat.i(252959);
    if (!e(paramView, 0, getHeight()))
    {
      AppMethodBeat.o(252959);
      return true;
    }
    AppMethodBeat.o(252959);
    return false;
  }
  
  private void aB(View paramView)
  {
    AppMethodBeat.i(252979);
    paramView.getDrawingRect(this.mTempRect);
    offsetDescendantRectToMyCoords(paramView, this.mTempRect);
    int i = computeScrollDeltaToGetChildRectOnScreen(this.mTempRect);
    if (i != 0) {
      scrollBy(0, i);
    }
    AppMethodBeat.o(252979);
  }
  
  private void ae(boolean paramBoolean)
  {
    AppMethodBeat.i(252977);
    if (paramBoolean) {
      E(2, 1);
    }
    for (;;)
    {
      this.Qu = getScrollY();
      w.G(this);
      AppMethodBeat.o(252977);
      return;
      bw(1);
    }
  }
  
  private boolean arrowScroll(int paramInt)
  {
    AppMethodBeat.i(252958);
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
        bM(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
        localView2.requestFocus(paramInt);
        if ((localView1 != null) && (localView1.isFocused()) && (aA(localView1)))
        {
          paramInt = getDescendantFocusability();
          setDescendantFocusability(131072);
          requestFocus();
          setDescendantFocusability(paramInt);
        }
        AppMethodBeat.o(252958);
        return true;
      }
      if ((paramInt == 33) && (getScrollY() < i)) {
        i = getScrollY();
      }
      for (;;)
      {
        if (i == 0)
        {
          AppMethodBeat.o(252958);
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
            bM(i);
            break;
            i = -i;
          }
        }
      }
    }
  }
  
  private boolean bK(int paramInt)
  {
    AppMethodBeat.i(252953);
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
      boolean bool = d(paramInt, this.mTempRect.top, this.mTempRect.bottom);
      AppMethodBeat.o(252953);
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
  
  private void bM(int paramInt)
  {
    AppMethodBeat.i(252962);
    if (paramInt != 0)
    {
      if (this.Qq)
      {
        c(0, paramInt, false);
        AppMethodBeat.o(252962);
        return;
      }
      scrollBy(0, paramInt);
    }
    AppMethodBeat.o(252962);
  }
  
  private boolean bx(int paramInt)
  {
    AppMethodBeat.i(252860);
    boolean bool = this.Qy.bx(paramInt);
    AppMethodBeat.o(252860);
    return bool;
  }
  
  private View c(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(252952);
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
        AppMethodBeat.o(252952);
        return localObject;
      }
    }
  }
  
  private void c(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(252963);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(252963);
      return;
    }
    if (AnimationUtils.currentAnimationTimeMillis() - this.Qh > 250L)
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
      this.Qi.startScroll(getScrollX(), paramInt1, 0, paramInt2 - paramInt1, 250);
      ae(paramBoolean);
    }
    for (;;)
    {
      this.Qh = AnimationUtils.currentAnimationTimeMillis();
      AppMethodBeat.o(252963);
      return;
      if (!this.Qi.isFinished()) {
        hH();
      }
      scrollBy(paramInt1, paramInt2);
    }
  }
  
  private void c(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(252880);
    int i = getScrollY();
    scrollBy(0, paramInt1);
    i = getScrollY() - i;
    if (paramArrayOfInt != null) {
      paramArrayOfInt[1] += i;
    }
    this.Qy.a(i, paramInt1 - i, null, paramInt2, paramArrayOfInt);
    AppMethodBeat.o(252880);
  }
  
  private static boolean c(View paramView1, View paramView2)
  {
    AppMethodBeat.i(252992);
    if (paramView1 == paramView2)
    {
      AppMethodBeat.o(252992);
      return true;
    }
    paramView1 = paramView1.getParent();
    if (((paramView1 instanceof ViewGroup)) && (c((View)paramView1, paramView2)))
    {
      AppMethodBeat.o(252992);
      return true;
    }
    AppMethodBeat.o(252992);
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
  
  private boolean d(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = false;
    AppMethodBeat.i(252957);
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
      AppMethodBeat.o(252957);
      return bool1;
    }
    if (bool1) {
      paramInt2 -= i;
    }
    for (;;)
    {
      bM(paramInt2);
      bool1 = true;
      break;
      paramInt2 = paramInt3 - j;
    }
  }
  
  private boolean e(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(252960);
    paramView.getDrawingRect(this.mTempRect);
    offsetDescendantRectToMyCoords(paramView, this.mTempRect);
    if ((this.mTempRect.bottom + paramInt1 >= getScrollY()) && (this.mTempRect.top - paramInt1 <= getScrollY() + paramInt2))
    {
      AppMethodBeat.o(252960);
      return true;
    }
    AppMethodBeat.o(252960);
    return false;
  }
  
  private void endDrag()
  {
    AppMethodBeat.i(252995);
    this.mIsBeingDragged = false;
    hG();
    bw(0);
    if (this.Qj != null)
    {
      this.Qj.onRelease();
      this.Qk.onRelease();
    }
    AppMethodBeat.o(252995);
  }
  
  private boolean g(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(252950);
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
        if ((bool2) && (!bx(1))) {
          this.Qi.springBack(paramInt1, paramInt2, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(paramInt1, paramInt2, bool1, bool2);
        if ((bool1) || (bool2))
        {
          AppMethodBeat.o(252950);
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
        AppMethodBeat.o(252950);
        return false;
        label156:
        bool2 = false;
      }
      label162:
      bool1 = false;
      paramInt1 = i;
    }
  }
  
  private float getVerticalScrollFactorCompat()
  {
    AppMethodBeat.i(252947);
    if (this.Qz == 0.0F)
    {
      Object localObject = new TypedValue();
      Context localContext = getContext();
      if (!localContext.getTheme().resolveAttribute(16842829, (TypedValue)localObject, true))
      {
        localObject = new IllegalStateException("Expected theme to define listPreferredItemHeight.");
        AppMethodBeat.o(252947);
        throw ((Throwable)localObject);
      }
      this.Qz = ((TypedValue)localObject).getDimension(localContext.getResources().getDisplayMetrics());
    }
    float f = this.Qz;
    AppMethodBeat.o(252947);
    return f;
  }
  
  private boolean hE()
  {
    AppMethodBeat.i(252924);
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
      int i = localView.getHeight();
      int j = localLayoutParams.topMargin;
      if (localLayoutParams.bottomMargin + (i + j) > getHeight() - getPaddingTop() - getPaddingBottom())
      {
        AppMethodBeat.o(252924);
        return true;
      }
      AppMethodBeat.o(252924);
      return false;
    }
    AppMethodBeat.o(252924);
    return false;
  }
  
  private void hF()
  {
    AppMethodBeat.i(252935);
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    AppMethodBeat.o(252935);
  }
  
  private void hG()
  {
    AppMethodBeat.i(252936);
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
    AppMethodBeat.o(252936);
  }
  
  private void hH()
  {
    AppMethodBeat.i(252978);
    this.Qi.abortAnimation();
    bw(1);
    AppMethodBeat.o(252978);
  }
  
  private void hI()
  {
    AppMethodBeat.i(252999);
    if (getOverScrollMode() != 2)
    {
      if (this.Qj == null)
      {
        Context localContext = getContext();
        this.Qj = new EdgeEffect(localContext);
        this.Qk = new EdgeEffect(localContext);
        AppMethodBeat.o(252999);
      }
    }
    else
    {
      this.Qj = null;
      this.Qk = null;
    }
    AppMethodBeat.o(252999);
  }
  
  private void onSecondaryPointerUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(252945);
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.mActivePointerId) {
      if (i != 0) {
        break label69;
      }
    }
    label69:
    for (i = 1;; i = 0)
    {
      this.Ql = ((int)paramMotionEvent.getY(i));
      this.mActivePointerId = paramMotionEvent.getPointerId(i);
      if (this.mVelocityTracker != null) {
        this.mVelocityTracker.clear();
      }
      AppMethodBeat.o(252945);
      return;
    }
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(252886);
    c(paramInt4, paramInt5, null);
    AppMethodBeat.o(252886);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    AppMethodBeat.i(252888);
    a(paramInt1, paramInt2, paramArrayOfInt, null, paramInt3);
    AppMethodBeat.o(252888);
  }
  
  public final boolean a(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    return (paramInt1 & 0x2) != 0;
  }
  
  public void addView(View paramView)
  {
    AppMethodBeat.i(252913);
    if (getChildCount() > 0)
    {
      paramView = new IllegalStateException("ScrollView can host only one direct child");
      AppMethodBeat.o(252913);
      throw paramView;
    }
    super.addView(paramView);
    AppMethodBeat.o(252913);
  }
  
  public void addView(View paramView, int paramInt)
  {
    AppMethodBeat.i(252915);
    if (getChildCount() > 0)
    {
      paramView = new IllegalStateException("ScrollView can host only one direct child");
      AppMethodBeat.o(252915);
      throw paramView;
    }
    super.addView(paramView, paramInt);
    AppMethodBeat.o(252915);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(252920);
    if (getChildCount() > 0)
    {
      paramView = new IllegalStateException("ScrollView can host only one direct child");
      AppMethodBeat.o(252920);
      throw paramView;
    }
    super.addView(paramView, paramInt, paramLayoutParams);
    AppMethodBeat.o(252920);
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(252917);
    if (getChildCount() > 0)
    {
      paramView = new IllegalStateException("ScrollView can host only one direct child");
      AppMethodBeat.o(252917);
      throw paramView;
    }
    super.addView(paramView, paramLayoutParams);
    AppMethodBeat.o(252917);
  }
  
  public final void b(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(252879);
    c(paramInt1, paramInt2, paramArrayOfInt);
    AppMethodBeat.o(252879);
  }
  
  public final void b(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(252883);
    this.oH.F(paramInt1, paramInt2);
    E(2, paramInt2);
    AppMethodBeat.o(252883);
  }
  
  public final boolean bL(int paramInt)
  {
    AppMethodBeat.i(252955);
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
      boolean bool = d(paramInt, this.mTempRect.top, this.mTempRect.bottom);
      AppMethodBeat.o(252955);
      return bool;
    }
  }
  
  final void bN(int paramInt)
  {
    AppMethodBeat.i(252964);
    c(0 - getScrollX(), paramInt - getScrollY(), true);
    AppMethodBeat.o(252964);
  }
  
  public void bO(int paramInt)
  {
    AppMethodBeat.i(252994);
    if (getChildCount() > 0)
    {
      this.Qi.fling(getScrollX(), getScrollY(), 0, paramInt, 0, 0, -2147483648, 2147483647, 0, 0);
      ae(true);
    }
    AppMethodBeat.o(252994);
  }
  
  public final void bw(int paramInt)
  {
    AppMethodBeat.i(252859);
    this.Qy.bw(paramInt);
    AppMethodBeat.o(252859);
  }
  
  public int computeHorizontalScrollExtent()
  {
    AppMethodBeat.i(252972);
    int i = super.computeHorizontalScrollExtent();
    AppMethodBeat.o(252972);
    return i;
  }
  
  public int computeHorizontalScrollOffset()
  {
    AppMethodBeat.i(252971);
    int i = super.computeHorizontalScrollOffset();
    AppMethodBeat.o(252971);
    return i;
  }
  
  public int computeHorizontalScrollRange()
  {
    AppMethodBeat.i(252969);
    int i = super.computeHorizontalScrollRange();
    AppMethodBeat.o(252969);
    return i;
  }
  
  public void computeScroll()
  {
    int k = 0;
    AppMethodBeat.i(252975);
    if (this.Qi.isFinished())
    {
      AppMethodBeat.o(252975);
      return;
    }
    this.Qi.computeScrollOffset();
    int i = this.Qi.getCurrY();
    int j = i - this.Qu;
    this.Qu = i;
    this.Qs[1] = 0;
    a(0, j, this.Qs, null, 1);
    j -= this.Qs[1];
    int m = getScrollRange();
    i = j;
    if (j != 0)
    {
      i = getScrollY();
      g(j, getScrollX(), i, m);
      i = getScrollY() - i;
      j -= i;
      this.Qs[1] = 0;
      a(i, j, this.Qr, 1, this.Qs);
      i = j - this.Qs[1];
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
        hI();
        if (i >= 0) {
          break label248;
        }
        if (this.Qj.isFinished()) {
          this.Qj.onAbsorb((int)this.Qi.getCurrVelocity());
        }
      }
    }
    for (;;)
    {
      hH();
      if (this.Qi.isFinished()) {
        break;
      }
      w.G(this);
      AppMethodBeat.o(252975);
      return;
      label248:
      if (this.Qk.isFinished()) {
        this.Qk.onAbsorb((int)this.Qi.getCurrVelocity());
      }
    }
    bw(1);
    AppMethodBeat.o(252975);
  }
  
  protected int computeScrollDeltaToGetChildRectOnScreen(Rect paramRect)
  {
    AppMethodBeat.i(252980);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(252980);
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
          AppMethodBeat.o(252980);
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
  
  public int computeVerticalScrollExtent()
  {
    AppMethodBeat.i(252967);
    int i = super.computeVerticalScrollExtent();
    AppMethodBeat.o(252967);
    return i;
  }
  
  public int computeVerticalScrollOffset()
  {
    AppMethodBeat.i(252966);
    int i = Math.max(0, super.computeVerticalScrollOffset());
    AppMethodBeat.o(252966);
    return i;
  }
  
  public int computeVerticalScrollRange()
  {
    AppMethodBeat.i(252965);
    int j = getChildCount();
    int i = getHeight() - getPaddingBottom() - getPaddingTop();
    if (j == 0)
    {
      AppMethodBeat.o(252965);
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
      AppMethodBeat.o(252965);
      return i;
      i = j;
      if (k > m) {
        i = j + (k - m);
      }
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(252929);
    if ((super.dispatchKeyEvent(paramKeyEvent)) || (executeKeyEvent(paramKeyEvent)))
    {
      AppMethodBeat.o(252929);
      return true;
    }
    AppMethodBeat.o(252929);
    return false;
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(252876);
    paramBoolean = this.Qy.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
    AppMethodBeat.o(252876);
    return paramBoolean;
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(252877);
    boolean bool = this.Qy.dispatchNestedPreFling(paramFloat1, paramFloat2);
    AppMethodBeat.o(252877);
    return bool;
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(252874);
    boolean bool = a(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, 0);
    AppMethodBeat.o(252874);
    return bool;
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(252872);
    boolean bool = this.Qy.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
    AppMethodBeat.o(252872);
    return bool;
  }
  
  public void draw(Canvas paramCanvas)
  {
    int n = 0;
    AppMethodBeat.i(253000);
    super.draw(paramCanvas);
    int i3;
    int i4;
    int j;
    int i2;
    int i1;
    if (this.Qj != null)
    {
      i3 = getScrollY();
      if (!this.Qj.isFinished())
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
      this.Qj.setSize(j, k);
      if (this.Qj.draw(paramCanvas)) {
        w.G(this);
      }
      paramCanvas.restoreToCount(i4);
      if (!this.Qk.isFinished())
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
        this.Qk.setSize(i, k);
        if (this.Qk.draw(paramCanvas)) {
          w.G(this);
        }
        paramCanvas.restoreToCount(i4);
      }
      AppMethodBeat.o(253000);
      return;
    }
  }
  
  public final boolean executeKeyEvent(KeyEvent paramKeyEvent)
  {
    int i = 33;
    AppMethodBeat.i(252932);
    this.mTempRect.setEmpty();
    if (!hE())
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
          AppMethodBeat.o(252932);
          return true;
        }
        AppMethodBeat.o(252932);
        return false;
      }
      AppMethodBeat.o(252932);
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
        AppMethodBeat.o(252932);
        return bool;
        if (!paramKeyEvent.isAltPressed())
        {
          bool = arrowScroll(33);
        }
        else
        {
          bool = bL(33);
          continue;
          if (!paramKeyEvent.isAltPressed()) {
            bool = arrowScroll(130);
          } else {
            bool = bL(130);
          }
        }
      }
    }
    if (paramKeyEvent.isShiftPressed()) {}
    for (;;)
    {
      bK(i);
      break;
      i = 130;
    }
  }
  
  protected float getBottomFadingEdgeStrength()
  {
    AppMethodBeat.i(252909);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(252909);
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
      AppMethodBeat.o(252909);
      return f;
    }
    AppMethodBeat.o(252909);
    return 1.0F;
  }
  
  public int getMaxScrollAmount()
  {
    AppMethodBeat.i(252911);
    int i = (int)(0.5F * getHeight());
    AppMethodBeat.o(252911);
    return i;
  }
  
  public int getNestedScrollAxes()
  {
    AppMethodBeat.i(252902);
    int i = this.oH.getNestedScrollAxes();
    AppMethodBeat.o(252902);
    return i;
  }
  
  int getScrollRange()
  {
    AppMethodBeat.i(252951);
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
      AppMethodBeat.o(252951);
      return i;
    }
  }
  
  protected float getTopFadingEdgeStrength()
  {
    AppMethodBeat.i(252907);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(252907);
      return 0.0F;
    }
    int i = getVerticalFadingEdgeLength();
    int j = getScrollY();
    if (j < i)
    {
      float f = j / i;
      AppMethodBeat.o(252907);
      return f;
    }
    AppMethodBeat.o(252907);
    return 1.0F;
  }
  
  public boolean hasNestedScrollingParent()
  {
    AppMethodBeat.i(252870);
    boolean bool = bx(0);
    AppMethodBeat.o(252870);
    return bool;
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return this.Qy.Np;
  }
  
  public final void l(View paramView, int paramInt)
  {
    AppMethodBeat.i(252884);
    this.oH.bz(paramInt);
    bw(paramInt);
    AppMethodBeat.o(252884);
  }
  
  protected void measureChild(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(252973);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    paramView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight(), localLayoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
    AppMethodBeat.o(252973);
  }
  
  protected void measureChildWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(252974);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    paramInt1 = getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin + paramInt2, localMarginLayoutParams.width);
    paramInt2 = localMarginLayoutParams.topMargin;
    paramView.measure(paramInt1, View.MeasureSpec.makeMeasureSpec(localMarginLayoutParams.bottomMargin + paramInt2, 0));
    AppMethodBeat.o(252974);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(252990);
    super.onAttachedToWindow();
    this.Qn = false;
    AppMethodBeat.o(252990);
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(252946);
    if ((paramMotionEvent.getSource() & 0x2) != 0) {
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(252946);
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
            AppMethodBeat.o(252946);
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
    AppMethodBeat.i(252940);
    int i = paramMotionEvent.getAction();
    if ((i == 2) && (this.mIsBeingDragged))
    {
      AppMethodBeat.o(252940);
      return true;
    }
    switch (i & 0xFF)
    {
    }
    for (;;)
    {
      bool = this.mIsBeingDragged;
      AppMethodBeat.o(252940);
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
          if ((Math.abs(i - this.Ql) > this.mTouchSlop) && ((getNestedScrollAxes() & 0x2) == 0))
          {
            this.mIsBeingDragged = true;
            this.Ql = i;
            hF();
            this.mVelocityTracker.addMovement(paramMotionEvent);
            this.Qt = 0;
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
                hG();
                break;
                i = 0;
                continue;
                i = 0;
              }
              label320:
              this.Ql = j;
              this.mActivePointerId = paramMotionEvent.getPointerId(0);
              if (this.mVelocityTracker == null)
              {
                this.mVelocityTracker = VelocityTracker.obtain();
                label348:
                this.mVelocityTracker.addMovement(paramMotionEvent);
                this.Qi.computeScrollOffset();
                if (this.Qi.isFinished()) {
                  break label400;
                }
              }
              for (;;)
              {
                this.mIsBeingDragged = bool;
                E(2, 0);
                break;
                this.mVelocityTracker.clear();
                break label348;
                label400:
                bool = false;
              }
              this.mIsBeingDragged = false;
              this.mActivePointerId = -1;
              hG();
              if (this.Qi.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                w.G(this);
              }
              bw(0);
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
    AppMethodBeat.i(252988);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.Qm = false;
    if ((this.Qo != null) && (c(this.Qo, this))) {
      aB(this.Qo);
    }
    this.Qo = null;
    if (!this.Qn)
    {
      if (this.Qv != null)
      {
        scrollTo(getScrollX(), this.Qv.QB);
        this.Qv = null;
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
    this.Qn = true;
    AppMethodBeat.o(252988);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(252928);
    super.onMeasure(paramInt1, paramInt2);
    if (!this.Qp)
    {
      AppMethodBeat.o(252928);
      return;
    }
    if (View.MeasureSpec.getMode(paramInt2) == 0)
    {
      AppMethodBeat.o(252928);
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
    AppMethodBeat.o(252928);
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(252900);
    if (!paramBoolean)
    {
      dispatchNestedFling(0.0F, paramFloat2, true);
      bO((int)paramFloat2);
      AppMethodBeat.o(252900);
      return true;
    }
    AppMethodBeat.o(252900);
    return false;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(252901);
    boolean bool = dispatchNestedPreFling(paramFloat1, paramFloat2);
    AppMethodBeat.o(252901);
    return bool;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(252898);
    a(paramView, paramInt1, paramInt2, paramArrayOfInt, 0);
    AppMethodBeat.o(252898);
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(252896);
    c(paramInt4, 0, null);
    AppMethodBeat.o(252896);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    AppMethodBeat.i(252892);
    b(paramView1, paramView2, paramInt, 0);
    AppMethodBeat.o(252892);
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(252949);
    super.scrollTo(paramInt1, paramInt2);
    AppMethodBeat.o(252949);
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    AppMethodBeat.i(252984);
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
      AppMethodBeat.o(252984);
      return false;
      i = paramInt;
      if (paramInt != 1) {
        break;
      }
      i = 33;
      break;
    }
    label70:
    if (aA(localView))
    {
      AppMethodBeat.o(252984);
      return false;
    }
    boolean bool = localView.requestFocus(i, paramRect);
    AppMethodBeat.o(252984);
    return bool;
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(253002);
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(253002);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.Qv = paramParcelable;
    requestLayout();
    AppMethodBeat.o(253002);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(253004);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.QB = getScrollY();
    AppMethodBeat.o(253004);
    return localSavedState;
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(252927);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.QA != null) {
      this.QA.a(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(252927);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(252991);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = findFocus();
    if ((localView == null) || (this == localView))
    {
      AppMethodBeat.o(252991);
      return;
    }
    if (e(localView, 0, paramInt4))
    {
      localView.getDrawingRect(this.mTempRect);
      offsetDescendantRectToMyCoords(localView, this.mTempRect);
      bM(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
    }
    AppMethodBeat.o(252991);
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    AppMethodBeat.i(252890);
    boolean bool = a(paramView1, paramView2, paramInt, 0);
    AppMethodBeat.o(252890);
    return bool;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    AppMethodBeat.i(252895);
    l(paramView, 0);
    AppMethodBeat.o(252895);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(252944);
    hF();
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      this.Qt = 0;
    }
    MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
    localMotionEvent.offsetLocation(0.0F, this.Qt);
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
      AppMethodBeat.o(252944);
      return true;
      if (getChildCount() == 0)
      {
        AppMethodBeat.o(252944);
        return false;
      }
      if (!this.Qi.isFinished()) {}
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
        if (!this.Qi.isFinished()) {
          hH();
        }
        this.Ql = ((int)paramMotionEvent.getY());
        this.mActivePointerId = paramMotionEvent.getPointerId(0);
        E(2, 0);
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
        int j = this.Ql - m;
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
          if (a(0, i, this.Qs, this.Qr, 0))
          {
            j = i - this.Qs[1];
            this.Qt += this.Qr[1];
          }
          this.Ql = (m - this.Qr[1]);
          int n = getScrollY();
          m = getScrollRange();
          i = getOverScrollMode();
          if ((i == 0) || ((i == 1) && (m > 0)))
          {
            i = 1;
            if ((g(j, 0, getScrollY(), m)) && (!bx(0))) {
              this.mVelocityTracker.clear();
            }
            int i1 = getScrollY() - n;
            this.Qs[1] = 0;
            a(i1, j - i1, this.Qr, 0, this.Qs);
            this.Ql -= this.Qr[1];
            this.Qt += this.Qr[1];
            if (i == 0) {
              continue;
            }
            i = j - this.Qs[1];
            hI();
            j = n + i;
            if (j >= 0) {
              break label647;
            }
            d.a(this.Qj, i / getHeight(), paramMotionEvent.getX(k) / getWidth());
            if (!this.Qk.isFinished()) {
              this.Qk.onRelease();
            }
          }
          while ((this.Qj != null) && ((!this.Qj.isFinished()) || (!this.Qk.isFinished())))
          {
            w.G(this);
            break;
            label632:
            i = j + this.mTouchSlop;
            break label336;
            i = 0;
            break label433;
            if (j > m)
            {
              d.a(this.Qk, i / getHeight(), 1.0F - paramMotionEvent.getX(k) / getWidth());
              if (!this.Qj.isFinished()) {
                this.Qj.onRelease();
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
              bO(-i);
            }
          }
          for (;;)
          {
            this.mActivePointerId = -1;
            endDrag();
            break;
            if (this.Qi.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
              w.G(this);
            }
          }
          if ((this.mIsBeingDragged) && (getChildCount() > 0) && (this.Qi.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()))) {
            w.G(this);
          }
          this.mActivePointerId = -1;
          endDrag();
          continue;
          i = paramMotionEvent.getActionIndex();
          this.Ql = ((int)paramMotionEvent.getY(i));
          this.mActivePointerId = paramMotionEvent.getPointerId(i);
          continue;
          onSecondaryPointerUp(paramMotionEvent);
          this.Ql = ((int)paramMotionEvent.getY(paramMotionEvent.findPointerIndex(this.mActivePointerId)));
        }
      }
    }
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    AppMethodBeat.i(252981);
    if (!this.Qm) {
      aB(paramView2);
    }
    for (;;)
    {
      super.requestChildFocus(paramView1, paramView2);
      AppMethodBeat.o(252981);
      return;
      this.Qo = paramView2;
    }
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    AppMethodBeat.i(252985);
    paramRect.offset(paramView.getLeft() - paramView.getScrollX(), paramView.getTop() - paramView.getScrollY());
    int i = computeScrollDeltaToGetChildRectOnScreen(paramRect);
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
      AppMethodBeat.o(252985);
      return bool;
      bool = false;
      break;
      label74:
      c(0, i, false);
    }
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(252937);
    if (paramBoolean) {
      hG();
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    AppMethodBeat.o(252937);
  }
  
  public void requestLayout()
  {
    AppMethodBeat.i(252986);
    this.Qm = true;
    super.requestLayout();
    AppMethodBeat.o(252986);
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(252997);
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
    AppMethodBeat.o(252997);
  }
  
  public void setFillViewport(boolean paramBoolean)
  {
    AppMethodBeat.i(252925);
    if (paramBoolean != this.Qp)
    {
      this.Qp = paramBoolean;
      requestLayout();
    }
    AppMethodBeat.o(252925);
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(252864);
    this.Qy.setNestedScrollingEnabled(paramBoolean);
    AppMethodBeat.o(252864);
  }
  
  public void setOnScrollChangeListener(NestedScrollView.b paramb)
  {
    this.QA = paramb;
  }
  
  public void setSmoothScrollingEnabled(boolean paramBoolean)
  {
    this.Qq = paramBoolean;
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return true;
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    AppMethodBeat.i(252866);
    boolean bool = E(paramInt, 0);
    AppMethodBeat.o(252866);
    return bool;
  }
  
  public void stopNestedScroll()
  {
    AppMethodBeat.i(252868);
    bw(0);
    AppMethodBeat.o(252868);
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    public int QB;
    
    static
    {
      AppMethodBeat.i(252778);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(252778);
    }
    
    SavedState(Parcel paramParcel)
    {
      super();
      AppMethodBeat.i(252770);
      this.QB = paramParcel.readInt();
      AppMethodBeat.o(252770);
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      AppMethodBeat.i(252775);
      String str = "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.QB + "}";
      AppMethodBeat.o(252775);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(252774);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.QB);
      AppMethodBeat.o(252774);
    }
  }
  
  static final class a
    extends a
  {
    public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      AppMethodBeat.i(252639);
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
        AppMethodBeat.o(252639);
        return;
      }
    }
    
    public final void onInitializeAccessibilityNodeInfo(View paramView, androidx.core.g.a.d paramd)
    {
      AppMethodBeat.i(252638);
      super.onInitializeAccessibilityNodeInfo(paramView, paramd);
      paramView = (NestedScrollView)paramView;
      paramd.t(ScrollView.class.getName());
      if (paramView.isEnabled())
      {
        int i = paramView.getScrollRange();
        if (i > 0)
        {
          paramd.ab(true);
          if (paramView.getScrollY() > 0)
          {
            paramd.a(d.a.OO);
            paramd.a(d.a.Pa);
          }
          if (paramView.getScrollY() < i)
          {
            paramd.a(d.a.OM);
            paramd.a(d.a.Pc);
          }
        }
      }
      AppMethodBeat.o(252638);
    }
    
    public final boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(252635);
      if (super.performAccessibilityAction(paramView, paramInt, paramBundle))
      {
        AppMethodBeat.o(252635);
        return true;
      }
      paramView = (NestedScrollView)paramView;
      if (!paramView.isEnabled())
      {
        AppMethodBeat.o(252635);
        return false;
      }
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(252635);
        return false;
      case 4096: 
      case 16908346: 
        paramInt = Math.min(paramView.getHeight() - paramView.getPaddingBottom() - paramView.getPaddingTop() + paramView.getScrollY(), paramView.getScrollRange());
        if (paramInt != paramView.getScrollY())
        {
          paramView.bN(paramInt);
          AppMethodBeat.o(252635);
          return true;
        }
        AppMethodBeat.o(252635);
        return false;
      }
      paramInt = paramView.getHeight();
      int i = paramView.getPaddingBottom();
      int j = paramView.getPaddingTop();
      paramInt = Math.max(paramView.getScrollY() - (paramInt - i - j), 0);
      if (paramInt != paramView.getScrollY())
      {
        paramView.bN(paramInt);
        AppMethodBeat.o(252635);
        return true;
      }
      AppMethodBeat.o(252635);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.core.widget.NestedScrollView
 * JD-Core Version:    0.7.0.1
 */