package com.tencent.mm.plugin.account.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ad;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.storage.ao;

final class FacebookFriendUI$9
  implements MTimerHandler.CallBack
{
  FacebookFriendUI$9(FacebookFriendUI paramFacebookFriendUI, ad paramad) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(127967);
    g.aAh().azQ().set(65829, Integer.valueOf(1));
    g.azz().a(this.kkT, 0);
    AppMethodBeat.o(127967);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookFriendUI.9
 * JD-Core Version:    0.7.0.1
 */