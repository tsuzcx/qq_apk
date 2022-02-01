package com.google.a;

import com.google.a.b.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends i
{
  public final h<String, i> bLn;
  
  public l()
  {
    AppMethodBeat.i(108130);
    this.bLn = new h();
    AppMethodBeat.o(108130);
  }
  
  public final void a(String paramString, i parami)
  {
    AppMethodBeat.i(223536);
    Object localObject = parami;
    if (parami == null) {
      localObject = k.bLm;
    }
    this.bLn.put(paramString, localObject);
    AppMethodBeat.o(223536);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(108131);
    if ((paramObject == this) || (((paramObject instanceof l)) && (((l)paramObject).bLn.equals(this.bLn))))
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
    int i = this.bLn.hashCode();
    AppMethodBeat.o(108132);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.a.l
 * JD-Core Version:    0.7.0.1
 */