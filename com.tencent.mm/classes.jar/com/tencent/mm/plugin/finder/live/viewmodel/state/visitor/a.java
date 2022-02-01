package com.tencent.mm.plugin.finder.live.viewmodel.state.visitor;

import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.live.plugin.cw;
import com.tencent.mm.protocal.protobuf.bid;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorEndUIC;", "Lcom/tencent/mm/plugin/finder/live/component/statecomponent/FinderLiveVisitorStateComponent;", "context", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "finderLiveAfterPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorAfterPlugin;", "hidePlugins", "", "initPlugins", "notifyLiveFinish", "onBindData", "baseRouter", "Lcom/tencent/mm/plugin/finder/live/view/router/FinderLiveVisitorRouter;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "onLiveEnd", "extraMsg", "Landroid/os/Bundle;", "onLivePrepare", "onLiveStart", "onMount", "onRelease", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStart", "onStatusChanged", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "onStop", "plugin-finder_release"})
public final class a
  extends com.tencent.mm.plugin.finder.live.component.statecomponent.c
{
  public final String TAG;
  public cw zkn;
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(281433);
    this.TAG = "FinderLiveVisitorEndUIC";
    AppMethodBeat.o(281433);
  }
  
  public final void a(com.tencent.mm.plugin.finder.live.view.router.c paramc, bid parambid)
  {
    AppMethodBeat.i(281431);
    p.k(paramc, "baseRouter");
    super.a(paramc, parambid);
    paramc = this.ycZ;
    if ((paramc != null) && (this.zkn == null))
    {
      parambid = paramc.findViewById(b.f.finder_live_visitor_after_ui_root);
      p.j(parambid, "it.findViewById(R.id.fin…ve_visitor_after_ui_root)");
      this.zkn = new cw((ViewGroup)parambid, (b)paramc);
    }
    dHu();
    AppMethodBeat.o(281431);
  }
  
  public final void dHu()
  {
    AppMethodBeat.i(281429);
    cw localcw = this.zkn;
    if (localcw != null)
    {
      localcw.tU(8);
      AppMethodBeat.o(281429);
      return;
    }
    AppMethodBeat.o(281429);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.a
 * JD-Core Version:    0.7.0.1
 */