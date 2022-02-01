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
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/model/SubscribeStatusUpdateManager;", "", "service", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService;", "(Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService;)V", "subscribeMsgService", "updatingTaskIdSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "doUpdateSubscribeStatus", "", "updateTask", "Lcom/tencent/mm/msgsubscription/model/SubscribeMsgService$UpdateSubscribeStatusTask;", "isTemplateMsgSubscribed", "bizUsername", "templateId", "callback", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;", "onUpdateSubscribeStatusSuccess", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "switchSubscribeStatus", "tmpItem", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "updateGetSubscribeStatusTimestamp", "timestamp", "", "updateSubscribeStatus", "updateSubscribeStatusIfNecessary", "subscribeMsgTmpItem", "Companion", "plugin-comm_release"})
public final class c
{
  public static final c.a mpq;
  private final HashSet<String> mpo;
  ISubscribeMsgService mpp;
  
  static
  {
    AppMethodBeat.i(221577);
    mpq = new c.a((byte)0);
    AppMethodBeat.o(221577);
  }
  
  public c(ISubscribeMsgService paramISubscribeMsgService)
  {
    AppMethodBeat.i(221574);
    this.mpo = new HashSet();
    this.mpp = paramISubscribeMsgService;
    AppMethodBeat.o(221574);
  }
  
  private final void a(a.b paramb)
  {
    AppMethodBeat.i(221568);
    if (this.mpo.contains(paramb.lnb))
    {
      Log.i("MicroMsg.SubscribeStatusUpdateManager", "alvinluo updateSubscribeStatus templateId: %s is updating", new Object[] { paramb.lnb });
      AppMethodBeat.o(221568);
      return;
    }
    b(paramb);
    AppMethodBeat.o(221568);
  }
  
  private final void b(final a.b paramb)
  {
    AppMethodBeat.i(221571);
    Log.i("MicroMsg.SubscribeStatusUpdateManager", "alvinluo doUpdateSubscribeStatus templateId: %s, bizUsername: %s", new Object[] { paramb.lnb, paramb.fOX });
    this.mpo.add(paramb.lnb);
    ISubscribeMsgService localISubscribeMsgService = this.mpp;
    if (localISubscribeMsgService != null) {
      localISubscribeMsgService.a(paramb.fOX, j.mutableListOf(new String[] { paramb.lnb }), (a)new b(this, paramb));
    }
    h(paramb.fOX, paramb.lnb, System.currentTimeMillis() + 30000L);
    AppMethodBeat.o(221571);
  }
  
  private final void h(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(221572);
    ISubscribeMsgService localISubscribeMsgService = this.mpp;
    if (localISubscribeMsgService != null)
    {
      localISubscribeMsgService.g(paramString1, paramString2, paramLong);
      AppMethodBeat.o(221572);
      return;
    }
    AppMethodBeat.o(221572);
  }
  
