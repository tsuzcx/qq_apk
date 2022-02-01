package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.backup.i.m;
import com.tencent.mm.plugin.backup.i.n;
import com.tencent.mm.plugin.backup.i.o;
import com.tencent.mm.sdk.platformtools.ae;

public final class k
  extends b
{
  private n nFr;
  public o nFs;
  
  public k(String paramString)
  {
    AppMethodBeat.i(21738);
    this.nFr = new n();
    this.nFs = new o();
    ae.i("MicroMsg.BackupStartScene", "BackupStartScene, id[%s]", new Object[] { paramString });
    this.nFr.ID = paramString;
    AppMethodBeat.o(21738);
  }
  
  public final void a(long paramLong, m paramm, int paramInt)
  {
    this.nFr.nIT = 0L;
    this.nFr.nIU = paramLong;
    this.nFr.nIV = 0L;
    this.nFr.nIW = paramm;
    this.nFr.nIX = 0L;
    this.nFr.nIY = paramInt;
  }
  
  public final a bJy()
  {
    return this.nFr;
  }
  
  public final int getType()
  {
    return 3;
  }
  
  public final void xG(int paramInt)
  {
    AppMethodBeat.i(21739);
    ae.i("MicroMsg.BackupStartScene", "onSceneEnd.");
    if (this.nFs.nJb != 0)
    {
      q(4, this.nFs.nJb, "BackupStartScene onSceneEnd failed");
      AppMethodBeat.o(21739);
      return;
    }
    q(0, this.nFs.nJb, "BackupStartScene onSceneEnd success");
    AppMethodBeat.o(21739);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.k
 * JD-Core Version:    0.7.0.1
 */