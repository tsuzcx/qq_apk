package com.tencent.mm.plugin.card.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class CardAcceptCardListUI$6
  implements DialogInterface.OnClickListener
{
  CardAcceptCardListUI$6(CardAcceptCardListUI paramCardAcceptCardListUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(113154);
    paramDialogInterface.dismiss();
    CardAcceptCardListUI.a(this.pYO, 2);
    AppMethodBeat.o(113154);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardAcceptCardListUI.6
 * JD-Core Version:    0.7.0.1
 */