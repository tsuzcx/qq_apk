package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.model.af;
import com.tencent.mm.plugin.finder.live.model.af.c;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.util.ai;
import com.tencent.mm.plugin.finder.utils.bq;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.eom;
import com.tencent.mm.protocal.protobuf.eon;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k.b;
import com.tencent.threadpool.i;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.ak;
import kotlin.ah;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveBoxPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "boxChangedObserver", "Landroidx/lifecycle/Observer;", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BoxMsgInfo;", "commentPoller", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveBoxPlugin$CommentPoller;", "getCommentPoller", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveBoxPlugin$CommentPoller;", "setCommentPoller", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveBoxPlugin$CommentPoller;)V", "fromGroupId", "getFromGroupId", "()Ljava/lang/String;", "setFromGroupId", "(Ljava/lang/String;)V", "job", "Lkotlinx/coroutines/Job;", "getJob", "()Lkotlinx/coroutines/Job;", "setJob", "(Lkotlinx/coroutines/Job;)V", "lastBoxMsgInfo", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "setLifeCycleKeeper", "(Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;)V", "liveBoxSlice", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveBoxSlice;", "getLiveBoxSlice", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveBoxSlice;", "liveId", "", "getLiveId", "()J", "setLiveId", "(J)V", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "mount", "", "setVisible", "visible", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "CommentPoller", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cz
  extends b
{
  private static final String TAG;
  public static final b agxD;
  private com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> AAh;
  private final MMActivity activity;
  a agxE;
  String agxF;
  final com.tencent.mm.plugin.finder.live.viewmodel.data.business.s agxG;
  private ConcurrentHashMap<String, com.tencent.mm.plugin.finder.live.viewmodel.data.a.h> akeU;
  private final y<ConcurrentHashMap<String, com.tencent.mm.plugin.finder.live.viewmodel.data.a.h>> akeV;
  private cb job;
  private long liveId;
  final com.tencent.mm.live.b.b nfT;
  
  static
  {
    AppMethodBeat.i(371381);
    agxD = new b((byte)0);
    TAG = "Finder.FinderLiveBoxPlugin";
    AppMethodBeat.o(371381);
  }
  
  private cz(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb, MMActivity paramMMActivity)
  {
    super(paramViewGroup, paramb, null);
    AppMethodBeat.i(371368);
    this.nfT = paramb;
    this.activity = paramMMActivity;
    this.AAh = new com.tencent.mm.vending.e.c();
    this.agxF = "";
    this.agxG = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class));
    this.akeU = new ConcurrentHashMap();
    this.akeV = new cz..ExternalSyntheticLambda0(this);
    if (this.activity.getIntent().getLongExtra("KEY_ENTER_LIVE_PARAM_BOX_GROUP_TO_LIVEID", 0L) == ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId)
    {
      Log.i(TAG, "hit targetId, consume fromGroupId");
      paramb = this.activity.getIntent().getStringExtra("KEY_ENTER_LIVE_PARAM_BOX_GROUP_ID");
      paramViewGroup = paramb;
      if (paramb == null) {
        paramViewGroup = "";
      }
      this.agxF = paramViewGroup;
      this.activity.getIntent().removeExtra("KEY_ENTER_LIVE_PARAM_BOX_GROUP_ID");
    }
    AppMethodBeat.o(371368);
  }
  
  private static final void a(cz paramcz, ConcurrentHashMap paramConcurrentHashMap)
  {
    int i = 1;
    AppMethodBeat.i(371371);
    kotlin.g.b.s.u(paramcz, "this$0");
    Object localObject1 = bq.akii;
    Object localObject2 = TAG;
    if (paramConcurrentHashMap == null) {}
    for (localObject1 = null;; localObject1 = Integer.valueOf(paramConcurrentHashMap.size()))
    {
      bq.rU((String)localObject2, kotlin.g.b.s.X("boxChangedObserver, ", localObject1));
      if (paramConcurrentHashMap != null) {
        break;
      }
      Log.w(TAG, "getAllBoxInfo is null");
      AppMethodBeat.o(371371);
      return;
    }
    int j = 0;
    if (paramcz.akeU.size() != paramConcurrentHashMap.size()) {}
    for (;;)
    {
      paramcz.akeU.clear();
      paramcz.akeU.putAll((Map)paramConcurrentHashMap);
      if (i != 0)
      {
        paramConcurrentHashMap = bq.akii;
        bq.rR(TAG, "status FINDER_LIVE_UPDATE_BOX_INFO");
        paramcz.nfT.statusChange(b.c.qMl, new Bundle());
      }
      AppMethodBeat.o(371371);
      return;
      localObject1 = ((Map)paramConcurrentHashMap).entrySet().iterator();
      i = j;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if ((!paramcz.akeU.containsKey(((Map.Entry)localObject2).getKey())) || (!kotlin.g.b.s.p(paramcz.akeU.get(((Map.Entry)localObject2).getKey()), ((Map.Entry)localObject2).getValue()))) {
          i = 1;
        }
        for (;;)
        {
          break;
        }
      }
    }
  }
  
  private static final void a(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s params, final long paramLong)
  {
    AppMethodBeat.i(371373);
    kotlin.g.b.s.u(params, "$liveBoxSlice");
    kotlinx.coroutines.k.x((m)new e(params, paramLong, null));
    AppMethodBeat.o(371373);
  }
  
  public final void mount()
  {
    AppMethodBeat.i(371391);
    this.AAh = new com.tencent.mm.vending.e.c();
    super.mount();
    AppMethodBeat.o(371391);
  }
  
  public final void statusChange(b.c paramc, final Bundle paramBundle)
  {
    AppMethodBeat.i(371389);
    kotlin.g.b.s.u(paramc, "status");
    switch (c.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
    case 1: 
      do
      {
        AppMethodBeat.o(371389);
        return;
        paramc = bq.akii;
      } while ((!bq.B(getBuContext())) || (isLandscape()));
      this.liveId = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
      this.job = j.a(ar.d((kotlin.d.f)bg.kCh()), null, null, (m)new d(this, paramBundle, null), 3);
      AppMethodBeat.o(371389);
      return;
    }
    int i;
    label136:
    label143:
    com.tencent.mm.plugin.finder.live.report.k localk;
    if (paramBundle == null)
    {
      i = 0;
      if (paramBundle != null) {
        break label211;
      }
      paramc = "";
      localk = com.tencent.mm.plugin.finder.live.report.k.Doi;
      paramBundle = (bfv)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).akgQ.getValue();
      if (paramBundle != null) {
        break label231;
      }
      paramBundle = "";
    }
    for (;;)
    {
      kotlin.g.b.s.u(paramBundle, "groupId");
      localk.a(paramc, "", "", Integer.valueOf(i), true, paramBundle);
      break;
      i = paramBundle.getInt("PARAM_FINDER_LIVE_BOX_MSG_TYPE");
      break label136;
      label211:
      paramBundle = paramBundle.getString("PARAM_FINDER_LIVE_BOX_MSG_CONTENT");
      paramc = paramBundle;
      if (paramBundle != null) {
        break label143;
      }
      paramc = "";
      break label143;
      label231:
      String str = paramBundle.id;
      paramBundle = str;
      if (str == null) {
        paramBundle = "";
      }
    }
  }
  
  public final void tO(int paramInt) {}
  
  public final void unMount()
  {
    AppMethodBeat.i(371393);
    long l = this.liveId;
    Object localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class);
    if (l > 0L) {
      com.tencent.threadpool.h.ahAA.bm(new cz..ExternalSyntheticLambda1((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)localObject, l));
    }
    this.AAh.dead();
    localObject = this.job;
    if (localObject != null) {
      ((cb)localObject).a(null);
    }
    this.akeU = new ConcurrentHashMap();
    this.agxF = "";
    super.unMount();
    if (this.agxE != null) {
      a.erv();
    }
    this.liveId = 0L;
    AppMethodBeat.o(371393);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveBoxPlugin$CommentPoller;", "", "commentStore", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BoxBulletStore;", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BoxBulletStore;)V", "getCommentStore", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BoxBulletStore;", "startPollComment", "", "stopPollComment", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    final com.tencent.mm.plugin.finder.live.viewmodel.data.a.c akeW;
    
    public a(com.tencent.mm.plugin.finder.live.viewmodel.data.a.c paramc)
    {
      AppMethodBeat.i(371351);
      this.akeW = paramc;
      AppMethodBeat.o(371351);
    }
    
    public static void erv()
    {
      AppMethodBeat.i(371352);
      aj localaj = aj.CGT;
      aj.elm().OQ(9);
      AppMethodBeat.o(371352);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveBoxPlugin$CommentPoller$startPollComment$1", "Lcom/tencent/mm/plugin/finder/live/model/FinderLivePollingService$PollingEventCallback;", "Lcom/tencent/mm/protocal/protobuf/RefreshCommentResponse;", "onPollingSuccess", "", "result", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      extends af.c<eon>
    {
      a(cz.a parama, Class<eon> paramClass)
      {
        super();
      }
      
      @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
      static final class a
        extends u
        implements kotlin.g.a.a<ah>
      {
        a(cz.a parama, eon parameon)
        {
          super();
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveBoxPlugin$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.d.b.a.k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    d(cz paramcz, Bundle paramBundle, d<? super d> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(371349);
      paramObject = (d)new d(this.akeY, paramBundle, paramd);
      AppMethodBeat.o(371349);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(371346);
      Object localObject1 = kotlin.d.a.a.aiwj;
      int i;
      Object localObject2;
      d locald;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(371346);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        if (((CharSequence)this.akeY.agxF).length() > 0) {
          i = 1;
        }
      case 1: 
      case 2: 
        for (;;)
        {
          if (i != 0)
          {
            paramObject = this.akeY.agxG;
            localObject2 = com.tencent.mm.ui.component.k.aeZF;
            localObject2 = ((bn)com.tencent.mm.ui.component.k.d((AppCompatActivity)cz.a(this.akeY)).cq(bn.class)).fou();
            locald = (d)this;
            this.label = 1;
            if (paramObject.a((bui)localObject2, locald) == localObject1)
            {
              AppMethodBeat.o(371346);
              return localObject1;
              i = 0;
              continue;
              ResultKt.throwOnFailure(paramObject);
            }
            else
            {
              paramObject = ai.akfD;
              if (!ai.isChatRoomDismiss(this.akeY.agxF))
              {
                paramObject = ai.akfD;
                if (!ai.isNotInChatRoom(this.akeY.agxF)) {
                  break;
                }
              }
              else
              {
                paramObject = this.akeY.agxG;
                localObject2 = (d)this;
                this.label = 2;
                if (paramObject.c(null, false, (d)localObject2) == localObject1)
                {
                  AppMethodBeat.o(371346);
                  return localObject1;
                  ResultKt.throwOnFailure(paramObject);
                }
                paramObject = this.akeY;
                kotlin.g.b.s.u("", "<set-?>");
                paramObject.agxF = "";
                label271:
                paramObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)this.akeY.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).akgn;
                if (paramObject != null)
                {
                  localObject1 = this.akeY;
                  ((cz)localObject1).agxE = new cz.a(paramObject);
                  paramObject = ((cz)localObject1).agxE;
                  if (paramObject != null)
                  {
                    cz.a.erv();
                    localObject1 = new eom();
                    ((eom)localObject1).ZEQ = paramObject.akeW.lastBuffer;
                    localObject2 = aj.CGT;
                    aj.elm().a(9, (com.tencent.mm.bx.a)localObject1, (af.c)new cz.a.a(paramObject, eon.class));
                  }
                }
                localObject1 = cz.b(this.akeY);
                paramObject = this.akeY.agxG.kLh();
                if (paramObject != null) {
                  break label715;
                }
                paramObject = null;
                label394:
                if (paramObject != null) {
                  break label726;
                }
              }
            }
          }
        }
      }
      label715:
      label726:
      for (paramObject = ak.kkZ();; paramObject = (Map)paramObject)
      {
        ((ConcurrentHashMap)localObject1).putAll(paramObject);
        paramObject = this.akeY.agxG.kLh();
        if (paramObject != null) {
          paramObject.a((q)this.akeY, cz.c(this.akeY));
        }
        paramObject = bq.akii;
        paramObject = cz.agxD;
        bq.rR(cz.access$getTAG$cp(), "status FINDER_LIVE_INIT_BOX_INFO");
        this.akeY.nfT.statusChange(b.c.qMf, paramBundle);
        paramObject = ah.aiuX;
        AppMethodBeat.o(371346);
        return paramObject;
        paramObject = this.akeY.agxG;
        localObject2 = this.akeY.agxF;
        locald = (d)this;
        this.label = 3;
        if (paramObject.c((String)localObject2, true, locald) == localObject1)
        {
          AppMethodBeat.o(371346);
          return localObject1;
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = this.akeY.agxG;
        localObject1 = bq.akii;
        paramObject.a(bq.bLz(this.akeY.agxF));
        paramObject = com.tencent.mm.plugin.finder.live.gala.c.a.adlY;
        com.tencent.mm.plugin.finder.live.gala.c.a.aCS(this.akeY.agxF);
        break;
        if (this.akeY.agxG.hasInit) {
          break label271;
        }
        paramObject = this.akeY.agxG;
        localObject2 = com.tencent.mm.ui.component.k.aeZF;
        localObject2 = ((bn)com.tencent.mm.ui.component.k.d((AppCompatActivity)cz.a(this.akeY)).cq(bn.class)).fou();
        locald = (d)this;
        this.label = 4;
        if (paramObject.a((bui)localObject2, locald) == localObject1)
        {
          AppMethodBeat.o(371346);
          return localObject1;
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = this.akeY.agxG;
        localObject2 = (d)this;
        this.label = 5;
        if (paramObject.c(null, true, (d)localObject2) != localObject1) {
          break label271;
        }
        AppMethodBeat.o(371346);
        return localObject1;
        ResultKt.throwOnFailure(paramObject);
        break label271;
        paramObject = (ConcurrentHashMap)paramObject.getValue();
        break label394;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.d.b.a.k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    e(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s params, long paramLong, d<? super e> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(371345);
      paramObject = (d)new e(this.akeZ, paramLong, paramd);
      AppMethodBeat.o(371345);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(371344);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(371344);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        long l = paramLong;
        paramObject = (d)this;
        this.label = 1;
        if (com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.e("unMount", l, paramObject) == locala)
        {
          AppMethodBeat.o(371344);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(371344);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.cz
 * JD-Core Version:    0.7.0.1
 */