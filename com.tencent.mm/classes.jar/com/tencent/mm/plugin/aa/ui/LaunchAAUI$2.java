package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class LaunchAAUI$2
  implements l
{
  LaunchAAUI$2(LaunchAAUI paramLaunchAAUI, ArrayList paramArrayList, String paramString) {}
  
  public final void b(k paramk)
  {
    AppMethodBeat.i(220002);
    if ((LaunchAAUI.j(this.mPg) != null) && (LaunchAAUI.j(this.mPg).isShowing())) {
      LaunchAAUI.j(this.mPg).dismiss();
    }
    LaunchAAUI.k(this.mPg);
    this.mPh.clear();
    switch (paramk.resultCode)
    {
    }
    do
    {
      do
      {
        LaunchAAUI.a(this.mPg, this.mPh);
        AppMethodBeat.o(220002);
        return;
        Log.i("MicroMsg.Aa.LaunchAAUI", "search result %d", new Object[] { Integer.valueOf(paramk.BIW.size()) });
        if ((this.mPi == null) || (!this.mPi.equals(paramk.BFk.query)))
        {
          Log.i("MicroMsg.Aa.LaunchAAUI", "Native Search: Not Same query origin:%s current:%s", new Object[] { paramk.BFk.query, this.mPi });
          AppMethodBeat.o(220002);
          return;
        }
      } while ((paramk.BIW == null) || (paramk.BIW.size() <= 0));
      paramk = paramk.BIW.iterator();
      while (paramk.hasNext())
      {
        m localm = (m)paramk.next();
        if (LaunchAAUI.aam(localm.BHS)) {
          this.mPh.add(localm.BHS);
        }
      }
      Log.i("MicroMsg.Aa.LaunchAAUI", "onSearchError: errorCode=%d | originQuery=%s", new Object[] { Integer.valueOf(paramk.resultCode), paramk.BFk.query });
    } while (paramk.BFk.query.equals(this.mPi));
    Log.i("MicroMsg.Aa.LaunchAAUI", "Native Search: Not Same Query");
    AppMethodBeat.o(220002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.2
 * JD-Core Version:    0.7.0.1
 */