package com.tencent.av.opengl.gesture;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

public class MoveGestureDetector
  extends BaseGestureDetector
{
  private static final PointF FOCUS_DELTA_ZERO = new PointF();
  private PointF mCurrFocusInternal;
  private PointF mFocusDeltaExternal = new PointF();
  private PointF mFocusExternal = new PointF();
  private final OnMoveGestureListener mListener;
  private PointF mPrevFocusInternal;
  
  public MoveGestureDetector(Context paramContext, OnMoveGestureListener paramOnMoveGestureListener)
  {
    super(paramContext);
    this.mListener = paramOnMoveGestureListener;
  }
  
  private PointF determineFocalPoint(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getPointerCount();
    float f2 = 0.0F;
    float f1 = 0.0F;
    int i = 0;
    while (i < j)
    {
      f2 += paramMotionEvent.getX(i);
      f1 += paramMotionEvent.getY(i);
      i += 1;
    }
    return new PointF(f2 / j, f1 / j);
  }
  
  public PointF getFocusDelta()
  {
    return this.mFocusDeltaExternal;
  }
  
  public float getFocusX()
  {
    return this.mFocusExternal.x;
  }
  
  public float getFocusY()
  {
    return this.mFocusExternal.y;
  }
  
  protected void handleInProgressEvent(int paramInt, MotionEvent paramMotionEvent)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      this.mListener.onMoveEnd(this);
      resetState();
      return;
      updateStateByEvent(paramMotionEvent);
    } while ((this.mCurrPressure / this.mPrevPressure <= 0.67F) || (!this.mListener.onMove(this)) || (this.mPrevEvent == null));
    this.mPrevEvent.recycle();
    this.mPrevEvent = MotionEvent.obtain(paramMotionEvent);
  }
  
  protected void handleStartProgressEvent(int paramInt, MotionEvent paramMotionEvent)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return;
    case 0: 
      resetState();
      this.mPrevEvent = MotionEvent.obtain(paramMotionEvent);
      this.mTimeDelta = 0L;
      updateStateByEvent(paramMotionEvent);
      return;
    }
    this.mGestureInProgress = this.mListener.onMoveBegin(this);
  }
  
  protected void updateStateByEvent(MotionEvent paramMotionEvent)
  {
    super.updateStateByEvent(paramMotionEvent);
    MotionEvent localMotionEvent = this.mPrevEvent;
    if ((paramMotionEvent == null) || (localMotionEvent == null)) {
      return;
    }
    this.mCurrFocusInternal = determineFocalPoint(paramMotionEvent);
    this.mPrevFocusInternal = determineFocalPoint(localMotionEvent);
    int i;
    if (localMotionEvent.getPointerCount() != paramMotionEvent.getPointerCount())
    {
      i = 1;
      if (i == 0) {
        break label111;
      }
    }
    label111:
    for (paramMotionEvent = FOCUS_DELTA_ZERO;; paramMotionEvent = new PointF(this.mCurrFocusInternal.x - this.mPrevFocusInternal.x, this.mCurrFocusInternal.y - this.mPrevFocusInternal.y))
    {
      this.mFocusDeltaExternal = paramMotionEvent;
      paramMotionEvent = this.mFocusExternal;
      paramMotionEvent.x += this.mFocusDeltaExternal.x;
      paramMotionEvent = this.mFocusExternal;
      paramMotionEvent.y += this.mFocusDeltaExternal.y;
      return;
      i = 0;
      break;
    }
  }
  
  public static abstract interface OnMoveGestureListener
  {
    public abstract boolean onMove(MoveGestureDetector paramMoveGestureDetector);
    
    public abstract boolean onMoveBegin(MoveGestureDetector paramMoveGestureDetector);
    
    public abstract void onMoveEnd(MoveGestureDetector paramMoveGestureDetector);
  }
  
  public static class SimpleOnMoveGestureListener
    implements MoveGestureDetector.OnMoveGestureListener
  {
    public boolean onMove(MoveGestureDetector paramMoveGestureDetector)
    {
      return false;
    }
    
    public boolean onMoveBegin(MoveGestureDetector paramMoveGestureDetector)
    {
      return true;
    }
    
    public void onMoveEnd(MoveGestureDetector paramMoveGestureDetector) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.av.opengl.gesture.MoveGestureDetector
 * JD-Core Version:    0.7.0.1
 */