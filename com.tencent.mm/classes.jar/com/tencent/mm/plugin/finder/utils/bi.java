package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.cp.f;
import com.tencent.mm.plugin.finder.cgi.ah.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.protocal.protobuf.awr;
import com.tencent.mm.protocal.protobuf.bkq;
import com.tencent.mm.protocal.protobuf.cdr;
import com.tencent.mm.protocal.protobuf.cds;
import com.tencent.mm.protocal.protobuf.ctt;
import com.tencent.mm.protocal.protobuf.ctu;
import com.tencent.mm.protocal.protobuf.dcg;
import com.tencent.mm.protocal.protobuf.dch;
import com.tencent.mm.protocal.protobuf.deq;
import com.tencent.mm.protocal.protobuf.der;
import com.tencent.mm.protocal.protobuf.dz;
import com.tencent.mm.protocal.protobuf.ea;
import com.tencent.mm.protocal.protobuf.fgz;
import com.tencent.mm.protocal.protobuf.fsf;
import com.tencent.mm.protocal.protobuf.fsg;
import com.tencent.mm.protocal.protobuf.fvf;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.d.h;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/OlympicsCgiUtil;", "", "()V", "TAG", "", "addTorchLive", "Lcom/tencent/mm/protocal/protobuf/AddTorchCertResponse;", "req", "Lcom/tencent/mm/protocal/protobuf/AddTorchCertRequest;", "(Lcom/tencent/mm/protocal/protobuf/AddTorchCertRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEventActivityInfo", "", "lifeCycle", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/protocal/protobuf/GetActivityInfoRequest;", "callback", "Lkotlin/Function2;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveOpenTransferResponse;", "Lcom/tencent/mm/protocal/protobuf/GetActivityInfoResponse;", "getTorchLive", "Lcom/tencent/mm/protocal/protobuf/GetTorchCertResponse;", "Lcom/tencent/mm/protocal/protobuf/GetTorchCertRequest;", "(Lcom/tencent/mm/protocal/protobuf/GetTorchCertRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initTorchLive", "Lcom/tencent/mm/protocal/protobuf/InitTorchLiveRequest;", "Lcom/tencent/mm/protocal/protobuf/InitTorchLiveResponse;", "joinRun", "Lcom/tencent/mm/protocal/protobuf/JoinRunWithRequest;", "Lcom/tencent/mm/protocal/protobuf/JoinRunWithResponse;", "test", "updateTorchLive", "Lcom/tencent/mm/protocal/protobuf/UpdateTorchCertResponse;", "Lcom/tencent/mm/protocal/protobuf/UpdateTorchCertRequest;", "(Lcom/tencent/mm/protocal/protobuf/UpdateTorchCertRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bi
{
  public static final bi GlP;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(333273);
    GlP = new bi();
    TAG = "Finder.OlympicsCgiUtil";
    AppMethodBeat.o(333273);
  }
  
  public static Object a(ctt paramctt, kotlin.d.d<? super ctu> paramd)
  {
    AppMethodBeat.i(333182);
    h localh = new h(kotlin.d.a.b.au(paramd));
    kotlin.d.d locald = (kotlin.d.d)localh;
    Object localObject1 = TAG;
    Object localObject2 = bj.GlQ;
    Log.i((String)localObject1, s.X("getTorchLive req:", bj.a(paramctt)));
    localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
    localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.emY();
    if (localObject1 == null) {
      localObject1 = "";
    }
    for (;;)
    {
      new com.tencent.mm.plugin.finder.cgi.ah("/cgi-bin/micromsg-bin/finderliveopengettorchcert", 7156, (String)localObject1, (com.tencent.mm.bx.a)paramctt).bFJ().g((com.tencent.mm.vending.c.a)new b(locald));
      paramctt = localh.kli();
      if (paramctt == kotlin.d.a.a.aiwj) {
        s.u(paramd, "frame");
      }
      AppMethodBeat.o(333182);
      return paramctt;
      localObject1 = (e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(e.class);
      if (localObject1 == null)
      {
        localObject1 = "";
      }
      else
      {
        localObject2 = ((e)localObject1).token;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
    }
  }
  
  public static Object a(dz paramdz, kotlin.d.d<? super ea> paramd)
  {
    AppMethodBeat.i(333174);
    h localh = new h(kotlin.d.a.b.au(paramd));
    kotlin.d.d locald = (kotlin.d.d)localh;
    Object localObject1 = TAG;
    Object localObject2 = bj.GlQ;
    Log.i((String)localObject1, s.X("addTorchLive req:", bj.a(paramdz)));
    localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
    localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.emY();
    if (localObject1 == null) {
      localObject1 = "";
    }
    for (;;)
    {
      new com.tencent.mm.plugin.finder.cgi.ah("/cgi-bin/micromsg-bin/finderliveopenaddtorchcert", 8500, (String)localObject1, (com.tencent.mm.bx.a)paramdz).bFJ().g((com.tencent.mm.vending.c.a)new a(locald));
      paramdz = localh.kli();
      if (paramdz == kotlin.d.a.a.aiwj) {
        s.u(paramd, "frame");
      }
      AppMethodBeat.o(333174);
      return paramdz;
      localObject1 = (e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(e.class);
      if (localObject1 == null)
      {
        localObject1 = "";
      }
      else
      {
        localObject2 = ((e)localObject1).token;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
    }
  }
  
  public static Object a(fsf paramfsf, kotlin.d.d<? super fsg> paramd)
  {
    AppMethodBeat.i(333195);
    h localh = new h(kotlin.d.a.b.au(paramd));
    kotlin.d.d locald = (kotlin.d.d)localh;
    Object localObject1 = TAG;
    Object localObject2 = bj.GlQ;
    Log.i((String)localObject1, s.X("updateTorchLive req:", bj.a(paramfsf)));
    localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
    localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.emY();
    if (localObject1 == null) {
      localObject1 = "";
    }
    for (;;)
    {
      new com.tencent.mm.plugin.finder.cgi.ah("/cgi-bin/micromsg-bin/finderliveopenupdatetorchcert", 7582, (String)localObject1, (com.tencent.mm.bx.a)paramfsf).bFJ().g((com.tencent.mm.vending.c.a)new c(locald));
      paramfsf = localh.kli();
      if (paramfsf == kotlin.d.a.a.aiwj) {
        s.u(paramd, "frame");
      }
      AppMethodBeat.o(333195);
      return paramfsf;
      localObject1 = (e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(e.class);
      if (localObject1 == null)
      {
        localObject1 = "";
      }
      else
      {
        localObject2 = ((e)localObject1).token;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
    }
  }
  
  private static final kotlin.ah a(m paramm, b.a parama)
  {
    AppMethodBeat.i(333233);
    s.u(paramm, "$callback");
    Object localObject = com.tencent.mm.plugin.finder.cgi.ah.AzO;
    s.s(parama, "it");
    dch localdch = (dch)ah.a.a(parama, (com.tencent.mm.bx.a)new dch());
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("initTorchLive, errType: ").append(parama.errType).append(", errCode:").append(parama.errCode).append(", resp:");
    if (localdch == null) {}
    for (localObject = null;; localObject = bj.a(localdch))
    {
      Log.i(str, localObject);
      paramm.invoke(parama, localdch);
      paramm = kotlin.ah.aiuX;
      AppMethodBeat.o(333233);
      return paramm;
      localObject = bj.GlQ;
    }
  }
  
  public static void a(deq paramdeq, m<? super b.a<bkq>, ? super der, kotlin.ah> paramm)
  {
    AppMethodBeat.i(333209);
    s.u(paramdeq, "req");
    s.u(paramm, "callback");
    Object localObject1 = TAG;
    Object localObject2 = bj.GlQ;
    Log.i((String)localObject1, s.X("joinRun req:", bj.a(paramdeq)));
    localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
    localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.emY();
    if (localObject1 == null) {
      localObject1 = "";
    }
    for (;;)
    {
      new com.tencent.mm.plugin.finder.cgi.ah("/cgi-bin/micromsg-bin/finderliveopenjoinrunwith", 11157, (String)localObject1, (com.tencent.mm.bx.a)paramdeq).bFJ().g(new bi..ExternalSyntheticLambda1(paramm));
      AppMethodBeat.o(333209);
      return;
      localObject1 = (e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(e.class);
      if (localObject1 == null)
      {
        localObject1 = "";
      }
      else
      {
        localObject2 = ((e)localObject1).token;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
    }
  }
  
  public static void a(com.tencent.mm.vending.e.b<?> paramb, cdr paramcdr, m<? super b.a<bkq>, ? super cds, kotlin.ah> paramm)
  {
    AppMethodBeat.i(333223);
    s.u(paramcdr, "req");
    s.u(paramm, "callback");
    String str = TAG;
    Object localObject = bj.GlQ;
    s.u(paramcdr, "<this>");
    StringBuilder localStringBuilder = new StringBuilder("activity_id:").append(paramcdr.Vyi).append(", user_location:");
    localObject = paramcdr.aaob;
    if (localObject == null)
    {
      localObject = null;
      Log.i(str, s.X("getEventActivityInfo req:", localObject + ", live_id:" + com.tencent.mm.ae.d.hF(paramcdr.mMJ)));
      localObject = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
      localObject = com.tencent.mm.plugin.finder.live.model.context.a.emY();
      if (localObject != null) {
        break label183;
      }
      localObject = "";
    }
    for (;;)
    {
      paramcdr = new com.tencent.mm.plugin.finder.cgi.ah("/cgi-bin/micromsg-bin/finderliveeventgetactivityinfo", 9425, (String)localObject, (com.tencent.mm.bx.a)paramcdr).bFJ();
      if (paramb != null) {
        paramcdr.a(paramb);
      }
      paramcdr.g(new bi..ExternalSyntheticLambda0(paramm));
      AppMethodBeat.o(333223);
      return;
      localObject = bj.a((fvf)localObject);
      break;
      label183:
      localObject = (e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(e.class);
      if (localObject == null)
      {
        localObject = "";
      }
      else
      {
        str = ((e)localObject).token;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
      }
    }
  }
  
  public static void a(com.tencent.mm.vending.e.b<?> paramb, dcg paramdcg, m<? super b.a<bkq>, ? super dch, kotlin.ah> paramm)
  {
    AppMethodBeat.i(333165);
    s.u(paramdcg, "req");
    s.u(paramm, "callback");
    Object localObject1 = TAG;
    Object localObject2 = bj.GlQ;
    Log.i((String)localObject1, s.X("initTorchLive req:", bj.a(paramdcg)));
    localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
    localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.emY();
    if (localObject1 == null) {
      localObject1 = "";
    }
    for (;;)
    {
      paramdcg = new com.tencent.mm.plugin.finder.cgi.ah("/cgi-bin/micromsg-bin/finderliveopeninittorchlive", 7268, (String)localObject1, (com.tencent.mm.bx.a)paramdcg).bFJ();
      if (paramb != null) {
        paramdcg.a(paramb);
      }
      paramdcg.g(new bi..ExternalSyntheticLambda2(paramm));
      AppMethodBeat.o(333165);
      return;
      localObject1 = (e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(e.class);
      if (localObject1 == null)
      {
        localObject1 = "";
      }
      else
      {
        localObject2 = ((e)localObject1).token;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
    }
  }
  
  private static final kotlin.ah b(m paramm, b.a parama)
  {
    AppMethodBeat.i(333242);
    s.u(paramm, "$callback");
    Object localObject = com.tencent.mm.plugin.finder.cgi.ah.AzO;
    s.s(parama, "it");
    der localder = (der)ah.a.a(parama, (com.tencent.mm.bx.a)new der());
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("joinRun, errType: ").append(parama.errType).append(", errCode:").append(parama.errCode).append(", resp:");
    if (localder == null) {}
    for (localObject = null;; localObject = bj.a(localder))
    {
      Log.i(str, localObject);
      paramm.invoke(parama, localder);
      paramm = kotlin.ah.aiuX;
      AppMethodBeat.o(333242);
      return paramm;
      localObject = bj.GlQ;
    }
  }
  
  private static final kotlin.ah c(m paramm, b.a parama)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(333256);
    s.u(paramm, "$callback");
    Object localObject3 = com.tencent.mm.plugin.finder.cgi.ah.AzO;
    s.s(parama, "it");
    localObject3 = (cds)ah.a.a(parama, (com.tencent.mm.bx.a)new cds());
    String str = TAG;
    StringBuilder localStringBuilder1 = new StringBuilder("getEventActivityInfo, errType: ").append(parama.errType).append(", errCode:").append(parama.errCode).append(", resp:");
    if (localObject3 == null)
    {
      Log.i(str, localObject1);
      paramm.invoke(parama, localObject3);
      paramm = kotlin.ah.aiuX;
      AppMethodBeat.o(333256);
      return paramm;
    }
    localObject1 = bj.GlQ;
    s.u(localObject3, "<this>");
    StringBuilder localStringBuilder2 = new StringBuilder("ret:");
    localObject1 = ((cds)localObject3).YGg;
    if (localObject1 == null)
    {
      localObject1 = null;
      label165:
      localStringBuilder2 = localStringBuilder2.append(localObject1).append(", msg:");
      localObject1 = ((cds)localObject3).YGg;
      if (localObject1 != null) {
        break label241;
      }
      localObject1 = null;
      label191:
      localStringBuilder2 = localStringBuilder2.append(localObject1).append(", activity:");
      localObject1 = ((cds)localObject3).CNI;
      if (localObject1 != null) {
        break label249;
      }
    }
    label241:
    label249:
    for (localObject1 = localObject2;; localObject1 = bj.b((fgz)localObject1))
    {
      localObject1 = localObject1;
      break;
      localObject1 = Integer.valueOf(((awr)localObject1).ret);
      break label165;
      localObject1 = ((awr)localObject1).msg;
      break label191;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/AddTorchCertResponse;", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveOpenTransferResponse;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a
  {
    a(kotlin.d.d<? super ea> paramd) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/GetTorchCertResponse;", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveOpenTransferResponse;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a
  {
    b(kotlin.d.d<? super ctu> paramd) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/UpdateTorchCertResponse;", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveOpenTransferResponse;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a
  {
    c(kotlin.d.d<? super fsg> paramd) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.bi
 * JD-Core Version:    0.7.0.1
 */