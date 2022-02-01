package com.tencent.mm.plugin.finder.live.component;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b;
import com.tencent.mm.plugin.finder.live.model.context.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAllowanceGiftPagPresenter;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAllowanceGiftPagContract$Presenter;", "context", "Landroid/content/Context;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAllowanceGiftPagContract$ViewCallback;", "onAttach", "", "callback", "onDetach", "onGetGiftSuccess", "giftUrl", "", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  implements g.a
{
  public static final h.a Cwv;
  private final a CvU;
  private g.b Cww;
  private final Context context;
  private final b nfT;
  
  static
  {
    AppMethodBeat.i(352515);
    Cwv = new h.a((byte)0);
    AppMethodBeat.o(352515);
  }
  
  public h(Context paramContext, a parama, b paramb)
  {
    AppMethodBeat.i(352506);
    this.context = paramContext;
    this.CvU = parama;
    this.nfT = paramb;
    AppMethodBeat.o(352506);
  }
  
  public final void awk(String paramString)
  {
    AppMethodBeat.i(352524);
    g.b localb = this.Cww;
    if (localb != null) {
      localb.awl(paramString);
    }
    AppMethodBeat.o(352524);
  }
  
  public final void onDetach() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.h
 * JD-Core Version:    0.7.0.1
 */