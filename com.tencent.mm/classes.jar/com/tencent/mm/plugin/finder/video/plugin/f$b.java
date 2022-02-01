package com.tencent.mm.plugin.finder.video.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.e.c;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
final class f$b
  implements Runnable
{
  f$b(f paramf) {}
  
  public final void run()
  {
    AppMethodBeat.i(254484);
    Iterator localIterator = ((Iterable)f.a(this.whd)).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      c localc = c.Cic;
      c.aLC(str);
    }
    f.a(this.whd).clear();
    AppMethodBeat.o(254484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.f.b
 * JD-Core Version:    0.7.0.1
 */