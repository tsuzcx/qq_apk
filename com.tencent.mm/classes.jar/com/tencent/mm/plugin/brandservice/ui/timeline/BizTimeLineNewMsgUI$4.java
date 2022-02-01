package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class BizTimeLineNewMsgUI$4
  implements View.OnTouchListener
{
  BizTimeLineNewMsgUI$4(BizTimeLineNewMsgUI paramBizTimeLineNewMsgUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(5919);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineNewMsgUI$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      a.a(false, this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineNewMsgUI$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(5919);
      return false;
      BizTimeLineNewMsgUI.a(this.obi, (int)paramMotionEvent.getRawX());
      BizTimeLineNewMsgUI.b(this.obi, (int)paramMotionEvent.getRawY());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineNewMsgUI.4
 * JD-Core Version:    0.7.0.1
 */