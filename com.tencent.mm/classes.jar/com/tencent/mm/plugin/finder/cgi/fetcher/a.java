package com.tencent.mm.plugin.finder.cgi.fetcher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.plugin.finder.cgi.af;
import com.tencent.mm.plugin.finder.cgi.af.a;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.plugin.finder.storage.y;
import com.tencent.mm.plugin.findersdk.a.ai;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.atu;
import com.tencent.mm.protocal.protobuf.atv;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.j;
import kotlin.g;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderContactFetcher;", "", "()V", "aliasContactStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderMsgAliasContactStorage;", "getAliasContactStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderMsgAliasContactStorage;", "aliasContactStorage$delegate", "Lkotlin/Lazy;", "fetchingSet", "Ljava/util/concurrent/ConcurrentHashMap;", "", "strangerContactStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage;", "getStrangerContactStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage;", "strangerContactStorage$delegate", "fetchContact", "", "req", "call", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "Lkotlin/ParameterName;", "name", "result", "type", "", "fetchContact2", "Lcom/tencent/mm/protocal/protobuf/FinderContactMsgInfo;", "fetchContact3", "Lcom/tencent/mm/protocal/protobuf/FinderContactCommentInfo;", "fetchContactList", "reqList", "", "resultList", "fetchContactList2", "fetchContactList3", "fetchSelfAliasContact", "fetchSelfAliasList", "onFetchContactResp", "back", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetContactListResp;", "Ljava/util/LinkedList;", "from", "Companion", "plugin-finder_release"})
public final class a
{
  public static final a xeG;
  public final ConcurrentHashMap<String, Object> xeD;
  private final kotlin.f xeE;
  private final kotlin.f xeF;
  
  static
  {
    AppMethodBeat.i(279175);
    xeG = new a((byte)0);
    AppMethodBeat.o(279175);
  }
  
  public a()
  {
    AppMethodBeat.i(279174);
    this.xeD = new ConcurrentHashMap();
    this.xeE = g.ar((kotlin.g.a.a)l.xeL);
    this.xeF = g.ar((kotlin.g.a.a)b.xeH);
    AppMethodBeat.o(279174);
  }
  
  private final com.tencent.mm.plugin.finder.storage.z dpi()
  {
    AppMethodBeat.i(279166);
    com.tencent.mm.plugin.finder.storage.z localz = (com.tencent.mm.plugin.finder.storage.z)this.xeE.getValue();
    AppMethodBeat.o(279166);
    return localz;
  }
  
  private final y dpj()
  {
    AppMethodBeat.i(279167);
    y localy = (y)this.xeF.getValue();
    AppMethodBeat.o(279167);
    return localy;
  }
  
  public final void E(final b<? super ai, x> paramb)
  {
    AppMethodBeat.i(279173);
    p.k(paramb, "call");
    Object localObject2 = com.tencent.mm.model.z.bdi();
    Object localObject3;
    if (!this.xeD.containsKey(localObject2))
    {
      localObject3 = (Map)this.xeD;
      if (localObject2 != null) {
        break label267;
      }
    }
    label267:
    for (Object localObject1 = "";; localObject1 = localObject2)
    {
      ((Map)localObject3).put(localObject1, this);
      paramb = (b)new j(this, (String)localObject2, paramb);
      localObject1 = new LinkedList();
      localObject2 = af.xbO;
      localObject2 = new af();
      localObject3 = new d.a();
      Object localObject4 = new atu();
      ao localao = ao.xcj;
      ((atu)localObject4).SDi = ao.dnO();
      ((atu)localObject4).SGE = 5;
      ((atu)localObject4).RLN = com.tencent.mm.model.z.bdh();
      ((d.a)localObject3).c((com.tencent.mm.cd.a)localObject4);
      localObject4 = new atv();
      ((atv)localObject4).setBaseResponse(new jh());
      ((atv)localObject4).getBaseResponse().Tef = new eaf();
      ((d.a)localObject3).d((com.tencent.mm.cd.a)localObject4);
      ((d.a)localObject3).TW("/cgi-bin/micromsg-bin/findergetcontactlist");
      ((d.a)localObject3).vD(3953);
      ((af)localObject2).c(((d.a)localObject3).bgN());
      Log.i("Finder.CgiGetFinderContact", "[CgiGetFinderContact] ");
      ((af)localObject2).bhW().j((com.tencent.mm.vending.c.a)new k(this, (LinkedList)localObject1, paramb));
      AppMethodBeat.o(279173);
      return;
      Log.w("Finder.ContactFetcher", "fetchAliasContact[req] is loading. just return");
      AppMethodBeat.o(279173);
      return;
    }
  }
  
