package com.tencent.mm.plugin.account.friend.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.ra;
import com.tencent.mm.f.a.ra.b;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.event.EventCenter;

final class InviteFriendUI$2
  implements View.OnClickListener
{
  InviteFriendUI$2(InviteFriendUI paramInviteFriendUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(131239);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/friend/ui/InviteFriendUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    paramView = new ra();
    paramView.fPR.opType = 0;
    paramView.fPR.fPT = (InviteFriendUI.b(this.mYt) + "@qqim");
    paramView.fPR.fPU = InviteFriendUI.f(this.mYt);
    EventCenter.instance.publish(paramView);
    if (paramView.fPS.fyl) {
      com.tencent.mm.plugin.account.sdk.a.mIG.d(new Intent().putExtra("Chat_User", InviteFriendUI.b(this.mYt) + "@qqim"), this.mYt);
    }
    this.mYt.finish();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/InviteFriendUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(131239);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.InviteFriendUI.2
 * JD-Core Version:    0.7.0.1
 */