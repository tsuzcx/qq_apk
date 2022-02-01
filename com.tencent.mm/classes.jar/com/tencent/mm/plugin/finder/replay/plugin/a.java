package com.tencent.mm.plugin.finder.replay.plugin;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.plugin.ag;
import com.tencent.mm.plugin.finder.replay.FinderLiveReplayPluginLayout;
import com.tencent.mm.plugin.finder.replay.viewmodel.c;
import com.tencent.mm.plugin.finder.replay.widget.f.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/plugin/FinderLiveReplayClosePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "canClearScreen", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.finder.live.plugin.b
{
  private final com.tencent.mm.live.b.b nfT;
  
  public a(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(332918);
    this.nfT = paramb;
    paramViewGroup.setOnClickListener(new a..ExternalSyntheticLambda0(this));
    paramViewGroup = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    com.tencent.mm.plugin.finder.live.utils.a.a((com.tencent.mm.plugin.finder.live.plugin.b)this, false);
    paramViewGroup = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    com.tencent.mm.plugin.finder.live.utils.a.a((com.tencent.mm.plugin.finder.live.plugin.b)this);
    AppMethodBeat.o(332918);
  }
  
  private static final void a(a parama, View paramView)
  {
    AppMethodBeat.i(332926);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/replay/plugin/FinderLiveReplayClosePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    ((c)parama.business(c.class)).tw(true);
    paramView = (ag)parama.getPlugin(ag.class);
    if (paramView != null) {
      paramView.tO(8);
    }
    parama.eoH().finish();
    parama = parama.eoH();
    if ((parama instanceof FinderLiveReplayPluginLayout)) {}
    for (parama = (FinderLiveReplayPluginLayout)parama;; parama = null)
    {
      if (parama != null)
      {
        parama = parama.getUiClickListener();
        if (parama != null) {
          parama.eqV();
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/replay/plugin/FinderLiveReplayClosePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(332926);
      return;
    }
  }
  
  public final boolean eoI()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.replay.plugin.a
 * JD-Core Version:    0.7.0.1
 */