package com.google.c;

import com.google.c.b.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends i
{
  public final h<String, i> dEV;
  
  public l()
  {
    AppMethodBeat.i(108130);
    this.dEV = new h();
    AppMethodBeat.o(108130);
  }
  
  public final void a(String paramString, i parami)
  {
    AppMethodBeat.i(208786);
    Object localObject = parami;
    if (parami == null) {
      localObject = k.dEU;
    }
    this.dEV.put(paramString, localObject);
    AppMethodBeat.o(208786);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(108131);
    if ((paramObject == this) || (((paramObject instanceof l)) && (((l)paramObject).dEV.equals(this.dEV))))
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
    int i = this.dEV.hashCode();
    AppMethodBeat.o(108132);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.c.l
 * JD-Core Version:    0.7.0.1
 */