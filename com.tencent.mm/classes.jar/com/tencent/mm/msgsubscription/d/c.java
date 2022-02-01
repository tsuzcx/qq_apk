package com.tencent.mm.msgsubscription.d;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService.Companion.SubscribeMsgListWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgStorageManager;", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "()V", "MMKV_FILE_KEY_POSTFIX", "", "SubscribeMsgSaveExecutorTag", "TAG", "mTotalSwitchOpenMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "subscribeMsgTmpCacheMap", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "clearStorage", "", "doSaveSubscribeMsgList", "scene", "", "bizUsername", "subscribeMsgList", "", "subscribeSwitchOpened", "doSaveSubscribeStatus", "toSaveList", "switchOpen", "needUpdateSettingStatus", "needUpdateSwitchOpen", "needUpdateTimestamp", "getCacheKey", "templateId", "getMMKVKey", "getSubscribeMsgListWrapper", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$Companion$SubscribeMsgListWrapper;", "getSubscribeSwitchOpened", "getSubscribeTmpByTemplateId", "mergeSubscribeMsgList", "savedList", "processSubscribeMsgList", "runInMainUI", "task", "Lkotlin/Function0;", "saveSubscribeMsgList", "updateCache", "updateCacheList", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "cachedItem", "toUpdateItem", "updateSubscribeStatus", "switchOpened", "updateSubscribeStatusTimestamp", "updateSwitchOpen", "ParcelUtil", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements a
{
  public static final c pjX;
  private static final HashMap<String, SubscribeMsgTmpItem> pjY;
  private static HashMap<String, Boolean> pjZ;
  
  static
  {
    AppMethodBeat.i(236323);
    pjX = new c();
    pjY = new HashMap();
    pjZ = new HashMap();
    AppMethodBeat.o(236323);
  }
  
  private static List<SubscribeMsgTmpItem> a(int paramInt, List<SubscribeMsgTmpItem> paramList1, List<SubscribeMsgTmpItem> paramList2)
  {
    AppMethodBeat.i(236299);
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
            localSubscribeMsgTmpItem2.phV = bool;
            if (!localSubscribeMsgTmpItem1.nSg.equals(localSubscribeMsgTmpItem2.nSg)) {
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
      if ((i != 0) || (localSubscribeMsgTmpItem1.phV)) {
        break;
      }
      localList.add(localSubscribeMsgTmpItem1);
      break;
      localList.addAll((Collection)paramList2);
      AppMethodBeat.o(236299);
      return localList;
    }
  }
  
  private static final void a(int paramInt, String paramString, List paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(236304);
    s.u(paramString, "$bizUsername");
    s.u(paramList, "$subscribeMsgList");
    Object localObject3 = pjX;
    Log.i("MicroMsg.BrandSubscribeStorageManager", "alvinluo saveSubscribeMsgList bizUsername: %s, scene: %d, size: %d, isOpened: %b", new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(paramList.size()), Boolean.valueOf(paramBoolean) });
    if (paramInt == 1)
    {
      localObject1 = ((Iterable)paramList).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((SubscribeMsgTmpItem)((Iterator)localObject1).next()).phV = true;
      }
    }
    Object localObject1 = MultiProcessMMKV.getMMKV(bQe());
    Object localObject2 = (List)new ArrayList();
    ((List)localObject2).addAll((Collection)paramList);
    paramList = ((c)localObject3).Re(paramString);
    if (paramList == null) {}
    for (paramList = null;; paramList = paramList.pis)
    {
      paramList = a(paramInt, paramList, (List)localObject2);
      localObject2 = new ISubscribeMsgService.Companion.SubscribeMsgListWrapper(paramList, paramBoolean);
      localObject3 = a.pka;
      ((MultiProcessMMKV)localObject1).putString(paramString, a.d((Parcelable)localObject2));
      g(paramString, paramList);
      ah(paramString, paramBoolean);
      AppMethodBeat.o(236304);
      return;
    }
  }
  
  private final void a(final String paramString, List<SubscribeMsgTmpItem> paramList, final boolean paramBoolean1, final boolean paramBoolean2, final boolean paramBoolean3, final boolean paramBoolean4)
  {
    AppMethodBeat.i(236276);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(bQe());
    Object localObject2 = Re(paramString);
    Object localObject1;
    List localList;
    label56:
    SubscribeMsgTmpItem localSubscribeMsgTmpItem1;
    int j;
    if (localObject2 == null)
    {
      localObject1 = null;
      localList = (List)new ArrayList();
      if (paramList == null) {
        break label240;
      }
      Iterator localIterator1 = ((Iterable)paramList).iterator();
      if (!localIterator1.hasNext()) {
        break label240;
      }
      localSubscribeMsgTmpItem1 = (SubscribeMsgTmpItem)localIterator1.next();
      j = 0;
      int i = 0;
      if (localObject1 == null) {
        break label222;
      }
      Iterator localIterator2 = ((Iterable)localObject1).iterator();
      label101:
      j = i;
      if (!localIterator2.hasNext()) {
        break label222;
      }
      SubscribeMsgTmpItem localSubscribeMsgTmpItem2 = (SubscribeMsgTmpItem)localIterator2.next();
      if (!localSubscribeMsgTmpItem2.nSg.equals(localSubscribeMsgTmpItem1.nSg)) {
        break label389;
      }
      if (paramBoolean2) {
        localSubscribeMsgTmpItem2.phT = localSubscribeMsgTmpItem1.phT;
      }
      if (paramBoolean4)
      {
        Log.i("MicroMsg.BrandSubscribeStorageManager", "alvinluo doSaveSubscribeStatus timestamp: %s", new Object[] { Long.valueOf(localSubscribeMsgTmpItem1.phU) });
        localSubscribeMsgTmpItem2.phU = localSubscribeMsgTmpItem1.phU;
      }
      localSubscribeMsgTmpItem2.phu = localSubscribeMsgTmpItem1.phu;
      i = 1;
    }
    label389:
    for (;;)
    {
      break label101;
      localObject1 = ((ISubscribeMsgService.Companion.SubscribeMsgListWrapper)localObject2).pis;
      break;
      label222:
      if (j != 0) {
        break label56;
      }
      localList.add(localSubscribeMsgTmpItem1);
      break label56;
      label240:
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
        localObject2 = a.pka;
        localMultiProcessMMKV.putString(paramString, a.d((Parcelable)localObject1));
        ae((kotlin.g.a.a)new b(paramList, paramBoolean3, paramString, paramBoolean1, paramBoolean2, paramBoolean4));
        AppMethodBeat.o(236276);
        return;
        if (localObject2 == null) {
          bool = false;
        } else {
          bool = ((ISubscribeMsgService.Companion.SubscribeMsgListWrapper)localObject2).pit;
        }
      }
    }
  }
  
  private static void ae(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(236281);
    if (MMHandlerThread.isMainThread())
    {
      parama.invoke();
      AppMethodBeat.o(236281);
      return;
    }
    com.tencent.threadpool.h.ahAA.bk(new c..ExternalSyntheticLambda2(parama));
    AppMethodBeat.o(236281);
  }
  
  private static final void af(kotlin.g.a.a parama)
  {
    AppMethodBeat.i(236305);
    s.u(parama, "$task");
    parama.invoke();
    AppMethodBeat.o(236305);
  }
  
  private static void ah(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(236294);
    Log.i("MicroMsg.BrandSubscribeStorageManager", "alvinluo updateSwitchOpen: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ((Map)pjZ).put(paramString, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(236294);
  }
  
  private static String bQe()
  {
    AppMethodBeat.i(236269);
    com.tencent.mm.kernel.h.baC();
    String str = s.X(b.aZs(), "_subscribe_msg_storage");
    AppMethodBeat.o(236269);
    return str;
  }
  
  private static void g(String paramString, List<SubscribeMsgTmpItem> paramList)
  {
    AppMethodBeat.i(236288);
    if (MMHandlerThread.isMainThread())
    {
      h(paramString, paramList);
      AppMethodBeat.o(236288);
      return;
    }
    MMHandlerThread.postToMainThread(new c..ExternalSyntheticLambda1(paramString, paramList));
    AppMethodBeat.o(236288);
  }
  
  private static void h(String paramString, List<SubscribeMsgTmpItem> paramList)
  {
    AppMethodBeat.i(236291);
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)paramList.next();
      ((Map)pjY).put(s.X(paramString, localSubscribeMsgTmpItem.nSg), localSubscribeMsgTmpItem);
    }
    AppMethodBeat.o(236291);
  }
  
  private static final void i(String paramString, List paramList)
  {
    AppMethodBeat.i(236309);
    s.u(paramString, "$bizUsername");
    s.u(paramList, "$subscribeMsgList");
    h(paramString, paramList);
    AppMethodBeat.o(236309);
  }
  
  public final boolean Rd(String paramString)
  {
    AppMethodBeat.i(236352);
    s.u(paramString, "bizUsername");
    paramString = (Boolean)pjZ.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(236352);
      return false;
    }
    boolean bool = paramString.booleanValue();
    AppMethodBeat.o(236352);
    return bool;
  }
  
  public final ISubscribeMsgService.Companion.SubscribeMsgListWrapper Re(String paramString)
  {
    AppMethodBeat.i(236356);
    s.u(paramString, "bizUsername");
    Log.v("MicroMsg.BrandSubscribeStorageManager", "alvinluo getSubscribeMsgListWrapper bizUsername: %s, hashCode: %s", new Object[] { paramString, Integer.valueOf(hashCode()) });
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(bQe());
    try
    {
      Object localObject1 = localMultiProcessMMKV.getString(paramString, null);
      if (localObject1 == null)
      {
        AppMethodBeat.o(236356);
        return null;
      }
      Object localObject2 = a.pka;
      localObject2 = (Parcelable.Creator)ISubscribeMsgService.Companion.SubscribeMsgListWrapper.CREATOR;
      s.u(localObject1, "data");
      s.u(localObject2, "creator");
      localObject1 = a.Rf((String)localObject1);
      localObject2 = ((Parcelable.Creator)localObject2).createFromParcel((Parcel)localObject1);
      ((Parcel)localObject1).recycle();
      localObject1 = (ISubscribeMsgService.Companion.SubscribeMsgListWrapper)localObject2;
      g(paramString, p.J((Collection)((ISubscribeMsgService.Companion.SubscribeMsgListWrapper)localObject1).pis));
      ah(paramString, ((ISubscribeMsgService.Companion.SubscribeMsgListWrapper)localObject1).pit);
      AppMethodBeat.o(236356);
      return localObject1;
    }
    catch (Exception localException)
    {
      localMultiProcessMMKV.putString(paramString, null);
      AppMethodBeat.o(236356);
    }
    return null;
  }
  
  public final void a(String paramString, List<SubscribeMsgTmpItem> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(236358);
    s.u(paramString, "bizUsername");
    s.u(paramList, "subscribeMsgList");
    com.tencent.threadpool.h.ahAA.g(new c..ExternalSyntheticLambda0(1, paramString, paramList, paramBoolean), "SubscribeMsgSaveTag");
    AppMethodBeat.o(236358);
  }
  
  public final void b(String paramString, List<SubscribeMsgTmpItem> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(236365);
    s.u(paramString, "bizUsername");
    if (paramList == null) {}
    for (Integer localInteger = null;; localInteger = Integer.valueOf(paramList.size()))
    {
      Log.i("MicroMsg.BrandSubscribeStorageManager", "alvinluo saveSubscribeMsgSubscribeStatus bizUsername: %s, size: %s, switchOpened: %b, needUpdateSwitchOpen: %b, needUpdateTimestamp: %b", new Object[] { paramString, localInteger, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3) });
      a(paramString, paramList, paramBoolean1, true, paramBoolean2, paramBoolean3);
      AppMethodBeat.o(236365);
      return;
    }
  }
  
  public final void bQd()
  {
    AppMethodBeat.i(236343);
    Log.i("MicroMsg.BrandSubscribeStorageManager", "alvinluo SubscribeMsg clearStorage");
    MultiProcessMMKV.getMMKV(bQe()).clear();
    AppMethodBeat.o(236343);
  }
  
  public final SubscribeMsgTmpItem bX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(236348);
    s.u(paramString1, "bizUsername");
    s.u(paramString2, "templateId");
    paramString1 = (SubscribeMsgTmpItem)pjY.get(s.X(paramString1, paramString2));
    AppMethodBeat.o(236348);
    return paramString1;
  }
  
  public final void f(String paramString, List<SubscribeMsgTmpItem> paramList)
  {
    AppMethodBeat.i(236375);
    s.u(paramString, "bizUsername");
    s.u(paramList, "subscribeMsgList");
    Log.i("MicroMsg.BrandSubscribeStorageManager", "alvinluo updateSubscribeMsgUiStatusTimestamp bizUsername: %s, size: %s", new Object[] { paramString, Integer.valueOf(paramList.size()) });
    a(paramString, paramList, false, false, false, true);
    AppMethodBeat.o(236375);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgStorageManager$ParcelUtil;", "", "()V", "marshall", "", "parcelable", "Landroid/os/Parcelable;", "unmarshall", "Landroid/os/Parcel;", "data", "T", "creator", "Landroid/os/Parcelable$Creator;", "(Ljava/lang/String;Landroid/os/Parcelable$Creator;)Ljava/lang/Object;", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static final a pka;
    
    static
    {
      AppMethodBeat.i(236290);
      pka = new a();
      AppMethodBeat.o(236290);
    }
    
    public static Parcel Rf(String paramString)
    {
      AppMethodBeat.i(236289);
      s.u(paramString, "data");
      paramString = Base64.decode(paramString, 0);
      Parcel localParcel = Parcel.obtain();
      s.s(localParcel, "obtain()");
      localParcel.unmarshall(paramString, 0, paramString.length);
      localParcel.setDataPosition(0);
      AppMethodBeat.o(236289);
      return localParcel;
    }
    
    public static String d(Parcelable paramParcelable)
    {
      AppMethodBeat.i(236282);
      s.u(paramParcelable, "parcelable");
      Parcel localParcel = Parcel.obtain();
      s.s(localParcel, "obtain()");
      paramParcelable.writeToParcel(localParcel, 0);
      paramParcelable = localParcel.marshall();
      localParcel.recycle();
      paramParcelable = Base64.encodeToString(paramParcelable, 0);
      s.s(paramParcelable, "encodeToString(bytes, Base64.DEFAULT)");
      AppMethodBeat.o(236282);
      return paramParcelable;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(List<SubscribeMsgTmpItem> paramList, boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "cachedItem", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "toUpdateItem"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements m<SubscribeMsgTmpItem, SubscribeMsgTmpItem, ah>
    {
      a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.d.c
 * JD-Core Version:    0.7.0.1
 */