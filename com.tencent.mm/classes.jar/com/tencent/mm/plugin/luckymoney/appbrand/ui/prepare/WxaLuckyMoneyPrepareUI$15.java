package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.text.SpannableString;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.appbrand.a.g;
import com.tencent.mm.plugin.luckymoney.appbrand.a.h.a;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyMoneyInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNumInputView;
import com.tencent.mm.plugin.wallet_core.ui.j.a;
import com.tencent.mm.wallet_core.ui.e;

final class WxaLuckyMoneyPrepareUI$15
  implements j.a
{
  WxaLuckyMoneyPrepareUI$15(WxaLuckyMoneyPrepareUI paramWxaLuckyMoneyPrepareUI, SpannableString paramSpannableString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42070);
    int i = WxaLuckyMoneyPrepareUI.c(this.ojQ).getInput();
    double d = WxaLuckyMoneyPrepareUI.b(this.ojQ).getInput();
    WxaLuckyMoneyPrepareUI.a(this.ojQ, h.a.oiA);
    WxaLuckyMoneyPrepareUI.b(this.ojQ).setType(WxaLuckyMoneyPrepareUI.e(this.ojQ));
    WxaLuckyMoneyPrepareUI.b(this.ojQ).setMaxAmount(g.oiq.oiu);
    WxaLuckyMoneyPrepareUI.b(this.ojQ).setTitle(this.ojQ.getString(2131301333));
    WxaLuckyMoneyPrepareUI.b(this.ojQ).setShowGroupIcon(true);
    if ((d > 0.0D) && (i > 0)) {
      WxaLuckyMoneyPrepareUI.b(this.ojQ).setAmount(e.E(d * i));
    }
    WxaLuckyMoneyPrepareUI.g(this.ojQ).setText(this.ojW);
    AppMethodBeat.o(42070);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.15
 * JD-Core Version:    0.7.0.1
 */