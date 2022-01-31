package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ao.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class q$5
  implements ao.e
{
  q$5(q paramq) {}
  
  public final void cq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(78792);
    ab.d("MicroMsg.SubCoreStat", "ReportDataFlow [%d][%d][%d] : %s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0), bo.dtY() });
    n.cq(paramInt1, paramInt2);
    AppMethodBeat.o(78792);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelstat.q.5
 * JD-Core Version:    0.7.0.1
 */