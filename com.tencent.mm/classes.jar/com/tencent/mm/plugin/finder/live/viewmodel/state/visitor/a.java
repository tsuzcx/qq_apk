package com.tencent.mm.plugin.finder.live.viewmodel.state.visitor;

import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b;
import com.tencent.mm.plugin.finder.live.component.statecomponent.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.plugin.ch;
import com.tencent.mm.plugin.finder.live.view.router.c;
import com.tencent.mm.protocal.protobuf.bui;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorEndUIC;", "Lcom/tencent/mm/plugin/finder/live/component/statecomponent/FinderLiveVisitorStateComponent;", "context", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "finderLiveAfterPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorAfterPlugin;", "hidePlugins", "", "initPlugins", "notifyLiveFinish", "onBindData", "baseRouter", "Lcom/tencent/mm/plugin/finder/live/view/router/FinderLiveVisitorRouter;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "onLiveEnd", "extraMsg", "Landroid/os/Bundle;", "onLiveIdle", "onLiveStart", "onMount", "onRelease", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSelected", "onStart", "onStatusChanged", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "onStop", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends d
{
  public ch Ekc;
  public final String TAG;
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(357385);
    this.TAG = "FinderLiveVisitorEndUIC";
    AppMethodBeat.o(357385);
  }
  
  public final void a(c paramc, bui parambui)
  {
    AppMethodBeat.i(357407);
    s.u(paramc, "baseRouter");
    super.a(paramc, parambui);
    paramc = this.CCg;
    if ((paramc != null) && (this.Ekc == null)) {
      this.Ekc = new ch((ViewGroup)genRootViewByStub(p.e.BTE, (View)paramc), (b)paramc);
    }
    eqj();
    AppMethodBeat.o(357407);
  }
  
  public final void aEB()
  {
    AppMethodBeat.i(357414);
    super.aEB();
    AppMethodBeat.o(357414);
  }
  
  public final void eqj()
  {
    AppMethodBeat.i(357391);
    ch localch = this.Ekc;
    if (localch != null) {
      localch.tO(8);
    }
    AppMethodBeat.o(357391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.a
 * JD-Core Version:    0.7.0.1
 */