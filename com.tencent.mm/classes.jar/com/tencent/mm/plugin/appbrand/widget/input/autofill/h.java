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
      uKz = new a("CANCEL", 0);
      uKA = new a("DELETE", 1);
      uKB = new a("SELECT", 2);
      uKC = new a[] { uKz, uKA, uKB };
      AppMethodBeat.o(136675);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.h
 * JD-Core Version:    0.7.0.1
 */