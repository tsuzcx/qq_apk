package com.tencent.kinda.framework.widget.base;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.kinda.gen.KViewOnTouchCallback;
import com.tencent.kinda.gen.TouchAction;
import com.tencent.kinda.gen.TouchEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

class MMKView$4
  implements View.OnTouchListener
{
  private byte _hellAccFlag_;
  
  MMKView$4(MMKView paramMMKView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(19124);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/kinda/framework/widget/base/MMKView$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
    if (MMKView.access$400(this.this$0) != null)
    {
      paramView = TouchAction.DOWN;
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      paramView = new TouchEvent(paramMotionEvent.getX(), paramMotionEvent.getY(), paramView);
      MMKView.access$400(this.this$0).onTouch(paramView);
      a.a(false, this, "com/tencent/kinda/framework/widget/base/MMKView$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKView.4
 * JD-Core Version:    0.7.0.1
 */