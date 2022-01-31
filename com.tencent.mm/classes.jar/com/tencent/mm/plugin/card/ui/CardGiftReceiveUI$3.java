package com.tencent.mm.plugin.card.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.p;

final class CardGiftReceiveUI$3
  implements DialogInterface.OnCancelListener
{
  CardGiftReceiveUI$3(CardGiftReceiveUI paramCardGiftReceiveUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(88417);
    if ((CardGiftReceiveUI.c(this.kvA) != null) && (CardGiftReceiveUI.c(this.kvA).isShowing())) {
      CardGiftReceiveUI.c(this.kvA).dismiss();
    }
    if ((CardGiftReceiveUI.d(this.kvA).getVisibility() == 8) || (CardGiftReceiveUI.e(this.kvA).getVisibility() == 4))
    {
      ab.i("MicroMsg.CardGiftReceiveUI", "user cancel & finish");
      this.kvA.finish();
    }
    AppMethodBeat.o(88417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftReceiveUI.3
 * JD-Core Version:    0.7.0.1
 */