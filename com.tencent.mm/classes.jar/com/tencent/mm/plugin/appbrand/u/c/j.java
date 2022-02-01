package com.tencent.mm.plugin.appbrand.u.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.appbrand.permission.a.a;
import com.tencent.mm.plugin.appbrand.permission.a.a.c;
import com.tencent.mm.plugin.appbrand.u.a.b;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class j
  extends b
{
  static void a(com.tencent.mm.plugin.appbrand.u.a.c paramc, int paramInt)
  {
    AppMethodBeat.i(147402);
    HashMap localHashMap = new HashMap();
    localHashMap.put("result", Integer.valueOf(paramInt));
    paramc.R(localHashMap);
    AppMethodBeat.o(147402);
  }
  
  public final void a(final i parami, final com.tencent.mm.plugin.appbrand.u.a.c paramc)
  {
    AppMethodBeat.i(147401);
    parami = parami.optString("apiName");
    v localv = paramc.czP;
    if (a.eU(localv.getAppId(), parami))
    {
      a(paramc, 1);
      AppMethodBeat.o(147401);
      return;
    }
    a.a(new com.tencent.mm.plugin.appbrand.permission.a.c(localv, parami, (byte)0), new a.c()
    {
      public final void akr(String paramAnonymousString)
      {
        AppMethodBeat.i(147399);
        Log.e("Luggage.NodeJS.RequireUserAuth", "onDeny apiName[%s], reason[%s]", new Object[] { parami, paramAnonymousString });
        j.a(paramc, 2);
        AppMethodBeat.o(147399);
      }
      
      public final void caY()
      {
        AppMethodBeat.i(147398);
        j.a(paramc, 1);
        AppMethodBeat.o(147398);
      }
      
      public final void onCancel()
      {
        AppMethodBeat.i(147400);
        j.a(paramc, 3);
        AppMethodBeat.o(147400);
      }
    });
    AppMethodBeat.o(147401);
  }
  
  public final int ccB()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.c.j
 * JD-Core Version:    0.7.0.1
 */