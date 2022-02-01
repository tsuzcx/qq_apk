package com.tencent.mm.plugin.finder.cgi.fetcher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.ae;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.plugin.i.a.ah;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aps;
import com.tencent.mm.protocal.protobuf.art;
import com.tencent.mm.protocal.protobuf.aru;
import com.tencent.mm.protocal.protobuf.dqi;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderContactFetcher;", "", "()V", "fetchingSet", "Ljava/util/concurrent/ConcurrentHashMap;", "", "strangerContactStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage;", "getStrangerContactStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage;", "strangerContactStorage$delegate", "Lkotlin/Lazy;", "fetchContact", "", "req", "call", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "Lkotlin/ParameterName;", "name", "result", "fetchContact2", "Lcom/tencent/mm/protocal/protobuf/FinderContactMsgInfo;", "fetchContact3", "Lcom/tencent/mm/protocal/protobuf/FinderContactCommentInfo;", "fetchContactList", "reqList", "", "resultList", "fetchContactList2", "fetchContactList3", "Companion", "plugin-finder_release"})
public final class a
{
  public static final a twS;
  public final ConcurrentHashMap<String, Object> twQ;
  private final kotlin.f twR;
  
  static
  {
    AppMethodBeat.i(242584);
    twS = new a((byte)0);
    AppMethodBeat.o(242584);
  }
  
  public a()
  {
    AppMethodBeat.i(242583);
    this.twQ = new ConcurrentHashMap();
    this.twR = g.ah((kotlin.g.a.a)h.twX);
    AppMethodBeat.o(242583);
  }
  
  public final void a(final aps paramaps, final b<? super ah, x> paramb)
  {
    AppMethodBeat.i(242582);
    p.h(paramaps, "req");
    p.h(paramb, "call");
    Object localObject2 = paramaps.LBC;
    Object localObject1 = (Map)this.twQ;
    if (localObject1 == null)
    {
      paramaps = new t("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
      AppMethodBeat.o(242582);
      throw paramaps;
    }
    Object localObject3;
    if (!((Map)localObject1).containsKey(localObject2))
    {
      localObject3 = (Map)this.twQ;
      if (localObject2 != null) {
        break label334;
      }
    }
    label334:
    for (localObject1 = "";; localObject1 = localObject2)
    {
      ((Map)localObject3).put(localObject1, this);
      paramaps = j.listOf(paramaps);
      paramb = (b)new c(this, (String)localObject2, paramb);
      p.h(paramaps, "reqList");
      p.h(paramb, "call");
      localObject1 = new LinkedList();
      localObject2 = ae.tue;
      p.h(paramaps, "usernameList");
      localObject2 = new ae();
      localObject3 = new d.a();
      Object localObject4 = new art();
      am localam = am.tuw;
      ((art)localObject4).LAI = am.cXY();
      ((art)localObject4).LDk = 1;
      ((art)localObject4).LAt = z.aUg();
      ((art)localObject4).LDl.addAll((Collection)paramaps);
      ((d.a)localObject3).c((com.tencent.mm.bw.a)localObject4);
      localObject4 = new aru();
      ((aru)localObject4).setBaseResponse(new BaseResponse());
      ((aru)localObject4).getBaseResponse().ErrMsg = new dqi();
      ((d.a)localObject3).d((com.tencent.mm.bw.a)localObject4);
      ((d.a)localObject3).MB("/cgi-bin/micromsg-bin/findergetcontactlist");
      ((d.a)localObject3).sG(3953);
      ((ae)localObject2).c(((d.a)localObject3).aXF());
      ((ae)localObject2).aYI().j((com.tencent.mm.vending.c.a)new f(this, (LinkedList)localObject1, paramaps, paramb));
      AppMethodBeat.o(242582);
      return;
      Log.w("Finder.ContactFetcher", "fetchContact2[req] is loading. just return");
      AppMethodBeat.o(242582);
      return;
    }
  }
  
  public final void b(final List<String> paramList, final b<? super List<? extends ah>, x> paramb)
  {
    AppMethodBeat.i(242580);
    p.h(paramList, "reqList");
    p.h(paramb, "call");
    final LinkedList localLinkedList = new LinkedList();
    Object localObject1 = ae.tue;
    p.h(paramList, "usernameList");
    localObject1 = new ae();
    d.a locala = new d.a();
    Object localObject2 = new art();
    am localam = am.tuw;
    ((art)localObject2).LAI = am.cXY();
    ((art)localObject2).LDj.addAll((Collection)paramList);
    ((art)localObject2).LDk = 0;
    locala.c((com.tencent.mm.bw.a)localObject2);
    localObject2 = new aru();
    ((aru)localObject2).setBaseResponse(new BaseResponse());
    ((aru)localObject2).getBaseResponse().ErrMsg = new dqi();
    locala.d((com.tencent.mm.bw.a)localObject2);
    locala.MB("/cgi-bin/micromsg-bin/findergetcontactlist");
    locala.sG(3953);
    ((ae)localObject1).c(locala.aXF());
    Log.i("Finder.CgiGetFinderContact", "[CgiGetFinderContact] username=".concat(String.valueOf(paramList)));
    ((ae)localObject1).aYI().j((com.tencent.mm.vending.c.a)new e(this, localLinkedList, paramList, paramb));
    AppMethodBeat.o(242580);
  }
  
  public final void h(final String paramString, final b<? super ah, x> paramb)
  {
    AppMethodBeat.i(242581);
    p.h(paramString, "req");
    p.h(paramb, "call");
    if (!this.twQ.containsKey(paramString))
    {
      ((Map)this.twQ).put(paramString, this);
      b(j.listOf(paramString), (b)new b(this, paramString, paramb));
      AppMethodBeat.o(242581);
      return;
    }
    Log.w("Finder.ContactFetcher", "fetchContact[req] is loading. just return");
    AppMethodBeat.o(242581);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderContactFetcher$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "resultList", "", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
  static final class b
    extends q
    implements b<List<? extends ah>, x>
  {
    b(a parama, String paramString, b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "resultList", "", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
  static final class c
    extends q
    implements b<List<? extends ah>, x>
  {
    c(a parama, String paramString, b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "resultList", "", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
  public static final class d
    extends q
    implements b<List<? extends ah>, x>
  {
    public d(a parama, String paramString, b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "back", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetContactListResp;", "kotlin.jvm.PlatformType", "call"})
  static final class e<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    e(a parama, LinkedList paramLinkedList, List paramList, b paramb) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "back", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetContactListResp;", "kotlin.jvm.PlatformType", "call"})
  static final class f<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    f(a parama, LinkedList paramLinkedList, List paramList, b paramb) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "back", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetContactListResp;", "kotlin.jvm.PlatformType", "call"})
  public static final class g<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    public g(a parama, LinkedList paramLinkedList, List paramList, b paramb) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage;", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<ab>
  {
    public static final h twX;
    
    static
    {
      AppMethodBeat.i(242579);
      twX = new h();
      AppMethodBeat.o(242579);
    }
    
    h()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.fetcher.a
 * JD-Core Version:    0.7.0.1
 */