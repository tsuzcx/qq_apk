package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.n.g;
import com.tencent.mm.plugin.webcanvas.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMCacheSlotManager;
import com.tencent.mm.sdk.platformtools.MMFileSlotManager;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/AppMsgContextEx;", "", "()V", "testClear", "", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b vQq;
  
  static
  {
    AppMethodBeat.i(6548);
    vQq = new b();
    AppMethodBeat.o(6548);
  }
  
  public static final void deH()
  {
    AppMethodBeat.i(6547);
    ??? = m.vSK;
    m.dfv().clearAll();
    ??? = m.vSK;
    m.dfw().clearAll();
    ??? = r.vTf;
    r.dfG().clearAll();
    ??? = r.vTf;
    r.dfH().clearAll();
    ??? = com.tencent.mm.plugin.az.c.WmU;
    com.tencent.mm.plugin.az.c.ipm().clearAll();
    ??? = r.vTf;
    r.dfI().clearAll();
    ??? = com.tencent.mm.plugin.az.c.WmU;
    com.tencent.mm.plugin.az.c.ipn().clearAll();
    ??? = r.vTf;
    r.dfJ().clearAll();
    ??? = com.tencent.mm.plugin.az.c.WmU;
    com.tencent.mm.plugin.az.c.ipo().clearAll();
    com.tencent.mm.plugin.az.c localc = WebPrefetcherManifest.vUW.dgz();
    synchronized (localc.Wmr)
    {
      Object localObject3 = (Map)localc.Wmr;
      Map localMap = (Map)new LinkedHashMap(ak.aKi(((Map)localObject3).size()));
      localObject3 = ((Iterable)((Map)localObject3).entrySet()).iterator();
      if (((Iterator)localObject3).hasNext())
      {
        Object localObject4 = ((Iterator)localObject3).next();
        Map.Entry localEntry = (Map.Entry)localObject4;
        localEntry.getKey();
        int i = ((Number)localEntry.getValue()).intValue();
        Log.d(localc.mgf, s.X("clearAll destroy context: ", Integer.valueOf(i)));
        localc.BK(i).destroy();
        localMap.put(ah.aiuX, ((Map.Entry)localObject4).getValue());
      }
    }
    localObject2.Wmr.clear();
    ah localah = ah.aiuX;
    ??? = com.tencent.mm.plugin.brandservice.c.vAt;
    com.tencent.mm.plugin.brandservice.c.dbJ().clearAll();
    ??? = com.tencent.mm.plugin.brandservice.c.vAt;
    com.tencent.mm.plugin.brandservice.c.dbK().clearAll();
    ??? = com.tencent.mm.plugin.brandservice.c.vAt;
    com.tencent.mm.plugin.brandservice.c.dbL().clearAll();
    ??? = r.vTf;
    r.dfN().clearAll();
    q.dfF().clearAll();
    ??? = com.tencent.mm.plugin.webcanvas.c.Wkq;
    ((MMKVSlotManager)com.tencent.mm.plugin.webcanvas.c.ioo().getValue()).clearAll();
    c.deJ().clear();
    c.deI().clear();
    ??? = k.WkZ;
    k.atj().clearAll();
    ??? = v.vVd;
    v.dgD().clearAll();
    AppMethodBeat.o(6547);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.b
 * JD-Core Version:    0.7.0.1
 */