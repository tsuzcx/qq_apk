package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WxaLuckyMoneyCompleteUI$1
  implements View.OnClickListener
{
  WxaLuckyMoneyCompleteUI$1(WxaLuckyMoneyCompleteUI paramWxaLuckyMoneyCompleteUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42049);
    this.ojE.setResult(0, null);
    this.ojE.finish();
    AppMethodBeat.o(42049);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyCompleteUI.1
 * JD-Core Version:    0.7.0.1
 */