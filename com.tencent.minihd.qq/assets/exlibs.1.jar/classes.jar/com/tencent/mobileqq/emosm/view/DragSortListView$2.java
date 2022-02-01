package com.tencent.mobileqq.emosm.view;

import android.database.DataSetObserver;

class DragSortListView$2
  extends DataSetObserver
{
  DragSortListView$2(DragSortListView paramDragSortListView) {}
  
  private void cancel()
  {
    if (this.this$0.mDragState == 4) {
      this.this$0.cancelDrag();
    }
  }
  
  public void onChanged()
  {
    cancel();
  }
  
  public void onInvalidated()
  {
    cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortListView.2
 * JD-Core Version:    0.7.0.1
 */