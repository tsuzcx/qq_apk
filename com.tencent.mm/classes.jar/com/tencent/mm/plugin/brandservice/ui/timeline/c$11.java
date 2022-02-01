package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.s;
import java.util.HashMap;

final class c$11
  implements k
{
  c$11(c paramc) {}
  
  public final void a(s params, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175422);
    h localh = this.mXd.mWX;
    if (params != null)
    {
      h.a locala = (h.a)localh.mXH.get(params.field_msgId + "_" + paramInt1);
      if (locala != null)
      {
        locala.CKg = 1;
        ad.d("MicroMsg.BizTimeLineReport", "onClick %d", new Object[] { Integer.valueOf(paramInt1) });
      }
      localh.a(params, paramInt1, 11, paramInt2);
    }
    this.mXd.mWN.e(params);
    AppMethodBeat.o(175422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.c.11
 * JD-Core Version:    0.7.0.1
 */