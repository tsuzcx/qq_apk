package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class c$6
  implements Runnable
{
  c$6(c paramc) {}
  
  public final void run()
  {
    boolean bool = false;
    AppMethodBeat.i(138952);
    c localc = this.cvH;
    ae.i(localc.getLogTag(), "*** handler(%s) handleWebViewForeground", new Object[] { localc.BN() });
    localc.cvu = false;
    if (!localc.csB)
    {
      bool = localc.Gw();
      localc.csD = null;
    }
    c.7 local7 = new c.7(localc, bool);
    if (!localc.Gz())
    {
      ae.i(localc.getLogTag(), "handleWebViewForeground, resume playing");
      local7.run();
    }
    AppMethodBeat.o(138952);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.c.6
 * JD-Core Version:    0.7.0.1
 */