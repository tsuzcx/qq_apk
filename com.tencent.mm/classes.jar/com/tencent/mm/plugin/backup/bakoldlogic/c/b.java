package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.backup.i.ab;
import com.tencent.mm.plugin.backup.i.ac;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends com.tencent.mm.plugin.backup.g.b
{
  private ab oSo;
  private ac oSp;
  
  public b(int paramInt)
  {
    AppMethodBeat.i(21938);
    this.oSo = new ab();
    this.oSp = new ac();
    this.oSo.oTl = paramInt;
    AppMethodBeat.o(21938);
  }
  
  public final void Bm(int paramInt)
  {
    AppMethodBeat.i(21939);
    if (this.oSp.oTW == 0)
    {
      q(0, 0, "ok");
      AppMethodBeat.o(21939);
      return;
    }
    Log.e("MicroMsg.BakSceneCommand", " type:%d  errCode:%d", new Object[] { Integer.valueOf(this.oSo.oTl), Integer.valueOf(this.oSp.oTW) });
    q(4, this.oSp.oTW, "fail");
    AppMethodBeat.o(21939);
  }
  
  public final a cgq()
  {
    return this.oSp;
  }
  
  public final a cgr()
  {
    return this.oSo;
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