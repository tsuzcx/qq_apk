package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;

public class bb
  implements com.tencent.luggage.a.b, com.tencent.mm.kernel.c.b
{
  final LinkedList<az> izP;
  
  public bb()
  {
    AppMethodBeat.i(140962);
    this.izP = new LinkedList();
    AppMethodBeat.o(140962);
  }
  
  public static bb b(com.tencent.luggage.sdk.d.b paramb)
  {
    AppMethodBeat.i(140963);
    bb localbb2 = (bb)paramb.E(bb.class);
    bb localbb1 = localbb2;
    if (localbb2 == null)
    {
      localbb1 = new bb();
      paramb.b(bb.class, localbb1);
    }
    AppMethodBeat.o(140963);
    return localbb1;
  }
  
  public final void xM() {}
  
  public final void xN()
  {
    AppMethodBeat.i(140964);
    Object localObject = new LinkedList(this.izP);
    this.izP.clear();
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((az)((Iterator)localObject).next()).destroy();
    }
    AppMethodBeat.o(140964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bb
 * JD-Core Version:    0.7.0.1
 */