  public final void a(final arg paramarg, final b<? super ai, x> paramb)
  {
    AppMethodBeat.i(279172);
    p.k(paramarg, "req");
    p.k(paramb, "call");
    Object localObject2 = paramarg.SEn;
    Object localObject1 = (Map)this.xeD;
    if (localObject1 == null)
    {
      paramarg = new t("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
      AppMethodBeat.o(279172);
      throw paramarg;
    }
    Map localMap;
    if (!((Map)localObject1).containsKey(localObject2))
    {
      localMap = (Map)this.xeD;
      if (localObject2 != null) {
        break label175;
      }
    }
    label175:
    for (localObject1 = "";; localObject1 = localObject2)
    {
      localMap.put(localObject1, this);
      paramarg = j.listOf(paramarg);
      paramb = (b)new d(this, (String)localObject2, paramb);
      localObject1 = new LinkedList();
      localObject2 = af.xbO;
      af.a.dW(paramarg).bhW().j((com.tencent.mm.vending.c.a)new h(this, (LinkedList)localObject1, paramarg, paramb));
      AppMethodBeat.o(279172);
      return;
      Log.w("Finder.ContactFetcher", "fetchContact2[req] is loading. just return");
      AppMethodBeat.o(279172);
      return;
    }
  }
  
  public final void a(final String paramString, final b<? super ai, x> paramb, int paramInt)
  {
    AppMethodBeat.i(279170);
    p.k(paramString, "req");
    p.k(paramb, "call");
    if (!this.xeD.containsKey(paramString))
    {
      ((Map)this.xeD).put(paramString, this);
      a(j.listOf(paramString), (b)new c(this, paramString, paramb), paramInt);
      AppMethodBeat.o(279170);
      return;
    }
    Log.w("Finder.ContactFetcher", "fetchContact[req] is loading. just return");
    AppMethodBeat.o(279170);
  }
  
  public final void a(final List<String> paramList, final b<? super List<? extends ai>, x> paramb, int paramInt)
  {
    AppMethodBeat.i(279169);
    p.k(paramList, "reqList");
    p.k(paramb, "call");
    final LinkedList localLinkedList = new LinkedList();
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(279169);
      return;
      Object localObject1 = af.xbO;
      p.k(paramList, "usernameList");
      localObject1 = new af();
      d.a locala = new d.a();
      Object localObject2 = new atu();
      ao localao = ao.xcj;
      ((atu)localObject2).SDi = ao.dnO();
      ((atu)localObject2).SGD.addAll((Collection)paramList);
      ((atu)localObject2).SGE = 0;
      ((atu)localObject2).RLN = com.tencent.mm.model.z.bdh();
      locala.c((com.tencent.mm.cd.a)localObject2);
      localObject2 = new atv();
      ((atv)localObject2).setBaseResponse(new jh());
      ((atv)localObject2).getBaseResponse().Tef = new eaf();
      locala.d((com.tencent.mm.cd.a)localObject2);
      locala.TW("/cgi-bin/micromsg-bin/findergetcontactlist");
      locala.vD(3953);
      ((af)localObject1).c(locala.bgN());
      Log.i("Finder.CgiGetFinderContact", "[CgiGetFinderContact] username=".concat(String.valueOf(paramList)));
      ((af)localObject1).bhW().j((com.tencent.mm.vending.c.a)new f(this, localLinkedList, paramList, paramb));
      AppMethodBeat.o(279169);
      return;
      localObject1 = af.xbO;
      p.k(paramList, "usernameList");
      localObject1 = new af();
      locala = new d.a();
      localObject2 = new atu();
      localao = ao.xcj;
      ((atu)localObject2).SDi = ao.dnO();
      ((atu)localObject2).SGD.addAll((Collection)paramList);
      ((atu)localObject2).SGE = 4;
      ((atu)localObject2).RLN = com.tencent.mm.model.z.bdh();
      locala.c((com.tencent.mm.cd.a)localObject2);
      localObject2 = new atv();
      ((atv)localObject2).setBaseResponse(new jh());
      ((atv)localObject2).getBaseResponse().Tef = new eaf();
      locala.d((com.tencent.mm.cd.a)localObject2);
      locala.TW("/cgi-bin/micromsg-bin/findergetcontactlist");
      locala.vD(3953);
      ((af)localObject1).c(locala.bgN());
      Log.i("Finder.CgiGetFinderContact", "[CgiGetFinderContact] username=".concat(String.valueOf(paramList)));
      ((af)localObject1).bhW().j((com.tencent.mm.vending.c.a)new g(this, localLinkedList, paramList, paramb));
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderContactFetcher$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderMsgAliasContactStorage;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<y>
  {
    public static final b xeH;
    
    static
    {
      AppMethodBeat.i(273019);
      xeH = new b();
      AppMethodBeat.o(273019);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "resultList", "", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
  static final class c
    extends q
    implements b<List<? extends ai>, x>
  {
    c(a parama, String paramString, b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "resultList", "", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
  static final class d
    extends q
    implements b<List<? extends ai>, x>
  {
    d(a parama, String paramString, b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "resultList", "", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
  public static final class e
    extends q
    implements b<List<? extends ai>, x>
  {
    public e(a parama, String paramString, b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "back", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetContactListResp;", "kotlin.jvm.PlatformType", "call"})
  static final class f<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    f(a parama, LinkedList paramLinkedList, List paramList, b paramb) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "back", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetContactListResp;", "kotlin.jvm.PlatformType", "call"})
  static final class g<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    g(a parama, LinkedList paramLinkedList, List paramList, b paramb) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "back", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetContactListResp;", "kotlin.jvm.PlatformType", "call"})
  static final class h<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    h(a parama, LinkedList paramLinkedList, List paramList, b paramb) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "back", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetContactListResp;", "kotlin.jvm.PlatformType", "call"})
  public static final class i<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    public i(a parama, LinkedList paramLinkedList, List paramList, b paramb) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "resultList", "", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
  static final class j
    extends q
    implements b<List<? extends ai>, x>
  {
    j(a parama, String paramString, b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "back", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetContactListResp;", "kotlin.jvm.PlatformType", "call"})
  static final class k<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    k(a parama, LinkedList paramLinkedList, b paramb) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage;", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.storage.z>
  {
    public static final l xeL;
    
    static
    {
      AppMethodBeat.i(288718);
      xeL = new l();
      AppMethodBeat.o(288718);
    }
    
    l()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.fetcher.a
 * JD-Core Version:    0.7.0.1
 */