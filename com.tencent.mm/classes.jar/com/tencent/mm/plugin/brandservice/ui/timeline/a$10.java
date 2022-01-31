package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.q;
import java.util.HashMap;

final class a$10
  implements i
{
  a$10(a parama) {}
  
  public final void a(q paramq, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14107);
    f localf = this.jVZ.jVS;
    if (paramq != null)
    {
      f.a locala = (f.a)localf.jWA.get(paramq.field_msgId + "_" + paramInt1);
      if (locala != null)
      {
        locala.wzr = 1;
        ab.d("MicroMsg.BizTimeLineReport", "onClick %d", new Object[] { Integer.valueOf(paramInt1) });
      }
      localf.a(paramq, paramInt1, 11, paramInt2);
    }
    this.jVZ.jVI.e(paramq);
    AppMethodBeat.o(14107);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.10
 * JD-Core Version:    0.7.0.1
 */