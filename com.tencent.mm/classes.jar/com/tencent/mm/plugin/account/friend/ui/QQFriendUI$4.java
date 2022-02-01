package com.tencent.mm.plugin.account.friend.ui;

import android.content.Intent;
import android.database.Cursor;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.ra;
import com.tencent.mm.f.a.ra.b;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.account.friend.a.j;
import com.tencent.mm.plugin.account.friend.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;

final class QQFriendUI$4
  implements AdapterView.OnItemClickListener
{
  QQFriendUI$4(QQFriendUI paramQQFriendUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(131277);
    Object localObject1 = new b();
    ((b)localObject1).bn(paramAdapterView);
    ((b)localObject1).bn(paramView);
    ((b)localObject1).sg(paramInt);
    ((b)localObject1).Fs(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/friend/ui/QQFriendUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject1).aFi());
    if (paramInt < QQFriendUI.c(this.mYS).getHeaderViewsCount())
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/QQFriendUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(131277);
      return;
    }
    paramInt -= QQFriendUI.c(this.mYS).getHeaderViewsCount();
    Log.i("MicroMsg.QQFriendUI", "realpostion is:%d headerViewscount:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(QQFriendUI.c(this.mYS).getHeaderViewsCount()) });
    paramView = (com.tencent.mm.plugin.account.friend.a.as)QQFriendUI.d(this.mYS).getItem(paramInt);
    if (this.mYS.getIntent().getBooleanExtra("qqgroup_sendmessage", false))
    {
      paramAdapterView = new ra();
      paramAdapterView.fPR.opType = 0;
      paramAdapterView.fPR.fPT = (paramView.mXm + "@qqim");
      paramAdapterView.fPR.fPU = paramView.getDisplayName();
      EventCenter.instance.publish(paramAdapterView);
      if (paramAdapterView.fPS.fyl)
      {
        paramAdapterView = new Intent();
        paramAdapterView.putExtra("Chat_User", paramView.mXm + "@qqim");
        paramAdapterView.putExtra("key_need_send_video", false);
        com.tencent.mm.plugin.account.sdk.a.mIG.d(paramAdapterView, this.mYS);
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/QQFriendUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(131277);
      return;
      if ((paramView.mXn == 1) || (paramView.mXn == 2))
      {
        paramAdapterView = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramView.getUsername());
        if ((paramAdapterView != null) && (paramAdapterView.hxX())) {
          com.tencent.mm.plugin.report.service.h.IzE.kvStat(10298, paramView.getUsername() + ",12");
        }
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("Contact_User", paramView.getUsername());
        ((Intent)localObject1).putExtra("Contact_Nick", paramView.getNickname());
        ((Intent)localObject1).putExtra("Contact_Uin", paramView.mXm);
        ((Intent)localObject1).putExtra("Contact_QQNick", paramView.getDisplayName());
        ((Intent)localObject1).putExtra("Contact_Scene", 12);
        ((Intent)localObject1).putExtra("Contact_RemarkName", paramView.byI());
        paramAdapterView = (k)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getFrdExtStg();
        Object localObject2 = paramView.getUsername();
        localObject2 = "select friend_ext.username,friend_ext.sex,friend_ext.personalcard,friend_ext.province,friend_ext.city,friend_ext.signature from friend_ext   where friend_ext.username = \"" + Util.escapeSqlValue(String.valueOf(localObject2)) + "\"";
        localObject2 = paramAdapterView.lvy.rawQuery((String)localObject2, null, 2);
        if (localObject2 == null) {
          paramAdapterView = null;
        }
        for (;;)
        {
          if (paramAdapterView != null) {
            ((Intent)localObject1).putExtra("Contact_Sex", paramAdapterView.sex);
          }
          ((Intent)localObject1).putExtra("Contact_ShowUserName", false);
          if (!Util.isNullOrNil(paramView.getUsername())) {
            break;
          }
          Log.e("MicroMsg.QQFriendUI", "username is null. can't start contact ui. friend is:%s", new Object[] { paramView.toString() });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/QQFriendUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(131277);
          return;
          paramAdapterView = null;
          if (((Cursor)localObject2).moveToFirst())
          {
            paramAdapterView = new j();
            paramAdapterView.username = ((Cursor)localObject2).getString(0);
            paramAdapterView.sex = ((Cursor)localObject2).getInt(1);
            paramAdapterView.hDk = ((Cursor)localObject2).getInt(2);
            paramAdapterView.province = ((Cursor)localObject2).getString(3);
            paramAdapterView.city = ((Cursor)localObject2).getString(4);
            paramAdapterView.signature = ((Cursor)localObject2).getString(5);
          }
          ((Cursor)localObject2).close();
        }
        com.tencent.mm.plugin.account.sdk.a.mIG.c((Intent)localObject1, this.mYS);
      }
      else if (paramView.mXn == 0)
      {
        paramAdapterView = new Intent(this.mYS, InviteFriendUI.class);
        paramAdapterView.putExtra("friend_type", 0);
        paramAdapterView.putExtra("friend_user_name", paramView.getUsername());
        paramAdapterView.putExtra("friend_num", paramView.mXm);
        paramAdapterView.putExtra("friend_nick", paramView.getDisplayName());
        paramAdapterView.putExtra("friend_weixin_nick", paramView.getNickname());
        paramAdapterView.putExtra("friend_scene", 12);
        paramView = this.mYS;
        paramAdapterView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAdapterView);
        com.tencent.mm.hellhoundlib.a.a.b(paramView, paramAdapterView.aFh(), "com/tencent/mm/plugin/account/friend/ui/QQFriendUI$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramView.startActivity((Intent)paramAdapterView.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/account/friend/ui/QQFriendUI$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.QQFriendUI.4
 * JD-Core Version:    0.7.0.1
 */