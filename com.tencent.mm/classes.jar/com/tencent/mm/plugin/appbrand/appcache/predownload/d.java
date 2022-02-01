package com.tencent.mm.plugin.appbrand.appcache.predownload;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl;", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPreDownloadServiceExport;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "()V", "scanBeforeA8KeyListener", "com/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl$scanBeforeA8KeyListener$1", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl$scanBeforeA8KeyListener$1;", "wxaQRScanSheetPreloadListener", "com/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl$wxaQRScanSheetPreloadListener$1", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl$wxaQRScanSheetPreloadListener$1;", "canSyncWxaUsername", "", "username", "", "checkIfWaitWxaAttrsPreloadDone", "block", "Lkotlin/Function0;", "", "onRegister", "onUnregister", "triggerPreDownload", "scene", "", "appId", "triggerPrefetchChattingItemAppBrandPiece", "triggerPrefetchChattingItemWeishiVideoFakeNative", "triggerPrefetchMallIndexWeAppLinks", "appLinks", "", "triggerPrefetchMallIndexWeAppV2", "prefetchUsernameList", "", "triggerPrefetchWeAppQRCode", "Companion", "plugin-appbrand-integration_release"})
public final class d
  implements com.tencent.mm.kernel.c.b, w
{
  @Deprecated
  public static final a kPb;
  private final d kOZ;
  private final b kPa;
  
  static
  {
    AppMethodBeat.i(180434);
    kPb = new a((byte)0);
    AppMethodBeat.o(180434);
  }
  
  public d()
  {
    AppMethodBeat.i(228016);
    this.kOZ = new d(this);
    this.kPa = new b();
    AppMethodBeat.o(228016);
  }
  
  static boolean VB(String paramString)
  {
    AppMethodBeat.i(228010);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; (i == 0) && (as.HF(paramString)) && (aa.XB(paramString)); i = 0)
    {
      AppMethodBeat.o(228010);
      return true;
    }
    AppMethodBeat.o(228010);
    return false;
  }
  
  public final void VA(String paramString)
  {
    AppMethodBeat.i(228013);
    if (!VB(paramString))
    {
      AppMethodBeat.o(228013);
      return;
    }
    com.tencent.mm.plugin.report.service.h.CyF.dN(1342, 2);
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rUx, false))
    {
      Log.i("MicroMsg.AppBrand.PreDownloadServiceExportImpl", "triggerPrefetchChattingItemAppBrandPiece username:".concat(String.valueOf(paramString)));
      h localh = h.kPo;
      if (paramString == null) {
        p.hyc();
      }
      h.a(j.listOf(paramString), o.a.lfe);
    }
    AppMethodBeat.o(228013);
  }
  
  public final void aBc()
  {
    AppMethodBeat.i(228014);
    this.kOZ.alive();
    this.kPa.alive();
    AppMethodBeat.o(228014);
  }
  
  public final void aBd()
  {
    AppMethodBeat.i(228015);
    this.kOZ.dead();
    this.kPa.dead();
    AppMethodBeat.o(228015);
  }
  
  public final void bb(String paramString, int paramInt)
  {
    AppMethodBeat.i(228009);
    String[] arrayOfString = AppBrandGlobalSystemConfig.bzP().ldm;
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
          AppMethodBeat.o(228009);
          return;
        }
        i += 1;
      }
      c.a(new c(paramString, paramInt, 2), false, 3);
      AppMethodBeat.o(228009);
      return;
    }
  }
  
  public final void bg(List<String> paramList)
  {
    AppMethodBeat.i(228011);
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    label117:
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
            break label117;
          }
          try
          {
            str = Uri.parse(str).getQueryParameter("username");
            if (!VB(str)) {
              break;
            }
            if (str == null) {
              p.hyc();
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
      com.tencent.mm.plugin.report.service.h.CyF.dN(1342, 1);
      if ((!BuildInfo.DEBUG) && (!BuildInfo.IS_FLAVOR_RED)) {
        break label218;
      }
    }
    label218:
    for (boolean bool = true;; bool = false)
    {
      if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rUv, bool))
      {
        Log.i("MicroMsg.AppBrand.PreDownloadServiceExportImpl", "triggerPrefetchMallIndexWeAppLinks list.size:" + localLinkedList.size());
        paramList = h.kPo;
        h.a((List)localLinkedList, o.a.lfd);
      }
      AppMethodBeat.o(228011);
      return;
    }
  }
  
  public final void bh(List<String> paramList)
  {
    boolean bool = false;
    AppMethodBeat.i(228012);
    if (((Collection)paramList).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        com.tencent.mm.plugin.report.service.h.CyF.dN(1342, 1);
        if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED)) {
          bool = true;
        }
        if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rUv, bool))
        {
          Log.i("MicroMsg.AppBrand.PreDownloadServiceExportImpl", "triggerPrefetchMallIndexWeAppV2 list.size:" + paramList.size());
          h localh = h.kPo;
          h.a(paramList, o.a.lfd);
        }
      }
      AppMethodBeat.o(228012);
      return;
    }
  }
  
  public final void bwL()
  {
    AppMethodBeat.i(180433);
    if (!VB("gh_8c10d2f0f25e@app"))
    {
      AppMethodBeat.o(180433);
      return;
    }
    com.tencent.mm.plugin.report.service.h.CyF.dN(1342, 4);
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rUw, false))
    {
      Log.i("MicroMsg.AppBrand.PreDownloadServiceExportImpl", "triggerPrefetchChattingItemWeishiVideoFakeNative");
      h localh = h.kPo;
      h.a(j.listOf("gh_8c10d2f0f25e@app"), o.a.lfe);
    }
    AppMethodBeat.o(180433);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl$Companion;", "", "()V", "PRE_FETCH_DATA_MONITOR_ID", "", "PRE_FETCH_DATA_MONITOR_KEY_CHATTING_ITEM", "PRE_FETCH_DATA_MONITOR_KEY_MALL_INDEX", "PRE_FETCH_DATA_MONITOR_KEY_QRCODE_LONG_PRESS_DETECT", "PRE_FETCH_DATA_MONITOR_KEY_WEISHI", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl$scanBeforeA8KeyListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/plugin/scanner/EventScanCodeTryPreloadWxaAttrsBeforeA8Key;", "callback", "", "event", "plugin-appbrand-integration_release"})
  public static final class b
    extends IListener<com.tencent.mm.plugin.scanner.c>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<x>
  {
    c(String paramString, long paramLong)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl$wxaQRScanSheetPreloadListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/plugin/scanner/EventScanCodeSheetPreloadWxaAttrs;", "callback", "", "event", "plugin-appbrand-integration_release"})
  public static final class d
    extends IListener<com.tencent.mm.plugin.scanner.b>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.d
 * JD-Core Version:    0.7.0.1
 */