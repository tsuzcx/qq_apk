package com.tencent.mm.plugin.account.friend.ui;

import android.app.ProgressDialog;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.i;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.y;

final class FindMContactInviteUI$5
  implements ai.a
{
  FindMContactInviteUI$5(FindMContactInviteUI paramFindMContactInviteUI) {}
  
  public final boolean JS()
  {
    try
    {
      FindMContactInviteUI.a(this.fhx, com.tencent.mm.pluginsdk.a.ck(this.fhx));
      FindMContactInviteUI.b(this.fhx).fcV = FindMContactInviteUI.c(this.fhx);
      FindMContactInviteUI.b(this.fhx).r(((com.tencent.mm.plugin.account.a.a.a)g.t(com.tencent.mm.plugin.account.a.a.a.class)).getFriendData());
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.FindMContactInviteUI", localException, "", new Object[0]);
      }
    }
  }
  
  public final boolean JT()
  {
    if (FindMContactInviteUI.a(this.fhx) != null)
    {
      FindMContactInviteUI.a(this.fhx).dismiss();
      FindMContactInviteUI.a(this.fhx, null);
    }
    FindMContactInviteUI.b(this.fhx).notifyDataSetChanged();
    return false;
  }
  
  public final String toString()
  {
    return super.toString() + "|listMFriendData";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI.5
 * JD-Core Version:    0.7.0.1
 */