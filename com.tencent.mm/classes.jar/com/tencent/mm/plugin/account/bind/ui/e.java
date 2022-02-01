package com.tencent.mm.plugin.account.bind.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.g.a.ma.a;
import com.tencent.mm.sdk.b.c;

public final class e
  extends c<ma>
  implements f.a
{
  private ma iJg;
  
  public e()
  {
    AppMethodBeat.i(161741);
    this.__eventId = ma.class.getName().hashCode();
    AppMethodBeat.o(161741);
  }
  
  public final void aPh()
  {
    AppMethodBeat.i(110173);
    if ((this.iJg != null) && (this.iJg.dod.dof != null))
    {
      this.iJg.doe.dbS = false;
      this.iJg.dod.dof.run();
      this.iJg = null;
    }
    AppMethodBeat.o(110173);
  }
  
  public final boolean dy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(110172);
    if (this.iJg == null)
    {
      AppMethodBeat.o(110172);
      return false;
    }
    if (this.iJg.dod.dof == null)
    {
      this.iJg = null;
      AppMethodBeat.o(110172);
      return false;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.iJg.doe.dbS = true;
      this.iJg.dod.dof.run();
      this.iJg = null;
      AppMethodBeat.o(110172);
      return true;
    }
    this.iJg.doe.dbS = false;
    this.iJg.dod.dof.run();
    this.iJg = null;
    AppMethodBeat.o(110172);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.e
 * JD-Core Version:    0.7.0.1
 */