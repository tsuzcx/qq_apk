package com.tencent.mm.plugin.finder.viewmodel.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.receiver.HeadsetReceiver.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$onHeadsetStateChangeListener$1", "Lcom/tencent/mm/plugin/findersdk/receiver/HeadsetReceiver$OnHeadsetStateChangeListener;", "onHeadsetStateChange", "", "on", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class be$j
  implements HeadsetReceiver.b
{
  be$j(be parambe) {}
  
  public final void sO(boolean paramBoolean)
  {
    AppMethodBeat.i(338661);
    Log.i("Finder.VideoRecycler", s.X("onHeadsetStateChange on:", Boolean.valueOf(paramBoolean)));
    Iterator localIterator = ((Iterable)be.i(this.GVS)).iterator();
    while (localIterator.hasNext()) {
      ((HeadsetReceiver.b)localIterator.next()).sO(paramBoolean);
    }
    AppMethodBeat.o(338661);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.be.j
 * JD-Core Version:    0.7.0.1
 */