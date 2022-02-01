package com.tencent.mm.plugin.finder.live.viewmodel.state.visitor;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.plugin.finder.live.component.statecomponent.d;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.plugin.cu;
import com.tencent.mm.plugin.finder.live.viewmodel.data.g;
import com.tencent.mm.plugin.finder.live.viewmodel.data.j;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorPrepareUIC;", "Lcom/tencent/mm/plugin/finder/live/component/statecomponent/FinderLiveVisitorStateComponent;", "context", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "showVisitorGuide", "", "getShowVisitorGuide", "()Z", "setShowVisitorGuide", "(Z)V", "visitorRoleGuidePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorRoleGuidePlugin;", "activateFromMiniWindow", "", "activateFromNormal", "handleOnGetFeedObject", "feedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "initVisitorRoleGuidePlugin", "livePrepared", "byMiniWin", "loadFeedAndPrepareLive", "onBindData", "baseRouter", "Lcom/tencent/mm/plugin/finder/live/view/router/FinderLiveVisitorRouter;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "onSelected", "onStart", "onStop", "prepareLive", "isFromFloat", "restart", "setVisitorDefaultBg", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends d
{
  public cu Elp;
  public boolean Elq;
  public final String TAG;
  
  public c(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(357381);
    this.TAG = "FinderLiveVisitorPrepareUIC";
    AppMethodBeat.o(357381);
  }
  
  private final void ezS()
  {
    int i = 0;
    AppMethodBeat.i(357387);
    com.tencent.d.a.b.a.a locala = ((com.tencent.d.a.b.a.e)h.az(com.tencent.d.a.b.a.e.class)).getNearbyEnterTargetLiveRoomChecker();
    long l = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN;
    String str = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).nonceId;
    Object localObject = aj.CGT;
    localObject = aj.egD();
    if (localObject == null) {}
    for (;;)
    {
      locala.a(l, str, i, (b)new c(this));
      AppMethodBeat.o(357387);
      return;
      localObject = ((g)localObject).Bwy;
      if (localObject != null) {
        i = ((j)localObject).AJo;
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.finder.live.view.router.c paramc, bui parambui)
  {
    int i = 1;
    AppMethodBeat.i(357420);
    s.u(paramc, "baseRouter");
    super.a(paramc, parambui);
    paramc = this.CCg;
    if ((paramc != null) && (paramc.isLandscape() == true)) {
      if (i == 0)
      {
        paramc = this.CCg;
        if (paramc != null) {
          break label133;
        }
      }
    }
    label133:
    for (boolean bool = false;; bool = com.tencent.mm.plugin.finder.live.view.a.fillBlurBg$default((com.tencent.mm.plugin.finder.live.view.a)paramc, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC, false, 2, null))
    {
      if (bool)
      {
        paramc = this.CCg;
        if (paramc != null) {
          paramc.hideProgress();
        }
      }
      Log.i(this.TAG, "setVisitorDefaultBg liveId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId + ",haveBg:" + bool + '!');
      AppMethodBeat.o(357420);
      return;
      i = 0;
      break;
    }
  }
  
  public final void aEB()
  {
    AppMethodBeat.i(357434);
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyI();
    AppMethodBeat.o(357434);
  }
  
  public final void eul()
  {
    int i = 1;
    AppMethodBeat.i(357428);
    Object localObject = this.data;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.f)localObject).Ebr;
      if ((localObject == null) || (((LiveConfig)localObject).mIR != true)) {}
    }
    while (i != 0)
    {
      ezS();
      AppMethodBeat.o(357428);
      return;
      i = 0;
    }
    sv(false);
    AppMethodBeat.o(357428);
  }
  
  public final void sv(boolean paramBoolean)
  {
    AppMethodBeat.i(357430);
    com.tencent.mm.plugin.finder.live.view.router.c localc = this.CCg;
    if (localc != null) {
      localc.prepareToStart(paramBoolean);
    }
    AppMethodBeat.o(357430);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(c paramc, FinderObject paramFinderObject)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    public b(com.tencent.mm.plugin.finder.live.view.router.c paramc, c paramc1)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderObject;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<FinderObject, ah>
  {
    c(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.c
 * JD-Core Version:    0.7.0.1
 */