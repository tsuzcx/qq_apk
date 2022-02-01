package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.j.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

final class h$1
  implements j.a
{
  public final void nJ(int paramInt)
  {
    AppMethodBeat.i(19884);
    Log.i("MicroMsg.PostTaskLightweightJob", "CrashStatus report: key %s ", new Object[] { Integer.valueOf(paramInt) });
    h.OAn.idkeyStat(25L, paramInt, 1L, false);
    AppMethodBeat.o(19884);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.h.1
 * JD-Core Version:    0.7.0.1
 */