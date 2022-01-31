package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.ui.base.h;

final class InviteFacebookFriendsUI$4
  implements AdapterView.OnItemClickListener
{
  InviteFacebookFriendsUI$4(InviteFacebookFriendsUI paramInviteFacebookFriendsUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (InviteFacebookFriendsUI.a(this.fmd).XH().length >= 50)
    {
      h.h(this.fmd, q.j.facebook_invitefriends_tips_max, q.j.app_tip);
      return;
    }
    InviteFacebookFriendsUI.a(this.fmd).kb(paramInt - InviteFacebookFriendsUI.b(this.fmd).getHeaderViewsCount());
    if (InviteFacebookFriendsUI.a(this.fmd).XH().length > 0)
    {
      this.fmd.showOptionMenu(true);
      return;
    }
    this.fmd.showOptionMenu(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI.4
 * JD-Core Version:    0.7.0.1
 */