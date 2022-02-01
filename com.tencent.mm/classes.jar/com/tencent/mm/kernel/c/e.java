package com.tencent.mm.kernel.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e<T extends a>
  implements b, c<T>
{
  private T htG;
  
  public e(T paramT)
  {
    this.htG = paramT;
  }
  
  public final void aBc()
  {
    AppMethodBeat.i(157490);
    if ((this.htG instanceof b)) {
      ((b)this.htG).aBc();
    }
    AppMethodBeat.o(157490);
  }
  
  public final void aBd()
  {
    AppMethodBeat.i(157491);
    if ((this.htG instanceof b)) {
      ((b)this.htG).aBd();
    }
    AppMethodBeat.o(157491);
  }
  
  public final T aBe()
  {
    return this.htG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.c.e
 * JD-Core Version:    0.7.0.1
 */