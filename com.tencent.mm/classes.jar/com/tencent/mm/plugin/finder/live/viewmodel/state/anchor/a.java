package com.tencent.mm.plugin.finder.live.viewmodel.state.anchor;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.c.a.a.a.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.live.plugin.e;
import com.tencent.mm.protocal.protobuf.bac;
import kotlin.g.a.s;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/state/anchor/FinderLiveAnchorEndUIC;", "Lcom/tencent/mm/plugin/finder/live/component/statecomponent/FinderLiveAnchorStateComponent;", "context", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "finderLiveAfterPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin;", "getFinderLiveAfterPlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin;", "setFinderLiveAfterPlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin;)V", "initPlugins", "", "onBindData", "baseRouter", "Lcom/tencent/mm/plugin/finder/live/view/router/FinderLiveAnchorRouter;", "onLiveEnd", "onLivePrepare", "onLiveStart", "onStatusChanged", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stopLive", "plugin-finder_release"})
public final class a
  extends com.tencent.mm.plugin.finder.live.component.statecomponent.a
{
  public final String TAG;
  public e ziW;
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(288547);
    this.TAG = "FinderLiveAnchorEndUIC";
    AppMethodBeat.o(288547);
  }
  
  public final void a(com.tencent.mm.plugin.finder.live.view.router.a parama)
  {
    AppMethodBeat.i(288546);
    p.k(parama, "baseRouter");
    super.a(parama);
    parama = this.ycU;
    if (parama != null)
    {
      View localView = parama.findViewById(b.f.finder_live_anchor_after_ui_root);
      p.j(localView, "it.findViewById(R.id.fin…ive_anchor_after_ui_root)");
      this.ziW = new e((ViewGroup)localView, (com.tencent.mm.live.c.b)parama);
      parama = this.ziW;
      if (parama != null)
      {
        parama.tU(8);
        AppMethodBeat.o(288546);
        return;
      }
      AppMethodBeat.o(288546);
      return;
    }
    AppMethodBeat.o(288546);
  }
  
  public final void aRk()
  {
    AppMethodBeat.i(288545);
    com.tencent.mm.live.core.core.a.b localb = this.kDk;
    if (localb != null)
    {
      localb.b((com.tencent.mm.live.core.core.c)new d());
      AppMethodBeat.o(288545);
      return;
    }
    AppMethodBeat.o(288545);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    public a(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class b
    implements Runnable
  {
    public b(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(287716);
      ((com.tencent.c.a.a.a.b)h.ag(com.tencent.c.a.a.a.b.class)).getFinderLiveLastRewardInfoStorage().aCJ(String.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.ziX.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId));
      AppMethodBeat.o(287716);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "success", "", "errCode", "", "errType", "errMsg", "", "info", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/AnchorFinishInfo;", "invoke"})
  public static final class c
    extends q
    implements s<Boolean, Integer, Integer, String, com.tencent.mm.plugin.finder.live.viewmodel.data.a, x>
  {
    public c(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/FinderLiveAnchorEndUIC$stopLive$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-finder_release"})
  public static final class d
    implements com.tencent.mm.live.core.core.c
  {
    public final void callback(int paramInt, Bundle paramBundle) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.a
 * JD-Core Version:    0.7.0.1
 */