package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.q;

public final class b
  extends a<ag>
{
  public static boolean g(ac paramac)
  {
    AppMethodBeat.i(227149);
    Object localObject = (q)paramac.getRuntime();
    if (((q)localObject).NA())
    {
      AppMethodBeat.o(227149);
      return false;
    }
    localObject = ((q)localObject).getAppConfig().bzI();
    boolean bool = paramac.nna.startsWith((String)localObject);
    AppMethodBeat.o(227149);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.b
 * JD-Core Version:    0.7.0.1
 */