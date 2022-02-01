package com.tencent.mm.plugin.appbrand.appcache.b;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.n.a;
import com.tencent.mm.plugin.appbrand.config.x;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.am;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vending.g.e;
import d.a.j;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl;", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPreDownloadServiceExport;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "()V", "wxaQRScanSheetPreloadListener", "com/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl$wxaQRScanSheetPreloadListener$1", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl$wxaQRScanSheetPreloadListener$1;", "batchPreloadAttrs", "", "usernameList", "", "", "scene", "Lcom/tencent/mm/plugin/appbrand/config/CgiBatchWxaAttrSync$BatchSyncScene;", "onSuccess", "Lkotlin/Function0;", "canSyncWxaUsername", "", "username", "onRegister", "onUnregister", "triggerPreDownload", "triggerPrefetchChattingItemAppBrandPiece", "triggerPrefetchChattingItemWeishiVideoFakeNative", "triggerPrefetchMallIndexWeAppLinks", "appLinks", "", "triggerPrefetchWeAppQRCode", "Companion", "plugin-appbrand-integration_release"})
public final class d
  implements com.tencent.mm.kernel.c.b, r
{
  @Deprecated
  public static final a jJS;
  private final e jJR;
  
  static
  {
    AppMethodBeat.i(180434);
    jJS = new a((byte)0);
    AppMethodBeat.o(180434);
  }
  
  public d()
  {
    AppMethodBeat.i(188981);
    this.jJR = new e(this);
    AppMethodBeat.o(188981);
  }
  
  static boolean LP(String paramString)
  {
    AppMethodBeat.i(188974);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; (i == 0) && (am.yt(paramString)) && (x.NJ(paramString)); i = 0)
    {
      AppMethodBeat.o(188974);
      return true;
    }
    AppMethodBeat.o(188974);
    return false;
  }
  
  static void a(List<String> paramList, n.a parama)
  {
    AppMethodBeat.i(188977);
    x.c(paramList, parama).a((d.b)c.jJU);
    AppMethodBeat.o(188977);
  }
  
  public final void LO(String paramString)
  {
    AppMethodBeat.i(50194);
    String[] arrayOfString = AppBrandGlobalSystemConfig.bdT().jWU;
    if (arrayOfString == null) {
      arrayOfString = new String[0];
    }
    for (;;)
    {
      int k = arrayOfString.length;
      int i = 0;
      while (i < k)
      {
        String str = arrayOfString[i];
        CharSequence localCharSequence = (CharSequence)str;
        if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
        for (int j = 1; (j == 0) && (str.equals(paramString)); j = 0)
        {
          ad.i("MicroMsg.AppBrand.PreDownloadServiceExportImpl", "username[" + paramString + "] blacklist, just return");
          AppMethodBeat.o(50194);
          return;
        }
        i += 1;
      }
      c.a(new c(paramString, 6), false, 3);
      AppMethodBeat.o(50194);
      return;
    }
  }
  
  public final void LQ(String paramString)
  {
    AppMethodBeat.i(188976);
    if (!LP(paramString))
    {
      AppMethodBeat.o(188976);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yhR.dD(1342, 2);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.quQ, false))
    {
      ad.i("MicroMsg.AppBrand.PreDownloadServiceExportImpl", "triggerPrefetchChattingItemAppBrandPiece username:".concat(String.valueOf(paramString)));
      if (paramString == null) {
        p.gfZ();
      }
      b(j.listOf(paramString), n.a.jYI);
    }
    AppMethodBeat.o(188976);
  }
  
  public final void aW(List<String> paramList)
  {
    AppMethodBeat.i(188975);
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    label115:
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      CharSequence localCharSequence = (CharSequence)str;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (i = 1;; i = 0)
      {
        for (;;)
        {
          if (i != 0) {
            break label115;
          }
          try
          {
            str = Uri.parse(str).getQueryParameter("username");
            if (!LP(str)) {
              break;
            }
            if (str == null) {
              p.gfZ();
            }
            localLinkedList.add(str);
          }
          catch (Throwable localThrowable) {}
        }
        break;
      }
    }
    if (localLinkedList.size() > 0)
    {
      com.tencent.mm.plugin.report.service.g.yhR.dD(1342, 1);
      if (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.quO, false)) {
        break label201;
      }
    }
    label201:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ad.i("MicroMsg.AppBrand.PreDownloadServiceExportImpl", "triggerPrefetchMallIndexWeAppLinks list.size:" + localLinkedList.size());
        b((List)localLinkedList, n.a.jYH);
      }
      AppMethodBeat.o(188975);
      return;
    }
  }
  
  public final void akx()
  {
    AppMethodBeat.i(188979);
    this.jJR.alive();
    AppMethodBeat.o(188979);
  }
  
  public final void aky()
  {
    AppMethodBeat.i(188980);
    this.jJR.dead();
    AppMethodBeat.o(188980);
  }
  
  public final void baZ()
  {
    AppMethodBeat.i(180433);
    if (!LP("gh_8c10d2f0f25e@app"))
    {
      AppMethodBeat.o(180433);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yhR.dD(1342, 4);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.quP, false))
    {
      ad.i("MicroMsg.AppBrand.PreDownloadServiceExportImpl", "triggerPrefetchChattingItemWeishiVideoFakeNative");
      b(j.listOf("gh_8c10d2f0f25e@app"), n.a.jYI);
    }
    AppMethodBeat.o(180433);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl$Companion;", "", "()V", "PRE_FETCH_DATA_MONITOR_ID", "", "PRE_FETCH_DATA_MONITOR_KEY_CHATTING_ITEM", "PRE_FETCH_DATA_MONITOR_KEY_MALL_INDEX", "PRE_FETCH_DATA_MONITOR_KEY_QRCODE_LONG_PRESS_DETECT", "PRE_FETCH_DATA_MONITOR_KEY_WEISHI", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "updatedList", "", "", "kotlin.jvm.PlatformType", "", "onTerminate"})
  static final class c<T>
    implements d.b<List<String>>
  {
    public static final c jJU;
    
    static
    {
      AppMethodBeat.i(188970);
      jJU = new c();
      AppMethodBeat.o(188970);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<z>
  {
    d(String paramString, long paramLong)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl$wxaQRScanSheetPreloadListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/plugin/scanner/EventScanCodeSheetPreloadWxaAttrs;", "callback", "", "event", "plugin-appbrand-integration_release"})
  public static final class e
    extends com.tencent.mm.sdk.b.c<com.tencent.mm.plugin.scanner.b>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.d
 * JD-Core Version:    0.7.0.1
 */