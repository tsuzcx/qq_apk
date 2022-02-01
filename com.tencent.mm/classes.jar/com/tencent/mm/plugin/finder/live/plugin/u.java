package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.a;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.live.component.a.a;
import com.tencent.mm.plugin.finder.live.component.a.b;
import com.tencent.mm.plugin.finder.live.component.c;
import com.tencent.mm.plugin.finder.live.model.aq;
import com.tencent.mm.ui.MMActivity;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "musicGuidePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicGuidePlugin;", "getMusicGuidePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicGuidePlugin;", "setMusicGuidePlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicGuidePlugin;)V", "musicVolumeClickPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicVolumePlugin;", "getMusicVolumeClickPlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicVolumePlugin;", "setMusicVolumeClickPlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicVolumePlugin;)V", "presenter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicContract$Presenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicContract$Presenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicContract$Presenter;)V", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicContract$ViewCallback;)V", "canClearScreen", "", "mount", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "volumeAction", "plugin-finder_release"})
public final class u
  extends d
{
  private final String TAG;
  private final com.tencent.mm.live.c.b kCL;
  public a.a xYU;
  a.b xYn;
  private t ynu;
  private w ynv;
  
  public u(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(220917);
    this.kCL = paramb;
    this.TAG = "Finder.LiveAnchorMusicPlugin";
    AppMethodBeat.o(220917);
  }
  
  public final boolean dAo()
  {
    return true;
  }
  
  public final void mount()
  {
    AppMethodBeat.i(220901);
    super.mount();
    Object localObject2;
    if ((this.xYU == null) || (this.xYn == null))
    {
      localObject1 = this.kiF.getContext();
      p.j(localObject1, "root.context");
      this.xYU = ((a.a)new c((Context)localObject1, getBuContext(), this.kCL, (d)this));
      localObject1 = (View)this.kiF;
      localObject2 = this.kiF.getContext();
      if (localObject2 == null)
      {
        localObject1 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(220901);
        throw ((Throwable)localObject1);
      }
      this.xYn = ((a.b)new com.tencent.mm.plugin.finder.live.component.d((View)localObject1, (MMActivity)localObject2, getBuContext(), this.xYU));
    }
    Object localObject1 = this.xYU;
    if (localObject1 != null)
    {
      localObject2 = this.xYn;
      if (localObject2 == null) {
        p.iCn();
      }
      ((a.a)localObject1).onAttach(localObject2);
      AppMethodBeat.o(220901);
      return;
    }
    AppMethodBeat.o(220901);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(220914);
    p.k(paramc, "status");
    switch (v.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    label280:
    label285:
    label291:
    do
    {
      AppMethodBeat.o(220914);
      return;
      tU(0);
      paramc = this.xYU;
      if (paramc != null)
      {
        paramc.dwV();
        AppMethodBeat.o(220914);
        return;
      }
      AppMethodBeat.o(220914);
      return;
      tU(8);
      paramc = this.xYU;
      if (paramc != null) {
        paramc.dwX();
      }
      if (this.ynu == null) {
        this.ynu = ((t)getPlugin(t.class));
      }
      paramc = this.ynu;
      if (paramc != null) {
        paramc.dAH();
      }
      if (this.ynv == null) {
        this.ynv = ((w)getPlugin(w.class));
      }
      paramc = this.ynv;
      if (paramc != null)
      {
        paramc.dAH();
        AppMethodBeat.o(220914);
        return;
      }
      AppMethodBeat.o(220914);
      return;
      if (paramBundle != null)
      {
        paramc = Integer.valueOf(paramBundle.getInt("PARAM_FINDER_LIVE_MUSIC_ID"));
        paramBundle = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj;
        if (paramc == null) {
          break label280;
        }
      }
      for (int i = paramc.intValue();; i = 0)
      {
        paramc = paramBundle.Nm(i);
        paramBundle = (aq)paramc.Mx;
        if (paramBundle == null) {
          break label291;
        }
        a.a locala = this.xYU;
        if (locala == null) {
          break label285;
        }
        locala.a(paramBundle, ((Number)paramc.My).intValue(), false);
        AppMethodBeat.o(220914);
        return;
        paramc = null;
        break;
      }
      AppMethodBeat.o(220914);
      return;
      AppMethodBeat.o(220914);
      return;
      paramc = this.xYU;
    } while (paramc == null);
    paramc.bnv();
    AppMethodBeat.o(220914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.u
 * JD-Core Version:    0.7.0.1
 */