package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.kinda.framework.widget.tools.ColorUtil;
import com.tencent.kinda.gen.KViewOnTouchCallback;
import com.tencent.kinda.gen.TouchAction;
import com.tencent.kinda.gen.TouchEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

class MMKView$1
  implements View.OnTouchListener
{
  private byte _hellAccFlag_;
  
  MMKView$1(MMKView paramMMKView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(19121);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/kinda/framework/widget/base/MMKView$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
    if (MMKView.access$000(this.this$0))
    {
      if ((paramMotionEvent.getAction() == 0) || (paramMotionEvent.getAction() == 2))
      {
        MMKView.access$102(this.this$0, this.this$0.backgroundColor);
        MMKView.access$200(this.this$0).setBackgroundColor(this.this$0.mContext.getResources().getColor(2131100551));
        this.this$0.setViewBackground(MMKView.access$300(this.this$0));
      }
    }
    else if (MMKView.access$400(this.this$0) != null)
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
      a.a(false, this, "com/tencent/kinda/framework/widget/base/MMKView$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(19121);
      return false;
      if ((paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3)) {
        break;
      }
      MMKView.access$200(this.this$0).setBackgroundColor((int)ColorUtil.getColorByMode(MMKView.access$100(this.this$0)));
      this.this$0.setViewBackground(MMKView.access$300(this.this$0));
      break;
      paramView = TouchAction.DOWN;
      continue;
      paramView = TouchAction.MOVE;
      continue;
      paramView = TouchAction.UP;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKView.1
 * JD-Core Version:    0.7.0.1
 */