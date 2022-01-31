package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;

final class FacebookLoginUI$5
  implements DialogInterface.OnCancelListener
{
  FacebookLoginUI$5(FacebookLoginUI paramFacebookLoginUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if (FacebookLoginUI.b(this.flX) != null) {
      g.Dk().c(FacebookLoginUI.b(this.flX));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookLoginUI.5
 * JD-Core Version:    0.7.0.1
 */