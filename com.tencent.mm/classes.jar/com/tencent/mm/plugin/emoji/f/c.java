package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.hz;
import com.tencent.mm.protocal.protobuf.ia;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends q
  implements m
{
  private i callback;
  public int mWz;
  private final d rr;
  private int uFx;
  private List<String> uFy;
  
  public c(int paramInt1, int paramInt2, List<String> paramList)
  {
    AppMethodBeat.i(104566);
    d.a locala = new d.a();
    locala.lBU = new hz();
    locala.lBV = new ia();
    locala.uri = "/cgi-bin/micromsg-bin/mmbackupemojioperate";
    locala.funcId = 698;
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.rr = locala.bgN();
    this.uFx = paramInt1;
    this.mWz = paramInt2;
    this.uFy = paramList;
    AppMethodBeat.o(104566);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(104568);
    this.callback = parami;
    parami = (hz)d.b.b(this.rr.lBR);
    parami.RNt = this.mWz;
    parami.RNs = new LinkedList(this.uFy);
    parami.CNe = this.uFx;
    if ((parami.RNs != null) && (parami.RNs.size() > 0))
    {
      Log.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "do scene delte md5 list size:%s", new Object[] { Integer.valueOf(parami.RNs.size()) });
      i = 0;
    }
    while (i < parami.RNs.size())
    {
      Log.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "do scene delte md5:%s", new Object[] { parami.RNs.get(i) });
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
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VgF, Boolean.TRUE);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(164L, 7L, 1L, false);
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VgF, Boolean.FALSE);
      if ((this.mWz == 1) || (this.mWz == 4)) {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(164L, 5L, 1L, false);
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(104567);
      return;
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(164L, 8L, 1L, false);
      continue;
      if ((this.mWz == 1) || (this.mWz == 4)) {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(164L, 6L, 1L, false);
      } else {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(164L, 9L, 1L, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.c
 * JD-Core Version:    0.7.0.1
 */