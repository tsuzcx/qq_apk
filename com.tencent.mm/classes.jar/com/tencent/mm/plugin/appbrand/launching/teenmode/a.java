package com.tencent.mm.plugin.appbrand.launching.teenmode;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.appusage.af.a;
import com.tencent.mm.plugin.appbrand.appusage.t;
import com.tencent.mm.plugin.appbrand.appusage.t.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.s.a;
import com.tencent.mm.plugin.teenmode.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/teenmode/AppBrandTeenModeReporter;", "", "()V", "REPORT_TEEN_MODE_TAG", "", "TAG", "collectionSet", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/appbrand/launching/teenmode/AppBrandTeenModeReporter$InfoWrapper;", "Lkotlin/collections/HashMap;", "addCollection", "", "username", "versionType", "", "checkRemovedCollection", "getAllCollectionList", "getKey", "getNicknameAsync", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "init", "removeCollection", "reportRemoveCollection", "reportTeenModeToast", "runTask", "runnable", "Ljava/lang/Runnable;", "updateCollectionSet", "list", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandRecentTaskInfo;", "Lkotlin/collections/ArrayList;", "InfoWrapper", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a tfc;
  private static HashMap<String, a> tfd;
  
  static
  {
    AppMethodBeat.i(321238);
    tfc = new a();
    tfd = new HashMap();
    AppMethodBeat.o(321238);
  }
  
  private static void N(ArrayList<AppBrandRecentTaskInfo> paramArrayList)
  {
    AppMethodBeat.i(321185);
    tfd.clear();
    if (paramArrayList != null)
    {
      paramArrayList = ((Iterable)paramArrayList).iterator();
      label120:
      while (paramArrayList.hasNext())
      {
        AppBrandRecentTaskInfo localAppBrandRecentTaskInfo = (AppBrandRecentTaskInfo)paramArrayList.next();
        if (localAppBrandRecentTaskInfo != null)
        {
          CharSequence localCharSequence = (CharSequence)localAppBrandRecentTaskInfo.username;
          if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
          for (int i = 1;; i = 0)
          {
            if (i != 0) {
              break label120;
            }
            Log.i("MicroMsg.AppBrandTeenModeReporter", "getAllCollectionList info: %s, %d", new Object[] { localAppBrandRecentTaskInfo.username, Integer.valueOf(localAppBrandRecentTaskInfo.euz) });
            cU(localAppBrandRecentTaskInfo.username, localAppBrandRecentTaskInfo.euz);
            break;
          }
        }
      }
    }
    AppMethodBeat.o(321185);
  }
  
  private static final void a(t.a parama)
  {
    AppMethodBeat.i(321218);
    kotlin.g.b.s.u(parama, "$this_apply");
    cU(parama.field_username, parama.field_versionType);
    AppMethodBeat.o(321218);
  }
  
  private static final void adm(String paramString)
  {
    AppMethodBeat.i(321200);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(321200);
      return;
    }
    if (!((d)com.tencent.mm.kernel.h.ax(d.class)).aBu())
    {
      AppMethodBeat.o(321200);
      return;
    }
    k(paramString, (b)new a.c(paramString));
    AppMethodBeat.o(321200);
  }
  
  public static final void adn(String paramString)
  {
    AppMethodBeat.i(321207);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(321207);
      return;
    }
    if (!((d)com.tencent.mm.kernel.h.ax(d.class)).aBu())
    {
      AppMethodBeat.o(321207);
      return;
    }
    k(paramString, (b)new a.d(paramString));
    AppMethodBeat.o(321207);
  }
  
  private static final void b(t.a parama)
  {
    AppMethodBeat.i(321220);
    kotlin.g.b.s.u(parama, "$this_apply");
    String str = parama.field_username;
    int j = parama.field_versionType;
    CharSequence localCharSequence = (CharSequence)str;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        tfd.remove(cV(str, j));
        Log.i("MicroMsg.AppBrandTeenModeReporter", "removeCollection %s, %d, %d", new Object[] { str, Integer.valueOf(j), Integer.valueOf(tfd.size()) });
      }
      adm(parama.field_username);
      AppMethodBeat.o(321220);
      return;
    }
  }
  
  private static final void b(String paramString, MStorageEventData paramMStorageEventData)
  {
    Object localObject = null;
    AppMethodBeat.i(321225);
    Integer localInteger;
    label18:
    int i;
    if (paramMStorageEventData == null)
    {
      localInteger = null;
      if (paramMStorageEventData != null) {
        break label107;
      }
      Log.i("MicroMsg.AppBrandTeenModeReporter", "alvinluo starAppStorage onNotifyChanged event: %s, eventId: %s, eventData.obj: %s", new Object[] { paramString, localInteger, localObject });
      if ((paramMStorageEventData == null) || (paramMStorageEventData.eventId != 2)) {
        break label116;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        if (!(paramMStorageEventData.obj instanceof t.a)) {
          break label214;
        }
        paramString = paramMStorageEventData.obj;
        if (paramString == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.appusage.AppBrandStarAppStorage.AppBrandStarAppRecord");
          AppMethodBeat.o(321225);
          throw paramString;
          localInteger = Integer.valueOf(paramMStorageEventData.eventId);
          break;
          label107:
          localObject = paramMStorageEventData.obj;
          break label18;
          label116:
          i = 0;
          continue;
        }
        y(new a..ExternalSyntheticLambda3((t.a)paramString));
        AppMethodBeat.o(321225);
        return;
      }
    }
    if ((paramMStorageEventData != null) && (paramMStorageEventData.eventId == 5)) {
      i = 1;
    }
    while ((i != 0) && ((paramMStorageEventData.obj instanceof t.a)))
    {
      paramString = paramMStorageEventData.obj;
      if (paramString == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.appusage.AppBrandStarAppStorage.AppBrandStarAppRecord");
        AppMethodBeat.o(321225);
        throw paramString;
        i = 0;
      }
      else
      {
        y(new a..ExternalSyntheticLambda2((t.a)paramString));
      }
    }
    label214:
    AppMethodBeat.o(321225);
  }
  
  private static final void c(String paramString, MStorageEventData paramMStorageEventData)
  {
    Object localObject = null;
    AppMethodBeat.i(321231);
    Integer localInteger;
    if (paramMStorageEventData == null)
    {
      localInteger = null;
      if (paramMStorageEventData != null) {
        break label103;
      }
      label19:
      Log.i("MicroMsg.AppBrandTeenModeReporter", "alvinluo collectionStorage onNotifyChanged event: %s, eventId: %s, eventData.obj: %s", new Object[] { paramString, localInteger, localObject });
      if ((paramMStorageEventData == null) || (paramMStorageEventData.eventId != 3)) {
        break label112;
      }
    }
    label103:
    label112:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (kotlin.g.b.s.p(paramString, "batch")) && (paramMStorageEventData.obj == null)) {
        y(a..ExternalSyntheticLambda4.INSTANCE);
      }
      AppMethodBeat.o(321231);
      return;
      localInteger = Integer.valueOf(paramMStorageEventData.eventId);
      break;
      localObject = paramMStorageEventData.obj;
      break label19;
    }
  }
  
  private static final void cAX()
  {
    Object localObject2 = null;
    AppMethodBeat.i(321228);
    Object localObject1 = (t)n.ag(t.class);
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label154;
      }
    }
    Object localObject3;
    for (;;)
    {
      Log.i("MicroMsg.AppBrandTeenModeReporter", "alvinluo checkRemovedCollection allCollection: %d", new Object[] { localObject2 });
      if (localObject1 == null) {
        break label165;
      }
      localObject2 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (AppBrandRecentTaskInfo)((Iterator)localObject2).next();
        String str = ((AppBrandRecentTaskInfo)localObject3).username;
        kotlin.g.b.s.s(str, "info.username");
        localObject3 = cV(str, ((AppBrandRecentTaskInfo)localObject3).euz);
        Log.i("MicroMsg.AppBrandTeenModeReporter", "alvinluo checkRemovedCollection key: %s", new Object[] { localObject3 });
        if (((Map)tfd).containsKey(localObject3)) {
          tfd.remove(localObject3);
        }
      }
      localObject1 = ((t)localObject1).b(2147483647, af.a.qPY);
      break;
      label154:
      localObject2 = Integer.valueOf(((ArrayList)localObject1).size());
    }
    label165:
    localObject2 = ((Map)tfd).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      Log.i("MicroMsg.AppBrandTeenModeReporter", "alvinluo checkRemovedCollection needRemove key: %s", new Object[] { ((Map.Entry)localObject3).getKey() });
      adm(((a)((Map.Entry)localObject3).getValue()).username);
    }
    N((ArrayList)localObject1);
    AppMethodBeat.o(321228);
  }
  
  private static final void cAY()
  {
    AppMethodBeat.i(321234);
    Object localObject = (t)n.ag(t.class);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((t)localObject).b(2147483647, af.a.qPY))
    {
      N((ArrayList)localObject);
      AppMethodBeat.o(321234);
      return;
    }
  }
  
  private static void cU(String paramString, int paramInt)
  {
    AppMethodBeat.i(321189);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(321189);
      return;
    }
    localObject = (Map)tfd;
    String str = cV(paramString, paramInt);
    a locala = new a();
    locala.setUsername(paramString);
    locala.euz = paramInt;
    ((Map)localObject).put(str, locala);
    Log.i("MicroMsg.AppBrandTeenModeReporter", "addCollection %s, %d, %d", new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(tfd.size()) });
    AppMethodBeat.o(321189);
  }
  
  private static String cV(String paramString, int paramInt)
  {
    AppMethodBeat.i(321196);
    paramString = paramString + ',' + paramInt;
    AppMethodBeat.o(321196);
    return paramString;
  }
  
  public static final void init()
  {
    AppMethodBeat.i(321179);
    Object localObject = (t)n.ag(t.class);
    if (localObject != null) {
      ((t)localObject).add(a..ExternalSyntheticLambda0.INSTANCE);
    }
    localObject = (af)com.tencent.mm.kernel.h.ax(af.class);
    if (localObject != null) {
      ((af)localObject).add(a..ExternalSyntheticLambda1.INSTANCE);
    }
    y(a..ExternalSyntheticLambda5.INSTANCE);
    AppMethodBeat.o(321179);
  }
  
  private static void k(String paramString, b<? super WxaAttributes, ah> paramb)
  {
    AppMethodBeat.i(321212);
    ((com.tencent.mm.plugin.appbrand.service.s)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.s.class)).a(paramString, (s.a)new b(paramb));
    AppMethodBeat.o(321212);
  }
  
  private static void y(Runnable paramRunnable)
  {
    AppMethodBeat.i(321214);
    com.tencent.threadpool.h.ahAA.j(paramRunnable, "AppBrandTeenModeReporter");
    AppMethodBeat.o(321214);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/teenmode/AppBrandTeenModeReporter$InfoWrapper;", "", "()V", "username", "", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "versionType", "", "getVersionType", "()I", "setVersionType", "(I)V", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
  {
    int euz;
    String username = "";
    
    public final void setUsername(String paramString)
    {
      AppMethodBeat.i(321137);
      kotlin.g.b.s.u(paramString, "<set-?>");
      this.username = paramString;
      AppMethodBeat.o(321137);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/launching/teenmode/AppBrandTeenModeReporter$getNicknameAsync$1", "Lcom/tencent/mm/plugin/appbrand/service/IWeAppInfoService$IGetWeAppInfoCallback;", "onGetWeAppInfo", "", "info", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements s.a
  {
    b(b<? super WxaAttributes, ah> paramb) {}
    
    public final void onGetWeAppInfo(WxaAttributes paramWxaAttributes)
    {
      AppMethodBeat.i(321148);
      if (paramWxaAttributes == null)
      {
        AppMethodBeat.o(321148);
        return;
      }
      this.$callback.invoke(paramWxaAttributes);
      AppMethodBeat.o(321148);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.teenmode.a
 * JD-Core Version:    0.7.0.1
 */