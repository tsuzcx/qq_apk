package com.tencent.mm.msgsubscription.d;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgStorageManager;", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "()V", "MMKV_FILE_KEY_POSTFIX", "", "SubscribeMsgSaveExecutorTag", "TAG", "mTotalSwitchOpenMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "subscribeMsgTmpCacheMap", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "clearStorage", "", "doSaveSubscribeMsgList", "scene", "", "bizUsername", "subscribeMsgList", "", "subscribeSwitchOpened", "doSaveSubscribeStatus", "toSaveList", "switchOpen", "needUpdateSettingStatus", "needUpdateSwitchOpen", "needUpdateTimestamp", "getCacheKey", "templateId", "getMMKVKey", "getSubscribeMsgListWrapper", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$Companion$SubscribeMsgListWrapper;", "getSubscribeSwitchOpened", "getSubscribeTmpByTemplateId", "mergeSubscribeMsgList", "savedList", "processSubscribeMsgList", "runInMainUI", "task", "Lkotlin/Function0;", "saveSubscribeMsgList", "updateCache", "updateCacheList", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "cachedItem", "toUpdateItem", "updateSubscribeStatus", "switchOpened", "updateSubscribeStatusTimestamp", "updateSwitchOpen", "ParcelUtil", "plugin-comm_release"})
public final class c
  implements a
{
  private static final HashMap<String, SubscribeMsgTmpItem> jAD;
  private static HashMap<String, Boolean> jAE;
  public static final c jAF;
  
  static
  {
    AppMethodBeat.i(223365);
    jAF = new c();
    jAD = new HashMap();
    jAE = new HashMap();
    AppMethodBeat.o(223365);
  }
  
  private static List<SubscribeMsgTmpItem> a(int paramInt, List<SubscribeMsgTmpItem> paramList1, List<SubscribeMsgTmpItem> paramList2)
  {
    AppMethodBeat.i(223364);
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
            localSubscribeMsgTmpItem2.jyD = bool;
            if (!localSubscribeMsgTmpItem1.ixM.equals(localSubscribeMsgTmpItem2.ixM)) {
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
      if ((i != 0) || (localSubscribeMsgTmpItem1.jyD)) {
        break;
      }
      localList.add(localSubscribeMsgTmpItem1);
      break;
      localList.addAll((Collection)paramList2);
      AppMethodBeat.o(223364);
      return localList;
    }
  }
  
  private final void a(final String paramString, List<SubscribeMsgTmpItem> paramList, final boolean paramBoolean1, final boolean paramBoolean2, final boolean paramBoolean3, final boolean paramBoolean4)
  {
    AppMethodBeat.i(223359);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(biZ());
    Object localObject2 = RA(paramString);
    Object localObject1;
    List localList;
    label59:
    SubscribeMsgTmpItem localSubscribeMsgTmpItem1;
    int j;
    if (localObject2 != null)
    {
      localObject1 = ((ISubscribeMsgService.Companion.SubscribeMsgListWrapper)localObject2).jyV;
      localList = (List)new ArrayList();
      if (paramList == null) {
        break label229;
      }
      Iterator localIterator1 = ((Iterable)paramList).iterator();
      if (!localIterator1.hasNext()) {
        break label229;
      }
      localSubscribeMsgTmpItem1 = (SubscribeMsgTmpItem)localIterator1.next();
      j = 0;
      int i = 0;
      if (localObject1 == null) {
        break label211;
      }
      Iterator localIterator2 = ((Iterable)localObject1).iterator();
      label104:
      j = i;
      if (!localIterator2.hasNext()) {
        break label211;
      }
      SubscribeMsgTmpItem localSubscribeMsgTmpItem2 = (SubscribeMsgTmpItem)localIterator2.next();
      if (!localSubscribeMsgTmpItem2.ixM.equals(localSubscribeMsgTmpItem1.ixM)) {
        break label377;
      }
      if (paramBoolean2) {
        localSubscribeMsgTmpItem2.jyB = localSubscribeMsgTmpItem1.jyB;
      }
      if (paramBoolean4)
      {
        Log.i("MicroMsg.BrandSubscribeStorageManager", "alvinluo doSaveSubscribeStatus timestamp: %s", new Object[] { Long.valueOf(localSubscribeMsgTmpItem1.jyC) });
        localSubscribeMsgTmpItem2.jyC = localSubscribeMsgTmpItem1.jyC;
      }
      i = 1;
    }
    label211:
    label229:
    label377:
    for (;;)
    {
      break label104;
      localObject1 = null;
      break;
      if (j != 0) {
        break label59;
      }
      localList.add(localSubscribeMsgTmpItem1);
      break label59;
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
        localObject2 = c.a.jAG;
        localMultiProcessMMKV.putString(paramString, c.a.e((Parcelable)localObject1));
        q((kotlin.g.a.a)new b(paramList, paramString, paramBoolean2, paramBoolean4, paramBoolean3, paramBoolean1));
        AppMethodBeat.o(223359);
        return;
        if (localObject2 != null) {
          bool = ((ISubscribeMsgService.Companion.SubscribeMsgListWrapper)localObject2).jyW;
        } else {
          bool = false;
        }
      }
    }
  }
  
  private static void aa(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(223363);
    Log.i("MicroMsg.BrandSubscribeStorageManager", "alvinluo updateSwitchOpen: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ((Map)jAE).put(paramString, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(223363);
  }
  
  private static String bJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(223351);
    paramString1 = paramString1 + paramString2;
    AppMethodBeat.o(223351);
    return paramString1;
  }
  
  private static String biZ()
  {
    AppMethodBeat.i(223350);
    Object localObject = new StringBuilder();
    p.g(g.aAf(), "MMKernel.account()");
    localObject = com.tencent.mm.kernel.a.ayV() + "_subscribe_msg_storage";
    AppMethodBeat.o(223350);
    return localObject;
  }
  
  private static void e(String paramString, final List<SubscribeMsgTmpItem> paramList)
  {
    AppMethodBeat.i(223361);
    if (MMHandlerThread.isMainThread())
    {
      f(paramString, paramList);
      AppMethodBeat.o(223361);
      return;
    }
    MMHandlerThread.postToMainThread((Runnable)new e(paramString, paramList));
    AppMethodBeat.o(223361);
  }
  
  private static void f(String paramString, List<SubscribeMsgTmpItem> paramList)
  {
    AppMethodBeat.i(223362);
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)paramList.next();
      ((Map)jAD).put(bJ(paramString, localSubscribeMsgTmpItem.ixM), localSubscribeMsgTmpItem);
    }
    AppMethodBeat.o(223362);
  }
  
  private static void q(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(223360);
    if (MMHandlerThread.isMainThread())
    {
      parama.invoke();
      AppMethodBeat.o(223360);
      return;
    }
    h.RTc.aV((Runnable)new c.c(parama));
    AppMethodBeat.o(223360);
  }
  
  public final ISubscribeMsgService.Companion.SubscribeMsgListWrapper RA(String paramString)
  {
    AppMethodBeat.i(223355);
    p.h(paramString, "bizUsername");
    Log.v("MicroMsg.BrandSubscribeStorageManager", "alvinluo getSubscribeMsgListWrapper bizUsername: %s, hashCode: %s", new Object[] { paramString, Integer.valueOf(hashCode()) });
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(biZ());
    try
    {
      Object localObject1 = localMultiProcessMMKV.getString(paramString, null);
      if (localObject1 == null)
      {
        AppMethodBeat.o(223355);
        return null;
      }
      Object localObject2 = c.a.jAG;
      localObject2 = (Parcelable.Creator)ISubscribeMsgService.Companion.SubscribeMsgListWrapper.CREATOR;
      p.h(localObject1, "data");
      p.h(localObject2, "creator");
      localObject1 = c.a.RB((String)localObject1);
      localObject2 = ((Parcelable.Creator)localObject2).createFromParcel((Parcel)localObject1);
      ((Parcel)localObject1).recycle();
      localObject1 = (ISubscribeMsgService.Companion.SubscribeMsgListWrapper)localObject2;
      e(paramString, j.v((Collection)((ISubscribeMsgService.Companion.SubscribeMsgListWrapper)localObject1).jyV));
      aa(paramString, ((ISubscribeMsgService.Companion.SubscribeMsgListWrapper)localObject1).jyW);
      AppMethodBeat.o(223355);
      return localObject1;
    }
    catch (Exception localException)
    {
      localMultiProcessMMKV.putString(paramString, null);
      AppMethodBeat.o(223355);
    }
    return null;
  }
  
  public final boolean Rz(String paramString)
  {
    AppMethodBeat.i(223354);
    p.h(paramString, "bizUsername");
    paramString = (Boolean)jAE.get(paramString);
    if (paramString != null)
    {
      boolean bool = paramString.booleanValue();
      AppMethodBeat.o(223354);
      return bool;
    }
    AppMethodBeat.o(223354);
    return false;
  }
  
  public final void a(String paramString, final List<SubscribeMsgTmpItem> paramList, final boolean paramBoolean)
  {
    AppMethodBeat.i(223356);
    p.h(paramString, "bizUsername");
    p.h(paramList, "subscribeMsgList");
    h.RTc.b((Runnable)new d(paramString, paramList, paramBoolean), "SubscribeMsgSaveTag");
    AppMethodBeat.o(223356);
  }
  
  public final void b(String paramString, List<SubscribeMsgTmpItem> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(223357);
    p.h(paramString, "bizUsername");
    if (paramList != null) {}
    for (Integer localInteger = Integer.valueOf(paramList.size());; localInteger = null)
    {
      Log.i("MicroMsg.BrandSubscribeStorageManager", "alvinluo saveSubscribeMsgSubscribeStatus bizUsername: %s, size: %s, switchOpened: %b, needUpdateSwitchOpen: %b, needUpdateTimestamp: %b", new Object[] { paramString, localInteger, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3) });
      a(paramString, paramList, paramBoolean1, true, paramBoolean2, paramBoolean3);
      AppMethodBeat.o(223357);
      return;
    }
  }
  
  public final SubscribeMsgTmpItem bI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(223353);
    p.h(paramString1, "bizUsername");
    p.h(paramString2, "templateId");
    paramString1 = (SubscribeMsgTmpItem)jAD.get(bJ(paramString1, paramString2));
    AppMethodBeat.o(223353);
    return paramString1;
  }
  
  public final void biY()
  {
    AppMethodBeat.i(223352);
    Log.i("MicroMsg.BrandSubscribeStorageManager", "alvinluo SubscribeMsg clearStorage");
    MultiProcessMMKV.getMMKV(biZ()).clear();
    AppMethodBeat.o(223352);
  }
  
  public final void d(String paramString, List<SubscribeMsgTmpItem> paramList)
  {
    AppMethodBeat.i(223358);
    p.h(paramString, "bizUsername");
    p.h(paramList, "subscribeMsgList");
    Log.i("MicroMsg.BrandSubscribeStorageManager", "alvinluo updateSubscribeMsgUiStatusTimestamp bizUsername: %s, size: %s", new Object[] { paramString, Integer.valueOf(paramList.size()) });
    a(paramString, paramList, false, false, false, true);
    AppMethodBeat.o(223358);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(List paramList, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    {
      super();
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "cachedItem", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "toUpdateItem", "invoke", "com/tencent/mm/msgsubscription/storage/SubscribeMsgStorageManager$doSaveSubscribeStatus$2$1$1"})
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(String paramString, List paramList, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(223348);
      c.a(c.jAF, this.$scene, this.jzO, paramList, paramBoolean);
      AppMethodBeat.o(223348);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(String paramString, List paramList) {}
    
    public final void run()
    {
      AppMethodBeat.i(223349);
      c localc = c.jAF;
      c.g(this.jzO, paramList);
      AppMethodBeat.o(223349);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.d.c
 * JD-Core Version:    0.7.0.1
 */