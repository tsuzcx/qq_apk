package com.tencent.mm.msgsubscription.d;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService.Companion.SubscribeMsgListWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgStorageManager;", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "()V", "MMKV_FILE_KEY_POSTFIX", "", "SubscribeMsgSaveExecutorTag", "TAG", "mTotalSwitchOpenMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "subscribeMsgTmpCacheMap", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "clearStorage", "", "doSaveSubscribeMsgList", "scene", "", "bizUsername", "subscribeMsgList", "", "subscribeSwitchOpened", "doSaveSubscribeStatus", "toSaveList", "switchOpen", "needUpdateSettingStatus", "needUpdateSwitchOpen", "needUpdateTimestamp", "getCacheKey", "templateId", "getMMKVKey", "getSubscribeMsgListWrapper", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$Companion$SubscribeMsgListWrapper;", "getSubscribeSwitchOpened", "getSubscribeTmpByTemplateId", "mergeSubscribeMsgList", "savedList", "processSubscribeMsgList", "runInMainUI", "task", "Lkotlin/Function0;", "saveSubscribeMsgList", "updateCache", "updateCacheList", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "cachedItem", "toUpdateItem", "updateSubscribeStatus", "switchOpened", "updateSubscribeStatusTimestamp", "updateSwitchOpen", "ParcelUtil", "plugin-comm_release"})
public final class c
  implements a
{
  private static final HashMap<String, SubscribeMsgTmpItem> mql;
  private static HashMap<String, Boolean> mqm;
  public static final c mqn;
  
  static
  {
    AppMethodBeat.i(243943);
    mqn = new c();
    mql = new HashMap();
    mqm = new HashMap();
    AppMethodBeat.o(243943);
  }
  
  private static List<SubscribeMsgTmpItem> a(int paramInt, List<SubscribeMsgTmpItem> paramList1, List<SubscribeMsgTmpItem> paramList2)
  {
    AppMethodBeat.i(243940);
    List localList = (List)new ArrayList();
    SubscribeMsgTmpItem localSubscribeMsgTmpItem1;
    int i;
    label64:
    boolean bool;
    if (paramList1 != null)
    {
      paramList1 = ((Iterable)paramList1).iterator();
      if (paramList1.hasNext())
      {
        localSubscribeMsgTmpItem1 = (SubscribeMsgTmpItem)paramList1.next();
        Iterator localIterator = ((Iterable)paramList2).iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          SubscribeMsgTmpItem localSubscribeMsgTmpItem2 = (SubscribeMsgTmpItem)localIterator.next();
          if (paramInt == 1)
          {
            bool = true;
            label94:
            localSubscribeMsgTmpItem2.moh = bool;
            if (!localSubscribeMsgTmpItem1.lnb.equals(localSubscribeMsgTmpItem2.lnb)) {
              break label173;
            }
            i = 1;
          }
        }
      }
    }
    label173:
    for (;;)
    {
      break label64;
      bool = false;
      break label94;
      if ((i != 0) || (localSubscribeMsgTmpItem1.moh)) {
        break;
      }
      localList.add(localSubscribeMsgTmpItem1);
      break;
      localList.addAll((Collection)paramList2);
      AppMethodBeat.o(243940);
      return localList;
    }
  }
  
  private final void a(final String paramString, List<SubscribeMsgTmpItem> paramList, final boolean paramBoolean1, final boolean paramBoolean2, final boolean paramBoolean3, final boolean paramBoolean4)
  {
    AppMethodBeat.i(243931);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(bsy());
    Object localObject2 = YZ(paramString);
    Object localObject1;
    List localList;
    label59:
    SubscribeMsgTmpItem localSubscribeMsgTmpItem1;
    int j;
    if (localObject2 != null)
    {
      localObject1 = ((ISubscribeMsgService.Companion.SubscribeMsgListWrapper)localObject2).moB;
      localList = (List)new ArrayList();
      if (paramList == null) {
        break label239;
      }
      Iterator localIterator1 = ((Iterable)paramList).iterator();
      if (!localIterator1.hasNext()) {
        break label239;
      }
      localSubscribeMsgTmpItem1 = (SubscribeMsgTmpItem)localIterator1.next();
      j = 0;
      int i = 0;
      if (localObject1 == null) {
        break label221;
      }
      Iterator localIterator2 = ((Iterable)localObject1).iterator();
      label104:
      j = i;
      if (!localIterator2.hasNext()) {
        break label221;
      }
      SubscribeMsgTmpItem localSubscribeMsgTmpItem2 = (SubscribeMsgTmpItem)localIterator2.next();
      if (!localSubscribeMsgTmpItem2.lnb.equals(localSubscribeMsgTmpItem1.lnb)) {
        break label387;
      }
      if (paramBoolean2) {
        localSubscribeMsgTmpItem2.mof = localSubscribeMsgTmpItem1.mof;
      }
      if (paramBoolean4)
      {
        Log.i("MicroMsg.BrandSubscribeStorageManager", "alvinluo doSaveSubscribeStatus timestamp: %s", new Object[] { Long.valueOf(localSubscribeMsgTmpItem1.mog) });
        localSubscribeMsgTmpItem2.mog = localSubscribeMsgTmpItem1.mog;
      }
      localSubscribeMsgTmpItem2.mnH = localSubscribeMsgTmpItem1.mnH;
      i = 1;
    }
    label387:
    for (;;)
    {
      break label104;
      localObject1 = null;
      break;
      label221:
      if (j != 0) {
        break label59;
      }
      localList.add(localSubscribeMsgTmpItem1);
      break label59;
      label239:
      if (localObject1 != null) {
        localList.addAll((Collection)localObject1);
      }
      Log.i("MicroMsg.BrandSubscribeStorageManager", "alvinluo saveSubscribeMsgUiStatus finalList: %d, switchOpen: %b, needUpateSwitchOpen: %b", new Object[] { Integer.valueOf(localList.size()), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean3) });
      boolean bool;
      if (paramBoolean3) {
        bool = paramBoolean1;
      }
      for (;;)
      {
        localObject1 = new ISubscribeMsgService.Companion.SubscribeMsgListWrapper(localList, bool);
        localObject2 = c.a.mqo;
        localMultiProcessMMKV.putString(paramString, c.a.d((Parcelable)localObject1));
        p((kotlin.g.a.a)new b(paramList, paramString, paramBoolean2, paramBoolean4, paramBoolean3, paramBoolean1));
        AppMethodBeat.o(243931);
        return;
        if (localObject2 != null) {
          bool = ((ISubscribeMsgService.Companion.SubscribeMsgListWrapper)localObject2).moC;
        } else {
          bool = false;
        }
      }
    }
  }
  
  private static void ad(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(243938);
    Log.i("MicroMsg.BrandSubscribeStorageManager", "alvinluo updateSwitchOpen: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ((Map)mqm).put(paramString, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(243938);
  }
  
  private static String bM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(243916);
    paramString1 = paramString1 + paramString2;
    AppMethodBeat.o(243916);
    return paramString1;
  }
  
  private static String bsy()
  {
    AppMethodBeat.i(243914);
    Object localObject = new StringBuilder();
    p.j(com.tencent.mm.kernel.h.aHE(), "MMKernel.account()");
    localObject = b.aGq() + "_subscribe_msg_storage";
    AppMethodBeat.o(243914);
    return localObject;
  }
  
  private static void e(String paramString, final List<SubscribeMsgTmpItem> paramList)
  {
    AppMethodBeat.i(243935);
    if (MMHandlerThread.isMainThread())
    {
      f(paramString, paramList);
      AppMethodBeat.o(243935);
      return;
    }
    MMHandlerThread.postToMainThread((Runnable)new e(paramString, paramList));
    AppMethodBeat.o(243935);
  }
  
  private static void f(String paramString, List<SubscribeMsgTmpItem> paramList)
  {
    AppMethodBeat.i(243936);
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)paramList.next();
      ((Map)mql).put(bM(paramString, localSubscribeMsgTmpItem.lnb), localSubscribeMsgTmpItem);
    }
    AppMethodBeat.o(243936);
  }
  
  private static void p(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(243933);
    if (MMHandlerThread.isMainThread())
    {
      parama.invoke();
      AppMethodBeat.o(243933);
      return;
    }
    com.tencent.e.h.ZvG.bc((Runnable)new c.c(parama));
    AppMethodBeat.o(243933);
  }
  
  public final boolean YY(String paramString)
  {
    AppMethodBeat.i(243921);
    p.k(paramString, "bizUsername");
    paramString = (Boolean)mqm.get(paramString);
    if (paramString != null)
    {
      boolean bool = paramString.booleanValue();
      AppMethodBeat.o(243921);
      return bool;
    }
    AppMethodBeat.o(243921);
    return false;
  }
  
  public final ISubscribeMsgService.Companion.SubscribeMsgListWrapper YZ(String paramString)
  {
    AppMethodBeat.i(243923);
    p.k(paramString, "bizUsername");
    Log.v("MicroMsg.BrandSubscribeStorageManager", "alvinluo getSubscribeMsgListWrapper bizUsername: %s, hashCode: %s", new Object[] { paramString, Integer.valueOf(hashCode()) });
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(bsy());
    try
    {
      Object localObject1 = localMultiProcessMMKV.getString(paramString, null);
      if (localObject1 == null)
      {
        AppMethodBeat.o(243923);
        return null;
      }
      Object localObject2 = c.a.mqo;
      localObject2 = (Parcelable.Creator)ISubscribeMsgService.Companion.SubscribeMsgListWrapper.CREATOR;
      p.k(localObject1, "data");
      p.k(localObject2, "creator");
      localObject1 = c.a.Za((String)localObject1);
      localObject2 = ((Parcelable.Creator)localObject2).createFromParcel((Parcel)localObject1);
      ((Parcel)localObject1).recycle();
      localObject1 = (ISubscribeMsgService.Companion.SubscribeMsgListWrapper)localObject2;
      e(paramString, j.t((Collection)((ISubscribeMsgService.Companion.SubscribeMsgListWrapper)localObject1).moB));
      ad(paramString, ((ISubscribeMsgService.Companion.SubscribeMsgListWrapper)localObject1).moC);
      AppMethodBeat.o(243923);
      return localObject1;
    }
    catch (Exception localException)
    {
      localMultiProcessMMKV.putString(paramString, null);
      AppMethodBeat.o(243923);
    }
    return null;
  }
  
  public final void a(String paramString, final List<SubscribeMsgTmpItem> paramList, final boolean paramBoolean)
  {
    AppMethodBeat.i(243924);
    p.k(paramString, "bizUsername");
    p.k(paramList, "subscribeMsgList");
    com.tencent.e.h.ZvG.d((Runnable)new d(paramString, paramList, paramBoolean), "SubscribeMsgSaveTag");
    AppMethodBeat.o(243924);
  }
  
  public final void b(String paramString, List<SubscribeMsgTmpItem> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(243926);
    p.k(paramString, "bizUsername");
    if (paramList != null) {}
    for (Integer localInteger = Integer.valueOf(paramList.size());; localInteger = null)
    {
      Log.i("MicroMsg.BrandSubscribeStorageManager", "alvinluo saveSubscribeMsgSubscribeStatus bizUsername: %s, size: %s, switchOpened: %b, needUpdateSwitchOpen: %b, needUpdateTimestamp: %b", new Object[] { paramString, localInteger, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3) });
      a(paramString, paramList, paramBoolean1, true, paramBoolean2, paramBoolean3);
      AppMethodBeat.o(243926);
      return;
    }
  }
  
  public final SubscribeMsgTmpItem bL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(243920);
    p.k(paramString1, "bizUsername");
    p.k(paramString2, "templateId");
    paramString1 = (SubscribeMsgTmpItem)mql.get(bM(paramString1, paramString2));
    AppMethodBeat.o(243920);
    return paramString1;
  }
  
  public final void bsx()
  {
    AppMethodBeat.i(243917);
    Log.i("MicroMsg.BrandSubscribeStorageManager", "alvinluo SubscribeMsg clearStorage");
    MultiProcessMMKV.getMMKV(bsy()).clear();
    AppMethodBeat.o(243917);
  }
  
  public final void d(String paramString, List<SubscribeMsgTmpItem> paramList)
  {
    AppMethodBeat.i(243928);
    p.k(paramString, "bizUsername");
    p.k(paramList, "subscribeMsgList");
    Log.i("MicroMsg.BrandSubscribeStorageManager", "alvinluo updateSubscribeMsgUiStatusTimestamp bizUsername: %s, size: %s", new Object[] { paramString, Integer.valueOf(paramList.size()) });
    a(paramString, paramList, false, false, false, true);
    AppMethodBeat.o(243928);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(List paramList, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    {
      super();
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "cachedItem", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "toUpdateItem", "invoke", "com/tencent/mm/msgsubscription/storage/SubscribeMsgStorageManager$doSaveSubscribeStatus$2$1$1"})
    static final class a
      extends q
      implements m<SubscribeMsgTmpItem, SubscribeMsgTmpItem, x>
    {
      a(c.b paramb)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(String paramString, List paramList, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(197408);
      c.a(c.mqn, this.$scene, this.mpu, paramList, paramBoolean);
      AppMethodBeat.o(197408);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(String paramString, List paramList) {}
    
    public final void run()
    {
      AppMethodBeat.i(226314);
      c localc = c.mqn;
      c.g(this.mpu, paramList);
      AppMethodBeat.o(226314);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.d.c
 * JD-Core Version:    0.7.0.1
 */