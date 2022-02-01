package com.google.a;

import com.google.a.b.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends k
{
  public final g<String, k> bDj;
  
  public n()
  {
    AppMethodBeat.i(108130);
    this.bDj = new g();
    AppMethodBeat.o(108130);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(108131);
    if ((paramObject == this) || (((paramObject instanceof n)) && (((n)paramObject).bDj.equals(this.bDj))))
    {
      AppMethodBeat.o(108131);
      return true;
    }
    AppMethodBeat.o(108131);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(108132);
    int i = this.bDj.hashCode();
    AppMethodBeat.o(108132);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.a.n
 * JD-Core Version:    0.7.0.1
 */