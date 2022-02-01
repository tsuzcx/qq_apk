package com.tencent.mm.plugin.account.bind.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mj;
import com.tencent.mm.g.a.mj.a;
import com.tencent.mm.sdk.b.c;

public final class e
  extends c<mj>
  implements f.a
{
  private mj jcp;
  
  public e()
  {
    AppMethodBeat.i(161741);
    this.__eventId = mj.class.getName().hashCode();
    AppMethodBeat.o(161741);
  }
  
  public final void aSt()
  {
    AppMethodBeat.i(110173);
    if ((this.jcp != null) && (this.jcp.dzR.dzT != null))
    {
      this.jcp.dzS.dno = false;
      this.jcp.dzR.dzT.run();
      this.jcp = null;
    }
    AppMethodBeat.o(110173);
  }
  
  public final boolean dA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(110172);
    if (this.jcp == null)
    {
      AppMethodBeat.o(110172);
      return false;
    }
    if (this.jcp.dzR.dzT == null)
    {
      this.jcp = null;
      AppMethodBeat.o(110172);
      return false;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.jcp.dzS.dno = true;
      this.jcp.dzR.dzT.run();
      this.jcp = null;
      AppMethodBeat.o(110172);
      return true;
    }
    this.jcp.dzS.dno = false;
    this.jcp.dzR.dzT.run();
    this.jcp = null;
    AppMethodBeat.o(110172);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.e
 * JD-Core Version:    0.7.0.1
 */