package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import com.tencent.matrix.trace.core.AppMethodBeat;

abstract interface h
{
  public abstract void a(String paramString, a parama);
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(136675);
      owC = new a("CANCEL", 0);
      owD = new a("DELETE", 1);
      owE = new a("SELECT", 2);
      owF = new a[] { owC, owD, owE };
      AppMethodBeat.o(136675);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.h
 * JD-Core Version:    0.7.0.1
 */