package com.tencent.mm.plugin.account.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ad;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.storage.aj;

final class InviteFacebookFriendsUI$6
  implements aw.a
{
  InviteFacebookFriendsUI$6(InviteFacebookFriendsUI paramInviteFacebookFriendsUI, ad paramad) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(128027);
    g.ajR().ajA().set(65829, Integer.valueOf(1));
    g.ajj().a(this.jmK, 0);
    AppMethodBeat.o(128027);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI.6
 * JD-Core Version:    0.7.0.1
 */