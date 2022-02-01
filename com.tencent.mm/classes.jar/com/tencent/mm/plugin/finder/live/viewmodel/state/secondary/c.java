package com.tencent.mm.plugin.finder.live.viewmodel.state.secondary;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.view.router.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/state/secondary/FinderLiveSecondaryPrepareUIC;", "Lcom/tencent/mm/plugin/finder/live/component/statecomponent/FinderLiveSecondaryStateComponent;", "context", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "onBindData", "", "baseRouter", "Lcom/tencent/mm/plugin/finder/live/view/router/FinderLiveSecondaryRouter;", "onLiveEnd", "onLivePrepare", "onLiveStart", "onStatusChanged", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "prepareLive", "isFromFloat", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.plugin.finder.live.component.statecomponent.c
{
  public c(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(357125);
    AppMethodBeat.o(357125);
  }
  
  public static void c(b.c paramc)
  {
    AppMethodBeat.i(357131);
    s.u(paramc, "status");
    AppMethodBeat.o(357131);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(357138);
    s.u(paramb, "baseRouter");
    super.a(paramb);
    AppMethodBeat.o(357138);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.c
 * JD-Core Version:    0.7.0.1
 */