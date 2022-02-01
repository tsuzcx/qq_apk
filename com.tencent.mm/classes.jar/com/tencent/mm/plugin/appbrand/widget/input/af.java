package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface af
{
  public abstract void a(String paramString, int paramInt, a parama);
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(131516);
      nlp = new a("COMPLETE", 0);
      nlq = new a("CONFIRM", 1);
      nlr = new a("CHANGED", 2);
      nls = new a[] { nlp, nlq, nlr };
      AppMethodBeat.o(131516);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.af
 * JD-Core Version:    0.7.0.1
 */