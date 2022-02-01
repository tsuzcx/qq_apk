package com.tencent.mm.plugin.finder.service;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.cgi.ai;
import com.tencent.mm.plugin.finder.cgi.ck;
import com.tencent.mm.plugin.finder.storage.af;
import com.tencent.mm.plugin.finder.storage.af.b;
import com.tencent.mm.plugin.findersdk.a.ab;
import com.tencent.mm.plugin.findersdk.a.ab.a;
import com.tencent.mm.plugin.findersdk.a.ab.b;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bfe;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/service/FinderSessionInfoService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSessionInfoService;", "()V", "sessionInfoStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "getSessionInfoStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "sessionInfoStorage$delegate", "Lkotlin/Lazy;", "getSessionId", "", "context", "Landroid/content/Context;", "scene", "", "username", "", "roleType", "callable", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSessionInfoService$SessionIdCallback;", "getSessionIdByComment", "sessionId", "objectId", "", "commentId", "getSessionIdByFansId", "fansId", "getSessionIdByLottery", "lotteryId", "sourceType", "getSessionIdFromLive", "getSessionIdFromLocal", "talker", "getSessionIdFromServer", "feedId", "isFromLiveLottery", "", "source", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage$ReplaceSource;", "callback", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "result", "errType", "errCode", "errMsg", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;JJZLjava/lang/String;Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage$ReplaceSource;Ljava/lang/Integer;Lkotlin/jvm/functions/Function4;)V", "getSessionSender", "getTalkerFromLocal", "isFinderSession", "toUsername", "requestSessionStatus", "reqItems", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderMsgGetSessionReqItem;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSessionInfoService$SessionStatusCallback;", "Companion", "plugin-finder_release"})
public final class f
  implements ab
{
  public static final a Adw;
  private final kotlin.f xgB;
  
  static
  {
    AppMethodBeat.i(283793);
    Adw = new a((byte)0);
    AppMethodBeat.o(283793);
  }
  
  public f()
  {
    AppMethodBeat.i(283792);
    this.xgB = kotlin.g.ar((kotlin.g.a.a)i.AdD);
    AppMethodBeat.o(283792);
  }
  
  private void a(Context paramContext, final int paramInt, final String paramString1, final String paramString2, final long paramLong1, long paramLong2, boolean paramBoolean, String paramString3, final af.b paramb, Integer paramInteger, r<? super String, ? super Integer, ? super Integer, ? super String, x> paramr)
  {
    AppMethodBeat.i(283788);
    p.k(paramContext, "context");
    p.k(paramString1, "username");
    p.k(paramString3, "lotteryId");
    p.k(paramb, "source");
    p.k(paramr, "callback");
    if (paramString2 != null) {
      paramString3 = c.a(new ai(paramString2), paramContext);
    }
    for (;;)
    {
      paramString3.bhW().j((com.tencent.mm.vending.c.a)new g(this, paramInt, paramString1, paramString2, paramLong1, paramLong2, paramb, paramr)).a((com.tencent.mm.vending.e.b)paramContext);
      AppMethodBeat.o(283788);
      return;
      if ((paramLong1 != 0L) && (paramLong2 != 0L)) {
        paramString3 = c.a(new ai(paramInt, paramString1, paramLong1, paramLong2), paramContext);
      } else if (paramBoolean) {
        paramString3 = c.a(new ai(paramInt, paramString1, paramString3, paramLong1, paramInteger), paramContext);
      } else {
        paramString3 = c.a(new ai(paramInt, paramString1), paramContext);
      }
    }
  }
  
  private final af getSessionInfoStorage()
  {
    AppMethodBeat.i(283774);
    af localaf = (af)this.xgB.getValue();
    AppMethodBeat.o(283774);
    return localaf;
  }
  
  public final void a(Context paramContext, int paramInt1, String paramString, int paramInt2, ab.a parama)
  {
    AppMethodBeat.i(283775);
    p.k(paramContext, "context");
    p.k(parama, "callable");
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      parama.l("", 0, 0, "");
      Log.e("Finder.SessionInfoService", "[getSessionId] username=" + paramString + " is invalid, just return.");
      AppMethodBeat.o(283775);
      return;
    }
    localObject = dX(paramString, paramInt2);
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (paramInt2 = 1; paramInt2 != 0; paramInt2 = 0)
    {
      a(this, paramContext, paramInt1, paramString, null, 0L, 0L, false, null, null, null, (r)new b(parama), 1016);
      AppMethodBeat.o(283775);
      return;
    }
    parama.l((String)localObject, 0, 0, "");
    AppMethodBeat.o(283775);
  }
  
  public final void a(Context paramContext, String paramString, ab.a parama)
  {
    AppMethodBeat.i(283780);
    p.k(paramContext, "context");
    p.k(parama, "callable");
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      parama.l("", 0, 0, "");
      Log.e("Finder.SessionInfoService", "[getSessionId] username=" + paramString + " is invalid, just return.");
      AppMethodBeat.o(283780);
      return;
    }
    a(this, paramContext, 1, paramString, null, 0L, 0L, false, null, null, null, (r)new f(parama), 1016);
    AppMethodBeat.o(283780);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, ab.a parama)
  {
    AppMethodBeat.i(283777);
    p.k(paramContext, "context");
    p.k(parama, "callable");
    CharSequence localCharSequence = (CharSequence)paramString2;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      parama.l("", 0, 0, "");
      Log.e("Finder.SessionInfoService", "[getSessionId] fansId=" + paramString2 + " is invalid, just return.");
      AppMethodBeat.o(283777);
      return;
    }
    paramString1 = getSessionInfoStorage().aEN(paramString1).field_sessionId;
    localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (i = 1; i != 0; i = 0)
    {
      a(this, paramContext, 1, "", paramString2, 0L, 0L, false, null, null, null, (r)new d(parama), 1008);
      AppMethodBeat.o(283777);
      return;
    }
    parama.l(paramString1, 0, 0, "");
    AppMethodBeat.o(283777);
  }
  
  public final void a(LinkedList<bfe> paramLinkedList, ab.b paramb)
  {
    AppMethodBeat.i(283790);
    p.k(paramLinkedList, "reqItems");
    g localg = g.AdF;
    p.k(paramLinkedList, "reqItems");
    g.AdE = paramb;
    h.aGY().a(6218, (i)localg);
    paramLinkedList = new ck(paramLinkedList);
    h.aGY().b((com.tencent.mm.an.q)paramLinkedList);
    AppMethodBeat.o(283790);
  }
  
  public final String aED(String paramString)
  {
    AppMethodBeat.i(283782);
    String str = getSessionInfoStorage().aEN(paramString).field_talker;
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    AppMethodBeat.o(283782);
    return paramString;
  }
  
  public final String aEE(String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(283786);
    paramString = getSessionInfoStorage().aEN(paramString);
    Object localObject = com.tencent.mm.plugin.findersdk.b.BuZ;
    String str = paramString.field_senderUserName;
    int i;
    if (str != null) {
      if (((CharSequence)str).length() > 0)
      {
        i = 1;
        if (i != 1) {
          break label101;
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.ae.f.a.a((com.tencent.mm.ae.f)localObject, "getSessionSender", bool, false, (kotlin.g.a.a)h.AdC, 12);
      localObject = paramString.field_senderUserName;
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = "";
      }
      AppMethodBeat.o(283786);
      return paramString;
      i = 0;
      break;
      label101:
      bool = false;
    }
  }
  
  public final boolean aEF(String paramString)
  {
    AppMethodBeat.i(283791);
    if (paramString != null)
    {
      boolean bool = n.pu(paramString, "@findermsg");
      AppMethodBeat.o(283791);
      return bool;
    }
    AppMethodBeat.o(283791);
    return false;
  }
  
  public final String dX(String paramString, int paramInt)
  {
    AppMethodBeat.i(283784);
    paramString = getSessionInfoStorage().dZ(paramString, paramInt);
    AppMethodBeat.o(283784);
    return paramString;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/service/FinderSessionInfoService$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "sessionIdServer", "", "errType", "", "errCode", "errMsg", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements r<String, Integer, Integer, String, x>
  {
    b(ab.a parama)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "sessionIdServer", "", "errType", "", "errCode", "errMsg", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements r<String, Integer, Integer, String, x>
  {
    c(ab.a parama)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "sessionIdServer", "", "errType", "", "errCode", "errMsg", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements r<String, Integer, Integer, String, x>
  {
    d(ab.a parama)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "sessionIdServer", "", "errType", "", "errCode", "errMsg", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements r<String, Integer, Integer, String, x>
  {
    e(ab.a parama)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "sessionIdServer", "", "errType", "", "errCode", "errMsg", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements r<String, Integer, Integer, String, x>
  {
    f(ab.a parama)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetMsgSessionIdResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class g<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    g(f paramf, int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2, af.b paramb, r paramr) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<String>
  {
    public static final h AdC;
    
    static
    {
      AppMethodBeat.i(279063);
      AdC = new h();
      AppMethodBeat.o(279063);
    }
    
    h()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.a<af>
  {
    public static final i AdD;
    
    static
    {
      AppMethodBeat.i(288661);
      AdD = new i();
      AppMethodBeat.o(288661);
    }
    
    i()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.service.f
 * JD-Core Version:    0.7.0.1
 */