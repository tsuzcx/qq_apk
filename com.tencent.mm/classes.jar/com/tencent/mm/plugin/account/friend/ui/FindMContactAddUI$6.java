package com.tencent.mm.plugin.account.friend.ui;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al.a;

final class FindMContactAddUI$6
  implements al.a
{
  FindMContactAddUI$6(FindMContactAddUI paramFindMContactAddUI) {}
  
  public final boolean acS()
  {
    AppMethodBeat.i(108518);
    try
    {
      FindMContactAddUI.a(this.gzd, com.tencent.mm.pluginsdk.a.cL(this.gzd));
      FindMContactAddUI.c(this.gzd).guG = FindMContactAddUI.d(this.gzd);
      FindMContactAddUI.c(this.gzd).r(((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).getFriendData());
      AppMethodBeat.o(108518);
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.FindMContactAddUI", localException, "", new Object[0]);
      }
    }
  }
  
  public final boolean acT()
  {
    AppMethodBeat.i(108517);
    if (FindMContactAddUI.a(this.gzd) != null)
    {
      FindMContactAddUI.a(this.gzd).dismiss();
      FindMContactAddUI.b(this.gzd);
    }
    FindMContactAddUI.c(this.gzd).notifyDataSetChanged();
    AppMethodBeat.o(108517);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(108519);
    String str = super.toString() + "|listMFriendData";
    AppMethodBeat.o(108519);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI.6
 * JD-Core Version:    0.7.0.1
 */