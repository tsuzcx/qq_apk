package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

final class InviteFacebookFriendsUI$4
  implements AdapterView.OnItemClickListener
{
  InviteFacebookFriendsUI$4(InviteFacebookFriendsUI paramInviteFacebookFriendsUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(124874);
    if (InviteFacebookFriendsUI.a(this.gDx).arp().length >= 50)
    {
      h.h(this.gDx, 2131299636, 2131297087);
      AppMethodBeat.o(124874);
      return;
    }
    InviteFacebookFriendsUI.a(this.gDx).mW(paramInt - InviteFacebookFriendsUI.b(this.gDx).getHeaderViewsCount());
    if (InviteFacebookFriendsUI.a(this.gDx).arp().length > 0)
    {
      this.gDx.showOptionMenu(true);
      AppMethodBeat.o(124874);
      return;
    }
    this.gDx.showOptionMenu(false);
    AppMethodBeat.o(124874);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI.4
 * JD-Core Version:    0.7.0.1
 */