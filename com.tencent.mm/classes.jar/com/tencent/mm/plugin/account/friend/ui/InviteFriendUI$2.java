package com.tencent.mm.plugin.account.friend.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.h.a.mj;
import com.tencent.mm.h.a.mj.b;
import com.tencent.mm.pluginsdk.m;

final class InviteFriendUI$2
  implements View.OnClickListener
{
  InviteFriendUI$2(InviteFriendUI paramInviteFriendUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new mj();
    paramView.bVE.opType = 0;
    paramView.bVE.bVG = (InviteFriendUI.b(this.fhT) + "@qqim");
    paramView.bVE.bVH = InviteFriendUI.f(this.fhT);
    com.tencent.mm.sdk.b.a.udP.m(paramView);
    if (paramView.bVF.bIe) {
      com.tencent.mm.plugin.account.a.a.eUR.e(new Intent().putExtra("Chat_User", InviteFriendUI.b(this.fhT) + "@qqim"), this.fhT);
    }
    this.fhT.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.InviteFriendUI.2
 * JD-Core Version:    0.7.0.1
 */