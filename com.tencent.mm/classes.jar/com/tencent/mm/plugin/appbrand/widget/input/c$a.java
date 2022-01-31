package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.widget.input.d.e;

public enum c$a
{
  public static c a(String paramString, v paramv, e parame)
  {
    AppMethodBeat.i(123581);
    if (("digit".equalsIgnoreCase(paramString)) || ("idcard".equalsIgnoreCase(paramString)) || ("number".equalsIgnoreCase(paramString)))
    {
      paramString = new d(paramString, paramv, parame);
      AppMethodBeat.o(123581);
      return paramString;
    }
    AppMethodBeat.o(123581);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.c.a
 * JD-Core Version:    0.7.0.1
 */