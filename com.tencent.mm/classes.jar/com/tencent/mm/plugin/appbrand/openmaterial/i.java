package com.tencent.mm.plugin.appbrand.openmaterial;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.e.a;

public abstract interface i
  extends a
{
  public static final i tru = new i()
  {
    public final void a(i.a paramAnonymousa) {}
    
    public final void dead() {}
  };
  
  public abstract void a(a parama);
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(323560);
      trv = new a("ENABLE", 0);
      trw = new a("DISABLE", 1);
      trx = new a("HIDE", 2);
      try = new a[] { trv, trw, trx };
      AppMethodBeat.o(323560);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.i
 * JD-Core Version:    0.7.0.1
 */