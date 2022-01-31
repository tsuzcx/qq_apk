package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c.a;
import com.tencent.mm.sdk.platformtools.ab;

final class PickPoi$1
  implements c.a
{
  PickPoi$1(PickPoi paramPickPoi) {}
  
  public final void b(Addr paramAddr)
  {
    AppMethodBeat.i(113648);
    ab.d("MicroMsg.PickPoi", "onGetAddrss  %s", new Object[] { paramAddr.toString() });
    if (PickPoi.a(this.ogM) == null)
    {
      ab.i("MicroMsg.PickPoi", "error, empty poi!");
      AppMethodBeat.o(113648);
      return;
    }
    f localf = PickPoi.a(this.ogM);
    localf.ohc = paramAddr;
    localf.ogS = paramAddr.fBq;
    localf.bnl = paramAddr.fBB;
    localf.bnm = paramAddr.fBC;
    localf.ogW = paramAddr.fBr;
    localf.ogX = paramAddr.fBs;
    localf.ogZ = paramAddr.fBw;
    localf.ohb = paramAddr.fBy;
    localf.ohe = paramAddr.fBA;
    ab.d("poidata", "roughAddr %s", new Object[] { paramAddr.toString() });
    if (PickPoi.b(this.ogM) != null) {
      PickPoi.b(this.ogM).notifyDataSetChanged();
    }
    AppMethodBeat.o(113648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.PickPoi.1
 * JD-Core Version:    0.7.0.1
 */