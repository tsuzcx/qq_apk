package com.tencent.mm.plugin.appbrand.app;

import com.tencent.luggage.sdk.processes.c;
import com.tencent.luggage.sdk.processes.client.LuggageClientProcessMessage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.p.a;
import com.tencent.mm.plugin.appbrand.appcache.predownload.b.j;
import com.tencent.mm.plugin.appbrand.task.d;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.plugin.appbrand.task.ipc.AppBrandNetworkChangeMessage;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

final class m$29
  extends p.a
{
  m$29(m paramm)
  {
    AppMethodBeat.i(160589);
    AppMethodBeat.o(160589);
  }
  
  public final void onNetworkChange(int paramInt)
  {
    AppMethodBeat.i(274219);
    if (MMApplicationContext.isMainProcess())
    {
      Object localObject2 = (Iterable)i.cjb().RS();
      Object localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      Object localObject3;
      label88:
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (!((d)localObject3).RK()) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt == 0) {
            break label88;
          }
          ((Collection)localObject1).add(localObject3);
          break;
        }
      }
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (d)((Iterator)localObject1).next();
        localObject3 = ((Iterable)((d)localObject2).RL()).iterator();
        while (((Iterator)localObject3).hasNext()) {
          c.a((c)localObject2, (LuggageClientProcessMessage)new AppBrandNetworkChangeMessage((String)((Iterator)localObject3).next()));
        }
      }
    }
    j.nJX.bHY();
    AppMethodBeat.o(274219);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.m.29
 * JD-Core Version:    0.7.0.1
 */