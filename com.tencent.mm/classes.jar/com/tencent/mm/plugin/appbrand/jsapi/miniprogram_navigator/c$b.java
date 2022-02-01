package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface c$b
{
  public abstract void a(a parama);
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(326228);
      shX = new a("PROCEED", 0);
      shY = new a("IGNORE", 1);
      shZ = new a("CANCEL", 2);
      sia = new a[] { shX, shY, shZ };
      AppMethodBeat.o(326228);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.c.b
 * JD-Core Version:    0.7.0.1
 */