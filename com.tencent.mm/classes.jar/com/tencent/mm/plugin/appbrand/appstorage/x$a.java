package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.o;

public enum x$a
  implements com.tencent.mm.plugin.appbrand.appstorage.a.a
{
  static
  {
    AppMethodBeat.i(129526);
    haE = new a("INSTANCE");
    haF = new a[] { haE };
    AppMethodBeat.o(129526);
  }
  
  private x$a() {}
  
  public final int zt(String paramString)
  {
    AppMethodBeat.i(129525);
    paramString = com.tencent.mm.plugin.appbrand.a.xL(paramString);
    if ((paramString == null) || (paramString.atS() == null))
    {
      AppMethodBeat.o(129525);
      return 0;
    }
    int i = paramString.atS().uin;
    AppMethodBeat.o(129525);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.x.a
 * JD-Core Version:    0.7.0.1
 */