package com.tencent.mm.plugin.finder.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.cgi.ba;
import com.tencent.mm.plugin.finder.cgi.t;
import com.tencent.mm.plugin.finder.conv.j;
import com.tencent.mm.plugin.finder.storage.w;
import com.tencent.mm.plugin.finder.storage.w.b;
import com.tencent.mm.plugin.i.a.p.a;
import com.tencent.mm.plugin.i.a.p.b;
import com.tencent.mm.protocal.protobuf.apu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.am;
import d.g.a.r;
import d.l;
import d.z;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/service/FinderSessionInfoService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSessionInfoService;", "()V", "sessionInfoStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "getSessionInfoStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "sessionInfoStorage$delegate", "Lkotlin/Lazy;", "getSessionId", "", "scene", "", "username", "", "callable", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSessionInfoService$SessionIdCallback;", "getSessionIdByComment", "sessionId", "objectId", "", "commentId", "getSessionIdByFansId", "fansId", "getSessionIdFromLocal", "talker", "getSessionIdFromServer", "feedId", "source", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage$ReplaceSource;", "callback", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "result", "errType", "errCode", "errMsg", "getSessionSender", "getTalkerFromLocal", "isFinderSession", "", "toUsername", "requestSessionStatus", "reqItems", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderMsgGetSessionReqItem;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSessionInfoService$SessionStatusCallback;", "Companion", "plugin-finder_release"})
public final class d
  implements com.tencent.mm.plugin.i.a.p
{
  public static final a suo;
  private final d.f rLJ;
  
  static
  {
    AppMethodBeat.i(203541);
    suo = new a((byte)0);
    AppMethodBeat.o(203541);
  }
  
  public d()
  {
    AppMethodBeat.i(203540);
    this.rLJ = d.g.O((d.g.a.a)f.suu);
    AppMethodBeat.o(203540);
  }
  
  private void a(int paramInt, final String paramString1, final String paramString2, final long paramLong1, long paramLong2, final w.b paramb, r<? super String, ? super Integer, ? super Integer, ? super String, z> paramr)
  {
    AppMethodBeat.i(203536);
    d.g.b.p.h(paramString1, "username");
    d.g.b.p.h(paramb, "source");
    d.g.b.p.h(paramr, "callback");
    t localt;
    if (paramString2 != null) {
      localt = new t(paramString2);
    }
    for (;;)
    {
      localt.aED().j((com.tencent.mm.vending.c.a)new e(this, paramString1, paramString2, paramLong1, paramLong2, paramb, paramr));
      AppMethodBeat.o(203536);
      return;
      if ((paramLong1 != 0L) && (paramLong2 != 0L)) {
        localt = new t(paramInt, paramString1, paramLong1, paramLong2);
      } else {
        localt = new t(paramInt, paramString1);
      }
    }
  }
  
  private final w getSessionInfoStorage()
  {
    AppMethodBeat.i(203529);
    w localw = (w)this.rLJ.getValue();
    AppMethodBeat.o(203529);
    return localw;
  }
  
  public final void a(String paramString, p.a parama)
  {
    AppMethodBeat.i(203530);
    d.g.b.p.h(parama, "callable");
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      parama.j("", 0, 0, "");
      ad.e("Finder.SessionInfoService", "[getSessionId] username=" + paramString + " is invalid, just return.");
      AppMethodBeat.o(203530);
      return;
    }
    localObject = aij(paramString);
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (i = 1; i != 0; i = 0)
    {
      a(this, 2, paramString, null, 0L, 0L, null, (r)new b(parama), 60);
      AppMethodBeat.o(203530);
      return;
    }
    parama.j((String)localObject, 0, 0, "");
    AppMethodBeat.o(203530);
  }
  
  public final void a(String paramString1, String paramString2, p.a parama)
  {
    AppMethodBeat.i(203532);
    d.g.b.p.h(parama, "callable");
    CharSequence localCharSequence = (CharSequence)paramString2;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      parama.j("", 0, 0, "");
      ad.e("Finder.SessionInfoService", "[getSessionId] fansId=" + paramString2 + " is invalid, just return.");
      AppMethodBeat.o(203532);
      return;
    }
    paramString1 = getSessionInfoStorage().aiw(paramString1).field_sessionId;
    localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (i = 1; i != 0; i = 0)
    {
      a(this, 1, "", paramString2, 0L, 0L, null, (r)new d(parama), 56);
      AppMethodBeat.o(203532);
      return;
    }
    parama.j(paramString1, 0, 0, "");
    AppMethodBeat.o(203532);
  }
  
  public final void a(LinkedList<apu> paramLinkedList, p.b paramb)
  {
    AppMethodBeat.i(203538);
    d.g.b.p.h(paramLinkedList, "reqItems");
    e locale = e.suw;
    d.g.b.p.h(paramLinkedList, "reqItems");
    e.suv = paramb;
    com.tencent.mm.kernel.g.aiU().a(6218, (com.tencent.mm.al.f)locale);
    paramLinkedList = new ba(paramLinkedList);
    com.tencent.mm.kernel.g.aiU().b((com.tencent.mm.al.n)paramLinkedList);
    AppMethodBeat.o(203538);
  }
  
  public final String aii(String paramString)
  {
    AppMethodBeat.i(203533);
    paramString = getSessionInfoStorage().aiy(paramString);
    AppMethodBeat.o(203533);
    return paramString;
  }
  
  public final String aij(String paramString)
  {
    AppMethodBeat.i(203534);
    paramString = getSessionInfoStorage().aix(paramString);
    AppMethodBeat.o(203534);
    return paramString;
  }
  
  public final String aik(String paramString)
  {
    AppMethodBeat.i(203535);
    if (am.aSU(getSessionInfoStorage().aiy(paramString)))
    {
      paramString = u.aAm();
      d.g.b.p.g(paramString, "ConfigStorageLogic.getUsernameFromUserInfo()");
      AppMethodBeat.o(203535);
      return paramString;
    }
    paramString = u.aAu();
    d.g.b.p.g(paramString, "ConfigStorageLogic.getMyFinderUsername()");
    AppMethodBeat.o(203535);
    return paramString;
  }
  
  public final boolean ail(String paramString)
  {
    AppMethodBeat.i(203539);
    if (paramString != null)
    {
      boolean bool = d.n.n.nA(paramString, "@findermsg");
      AppMethodBeat.o(203539);
      return bool;
    }
    AppMethodBeat.o(203539);
    return false;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/service/FinderSessionInfoService$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "sessionIdServer", "", "errType", "", "errCode", "errMsg", "invoke"})
  static final class b
    extends d.g.b.q
    implements r<String, Integer, Integer, String, z>
  {
    b(p.a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "sessionIdServer", "", "errType", "", "errCode", "errMsg", "invoke"})
  static final class c
    extends d.g.b.q
    implements r<String, Integer, Integer, String, z>
  {
    c(p.a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "sessionIdServer", "", "errType", "", "errCode", "errMsg", "invoke"})
  static final class d
    extends d.g.b.q
    implements r<String, Integer, Integer, String, z>
  {
    d(p.a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetMsgSessionIdResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class e<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    e(d paramd, String paramString1, String paramString2, long paramLong1, long paramLong2, w.b paramb, r paramr) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "invoke"})
  static final class f
    extends d.g.b.q
    implements d.g.a.a<w>
  {
    public static final f suu;
    
    static
    {
      AppMethodBeat.i(203528);
      suu = new f();
      AppMethodBeat.o(203528);
    }
    
    f()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.service.d
 * JD-Core Version:    0.7.0.1
 */