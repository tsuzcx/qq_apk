package com.tencent.mm.plugin.account.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ad;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.storage.aj;

final class FacebookFriendUI$9
  implements aw.a
{
  FacebookFriendUI$9(FacebookFriendUI paramFacebookFriendUI, ad paramad) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(127967);
    g.ajR().ajA().set(65829, Integer.valueOf(1));
    g.ajj().a(this.jmK, 0);
    AppMethodBeat.o(127967);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookFriendUI.9
 * JD-Core Version:    0.7.0.1
 */