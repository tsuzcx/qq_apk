package com.tencent.mm.plugin.account.bind.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nb;
import com.tencent.mm.g.a.nb.a;
import com.tencent.mm.sdk.event.IListener;

public final class e
  extends IListener<nb>
  implements f.a
{
  private nb kdl;
  
  public e()
  {
    AppMethodBeat.i(161741);
    this.__eventId = nb.class.getName().hashCode();
    AppMethodBeat.o(161741);
  }
  
  public final void bnF()
  {
    AppMethodBeat.i(110173);
    if ((this.kdl != null) && (this.kdl.dSL.dSN != null))
    {
      this.kdl.dSM.dFE = false;
      this.kdl.dSL.dSN.run();
      this.kdl = null;
    }
    AppMethodBeat.o(110173);
  }
  
  public final boolean dI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(110172);
    if (this.kdl == null)
    {
      AppMethodBeat.o(110172);
      return false;
    }
    if (this.kdl.dSL.dSN == null)
    {
      this.kdl = null;
      AppMethodBeat.o(110172);
      return false;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.kdl.dSM.dFE = true;
      this.kdl.dSL.dSN.run();
      this.kdl = null;
      AppMethodBeat.o(110172);
      return true;
    }
    this.kdl.dSM.dFE = false;
    this.kdl.dSL.dSN.run();
    this.kdl = null;
    AppMethodBeat.o(110172);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.e
 * JD-Core Version:    0.7.0.1
 */