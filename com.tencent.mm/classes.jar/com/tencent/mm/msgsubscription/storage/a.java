package com.tencent.mm.msgsubscription.storage;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.c.d;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.g.b.y.f;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/msgsubscription/storage/BaseSubscribeMsgService;", "Lcom/tencent/mm/msgsubscription/storage/IBrandSubscribeMsgService;", "()V", "dataLoader", "Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader;", "updatingTaskIdSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "callbackWrapper", "", "templateId", "action", "Lkotlin/Function1;", "Lcom/tencent/mm/msgsubscription/storage/IBrandSubscribeMsgService$SubscribeStatusOpCallback;", "Lkotlin/ParameterName;", "name", "callback", "clickSubscribeMsgSpan", "context", "Landroid/content/Context;", "bizUsername", "url", "extra", "Landroid/os/Bundle;", "doUpdateSubscribeUIStatus", "updateTask", "Lcom/tencent/mm/msgsubscription/storage/BaseSubscribeMsgService$UpdateSubscribeStatusTask;", "goToSettingManagerUI", "nickname", "isTemplateMsgSubscribed", "onErrorWrapper", "onUpdateSubscribeUIStatusSuccess", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "onUpdatedWrapper", "Lcom/tencent/mm/msgsubscription/storage/IBrandSubscribeMsgService$SubscribeStatusResult;", "saveSubscribeMsgUiStatus", "subscribeMsgList", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "switchOpened", "", "needUpdateSwitch", "needUpdateTimestamp", "switchSubscribeStatus", "tmpItem", "updateLocalSwitchOpened", "updateSubscribeUIStatus", "updateSubscribeUIStatusIfNecessary", "subscribeMsgTmpItem", "Companion", "UpdateSubscribeStatusTask", "plugin-comm_release"})
public abstract class a
  implements IBrandSubscribeMsgService
{
  private static final HashMap<String, HashMap<String, IBrandSubscribeMsgService.b>> iBj = new HashMap();
  public static final a iBk = new a((byte)0);
  private final HashSet<String> iBh = new HashSet();
  public final e iBi = new e(aOt());
  
  public static void a(String paramString, final IBrandSubscribeMsgService.c paramc)
  {
    ad.i("MicroMsg.BaseSubscribeMsgService", "alvinluo onUpdatedWrapper templateId: %s, isSubscribed: %b, switchOpen: %b", new Object[] { paramString, Boolean.valueOf(paramc.iBM), Boolean.valueOf(paramc.iBN) });
    b(paramString, (b)new f(paramString, paramc));
  }
  
  private static void b(String paramString, b<? super IBrandSubscribeMsgService.b, z> paramb)
  {
    Integer localInteger = null;
    HashMap localHashMap = (HashMap)iBj.get(paramString);
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
        paramb.invoke(localHashMap.get((String)paramString.next()));
      }
    }
  }
  
  public final void Z(String paramString, boolean paramBoolean)
  {
    p.h(paramString, "bizUsername");
    ad.i("MicroMsg.BaseSubscribeMsgService", "alvinluo updateLocalSwitchOpened bizUsername: %s, switchOpened: %b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    e locale = this.iBi;
    p.h(paramString, "username");
    locale.b(paramString, (List)new ArrayList(), paramBoolean, true, false);
  }
  
  public final void a(SubscribeMsgTmpItem paramSubscribeMsgTmpItem, final b paramb)
  {
    Object localObject = c.iBH;
    if (c.b(paramSubscribeMsgTmpItem))
    {
      if (this.iBh.contains(paramb.hAT))
      {
        ad.i("MicroMsg.BaseSubscribeMsgService", "alvinluo updateSubscribeUIStatus templateId: %s is updating", new Object[] { paramb.hAT });
        return;
      }
      this.iBh.add(paramb.hAT);
      ad.i("MicroMsg.BaseSubscribeMsgService", "alvinluo doUpdateSubscribeUIStatus templateId: %s, bizUsername: %s", new Object[] { paramb.hAT, paramb.dCB });
      paramSubscribeMsgTmpItem = this.iBi;
      localObject = paramb.dCB;
      List localList = j.mutableListOf(new String[] { paramb.hAT });
      paramb = (e.b)new c(this, paramb);
      p.h(localObject, "username");
      p.h(localList, "templateIdList");
      ad.i("Mp.SubscribeMsgDataLoader", "alvinluo getSubscribeUIStatus username: %s, template size: %d", new Object[] { localObject, Integer.valueOf(localList.size()) });
      g localg = g.iBT;
      g.a(paramSubscribeMsgTmpItem.iBO, (com.tencent.mm.msgsubscription.c.a)new d((String)localObject, localList, paramSubscribeMsgTmpItem.iBO, paramb));
      return;
    }
    ad.v("MicroMsg.BaseSubscribeMsgService", "alvinluo updateSubscribeUIStatus no need to update");
  }
  
  public final void a(String paramString, List<SubscribeMsgTmpItem> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    p.h(paramString, "bizUsername");
    p.h(paramList, "subscribeMsgList");
    this.iBi.b(paramString, paramList, paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  public void k(Context paramContext, String paramString1, String paramString2)
  {
    p.h(paramContext, "context");
    p.h(paramString1, "bizUsername");
    p.h(paramString2, "nickname");
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/msgsubscription/storage/BaseSubscribeMsgService$Companion;", "", "()V", "DEFAULT_MAX_CACHE_AGE_FOR_TEST_IN_SEC", "", "DEFAULT_MAX_CACHE_AGE_IN_SEC", "TAG", "", "notifyCallbackList", "Ljava/util/HashMap;", "Lcom/tencent/mm/msgsubscription/storage/IBrandSubscribeMsgService$SubscribeStatusOpCallback;", "Lkotlin/collections/HashMap;", "clearNotifyCallback", "", "registerNotifyCallback", "templateId", "viewKey", "callback", "unregisterNotifyCallback", "plugin-comm_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/msgsubscription/storage/BaseSubscribeMsgService$UpdateSubscribeStatusTask;", "", "bizUsername", "", "templateId", "uiStatus", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getBizUsername", "()Ljava/lang/String;", "getTemplateId", "getUiStatus", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-comm_release"})
  public static final class b
  {
    private final int dAJ;
    final String dCB;
    final String hAT;
    
    public b(String paramString1, String paramString2, int paramInt)
    {
      AppMethodBeat.i(149598);
      this.dCB = paramString1;
      this.hAT = paramString2;
      this.dAJ = paramInt;
      AppMethodBeat.o(149598);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(149601);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((!p.i(this.dCB, paramObject.dCB)) || (!p.i(this.hAT, paramObject.hAT)) || (this.dAJ != paramObject.dAJ)) {}
        }
      }
      else
      {
        AppMethodBeat.o(149601);
        return true;
      }
      AppMethodBeat.o(149601);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(149600);
      String str = this.dCB;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        str = this.hAT;
        if (str != null) {
          j = str.hashCode();
        }
        int k = this.dAJ;
        AppMethodBeat.o(149600);
        return (i * 31 + j) * 31 + k;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(149599);
      String str = "UpdateSubscribeStatusTask(bizUsername=" + this.dCB + ", templateId=" + this.hAT + ", uiStatus=" + this.dAJ + ")";
      AppMethodBeat.o(149599);
      return str;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/msgsubscription/storage/BaseSubscribeMsgService$doUpdateSubscribeUIStatus$1", "Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader$SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
  public static final class c
    implements e.b
  {
    c(a.b paramb) {}
    
    public final void a(String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(149602);
      p.h(paramString, "bizUsername");
      p.h(paramSubscribeMsgRequestResult, "result");
      a.a(this.iBl, paramSubscribeMsgRequestResult, paramb);
      AppMethodBeat.o(149602);
    }
    
    public final void i(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(149603);
      p.h(paramString, "errMsg");
      a.If(paramb.hAT);
      AppMethodBeat.o(149603);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/msgsubscription/storage/BaseSubscribeMsgService$isTemplateMsgSubscribed$1", "Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader$SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
  public static final class d
    implements e.b
  {
    public d(String paramString, y.f paramf) {}
    
    public final void a(String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(149604);
      p.h(paramString, "bizUsername");
      p.h(paramSubscribeMsgRequestResult, "result");
      paramSubscribeMsgRequestResult = paramSubscribeMsgRequestResult.iAc;
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
        } while (!this.iBn.equals(localSubscribeMsgTmpItem1.hAT));
        str = this.iBn;
        if (localSubscribeMsgTmpItem1.iAs != 1) {
          break label139;
        }
      }
      label139:
      for (boolean bool = true;; bool = false)
      {
        a.b(str, new IBrandSubscribeMsgService.c(bool, localSubscribeMsgTmpItem1.Vp));
        this.iBo.MLV = localSubscribeMsgTmpItem1;
        break label50;
        i = 0;
        break;
      }
      label145:
      paramSubscribeMsgRequestResult = this.iBl;
      SubscribeMsgTmpItem localSubscribeMsgTmpItem1 = (SubscribeMsgTmpItem)this.iBo.MLV;
      String str = this.iBn;
      SubscribeMsgTmpItem localSubscribeMsgTmpItem2 = (SubscribeMsgTmpItem)this.iBo.MLV;
      if (localSubscribeMsgTmpItem2 != null) {}
      for (int i = localSubscribeMsgTmpItem2.iAs;; i = -1)
      {
        a.a(paramSubscribeMsgRequestResult, localSubscribeMsgTmpItem1, new a.b(paramString, str, i));
        AppMethodBeat.o(149604);
        return;
      }
    }
    
    public final void i(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(149605);
      p.h(paramString, "errMsg");
      AppMethodBeat.o(149605);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "callback", "Lcom/tencent/mm/msgsubscription/storage/IBrandSubscribeMsgService$SubscribeStatusOpCallback;", "invoke"})
  static final class e
    extends q
    implements b<IBrandSubscribeMsgService.b, z>
  {
    public static final e iBp;
    
    static
    {
      AppMethodBeat.i(149607);
      iBp = new e();
      AppMethodBeat.o(149607);
    }
    
    e()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "callback", "Lcom/tencent/mm/msgsubscription/storage/IBrandSubscribeMsgService$SubscribeStatusOpCallback;", "invoke"})
  static final class f
    extends q
    implements b<IBrandSubscribeMsgService.b, z>
  {
    f(String paramString, IBrandSubscribeMsgService.c paramc)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/msgsubscription/storage/BaseSubscribeMsgService$switchSubscribeStatus$1", "Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader$SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
  public static final class g
    implements e.b
  {
    public g(SubscribeMsgTmpItem paramSubscribeMsgTmpItem, IBrandSubscribeMsgService.b paramb, String paramString) {}
    
    public final void a(String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(149609);
      p.h(paramString, "bizUsername");
      p.h(paramSubscribeMsgRequestResult, "result");
      ad.v("MicroMsg.BaseSubscribeMsgService", "alvinluo switchSubscribeStatus onSuccess bizUsername: %s, templateId: %s, settingStatus: %d", new Object[] { paramString, this.iBr.hAT, Integer.valueOf(this.iBr.iAs) });
      Object localObject1 = ((Iterable)paramSubscribeMsgRequestResult.iAc).iterator();
      boolean bool1 = false;
      boolean bool2 = false;
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (SubscribeMsgTmpItem)((Iterator)localObject1).next();
        if (this.iBr.hAT.equals(((SubscribeMsgTmpItem)localObject2).hAT))
        {
          bool1 = ((SubscribeMsgTmpItem)localObject2).Vp;
          bool2 = true;
        }
      }
      boolean bool3;
      if (bool2) {
        if (this.iBr.iAs == 1) {
          bool3 = true;
        }
      }
      for (localObject1 = new IBrandSubscribeMsgService.c(bool3, bool1);; localObject1 = new IBrandSubscribeMsgService.c(false, this.iBr.Vp))
      {
        ad.i("MicroMsg.BaseSubscribeMsgService", "alvinluo switchSubscribeStatus onSuccess hasResult: %b, isSubscribed: %b, switchOpen: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(((IBrandSubscribeMsgService.c)localObject1).iBM), Boolean.valueOf(((IBrandSubscribeMsgService.c)localObject1).iBN) });
        a.b(this.iBr.hAT, (IBrandSubscribeMsgService.c)localObject1);
        localObject2 = this.iBs;
        if (localObject2 != null) {
          ((IBrandSubscribeMsgService.b)localObject2).c(this.iBr.hAT, (IBrandSubscribeMsgService.c)localObject1);
        }
        IBrandSubscribeMsgService.a.a(this.iBl, paramString, (List)paramSubscribeMsgRequestResult.iAc);
        AppMethodBeat.o(149609);
        return;
        bool3 = false;
        break;
      }
    }
    
    public final void i(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(149610);
      p.h(paramString, "errMsg");
      if (this.iBr.iAs == 1) {}
      for (this.iBr.iAs = 0;; this.iBr.iAs = 1)
      {
        a.If(this.iBr.hAT);
        paramString = this.iBs;
        if (paramString != null) {
          paramString.onError();
        }
        IBrandSubscribeMsgService.a.a(this.iBl, this.hSL, j.mutableListOf(new SubscribeMsgTmpItem[] { this.iBr }));
        AppMethodBeat.o(149610);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.storage.a
 * JD-Core Version:    0.7.0.1
 */