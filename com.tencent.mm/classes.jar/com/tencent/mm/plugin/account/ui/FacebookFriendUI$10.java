package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ab;
import com.tencent.mm.sdk.platformtools.am;

final class FacebookFriendUI$10
  implements DialogInterface.OnCancelListener
{
  FacebookFriendUI$10(FacebookFriendUI paramFacebookFriendUI, am paramam, ab paramab) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    this.flR.stopTimer();
    g.Dk().c(this.flQ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookFriendUI.10
 * JD-Core Version:    0.7.0.1
 */