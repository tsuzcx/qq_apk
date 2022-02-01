package com.tencent.mm.plugin.account.bind.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mk;
import com.tencent.mm.g.a.mk.a;
import com.tencent.mm.sdk.b.c;

public final class e
  extends c<mk>
  implements f.a
{
  private mk jfi;
  
  public e()
  {
    AppMethodBeat.i(161741);
    this.__eventId = mk.class.getName().hashCode();
    AppMethodBeat.o(161741);
  }
  
  public final void aSS()
  {
    AppMethodBeat.i(110173);
    if ((this.jfi != null) && (this.jfi.dAW.dAY != null))
    {
      this.jfi.dAX.doq = false;
      this.jfi.dAW.dAY.run();
      this.jfi = null;
    }
    AppMethodBeat.o(110173);
  }
  
  public final boolean dA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(110172);
    if (this.jfi == null)
    {
      AppMethodBeat.o(110172);
      return false;
    }
    if (this.jfi.dAW.dAY == null)
    {
      this.jfi = null;
      AppMethodBeat.o(110172);
      return false;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.jfi.dAX.doq = true;
      this.jfi.dAW.dAY.run();
      this.jfi = null;
      AppMethodBeat.o(110172);
      return true;
    }
    this.jfi.dAX.doq = false;
    this.jfi.dAW.dAY.run();
    this.jfi = null;
    AppMethodBeat.o(110172);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.e
 * JD-Core Version:    0.7.0.1
 */