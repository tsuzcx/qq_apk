package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ad;
import com.tencent.mm.sdk.platformtools.MTimerHandler;

final class InviteFacebookFriendsUI$7
  implements DialogInterface.OnCancelListener
{
  InviteFacebookFriendsUI$7(InviteFacebookFriendsUI paramInviteFacebookFriendsUI, MTimerHandler paramMTimerHandler, ad paramad) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(128028);
    this.kkU.stopTimer();
    g.azz().a(this.kkT);
    AppMethodBeat.o(128028);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI.7
 * JD-Core Version:    0.7.0.1
 */