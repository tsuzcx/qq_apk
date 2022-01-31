package com.tencent.mm.plugin.account.friend.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.i;

final class FindMContactInviteUI$7
  implements View.OnClickListener
{
  FindMContactInviteUI$7(FindMContactInviteUI paramFindMContactInviteUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(108544);
    paramView = new StringBuilder();
    g.RJ();
    paramView = paramView.append(com.tencent.mm.kernel.a.QX()).append(",").append(this.gzf.getClass().getName()).append(",R300_400_AddAllButton,");
    g.RJ();
    com.tencent.mm.plugin.b.a.xE(com.tencent.mm.kernel.a.mx("R300_300_AddAllButton") + ",3");
    if (FindMContactInviteUI.d(this.gzf) == 2)
    {
      FindMContactInviteUI.b(this.gzf).dw(true);
      FindMContactInviteUI.b(this.gzf).notifyDataSetChanged();
      FindMContactInviteUI.e(this.gzf).setVisibility(8);
      if (FindMContactInviteUI.f(this.gzf) != null)
      {
        FindMContactInviteUI.f(this.gzf).setVisibility(0);
        AppMethodBeat.o(108544);
      }
    }
    else
    {
      if (FindMContactInviteUI.d(this.gzf) == 1)
      {
        FindMContactInviteUI.b(this.gzf).dw(true);
        FindMContactInviteUI.b(this.gzf).notifyDataSetChanged();
        FindMContactInviteUI.h(this.gzf);
        AppMethodBeat.o(108544);
        return;
      }
      FindMContactInviteUI.b(this.gzf).dw(true);
      FindMContactInviteUI.b(this.gzf).notifyDataSetChanged();
      FindMContactInviteUI.e(this.gzf).setVisibility(8);
      if (FindMContactInviteUI.f(this.gzf) != null) {
        FindMContactInviteUI.f(this.gzf).setVisibility(0);
      }
    }
    AppMethodBeat.o(108544);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI.7
 * JD-Core Version:    0.7.0.1
 */