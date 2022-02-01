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
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.z.f;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/model/SubscribeStatusUpdateManager;", "", "service", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService;", "(Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService;)V", "subscribeMsgService", "updatingTaskIdSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "doUpdateSubscribeStatus", "", "updateTask", "Lcom/tencent/mm/msgsubscription/model/SubscribeMsgService$UpdateSubscribeStatusTask;", "isTemplateMsgSubscribed", "bizUsername", "templateId", "callback", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;", "onUpdateSubscribeStatusSuccess", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "switchSubscribeStatus", "tmpItem", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "updateGetSubscribeStatusTimestamp", "timestamp", "", "updateSubscribeStatus", "updateSubscribeStatusIfNecessary", "subscribeMsgTmpItem", "Companion", "plugin-comm_release"})
public final class c
{
  public static final c.a jzK;
  private final HashSet<String> jzI;
  ISubscribeMsgService jzJ;
  
  static
  {
    AppMethodBeat.i(223284);
    jzK = new c.a((byte)0);
    AppMethodBeat.o(223284);
  }
  
  public c(ISubscribeMsgService paramISubscribeMsgService)
  {
    AppMethodBeat.i(223283);
    this.jzI = new HashSet();
    this.jzJ = paramISubscribeMsgService;
    AppMethodBeat.o(223283);
  }
  
  private final void a(a.b paramb)
  {
    AppMethodBeat.i(223280);
    if (this.jzI.contains(paramb.ixM))
    {
      Log.i("MicroMsg.SubscribeStatusUpdateManager", "alvinluo updateSubscribeStatus templateId: %s is updating", new Object[] { paramb.ixM });
      AppMethodBeat.o(223280);
      return;
    }
    b(paramb);
    AppMethodBeat.o(223280);
  }
  
  private final void b(final a.b paramb)
  {
    AppMethodBeat.i(223281);
    Log.i("MicroMsg.SubscribeStatusUpdateManager", "alvinluo doUpdateSubscribeStatus templateId: %s, bizUsername: %s", new Object[] { paramb.ixM, paramb.dVu });
    this.jzI.add(paramb.ixM);
    ISubscribeMsgService localISubscribeMsgService = this.jzJ;
    if (localISubscribeMsgService != null) {
      localISubscribeMsgService.a(paramb.dVu, j.mutableListOf(new String[] { paramb.ixM }), (a)new b(this, paramb));
    }
    h(paramb.dVu, paramb.ixM, System.currentTimeMillis() + 30000L);
    AppMethodBeat.o(223281);
  }
  
  private final void h(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(223282);
    ISubscribeMsgService localISubscribeMsgService = this.jzJ;
    if (localISubscribeMsgService != null)
    {
      localISubscribeMsgService.g(paramString1, paramString2, paramLong);
      AppMethodBeat.o(223282);
      return;
    }
    AppMethodBeat.o(223282);
  }
  
