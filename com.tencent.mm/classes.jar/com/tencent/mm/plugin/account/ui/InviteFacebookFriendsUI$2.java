package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class InviteFacebookFriendsUI$2
  implements DialogInterface.OnClickListener
{
  InviteFacebookFriendsUI$2(InviteFacebookFriendsUI paramInviteFacebookFriendsUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.fmd.mController.uMN, FacebookAuthUI.class);
    paramDialogInterface.putExtra("is_force_unbind", true);
    this.fmd.mController.uMN.startActivity(paramDialogInterface);
    this.fmd.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI.2
 * JD-Core Version:    0.7.0.1
 */