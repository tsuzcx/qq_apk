package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMWizardActivity;

final class BindMContactIntroUI$26
  implements DialogInterface.OnClickListener
{
  BindMContactIntroUI$26(BindMContactIntroUI paramBindMContactIntroUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(13436);
    MMWizardActivity.J(this.gtw, new Intent(this.gtw, BindMContactStatusUI.class));
    AppMethodBeat.o(13436);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.26
 * JD-Core Version:    0.7.0.1
 */