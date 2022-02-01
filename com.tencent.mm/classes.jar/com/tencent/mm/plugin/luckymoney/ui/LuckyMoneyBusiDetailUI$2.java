package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class LuckyMoneyBusiDetailUI$2
  implements DialogInterface.OnClickListener
{
  LuckyMoneyBusiDetailUI$2(LuckyMoneyBusiDetailUI paramLuckyMoneyBusiDetailUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(65451);
    ae.i("MicroMsg.LuckyMoneyDetailUI", "RealnameGuideHelper dialog click cancel");
    AppMethodBeat.o(65451);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI.2
 * JD-Core Version:    0.7.0.1
 */