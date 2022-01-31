package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class a$1
  implements ap.a
{
  a$1(a parama) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(77968);
    if ((a.a(this.fyF) == 0) && (a.b(this.fyF) == 0))
    {
      AppMethodBeat.o(77968);
      return false;
    }
    ab.i("MicroMsg.CdnTransportEngine", "CdnDataFlowStat id:%s send:%d recv:%d", new Object[] { a.c(this.fyF), Integer.valueOf(a.a(this.fyF)), Integer.valueOf(a.b(this.fyF)) });
    if (ao.a.flJ == null)
    {
      ab.e("MicroMsg.CdnTransportEngine", "getNetStat null");
      AppMethodBeat.o(77968);
      return false;
    }
    ao.a.flJ.cq(a.b(this.fyF), a.a(this.fyF));
    a.d(this.fyF);
    a.e(this.fyF);
    AppMethodBeat.o(77968);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.al.a.1
 * JD-Core Version:    0.7.0.1
 */