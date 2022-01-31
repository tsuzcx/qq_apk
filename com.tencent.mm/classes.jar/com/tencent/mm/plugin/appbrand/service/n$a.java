package com.tencent.mm.plugin.appbrand.service;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum n$a
{
  public final String tag;
  
  static
  {
    AppMethodBeat.i(114921);
    iJs = new a("CLICK", 0, "1");
    iJt = new a("SWIPE", 1, "2");
    iJu = new a[] { iJs, iJt };
    AppMethodBeat.o(114921);
  }
  
  private n$a(String paramString)
  {
    this.tag = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.n.a
 * JD-Core Version:    0.7.0.1
 */