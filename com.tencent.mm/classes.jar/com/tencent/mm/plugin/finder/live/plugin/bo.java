package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.d.a.a.a.b.b.k;
import com.tencent.d.a.a.a.b.b.k.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.live.model.af;
import com.tencent.mm.plugin.finder.live.model.af.c;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.n;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.n.c;
import com.tencent.mm.plugin.finder.utils.bi;
import com.tencent.mm.plugin.finder.utils.bj;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.bkq;
import com.tencent.mm.protocal.protobuf.brs;
import com.tencent.mm.protocal.protobuf.cds;
import com.tencent.mm.protocal.protobuf.dcg;
import com.tencent.mm.protocal.protobuf.dch;
import com.tencent.mm.protocal.protobuf.eom;
import com.tencent.mm.protocal.protobuf.eon;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.vending.e.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveOlympicsPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "commentPoller", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveOlympicsPlugin$CommentPoller;", "getCommentPoller", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveOlympicsPlugin$CommentPoller;", "setCommentPoller", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveOlympicsPlugin$CommentPoller;)V", "from", "", "getFrom", "()I", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "setLifeCycleKeeper", "(Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;)V", "remainRetryCount", "getRemainRetryCount", "setRemainRetryCount", "(I)V", "statusListener", "Lkotlin/Function0;", "", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "initSport", "initTorch", "mount", "notifyStreamStatusChanged", "setVisible", "visible", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "CommentPoller", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bo
  extends b
{
  public static final b Dhs;
  private static final String TAG;
  private c<com.tencent.mm.vending.e.a> AAh;
  int Dht;
  private a Dhu;
  private final kotlin.g.a.a<ah> Dhv;
  private final MMActivity activity;
  private final int from;
  final com.tencent.mm.live.b.b nfT;
  
  static
  {
    AppMethodBeat.i(355290);
    Dhs = new b((byte)0);
    TAG = "Finder.FinderLiveOlympicsPlugin";
    AppMethodBeat.o(355290);
  }
  
  private bo(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb, MMActivity paramMMActivity)
  {
    super(paramViewGroup, paramb, null);
    AppMethodBeat.i(355228);
    this.nfT = paramb;
    this.activity = paramMMActivity;
    paramViewGroup = this.activity.getIntent();
    paramb = b.k.ahpq;
    this.from = paramViewGroup.getIntExtra("KEY_ENTER_LIVE_PARAM_LIVE_EVENT_SOURCE", b.k.a.jWl());
    this.Dht = 2;
    this.AAh = new c();
    this.Dhv = ((kotlin.g.a.a)new g(this));
    AppMethodBeat.o(355228);
  }
  
  private final void eru()
  {
    AppMethodBeat.i(355247);
    Object localObject = bi.GlP;
    localObject = (com.tencent.mm.vending.e.b)this.AAh;
    dcg localdcg = new dcg();
    localdcg.source = this.from;
    ah localah = ah.aiuX;
    bi.a((com.tencent.mm.vending.e.b)localObject, localdcg, (m)new e(this));
    AppMethodBeat.o(355247);
  }
  
  public final void mount()
  {
    Object localObject2 = null;
    AppMethodBeat.i(355321);
    this.AAh = new c();
    super.mount();
    Object localObject1 = (com.tencent.mm.bx.a)new brs();
    Object localObject3 = this.activity.getIntent().getByteArrayExtra("KEY_ENTER_LIVE_PARAM_OLYMPIC_FIRE_AUTHOR_INFO");
    try
    {
      ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
      localObject3 = (brs)localObject1;
      StringBuilder localStringBuilder = new StringBuilder("fireAuthorInfo After gotoLive AuthorId: ");
      if (localObject3 == null)
      {
        localObject1 = null;
        localStringBuilder = localStringBuilder.append(localObject1).append(", AuthorIndex: ");
        if (localObject3 != null) {
          break label257;
        }
        localObject1 = null;
        localStringBuilder = localStringBuilder.append(localObject1).append(", byPassInfo: ");
        if (localObject3 != null) {
          break label266;
        }
        localObject1 = localObject2;
        Log.i("Plugin.FinderLive", localObject1);
        ((n)getBuContext().business(n.class)).Ehe = ((brs)localObject3);
        localObject1 = (n)getBuContext().business(n.class);
        if (localObject3 != null) {
          break label275;
        }
        i = 0;
        if (i != 1) {
          break label284;
        }
        bool = true;
        ((n)localObject1).Ehg = bool;
        this.activity.getIntent().removeExtra("KEY_ENTER_LIVE_PARAM_OLYMPIC_FIRE_AUTHOR_INFO");
        ((e)business(e.class)).bp(this.Dhv);
        AppMethodBeat.o(355321);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printDebugStack("safeParser", "", new Object[] { localException });
        String str = null;
        continue;
        str = ((brs)localObject3).ZVr;
        continue;
        label257:
        str = ((brs)localObject3).ZVq;
        continue;
        label266:
        str = ((brs)localObject3).ZVp;
        continue;
        label275:
        int i = ((brs)localObject3).ZZU;
        continue;
        label284:
        boolean bool = false;
      }
    }
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(355306);
    s.u(paramc, "status");
    if (c.$EnumSwitchMapping$0[paramc.ordinal()] == 1)
    {
      paramc = bj.GlQ;
      if (bj.y(getBuContext()))
      {
        paramc = k.aeZF;
        ((g)k.cn(cn.class).cq(g.class)).pH(false);
        eru();
        this.Dhu = new a(((n)business(n.class)).Dhw);
        paramc = this.Dhu;
        if (paramc != null)
        {
          a.erv();
          paramBundle = new eom();
          paramBundle.ZEQ = paramc.Dhw.lastBuffer;
          aj localaj = aj.CGT;
          aj.elm().a(9, (com.tencent.mm.bx.a)paramBundle, (af.c)new bo.a.a(paramc, eon.class));
        }
      }
    }
    AppMethodBeat.o(355306);
  }
  
  public final void tO(int paramInt) {}
  
  public final void unMount()
  {
    AppMethodBeat.i(355331);
    this.AAh.dead();
    super.unMount();
    if (this.Dhu != null) {
      a.erv();
    }
    e locale = (e)business(e.class);
    kotlin.g.a.a locala = this.Dhv;
    s.u(locala, "listener");
    locale.EcC.remove(locala);
    this.Dht = 2;
    AppMethodBeat.o(355331);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveOlympicsPlugin$CommentPoller;", "", "commentStore", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveOlympicsSlice$CommentStore;", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveOlympicsSlice$CommentStore;)V", "getCommentStore", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveOlympicsSlice$CommentStore;", "startPollComment", "", "stopPollComment", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    final n.c Dhw;
    
    public a(n.c paramc)
    {
      AppMethodBeat.i(353669);
      this.Dhw = paramc;
      AppMethodBeat.o(353669);
    }
    
    public static void erv()
    {
      AppMethodBeat.i(353677);
      aj localaj = aj.CGT;
      aj.elm().OQ(9);
      AppMethodBeat.o(353677);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveOlympicsPlugin$CommentPoller$startPollComment$1", "Lcom/tencent/mm/plugin/finder/live/model/FinderLivePollingService$PollingEventCallback;", "Lcom/tencent/mm/protocal/protobuf/RefreshCommentResponse;", "onPollingSuccess", "", "result", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      extends af.c<eon>
    {
      a(bo.a parama, Class<eon> paramClass)
      {
        super();
      }
      
      @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
      static final class a
        extends u
        implements kotlin.g.a.a<ah>
      {
        a(bo.a parama, eon parameon)
        {
          super();
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveOlympicsPlugin$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveOpenTransferResponse;", "response", "Lcom/tencent/mm/protocal/protobuf/GetActivityInfoResponse;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements m<b.a<bkq>, cds, ah>
  {
    d(bo parambo)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(bo parambo)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveOpenTransferResponse;", "response", "Lcom/tencent/mm/protocal/protobuf/InitTorchLiveResponse;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements m<b.a<bkq>, dch, ah>
  {
    e(bo parambo)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(bo parambo)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(bo parambo)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bo
 * JD-Core Version:    0.7.0.1
 */