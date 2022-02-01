package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.w;

public final class b
  extends a<ah>
{
  public static boolean g(ad paramad)
  {
    AppMethodBeat.i(323819);
    Object localObject = (w)paramad.getRuntime();
    if (((w)localObject).aqJ())
    {
      AppMethodBeat.o(323819);
      return false;
    }
    localObject = ((w)localObject).getAppConfig().ckv();
    boolean bool = paramad.cEE().startsWith((String)localObject);
    AppMethodBeat.o(323819);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.b
 * JD-Core Version:    0.7.0.1
 */