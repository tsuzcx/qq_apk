package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.backup.i.ab;
import com.tencent.mm.plugin.backup.i.ac;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
  extends com.tencent.mm.plugin.backup.g.b
{
  private ab nHr;
  private ac nHs;
  
  public b(int paramInt)
  {
    AppMethodBeat.i(21938);
    this.nHr = new ab();
    this.nHs = new ac();
    this.nHr.nIp = paramInt;
    AppMethodBeat.o(21938);
  }
  
  public final a bJx()
  {
    return this.nHs;
  }
  
  public final a bJy()
  {
    return this.nHr;
  }
  
  public final int getType()
  {
    return 3;
  }
  
  public final void xG(int paramInt)
  {
    AppMethodBeat.i(21939);
    if (this.nHs.nJb == 0)
    {
      q(0, 0, "ok");
      AppMethodBeat.o(21939);
      return;
    }
    ae.e("MicroMsg.BakSceneCommand", " type:%d  errCode:%d", new Object[] { Integer.valueOf(this.nHr.nIp), Integer.valueOf(this.nHs.nJb) });
    q(4, this.nHs.nJb, "fail");
    AppMethodBeat.o(21939);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.c.b
 * JD-Core Version:    0.7.0.1
 */