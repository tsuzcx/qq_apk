package com.tencent.mm.plugin.appbrand;

import androidx.core.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentSkipListSet;

public final class aw
  implements ap
{
  public final ConcurrentSkipListSet<ap> nzd;
  
  aw()
  {
    AppMethodBeat.i(242550);
    this.nzd = new ConcurrentSkipListSet(new Comparator() {});
    AppMethodBeat.o(242550);
  }
  
  private void a(a<ap> parama)
  {
    AppMethodBeat.i(242553);
    Iterator localIterator = new LinkedList(this.nzd).iterator();
    while (localIterator.hasNext()) {
      parama.accept((ap)localIterator.next());
    }
    AppMethodBeat.o(242553);
  }
  
  public final void b(final ak paramak)
  {
    AppMethodBeat.i(242555);
    a(new a() {});
    AppMethodBeat.o(242555);
  }
  
  public final void bEn()
  {
    AppMethodBeat.i(242557);
    a(new a() {});
    AppMethodBeat.o(242557);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.aw
 * JD-Core Version:    0.7.0.1
 */