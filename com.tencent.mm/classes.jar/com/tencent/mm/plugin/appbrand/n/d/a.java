package com.tencent.mm.plugin.appbrand.n.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.n.a.e;
import com.tencent.mm.plugin.appbrand.n.a.e.a;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.s.a;
import com.tencent.mm.plugin.appbrand.s.b;

public final class a
  extends e
{
  private s.b iur;
  
  public a(e.a parama, r paramr)
  {
    super(parama, paramr);
  }
  
  public final void aIC()
  {
    AppMethodBeat.i(102205);
    this.iur = new a.1(this);
    s.a.gRL.a(this.bEw, this.iur);
    AppMethodBeat.o(102205);
  }
  
  public final int getType()
  {
    return 1;
  }
  
  public final void removeListener()
  {
    AppMethodBeat.i(102206);
    s.a.gRL.b(this.bEw, this.iur);
    AppMethodBeat.o(102206);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.d.a
 * JD-Core Version:    0.7.0.1
 */