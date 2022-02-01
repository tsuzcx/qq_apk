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
      ouW = new a("COMPLETE", 0);
      ouX = new a("CONFIRM", 1);
      ouY = new a("CHANGED", 2);
      ouZ = new a[] { ouW, ouX, ouY };
      AppMethodBeat.o(131516);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.af
 * JD-Core Version:    0.7.0.1
 */