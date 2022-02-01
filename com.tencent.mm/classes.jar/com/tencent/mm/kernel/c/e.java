package com.tencent.mm.kernel.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e<T extends a>
  implements b, c<T>
{
  private T kfD;
  
  public e(T paramT)
  {
    this.kfD = paramT;
  }
  
  public final void aIF()
  {
    AppMethodBeat.i(157490);
    if ((this.kfD instanceof b)) {
      ((b)this.kfD).aIF();
    }
    AppMethodBeat.o(157490);
  }
  
  public final void aIG()
  {
    AppMethodBeat.i(157491);
    if ((this.kfD instanceof b)) {
      ((b)this.kfD).aIG();
    }
    AppMethodBeat.o(157491);
  }
  
  public final T aIH()
  {
    return this.kfD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.kernel.c.e
 * JD-Core Version:    0.7.0.1
 */