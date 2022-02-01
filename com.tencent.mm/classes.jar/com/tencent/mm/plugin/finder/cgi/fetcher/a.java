package com.tencent.mm.plugin.finder.cgi.fetcher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.i.a.r;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.alz;
import com.tencent.mm.protocal.protobuf.ani;
import com.tencent.mm.protocal.protobuf.anj;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.ad;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderContactFetcher;", "", "()V", "fetchingSet", "Ljava/util/concurrent/ConcurrentHashMap;", "", "strangerContactStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage;", "getStrangerContactStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage;", "strangerContactStorage$delegate", "Lkotlin/Lazy;", "fetchContact", "", "req", "call", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "Lkotlin/ParameterName;", "name", "result", "fetchContact2", "Lcom/tencent/mm/protocal/protobuf/FinderContactMsgInfo;", "fetchContact3", "Lcom/tencent/mm/protocal/protobuf/FinderContactCommentInfo;", "fetchContactList", "reqList", "", "resultList", "fetchContactList2", "fetchContactList3", "Companion", "plugin-finder_release"})
public final class a
{
  public static final a rKq;
  public final ConcurrentHashMap<String, Object> rKo;
  private final d.f rKp;
  
  static
  {
    AppMethodBeat.i(201187);
    rKq = new a((byte)0);
    AppMethodBeat.o(201187);
  }
  
  public a()
  {
    AppMethodBeat.i(201186);
    this.rKo = new ConcurrentHashMap();
    this.rKp = g.O((d.g.a.a)h.rKu);
    AppMethodBeat.o(201186);
  }
  
  public final void a(final alz paramalz, final b<? super r, z> paramb)
  {
    AppMethodBeat.i(221448);
    d.g.b.p.h(paramalz, "req");
    d.g.b.p.h(paramb, "call");
    Object localObject1 = paramalz.GlG;
    if (!this.rKo.containsKey(localObject1))
    {
      Object localObject2 = (Map)this.rKo;
      d.g.b.p.g(localObject1, "username");
      ((Map)localObject2).put(localObject1, this);
      paramalz = j.listOf(paramalz);
      paramb = (b)new c(this, (String)localObject1, paramb);
      d.g.b.p.h(paramalz, "reqList");
      d.g.b.p.h(paramb, "call");
      localObject1 = new LinkedList();
      localObject2 = com.tencent.mm.plugin.finder.cgi.p.rIC;
      d.g.b.p.h(paramalz, "usernameList");
      localObject2 = new com.tencent.mm.plugin.finder.cgi.p();
      b.a locala = new b.a();
      Object localObject3 = new ani();
      com.tencent.mm.plugin.finder.cgi.v localv = com.tencent.mm.plugin.finder.cgi.v.rIR;
      ((ani)localObject3).Gle = com.tencent.mm.plugin.finder.cgi.v.cxY();
      ((ani)localObject3).Gmy = 1;
      ((ani)localObject3).Gmz = u.aAu();
      ((ani)localObject3).GmA.addAll((Collection)paramalz);
      locala.c((com.tencent.mm.bx.a)localObject3);
      localObject3 = new anj();
      ((anj)localObject3).setBaseResponse(new BaseResponse());
      ((anj)localObject3).getBaseResponse().ErrMsg = new cwt();
      locala.d((com.tencent.mm.bx.a)localObject3);
      locala.Dl("/cgi-bin/micromsg-bin/findergetcontactlist");
      locala.oP(3953);
      ((com.tencent.mm.plugin.finder.cgi.p)localObject2).c(locala.aDC());
      ((com.tencent.mm.plugin.finder.cgi.p)localObject2).aED().j((com.tencent.mm.vending.c.a)new f(this, (LinkedList)localObject1, paramalz, paramb));
      AppMethodBeat.o(221448);
      return;
    }
    ad.w("Finder.ContactFetcher", "fetchContact2[req] is loading. just return");
    AppMethodBeat.o(221448);
  }
  
  public final void a(final List<String> paramList, final b<? super List<? extends r>, z> paramb)
  {
    AppMethodBeat.i(201185);
    d.g.b.p.h(paramList, "reqList");
    d.g.b.p.h(paramb, "call");
    final LinkedList localLinkedList = new LinkedList();
    Object localObject1 = com.tencent.mm.plugin.finder.cgi.p.rIC;
    d.g.b.p.h(paramList, "usernameList");
    localObject1 = new com.tencent.mm.plugin.finder.cgi.p();
    b.a locala = new b.a();
    Object localObject2 = new ani();
    com.tencent.mm.plugin.finder.cgi.v localv = com.tencent.mm.plugin.finder.cgi.v.rIR;
    ((ani)localObject2).Gle = com.tencent.mm.plugin.finder.cgi.v.cxY();
    ((ani)localObject2).Gmx.addAll((Collection)paramList);
    ((ani)localObject2).Gmy = 0;
    locala.c((com.tencent.mm.bx.a)localObject2);
    localObject2 = new anj();
    ((anj)localObject2).setBaseResponse(new BaseResponse());
    ((anj)localObject2).getBaseResponse().ErrMsg = new cwt();
    locala.d((com.tencent.mm.bx.a)localObject2);
    locala.Dl("/cgi-bin/micromsg-bin/findergetcontactlist");
    locala.oP(3953);
    ((com.tencent.mm.plugin.finder.cgi.p)localObject1).c(locala.aDC());
    ad.i("Finder.CgiGetFinderContact", "[CgiGetFinderContact] username=".concat(String.valueOf(paramList)));
    ((com.tencent.mm.plugin.finder.cgi.p)localObject1).aED().j((com.tencent.mm.vending.c.a)new e(this, localLinkedList, paramList, paramb));
    AppMethodBeat.o(201185);
  }
  
  public final void j(final String paramString, final b<? super r, z> paramb)
  {
    AppMethodBeat.i(221447);
    d.g.b.p.h(paramString, "req");
    d.g.b.p.h(paramb, "call");
    if (!this.rKo.containsKey(paramString))
    {
      ((Map)this.rKo).put(paramString, this);
      a(j.listOf(paramString), (b)new b(this, paramString, paramb));
      AppMethodBeat.o(221447);
      return;
    }
    ad.w("Finder.ContactFetcher", "fetchContact[req] is loading. just return");
    AppMethodBeat.o(221447);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderContactFetcher$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "resultList", "", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
  static final class b
    extends q
    implements b<List<? extends r>, z>
  {
    b(a parama, String paramString, b paramb)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "resultList", "", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
  static final class c
    extends q
    implements b<List<? extends r>, z>
  {
    c(a parama, String paramString, b paramb)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "resultList", "", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
  public static final class d
    extends q
    implements b<List<? extends r>, z>
  {
    public d(a parama, String paramString, b paramb)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "back", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetContactListResp;", "kotlin.jvm.PlatformType", "call"})
  static final class e<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    e(a parama, LinkedList paramLinkedList, List paramList, b paramb) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "back", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetContactListResp;", "kotlin.jvm.PlatformType", "call"})
  static final class f<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    f(a parama, LinkedList paramLinkedList, List paramList, b paramb) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "back", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetContactListResp;", "kotlin.jvm.PlatformType", "call"})
  public static final class g<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    public g(a parama, LinkedList paramLinkedList, List paramList, b paramb) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage;", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<com.tencent.mm.plugin.finder.storage.v>
  {
    public static final h rKu;
    
    static
    {
      AppMethodBeat.i(201184);
      rKu = new h();
      AppMethodBeat.o(201184);
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