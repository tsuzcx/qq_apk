package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ik;
import com.tencent.mm.protocal.protobuf.il;
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
  public int kfa;
  private int rcs;
  private List<String> rct;
  private final d rr;
  
  public c(int paramInt1, int paramInt2, List<String> paramList)
  {
    AppMethodBeat.i(104566);
    d.a locala = new d.a();
    locala.iLN = new ik();
    locala.iLO = new il();
    locala.uri = "/cgi-bin/micromsg-bin/mmbackupemojioperate";
    locala.funcId = 698;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    this.rcs = paramInt1;
    this.kfa = paramInt2;
    this.rct = paramList;
    AppMethodBeat.o(104566);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(104568);
    this.callback = parami;
    parami = (ik)this.rr.iLK.iLR;
    parami.KMz = this.kfa;
    parami.KMy = new LinkedList(this.rct);
    parami.xIY = this.rcs;
    if ((parami.KMy != null) && (parami.KMy.size() > 0))
    {
      Log.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "do scene delte md5 list size:%s", new Object[] { Integer.valueOf(parami.KMy.size()) });
      i = 0;
    }
    while (i < parami.KMy.size())
    {
      Log.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "do scene delte md5:%s", new Object[] { parami.KMy.get(i) });
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
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NSH, Boolean.TRUE);
      h.CyF.idkeyStat(164L, 7L, 1L, false);
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NSH, Boolean.FALSE);
      if ((this.kfa == 1) || (this.kfa == 4)) {
        h.CyF.idkeyStat(164L, 5L, 1L, false);
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(104567);
      return;
      h.CyF.idkeyStat(164L, 8L, 1L, false);
      continue;
      if ((this.kfa == 1) || (this.kfa == 4)) {
        h.CyF.idkeyStat(164L, 6L, 1L, false);
      } else {
        h.CyF.idkeyStat(164L, 9L, 1L, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.c
 * JD-Core Version:    0.7.0.1
 */