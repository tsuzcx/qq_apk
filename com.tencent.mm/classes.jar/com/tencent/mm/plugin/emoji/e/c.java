package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.iv;
import com.tencent.mm.protocal.protobuf.iw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  public int pTf;
  private final com.tencent.mm.am.c rr;
  private int xNZ;
  private List<String> xOa;
  
  public c(int paramInt1, int paramInt2, List<String> paramList)
  {
    AppMethodBeat.i(104566);
    c.a locala = new c.a();
    locala.otE = new iv();
    locala.otF = new iw();
    locala.uri = "/cgi-bin/micromsg-bin/mmbackupemojioperate";
    locala.funcId = 698;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    this.xNZ = paramInt1;
    this.pTf = paramInt2;
    this.xOa = paramList;
    AppMethodBeat.o(104566);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(104568);
    this.callback = paramh;
    paramh = (iv)c.b.b(this.rr.otB);
    paramh.YKH = this.pTf;
    paramh.YKG = new LinkedList(this.xOa);
    paramh.IHj = this.xNZ;
    if ((paramh.YKG != null) && (paramh.YKG.size() > 0))
    {
      Log.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "do scene delte md5 list size:%s", new Object[] { Integer.valueOf(paramh.YKG.size()) });
      i = 0;
    }
    while (i < paramh.YKG.size())
    {
      Log.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "do scene delte md5:%s", new Object[] { paramh.YKG.get(i) });
      i += 1;
      continue;
      Log.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "empty md5 list.");
    }
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(104568);
    return i;
  }
  
  public final int getType()
  {
    return 698;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(104567);
    Log.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramInt3 == -434)
    {
      Log.w("MicroMsg.emoji.NetSceneBackupEmojiOperate", "[cpan] batch backup emoji failed. over size.");
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acHU, Boolean.TRUE);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(164L, 7L, 1L, false);
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acHU, Boolean.FALSE);
      if ((this.pTf == 1) || (this.pTf == 4)) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(164L, 5L, 1L, false);
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(104567);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(164L, 8L, 1L, false);
      continue;
      if ((this.pTf == 1) || (this.pTf == 4)) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(164L, 6L, 1L, false);
      } else {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(164L, 9L, 1L, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.c
 * JD-Core Version:    0.7.0.1
 */