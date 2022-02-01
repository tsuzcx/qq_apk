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
    AppMethodBeat.i(213022);
    if ((LaunchAAUI.i(this.jXQ) != null) && (LaunchAAUI.i(this.jXQ).isShowing())) {
      LaunchAAUI.i(this.jXQ).dismiss();
    }
    LaunchAAUI.j(this.jXQ);
    this.jXR.clear();
    switch (paramk.resultCode)
    {
    }
    do
    {
      do
      {
        LaunchAAUI.a(this.jXQ, this.jXR);
        AppMethodBeat.o(213022);
        return;
        Log.i("MicroMsg.Aa.LaunchAAUI", "search result %d", new Object[] { Integer.valueOf(paramk.wXb.size()) });
        if ((this.jXS == null) || (!this.jXS.equals(paramk.wTn.query)))
        {
          Log.i("MicroMsg.Aa.LaunchAAUI", "Native Search: Not Same query origin:%s current:%s", new Object[] { paramk.wTn.query, this.jXS });
          AppMethodBeat.o(213022);
          return;
        }
      } while ((paramk.wXb == null) || (paramk.wXb.size() <= 0));
      paramk = paramk.wXb.iterator();
      while (paramk.hasNext())
      {
        m localm = (m)paramk.next();
        if (LaunchAAUI.SG(localm.wVX)) {
          this.jXR.add(localm.wVX);
        }
      }
      Log.i("MicroMsg.Aa.LaunchAAUI", "onSearchError: errorCode=%d | originQuery=%s", new Object[] { Integer.valueOf(paramk.resultCode), paramk.wTn.query });
    } while (paramk.wTn.query.equals(this.jXS));
    Log.i("MicroMsg.Aa.LaunchAAUI", "Native Search: Not Same Query");
    AppMethodBeat.o(213022);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.2
 * JD-Core Version:    0.7.0.1
 */