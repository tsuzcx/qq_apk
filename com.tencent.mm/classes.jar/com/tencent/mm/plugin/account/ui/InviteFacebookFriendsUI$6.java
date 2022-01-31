package com.tencent.mm.plugin.account.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ab;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.storage.z;

final class InviteFacebookFriendsUI$6
  implements ap.a
{
  InviteFacebookFriendsUI$6(InviteFacebookFriendsUI paramInviteFacebookFriendsUI, ab paramab) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(124877);
    g.RL().Ru().set(65829, Integer.valueOf(1));
    g.Rc().a(this.gDi, 0);
    AppMethodBeat.o(124877);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI.6
 * JD-Core Version:    0.7.0.1
 */