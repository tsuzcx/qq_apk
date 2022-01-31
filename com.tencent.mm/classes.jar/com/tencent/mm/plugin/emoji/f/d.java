package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.fg;
import com.tencent.mm.protocal.c.fh;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends m
  implements k
{
  public final b dmK;
  private f dmL;
  public int fgi;
  private List<String> iZu;
  
  public d(int paramInt, List<String> paramList)
  {
    b.a locala = new b.a();
    locala.ecH = new fg();
    locala.ecI = new fh();
    locala.uri = "/cgi-bin/micromsg-bin/mmbackupemojioperate";
    locala.ecG = 698;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    this.fgi = paramInt;
    this.iZu = paramList;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    paramf = (fg)this.dmK.ecE.ecN;
    paramf.syV = this.fgi;
    paramf.syU = new LinkedList(this.iZu);
    int i;
    if ((paramf.syU != null) && (paramf.syU.size() > 0))
    {
      y.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "do scene delte md5 list size:%s", new Object[] { Integer.valueOf(paramf.syU.size()) });
      i = 0;
    }
    while (i < paramf.syU.size())
    {
      y.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "do scene delte md5:%s", new Object[] { paramf.syU.get(i) });
      i += 1;
      continue;
      y.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "empty md5 list.");
    }
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramInt3 == -434)
    {
      y.w("MicroMsg.emoji.NetSceneBackupEmojiOperate", "[cpan] batch backup emoji failed. over size.");
      g.DP().Dz().c(ac.a.unV, Boolean.valueOf(true));
      h.nFQ.a(164L, 7L, 1L, false);
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      g.DP().Dz().c(ac.a.unV, Boolean.valueOf(false));
      if ((this.fgi == 1) || (this.fgi == 4)) {
        h.nFQ.a(164L, 5L, 1L, false);
      }
    }
    for (;;)
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      h.nFQ.a(164L, 8L, 1L, false);
      continue;
      if ((this.fgi == 1) || (this.fgi == 4)) {
        h.nFQ.a(164L, 6L, 1L, false);
      } else {
        h.nFQ.a(164L, 9L, 1L, false);
      }
    }
  }
  
  public final int getType()
  {
    return 698;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.d
 * JD-Core Version:    0.7.0.1
 */