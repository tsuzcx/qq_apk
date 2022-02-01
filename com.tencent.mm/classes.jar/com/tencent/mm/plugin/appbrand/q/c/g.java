package com.tencent.mm.plugin.appbrand.q.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.plugin.appbrand.permission.d;
import com.tencent.mm.plugin.appbrand.permission.d.c;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.q.a.b;
import com.tencent.mm.plugin.appbrand.q.a.c;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.Map;

public final class g
  extends b
{
  static void a(c paramc, int paramInt)
  {
    AppMethodBeat.i(147402);
    HashMap localHashMap = new HashMap();
    localHashMap.put("result", Integer.valueOf(paramInt));
    paramc.O(localHashMap);
    AppMethodBeat.o(147402);
  }
  
  public final void a(final i parami, final c paramc)
  {
    AppMethodBeat.i(147401);
    parami = parami.optString("apiName");
    q localq = paramc.ceh;
    if (d.ea(localq.getAppId(), parami))
    {
      a(paramc, 1);
      AppMethodBeat.o(147401);
      return;
    }
    d.a(localq, parami, new d.c()
    {
      public final void Pt(String paramAnonymousString)
      {
        AppMethodBeat.i(147399);
        ac.e("Luggage.NodeJS.RequireUserAuth", "onDeny apiName[%s], reason[%s]", new Object[] { parami, paramAnonymousString });
        g.a(paramc, 2);
        AppMethodBeat.o(147399);
      }
      
      public final void bpF()
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
  
  public final int bpA()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.c.g
 * JD-Core Version:    0.7.0.1
 */