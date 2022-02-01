package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.a.b;

final class bd
  implements be
{
  final ConcurrentSkipListSet<be> qyi;
  final AtomicBoolean qyj;
  
  bd()
  {
    AppMethodBeat.i(316591);
    this.qyi = new ConcurrentSkipListSet(new Comparator() {});
    this.qyj = new AtomicBoolean(false);
    AppMethodBeat.o(316591);
  }
  
  private void N(b<be, Void> paramb)
  {
    AppMethodBeat.i(316597);
    Iterator localIterator = new LinkedList(this.qyi).iterator();
    while (localIterator.hasNext()) {
      paramb.invoke((be)localIterator.next());
    }
    AppMethodBeat.o(316597);
  }
  
  public final void UF(final String paramString)
  {
    AppMethodBeat.i(316611);
    N(new b() {});
    AppMethodBeat.o(316611);
  }
  
  public final void cbz()
  {
    AppMethodBeat.i(316615);
    N(new b() {});
    AppMethodBeat.o(316615);
  }
  
  public final void cdA()
  {
    AppMethodBeat.i(316608);
    N(new b() {});
    this.qyj.set(true);
    this.qyi.clear();
    AppMethodBeat.o(316608);
  }
  
  public final void cdz()
  {
    AppMethodBeat.i(316603);
    N(new b() {});
    AppMethodBeat.o(316603);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.bd
 * JD-Core Version:    0.7.0.1
 */