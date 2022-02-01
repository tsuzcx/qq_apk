package com.tencent.mm.plugin.finder.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.finder.cgi.bb;
import com.tencent.mm.plugin.finder.cgi.t;
import com.tencent.mm.plugin.finder.conv.j;
import com.tencent.mm.plugin.finder.storage.w;
import com.tencent.mm.plugin.finder.storage.w.b;
import com.tencent.mm.plugin.i.a.p.a;
import com.tencent.mm.plugin.i.a.p.b;
import com.tencent.mm.protocal.protobuf.aqh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.an;
import d.g.a.r;
import d.l;
import d.z;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/service/FinderSessionInfoService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSessionInfoService;", "()V", "sessionInfoStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "getSessionInfoStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "sessionInfoStorage$delegate", "Lkotlin/Lazy;", "getSessionId", "", "scene", "", "username", "", "callable", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSessionInfoService$SessionIdCallback;", "getSessionIdByComment", "sessionId", "objectId", "", "commentId", "getSessionIdByFansId", "fansId", "getSessionIdFromLocal", "talker", "getSessionIdFromServer", "feedId", "source", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage$ReplaceSource;", "callback", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "result", "errType", "errCode", "errMsg", "getSessionSender", "getTalkerFromLocal", "isFinderSession", "", "toUsername", "requestSessionStatus", "reqItems", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderMsgGetSessionReqItem;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSessionInfoService$SessionStatusCallback;", "Companion", "plugin-finder_release"})
public final class d
  implements com.tencent.mm.plugin.i.a.p
{
  public static final a sEy;
  private final d.f rTW;
  
  static
  {
    AppMethodBeat.i(204101);
    sEy = new a((byte)0);
    AppMethodBeat.o(204101);
  }
  
  public d()
  {
    AppMethodBeat.i(204100);
    this.rTW = d.g.O((d.g.a.a)f.sEE);
    AppMethodBeat.o(204100);
  }
  
  private void a(int paramInt, final String paramString1, final String paramString2, final long paramLong1, long paramLong2, final w.b paramb, r<? super String, ? super Integer, ? super Integer, ? super String, z> paramr)
  {
    AppMethodBeat.i(204096);
    d.g.b.p.h(paramString1, "username");
    d.g.b.p.h(paramb, "source");
    d.g.b.p.h(paramr, "callback");
    t localt;
    if (paramString2 != null) {
      localt = new t(paramString2);
    }
    for (;;)
    {
      localt.aET().j((com.tencent.mm.vending.c.a)new e(this, paramString1, paramString2, paramLong1, paramLong2, paramb, paramr));
      AppMethodBeat.o(204096);
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
    AppMethodBeat.i(204089);
    w localw = (w)this.rTW.getValue();
    AppMethodBeat.o(204089);
    return localw;
  }
  
  public final void a(String paramString, p.a parama)
  {
    AppMethodBeat.i(204090);
    d.g.b.p.h(parama, "callable");
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      parama.j("", 0, 0, "");
      ae.e("Finder.SessionInfoService", "[getSessionId] username=" + paramString + " is invalid, just return.");
      AppMethodBeat.o(204090);
      return;
    }
    localObject = ajg(paramString);
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (i = 1; i != 0; i = 0)
    {
      a(this, 2, paramString, null, 0L, 0L, null, (r)new b(parama), 60);
      AppMethodBeat.o(204090);
      return;
    }
    parama.j((String)localObject, 0, 0, "");
    AppMethodBeat.o(204090);
  }
  
  public final void a(String paramString1, String paramString2, p.a parama)
  {
    AppMethodBeat.i(204092);
    d.g.b.p.h(parama, "callable");
    CharSequence localCharSequence = (CharSequence)paramString2;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      parama.j("", 0, 0, "");
      ae.e("Finder.SessionInfoService", "[getSessionId] fansId=" + paramString2 + " is invalid, just return.");
      AppMethodBeat.o(204092);
      return;
    }
    paramString1 = getSessionInfoStorage().ajt(paramString1).field_sessionId;
    localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (i = 1; i != 0; i = 0)
    {
      a(this, 1, "", paramString2, 0L, 0L, null, (r)new d(parama), 56);
      AppMethodBeat.o(204092);
      return;
    }
    parama.j(paramString1, 0, 0, "");
    AppMethodBeat.o(204092);
  }
  
  public final void a(LinkedList<aqh> paramLinkedList, p.b paramb)
  {
    AppMethodBeat.i(204098);
    d.g.b.p.h(paramLinkedList, "reqItems");
    e locale = e.sEG;
    d.g.b.p.h(paramLinkedList, "reqItems");
    e.sEF = paramb;
    com.tencent.mm.kernel.g.ajj().a(6218, (com.tencent.mm.ak.f)locale);
    paramLinkedList = new bb(paramLinkedList);
    com.tencent.mm.kernel.g.ajj().b((com.tencent.mm.ak.n)paramLinkedList);
    AppMethodBeat.o(204098);
  }
  
  public final String ajf(String paramString)
  {
    AppMethodBeat.i(204093);
    paramString = getSessionInfoStorage().ajv(paramString);
    AppMethodBeat.o(204093);
    return paramString;
  }
  
  public final String ajg(String paramString)
  {
    AppMethodBeat.i(204094);
    paramString = getSessionInfoStorage().aju(paramString);
    AppMethodBeat.o(204094);
    return paramString;
  }
  
  public final String ajh(String paramString)
  {
    AppMethodBeat.i(204095);
    if (an.aUu(getSessionInfoStorage().ajv(paramString)))
    {
      paramString = v.aAC();
      d.g.b.p.g(paramString, "ConfigStorageLogic.getUsernameFromUserInfo()");
      AppMethodBeat.o(204095);
      return paramString;
    }
    paramString = v.aAK();
    d.g.b.p.g(paramString, "ConfigStorageLogic.getMyFinderUsername()");
    AppMethodBeat.o(204095);
    return paramString;
  }
  
  public final boolean aji(String paramString)
  {
    AppMethodBeat.i(204099);
    if (paramString != null)
    {
      boolean bool = d.n.n.nG(paramString, "@findermsg");
      AppMethodBeat.o(204099);
      return bool;
    }
    AppMethodBeat.o(204099);
    return false;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/service/FinderSessionInfoService$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "sessionIdServer", "", "errType", "", "errCode", "errMsg", "invoke"})
  static final class b
    extends d.g.b.q
    implements r<String, Integer, Integer, String, z>
  {
    b(p.a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "sessionIdServer", "", "errType", "", "errCode", "errMsg", "invoke"})
  static final class c
    extends d.g.b.q
    implements r<String, Integer, Integer, String, z>
  {
    c(p.a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "sessionIdServer", "", "errType", "", "errCode", "errMsg", "invoke"})
  static final class d
    extends d.g.b.q
    implements r<String, Integer, Integer, String, z>
  {
    d(p.a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetMsgSessionIdResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class e<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    e(d paramd, String paramString1, String paramString2, long paramLong1, long paramLong2, w.b paramb, r paramr) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "invoke"})
  static final class f
    extends d.g.b.q
    implements d.g.a.a<w>
  {
    public static final f sEE;
    
    static
    {
      AppMethodBeat.i(204088);
      sEE = new f();
      AppMethodBeat.o(204088);
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