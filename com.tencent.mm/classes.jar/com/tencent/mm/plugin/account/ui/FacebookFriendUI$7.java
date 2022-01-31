package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.account.friend.a.g;
import com.tencent.mm.pluginsdk.m;

final class FacebookFriendUI$7
  implements AdapterView.OnItemClickListener
{
  FacebookFriendUI$7(FacebookFriendUI paramFacebookFriendUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (g)FacebookFriendUI.b(this.flO).getItem(paramInt - FacebookFriendUI.e(this.flO).getHeaderViewsCount());
    if ((paramAdapterView.status == 100) || (paramAdapterView.status == 101))
    {
      paramView = new Intent();
      paramView.putExtra("Contact_User", paramAdapterView.getUsername());
      paramView.putExtra("Contact_Nick", paramAdapterView.WA());
      paramView.putExtra("Contact_KFacebookId", paramAdapterView.cCs);
      paramView.putExtra("Contact_KFacebookName", paramAdapterView.WI());
      paramView.putExtra("Contact_Scene", 31);
      a.eUR.d(paramView, this.flO);
    }
    if (paramAdapterView.status == 102) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookFriendUI.7
 * JD-Core Version:    0.7.0.1
 */