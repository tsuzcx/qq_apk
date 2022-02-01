package com.tencent.mm.plugin.finder.live.component;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b;
import com.tencent.mm.plugin.finder.live.model.context.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAllowanceGiftCardPresenter;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAllowanceGiftCardContract$Presenter;", "context", "Landroid/content/Context;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAllowanceGiftCardContract$ViewCallback;", "getGiftFailed", "", "onAttach", "callback", "onDetach", "showAnchorGuide", "showVisitorGuide", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements d.a
{
  public static final e.a Cwm;
  private final a CvU;
  private d.b Cwn;
  private final Context context;
  private final b nfT;
  
  static
  {
    AppMethodBeat.i(352507);
    Cwm = new e.a((byte)0);
    AppMethodBeat.o(352507);
  }
  
  public e(Context paramContext, a parama, b paramb)
  {
    AppMethodBeat.i(352498);
    this.context = paramContext;
    this.CvU = parama;
    this.nfT = paramb;
    AppMethodBeat.o(352498);
  }
  
  public final void ehu()
  {
    AppMethodBeat.i(352517);
    d.b localb = this.Cwn;
    if (localb != null) {
      localb.ehx();
    }
    AppMethodBeat.o(352517);
  }
  
  public final void ehv()
  {
    AppMethodBeat.i(352525);
    d.b localb = this.Cwn;
    if (localb != null) {
      localb.ehy();
    }
    AppMethodBeat.o(352525);
  }
  
  public final void ehw()
  {
    AppMethodBeat.i(352533);
    d.b localb = this.Cwn;
    if (localb != null) {
      localb.ehz();
    }
    AppMethodBeat.o(352533);
  }
  
  public final void onDetach() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.e
 * JD-Core Version:    0.7.0.1
 */