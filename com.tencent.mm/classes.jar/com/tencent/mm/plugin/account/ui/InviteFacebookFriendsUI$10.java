package com.tencent.mm.plugin.account.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.f.a.c;

final class InviteFacebookFriendsUI$10
  implements MenuItem.OnMenuItemClickListener
{
  InviteFacebookFriendsUI$10(InviteFacebookFriendsUI paramInviteFacebookFriendsUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    c localc = new c("290293790992170");
    Bundle localBundle = new Bundle();
    localBundle.putString("message", this.fmd.getString(q.j.facebook_invite_message));
    long[] arrayOfLong = InviteFacebookFriendsUI.a(this.fmd).XH();
    paramMenuItem = Long.toString(arrayOfLong[0]);
    int i = 1;
    while (i < arrayOfLong.length)
    {
      paramMenuItem = paramMenuItem + ",";
      paramMenuItem = paramMenuItem + Long.toString(arrayOfLong[i]);
      i += 1;
    }
    localBundle.putString("to", paramMenuItem);
    localc.a(this.fmd, "apprequests", localBundle, new InviteFacebookFriendsUI.10.1(this, arrayOfLong));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI.10
 * JD-Core Version:    0.7.0.1
 */