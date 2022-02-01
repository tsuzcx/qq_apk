package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.a;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.component.j.a;
import com.tencent.mm.plugin.finder.live.component.j.b;
import com.tencent.mm.plugin.finder.live.component.l;
import com.tencent.mm.plugin.finder.live.component.m;
import com.tencent.mm.plugin.finder.live.model.at;
import com.tencent.mm.plugin.finder.live.model.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "musicGuidePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicGuidePlugin;", "getMusicGuidePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicGuidePlugin;", "setMusicGuidePlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicGuidePlugin;)V", "musicVolumeClickPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicVolumePlugin;", "getMusicVolumeClickPlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicVolumePlugin;", "setMusicVolumeClickPlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicVolumePlugin;)V", "presenter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicContract$Presenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicContract$Presenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicContract$Presenter;)V", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicContract$ViewCallback;)V", "canClearScreen", "", "mount", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "volumeAction", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class u
  extends b
{
  private t CWn;
  private v CWo;
  j.b CwH;
  public j.a CwN;
  private final String TAG;
  private final com.tencent.mm.live.b.b nfT;
  
  public u(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(353809);
    this.nfT = paramb;
    this.TAG = "Finder.LiveAnchorMusicPlugin";
    AppMethodBeat.o(353809);
  }
  
  public final boolean eoI()
  {
    return true;
  }
  
  public final void mount()
  {
    AppMethodBeat.i(353820);
    super.mount();
    Object localObject2;
    if ((this.CwN == null) || (this.CwH == null))
    {
      localObject1 = this.mJe.getContext();
      s.s(localObject1, "root.context");
      this.CwN = ((j.a)new l((Context)localObject1, getBuContext(), this.nfT, (b)this));
      localObject1 = (View)this.mJe;
      localObject2 = this.mJe.getContext();
      if (localObject2 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(353820);
        throw ((Throwable)localObject1);
      }
      this.CwH = ((j.b)new m((View)localObject1, (MMActivity)localObject2, getBuContext(), this.CwN));
    }
    Object localObject1 = this.CwN;
    if (localObject1 != null)
    {
      localObject2 = this.CwH;
      s.checkNotNull(localObject2);
      ((j.a)localObject1).onAttach(localObject2);
    }
    AppMethodBeat.o(353820);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(353830);
    s.u(paramc, "status");
    switch (a.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(353830);
      return;
      tO(0);
      paramc = this.CwN;
      if (paramc != null)
      {
        paramc.ehC();
        AppMethodBeat.o(353830);
        return;
        tO(8);
        paramc = this.CwN;
        if (paramc != null) {
          paramc.ehE();
        }
        if (this.CWn == null) {
          this.CWn = ((t)getPlugin(t.class));
        }
        paramc = this.CWn;
        if (paramc != null) {
          paramc.eoD();
        }
        if (this.CWo == null) {
          this.CWo = ((v)getPlugin(v.class));
        }
        paramc = this.CWo;
        if (paramc != null)
        {
          paramc.eoD();
          AppMethodBeat.o(353830);
          return;
          if (paramBundle == null)
          {
            paramc = null;
            label179:
            paramBundle = ((e)business(e.class)).Eee;
            if (paramc != null) {
              break label265;
            }
          }
          label265:
          for (int i = 0;; i = paramc.intValue())
          {
            paramc = paramBundle.OL(i);
            paramBundle = (at)paramc.bsC;
            if (paramBundle == null) {
              break;
            }
            j.a locala = this.CwN;
            if (locala != null) {
              locala.a(paramBundle, ((Number)paramc.bsD).intValue(), false);
            }
            AppMethodBeat.o(353830);
            return;
            paramc = Integer.valueOf(paramBundle.getInt("PARAM_FINDER_LIVE_MUSIC_ID"));
            break label179;
          }
          paramc = this.CwN;
          if (paramc != null) {
            paramc.bLi();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.u
 * JD-Core Version:    0.7.0.1
 */