package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.a.c;
import com.tencent.mm.plugin.sight.base.a;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
final class o$a
  implements Runnable
{
  o$a(ArrayList paramArrayList) {}
  
  public final void run()
  {
    AppMethodBeat.i(202827);
    long l1 = 0L;
    Object localObject1 = ((Iterable)this.rAr).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject1).next();
      Object localObject3 = c.sTV;
      localObject2 = c.aeB((String)localObject2);
      long l2 = ((a)localObject2).videoDuration;
      localObject3 = o.rAq;
      o.uH(((a)localObject2).videoDuration);
      l1 = l2 + l1;
    }
    localObject1 = o.rAq;
    o.uI(l1);
    localObject1 = o.rAq;
    o.uJ(this.rAr.size());
    AppMethodBeat.o(202827);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.o.a
 * JD-Core Version:    0.7.0.1
 */