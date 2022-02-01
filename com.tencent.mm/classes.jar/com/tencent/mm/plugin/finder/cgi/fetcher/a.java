package com.tencent.mm.plugin.finder.cgi.fetcher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.plugin.i.a.r;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anv;
import com.tencent.mm.protocal.protobuf.anw;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.ae;
import d.a.j;
import d.g;
import d.g.a.b;
import d.g.b.q;
import d.l;
import d.z;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderContactFetcher;", "", "()V", "fetchingSet", "Ljava/util/concurrent/ConcurrentHashMap;", "", "strangerContactStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage;", "getStrangerContactStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage;", "strangerContactStorage$delegate", "Lkotlin/Lazy;", "fetchContact", "", "req", "call", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "Lkotlin/ParameterName;", "name", "result", "fetchContact2", "Lcom/tencent/mm/protocal/protobuf/FinderContactMsgInfo;", "fetchContact3", "Lcom/tencent/mm/protocal/protobuf/FinderContactCommentInfo;", "fetchContactList", "reqList", "", "resultList", "fetchContactList2", "fetchContactList3", "Companion", "plugin-finder_release"})
public final class a
{
  public static final a rSC;
  public final ConcurrentHashMap<String, Object> rSA;
  private final d.f rSB;
  
  static
  {
    AppMethodBeat.i(201611);
    rSC = new a((byte)0);
    AppMethodBeat.o(201611);
  }
  
  public a()
  {
    AppMethodBeat.i(201610);
    this.rSA = new ConcurrentHashMap();
    this.rSB = g.O((d.g.a.a)h.rSG);
    AppMethodBeat.o(201610);
  }
  
