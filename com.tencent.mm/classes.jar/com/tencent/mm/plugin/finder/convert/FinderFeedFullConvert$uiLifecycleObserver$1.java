package com.tencent.mm.plugin.finder.convert;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.life.b;
import java.util.HashSet;
import java.util.Iterator;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$uiLifecycleObserver$1", "Lcom/tencent/mm/plugin/finder/life/UILifecycleObserver;", "onCreate", "", "var1", "Landroidx/lifecycle/LifecycleOwner;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "plugin-finder_release"})
public final class FinderFeedFullConvert$uiLifecycleObserver$1
  implements b
{
  public final void onCreate(androidx.lifecycle.l paraml)
  {
    AppMethodBeat.i(289958);
    kotlin.g.b.p.k(paraml, "var1");
    AppMethodBeat.o(289958);
  }
  
  public final void onDestroy(androidx.lifecycle.l paraml)
  {
    AppMethodBeat.i(289963);
    kotlin.g.b.p.k(paraml, "var1");
    paraml = ((Iterable)p.f(this.xjB)).iterator();
    while (paraml.hasNext()) {
      ((p.c)paraml.next()).dead();
    }
    p.f(this.xjB).clear();
    AppMethodBeat.o(289963);
  }
  
  public final void onPause(androidx.lifecycle.l paraml)
  {
    AppMethodBeat.i(289961);
    kotlin.g.b.p.k(paraml, "var1");
    AppMethodBeat.o(289961);
  }
  
  public final void onResume(androidx.lifecycle.l paraml)
  {
    AppMethodBeat.i(289960);
    kotlin.g.b.p.k(paraml, "var1");
    AppMethodBeat.o(289960);
  }
  
  public final void onStart(androidx.lifecycle.l paraml)
  {
    AppMethodBeat.i(289959);
    kotlin.g.b.p.k(paraml, "var1");
    AppMethodBeat.o(289959);
  }
  
  public final void onStop(androidx.lifecycle.l paraml)
  {
    AppMethodBeat.i(289962);
    kotlin.g.b.p.k(paraml, "var1");
    AppMethodBeat.o(289962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.FinderFeedFullConvert.uiLifecycleObserver.1
 * JD-Core Version:    0.7.0.1
 */