package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.backup.i.ab;
import com.tencent.mm.plugin.backup.i.ac;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  extends com.tencent.mm.plugin.backup.g.b
{
  private ab mzy;
  private ac mzz;
  
  public b(int paramInt)
  {
    AppMethodBeat.i(21938);
    this.mzy = new ab();
    this.mzz = new ac();
    this.mzy.mAw = paramInt;
    AppMethodBeat.o(21938);
  }
  
  public final a bxu()
  {
    return this.mzz;
  }
  
  public final a bxv()
  {
    return this.mzy;
  }
  
  public final int getType()
  {
    return 3;
  }
  
  public final void wf(int paramInt)
  {
    AppMethodBeat.i(21939);
    if (this.mzz.mBi == 0)
    {
      q(0, 0, "ok");
      AppMethodBeat.o(21939);
      return;
    }
    ad.e("MicroMsg.BakSceneCommand", " type:%d  errCode:%d", new Object[] { Integer.valueOf(this.mzy.mAw), Integer.valueOf(this.mzz.mBi) });
    q(4, this.mzz.mBi, "fail");
    AppMethodBeat.o(21939);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.c.b
 * JD-Core Version:    0.7.0.1
 */