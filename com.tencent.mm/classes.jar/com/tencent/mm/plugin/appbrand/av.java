package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.a.b;

final class av
  implements aw
{
  final ConcurrentSkipListSet<aw> kFA;
  final AtomicBoolean kFB;
  
  av()
  {
    AppMethodBeat.i(219284);
    this.kFA = new ConcurrentSkipListSet(new Comparator() {});
    this.kFB = new AtomicBoolean(false);
    AppMethodBeat.o(219284);
  }
  
  private void s(b<aw, Void> paramb)
  {
    AppMethodBeat.i(219285);
    Iterator localIterator = new LinkedList(this.kFA).iterator();
    while (localIterator.hasNext()) {
      paramb.invoke((aw)localIterator.next());
    }
    AppMethodBeat.o(219285);
  }
  
  public final void Uu(final String paramString)
  {
    AppMethodBeat.i(219288);
    s(new b() {});
    AppMethodBeat.o(219288);
  }
  
  public final void bru()
  {
    AppMethodBeat.i(219289);
    s(new b() {});
    AppMethodBeat.o(219289);
  }
  
  public final void btt()
  {
    AppMethodBeat.i(219286);
    s(new b() {});
    AppMethodBeat.o(219286);
  }
  
  public final void btu()
  {
    AppMethodBeat.i(219287);
    s(new b() {});
    this.kFB.set(true);
    this.kFA.clear();
    AppMethodBeat.o(219287);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.av
 * JD-Core Version:    0.7.0.1
 */