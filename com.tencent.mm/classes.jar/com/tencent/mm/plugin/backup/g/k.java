package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.backup.i.m;
import com.tencent.mm.plugin.backup.i.n;
import com.tencent.mm.plugin.backup.i.o;
import com.tencent.mm.sdk.platformtools.Log;

public final class k
  extends b
{
  private n rSl;
  public o rSm;
  
  public k(String paramString)
  {
    AppMethodBeat.i(21738);
    this.rSl = new n();
    this.rSm = new o();
    Log.i("MicroMsg.BackupStartScene", "BackupStartScene, id[%s]", new Object[] { paramString });
    this.rSl.ID = paramString;
    AppMethodBeat.o(21738);
  }
  
  public final void EN(int paramInt)
  {
    AppMethodBeat.i(21739);
    Log.i("MicroMsg.BackupStartScene", "onSceneEnd.");
    if (this.rSm.rVU != 0)
    {
      r(4, this.rSm.rVU, "BackupStartScene onSceneEnd failed");
      AppMethodBeat.o(21739);
      return;
    }
    r(0, this.rSm.rVU, "BackupStartScene onSceneEnd success");
    AppMethodBeat.o(21739);
  }
  
  public final void a(long paramLong, m paramm, int paramInt)
  {
    this.rSl.rVM = 0L;
    this.rSl.rVN = paramLong;
    this.rSl.rVO = 0L;
    this.rSl.rVP = paramm;
    this.rSl.rVQ = 0L;
    this.rSl.rVR = paramInt;
  }
  
  public final a ctD()
  {
    return this.rSl;
  }
  
  public final int getType()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.k
 * JD-Core Version:    0.7.0.1
 */