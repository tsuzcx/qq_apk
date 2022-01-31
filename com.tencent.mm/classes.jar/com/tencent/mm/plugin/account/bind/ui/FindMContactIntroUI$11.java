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

final class FindMContactIntroUI$11
  implements al.a
{
  FindMContactIntroUI$11(FindMContactIntroUI paramFindMContactIntroUI) {}
  
  public final boolean acS()
  {
    AppMethodBeat.i(13608);
    for (;;)
    {
      try
      {
        FindMContactIntroUI.a(this.guX, a.cL(this.guX));
        StringBuilder localStringBuilder = new StringBuilder("tigerreg mobileList size ");
        if (FindMContactIntroUI.k(this.guX) != null) {
          continue;
        }
        i = 0;
        ab.d("MicroMsg.FindMContactIntroUI", i);
      }
      catch (Exception localException)
      {
        int i;
        ab.printErrStackTrace("MicroMsg.FindMContactIntroUI", localException, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(13608);
      return true;
      i = FindMContactIntroUI.k(this.guX).size();
    }
  }
  
  public final boolean acT()
  {
    AppMethodBeat.i(13607);
    if ((FindMContactIntroUI.k(this.guX) != null) && (FindMContactIntroUI.k(this.guX).size() != 0))
    {
      FindMContactIntroUI.a(this.guX, new ag(FindMContactIntroUI.c(this.guX), FindMContactIntroUI.k(this.guX)));
      g.Rc().a(FindMContactIntroUI.l(this.guX), 0);
    }
    for (;;)
    {
      AppMethodBeat.o(13607);
      return false;
      if (FindMContactIntroUI.g(this.guX) != null)
      {
        FindMContactIntroUI.g(this.guX).dismiss();
        FindMContactIntroUI.h(this.guX);
      }
      FindMContactIntroUI.b(this.guX);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(13609);
    String str = super.toString() + "|doUpload";
    AppMethodBeat.o(13609);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI.11
 * JD-Core Version:    0.7.0.1
 */