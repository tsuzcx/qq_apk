package com.tencent.kinda.framework.widget.base;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.kinda.gen.KViewOnTouchCallback;
import com.tencent.kinda.gen.TouchAction;
import com.tencent.kinda.gen.TouchEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;

class MMKView$4
  implements View.OnTouchListener
{
  MMKView$4(MMKView paramMMKView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(19124);
    if (MMKView.access$200(this.this$0) != null)
    {
      paramView = TouchAction.DOWN;
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      paramView = new TouchEvent(paramMotionEvent.getX(), paramMotionEvent.getY(), paramView);
      MMKView.access$200(this.this$0).onTouch(paramView);
      AppMethodBeat.o(19124);
      return false;
      paramView = TouchAction.DOWN;
      continue;
      paramView = TouchAction.MOVE;
      continue;
      paramView = TouchAction.UP;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKView.4
 * JD-Core Version:    0.7.0.1
 */