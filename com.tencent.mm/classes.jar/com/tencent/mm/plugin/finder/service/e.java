package com.tencent.mm.plugin.finder.service;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.ai;
import com.tencent.mm.plugin.finder.cgi.an;
import com.tencent.mm.plugin.finder.cgi.cg;
import com.tencent.mm.plugin.finder.conv.k;
import com.tencent.mm.plugin.finder.storage.ag;
import com.tencent.mm.plugin.finder.storage.ag.b;
import com.tencent.mm.plugin.i.a.aa;
import com.tencent.mm.plugin.i.a.aa.a;
import com.tencent.mm.plugin.i.a.aa.b;
import com.tencent.mm.protocal.protobuf.azi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import java.util.LinkedList;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/service/FinderSessionInfoService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSessionInfoService;", "()V", "sessionInfoStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "getSessionInfoStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "sessionInfoStorage$delegate", "Lkotlin/Lazy;", "getSessionId", "", "context", "Landroid/content/Context;", "scene", "", "username", "", "callable", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSessionInfoService$SessionIdCallback;", "getSessionIdByComment", "sessionId", "objectId", "", "commentId", "getSessionIdByFansId", "fansId", "getSessionIdByLottery", "lotteryId", "getSessionIdFromLocal", "talker", "getSessionIdFromServer", "feedId", "isFromLiveLottery", "", "source", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage$ReplaceSource;", "callback", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "result", "errType", "errCode", "errMsg", "getSessionSender", "getTalkerFromLocal", "isFinderSession", "toUsername", "requestSessionStatus", "reqItems", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderMsgGetSessionReqItem;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSessionInfoService$SessionStatusCallback;", "Companion", "plugin-finder_release"})
public final class e
  implements aa
{
  public static final a vvW;
  private final kotlin.f tyR;
  
  static
  {
    AppMethodBeat.i(251484);
    vvW = new a((byte)0);
    AppMethodBeat.o(251484);
  }
  
  public e()
  {
    AppMethodBeat.i(251483);
    this.tyR = kotlin.g.ah((kotlin.g.a.a)g.vwc);
    AppMethodBeat.o(251483);
  }
  
  private void a(Context paramContext, int paramInt, final String paramString1, final String paramString2, final long paramLong1, long paramLong2, boolean paramBoolean, String paramString3, final ag.b paramb, r<? super String, ? super Integer, ? super Integer, ? super String, x> paramr)
  {
    AppMethodBeat.i(251479);
    p.h(paramContext, "context");
    p.h(paramString1, "username");
    p.h(paramString3, "lotteryId");
    p.h(paramb, "source");
    p.h(paramr, "callback");
    if (paramString2 != null) {
      paramContext = an.a(new ai(paramString2), paramContext);
    }
    for (;;)
    {
      paramContext.aYI().j((com.tencent.mm.vending.c.a)new f(this, paramString1, paramString2, paramLong1, paramLong2, paramb, paramr));
      AppMethodBeat.o(251479);
      return;
      if ((paramLong1 != 0L) && (paramLong2 != 0L)) {
        paramContext = an.a(new ai(paramInt, paramString1, paramLong1, paramLong2), paramContext);
      } else if (paramBoolean) {
        paramContext = an.a(new ai(paramInt, paramString1, paramString3, paramLong1), paramContext);
      } else {
        paramContext = an.a(new ai(paramInt, paramString1), paramContext);
      }
    }
  }
  
  private final ag getSessionInfoStorage()
  {
    AppMethodBeat.i(251471);
    ag localag = (ag)this.tyR.getValue();
    AppMethodBeat.o(251471);
    return localag;
  }
  
  public final void a(Context paramContext, String paramString, aa.a parama)
  {
    AppMethodBeat.i(251472);
    p.h(paramContext, "context");
    p.h(parama, "callable");
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      parama.j("", 0, 0, "");
      Log.e("Finder.SessionInfoService", "[getSessionId] username=" + paramString + " is invalid, just return.");
      AppMethodBeat.o(251472);
      return;
    }
    localObject = avj(paramString);
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (i = 1; i != 0; i = 0)
    {
      a(this, paramContext, 2, paramString, null, 0L, 0L, false, null, null, (r)new b(parama), 504);
      AppMethodBeat.o(251472);
      return;
    }
    parama.j((String)localObject, 0, 0, "");
    AppMethodBeat.o(251472);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, aa.a parama)
  {
    AppMethodBeat.i(251474);
    p.h(paramContext, "context");
    p.h(parama, "callable");
    CharSequence localCharSequence = (CharSequence)paramString2;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      parama.j("", 0, 0, "");
      Log.e("Finder.SessionInfoService", "[getSessionId] fansId=" + paramString2 + " is invalid, just return.");
      AppMethodBeat.o(251474);
      return;
    }
    paramString1 = getSessionInfoStorage().avz(paramString1).field_sessionId;
    localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (i = 1; i != 0; i = 0)
    {
      a(this, paramContext, 1, "", paramString2, 0L, 0L, false, null, null, (r)new d(parama), 496);
      AppMethodBeat.o(251474);
      return;
    }
    parama.j(paramString1, 0, 0, "");
    AppMethodBeat.o(251474);
  }
  
  public final void a(LinkedList<azi> paramLinkedList, aa.b paramb)
  {
    AppMethodBeat.i(251481);
    p.h(paramLinkedList, "reqItems");
    f localf = f.vwe;
    p.h(paramLinkedList, "reqItems");
    f.vwd = paramb;
    com.tencent.mm.kernel.g.azz().a(6218, (i)localf);
    paramLinkedList = new cg(paramLinkedList);
    com.tencent.mm.kernel.g.azz().b((com.tencent.mm.ak.q)paramLinkedList);
    AppMethodBeat.o(251481);
  }
  
  public final String avi(String paramString)
  {
    AppMethodBeat.i(251476);
    paramString = getSessionInfoStorage().avB(paramString);
    AppMethodBeat.o(251476);
    return paramString;
  }
  
  public final String avj(String paramString)
  {
    AppMethodBeat.i(251477);
    paramString = getSessionInfoStorage().avA(paramString);
    AppMethodBeat.o(251477);
    return paramString;
  }
  
  public final String avk(String paramString)
  {
    AppMethodBeat.i(251478);
    if (as.bjt(getSessionInfoStorage().avB(paramString)))
    {
      paramString = z.aTY();
      p.g(paramString, "ConfigStorageLogic.getUsernameFromUserInfo()");
      AppMethodBeat.o(251478);
      return paramString;
    }
    paramString = z.aUg();
    p.g(paramString, "ConfigStorageLogic.getMyFinderUsername()");
    AppMethodBeat.o(251478);
    return paramString;
  }
  
  public final boolean avl(String paramString)
  {
    AppMethodBeat.i(251482);
    if (paramString != null)
    {
      boolean bool = n.K(paramString, "@findermsg", false);
      AppMethodBeat.o(251482);
      return bool;
    }
    AppMethodBeat.o(251482);
    return false;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/service/FinderSessionInfoService$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "sessionIdServer", "", "errType", "", "errCode", "errMsg", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements r<String, Integer, Integer, String, x>
  {
    b(aa.a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "sessionIdServer", "", "errType", "", "errCode", "errMsg", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements r<String, Integer, Integer, String, x>
  {
    c(aa.a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "sessionIdServer", "", "errType", "", "errCode", "errMsg", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements r<String, Integer, Integer, String, x>
  {
    d(aa.a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "sessionIdServer", "", "errType", "", "errCode", "errMsg", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements r<String, Integer, Integer, String, x>
  {
    e(aa.a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetMsgSessionIdResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class f<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    f(e parame, String paramString1, String paramString2, long paramLong1, long paramLong2, ag.b paramb, r paramr) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<ag>
  {
    public static final g vwc;
    
    static
    {
      AppMethodBeat.i(251470);
      vwc = new g();
      AppMethodBeat.o(251470);
    }
    
    g()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.service.e
 * JD-Core Version:    0.7.0.1
 */