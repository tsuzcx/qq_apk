package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;

final class BindFacebookUI$1
  implements DialogInterface.OnCancelListener
{
  BindFacebookUI$1(BindFacebookUI paramBindFacebookUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(124725);
    if (BindFacebookUI.a(this.gCw) != null) {
      g.Rc().a(BindFacebookUI.a(this.gCw));
    }
    AppMethodBeat.o(124725);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.BindFacebookUI.1
 * JD-Core Version:    0.7.0.1
 */