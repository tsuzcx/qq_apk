package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.backup.i.ab;

public final class b
  extends com.tencent.mm.plugin.backup.g.b
{
  private com.tencent.mm.plugin.backup.i.ac nbA;
  private ab nbz;
  
  public b(int paramInt)
  {
    AppMethodBeat.i(21938);
    this.nbz = new ab();
    this.nbA = new com.tencent.mm.plugin.backup.i.ac();
    this.nbz.ncx = paramInt;
    AppMethodBeat.o(21938);
  }
  
  public final a bEq()
  {
    return this.nbA;
  }
  
  public final a bEr()
  {
    return this.nbz;
  }
  
  public final int getType()
  {
    return 3;
  }
  
  public final void wW(int paramInt)
  {
    AppMethodBeat.i(21939);
    if (this.nbA.ndj == 0)
    {
      q(0, 0, "ok");
      AppMethodBeat.o(21939);
      return;
    }
    com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.BakSceneCommand", " type:%d  errCode:%d", new Object[] { Integer.valueOf(this.nbz.ncx), Integer.valueOf(this.nbA.ndj) });
    q(4, this.nbA.ndj, "fail");
    AppMethodBeat.o(21939);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.c.b
 * JD-Core Version:    0.7.0.1
 */