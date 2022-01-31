package com.tencent.mm.modelstat;

import com.tencent.mm.model.am.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class q$5
  implements am.e
{
  q$5(q paramq) {}
  
  public final void bg(int paramInt1, int paramInt2)
  {
    y.d("MicroMsg.SubCoreStat", "ReportDataFlow [%d][%d][%d] : %s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0), bk.csb() });
    n.bg(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelstat.q.5
 * JD-Core Version:    0.7.0.1
 */