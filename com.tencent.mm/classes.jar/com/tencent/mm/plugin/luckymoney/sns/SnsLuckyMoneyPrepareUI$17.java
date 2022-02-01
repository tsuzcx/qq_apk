package com.tencent.mm.plugin.luckymoney.sns;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsLuckyMoneyPrepareUI$17
  implements View.OnTouchListener
{
  SnsLuckyMoneyPrepareUI$17(SnsLuckyMoneyPrepareUI paramSnsLuckyMoneyPrepareUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(65383);
    if (paramMotionEvent.getAction() == 0)
    {
      this.Kwc.hideTenpayKB();
      this.Kwc.hideVKB();
    }
    AppMethodBeat.o(65383);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.17
 * JD-Core Version:    0.7.0.1
 */