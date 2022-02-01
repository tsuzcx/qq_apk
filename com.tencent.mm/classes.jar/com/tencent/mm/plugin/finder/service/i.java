package com.tencent.mm.plugin.finder.service;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.e.a;
import com.tencent.mm.am.b.a;
import com.tencent.mm.am.p;
import com.tencent.mm.cp.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bb;
import com.tencent.mm.plugin.finder.cgi.dl;
import com.tencent.mm.plugin.finder.conv.o;
import com.tencent.mm.plugin.finder.storage.ak;
import com.tencent.mm.plugin.finder.storage.ak.b;
import com.tencent.mm.plugin.findersdk.a.bp;
import com.tencent.mm.plugin.findersdk.a.bp.a;
import com.tencent.mm.plugin.findersdk.a.bp.b;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bal;
import com.tencent.mm.protocal.protobuf.bqh;
import com.tencent.mm.protocal.protobuf.bqi;
import com.tencent.mm.protocal.protobuf.bsf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.r;
import kotlin.g.b.u;
import kotlin.k;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/service/FinderSessionInfoService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSessionInfoService;", "()V", "sessionInfoStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "getSessionInfoStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "sessionInfoStorage$delegate", "Lkotlin/Lazy;", "getSessionId", "", "context", "Landroid/content/Context;", "scene", "", "username", "", "roleType", "callable", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSessionInfoService$SessionIdCallback;", "getSessionIdByComment", "sessionId", "objectId", "", "commentId", "isCommentLike", "", "getSessionIdByFansId", "fansId", "getSessionIdByLottery", "lotteryId", "sourceType", "getSessionIdByUsername", "getSessionIdFromLive", "getSessionIdFromLocal", "talker", "getSessionIdFromServer", "feedId", "isFromLiveLottery", "source", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage$ReplaceSource;", "callback", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "result", "errType", "errCode", "errMsg", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;JJZLjava/lang/String;Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage$ReplaceSource;Ljava/lang/Integer;ZLkotlin/jvm/functions/Function4;)V", "getSessionSender", "getTalkerFromLocal", "isFinderSession", "toUsername", "requestSessionStatus", "reqItems", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderMsgGetSessionReqItem;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSessionInfoService$SessionStatusCallback;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  implements bp
{
  public static final a Fzs;
  private final kotlin.j AFU;
  
  static
  {
    AppMethodBeat.i(330176);
    Fzs = new a((byte)0);
    AppMethodBeat.o(330176);
  }
  
  public i()
  {
    AppMethodBeat.i(330129);
    this.AFU = k.cm((a)i.Fzv);
    AppMethodBeat.o(330129);
  }
  
  private static final ah a(i parami, int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2, ak.b paramb, r paramr, b.a parama)
  {
    AppMethodBeat.i(330170);
    kotlin.g.b.s.u(parami, "this$0");
    kotlin.g.b.s.u(paramString1, "$username");
    kotlin.g.b.s.u(paramb, "$source");
    kotlin.g.b.s.u(paramr, "$callback");
    Object localObject1;
    Object localObject2;
    bsf localbsf;
    label99:
    int i;
    label124:
    Object localObject3;
    label146:
    int j;
    label181:
    int k;
    label194:
    int m;
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      localObject1 = ((bal)parama.ott).ZLt;
      if (localObject1 == null)
      {
        localObject2 = "";
        localbsf = new bsf();
        localObject1 = ((bal)parama.ott).ZLt;
        if (localObject1 != null) {
          break label500;
        }
        localObject1 = null;
        if (localObject1 == null) {
          Log.e("Finder.SessionInfoService", "extInfo is null! ");
        }
        if ((localbsf.action & 0x1) <= 0) {
          break label533;
        }
        i = 1;
        localObject1 = ((bal)parama.ott).ZLt;
        if (localObject1 != null) {
          break label539;
        }
        localObject3 = "";
        j = 2;
        switch (paramInt)
        {
        default: 
          localObject1 = z.bAM();
          if ((localbsf.action & 0x4) > 0)
          {
            k = 1;
            Log.i("Finder.SessionInfoService", "[getSessionId] " + paramString1 + ',' + paramString2 + ',' + paramLong1 + '#' + paramLong2 + " => " + (String)localObject2 + " enableAction=" + i + " from server. username is equal?" + kotlin.g.b.s.p(localObject3, paramString1));
            if (((CharSequence)localObject2).length() <= 0) {
              break label595;
            }
            m = 1;
            label294:
            if (m != 0)
            {
              if (((CharSequence)localObject3).length() <= 0) {
                break label601;
              }
              m = 1;
              label315:
              if (m != 0)
              {
                if ((paramInt == 1) && (au.bxa((String)localObject3)))
                {
                  if (((CharSequence)parami.getSessionInfoStorage().eK((String)localObject3, 1)).length() <= 0) {
                    break label607;
                  }
                  paramInt = 1;
                  label356:
                  if (paramInt != 0)
                  {
                    Log.i("Finder.SessionInfoService", "build session to alias, but local has save sessionId, the talker has rebuild alias , so delete old sessionInfo");
                    parami.getSessionInfoStorage().aAJ(parami.getSessionInfoStorage().eK((String)localObject3, 1));
                  }
                }
                parami = parami.getSessionInfoStorage();
                kotlin.g.b.s.s(localObject1, "myUserName");
                parami.a((String)localObject2, (String)localObject3, j, i, paramb, k, 0, (String)localObject1);
              }
            }
            parami = ((bal)parama.ott).ZLt;
            if (parami != null) {
              break label612;
            }
            parami = "";
            label436:
            paramr.a(parami, Integer.valueOf(parama.errType), Integer.valueOf(parama.errCode), parama.errMsg);
          }
          break;
        }
      }
    }
    for (;;)
    {
      parami = ah.aiuX;
      AppMethodBeat.o(330170);
      return parami;
      localObject1 = ((bqi)localObject1).sessionId;
      localObject2 = localObject1;
      if (localObject1 != null) {
        break;
      }
      localObject2 = "";
      break;
      label500:
      localObject1 = ((bqi)localObject1).ZYn;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label99;
      }
      localObject1 = localbsf.parseFrom(((com.tencent.mm.bx.b)localObject1).toByteArray());
      break label99;
      label533:
      i = 0;
      break label124;
      label539:
      localObject1 = ((bqi)localObject1).hgl;
      localObject3 = localObject1;
      if (localObject1 != null) {
        break label146;
      }
      localObject3 = "";
      break label146;
      localObject1 = z.bAM();
      break label181;
      j = 3;
      localObject1 = z.bAX();
      break label181;
      localObject1 = z.bAW();
      break label181;
      k = 0;
      break label194;
      label595:
      m = 0;
      break label294;
      label601:
      m = 0;
      break label315;
      label607:
      paramInt = 0;
      break label356;
      label612:
      paramString1 = parami.sessionId;
      parami = paramString1;
      if (paramString1 != null) {
        break label436;
      }
      parami = "";
      break label436;
      paramr.a("", Integer.valueOf(parama.errType), Integer.valueOf(parama.errCode), parama.errMsg);
    }
  }
  
  private void a(Context paramContext, int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2, boolean paramBoolean1, String paramString3, ak.b paramb, Integer paramInteger, boolean paramBoolean2, r<? super String, ? super Integer, ? super Integer, ? super String, ah> paramr)
  {
    AppMethodBeat.i(330152);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString1, "username");
    kotlin.g.b.s.u(paramString3, "lotteryId");
    kotlin.g.b.s.u(paramb, "source");
    kotlin.g.b.s.u(paramr, "callback");
    if (paramString2 != null) {
      paramString3 = c.a((c)new bb(paramString2), paramContext, 1500L, 2);
    }
    for (;;)
    {
      paramString3.bFJ().j(new i..ExternalSyntheticLambda0(this, paramInt, paramString1, paramString2, paramLong1, paramLong2, paramb, paramr)).a((com.tencent.mm.vending.e.b)paramContext);
      AppMethodBeat.o(330152);
      return;
      if ((paramLong1 != 0L) && (paramLong2 != 0L) && (!paramBoolean2)) {
        paramString3 = c.a((c)new bb(paramInt, paramString1, paramLong1, paramLong2), paramContext, 1500L, 2);
      } else if (paramBoolean1) {
        paramString3 = c.a((c)new bb(paramInt, paramString1, paramString3, paramLong1, paramInteger), paramContext, 1500L, 2);
      } else {
        paramString3 = c.a((c)new bb(paramInt, paramString1), paramContext, 1500L, 2);
      }
    }
  }
  
  private final ak getSessionInfoStorage()
  {
    AppMethodBeat.i(330135);
    ak localak = (ak)this.AFU.getValue();
    AppMethodBeat.o(330135);
    return localak;
  }
  
  public final void a(Context paramContext, int paramInt1, String paramString, int paramInt2, bp.a parama)
  {
    AppMethodBeat.i(330189);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(parama, "callable");
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      parama.onDone("", 0, 0, "");
      Log.e("Finder.SessionInfoService", "[getSessionId] username=" + paramString + " is invalid, just return.");
      AppMethodBeat.o(330189);
      return;
    }
    localObject = eI(paramString, paramInt2);
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (paramInt2 = 1; paramInt2 != 0; paramInt2 = 0)
    {
      a(this, paramContext, paramInt1, paramString, null, 0L, 0L, false, null, null, null, false, (r)new b(parama), 2040);
      AppMethodBeat.o(330189);
      return;
    }
    parama.onDone((String)localObject, 0, 0, "");
    AppMethodBeat.o(330189);
  }
  
  public final void a(Context paramContext, String paramString, bp.a parama)
  {
    AppMethodBeat.i(330215);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(parama, "callable");
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      parama.onDone("", 0, 0, "");
      Log.e("Finder.SessionInfoService", "[getSessionId] username=" + paramString + " is invalid, just return.");
      AppMethodBeat.o(330215);
      return;
    }
    a(this, paramContext, 1, paramString, null, 0L, 0L, false, null, null, null, false, (r)new g(parama), 2040);
    AppMethodBeat.o(330215);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, bp.a parama)
  {
    AppMethodBeat.i(330197);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(parama, "callable");
    CharSequence localCharSequence = (CharSequence)paramString2;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      parama.onDone("", 0, 0, "");
      Log.e("Finder.SessionInfoService", "[getSessionId] fansId=" + paramString2 + " is invalid, just return.");
      AppMethodBeat.o(330197);
      return;
    }
    paramString1 = getSessionInfoStorage().aAG(paramString1).field_sessionId;
    localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (i = 1; i != 0; i = 0)
    {
      a(this, paramContext, 1, "", paramString2, 0L, 0L, false, null, null, null, false, (r)new d(parama), 2032);
      AppMethodBeat.o(330197);
      return;
    }
    parama.onDone(paramString1, 0, 0, "");
    AppMethodBeat.o(330197);
  }
  
  public final void a(LinkedList<bqh> paramLinkedList, bp.b paramb)
  {
    AppMethodBeat.i(330248);
    kotlin.g.b.s.u(paramLinkedList, "reqItems");
    j localj = j.Fzw;
    kotlin.g.b.s.u(paramLinkedList, "reqItems");
    j.Fzx = paramb;
    com.tencent.mm.kernel.h.aZW().a(6218, (com.tencent.mm.am.h)localj);
    paramLinkedList = new dl(paramLinkedList);
    com.tencent.mm.kernel.h.aZW().a((p)paramLinkedList, 0);
    AppMethodBeat.o(330248);
  }
  
  public final String aAw(String paramString)
  {
    AppMethodBeat.i(330222);
    paramString = getSessionInfoStorage().aAG(paramString).field_talker;
    if (paramString == null)
    {
      AppMethodBeat.o(330222);
      return "";
    }
    AppMethodBeat.o(330222);
    return paramString;
  }
  
  public final String aAx(String paramString)
  {
    AppMethodBeat.i(330237);
    paramString = getSessionInfoStorage().aAG(paramString);
    e locale = (e)com.tencent.mm.plugin.findersdk.b.HbT;
    String str = paramString.field_senderUserName;
    int i;
    if (str != null) {
      if (((CharSequence)str).length() > 0)
      {
        i = 1;
        if (i != 1) {
          break label98;
        }
      }
    }
    label98:
    for (boolean bool = true;; bool = false)
    {
      e.a.a(locale, "getSessionSender", bool, null, false, (a)h.Fzu, 28);
      paramString = paramString.field_senderUserName;
      if (paramString != null) {
        break label103;
      }
      AppMethodBeat.o(330237);
      return "";
      i = 0;
      break;
    }
    label103:
    AppMethodBeat.o(330237);
    return paramString;
  }
  
  public final boolean aAy(String paramString)
  {
    AppMethodBeat.i(330255);
    if (paramString != null)
    {
      boolean bool = n.rs(paramString, "@findermsg");
      AppMethodBeat.o(330255);
      return bool;
    }
    AppMethodBeat.o(330255);
    return false;
  }
  
  public final void b(Context paramContext, String paramString1, String paramString2, bp.a parama)
  {
    AppMethodBeat.i(330207);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(parama, "callable");
    CharSequence localCharSequence = (CharSequence)paramString2;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      parama.onDone("", 0, 0, "");
      Log.e("Finder.SessionInfoService", "[getSessionId] username=" + paramString2 + " is invalid, just return.");
      AppMethodBeat.o(330207);
      return;
    }
    paramString1 = getSessionInfoStorage().aAG(paramString1).field_sessionId;
    localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (i = 1; i != 0; i = 0)
    {
      a(this, paramContext, 1, paramString2, null, 0L, 0L, false, null, null, null, false, (r)new f(parama), 2040);
      AppMethodBeat.o(330207);
      return;
    }
    parama.onDone(paramString1, 0, 0, "");
    AppMethodBeat.o(330207);
  }
  
  public final String eI(String paramString, int paramInt)
  {
    AppMethodBeat.i(330228);
    paramString = getSessionInfoStorage().eK(paramString, paramInt);
    AppMethodBeat.o(330228);
    return paramString;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/service/FinderSessionInfoService$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "sessionIdServer", "", "errType", "", "errCode", "errMsg"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements r<String, Integer, Integer, String, ah>
  {
    b(bp.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "sessionIdServer", "", "errType", "", "errCode", "errMsg"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements r<String, Integer, Integer, String, ah>
  {
    c(bp.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "sessionIdServer", "", "errType", "", "errCode", "errMsg"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements r<String, Integer, Integer, String, ah>
  {
    d(bp.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "sessionIdServer", "", "errType", "", "errCode", "errMsg"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements r<String, Integer, Integer, String, ah>
  {
    e(bp.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "sessionIdServer", "", "errType", "", "errCode", "errMsg"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements r<String, Integer, Integer, String, ah>
  {
    f(bp.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "sessionIdServer", "", "errType", "", "errCode", "errMsg"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements r<String, Integer, Integer, String, ah>
  {
    g(bp.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements a<String>
  {
    public static final h Fzu;
    
    static
    {
      AppMethodBeat.i(330022);
      Fzu = new h();
      AppMethodBeat.o(330022);
    }
    
    h()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements a<ak>
  {
    public static final i Fzv;
    
    static
    {
      AppMethodBeat.i(330017);
      Fzv = new i();
      AppMethodBeat.o(330017);
    }
    
    i()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.service.i
 * JD-Core Version:    0.7.0.1
 */