  public final void a(final aml paramaml, final b<? super r, z> paramb)
  {
    AppMethodBeat.i(201609);
    d.g.b.p.h(paramaml, "req");
    d.g.b.p.h(paramb, "call");
    Object localObject2 = paramaml.GEI;
    Object localObject1 = (Map)this.rSA;
    if (localObject1 == null)
    {
      paramaml = new d.v("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
      AppMethodBeat.o(201609);
      throw paramaml;
    }
    Object localObject3;
    if (!((Map)localObject1).containsKey(localObject2))
    {
      localObject3 = (Map)this.rSA;
      if (localObject2 != null) {
        break label334;
      }
    }
    label334:
    for (localObject1 = "";; localObject1 = localObject2)
    {
      ((Map)localObject3).put(localObject1, this);
      paramaml = j.listOf(paramaml);
      paramb = (b)new c(this, (String)localObject2, paramb);
      d.g.b.p.h(paramaml, "reqList");
      d.g.b.p.h(paramb, "call");
      localObject1 = new LinkedList();
      localObject2 = com.tencent.mm.plugin.finder.cgi.p.rQM;
      d.g.b.p.h(paramaml, "usernameList");
      localObject2 = new com.tencent.mm.plugin.finder.cgi.p();
      localObject3 = new b.a();
      Object localObject4 = new anv();
      com.tencent.mm.plugin.finder.cgi.v localv = com.tencent.mm.plugin.finder.cgi.v.rRb;
      ((anv)localObject4).GEg = com.tencent.mm.plugin.finder.cgi.v.czz();
      ((anv)localObject4).GFG = 1;
      ((anv)localObject4).GDP = com.tencent.mm.model.v.aAK();
      ((anv)localObject4).GFH.addAll((Collection)paramaml);
      ((b.a)localObject3).c((com.tencent.mm.bw.a)localObject4);
      localObject4 = new anw();
      ((anw)localObject4).setBaseResponse(new BaseResponse());
      ((anw)localObject4).getBaseResponse().ErrMsg = new cxn();
      ((b.a)localObject3).d((com.tencent.mm.bw.a)localObject4);
      ((b.a)localObject3).DN("/cgi-bin/micromsg-bin/findergetcontactlist");
      ((b.a)localObject3).oS(3953);
      ((com.tencent.mm.plugin.finder.cgi.p)localObject2).c(((b.a)localObject3).aDS());
      ((com.tencent.mm.plugin.finder.cgi.p)localObject2).aET().j((com.tencent.mm.vending.c.a)new f(this, (LinkedList)localObject1, paramaml, paramb));
      AppMethodBeat.o(201609);
      return;
      ae.w("Finder.ContactFetcher", "fetchContact2[req] is loading. just return");
      AppMethodBeat.o(201609);
      return;
    }
  }
  
  public final void b(final List<String> paramList, final b<? super List<? extends r>, z> paramb)
  {
    AppMethodBeat.i(201607);
    d.g.b.p.h(paramList, "reqList");
    d.g.b.p.h(paramb, "call");
    final LinkedList localLinkedList = new LinkedList();
    Object localObject1 = com.tencent.mm.plugin.finder.cgi.p.rQM;
    d.g.b.p.h(paramList, "usernameList");
    localObject1 = new com.tencent.mm.plugin.finder.cgi.p();
    b.a locala = new b.a();
    Object localObject2 = new anv();
    com.tencent.mm.plugin.finder.cgi.v localv = com.tencent.mm.plugin.finder.cgi.v.rRb;
    ((anv)localObject2).GEg = com.tencent.mm.plugin.finder.cgi.v.czz();
    ((anv)localObject2).GFF.addAll((Collection)paramList);
    ((anv)localObject2).GFG = 0;
    locala.c((com.tencent.mm.bw.a)localObject2);
    localObject2 = new anw();
    ((anw)localObject2).setBaseResponse(new BaseResponse());
    ((anw)localObject2).getBaseResponse().ErrMsg = new cxn();
    locala.d((com.tencent.mm.bw.a)localObject2);
    locala.DN("/cgi-bin/micromsg-bin/findergetcontactlist");
    locala.oS(3953);
    ((com.tencent.mm.plugin.finder.cgi.p)localObject1).c(locala.aDS());
    ae.i("Finder.CgiGetFinderContact", "[CgiGetFinderContact] username=".concat(String.valueOf(paramList)));
    ((com.tencent.mm.plugin.finder.cgi.p)localObject1).aET().j((com.tencent.mm.vending.c.a)new e(this, localLinkedList, paramList, paramb));
    AppMethodBeat.o(201607);
  }
  
  public final void g(final String paramString, final b<? super r, z> paramb)
  {
    AppMethodBeat.i(201608);
    d.g.b.p.h(paramString, "req");
    d.g.b.p.h(paramb, "call");
    if (!this.rSA.containsKey(paramString))
    {
      ((Map)this.rSA).put(paramString, this);
      b(j.listOf(paramString), (b)new b(this, paramString, paramb));
      AppMethodBeat.o(201608);
      return;
    }
    ae.w("Finder.ContactFetcher", "fetchContact[req] is loading. just return");
    AppMethodBeat.o(201608);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderContactFetcher$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "resultList", "", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
  static final class b
    extends q
    implements b<List<? extends r>, z>
  {
    b(a parama, String paramString, b paramb)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "resultList", "", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
  static final class c
    extends q
    implements b<List<? extends r>, z>
  {
    c(a parama, String paramString, b paramb)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "resultList", "", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
  public static final class d
    extends q
    implements b<List<? extends r>, z>
  {
    public d(a parama, String paramString, b paramb)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "back", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetContactListResp;", "kotlin.jvm.PlatformType", "call"})
  static final class e<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    e(a parama, LinkedList paramLinkedList, List paramList, b paramb) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "back", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetContactListResp;", "kotlin.jvm.PlatformType", "call"})
  static final class f<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    f(a parama, LinkedList paramLinkedList, List paramList, b paramb) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "back", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetContactListResp;", "kotlin.jvm.PlatformType", "call"})
  public static final class g<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    public g(a parama, LinkedList paramLinkedList, List paramList, b paramb) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage;", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<com.tencent.mm.plugin.finder.storage.v>
  {
    public static final h rSG;
    
    static
    {
      AppMethodBeat.i(201606);
      rSG = new h();
      AppMethodBeat.o(201606);
    }
    
    h()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.fetcher.a
 * JD-Core Version:    0.7.0.1
 */