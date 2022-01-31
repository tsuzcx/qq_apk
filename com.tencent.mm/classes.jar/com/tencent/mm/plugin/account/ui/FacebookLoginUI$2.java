package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;

final class FacebookLoginUI$2
  implements DialogInterface.OnCancelListener
{
  FacebookLoginUI$2(FacebookLoginUI paramFacebookLoginUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(124831);
    if (FacebookLoginUI.h(this.gDq) != null) {
      g.Rc().a(FacebookLoginUI.h(this.gDq));
    }
    AppMethodBeat.o(124831);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookLoginUI.2
 * JD-Core Version:    0.7.0.1
 */