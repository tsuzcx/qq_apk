package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.y;

final class FacebookAuthUI$7
  implements DialogInterface.OnClickListener
{
  FacebookAuthUI$7(FacebookAuthUI paramFacebookAuthUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(124782);
    paramDialogInterface = this.gDa.getString(2131297087);
    String str = this.gDa.getString(2131299629);
    FacebookAuthUI.a(this.gDa, ProgressDialog.show(this.gDa, paramDialogInterface, str, true));
    FacebookAuthUI.f(this.gDa).setOnCancelListener(FacebookAuthUI.e(this.gDa));
    paramDialogInterface = new y(y.gxZ);
    g.Rc().a(paramDialogInterface, 0);
    AppMethodBeat.o(124782);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookAuthUI.7
 * JD-Core Version:    0.7.0.1
 */