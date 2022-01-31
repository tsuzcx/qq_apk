package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.sdk.platformtools.y;

public final class e$1
  implements w.a
{
  public e$1(e parame) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    y.i("MicroMsg.BizTimeLineOftenReadReport", "often_read_bar_report CGI return, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.e.1
 * JD-Core Version:    0.7.0.1
 */