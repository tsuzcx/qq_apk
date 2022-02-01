package com.tencent.mm.kernel.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e<T extends a>
  implements b, c<T>
{
  private T gkB;
  
  public e(T paramT)
  {
    this.gkB = paramT;
  }
  
  public final void ahM()
  {
    AppMethodBeat.i(157490);
    if ((this.gkB instanceof b)) {
      ((b)this.gkB).ahM();
    }
    AppMethodBeat.o(157490);
  }
  
  public final void ahN()
  {
    AppMethodBeat.i(157491);
    if ((this.gkB instanceof b)) {
      ((b)this.gkB).ahN();
    }
    AppMethodBeat.o(157491);
  }
  
  public final T ahO()
  {
    return this.gkB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.c.e
 * JD-Core Version:    0.7.0.1
 */