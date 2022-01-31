package com.tencent.mm.plugin.card.base;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class CardBaseUI$8
  implements DialogInterface.OnClickListener
{
  CardBaseUI$8(CardBaseUI paramCardBaseUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(87624);
    this.kkO.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    AppMethodBeat.o(87624);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.base.CardBaseUI.8
 * JD-Core Version:    0.7.0.1
 */