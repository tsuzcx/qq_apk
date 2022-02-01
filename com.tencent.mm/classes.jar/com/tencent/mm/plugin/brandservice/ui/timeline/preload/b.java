package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.g;
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
import kotlin.a.ae;
import kotlin.f;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/AppMsgContextEx;", "", "()V", "testClear", "", "plugin-brandservice_release"})
public final class b
{
  public static final b sKu;
  
  static
  {
    AppMethodBeat.i(6548);
    sKu = new b();
    AppMethodBeat.o(6548);
  }
  
  public static final void cBw()
  {
    AppMethodBeat.i(6547);
    ??? = m.sNg;
    m.cCj().clearAll();
    ??? = m.sNg;
    m.cCk().clearAll();
    ??? = s.sNX;
    s.cCw().clearAll();
    ??? = s.sNX;
    s.cCx().clearAll();
    ??? = com.tencent.mm.plugin.ax.c.PwQ;
    com.tencent.mm.plugin.ax.c.gPW().clearAll();
    ??? = s.sNX;
    s.cCy().clearAll();
    ??? = com.tencent.mm.plugin.ax.c.PwQ;
    com.tencent.mm.plugin.ax.c.gPX().clearAll();
    ??? = s.sNX;
    s.cCz().clearAll();
    ??? = com.tencent.mm.plugin.ax.c.PwQ;
    com.tencent.mm.plugin.ax.c.gPY().clearAll();
    com.tencent.mm.plugin.ax.c localc = w.sPP.cDd();
    synchronized (localc.Pwb)
    {
      Object localObject4 = (Map)localc.Pwb;
      Map localMap = (Map)new LinkedHashMap(ae.aDD(((Map)localObject4).size()));
      localObject4 = ((Iterable)((Map)localObject4).entrySet()).iterator();
      if (((Iterator)localObject4).hasNext())
      {
        Object localObject5 = ((Iterator)localObject4).next();
        Map.Entry localEntry = (Map.Entry)localObject5;
        localEntry.getKey();
        int i = ((Number)localEntry.getValue()).intValue();
        Log.d(localc.jGx, "clearAll destroy context: ".concat(String.valueOf(i)));
        localc.Bx(i).destroy();
        localMap.put(x.aazN, ((Map.Entry)localObject5).getValue());
      }
    }
    localObject2.Pwb.clear();
    Object localObject3 = x.aazN;
    ??? = com.tencent.mm.plugin.brandservice.c.soD;
    com.tencent.mm.plugin.brandservice.c.cyL().clearAll();
    ??? = com.tencent.mm.plugin.brandservice.c.soD;
    com.tencent.mm.plugin.brandservice.c.cyM().clearAll();
    ??? = com.tencent.mm.plugin.brandservice.c.soD;
    com.tencent.mm.plugin.brandservice.c.cyN().clearAll();
    ??? = s.sNX;
    s.cCE().clearAll();
    q.cCt().clearAll();
    ??? = com.tencent.mm.plugin.webcanvas.c.PtO;
    ??? = com.tencent.mm.plugin.webcanvas.c.gOZ();
    localObject3 = com.tencent.mm.plugin.webcanvas.c.PtO;
    ((MMKVSlotManager)((f)???).getValue()).clearAll();
    c.cBy().clear();
    c.cBx().clear();
    AppMethodBeat.o(6547);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.b
 * JD-Core Version:    0.7.0.1
 */