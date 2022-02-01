package com.tencent.mm.plugin.finder.live.viewmodel.data.business;

import androidx.lifecycle.x;
import com.tencent.d.a.a.a.b.c.a;
import com.tencent.d.a.a.a.b.c.a.a;
import com.tencent.d.a.a.a.b.c.c;
import com.tencent.d.a.a.a.b.c.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.cgi.eg;
import com.tencent.mm.plugin.finder.live.viewmodel.data.a.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.a.f.b;
import com.tencent.mm.plugin.finder.live.viewmodel.data.a.f.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.a.f.j;
import com.tencent.mm.plugin.finder.live.viewmodel.data.a.h;
import com.tencent.mm.plugin.finder.live.viewmodel.data.a.i;
import com.tencent.mm.plugin.finder.live.viewmodel.data.p;
import com.tencent.mm.plugin.finder.live.viewmodel.data.p.d;
import com.tencent.mm.plugin.finder.utils.bq;
import com.tencent.mm.protocal.protobuf.anc;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bsq;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.etk;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.g.a.m;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveBoxSlice;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/IBusiness;", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "liveContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "boxDataStore", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BoxDataStore;", "getBoxDataStore", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BoxDataStore;", "setBoxDataStore", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BoxDataStore;)V", "bulletStore", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BoxBulletStore;", "getBulletStore", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BoxBulletStore;", "setBulletStore", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BoxBulletStore;)V", "commentReadCount", "", "getCommentReadCount", "()J", "setCommentReadCount", "(J)V", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "setContextObj", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "curBox", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBoxId;", "getCurBox", "()Landroidx/lifecycle/MutableLiveData;", "setCurBox", "(Landroidx/lifecycle/MutableLiveData;)V", "enterTime", "getEnterTime", "setEnterTime", "firstVisiableCommentPosition", "", "getFirstVisiableCommentPosition", "()I", "setFirstVisiableCommentPosition", "(I)V", "hasInit", "", "getHasInit", "()Z", "setHasInit", "(Z)V", "lastVisiableCommentPosition", "getLastVisiableCommentPosition", "setLastVisiableCommentPosition", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "setLifeCycleKeeper", "(Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;)V", "liveId", "getLiveId", "value", "reachLastVisibleComment", "getReachLastVisibleComment", "setReachLastVisibleComment", "unReadAtMeMsgPos", "getUnReadAtMeMsgPos", "setUnReadAtMeMsgPos", "dismissAllRedDot", "", "enterBox", "box", "exitBox", "getAllBoxInfo", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BoxMsgInfo;", "getDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BaseBoxMsg;", "Lkotlin/collections/ArrayList;", "boxId", "getRedDotMap", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BoxRedDotInfo;", "inBox", "initData", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCleared", "pauseRedDotPolling", "postLikeMsg", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "postMsg", "prepareBox", "groupId", "useLastBoxDefault", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resumeRedDotPolling", "revertLikeMsg", "likeMsg", "saveBox", "tag", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setDataNotifier", "notifier", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BoxDataStore$BoxMsgNotifier;", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
  extends c<com.tencent.mm.plugin.finder.live.model.context.a>
{
  public static final String TAG;
  public static final a akgP;
  private static int akgW;
  private com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> AAh;
  bui Auc;
  public long EgL;
  public x<bfv> akgQ;
  public int akgR;
  public int akgS;
  public boolean akgT;
  public int akgU;
  public com.tencent.mm.plugin.finder.live.viewmodel.data.a.f akgV;
  public com.tencent.mm.plugin.finder.live.viewmodel.data.a.c akgn;
  public long enterTime;
  public boolean hasInit;
  
  static
  {
    AppMethodBeat.i(371779);
    akgP = new a((byte)0);
    TAG = "Finder.LiveBoxSlice";
    AppMethodBeat.o(371779);
  }
  
  public s(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(371763);
    this.AAh = new com.tencent.mm.vending.e.c();
    this.akgQ = new x();
    this.akgR = -1;
    this.akgS = -1;
    this.akgT = true;
    AppMethodBeat.o(371763);
  }
  
  private static final Object a(s params, bdm parambdm, b.a parama)
  {
    AppMethodBeat.i(371774);
    kotlin.g.b.s.u(params, "this$0");
    kotlin.g.b.s.u(parambdm, "$msg");
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      params = ah.aiuX;
      AppMethodBeat.o(371774);
      return params;
    }
    parama = bq.akii;
    bq.rT(TAG, "cgi failed, revert like op");
    params = params.akgV;
    if (params == null)
    {
      AppMethodBeat.o(371774);
      return null;
    }
    boolean bool = params.c(f(parambdm));
    AppMethodBeat.o(371774);
    return Boolean.valueOf(bool);
  }
  
  private static final ah a(com.tencent.mm.plugin.finder.live.viewmodel.data.a.b paramb, final s params, b.a parama)
  {
    AppMethodBeat.i(371770);
    kotlin.g.b.s.u(params, "this$0");
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      parama = parama.ott;
      if ((parama != null) && (paramb != null))
      {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(paramb, (bsq)parama, params));
        paramb = ah.aiuX;
        AppMethodBeat.o(371770);
        return paramb;
      }
      AppMethodBeat.o(371770);
      return null;
    }
    Log.e(TAG, "postMsg error errType: " + parama.errType + " errCode: " + parama.errCode + " errMsg: " + parama.errMsg);
    paramb = ah.aiuX;
    AppMethodBeat.o(371770);
    return paramb;
  }
  
  public static Object e(String paramString, long paramLong, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(371769);
    e locale = e.akgh;
    paramString = e.d(paramString, paramLong, paramd);
    if (paramString == kotlin.d.a.a.aiwj)
    {
      AppMethodBeat.o(371769);
      return paramString;
    }
    paramString = ah.aiuX;
    AppMethodBeat.o(371769);
    return paramString;
  }
  
  private static bdm f(bdm parambdm)
  {
    AppMethodBeat.i(371767);
    localObject3 = (com.tencent.mm.bx.a)new etk();
    Object localObject1 = parambdm.ZNY;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((com.tencent.mm.bx.b)localObject1).toByteArray())
    {
      try
      {
        ((com.tencent.mm.bx.a)localObject3).parseFrom((byte[])localObject1);
        localObject1 = localObject3;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i;
          Log.printDebugStack("safeParser", "", new Object[] { localException });
          Object localObject2 = null;
          continue;
          localObject3 = c.a.akmY;
          if (i == c.a.a.kMI())
          {
            localObject3 = c.a.akmY;
            localObject2.YAN = c.a.a.kMH();
            localObject2.akkK += 1;
          }
        }
      }
      localObject1 = (etk)localObject1;
      if (localObject1 != null)
      {
        i = ((etk)localObject1).YAN;
        localObject3 = c.a.akmY;
        if (i != c.a.a.kMH()) {
          break;
        }
        localObject3 = c.a.akmY;
        ((etk)localObject1).YAN = c.a.a.kMI();
        ((etk)localObject1).akkK -= 1;
        ((etk)localObject1).akkK = Math.max(0, ((etk)localObject1).akkK);
      }
      AppMethodBeat.o(371767);
      return parambdm;
    }
  }
  
  private long getLiveId()
  {
    AppMethodBeat.i(371764);
    long l = ((f)business(f.class)).liveInfo.liveId;
    AppMethodBeat.o(371764);
    return l;
  }
  
  public final void PX(boolean paramBoolean)
  {
    AppMethodBeat.i(371783);
    if (paramBoolean != this.akgT) {
      Log.i(TAG, "reachLastVisibleComment from " + this.akgT + " to " + paramBoolean + '!');
    }
    this.akgT = paramBoolean;
    AppMethodBeat.o(371783);
  }
  
  public final Object a(bui parambui, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(371788);
    Object localObject1;
    if ((paramd instanceof c))
    {
      localObject1 = (c)paramd;
      if ((((c)localObject1).label & 0x80000000) != 0) {
        ((c)localObject1).label += -2147483648;
      }
    }
    for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = new c(this, paramd))
    {
      localObject2 = paramd.result;
      localObject1 = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        parambui = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(371788);
        throw parambui;
      }
    }
    ResultKt.throwOnFailure(localObject2);
    Object localObject2 = bq.akii;
    bq.rR(TAG, kotlin.g.b.s.X("LiveBoxSlice initData, hasInit:", Boolean.valueOf(this.hasInit)));
    this.Auc = parambui;
    if (!this.hasInit)
    {
      this.hasInit = true;
      parambui = e.akgh;
      long l = getLiveId();
      paramd.L$0 = this;
      paramd.label = 1;
      parambui = this;
      if (e.c("initData", l, paramd) == localObject1)
      {
        AppMethodBeat.o(371788);
        return localObject1;
        parambui = (s)paramd.L$0;
        ResultKt.throwOnFailure(localObject2);
      }
      parambui.akgn = new com.tencent.mm.plugin.finder.live.viewmodel.data.a.c();
      localObject2 = parambui.CBK;
      localObject1 = parambui.akgn;
      paramd = (kotlin.d.d<? super ah>)localObject1;
      if (localObject1 == null) {
        paramd = new com.tencent.mm.plugin.finder.live.viewmodel.data.a.c();
      }
      parambui.akgV = new com.tencent.mm.plugin.finder.live.viewmodel.data.a.f((com.tencent.mm.plugin.finder.live.model.context.a)localObject2, paramd);
    }
    parambui = ah.aiuX;
    AppMethodBeat.o(371788);
    return parambui;
  }
  
  public final void a(bfv parambfv)
  {
    AppMethodBeat.i(371791);
    kotlin.g.b.s.u(parambfv, "box");
    Object localObject1 = bq.akii;
    bq.rR(TAG, kotlin.g.b.s.X("LiveBoxSlice enterBox: ", parambfv.id));
    Object localObject2 = parambfv.id;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    if (((CharSequence)localObject1).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w(TAG, "enterBox but boxId isEmpty");
      AppMethodBeat.o(371791);
      return;
    }
    localObject2 = (bfv)this.akgQ.getValue();
    if (localObject2 == null) {}
    for (localObject2 = null; kotlin.g.b.s.p(localObject2, localObject1); localObject2 = ((bfv)localObject2).id)
    {
      AppMethodBeat.o(371791);
      return;
    }
    localObject2 = this.akgV;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.a.f)localObject2).bkI((String)localObject1);
    }
    localObject1 = this.akgV;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.a.f)localObject1).kLd();
      if (localObject1 != null)
      {
        localObject1 = ((h)localObject1).akgL;
        if (localObject1 != null)
        {
          localObject2 = bq.akii;
          localObject2 = TAG;
          StringBuilder localStringBuilder = new StringBuilder("LiveBoxSlice startPollingMsg, boxContext hashCode:").append(((anc)localObject1).hashCode()).append(", logInfo: ");
          bq localbq = bq.akii;
          bq.rR((String)localObject2, bq.c((anc)localObject1));
          localObject2 = this.akgV;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.a.f)localObject2).a(parambfv, (anc)localObject1, this.Auc);
          }
        }
      }
    }
    this.akgQ.setValue(parambfv);
    this.enterTime = cn.bDw();
    AppMethodBeat.o(371791);
  }
  
  public final void a(String paramString, bdm parambdm)
  {
    AppMethodBeat.i(371795);
    kotlin.g.b.s.u(paramString, "boxId");
    kotlin.g.b.s.u(parambdm, "msg");
    com.tencent.mm.plugin.finder.live.viewmodel.data.a.f localf = this.akgV;
    Object localObject;
    if (localf == null) {
      localObject = null;
    }
    for (;;)
    {
      new eg(parambdm, this.CBK, this.Auc).bFJ().a((com.tencent.mm.vending.e.b)this.AAh).g(new s..ExternalSyntheticLambda0((com.tencent.mm.plugin.finder.live.viewmodel.data.a.b)localObject, this));
      AppMethodBeat.o(371795);
      return;
      kotlin.g.b.s.u(paramString, "boxId");
      kotlin.g.b.s.u(parambdm, "msg");
      Log.i(com.tencent.mm.plugin.finder.live.viewmodel.data.a.f.TAG, kotlin.g.b.s.X("insertLocal ", parambdm.Tro));
      com.tencent.mm.plugin.finder.live.viewmodel.data.a.b localb = f.b.d(parambdm);
      localObject = localb;
      if (localb != null)
      {
        localb.hJv = true;
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new f.j(localf, paramString, localb));
        localObject = localb;
      }
    }
  }
  
  public final void aNA(int paramInt)
  {
    AppMethodBeat.i(371785);
    if (paramInt != this.akgU) {
      Log.i(TAG, "unReadAtMeMsgPos from " + this.akgU + " to " + paramInt);
    }
    this.akgU = paramInt;
    AppMethodBeat.o(371785);
  }
  
  public final Object c(String paramString, final boolean paramBoolean, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(371790);
    paramString = l.a((kotlin.d.f)bg.kCh(), (m)new e(paramString, this, paramBoolean, null), paramd);
    AppMethodBeat.o(371790);
    return paramString;
  }
  
  public final void e(bdm parambdm)
  {
    AppMethodBeat.i(371796);
    kotlin.g.b.s.u(parambdm, "msg");
    Object localObject = bq.akii;
    bq.rT(TAG, kotlin.g.b.s.X("postLikeMsg, seq:", Long.valueOf(parambdm.seq)));
    localObject = this.akgV;
    if (localObject == null) {}
    for (boolean bool = false; !bool; bool = ((com.tencent.mm.plugin.finder.live.viewmodel.data.a.f)localObject).c(parambdm))
    {
      Log.i(TAG, "update failed, don't request cgi");
      AppMethodBeat.o(371796);
      return;
    }
    new eg(parambdm, this.CBK, this.Auc).bFJ().a((com.tencent.mm.vending.e.b)this.AAh).g(new s..ExternalSyntheticLambda1(this, parambdm));
    AppMethodBeat.o(371796);
  }
  
  public final x<ConcurrentHashMap<String, h>> kLh()
  {
    com.tencent.mm.plugin.finder.live.viewmodel.data.a.f localf = this.akgV;
    if (localf == null) {
      return null;
    }
    return localf.akgo;
  }
  
  public final x<ConcurrentHashMap<String, i>> kLi()
  {
    com.tencent.mm.plugin.finder.live.viewmodel.data.a.f localf = this.akgV;
    if (localf == null) {
      return null;
    }
    return localf.akgq;
  }
  
  public final void kLj()
  {
    AppMethodBeat.i(371792);
    x localx = kLi();
    if (localx != null)
    {
      bq localbq = bq.akii;
      bq.a(localx, (kotlin.g.a.b)b.akgX);
    }
    AppMethodBeat.o(371792);
  }
  
  public final void kLk()
  {
    AppMethodBeat.i(371793);
    Object localObject = bq.akii;
    bq.rS(TAG, "pauseRedDotPolling");
    localObject = this.akgV;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.a.f)localObject).akgr = false;
    }
    AppMethodBeat.o(371793);
  }
  
  public final void kLl()
  {
    AppMethodBeat.i(371794);
    Object localObject = bq.akii;
    bq.rS(TAG, "resumeRedDotPolling");
    localObject = this.akgV;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.a.f)localObject).akgr = true;
    }
    AppMethodBeat.o(371794);
  }
  
  public final boolean kLm()
  {
    AppMethodBeat.i(371797);
    Object localObject = (bfv)this.akgQ.getValue();
    if (localObject == null)
    {
      AppMethodBeat.o(371797);
      return false;
    }
    int i = ((bfv)localObject).type;
    localObject = c.c.aknf;
    if (i != c.c.a.kMK())
    {
      AppMethodBeat.o(371797);
      return true;
    }
    AppMethodBeat.o(371797);
    return false;
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(371798);
    super.onCleared();
    this.AAh.dead();
    this.akgQ = new x();
    com.tencent.mm.plugin.finder.live.viewmodel.data.a.f localf = this.akgV;
    if (localf != null)
    {
      Log.i(com.tencent.mm.plugin.finder.live.viewmodel.data.a.f.TAG, "release");
      localf.akgo = new x(new ConcurrentHashMap());
      localf.akgp.clear();
      localf.akgq = new x(new ConcurrentHashMap());
      p localp = localf.akgs;
      if (localp != null) {
        localp.stopAsync();
      }
      localf.akgs = null;
      localp = localf.akgt;
      if (localp != null) {
        localp.stopAsync();
      }
      localf.akgt = null;
    }
    this.akgV = null;
    this.akgn = null;
    this.akgS = -1;
    this.akgR = -1;
    PX(true);
    this.hasInit = false;
    this.EgL = 0L;
    aNA(0);
    this.enterTime = 0L;
    AppMethodBeat.o(371798);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveBoxSlice$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "value", "", "minimunShowMsgLikeCnt", "getMinimunShowMsgLikeCnt", "()I", "setMinimunShowMsgLikeCnt", "(I)V", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BoxRedDotInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<ConcurrentHashMap<String, i>, ah>
  {
    public static final b akgX;
    
    static
    {
      AppMethodBeat.i(371765);
      akgX = new b();
      AppMethodBeat.o(371765);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    c(s params, kotlin.d.d<? super c> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(371766);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.akgY.a(null, (kotlin.d.d)this);
      AppMethodBeat.o(371766);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(com.tencent.mm.plugin.finder.live.viewmodel.data.a.b paramb, bsq parambsq, s params)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    e(String paramString, s params, boolean paramBoolean, kotlin.d.d<? super e> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(371773);
      paramObject = (kotlin.d.d)new e(this.adlK, jdField_this, paramBoolean, paramd);
      AppMethodBeat.o(371773);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(371771);
      Object localObject1 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(371771);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = bq.akii;
        paramObject = s.akgP;
        bq.rR(s.access$getTAG$cp(), kotlin.g.b.s.X("LiveBoxSlice prepareBox, groupId:", this.adlK));
        paramObject = jdField_this.akgV;
        if (paramObject != null)
        {
          localObject2 = this.adlK;
          boolean bool = paramBoolean;
          localObject3 = (kotlin.d.d)this;
          this.label = 1;
          if (paramObject.b((String)localObject2, bool, (kotlin.d.d)localObject3) == localObject1)
          {
            AppMethodBeat.o(371771);
            return localObject1;
          }
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = jdField_this.akgV;
      if (paramObject == null)
      {
        AppMethodBeat.o(371771);
        return null;
      }
      paramObject = paramObject.kLd();
      if (paramObject == null)
      {
        AppMethodBeat.o(371771);
        return null;
      }
      paramObject = paramObject.akgL;
      if (paramObject == null)
      {
        AppMethodBeat.o(371771);
        return null;
      }
      localObject1 = jdField_this;
      Object localObject2 = bq.akii;
      localObject2 = s.akgP;
      localObject2 = s.access$getTAG$cp();
      Object localObject3 = bq.akii;
      bq.rR((String)localObject2, kotlin.g.b.s.X("LiveBoxSlice startPollingRedDot, boxContext:", bq.c(paramObject)));
      localObject2 = ((s)localObject1).akgV;
      if (localObject2 == null)
      {
        AppMethodBeat.o(371771);
        return null;
      }
      localObject1 = ((s)localObject1).Auc;
      kotlin.g.b.s.u(paramObject, "boxContext");
      Log.i(com.tencent.mm.plugin.finder.live.viewmodel.data.a.f.TAG, "startPollingRedDot");
      Log.i(com.tencent.mm.plugin.finder.live.viewmodel.data.a.f.TAG, "stopPollingRedDot");
      localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.a.f)localObject2).akgt;
      if (localObject3 != null) {
        ((p)localObject3).stopAsync();
      }
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.a.f)localObject2).akgt = new p((p.d)new f.e((com.tencent.mm.plugin.finder.live.viewmodel.data.a.f)localObject2, paramObject, (bui)localObject1), (kotlin.d.f)bg.kCi());
      paramObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.a.f)localObject2).akgt;
      if (paramObject != null) {
        paramObject.start();
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(371771);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.business.s
 * JD-Core Version:    0.7.0.1
 */