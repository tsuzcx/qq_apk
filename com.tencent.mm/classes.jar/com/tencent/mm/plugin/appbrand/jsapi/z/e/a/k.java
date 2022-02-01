package com.tencent.mm.plugin.appbrand.jsapi.z.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.b.c;
import com.tencent.mm.sdk.platformtools.aw;
import d.a.j;
import d.g.a.a;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"isRecentDevice", "", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "saveDevice", "", "luggage-xweb-ext_release"})
public final class k
{
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(c paramc, aw paramaw) {}
    
    public final void run()
    {
      String str = null;
      AppMethodBeat.i(139810);
      Object localObject1 = this.fOq.getStringSet("VideoCastDeviceManager.saveDevice", null);
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = j.r((Collection)localObject1);
        localObject2 = this.ldY.bbJ();
        if (localObject2 == null) {
          break label84;
        }
        localObject2 = ((com.tencent.mm.plugin.appbrand.h.b.b)localObject2).jIG;
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          if (((List)localObject1).contains(localObject2))
          {
            this.fOq.putLong((String)localObject2, System.currentTimeMillis());
            AppMethodBeat.o(139810);
            return;
            localObject1 = null;
            break;
            label84:
            localObject2 = null;
            continue;
          }
          if (((List)localObject1).size() >= this.ldZ) {
            new d.g.b.l((List)localObject1)
            {
              public final void invoke()
              {
                AppMethodBeat.i(139809);
                Object localObject = (Iterable)this.leb;
                Collection localCollection = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
                localObject = ((Iterable)localObject).iterator();
                while (((Iterator)localObject).hasNext())
                {
                  String str = (String)((Iterator)localObject).next();
                  localCollection.add(Long.valueOf(this.lea.fOq.getLong(str, 0L)));
                }
                j.j((Iterable)localCollection);
                this.lea.fOq.removeValueForKey((String)this.leb.get(0));
                this.leb.set(0, this.lec);
                this.lea.fOq.putLong(this.lec, System.currentTimeMillis());
                AppMethodBeat.o(139809);
              }
            }.invoke();
          }
          com.tencent.mm.plugin.appbrand.h.b.b localb = this.ldY.bbJ();
          if (localb != null) {
            str = localb.jIG;
          }
          ((List)localObject1).add(str);
          this.fOq.putStringSet("VideoCastDeviceManager.saveDevice", j.n((Iterable)localObject1));
          this.fOq.putLong((String)localObject2, System.currentTimeMillis());
          AppMethodBeat.o(139810);
          return;
        }
      }
      localObject1 = new android.support.v4.e.b();
      ((android.support.v4.e.b)localObject1).add(localObject2);
      this.fOq.putStringSet("VideoCastDeviceManager.saveDevice", (Set)localObject1);
      this.fOq.putLong((String)localObject2, System.currentTimeMillis());
      AppMethodBeat.o(139810);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.e.a.k
 * JD-Core Version:    0.7.0.1
 */