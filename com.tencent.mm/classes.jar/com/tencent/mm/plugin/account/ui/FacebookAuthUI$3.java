package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;

final class FacebookAuthUI$3
  implements DialogInterface.OnCancelListener
{
  FacebookAuthUI$3(FacebookAuthUI paramFacebookAuthUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if (FacebookAuthUI.a(this.flI) != null) {
      g.Dk().c(FacebookAuthUI.a(this.flI));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookAuthUI.3
 * JD-Core Version:    0.7.0.1
 */