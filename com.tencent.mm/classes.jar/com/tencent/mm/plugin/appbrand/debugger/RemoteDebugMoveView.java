package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class RemoteDebugMoveView
  extends FrameLayout
{
  float bTE;
  float bTF;
  int hlX;
  int hlY;
  float hlZ;
  float hma;
  
  public RemoteDebugMoveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RemoteDebugMoveView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(101855);
    super.onConfigurationChanged(paramConfiguration);
    getViewTreeObserver().addOnGlobalLayoutListener(new RemoteDebugMoveView.2(this));
    AppMethodBeat.o(101855);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(101856);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(101856);
      return true;
      this.bTE = paramMotionEvent.getRawX();
      this.bTF = paramMotionEvent.getRawY();
      continue;
      this.hlZ = paramMotionEvent.getRawX();
      this.hma = paramMotionEvent.getRawY();
      float f1 = getX() + (this.hlZ - this.bTE);
      if ((0.0F < f1) && (f1 < this.hlX - getWidth())) {
        setX(f1);
      }
      f1 = this.hma - this.bTF;
      float f2 = this.hlY - getHeight();
      float f3 = getY() + f1;
      if (((0.0F < f3) && (f3 < f2)) || ((f3 <= 0.0F) && (f1 > 0.0F)) || ((f3 >= f2) && (f1 < 0.0F))) {
        setY(f3);
      }
      this.bTE = this.hlZ;
      this.bTF = this.hma;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView
 * JD-Core Version:    0.7.0.1
 */