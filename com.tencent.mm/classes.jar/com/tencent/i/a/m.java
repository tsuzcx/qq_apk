package com.tencent.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
{
  private a SqI;
  
  private m(a parama)
  {
    this.SqI = parama;
  }
  
  public final j hqa()
  {
    if (this.SqI != null) {
      return this.SqI.SqJ;
    }
    return null;
  }
  
  public static final class a
  {
    public j SqJ;
    
    public final m hqb()
    {
      AppMethodBeat.i(214678);
      if (this.SqJ == null)
      {
        localObject = new IllegalArgumentException("You're trying to build a TuringSMIJob with no TuringShieldConfigs, this is not allowed.");
        AppMethodBeat.o(214678);
        throw ((Throwable)localObject);
      }
      Object localObject = new m(this, (byte)0);
      AppMethodBeat.o(214678);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.i.a.m
 * JD-Core Version:    0.7.0.1
 */