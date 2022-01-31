package com.tencent.mm.plugin.account.friend.ui;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.account.friend.a.f;
import com.tencent.mm.plugin.account.friend.a.h;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

final class RecommendFriendUI$2
  implements MenuItem.OnMenuItemClickListener
{
  RecommendFriendUI$2(RecommendFriendUI paramRecommendFriendUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    int i = RecommendFriendUI.b(this.fiz).Xq().length;
    h.a(this.fiz.mController.uMN, this.fiz.mController.uMN.getResources().getQuantityString(a.f.inviteqqfriends_invite_tips, i, new Object[] { Integer.valueOf(i) }), this.fiz.getString(a.h.app_tip), new RecommendFriendUI.2.1(this), new RecommendFriendUI.2.2(this));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.RecommendFriendUI.2
 * JD-Core Version:    0.7.0.1
 */