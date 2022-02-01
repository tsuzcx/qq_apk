package com.tencent.mm.plugin.appbrand.launching.f;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.appusage.u;
import com.tencent.mm.plugin.appbrand.appusage.u.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.appbrand.service.q.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/teenmode/AppBrandTeenModeReporter;", "", "()V", "REPORT_TEEN_MODE_TAG", "", "TAG", "collectionSet", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/appbrand/launching/teenmode/AppBrandTeenModeReporter$InfoWrapper;", "Lkotlin/collections/HashMap;", "addCollection", "", "username", "versionType", "", "checkRemovedCollection", "getAllCollectionList", "getKey", "getNicknameAsync", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "init", "removeCollection", "reportRemoveCollection", "reportTeenModeToast", "runTask", "runnable", "Ljava/lang/Runnable;", "updateCollectionSet", "list", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandRecentTaskInfo;", "Lkotlin/collections/ArrayList;", "InfoWrapper", "plugin-appbrand-integration_release"})
public final class a
{
  private static HashMap<String, a> mZu;
  public static final a mZv;
  
  static
  {
    AppMethodBeat.i(228787);
    mZv = new a();
    mZu = new HashMap();
    AppMethodBeat.o(228787);
  }
  
  private static void I(ArrayList<AppBrandRecentTaskInfo> paramArrayList)
  {
    AppMethodBeat.i(228780);
    mZu.clear();
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
            Log.i("MicroMsg.AppBrandTeenModeReporter", "getAllCollectionList info: %s, %d", new Object[] { localAppBrandRecentTaskInfo.username, Integer.valueOf(localAppBrandRecentTaskInfo.iOo) });
            bX(localAppBrandRecentTaskInfo.username, localAppBrandRecentTaskInfo.iOo);
            break;
          }
        }
      }
      AppMethodBeat.o(228780);
      return;
    }
    AppMethodBeat.o(228780);
  }
  
  private static final void acn(String paramString)
  {
    AppMethodBeat.i(228783);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(228783);
      return;
    }
    localObject = g.af(com.tencent.mm.plugin.teenmode.a.b.class);
    p.g(localObject, "MMKernel.service(ITeenModeService::class.java)");
    if (!((com.tencent.mm.plugin.teenmode.a.b)localObject).Vt())
    {
      AppMethodBeat.o(228783);
      return;
    }
    e(paramString, (kotlin.g.a.b)new a.f(paramString));
    AppMethodBeat.o(228783);
  }
  
  public static final void aco(String paramString)
  {
    AppMethodBeat.i(228784);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(228784);
      return;
    }
    localObject = g.af(com.tencent.mm.plugin.teenmode.a.b.class);
    p.g(localObject, "MMKernel.service(ITeenModeService::class.java)");
    if (!((com.tencent.mm.plugin.teenmode.a.b)localObject).Vt())
    {
      AppMethodBeat.o(228784);
      return;
    }
    e(paramString, (kotlin.g.a.b)new a.g(paramString));
    AppMethodBeat.o(228784);
  }
  
  private static void bX(String paramString, int paramInt)
  {
    AppMethodBeat.i(228781);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(228781);
      return;
    }
    localObject = (Map)mZu;
    String str = bY(paramString, paramInt);
    a locala = new a();
    locala.setUsername(paramString);
    locala.iOo = paramInt;
    ((Map)localObject).put(str, locala);
    Log.i("MicroMsg.AppBrandTeenModeReporter", "addCollection %s, %d, %d", new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(mZu.size()) });
    AppMethodBeat.o(228781);
  }
  
  private static String bY(String paramString, int paramInt)
  {
    AppMethodBeat.i(228782);
    paramString = paramString + ',' + paramInt;
    AppMethodBeat.o(228782);
    return paramString;
  }
  
  private static void e(String paramString, kotlin.g.a.b<? super WxaAttributes, x> paramb)
  {
    AppMethodBeat.i(228785);
    ((q)g.af(q.class)).a(paramString, (q.a)new b(paramb));
    AppMethodBeat.o(228785);
  }
  
  public static final void init()
  {
    AppMethodBeat.i(228779);
    Object localObject = (u)n.W(u.class);
    if (localObject != null) {
      ((u)localObject).add((MStorage.IOnStorageChange)c.mZw);
    }
    localObject = (ag)g.af(ag.class);
    if (localObject != null) {
      ((ag)localObject).add((MStorage.IOnStorageChange)d.mZy);
    }
    v((Runnable)e.mZA);
    AppMethodBeat.o(228779);
  }
  
  private static void v(Runnable paramRunnable)
  {
    AppMethodBeat.i(228786);
    h.RTc.e(paramRunnable, "AppBrandTeenModeReporter");
    AppMethodBeat.o(228786);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/teenmode/AppBrandTeenModeReporter$InfoWrapper;", "", "()V", "username", "", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "versionType", "", "getVersionType", "()I", "setVersionType", "(I)V", "plugin-appbrand-integration_release"})
  static final class a
  {
    int iOo;
    String username = "";
    
    public final void setUsername(String paramString)
    {
      AppMethodBeat.i(228765);
      p.h(paramString, "<set-?>");
      this.username = paramString;
      AppMethodBeat.o(228765);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/launching/teenmode/AppBrandTeenModeReporter$getNicknameAsync$1", "Lcom/tencent/mm/plugin/appbrand/service/IWeAppInfoService$IGetWeAppInfoCallback;", "onGetWeAppInfo", "", "info", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "plugin-appbrand-integration_release"})
  public static final class b
    implements q.a
  {
    b(kotlin.g.a.b paramb) {}
    
    public final void b(WxaAttributes paramWxaAttributes)
    {
      AppMethodBeat.i(228766);
      if (paramWxaAttributes == null)
      {
        AppMethodBeat.o(228766);
        return;
      }
      this.gWe.invoke(paramWxaAttributes);
      AppMethodBeat.o(228766);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
  static final class c
    implements MStorage.IOnStorageChange
  {
    public static final c mZw;
    
    static
    {
      AppMethodBeat.i(228770);
      mZw = new c();
      AppMethodBeat.o(228770);
    }
    
    public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
    {
      Object localObject = null;
      AppMethodBeat.i(228769);
      if (paramMStorageEventData != null) {}
      for (Integer localInteger = Integer.valueOf(paramMStorageEventData.eventId);; localInteger = null)
      {
        if (paramMStorageEventData != null) {
          localObject = paramMStorageEventData.obj;
        }
        Log.i("MicroMsg.AppBrandTeenModeReporter", "alvinluo starAppStorage onNotifyChanged event: %s, eventId: %s, eventData.obj: %s", new Object[] { paramString, localInteger, localObject });
        if ((paramMStorageEventData == null) || (paramMStorageEventData.eventId != 2)) {
          break label136;
        }
        if (!(paramMStorageEventData.obj instanceof u.a)) {
          break label213;
        }
        paramString = paramMStorageEventData.obj;
        if (paramString != null) {
          break;
        }
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.appusage.AppBrandStarAppStorage.AppBrandStarAppRecord");
        AppMethodBeat.o(228769);
        throw paramString;
      }
      paramString = (u.a)paramString;
      paramMStorageEventData = a.mZv;
      a.ac((Runnable)new a(paramString));
      AppMethodBeat.o(228769);
      return;
      label136:
      if (paramMStorageEventData != null)
      {
        if ((paramMStorageEventData.eventId != 5) || (!(paramMStorageEventData.obj instanceof u.a))) {
          break label213;
        }
        paramString = paramMStorageEventData.obj;
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.appusage.AppBrandStarAppStorage.AppBrandStarAppRecord");
          AppMethodBeat.o(228769);
          throw paramString;
        }
      }
      else
      {
        AppMethodBeat.o(228769);
        return;
      }
      paramString = (u.a)paramString;
      paramMStorageEventData = a.mZv;
      a.ac((Runnable)new b(paramString));
      label213:
      AppMethodBeat.o(228769);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(u.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(228767);
        a locala = a.mZv;
        a.bZ(this.mZx.field_username, this.mZx.field_versionType);
        AppMethodBeat.o(228767);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(u.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(228768);
        a locala = a.mZv;
        a.ca(this.mZx.field_username, this.mZx.field_versionType);
        a.acp(this.mZx.field_username);
        AppMethodBeat.o(228768);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
  static final class d
    implements MStorage.IOnStorageChange
  {
    public static final d mZy;
    
    static
    {
      AppMethodBeat.i(228774);
      mZy = new d();
      AppMethodBeat.o(228774);
    }
    
    public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
    {
      Object localObject = null;
      AppMethodBeat.i(228773);
      if (paramMStorageEventData != null) {}
      for (Integer localInteger = Integer.valueOf(paramMStorageEventData.eventId);; localInteger = null)
      {
        if (paramMStorageEventData != null) {
          localObject = paramMStorageEventData.obj;
        }
        Log.i("MicroMsg.AppBrandTeenModeReporter", "alvinluo collectionStorage onNotifyChanged event: %s, eventId: %s, eventData.obj: %s", new Object[] { paramString, localInteger, localObject });
        if (paramMStorageEventData == null) {
          break;
        }
        if ((paramMStorageEventData.eventId == 3) && (p.j(paramString, "batch")) && (paramMStorageEventData.obj == null))
        {
          paramString = a.mZv;
          a.ac((Runnable)1.mZz);
        }
        AppMethodBeat.o(228773);
        return;
      }
      AppMethodBeat.o(228773);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    public static final e mZA;
    
    static
    {
      AppMethodBeat.i(228776);
      mZA = new e();
      AppMethodBeat.o(228776);
    }
    
    public final void run()
    {
      AppMethodBeat.i(228775);
      a locala = a.mZv;
      a.bOm();
      AppMethodBeat.o(228775);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.f.a
 * JD-Core Version:    0.7.0.1
 */