package com.tencent.mm.plugin.crashfix.patch.killself;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ne;
import com.tencent.mm.sdk.event.IListener;

class KillSelfMonitor$2
  extends IListener<ne>
{
  KillSelfMonitor$2(a parama, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(261579);
    this.__eventId = ne.class.getName().hashCode();
    AppMethodBeat.o(261579);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.patch.killself.KillSelfMonitor.2
 * JD-Core Version:    0.7.0.1
 */