package com.tencent.mm.plugin.account.friend.ui;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al.a;

final class FindMContactInviteUI$5
  implements al.a
{
  FindMContactInviteUI$5(FindMContactInviteUI paramFindMContactInviteUI) {}
  
  public final boolean acS()
  {
    AppMethodBeat.i(108541);
    try
    {
      FindMContactInviteUI.a(this.gzf, com.tencent.mm.pluginsdk.a.cL(this.gzf));
      FindMContactInviteUI.b(this.gzf).guG = FindMContactInviteUI.c(this.gzf);
      FindMContactInviteUI.b(this.gzf).r(((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).getFriendData());
      AppMethodBeat.o(108541);
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.FindMContactInviteUI", localException, "", new Object[0]);
      }
    }
  }
  
  public final boolean acT()
  {
    AppMethodBeat.i(108540);
    if (FindMContactInviteUI.a(this.gzf) != null)
    {
      FindMContactInviteUI.a(this.gzf).dismiss();
      FindMContactInviteUI.a(this.gzf, null);
    }
    FindMContactInviteUI.b(this.gzf).notifyDataSetChanged();
    AppMethodBeat.o(108540);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(108542);
    String str = super.toString() + "|listMFriendData";
    AppMethodBeat.o(108542);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI.5
 * JD-Core Version:    0.7.0.1
 */