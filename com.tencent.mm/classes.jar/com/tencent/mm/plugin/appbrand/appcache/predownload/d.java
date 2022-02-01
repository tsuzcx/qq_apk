package com.tencent.mm.plugin.appbrand.appcache.predownload;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.aa;
import com.tencent.mm.plugin.appbrand.config.o.a;
import com.tencent.mm.plugin.appbrand.service.w;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl;", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPreDownloadServiceExport;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "()V", "scanBeforeA8KeyListener", "com/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl$scanBeforeA8KeyListener$1", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl$scanBeforeA8KeyListener$1;", "wxaQRScanSheetPreloadListener", "com/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl$wxaQRScanSheetPreloadListener$1", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl$wxaQRScanSheetPreloadListener$1;", "canSyncWxaUsername", "", "username", "", "checkIfWaitWxaAttrsPreloadDone", "block", "Lkotlin/Function0;", "", "onRegister", "onUnregister", "triggerPreDownload", "scene", "", "appId", "triggerPrefetchChattingItemAppBrandPiece", "triggerPrefetchChattingItemWeishiVideoFakeNative", "triggerPrefetchMallIndexWeAppLinks", "appLinks", "", "triggerPrefetchMallIndexWeAppV2", "prefetchUsernameList", "", "triggerPrefetchWeAppQRCode", "Companion", "plugin-appbrand-integration_release"})
public final class d
  implements com.tencent.mm.kernel.c.b, w
{
  @Deprecated
  public static final a nJh;
  private final d nJf;
  private final b nJg;
  
  static
  {
    AppMethodBeat.i(180434);
    nJh = new a((byte)0);
    AppMethodBeat.o(180434);
  }
  
  public d()
  {
    AppMethodBeat.i(265195);
    this.nJf = new d(this);
    this.nJg = new b();
    AppMethodBeat.o(265195);
  }
  
  static boolean adk(String paramString)
  {
    AppMethodBeat.i(265189);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; (i == 0) && (as.OS(paramString)) && (aa.afn(paramString)); i = 0)
    {
      AppMethodBeat.o(265189);
      return true;
    }
    AppMethodBeat.o(265189);
    return false;
  }
  
  public final void aIF()
  {
    AppMethodBeat.i(265193);
    this.nJf.alive();
    this.nJg.alive();
    AppMethodBeat.o(265193);
  }
  
  public final void aIG()
  {
    AppMethodBeat.i(265194);
    this.nJf.dead();
    this.nJg.dead();
    AppMethodBeat.o(265194);
  }
  
  public final void adj(String paramString)
  {
    AppMethodBeat.i(265192);
    if (!adk(paramString))
    {
      AppMethodBeat.o(265192);
      return;
    }
    com.tencent.mm.plugin.report.service.h.IzE.el(1342, 2);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vBi, false))
    {
      Log.i("MicroMsg.AppBrand.PreDownloadServiceExportImpl", "triggerPrefetchChattingItemAppBrandPiece username:".concat(String.valueOf(paramString)));
      h localh = h.nJu;
      if (paramString == null) {
        p.iCn();
      }
      h.a(j.listOf(paramString), o.a.nZr);
    }
    AppMethodBeat.o(265192);
  }
  
  public final void bHS()
  {
    AppMethodBeat.i(180433);
    if (!adk("gh_8c10d2f0f25e@app"))
    {
      AppMethodBeat.o(180433);
      return;
    }
    com.tencent.mm.plugin.report.service.h.IzE.el(1342, 4);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vBh, false))
    {
      Log.i("MicroMsg.AppBrand.PreDownloadServiceExportImpl", "triggerPrefetchChattingItemWeishiVideoFakeNative");
      h localh = h.nJu;
      h.a(j.listOf("gh_8c10d2f0f25e@app"), o.a.nZr);
    }
    AppMethodBeat.o(180433);
  }
  
  public final void be(List<String> paramList)
  {
    AppMethodBeat.i(265190);
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    label116:
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      CharSequence localCharSequence = (CharSequence)str;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (int i = 1;; i = 0)
      {
        for (;;)
        {
          if (i != 0) {
            break label116;
          }
          try
          {
            str = Uri.parse(str).getQueryParameter("username");
            if (!adk(str)) {
              break;
            }
            if (str == null) {
              p.iCn();
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
      com.tencent.mm.plugin.report.service.h.IzE.el(1342, 1);
      if ((!BuildInfo.DEBUG) && (!BuildInfo.IS_FLAVOR_RED)) {
        break label217;
      }
    }
    label217:
    for (boolean bool = true;; bool = false)
    {
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vBg, bool))
      {
        Log.i("MicroMsg.AppBrand.PreDownloadServiceExportImpl", "triggerPrefetchMallIndexWeAppLinks list.size:" + localLinkedList.size());
        paramList = h.nJu;
        h.a((List)localLinkedList, o.a.nZq);
      }
      AppMethodBeat.o(265190);
      return;
    }
  }
  
  public final void bf(List<String> paramList)
  {
    boolean bool = false;
    AppMethodBeat.i(265191);
    if (((Collection)paramList).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        com.tencent.mm.plugin.report.service.h.IzE.el(1342, 1);
        if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED)) {
          bool = true;
        }
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vBg, bool))
        {
          Log.i("MicroMsg.AppBrand.PreDownloadServiceExportImpl", "triggerPrefetchMallIndexWeAppV2 list.size:" + paramList.size());
          h localh = h.nJu;
          h.a(paramList, o.a.nZq);
        }
      }
      AppMethodBeat.o(265191);
      return;
    }
  }
  
  public final void bu(String paramString, int paramInt)
  {
    AppMethodBeat.i(265187);
    String[] arrayOfString = AppBrandGlobalSystemConfig.bLe().nXv;
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
          Log.i("MicroMsg.AppBrand.PreDownloadServiceExportImpl", "username[" + paramString + "] blacklist, just return");
          AppMethodBeat.o(265187);
          return;
        }
        i += 1;
      }
      c.a(new c(paramString, paramInt, 2), false, 3);
      AppMethodBeat.o(265187);
      return;
    }
  }
  
  public final void t(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(265188);
    c.a(new c(paramString1, paramInt, paramString2), false, 3);
    AppMethodBeat.o(265188);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl$Companion;", "", "()V", "PRE_FETCH_DATA_MONITOR_ID", "", "PRE_FETCH_DATA_MONITOR_KEY_CHATTING_ITEM", "PRE_FETCH_DATA_MONITOR_KEY_MALL_INDEX", "PRE_FETCH_DATA_MONITOR_KEY_QRCODE_LONG_PRESS_DETECT", "PRE_FETCH_DATA_MONITOR_KEY_WEISHI", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl$scanBeforeA8KeyListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/plugin/scanner/EventScanCodeTryPreloadWxaAttrsBeforeA8Key;", "callback", "", "event", "plugin-appbrand-integration_release"})
  public static final class b
    extends IListener<com.tencent.mm.plugin.scanner.d>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<x>
  {
    c(String paramString, long paramLong)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl$wxaQRScanSheetPreloadListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/plugin/scanner/EventScanCodeSheetPreloadWxaAttrs;", "callback", "", "event", "plugin-appbrand-integration_release"})
  public static final class d
    extends IListener<com.tencent.mm.plugin.scanner.c>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.d
 * JD-Core Version:    0.7.0.1
 */