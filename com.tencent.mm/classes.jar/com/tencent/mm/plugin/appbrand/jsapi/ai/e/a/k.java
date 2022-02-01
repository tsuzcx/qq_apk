package com.tencent.mm.plugin.appbrand.jsapi.ai.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.b.c;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.a.j;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"isRecentDevice", "", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "saveDevice", "", "luggage-xweb-ext_release"})
public final class k
{
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(c paramc, MultiProcessMMKV paramMultiProcessMMKV) {}
    
    public final void run()
    {
      String str = null;
      AppMethodBeat.i(139810);
      Object localObject1 = this.jFm.getStringSet("VideoCastDeviceManager.saveDevice", null);
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = j.t((Collection)localObject1);
        localObject2 = this.pNX.bMJ();
        if (localObject2 == null) {
          break label84;
        }
        localObject2 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject2).oeD;
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          if (((List)localObject1).contains(localObject2))
          {
            this.jFm.putLong((String)localObject2, System.currentTimeMillis());
            AppMethodBeat.o(139810);
            return;
            localObject1 = null;
            break;
            label84:
            localObject2 = null;
            continue;
          }
          if (((List)localObject1).size() >= this.pNY) {
            new q((List)localObject1)
            {
              public final void invoke()
              {
                AppMethodBeat.i(139809);
                Object localObject = (Iterable)this.pOa;
                Collection localCollection = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
                localObject = ((Iterable)localObject).iterator();
                while (((Iterator)localObject).hasNext())
                {
                  String str = (String)((Iterator)localObject).next();
                  localCollection.add(Long.valueOf(this.pNZ.jFm.getLong(str, 0L)));
                }
                j.n((Iterable)localCollection);
                this.pNZ.jFm.removeValueForKey((String)this.pOa.get(0));
                this.pOa.set(0, this.pOb);
                this.pNZ.jFm.putLong(this.pOb, System.currentTimeMillis());
                AppMethodBeat.o(139809);
              }
            }.invoke();
          }
          com.tencent.mm.plugin.appbrand.g.b.b localb = this.pNX.bMJ();
          if (localb != null) {
            str = localb.oeD;
          }
          ((List)localObject1).add(str);
          this.jFm.putStringSet("VideoCastDeviceManager.saveDevice", j.r((Iterable)localObject1));
          this.jFm.putLong((String)localObject2, System.currentTimeMillis());
          AppMethodBeat.o(139810);
          return;
        }
      }
      localObject1 = new androidx.b.b();
      ((androidx.b.b)localObject1).add(localObject2);
      this.jFm.putStringSet("VideoCastDeviceManager.saveDevice", (Set)localObject1);
      this.jFm.putLong((String)localObject2, System.currentTimeMillis());
      AppMethodBeat.o(139810);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai.e.a.k
 * JD-Core Version:    0.7.0.1
 */