package com.tencent.mm.plugin.finder.feed.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.ii;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
final class FinderGameLiveFinishUI$a
  implements Runnable
{
  public static final a xNV;
  
  static
  {
    AppMethodBeat.i(268521);
    xNV = new a();
    AppMethodBeat.o(268521);
  }
  
  public final void run()
  {
    AppMethodBeat.i(268519);
    EventCenter localEventCenter = EventCenter.instance;
    ii localii = new ii();
    localii.fFz.fFA = true;
    localEventCenter.publish((IEvent)localii);
    AppMethodBeat.o(268519);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderGameLiveFinishUI.a
 * JD-Core Version:    0.7.0.1
 */