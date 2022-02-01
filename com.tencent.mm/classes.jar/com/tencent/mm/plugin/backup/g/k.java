package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.backup.i.m;
import com.tencent.mm.plugin.backup.i.n;
import com.tencent.mm.plugin.backup.i.o;
import com.tencent.mm.sdk.platformtools.ad;

public final class k
  extends b
{
  private n nzW;
  public o nzX;
  
  public k(String paramString)
  {
    AppMethodBeat.i(21738);
    this.nzW = new n();
    this.nzX = new o();
    ad.i("MicroMsg.BackupStartScene", "BackupStartScene, id[%s]", new Object[] { paramString });
    this.nzW.ID = paramString;
    AppMethodBeat.o(21738);
  }
  
  public final void a(long paramLong, m paramm, int paramInt)
  {
    this.nzW.nDy = 0L;
    this.nzW.nDz = paramLong;
    this.nzW.nDA = 0L;
    this.nzW.nDB = paramm;
    this.nzW.nDC = 0L;
    this.nzW.nDD = paramInt;
  }
  
  public final a bIA()
  {
    return this.nzW;
  }
  
  public final int getType()
  {
    return 3;
  }
  
  public final void xC(int paramInt)
  {
    AppMethodBeat.i(21739);
    ad.i("MicroMsg.BackupStartScene", "onSceneEnd.");
    if (this.nzX.nDG != 0)
    {
      q(4, this.nzX.nDG, "BackupStartScene onSceneEnd failed");
      AppMethodBeat.o(21739);
      return;
    }
    q(0, this.nzX.nDG, "BackupStartScene onSceneEnd success");
    AppMethodBeat.o(21739);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.k
 * JD-Core Version:    0.7.0.1
 */