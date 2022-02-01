package com.tencent.mm.plugin.finder.live.viewmodel.state.anchor;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.plugin.g;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/state/anchor/FinderLiveAnchorEndUIC;", "Lcom/tencent/mm/plugin/finder/live/component/statecomponent/FinderLiveAnchorStateComponent;", "context", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "finderLiveAfterPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin;", "getFinderLiveAfterPlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin;", "setFinderLiveAfterPlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin;)V", "initPlugins", "", "onBindData", "baseRouter", "Lcom/tencent/mm/plugin/finder/live/view/router/FinderLiveAnchorRouter;", "onLiveEnd", "onLivePrepare", "onLiveStart", "onStatusChanged", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stopLive", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.finder.live.component.statecomponent.a
{
  public g EiK;
  public final String TAG;
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(357256);
    this.TAG = "FinderLiveAnchorEndUIC";
    AppMethodBeat.o(357256);
  }
  
  private static final void a(a parama)
  {
    AppMethodBeat.i(357263);
    kotlin.g.b.s.u(parama, "this$0");
    ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveLastRewardInfoStorage().axK(String.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((e)parama.business(e.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId));
    AppMethodBeat.o(357263);
  }
  
  public final void a(com.tencent.mm.plugin.finder.live.view.router.a parama)
  {
    AppMethodBeat.i(357287);
    kotlin.g.b.s.u(parama, "baseRouter");
    super.a(parama);
    parama = this.CCb;
    if (parama != null)
    {
      View localView = parama.findViewById(p.e.BFc);
      kotlin.g.b.s.s(localView, "it.findViewById(R.id.fin…ive_anchor_after_ui_root)");
      this.EiK = new g((ViewGroup)localView, (com.tencent.mm.live.b.b)parama);
      parama = this.EiK;
      if (parama != null) {
        parama.tO(8);
      }
    }
    AppMethodBeat.o(357287);
  }
  
  public final void bkX()
  {
    AppMethodBeat.i(357279);
    com.tencent.mm.live.core.core.a.b localb = this.ngB;
    if (localb != null) {
      localb.b((c)new d());
    }
    AppMethodBeat.o(357279);
  }
  
  public final void ezp()
  {
    AppMethodBeat.i(357295);
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.i)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.i.class)).Efn)
    {
      Log.i(this.TAG, "finish live by force quit, hide normal end page");
      localg = this.EiK;
      if (localg != null) {
        localg.tO(8);
      }
      AppMethodBeat.o(357295);
      return;
    }
    g localg = this.EiK;
    if (localg != null) {
      localg.bh((kotlin.g.a.a)new b(this));
    }
    com.tencent.threadpool.h.ahAA.bn(new a..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(357295);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", "", "errCode", "", "errType", "errMsg", "", "info", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/AnchorFinishInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class c
    extends u
    implements kotlin.g.a.s<Boolean, Integer, Integer, String, com.tencent.mm.plugin.finder.live.viewmodel.data.a, ah>
  {
    public c(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/state/anchor/FinderLiveAnchorEndUIC$stopLive$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements c
  {
    public final void callback(int paramInt, Bundle paramBundle) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.state.anchor.a
 * JD-Core Version:    0.7.0.1
 */