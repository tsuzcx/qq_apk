package com.tencent.mm.plugin.appbrand.launching.f;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.m;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/teenmode/AppBrandTeenModeReporter;", "", "()V", "REPORT_TEEN_MODE_TAG", "", "TAG", "collectionSet", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/appbrand/launching/teenmode/AppBrandTeenModeReporter$InfoWrapper;", "Lkotlin/collections/HashMap;", "addCollection", "", "username", "versionType", "", "checkRemovedCollection", "getAllCollectionList", "getKey", "getNicknameAsync", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "init", "removeCollection", "reportRemoveCollection", "reportTeenModeToast", "runTask", "runnable", "Ljava/lang/Runnable;", "updateCollectionSet", "list", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandRecentTaskInfo;", "Lkotlin/collections/ArrayList;", "InfoWrapper", "plugin-appbrand-integration_release"})
public final class a
{
  private static HashMap<String, a.a> pZS;
  public static final a pZT;
  
  static
  {
    AppMethodBeat.i(266245);
    pZT = new a();
    pZS = new HashMap();
    AppMethodBeat.o(266245);
  }
  
  private static void J(ArrayList<AppBrandRecentTaskInfo> paramArrayList)
  {
    AppMethodBeat.i(266237);
    pZS.clear();
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
            Log.i("MicroMsg.AppBrandTeenModeReporter", "getAllCollectionList info: %s, %d", new Object[] { localAppBrandRecentTaskInfo.username, Integer.valueOf(localAppBrandRecentTaskInfo.cBU) });
            cv(localAppBrandRecentTaskInfo.username, localAppBrandRecentTaskInfo.cBU);
            break;
          }
        }
      }
      AppMethodBeat.o(266237);
      return;
    }
    AppMethodBeat.o(266237);
  }
  
  private static final void akh(String paramString)
  {
    AppMethodBeat.i(266241);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(266241);
      return;
    }
    localObject = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class);
    p.j(localObject, "MMKernel.service(ITeenModeService::class.java)");
    if (!((com.tencent.mm.plugin.teenmode.a.b)localObject).ZM())
    {
      AppMethodBeat.o(266241);
      return;
    }
    e(paramString, (kotlin.g.a.b)new a.f(paramString));
    AppMethodBeat.o(266241);
  }
  
  public static final void aki(String paramString)
  {
    AppMethodBeat.i(266242);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(266242);
      return;
    }
    localObject = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class);
    p.j(localObject, "MMKernel.service(ITeenModeService::class.java)");
    if (!((com.tencent.mm.plugin.teenmode.a.b)localObject).ZM())
    {
      AppMethodBeat.o(266242);
      return;
    }
    e(paramString, (kotlin.g.a.b)new a.g(paramString));
    AppMethodBeat.o(266242);
  }
  
  private static void cv(String paramString, int paramInt)
  {
    AppMethodBeat.i(266238);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(266238);
      return;
    }
    localObject = (Map)pZS;
    String str = cw(paramString, paramInt);
    a.a locala = new a.a();
    locala.setUsername(paramString);
    locala.cBU = paramInt;
    ((Map)localObject).put(str, locala);
    Log.i("MicroMsg.AppBrandTeenModeReporter", "addCollection %s, %d, %d", new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(pZS.size()) });
    AppMethodBeat.o(266238);
  }
  
  private static String cw(String paramString, int paramInt)
  {
    AppMethodBeat.i(266240);
    paramString = paramString + ',' + paramInt;
    AppMethodBeat.o(266240);
    return paramString;
  }
  
  private static void e(String paramString, kotlin.g.a.b<? super WxaAttributes, x> paramb)
  {
    AppMethodBeat.i(266243);
    ((q)com.tencent.mm.kernel.h.ae(q.class)).a(paramString, (q.a)new a.b(paramb));
    AppMethodBeat.o(266243);
  }
  
  public static final void init()
  {
    AppMethodBeat.i(266236);
    Object localObject = (u)m.W(u.class);
    if (localObject != null) {
      ((u)localObject).add((MStorage.IOnStorageChange)c.pZU);
    }
    localObject = (ag)com.tencent.mm.kernel.h.ae(ag.class);
    if (localObject != null) {
      ((ag)localObject).add((MStorage.IOnStorageChange)d.pZW);
    }
    u((Runnable)e.pZY);
    AppMethodBeat.o(266236);
  }
  
  private static void u(Runnable paramRunnable)
  {
    AppMethodBeat.i(266244);
    com.tencent.e.h.ZvG.g(paramRunnable, "AppBrandTeenModeReporter");
    AppMethodBeat.o(266244);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
  static final class c
    implements MStorage.IOnStorageChange
  {
    public static final c pZU;
    
    static
    {
      AppMethodBeat.i(283887);
      pZU = new c();
      AppMethodBeat.o(283887);
    }
    
    public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
    {
      Object localObject = null;
      AppMethodBeat.i(283886);
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
        AppMethodBeat.o(283886);
        throw paramString;
      }
      paramString = (u.a)paramString;
      paramMStorageEventData = a.pZT;
      a.af((Runnable)new a(paramString));
      AppMethodBeat.o(283886);
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
          AppMethodBeat.o(283886);
          throw paramString;
        }
      }
      else
      {
        AppMethodBeat.o(283886);
        return;
      }
      paramString = (u.a)paramString;
      paramMStorageEventData = a.pZT;
      a.af((Runnable)new b(paramString));
      label213:
      AppMethodBeat.o(283886);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(u.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(243630);
        a locala = a.pZT;
        a.cx(this.pZV.field_username, this.pZV.field_versionType);
        AppMethodBeat.o(243630);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(u.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(267249);
        a locala = a.pZT;
        a.cy(this.pZV.field_username, this.pZV.field_versionType);
        a.akj(this.pZV.field_username);
        AppMethodBeat.o(267249);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
  static final class d
    implements MStorage.IOnStorageChange
  {
    public static final d pZW;
    
    static
    {
      AppMethodBeat.i(245999);
      pZW = new d();
      AppMethodBeat.o(245999);
    }
    
    public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
    {
      Object localObject = null;
      AppMethodBeat.i(245998);
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
        if ((paramMStorageEventData.eventId == 3) && (p.h(paramString, "batch")) && (paramMStorageEventData.obj == null))
        {
          paramString = a.pZT;
          a.af((Runnable)1.pZX);
        }
        AppMethodBeat.o(245998);
        return;
      }
      AppMethodBeat.o(245998);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    public static final e pZY;
    
    static
    {
      AppMethodBeat.i(280249);
      pZY = new e();
      AppMethodBeat.o(280249);
    }
    
    public final void run()
    {
      AppMethodBeat.i(280247);
      a locala = a.pZT;
      a.caG();
      AppMethodBeat.o(280247);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.f.a
 * JD-Core Version:    0.7.0.1
 */