package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.storage.q;

final class c$2
  implements Runnable
{
  c$2(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(14363);
    c.a(this.jZR);
    if ((c.b(this.jZR) == null) || (c.b(this.jZR).isFinishing()))
    {
      AppMethodBeat.o(14363);
      return;
    }
    if ((c.aXk()) && (!at.isWifi(c.b(this.jZR))))
    {
      AppMethodBeat.o(14363);
      return;
    }
    if (!c.c(this.jZR))
    {
      ab.v("MicroMsg.BizTimeLineImgLoader", "not all visibleItem loaded");
      AppMethodBeat.o(14363);
      return;
    }
    q localq = c.d(this.jZR);
    if (localq == null)
    {
      ab.v("MicroMsg.BizTimeLineImgLoader", "not loading");
      AppMethodBeat.o(14363);
      return;
    }
    c.a(this.jZR, localq);
    AppMethodBeat.o(14363);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.2
 * JD-Core Version:    0.7.0.1
 */