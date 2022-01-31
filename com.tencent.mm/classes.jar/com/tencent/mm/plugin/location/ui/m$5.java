package com.tencent.mm.plugin.location.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.location.model.i.a;
import com.tencent.mm.plugin.location.ui.impl.TrackPoint;
import com.tencent.mm.sdk.platformtools.ab;

final class m$5
  implements i.a
{
  m$5(m paramm) {}
  
  public final void x(double paramDouble)
  {
    AppMethodBeat.i(113563);
    if (m.d(this.oeH) != null)
    {
      ab.d("MicroMsg.TrackPointViewMgrImpl", "updateMyTrackPointDegree, degree = %f", new Object[] { Double.valueOf(paramDouble) });
      m.d(this.oeH).y(paramDouble);
    }
    AppMethodBeat.o(113563);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.m.5
 * JD-Core Version:    0.7.0.1
 */