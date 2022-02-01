package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ad;
import com.tencent.mm.sdk.platformtools.av;

final class FacebookFriendUI$10
  implements DialogInterface.OnCancelListener
{
  FacebookFriendUI$10(FacebookFriendUI paramFacebookFriendUI, av paramav, ad paramad) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(127968);
    this.jjS.stopTimer();
    g.aiU().a(this.jjR);
    AppMethodBeat.o(127968);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookFriendUI.10
 * JD-Core Version:    0.7.0.1
 */