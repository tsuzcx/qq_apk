package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.backup.i.m;
import com.tencent.mm.plugin.backup.i.n;
import com.tencent.mm.plugin.backup.i.o;
import com.tencent.mm.sdk.platformtools.ac;

public final class k
  extends b
{
  public o mZA;
  private n mZz;
  
  public k(String paramString)
  {
    AppMethodBeat.i(21738);
    this.mZz = new n();
    this.mZA = new o();
    ac.i("MicroMsg.BackupStartScene", "BackupStartScene, id[%s]", new Object[] { paramString });
    this.mZz.ID = paramString;
    AppMethodBeat.o(21738);
  }
  
  public final void a(long paramLong, m paramm, int paramInt)
  {
    this.mZz.ndb = 0L;
    this.mZz.ndc = paramLong;
    this.mZz.ndd = 0L;
    this.mZz.nde = paramm;
    this.mZz.ndf = 0L;
    this.mZz.ndg = paramInt;
  }
  
  public final a bEr()
  {
    return this.mZz;
  }
  
  public final int getType()
  {
    return 3;
  }
  
  public final void wW(int paramInt)
  {
    AppMethodBeat.i(21739);
    ac.i("MicroMsg.BackupStartScene", "onSceneEnd.");
    if (this.mZA.ndj != 0)
    {
      q(4, this.mZA.ndj, "BackupStartScene onSceneEnd failed");
      AppMethodBeat.o(21739);
      return;
    }
    q(0, this.mZA.ndj, "BackupStartScene onSceneEnd success");
    AppMethodBeat.o(21739);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.k
 * JD-Core Version:    0.7.0.1
 */