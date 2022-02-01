package com.tencent.mm.msgsubscription.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService.a;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService.b;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService.c;
import com.tencent.mm.msgsubscription.api.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/model/SubscribeStatusUpdateManager;", "", "service", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService;", "(Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService;)V", "subscribeMsgService", "updatingTaskIdSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "doUpdateSubscribeStatus", "", "updateTask", "Lcom/tencent/mm/msgsubscription/model/SubscribeMsgService$UpdateSubscribeStatusTask;", "isTemplateMsgSubscribed", "bizUsername", "templateId", "callback", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;", "onUpdateSubscribeStatusSuccess", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "switchSubscribeStatus", "tmpItem", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "updateGetSubscribeStatusTimestamp", "timestamp", "", "updateSubscribeStatus", "updateSubscribeStatusIfNecessary", "subscribeMsgTmpItem", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c.a pjb;
  private final HashSet<String> pjc;
  ISubscribeMsgService pjd;
  
  static
  {
    AppMethodBeat.i(236432);
    pjb = new c.a((byte)0);
    AppMethodBeat.o(236432);
  }
  
  public c(ISubscribeMsgService paramISubscribeMsgService)
  {
    AppMethodBeat.i(236346);
    this.pjc = new HashSet();
    this.pjd = paramISubscribeMsgService;
    AppMethodBeat.o(236346);
  }
  
  private final void a(a.b paramb)
  {
    AppMethodBeat.i(236354);
    if (this.pjc.contains(paramb.nSg))
    {
      Log.i("MicroMsg.SubscribeStatusUpdateManager", "alvinluo updateSubscribeStatus templateId: %s is updating", new Object[] { paramb.nSg });
      AppMethodBeat.o(236354);
      return;
    }
    b(paramb);
    AppMethodBeat.o(236354);
  }
  
  private final void b(final a.b paramb)
  {
    AppMethodBeat.i(236363);
    Log.i("MicroMsg.SubscribeStatusUpdateManager", "alvinluo doUpdateSubscribeStatus templateId: %s, bizUsername: %s", new Object[] { paramb.nSg, paramb.hUQ });
    this.pjc.add(paramb.nSg);
    ISubscribeMsgService localISubscribeMsgService = this.pjd;
    if (localISubscribeMsgService != null) {
      localISubscribeMsgService.a(paramb.hUQ, p.mutableListOf(new String[] { paramb.nSg }), (a)new b(this, paramb));
    }
    h(paramb.hUQ, paramb.nSg, System.currentTimeMillis() + 30000L);
    AppMethodBeat.o(236363);
  }
  
  private final void h(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(236377);
    ISubscribeMsgService localISubscribeMsgService = this.pjd;
    if (localISubscribeMsgService != null) {
      localISubscribeMsgService.g(paramString1, paramString2, paramLong);
    }
    AppMethodBeat.o(236377);
  }
  
  final void a(SubscribeMsgTmpItem paramSubscribeMsgTmpItem, a.b paramb)
  {
    AppMethodBeat.i(236439);
    b localb = b.pja;
    if (b.b(paramSubscribeMsgTmpItem))
    {
      a(paramb);
      AppMethodBeat.o(236439);
      return;
    }
    Log.v("MicroMsg.SubscribeStatusUpdateManager", "alvinluo updateSubscribeStatusIfNecessary no need to update");
    AppMethodBeat.o(236439);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/msgsubscription/model/SubscribeStatusUpdateManager$doUpdateSubscribeStatus$1", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements a
  {
    b(c paramc, a.b paramb) {}
    
    public final void a(String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(236311);
      s.u(paramString, "bizUsername");
      s.u(paramSubscribeMsgRequestResult, "result");
      c.b(this.pje).remove(paramb.nSg);
      c.a(this.pje, paramSubscribeMsgRequestResult, paramb);
      AppMethodBeat.o(236311);
    }
    
    public final void j(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(236316);
      s.u(paramString, "errMsg");
      Log.e("MicroMsg.SubscribeStatusUpdateManager", "alvinluo getSubscribeStatus onError templateId: " + paramb.nSg + ", errType: " + paramInt1 + ", errCode: " + paramInt2 + ", errMsg: " + paramString);
      c.b(this.pje).remove(paramb.nSg);
      paramString = paramb.piU;
      if (paramString != null) {
        paramString.atR();
      }
      AppMethodBeat.o(236316);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/msgsubscription/model/SubscribeStatusUpdateManager$isTemplateMsgSubscribed$2", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements a
  {
    c(c paramc, ah.f<SubscribeMsgTmpItem> paramf, String paramString, ISubscribeMsgService.b paramb) {}
    
    public final void a(String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(236322);
      s.u(paramString, "bizUsername");
      s.u(paramSubscribeMsgRequestResult, "result");
      paramSubscribeMsgRequestResult = paramSubscribeMsgRequestResult.phC;
      label72:
      SubscribeMsgTmpItem localSubscribeMsgTmpItem;
      if (!((Collection)paramSubscribeMsgRequestResult).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label190;
        }
        localObject3 = (Iterable)paramSubscribeMsgRequestResult;
        paramSubscribeMsgRequestResult = this.oad;
        localObject1 = this.piZ;
        localObject2 = this.pjg;
        localObject3 = ((Iterable)localObject3).iterator();
        do
        {
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)((Iterator)localObject3).next();
        } while (!paramSubscribeMsgRequestResult.equals(localSubscribeMsgTmpItem.nSg));
        if (localSubscribeMsgTmpItem.phT != 1) {
          break label184;
        }
      }
      label184:
      for (boolean bool = true;; bool = false)
      {
        ISubscribeMsgService.c localc = new ISubscribeMsgService.c(bool, localSubscribeMsgTmpItem.hU);
        localc.phY = localSubscribeMsgTmpItem.phY;
        localc.phu = localSubscribeMsgTmpItem.phu;
        if (localObject1 != null) {
          ((ISubscribeMsgService.b)localObject1).a(paramSubscribeMsgRequestResult, localc);
        }
        ((ah.f)localObject2).aqH = localSubscribeMsgTmpItem;
        break label72;
        i = 0;
        break;
      }
      label190:
      paramSubscribeMsgRequestResult = this.pje;
      Object localObject1 = (SubscribeMsgTmpItem)this.pjg.aqH;
      Object localObject2 = this.oad;
      Object localObject3 = (SubscribeMsgTmpItem)this.pjg.aqH;
      if (localObject3 == null) {}
      for (int i = -1;; i = ((SubscribeMsgTmpItem)localObject3).phT)
      {
        paramString = new a.b(paramString, (String)localObject2, i);
        paramString.piU = this.piZ;
        localObject2 = ah.aiuX;
        c.a(paramSubscribeMsgRequestResult, (SubscribeMsgTmpItem)localObject1, paramString);
        AppMethodBeat.o(236322);
        return;
      }
    }
    
    public final void j(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(236330);
      s.u(paramString, "errMsg");
      Log.e("MicroMsg.SubscribeStatusUpdateManager", "alvinluo loadSubscribeMsgList onError templateId: " + this.oad + ", errType: " + paramInt1 + ", errCode: " + paramInt2 + ", errMsg: " + paramString);
      paramString = this.piZ;
      if (paramString != null) {
        paramString.atR();
      }
      AppMethodBeat.o(236330);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/msgsubscription/model/SubscribeStatusUpdateManager$switchSubscribeStatus$1", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements a
  {
    d(SubscribeMsgTmpItem paramSubscribeMsgTmpItem, ISubscribeMsgService.b paramb, c paramc, String paramString) {}
    
    public final void a(String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(236321);
      s.u(paramString, "bizUsername");
      s.u(paramSubscribeMsgRequestResult, "result");
      Log.v("MicroMsg.SubscribeStatusUpdateManager", "alvinluo switchSubscribeStatus onSuccess bizUsername: %s, templateId: %s, settingStatus: %d", new Object[] { paramString, this.piY.nSg, Integer.valueOf(this.piY.phT) });
      Object localObject2 = (Iterable)paramSubscribeMsgRequestResult.phC;
      Object localObject1 = this.piY;
      localObject2 = ((Iterable)localObject2).iterator();
      boolean bool1 = false;
      boolean bool2 = false;
      while (((Iterator)localObject2).hasNext())
      {
        SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)((Iterator)localObject2).next();
        if (((SubscribeMsgTmpItem)localObject1).nSg.equals(localSubscribeMsgTmpItem.nSg))
        {
          bool1 = localSubscribeMsgTmpItem.hU;
          bool2 = true;
        }
      }
      boolean bool3;
      if (bool2) {
        if (this.piY.phT == 1) {
          bool3 = true;
        }
      }
      for (localObject1 = new ISubscribeMsgService.c(bool3, bool1);; localObject1 = new ISubscribeMsgService.c(false, this.piY.hU))
      {
        ((ISubscribeMsgService.c)localObject1).phY = this.piY.phY;
        ((ISubscribeMsgService.c)localObject1).phu = this.piY.phu;
        Log.i("MicroMsg.SubscribeStatusUpdateManager", "alvinluo switchSubscribeStatus onSuccess hasResult: %b, isSubscribed: %b, switchOpen: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(((ISubscribeMsgService.c)localObject1).piu), Boolean.valueOf(((ISubscribeMsgService.c)localObject1).piv) });
        this.piZ.a(this.piY.nSg, (ISubscribeMsgService.c)localObject1);
        localObject1 = c.a(this.pje);
        if (localObject1 != null) {
          ISubscribeMsgService.a.a((ISubscribeMsgService)localObject1, paramString, (List)paramSubscribeMsgRequestResult.phC);
        }
        AppMethodBeat.o(236321);
        return;
        bool3 = false;
        break;
      }
    }
    
    public final void j(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(236329);
      s.u(paramString, "errMsg");
      Log.e("MicroMsg.SubscribeStatusUpdateManager", "alvinluo switchSubscribeStatus onError templateId: " + this.piY.nSg + ", errType: " + paramInt1 + ", errCode: " + paramInt2 + ", errMsg: " + paramString);
      if (this.piY.phT == 1) {}
      for (this.piY.phT = 0;; this.piY.phT = 1)
      {
        this.piZ.atR();
        paramString = c.a(this.pje);
        if (paramString != null) {
          ISubscribeMsgService.a.a(paramString, this.pjh, p.mutableListOf(new SubscribeMsgTmpItem[] { this.piY }));
        }
        AppMethodBeat.o(236329);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.b.c
 * JD-Core Version:    0.7.0.1
 */