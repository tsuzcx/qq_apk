package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.aei;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.ri;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.LinkedList;

final class c$1
  implements f
{
  c$1(c paramc) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    au.Dk().b(595, c.a(this.hKH));
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      y.i("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd Error: other error[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      h.nFQ.a(400L, 111L, 1L, false);
      if ((paramInt1 == 4) && (paramInt2 == -2011)) {
        y.e("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd Error: INVALID URL");
      }
      b.auw().atn().hFu = -5;
      b.auw().auy().nD(-5);
      return;
    }
    paramString = ((com.tencent.mm.plugin.backup.g.e)paramm).avb();
    au.Hx();
    if (!bk.pm((String)com.tencent.mm.model.c.Dz().get(2, null)).equals(paramString.szb))
    {
      y.e("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd Error: not the same account");
      b.auw().atn().hFu = -5;
      b.auw().auy().nD(-5);
      h.nFQ.a(400L, 112L, 1L, false);
      return;
    }
    if ((paramString.syZ == null) || (paramString.syZ.size() <= 0) || (paramString.syZ.getFirst() == null))
    {
      paramInt1 = paramString.syY;
      if (paramString.syZ == null) {}
      for (paramString = "null";; paramString = paramString.syZ.size())
      {
        y.e("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd AddrList is empty! AddrCount[%d], AddrList size[%s]", new Object[] { Integer.valueOf(paramInt1), paramString });
        b.auw().atn().hFu = -5;
        b.auw().auy().nD(-5);
        h.nFQ.a(400L, 113L, 1L, false);
        return;
      }
    }
    Object localObject = (ri)paramString.syZ.getFirst();
    paramm = ((ri)localObject).sMR;
    paramInt1 = ((Integer)((ri)localObject).sPm.getFirst()).intValue();
    localObject = this.hKH;
    ((c)localObject).hKy = paramString.szc;
    ((c)localObject).hKz = paramm;
    ((c)localObject).hKA = paramInt1;
    y.i("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd type:%d, scene:%d, wifiName:%s, ip:%s, port:%d", new Object[] { Integer.valueOf(paramString.hQR), Integer.valueOf(paramString.pyo), paramString.szc, paramm, Integer.valueOf(paramInt1) });
    b.auw().hFm = paramString.ID;
    b.auw().hFn = paramString.szi;
    b.auw().hFo = paramString.szj;
    b.auw().hFs = paramString.syK.tFM.oY;
    c.b(this.hKH);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.c.1
 * JD-Core Version:    0.7.0.1
 */