package com.tencent.mm.plugin.collect.reward.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;

final class a$1
  implements Runnable
{
  a$1(a parama, String paramString, d paramd, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(41054);
    a.a locala = (a.a)a.a(this.kOQ).get(this.Cq);
    if (locala != null)
    {
      if (this.fyV != null)
      {
        int i = this.fyV.field_retCode;
        locala.Z(this.Cq, this.kOP, i);
        a.a(this.kOQ).remove(this.Cq);
        if (this.fyV.field_retCode == 0)
        {
          h.qsU.idkeyStat(724L, 8L, 1L, false);
          AppMethodBeat.o(41054);
          return;
        }
        h.qsU.idkeyStat(724L, 9L, 1L, false);
        AppMethodBeat.o(41054);
        return;
      }
      ab.v("MicroMsg.QrRewardCdnDownloadHelper", "download is not end");
      AppMethodBeat.o(41054);
      return;
    }
    ab.w("MicroMsg.QrRewardCdnDownloadHelper", "no callback");
    AppMethodBeat.o(41054);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.b.a.1
 * JD-Core Version:    0.7.0.1
 */