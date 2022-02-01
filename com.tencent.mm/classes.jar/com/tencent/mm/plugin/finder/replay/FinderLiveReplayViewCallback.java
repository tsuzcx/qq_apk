package com.tencent.mm.plugin.finder.replay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.view.FinderLiveLayoutManager;
import com.tencent.mm.plugin.finder.live.view.FinderLiveRecyclerView;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.protocal.protobuf.bug;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayViewCallback;", "Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/life/UILifecycleObserver;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayContract$Presenter;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayContract$Presenter;)V", "finderLiveReplayPageFloatBallHelper", "Lcom/tencent/mm/plugin/finder/replay/model/FinderLiveReplayPageFloatBallHelper;", "liveLayoutManager", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveLayoutManager;", "proxyRLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "getProxyRLayout", "()Lcom/tencent/mm/view/IViewActionCallback;", "setProxyRLayout", "(Lcom/tencent/mm/view/IViewActionCallback;)V", "recyclerView", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveRecyclerView;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "rfLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "verticalPageSnapHelper", "Lcom/tencent/mm/plugin/finder/ui/FinderFullPagerSnapHelper;", "viewManager", "Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayViewManager;", "delete", "", "liveId", "", "getActivity", "getPresenter", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getViewActionCallback", "initView", "isFinish", "", "keyboardChange", "show", "height", "", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "var1", "Landroidx/lifecycle/LifecycleOwner;", "onDestroy", "onInit", "onLoadMoreResult", "incrementSize", "onPause", "onResume", "onStart", "onStop", "onUninit", "restart", "tryHideFloatBallWhenEnterPage", "updateLayoutManager", "pos", "itemView", "Landroid/view/View;", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveReplayViewCallback
  implements com.tencent.mm.plugin.finder.life.b, f.b
{
  public static final FinderLiveReplayViewCallback.a FkQ;
  private com.tencent.mm.view.k ATF;
  RefreshLoadMoreLayout BwD;
  FinderLiveRecyclerView BwI;
  FinderLiveLayoutManager BwJ;
  final f.a FkR;
  final com.tencent.mm.plugin.finder.ui.e FkS;
  private final o FkT;
  private com.tencent.mm.plugin.finder.replay.model.b FkU;
  final MMActivity activity;
  private final bui reportObj;
  
  static
  {
    AppMethodBeat.i(333021);
    FkQ = new FinderLiveReplayViewCallback.a((byte)0);
    AppMethodBeat.o(333021);
  }
  
  public FinderLiveReplayViewCallback(MMActivity paramMMActivity, f.a parama)
  {
    AppMethodBeat.i(332913);
    this.activity = paramMMActivity;
    this.FkR = parama;
    this.FkS = new com.tencent.mm.plugin.finder.ui.e();
    paramMMActivity = this.activity.findViewById(p.e.BSa);
    s.s(paramMMActivity, "activity.findViewById(R.id.finder_live_replay_rf)");
    this.BwD = ((RefreshLoadMoreLayout)paramMMActivity);
    paramMMActivity = this.activity.findViewById(p.e.BRZ);
    s.s(paramMMActivity, "activity.findViewById(R.…ive_replay_recycler_view)");
    this.BwI = ((FinderLiveRecyclerView)paramMMActivity);
    paramMMActivity = com.tencent.mm.ui.component.k.aeZF;
    this.reportObj = ((bn)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.activity).cq(bn.class)).fou();
    this.FkT = new o((WxRecyclerView)this.BwI, this.reportObj);
    this.ATF = ((com.tencent.mm.view.k)new d(this));
    AppMethodBeat.o(332913);
  }
  
  private static final void a(FinderLiveReplayViewCallback paramFinderLiveReplayViewCallback, int paramInt)
  {
    AppMethodBeat.i(332922);
    s.u(paramFinderLiveReplayViewCallback, "this$0");
    paramFinderLiveReplayViewCallback = paramFinderLiveReplayViewCallback.BwI;
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(paramFinderLiveReplayViewCallback, locala.aYi(), "com/tencent/mm/plugin/finder/replay/FinderLiveReplayViewCallback", "onLoadMoreResult$lambda-4", "(Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayViewCallback;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
    paramFinderLiveReplayViewCallback.smoothScrollToPosition(((Integer)locala.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(paramFinderLiveReplayViewCallback, "com/tencent/mm/plugin/finder/replay/FinderLiveReplayViewCallback", "onLoadMoreResult$lambda-4", "(Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayViewCallback;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
    AppMethodBeat.o(332922);
  }
  
  private static final void a(FinderLiveReplayViewCallback paramFinderLiveReplayViewCallback, long paramLong)
  {
    AppMethodBeat.i(332937);
    s.u(paramFinderLiveReplayViewCallback, "this$0");
    int j = paramFinderLiveReplayViewCallback.FkT.pos;
    Object localObject = paramFinderLiveReplayViewCallback.BwI.getAdapter();
    if (localObject == null)
    {
      paramFinderLiveReplayViewCallback = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.replay.FinderLiveReplayAdapter");
      AppMethodBeat.o(332937);
      throw paramFinderLiveReplayViewCallback;
    }
    localObject = ((d)localObject).pUj;
    int i;
    if (localObject == null)
    {
      i = 0;
      Log.i("FinderLiveReplayViewCallback", "restart curPos:" + j + "(liveId:" + paramLong + "),size:" + i + '!');
      if (j < 0) {
        break label174;
      }
      if (j >= i) {
        break label169;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        paramFinderLiveReplayViewCallback = paramFinderLiveReplayViewCallback.BwJ;
        if (paramFinderLiveReplayViewCallback != null) {
          FinderLiveLayoutManager.a(paramFinderLiveReplayViewCallback, false, true, 1);
        }
      }
      AppMethodBeat.o(332937);
      return;
      i = ((ArrayList)localObject).size();
      break;
      label169:
      i = 0;
      continue;
      label174:
      i = 0;
    }
  }
  
  private static final void b(FinderLiveReplayViewCallback paramFinderLiveReplayViewCallback, long paramLong)
  {
    int m = 0;
    AppMethodBeat.i(332952);
    s.u(paramFinderLiveReplayViewCallback, "this$0");
    Object localObject1 = paramFinderLiveReplayViewCallback.BwI.getAdapter();
    Object localObject2;
    int i;
    if ((localObject1 instanceof d))
    {
      localObject1 = (d)localObject1;
      if (localObject1 != null)
      {
        localObject2 = ((d)localObject1).pUj;
        if (localObject2 == null) {
          break label255;
        }
        localObject2 = ((List)localObject2).iterator();
        i = 0;
        label70:
        if (!((Iterator)localObject2).hasNext()) {
          break label255;
        }
        if (((com.tencent.mm.plugin.finder.live.viewmodel.data.f)((Iterator)localObject2).next()).Ebr.liveId != paramLong) {
          break label242;
        }
        j = 1;
        label104:
        if (j == 0) {
          break label248;
        }
        label109:
        localObject2 = ((d)localObject1).pUj;
        if (localObject2 != null) {
          break label260;
        }
      }
    }
    label260:
    for (int j = 0;; j = ((ArrayList)localObject2).size())
    {
      Log.i("FinderLiveReplayViewCallback", "delete deletePos:" + i + "(liveId:" + paramLong + "),size:" + j + '!');
      int k = m;
      if (i >= 0)
      {
        k = m;
        if (i < j) {
          k = 1;
        }
      }
      if (k != 0)
      {
        ((d)localObject1).RK(i);
        if (((d)localObject1).getItemCount() == 0)
        {
          Log.i("FinderLiveReplayViewCallback", "not replay item exist,close activity!");
          paramFinderLiveReplayViewCallback.activity.finish();
        }
      }
      AppMethodBeat.o(332952);
      return;
      localObject1 = null;
      break;
      label242:
      j = 0;
      break label104;
      label248:
      i += 1;
      break label70;
      label255:
      i = -1;
      break label109;
    }
  }
  
  public final void RL(int paramInt)
  {
    Object localObject2 = null;
    int m = 0;
    AppMethodBeat.i(333066);
    Object localObject1 = this.BwI.getAdapter();
    int j;
    int k;
    label42:
    label93:
    boolean bool;
    label144:
    label177:
    label188:
    label249:
    int n;
    int i;
    if (localObject1 == null)
    {
      j = 0;
      localObject1 = this.BwJ;
      if (localObject1 != null) {
        break label376;
      }
      k = -1;
      StringBuilder localStringBuilder = new StringBuilder("onLoadMoreResult increment size:").append(paramInt).append(",adapterItemCount:").append(j).append(",curPos:");
      localObject1 = k.Fky.eLF().Fkz;
      if (localObject1 != null) {
        break label386;
      }
      localObject1 = null;
      Log.i("FinderLiveReplayViewCallback", localObject1 + ",lastVisibleItemPos:" + k);
      if (paramInt > 0) {
        break label425;
      }
      localObject1 = this.BwD.aFR(p.e.BNl);
      if (localObject1 != null) {
        break label399;
      }
      localObject1 = null;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      localObject1 = this.BwD.aFR(p.e.BNl);
      if (localObject1 != null) {
        break label412;
      }
      localObject1 = localObject2;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
      localObject1 = new RefreshLoadMoreLayout.d(-1);
      ((RefreshLoadMoreLayout.d)localObject1).agJv = paramInt;
      ((RefreshLoadMoreLayout.d)localObject1).agJu = true;
      localObject2 = k.Fky.eLF().Fkz;
      if (localObject2 == null) {
        break label452;
      }
      localObject2 = ((com.tencent.mm.plugin.finder.replay.model.c)localObject2).FlT;
      if ((localObject2 == null) || (((bug)localObject2).BeA != 0)) {
        break label452;
      }
      bool = true;
      ((RefreshLoadMoreLayout.d)localObject1).pzq = bool;
      this.BwD.onPreFinishLoadMoreSmooth((RefreshLoadMoreLayout.d)localObject1);
      n = j - paramInt;
      if (paramInt > 0)
      {
        if (n < 0) {
          break label463;
        }
        if (n >= j) {
          break label458;
        }
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject1 = this.BwI.getAdapter();
        if (localObject1 != null) {
          ((RecyclerView.a)localObject1).bA(n, paramInt);
        }
      }
      i = k + 1;
      if (paramInt > 0)
      {
        paramInt = m;
        if (i >= 0)
        {
          paramInt = m;
          if (i < j) {
            paramInt = 1;
          }
        }
        if (paramInt != 0) {
          this.BwI.post(new FinderLiveReplayViewCallback..ExternalSyntheticLambda0(this, i));
        }
      }
      AppMethodBeat.o(333066);
      return;
      j = ((RecyclerView.a)localObject1).getItemCount();
      break;
      label376:
      k = ((FinderLiveLayoutManager)localObject1).Jw();
      break label42;
      label386:
      localObject1 = Integer.valueOf(((com.tencent.mm.plugin.finder.replay.model.c)localObject1).CEY);
      break label93;
      label399:
      localObject1 = ((View)localObject1).findViewById(p.e.loading_progress);
      break label144;
      label412:
      localObject1 = ((View)localObject1).findViewById(p.e.load_finish);
      break label177;
      label425:
      localObject1 = this.BwD.aFR(p.e.BNl);
      if (localObject1 == null) {
        break label188;
      }
      ((View)localObject1).setVisibility(8);
      break label188;
      label452:
      bool = false;
      break label249;
      label458:
      i = 0;
      continue;
      label463:
      i = 0;
    }
  }
  
  public final void delete(long paramLong)
  {
    AppMethodBeat.i(333084);
    this.BwI.post(new FinderLiveReplayViewCallback..ExternalSyntheticLambda2(this, paramLong));
    AppMethodBeat.o(333084);
  }
  
  public final com.tencent.mm.view.k ecd()
  {
    return this.ATF;
  }
  
  public final void onCreate(androidx.lifecycle.q paramq)
  {
    AppMethodBeat.i(333120);
    s.u(paramq, "var1");
    Log.i("FinderLiveReplayViewCallback", s.X("[LiveLifecycle]onCreate ", this));
    this.FkU = new com.tencent.mm.plugin.finder.replay.model.b((com.tencent.mm.plugin.ball.a.f)new com.tencent.mm.plugin.ball.a.e((Activity)this.activity));
    paramq = this.FkU;
    if (paramq != null) {
      paramq.J(34, "LiveReplayFloatBall");
    }
    AppMethodBeat.o(333120);
  }
  
  public final void onDestroy(androidx.lifecycle.q paramq)
  {
    AppMethodBeat.i(333184);
    s.u(paramq, "var1");
    Log.i("FinderLiveReplayViewCallback", s.X("[LiveLifecycle]onDestroy ", this));
    paramq = this.FkT.FkW;
    if (paramq != null) {
      paramq.unMount();
    }
    paramq = this.FkU;
    if (paramq != null) {
      paramq.onDestroy();
    }
    AppMethodBeat.o(333184);
  }
  
  public final void onPause(androidx.lifecycle.q paramq)
  {
    AppMethodBeat.i(333156);
    s.u(paramq, "var1");
    Log.i("FinderLiveReplayViewCallback", s.X("[LiveLifecycle]onPause ", this));
    paramq = this.FkT.FkW;
    if (paramq != null) {
      paramq.pause();
    }
    AppMethodBeat.o(333156);
  }
  
  public final void onResume(androidx.lifecycle.q paramq)
  {
    AppMethodBeat.i(333144);
    s.u(paramq, "var1");
    Log.i("FinderLiveReplayViewCallback", s.X("[LiveLifecycle]onResume ", this));
    paramq = this.FkT.FkW;
    if (paramq != null) {
      paramq.resume();
    }
    AppMethodBeat.o(333144);
  }
  
  public final void onStart(androidx.lifecycle.q paramq)
  {
    Object localObject = null;
    AppMethodBeat.i(333137);
    s.u(paramq, "var1");
    StringBuilder localStringBuilder = new StringBuilder("[LiveLifecycle]onStart ").append(this).append(", needMiniWindow:");
    paramq = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)k.Fky.eLF().business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
    if (paramq == null)
    {
      paramq = null;
      localStringBuilder = localStringBuilder.append(paramq).append(",manualClose:");
      paramq = (com.tencent.mm.plugin.finder.replay.viewmodel.c)k.Fky.eLF().business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class);
      if (paramq != null) {
        break label279;
      }
      paramq = null;
      label92:
      localStringBuilder = localStringBuilder.append(paramq).append(",manualMinimum:");
      paramq = (com.tencent.mm.plugin.finder.replay.viewmodel.c)k.Fky.eLF().business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class);
      if (paramq != null) {
        break label290;
      }
    }
    label279:
    label290:
    for (paramq = localObject;; paramq = Boolean.valueOf(paramq.FmS))
    {
      Log.i("FinderLiveReplayViewCallback", paramq);
      paramq = com.tencent.mm.plugin.finder.replay.model.b.FlR;
      com.tencent.mm.plugin.finder.replay.model.b.axX(toString());
      paramq = this.FkU;
      if (paramq != null) {
        paramq.bhT();
      }
      com.tencent.mm.plugin.ball.f.f.d(true, false, true);
      paramq = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)k.Fky.eLF().business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if (paramq != null) {
        paramq.EcI = true;
      }
      paramq = (com.tencent.mm.plugin.finder.replay.viewmodel.c)k.Fky.eLF().business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class);
      if (paramq != null) {
        paramq.tw(false);
      }
      paramq = (com.tencent.mm.plugin.finder.replay.viewmodel.c)k.Fky.eLF().business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class);
      if (paramq != null) {
        paramq.tx(false);
      }
      paramq = this.FkT.FkW;
      if (paramq != null) {
        paramq.start();
      }
      AppMethodBeat.o(333137);
      return;
      paramq = Boolean.valueOf(paramq.EcI);
      break;
      paramq = Boolean.valueOf(paramq.FmR);
      break label92;
    }
  }
  
  public final void onStop(androidx.lifecycle.q paramq)
  {
    Object localObject3 = null;
    AppMethodBeat.i(333172);
    s.u(paramq, "var1");
    Object localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)k.Fky.eLF().business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
    Object localObject2;
    label60:
    com.tencent.mm.plugin.finder.replay.viewmodel.c localc;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject2 = (com.tencent.mm.plugin.finder.replay.viewmodel.c)k.Fky.eLF().business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class);
      if (localObject2 != null) {
        break label205;
      }
      localObject2 = null;
      localc = (com.tencent.mm.plugin.finder.replay.viewmodel.c)k.Fky.eLF().business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class);
      if (localc != null) {
        break label216;
      }
      label82:
      Log.i("FinderLiveReplayViewCallback", "[LiveLifecycle]onStop " + this + ", needMiniView:" + localObject1 + ", manualClose:" + localObject2 + ",manualMinumum:" + localObject3 + ",lifecycleOwner:" + paramq);
      if (!s.p(localObject3, Boolean.TRUE)) {
        break label229;
      }
      paramq = this.FkU;
      if (paramq != null) {
        paramq.rZ(false);
      }
    }
    for (;;)
    {
      paramq = this.FkT.FkW;
      if (paramq != null) {
        paramq.stop();
      }
      AppMethodBeat.o(333172);
      return;
      localObject1 = Boolean.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcI);
      break;
      label205:
      localObject2 = Boolean.valueOf(((com.tencent.mm.plugin.finder.replay.viewmodel.c)localObject2).FmR);
      break label60;
      label216:
      localObject3 = Boolean.valueOf(localc.FmS);
      break label82;
      label229:
      if ((s.p(localObject2, Boolean.FALSE)) && (!s.p(localObject1, Boolean.FALSE)))
      {
        paramq = k.Fky.eLF();
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", 3);
        localObject2 = ah.aiuX;
        paramq.aH((Intent)localObject1);
        paramq = this.FkU;
        if (paramq != null) {
          paramq.rZ(false);
        }
      }
      else
      {
        paramq = this.FkU;
        if (paramq != null) {
          paramq.rZ(true);
        }
      }
    }
  }
  
  public final void pt(long paramLong)
  {
    AppMethodBeat.i(333076);
    this.BwI.post(new FinderLiveReplayViewCallback..ExternalSyntheticLambda1(this, paramLong));
    AppMethodBeat.o(333076);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "pos", "", "<anonymous parameter 1>", "Landroid/view/View;", "<anonymous parameter 2>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.q<Integer, View, Boolean, ah>
  {
    b(FinderLiveReplayViewCallback paramFinderLiveReplayViewCallback)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/replay/FinderLiveReplayViewCallback$initView$2$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "onLoadMoreBegin", "", "loadMoreType", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "onRefreshEnd", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RefreshLoadMoreLayout.b
  {
    c(FinderLiveReplayViewCallback paramFinderLiveReplayViewCallback) {}
    
    private static final void d(FinderLiveReplayViewCallback paramFinderLiveReplayViewCallback)
    {
      AppMethodBeat.i(332517);
      s.u(paramFinderLiveReplayViewCallback, "this$0");
      FinderLiveReplayViewCallback.b(paramFinderLiveReplayViewCallback).aFV(0);
      AppMethodBeat.o(332517);
    }
    
    public final void IH(int paramInt)
    {
      AppMethodBeat.i(332547);
      super.IH(paramInt);
      Log.i("FinderLiveReplayViewCallback", "onRefreshBegin");
      FinderLiveReplayViewCallback.b(this.FkV).post(new FinderLiveReplayViewCallback.c..ExternalSyntheticLambda0(this.FkV));
      AppMethodBeat.o(332547);
    }
    
    public final void a(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(332540);
      s.u(paramd, "reason");
      Log.i("FinderLiveReplayViewCallback", "onLoadMoreEnd");
      AppMethodBeat.o(332540);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(332556);
      s.u(paramd, "reason");
      super.onRefreshEnd(paramd);
      Log.i("FinderLiveReplayViewCallback", "onRefreshEnd");
      AppMethodBeat.o(332556);
    }
    
    public final void qI(int paramInt)
    {
      View localView = null;
      AppMethodBeat.i(332535);
      Object localObject1 = FinderLiveReplayViewCallback.b(this.FkV).aFR(p.e.BNl);
      label39:
      Object localObject2;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (!(localObject1 instanceof MMProcessBar)) {
          break label179;
        }
        localObject1 = (MMProcessBar)localObject1;
        localObject2 = FinderLiveReplayViewCallback.b(this.FkV).aFR(p.e.BNl);
        if (localObject2 != null) {
          break label184;
        }
        label59:
        localObject2 = k.Fky.eLF().Fkz;
        if (localObject2 == null) {
          break label196;
        }
        localObject2 = ((com.tencent.mm.plugin.finder.replay.model.c)localObject2).FlT;
        if ((localObject2 == null) || (((bug)localObject2).BeA != 0)) {
          break label196;
        }
      }
      label179:
      label184:
      label196:
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt != 0) {
          break label201;
        }
        FinderLiveReplayViewCallback.c(this.FkV).bXB();
        if (localObject1 != null) {
          ((MMProcessBar)localObject1).oH(p.g.finder_live_icon_location_loading, MMApplicationContext.getContext().getResources().getColor(p.b.White));
        }
        if (localObject1 != null) {
          ((MMProcessBar)localObject1).setVisibility(0);
        }
        if (localView != null) {
          localView.setVisibility(8);
        }
        Log.i("FinderLiveReplayViewCallback", "load more progress bar is show");
        AppMethodBeat.o(332535);
        return;
        localObject1 = ((View)localObject1).findViewById(p.e.loading_progress);
        break;
        localObject1 = null;
        break label39;
        localView = ((View)localObject2).findViewById(p.e.load_finish);
        break label59;
      }
      label201:
      if (localObject1 != null) {
        ((MMProcessBar)localObject1).setVisibility(8);
      }
      if (localView != null) {
        localView.setVisibility(0);
      }
      FinderLiveReplayViewCallback.b(this.FkV).aFW(0);
      Log.i("FinderLiveReplayViewCallback", "live list load finish is show");
      AppMethodBeat.o(332535);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/replay/FinderLiveReplayViewCallback$proxyRLayout$1", "Lcom/tencent/mm/view/IViewActionCallback;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements com.tencent.mm.view.k
  {
    d(FinderLiveReplayViewCallback paramFinderLiveReplayViewCallback) {}
    
    public final void onChanged()
    {
      AppMethodBeat.i(332532);
      Log.i("FinderLiveReplayViewCallback", "onChanged");
      AppMethodBeat.o(332532);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(332538);
      Log.i("FinderLiveReplayViewCallback", "onItemRangeChanged positionStart:" + paramInt1 + ", itemCount:" + paramInt2);
      AppMethodBeat.o(332538);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(332543);
      Log.i("FinderLiveReplayViewCallback", "onItemRangeChanged positionStart:" + paramInt1 + ", itemCount:" + paramInt2);
      AppMethodBeat.o(332543);
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(332552);
      Log.i("FinderLiveReplayViewCallback", "onItemRangeInserted positionStart:" + paramInt1 + ", itemCount:" + paramInt2);
      AppMethodBeat.o(332552);
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(332560);
      Log.i("FinderLiveReplayViewCallback", "onItemRangeRemoved positionStart:" + paramInt1 + ", itemCount:" + paramInt2);
      AppMethodBeat.o(332560);
    }
    
    public final void onPreFinishLoadMore(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(332522);
      s.u(paramd, "reason");
      Log.i("FinderLiveReplayViewCallback", s.X("onPreFinishLoadMore reason:", paramd));
      FinderLiveReplayViewCallback.b(this.FkV).onPreFinishLoadMore(paramd);
      AppMethodBeat.o(332522);
    }
    
    public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(332527);
      s.u(paramd, "reason");
      Log.i("FinderLiveReplayViewCallback", s.X("onPreFinishLoadMoreSmooth reason:", paramd));
      FinderLiveReplayViewCallback.b(this.FkV).onPreFinishLoadMoreSmooth(paramd);
      AppMethodBeat.o(332527);
    }
    
    public final void onPreFinishRefresh(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(332514);
      s.u(paramd, "reason");
      Log.i("FinderLiveReplayViewCallback", s.X("onPreFinishRefresh reason:", paramd));
      FinderLiveReplayViewCallback.b(this.FkV).onPreFinishRefresh(paramd);
      AppMethodBeat.o(332514);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.replay.FinderLiveReplayViewCallback
 * JD-Core Version:    0.7.0.1
 */