package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;

final class BindGoogleContactIntroUI$4
  implements DialogInterface.OnCancelListener
{
  BindGoogleContactIntroUI$4(BindGoogleContactIntroUI paramBindGoogleContactIntroUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(13336);
    g.Rc().a(BindGoogleContactIntroUI.c(this.gsw));
    AppMethodBeat.o(13336);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindGoogleContactIntroUI.4
 * JD-Core Version:    0.7.0.1
 */