package com.tencent.mm.plugin.appbrand;

import android.support.v4.e.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentSkipListSet;

public final class au
  implements ao
{
  public final ConcurrentSkipListSet<ao> kFx;
  
  au()
  {
    AppMethodBeat.i(219275);
    this.kFx = new ConcurrentSkipListSet(new Comparator() {});
    AppMethodBeat.o(219275);
  }
  
  private void a(c<ao> paramc)
  {
    AppMethodBeat.i(219276);
    Iterator localIterator = new LinkedList(this.kFx).iterator();
    while (localIterator.hasNext()) {
      paramc.accept((ao)localIterator.next());
    }
    AppMethodBeat.o(219276);
  }
  
  public final void b(final ak paramak)
  {
    AppMethodBeat.i(219277);
    a(new c() {});
    AppMethodBeat.o(219277);
  }
  
  public final void btq()
  {
    AppMethodBeat.i(219278);
    a(new c() {});
    AppMethodBeat.o(219278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.au
 * JD-Core Version:    0.7.0.1
 */