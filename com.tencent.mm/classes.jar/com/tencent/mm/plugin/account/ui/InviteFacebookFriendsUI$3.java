package com.tencent.mm.plugin.account.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.ui.p.a;

final class InviteFacebookFriendsUI$3
  implements p.a
{
  InviteFacebookFriendsUI$3(InviteFacebookFriendsUI paramInviteFacebookFriendsUI, TextView paramTextView) {}
  
  public final void apT()
  {
    AppMethodBeat.i(124873);
    if (r.ZP())
    {
      if (InviteFacebookFriendsUI.a(this.gDx).getCount() == 0)
      {
        this.gDh.setVisibility(0);
        AppMethodBeat.o(124873);
        return;
      }
      this.gDh.setVisibility(8);
    }
    AppMethodBeat.o(124873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI.3
 * JD-Core Version:    0.7.0.1
 */