package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.backup.i.ab;
import com.tencent.mm.plugin.backup.i.ac;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends com.tencent.mm.plugin.backup.g.b
{
  private ab vfC;
  private ac vfD;
  
  public b(int paramInt)
  {
    AppMethodBeat.i(21938);
    this.vfC = new ab();
    this.vfD = new ac();
    this.vfC.vgz = paramInt;
    AppMethodBeat.o(21938);
  }
  
  public final void Fo(int paramInt)
  {
    AppMethodBeat.i(21939);
    if (this.vfD.vhk == 0)
    {
      u(0, 0, "ok");
      AppMethodBeat.o(21939);
      return;
    }
    Log.e("MicroMsg.BakSceneCommand", " type:%d  errCode:%d", new Object[] { Integer.valueOf(this.vfC.vgz), Integer.valueOf(this.vfD.vhk) });
    u(4, this.vfD.vhk, "fail");
    AppMethodBeat.o(21939);
  }
  
  public final a cWm()
  {
    return this.vfD;
  }
  
  public final a cWn()
  {
    return this.vfC;
  }
  
  public final int getType()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.c.b
 * JD-Core Version:    0.7.0.1
 */