package com.tencent.mm.plugin.appbrand;

import androidx.core.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentSkipListSet;

final class bc
  implements au
{
  final ConcurrentSkipListSet<au> qyf;
  
  bc()
  {
    AppMethodBeat.i(316589);
    this.qyf = new ConcurrentSkipListSet(new Comparator() {});
    AppMethodBeat.o(316589);
  }
  
  private void b(a<au> parama)
  {
    AppMethodBeat.i(316596);
    Iterator localIterator = new LinkedList(this.qyf).iterator();
    while (localIterator.hasNext()) {
      parama.accept((au)localIterator.next());
    }
    AppMethodBeat.o(316596);
  }
  
  public final void b(final ap paramap)
  {
    AppMethodBeat.i(316600);
    b(new a() {});
    AppMethodBeat.o(316600);
  }
  
  public final void cdx()
  {
    AppMethodBeat.i(316607);
    b(new a() {});
    AppMethodBeat.o(316607);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.bc
 * JD-Core Version:    0.7.0.1
 */