package com.tencent.mm.plugin.collect.reward.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;

final class a$1
  implements Runnable
{
  a$1(a parama, String paramString, d paramd, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(63914);
    a.a locala = (a.a)this.tWK.rRk.get(this.acq);
    if (locala != null)
    {
      if (this.lIc != null)
      {
        int i = this.lIc.field_retCode;
        locala.aa(this.acq, this.tWJ, i);
        this.tWK.rRk.remove(this.acq);
        if (this.lIc.field_retCode == 0)
        {
          h.IzE.idkeyStat(724L, 8L, 1L, false);
          AppMethodBeat.o(63914);
          return;
        }
        h.IzE.idkeyStat(724L, 9L, 1L, false);
        AppMethodBeat.o(63914);
        return;
      }
      Log.v("MicroMsg.QrRewardCdnDownloadHelper", "download is not end");
      AppMethodBeat.o(63914);
      return;
    }
    Log.w("MicroMsg.QrRewardCdnDownloadHelper", "no callback");
    AppMethodBeat.o(63914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.b.a.1
 * JD-Core Version:    0.7.0.1
 */