package com.tencent.h.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
{
  private a ahWI;
  
  private m(a parama)
  {
    this.ahWI = parama;
  }
  
  public final j kda()
  {
    if (this.ahWI != null) {
      return this.ahWI.ahWJ;
    }
    return null;
  }
  
  public static final class a
  {
    public j ahWJ;
    
    public final m kdb()
    {
      AppMethodBeat.i(212067);
      if (this.ahWJ == null)
      {
        localObject = new IllegalArgumentException("You're trying to build a TuringSMIJob with no TuringShieldConfigs, this is not allowed.");
        AppMethodBeat.o(212067);
        throw ((Throwable)localObject);
      }
      Object localObject = new m(this, (byte)0);
      AppMethodBeat.o(212067);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.h.a.m
 * JD-Core Version:    0.7.0.1
 */