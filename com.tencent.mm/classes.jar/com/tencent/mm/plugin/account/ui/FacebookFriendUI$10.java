package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ab;
import com.tencent.mm.sdk.platformtools.ap;

final class FacebookFriendUI$10
  implements DialogInterface.OnCancelListener
{
  FacebookFriendUI$10(FacebookFriendUI paramFacebookFriendUI, ap paramap, ab paramab) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(124817);
    this.gDj.stopTimer();
    g.Rc().a(this.gDi);
    AppMethodBeat.o(124817);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookFriendUI.10
 * JD-Core Version:    0.7.0.1
 */