package com.tencent.mm.plugin.aa.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.c.b;

public final class j
  implements b<i>
{
  protected i gnV;
  public final j.b gnW;
  public final j.a gnX;
  
  public j()
  {
    this(new i());
    AppMethodBeat.i(40630);
    AppMethodBeat.o(40630);
  }
  
  private j(i parami)
  {
    AppMethodBeat.i(40631);
    this.gnW = new j.b(this);
    this.gnX = new j.a(this);
    this.gnV = parami;
    AppMethodBeat.o(40631);
  }
  
  public final i aoS()
  {
    return this.gnV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.a.j
 * JD-Core Version:    0.7.0.1
 */