package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;

final class BindGoogleContactUI$8
  implements DialogInterface.OnCancelListener
{
  BindGoogleContactUI$8(BindGoogleContactUI paramBindGoogleContactUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(13355);
    BindGoogleContactUI.f(this.gsF);
    if (BindGoogleContactUI.g(this.gsF) != null) {
      g.Rc().a(BindGoogleContactUI.g(this.gsF));
    }
    AppMethodBeat.o(13355);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindGoogleContactUI.8
 * JD-Core Version:    0.7.0.1
 */