package com.tencent.mm.plugin.luckymoney.ui;

import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.scaledLayout.ViewPagerLayoutManager;
import com.tencent.mm.plugin.luckymoney.scaledLayout.c;
import com.tencent.mm.sdk.platformtools.ab;

final class LuckyMoneyPickEnvelopeUI$13
  implements Runnable
{
  LuckyMoneyPickEnvelopeUI$13(LuckyMoneyPickEnvelopeUI paramLuckyMoneyPickEnvelopeUI) {}
  
  public final void run()
  {
    int i = 0;
    AppMethodBeat.i(42913);
    LuckyMoneyEnvelopeTouchRecyclerView localLuckyMoneyEnvelopeTouchRecyclerView;
    int j;
    if ((LuckyMoneyPickEnvelopeUI.a(this.ovW) >= 0) && (LuckyMoneyPickEnvelopeUI.a(this.ovW) < LuckyMoneyPickEnvelopeUI.i(this.ovW).getItemCount()))
    {
      ab.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "scroll to pos: %s", new Object[] { Integer.valueOf(LuckyMoneyPickEnvelopeUI.a(this.ovW)) });
      localLuckyMoneyEnvelopeTouchRecyclerView = LuckyMoneyPickEnvelopeUI.f(this.ovW);
      c localc = LuckyMoneyPickEnvelopeUI.c(this.ovW);
      j = localc.qR(LuckyMoneyPickEnvelopeUI.a(this.ovW));
      if (localc.mOrientation == 1) {
        localLuckyMoneyEnvelopeTouchRecyclerView.scrollBy(0, j);
      }
    }
    else
    {
      if (LuckyMoneyPickEnvelopeUI.a(this.ovW) >= 0) {
        break label139;
      }
    }
    for (;;)
    {
      LuckyMoneyPickEnvelopeUI.a(this.ovW, i);
      AppMethodBeat.o(42913);
      return;
      localLuckyMoneyEnvelopeTouchRecyclerView.scrollBy(j, 0);
      break;
      label139:
      i = LuckyMoneyPickEnvelopeUI.a(this.ovW);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.13
 * JD-Core Version:    0.7.0.1
 */