  final void a(SubscribeMsgTmpItem paramSubscribeMsgTmpItem, a.b paramb)
  {
    AppMethodBeat.i(223279);
    b localb = b.jzH;
    if (b.b(paramSubscribeMsgTmpItem))
    {
      a(paramb);
      AppMethodBeat.o(223279);
      return;
    }
    Log.v("MicroMsg.SubscribeStatusUpdateManager", "alvinluo updateSubscribeStatusIfNecessary no need to update");
    AppMethodBeat.o(223279);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/msgsubscription/model/SubscribeStatusUpdateManager$doUpdateSubscribeStatus$1", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
  public static final class b
    implements a
  {
    b(a.b paramb) {}
    
    public final void a(String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(223273);
      p.h(paramString, "bizUsername");
      p.h(paramSubscribeMsgRequestResult, "result");
      c.b(this.jzL).remove(paramb.ixM);
      c.a(this.jzL, paramSubscribeMsgRequestResult, paramb);
      AppMethodBeat.o(223273);
    }
    
    public final void i(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(223274);
      p.h(paramString, "errMsg");
      Log.e("MicroMsg.SubscribeStatusUpdateManager", "alvinluo getSubscribeStatus onError templateId: " + paramb.ixM + ", errType: " + paramInt1 + ", errCode: " + paramInt2 + ", errMsg: " + paramString);
      c.b(this.jzL).remove(paramb.ixM);
      paramString = paramb.jzA;
      if (paramString != null)
      {
        paramString.onError();
        AppMethodBeat.o(223274);
        return;
      }
      AppMethodBeat.o(223274);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/msgsubscription/model/SubscribeStatusUpdateManager$isTemplateMsgSubscribed$2", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
  public static final class c
    implements a
  {
    c(String paramString, ISubscribeMsgService.b paramb, z.f paramf) {}
    
    public final void a(String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(223275);
      p.h(paramString, "bizUsername");
      p.h(paramSubscribeMsgRequestResult, "result");
      paramSubscribeMsgRequestResult = paramSubscribeMsgRequestResult.jyk;
      if (!((Collection)paramSubscribeMsgRequestResult).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label160;
        }
        paramSubscribeMsgRequestResult = ((Iterable)paramSubscribeMsgRequestResult).iterator();
        label50:
        do
        {
          if (!paramSubscribeMsgRequestResult.hasNext()) {
            break;
          }
          localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)paramSubscribeMsgRequestResult.next();
        } while (!this.jzC.equals(localSubscribeMsgTmpItem.ixM));
        localObject1 = this.jzG;
        if (localObject1 != null)
        {
          localObject2 = this.jzC;
          if (localSubscribeMsgTmpItem.jyB != 1) {
            break label154;
          }
        }
      }
      label154:
      for (boolean bool = true;; bool = false)
      {
        ((ISubscribeMsgService.b)localObject1).a((String)localObject2, new ISubscribeMsgService.c(bool, localSubscribeMsgTmpItem.VC));
        this.jzN.SYG = localSubscribeMsgTmpItem;
        break label50;
        i = 0;
        break;
      }
      label160:
      paramSubscribeMsgRequestResult = this.jzL;
      SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)this.jzN.SYG;
      Object localObject1 = this.jzC;
      Object localObject2 = (SubscribeMsgTmpItem)this.jzN.SYG;
      if (localObject2 != null) {}
      for (int i = ((SubscribeMsgTmpItem)localObject2).jyB;; i = -1)
      {
        paramString = new a.b(paramString, (String)localObject1, i);
        paramString.jzA = this.jzG;
        c.a(paramSubscribeMsgRequestResult, localSubscribeMsgTmpItem, paramString);
        AppMethodBeat.o(223275);
        return;
      }
    }
    
    public final void i(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(223276);
      p.h(paramString, "errMsg");
      Log.e("MicroMsg.SubscribeStatusUpdateManager", "alvinluo loadSubscribeMsgList onError templateId: " + this.jzC + ", errType: " + paramInt1 + ", errCode: " + paramInt2 + ", errMsg: " + paramString);
      paramString = this.jzG;
      if (paramString != null)
      {
        paramString.onError();
        AppMethodBeat.o(223276);
        return;
      }
      AppMethodBeat.o(223276);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/msgsubscription/model/SubscribeStatusUpdateManager$switchSubscribeStatus$1", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
  public static final class d
    implements a
  {
    d(SubscribeMsgTmpItem paramSubscribeMsgTmpItem, ISubscribeMsgService.b paramb, String paramString) {}
    
    public final void a(String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(223277);
      p.h(paramString, "bizUsername");
      p.h(paramSubscribeMsgRequestResult, "result");
      Log.v("MicroMsg.SubscribeStatusUpdateManager", "alvinluo switchSubscribeStatus onSuccess bizUsername: %s, templateId: %s, settingStatus: %d", new Object[] { paramString, this.jzF.ixM, Integer.valueOf(this.jzF.jyB) });
      Object localObject = ((Iterable)paramSubscribeMsgRequestResult.jyk).iterator();
      boolean bool1 = false;
      boolean bool2 = false;
      while (((Iterator)localObject).hasNext())
      {
        SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)((Iterator)localObject).next();
        if (this.jzF.ixM.equals(localSubscribeMsgTmpItem.ixM))
        {
          bool1 = localSubscribeMsgTmpItem.VC;
          bool2 = true;
        }
      }
      boolean bool3;
      if (bool2) {
        if (this.jzF.jyB == 1) {
          bool3 = true;
        }
      }
      for (localObject = new ISubscribeMsgService.c(bool3, bool1);; localObject = new ISubscribeMsgService.c(false, this.jzF.VC))
      {
        Log.i("MicroMsg.SubscribeStatusUpdateManager", "alvinluo switchSubscribeStatus onSuccess hasResult: %b, isSubscribed: %b, switchOpen: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(((ISubscribeMsgService.c)localObject).jyX), Boolean.valueOf(((ISubscribeMsgService.c)localObject).jyY) });
        this.jzG.a(this.jzF.ixM, (ISubscribeMsgService.c)localObject);
        localObject = c.a(this.jzL);
        if (localObject == null) {
          break label275;
        }
        ISubscribeMsgService.a.a((ISubscribeMsgService)localObject, paramString, (List)paramSubscribeMsgRequestResult.jyk);
        AppMethodBeat.o(223277);
        return;
        bool3 = false;
        break;
      }
      label275:
      AppMethodBeat.o(223277);
    }
    
    public final void i(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(223278);
      p.h(paramString, "errMsg");
      Log.e("MicroMsg.SubscribeStatusUpdateManager", "alvinluo switchSubscribeStatus onError templateId: " + this.jzF.ixM + ", errType: " + paramInt1 + ", errCode: " + paramInt2 + ", errMsg: " + paramString);
      if (this.jzF.jyB == 1) {}
      for (this.jzF.jyB = 0;; this.jzF.jyB = 1)
      {
        this.jzG.onError();
        paramString = c.a(this.jzL);
        if (paramString == null) {
          break;
        }
        ISubscribeMsgService.a.a(paramString, this.jzO, j.mutableListOf(new SubscribeMsgTmpItem[] { this.jzF }));
        AppMethodBeat.o(223278);
        return;
      }
      AppMethodBeat.o(223278);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.b.c
 * JD-Core Version:    0.7.0.1
 */