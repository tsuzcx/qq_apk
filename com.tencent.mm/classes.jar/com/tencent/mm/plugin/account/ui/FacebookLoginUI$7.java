package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.d;

final class FacebookLoginUI$7
  implements DialogInterface.OnClickListener
{
  FacebookLoginUI$7(FacebookLoginUI paramFacebookLoginUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(124840);
    if (d.whK)
    {
      FacebookLoginUI.e(this.gDq);
      AppMethodBeat.o(124840);
      return;
    }
    FacebookLoginUI.f(this.gDq);
    AppMethodBeat.o(124840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookLoginUI.7
 * JD-Core Version:    0.7.0.1
 */