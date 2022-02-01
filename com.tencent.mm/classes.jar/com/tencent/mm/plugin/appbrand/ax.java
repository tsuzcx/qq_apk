package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.a.b;

final class ax
  implements ay
{
  final ConcurrentSkipListSet<ay> nzg;
  final AtomicBoolean nzh;
  
  ax()
  {
    AppMethodBeat.i(245663);
    this.nzg = new ConcurrentSkipListSet(new Comparator() {});
    this.nzh = new AtomicBoolean(false);
    AppMethodBeat.o(245663);
  }
  
  private void s(b<ay, Void> paramb)
  {
    AppMethodBeat.i(245664);
    Iterator localIterator = new LinkedList(this.nzg).iterator();
    while (localIterator.hasNext()) {
      paramb.invoke((ay)localIterator.next());
    }
    AppMethodBeat.o(245664);
  }
  
  public final void ace(final String paramString)
  {
    AppMethodBeat.i(245667);
    s(new b() {});
    AppMethodBeat.o(245667);
  }
  
  public final void bCk()
  {
    AppMethodBeat.i(245668);
    s(new b() {});
    AppMethodBeat.o(245668);
  }
  
  public final void bEq()
  {
    AppMethodBeat.i(245665);
    s(new b() {});
    AppMethodBeat.o(245665);
  }
  
  public final void bEr()
  {
    AppMethodBeat.i(245666);
    s(new b() {});
    this.nzh.set(true);
    this.nzg.clear();
    AppMethodBeat.o(245666);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ax
 * JD-Core Version:    0.7.0.1
 */