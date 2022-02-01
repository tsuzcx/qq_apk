package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.d;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.network.p.a;
import com.tencent.mm.sdk.platformtools.Log;

final class WorkerProfile$12
  extends p.a
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
    if ((bg.aAc()) && (g.aAf().hpY) && (!bg.azj()))
    {
      Log.i("MicroMsg.WorkerProfile", "dkmsg Network connected , try send msg.");
      o.a(o.d.jdK).bdQ().execute();
      AppMethodBeat.o(19556);
      return;
    }
    AppMethodBeat.o(19556);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.WorkerProfile.12
 * JD-Core Version:    0.7.0.1
 */