package com.tencent.mm.plugin.appbrand.appcache.b;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.n.a;
import com.tencent.mm.plugin.appbrand.config.x;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.an;
import d.a.j;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl;", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPreDownloadServiceExport;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "()V", "scanBeforeA8KeyListener", "com/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl$scanBeforeA8KeyListener$1", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl$scanBeforeA8KeyListener$1;", "wxaQRScanSheetPreloadListener", "com/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl$wxaQRScanSheetPreloadListener$1", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl$wxaQRScanSheetPreloadListener$1;", "canSyncWxaUsername", "", "username", "", "checkIfWaitWxaAttrsPreloadDone", "block", "Lkotlin/Function0;", "", "onRegister", "onUnregister", "triggerPreDownload", "triggerPrefetchChattingItemAppBrandPiece", "triggerPrefetchChattingItemWeishiVideoFakeNative", "triggerPrefetchMallIndexWeAppLinks", "appLinks", "", "triggerPrefetchWeAppQRCode", "Companion", "plugin-appbrand-integration_release"})
public final class d
  implements com.tencent.mm.kernel.c.b, s
{
  @Deprecated
  public static final a jMV;
  private final d jMT;
  private final b jMU;
  
  static
  {
    AppMethodBeat.i(180434);
    jMV = new a((byte)0);
    AppMethodBeat.o(180434);
  }
  
  public d()
  {
    AppMethodBeat.i(223224);
    this.jMT = new d(this);
    this.jMU = new b();
    AppMethodBeat.o(223224);
  }
  
  static boolean Ms(String paramString)
  {
    AppMethodBeat.i(223219);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; (i == 0) && (an.zd(paramString)) && (x.Or(paramString)); i = 0)
    {
      AppMethodBeat.o(223219);
      return true;
    }
    AppMethodBeat.o(223219);
    return false;
  }
  
  public final void Mr(String paramString)
  {
    AppMethodBeat.i(50194);
    String[] arrayOfString = AppBrandGlobalSystemConfig.bez().kaj;
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
          ae.i("MicroMsg.AppBrand.PreDownloadServiceExportImpl", "username[" + paramString + "] blacklist, just return");
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
  
  public final void Mt(String paramString)
  {
    AppMethodBeat.i(223221);
    if (!Ms(paramString))
    {
      AppMethodBeat.o(223221);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yxI.dD(1342, 2);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qBL, false))
    {
      ae.i("MicroMsg.AppBrand.PreDownloadServiceExportImpl", "triggerPrefetchChattingItemAppBrandPiece username:".concat(String.valueOf(paramString)));
      h localh = h.jNg;
      if (paramString == null) {
        p.gkB();
      }
      h.a(j.listOf(paramString), n.a.kbX);
    }
    AppMethodBeat.o(223221);
  }
  
  public final void aW(List<String> paramList)
  {
    AppMethodBeat.i(223220);
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
            if (!Ms(str)) {
              break;
            }
            if (str == null) {
              p.gkB();
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
      com.tencent.mm.plugin.report.service.g.yxI.dD(1342, 1);
      if (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qBJ, false)) {
        break label205;
      }
    }
    label205:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ae.i("MicroMsg.AppBrand.PreDownloadServiceExportImpl", "triggerPrefetchMallIndexWeAppLinks list.size:" + localLinkedList.size());
        paramList = h.jNg;
        h.a((List)localLinkedList, n.a.kbW);
      }
      AppMethodBeat.o(223220);
      return;
    }
  }
  
  public final void akM()
  {
    AppMethodBeat.i(223222);
    this.jMT.alive();
    this.jMU.alive();
    AppMethodBeat.o(223222);
  }
  
  public final void akN()
  {
    AppMethodBeat.i(223223);
    this.jMT.dead();
    this.jMU.dead();
    AppMethodBeat.o(223223);
  }
  
  public final void bby()
  {
    AppMethodBeat.i(180433);
    if (!Ms("gh_8c10d2f0f25e@app"))
    {
      AppMethodBeat.o(180433);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yxI.dD(1342, 4);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qBK, false))
    {
      ae.i("MicroMsg.AppBrand.PreDownloadServiceExportImpl", "triggerPrefetchChattingItemWeishiVideoFakeNative");
      h localh = h.jNg;
      h.a(j.listOf("gh_8c10d2f0f25e@app"), n.a.kbX);
    }
    AppMethodBeat.o(180433);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl$Companion;", "", "()V", "PRE_FETCH_DATA_MONITOR_ID", "", "PRE_FETCH_DATA_MONITOR_KEY_CHATTING_ITEM", "PRE_FETCH_DATA_MONITOR_KEY_MALL_INDEX", "PRE_FETCH_DATA_MONITOR_KEY_QRCODE_LONG_PRESS_DETECT", "PRE_FETCH_DATA_MONITOR_KEY_WEISHI", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl$scanBeforeA8KeyListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/plugin/scanner/EventScanCodeTryPreloadWxaAttrsBeforeA8Key;", "callback", "", "event", "plugin-appbrand-integration_release"})
  public static final class b
    extends com.tencent.mm.sdk.b.c<com.tencent.mm.plugin.scanner.c>
  {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<z>
  {
    c(String paramString, long paramLong)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl$wxaQRScanSheetPreloadListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/plugin/scanner/EventScanCodeSheetPreloadWxaAttrs;", "callback", "", "event", "plugin-appbrand-integration_release"})
  public static final class d
    extends com.tencent.mm.sdk.b.c<com.tencent.mm.plugin.scanner.b>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.d
 * JD-Core Version:    0.7.0.1
 */