package com.tencent.mm.plugin.account.bind.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lr;
import com.tencent.mm.g.a.lr.a;
import com.tencent.mm.sdk.b.c;

public final class e
  extends c<lr>
  implements f.a
{
  private lr iiZ;
  
  public e()
  {
    AppMethodBeat.i(161741);
    this.__eventId = lr.class.getName().hashCode();
    AppMethodBeat.o(161741);
  }
  
  public final void aIq()
  {
    AppMethodBeat.i(110173);
    if ((this.iiZ != null) && (this.iiZ.dqs.dqu != null))
    {
      this.iiZ.dqt.dew = false;
      this.iiZ.dqs.dqu.run();
      this.iiZ = null;
    }
    AppMethodBeat.o(110173);
  }
  
  public final boolean dy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(110172);
    if (this.iiZ == null)
    {
      AppMethodBeat.o(110172);
      return false;
    }
    if (this.iiZ.dqs.dqu == null)
    {
      this.iiZ = null;
      AppMethodBeat.o(110172);
      return false;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.iiZ.dqt.dew = true;
      this.iiZ.dqs.dqu.run();
      this.iiZ = null;
      AppMethodBeat.o(110172);
      return true;
    }
    this.iiZ.dqt.dew = false;
    this.iiZ.dqs.dqu.run();
    this.iiZ = null;
    AppMethodBeat.o(110172);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.e
 * JD-Core Version:    0.7.0.1
 */