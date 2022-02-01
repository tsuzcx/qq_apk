package com.tencent.mobileqq.emosm.view;

import android.graphics.Point;
import android.view.View;

class DragSortListView$DropAnimator
  extends DragSortListView.SmoothAnimator
{
  private int mDropPos;
  private float mInitDeltaX;
  private float mInitDeltaY;
  private int srcPos;
  
  public DragSortListView$DropAnimator(DragSortListView paramDragSortListView, float paramFloat, int paramInt)
  {
    super(paramDragSortListView, paramFloat, paramInt);
  }
  
  private int getTargetY()
  {
    int i = this.this$0.getFirstVisiblePosition();
    int j = (this.this$0.mItemHeightCollapsed + this.this$0.getDividerHeight()) / 2;
    View localView = this.this$0.getChildAt(this.mDropPos - i);
    if (localView != null)
    {
      if (this.mDropPos == this.srcPos) {
        return localView.getTop();
      }
      if (this.mDropPos < this.srcPos) {
        return localView.getTop() - j;
      }
      return localView.getBottom() + j - this.this$0.mFloatViewHeight;
    }
    cancel();
    return -1;
  }
  
  public void onStart()
  {
    this.mDropPos = this.this$0.mFloatPos;
    this.srcPos = this.this$0.mSrcPos;
    this.this$0.mDragState = 2;
    this.mInitDeltaY = (this.this$0.mFloatLoc.y - getTargetY());
    this.mInitDeltaX = (this.this$0.mFloatLoc.x - this.this$0.getPaddingLeft());
  }
  
  public void onStop()
  {
    DragSortListView.access$100(this.this$0);
  }
  
  public void onUpdate(float paramFloat1, float paramFloat2)
  {
    int i = getTargetY();
    int j = this.this$0.getPaddingLeft();
    paramFloat1 = this.this$0.mFloatLoc.y - i;
    float f = this.this$0.mFloatLoc.x - j;
    paramFloat2 = 1.0F - paramFloat2;
    if ((paramFloat2 < Math.abs(paramFloat1 / this.mInitDeltaY)) || (paramFloat2 < Math.abs(f / this.mInitDeltaX)))
    {
      this.this$0.mFloatLoc.y = (i + (int)(this.mInitDeltaY * paramFloat2));
      this.this$0.mFloatLoc.x = (this.this$0.getPaddingLeft() + (int)(this.mInitDeltaX * paramFloat2));
      this.this$0.doDragFloatView(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortListView.DropAnimator
 * JD-Core Version:    0.7.0.1
 */