package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "fLongitude", "", "fLatitude", "onCallbackLocation"})
final class d$d
  implements c.a
{
  d$d(d paramd) {}
  
  public final void K(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(50310);
    Iterator localIterator = d.g(this.nRu).iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      d locald = this.nRu;
      p.j(localInteger, "item");
      d.a(locald, localInteger.intValue(), paramFloat1, paramFloat2);
    }
    d.g(this.nRu).clear();
    AppMethodBeat.o(50310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.d.d
 * JD-Core Version:    0.7.0.1
 */