  final void a(SubscribeMsgTmpItem paramSubscribeMsgTmpItem, a.b paramb)
  {
    AppMethodBeat.i(221564);
    b localb = b.mpn;
    if (b.b(paramSubscribeMsgTmpItem))
    {
      a(paramb);
      AppMethodBeat.o(221564);
      return;
    }
    Log.v("MicroMsg.SubscribeStatusUpdateManager", "alvinluo updateSubscribeStatusIfNecessary no need to update");
    AppMethodBeat.o(221564);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/msgsubscription/model/SubscribeStatusUpdateManager$doUpdateSubscribeStatus$1", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
  public static final class b
    implements a
  {
    b(a.b paramb) {}
    
    public final void a(String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(196361);
      p.k(paramString, "bizUsername");
      p.k(paramSubscribeMsgRequestResult, "result");
      c.b(this.mpr).remove(paramb.lnb);
      c.a(this.mpr, paramSubscribeMsgRequestResult, paramb);
      AppMethodBeat.o(196361);
    }
    
    public final void i(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(196363);
      p.k(paramString, "errMsg");
      Log.e("MicroMsg.SubscribeStatusUpdateManager", "alvinluo getSubscribeStatus onError templateId: " + paramb.lnb + ", errType: " + paramInt1 + ", errCode: " + paramInt2 + ", errMsg: " + paramString);
      c.b(this.mpr).remove(paramb.lnb);
      paramString = paramb.mpg;
      if (paramString != null)
      {
        paramString.onError();
        AppMethodBeat.o(196363);
        return;
      }
      AppMethodBeat.o(196363);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/msgsubscription/model/SubscribeStatusUpdateManager$isTemplateMsgSubscribed$2", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
  public static final class c
    implements a
  {
    c(String paramString, ISubscribeMsgService.b paramb, aa.f paramf) {}
    
    public final void a(String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(238316);
      p.k(paramString, "bizUsername");
      p.k(paramSubscribeMsgRequestResult, "result");
      paramSubscribeMsgRequestResult = paramSubscribeMsgRequestResult.mnO;
      if (!((Collection)paramSubscribeMsgRequestResult).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label180;
        }
        paramSubscribeMsgRequestResult = ((Iterable)paramSubscribeMsgRequestResult).iterator();
        label50:
        do
        {
          if (!paramSubscribeMsgRequestResult.hasNext()) {
            break;
          }
          localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)paramSubscribeMsgRequestResult.next();
        } while (!this.mpi.equals(localSubscribeMsgTmpItem.lnb));
        if (localSubscribeMsgTmpItem.mof != 1) {
          break label174;
        }
      }
      label174:
      for (boolean bool = true;; bool = false)
      {
        localObject1 = new ISubscribeMsgService.c(bool, localSubscribeMsgTmpItem.gZ);
        ((ISubscribeMsgService.c)localObject1).mok = localSubscribeMsgTmpItem.mok;
        ((ISubscribeMsgService.c)localObject1).mnH = localSubscribeMsgTmpItem.mnH;
        localObject2 = this.mpm;
        if (localObject2 != null) {
          ((ISubscribeMsgService.b)localObject2).a(this.mpi, (ISubscribeMsgService.c)localObject1);
        }
        this.mpt.aaBC = localSubscribeMsgTmpItem;
        break label50;
        i = 0;
        break;
      }
      label180:
      paramSubscribeMsgRequestResult = this.mpr;
      SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)this.mpt.aaBC;
      Object localObject1 = this.mpi;
      Object localObject2 = (SubscribeMsgTmpItem)this.mpt.aaBC;
      if (localObject2 != null) {}
      for (int i = ((SubscribeMsgTmpItem)localObject2).mof;; i = -1)
      {
        paramString = new a.b(paramString, (String)localObject1, i);
        paramString.mpg = this.mpm;
        c.a(paramSubscribeMsgRequestResult, localSubscribeMsgTmpItem, paramString);
        AppMethodBeat.o(238316);
        return;
      }
    }
    
    public final void i(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(238322);
      p.k(paramString, "errMsg");
      Log.e("MicroMsg.SubscribeStatusUpdateManager", "alvinluo loadSubscribeMsgList onError templateId: " + this.mpi + ", errType: " + paramInt1 + ", errCode: " + paramInt2 + ", errMsg: " + paramString);
      paramString = this.mpm;
      if (paramString != null)
      {
        paramString.onError();
        AppMethodBeat.o(238322);
        return;
      }
      AppMethodBeat.o(238322);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/msgsubscription/model/SubscribeStatusUpdateManager$switchSubscribeStatus$1", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
  public static final class d
    implements a
  {
    d(SubscribeMsgTmpItem paramSubscribeMsgTmpItem, ISubscribeMsgService.b paramb, String paramString) {}
    
    public final void a(String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(221954);
      p.k(paramString, "bizUsername");
      p.k(paramSubscribeMsgRequestResult, "result");
      Log.v("MicroMsg.SubscribeStatusUpdateManager", "alvinluo switchSubscribeStatus onSuccess bizUsername: %s, templateId: %s, settingStatus: %d", new Object[] { paramString, this.mpl.lnb, Integer.valueOf(this.mpl.mof) });
      Object localObject = ((Iterable)paramSubscribeMsgRequestResult.mnO).iterator();
      boolean bool1 = false;
      boolean bool2 = false;
      while (((Iterator)localObject).hasNext())
      {
        SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)((Iterator)localObject).next();
        if (this.mpl.lnb.equals(localSubscribeMsgTmpItem.lnb))
        {
          bool1 = localSubscribeMsgTmpItem.gZ;
          bool2 = true;
        }
      }
      boolean bool3;
      if (bool2) {
        if (this.mpl.mof == 1) {
          bool3 = true;
        }
      }
      for (localObject = new ISubscribeMsgService.c(bool3, bool1);; localObject = new ISubscribeMsgService.c(false, this.mpl.gZ))
      {
        ((ISubscribeMsgService.c)localObject).mok = this.mpl.mok;
        ((ISubscribeMsgService.c)localObject).mnH = this.mpl.mnH;
        Log.i("MicroMsg.SubscribeStatusUpdateManager", "alvinluo switchSubscribeStatus onSuccess hasResult: %b, isSubscribed: %b, switchOpen: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(((ISubscribeMsgService.c)localObject).moD), Boolean.valueOf(((ISubscribeMsgService.c)localObject).moE) });
        this.mpm.a(this.mpl.lnb, (ISubscribeMsgService.c)localObject);
        localObject = c.a(this.mpr);
        if (localObject == null) {
          break label299;
        }
        ISubscribeMsgService.a.a((ISubscribeMsgService)localObject, paramString, (List)paramSubscribeMsgRequestResult.mnO);
        AppMethodBeat.o(221954);
        return;
        bool3 = false;
        break;
      }
      label299:
      AppMethodBeat.o(221954);
    }
    
    public final void i(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(221957);
      p.k(paramString, "errMsg");
      Log.e("MicroMsg.SubscribeStatusUpdateManager", "alvinluo switchSubscribeStatus onError templateId: " + this.mpl.lnb + ", errType: " + paramInt1 + ", errCode: " + paramInt2 + ", errMsg: " + paramString);
      if (this.mpl.mof == 1) {}
      for (this.mpl.mof = 0;; this.mpl.mof = 1)
      {
        this.mpm.onError();
        paramString = c.a(this.mpr);
        if (paramString == null) {
          break;
        }
        ISubscribeMsgService.a.a(paramString, this.mpu, j.mutableListOf(new SubscribeMsgTmpItem[] { this.mpl }));
        AppMethodBeat.o(221957);
        return;
      }
      AppMethodBeat.o(221957);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.b.c
 * JD-Core Version:    0.7.0.1
 */