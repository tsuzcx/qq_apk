package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

final class f$3
  implements com.tencent.mm.ai.f
{
  f$3(f paramf) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(78076);
    if (!(paramm instanceof d))
    {
      ab.w("MicroMsg.SubCoreCdnTransport", "get cdn dns on scene end but is not [NetSceneGetCdnDns]");
      AppMethodBeat.o(78076);
      return;
    }
    ab.i("MicroMsg.SubCoreCdnTransport", "%d get cdn dns on scene end errType[%d] errCode[%d] errMsg[%s] lastGetDnsErrorTime[%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Long.valueOf(f.a(this.fzD)) });
    if ("doScene failed".equals(paramString))
    {
      ab.d("MicroMsg.SubCoreCdnTransport", "%d get cdn dns cache do nothing.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(78076);
      return;
    }
    h.qsU.idkeyStat(546L, paramInt1 + 10, 1L, true);
    if (paramInt1 == 0)
    {
      if (f.a(this.fzD) > 0L)
      {
        h.qsU.idkeyStat(546L, 52L, 1L, true);
        f.a(this.fzD, 0L);
      }
      AppMethodBeat.o(78076);
      return;
    }
    if (paramInt1 != 4)
    {
      if (f.a(this.fzD) == 0L)
      {
        paramInt1 = ((d)paramm).scene;
        f.a(this.fzD, bo.aoy());
        f.b(this.fzD).removeMessages(1);
        f.b(this.fzD).sendMessageDelayed(f.b(this.fzD).obtainMessage(1, paramInt1, 0), 30000L);
        h.qsU.idkeyStat(546L, 50L, 1L, true);
        AppMethodBeat.o(78076);
        return;
      }
      f.a(this.fzD, 0L);
      h.qsU.idkeyStat(546L, 51L, 1L, true);
      AppMethodBeat.o(78076);
      return;
    }
    AppMethodBeat.o(78076);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.al.f.3
 * JD-Core Version:    0.7.0.1
 */