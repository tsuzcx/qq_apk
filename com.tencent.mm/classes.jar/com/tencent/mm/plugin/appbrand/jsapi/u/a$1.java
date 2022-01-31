package com.tencent.mm.plugin.appbrand.jsapi.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.u.c;

final class a$1
  implements u.c
{
  private int bEm = 0;
  
  a$1(a parama) {}
  
  public final void bc(boolean paramBoolean)
  {
    AppMethodBeat.i(131631);
    a.a(this.igQ).m(paramBoolean, this.bEm);
    AppMethodBeat.o(131631);
  }
  
  public final void fu(int paramInt)
  {
    this.bEm = paramInt;
  }
  
  public final int getHeight()
  {
    return this.bEm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.a.1
 * JD-Core Version:    0.7.0.1
 */