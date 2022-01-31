package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;

final class FacebookAuthUI$4
  implements DialogInterface.OnCancelListener
{
  FacebookAuthUI$4(FacebookAuthUI paramFacebookAuthUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(124777);
    if (FacebookAuthUI.a(this.gDa) != null) {
      g.Rc().a(FacebookAuthUI.a(this.gDa));
    }
    AppMethodBeat.o(124777);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookAuthUI.4
 * JD-Core Version:    0.7.0.1
 */