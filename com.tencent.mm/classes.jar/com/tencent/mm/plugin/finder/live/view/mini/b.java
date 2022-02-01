package com.tencent.mm.plugin.finder.live.view.mini;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.lifecycle.j.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.plugin.finder.api.l;
import com.tencent.mm.plugin.finder.live.component.ao;
import com.tencent.mm.plugin.finder.live.component.w.a;
import com.tencent.mm.plugin.finder.live.fluent.h.a;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.ar;
import com.tencent.mm.plugin.finder.live.plugin.at;
import com.tencent.mm.plugin.finder.live.report.q.bw;
import com.tencent.mm.plugin.finder.live.report.q.c;
import com.tencent.mm.plugin.finder.live.report.q.z;
import com.tencent.mm.plugin.finder.live.util.m;
import com.tencent.mm.plugin.finder.live.view.FinderLiveMiniView;
import com.tencent.mm.plugin.finder.live.view.FinderLiveVisitorPluginLayout;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.q;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.bj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.component.k.b;
import com.tencent.rtmp.ui.TXCloudVideoView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import org.libpag.PAGFile;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/mini/FinderLiveMiniWindowManager;", "", "()V", "TAG", "", "miniView", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveMiniView;", "getMiniView", "()Lcom/tencent/mm/plugin/finder/live/view/FinderLiveMiniView;", "setMiniView", "(Lcom/tencent/mm/plugin/finder/live/view/FinderLiveMiniView;)V", "miniWindowClickListener", "Landroid/view/View$OnClickListener;", "miniWindowCloseClickListener", "miniWindowStateCallback", "Lcom/tencent/mm/live/core/core/trtc/MiniWindowStateCallback;", "getMiniWindowStateCallback", "()Lcom/tencent/mm/live/core/core/trtc/MiniWindowStateCallback;", "olympicsStatusListener", "Lkotlin/Function0;", "", "reporter", "Lcom/tencent/mm/plugin/finder/live/view/mini/FinderLiveMiniWindowReporter;", "getReporter", "()Lcom/tencent/mm/plugin/finder/live/view/mini/FinderLiveMiniWindowReporter;", "createMiniView", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "isAnchor", "", "isEnableFluentSwitchEnter", "miniWindowStartActivity", "it", "Landroid/view/View;", "launchWithAnim", "feedId", "", "notifyGameWelfareTaskCloseMiniApp", "onCloseSelfLiveMic", "onLinkSelfLiveMic", "refreshMiniWindow", "refreshOlympicsView", "release", "updateMiniWindow", "sourceType", "", "micData", "Lorg/json/JSONObject;", "checkDiff", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public final c DVA;
  public final kotlin.g.a.a<ah> DVB;
  private final View.OnClickListener DVC;
  public FinderLiveMiniView DVz;
  final String TAG;
  public final com.tencent.mm.live.core.core.trtc.b mRr;
  private View.OnClickListener naa;
  
  public b()
  {
    AppMethodBeat.i(358296);
    this.TAG = "Finder.FinderLiveMiniWindowManager";
    this.DVA = new c();
    this.DVB = ((kotlin.g.a.a)new c(this));
    this.naa = new b..ExternalSyntheticLambda0(this);
    this.DVC = new b..ExternalSyntheticLambda1(this);
    this.mRr = ((com.tencent.mm.live.core.core.trtc.b)new b(this));
    AppMethodBeat.o(358296);
  }
  
  private static final void a(b paramb, final View paramView)
  {
    AppMethodBeat.i(358321);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramb);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/mini/FinderLiveMiniWindowManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramb, "this$0");
    localObject1 = paramb.TAG;
    localObject2 = aj.CGT;
    Log.i((String)localObject1, s.X("miniWindowClickListener onClick ", aj.egD()));
    paramb.DVA.sc(false);
    localObject1 = com.tencent.mm.plugin.finder.live.fluent.a.CCh;
    if (com.tencent.mm.plugin.finder.live.fluent.a.ejm())
    {
      localObject1 = com.tencent.mm.plugin.finder.live.fluent.g.CCu;
      if (!com.tencent.mm.plugin.finder.live.fluent.g.ejs())
      {
        localObject1 = aj.CGT;
        if (!aj.bUB())
        {
          Log.i(paramb.TAG, "miniWindowClickListener isEnableFluentClick = false");
          com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/mini/FinderLiveMiniWindowManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(358321);
          return;
        }
      }
    }
    localObject1 = aj.CGT;
    localObject1 = (e)aj.business(e.class);
    boolean bool4;
    if (localObject1 == null)
    {
      i = 0;
      bool4 = com.tencent.mm.ae.d.ee(i, 524288);
      localObject1 = aj.CGT;
      localObject1 = aj.elk();
      if (localObject1 != null) {
        break label262;
      }
      localObject1 = null;
      label205:
      if (!(localObject1 instanceof Activity)) {
        break label619;
      }
      localObject1 = aj.CGT;
      localObject1 = aj.elk();
      if (localObject1 != null) {
        break label272;
      }
    }
    label262:
    label272:
    for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.finder.live.view.a)localObject1).getContext())
    {
      if (localObject1 != null) {
        break label282;
      }
      paramb = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(358321);
      throw paramb;
      i = ((e)localObject1).EcS;
      break;
      localObject1 = ((com.tencent.mm.plugin.finder.live.view.a)localObject1).getContext();
      break label205;
    }
    label282:
    boolean bool1;
    boolean bool2;
    label319:
    label352:
    boolean bool3;
    if (((Activity)localObject1).isFinishing())
    {
      bool1 = true;
      localObject1 = aj.CGT;
      localObject1 = (e)aj.business(e.class);
      if (localObject1 != null) {
        break label625;
      }
      bool2 = true;
      boolean bool5 = AppForegroundDelegate.heY.eLx;
      localObject1 = aj.CGT;
      localObject1 = aj.getLiveCore();
      if (!(localObject1 instanceof com.tencent.mm.live.core.core.f.c)) {
        break label635;
      }
      localObject1 = (com.tencent.mm.live.core.core.f.c)localObject1;
      if (localObject1 != null) {
        break label641;
      }
      bool3 = false;
      label360:
      localObject1 = paramb.TAG;
      localObject2 = new StringBuilder("isEnableFluentSwitchEnter isPause: ").append(bool4).append(" isActivityFinish: ").append(bool1).append(" isLiveFinish: ").append(bool2).append(" foreground: ").append(bool5).append(" isAnchor： ");
      localObject3 = aj.CGT;
      Log.i((String)localObject1, aj.bUB() + " isVisitorPlaying:" + bool3);
      localObject1 = com.tencent.mm.plugin.finder.live.fluent.a.CCh;
      if ((!com.tencent.mm.plugin.finder.live.fluent.a.ejm()) || (!bool5) || (!bool1) || (bool2) || (bool4)) {
        break label665;
      }
      localObject1 = aj.CGT;
      if ((aj.bUB()) || (!bool3)) {
        break label665;
      }
      i = 1;
      label503:
      if (i == 0) {
        break label1148;
      }
      localObject1 = aj.CGT;
      localObject1 = aj.getLiveCore();
      if (!(localObject1 instanceof com.tencent.mm.live.core.core.f.d)) {
        break label670;
      }
      localObject2 = (com.tencent.mm.live.core.core.f.d)localObject1;
      label532:
      if (localObject2 != null) {
        break label676;
      }
      localObject1 = null;
      label540:
      if (localObject2 != null) {
        break label704;
      }
    }
    label641:
    label665:
    label670:
    label676:
    label704:
    for (Object localObject3 = null;; localObject3 = ((com.tencent.mm.live.core.core.f.d)localObject2).mUn.mJG)
    {
      Log.i(paramb.TAG, s.X("miniWindowClickListener player:", localObject3));
      if ((localObject1 != null) && (localObject3 != null) && ((localObject1 instanceof com.tencent.mm.live.core.view.a))) {
        break label717;
      }
      s.s(paramView, "it");
      paramb.a(paramView, false, 0L);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/mini/FinderLiveMiniWindowManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(358321);
      return;
      label619:
      bool1 = false;
      break;
      label625:
      bool2 = ((e)localObject1).eyA();
      break label319;
      label635:
      localObject1 = null;
      break label352;
      localObject2 = aj.CGT;
      aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      bool3 = ((com.tencent.mm.live.core.core.f.c)localObject1).bfC();
      break label360;
      i = 0;
      break label503;
      localObject2 = null;
      break label532;
      localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject2).mRq;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label540;
      }
      localObject1 = ((com.tencent.mm.live.core.mini.b)localObject1).mUN;
      break label540;
    }
    label717:
    Object localObject4 = null;
    int j = ((com.tencent.mm.live.core.view.a)localObject1).getChildCount();
    int i = 0;
    if (i < j)
    {
      localObject2 = ((com.tencent.mm.live.core.view.a)localObject1).getChildAt(i);
      if ((localObject2 instanceof TXCloudVideoView)) {}
      for (localObject2 = (TXCloudVideoView)localObject2;; localObject2 = null)
      {
        if (localObject2 != null) {
          localObject4 = localObject2;
        }
        i += 1;
        break;
      }
    }
    localObject1 = aj.CGT;
    localObject1 = (e)aj.business(e.class);
    final long l;
    if (localObject1 == null)
    {
      l = 0L;
      localObject1 = aj.CGT;
      localObject1 = (e)aj.business(e.class);
      if (localObject1 != null) {
        break label962;
      }
      i = 0;
      label829:
      localObject1 = aj.CGT;
      localObject1 = (e)aj.business(e.class);
      if (localObject1 != null) {
        break label971;
      }
    }
    label962:
    label971:
    for (j = 0;; j = ((e)localObject1).videoHeight)
    {
      if ((localObject4 != null) && (l != 0L) && (i != 0) && (j != 0) && (((TXCloudVideoView)localObject4).getVideoView() != null) && (((TXCloudVideoView)localObject4).getVideoView().getSurfaceTexture() != null)) {
        break label980;
      }
      s.s(paramView, "it");
      paramb.a(paramView, false, 0L);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/mini/FinderLiveMiniWindowManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(358321);
      return;
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((e)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (localObject1 == null)
      {
        l = 0L;
        break;
      }
      l = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject1).hKN;
      break;
      i = ((e)localObject1).videoWidth;
      break label829;
    }
    label980:
    int k = bd.bs(MMApplicationContext.getContext(), com.tencent.mm.live.core.a.b.float_ball_voip_view_video_width);
    int m = bd.bs(MMApplicationContext.getContext(), com.tencent.mm.live.core.a.b.float_ball_voip_view_video_height);
    com.tencent.mm.plugin.ball.f.f.d(true, true, true);
    localObject1 = h.a.CCF;
    localObject2 = (View)localObject4;
    localObject4 = ((TXCloudVideoView)localObject4).getVideoView();
    s.s(localObject4, "playerView!!.videoView");
    localObject1 = new com.tencent.mm.plugin.finder.live.fluent.f((h.a)localObject1, true, l, (View)localObject2, (TextureView)localObject4, (com.tencent.mm.live.core.core.c.b)localObject3, i, j, 1.0F * i / j, new int[] { k, m });
    localObject2 = com.tencent.mm.plugin.finder.live.fluent.g.CCu;
    localObject2 = MMApplicationContext.getContext();
    s.s(localObject2, "getContext()");
    com.tencent.mm.plugin.finder.live.fluent.g.a((Context)localObject2, (com.tencent.mm.plugin.finder.live.fluent.h)localObject1).aX((kotlin.g.a.a)new a(paramb, paramView, l));
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/mini/FinderLiveMiniWindowManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(358321);
      return;
      label1148:
      s.s(paramView, "it");
      paramb.a(paramView, false, 0L);
    }
  }
  
  private static final void b(b paramb, View paramView)
  {
    Object localObject1 = null;
    boolean bool1 = false;
    AppMethodBeat.i(358336);
    Object localObject2 = new Object();
    Object localObject3 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject3).cH(paramb);
    ((com.tencent.mm.hellhoundlib.b.b)localObject3).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/mini/FinderLiveMiniWindowManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject2, ((com.tencent.mm.hellhoundlib.b.b)localObject3).aYj());
    s.u(paramb, "this$0");
    paramb.DVA.sc(true);
    boolean bool2 = Util.isTopApplication(MMApplicationContext.getContext());
    paramView = aj.CGT;
    if (!aj.bUB())
    {
      paramView = m.DJb;
      paramView = aj.CGT;
      m.l(aj.elr());
      paramView = com.tencent.mm.ui.component.k.aeZF;
      ((l)com.tencent.mm.ui.component.k.cn(com.tencent.mm.plugin.findersdk.a.cn.class).cq(l.class)).dUq();
    }
    localObject2 = paramb.TAG;
    localObject3 = new StringBuilder("mini window close,is top applicaton:").append(bool2).append(",is shopping in MiniPro:");
    paramView = aj.CGT;
    paramView = (q)aj.business(q.class);
    if (paramView == null)
    {
      paramView = null;
      paramView = ((StringBuilder)localObject3).append(paramView).append(",isAnchor:");
      localObject3 = aj.CGT;
      Log.i((String)localObject2, aj.bUB());
      paramView = aj.CGT;
      if (aj.bUB()) {
        break label311;
      }
      paramView = aj.CGT;
      paramView = (q)aj.business(q.class);
      if ((paramView == null) || (paramView.Eij != true)) {
        break label306;
      }
    }
    label306:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label311;
      }
      paramb = aj.CGT;
      paramb = aj.getLiveCore();
      if (paramb != null) {
        paramb.beY();
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/mini/FinderLiveMiniWindowManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(358336);
      return;
      paramView = Boolean.valueOf(paramView.Eij);
      break;
    }
    label311:
    paramView = aj.CGT;
    if (!aj.bUB())
    {
      paramView = aj.CGT;
      paramView = (e)aj.business(e.class);
      if ((paramView != null) && (paramView.Edf == true)) {}
      for (i = 1; i != 0; i = 0)
      {
        ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ball.c.b.class)).mq(true);
        paramb = com.tencent.mm.live.core.mini.a.mUD;
        paramb = com.tencent.mm.live.core.mini.a.b.mUF;
        com.tencent.mm.live.core.mini.a.b.bfP().mi(false);
        paramb = aj.CGT;
        paramb = aj.getLiveCore();
        if (paramb != null) {
          paramb.bcg();
        }
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/mini/FinderLiveMiniWindowManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(358336);
        return;
      }
    }
    paramView = aj.CGT;
    paramView = aj.elk();
    label505:
    int j;
    if ((paramView instanceof FinderLiveVisitorPluginLayout))
    {
      paramView = (FinderLiveVisitorPluginLayout)paramView;
      if (paramView != null)
      {
        paramView = (at)paramView.getPlugin(at.class);
        if (paramView != null)
        {
          paramView = paramView.Cyv;
          if (paramView != null) {
            paramView.eic();
          }
        }
      }
      paramView = ao.CAQ;
      paramView = aj.CGT;
      paramView = (e)aj.business(e.class);
      if (paramView != null) {
        break label668;
      }
      i = 0;
      paramView = aj.CGT;
      paramView = (e)aj.business(e.class);
      if (paramView != null) {
        break label676;
      }
      j = 0;
      label524:
      ao.b(3, i, j, false, 8);
      paramView = aj.CGT;
      aj.qE(bool2);
      paramb = paramb.DVz;
      if (paramb != null) {
        break label684;
      }
      label551:
      if (!bool1)
      {
        ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveVideoDefinitionStorage().eud();
        ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveChargeInfoStorage().etV();
        localObject2 = com.tencent.mm.plugin.finder.live.report.k.Doi;
        paramb = aj.CGT;
        paramb = aj.elk();
        if (paramb != null) {
          break label693;
        }
        paramb = null;
        label609:
        localObject3 = q.bw.DDy;
        paramView = aj.CGT;
        paramView = aj.egD();
        if (paramView != null) {
          break label701;
        }
      }
    }
    label668:
    label676:
    label684:
    label693:
    label701:
    for (paramView = localObject1;; paramView = paramView.CFn)
    {
      ((com.tencent.mm.plugin.finder.live.report.k)localObject2).a(paramb, (q.bw)localObject3, paramView);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/mini/FinderLiveMiniWindowManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(358336);
      return;
      paramView = null;
      break;
      i = paramView.Eeo;
      break label505;
      j = paramView.EcS;
      break label524;
      bool1 = paramb.hKC;
      break label551;
      paramb = paramb.getContext();
      break label609;
    }
  }
  
  final void a(View paramView, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(358390);
    Object localObject1 = ar.CIh;
    ar.emj();
    localObject1 = aj.CGT;
    localObject1 = aj.getLiveCore();
    if (localObject1 != null) {
      ((com.tencent.mm.live.core.core.trtc.a)localObject1).bcg();
    }
    localObject1 = aj.CGT;
    int i;
    if (aj.bUB())
    {
      localObject1 = aj.CGT;
      if ((aj.getLiveCore() instanceof com.tencent.mm.live.core.core.a.b))
      {
        localObject1 = aj.CGT;
        localObject1 = (e)aj.business(e.class);
        if ((localObject1 != null) && (((e)localObject1).Eet == true))
        {
          i = 1;
          if (i != 0) {
            break label416;
          }
          localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          paramView = paramView.getContext();
          s.s(paramView, "it.context");
          paramView = com.tencent.mm.plugin.finder.live.utils.a.gB(paramView);
          label118:
          localObject1 = new Intent(MMApplicationContext.getContext(), paramView);
          Object localObject2 = aj.CGT;
          if (!aj.bUB())
          {
            localObject2 = aj.CGT;
            localObject2 = aj.elk();
            if ((localObject2 != null) && (!s.p(((com.tencent.mm.plugin.finder.live.view.a)localObject2).getContext().getClass(), paramView)))
            {
              paramView = ((com.tencent.mm.plugin.finder.live.view.a)localObject2).getContext();
              if (!(paramView instanceof MMFinderUI)) {
                break label466;
              }
              paramView = (MMFinderUI)paramView;
              label190:
              if ((paramView != null) && (paramView.getLifecycle().getCurrentState() != j.b.bHg))
              {
                ((com.tencent.mm.plugin.finder.live.view.a)localObject2).setFinishActivityNotReleaseLive(true);
                paramView.finish();
              }
            }
          }
          ((Intent)localObject1).putExtra("LAUNCH_WITH_ANIM", paramBoolean);
          ((Intent)localObject1).putExtra("CURRENT_FEED_ID", paramLong);
          ((Intent)localObject1).putExtra("route_to_maximize", true);
          ((Intent)localObject1).addFlags(872415232);
          paramView = MMApplicationContext.getContext();
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
          com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/finder/live/view/mini/FinderLiveMiniWindowManager", "miniWindowStartActivity", "(Landroid/view/View;ZJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/finder/live/view/mini/FinderLiveMiniWindowManager", "miniWindowStartActivity", "(Landroid/view/View;ZJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramView = com.tencent.mm.live.core.mini.a.mUD;
          paramView = com.tencent.mm.live.core.mini.a.b.mUF;
          com.tencent.mm.live.core.mini.a.b.bfP().bfO();
          paramView = this.DVz;
          if (paramView != null) {
            break label471;
          }
        }
      }
    }
    label416:
    label466:
    label471:
    for (paramBoolean = false;; paramBoolean = paramView.hKC)
    {
      if (!paramBoolean) {
        break label479;
      }
      paramView = com.tencent.mm.plugin.finder.live.report.j.Dob;
      com.tencent.mm.plugin.finder.live.report.j.Doc.Dqr = false;
      paramView = com.tencent.mm.plugin.finder.live.report.j.Dob;
      com.tencent.mm.plugin.finder.live.report.j.Doc.Dqs = true;
      com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.c.Dri, String.valueOf(q.z.Dxx.type));
      AppMethodBeat.o(358390);
      return;
      i = 0;
      break;
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      paramView = paramView.getContext();
      s.s(paramView, "it.context");
      paramView = com.tencent.mm.plugin.finder.live.utils.a.gC(paramView);
      break label118;
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      paramView = paramView.getContext();
      s.s(paramView, "it.context");
      paramView = com.tencent.mm.plugin.finder.live.utils.a.gD(paramView);
      break label118;
      paramView = null;
      break label190;
    }
    label479:
    com.tencent.mm.plugin.finder.live.report.k.Doi.a(false, q.z.Dxx);
    AppMethodBeat.o(358390);
  }
  
  public final FinderLiveMiniView b(com.tencent.mm.plugin.finder.live.model.context.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(358361);
    s.u(parama, "liveData");
    Object localObject = MMApplicationContext.getContext();
    s.s(localObject, "getContext()");
    localObject = new FinderLiveMiniView((Context)localObject);
    this.DVz = ((FinderLiveMiniView)localObject);
    FinderLiveMiniView localFinderLiveMiniView = this.DVz;
    if (localFinderLiveMiniView != null) {
      localFinderLiveMiniView.a(this.naa, this.DVC);
    }
    localFinderLiveMiniView = this.DVz;
    if (localFinderLiveMiniView != null) {
      localFinderLiveMiniView.x(((e)parama.business(e.class)).mIC, ((e)parama.business(e.class)).eyo(), paramBoolean);
    }
    AppMethodBeat.o(358361);
    return localObject;
  }
  
  public final void ewe()
  {
    AppMethodBeat.i(358370);
    Object localObject1 = aj.CGT;
    localObject1 = aj.getLiveCore();
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRB;
      if ((localObject1 == null) || (((com.tencent.mm.live.core.core.model.i)localObject1).isFloatMode())) {}
    }
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(358370);
      return;
    }
    Log.i(this.TAG, "refreshOlympicsView begin");
    localObject1 = this.DVz;
    Object localObject2 = aj.CGT;
    localObject2 = aj.elr();
    if ((localObject1 != null) && (localObject2 != null))
    {
      bj localbj = bj.GlQ;
      if (bj.y((com.tencent.mm.plugin.finder.live.model.context.a)localObject2)) {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new f((com.tencent.mm.plugin.finder.live.model.context.a)localObject2, this, (FinderLiveMiniView)localObject1));
      }
    }
    AppMethodBeat.o(358370);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(b paramb, View paramView, long paramLong)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/view/mini/FinderLiveMiniWindowManager$miniWindowStateCallback$1", "Lcom/tencent/mm/live/core/core/trtc/MiniWindowStateCallback;", "onBackground", "", "hide", "", "onClose", "onForgound", "resume", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.live.core.core.trtc.b
  {
    b(b paramb) {}
    
    public final void bfj()
    {
      AppMethodBeat.i(358259);
      this.DVD.DVA.sc(false);
      AppMethodBeat.o(358259);
    }
    
    public final void fJ(boolean paramBoolean)
    {
      AppMethodBeat.i(358266);
      c localc = this.DVD.DVA;
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        if ((!com.tencent.mm.plugin.finder.live.utils.a.bUx()) && (localc.DVL > 0L)) {
          break;
        }
        AppMethodBeat.o(358266);
        return;
      }
      if (paramBoolean) {
        localc.sd(false);
      }
      localc.DVI = 0;
      localc.AcP = com.tencent.mm.model.cn.bDw();
      localc.ewf();
      Log.i(localc.TAG, s.X("enterForgound shouldReportExit:", Boolean.valueOf(paramBoolean)));
      AppMethodBeat.o(358266);
    }
    
    public final void fK(boolean paramBoolean)
    {
      boolean bool = false;
      AppMethodBeat.i(358274);
      c localc = this.DVD.DVA;
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        if ((!com.tencent.mm.plugin.finder.live.utils.a.bUx()) && (localc.DVL > 0L)) {
          break;
        }
        AppMethodBeat.o(358274);
        return;
      }
      if (com.tencent.mm.model.cn.bDw() - localc.DVL < 1000L)
      {
        Log.i(localc.TAG, "enterBackground in 1s, skip report enter and exit");
        bool = true;
      }
      for (;;)
      {
        localc.DVI = 1;
        localc.AcP = com.tencent.mm.model.cn.bDw();
        if ((paramBoolean) && (!bool)) {
          localc.ewf();
        }
        Log.i(localc.TAG, "enterBackground shouldReportEnter:" + paramBoolean + ", skipReport:" + bool);
        AppMethodBeat.o(358274);
        return;
        localc.sd(false);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    public d(com.tencent.mm.plugin.finder.live.model.context.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    public e(com.tencent.mm.plugin.finder.live.model.context.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(com.tencent.mm.plugin.finder.live.model.context.a parama, b paramb, FinderLiveMiniView paramFinderLiveMiniView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.mini.b
 * JD-Core Version:    0.7.0.1
 */