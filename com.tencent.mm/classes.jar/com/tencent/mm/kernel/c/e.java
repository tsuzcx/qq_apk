package com.tencent.mm.kernel.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e<T extends a>
  implements b, c<T>
{
  private T gGS;
  
  public e(T paramT)
  {
    this.gGS = paramT;
  }
  
  public final void akM()
  {
    AppMethodBeat.i(157490);
    if ((this.gGS instanceof b)) {
      ((b)this.gGS).akM();
    }
    AppMethodBeat.o(157490);
  }
  
  public final void akN()
  {
    AppMethodBeat.i(157491);
    if ((this.gGS instanceof b)) {
      ((b)this.gGS).akN();
    }
    AppMethodBeat.o(157491);
  }
  
  public final T akO()
  {
    return this.gGS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.c.e
 * JD-Core Version:    0.7.0.1
 */