package com.tencent.mm.kernel.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e<T extends a>
  implements b, c<T>
{
  private T eKN;
  
  public e(T paramT)
  {
    this.eKN = paramT;
  }
  
  public final T SE()
  {
    return this.eKN;
  }
  
  public final void xM()
  {
    AppMethodBeat.i(51937);
    if ((this.eKN instanceof b)) {
      ((b)this.eKN).xM();
    }
    AppMethodBeat.o(51937);
  }
  
  public final void xN()
  {
    AppMethodBeat.i(51938);
    if ((this.eKN instanceof b)) {
      ((b)this.eKN).xN();
    }
    AppMethodBeat.o(51938);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.c.e
 * JD-Core Version:    0.7.0.1
 */