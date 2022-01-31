package com.tencent.mm.plugin.luckymoney.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LuckyMoneyPrepareUI$2
  implements View.OnTouchListener
{
  LuckyMoneyPrepareUI$2(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(142057);
    if (paramMotionEvent.getAction() == 0)
    {
      this.owL.hideTenpayKB();
      this.owL.hideVKB();
    }
    AppMethodBeat.o(142057);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.2
 * JD-Core Version:    0.7.0.1
 */