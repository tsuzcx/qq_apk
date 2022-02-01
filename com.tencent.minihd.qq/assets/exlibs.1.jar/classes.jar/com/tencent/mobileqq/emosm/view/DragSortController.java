package com.tencent.mobileqq.emosm.view;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;

public class DragSortController
  extends SimpleFloatViewManager
  implements GestureDetector.OnGestureListener, View.OnTouchListener
{
  public static final int CLICK_REMOVE = 0;
  public static final int FLING_REMOVE = 1;
  public static final int MISS = -1;
  public static final int ON_DOWN = 0;
  public static final int ON_DRAG = 1;
  public static final int ON_LONG_PRESS = 2;
  public static final int SLIDE_LEFT_AND_RIGHT_REMOVE = 3;
  public static final int SLIDE_LEFT_TO_RIGHT_REMOVE = 1;
  public static final int SLIDE_RIGHT_TO_LEFT_REMOVE = 2;
  private boolean mCanDrag;
  private int mClickRemoveHitPos = -1;
  private int mClickRemoveId;
  int mCurrX;
  int mCurrY;
  GestureDetector mDetector;
  private int mDragHandleId;
  private int mDragInitMode = 0;
  boolean mDragging = false;
  DragSortListView mDslv;
  private int mFlingHandleId;
  private int mFlingHitPos = -1;
  GestureDetector mFlingRemoveDetector;
  private GestureDetector.OnGestureListener mFlingRemoveListener = new DragSortController.1(this);
  private float mFlingSpeed = 500.0F;
  private boolean mHasSlide;
  private int mHitPos = -1;
  boolean mIsRemoving = false;
  int mItemPosition;
  private int mItemX;
  private int mItemY;
  private int mPositionX;
  boolean mRemoveEnabled = false;
  private int mRemoveMode;
  int mRemoveOrientation;
  float mSlideSlop = ViewConfiguration.getTouchSlop() + 2;
  private boolean mSortEnabled = true;
  private int[] mTempLoc = new int[2];
  private int mTouchSlop;
  
  public DragSortController(DragSortListView paramDragSortListView)
  {
    this(paramDragSortListView, 0, 0, 1);
  }
  
  public DragSortController(DragSortListView paramDragSortListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramDragSortListView, paramInt1, paramInt2, paramInt3, 0);
  }
  
  public DragSortController(DragSortListView paramDragSortListView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this(paramDragSortListView, paramInt1, paramInt2, paramInt3, paramInt4, 0);
  }
  
  public DragSortController(DragSortListView paramDragSortListView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super(paramDragSortListView);
    this.mDslv = paramDragSortListView;
    this.mDetector = new GestureDetector(paramDragSortListView.getContext(), this);
    this.mFlingRemoveDetector = new GestureDetector(paramDragSortListView.getContext(), this.mFlingRemoveListener);
    this.mFlingRemoveDetector.setIsLongpressEnabled(false);
    this.mTouchSlop = ViewConfiguration.get(paramDragSortListView.getContext()).getScaledTouchSlop();
    this.mDragHandleId = paramInt1;
    this.mClickRemoveId = paramInt4;
    this.mFlingHandleId = paramInt5;
    setRemoveMode(paramInt3);
    setDragInitMode(paramInt2);
    this.mRemoveOrientation = 3;
  }
  
  public int dragHandleHitPosition(MotionEvent paramMotionEvent)
  {
    return viewIdHitPosition(paramMotionEvent, this.mDragHandleId);
  }
  
  public int flingHandleHitPosition(MotionEvent paramMotionEvent)
  {
    return viewIdHitPosition(paramMotionEvent, this.mFlingHandleId);
  }
  
  public int getDragInitMode()
  {
    return this.mDragInitMode;
  }
  
  public int getRemoveMode()
  {
    return this.mRemoveMode;
  }
  
  public boolean isRemoveEnabled()
  {
    return this.mRemoveEnabled;
  }
  
  public boolean isSortEnabled()
  {
    return this.mSortEnabled;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    if ((this.mRemoveEnabled) && (this.mRemoveMode == 0)) {
      this.mClickRemoveHitPos = viewIdHitPosition(paramMotionEvent, this.mClickRemoveId);
    }
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    this.mItemPosition = this.mDslv.pointToPosition(i, j);
    this.mHitPos = startDragPosition(paramMotionEvent);
    if ((this.mHitPos != -1) && (this.mDragInitMode == 0)) {
      startDrag(this.mHitPos, (int)paramMotionEvent.getX() - this.mItemX, (int)paramMotionEvent.getY() - this.mItemY);
    }
    this.mIsRemoving = false;
    this.mCanDrag = true;
    this.mPositionX = 0;
    this.mFlingHitPos = startFlingPosition(paramMotionEvent);
    return true;
  }
  
  public void onDragFloatView(View paramView, Point paramPoint1, Point paramPoint2)
  {
    if ((this.mRemoveEnabled) && (this.mIsRemoving)) {
      this.mPositionX = paramPoint1.x;
    }
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if ((this.mHitPos != -1) && (this.mDragInitMode == 2))
    {
      this.mDslv.performHapticFeedback(0);
      startDrag(this.mHitPos, this.mCurrX - this.mItemX, this.mCurrY - this.mItemY);
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {}
    int j;
    int m;
    do
    {
      int i;
      int k;
      int n;
      int i1;
      do
      {
        do
        {
          do
          {
            return false;
            i = (int)paramMotionEvent1.getX();
            j = (int)paramMotionEvent1.getY();
            k = (int)paramMotionEvent2.getX();
            m = (int)paramMotionEvent2.getY();
            n = k - this.mItemX;
            i1 = m - this.mItemY;
          } while ((!this.mCanDrag) || (this.mDragging) || ((this.mHitPos == -1) && (this.mFlingHitPos == -1)));
          if (this.mHitPos == -1) {
            break;
          }
          if ((this.mDragInitMode == 1) && (Math.abs(m - j) > this.mTouchSlop) && (this.mSortEnabled))
          {
            startDrag(this.mHitPos, n, i1);
            return false;
          }
        } while ((this.mDragInitMode == 0) || (Math.abs(k - i) <= this.mTouchSlop) || (!this.mRemoveEnabled));
        this.mIsRemoving = true;
        startDrag(this.mFlingHitPos, n, i1);
        return false;
      } while (this.mFlingHitPos == -1);
      if ((Math.abs(k - i) > this.mTouchSlop) && (this.mRemoveEnabled))
      {
        this.mIsRemoving = true;
        startDrag(this.mFlingHitPos, n, i1);
        return false;
      }
    } while (Math.abs(m - j) <= this.mTouchSlop);
    this.mCanDrag = false;
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if ((this.mRemoveEnabled) && (this.mRemoveMode == 0) && (this.mClickRemoveHitPos != -1)) {
      this.mDslv.removeItem(this.mClickRemoveHitPos - this.mDslv.getHeaderViewsCount());
    }
    return true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((!this.mDslv.isDragEnabled()) || (this.mDslv.listViewIntercepted()))
    {
      if (!this.mDslv.isDragEnabled())
      {
        if (paramMotionEvent.getAction() == 0)
        {
          i = (int)paramMotionEvent.getX();
          int j = (int)paramMotionEvent.getY();
          this.mItemPosition = this.mDslv.pointToPosition(i, j);
        }
        return this.mFlingRemoveDetector.onTouchEvent(paramMotionEvent);
      }
      return false;
    }
    this.mDetector.onTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    case 2: 
    default: 
    case 0: 
      for (;;)
      {
        return false;
        this.mCurrX = ((int)paramMotionEvent.getX());
        this.mCurrY = ((int)paramMotionEvent.getY());
      }
    case 1: 
      if ((this.mRemoveEnabled) && (this.mIsRemoving)) {
        if (this.mPositionX < 0) {
          break label209;
        }
      }
      break;
    }
    label209:
    for (int i = this.mPositionX;; i = -this.mPositionX)
    {
      if (i > this.mDslv.getWidth() / 2) {
        this.mDslv.stopDragWithVelocity(false, 0.0F);
      }
      this.mIsRemoving = false;
      this.mDragging = false;
      break;
    }
  }
  
  public void setClickRemoveId(int paramInt)
  {
    this.mClickRemoveId = paramInt;
  }
  
  public void setDragHandleId(int paramInt)
  {
    this.mDragHandleId = paramInt;
  }
  
  public void setDragInitMode(int paramInt)
  {
    this.mDragInitMode = paramInt;
  }
  
  public void setFlingHandleId(int paramInt)
  {
    this.mFlingHandleId = paramInt;
  }
  
  public void setRemoveEnabled(boolean paramBoolean)
  {
    this.mRemoveEnabled = paramBoolean;
  }
  
  public void setRemoveMode(int paramInt)
  {
    this.mRemoveMode = paramInt;
  }
  
  public void setRemoveOrientation(int paramInt)
  {
    this.mRemoveOrientation = paramInt;
  }
  
  public void setSortEnabled(boolean paramBoolean)
  {
    this.mSortEnabled = paramBoolean;
  }
  
  public boolean startDrag(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 0;
    int i = j;
    if (this.mSortEnabled)
    {
      i = j;
      if (!this.mIsRemoving) {
        i = 12;
      }
    }
    j = i;
    if (this.mRemoveEnabled)
    {
      j = i;
      if (this.mIsRemoving) {
        j = i | 0x1 | 0x2;
      }
    }
    this.mDragging = this.mDslv.startDrag(paramInt1 - this.mDslv.getHeaderViewsCount(), j, paramInt2, paramInt3);
    return this.mDragging;
  }
  
  public int startDragPosition(MotionEvent paramMotionEvent)
  {
    return dragHandleHitPosition(paramMotionEvent);
  }
  
  public int startFlingPosition(MotionEvent paramMotionEvent)
  {
    if (this.mRemoveMode == 1) {
      return flingHandleHitPosition(paramMotionEvent);
    }
    return -1;
  }
  
  public int viewIdHitPosition(MotionEvent paramMotionEvent, int paramInt)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    i = this.mDslv.pointToPosition(i, j);
    j = this.mDslv.getHeaderViewsCount();
    int k = this.mDslv.getFooterViewsCount();
    int m = this.mDslv.getCount();
    if ((i != -1) && (i >= j) && (i < m - k))
    {
      View localView = this.mDslv.getChildAt(i - this.mDslv.getFirstVisiblePosition());
      k = (int)paramMotionEvent.getRawX();
      j = (int)paramMotionEvent.getRawY();
      if (paramInt == 0) {}
      for (paramMotionEvent = localView; paramMotionEvent != null; paramMotionEvent = localView.findViewById(paramInt))
      {
        paramMotionEvent.getLocationOnScreen(this.mTempLoc);
        if ((k <= this.mTempLoc[0]) || (j <= this.mTempLoc[1]) || (k >= this.mTempLoc[0] + paramMotionEvent.getWidth())) {
          break;
        }
        paramInt = this.mTempLoc[1];
        if (j >= paramMotionEvent.getHeight() + paramInt) {
          break;
        }
        this.mItemX = localView.getLeft();
        this.mItemY = localView.getTop();
        return i;
      }
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortController
 * JD-Core Version:    0.7.0.1
 */