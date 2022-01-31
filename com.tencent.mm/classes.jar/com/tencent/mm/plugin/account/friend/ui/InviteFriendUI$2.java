package com.tencent.mm.plugin.account.friend.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ne;
import com.tencent.mm.g.a.ne.b;
import com.tencent.mm.pluginsdk.n;

final class InviteFriendUI$2
  implements View.OnClickListener
{
  InviteFriendUI$2(InviteFriendUI paramInviteFriendUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(108578);
    paramView = new ne();
    paramView.cDp.opType = 0;
    paramView.cDp.cDr = (InviteFriendUI.b(this.gzA) + "@qqim");
    paramView.cDp.cDs = InviteFriendUI.f(this.gzA);
    com.tencent.mm.sdk.b.a.ymk.l(paramView);
    if (paramView.cDq.cpz) {
      com.tencent.mm.plugin.account.a.a.gmO.d(new Intent().putExtra("Chat_User", InviteFriendUI.b(this.gzA) + "@qqim"), this.gzA);
    }
    this.gzA.finish();
    AppMethodBeat.o(108578);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.InviteFriendUI.2
 * JD-Core Version:    0.7.0.1
 */