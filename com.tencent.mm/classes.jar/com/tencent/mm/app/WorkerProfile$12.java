package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.modelmulti.i;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.ac;

final class WorkerProfile$12
  extends n.a
{
  WorkerProfile$12(WorkerProfile paramWorkerProfile) {}
  
  public final void onNetworkChange(int paramInt)
  {
    AppMethodBeat.i(19556);
    if ((paramInt != 4) && (paramInt != 6))
    {
      AppMethodBeat.o(19556);
      return;
    }
    if ((az.agM()) && (g.agP().ggT) && (!az.afS()))
    {
      ac.i("MicroMsg.WorkerProfile", "dkmsg Network connected , try send msg.");
      az.agi().a(new i(), 0);
      AppMethodBeat.o(19556);
      return;
    }
    AppMethodBeat.o(19556);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.WorkerProfile.12
 * JD-Core Version:    0.7.0.1
 */