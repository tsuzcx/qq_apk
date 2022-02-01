package com.tencent.mm.plugin.finder.live.viewmodel.state.secondary;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.plugin.g;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/state/secondary/FinderLiveSecondaryEndUIC;", "Lcom/tencent/mm/plugin/finder/live/component/statecomponent/FinderLiveSecondaryStateComponent;", "context", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "finderLiveAfterPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin;", "initPlugins", "", "onBindData", "baseRouter", "Lcom/tencent/mm/plugin/finder/live/view/router/FinderLiveSecondaryRouter;", "onLiveEnd", "extraMsg", "Landroid/os/Bundle;", "onLivePrepare", "onLiveStart", "onStatusChanged", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "stopLive", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.finder.live.component.statecomponent.c
{
  public g EiK;
  public final String TAG;
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(357124);
    this.TAG = "FinderLiveSecondaryEndUIC";
    AppMethodBeat.o(357124);
  }
  
  public final void a(com.tencent.mm.plugin.finder.live.view.router.b paramb)
  {
    AppMethodBeat.i(357150);
    kotlin.g.b.s.u(paramb, "baseRouter");
    super.a(paramb);
    paramb = this.CCe;
    if (paramb != null)
    {
      View localView = paramb.findViewById(p.e.BFc);
      kotlin.g.b.s.s(localView, "it.findViewById(R.id.fin…ive_anchor_after_ui_root)");
      this.EiK = new g((ViewGroup)localView, (com.tencent.mm.live.b.b)paramb);
      paramb = this.EiK;
      if (paramb != null) {
        paramb.tO(8);
      }
    }
    AppMethodBeat.o(357150);
  }
  
  public final void bkX()
  {
    AppMethodBeat.i(357142);
    com.tencent.mm.live.core.core.trtc.a locala = this.nkg;
    if (locala != null) {
      locala.b((com.tencent.mm.live.core.core.c)new e());
    }
    AppMethodBeat.o(357142);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    public b(a parama)
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
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", "", "errCode", "", "errType", "errMsg", "", "info", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/AnchorFinishInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class d
    extends u
    implements kotlin.g.a.s<Boolean, Integer, Integer, String, com.tencent.mm.plugin.finder.live.viewmodel.data.a, ah>
  {
    public d(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/FinderLiveSecondaryEndUIC$stopLive$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements com.tencent.mm.live.core.core.c
  {
    public final void callback(int paramInt, Bundle paramBundle) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.a
 * JD-Core Version:    0.7.0.1
 */