package com.tencent.mm.plugin.appbrand.appcache.b;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.n.a;
import com.tencent.mm.plugin.appbrand.config.w;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.af;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vending.g.e;
import d.a.j;
import d.g.b.k;
import d.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl;", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPreDownloadServiceExport;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "()V", "wxaQRScanSheetPreloadListener", "com/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl$wxaQRScanSheetPreloadListener$1", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl$wxaQRScanSheetPreloadListener$1;", "batchPreloadAttrs", "", "usernameList", "", "", "scene", "Lcom/tencent/mm/plugin/appbrand/config/CgiBatchWxaAttrSync$BatchSyncScene;", "onSuccess", "Lkotlin/Function0;", "canSyncWxaUsername", "", "username", "onRegister", "onUnregister", "triggerPreDownload", "triggerPrefetchChattingItemAppBrandPiece", "triggerPrefetchChattingItemWeishiVideoFakeNative", "triggerPrefetchMallIndexWeAppLinks", "appLinks", "", "triggerPrefetchWeAppQRCode", "Companion", "plugin-appbrand-integration_release"})
public final class d
  implements com.tencent.mm.kernel.c.b, q
{
  @Deprecated
  public static final a iPN;
  private final e iPM;
  
  static
  {
    AppMethodBeat.i(180434);
    iPN = new a((byte)0);
    AppMethodBeat.o(180434);
  }
  
  public d()
  {
    AppMethodBeat.i(196235);
    this.iPM = new e(this);
    AppMethodBeat.o(196235);
  }
  
  static boolean Ev(String paramString)
  {
    AppMethodBeat.i(196228);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; (i == 0) && (af.rz(paramString)) && (w.Gm(paramString)); i = 0)
    {
      AppMethodBeat.o(196228);
      return true;
    }
    AppMethodBeat.o(196228);
    return false;
  }
  
  static void a(List<String> paramList, n.a parama)
  {
    AppMethodBeat.i(196231);
    w.c(paramList, parama).a((d.b)d.c.iPP);
    AppMethodBeat.o(196231);
  }
  
  public final void Eu(String paramString)
  {
    AppMethodBeat.i(50194);
    String[] arrayOfString = AppBrandGlobalSystemConfig.aTv().jcL;
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
  
  public final void Ew(String paramString)
  {
    AppMethodBeat.i(196230);
    if (!Ev(paramString))
    {
      AppMethodBeat.o(196230);
      return;
    }
    h.vKh.dB(1342, 2);
    if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pna, false))
    {
      ad.i("MicroMsg.AppBrand.PreDownloadServiceExportImpl", "triggerPrefetchChattingItemAppBrandPiece username:".concat(String.valueOf(paramString)));
      if (paramString == null) {
        k.fvU();
      }
      b(j.listOf(paramString), n.a.jes);
    }
    AppMethodBeat.o(196230);
  }
  
  public final void aQG()
  {
    AppMethodBeat.i(180433);
    if (!Ev("gh_8c10d2f0f25e@app"))
    {
      AppMethodBeat.o(180433);
      return;
    }
    h.vKh.dB(1342, 4);
    if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pmZ, false))
    {
      ad.i("MicroMsg.AppBrand.PreDownloadServiceExportImpl", "triggerPrefetchChattingItemWeishiVideoFakeNative");
      b(j.listOf("gh_8c10d2f0f25e@app"), n.a.jes);
    }
    AppMethodBeat.o(180433);
  }
  
  public final void aX(List<String> paramList)
  {
    AppMethodBeat.i(196229);
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    label116:
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
            break label116;
          }
          try
          {
            str = Uri.parse(str).getQueryParameter("username");
            if (!Ev(str)) {
              break;
            }
            if (str == null) {
              k.fvU();
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
      h.vKh.dB(1342, 1);
      if (!((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pmY, false)) {
        break label203;
      }
    }
    label203:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ad.i("MicroMsg.AppBrand.PreDownloadServiceExportImpl", "triggerPrefetchMallIndexWeAppLinks list.size:" + localLinkedList.size());
        b((List)localLinkedList, n.a.jer);
      }
      AppMethodBeat.o(196229);
      return;
    }
  }
  
  public final void agv()
  {
    AppMethodBeat.i(196233);
    this.iPM.alive();
    AppMethodBeat.o(196233);
  }
  
  public final void agw()
  {
    AppMethodBeat.i(196234);
    this.iPM.dead();
    AppMethodBeat.o(196234);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl$Companion;", "", "()V", "PRE_FETCH_DATA_MONITOR_ID", "", "PRE_FETCH_DATA_MONITOR_KEY_CHATTING_ITEM", "PRE_FETCH_DATA_MONITOR_KEY_MALL_INDEX", "PRE_FETCH_DATA_MONITOR_KEY_QRCODE_LONG_PRESS_DETECT", "PRE_FETCH_DATA_MONITOR_KEY_WEISHI", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    d(String paramString, long paramLong)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl$wxaQRScanSheetPreloadListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/plugin/scanner/EventScanCodeSheetPreloadWxaAttrs;", "callback", "", "event", "plugin-appbrand-integration_release"})
  public static final class e
    extends com.tencent.mm.sdk.b.c<com.tencent.mm.plugin.scanner.a>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.d
 * JD-Core Version:    0.7.0.1
 */