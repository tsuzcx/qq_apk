package com.tencent.mm.plugin.appbrand.appusage.a;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "fLongitude", "", "fLatitude", "onCallbackLocation"})
final class d$d
  implements c.a
{
  d$d(d paramd) {}
  
  public final void J(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(134573);
    Iterator localIterator = d.g(this.hds).iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      d locald = this.hds;
      j.p(localInteger, "item");
      d.a(locald, localInteger.intValue(), paramFloat1, paramFloat2);
    }
    d.g(this.hds).clear();
    AppMethodBeat.o(134573);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.d.d
 * JD-Core Version:    0.7.0.1
 */