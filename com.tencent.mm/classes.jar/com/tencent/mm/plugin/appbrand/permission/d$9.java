package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

final class d$9
  implements Runnable
{
  d$9(Runnable paramRunnable, String paramString1, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(156384);
    if (d.aKu())
    {
      d.aKv().add(this.iBH);
      ab.i("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, another request already running, put this in queue, appId %s, api %s", new Object[] { this.val$appId, this.iBu });
      AppMethodBeat.o(156384);
      return;
    }
    d.eJ(true);
    this.iBH.run();
    AppMethodBeat.o(156384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.d.9
 * JD-Core Version:    0.7.0.1
 */