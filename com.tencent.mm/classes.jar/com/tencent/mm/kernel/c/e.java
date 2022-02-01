package com.tencent.mm.kernel.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e<T extends a>
  implements b, c<T>
{
  private T gEl;
  
  public e(T paramT)
  {
    this.gEl = paramT;
  }
  
  public final void akx()
  {
    AppMethodBeat.i(157490);
    if ((this.gEl instanceof b)) {
      ((b)this.gEl).akx();
    }
    AppMethodBeat.o(157490);
  }
  
  public final void aky()
  {
    AppMethodBeat.i(157491);
    if ((this.gEl instanceof b)) {
      ((b)this.gEl).aky();
    }
    AppMethodBeat.o(157491);
  }
  
  public final T akz()
  {
    return this.gEl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.c.e
 * JD-Core Version:    0.7.0.1
 */