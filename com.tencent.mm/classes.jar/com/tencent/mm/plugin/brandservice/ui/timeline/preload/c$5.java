package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.z;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.r;

final class c$5
  implements Runnable
{
  c$5(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(14367);
    if ((c.b(this.jZR) == null) || (c.b(this.jZR).isFinishing()))
    {
      AppMethodBeat.o(14367);
      return;
    }
    q localq = this.jZR.aXi();
    if (localq == null)
    {
      AppMethodBeat.o(14367);
      return;
    }
    al.d(new c.5.1(this, z.afo().al(5, localq.field_orderFlag)));
    AppMethodBeat.o(14367);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.5
 * JD-Core Version:    0.7.0.1
 */