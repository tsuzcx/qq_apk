package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.backup.i.m;
import com.tencent.mm.plugin.backup.i.n;
import com.tencent.mm.plugin.backup.i.o;
import com.tencent.mm.sdk.platformtools.Log;

public final class k
  extends b
{
  private n oQo;
  public o oQp;
  
  public k(String paramString)
  {
    AppMethodBeat.i(21738);
    this.oQo = new n();
    this.oQp = new o();
    Log.i("MicroMsg.BackupStartScene", "BackupStartScene, id[%s]", new Object[] { paramString });
    this.oQo.ID = paramString;
    AppMethodBeat.o(21738);
  }
  
  public final void Bm(int paramInt)
  {
    AppMethodBeat.i(21739);
    Log.i("MicroMsg.BackupStartScene", "onSceneEnd.");
    if (this.oQp.oTW != 0)
    {
      q(4, this.oQp.oTW, "BackupStartScene onSceneEnd failed");
      AppMethodBeat.o(21739);
      return;
    }
    q(0, this.oQp.oTW, "BackupStartScene onSceneEnd success");
    AppMethodBeat.o(21739);
  }
  
  public final void a(long paramLong, m paramm, int paramInt)
  {
    this.oQo.oTO = 0L;
    this.oQo.oTP = paramLong;
    this.oQo.oTQ = 0L;
    this.oQo.oTR = paramm;
    this.oQo.oTS = 0L;
    this.oQo.oTT = paramInt;
  }
  
  public final a cgr()
  {
    return this.oQo;
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