package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.hx;
import com.tencent.mm.protocal.protobuf.hy;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends n
  implements k
{
  private f callback;
  public int jgW;
  private int pLZ;
  private List<String> pMa;
  private final b rr;
  
  public c(int paramInt1, int paramInt2, List<String> paramList)
  {
    AppMethodBeat.i(104566);
    b.a locala = new b.a();
    locala.hQF = new hx();
    locala.hQG = new hy();
    locala.uri = "/cgi-bin/micromsg-bin/mmbackupemojioperate";
    locala.funcId = 698;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    this.pLZ = paramInt1;
    this.jgW = paramInt2;
    this.pMa = paramList;
    AppMethodBeat.o(104566);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(104568);
    this.callback = paramf;
    paramf = (hx)this.rr.hQD.hQJ;
    paramf.FSQ = this.jgW;
    paramf.FSP = new LinkedList(this.pMa);
    paramf.uqG = this.pLZ;
    if ((paramf.FSP != null) && (paramf.FSP.size() > 0))
    {
      ae.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "do scene delte md5 list size:%s", new Object[] { Integer.valueOf(paramf.FSP.size()) });
      i = 0;
    }
    while (i < paramf.FSP.size())
    {
      ae.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "do scene delte md5:%s", new Object[] { paramf.FSP.get(i) });
      i += 1;
      continue;
      ae.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "empty md5 list.");
    }
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(104568);
    return i;
  }
  
  public final int getType()
  {
    return 698;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(104567);
    ae.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramInt3 == -434)
    {
      ae.w("MicroMsg.emoji.NetSceneBackupEmojiOperate", "[cpan] batch backup emoji failed. over size.");
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IKJ, Boolean.TRUE);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(164L, 7L, 1L, false);
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IKJ, Boolean.FALSE);
      if ((this.jgW == 1) || (this.jgW == 4)) {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(164L, 5L, 1L, false);
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(104567);
      return;
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(164L, 8L, 1L, false);
      continue;
      if ((this.jgW == 1) || (this.jgW == 4)) {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(164L, 6L, 1L, false);
      } else {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(164L, 9L, 1L, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.c
 * JD-Core Version:    0.7.0.1
 */