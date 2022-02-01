package com.tencent.mm.plugin.finder.live.viewmodel.state.secondary;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b.c;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/state/secondary/FinderLiveSecondaryPrepareUIC;", "Lcom/tencent/mm/plugin/finder/live/component/statecomponent/FinderLiveSecondaryStateComponent;", "context", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "onBindData", "", "baseRouter", "Lcom/tencent/mm/plugin/finder/live/view/router/FinderLiveSecondaryRouter;", "onLiveEnd", "onLivePrepare", "onLiveStart", "onStatusChanged", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "prepareLive", "isFromFloat", "", "plugin-finder_release"})
public final class e
  extends com.tencent.mm.plugin.finder.live.component.statecomponent.b
{
  public e(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(286288);
    AppMethodBeat.o(286288);
  }
  
  public static void a(b.c paramc)
  {
    AppMethodBeat.i(286287);
    p.k(paramc, "status");
    AppMethodBeat.o(286287);
  }
  
  public final void a(com.tencent.mm.plugin.finder.live.view.router.b paramb)
  {
    AppMethodBeat.i(286286);
    p.k(paramb, "baseRouter");
    super.a(paramb);
    AppMethodBeat.o(286286);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.e
 * JD-Core Version:    0.7.0.1
 */