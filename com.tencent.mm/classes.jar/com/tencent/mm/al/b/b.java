package com.tencent.mm.al.b;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.storage.IBrandSubscribeMsgService.Companion.SubscribeMsgListWrapper;
import com.tencent.mm.msgsubscription.storage.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.ay;
import d.a.j;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/modelbiz/subscribemsg/BrandSubscribeStorageManager;", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "()V", "MMKV_FILE_KEY_POSTFIX", "", "SubscribeMsgSaveExecutorTag", "TAG", "mTotalSwitchOpenMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "subscribeMsgTmpCacheMap", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "clearStorage", "", "doSaveSubscribeMsgList", "scene", "", "bizUsername", "subscribeMsgList", "", "subscribeSwitchOpened", "doSaveSubscribeMsgSubscribeStatus", "toSaveList", "isOpened", "doSaveSubscribeMsgUiStatus", "switchOpen", "needUpdateSwitchOpen", "needUpdateTimestamp", "getCacheKey", "templateId", "getMMKVKey", "getSubscribeMsgListWrapper", "Lcom/tencent/mm/msgsubscription/storage/IBrandSubscribeMsgService$Companion$SubscribeMsgListWrapper;", "getSubscribeSwitchOpened", "getSubscribeTmpByTemplateId", "mergeSubscribeMsgList", "savedList", "processSubscribeMsgList", "runInMainUI", "task", "Lkotlin/Function0;", "saveSubscribeMsgList", "saveSubscribeMsgSubscribeStatus", "saveSubscribeMsgUiStatus", "switchOpened", "updateCache", "updateCacheList", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "cachedItem", "toUpdateItem", "updateSwitchOpen", "ParcelUtil", "plugin-biz_release"})
public final class b
  implements d
{
  public static final b hVA;
  private static final HashMap<String, SubscribeMsgTmpItem> hVy;
  private static HashMap<String, Boolean> hVz;
  
  static
  {
    AppMethodBeat.i(124754);
    hVA = new b();
    hVy = new HashMap();
    hVz = new HashMap();
    AppMethodBeat.o(124754);
  }
  
  private static void O(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(124752);
    ae.i("MicroMsg.BrandSubscribeStorageManager", "alvinluo updateSwitchOpen: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ((Map)hVz).put(paramString, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(124752);
  }
  
  private static List<SubscribeMsgTmpItem> a(int paramInt, List<SubscribeMsgTmpItem> paramList1, List<SubscribeMsgTmpItem> paramList2)
  {
    AppMethodBeat.i(124753);
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
            localSubscribeMsgTmpItem2.iDn = bool;
            if (!localSubscribeMsgTmpItem1.hDH.equals(localSubscribeMsgTmpItem2.hDH)) {
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
      if ((i != 0) || (localSubscribeMsgTmpItem1.iDn)) {
        break;
      }
      localList.add(localSubscribeMsgTmpItem1);
      break;
      localList.addAll((Collection)paramList2);
      AppMethodBeat.o(124753);
      return localList;
    }
  }
  
  private static String aGN()
  {
    AppMethodBeat.i(124740);
    Object localObject = new StringBuilder();
    p.g(g.ajP(), "MMKernel.account()");
    localObject = com.tencent.mm.kernel.a.aiF() + "_subscribe_msg_storage";
    AppMethodBeat.o(124740);
    return localObject;
  }
  
  private static String bl(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124741);
    paramString1 = paramString1 + paramString2;
    AppMethodBeat.o(124741);
    return paramString1;
  }
  
  private static void d(String paramString, final List<SubscribeMsgTmpItem> paramList)
  {
    AppMethodBeat.i(124750);
    if (ar.isMainThread())
    {
      e(paramString, paramList);
      AppMethodBeat.o(124750);
      return;
    }
    ar.f((Runnable)new f(paramString, paramList));
    AppMethodBeat.o(124750);
  }
  
  private static void e(String paramString, List<SubscribeMsgTmpItem> paramList)
  {
    AppMethodBeat.i(124751);
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)paramList.next();
      ((Map)hVy).put(bl(paramString, localSubscribeMsgTmpItem.hDH), localSubscribeMsgTmpItem);
    }
    AppMethodBeat.o(124751);
  }
  
  private static void p(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(124749);
    if (ar.isMainThread())
    {
      parama.invoke();
      AppMethodBeat.o(124749);
      return;
    }
    ar.f((Runnable)new d(parama));
    AppMethodBeat.o(124749);
  }
  
  public final boolean Fe(String paramString)
  {
    AppMethodBeat.i(124744);
    p.h(paramString, "bizUsername");
    paramString = (Boolean)hVz.get(paramString);
    if (paramString != null)
    {
      boolean bool = paramString.booleanValue();
      AppMethodBeat.o(124744);
      return bool;
    }
    AppMethodBeat.o(124744);
    return false;
  }
  
  public final IBrandSubscribeMsgService.Companion.SubscribeMsgListWrapper Ff(String paramString)
  {
    AppMethodBeat.i(124745);
    p.h(paramString, "bizUsername");
    ae.v("MicroMsg.BrandSubscribeStorageManager", "alvinluo getSubscribeMsgListWrapper bizUsername: %s", new Object[] { paramString });
    ay localay = ay.aRW(aGN());
    try
    {
      Object localObject1 = localay.getString(paramString, null);
      if (localObject1 == null)
      {
        AppMethodBeat.o(124745);
        return null;
      }
      Object localObject2 = a.hVB;
      localObject2 = (Parcelable.Creator)IBrandSubscribeMsgService.Companion.SubscribeMsgListWrapper.CREATOR;
      p.h(localObject1, "data");
      p.h(localObject2, "creator");
      localObject1 = a.Fg((String)localObject1);
      localObject2 = ((Parcelable.Creator)localObject2).createFromParcel((Parcel)localObject1);
      ((Parcel)localObject1).recycle();
      localObject1 = (IBrandSubscribeMsgService.Companion.SubscribeMsgListWrapper)localObject2;
      d(paramString, j.s((Collection)((IBrandSubscribeMsgService.Companion.SubscribeMsgListWrapper)localObject1).iED));
      O(paramString, ((IBrandSubscribeMsgService.Companion.SubscribeMsgListWrapper)localObject1).iEE);
      AppMethodBeat.o(124745);
      return localObject1;
    }
    catch (Exception localException)
    {
      localay.putString(paramString, null);
      AppMethodBeat.o(124745);
    }
    return null;
  }
  
  public final void a(String paramString, final List<SubscribeMsgTmpItem> paramList, final boolean paramBoolean)
  {
    AppMethodBeat.i(124746);
    p.h(paramString, "bizUsername");
    p.h(paramList, "subscribeMsgList");
    h.MqF.f((Runnable)new e(paramString, paramList, paramBoolean), "SubscribeMsgSaveTag");
    AppMethodBeat.o(124746);
  }
  
  public final void a(String paramString, final List<SubscribeMsgTmpItem> paramList, final boolean paramBoolean1, final boolean paramBoolean2, final boolean paramBoolean3)
  {
    AppMethodBeat.i(124747);
    p.h(paramString, "bizUsername");
    p.h(paramList, "toSaveList");
    ae.i("MicroMsg.BrandSubscribeStorageManager", "alvinluo saveSubscribeMsgUiStatus bizUsername: %s, size: %d, needUpdateSwitchOpen: %b", new Object[] { paramString, Integer.valueOf(paramList.size()), Boolean.valueOf(paramBoolean2) });
    ay localay = ay.aRW(aGN());
    Object localObject2 = Ff(paramString);
    Object localObject1;
    List localList;
    label106:
    SubscribeMsgTmpItem localSubscribeMsgTmpItem1;
    int j;
    if (localObject2 != null)
    {
      localObject1 = ((IBrandSubscribeMsgService.Companion.SubscribeMsgListWrapper)localObject2).iED;
      localList = (List)new ArrayList();
      Iterator localIterator1 = ((Iterable)paramList).iterator();
      if (!localIterator1.hasNext()) {
        break label248;
      }
      localSubscribeMsgTmpItem1 = (SubscribeMsgTmpItem)localIterator1.next();
      j = 0;
      int i = 0;
      if (localObject1 == null) {
        break label230;
      }
      Iterator localIterator2 = ((Iterable)localObject1).iterator();
      label151:
      j = i;
      if (!localIterator2.hasNext()) {
        break label230;
      }
      SubscribeMsgTmpItem localSubscribeMsgTmpItem2 = (SubscribeMsgTmpItem)localIterator2.next();
      if (!localSubscribeMsgTmpItem2.hDH.equals(localSubscribeMsgTmpItem1.hDH)) {
        break label387;
      }
      localSubscribeMsgTmpItem2.iDl = localSubscribeMsgTmpItem1.iDl;
      if (paramBoolean3) {
        localSubscribeMsgTmpItem2.iDm = localSubscribeMsgTmpItem1.iDm;
      }
      i = 1;
    }
    label387:
    for (;;)
    {
      break label151;
      localObject1 = null;
      break;
      label230:
      if (j != 0) {
        break label106;
      }
      localList.add(localSubscribeMsgTmpItem1);
      break label106;
      label248:
      if (localObject1 != null) {
        localList.addAll((Collection)localObject1);
      }
      ae.i("MicroMsg.BrandSubscribeStorageManager", "alvinluo saveSubscribeMsgUiStatus finalList: %d, switchOpen: %b", new Object[] { Integer.valueOf(localList.size()), Boolean.valueOf(paramBoolean1) });
      boolean bool;
      if (paramBoolean2) {
        bool = paramBoolean1;
      }
      for (;;)
      {
        localObject1 = new IBrandSubscribeMsgService.Companion.SubscribeMsgListWrapper(localList, bool);
        localObject2 = a.hVB;
        localay.putString(paramString, a.e((Parcelable)localObject1));
        p((d.g.a.a)new c(paramString, paramList, paramBoolean3, paramBoolean2, paramBoolean1));
        AppMethodBeat.o(124747);
        return;
        if (localObject2 != null) {
          bool = ((IBrandSubscribeMsgService.Companion.SubscribeMsgListWrapper)localObject2).iEE;
        } else {
          bool = false;
        }
      }
    }
  }
  
  public final void aGO()
  {
    AppMethodBeat.i(124742);
    ae.i("MicroMsg.BrandSubscribeStorageManager", "alvinluo SubscribeMsg clearStorage");
    ay.aRW(aGN()).clear();
    AppMethodBeat.o(124742);
  }
  
  public final void b(final String paramString, List<SubscribeMsgTmpItem> paramList, final boolean paramBoolean)
  {
    AppMethodBeat.i(124748);
    p.h(paramString, "bizUsername");
    Object localObject1;
    ay localay;
    Object localObject2;
    label88:
    label103:
    SubscribeMsgTmpItem localSubscribeMsgTmpItem1;
    int j;
    if (paramList != null)
    {
      localObject1 = Integer.valueOf(paramList.size());
      ae.i("MicroMsg.BrandSubscribeStorageManager", "alvinluo saveSubscribeMsgSubscribeStatus bizUsername: %s, size: %s", new Object[] { paramString, localObject1 });
      localay = ay.aRW(aGN());
      localObject1 = Ff(paramString);
      localObject2 = (List)new ArrayList();
      if (localObject1 == null) {
        break label212;
      }
      localObject1 = ((IBrandSubscribeMsgService.Companion.SubscribeMsgListWrapper)localObject1).iED;
      if (paramList == null) {
        break label236;
      }
      Iterator localIterator1 = ((Iterable)paramList).iterator();
      if (!localIterator1.hasNext()) {
        break label236;
      }
      localSubscribeMsgTmpItem1 = (SubscribeMsgTmpItem)localIterator1.next();
      j = 0;
      int i = 0;
      if (localObject1 == null) {
        break label218;
      }
      Iterator localIterator2 = ((Iterable)localObject1).iterator();
      label148:
      j = i;
      if (!localIterator2.hasNext()) {
        break label218;
      }
      SubscribeMsgTmpItem localSubscribeMsgTmpItem2 = (SubscribeMsgTmpItem)localIterator2.next();
      if (!localSubscribeMsgTmpItem2.hDH.equals(localSubscribeMsgTmpItem1.hDH)) {
        break label341;
      }
      localSubscribeMsgTmpItem2.iDl = localSubscribeMsgTmpItem1.iDl;
      i = 1;
    }
    label212:
    label341:
    for (;;)
    {
      break label148;
      localObject1 = null;
      break;
      localObject1 = null;
      break label88;
      label218:
      if (j != 0) {
        break label103;
      }
      ((List)localObject2).add(localSubscribeMsgTmpItem1);
      break label103;
      label236:
      if (localObject1 != null) {
        ((List)localObject2).addAll((Collection)localObject1);
      }
      ae.d("MicroMsg.BrandSubscribeStorageManager", "alvinluo saveSubscribeMsgSubscribeStatus finalList: %d, isOpened: %b", new Object[] { Integer.valueOf(((List)localObject2).size()), Boolean.valueOf(paramBoolean) });
      localObject1 = new IBrandSubscribeMsgService.Companion.SubscribeMsgListWrapper((List)localObject2, paramBoolean);
      localObject2 = a.hVB;
      localay.putString(paramString, a.e((Parcelable)localObject1));
      p((d.g.a.a)new b(paramList, paramString, paramBoolean));
      AppMethodBeat.o(124748);
      return;
    }
  }
  
  public final SubscribeMsgTmpItem bm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124743);
    p.h(paramString1, "bizUsername");
    p.h(paramString2, "templateId");
    paramString1 = (SubscribeMsgTmpItem)hVy.get(bl(paramString1, paramString2));
    AppMethodBeat.o(124743);
    return paramString1;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/modelbiz/subscribemsg/BrandSubscribeStorageManager$ParcelUtil;", "", "()V", "marshall", "", "parcelable", "Landroid/os/Parcelable;", "unmarshall", "Landroid/os/Parcel;", "data", "T", "creator", "Landroid/os/Parcelable$Creator;", "(Ljava/lang/String;Landroid/os/Parcelable$Creator;)Ljava/lang/Object;", "plugin-biz_release"})
  public static final class a
  {
    public static final a hVB;
    
    static
    {
      AppMethodBeat.i(124731);
      hVB = new a();
      AppMethodBeat.o(124731);
    }
    
    public static Parcel Fg(String paramString)
    {
      AppMethodBeat.i(124730);
      p.h(paramString, "data");
      paramString = Base64.decode(paramString, 0);
      Parcel localParcel = Parcel.obtain();
      localParcel.unmarshall(paramString, 0, paramString.length);
      localParcel.setDataPosition(0);
      p.g(localParcel, "parcel");
      AppMethodBeat.o(124730);
      return localParcel;
    }
    
    public static String e(Parcelable paramParcelable)
    {
      AppMethodBeat.i(124729);
      p.h(paramParcelable, "parcelable");
      Parcel localParcel = Parcel.obtain();
      paramParcelable.writeToParcel(localParcel, 0);
      paramParcelable = localParcel.marshall();
      localParcel.recycle();
      paramParcelable = Base64.encodeToString(paramParcelable, 0);
      p.g(paramParcelable, "Base64.encodeToString(bytes, Base64.DEFAULT)");
      AppMethodBeat.o(124729);
      return paramParcelable;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(List paramList, String paramString, boolean paramBoolean)
    {
      super();
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "cachedItem", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "toUpdateItem", "invoke"})
    static final class a
      extends q
      implements m<SubscribeMsgTmpItem, SubscribeMsgTmpItem, z>
    {
      public static final a hVF;
      
      static
      {
        AppMethodBeat.i(124733);
        hVF = new a();
        AppMethodBeat.o(124733);
      }
      
      a()
      {
        super();
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<z>
  {
    c(String paramString, List paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(d.g.a.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(124737);
      this.hVK.invoke();
      AppMethodBeat.o(124737);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(String paramString, List paramList, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(124738);
      b.a(b.hVA, this.hVL, this.hVD, paramList, paramBoolean);
      AppMethodBeat.o(124738);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(String paramString, List paramList) {}
    
    public final void run()
    {
      AppMethodBeat.i(124739);
      b localb = b.hVA;
      b.f(this.hVD, paramList);
      AppMethodBeat.o(124739);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.al.b.b
 * JD-Core Version:    0.7.0.1
 */