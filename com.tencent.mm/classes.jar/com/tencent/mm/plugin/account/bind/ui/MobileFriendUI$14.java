package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.friend.a.a;
import com.tencent.mm.plugin.account.friend.ui.InviteFriendUI;

final class MobileFriendUI$14
  implements AdapterView.OnItemClickListener
{
  MobileFriendUI$14(MobileFriendUI paramMobileFriendUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(13732);
    if (paramInt < MobileFriendUI.f(this.gwb).getHeaderViewsCount())
    {
      AppMethodBeat.o(13732);
      return;
    }
    int i = MobileFriendUI.f(this.gwb).getHeaderViewsCount();
    paramAdapterView = (a)MobileFriendUI.d(this.gwb).getItem(paramInt - i);
    if ((paramAdapterView.status == 1) || (paramAdapterView.status == 2)) {
      this.gwb.b(paramAdapterView);
    }
    if (paramAdapterView.status == 0)
    {
      paramView = new Intent(this.gwb, InviteFriendUI.class);
      paramView.putExtra("friend_type", 1);
      paramView.putExtra("friend_user_name", paramAdapterView.getUsername());
      paramView.putExtra("friend_num", paramAdapterView.aqf());
      paramView.putExtra("friend_nick", paramAdapterView.apZ());
      paramView.putExtra("friend_weixin_nick", paramAdapterView.aqc());
      paramView.putExtra("friend_scene", 13);
      this.gwb.startActivity(paramView);
    }
    AppMethodBeat.o(13732);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.MobileFriendUI.14
 * JD-Core Version:    0.7.0.1
 */