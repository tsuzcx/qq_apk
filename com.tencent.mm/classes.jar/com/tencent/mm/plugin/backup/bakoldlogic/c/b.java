package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.backup.i.ab;
import com.tencent.mm.plugin.backup.i.ac;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  extends com.tencent.mm.plugin.backup.g.b
{
  private ab nBW;
  private ac nBX;
  
  public b(int paramInt)
  {
    AppMethodBeat.i(21938);
    this.nBW = new ab();
    this.nBX = new ac();
    this.nBW.nCU = paramInt;
    AppMethodBeat.o(21938);
  }
  
  public final a bIA()
  {
    return this.nBW;
  }
  
  public final a bIz()
  {
    return this.nBX;
  }
  
  public final int getType()
  {
    return 3;
  }
  
  public final void xC(int paramInt)
  {
    AppMethodBeat.i(21939);
    if (this.nBX.nDG == 0)
    {
      q(0, 0, "ok");
      AppMethodBeat.o(21939);
      return;
    }
    ad.e("MicroMsg.BakSceneCommand", " type:%d  errCode:%d", new Object[] { Integer.valueOf(this.nBW.nCU), Integer.valueOf(this.nBX.nDG) });
    q(4, this.nBX.nDG, "fail");
    AppMethodBeat.o(21939);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.c.b
 * JD-Core Version:    0.7.0.1
 */