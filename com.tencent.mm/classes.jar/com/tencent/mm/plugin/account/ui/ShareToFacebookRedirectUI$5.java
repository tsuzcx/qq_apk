package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class ShareToFacebookRedirectUI$5
  implements DialogInterface.OnClickListener
{
  ShareToFacebookRedirectUI$5(ShareToFacebookRedirectUI paramShareToFacebookRedirectUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.fsJ.mController.uMN, FacebookAuthUI.class);
    paramDialogInterface.putExtra("is_force_unbind", true);
    this.fsJ.mController.uMN.startActivityForResult(paramDialogInterface, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.ShareToFacebookRedirectUI.5
 * JD-Core Version:    0.7.0.1
 */