package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.backup.i.ac;
import com.tencent.mm.plugin.backup.i.r;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

final class f$2
  implements com.tencent.mm.ai.f
{
  f$2(f paramf) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(17863);
    paramString = (ac)((com.tencent.mm.plugin.backup.g.b)paramm).aUl();
    if (paramString.jJg != 2)
    {
      AppMethodBeat.o(17863);
      return;
    }
    paramString = paramString.jKM;
    this.jHZ.jHT.addAll(paramString.jKk);
    this.jHZ.jHS.addAll(paramString.jKj);
    ab.i("MicroMsg.RecoverPCServer", "MediaSize:[%d / %d], digestSize: [%d / %d]", new Object[] { Integer.valueOf(this.jHZ.jHT.size()), Integer.valueOf(this.jHZ.jHS.size()), Integer.valueOf(paramString.jJW), Integer.valueOf(paramString.jJV) });
    if ((this.jHZ.jHT.size() < paramString.jJW) || (this.jHZ.jHS.size() < paramString.jJV))
    {
      ab.i("MicroMsg.RecoverPCServer", "send restore info cmd again~");
      new com.tencent.mm.plugin.backup.bakoldlogic.c.b(2).aUv();
      AppMethodBeat.o(17863);
      return;
    }
    this.jHZ.jHW = paramString.jJR;
    ab.i("MicroMsg.RecoverPCServer", "down RestoreInfo complete, convDataSize:%d", new Object[] { Long.valueOf(this.jHZ.jHW) });
    com.tencent.mm.plugin.backup.g.b.b(3, this);
    d.post(new f.2.1(this), "RecoverPCServer_recover_getIDList");
    AppMethodBeat.o(17863);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f.2
 * JD-Core Version:    0.7.0.1
 */