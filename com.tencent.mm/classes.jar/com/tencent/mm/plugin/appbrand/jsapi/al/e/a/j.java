package com.tencent.mm.plugin.appbrand.jsapi.al.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.b.c;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"isRecentDevice", "", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "saveDevice", "", "luggage-xweb-ext_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class j
{
  private static final void a(MultiProcessMMKV paramMultiProcessMMKV, c paramc, int paramInt)
  {
    Object localObject3 = null;
    AppMethodBeat.i(327256);
    s.u(paramc, "$this_saveDevice");
    Object localObject1 = paramMultiProcessMMKV.getStringSet("VideoCastDeviceManager.saveDevice", null);
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject2 = paramc.cmY();
      if (localObject2 != null) {
        break label84;
      }
      localObject2 = null;
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        if (((List)localObject1).contains(localObject2))
        {
          paramMultiProcessMMKV.putLong((String)localObject2, System.currentTimeMillis());
          AppMethodBeat.o(327256);
          return;
          localObject1 = p.J((Collection)localObject1);
          break;
          label84:
          localObject2 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject2).rii;
          continue;
        }
        if (((List)localObject1).size() >= paramInt)
        {
          Object localObject4 = (Iterable)localObject1;
          Collection localCollection = (Collection)new ArrayList(p.a((Iterable)localObject4, 10));
          localObject4 = ((Iterable)localObject4).iterator();
          while (((Iterator)localObject4).hasNext()) {
            localCollection.add(Long.valueOf(paramMultiProcessMMKV.getLong((String)((Iterator)localObject4).next(), 0L)));
          }
          p.n((Iterable)localCollection);
          paramMultiProcessMMKV.removeValueForKey((String)((List)localObject1).get(0));
          ((List)localObject1).set(0, localObject2);
          paramMultiProcessMMKV.putLong((String)localObject2, System.currentTimeMillis());
        }
        paramc = paramc.cmY();
        if (paramc == null) {}
        for (paramc = localObject3;; paramc = paramc.rii)
        {
          ((List)localObject1).add(paramc);
          paramMultiProcessMMKV.putStringSet("VideoCastDeviceManager.saveDevice", p.r((Iterable)localObject1));
          paramMultiProcessMMKV.putLong((String)localObject2, System.currentTimeMillis());
          AppMethodBeat.o(327256);
          return;
        }
      }
    }
    paramc = new androidx.b.b();
    paramc.add(localObject2);
    paramMultiProcessMMKV.putStringSet("VideoCastDeviceManager.saveDevice", (Set)paramc);
    paramMultiProcessMMKV.putLong((String)localObject2, System.currentTimeMillis());
    AppMethodBeat.o(327256);
  }
  
  public static final void h(c paramc)
  {
    AppMethodBeat.i(327247);
    s.u(paramc, "<this>");
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleDefault();
    h.ahAA.bm(new j..ExternalSyntheticLambda0(localMultiProcessMMKV, paramc, 2));
    AppMethodBeat.o(327247);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.e.a.j
 * JD-Core Version:    0.7.0.1
 */