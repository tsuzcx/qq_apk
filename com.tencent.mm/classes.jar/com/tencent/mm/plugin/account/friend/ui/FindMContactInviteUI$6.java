package com.tencent.mm.plugin.account.friend.ui;

import android.content.res.Resources;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.plugin.account.friend.a.f;
import com.tencent.mm.plugin.account.friend.a.h;
import com.tencent.mm.plugin.account.friend.a.i;
import com.tencent.mm.plugin.account.friend.a.i.a;

final class FindMContactInviteUI$6
  implements i.a
{
  FindMContactInviteUI$6(FindMContactInviteUI paramFindMContactInviteUI) {}
  
  public final void notifyDataSetChanged()
  {
    if ((FindMContactInviteUI.d(this.fhx) != 2) && (FindMContactInviteUI.d(this.fhx) == 1))
    {
      FindMContactInviteUI.e(this.fhx).setText(this.fhx.getString(a.h.find_mcontact_invite_all_continue));
      if (!FindMContactInviteUI.b(this.fhx).WK()) {
        break label233;
      }
      if ((FindMContactInviteUI.d(this.fhx) != 1) && (FindMContactInviteUI.e(this.fhx).getVisibility() == 0) && (FindMContactInviteUI.f(this.fhx) != null))
      {
        FindMContactInviteUI.e(this.fhx).setVisibility(8);
        FindMContactInviteUI.f(this.fhx).setVisibility(0);
      }
    }
    for (;;)
    {
      if ((FindMContactInviteUI.b(this.fhx).getSelectCount() <= 0) || (FindMContactInviteUI.d(this.fhx) == 1)) {
        break label295;
      }
      FindMContactInviteUI.g(this.fhx).setText(this.fhx.getResources().getQuantityString(a.f.find_mcontact_already_invite_count, FindMContactInviteUI.b(this.fhx).getSelectCount(), new Object[] { Integer.valueOf(FindMContactInviteUI.b(this.fhx).getSelectCount()) }));
      return;
      FindMContactInviteUI.e(this.fhx).setText(this.fhx.getString(a.h.find_mcontact_invite_all, new Object[] { Integer.valueOf(FindMContactInviteUI.b(this.fhx).getCount()) }));
      break;
      label233:
      if ((FindMContactInviteUI.d(this.fhx) != 1) && (FindMContactInviteUI.e(this.fhx).getVisibility() == 8) && (FindMContactInviteUI.f(this.fhx) != null))
      {
        FindMContactInviteUI.e(this.fhx).setVisibility(0);
        FindMContactInviteUI.f(this.fhx).setVisibility(8);
      }
    }
    label295:
    FindMContactInviteUI.g(this.fhx).setText(this.fhx.getResources().getQuantityString(a.f.find_mcontact_invite_friend_cnt, FindMContactInviteUI.b(this.fhx).getCount(), new Object[] { Integer.valueOf(FindMContactInviteUI.b(this.fhx).getCount()) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI.6
 * JD-Core Version:    0.7.0.1
 */