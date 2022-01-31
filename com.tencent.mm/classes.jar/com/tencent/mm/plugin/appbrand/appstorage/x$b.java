package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;

public enum x$b
  implements com.tencent.mm.plugin.appbrand.appstorage.a.a
{
  static
  {
    AppMethodBeat.i(129530);
    haG = new b("INSTANCE");
    haH = new b[] { haG };
    AppMethodBeat.o(129530);
  }
  
  private x$b() {}
  
  public final int zt(String paramString)
  {
    AppMethodBeat.i(129529);
    g.RJ();
    int i = com.tencent.mm.kernel.a.getUin();
    AppMethodBeat.o(129529);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.x.b
 * JD-Core Version:    0.7.0.1
 */