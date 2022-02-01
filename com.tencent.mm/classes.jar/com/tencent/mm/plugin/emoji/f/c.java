package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.hx;
import com.tencent.mm.protocal.protobuf.hy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends n
  implements k
{
  private f callback;
  public int jed;
  private int pFv;
  private List<String> pFw;
  private final b rr;
  
  public c(int paramInt1, int paramInt2, List<String> paramList)
  {
    AppMethodBeat.i(104566);
    b.a locala = new b.a();
    locala.hNM = new hx();
    locala.hNN = new hy();
    locala.uri = "/cgi-bin/micromsg-bin/mmbackupemojioperate";
    locala.funcId = 698;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    this.pFv = paramInt1;
    this.jed = paramInt2;
    this.pFw = paramList;
    AppMethodBeat.o(104566);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(104568);
    this.callback = paramf;
    paramf = (hx)this.rr.hNK.hNQ;
    paramf.FAt = this.jed;
    paramf.FAs = new LinkedList(this.pFw);
    paramf.FAu = this.pFv;
    if ((paramf.FAs != null) && (paramf.FAs.size() > 0))
    {
      ad.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "do scene delte md5 list size:%s", new Object[] { Integer.valueOf(paramf.FAs.size()) });
      i = 0;
    }
    while (i < paramf.FAs.size())
    {
      ad.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "do scene delte md5:%s", new Object[] { paramf.FAs.get(i) });
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
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Iqn, Boolean.TRUE);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(164L, 7L, 1L, false);
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Iqn, Boolean.FALSE);
      if ((this.jed == 1) || (this.jed == 4)) {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(164L, 5L, 1L, false);
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(104567);
      return;
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(164L, 8L, 1L, false);
      continue;
      if ((this.jed == 1) || (this.jed == 4)) {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(164L, 6L, 1L, false);
      } else {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(164L, 9L, 1L, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.c
 * JD-Core Version:    0.7.0.1
 */