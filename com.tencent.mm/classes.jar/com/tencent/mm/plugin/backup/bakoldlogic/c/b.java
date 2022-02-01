package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.backup.i.ab;
import com.tencent.mm.plugin.backup.i.ac;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends com.tencent.mm.plugin.backup.g.b
{
  private ab rUn;
  private ac rUo;
  
  public b(int paramInt)
  {
    AppMethodBeat.i(21938);
    this.rUn = new ab();
    this.rUo = new ac();
    this.rUn.rVj = paramInt;
    AppMethodBeat.o(21938);
  }
  
  public final void EN(int paramInt)
  {
    AppMethodBeat.i(21939);
    if (this.rUo.rVU == 0)
    {
      r(0, 0, "ok");
      AppMethodBeat.o(21939);
      return;
    }
    Log.e("MicroMsg.BakSceneCommand", " type:%d  errCode:%d", new Object[] { Integer.valueOf(this.rUn.rVj), Integer.valueOf(this.rUo.rVU) });
    r(4, this.rUo.rVU, "fail");
    AppMethodBeat.o(21939);
  }
  
  public final a ctC()
  {
    return this.rUo;
  }
  
  public final a ctD()
  {
    return this.rUn;
  }
  
  public final int getType()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.c.b
 * JD-Core Version:    0.7.0.1
 */