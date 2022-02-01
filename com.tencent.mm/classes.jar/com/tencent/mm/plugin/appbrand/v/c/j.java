package com.tencent.mm.plugin.appbrand.v.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.appbrand.permission.a.a;
import com.tencent.mm.plugin.appbrand.permission.a.a.d;
import com.tencent.mm.plugin.appbrand.v.a.b;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class j
  extends b
{
  static void a(com.tencent.mm.plugin.appbrand.v.a.c paramc, int paramInt)
  {
    AppMethodBeat.i(147402);
    HashMap localHashMap = new HashMap();
    localHashMap.put("result", Integer.valueOf(paramInt));
    paramc.Y(localHashMap);
    AppMethodBeat.o(147402);
  }
  
  public final void a(final i parami, final com.tencent.mm.plugin.appbrand.v.a.c paramc)
  {
    AppMethodBeat.i(147401);
    parami = parami.optString("apiName");
    y localy = paramc.esk;
    if (a.fl(localy.getAppId(), parami))
    {
      a(paramc, 1);
      AppMethodBeat.o(147401);
      return;
    }
    a.a(new com.tencent.mm.plugin.appbrand.permission.a.c(localy, parami, (byte)0), new a.d()
    {
      public final void adx(String paramAnonymousString)
      {
        AppMethodBeat.i(147399);
        Log.e("Luggage.NodeJS.RequireUserAuth", "onDeny apiName[%s], reason[%s]", new Object[] { parami, paramAnonymousString });
        j.a(paramc, 2);
        AppMethodBeat.o(147399);
      }
      
      public final void bSs()
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
  
  public final int cCX()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.c.j
 * JD-Core Version:    0.7.0.1
 */