package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.c.c;
import com.tencent.mm.plugin.backup.g.i;
import com.tencent.mm.plugin.backup.i.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class e$2
  implements f
{
  e$2(e parame) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    com.tencent.mm.plugin.backup.g.b.b(11, this.hKW.hKU);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      y.e("MicroMsg.BackupPcServer", "requestSessionSceneEnd sessionName or timeInterval null or request session resp number error, errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      h.nFQ.a(400L, 119L, 1L, false);
      this.hKW.cancel(false);
      b.auw().atn().hFu = -5;
      this.hKW.nD(-5);
      return;
    }
    paramString = (i)paramm;
    paramString = g.a(paramString.hMs.hPU, paramString.hMs.hPV);
    y.i("MicroMsg.BackupPcServer", "requestSessionSceneEnd receive requestsessionResp, backupSessionList size[%d]", new Object[] { Integer.valueOf(paramString.size()) });
    paramm = e.b(this.hKW);
    b.auw().aux();
    paramm.a(paramString, b.auw().atn().hFA, e.access$100());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.e.2
 * JD-Core Version:    0.7.0.1
 */