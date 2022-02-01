package com.tencent.mm.plugin.appbrand.jsapi.ac.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.b.c;
import com.tencent.mm.sdk.platformtools.ax;
import d.a.j;
import d.g.a.a;
import d.g.b.q;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"isRecentDevice", "", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "saveDevice", "", "luggage-xweb-ext_release"})
public final class k
{
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(c paramc, ax paramax) {}
    
    public final void run()
    {
      String str = null;
      AppMethodBeat.i(139810);
      Object localObject1 = this.ghQ.getStringSet("VideoCastDeviceManager.saveDevice", null);
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = j.s((Collection)localObject1);
        localObject2 = this.lAY.bfn();
        if (localObject2 == null) {
          break label84;
        }
        localObject2 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject2).kcS;
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          if (((List)localObject1).contains(localObject2))
          {
            this.ghQ.putLong((String)localObject2, System.currentTimeMillis());
            AppMethodBeat.o(139810);
            return;
            localObject1 = null;
            break;
            label84:
            localObject2 = null;
            continue;
          }
          if (((List)localObject1).size() >= this.lAZ) {
            new q((List)localObject1)
            {
              public final void invoke()
              {
                AppMethodBeat.i(139809);
                Object localObject = (Iterable)this.lBb;
                Collection localCollection = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
                localObject = ((Iterable)localObject).iterator();
                while (((Iterator)localObject).hasNext())
                {
                  String str = (String)((Iterator)localObject).next();
                  localCollection.add(Long.valueOf(this.lBa.ghQ.getLong(str, 0L)));
                }
                j.j((Iterable)localCollection);
                this.lBa.ghQ.removeValueForKey((String)this.lBb.get(0));
                this.lBb.set(0, this.lBc);
                this.lBa.ghQ.putLong(this.lBc, System.currentTimeMillis());
                AppMethodBeat.o(139809);
              }
            }.invoke();
          }
          com.tencent.mm.plugin.appbrand.g.b.b localb = this.lAY.bfn();
          if (localb != null) {
            str = localb.kcS;
          }
          ((List)localObject1).add(str);
          this.ghQ.putStringSet("VideoCastDeviceManager.saveDevice", j.n((Iterable)localObject1));
          this.ghQ.putLong((String)localObject2, System.currentTimeMillis());
          AppMethodBeat.o(139810);
          return;
        }
      }
      localObject1 = new android.support.v4.e.b();
      ((android.support.v4.e.b)localObject1).add(localObject2);
      this.ghQ.putStringSet("VideoCastDeviceManager.saveDevice", (Set)localObject1);
      this.ghQ.putLong((String)localObject2, System.currentTimeMillis());
      AppMethodBeat.o(139810);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.e.a.k
 * JD-Core Version:    0.7.0.1
 */