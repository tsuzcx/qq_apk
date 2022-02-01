package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface aj
{
  public abstract void a(String paramString, int paramInt, a parama);
  
  public abstract void f(String paramString1, int paramInt, String paramString2, String paramString3);
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(131516);
      rxy = new a("COMPLETE", 0);
      rxz = new a("CONFIRM", 1);
      rxA = new a("CHANGED", 2);
      rxB = new a[] { rxy, rxz, rxA };
      AppMethodBeat.o(131516);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.aj
 * JD-Core Version:    0.7.0.1
 */