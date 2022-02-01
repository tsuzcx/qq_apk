package com.tencent.mm.plugin.luckymoney.ui;

import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.Log;

final class LuckyMoneyPrepareUI$3
  implements Runnable
{
  LuckyMoneyPrepareUI$3(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(211384);
    TextView localTextView = (TextView)this.ENG.findViewById(a.f.lucky_money_exclusive_title_tv);
    ImageView localImageView = (ImageView)this.ENG.findViewById(a.f.lucky_money_exclusive_arrow_iv);
    int i = localTextView.getRight();
    int j = a.fromDPToPix(this.ENG.getContext(), 52);
    i = localImageView.getLeft() - a.fromDPToPix(this.ENG.getContext(), 8) - (i + j);
    if (i > 0)
    {
      Log.d("MicroMsg.LuckyMoneyPrepareUI", "usernametv maxwidth: %s", new Object[] { Integer.valueOf(i) });
      LuckyMoneyPrepareUI.r(this.ENG).setMaxWidth(i);
    }
    AppMethodBeat.o(211384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.3
 * JD-Core Version:    0.7.0.1
 */