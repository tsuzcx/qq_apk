package com.tencent.mm.an;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

final class a$1
  implements MTimerHandler.CallBack
{
  a$1(a parama) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(150332);
    if ((a.a(this.iRp) == 0) && (a.b(this.iRp) == 0))
    {
      AppMethodBeat.o(150332);
      return false;
    }
    Log.i("MicroMsg.CdnTransportEngine", "CdnDataFlowStat id:%s send:%d recv:%d", new Object[] { a.c(this.iRp), Integer.valueOf(a.a(this.iRp)), Integer.valueOf(a.b(this.iRp)) });
    if (ay.a.iDr == null)
    {
      Log.e("MicroMsg.CdnTransportEngine", "getNetStat null");
      AppMethodBeat.o(150332);
      return false;
    }
    ay.a.iDr.dl(a.b(this.iRp), a.a(this.iRp));
    a.d(this.iRp);
    a.e(this.iRp);
    AppMethodBeat.o(150332);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.an.a.1
 * JD-Core Version:    0.7.0.1
 */