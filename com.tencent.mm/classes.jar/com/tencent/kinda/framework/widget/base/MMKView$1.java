package com.tencent.kinda.framework.widget.base;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.kinda.gen.KViewOnTouchCallback;
import com.tencent.kinda.gen.TouchAction;
import com.tencent.kinda.gen.TouchEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;

class MMKView$1
  implements View.OnTouchListener
{
  MMKView$1(MMKView paramMMKView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(144962);
    if (MMKView.access$000(this.this$0))
    {
      if (paramMotionEvent.getAction() == 0)
      {
        MMKView.access$102(this.this$0, this.this$0.backgroundColor);
        this.this$0.getView().setBackgroundColor(-3355444);
      }
    }
    else if (MMKView.access$200(this.this$0) != null)
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
      AppMethodBeat.o(144962);
      return false;
      if ((paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 2) && (paramMotionEvent.getAction() != 3)) {
        break;
      }
      this.this$0.getView().setBackgroundColor((int)MMKView.access$100(this.this$0));
      break;
      paramView = TouchAction.DOWN;
      continue;
      paramView = TouchAction.MOVE;
      continue;
      paramView = TouchAction.UP;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKView.1
 * JD-Core Version:    0.7.0.1
 */