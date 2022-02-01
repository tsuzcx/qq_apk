package com.tencent.mm.kernel.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e<T extends a>
  implements b, c<T>
{
  private T gfV;
  
  public e(T paramT)
  {
    this.gfV = paramT;
  }
  
  public final void agv()
  {
    AppMethodBeat.i(157490);
    if ((this.gfV instanceof b)) {
      ((b)this.gfV).agv();
    }
    AppMethodBeat.o(157490);
  }
  
  public final void agw()
  {
    AppMethodBeat.i(157491);
    if ((this.gfV instanceof b)) {
      ((b)this.gfV).agw();
    }
    AppMethodBeat.o(157491);
  }
  
  public final T agx()
  {
    return this.gfV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.c.e
 * JD-Core Version:    0.7.0.1
 */