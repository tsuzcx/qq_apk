package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.backup.i.m;
import com.tencent.mm.plugin.backup.i.n;
import com.tencent.mm.plugin.backup.i.o;
import com.tencent.mm.sdk.platformtools.ab;

public final class k
  extends b
{
  private n jGf;
  public o jGg;
  
  public k(String paramString)
  {
    AppMethodBeat.i(17679);
    this.jGf = new n();
    this.jGg = new o();
    ab.i("MicroMsg.BackupStartScene", "BackupStartScene, id[%s]", new Object[] { paramString });
    this.jGf.ID = paramString;
    AppMethodBeat.o(17679);
  }
  
  public final void a(long paramLong, m paramm, int paramInt)
  {
    this.jGf.jJK = 0L;
    this.jGf.jJL = paramLong;
    this.jGf.jJM = 0L;
    this.jGf.jJN = paramm;
    this.jGf.jJO = 0L;
    this.jGf.jJP = paramInt;
  }
  
  public final a aUm()
  {
    return this.jGf;
  }
  
  public final int getType()
  {
    return 3;
  }
  
  public final void rt(int paramInt)
  {
    AppMethodBeat.i(17680);
    ab.i("MicroMsg.BackupStartScene", "onSceneEnd.");
    if (this.jGg.jJS != 0)
    {
      n(4, this.jGg.jJS, "BackupStartScene onSceneEnd failed");
      AppMethodBeat.o(17680);
      return;
    }
    n(0, this.jGg.jJS, "BackupStartScene onSceneEnd success");
    AppMethodBeat.o(17680);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.k
 * JD-Core Version:    0.7.0.1
 */