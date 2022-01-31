package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.plugin.account.friend.a.a;
import com.tencent.mm.plugin.account.friend.ui.InviteFriendUI;

final class MobileFriendUI$14
  implements AdapterView.OnItemClickListener
{
  MobileFriendUI$14(MobileFriendUI paramMobileFriendUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < MobileFriendUI.f(this.fes).getHeaderViewsCount()) {}
    do
    {
      return;
      int i = MobileFriendUI.f(this.fes).getHeaderViewsCount();
      paramAdapterView = (a)MobileFriendUI.d(this.fes).getItem(paramInt - i);
      if ((paramAdapterView.status == 1) || (paramAdapterView.status == 2)) {
        this.fes.b(paramAdapterView);
      }
    } while (paramAdapterView.status != 0);
    paramView = new Intent(this.fes, InviteFriendUI.class);
    paramView.putExtra("friend_type", 1);
    paramView.putExtra("friend_user_name", paramAdapterView.getUsername());
    paramView.putExtra("friend_num", paramAdapterView.WD());
    paramView.putExtra("friend_nick", paramAdapterView.Wx());
    paramView.putExtra("friend_weixin_nick", paramAdapterView.WA());
    paramView.putExtra("friend_scene", 13);
    this.fes.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.MobileFriendUI.14
 * JD-Core Version:    0.7.0.1
 */