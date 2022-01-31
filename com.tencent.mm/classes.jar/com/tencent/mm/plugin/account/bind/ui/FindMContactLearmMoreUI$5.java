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

final class FindMContactLearmMoreUI$5
  implements al.a
{
  FindMContactLearmMoreUI$5(FindMContactLearmMoreUI paramFindMContactLearmMoreUI) {}
  
  public final boolean acS()
  {
    AppMethodBeat.i(13627);
    for (;;)
    {
      try
      {
        FindMContactLearmMoreUI.a(this.gvb, a.cL(this.gvb));
        StringBuilder localStringBuilder = new StringBuilder("tigerreg mobileList size ");
        if (FindMContactLearmMoreUI.j(this.gvb) != null) {
          continue;
        }
        i = 0;
        ab.d("MicroMsg.FindMContactLearmMoreUI", i);
      }
      catch (Exception localException)
      {
        int i;
        ab.printErrStackTrace("MicroMsg.FindMContactLearmMoreUI", localException, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(13627);
      return true;
      i = FindMContactLearmMoreUI.j(this.gvb).size();
    }
  }
  
  public final boolean acT()
  {
    AppMethodBeat.i(13626);
    if ((FindMContactLearmMoreUI.j(this.gvb) != null) && (FindMContactLearmMoreUI.j(this.gvb).size() != 0))
    {
      FindMContactLearmMoreUI.a(this.gvb, new ag(FindMContactLearmMoreUI.h(this.gvb), FindMContactLearmMoreUI.j(this.gvb)));
      g.Rc().a(FindMContactLearmMoreUI.k(this.gvb), 0);
    }
    for (;;)
    {
      AppMethodBeat.o(13626);
      return false;
      if (FindMContactLearmMoreUI.c(this.gvb) != null)
      {
        FindMContactLearmMoreUI.c(this.gvb).dismiss();
        FindMContactLearmMoreUI.d(this.gvb);
      }
      FindMContactLearmMoreUI.b(this.gvb);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(13628);
    String str = super.toString() + "|doUpload";
    AppMethodBeat.o(13628);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactLearmMoreUI.5
 * JD-Core Version:    0.7.0.1
 */