package com.tencent.mm.kernel.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e<T extends a>
  implements b, c<T>
{
  private T mGb;
  
  public e(T paramT)
  {
    this.mGb = paramT;
  }
  
  public final void bbB()
  {
    AppMethodBeat.i(157490);
    if ((this.mGb instanceof b)) {
      ((b)this.mGb).bbB();
    }
    AppMethodBeat.o(157490);
  }
  
  public final void bbC()
  {
    AppMethodBeat.i(157491);
    if ((this.mGb instanceof b)) {
      ((b)this.mGb).bbC();
    }
    AppMethodBeat.o(157491);
  }
  
  public final T bbD()
  {
    return this.mGb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.kernel.c.e
 * JD-Core Version:    0.7.0.1
 */