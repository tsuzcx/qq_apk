package com.tencent.mm.plugin.account.friend.ui;

import android.content.res.Resources;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.friend.a.i;
import com.tencent.mm.plugin.account.friend.a.i.a;

final class FindMContactInviteUI$6
  implements i.a
{
  FindMContactInviteUI$6(FindMContactInviteUI paramFindMContactInviteUI) {}
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(108543);
    if ((FindMContactInviteUI.d(this.gzf) != 2) && (FindMContactInviteUI.d(this.gzf) == 1))
    {
      FindMContactInviteUI.e(this.gzf).setText(this.gzf.getString(2131299933));
      if (!FindMContactInviteUI.b(this.gzf).aqm()) {
        break label240;
      }
      if ((FindMContactInviteUI.d(this.gzf) != 1) && (FindMContactInviteUI.e(this.gzf).getVisibility() == 0) && (FindMContactInviteUI.f(this.gzf) != null))
      {
        FindMContactInviteUI.e(this.gzf).setVisibility(8);
        FindMContactInviteUI.f(this.gzf).setVisibility(0);
      }
    }
    for (;;)
    {
      if ((FindMContactInviteUI.b(this.gzf).getSelectCount() <= 0) || (FindMContactInviteUI.d(this.gzf) == 1)) {
        break label302;
      }
      FindMContactInviteUI.g(this.gzf).setText(this.gzf.getResources().getQuantityString(2131361798, FindMContactInviteUI.b(this.gzf).getSelectCount(), new Object[] { Integer.valueOf(FindMContactInviteUI.b(this.gzf).getSelectCount()) }));
      AppMethodBeat.o(108543);
      return;
      FindMContactInviteUI.e(this.gzf).setText(this.gzf.getString(2131299932, new Object[] { Integer.valueOf(FindMContactInviteUI.b(this.gzf).getCount()) }));
      break;
      label240:
      if ((FindMContactInviteUI.d(this.gzf) != 1) && (FindMContactInviteUI.e(this.gzf).getVisibility() == 8) && (FindMContactInviteUI.f(this.gzf) != null))
      {
        FindMContactInviteUI.e(this.gzf).setVisibility(0);
        FindMContactInviteUI.f(this.gzf).setVisibility(8);
      }
    }
    label302:
    FindMContactInviteUI.g(this.gzf).setText(this.gzf.getResources().getQuantityString(2131361799, FindMContactInviteUI.b(this.gzf).getCount(), new Object[] { Integer.valueOf(FindMContactInviteUI.b(this.gzf).getCount()) }));
    AppMethodBeat.o(108543);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI.6
 * JD-Core Version:    0.7.0.1
 */