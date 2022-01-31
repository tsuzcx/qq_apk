package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class RemoteDebugMoveView
  extends FrameLayout
{
  float fSA;
  float fSB;
  int fSw;
  int fSx;
  float fSy;
  float fSz;
  
  public RemoteDebugMoveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RemoteDebugMoveView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      this.fSy = paramMotionEvent.getRawX();
      this.fSz = paramMotionEvent.getRawY();
      continue;
      this.fSA = paramMotionEvent.getRawX();
      this.fSB = paramMotionEvent.getRawY();
      float f1 = getX() + (this.fSA - this.fSy);
      if ((0.0F < f1) && (f1 < this.fSw - getWidth())) {
        setX(f1);
      }
      f1 = this.fSB - this.fSz;
      float f2 = this.fSx - getHeight();
      float f3 = getY() + f1;
      if (((0.0F < f3) && (f3 < f2)) || ((f3 <= 0.0F) && (f1 > 0.0F)) || ((f3 >= f2) && (f1 < 0.0F))) {
        setY(f3);
      }
      this.fSy = this.fSA;
      this.fSz = this.fSB;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView
 * JD-Core Version:    0.7.0.1
 */