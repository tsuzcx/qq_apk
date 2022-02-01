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
      mHp = new a("CANCEL", 0);
      mHq = new a("DELETE", 1);
      mHr = new a("SELECT", 2);
      mHs = new a[] { mHp, mHq, mHr };
      AppMethodBeat.o(136675);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.h
 * JD-Core Version:    0.7.0.1
 */