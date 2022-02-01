package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.backup.i.m;
import com.tencent.mm.plugin.backup.i.n;
import com.tencent.mm.plugin.backup.i.o;
import com.tencent.mm.sdk.platformtools.Log;

public final class k
  extends b
{
  private n vdB;
  public o vdC;
  
  public k(String paramString)
  {
    AppMethodBeat.i(21738);
    this.vdB = new n();
    this.vdC = new o();
    Log.i("MicroMsg.BackupStartScene", "BackupStartScene, id[%s]", new Object[] { paramString });
    this.vdB.vgy = paramString;
    AppMethodBeat.o(21738);
  }
  
  public final void Fo(int paramInt)
  {
    AppMethodBeat.i(21739);
    Log.i("MicroMsg.BackupStartScene", "onSceneEnd.");
    if (this.vdC.vhk != 0)
    {
      u(4, this.vdC.vhk, "BackupStartScene onSceneEnd failed");
      AppMethodBeat.o(21739);
      return;
    }
    u(0, this.vdC.vhk, "BackupStartScene onSceneEnd success");
    AppMethodBeat.o(21739);
  }
  
  public final void a(long paramLong, m paramm, int paramInt)
  {
    this.vdB.vhc = 0L;
    this.vdB.vhd = paramLong;
    this.vdB.vhe = 0L;
    this.vdB.vhf = paramm;
    this.vdB.vhg = 0L;
    this.vdB.vhh = paramInt;
  }
  
  public final a cWn()
  {
    return this.vdB;
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