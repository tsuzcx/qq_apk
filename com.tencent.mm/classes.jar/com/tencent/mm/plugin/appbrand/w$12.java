package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.l.b;
import com.tencent.mm.plugin.handoff.model.HandOffMP;
import com.tencent.mm.sdk.platformtools.Log;

final class w$12
  implements b
{
  private HandOffMP qwg;
  
  w$12(w paramw)
  {
    AppMethodBeat.i(316551);
    this.qwg = com.tencent.mm.plugin.appbrand.l.a.J(this.qvY);
    AppMethodBeat.o(316551);
  }
  
  public final void Uz(String paramString)
  {
    AppMethodBeat.i(316553);
    if (this.qvY.asE())
    {
      Log.i("MicroMsg.AppBrandRuntimeWC", "is pre render mode, not handoff");
      AppMethodBeat.o(316553);
      return;
    }
    if ((this.qvY.getInitConfig() != null) && (!this.qvY.getInitConfig().qYd))
    {
      this.qwg.setAppEntryPage(paramString);
      ((com.tencent.mm.plugin.handoff.a.a)h.ax(com.tencent.mm.plugin.handoff.a.a.class)).e(this.qwg);
    }
    AppMethodBeat.o(316553);
  }
  
  public final void bu(String paramString, int paramInt)
  {
    AppMethodBeat.i(316560);
    if ((this.qvY.getInitConfig() != null) && (!this.qvY.getInitConfig().qYd))
    {
      this.qwg.setHandOffType(paramInt);
      this.qwg.setAppEntryPage(paramString);
      ((com.tencent.mm.plugin.handoff.a.a)h.ax(com.tencent.mm.plugin.handoff.a.a.class)).f(this.qwg);
    }
    AppMethodBeat.o(316560);
  }
  
  public final void cdf()
  {
    AppMethodBeat.i(316555);
    if (this.qvY.asE())
    {
      Log.i("MicroMsg.AppBrandRuntimeWC", "is pre render mode, not delete handoff");
      AppMethodBeat.o(316555);
      return;
    }
    if ((this.qvY.getInitConfig() != null) && (!this.qvY.getInitConfig().qYd)) {
      ((com.tencent.mm.plugin.handoff.a.a)h.ax(com.tencent.mm.plugin.handoff.a.a.class)).del(this.qwg.getKey());
    }
    AppMethodBeat.o(316555);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.w.12
 * JD-Core Version:    0.7.0.1
 */