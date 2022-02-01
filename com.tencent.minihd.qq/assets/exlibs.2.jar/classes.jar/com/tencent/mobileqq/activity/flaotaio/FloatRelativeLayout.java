package com.tencent.mobileqq.activity.flaotaio;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class FloatRelativeLayout
  extends FrameLayout
{
  FloatRelativeLayout.WindowCloseCallBack a;
  
  public FloatRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    if (paramKeyEvent.getKeyCode() == 4)
    {
      if (getKeyDispatcherState() == null) {
        bool = super.dispatchKeyEvent(paramKeyEvent);
      }
      do
      {
        do
        {
          return bool;
          if ((paramKeyEvent.getAction() != 0) || (paramKeyEvent.getRepeatCount() != 0)) {
            break;
          }
          localDispatcherState = getKeyDispatcherState();
        } while (localDispatcherState == null);
        localDispatcherState.startTracking(paramKeyEvent, this);
        return true;
        if (paramKeyEvent.getAction() != 1) {
          break;
        }
        KeyEvent.DispatcherState localDispatcherState = getKeyDispatcherState();
        if ((localDispatcherState == null) || (!localDispatcherState.isTracking(paramKeyEvent)) || (paramKeyEvent.isCanceled())) {
          break;
        }
      } while (this.a == null);
      this.a.a();
      return true;
      return super.dispatchKeyEvent(paramKeyEvent);
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (getChildCount() == 0) {
      bool = super.onTouchEvent(paramMotionEvent);
    }
    do
    {
      do
      {
        return bool;
        int i = (int)paramMotionEvent.getX();
        int j = (int)paramMotionEvent.getY();
        View localView = findViewById(2131297712);
        if (localView == null) {
          return super.onTouchEvent(paramMotionEvent);
        }
        if ((paramMotionEvent.getAction() != 0) || ((i >= localView.getLeft()) && (i < localView.getLeft() + localView.getWidth()) && (j >= localView.getTop()) && (j < localView.getTop() + localView.getHeight()))) {
          break;
        }
      } while (this.a == null);
      this.a.b();
      return true;
      if (paramMotionEvent.getAction() != 4) {
        break;
      }
    } while (this.a == null);
    this.a.b();
    return true;
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setWindowCloseCallBack(FloatRelativeLayout.WindowCloseCallBack paramWindowCloseCallBack)
  {
    this.a = paramWindowCloseCallBack;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.flaotaio.FloatRelativeLayout
 * JD-Core Version:    0.7.0.1
 */