package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.hm;
import com.tencent.mm.protocal.protobuf.hn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  public int ikN;
  private int oyl;
  private List<String> oym;
  private final b rr;
  
  public c(int paramInt1, int paramInt2, List<String> paramList)
  {
    AppMethodBeat.i(104566);
    b.a locala = new b.a();
    locala.gUU = new hm();
    locala.gUV = new hn();
    locala.uri = "/cgi-bin/micromsg-bin/mmbackupemojioperate";
    locala.funcId = 698;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    this.oyl = paramInt1;
    this.ikN = paramInt2;
    this.oym = paramList;
    AppMethodBeat.o(104566);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(104568);
    this.callback = paramg;
    paramg = (hm)this.rr.gUS.gUX;
    paramg.CCB = this.ikN;
    paramg.CCA = new LinkedList(this.oym);
    paramg.CCC = this.oyl;
    if ((paramg.CCA != null) && (paramg.CCA.size() > 0))
    {
      ad.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "do scene delte md5 list size:%s", new Object[] { Integer.valueOf(paramg.CCA.size()) });
      i = 0;
    }
    while (i < paramg.CCA.size())
    {
      ad.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "do scene delte md5:%s", new Object[] { paramg.CCA.get(i) });
      i += 1;
      continue;
      ad.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "empty md5 list.");
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
    ad.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramInt3 == -434)
    {
      ad.w("MicroMsg.emoji.NetSceneBackupEmojiOperate", "[cpan] batch backup emoji failed. over size.");
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fgg, Boolean.TRUE);
      h.vKh.idkeyStat(164L, 7L, 1L, false);
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fgg, Boolean.FALSE);
      if ((this.ikN == 1) || (this.ikN == 4)) {
        h.vKh.idkeyStat(164L, 5L, 1L, false);
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(104567);
      return;
      h.vKh.idkeyStat(164L, 8L, 1L, false);
      continue;
      if ((this.ikN == 1) || (this.ikN == 4)) {
        h.vKh.idkeyStat(164L, 6L, 1L, false);
      } else {
        h.vKh.idkeyStat(164L, 9L, 1L, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.c
 * JD-Core Version:    0.7.0.1
 */