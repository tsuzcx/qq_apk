package com.tencent.mm.plugin.account.bind.ui;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ag;
import com.tencent.mm.pluginsdk.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al.a;
import java.util.List;

final class FindMContactAlertUI$11
  implements al.a
{
  FindMContactAlertUI$11(FindMContactAlertUI paramFindMContactAlertUI) {}
  
  public final boolean acS()
  {
    AppMethodBeat.i(13574);
    for (;;)
    {
      try
      {
        FindMContactAlertUI.a(this.guR, a.cL(this.guR));
        StringBuilder localStringBuilder = new StringBuilder("tigerreg mobileList size ");
        if (FindMContactAlertUI.k(this.guR) != null) {
          continue;
        }
        i = 0;
        ab.d("MicroMsg.FindMContactAlertUI", i);
      }
      catch (Exception localException)
      {
        int i;
        ab.printErrStackTrace("MicroMsg.FindMContactAlertUI", localException, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(13574);
      return true;
      i = FindMContactAlertUI.k(this.guR).size();
    }
  }
  
  public final boolean acT()
  {
    AppMethodBeat.i(13573);
    if ((FindMContactAlertUI.k(this.guR) != null) && (FindMContactAlertUI.k(this.guR).size() != 0))
    {
      FindMContactAlertUI.a(this.guR, new ag(FindMContactAlertUI.a(this.guR), FindMContactAlertUI.k(this.guR)));
      g.Rc().a(FindMContactAlertUI.l(this.guR), 0);
    }
    for (;;)
    {
      AppMethodBeat.o(13573);
      return false;
      if (FindMContactAlertUI.f(this.guR) != null)
      {
        FindMContactAlertUI.f(this.guR).dismiss();
        FindMContactAlertUI.g(this.guR);
      }
      FindMContactAlertUI.d(this.guR);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(13575);
    String str = super.toString() + "|doUpload";
    AppMethodBeat.o(13575);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI.11
 * JD-Core Version:    0.7.0.1
 */