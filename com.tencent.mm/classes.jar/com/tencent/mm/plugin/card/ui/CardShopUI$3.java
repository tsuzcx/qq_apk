package com.tencent.mm.plugin.card.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.model.am;

final class CardShopUI$3
  implements DialogInterface.OnCancelListener
{
  CardShopUI$3(CardShopUI paramCardShopUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(88631);
    paramDialogInterface = am.bcg();
    paramDialogInterface.a(CardShopUI.d(this.kxT), this.kxT);
    if (paramDialogInterface.kmi != null) {
      g.RK().eHt.a(paramDialogInterface.kmi);
    }
    AppMethodBeat.o(88631);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardShopUI.3
 * JD-Core Version:    0.7.0.1
 */