package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WxaLuckyMoneyPrepareUI$12
  implements View.OnTouchListener
{
  WxaLuckyMoneyPrepareUI$12(WxaLuckyMoneyPrepareUI paramWxaLuckyMoneyPrepareUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(42067);
    if (paramMotionEvent.getAction() == 0)
    {
      this.ojQ.hideTenpayKB();
      this.ojQ.hideVKB();
    }
    AppMethodBeat.o(42067);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.12
 * JD-Core Version:    0.7.0.1
 */