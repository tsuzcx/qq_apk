package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.appbrand.a.h.a;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyMoneyInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNumInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyTextInputView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;

final class WxaLuckyMoneyPrepareUI$11
  extends com.tencent.mm.ui.t
{
  WxaLuckyMoneyPrepareUI$11(WxaLuckyMoneyPrepareUI paramWxaLuckyMoneyPrepareUI, String paramString) {}
  
  public final void bhX()
  {
    AppMethodBeat.i(42066);
    if (WxaLuckyMoneyPrepareUI.a(this.ojQ) == null)
    {
      ab.e("MicroMsg.WxaLuckyMoneyPrepareUI", "Click PrepareBtn but, mLogic == null");
      AppMethodBeat.o(42066);
      return;
    }
    if (WxaLuckyMoneyPrepareUI.b(this.ojQ).bMP() != 0)
    {
      com.tencent.mm.ui.base.t.makeText(this.ojQ.getContext(), 2131304847, 0).show();
      AppMethodBeat.o(42066);
      return;
    }
    int i = WxaLuckyMoneyPrepareUI.c(this.ojQ).getInput();
    double d = WxaLuckyMoneyPrepareUI.b(this.ojQ).getInput();
    String str2 = WxaLuckyMoneyPrepareUI.d(this.ojQ).getInput();
    String str1 = str2;
    if (bo.isNullOrNil(str2)) {
      if (bo.isNullOrNil(this.ojU)) {
        break label171;
      }
    }
    label171:
    for (str1 = this.ojU; WxaLuckyMoneyPrepareUI.e(this.ojQ) == h.a.oiA; str1 = this.ojQ.getString(2131301208))
    {
      WxaLuckyMoneyPrepareUI.a(this.ojQ).c((int)e.G(d), i, str1, WxaLuckyMoneyPrepareUI.f(this.ojQ));
      AppMethodBeat.o(42066);
      return;
    }
    if (WxaLuckyMoneyPrepareUI.e(this.ojQ) == h.a.oiB) {
      WxaLuckyMoneyPrepareUI.a(this.ojQ).d((int)e.G(d), i, str1, WxaLuckyMoneyPrepareUI.f(this.ojQ));
    }
    AppMethodBeat.o(42066);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.11
 * JD-Core Version:    0.7.0.1
 */