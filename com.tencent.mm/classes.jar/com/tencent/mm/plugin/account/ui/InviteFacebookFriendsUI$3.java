package com.tencent.mm.plugin.account.ui;

import android.widget.TextView;
import com.tencent.mm.model.q;
import com.tencent.mm.ui.r.a;

final class InviteFacebookFriendsUI$3
  implements r.a
{
  InviteFacebookFriendsUI$3(InviteFacebookFriendsUI paramInviteFacebookFriendsUI, TextView paramTextView) {}
  
  public final void Wp()
  {
    if (q.GL())
    {
      if (InviteFacebookFriendsUI.a(this.fmd).getCount() == 0) {
        this.flP.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.flP.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI.3
 * JD-Core Version:    0.7.0.1
 */