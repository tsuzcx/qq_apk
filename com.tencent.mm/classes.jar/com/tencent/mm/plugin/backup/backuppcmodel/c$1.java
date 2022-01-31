package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ajf;
import com.tencent.mm.protocal.protobuf.vd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.LinkedList;

final class c$1
  implements f
{
  c$1(c paramc) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(17499);
    aw.Rc().b(595, c.a(this.jEk));
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.i("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd Error: other error[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      h.qsU.idkeyStat(400L, 111L, 1L, false);
      if ((paramInt1 == 4) && (paramInt2 == -2011)) {
        ab.e("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd Error: INVALID URL");
      }
      b.aTX().aSL().jyN = -5;
      b.aTX().aTZ().rl(-5);
      AppMethodBeat.o(17499);
      return;
    }
    paramString = ((com.tencent.mm.plugin.backup.g.e)paramm).aUD();
    aw.aaz();
    if (!bo.nullAsNil((String)com.tencent.mm.model.c.Ru().get(2, null)).equals(paramString.wtd))
    {
      ab.e("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd Error: not the same account");
      b.aTX().aSL().jyN = -5;
      b.aTX().aTZ().rl(-5);
      h.qsU.idkeyStat(400L, 112L, 1L, false);
      AppMethodBeat.o(17499);
      return;
    }
    if ((paramString.wtb == null) || (paramString.wtb.size() <= 0) || (paramString.wtb.getFirst() == null))
    {
      paramInt1 = paramString.wta;
      if (paramString.wtb == null) {}
      for (paramString = "null";; paramString = paramString.wtb.size())
      {
        ab.e("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd AddrList is empty! AddrCount[%d], AddrList size[%s]", new Object[] { Integer.valueOf(paramInt1), paramString });
        b.aTX().aSL().jyN = -5;
        b.aTX().aTZ().rl(-5);
        h.qsU.idkeyStat(400L, 113L, 1L, false);
        AppMethodBeat.o(17499);
        return;
      }
    }
    Object localObject = (vd)paramString.wtb.getFirst();
    paramm = ((vd)localObject).wKH;
    paramInt1 = ((Integer)((vd)localObject).wNF.getFirst()).intValue();
    localObject = this.jEk;
    ((c)localObject).jEb = paramString.wte;
    ((c)localObject).jEc = paramm;
    ((c)localObject).jEd = paramInt1;
    ab.i("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd type:%d, scene:%d, wifiName:%s, ip:%s, port:%d", new Object[] { Integer.valueOf(paramString.jKs), Integer.valueOf(paramString.Scene), paramString.wte, paramm, Integer.valueOf(paramInt1) });
    b.aTX().jyF = paramString.ID;
    b.aTX().jyG = paramString.wtj;
    b.aTX().jyH = paramString.wtk;
    b.aTX().jyL = paramString.wsu.getBufferToBytes();
    c.b(this.jEk);
    AppMethodBeat.o(17499);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.c.1
 * JD-Core Version:    0.7.0.1
 */