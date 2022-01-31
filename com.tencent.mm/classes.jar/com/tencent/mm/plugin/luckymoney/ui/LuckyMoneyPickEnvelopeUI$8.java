package com.tencent.mm.plugin.luckymoney.ui;

import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.scaledLayout.a;

final class LuckyMoneyPickEnvelopeUI$8
  implements LuckyMoneyEnvelopeTouchRecyclerView.a
{
  LuckyMoneyPickEnvelopeUI$8(LuckyMoneyPickEnvelopeUI paramLuckyMoneyPickEnvelopeUI) {}
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(42908);
    if (paramMotionEvent.getAction() == 0)
    {
      paramMotionEvent = this.ovW;
      LuckyMoneyPickEnvelopeUI.d(this.ovW);
      LuckyMoneyPickEnvelopeUI.a(paramMotionEvent, a.h(LuckyMoneyPickEnvelopeUI.c(this.ovW)));
      LuckyMoneyPickEnvelopeUI.d(this.ovW).opY = LuckyMoneyPickEnvelopeUI.e(this.ovW);
    }
    AppMethodBeat.o(42908);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.8
 * JD-Core Version:    0.7.0.1
 */