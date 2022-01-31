package com.tencent.mm.plugin.account.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.g.a.c;

final class InviteFacebookFriendsUI$10
  implements MenuItem.OnMenuItemClickListener
{
  InviteFacebookFriendsUI$10(InviteFacebookFriendsUI paramInviteFacebookFriendsUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(124887);
    c localc = new c(this.gDx.getString(2131306163));
    Bundle localBundle = new Bundle();
    localBundle.putString("message", this.gDx.getString(2131299633));
    long[] arrayOfLong = InviteFacebookFriendsUI.a(this.gDx).arp();
    paramMenuItem = Long.toString(arrayOfLong[0]);
    int i = 1;
    while (i < arrayOfLong.length)
    {
      paramMenuItem = paramMenuItem + ",";
      paramMenuItem = paramMenuItem + Long.toString(arrayOfLong[i]);
      i += 1;
    }
    localBundle.putString("to", paramMenuItem);
    localc.a(this.gDx, "apprequests", localBundle, new InviteFacebookFriendsUI.10.1(this, arrayOfLong));
    AppMethodBeat.o(124887);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI.10
 * JD-Core Version:    0.7.0.1
 */