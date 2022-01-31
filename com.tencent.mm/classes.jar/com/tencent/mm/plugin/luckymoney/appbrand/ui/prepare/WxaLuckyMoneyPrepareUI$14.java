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

final class WxaLuckyMoneyPrepareUI$14
  implements j.a
{
  WxaLuckyMoneyPrepareUI$14(WxaLuckyMoneyPrepareUI paramWxaLuckyMoneyPrepareUI, SpannableString paramSpannableString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42069);
    int i = WxaLuckyMoneyPrepareUI.c(this.ojQ).getInput();
    double d = WxaLuckyMoneyPrepareUI.b(this.ojQ).getInput();
    WxaLuckyMoneyPrepareUI.a(this.ojQ, h.a.oiB);
    WxaLuckyMoneyPrepareUI.b(this.ojQ).setType(WxaLuckyMoneyPrepareUI.e(this.ojQ));
    WxaLuckyMoneyPrepareUI.b(this.ojQ).setShowGroupIcon(false);
    WxaLuckyMoneyPrepareUI.b(this.ojQ).setTitle(this.ojQ.getString(2131301334));
    if ((d > 0.0D) && (i > 0)) {
      WxaLuckyMoneyPrepareUI.b(this.ojQ).setAmount(e.E(d / i));
    }
    WxaLuckyMoneyPrepareUI.b(this.ojQ).setMaxAmount(g.oiq.ois);
    WxaLuckyMoneyPrepareUI.g(this.ojQ).setText(this.ojV);
    AppMethodBeat.o(42069);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.14
 * JD-Core Version:    0.7.0.1
 */