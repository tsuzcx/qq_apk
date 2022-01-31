package com.tencent.mm.plugin.account.friend.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.friend.a.i;

final class FindMContactInviteUI$8
  implements View.OnClickListener
{
  FindMContactInviteUI$8(FindMContactInviteUI paramFindMContactInviteUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(108545);
    FindMContactInviteUI.e(this.gzf).setVisibility(0);
    FindMContactInviteUI.f(this.gzf).setVisibility(8);
    FindMContactInviteUI.b(this.gzf).dw(false);
    FindMContactInviteUI.b(this.gzf).notifyDataSetChanged();
    AppMethodBeat.o(108545);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI.8
 * JD-Core Version:    0.7.0.1
 */