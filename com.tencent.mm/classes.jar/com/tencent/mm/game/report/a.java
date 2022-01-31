package com.tencent.mm.game.report;

import com.tencent.mm.game.report.api.b;
import com.tencent.mm.game.report.api.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public final class a
  extends b
{
  private HashMap<Long, com.tencent.mm.game.report.api.a> dCn = new HashMap();
  
  public final void a(long paramLong, com.tencent.mm.game.report.api.a parama)
  {
    this.dCn.put(Long.valueOf(paramLong), parama);
  }
  
  public final void a(String paramString1, int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, String paramString2, int paramInt3, int paramInt4, String paramString3, long paramLong4, int paramInt5, long paramLong5, String paramString4)
  {
    long l = paramLong2;
    if (paramLong2 < 0L) {
      l = 0L;
    }
    paramLong2 = paramLong4;
    if (paramLong4 < 0L) {
      paramLong2 = 0L;
    }
    y.i("MicroMsg.GameDownloadReportImpl", "report_14567, appId = %s, scene = %d, opId = %d, startSize = %d, downloadedSize = %d, totalSize = %d, downloadUrl = %s, errCode = %d, downloaderType = %d, chanelId = %s, costTime = %d, startState = %d, downloadId = %d", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong1), Long.valueOf(l), Long.valueOf(paramLong3), paramString2, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString3, Long.valueOf(paramLong2), Integer.valueOf(paramInt5), Long.valueOf(paramLong5) });
    c.a(d.c(14567, new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(l), Long.valueOf(paramLong3), com.tencent.mm.game.report.a.a.fy(paramString2), Integer.valueOf(com.tencent.mm.game.report.a.a.getNetworkType(ae.getContext())), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString3, Long.valueOf(paramLong2), Integer.valueOf(paramInt5), Long.valueOf(paramLong5), paramString4, com.tencent.mm.game.report.a.a.BH(), Long.valueOf(paramLong1) }));
    h.nFQ.f(15015, new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(l), Long.valueOf(paramLong3), com.tencent.mm.game.report.a.a.fy(paramString2), Integer.valueOf(com.tencent.mm.game.report.a.a.getNetworkType(ae.getContext())), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString3, Long.valueOf(paramLong2), Integer.valueOf(paramInt5), Long.valueOf(paramLong5), paramString4 });
  }
  
  public final void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    long l = System.currentTimeMillis();
    c.a(d.c(10737, new Object[] { Long.valueOf(l), Long.valueOf(l), Integer.valueOf(1), paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0), Integer.valueOf(0), paramString2, "", paramString3, Integer.valueOf(com.tencent.mm.game.report.a.a.getNetworkType(ae.getContext())), Integer.valueOf(0), Integer.valueOf(1), paramString4, paramString5 }));
  }
  
  public final com.tencent.mm.game.report.api.a bu(long paramLong)
  {
    if (this.dCn.containsKey(Long.valueOf(paramLong))) {
      return (com.tencent.mm.game.report.api.a)this.dCn.remove(Long.valueOf(paramLong));
    }
    return null;
  }
  
  public final void i(String paramString, long paramLong)
  {
    if (bk.bl(paramString)) {
      return;
    }
    if ("appid_is_empty".equals(paramString))
    {
      h.nFQ.a(860L, paramLong, 1L, false);
      return;
    }
    com.tencent.mm.cg.a.post(new a.1(this, paramString, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.game.report.a
 * JD-Core Version:    0.7.0.1
 */