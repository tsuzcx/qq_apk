package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;

public class bp
  implements com.tencent.luggage.a.b, com.tencent.mm.kernel.c.b
{
  final LinkedList<bn> lGh;
  
  public bp()
  {
    AppMethodBeat.i(147550);
    this.lGh = new LinkedList();
    AppMethodBeat.o(147550);
  }
  
  public static bp b(c paramc)
  {
    AppMethodBeat.i(147551);
    if (paramc == null)
    {
      AppMethodBeat.o(147551);
      return null;
    }
    bp localbp2 = (bp)paramc.ab(bp.class);
    bp localbp1 = localbp2;
    if (localbp2 == null)
    {
      localbp1 = new bp();
      paramc.b(bp.class, localbp1);
    }
    AppMethodBeat.o(147551);
    return localbp1;
  }
  
  public final void ahM() {}
  
  public final void ahN()
  {
    AppMethodBeat.i(147552);
    Object localObject = new LinkedList(this.lGh);
    this.lGh.clear();
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((bn)((Iterator)localObject).next()).destroy();
    }
    AppMethodBeat.o(147552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bp
 * JD-Core Version:    0.7.0.1
 */