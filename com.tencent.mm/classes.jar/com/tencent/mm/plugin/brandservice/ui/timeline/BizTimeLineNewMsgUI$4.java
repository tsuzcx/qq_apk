package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BizTimeLineNewMsgUI$4
  implements View.OnTouchListener
{
  BizTimeLineNewMsgUI$4(BizTimeLineNewMsgUI paramBizTimeLineNewMsgUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(14159);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(14159);
      return false;
      BizTimeLineNewMsgUI.a(this.jWx, (int)paramMotionEvent.getRawX());
      BizTimeLineNewMsgUI.b(this.jWx, (int)paramMotionEvent.getRawY());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineNewMsgUI.4
 * JD-Core Version:    0.7.0.1
 */