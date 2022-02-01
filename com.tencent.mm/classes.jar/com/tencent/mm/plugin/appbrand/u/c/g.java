package com.tencent.mm.plugin.appbrand.u.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.plugin.appbrand.permission.a.a;
import com.tencent.mm.plugin.appbrand.permission.a.a.c;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.u.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class g
  extends b
{
  static void a(com.tencent.mm.plugin.appbrand.u.a.c paramc, int paramInt)
  {
    AppMethodBeat.i(147402);
    HashMap localHashMap = new HashMap();
    localHashMap.put("result", Integer.valueOf(paramInt));
    paramc.Y(localHashMap);
    AppMethodBeat.o(147402);
  }
  
  public final void a(final i parami, final com.tencent.mm.plugin.appbrand.u.a.c paramc)
  {
    AppMethodBeat.i(147401);
    parami = parami.optString("apiName");
    s locals = paramc.cAJ;
    if (a.eG(locals.getAppId(), parami))
    {
      a(paramc, 1);
      AppMethodBeat.o(147401);
      return;
    }
    a.a(new com.tencent.mm.plugin.appbrand.permission.a.c(locals, parami, (byte)0), new a.c()
    {
      public final void acx(String paramAnonymousString)
      {
        AppMethodBeat.i(147399);
        Log.e("Luggage.NodeJS.RequireUserAuth", "onDeny apiName[%s], reason[%s]", new Object[] { parami, paramAnonymousString });
        g.a(paramc, 2);
        AppMethodBeat.o(147399);
      }
      
      public final void bOI()
      {
        AppMethodBeat.i(147398);
        g.a(paramc, 1);
        AppMethodBeat.o(147398);
      }
      
      public final void onCancel()
      {
        AppMethodBeat.i(147400);
        g.a(paramc, 3);
        AppMethodBeat.o(147400);
      }
    });
    AppMethodBeat.o(147401);
  }
  
  public final int bPT()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.c.g
 * JD-Core Version:    0.7.0.1
 */