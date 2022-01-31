package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.mm.ae.g.a;
import com.tencent.mm.model.ao;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.bi;

final class g$2
  implements Runnable
{
  g$2(g paramg, cd paramcd, ao paramao, bi parambi) {}
  
  public final void run()
  {
    if (this.mdh.kSW == 49)
    {
      g.a locala = g.a.gp(g.c(this.mdh));
      if ((locala.dRW == 1) && (!bk.bl(locala.dRX)) && (!bk.bl(locala.dRY)))
      {
        this.mdi.a(39, locala.dRY, "", locala.dRX, null, null);
        return;
      }
      this.mdi.a(this.dUy);
      return;
    }
    this.mdi.a(this.dUy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.g.2
 * JD-Core Version:    0.7.0.1
 */