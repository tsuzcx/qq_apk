package com.tencent.mm.plugin.account.bind.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.km;
import com.tencent.mm.g.a.km.a;
import com.tencent.mm.sdk.b.c;

public final class e
  extends c<km>
  implements f.a
{
  private km gwc;
  
  public e()
  {
    AppMethodBeat.i(13746);
    this.__eventId = km.class.getName().hashCode();
    AppMethodBeat.o(13746);
  }
  
  public final void apU()
  {
    AppMethodBeat.i(13748);
    if ((this.gwc != null) && (this.gwc.cAj.cAl != null))
    {
      this.gwc.cAk.cpz = false;
      this.gwc.cAj.cAl.run();
      this.gwc = null;
    }
    AppMethodBeat.o(13748);
  }
  
  public final boolean cQ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(13747);
    if (this.gwc == null)
    {
      AppMethodBeat.o(13747);
      return false;
    }
    if (this.gwc.cAj.cAl == null)
    {
      this.gwc = null;
      AppMethodBeat.o(13747);
      return false;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.gwc.cAk.cpz = true;
      this.gwc.cAj.cAl.run();
      this.gwc = null;
      AppMethodBeat.o(13747);
      return true;
    }
    this.gwc.cAk.cpz = false;
    this.gwc.cAj.cAl.run();
    this.gwc = null;
    AppMethodBeat.o(13747);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.e
 * JD-Core Version:    0.7.0.1
 */