package com.tencent.mm.plugin.account.ui;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.f.a.b;
import com.tencent.mm.ui.f.a.c.a;
import com.tencent.mm.ui.f.a.d;
import com.tencent.mm.ui.s;

final class ShowNonWeixinFriendUI$2$1
  implements c.a
{
  ShowNonWeixinFriendUI$2$1(ShowNonWeixinFriendUI.2 param2) {}
  
  public final void a(b paramb)
  {
    y.e("MicroMsg.ShowNonWeixinFriendUI", "fbinvite error");
  }
  
  public final void a(d paramd)
  {
    y.e("MicroMsg.ShowNonWeixinFriendUI", "fbinvite error");
  }
  
  public final void l(Bundle paramBundle)
  {
    y.i("MicroMsg.ShowNonWeixinFriendUI", "fbinvite oncomplete");
    h.a(this.fsP.fsO.mController.uMN, q.j.facebook_inviteqqfriends_invite_success, q.j.app_tip, new ShowNonWeixinFriendUI.2.1.1(this));
  }
  
  public final void onCancel()
  {
    y.e("MicroMsg.ShowNonWeixinFriendUI", "fbinvite cancle");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.ShowNonWeixinFriendUI.2.1
 * JD-Core Version:    0.7.0.1
 */