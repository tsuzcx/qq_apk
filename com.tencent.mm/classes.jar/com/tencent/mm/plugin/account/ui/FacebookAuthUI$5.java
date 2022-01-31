package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.y;

final class FacebookAuthUI$5
  implements DialogInterface.OnClickListener
{
  FacebookAuthUI$5(FacebookAuthUI paramFacebookAuthUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.flI.getString(q.j.app_tip);
    String str = this.flI.getString(q.j.facebook_auth_unbinding);
    FacebookAuthUI.a(this.flI, ProgressDialog.show(this.flI, paramDialogInterface, str, true));
    FacebookAuthUI.d(this.flI).setOnCancelListener(FacebookAuthUI.c(this.flI));
    paramDialogInterface = new y(y.fgr);
    g.Dk().a(paramDialogInterface, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookAuthUI.5
 * JD-Core Version:    0.7.0.1
 */