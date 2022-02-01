package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.t;

public final class b
  extends a<ah>
{
  public static boolean g(ad paramad)
  {
    AppMethodBeat.i(242646);
    Object localObject = (t)paramad.getRuntime();
    if (((t)localObject).Qv())
    {
      AppMethodBeat.o(242646);
      return false;
    }
    localObject = ((t)localObject).getAppConfig().bKX();
    boolean bool = paramad.qoI.startsWith((String)localObject);
    AppMethodBeat.o(242646);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.b
 * JD-Core Version:    0.7.0.1
 */