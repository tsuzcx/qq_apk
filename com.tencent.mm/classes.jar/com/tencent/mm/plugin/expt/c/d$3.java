package com.tencent.mm.plugin.expt.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jw;
import com.tencent.mm.sdk.platformtools.ab;

final class d$3
  extends com.tencent.mm.sdk.b.c<jw>
{
  d$3(d paramd)
  {
    AppMethodBeat.i(73533);
    this.__eventId = jw.class.getName().hashCode();
    AppMethodBeat.o(73533);
  }
  
  private boolean bsS()
  {
    AppMethodBeat.i(73534);
    ab.i("MicroMsg.MMPageFlowService", "manual force login");
    if (!d.a(this.mcn))
    {
      d.b(this.mcn);
      com.tencent.mm.plugin.expt.hellhound.a.a.c.s(105, null, null);
      com.tencent.mm.plugin.expt.hellhound.a.a.c.brV();
      com.tencent.mm.plugin.expt.hellhound.a.a.a.vq(7);
      com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.vm(7);
    }
    AppMethodBeat.o(73534);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.c.d.3
 * JD-Core Version:    0.7.0.1
 */