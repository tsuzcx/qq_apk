package com.tencent.mm.msgsubscription.storage;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.c.d;
import com.tencent.mm.sdk.platformtools.ac;
import d.a.j;
import d.g.a.b;
import d.g.b.k;
import d.g.b.v.f;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/msgsubscription/storage/BaseSubscribeMsgService;", "Lcom/tencent/mm/msgsubscription/storage/IBrandSubscribeMsgService;", "()V", "dataLoader", "Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader;", "updatingTaskIdSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "callbackWrapper", "", "templateId", "action", "Lkotlin/Function1;", "Lcom/tencent/mm/msgsubscription/storage/IBrandSubscribeMsgService$SubscribeStatusOpCallback;", "Lkotlin/ParameterName;", "name", "callback", "clickSubscribeMsgSpan", "context", "Landroid/content/Context;", "bizUsername", "url", "extra", "Landroid/os/Bundle;", "doUpdateSubscribeUIStatus", "updateTask", "Lcom/tencent/mm/msgsubscription/storage/BaseSubscribeMsgService$UpdateSubscribeStatusTask;", "goToSettingManagerUI", "nickname", "isTemplateMsgSubscribed", "onErrorWrapper", "onUpdateSubscribeUIStatusSuccess", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "onUpdatedWrapper", "Lcom/tencent/mm/msgsubscription/storage/IBrandSubscribeMsgService$SubscribeStatusResult;", "saveSubscribeMsgUiStatus", "subscribeMsgList", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "switchOpened", "", "needUpdateSwitch", "needUpdateTimestamp", "switchSubscribeStatus", "tmpItem", "updateLocalSwitchOpened", "updateSubscribeUIStatus", "updateSubscribeUIStatusIfNecessary", "subscribeMsgTmpItem", "Companion", "UpdateSubscribeStatusTask", "plugin-comm_release"})
public abstract class a
  implements IBrandSubscribeMsgService
{
  private static final HashMap<String, HashMap<String, IBrandSubscribeMsgService.b>> ihP = new HashMap();
  public static final a ihQ = new a((byte)0);
  private final HashSet<String> ihN = new HashSet();
  public final e ihO = new e(aLj());
  
  public static void a(String paramString, final IBrandSubscribeMsgService.c paramc)
  {
    ac.i("MicroMsg.BaseSubscribeMsgService", "alvinluo onUpdatedWrapper templateId: %s, isSubscribed: %b, switchOpen: %b", new Object[] { paramString, Boolean.valueOf(paramc.iis), Boolean.valueOf(paramc.iit) });
    b(paramString, (b)new f(paramString, paramc));
  }
  
  private static void b(String paramString, b<? super IBrandSubscribeMsgService.b, y> paramb)
  {
    Integer localInteger = null;
    HashMap localHashMap = (HashMap)ihP.get(paramString);
    if (localHashMap != null) {}
    for (Set localSet = localHashMap.keySet();; localSet = null)
    {
      if (localSet != null) {
        localInteger = Integer.valueOf(localSet.size());
      }
      ac.i("MicroMsg.BaseSubscribeMsgService", "alvinluo callbackWrapper templateId: %s, callback size: %s", new Object[] { paramString, localInteger });
      if (localSet == null) {
        break;
      }
      paramString = ((Iterable)localSet).iterator();
      while (paramString.hasNext()) {
        paramb.ay(localHashMap.get((String)paramString.next()));
      }
    }
  }
  
  public final void Z(String paramString, boolean paramBoolean)
  {
    k.h(paramString, "bizUsername");
    ac.i("MicroMsg.BaseSubscribeMsgService", "alvinluo updateLocalSwitchOpened bizUsername: %s, switchOpened: %b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    e locale = this.ihO;
    k.h(paramString, "username");
    locale.b(paramString, (List)new ArrayList(), paramBoolean, true, false);
  }
  
  public final void a(SubscribeMsgTmpItem paramSubscribeMsgTmpItem, final b paramb)
  {
    Object localObject = c.iin;
    if (c.b(paramSubscribeMsgTmpItem))
    {
      if (this.ihN.contains(paramb.hiK))
      {
        ac.i("MicroMsg.BaseSubscribeMsgService", "alvinluo updateSubscribeUIStatus templateId: %s is updating", new Object[] { paramb.hiK });
        return;
      }
      this.ihN.add(paramb.hiK);
      ac.i("MicroMsg.BaseSubscribeMsgService", "alvinluo doUpdateSubscribeUIStatus templateId: %s, bizUsername: %s", new Object[] { paramb.hiK, paramb.dqK });
      paramSubscribeMsgTmpItem = this.ihO;
      localObject = paramb.dqK;
      List localList = j.mutableListOf(new String[] { paramb.hiK });
      paramb = (e.b)new c(this, paramb);
      k.h(localObject, "username");
      k.h(localList, "templateIdList");
      ac.i("Mp.SubscribeMsgDataLoader", "alvinluo getSubscribeUIStatus username: %s, template size: %d", new Object[] { localObject, Integer.valueOf(localList.size()) });
      g localg = g.iiz;
      g.a(paramSubscribeMsgTmpItem.iiu, (com.tencent.mm.msgsubscription.c.a)new d((String)localObject, localList, paramSubscribeMsgTmpItem.iiu, paramb));
      return;
    }
    ac.v("MicroMsg.BaseSubscribeMsgService", "alvinluo updateSubscribeUIStatus no need to update");
  }
  
  public final void a(String paramString, List<SubscribeMsgTmpItem> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    k.h(paramString, "bizUsername");
    k.h(paramList, "subscribeMsgList");
    this.ihO.b(paramString, paramList, paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  public void k(Context paramContext, String paramString1, String paramString2)
  {
    k.h(paramContext, "context");
    k.h(paramString1, "bizUsername");
    k.h(paramString2, "nickname");
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/msgsubscription/storage/BaseSubscribeMsgService$Companion;", "", "()V", "DEFAULT_MAX_CACHE_AGE_FOR_TEST_IN_SEC", "", "DEFAULT_MAX_CACHE_AGE_IN_SEC", "TAG", "", "notifyCallbackList", "Ljava/util/HashMap;", "Lcom/tencent/mm/msgsubscription/storage/IBrandSubscribeMsgService$SubscribeStatusOpCallback;", "Lkotlin/collections/HashMap;", "clearNotifyCallback", "", "registerNotifyCallback", "templateId", "viewKey", "callback", "unregisterNotifyCallback", "plugin-comm_release"})
  public static final class a {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/msgsubscription/storage/BaseSubscribeMsgService$UpdateSubscribeStatusTask;", "", "bizUsername", "", "templateId", "uiStatus", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getBizUsername", "()Ljava/lang/String;", "getTemplateId", "getUiStatus", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-comm_release"})
  public static final class b
  {
    private final int doV;
    final String dqK;
    final String hiK;
    
    public b(String paramString1, String paramString2, int paramInt)
    {
      AppMethodBeat.i(149598);
      this.dqK = paramString1;
      this.hiK = paramString2;
      this.doV = paramInt;
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
          if ((!k.g(this.dqK, paramObject.dqK)) || (!k.g(this.hiK, paramObject.hiK)) || (this.doV != paramObject.doV)) {}
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
      String str = this.dqK;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        str = this.hiK;
        if (str != null) {
          j = str.hashCode();
        }
        int k = this.doV;
        AppMethodBeat.o(149600);
        return (i * 31 + j) * 31 + k;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(149599);
      String str = "UpdateSubscribeStatusTask(bizUsername=" + this.dqK + ", templateId=" + this.hiK + ", uiStatus=" + this.doV + ")";
      AppMethodBeat.o(149599);
      return str;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/msgsubscription/storage/BaseSubscribeMsgService$doUpdateSubscribeUIStatus$1", "Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader$SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
  public static final class c
    implements e.b
  {
    c(a.b paramb) {}
    
    public final void a(String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(149602);
      k.h(paramString, "bizUsername");
      k.h(paramSubscribeMsgRequestResult, "result");
      a.a(this.ihR, paramSubscribeMsgRequestResult, paramb);
      AppMethodBeat.o(149602);
    }
    
    public final void i(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(149603);
      k.h(paramString, "errMsg");
      a.ER(paramb.hiK);
      AppMethodBeat.o(149603);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/msgsubscription/storage/BaseSubscribeMsgService$isTemplateMsgSubscribed$1", "Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader$SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
  public static final class d
    implements e.b
  {
    public d(String paramString, v.f paramf) {}
    
    public final void a(String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(149604);
      k.h(paramString, "bizUsername");
      k.h(paramSubscribeMsgRequestResult, "result");
      paramSubscribeMsgRequestResult = paramSubscribeMsgRequestResult.igI;
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
        } while (!this.ihT.equals(localSubscribeMsgTmpItem1.hiK));
        str = this.ihT;
        if (localSubscribeMsgTmpItem1.igY != 1) {
          break label139;
        }
      }
      label139:
      for (boolean bool = true;; bool = false)
      {
        a.b(str, new IBrandSubscribeMsgService.c(bool, localSubscribeMsgTmpItem1.Tz));
        this.ihU.KUQ = localSubscribeMsgTmpItem1;
        break label50;
        i = 0;
        break;
      }
      label145:
      paramSubscribeMsgRequestResult = this.ihR;
      SubscribeMsgTmpItem localSubscribeMsgTmpItem1 = (SubscribeMsgTmpItem)this.ihU.KUQ;
      String str = this.ihT;
      SubscribeMsgTmpItem localSubscribeMsgTmpItem2 = (SubscribeMsgTmpItem)this.ihU.KUQ;
      if (localSubscribeMsgTmpItem2 != null) {}
      for (int i = localSubscribeMsgTmpItem2.igY;; i = -1)
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "callback", "Lcom/tencent/mm/msgsubscription/storage/IBrandSubscribeMsgService$SubscribeStatusOpCallback;", "invoke"})
  static final class e
    extends d.g.b.l
    implements b<IBrandSubscribeMsgService.b, y>
  {
    public static final e ihV;
    
    static
    {
      AppMethodBeat.i(149607);
      ihV = new e();
      AppMethodBeat.o(149607);
    }
    
    e()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "callback", "Lcom/tencent/mm/msgsubscription/storage/IBrandSubscribeMsgService$SubscribeStatusOpCallback;", "invoke"})
  static final class f
    extends d.g.b.l
    implements b<IBrandSubscribeMsgService.b, y>
  {
    f(String paramString, IBrandSubscribeMsgService.c paramc)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/msgsubscription/storage/BaseSubscribeMsgService$switchSubscribeStatus$1", "Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader$SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
  public static final class g
    implements e.b
  {
    public g(SubscribeMsgTmpItem paramSubscribeMsgTmpItem, IBrandSubscribeMsgService.b paramb, String paramString) {}
    
    public final void a(String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(149609);
      k.h(paramString, "bizUsername");
      k.h(paramSubscribeMsgRequestResult, "result");
      ac.v("MicroMsg.BaseSubscribeMsgService", "alvinluo switchSubscribeStatus onSuccess bizUsername: %s, templateId: %s, settingStatus: %d", new Object[] { paramString, this.ihX.hiK, Integer.valueOf(this.ihX.igY) });
      Object localObject1 = ((Iterable)paramSubscribeMsgRequestResult.igI).iterator();
      boolean bool1 = false;
      boolean bool2 = false;
      Object localObject2;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (SubscribeMsgTmpItem)((Iterator)localObject1).next();
        if (!this.ihX.hiK.equals(((SubscribeMsgTmpItem)localObject2).hiK)) {
          break label284;
        }
        bool1 = ((SubscribeMsgTmpItem)localObject2).Tz;
        bool2 = true;
      }
      label284:
      for (;;)
      {
        break;
        boolean bool3;
        if (bool2) {
          if (this.ihX.igY == 1) {
            bool3 = true;
          }
        }
        for (localObject1 = new IBrandSubscribeMsgService.c(bool3, bool1);; localObject1 = new IBrandSubscribeMsgService.c(false, this.ihX.Tz))
        {
          ac.i("MicroMsg.BaseSubscribeMsgService", "alvinluo switchSubscribeStatus onSuccess hasResult: %b, isSubscribed: %b, switchOpen: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(((IBrandSubscribeMsgService.c)localObject1).iis), Boolean.valueOf(((IBrandSubscribeMsgService.c)localObject1).iit) });
          a.b(this.ihX.hiK, (IBrandSubscribeMsgService.c)localObject1);
          localObject2 = this.ihY;
          if (localObject2 != null) {
            ((IBrandSubscribeMsgService.b)localObject2).c(this.ihX.hiK, (IBrandSubscribeMsgService.c)localObject1);
          }
          IBrandSubscribeMsgService.a.a(this.ihR, paramString, (List)paramSubscribeMsgRequestResult.igI);
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
      if (this.ihX.igY == 1) {}
      for (this.ihX.igY = 0;; this.ihX.igY = 1)
      {
        a.ER(this.ihX.hiK);
        paramString = this.ihY;
        if (paramString != null) {
          paramString.onError();
        }
        IBrandSubscribeMsgService.a.a(this.ihR, this.hAq, j.mutableListOf(new SubscribeMsgTmpItem[] { this.ihX }));
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