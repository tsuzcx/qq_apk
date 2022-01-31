package com.tencent.mm.plugin.account.friend.ui;

import android.app.ProgressDialog;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.i;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.y;

final class FindMContactAddUI$6
  implements ai.a
{
  FindMContactAddUI$6(FindMContactAddUI paramFindMContactAddUI) {}
  
  public final boolean JS()
  {
    try
    {
      FindMContactAddUI.a(this.fhv, com.tencent.mm.pluginsdk.a.ck(this.fhv));
      FindMContactAddUI.c(this.fhv).fcV = FindMContactAddUI.d(this.fhv);
      FindMContactAddUI.c(this.fhv).r(((com.tencent.mm.plugin.account.a.a.a)g.t(com.tencent.mm.plugin.account.a.a.a.class)).getFriendData());
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.FindMContactAddUI", localException, "", new Object[0]);
      }
    }
  }
  
  public final boolean JT()
  {
    if (FindMContactAddUI.a(this.fhv) != null)
    {
      FindMContactAddUI.a(this.fhv).dismiss();
      FindMContactAddUI.b(this.fhv);
    }
    FindMContactAddUI.c(this.fhv).notifyDataSetChanged();
    return false;
  }
  
  public final String toString()
  {
    return super.toString() + "|listMFriendData";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI.6
 * JD-Core Version:    0.7.0.1
 */