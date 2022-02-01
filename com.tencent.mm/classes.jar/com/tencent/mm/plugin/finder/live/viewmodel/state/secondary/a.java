package com.tencent.mm.plugin.finder.live.viewmodel.state.secondary;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.live.plugin.e;
import kotlin.g.a.s;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/state/secondary/FinderLiveSecondaryEndUIC;", "Lcom/tencent/mm/plugin/finder/live/component/statecomponent/FinderLiveSecondaryStateComponent;", "context", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "finderLiveAfterPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin;", "initPlugins", "", "onBindData", "baseRouter", "Lcom/tencent/mm/plugin/finder/live/view/router/FinderLiveSecondaryRouter;", "onLiveEnd", "extraMsg", "Landroid/os/Bundle;", "onLivePrepare", "onLiveStart", "onStatusChanged", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "stopLive", "plugin-finder_release"})
public final class a
  extends com.tencent.mm.plugin.finder.live.component.statecomponent.b
{
  public final String TAG;
  public e ziW;
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(248518);
    this.TAG = "FinderLiveSecondaryEndUIC";
    AppMethodBeat.o(248518);
  }
  
  public final void a(com.tencent.mm.plugin.finder.live.view.router.b paramb)
  {
    AppMethodBeat.i(248517);
    p.k(paramb, "baseRouter");
    super.a(paramb);
    paramb = this.ycX;
    if (paramb != null)
    {
      View localView = paramb.findViewById(b.f.finder_live_anchor_after_ui_root);
      p.j(localView, "it.findViewById(R.id.fin…ive_anchor_after_ui_root)");
      this.ziW = new e((ViewGroup)localView, (com.tencent.mm.live.c.b)paramb);
      paramb = this.ziW;
      if (paramb != null)
      {
        paramb.tU(8);
        AppMethodBeat.o(248517);
        return;
      }
      AppMethodBeat.o(248517);
      return;
    }
    AppMethodBeat.o(248517);
  }
  
  public final void aRk()
  {
    AppMethodBeat.i(248515);
    com.tencent.mm.live.core.core.trtc.a locala = this.kHp;
    if (locala != null)
    {
      locala.b((c)new c());
      AppMethodBeat.o(248515);
      return;
    }
    AppMethodBeat.o(248515);
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "success", "", "errCode", "", "errType", "errMsg", "", "info", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/AnchorFinishInfo;", "invoke"})
  public static final class b
    extends q
    implements s<Boolean, Integer, Integer, String, com.tencent.mm.plugin.finder.live.viewmodel.data.a, x>
  {
    public b(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/viewmodel/state/secondary/FinderLiveSecondaryEndUIC$stopLive$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-finder_release"})
  public static final class c
    implements c
  {
    public final void callback(int paramInt, Bundle paramBundle) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.state.secondary.a
 * JD-Core Version:    0.7.0.1
 */