package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.core.g.a.d;
import androidx.core.g.ae;
import androidx.core.g.ae.e;
import androidx.core.g.s;
import androidx.core.g.w;
import androidx.customview.view.AbsSavedState;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager
  extends ViewGroup
{
  private static final int CLOSE_ENOUGH = 2;
  private static final Comparator<ItemInfo> COMPARATOR;
  private static final boolean DEBUG = false;
  private static final int DEFAULT_GUTTER_SIZE = 16;
  private static final int DEFAULT_OFFSCREEN_PAGES = 1;
  private static final int DRAW_ORDER_DEFAULT = 0;
  private static final int DRAW_ORDER_FORWARD = 1;
  private static final int DRAW_ORDER_REVERSE = 2;
  private static final int INVALID_POINTER = -1;
  static final int[] LAYOUT_ATTRS;
  private static final int MAX_SETTLE_DURATION = 600;
  private static final int MIN_DISTANCE_FOR_FLING = 25;
  private static final int MIN_FLING_VELOCITY = 400;
  public static final int SCROLL_STATE_DRAGGING = 1;
  public static final int SCROLL_STATE_IDLE = 0;
  public static final int SCROLL_STATE_SETTLING = 2;
  private static final String TAG = "ViewPager";
  private static final boolean USE_CACHE = false;
  private static final Interpolator sInterpolator;
  private static final g sPositionComparator;
  private int mActivePointerId;
  a mAdapter;
  private List<c> mAdapterChangeListeners;
  private int mBottomPageBounds;
  private boolean mCalledSuper;
  private int mChildHeightMeasureSpec;
  private int mChildWidthMeasureSpec;
  private int mCloseEnough;
  int mCurItem;
  private int mDecorChildCount;
  private int mDefaultGutterSize;
  private int mDrawingOrder;
  private ArrayList<View> mDrawingOrderedChildren;
  private final Runnable mEndScrollRunnable;
  private int mExpectedAdapterCount;
  private long mFakeDragBeginTime;
  private boolean mFakeDragging;
  private boolean mFirstLayout;
  private float mFirstOffset;
  private int mFlingDistance;
  private int mGutterSize;
  private boolean mInLayout;
  private float mInitialMotionX;
  private float mInitialMotionY;
  private ViewPager.OnPageChangeListener mInternalPageChangeListener;
  private boolean mIsBeingDragged;
  private boolean mIsScrollStarted;
  private boolean mIsUnableToDrag;
  private final ArrayList<ItemInfo> mItems;
  private float mLastMotionX;
  private float mLastMotionY;
  private float mLastOffset;
  private EdgeEffect mLeftEdge;
  private Drawable mMarginDrawable;
  private int mMaximumVelocity;
  private int mMinimumVelocity;
  private boolean mNeedCalculatePageOffsets;
  private e mObserver;
  private int mOffscreenPageLimit;
  private ViewPager.OnPageChangeListener mOnPageChangeListener;
  private List<ViewPager.OnPageChangeListener> mOnPageChangeListeners;
  private int mPageMargin;
  private d mPageTransformer;
  private int mPageTransformerLayerType;
  private boolean mPopulatePending;
  private Parcelable mRestoredAdapterState;
  private ClassLoader mRestoredClassLoader;
  private int mRestoredCurItem;
  private EdgeEffect mRightEdge;
  private int mScrollState;
  public Scroller mScroller;
  private boolean mScrollingCacheEnabled;
  private final ItemInfo mTempItem;
  private final Rect mTempRect;
  private int mTopPageBounds;
  private int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  
  static
  {
    AppMethodBeat.i(235499);
    LAYOUT_ATTRS = new int[] { 16842931 };
    COMPARATOR = new Comparator() {};
    sInterpolator = new Interpolator()
    {
      public final float getInterpolation(float paramAnonymousFloat)
      {
        paramAnonymousFloat -= 1.0F;
        return paramAnonymousFloat * (paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat) + 1.0F;
      }
    };
    sPositionComparator = new g();
    AppMethodBeat.o(235499);
  }
  
  public ViewPager(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(235292);
    this.mItems = new ArrayList();
    this.mTempItem = new ItemInfo();
    this.mTempRect = new Rect();
    this.mRestoredCurItem = -1;
    this.mRestoredAdapterState = null;
    this.mRestoredClassLoader = null;
    this.mFirstOffset = -3.402824E+038F;
    this.mLastOffset = 3.4028235E+38F;
    this.mOffscreenPageLimit = 1;
    this.mActivePointerId = -1;
    this.mFirstLayout = true;
    this.mNeedCalculatePageOffsets = false;
    this.mEndScrollRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(235194);
        ViewPager.this.setScrollState(0);
        ViewPager.this.populate();
        AppMethodBeat.o(235194);
      }
    };
    this.mScrollState = 0;
    initViewPager();
    AppMethodBeat.o(235292);
  }
  
  public ViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(235295);
    this.mItems = new ArrayList();
    this.mTempItem = new ItemInfo();
    this.mTempRect = new Rect();
    this.mRestoredCurItem = -1;
    this.mRestoredAdapterState = null;
    this.mRestoredClassLoader = null;
    this.mFirstOffset = -3.402824E+038F;
    this.mLastOffset = 3.4028235E+38F;
    this.mOffscreenPageLimit = 1;
    this.mActivePointerId = -1;
    this.mFirstLayout = true;
    this.mNeedCalculatePageOffsets = false;
    this.mEndScrollRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(235194);
        ViewPager.this.setScrollState(0);
        ViewPager.this.populate();
        AppMethodBeat.o(235194);
      }
    };
    this.mScrollState = 0;
    initViewPager();
    AppMethodBeat.o(235295);
  }
  
  private void calculatePageOffsets(ItemInfo paramItemInfo1, int paramInt, ItemInfo paramItemInfo2)
  {
    AppMethodBeat.i(235380);
    int m = this.mAdapter.getCount();
    int i = getClientWidth();
    float f2;
    if (i > 0)
    {
      f2 = this.mPageMargin / i;
      if (paramItemInfo2 == null) {
        break label414;
      }
      i = paramItemInfo2.position;
      if (i < paramItemInfo1.position)
      {
        f1 = paramItemInfo2.offset + paramItemInfo2.widthFactor + f2;
        i += 1;
        j = 0;
      }
    }
    else
    {
      for (;;)
      {
        if ((i > paramItemInfo1.position) || (j >= this.mItems.size())) {
          break label414;
        }
        for (paramItemInfo2 = (ItemInfo)this.mItems.get(j);; paramItemInfo2 = (ItemInfo)this.mItems.get(j))
        {
          k = i;
          f3 = f1;
          if (i <= paramItemInfo2.position) {
            break;
          }
          k = i;
          f3 = f1;
          if (j >= this.mItems.size() - 1) {
            break;
          }
          j += 1;
        }
        f2 = 0.0F;
        break;
        while (k < paramItemInfo2.position)
        {
          f3 += this.mAdapter.getPageWidth(k) + f2;
          k += 1;
        }
        paramItemInfo2.offset = f3;
        f1 = f3 + (paramItemInfo2.widthFactor + f2);
        i = k + 1;
      }
    }
    if (i > paramItemInfo1.position)
    {
      j = this.mItems.size() - 1;
      f1 = paramItemInfo2.offset;
      i -= 1;
      while ((i >= paramItemInfo1.position) && (j >= 0))
      {
        for (paramItemInfo2 = (ItemInfo)this.mItems.get(j);; paramItemInfo2 = (ItemInfo)this.mItems.get(j))
        {
          k = i;
          f3 = f1;
          if (i >= paramItemInfo2.position) {
            break;
          }
          k = i;
          f3 = f1;
          if (j <= 0) {
            break;
          }
          j -= 1;
        }
        while (k > paramItemInfo2.position)
        {
          f3 -= this.mAdapter.getPageWidth(k) + f2;
          k -= 1;
        }
        f1 = f3 - (paramItemInfo2.widthFactor + f2);
        paramItemInfo2.offset = f1;
        i = k - 1;
      }
    }
    label414:
    int k = this.mItems.size();
    float f3 = paramItemInfo1.offset;
    i = paramItemInfo1.position - 1;
    if (paramItemInfo1.position == 0)
    {
      f1 = paramItemInfo1.offset;
      this.mFirstOffset = f1;
      if (paramItemInfo1.position != m - 1) {
        break label555;
      }
      f1 = paramItemInfo1.offset + paramItemInfo1.widthFactor - 1.0F;
      label480:
      this.mLastOffset = f1;
      j = paramInt - 1;
      f1 = f3;
    }
    for (;;)
    {
      if (j < 0) {
        break label608;
      }
      paramItemInfo2 = (ItemInfo)this.mItems.get(j);
      for (;;)
      {
        if (i > paramItemInfo2.position)
        {
          f1 -= this.mAdapter.getPageWidth(i) + f2;
          i -= 1;
          continue;
          f1 = -3.402824E+038F;
          break;
          label555:
          f1 = 3.4028235E+38F;
          break label480;
        }
      }
      f1 -= paramItemInfo2.widthFactor + f2;
      paramItemInfo2.offset = f1;
      if (paramItemInfo2.position == 0) {
        this.mFirstOffset = f1;
      }
      i -= 1;
      j -= 1;
    }
    label608:
    float f1 = paramItemInfo1.offset + paramItemInfo1.widthFactor + f2;
    int j = paramItemInfo1.position + 1;
    i = paramInt + 1;
    paramInt = j;
    while (i < k)
    {
      paramItemInfo1 = (ItemInfo)this.mItems.get(i);
      while (paramInt < paramItemInfo1.position)
      {
        f1 += this.mAdapter.getPageWidth(paramInt) + f2;
        paramInt += 1;
      }
      if (paramItemInfo1.position == m - 1) {
        this.mLastOffset = (paramItemInfo1.widthFactor + f1 - 1.0F);
      }
      paramItemInfo1.offset = f1;
      f1 += paramItemInfo1.widthFactor + f2;
      paramInt += 1;
      i += 1;
    }
    this.mNeedCalculatePageOffsets = false;
    AppMethodBeat.o(235380);
  }
  
  private void completeScroll(boolean paramBoolean)
  {
    AppMethodBeat.i(235424);
    int i;
    if (this.mScrollState == 2)
    {
      i = 1;
      if (i != 0)
      {
        setScrollingCacheEnabled(false);
        if (this.mScroller.isFinished()) {
          break label176;
        }
      }
    }
    label176:
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        this.mScroller.abortAnimation();
        j = getScrollX();
        k = getScrollY();
        int m = this.mScroller.getCurrX();
        int n = this.mScroller.getCurrY();
        if ((j != m) || (k != n))
        {
          scrollTo(m, n);
          if (m != j) {
            pageScrolled(m);
          }
        }
      }
      this.mPopulatePending = false;
      int k = 0;
      j = i;
      i = k;
      while (i < this.mItems.size())
      {
        ItemInfo localItemInfo = (ItemInfo)this.mItems.get(i);
        if (localItemInfo.scrolling)
        {
          localItemInfo.scrolling = false;
          j = 1;
        }
        i += 1;
      }
      i = 0;
      break;
    }
    if (j != 0)
    {
      if (paramBoolean)
      {
        w.a(this, this.mEndScrollRunnable);
        AppMethodBeat.o(235424);
        return;
      }
      this.mEndScrollRunnable.run();
    }
    AppMethodBeat.o(235424);
  }
  
  private int determineTargetPage(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(235437);
    if ((Math.abs(paramInt3) > this.mFlingDistance) && (Math.abs(paramInt2) > this.mMinimumVelocity))
    {
      if (paramInt2 > 0) {}
      for (;;)
      {
        paramInt2 = paramInt1;
        if (this.mItems.size() > 0)
        {
          ItemInfo localItemInfo1 = (ItemInfo)this.mItems.get(0);
          ItemInfo localItemInfo2 = (ItemInfo)this.mItems.get(this.mItems.size() - 1);
          paramInt2 = Math.max(localItemInfo1.position, Math.min(paramInt1, localItemInfo2.position));
        }
        AppMethodBeat.o(235437);
        return paramInt2;
        paramInt1 += 1;
      }
    }
    if (paramInt1 >= this.mCurItem) {}
    for (float f = 0.4F;; f = 0.6F)
    {
      paramInt1 += (int)(f + paramFloat);
      break;
    }
  }
  
  private void dispatchOnPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    AppMethodBeat.i(235418);
    if (this.mOnPageChangeListener != null) {
      this.mOnPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
    if (this.mOnPageChangeListeners != null)
    {
      int j = this.mOnPageChangeListeners.size();
      int i = 0;
      while (i < j)
      {
        ViewPager.OnPageChangeListener localOnPageChangeListener = (ViewPager.OnPageChangeListener)this.mOnPageChangeListeners.get(i);
        if (localOnPageChangeListener != null) {
          localOnPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2);
        }
        i += 1;
      }
    }
    if (this.mInternalPageChangeListener != null) {
      this.mInternalPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
    AppMethodBeat.o(235418);
  }
  
  private void dispatchOnPageSelected(int paramInt)
  {
    AppMethodBeat.i(235420);
    if (this.mOnPageChangeListener != null) {
      this.mOnPageChangeListener.onPageSelected(paramInt);
    }
    if (this.mOnPageChangeListeners != null)
    {
      int j = this.mOnPageChangeListeners.size();
      int i = 0;
      while (i < j)
      {
        ViewPager.OnPageChangeListener localOnPageChangeListener = (ViewPager.OnPageChangeListener)this.mOnPageChangeListeners.get(i);
        if (localOnPageChangeListener != null) {
          localOnPageChangeListener.onPageSelected(paramInt);
        }
        i += 1;
      }
    }
    if (this.mInternalPageChangeListener != null) {
      this.mInternalPageChangeListener.onPageSelected(paramInt);
    }
    AppMethodBeat.o(235420);
  }
  
  private void dispatchOnScrollStateChanged(int paramInt)
  {
    AppMethodBeat.i(235422);
    if (this.mOnPageChangeListener != null) {
      this.mOnPageChangeListener.onPageScrollStateChanged(paramInt);
    }
    if (this.mOnPageChangeListeners != null)
    {
      int j = this.mOnPageChangeListeners.size();
      int i = 0;
      while (i < j)
      {
        ViewPager.OnPageChangeListener localOnPageChangeListener = (ViewPager.OnPageChangeListener)this.mOnPageChangeListeners.get(i);
        if (localOnPageChangeListener != null) {
          localOnPageChangeListener.onPageScrollStateChanged(paramInt);
        }
        i += 1;
      }
    }
    if (this.mInternalPageChangeListener != null) {
      this.mInternalPageChangeListener.onPageScrollStateChanged(paramInt);
    }
    AppMethodBeat.o(235422);
  }
  
  private void enableLayers(boolean paramBoolean)
  {
    AppMethodBeat.i(235427);
    int k = getChildCount();
    int i = 0;
    if (i < k)
    {
      if (paramBoolean) {}
      for (int j = this.mPageTransformerLayerType;; j = 0)
      {
        getChildAt(i).setLayerType(j, null);
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(235427);
  }
  
  private void endDrag()
  {
    AppMethodBeat.i(235450);
    this.mIsBeingDragged = false;
    this.mIsUnableToDrag = false;
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
    AppMethodBeat.o(235450);
  }
  
  private Rect getChildRectInPagerCoordinates(Rect paramRect, View paramView)
  {
    AppMethodBeat.i(235468);
    if (paramRect == null) {
      paramRect = new Rect();
    }
    for (;;)
    {
      if (paramView == null)
      {
        paramRect.set(0, 0, 0, 0);
        AppMethodBeat.o(235468);
        return paramRect;
      }
      paramRect.left = paramView.getLeft();
      paramRect.right = paramView.getRight();
      paramRect.top = paramView.getTop();
      paramRect.bottom = paramView.getBottom();
      for (paramView = paramView.getParent(); ((paramView instanceof ViewGroup)) && (paramView != this); paramView = paramView.getParent())
      {
        paramView = (ViewGroup)paramView;
        paramRect.left += paramView.getLeft();
        paramRect.right += paramView.getRight();
        paramRect.top += paramView.getTop();
        paramRect.bottom += paramView.getBottom();
      }
      AppMethodBeat.o(235468);
      return paramRect;
    }
  }
  
  private int getClientWidth()
  {
    AppMethodBeat.i(235309);
    int i = getMeasuredWidth();
    int j = getPaddingLeft();
    int k = getPaddingRight();
    AppMethodBeat.o(235309);
    return i - j - k;
  }
  
  private ItemInfo infoForCurrentScrollPosition()
  {
    AppMethodBeat.i(235436);
    int i = getClientWidth();
    float f1;
    float f2;
    label42:
    int k;
    int j;
    Object localObject;
    float f3;
    float f4;
    label59:
    ItemInfo localItemInfo;
    if (i > 0)
    {
      f1 = getScrollX() / i;
      if (i <= 0) {
        break label215;
      }
      f2 = this.mPageMargin / i;
      k = -1;
      j = 1;
      i = 0;
      localObject = null;
      f3 = 0.0F;
      f4 = 0.0F;
      if (i >= this.mItems.size()) {
        break label258;
      }
      localItemInfo = (ItemInfo)this.mItems.get(i);
      if ((j != 0) || (localItemInfo.position == k + 1)) {
        break label267;
      }
      localItemInfo = this.mTempItem;
      localItemInfo.offset = (f4 + f3 + f2);
      localItemInfo.position = (k + 1);
      localItemInfo.widthFactor = this.mAdapter.getPageWidth(localItemInfo.position);
      i -= 1;
    }
    label258:
    label267:
    for (;;)
    {
      f4 = localItemInfo.offset;
      f3 = localItemInfo.widthFactor;
      if ((j != 0) || (f1 >= f4))
      {
        if ((f1 >= f3 + f4 + f2) && (i != this.mItems.size() - 1)) {
          break label229;
        }
        AppMethodBeat.o(235436);
        return localItemInfo;
        f1 = 0.0F;
        break;
        label215:
        f2 = 0.0F;
        break label42;
      }
      AppMethodBeat.o(235436);
      return localObject;
      label229:
      k = localItemInfo.position;
      f3 = localItemInfo.widthFactor;
      i += 1;
      j = 0;
      localObject = localItemInfo;
      break label59;
      AppMethodBeat.o(235436);
      return localObject;
    }
  }
  
  private static boolean isDecorView(View paramView)
  {
    AppMethodBeat.i(235388);
    if (paramView.getClass().getAnnotation(ViewPager.a.class) != null)
    {
      AppMethodBeat.o(235388);
      return true;
    }
    AppMethodBeat.o(235388);
    return false;
  }
  
  private boolean isGutterDrag(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(235425);
    if (((paramFloat1 < this.mGutterSize) && (paramFloat2 > 0.0F)) || ((paramFloat1 > getWidth() - this.mGutterSize) && (paramFloat2 < 0.0F)))
    {
      AppMethodBeat.o(235425);
      return true;
    }
    AppMethodBeat.o(235425);
    return false;
  }
  
  private void onSecondaryPointerUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(235449);
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.mActivePointerId) {
      if (i != 0) {
        break label68;
      }
    }
    label68:
    for (i = 1;; i = 0)
    {
      this.mLastMotionX = paramMotionEvent.getX(i);
      this.mActivePointerId = paramMotionEvent.getPointerId(i);
      if (this.mVelocityTracker != null) {
        this.mVelocityTracker.clear();
      }
      AppMethodBeat.o(235449);
      return;
    }
  }
  
  private boolean pageScrolled(int paramInt)
  {
    AppMethodBeat.i(235415);
    if (this.mItems.size() == 0)
    {
      if (this.mFirstLayout)
      {
        AppMethodBeat.o(235415);
        return false;
      }
      this.mCalledSuper = false;
      onPageScrolled(0, 0.0F, 0);
      if (!this.mCalledSuper)
      {
        localObject = new IllegalStateException("onPageScrolled did not call superclass implementation");
        AppMethodBeat.o(235415);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(235415);
      return false;
    }
    Object localObject = infoForCurrentScrollPosition();
    int j = getClientWidth();
    int k = this.mPageMargin;
    float f = this.mPageMargin / j;
    int i = ((ItemInfo)localObject).position;
    f = (paramInt / j - ((ItemInfo)localObject).offset) / (((ItemInfo)localObject).widthFactor + f);
    paramInt = (int)((k + j) * f);
    this.mCalledSuper = false;
    onPageScrolled(i, f, paramInt);
    if (!this.mCalledSuper)
    {
      localObject = new IllegalStateException("onPageScrolled did not call superclass implementation");
      AppMethodBeat.o(235415);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(235415);
    return true;
  }
  
  private boolean performDrag(float paramFloat)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(235434);
    float f1 = this.mLastMotionX;
    this.mLastMotionX = paramFloat;
    float f2 = getScrollX() + (f1 - paramFloat);
    int k = getClientWidth();
    paramFloat = k * this.mFirstOffset;
    f1 = k;
    float f3 = this.mLastOffset;
    ItemInfo localItemInfo1 = (ItemInfo)this.mItems.get(0);
    ItemInfo localItemInfo2 = (ItemInfo)this.mItems.get(this.mItems.size() - 1);
    if (localItemInfo1.position != 0)
    {
      paramFloat = localItemInfo1.offset;
      paramFloat = k * paramFloat;
    }
    for (int i = 0;; i = 1)
    {
      int j;
      if (localItemInfo2.position != this.mAdapter.getCount() - 1)
      {
        f1 = localItemInfo2.offset * k;
        j = 0;
      }
      for (;;)
      {
        if (f2 < paramFloat)
        {
          if (i == 0) {
            break label263;
          }
          this.mLeftEdge.onPull(Math.abs(paramFloat - f2) / k);
        }
        for (;;)
        {
          this.mLastMotionX += paramFloat - (int)paramFloat;
          scrollTo((int)paramFloat, getScrollY());
          pageScrolled((int)paramFloat);
          AppMethodBeat.o(235434);
          return bool1;
          if (f2 > f1)
          {
            if (j != 0) {
              this.mRightEdge.onPull(Math.abs(f2 - f1) / k);
            }
            for (bool1 = bool2;; bool1 = false)
            {
              paramFloat = f1;
              break;
            }
          }
          bool1 = false;
          paramFloat = f2;
          continue;
          label263:
          bool1 = false;
        }
        j = 1;
        f1 *= f3;
      }
    }
  }
  
  private void recomputeScrollPosition(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(235405);
    if ((paramInt2 > 0) && (!this.mItems.isEmpty()))
    {
      if (!this.mScroller.isFinished())
      {
        this.mScroller.setFinalX(getCurrentItem() * getClientWidth());
        AppMethodBeat.o(235405);
        return;
      }
      int i = getPaddingLeft();
      int j = getPaddingRight();
      int k = getPaddingLeft();
      int m = getPaddingRight();
      f = getScrollX() / (paramInt2 - k - m + paramInt4);
      scrollTo((int)((paramInt1 - i - j + paramInt3) * f), getScrollY());
      AppMethodBeat.o(235405);
      return;
    }
    ItemInfo localItemInfo = infoForPosition(this.mCurItem);
    if (localItemInfo != null) {}
    for (float f = Math.min(localItemInfo.offset, this.mLastOffset);; f = 0.0F)
    {
      paramInt1 = (int)(f * (paramInt1 - getPaddingLeft() - getPaddingRight()));
      if (paramInt1 != getScrollX())
      {
        completeScroll(false);
        scrollTo(paramInt1, getScrollY());
      }
      AppMethodBeat.o(235405);
      return;
    }
  }
  
  private void removeNonDecorViews()
  {
    AppMethodBeat.i(235304);
    int j;
    for (int i = 0; i < getChildCount(); i = j + 1)
    {
      j = i;
      if (!((LayoutParams)getChildAt(i).getLayoutParams()).avM)
      {
        removeViewAt(i);
        j = i - 1;
      }
    }
    AppMethodBeat.o(235304);
  }
  
  private void requestParentDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(235432);
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
    AppMethodBeat.o(235432);
  }
  
  private boolean resetTouch()
  {
    AppMethodBeat.i(235431);
    this.mActivePointerId = -1;
    endDrag();
    this.mLeftEdge.onRelease();
    this.mRightEdge.onRelease();
    if ((this.mLeftEdge.isFinished()) || (this.mRightEdge.isFinished()))
    {
      AppMethodBeat.o(235431);
      return true;
    }
    AppMethodBeat.o(235431);
    return false;
  }
  
  private void scrollToItem(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    AppMethodBeat.i(235320);
    ItemInfo localItemInfo = infoForPosition(paramInt1);
    float f;
    if (localItemInfo != null) {
      f = getClientWidth();
    }
    for (int i = (int)(Math.max(this.mFirstOffset, Math.min(localItemInfo.offset, this.mLastOffset)) * f);; i = 0)
    {
      if (paramBoolean1)
      {
        smoothScrollTo(i, 0, paramInt2);
        if (paramBoolean2)
        {
          dispatchOnPageSelected(paramInt1);
          AppMethodBeat.o(235320);
        }
      }
      else
      {
        if (paramBoolean2) {
          dispatchOnPageSelected(paramInt1);
        }
        completeScroll(false);
        scrollTo(i, 0);
        pageScrolled(i);
      }
      AppMethodBeat.o(235320);
      return;
    }
  }
  
  private void setScrollingCacheEnabled(boolean paramBoolean)
  {
    if (this.mScrollingCacheEnabled != paramBoolean) {
      this.mScrollingCacheEnabled = paramBoolean;
    }
  }
  
  private void sortChildDrawingOrder()
  {
    AppMethodBeat.i(235376);
    if (this.mDrawingOrder != 0)
    {
      if (this.mDrawingOrderedChildren == null) {
        this.mDrawingOrderedChildren = new ArrayList();
      }
      for (;;)
      {
        int j = getChildCount();
        int i = 0;
        while (i < j)
        {
          View localView = getChildAt(i);
          this.mDrawingOrderedChildren.add(localView);
          i += 1;
        }
        this.mDrawingOrderedChildren.clear();
      }
      Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
    }
    AppMethodBeat.o(235376);
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(235475);
    int j = paramArrayList.size();
    int k = getDescendantFocusability();
    if (k != 393216)
    {
      int i = 0;
      while (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (localView.getVisibility() == 0)
        {
          ItemInfo localItemInfo = infoForChild(localView);
          if ((localItemInfo != null) && (localItemInfo.position == this.mCurItem)) {
            localView.addFocusables(paramArrayList, paramInt1, paramInt2);
          }
        }
        i += 1;
      }
    }
    if ((k != 262144) || (j == paramArrayList.size()))
    {
      if (!isFocusable())
      {
        AppMethodBeat.o(235475);
        return;
      }
      if (((paramInt2 & 0x1) == 1) && (isInTouchMode()) && (!isFocusableInTouchMode()))
      {
        AppMethodBeat.o(235475);
        return;
      }
      if (paramArrayList != null) {
        paramArrayList.add(this);
      }
    }
    AppMethodBeat.o(235475);
  }
  
  ItemInfo addNewItem(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(235360);
    ItemInfo localItemInfo = new ItemInfo();
    localItemInfo.position = paramInt1;
    localItemInfo.object = this.mAdapter.instantiateItem(this, paramInt1);
    localItemInfo.widthFactor = this.mAdapter.getPageWidth(paramInt1);
    if ((paramInt2 < 0) || (paramInt2 >= this.mItems.size())) {
      this.mItems.add(localItemInfo);
    }
    for (;;)
    {
      AppMethodBeat.o(235360);
      return localItemInfo;
      this.mItems.add(paramInt2, localItemInfo);
    }
  }
  
  public void addOnAdapterChangeListener(c paramc)
  {
    AppMethodBeat.i(235306);
    if (this.mAdapterChangeListeners == null) {
      this.mAdapterChangeListeners = new ArrayList();
    }
    this.mAdapterChangeListeners.add(paramc);
    AppMethodBeat.o(235306);
  }
  
  public void addOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    AppMethodBeat.i(235323);
    if (this.mOnPageChangeListeners == null) {
      this.mOnPageChangeListeners = new ArrayList();
    }
    this.mOnPageChangeListeners.add(paramOnPageChangeListener);
    AppMethodBeat.o(235323);
  }
  
  public void addTouchables(ArrayList<View> paramArrayList)
  {
    AppMethodBeat.i(235478);
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        ItemInfo localItemInfo = infoForChild(localView);
        if ((localItemInfo != null) && (localItemInfo.position == this.mCurItem)) {
          localView.addTouchables(paramArrayList);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(235478);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(235387);
    if (!checkLayoutParams(paramLayoutParams)) {
      paramLayoutParams = generateLayoutParams(paramLayoutParams);
    }
    for (;;)
    {
      LayoutParams localLayoutParams = (LayoutParams)paramLayoutParams;
      localLayoutParams.avM |= isDecorView(paramView);
      if (this.mInLayout)
      {
        if ((localLayoutParams != null) && (localLayoutParams.avM))
        {
          paramView = new IllegalStateException("Cannot add pager decor view during layout");
          AppMethodBeat.o(235387);
          throw paramView;
        }
        localLayoutParams.avN = true;
        addViewInLayout(paramView, paramInt, paramLayoutParams);
        AppMethodBeat.o(235387);
        return;
      }
      super.addView(paramView, paramInt, paramLayoutParams);
      AppMethodBeat.o(235387);
      return;
    }
  }
  
  public boolean arrowScroll(int paramInt)
  {
    AppMethodBeat.i(235466);
    View localView = findFocus();
    Object localObject;
    int j;
    boolean bool;
    if (localView == this)
    {
      localObject = null;
      localView = FocusFinder.getInstance().findNextFocus(this, (View)localObject, paramInt);
      if ((localView == null) || (localView == localObject)) {
        break label320;
      }
      if (paramInt != 17) {
        break label266;
      }
      i = getChildRectInPagerCoordinates(this.mTempRect, localView).left;
      j = getChildRectInPagerCoordinates(this.mTempRect, (View)localObject).left;
      if ((localObject != null) && (i >= j))
      {
        bool = pageLeft();
        label95:
        if (bool) {
          playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
        }
        AppMethodBeat.o(235466);
        return bool;
      }
    }
    else
    {
      if (localView == null) {
        break label366;
      }
      localObject = localView.getParent();
      if (!(localObject instanceof ViewGroup)) {
        break label373;
      }
      if (localObject != this) {}
    }
    label266:
    label320:
    label360:
    label366:
    label373:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localView.getClass().getSimpleName());
        localObject = localView.getParent();
        for (;;)
        {
          if ((localObject instanceof ViewGroup))
          {
            localStringBuilder.append(" => ").append(localObject.getClass().getSimpleName());
            localObject = ((ViewParent)localObject).getParent();
            continue;
            localObject = ((ViewParent)localObject).getParent();
            break;
          }
        }
        new StringBuilder("arrowScroll tried to find focus based on non-child current focused view ").append(localStringBuilder.toString());
        localObject = null;
        break;
        bool = localView.requestFocus();
        break label95;
        if (paramInt == 66)
        {
          i = getChildRectInPagerCoordinates(this.mTempRect, localView).left;
          j = getChildRectInPagerCoordinates(this.mTempRect, (View)localObject).left;
          if ((localObject == null) || (i > j))
          {
            bool = localView.requestFocus();
            break label95;
            if ((paramInt == 17) || (paramInt == 1))
            {
              bool = pageLeft();
              break label95;
            }
            if ((paramInt != 66) && (paramInt != 2)) {
              break label360;
            }
          }
          bool = pageRight();
          break label95;
        }
        bool = false;
        break label95;
      }
      localObject = localView;
      break;
    }
  }
  
  public boolean beginFakeDrag()
  {
    AppMethodBeat.i(235441);
    if (this.mIsBeingDragged)
    {
      AppMethodBeat.o(235441);
      return false;
    }
    this.mFakeDragging = true;
    setScrollState(1);
    this.mLastMotionX = 0.0F;
    this.mInitialMotionX = 0.0F;
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    for (;;)
    {
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 0, 0.0F, 0.0F, 0);
      this.mVelocityTracker.addMovement(localMotionEvent);
      localMotionEvent.recycle();
      this.mFakeDragBeginTime = l;
      AppMethodBeat.o(235441);
      return true;
      this.mVelocityTracker.clear();
    }
  }
  
  protected boolean canScroll(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(235453);
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int j = paramView.getScrollX();
      int k = paramView.getScrollY();
      int i = localViewGroup.getChildCount() - 1;
      while (i >= 0)
      {
        View localView = localViewGroup.getChildAt(i);
        if ((paramInt2 + j >= localView.getLeft()) && (paramInt2 + j < localView.getRight()) && (paramInt3 + k >= localView.getTop()) && (paramInt3 + k < localView.getBottom()) && (canScroll(localView, true, paramInt1, paramInt2 + j - localView.getLeft(), paramInt3 + k - localView.getTop())))
        {
          AppMethodBeat.o(235453);
          return true;
        }
        i -= 1;
      }
    }
    if ((paramBoolean) && (paramView.canScrollHorizontally(-paramInt1)))
    {
      AppMethodBeat.o(235453);
      return true;
    }
    AppMethodBeat.o(235453);
    return false;
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    AppMethodBeat.i(235451);
    if (this.mAdapter == null)
    {
      AppMethodBeat.o(235451);
      return false;
    }
    int i = getClientWidth();
    int j = getScrollX();
    if (paramInt < 0)
    {
      if (j > (int)(i * this.mFirstOffset))
      {
        AppMethodBeat.o(235451);
        return true;
      }
      AppMethodBeat.o(235451);
      return false;
    }
    if (paramInt > 0)
    {
      if (j < (int)(i * this.mLastOffset))
      {
        AppMethodBeat.o(235451);
        return true;
      }
      AppMethodBeat.o(235451);
      return false;
    }
    AppMethodBeat.o(235451);
    return false;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(235495);
    if (((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams)))
    {
      AppMethodBeat.o(235495);
      return true;
    }
    AppMethodBeat.o(235495);
    return false;
  }
  
  public void clearOnPageChangeListeners()
  {
    AppMethodBeat.i(235327);
    if (this.mOnPageChangeListeners != null) {
      this.mOnPageChangeListeners.clear();
    }
    AppMethodBeat.o(235327);
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(235413);
    this.mIsScrollStarted = true;
    if ((!this.mScroller.isFinished()) && (this.mScroller.computeScrollOffset()))
    {
      int i = getScrollX();
      int j = getScrollY();
      int k = this.mScroller.getCurrX();
      int m = this.mScroller.getCurrY();
      if ((i != k) || (j != m))
      {
        scrollTo(k, m);
        if (!pageScrolled(k))
        {
          this.mScroller.abortAnimation();
          scrollTo(0, m);
        }
      }
      w.G(this);
      AppMethodBeat.o(235413);
      return;
    }
    completeScroll(true);
    AppMethodBeat.o(235413);
  }
  
  void dataSetChanged()
  {
    AppMethodBeat.i(235364);
    int i5 = this.mAdapter.getCount();
    this.mExpectedAdapterCount = i5;
    int i;
    int j;
    int n;
    int k;
    int i3;
    label66:
    Object localObject;
    int i4;
    int i2;
    int i1;
    int m;
    if ((this.mItems.size() < this.mOffscreenPageLimit * 2 + 1) && (this.mItems.size() < i5))
    {
      i = 1;
      j = this.mCurItem;
      n = 0;
      k = 0;
      i3 = i;
      if (n >= this.mItems.size()) {
        break label302;
      }
      localObject = (ItemInfo)this.mItems.get(n);
      i4 = this.mAdapter.getItemPosition(((ItemInfo)localObject).object);
      i2 = n;
      i1 = k;
      m = j;
      i = i3;
      if (i4 != -1)
      {
        if (i4 != -2) {
          break label242;
        }
        this.mItems.remove(n);
        i2 = n - 1;
        n = k;
        if (k == 0)
        {
          this.mAdapter.startUpdate(this);
          n = 1;
        }
        this.mAdapter.destroyItem(this, ((ItemInfo)localObject).position, ((ItemInfo)localObject).object);
        if (this.mCurItem != ((ItemInfo)localObject).position) {
          break label393;
        }
        m = Math.max(0, Math.min(this.mCurItem, i5 - 1));
        i = 1;
        i1 = n;
      }
    }
    for (;;)
    {
      n = i2 + 1;
      k = i1;
      j = m;
      i3 = i;
      break label66;
      i = 0;
      break;
      label242:
      i2 = n;
      i1 = k;
      m = j;
      i = i3;
      if (((ItemInfo)localObject).position != i4)
      {
        if (((ItemInfo)localObject).position == this.mCurItem) {
          j = i4;
        }
        ((ItemInfo)localObject).position = i4;
        i = 1;
        i2 = n;
        i1 = k;
        m = j;
        continue;
        label302:
        if (k != 0) {
          this.mAdapter.finishUpdate(this);
        }
        Collections.sort(this.mItems, COMPARATOR);
        if (i3 != 0)
        {
          k = getChildCount();
          i = 0;
          while (i < k)
          {
            localObject = (LayoutParams)getChildAt(i).getLayoutParams();
            if (!((LayoutParams)localObject).avM) {
              ((LayoutParams)localObject).widthFactor = 0.0F;
            }
            i += 1;
          }
          setCurrentItemInternal(j, false, true);
          requestLayout();
        }
        AppMethodBeat.o(235364);
        return;
        label393:
        i = 1;
        i1 = n;
        m = j;
      }
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(235456);
    if ((super.dispatchKeyEvent(paramKeyEvent)) || (executeKeyEvent(paramKeyEvent)))
    {
      AppMethodBeat.o(235456);
      return true;
    }
    AppMethodBeat.o(235456);
    return false;
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(235484);
    if (paramAccessibilityEvent.getEventType() == 4096)
    {
      boolean bool = super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
      AppMethodBeat.o(235484);
      return bool;
    }
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        ItemInfo localItemInfo = infoForChild(localView);
        if ((localItemInfo != null) && (localItemInfo.position == this.mCurItem) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent)))
        {
          AppMethodBeat.o(235484);
          return true;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(235484);
    return false;
  }
  
  float distanceInfluenceForSnapDuration(float paramFloat)
  {
    AppMethodBeat.i(235349);
    paramFloat = (float)Math.sin((paramFloat - 0.5F) * 0.4712389F);
    AppMethodBeat.o(235349);
    return paramFloat;
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(235438);
    super.draw(paramCanvas);
    int k = 0;
    int i = 0;
    int m = getOverScrollMode();
    boolean bool;
    if ((m == 0) || ((m == 1) && (this.mAdapter != null) && (this.mAdapter.getCount() > 1)))
    {
      int j;
      if (!this.mLeftEdge.isFinished())
      {
        k = paramCanvas.save();
        i = getHeight() - getPaddingTop() - getPaddingBottom();
        m = getWidth();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate(-i + getPaddingTop(), this.mFirstOffset * m);
        this.mLeftEdge.setSize(i, m);
        j = this.mLeftEdge.draw(paramCanvas) | false;
        paramCanvas.restoreToCount(k);
      }
      k = j;
      if (!this.mRightEdge.isFinished())
      {
        m = paramCanvas.save();
        k = getWidth();
        int n = getHeight();
        int i1 = getPaddingTop();
        int i2 = getPaddingBottom();
        paramCanvas.rotate(90.0F);
        paramCanvas.translate(-getPaddingTop(), -(this.mLastOffset + 1.0F) * k);
        this.mRightEdge.setSize(n - i1 - i2, k);
        bool = j | this.mRightEdge.draw(paramCanvas);
        paramCanvas.restoreToCount(m);
      }
    }
    for (;;)
    {
      if (bool) {
        w.G(this);
      }
      AppMethodBeat.o(235438);
      return;
      this.mLeftEdge.finish();
      this.mRightEdge.finish();
    }
  }
  
  protected void drawableStateChanged()
  {
    AppMethodBeat.i(235345);
    super.drawableStateChanged();
    Drawable localDrawable = this.mMarginDrawable;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      localDrawable.setState(getDrawableState());
    }
    AppMethodBeat.o(235345);
  }
  
  public void endFakeDrag()
  {
    AppMethodBeat.i(235443);
    Object localObject;
    if (!this.mFakeDragging)
    {
      localObject = new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
      AppMethodBeat.o(235443);
      throw ((Throwable)localObject);
    }
    if (this.mAdapter != null)
    {
      localObject = this.mVelocityTracker;
      ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.mMaximumVelocity);
      int i = (int)((VelocityTracker)localObject).getXVelocity(this.mActivePointerId);
      this.mPopulatePending = true;
      int j = getClientWidth();
      int k = getScrollX();
      localObject = infoForCurrentScrollPosition();
      setCurrentItemInternal(determineTargetPage(((ItemInfo)localObject).position, (k / j - ((ItemInfo)localObject).offset) / ((ItemInfo)localObject).widthFactor, i, (int)(this.mLastMotionX - this.mInitialMotionX)), true, true, i);
    }
    endDrag();
    this.mFakeDragging = false;
    AppMethodBeat.o(235443);
  }
  
  public boolean executeKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(235459);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramKeyEvent.getAction() == 0) {
      switch (paramKeyEvent.getKeyCode())
      {
      default: 
        bool1 = bool2;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(235459);
      return bool1;
      if (paramKeyEvent.hasModifiers(2))
      {
        bool1 = pageLeft();
      }
      else
      {
        bool1 = arrowScroll(17);
        continue;
        if (paramKeyEvent.hasModifiers(2))
        {
          bool1 = pageRight();
        }
        else
        {
          bool1 = arrowScroll(66);
          continue;
          if (paramKeyEvent.hasNoModifiers())
          {
            bool1 = arrowScroll(2);
          }
          else
          {
            bool1 = bool2;
            if (paramKeyEvent.hasModifiers(1)) {
              bool1 = arrowScroll(1);
            }
          }
        }
      }
    }
  }
  
  public void fakeDragBy(float paramFloat)
  {
    AppMethodBeat.i(235446);
    if (!this.mFakeDragging)
    {
      localObject = new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
      AppMethodBeat.o(235446);
      throw ((Throwable)localObject);
    }
    if (this.mAdapter == null)
    {
      AppMethodBeat.o(235446);
      return;
    }
    this.mLastMotionX += paramFloat;
    float f2 = getScrollX() - paramFloat;
    int i = getClientWidth();
    paramFloat = i;
    float f4 = this.mFirstOffset;
    float f1 = i;
    float f3 = this.mLastOffset;
    Object localObject = (ItemInfo)this.mItems.get(0);
    ItemInfo localItemInfo = (ItemInfo)this.mItems.get(this.mItems.size() - 1);
    if (((ItemInfo)localObject).position != 0) {}
    for (paramFloat = ((ItemInfo)localObject).offset * i;; paramFloat *= f4)
    {
      if (localItemInfo.position != this.mAdapter.getCount() - 1) {}
      for (f1 = localItemInfo.offset * i;; f1 *= f3)
      {
        if (f2 < paramFloat) {}
        for (;;)
        {
          this.mLastMotionX += paramFloat - (int)paramFloat;
          scrollTo((int)paramFloat, getScrollY());
          pageScrolled((int)paramFloat);
          long l = SystemClock.uptimeMillis();
          localObject = MotionEvent.obtain(this.mFakeDragBeginTime, l, 2, this.mLastMotionX, 0.0F, 0);
          this.mVelocityTracker.addMovement((MotionEvent)localObject);
          ((MotionEvent)localObject).recycle();
          AppMethodBeat.o(235446);
          return;
          if (f2 > f1) {
            paramFloat = f1;
          } else {
            paramFloat = f2;
          }
        }
      }
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(235488);
    LayoutParams localLayoutParams = new LayoutParams();
    AppMethodBeat.o(235488);
    return localLayoutParams;
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(235498);
    paramAttributeSet = new LayoutParams(getContext(), paramAttributeSet);
    AppMethodBeat.o(235498);
    return paramAttributeSet;
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(235492);
    paramLayoutParams = generateDefaultLayoutParams();
    AppMethodBeat.o(235492);
    return paramLayoutParams;
  }
  
  public a getAdapter()
  {
    return this.mAdapter;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(235334);
    int i = paramInt2;
    if (this.mDrawingOrder == 2) {
      i = paramInt1 - 1 - paramInt2;
    }
    paramInt1 = ((LayoutParams)((View)this.mDrawingOrderedChildren.get(i)).getLayoutParams()).avO;
    AppMethodBeat.o(235334);
    return paramInt1;
  }
  
  public int getCurrentItem()
  {
    return this.mCurItem;
  }
  
  public int getOffscreenPageLimit()
  {
    return this.mOffscreenPageLimit;
  }
  
  public int getPageMargin()
  {
    return this.mPageMargin;
  }
  
  ItemInfo infoForAnyChild(View paramView)
  {
    AppMethodBeat.i(235394);
    for (;;)
    {
      ViewParent localViewParent = paramView.getParent();
      if (localViewParent == this) {
        break;
      }
      if ((localViewParent == null) || (!(localViewParent instanceof View)))
      {
        AppMethodBeat.o(235394);
        return null;
      }
      paramView = (View)localViewParent;
    }
    paramView = infoForChild(paramView);
    AppMethodBeat.o(235394);
    return paramView;
  }
  
  ItemInfo infoForChild(View paramView)
  {
    AppMethodBeat.i(235391);
    int i = 0;
    while (i < this.mItems.size())
    {
      ItemInfo localItemInfo = (ItemInfo)this.mItems.get(i);
      if (this.mAdapter.isViewFromObject(paramView, localItemInfo.object))
      {
        AppMethodBeat.o(235391);
        return localItemInfo;
      }
      i += 1;
    }
    AppMethodBeat.o(235391);
    return null;
  }
  
  ItemInfo infoForPosition(int paramInt)
  {
    AppMethodBeat.i(235395);
    int i = 0;
    while (i < this.mItems.size())
    {
      ItemInfo localItemInfo = (ItemInfo)this.mItems.get(i);
      if (localItemInfo.position == paramInt)
      {
        AppMethodBeat.o(235395);
        return localItemInfo;
      }
      i += 1;
    }
    AppMethodBeat.o(235395);
    return null;
  }
  
  void initViewPager()
  {
    AppMethodBeat.i(235297);
    setWillNotDraw(false);
    setDescendantFocusability(262144);
    setFocusable(true);
    Context localContext = getContext();
    this.mScroller = new Scroller(localContext, sInterpolator);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(localContext);
    float f = localContext.getResources().getDisplayMetrics().density;
    this.mTouchSlop = localViewConfiguration.getScaledPagingTouchSlop();
    this.mMinimumVelocity = ((int)(400.0F * f));
    this.mMaximumVelocity = localViewConfiguration.getScaledMaximumFlingVelocity();
    this.mLeftEdge = new EdgeEffect(localContext);
    this.mRightEdge = new EdgeEffect(localContext);
    this.mFlingDistance = ((int)(25.0F * f));
    this.mCloseEnough = ((int)(2.0F * f));
    this.mDefaultGutterSize = ((int)(16.0F * f));
    w.a(this, new b());
    if (w.H(this) == 0) {
      w.p(this, 1);
    }
    w.a(this, new s()
    {
      private final Rect mTempRect;
      
      public final ae a(View paramAnonymousView, ae paramAnonymousae)
      {
        AppMethodBeat.i(235202);
        paramAnonymousView = w.a(paramAnonymousView, paramAnonymousae);
        if (paramAnonymousView.Oa.hk())
        {
          AppMethodBeat.o(235202);
          return paramAnonymousView;
        }
        paramAnonymousae = this.mTempRect;
        paramAnonymousae.left = paramAnonymousView.hc();
        paramAnonymousae.top = paramAnonymousView.hd();
        paramAnonymousae.right = paramAnonymousView.he();
        paramAnonymousae.bottom = paramAnonymousView.hf();
        int i = 0;
        int j = ViewPager.this.getChildCount();
        while (i < j)
        {
          ae localae = w.b(ViewPager.this.getChildAt(i), paramAnonymousView);
          paramAnonymousae.left = Math.min(localae.hc(), paramAnonymousae.left);
          paramAnonymousae.top = Math.min(localae.hd(), paramAnonymousae.top);
          paramAnonymousae.right = Math.min(localae.he(), paramAnonymousae.right);
          paramAnonymousae.bottom = Math.min(localae.hf(), paramAnonymousae.bottom);
          i += 1;
        }
        paramAnonymousView = paramAnonymousView.f(paramAnonymousae.left, paramAnonymousae.top, paramAnonymousae.right, paramAnonymousae.bottom);
        AppMethodBeat.o(235202);
        return paramAnonymousView;
      }
    });
    AppMethodBeat.o(235297);
  }
  
  public boolean isFakeDragging()
  {
    return this.mFakeDragging;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(235397);
    super.onAttachedToWindow();
    this.mFirstLayout = true;
    AppMethodBeat.o(235397);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(235298);
    removeCallbacks(this.mEndScrollRunnable);
    if ((this.mScroller != null) && (!this.mScroller.isFinished())) {
      this.mScroller.abortAnimation();
    }
    super.onDetachedFromWindow();
    AppMethodBeat.o(235298);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(235439);
    super.onDraw(paramCanvas);
    if ((this.mPageMargin > 0) && (this.mMarginDrawable != null) && (this.mItems.size() > 0) && (this.mAdapter != null))
    {
      int k = getScrollX();
      int m = getWidth();
      float f3 = this.mPageMargin / m;
      Object localObject = (ItemInfo)this.mItems.get(0);
      float f1 = ((ItemInfo)localObject).offset;
      int n = this.mItems.size();
      int i = ((ItemInfo)localObject).position;
      int i1 = ((ItemInfo)this.mItems.get(n - 1)).position;
      int j = 0;
      if (i < i1)
      {
        while ((i > ((ItemInfo)localObject).position) && (j < n))
        {
          localObject = this.mItems;
          j += 1;
          localObject = (ItemInfo)((ArrayList)localObject).get(j);
        }
        float f2;
        if (i == ((ItemInfo)localObject).position) {
          f2 = (((ItemInfo)localObject).offset + ((ItemInfo)localObject).widthFactor) * m;
        }
        float f4;
        for (f1 = ((ItemInfo)localObject).offset + ((ItemInfo)localObject).widthFactor + f3;; f1 += f4 + f3)
        {
          if (this.mPageMargin + f2 > k)
          {
            this.mMarginDrawable.setBounds(Math.round(f2), this.mTopPageBounds, Math.round(this.mPageMargin + f2), this.mBottomPageBounds);
            this.mMarginDrawable.draw(paramCanvas);
          }
          if (f2 > k + m) {
            break label316;
          }
          i += 1;
          break;
          f4 = this.mAdapter.getPageWidth(i);
          f2 = (f1 + f4) * m;
        }
      }
    }
    label316:
    AppMethodBeat.o(235439);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(235428);
    int i = paramMotionEvent.getAction() & 0xFF;
    if ((i == 3) || (i == 1))
    {
      resetTouch();
      AppMethodBeat.o(235428);
      return false;
    }
    if (i != 0)
    {
      if (this.mIsBeingDragged)
      {
        AppMethodBeat.o(235428);
        return true;
      }
      if (this.mIsUnableToDrag)
      {
        AppMethodBeat.o(235428);
        return false;
      }
    }
    switch (i)
    {
    }
    for (;;)
    {
      if (this.mVelocityTracker == null) {
        this.mVelocityTracker = VelocityTracker.obtain();
      }
      this.mVelocityTracker.addMovement(paramMotionEvent);
      boolean bool = this.mIsBeingDragged;
      AppMethodBeat.o(235428);
      return bool;
      i = this.mActivePointerId;
      if (i != -1)
      {
        i = paramMotionEvent.findPointerIndex(i);
        float f2 = paramMotionEvent.getX(i);
        float f1 = f2 - this.mLastMotionX;
        float f4 = Math.abs(f1);
        float f3 = paramMotionEvent.getY(i);
        float f5 = Math.abs(f3 - this.mInitialMotionY);
        if ((f1 != 0.0F) && (!isGutterDrag(this.mLastMotionX, f1)) && (canScroll(this, false, (int)f1, (int)f2, (int)f3)))
        {
          this.mLastMotionX = f2;
          this.mLastMotionY = f3;
          this.mIsUnableToDrag = true;
          AppMethodBeat.o(235428);
          return false;
        }
        if ((f4 > this.mTouchSlop) && (0.5F * f4 > f5))
        {
          this.mIsBeingDragged = true;
          requestParentDisallowInterceptTouchEvent(true);
          setScrollState(1);
          if (f1 > 0.0F)
          {
            f1 = this.mInitialMotionX + this.mTouchSlop;
            label322:
            this.mLastMotionX = f1;
            this.mLastMotionY = f3;
            setScrollingCacheEnabled(true);
          }
        }
        while ((this.mIsBeingDragged) && (performDrag(f2)))
        {
          w.G(this);
          break;
          f1 = this.mInitialMotionX - this.mTouchSlop;
          break label322;
          if (f5 > this.mTouchSlop) {
            this.mIsUnableToDrag = true;
          }
        }
        f1 = paramMotionEvent.getX();
        this.mInitialMotionX = f1;
        this.mLastMotionX = f1;
        f1 = paramMotionEvent.getY();
        this.mInitialMotionY = f1;
        this.mLastMotionY = f1;
        this.mActivePointerId = paramMotionEvent.getPointerId(0);
        this.mIsUnableToDrag = false;
        this.mIsScrollStarted = true;
        this.mScroller.computeScrollOffset();
        if ((this.mScrollState == 2) && (Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) > this.mCloseEnough))
        {
          this.mScroller.abortAnimation();
          this.mPopulatePending = false;
          populate();
          this.mIsBeingDragged = true;
          requestParentDisallowInterceptTouchEvent(true);
          setScrollState(1);
        }
        else
        {
          completeScroll(false);
          this.mIsBeingDragged = false;
          continue;
          onSecondaryPointerUp(paramMotionEvent);
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(235409);
    int i1 = getChildCount();
    int i3 = paramInt3 - paramInt1;
    int i2 = paramInt4 - paramInt2;
    paramInt1 = getPaddingLeft();
    paramInt2 = getPaddingTop();
    paramInt3 = getPaddingRight();
    int j = getPaddingBottom();
    int i4 = getScrollX();
    int k = 0;
    int m = 0;
    View localView;
    LayoutParams localLayoutParams;
    int n;
    int i;
    if (m < i1)
    {
      localView = getChildAt(m);
      if (localView.getVisibility() == 8) {
        break label650;
      }
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (!localLayoutParams.avM) {
        break label650;
      }
      paramInt4 = localLayoutParams.ek;
      n = localLayoutParams.ek;
      switch (paramInt4 & 0x7)
      {
      case 2: 
      case 4: 
      default: 
        paramInt4 = paramInt1;
        i = paramInt3;
        paramInt3 = paramInt1;
        paramInt1 = i;
        label169:
        switch (n & 0x70)
        {
        default: 
          i = paramInt2;
          label211:
          paramInt4 += i4;
          localView.layout(paramInt4, i, localView.getMeasuredWidth() + paramInt4, localView.getMeasuredHeight() + i);
          paramInt4 = k + 1;
        }
        break;
      }
    }
    for (;;)
    {
      m += 1;
      i = paramInt1;
      paramInt1 = paramInt3;
      paramInt3 = i;
      k = paramInt4;
      break;
      i = paramInt1 + localView.getMeasuredWidth();
      paramInt4 = paramInt1;
      paramInt1 = paramInt3;
      paramInt3 = i;
      break label169;
      i = Math.max((i3 - localView.getMeasuredWidth()) / 2, paramInt1);
      paramInt4 = paramInt1;
      paramInt1 = paramInt3;
      paramInt3 = paramInt4;
      paramInt4 = i;
      break label169;
      paramInt4 = localView.getMeasuredWidth();
      i = localView.getMeasuredWidth();
      paramInt4 = i3 - paramInt3 - paramInt4;
      i = paramInt3 + i;
      paramInt3 = paramInt1;
      paramInt1 = i;
      break label169;
      n = paramInt2 + localView.getMeasuredHeight();
      i = paramInt2;
      paramInt2 = n;
      break label211;
      i = Math.max((i2 - localView.getMeasuredHeight()) / 2, paramInt2);
      break label211;
      i = i2 - j - localView.getMeasuredHeight();
      j += localView.getMeasuredHeight();
      break label211;
      paramInt4 = i3 - paramInt1 - paramInt3;
      paramInt3 = 0;
      while (paramInt3 < i1)
      {
        localView = getChildAt(paramInt3);
        if (localView.getVisibility() != 8)
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (!localLayoutParams.avM)
          {
            ItemInfo localItemInfo = infoForChild(localView);
            if (localItemInfo != null)
            {
              float f = paramInt4;
              i = (int)(localItemInfo.offset * f) + paramInt1;
              if (localLayoutParams.avN)
              {
                localLayoutParams.avN = false;
                f = paramInt4;
                localView.measure(View.MeasureSpec.makeMeasureSpec((int)(localLayoutParams.widthFactor * f), 1073741824), View.MeasureSpec.makeMeasureSpec(i2 - paramInt2 - j, 1073741824));
              }
              localView.layout(i, paramInt2, localView.getMeasuredWidth() + i, localView.getMeasuredHeight() + paramInt2);
            }
          }
        }
        paramInt3 += 1;
      }
      this.mTopPageBounds = paramInt2;
      this.mBottomPageBounds = (i2 - j);
      this.mDecorChildCount = k;
      if (this.mFirstLayout) {
        scrollToItem(this.mCurItem, false, 0, false);
      }
      this.mFirstLayout = false;
      AppMethodBeat.o(235409);
      return;
      label650:
      paramInt4 = k;
      i = paramInt1;
      paramInt1 = paramInt3;
      paramInt3 = i;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(235400);
    setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
    paramInt1 = getMeasuredWidth();
    this.mGutterSize = Math.min(paramInt1 / 10, this.mDefaultGutterSize);
    paramInt1 = paramInt1 - getPaddingLeft() - getPaddingRight();
    paramInt2 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
    int i4 = getChildCount();
    int k = 0;
    View localView;
    int i;
    int j;
    LayoutParams localLayoutParams;
    int m;
    int i1;
    label189:
    int n;
    if (k < i4)
    {
      localView = getChildAt(k);
      i = paramInt1;
      j = paramInt2;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        i = paramInt1;
        j = paramInt2;
        if (localLayoutParams != null)
        {
          i = paramInt1;
          j = paramInt2;
          if (localLayoutParams.avM)
          {
            i = localLayoutParams.ek & 0x7;
            m = localLayoutParams.ek & 0x70;
            i1 = -2147483648;
            j = -2147483648;
            if ((m != 48) && (m != 80)) {
              break label339;
            }
            m = 1;
            if ((i != 3) && (i != 5)) {
              break label345;
            }
            n = 1;
            label204:
            if (m == 0) {
              break label351;
            }
            i = 1073741824;
            label214:
            if (localLayoutParams.width == -2) {
              break label540;
            }
            i1 = 1073741824;
            if (localLayoutParams.width == -1) {
              break label534;
            }
            i = localLayoutParams.width;
          }
        }
      }
    }
    for (;;)
    {
      int i3;
      if (localLayoutParams.height != -2)
      {
        i2 = 1073741824;
        j = i2;
        if (localLayoutParams.height != -1)
        {
          i3 = localLayoutParams.height;
          j = i2;
        }
      }
      for (int i2 = i3;; i2 = paramInt2)
      {
        localView.measure(View.MeasureSpec.makeMeasureSpec(i, i1), View.MeasureSpec.makeMeasureSpec(i2, j));
        if (m != 0)
        {
          j = paramInt2 - localView.getMeasuredHeight();
          i = paramInt1;
        }
        for (;;)
        {
          k += 1;
          paramInt1 = i;
          paramInt2 = j;
          break;
          label339:
          m = 0;
          break label189;
          label345:
          n = 0;
          break label204;
          label351:
          i = i1;
          if (n == 0) {
            break label214;
          }
          j = 1073741824;
          i = i1;
          break label214;
          i = paramInt1;
          j = paramInt2;
          if (n != 0)
          {
            i = paramInt1 - localView.getMeasuredWidth();
            j = paramInt2;
          }
        }
        this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
        this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
        this.mInLayout = true;
        populate();
        this.mInLayout = false;
        i = getChildCount();
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          localView = getChildAt(paramInt2);
          if (localView.getVisibility() != 8)
          {
            localLayoutParams = (LayoutParams)localView.getLayoutParams();
            if ((localLayoutParams == null) || (!localLayoutParams.avM))
            {
              float f = paramInt1;
              localView.measure(View.MeasureSpec.makeMeasureSpec((int)(localLayoutParams.widthFactor * f), 1073741824), this.mChildHeightMeasureSpec);
            }
          }
          paramInt2 += 1;
        }
        AppMethodBeat.o(235400);
        return;
      }
      label534:
      i = paramInt1;
      continue;
      label540:
      i1 = paramInt1;
      i2 = i;
      i = i1;
      i1 = i2;
    }
  }
  
  protected void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    AppMethodBeat.i(235416);
    int i;
    int k;
    int i2;
    int m;
    View localView;
    int j;
    label124:
    int n;
    if (this.mDecorChildCount > 0)
    {
      int i1 = getScrollX();
      i = getPaddingLeft();
      k = getPaddingRight();
      i2 = getWidth();
      int i3 = getChildCount();
      m = 0;
      if (m < i3)
      {
        localView = getChildAt(m);
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (!localLayoutParams.avM) {
          break label349;
        }
        switch (localLayoutParams.ek & 0x7)
        {
        case 2: 
        case 4: 
        default: 
          j = i;
          int i4 = j + i1 - localView.getLeft();
          n = k;
          j = i;
          if (i4 != 0)
          {
            localView.offsetLeftAndRight(i4);
            j = i;
            n = k;
          }
          break;
        }
      }
    }
    for (;;)
    {
      m += 1;
      i = j;
      k = n;
      break;
      n = i + localView.getWidth();
      j = i;
      i = n;
      break label124;
      j = Math.max((i2 - localView.getMeasuredWidth()) / 2, i);
      break label124;
      j = i2 - k - localView.getMeasuredWidth();
      k += localView.getMeasuredWidth();
      break label124;
      dispatchOnPageScrolled(paramInt1, paramFloat, paramInt2);
      if (this.mPageTransformer != null)
      {
        paramInt2 = getScrollX();
        i = getChildCount();
        paramInt1 = 0;
        while (paramInt1 < i)
        {
          localView = getChildAt(paramInt1);
          if (!((LayoutParams)localView.getLayoutParams()).avM)
          {
            paramFloat = (localView.getLeft() - paramInt2) / getClientWidth();
            this.mPageTransformer.o(localView, paramFloat);
          }
          paramInt1 += 1;
        }
      }
      this.mCalledSuper = true;
      AppMethodBeat.o(235416);
      return;
      label349:
      n = k;
      j = i;
    }
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    AppMethodBeat.i(235481);
    int k = getChildCount();
    int j;
    int i;
    if ((paramInt & 0x2) != 0)
    {
      j = 1;
      i = 0;
    }
    while (i != k)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        ItemInfo localItemInfo = infoForChild(localView);
        if ((localItemInfo != null) && (localItemInfo.position == this.mCurItem) && (localView.requestFocus(paramInt, paramRect)))
        {
          AppMethodBeat.o(235481);
          return true;
          i = k - 1;
          j = -1;
          k = -1;
          continue;
        }
      }
      i += j;
    }
    AppMethodBeat.o(235481);
    return false;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(235385);
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(235385);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.Rb);
    if (this.mAdapter != null)
    {
      this.mAdapter.restoreState(paramParcelable.avP, paramParcelable.avQ);
      setCurrentItemInternal(paramParcelable.position, false, true);
      AppMethodBeat.o(235385);
      return;
    }
    this.mRestoredCurItem = paramParcelable.position;
    this.mRestoredAdapterState = paramParcelable.avP;
    this.mRestoredClassLoader = paramParcelable.avQ;
    AppMethodBeat.o(235385);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(235382);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.position = this.mCurItem;
    if (this.mAdapter != null) {
      localSavedState.avP = this.mAdapter.saveState();
    }
    AppMethodBeat.o(235382);
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(235402);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3) {
      recomputeScrollPosition(paramInt1, paramInt3, this.mPageMargin, this.mPageMargin);
    }
    AppMethodBeat.o(235402);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(235430);
    if (this.mFakeDragging)
    {
      AppMethodBeat.o(235430);
      return true;
    }
    if ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0))
    {
      AppMethodBeat.o(235430);
      return false;
    }
    if ((this.mAdapter == null) || (this.mAdapter.getCount() == 0))
    {
      AppMethodBeat.o(235430);
      return false;
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    boolean bool1 = bool2;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      bool1 = bool2;
    }
    for (;;)
    {
      if (bool1) {
        w.G(this);
      }
      AppMethodBeat.o(235430);
      return true;
      this.mScroller.abortAnimation();
      this.mPopulatePending = false;
      populate();
      float f1 = paramMotionEvent.getX();
      this.mInitialMotionX = f1;
      this.mLastMotionX = f1;
      f1 = paramMotionEvent.getY();
      this.mInitialMotionY = f1;
      this.mLastMotionY = f1;
      this.mActivePointerId = paramMotionEvent.getPointerId(0);
      bool1 = bool2;
      continue;
      int i;
      float f2;
      if (!this.mIsBeingDragged)
      {
        i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
        if (i == -1)
        {
          bool1 = resetTouch();
          continue;
        }
        f1 = paramMotionEvent.getX(i);
        float f3 = Math.abs(f1 - this.mLastMotionX);
        f2 = paramMotionEvent.getY(i);
        float f4 = Math.abs(f2 - this.mLastMotionY);
        if ((f3 > this.mTouchSlop) && (f3 > f4))
        {
          this.mIsBeingDragged = true;
          requestParentDisallowInterceptTouchEvent(true);
          if (f1 - this.mInitialMotionX <= 0.0F) {
            break label423;
          }
        }
      }
      Object localObject;
      label423:
      for (f1 = this.mInitialMotionX + this.mTouchSlop;; f1 = this.mInitialMotionX - this.mTouchSlop)
      {
        this.mLastMotionX = f1;
        this.mLastMotionY = f2;
        setScrollState(1);
        setScrollingCacheEnabled(true);
        localObject = getParent();
        if (localObject != null) {
          ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
        }
        bool1 = bool2;
        if (!this.mIsBeingDragged) {
          break;
        }
        bool1 = performDrag(paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.mActivePointerId))) | false;
        break;
      }
      bool1 = bool2;
      if (this.mIsBeingDragged)
      {
        localObject = this.mVelocityTracker;
        ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.mMaximumVelocity);
        i = (int)((VelocityTracker)localObject).getXVelocity(this.mActivePointerId);
        this.mPopulatePending = true;
        int j = getClientWidth();
        int k = getScrollX();
        localObject = infoForCurrentScrollPosition();
        f1 = this.mPageMargin / j;
        setCurrentItemInternal(determineTargetPage(((ItemInfo)localObject).position, (k / j - ((ItemInfo)localObject).offset) / (((ItemInfo)localObject).widthFactor + f1), i, (int)(paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.mActivePointerId)) - this.mInitialMotionX)), true, true, i);
        bool1 = resetTouch();
        continue;
        bool1 = bool2;
        if (this.mIsBeingDragged)
        {
          scrollToItem(this.mCurItem, true, 0, false);
          bool1 = resetTouch();
          continue;
          i = paramMotionEvent.getActionIndex();
          this.mLastMotionX = paramMotionEvent.getX(i);
          this.mActivePointerId = paramMotionEvent.getPointerId(i);
          bool1 = bool2;
          continue;
          onSecondaryPointerUp(paramMotionEvent);
          this.mLastMotionX = paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.mActivePointerId));
          bool1 = bool2;
        }
      }
    }
  }
  
  boolean pageLeft()
  {
    AppMethodBeat.i(235470);
    if (this.mCurItem > 0)
    {
      setCurrentItem(this.mCurItem - 1, true);
      AppMethodBeat.o(235470);
      return true;
    }
    AppMethodBeat.o(235470);
    return false;
  }
  
  boolean pageRight()
  {
    AppMethodBeat.i(235472);
    if ((this.mAdapter != null) && (this.mCurItem < this.mAdapter.getCount() - 1))
    {
      setCurrentItem(this.mCurItem + 1, true);
      AppMethodBeat.o(235472);
      return true;
    }
    AppMethodBeat.o(235472);
    return false;
  }
  
  void populate()
  {
    AppMethodBeat.i(235367);
    populate(this.mCurItem);
    AppMethodBeat.o(235367);
  }
  
  void populate(int paramInt)
  {
    AppMethodBeat.i(235372);
    Object localObject3;
    if (this.mCurItem != paramInt)
    {
      localObject3 = infoForPosition(this.mCurItem);
      this.mCurItem = paramInt;
    }
    for (;;)
    {
      if (this.mAdapter == null)
      {
        sortChildDrawingOrder();
        AppMethodBeat.o(235372);
        return;
      }
      if (this.mPopulatePending)
      {
        sortChildDrawingOrder();
        AppMethodBeat.o(235372);
        return;
      }
      if (getWindowToken() == null)
      {
        AppMethodBeat.o(235372);
        return;
      }
      this.mAdapter.startUpdate(this);
      paramInt = this.mOffscreenPageLimit;
      int i1 = Math.max(0, this.mCurItem - paramInt);
      int m = this.mAdapter.getCount();
      int n = Math.min(m - 1, paramInt + this.mCurItem);
      Object localObject2;
      if (m != this.mExpectedAdapterCount) {
        try
        {
          Object localObject1 = getResources().getResourceName(getId());
          localObject1 = new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.mExpectedAdapterCount + ", found: " + m + " Pager id: " + (String)localObject1 + " Pager class: " + getClass() + " Problematic adapter: " + this.mAdapter.getClass());
          AppMethodBeat.o(235372);
          throw ((Throwable)localObject1);
        }
        catch (Resources.NotFoundException localNotFoundException)
        {
          for (;;)
          {
            localObject2 = Integer.toHexString(getId());
          }
        }
      }
      paramInt = 0;
      if (paramInt < this.mItems.size())
      {
        localObject2 = (ItemInfo)this.mItems.get(paramInt);
        if (((ItemInfo)localObject2).position >= this.mCurItem) {
          if (((ItemInfo)localObject2).position != this.mCurItem) {
            break label1238;
          }
        }
      }
      for (;;)
      {
        if ((localObject2 == null) && (m > 0)) {}
        for (Object localObject4 = addNewItem(this.mCurItem, paramInt);; localObject4 = localObject2)
        {
          float f1;
          int k;
          label355:
          int i2;
          float f2;
          label368:
          int j;
          int i;
          if (localObject4 != null)
          {
            f1 = 0.0F;
            k = paramInt - 1;
            if (k >= 0)
            {
              localObject2 = (ItemInfo)this.mItems.get(k);
              i2 = getClientWidth();
              if (i2 > 0) {
                break label496;
              }
              f2 = 0.0F;
              j = this.mCurItem - 1;
              i = paramInt;
              paramInt = k;
              label382:
              if (j < 0) {
                break label623;
              }
              if ((f1 < f2) || (j >= i1)) {
                break label523;
              }
              if (localObject2 == null) {
                break label623;
              }
              if ((j != ((ItemInfo)localObject2).position) || (((ItemInfo)localObject2).scrolling)) {
                break label1228;
              }
              this.mItems.remove(paramInt);
              this.mAdapter.destroyItem(this, j, ((ItemInfo)localObject2).object);
              paramInt -= 1;
              if (paramInt < 0) {
                break label517;
              }
              localObject2 = (ItemInfo)this.mItems.get(paramInt);
              label468:
              i -= 1;
            }
          }
          label517:
          label523:
          label676:
          label688:
          label834:
          label1228:
          for (;;)
          {
            j -= 1;
            break label382;
            paramInt += 1;
            break;
            localObject2 = null;
            break label355;
            label496:
            f2 = 2.0F - ((ItemInfo)localObject4).widthFactor + getPaddingLeft() / i2;
            break label368;
            localObject2 = null;
            break label468;
            if ((localObject2 != null) && (j == ((ItemInfo)localObject2).position))
            {
              f1 += ((ItemInfo)localObject2).widthFactor;
              paramInt -= 1;
              if (paramInt >= 0) {
                localObject2 = (ItemInfo)this.mItems.get(paramInt);
              } else {
                localObject2 = null;
              }
            }
            else
            {
              f1 += addNewItem(j, paramInt + 1).widthFactor;
              i += 1;
              if (paramInt >= 0) {}
              for (localObject2 = (ItemInfo)this.mItems.get(paramInt);; localObject2 = null) {
                break;
              }
              label623:
              float f3 = ((ItemInfo)localObject4).widthFactor;
              k = i + 1;
              if (f3 < 2.0F)
              {
                Object localObject5;
                if (k < this.mItems.size())
                {
                  localObject2 = (ItemInfo)this.mItems.get(k);
                  if (i2 > 0) {
                    break label834;
                  }
                  f2 = 0.0F;
                  j = this.mCurItem + 1;
                  localObject5 = localObject2;
                  if (j >= m) {
                    break label980;
                  }
                  if ((f3 < f2) || (j <= n)) {
                    break label861;
                  }
                  if (localObject5 == null) {
                    break label980;
                  }
                  localObject2 = localObject5;
                  f1 = f3;
                  paramInt = k;
                  if (j == localObject5.position)
                  {
                    localObject2 = localObject5;
                    f1 = f3;
                    paramInt = k;
                    if (!localObject5.scrolling)
                    {
                      this.mItems.remove(k);
                      this.mAdapter.destroyItem(this, j, localObject5.object);
                      if (k >= this.mItems.size()) {
                        break label849;
                      }
                      localObject2 = (ItemInfo)this.mItems.get(k);
                      paramInt = k;
                      f1 = f3;
                    }
                  }
                }
                for (;;)
                {
                  j += 1;
                  localObject5 = localObject2;
                  f3 = f1;
                  k = paramInt;
                  break label688;
                  localObject2 = null;
                  break;
                  f2 = getPaddingRight() / i2 + 2.0F;
                  break label676;
                  label849:
                  localObject2 = null;
                  f1 = f3;
                  paramInt = k;
                  continue;
                  label861:
                  if ((localObject5 != null) && (j == localObject5.position))
                  {
                    f1 = f3 + localObject5.widthFactor;
                    paramInt = k + 1;
                    if (paramInt < this.mItems.size()) {
                      localObject2 = (ItemInfo)this.mItems.get(paramInt);
                    } else {
                      localObject2 = null;
                    }
                  }
                  else
                  {
                    localObject2 = addNewItem(j, k);
                    paramInt = k + 1;
                    f1 = f3 + ((ItemInfo)localObject2).widthFactor;
                    if (paramInt < this.mItems.size()) {
                      localObject2 = (ItemInfo)this.mItems.get(paramInt);
                    } else {
                      localObject2 = null;
                    }
                  }
                }
              }
              label980:
              calculatePageOffsets((ItemInfo)localObject4, i, (ItemInfo)localObject3);
              this.mAdapter.setPrimaryItem(this, this.mCurItem, ((ItemInfo)localObject4).object);
              this.mAdapter.finishUpdate(this);
              i = getChildCount();
              paramInt = 0;
              while (paramInt < i)
              {
                localObject3 = getChildAt(paramInt);
                localObject2 = (LayoutParams)((View)localObject3).getLayoutParams();
                ((LayoutParams)localObject2).avO = paramInt;
                if ((!((LayoutParams)localObject2).avM) && (((LayoutParams)localObject2).widthFactor == 0.0F))
                {
                  localObject3 = infoForChild((View)localObject3);
                  if (localObject3 != null)
                  {
                    ((LayoutParams)localObject2).widthFactor = ((ItemInfo)localObject3).widthFactor;
                    ((LayoutParams)localObject2).position = ((ItemInfo)localObject3).position;
                  }
                }
                paramInt += 1;
              }
              sortChildDrawingOrder();
              if (hasFocus())
              {
                localObject2 = findFocus();
                if (localObject2 != null) {}
                for (localObject2 = infoForAnyChild((View)localObject2); (localObject2 == null) || (((ItemInfo)localObject2).position != this.mCurItem); localObject2 = null)
                {
                  paramInt = 0;
                  while (paramInt < getChildCount())
                  {
                    localObject2 = getChildAt(paramInt);
                    localObject3 = infoForChild((View)localObject2);
                    if ((localObject3 != null) && (((ItemInfo)localObject3).position == this.mCurItem) && (((View)localObject2).requestFocus(2))) {
                      break;
                    }
                    paramInt += 1;
                  }
                }
              }
              AppMethodBeat.o(235372);
              return;
            }
          }
        }
        label1238:
        localObject2 = null;
      }
      localObject3 = null;
    }
  }
  
  public void removeOnAdapterChangeListener(c paramc)
  {
    AppMethodBeat.i(235307);
    if (this.mAdapterChangeListeners != null) {
      this.mAdapterChangeListeners.remove(paramc);
    }
    AppMethodBeat.o(235307);
  }
  
  public void removeOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    AppMethodBeat.i(235325);
    if (this.mOnPageChangeListeners != null) {
      this.mOnPageChangeListeners.remove(paramOnPageChangeListener);
    }
    AppMethodBeat.o(235325);
  }
  
  public void removeView(View paramView)
  {
    AppMethodBeat.i(235390);
    if (this.mInLayout)
    {
      removeViewInLayout(paramView);
      AppMethodBeat.o(235390);
      return;
    }
    super.removeView(paramView);
    AppMethodBeat.o(235390);
  }
  
  public void setAdapter(a parama)
  {
    int j = 0;
    AppMethodBeat.i(235302);
    int i;
    if (this.mAdapter != null)
    {
      this.mAdapter.setViewPagerObserver(null);
      this.mAdapter.startUpdate(this);
      i = 0;
      while (i < this.mItems.size())
      {
        localObject = (ItemInfo)this.mItems.get(i);
        this.mAdapter.destroyItem(this, ((ItemInfo)localObject).position, ((ItemInfo)localObject).object);
        i += 1;
      }
      this.mAdapter.finishUpdate(this);
      this.mItems.clear();
      removeNonDecorViews();
      this.mCurItem = 0;
      scrollTo(0, 0);
    }
    Object localObject = this.mAdapter;
    this.mAdapter = parama;
    this.mExpectedAdapterCount = 0;
    boolean bool;
    if (this.mAdapter != null)
    {
      if (this.mObserver == null) {
        this.mObserver = new e();
      }
      this.mAdapter.setViewPagerObserver(this.mObserver);
      this.mPopulatePending = false;
      bool = this.mFirstLayout;
      this.mFirstLayout = true;
      this.mExpectedAdapterCount = this.mAdapter.getCount();
      if (this.mRestoredCurItem < 0) {
        break label306;
      }
      this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
      setCurrentItemInternal(this.mRestoredCurItem, false, true);
      this.mRestoredCurItem = -1;
      this.mRestoredAdapterState = null;
      this.mRestoredClassLoader = null;
    }
    while ((this.mAdapterChangeListeners != null) && (!this.mAdapterChangeListeners.isEmpty()))
    {
      int k = this.mAdapterChangeListeners.size();
      i = j;
      while (i < k)
      {
        ((c)this.mAdapterChangeListeners.get(i)).a(this, (a)localObject, parama);
        i += 1;
      }
      label306:
      if (!bool) {
        populate();
      } else {
        requestLayout();
      }
    }
    AppMethodBeat.o(235302);
  }
  
  public void setCurrentItem(int paramInt)
  {
    AppMethodBeat.i(235312);
    this.mPopulatePending = false;
    if (!this.mFirstLayout) {}
    for (boolean bool = true;; bool = false)
    {
      setCurrentItemInternal(paramInt, bool, false);
      AppMethodBeat.o(235312);
      return;
    }
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(235314);
    this.mPopulatePending = false;
    setCurrentItemInternal(paramInt, paramBoolean, false);
    AppMethodBeat.o(235314);
  }
  
  void setCurrentItemInternal(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(235316);
    setCurrentItemInternal(paramInt, paramBoolean1, paramBoolean2, 0);
    AppMethodBeat.o(235316);
  }
  
  void setCurrentItemInternal(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    boolean bool = false;
    AppMethodBeat.i(235319);
    if ((this.mAdapter == null) || (this.mAdapter.getCount() <= 0))
    {
      setScrollingCacheEnabled(false);
      AppMethodBeat.o(235319);
      return;
    }
    if ((!paramBoolean2) && (this.mCurItem == paramInt1) && (this.mItems.size() != 0))
    {
      setScrollingCacheEnabled(false);
      AppMethodBeat.o(235319);
      return;
    }
    int i;
    if (paramInt1 < 0) {
      i = 0;
    }
    for (;;)
    {
      paramInt1 = this.mOffscreenPageLimit;
      if ((i <= this.mCurItem + paramInt1) && (i >= this.mCurItem - paramInt1)) {
        break;
      }
      paramInt1 = 0;
      while (paramInt1 < this.mItems.size())
      {
        ((ItemInfo)this.mItems.get(paramInt1)).scrolling = true;
        paramInt1 += 1;
      }
      i = paramInt1;
      if (paramInt1 >= this.mAdapter.getCount()) {
        i = this.mAdapter.getCount() - 1;
      }
    }
    paramBoolean2 = bool;
    if (this.mCurItem != i) {
      paramBoolean2 = true;
    }
    if (this.mFirstLayout)
    {
      this.mCurItem = i;
      if (paramBoolean2) {
        dispatchOnPageSelected(i);
      }
      requestLayout();
      AppMethodBeat.o(235319);
      return;
    }
    populate(i);
    scrollToItem(i, paramBoolean1, paramInt2, paramBoolean2);
    AppMethodBeat.o(235319);
  }
  
  ViewPager.OnPageChangeListener setInternalPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    ViewPager.OnPageChangeListener localOnPageChangeListener = this.mInternalPageChangeListener;
    this.mInternalPageChangeListener = paramOnPageChangeListener;
    return localOnPageChangeListener;
  }
  
  public void setOffscreenPageLimit(int paramInt)
  {
    AppMethodBeat.i(235337);
    int i = paramInt;
    if (paramInt <= 0)
    {
      new StringBuilder("Requested offscreen page limit ").append(paramInt).append(" too small; defaulting to 1");
      i = 1;
    }
    if (i != this.mOffscreenPageLimit)
    {
      this.mOffscreenPageLimit = i;
      populate();
    }
    AppMethodBeat.o(235337);
  }
  
  @Deprecated
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.mOnPageChangeListener = paramOnPageChangeListener;
  }
  
  public void setPageMargin(int paramInt)
  {
    AppMethodBeat.i(235339);
    int i = this.mPageMargin;
    this.mPageMargin = paramInt;
    int j = getWidth();
    recomputeScrollPosition(j, j, paramInt, i);
    requestLayout();
    AppMethodBeat.o(235339);
  }
  
  public void setPageMarginDrawable(int paramInt)
  {
    AppMethodBeat.i(235343);
    setPageMarginDrawable(androidx.core.content.a.m(getContext(), paramInt));
    AppMethodBeat.o(235343);
  }
  
  public void setPageMarginDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(235341);
    this.mMarginDrawable = paramDrawable;
    if (paramDrawable != null) {
      refreshDrawableState();
    }
    if (paramDrawable == null) {}
    for (boolean bool = true;; bool = false)
    {
      setWillNotDraw(bool);
      invalidate();
      AppMethodBeat.o(235341);
      return;
    }
  }
  
  public void setPageTransformer(boolean paramBoolean, d paramd)
  {
    AppMethodBeat.i(235328);
    setPageTransformer(paramBoolean, paramd, 2);
    AppMethodBeat.o(235328);
  }
  
  public void setPageTransformer(boolean paramBoolean, d paramd, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(235331);
    boolean bool1;
    boolean bool2;
    label26:
    int i;
    if (paramd != null)
    {
      bool1 = true;
      if (this.mPageTransformer == null) {
        break label92;
      }
      bool2 = true;
      if (bool1 == bool2) {
        break label98;
      }
      i = 1;
      label36:
      this.mPageTransformer = paramd;
      setChildrenDrawingOrderEnabled(bool1);
      if (!bool1) {
        break label104;
      }
      if (paramBoolean) {
        j = 2;
      }
      this.mDrawingOrder = j;
      this.mPageTransformerLayerType = paramInt;
    }
    for (;;)
    {
      if (i != 0) {
        populate();
      }
      AppMethodBeat.o(235331);
      return;
      bool1 = false;
      break;
      label92:
      bool2 = false;
      break label26;
      label98:
      i = 0;
      break label36;
      label104:
      this.mDrawingOrder = 0;
    }
  }
  
  void setScrollState(int paramInt)
  {
    AppMethodBeat.i(235299);
    if (this.mScrollState == paramInt)
    {
      AppMethodBeat.o(235299);
      return;
    }
    this.mScrollState = paramInt;
    if (this.mPageTransformer != null) {
      if (paramInt == 0) {
        break label56;
      }
    }
    label56:
    for (boolean bool = true;; bool = false)
    {
      enableLayers(bool);
      dispatchOnScrollStateChanged(paramInt);
      AppMethodBeat.o(235299);
      return;
    }
  }
  
  void smoothScrollTo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(235352);
    smoothScrollTo(paramInt1, paramInt2, 0);
    AppMethodBeat.o(235352);
  }
  
  void smoothScrollTo(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(235357);
    if (getChildCount() == 0)
    {
      setScrollingCacheEnabled(false);
      AppMethodBeat.o(235357);
      return;
    }
    int i;
    if ((this.mScroller != null) && (!this.mScroller.isFinished()))
    {
      i = 1;
      if (i == 0) {
        break label143;
      }
      if (!this.mIsScrollStarted) {
        break label131;
      }
      i = this.mScroller.getCurrX();
      label66:
      this.mScroller.abortAnimation();
      setScrollingCacheEnabled(false);
    }
    int j;
    int k;
    for (;;)
    {
      j = getScrollY();
      k = paramInt1 - i;
      paramInt2 -= j;
      if ((k != 0) || (paramInt2 != 0)) {
        break label152;
      }
      completeScroll(false);
      populate();
      setScrollState(0);
      AppMethodBeat.o(235357);
      return;
      i = 0;
      break;
      label131:
      i = this.mScroller.getStartX();
      break label66;
      label143:
      i = getScrollX();
    }
    label152:
    setScrollingCacheEnabled(true);
    setScrollState(2);
    paramInt1 = getClientWidth();
    int m = paramInt1 / 2;
    float f3 = Math.min(1.0F, Math.abs(k) * 1.0F / paramInt1);
    float f1 = m;
    float f2 = m;
    f3 = distanceInfluenceForSnapDuration(f3);
    paramInt3 = Math.abs(paramInt3);
    if (paramInt3 > 0) {}
    for (paramInt1 = Math.round(1000.0F * Math.abs((f2 * f3 + f1) / paramInt3)) * 4;; paramInt1 = (int)((Math.abs(k) / (f1 * f2 + this.mPageMargin) + 1.0F) * 100.0F))
    {
      paramInt1 = Math.min(paramInt1, 600);
      this.mIsScrollStarted = false;
      this.mScroller.startScroll(i, j, k, paramInt2, paramInt1);
      w.G(this);
      AppMethodBeat.o(235357);
      return;
      f1 = paramInt1;
      f2 = this.mAdapter.getPageWidth(this.mCurItem);
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(235344);
    if ((super.verifyDrawable(paramDrawable)) || (paramDrawable == this.mMarginDrawable))
    {
      AppMethodBeat.o(235344);
      return true;
    }
    AppMethodBeat.o(235344);
    return false;
  }
  
  static class ItemInfo
  {
    Object object;
    float offset;
    int position;
    boolean scrolling;
    float widthFactor;
  }
  
  public static class LayoutParams
    extends ViewGroup.LayoutParams
  {
    public boolean avM;
    boolean avN;
    int avO;
    public int ek;
    int position;
    float widthFactor;
    
    public LayoutParams()
    {
      super(-1);
      this.widthFactor = 0.0F;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(235209);
      this.widthFactor = 0.0F;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ViewPager.LAYOUT_ATTRS);
      this.ek = paramContext.getInteger(0, 48);
      paramContext.recycle();
      AppMethodBeat.o(235209);
    }
  }
  
  public static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    Parcelable avP;
    ClassLoader avQ;
    int position;
    
    static
    {
      AppMethodBeat.i(235239);
      CREATOR = new Parcelable.ClassLoaderCreator() {};
      AppMethodBeat.o(235239);
    }
    
    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      AppMethodBeat.i(235237);
      ClassLoader localClassLoader = paramClassLoader;
      if (paramClassLoader == null) {
        localClassLoader = getClass().getClassLoader();
      }
      this.position = paramParcel.readInt();
      this.avP = paramParcel.readParcelable(localClassLoader);
      this.avQ = localClassLoader;
      AppMethodBeat.o(235237);
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      AppMethodBeat.i(235236);
      String str = "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
      AppMethodBeat.o(235236);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(235235);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.position);
      paramParcel.writeParcelable(this.avP, paramInt);
      AppMethodBeat.o(235235);
    }
  }
  
  final class b
    extends androidx.core.g.a
  {
    b() {}
    
    private boolean hE()
    {
      AppMethodBeat.i(235217);
      if ((ViewPager.this.mAdapter != null) && (ViewPager.this.mAdapter.getCount() > 1))
      {
        AppMethodBeat.o(235217);
        return true;
      }
      AppMethodBeat.o(235217);
      return false;
    }
    
    public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      AppMethodBeat.i(235213);
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(ViewPager.class.getName());
      paramAccessibilityEvent.setScrollable(hE());
      if ((paramAccessibilityEvent.getEventType() == 4096) && (ViewPager.this.mAdapter != null))
      {
        paramAccessibilityEvent.setItemCount(ViewPager.this.mAdapter.getCount());
        paramAccessibilityEvent.setFromIndex(ViewPager.this.mCurItem);
        paramAccessibilityEvent.setToIndex(ViewPager.this.mCurItem);
      }
      AppMethodBeat.o(235213);
    }
    
    public final void onInitializeAccessibilityNodeInfo(View paramView, d paramd)
    {
      AppMethodBeat.i(235215);
      super.onInitializeAccessibilityNodeInfo(paramView, paramd);
      paramd.t(ViewPager.class.getName());
      paramd.ab(hE());
      if (ViewPager.this.canScrollHorizontally(1)) {
        paramd.bA(4096);
      }
      if (ViewPager.this.canScrollHorizontally(-1)) {
        paramd.bA(8192);
      }
      AppMethodBeat.o(235215);
    }
    
    public final boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(235216);
      if (super.performAccessibilityAction(paramView, paramInt, paramBundle))
      {
        AppMethodBeat.o(235216);
        return true;
      }
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(235216);
        return false;
      case 4096: 
        if (ViewPager.this.canScrollHorizontally(1))
        {
          ViewPager.this.setCurrentItem(ViewPager.this.mCurItem + 1);
          AppMethodBeat.o(235216);
          return true;
        }
        AppMethodBeat.o(235216);
        return false;
      }
      if (ViewPager.this.canScrollHorizontally(-1))
      {
        ViewPager.this.setCurrentItem(ViewPager.this.mCurItem - 1);
        AppMethodBeat.o(235216);
        return true;
      }
      AppMethodBeat.o(235216);
      return false;
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(ViewPager paramViewPager, a parama1, a parama2);
  }
  
  public static abstract interface d
  {
    public abstract void o(View paramView, float paramFloat);
  }
  
  class e
    extends DataSetObserver
  {
    e() {}
    
    public void onChanged()
    {
      AppMethodBeat.i(235220);
      ViewPager.this.dataSetChanged();
      AppMethodBeat.o(235220);
    }
    
    public void onInvalidated()
    {
      AppMethodBeat.i(235221);
      ViewPager.this.dataSetChanged();
      AppMethodBeat.o(235221);
    }
  }
  
  static class g
    implements Comparator<View>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.viewpager.widget.ViewPager
 * JD-Core Version:    0.7.0.1
 */