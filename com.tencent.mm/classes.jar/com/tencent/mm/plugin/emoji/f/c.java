package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.hq;
import com.tencent.mm.protocal.protobuf.hr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  public int iKU;
  private int pbL;
  private List<String> pbM;
  private final b rr;
  
  public c(int paramInt1, int paramInt2, List<String> paramList)
  {
    AppMethodBeat.i(104566);
    b.a locala = new b.a();
    locala.hvt = new hq();
    locala.hvu = new hr();
    locala.uri = "/cgi-bin/micromsg-bin/mmbackupemojioperate";
    locala.funcId = 698;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    this.pbL = paramInt1;
    this.iKU = paramInt2;
    this.pbM = paramList;
    AppMethodBeat.o(104566);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(104568);
    this.callback = paramg;
    paramg = (hq)this.rr.hvr.hvw;
    paramg.DUY = this.iKU;
    paramg.DUX = new LinkedList(this.pbM);
    paramg.DUZ = this.pbL;
    if ((paramg.DUX != null) && (paramg.DUX.size() > 0))
    {
      ac.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "do scene delte md5 list size:%s", new Object[] { Integer.valueOf(paramg.DUX.size()) });
      i = 0;
    }
    while (i < paramg.DUX.size())
    {
      ac.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "do scene delte md5:%s", new Object[] { paramg.DUX.get(i) });
      i += 1;
      continue;
      ac.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "empty md5 list.");
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
    ac.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramInt3 == -434)
    {
      ac.w("MicroMsg.emoji.NetSceneBackupEmojiOperate", "[cpan] batch backup emoji failed. over size.");
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GDU, Boolean.TRUE);
      h.wUl.idkeyStat(164L, 7L, 1L, false);
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GDU, Boolean.FALSE);
      if ((this.iKU == 1) || (this.iKU == 4)) {
        h.wUl.idkeyStat(164L, 5L, 1L, false);
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(104567);
      return;
      h.wUl.idkeyStat(164L, 8L, 1L, false);
      continue;
      if ((this.iKU == 1) || (this.iKU == 4)) {
        h.wUl.idkeyStat(164L, 6L, 1L, false);
      } else {
        h.wUl.idkeyStat(164L, 9L, 1L, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.c
 * JD-Core Version:    0.7.0.1
 */