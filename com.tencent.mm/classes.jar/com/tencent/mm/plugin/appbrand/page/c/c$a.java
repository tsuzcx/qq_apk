package com.tencent.mm.plugin.appbrand.page.c;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.v;

public final class c$a
{
  public static c m(v paramv)
  {
    AppMethodBeat.i(87373);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramv = new a(paramv);
      AppMethodBeat.o(87373);
      return paramv;
    }
    paramv = new b(paramv);
    AppMethodBeat.o(87373);
    return paramv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.c.c.a
 * JD-Core Version:    0.7.0.1
 */