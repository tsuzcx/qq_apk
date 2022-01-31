package com.tencent.mm.plugin.card.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.p;

final class CardGiftReceiveUI$3
  implements DialogInterface.OnCancelListener
{
  CardGiftReceiveUI$3(CardGiftReceiveUI paramCardGiftReceiveUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if ((CardGiftReceiveUI.c(this.iuv) != null) && (CardGiftReceiveUI.c(this.iuv).isShowing())) {
      CardGiftReceiveUI.c(this.iuv).dismiss();
    }
    if ((CardGiftReceiveUI.d(this.iuv).getVisibility() == 8) || (CardGiftReceiveUI.e(this.iuv).getVisibility() == 4))
    {
      y.i("MicroMsg.CardGiftReceiveUI", "user cancel & finish");
      this.iuv.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftReceiveUI.3
 * JD-Core Version:    0.7.0.1
 */