package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.backup.i.ac;
import com.tencent.mm.plugin.backup.i.r;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class f$2
  implements com.tencent.mm.ah.f
{
  f$2(f paramf) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    paramString = (ac)((com.tencent.mm.plugin.backup.g.b)paramm).auJ();
    if (paramString.hPE != 2) {
      return;
    }
    paramString = paramString.hRl;
    this.hOx.hOr.addAll(paramString.hQI);
    this.hOx.hOq.addAll(paramString.hQH);
    y.i("MicroMsg.RecoverPCServer", "MediaSize:[%d / %d], digestSize: [%d / %d]", new Object[] { Integer.valueOf(this.hOx.hOr.size()), Integer.valueOf(this.hOx.hOq.size()), Integer.valueOf(paramString.hQu), Integer.valueOf(paramString.hQt) });
    if ((this.hOx.hOr.size() < paramString.hQu) || (this.hOx.hOq.size() < paramString.hQt))
    {
      y.i("MicroMsg.RecoverPCServer", "send restore info cmd again~");
      new com.tencent.mm.plugin.backup.bakoldlogic.c.b(2).auT();
      return;
    }
    this.hOx.hOu = paramString.hQp;
    y.i("MicroMsg.RecoverPCServer", "down RestoreInfo complete, convDataSize:%d", new Object[] { Long.valueOf(this.hOx.hOu) });
    com.tencent.mm.plugin.backup.g.b.b(3, this);
    e.post(new f.2.1(this), "RecoverPCServer_recover_getIDList");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f.2
 * JD-Core Version:    0.7.0.1
 */