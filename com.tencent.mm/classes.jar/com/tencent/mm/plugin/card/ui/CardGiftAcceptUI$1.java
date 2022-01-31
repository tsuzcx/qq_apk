package com.tencent.mm.plugin.card.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.p;

final class CardGiftAcceptUI$1
  implements DialogInterface.OnCancelListener
{
  CardGiftAcceptUI$1(CardGiftAcceptUI paramCardGiftAcceptUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if ((CardGiftAcceptUI.a(this.itr) != null) && (CardGiftAcceptUI.a(this.itr).isShowing())) {
      CardGiftAcceptUI.a(this.itr).dismiss();
    }
    y.i("MicroMsg.CardGiftAcceptUI", "user cancel & finish");
    this.itr.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftAcceptUI.1
 * JD-Core Version:    0.7.0.1
 */