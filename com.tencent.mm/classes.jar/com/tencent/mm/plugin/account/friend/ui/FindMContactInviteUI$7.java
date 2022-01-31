package com.tencent.mm.plugin.account.friend.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.i;

final class FindMContactInviteUI$7
  implements View.OnClickListener
{
  FindMContactInviteUI$7(FindMContactInviteUI paramFindMContactInviteUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new StringBuilder();
    g.DN();
    paramView = paramView.append(com.tencent.mm.kernel.a.Df()).append(",").append(this.fhx.getClass().getName()).append(",R300_400_AddAllButton,");
    g.DN();
    com.tencent.mm.plugin.b.a.qk(com.tencent.mm.kernel.a.gd("R300_300_AddAllButton") + ",3");
    if (FindMContactInviteUI.d(this.fhx) == 2)
    {
      FindMContactInviteUI.b(this.fhx).cu(true);
      FindMContactInviteUI.b(this.fhx).notifyDataSetChanged();
      FindMContactInviteUI.e(this.fhx).setVisibility(8);
      if (FindMContactInviteUI.f(this.fhx) != null) {
        FindMContactInviteUI.f(this.fhx).setVisibility(0);
      }
    }
    do
    {
      return;
      if (FindMContactInviteUI.d(this.fhx) == 1)
      {
        FindMContactInviteUI.b(this.fhx).cu(true);
        FindMContactInviteUI.b(this.fhx).notifyDataSetChanged();
        FindMContactInviteUI.h(this.fhx);
        return;
      }
      FindMContactInviteUI.b(this.fhx).cu(true);
      FindMContactInviteUI.b(this.fhx).notifyDataSetChanged();
      FindMContactInviteUI.e(this.fhx).setVisibility(8);
    } while (FindMContactInviteUI.f(this.fhx) == null);
    FindMContactInviteUI.f(this.fhx).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI.7
 * JD-Core Version:    0.7.0.1
 */