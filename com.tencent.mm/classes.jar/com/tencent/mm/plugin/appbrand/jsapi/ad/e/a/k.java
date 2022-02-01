package com.tencent.mm.plugin.appbrand.jsapi.ad.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.b.c;
import com.tencent.mm.sdk.platformtools.ay;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"isRecentDevice", "", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "saveDevice", "", "luggage-xweb-ext_release"})
public final class k
{
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(c paramc, ay paramay) {}
    
    public final void run()
    {
      String str = null;
      AppMethodBeat.i(139810);
      Object localObject1 = this.gkh.getStringSet("VideoCastDeviceManager.saveDevice", null);
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = j.s((Collection)localObject1);
        localObject2 = this.lFw.bfV();
        if (localObject2 == null) {
          break label84;
        }
        localObject2 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject2).kgj;
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          if (((List)localObject1).contains(localObject2))
          {
            this.gkh.putLong((String)localObject2, System.currentTimeMillis());
            AppMethodBeat.o(139810);
            return;
            localObject1 = null;
            break;
            label84:
            localObject2 = null;
            continue;
          }
          if (((List)localObject1).size() >= this.lFx) {
            new q((List)localObject1)
            {
              public final void invoke()
              {
                AppMethodBeat.i(139809);
                Object localObject = (Iterable)this.lFz;
                Collection localCollection = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
                localObject = ((Iterable)localObject).iterator();
                while (((Iterator)localObject).hasNext())
                {
                  String str = (String)((Iterator)localObject).next();
                  localCollection.add(Long.valueOf(this.lFy.gkh.getLong(str, 0L)));
                }
                j.j((Iterable)localCollection);
                this.lFy.gkh.removeValueForKey((String)this.lFz.get(0));
                this.lFz.set(0, this.lFA);
                this.lFy.gkh.putLong(this.lFA, System.currentTimeMillis());
                AppMethodBeat.o(139809);
              }
            }.invoke();
          }
          com.tencent.mm.plugin.appbrand.g.b.b localb = this.lFw.bfV();
          if (localb != null) {
            str = localb.kgj;
          }
          ((List)localObject1).add(str);
          this.gkh.putStringSet("VideoCastDeviceManager.saveDevice", j.n((Iterable)localObject1));
          this.gkh.putLong((String)localObject2, System.currentTimeMillis());
          AppMethodBeat.o(139810);
          return;
        }
      }
      localObject1 = new android.support.v4.e.b();
      ((android.support.v4.e.b)localObject1).add(localObject2);
      this.gkh.putStringSet("VideoCastDeviceManager.saveDevice", (Set)localObject1);
      this.gkh.putLong((String)localObject2, System.currentTimeMillis());
      AppMethodBeat.o(139810);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.e.a.k
 * JD-Core Version:    0.7.0.1
 */