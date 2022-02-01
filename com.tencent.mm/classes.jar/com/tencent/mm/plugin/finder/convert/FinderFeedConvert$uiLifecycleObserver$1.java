package com.tencent.mm.plugin.finder.convert;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.life.b;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/convert/FinderFeedConvert$uiLifecycleObserver$1", "Lcom/tencent/mm/plugin/finder/life/UILifecycleObserver;", "onCreate", "", "var1", "Landroidx/lifecycle/LifecycleOwner;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "plugin-finder_release"})
public final class FinderFeedConvert$uiLifecycleObserver$1
  implements b
{
  public final void onCreate(androidx.lifecycle.l paraml)
  {
    AppMethodBeat.i(272197);
    p.k(paraml, "var1");
    AppMethodBeat.o(272197);
  }
  
  public final void onDestroy(androidx.lifecycle.l paraml)
  {
    AppMethodBeat.i(272203);
    p.k(paraml, "var1");
    paraml = ((Iterable)m.i(this.xia)).iterator();
    while (paraml.hasNext()) {
      ((m.b)paraml.next()).dead();
    }
    m.i(this.xia).clear();
    AppMethodBeat.o(272203);
  }
  
  public final void onPause(androidx.lifecycle.l paraml)
  {
    AppMethodBeat.i(272201);
    p.k(paraml, "var1");
    AppMethodBeat.o(272201);
  }
  
  public final void onResume(androidx.lifecycle.l paraml)
  {
    AppMethodBeat.i(272200);
    p.k(paraml, "var1");
    AppMethodBeat.o(272200);
  }
  
  public final void onStart(androidx.lifecycle.l paraml)
  {
    AppMethodBeat.i(272199);
    p.k(paraml, "var1");
    AppMethodBeat.o(272199);
  }
  
  public final void onStop(androidx.lifecycle.l paraml)
  {
    AppMethodBeat.i(272202);
    p.k(paraml, "var1");
    AppMethodBeat.o(272202);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.FinderFeedConvert.uiLifecycleObserver.1
 * JD-Core Version:    0.7.0.1
 */