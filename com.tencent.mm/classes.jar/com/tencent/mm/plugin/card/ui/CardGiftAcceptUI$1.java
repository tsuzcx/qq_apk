package com.tencent.mm.plugin.card.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.p;

final class CardGiftAcceptUI$1
  implements DialogInterface.OnCancelListener
{
  CardGiftAcceptUI$1(CardGiftAcceptUI paramCardGiftAcceptUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(88382);
    if ((CardGiftAcceptUI.a(this.kuy) != null) && (CardGiftAcceptUI.a(this.kuy).isShowing())) {
      CardGiftAcceptUI.a(this.kuy).dismiss();
    }
    ab.i("MicroMsg.CardGiftAcceptUI", "user cancel & finish");
    this.kuy.finish();
    AppMethodBeat.o(88382);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftAcceptUI.1
 * JD-Core Version:    0.7.0.1
 */