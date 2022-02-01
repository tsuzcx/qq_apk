package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.luckymoney.model.aq;

final class LuckyMoneyPrepareUI$21
  implements DialogInterface.OnClickListener
{
  LuckyMoneyPrepareUI$21(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI, n paramn) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(65850);
    if (aq.j(this.cXh))
    {
      this.uyl.finish();
      AppMethodBeat.o(65850);
      return;
    }
    AppMethodBeat.o(65850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.21
 * JD-Core Version:    0.7.0.1
 */