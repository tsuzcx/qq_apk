package com.tencent.mm.msgsubscription.storage;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.c.d;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.g.a.b;
import d.g.b.k;
import d.g.b.v.e;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/msgsubscription/storage/BaseSubscribeMsgService;", "Lcom/tencent/mm/msgsubscription/storage/IBrandSubscribeMsgService;", "()V", "dataLoader", "Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader;", "updatingTaskIdSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "callbackWrapper", "", "templateId", "action", "Lkotlin/Function1;", "Lcom/tencent/mm/msgsubscription/storage/IBrandSubscribeMsgService$SubscribeStatusOpCallback;", "Lkotlin/ParameterName;", "name", "callback", "clickSubscribeMsgSpan", "context", "Landroid/content/Context;", "bizUsername", "url", "extra", "Landroid/os/Bundle;", "doUpdateSubscribeUIStatus", "updateTask", "Lcom/tencent/mm/msgsubscription/storage/BaseSubscribeMsgService$UpdateSubscribeStatusTask;", "goToSettingManagerUI", "nickname", "isTemplateMsgSubscribed", "onErrorWrapper", "onUpdateSubscribeUIStatusSuccess", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "onUpdatedWrapper", "Lcom/tencent/mm/msgsubscription/storage/IBrandSubscribeMsgService$SubscribeStatusResult;", "saveSubscribeMsgUiStatus", "subscribeMsgList", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "switchOpened", "", "needUpdateSwitch", "needUpdateTimestamp", "switchSubscribeStatus", "tmpItem", "updateLocalSwitchOpened", "updateSubscribeUIStatus", "updateSubscribeUIStatusIfNecessary", "subscribeMsgTmpItem", "Companion", "UpdateSubscribeStatusTask", "plugin-comm_release"})
public abstract class a
  implements IBrandSubscribeMsgService
{
  private static final HashMap<String, HashMap<String, IBrandSubscribeMsgService.b>> hHn = new HashMap();
  public static final a.a hHo = new a.a((byte)0);
  private final HashSet<String> hHl = new HashSet();
  public final e hHm = new e(aEs());
  
  public static void a(String paramString, final IBrandSubscribeMsgService.c paramc)
  {
    ad.i("MicroMsg.BaseSubscribeMsgService", "alvinluo onUpdatedWrapper templateId: %s, isSubscribed: %b, switchOpen: %b", new Object[] { paramString, Boolean.valueOf(paramc.hHQ), Boolean.valueOf(paramc.hHR) });
    a(paramString, (b)new f(paramString, paramc));
  }
  
  private static void a(String paramString, b<? super IBrandSubscribeMsgService.b, y> paramb)
  {
    Integer localInteger = null;
    HashMap localHashMap = (HashMap)hHn.get(paramString);
    if (localHashMap != null) {}
    for (Set localSet = localHashMap.keySet();; localSet = null)
    {
      if (localSet != null) {
        localInteger = Integer.valueOf(localSet.size());
      }
      ad.i("MicroMsg.BaseSubscribeMsgService", "alvinluo callbackWrapper templateId: %s, callback size: %s", new Object[] { paramString, localInteger });
      if (localSet == null) {
        break;
      }
      paramString = ((Iterable)localSet).iterator();
      while (paramString.hasNext()) {
        paramb.aA(localHashMap.get((String)paramString.next()));
      }
    }
  }
  
  public final void Y(String paramString, boolean paramBoolean)
  {
    k.h(paramString, "bizUsername");
    ad.i("MicroMsg.BaseSubscribeMsgService", "alvinluo updateLocalSwitchOpened bizUsername: %s, switchOpened: %b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    e locale = this.hHm;
    k.h(paramString, "username");
    locale.b(paramString, (List)new ArrayList(), paramBoolean, true, false);
  }
  
  public final void a(SubscribeMsgTmpItem paramSubscribeMsgTmpItem, final a.b paramb)
  {
    Object localObject = c.hHL;
    if (c.b(paramSubscribeMsgTmpItem))
    {
      if (this.hHl.contains(paramb.gIj))
      {
        ad.i("MicroMsg.BaseSubscribeMsgService", "alvinluo updateSubscribeUIStatus templateId: %s is updating", new Object[] { paramb.gIj });
        return;
      }
      this.hHl.add(paramb.gIj);
      ad.i("MicroMsg.BaseSubscribeMsgService", "alvinluo doUpdateSubscribeUIStatus templateId: %s, bizUsername: %s", new Object[] { paramb.gIj, paramb.dta });
      paramSubscribeMsgTmpItem = this.hHm;
      localObject = paramb.dta;
      List localList = j.mutableListOf(new String[] { paramb.gIj });
      paramb = (e.b)new c(this, paramb);
      k.h(localObject, "username");
      k.h(localList, "templateIdList");
      ad.i("Mp.SubscribeMsgDataLoader", "alvinluo getSubscribeUIStatus username: %s, template size: %d", new Object[] { localObject, Integer.valueOf(localList.size()) });
      g localg = g.hHX;
      g.a(paramSubscribeMsgTmpItem.hHS, (com.tencent.mm.msgsubscription.c.a)new d((String)localObject, localList, paramSubscribeMsgTmpItem.hHS, paramb));
      return;
    }
    ad.v("MicroMsg.BaseSubscribeMsgService", "alvinluo updateSubscribeUIStatus no need to update");
  }
  
  public final void a(String paramString, List<SubscribeMsgTmpItem> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    k.h(paramString, "bizUsername");
    k.h(paramList, "subscribeMsgList");
    this.hHm.b(paramString, paramList, paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  public void k(Context paramContext, String paramString1, String paramString2)
  {
    k.h(paramContext, "context");
    k.h(paramString1, "bizUsername");
    k.h(paramString2, "nickname");
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/msgsubscription/storage/BaseSubscribeMsgService$doUpdateSubscribeUIStatus$1", "Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader$SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
  public static final class c
    implements e.b
  {
    c(a.b paramb) {}
    
    public final void a(String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(149602);
      k.h(paramString, "bizUsername");
      k.h(paramSubscribeMsgRequestResult, "result");
      a.a(this.hHp, paramSubscribeMsgRequestResult, paramb);
      AppMethodBeat.o(149602);
    }
    
    public final void i(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(149603);
      k.h(paramString, "errMsg");
      a.AM(paramb.gIj);
      AppMethodBeat.o(149603);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/msgsubscription/storage/BaseSubscribeMsgService$isTemplateMsgSubscribed$1", "Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader$SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
  public static final class d
    implements e.b
  {
    public d(String paramString, v.e parame) {}
    
    public final void a(String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(149604);
      k.h(paramString, "bizUsername");
      k.h(paramSubscribeMsgRequestResult, "result");
      paramSubscribeMsgRequestResult = paramSubscribeMsgRequestResult.hGg;
      if (!((Collection)paramSubscribeMsgRequestResult).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label145;
        }
        paramSubscribeMsgRequestResult = ((Iterable)paramSubscribeMsgRequestResult).iterator();
        label50:
        do
        {
          if (!paramSubscribeMsgRequestResult.hasNext()) {
            break;
          }
          localSubscribeMsgTmpItem1 = (SubscribeMsgTmpItem)paramSubscribeMsgRequestResult.next();
        } while (!this.hHr.equals(localSubscribeMsgTmpItem1.gIj));
        str = this.hHr;
        if (localSubscribeMsgTmpItem1.hGw != 1) {
          break label139;
        }
      }
      label139:
      for (boolean bool = true;; bool = false)
      {
        a.b(str, new IBrandSubscribeMsgService.c(bool, localSubscribeMsgTmpItem1.SE));
        this.hHs.Jhw = localSubscribeMsgTmpItem1;
        break label50;
        i = 0;
        break;
      }
      label145:
      paramSubscribeMsgRequestResult = this.hHp;
      SubscribeMsgTmpItem localSubscribeMsgTmpItem1 = (SubscribeMsgTmpItem)this.hHs.Jhw;
      String str = this.hHr;
      SubscribeMsgTmpItem localSubscribeMsgTmpItem2 = (SubscribeMsgTmpItem)this.hHs.Jhw;
      if (localSubscribeMsgTmpItem2 != null) {}
      for (int i = localSubscribeMsgTmpItem2.hGw;; i = -1)
      {
        a.a(paramSubscribeMsgRequestResult, localSubscribeMsgTmpItem1, new a.b(paramString, str, i));
        AppMethodBeat.o(149604);
        return;
      }
    }
    
    public final void i(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(149605);
      k.h(paramString, "errMsg");
      AppMethodBeat.o(149605);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "callback", "Lcom/tencent/mm/msgsubscription/storage/IBrandSubscribeMsgService$SubscribeStatusOpCallback;", "invoke"})
  static final class e
    extends d.g.b.l
    implements b<IBrandSubscribeMsgService.b, y>
  {
    public static final e hHt;
    
    static
    {
      AppMethodBeat.i(149607);
      hHt = new e();
      AppMethodBeat.o(149607);
    }
    
    e()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "callback", "Lcom/tencent/mm/msgsubscription/storage/IBrandSubscribeMsgService$SubscribeStatusOpCallback;", "invoke"})
  static final class f
    extends d.g.b.l
    implements b<IBrandSubscribeMsgService.b, y>
  {
    f(String paramString, IBrandSubscribeMsgService.c paramc)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/msgsubscription/storage/BaseSubscribeMsgService$switchSubscribeStatus$1", "Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader$SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
  public static final class g
    implements e.b
  {
    public g(SubscribeMsgTmpItem paramSubscribeMsgTmpItem, IBrandSubscribeMsgService.b paramb, String paramString) {}
    
    public final void a(String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(149609);
      k.h(paramString, "bizUsername");
      k.h(paramSubscribeMsgRequestResult, "result");
      ad.v("MicroMsg.BaseSubscribeMsgService", "alvinluo switchSubscribeStatus onSuccess bizUsername: %s, templateId: %s, settingStatus: %d", new Object[] { paramString, this.hHv.gIj, Integer.valueOf(this.hHv.hGw) });
      Object localObject1 = ((Iterable)paramSubscribeMsgRequestResult.hGg).iterator();
      boolean bool1 = false;
      boolean bool2 = false;
      Object localObject2;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (SubscribeMsgTmpItem)((Iterator)localObject1).next();
        if (!this.hHv.gIj.equals(((SubscribeMsgTmpItem)localObject2).gIj)) {
          break label284;
        }
        bool1 = ((SubscribeMsgTmpItem)localObject2).SE;
        bool2 = true;
      }
      label284:
      for (;;)
      {
        break;
        boolean bool3;
        if (bool2) {
          if (this.hHv.hGw == 1) {
            bool3 = true;
          }
        }
        for (localObject1 = new IBrandSubscribeMsgService.c(bool3, bool1);; localObject1 = new IBrandSubscribeMsgService.c(false, this.hHv.SE))
        {
          ad.i("MicroMsg.BaseSubscribeMsgService", "alvinluo switchSubscribeStatus onSuccess hasResult: %b, isSubscribed: %b, switchOpen: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(((IBrandSubscribeMsgService.c)localObject1).hHQ), Boolean.valueOf(((IBrandSubscribeMsgService.c)localObject1).hHR) });
          a.b(this.hHv.gIj, (IBrandSubscribeMsgService.c)localObject1);
          localObject2 = this.hHw;
          if (localObject2 != null) {
            ((IBrandSubscribeMsgService.b)localObject2).c(this.hHv.gIj, (IBrandSubscribeMsgService.c)localObject1);
          }
          IBrandSubscribeMsgService.a.a(this.hHp, paramString, (List)paramSubscribeMsgRequestResult.hGg);
          AppMethodBeat.o(149609);
          return;
          bool3 = false;
          break;
        }
      }
    }
    
    public final void i(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(149610);
      k.h(paramString, "errMsg");
      if (this.hHv.hGw == 1) {}
      for (this.hHv.hGw = 0;; this.hHv.hGw = 1)
      {
        a.AM(this.hHv.gIj);
        paramString = this.hHw;
        if (paramString != null) {
          paramString.onError();
        }
        IBrandSubscribeMsgService.a.a(this.hHp, this.gZR, j.mutableListOf(new SubscribeMsgTmpItem[] { this.hHv }));
        AppMethodBeat.o(149610);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.storage.a
 * JD-Core Version:    0.7.0.1
 */