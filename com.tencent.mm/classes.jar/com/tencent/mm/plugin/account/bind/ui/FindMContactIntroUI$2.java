package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FindMContactIntroUI$2
  implements DialogInterface.OnClickListener
{
  FindMContactIntroUI$2(FindMContactIntroUI paramFindMContactIntroUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(13597);
    paramDialogInterface.dismiss();
    this.guX.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    AppMethodBeat.o(13597);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI.2
 * JD-Core Version:    0.7.0.1
 */