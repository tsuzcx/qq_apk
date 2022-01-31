package com.tencent.mm.plugin.appbrand.jsapi.p;

import a.f.a.m;
import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"pushEventEntry", "", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "entry", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$Entry;", "invoke"})
final class i$e$1
  extends k
  implements m<c, i.d, y>
{
  i$e$1(HashMap paramHashMap)
  {
    super(2);
  }
  
  public final void a(c paramc, i.d paramd)
  {
    AppMethodBeat.i(143866);
    j.q(paramc, "component");
    j.q(paramd, "entry");
    LinkedList localLinkedList2 = (LinkedList)this.hYr.get(paramc);
    LinkedList localLinkedList1 = localLinkedList2;
    if (localLinkedList2 == null)
    {
      localLinkedList1 = new LinkedList();
      ((Map)this.hYr).put(paramc, localLinkedList1);
    }
    localLinkedList1.addLast(paramd);
    AppMethodBeat.o(143866);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.i.e.1
 * JD-Core Version:    0.7.0.1
 */