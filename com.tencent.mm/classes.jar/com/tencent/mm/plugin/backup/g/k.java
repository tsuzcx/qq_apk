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
  private n mxy;
  public o mxz;
  
  public k(String paramString)
  {
    AppMethodBeat.i(21738);
    this.mxy = new n();
    this.mxz = new o();
    ad.i("MicroMsg.BackupStartScene", "BackupStartScene, id[%s]", new Object[] { paramString });
    this.mxy.ID = paramString;
    AppMethodBeat.o(21738);
  }
  
  public final void a(long paramLong, m paramm, int paramInt)
  {
    this.mxy.mBa = 0L;
    this.mxy.mBb = paramLong;
    this.mxy.mBc = 0L;
    this.mxy.mBd = paramm;
    this.mxy.mBe = 0L;
    this.mxy.mBf = paramInt;
  }
  
  public final a bxv()
  {
    return this.mxy;
  }
  
  public final int getType()
  {
    return 3;
  }
  
  public final void wf(int paramInt)
  {
    AppMethodBeat.i(21739);
    ad.i("MicroMsg.BackupStartScene", "onSceneEnd.");
    if (this.mxz.mBi != 0)
    {
      q(4, this.mxz.mBi, "BackupStartScene onSceneEnd failed");
      AppMethodBeat.o(21739);
      return;
    }
    q(0, this.mxz.mBi, "BackupStartScene onSceneEnd success");
    AppMethodBeat.o(21739);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.k
 * JD-Core Version:    0.7.0.1
 */