package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class f$1
  implements x.a
{
  public f$1(f paramf) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, n paramn)
  {
    AppMethodBeat.i(6136);
    ad.i("MicroMsg.BizTimeLineOftenReadReport", "often_read_bar_report CGI return, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(6136);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.f.1
 * JD-Core Version:    0.7.0.1
 */