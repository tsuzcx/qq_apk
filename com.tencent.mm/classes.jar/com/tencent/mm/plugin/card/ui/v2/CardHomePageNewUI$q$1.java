package com.tencent.mm.plugin.card.ui.v2;

import a.l;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$showSortSheet$1$2$1"})
final class CardHomePageNewUI$q$1
  implements DialogInterface.OnClickListener
{
  CardHomePageNewUI$q$1(CardHomePageNewUI.q paramq) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(152210);
    this.kAb.kzs.startActivityForResult(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"), 564);
    AppMethodBeat.o(152210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI.q.1
 * JD-Core Version:    0.7.0.1
 */