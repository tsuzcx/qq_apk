package com.tencent.mm.plugin.account.ui;

import android.os.Bundle;
import com.tencent.mm.ay.g.a;
import com.tencent.mm.plugin.account.friend.a.p;
import com.tencent.mm.plugin.account.friend.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.f.a.c.a;
import com.tencent.mm.ui.f.a.d;
import java.util.ArrayList;
import java.util.List;

final class InviteFacebookFriendsUI$10$1
  implements c.a
{
  InviteFacebookFriendsUI$10$1(InviteFacebookFriendsUI.10 param10, long[] paramArrayOfLong) {}
  
  public final void a(com.tencent.mm.ui.f.a.b paramb)
  {
    y.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite error");
  }
  
  public final void a(d paramd)
  {
    y.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite error");
  }
  
  public final void l(Bundle paramBundle)
  {
    y.i("MicroMsg.InviteFacebookFriendsUI", "fbinvite oncomplete");
    paramBundle = new ArrayList();
    paramBundle.add(new g.a(33, Integer.toString(this.fme.length)));
    ((j)com.tencent.mm.kernel.g.r(j.class)).Fv().b(new com.tencent.mm.ay.g(paramBundle));
    paramBundle = this.fme;
    int j = paramBundle.length;
    int i = 0;
    while (i < j)
    {
      long l = paramBundle[i];
      p localp = new p();
      localp.username = Long.toString(l);
      localp.ffY = 5;
      localp.efI = ((int)bk.UX());
      com.tencent.mm.plugin.account.b.getInviteFriendOpenStg().a(localp);
      i += 1;
    }
    com.tencent.mm.ui.base.h.a(this.fmf.fmd, q.j.facebook_invitefriends_tips_invitemore, q.j.app_tip, q.j.app_yes, q.j.app_no, new InviteFacebookFriendsUI.10.1.1(this), new InviteFacebookFriendsUI.10.1.2(this));
  }
  
  public final void onCancel()
  {
    y.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite cancle");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI.10.1
 * JD-Core Version:    0.7.0.1
 */