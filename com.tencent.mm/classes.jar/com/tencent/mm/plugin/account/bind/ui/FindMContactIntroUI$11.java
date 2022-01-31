package com.tencent.mm.plugin.account.bind.ui;

import android.app.ProgressDialog;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ag;
import com.tencent.mm.pluginsdk.a;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class FindMContactIntroUI$11
  implements ai.a
{
  FindMContactIntroUI$11(FindMContactIntroUI paramFindMContactIntroUI) {}
  
  public final boolean JS()
  {
    try
    {
      FindMContactIntroUI.a(this.fdm, a.ck(this.fdm));
      StringBuilder localStringBuilder = new StringBuilder("tigerreg mobileList size ");
      if (FindMContactIntroUI.k(this.fdm) == null) {}
      for (int i = 0;; i = FindMContactIntroUI.k(this.fdm).size())
      {
        y.d("MicroMsg.FindMContactIntroUI", i);
        break;
      }
      return true;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.FindMContactIntroUI", localException, "", new Object[0]);
    }
  }
  
  public final boolean JT()
  {
    if ((FindMContactIntroUI.k(this.fdm) != null) && (FindMContactIntroUI.k(this.fdm).size() != 0))
    {
      FindMContactIntroUI.a(this.fdm, new ag(FindMContactIntroUI.c(this.fdm), FindMContactIntroUI.k(this.fdm)));
      g.Dk().a(FindMContactIntroUI.l(this.fdm), 0);
      return false;
    }
    if (FindMContactIntroUI.g(this.fdm) != null)
    {
      FindMContactIntroUI.g(this.fdm).dismiss();
      FindMContactIntroUI.h(this.fdm);
    }
    FindMContactIntroUI.b(this.fdm);
    return false;
  }
  
  public final String toString()
  {
    return super.toString() + "|doUpload";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI.11
 * JD-Core Version:    0.7.0.1
 */