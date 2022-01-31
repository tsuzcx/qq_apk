package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.account.friend.a.g;
import com.tencent.mm.pluginsdk.n;

final class FacebookFriendUI$7
  implements AdapterView.OnItemClickListener
{
  FacebookFriendUI$7(FacebookFriendUI paramFacebookFriendUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(124813);
    paramAdapterView = (g)FacebookFriendUI.b(this.gDg).getItem(paramInt - FacebookFriendUI.e(this.gDg).getHeaderViewsCount());
    if ((paramAdapterView.status == 100) || (paramAdapterView.status == 101))
    {
      paramView = new Intent();
      paramView.putExtra("Contact_User", paramAdapterView.getUsername());
      paramView.putExtra("Contact_Nick", paramAdapterView.aqc());
      paramView.putExtra("Contact_KFacebookId", paramAdapterView.dqE);
      paramView.putExtra("Contact_KFacebookName", paramAdapterView.aqk());
      paramView.putExtra("Contact_Scene", 31);
      a.gmO.c(paramView, this.gDg);
    }
    if (paramAdapterView.status == 102)
    {
      AppMethodBeat.o(124813);
      return;
    }
    AppMethodBeat.o(124813);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookFriendUI.7
 * JD-Core Version:    0.7.0.1
 */