package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.ui.e;

final class LuckyMoneyPrepareUI$19$1
  implements DialogInterface.OnClickListener
{
  LuckyMoneyPrepareUI$19$1(LuckyMoneyPrepareUI.19 param19, b paramb) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(142069);
    ab.i("MicroMsg.LuckyMoneyPrepareUI", "goto h5: %s", new Object[] { this.owN.kNB });
    e.m(this.owO.owL.getContext(), this.owN.kNB, false);
    LuckyMoneyPrepareUI.a(this.owO.owL, false);
    AppMethodBeat.o(142069);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.19.1
 * JD-Core Version:    0.7.0.1
 */