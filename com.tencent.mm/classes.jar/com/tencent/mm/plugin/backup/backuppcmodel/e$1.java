package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.g.k;
import com.tencent.mm.plugin.backup.i.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class e$1
  implements f
{
  e$1(e parame) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    com.tencent.mm.plugin.backup.g.b.b(3, this.hKW.hIi);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      y.e("MicroMsg.BackupPcServer", "onSendStartRequestEnd receive startResp failed, errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      h.nFQ.a(400L, 117L, 1L, false);
      b.auw().atn().hFu = -5;
      this.hKW.nD(-5);
      return;
    }
    y.i("MicroMsg.BackupPcServer", "onSendStartRequestEnd receive startResp success, errMsg[%s]", new Object[] { paramString });
    paramString = ((k)paramm).hME;
    if (!b.auw().hFm.equals(paramString.ID))
    {
      y.e("MicroMsg.BackupPcServer", "onSendStartRequestEnd startResp not the same id");
      h.nFQ.a(400L, 118L, 1L, false);
      b.auw().atn().hFu = -5;
      this.hKW.nD(-5);
      return;
    }
    b.auw().atn().hFA = paramString.hQi;
    y.i("MicroMsg.BackupPcServer", "onSendStartRequestEnd startResp BigDataSize[%d]", new Object[] { Long.valueOf(paramString.hQi) });
    au.Hx();
    c.Dz().c(ac.a.uus, Boolean.valueOf(false));
    com.tencent.mm.plugin.backup.g.b.auL();
    e.a(this.hKW);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.e.1
 * JD-Core Version:    0.7.0.1
 */