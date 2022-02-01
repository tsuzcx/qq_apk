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
      nmV = new a("CANCEL", 0);
      nmW = new a("DELETE", 1);
      nmX = new a("SELECT", 2);
      nmY = new a[] { nmV, nmW, nmX };
      AppMethodBeat.o(136675);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.h
 * JD-Core Version:    0.7.0.1
 */