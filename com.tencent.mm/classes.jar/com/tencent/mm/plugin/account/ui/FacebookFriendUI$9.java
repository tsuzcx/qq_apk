package com.tencent.mm.plugin.account.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ab;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.storage.z;

final class FacebookFriendUI$9
  implements ap.a
{
  FacebookFriendUI$9(FacebookFriendUI paramFacebookFriendUI, ab paramab) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(124816);
    g.RL().Ru().set(65829, Integer.valueOf(1));
    g.Rc().a(this.gDi, 0);
    AppMethodBeat.o(124816);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookFriendUI.9
 * JD-Core Version:    0.7.0.1
 */