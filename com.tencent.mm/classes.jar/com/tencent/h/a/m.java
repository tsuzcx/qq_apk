package com.tencent.h.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
{
  private a ZSl;
  
  private m(a parama)
  {
    this.ZSl = parama;
  }
  
  public final j itF()
  {
    if (this.ZSl != null) {
      return this.ZSl.ZSm;
    }
    return null;
  }
  
  public static final class a
  {
    public j ZSm;
    
    public final m itG()
    {
      AppMethodBeat.i(207652);
      if (this.ZSm == null)
      {
        localObject = new IllegalArgumentException("You're trying to build a TuringSMIJob with no TuringShieldConfigs, this is not allowed.");
        AppMethodBeat.o(207652);
        throw ((Throwable)localObject);
      }
      Object localObject = new m(this, (byte)0);
      AppMethodBeat.o(207652);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.h.a.m
 * JD-Core Version:    0.7.0.1
 */