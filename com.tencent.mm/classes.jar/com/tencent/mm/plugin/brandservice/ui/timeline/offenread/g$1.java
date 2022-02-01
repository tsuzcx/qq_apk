package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.sdk.platformtools.Log;

public final class g$1
  implements aa.a
{
  public g$1(g paramg) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, d paramd, q paramq)
  {
    AppMethodBeat.i(6136);
    Log.i("MicroMsg.BizTimeLineOftenReadReport", "often_read_bar_report CGI return, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(6136);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.g.1
 * JD-Core Version:    0.7.0.1
 */