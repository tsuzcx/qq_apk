package com.tencent.mm.plugin.appbrand.jsapi.p;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$BufferQueueAIO;", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$IBufferQueue;", "()V", "typedQueues", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$BufferQueue;", "[Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$BufferQueue;", "poll", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$Entry;", "bytes", "", "push", "", "entry", "size", "plugin-appbrand-integration_release"})
final class i$b
{
  final i.a[] hYk;
  
  public i$b()
  {
    AppMethodBeat.i(143860);
    this.hYk = new i.a[] { new i.a(d.c.hXW, 3), new i.a(d.c.hXX, 1) };
    AppMethodBeat.o(143860);
  }
  
  public final boolean a(i.d paramd)
  {
    AppMethodBeat.i(143858);
    j.q(paramd, "entry");
    i.a[] arrayOfa = this.hYk;
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      i.a locala = arrayOfa[i];
      if (locala.hYh == paramd.hYh)
      {
        boolean bool = locala.a(paramd);
        AppMethodBeat.o(143858);
        return bool;
      }
      i += 1;
    }
    AppMethodBeat.o(143858);
    return false;
  }
  
  public final List<i.d> aEA()
  {
    AppMethodBeat.i(143859);
    Object localObject = new LinkedList();
    long l1 = 0L;
    i.a[] arrayOfa = this.hYk;
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      i.a locala = arrayOfa[i];
      long l2 = locala.size();
      ((LinkedList)localObject).addAll((Collection)locala.hA(65536L - l1));
      l1 += l2 - locala.size();
      i += 1;
    }
    localObject = (List)localObject;
    AppMethodBeat.o(143859);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.i.b
 * JD-Core Version:    0.7.0.1
 */