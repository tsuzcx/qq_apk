package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.j.a;

public final class o$d
{
  static o b(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(131818);
    if (j.a.nk(paramInt1))
    {
      paramString1 = new w(paramString1, paramString2, paramInt2, paramInt3);
      AppMethodBeat.o(131818);
      return paramString1;
    }
    paramString1 = new x(paramString1, paramString2, paramInt1, paramInt3);
    AppMethodBeat.o(131818);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.o.d
 * JD-Core Version:    0.7.0.1
 */