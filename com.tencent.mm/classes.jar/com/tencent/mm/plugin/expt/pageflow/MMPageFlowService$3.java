package com.tencent.mm.plugin.expt.pageflow;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.og;
import com.tencent.mm.plugin.expt.hellhound.ext.c.c;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

class MMPageFlowService$3
  extends IListener<og>
{
  MMPageFlowService$3(d paramd, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(299864);
    this.__eventId = og.class.getName().hashCode();
    AppMethodBeat.o(299864);
  }
  
  private boolean dNd()
  {
    AppMethodBeat.i(122367);
    Log.i("MicroMsg.MMPageFlowService", "manual force login");
    if (!d.a(this.zMs))
    {
      d.b(this.zMs);
      c.a(105, null, 0, System.currentTimeMillis());
      c.dLg();
      com.tencent.mm.plugin.expt.hellhound.ext.c.a.LR(7);
      com.tencent.mm.plugin.expt.hellhound.core.b.a.a.LA(7);
    }
    AppMethodBeat.o(122367);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.pageflow.MMPageFlowService.3
 * JD-Core Version:    0.7.0.1
 */