package com.tencent.mm.plugin.finder.convert;

import android.arch.lifecycle.LifecycleOwner;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.life.UILifecycleObserver;
import d.g.b.p;
import d.l;
import java.util.HashSet;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/convert/FinderFeedConvert$uiLifecycleObserver$1", "Lcom/tencent/mm/plugin/finder/life/UILifecycleObserver;", "onCreate", "", "var1", "Landroid/arch/lifecycle/LifecycleOwner;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "plugin-finder_release"})
public final class FinderFeedConvert$uiLifecycleObserver$1
  implements UILifecycleObserver
{
  public final void onCreate(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(165380);
    p.h(paramLifecycleOwner, "var1");
    AppMethodBeat.o(165380);
  }
  
  public final void onDestroy(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(165385);
    p.h(paramLifecycleOwner, "var1");
    paramLifecycleOwner = ((Iterable)h.f(this.rMP)).iterator();
    while (paramLifecycleOwner.hasNext()) {
      ((h.b)paramLifecycleOwner.next()).dead();
    }
    h.f(this.rMP).clear();
    AppMethodBeat.o(165385);
  }
  
  public final void onPause(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(165383);
    p.h(paramLifecycleOwner, "var1");
    AppMethodBeat.o(165383);
  }
  
  public final void onResume(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(165382);
    p.h(paramLifecycleOwner, "var1");
    AppMethodBeat.o(165382);
  }
  
  public final void onStart(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(165381);
    p.h(paramLifecycleOwner, "var1");
    AppMethodBeat.o(165381);
  }
  
  public final void onStop(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(165384);
    p.h(paramLifecycleOwner, "var1");
    AppMethodBeat.o(165384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.FinderFeedConvert.uiLifecycleObserver.1
 * JD-Core Version:    0.7.0.1
 */