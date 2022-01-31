package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.gp;
import com.tencent.mm.protocal.protobuf.gq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends m
  implements k
{
  private f callback;
  public int gxQ;
  private int lii;
  private List<String> lij;
  public final b rr;
  
  public c(int paramInt1, int paramInt2, List<String> paramList)
  {
    AppMethodBeat.i(53096);
    b.a locala = new b.a();
    locala.fsX = new gp();
    locala.fsY = new gq();
    locala.uri = "/cgi-bin/micromsg-bin/mmbackupemojioperate";
    locala.funcId = 698;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    this.lii = paramInt1;
    this.gxQ = paramInt2;
    this.lij = paramList;
    AppMethodBeat.o(53096);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(53098);
    this.callback = paramf;
    paramf = (gp)this.rr.fsV.fta;
    paramf.wsW = this.gxQ;
    paramf.wsV = new LinkedList(this.lij);
    paramf.wsX = this.lii;
    if ((paramf.wsV != null) && (paramf.wsV.size() > 0))
    {
      ab.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "do scene delte md5 list size:%s", new Object[] { Integer.valueOf(paramf.wsV.size()) });
      i = 0;
    }
    while (i < paramf.wsV.size())
    {
      ab.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "do scene delte md5:%s", new Object[] { paramf.wsV.get(i) });
      i += 1;
      continue;
      ab.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "empty md5 list.");
    }
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(53098);
    return i;
  }
  
  public final int getType()
  {
    return 698;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(53097);
    ab.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramInt3 == -434)
    {
      ab.w("MicroMsg.emoji.NetSceneBackupEmojiOperate", "[cpan] batch backup emoji failed. over size.");
      g.RL().Ru().set(ac.a.yxM, Boolean.TRUE);
      h.qsU.idkeyStat(164L, 7L, 1L, false);
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      g.RL().Ru().set(ac.a.yxM, Boolean.FALSE);
      if ((this.gxQ == 1) || (this.gxQ == 4)) {
        h.qsU.idkeyStat(164L, 5L, 1L, false);
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(53097);
      return;
      h.qsU.idkeyStat(164L, 8L, 1L, false);
      continue;
      if ((this.gxQ == 1) || (this.gxQ == 4)) {
        h.qsU.idkeyStat(164L, 6L, 1L, false);
      } else {
        h.qsU.idkeyStat(164L, 9L, 1L, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.c
 * JD-Core Version:    0.7.0.1
 */