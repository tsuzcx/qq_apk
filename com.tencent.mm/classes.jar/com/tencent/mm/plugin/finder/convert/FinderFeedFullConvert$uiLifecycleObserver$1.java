package com.tencent.mm.plugin.finder.convert;

import android.arch.lifecycle.LifecycleOwner;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.life.UILifecycleObserver;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$uiLifecycleObserver$1", "Lcom/tencent/mm/plugin/finder/life/UILifecycleObserver;", "onCreate", "", "var1", "Landroid/arch/lifecycle/LifecycleOwner;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "plugin-finder_release"})
public final class FinderFeedFullConvert$uiLifecycleObserver$1
  implements UILifecycleObserver
{
  public final void onCreate(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(242939);
    p.h(paramLifecycleOwner, "var1");
    AppMethodBeat.o(242939);
  }
  
  public final void onDestroy(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(242944);
    p.h(paramLifecycleOwner, "var1");
    paramLifecycleOwner = ((Iterable)o.e(this.tBP)).iterator();
    while (paramLifecycleOwner.hasNext()) {
      ((o.b)paramLifecycleOwner.next()).dead();
    }
    o.e(this.tBP).clear();
    AppMethodBeat.o(242944);
  }
  
  public final void onPause(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(242942);
    p.h(paramLifecycleOwner, "var1");
    AppMethodBeat.o(242942);
  }
  
  public final void onResume(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(242941);
    p.h(paramLifecycleOwner, "var1");
    AppMethodBeat.o(242941);
  }
  
  public final void onStart(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(242940);
    p.h(paramLifecycleOwner, "var1");
    AppMethodBeat.o(242940);
  }
  
  public final void onStop(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(242943);
    p.h(paramLifecycleOwner, "var1");
    AppMethodBeat.o(242943);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.FinderFeedFullConvert.uiLifecycleObserver.1
 * JD-Core Version:    0.7.0.1
 */