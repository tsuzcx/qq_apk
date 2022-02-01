package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;

public class bu
  implements com.tencent.luggage.a.b, com.tencent.mm.kernel.c.b
{
  final LinkedList<bs> lgn;
  
  public bu()
  {
    AppMethodBeat.i(147550);
    this.lgn = new LinkedList();
    AppMethodBeat.o(147550);
  }
  
  public static bu b(c paramc)
  {
    AppMethodBeat.i(147551);
    if (paramc == null)
    {
      AppMethodBeat.o(147551);
      return null;
    }
    bu localbu2 = (bu)paramc.ab(bu.class);
    bu localbu1 = localbu2;
    if (localbu2 == null)
    {
      localbu1 = new bu();
      paramc.b(bu.class, localbu1);
    }
    AppMethodBeat.o(147551);
    return localbu1;
  }
  
  public final void agv() {}
  
  public final void agw()
  {
    AppMethodBeat.i(147552);
    Object localObject = new LinkedList(this.lgn);
    this.lgn.clear();
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((bs)((Iterator)localObject).next()).destroy();
    }
    AppMethodBeat.o(147552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bu
 * JD-Core Version:    0.7.0.1
 */