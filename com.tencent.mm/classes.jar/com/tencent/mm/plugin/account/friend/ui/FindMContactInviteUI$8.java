package com.tencent.mm.plugin.account.friend.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.plugin.account.friend.a.i;

final class FindMContactInviteUI$8
  implements View.OnClickListener
{
  FindMContactInviteUI$8(FindMContactInviteUI paramFindMContactInviteUI) {}
  
  public final void onClick(View paramView)
  {
    FindMContactInviteUI.e(this.fhx).setVisibility(0);
    FindMContactInviteUI.f(this.fhx).setVisibility(8);
    FindMContactInviteUI.b(this.fhx).cu(false);
    FindMContactInviteUI.b(this.fhx).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI.8
 * JD-Core Version:    0.7.0.1
 */