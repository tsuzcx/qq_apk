package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class LuckyMoneyDetailUI$7
  implements DialogInterface.OnClickListener
{
  LuckyMoneyDetailUI$7(LuckyMoneyDetailUI paramLuckyMoneyDetailUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(163721);
    ad.i("MicroMsg.LuckyMoneyDetailUI", "RealnameGuideHelper dialog click cancel");
    LuckyMoneyDetailUI.D(this.tme);
    AppMethodBeat.o(163721);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.7
 * JD-Core Version:    0.7.0.1
 */