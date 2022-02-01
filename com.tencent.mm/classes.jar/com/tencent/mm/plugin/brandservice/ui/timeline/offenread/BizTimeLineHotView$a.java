package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.sdk.event.IListener;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotView$Companion;", "", "()V", "TAG", "", "liveStatusChangeListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/BizFinderLineStatusChangedEvent;", "addLiveStatusChangeListener", "", "hotView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/IBizTimeLineHotView;", "removeLiveStatusChangeListener", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class BizTimeLineHotView$a
{
  public static void a(k paramk)
  {
    AppMethodBeat.i(302284);
    s.u(paramk, "hotView");
    if (BizTimeLineHotView.deC() == null)
    {
      BizTimeLineHotView.b((IListener)new BizTimeLineHotView.Companion.addLiveStatusChangeListener.1(new WeakReference(paramk), f.hfK));
      paramk = BizTimeLineHotView.deC();
      if (paramk != null) {
        paramk.alive();
      }
    }
    AppMethodBeat.o(302284);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView.a
 * JD-Core Version:    0.7.0.1
 */