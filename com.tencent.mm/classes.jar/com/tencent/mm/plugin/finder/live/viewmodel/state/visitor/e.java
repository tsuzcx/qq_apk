package com.tencent.mm.plugin.finder.live.viewmodel.state.visitor;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.api.d;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.i;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.cgi.cr;
import com.tencent.mm.plugin.finder.live.plugin.dk;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorPrepareUIC;", "Lcom/tencent/mm/plugin/finder/live/component/statecomponent/FinderLiveVisitorStateComponent;", "context", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "visitorRoleGuidePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorRoleGuidePlugin;", "activateFromMiniWindow", "", "activateFromNormal", "handleOnGetFeedObject", "feedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "initVisitorRoleGuidePlugin", "livePrepared", "byMiniWin", "", "onBindData", "baseRouter", "Lcom/tencent/mm/plugin/finder/live/view/router/FinderLiveVisitorRouter;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "onStart", "onStop", "prepareLive", "isFromFloat", "restart", "setVisitorDefaultBg", "plugin-finder_release"})
public final class e
  extends com.tencent.mm.plugin.finder.live.component.statecomponent.c
{
  public final String TAG;
  public dk zlf;
  
  public e(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(282193);
    this.TAG = "FinderLiveVisitorPrepareUIC";
    AppMethodBeat.o(282193);
  }
  
  public final void a(com.tencent.mm.plugin.finder.live.view.router.c paramc, bid parambid)
  {
    boolean bool1 = false;
    AppMethodBeat.i(282190);
    p.k(paramc, "baseRouter");
    super.a(paramc, parambid);
    if (paramc.getAudienPreloadCDNLiveConfig())
    {
      paramc = d.wZQ;
      parambid = d.a.aAK(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig);
      if (parambid == null) {
        break label304;
      }
      paramc = parambid.Mm();
      paramc = (CharSequence)paramc;
      if ((paramc != null) && (paramc.length() != 0)) {
        break label309;
      }
      i = 1;
      label76:
      if (i == 0)
      {
        if (parambid == null) {
          break label314;
        }
        paramc = parambid.getNickname();
        label89:
        paramc = (CharSequence)paramc;
        if ((paramc != null) && (paramc.length() != 0)) {
          break label319;
        }
      }
    }
    label304:
    label309:
    label314:
    label319:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramc = new cr(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig, 0L, null, 0, null, 0, 0L, 104);
        paramc.xer = true;
        h.aGY().b((com.tencent.mm.an.q)paramc);
      }
      paramc = this.ycZ;
      if ((paramc == null) || (paramc.isLandscape() != true))
      {
        paramc = this.ycZ;
        if (paramc != null) {
          bool1 = com.tencent.mm.plugin.finder.live.view.a.fillBlurBg$default(paramc, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig, false, 2, null);
        }
        paramc = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        boolean bool2 = com.tencent.mm.plugin.finder.live.utils.a.dEB();
        if ((bool1) && (bool2))
        {
          paramc = this.ycZ;
          if (paramc != null) {
            paramc.hideProgress();
          }
        }
        Log.i(this.TAG, "setVisitorDefaultBg liveId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId + ",haveBg:" + bool1 + ",config:" + bool2 + '!');
      }
      AppMethodBeat.o(282190);
      return;
      paramc = null;
      break;
      i = 0;
      break label76;
      paramc = null;
      break label89;
    }
  }
  
  public final void dHF()
  {
    AppMethodBeat.i(282191);
    Object localObject1 = this.ycZ;
    if (localObject1 != null)
    {
      if (this.zlf == null)
      {
        Object localObject2 = ((com.tencent.mm.plugin.finder.live.view.router.c)localObject1).getContext();
        if (localObject2 == null)
        {
          localObject1 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(282191);
          throw ((Throwable)localObject1);
        }
        localObject2 = (Activity)localObject2;
        FrameLayout localFrameLayout = (FrameLayout)((Activity)localObject2).findViewById(b.f.finder_live_content_root);
        Object localObject3 = ((Activity)localObject2).getLayoutInflater().inflate(b.g.finder_live_visitor_role_guide_ui, (ViewGroup)localFrameLayout, false);
        if (localObject3 == null)
        {
          localObject1 = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(282191);
          throw ((Throwable)localObject1);
        }
        localObject3 = (ViewGroup)localObject3;
        if (localFrameLayout != null) {
          localFrameLayout.addView((View)localObject3);
        }
        ((com.tencent.mm.plugin.finder.live.view.router.c)localObject1).hideProgress();
        this.zlf = new dk((ViewGroup)localObject3, (com.tencent.mm.live.c.b)localObject1, (Activity)localObject2, getReportObj());
        localObject2 = this.zlf;
        if (localObject2 != null)
        {
          ((dk)localObject2).yzP = ((kotlin.g.a.a)new c((com.tencent.mm.plugin.finder.live.view.router.c)localObject1, this));
          AppMethodBeat.o(282191);
          return;
        }
      }
      AppMethodBeat.o(282191);
      return;
    }
    AppMethodBeat.o(282191);
  }
  
  public final void pF(boolean paramBoolean)
  {
    AppMethodBeat.i(282192);
    com.tencent.mm.plugin.finder.live.view.router.c localc = this.ycZ;
    if (localc != null)
    {
      localc.prepareToStart(paramBoolean);
      AppMethodBeat.o(282192);
      return;
    }
    AppMethodBeat.o(282192);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "invoke"})
  public static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.b<FinderObject, x>
  {
    public a(e parame)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    b(e parame, FinderObject paramFinderObject)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorPrepareUIC$initVisitorRoleGuidePlugin$1$1"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    c(com.tencent.mm.plugin.finder.live.view.router.c paramc, e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.e
 * JD-Core Version:    0.7.0.1
 */