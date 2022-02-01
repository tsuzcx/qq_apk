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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ai;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vending.g.e;
import d.a.j;
import d.g.a.a;
import d.g.b.k;
import d.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl;", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPreDownloadServiceExport;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "()V", "wxaQRScanSheetPreloadListener", "com/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl$wxaQRScanSheetPreloadListener$1", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl$wxaQRScanSheetPreloadListener$1;", "batchPreloadAttrs", "", "usernameList", "", "", "scene", "Lcom/tencent/mm/plugin/appbrand/config/CgiBatchWxaAttrSync$BatchSyncScene;", "onSuccess", "Lkotlin/Function0;", "canSyncWxaUsername", "", "username", "onRegister", "onUnregister", "triggerPreDownload", "triggerPrefetchChattingItemAppBrandPiece", "triggerPrefetchChattingItemWeishiVideoFakeNative", "triggerPrefetchMallIndexWeAppLinks", "appLinks", "", "triggerPrefetchWeAppQRCode", "Companion", "plugin-appbrand-integration_release"})
public final class d
  implements com.tencent.mm.kernel.c.b, q
{
  @Deprecated
  public static final a jpY;
  private final e jpX;
  
  static
  {
    AppMethodBeat.i(180434);
    jpY = new a((byte)0);
    AppMethodBeat.o(180434);
  }
  
  public d()
  {
    AppMethodBeat.i(187091);
    this.jpX = new e(this);
    AppMethodBeat.o(187091);
  }
  
  static boolean Iy(String paramString)
  {
    AppMethodBeat.i(187084);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; (i == 0) && (ai.vC(paramString)) && (w.Kq(paramString)); i = 0)
    {
      AppMethodBeat.o(187084);
      return true;
    }
    AppMethodBeat.o(187084);
    return false;
  }
  
  static void a(List<String> paramList, n.a parama)
  {
    AppMethodBeat.i(187087);
    w.c(paramList, parama).a((d.b)c.jqa);
    AppMethodBeat.o(187087);
  }
  
  public final void Ix(String paramString)
  {
    AppMethodBeat.i(50194);
    String[] arrayOfString = AppBrandGlobalSystemConfig.bat().jCY;
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
          ac.i("MicroMsg.AppBrand.PreDownloadServiceExportImpl", "username[" + paramString + "] blacklist, just return");
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
  
  public final void Iz(String paramString)
  {
    AppMethodBeat.i(187086);
    if (!Iy(paramString))
    {
      AppMethodBeat.o(187086);
      return;
    }
    h.wUl.dB(1342, 2);
    if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pQA, false))
    {
      ac.i("MicroMsg.AppBrand.PreDownloadServiceExportImpl", "triggerPrefetchChattingItemAppBrandPiece username:".concat(String.valueOf(paramString)));
      if (paramString == null) {
        k.fOy();
      }
      b(j.listOf(paramString), n.a.jEG);
    }
    AppMethodBeat.o(187086);
  }
  
  public final void aV(List<String> paramList)
  {
    AppMethodBeat.i(187085);
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
            if (!Iy(str)) {
              break;
            }
            if (str == null) {
              k.fOy();
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
      h.wUl.dB(1342, 1);
      if (!((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pQy, false)) {
        break label201;
      }
    }
    label201:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ac.i("MicroMsg.AppBrand.PreDownloadServiceExportImpl", "triggerPrefetchMallIndexWeAppLinks list.size:" + localLinkedList.size());
        b((List)localLinkedList, n.a.jEF);
      }
      AppMethodBeat.o(187085);
      return;
    }
  }
  
  public final void aXB()
  {
    AppMethodBeat.i(180433);
    if (!Iy("gh_8c10d2f0f25e@app"))
    {
      AppMethodBeat.o(180433);
      return;
    }
    h.wUl.dB(1342, 4);
    if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pQz, false))
    {
      ac.i("MicroMsg.AppBrand.PreDownloadServiceExportImpl", "triggerPrefetchChattingItemWeishiVideoFakeNative");
      b(j.listOf("gh_8c10d2f0f25e@app"), n.a.jEG);
    }
    AppMethodBeat.o(180433);
  }
  
  public final void ahM()
  {
    AppMethodBeat.i(187089);
    this.jpX.alive();
    AppMethodBeat.o(187089);
  }
  
  public final void ahN()
  {
    AppMethodBeat.i(187090);
    this.jpX.dead();
    AppMethodBeat.o(187090);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl$Companion;", "", "()V", "PRE_FETCH_DATA_MONITOR_ID", "", "PRE_FETCH_DATA_MONITOR_KEY_CHATTING_ITEM", "PRE_FETCH_DATA_MONITOR_KEY_MALL_INDEX", "PRE_FETCH_DATA_MONITOR_KEY_QRCODE_LONG_PRESS_DETECT", "PRE_FETCH_DATA_MONITOR_KEY_WEISHI", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "updatedList", "", "", "kotlin.jvm.PlatformType", "", "onTerminate"})
  static final class c<T>
    implements d.b<List<String>>
  {
    public static final c jqa;
    
    static
    {
      AppMethodBeat.i(187080);
      jqa = new c();
      AppMethodBeat.o(187080);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements a<y>
  {
    d(String paramString, long paramLong)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl$wxaQRScanSheetPreloadListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/plugin/scanner/EventScanCodeSheetPreloadWxaAttrs;", "callback", "", "event", "plugin-appbrand-integration_release"})
  public static final class e
    extends com.tencent.mm.sdk.b.c<com.tencent.mm.plugin.scanner.b>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.d
 * JD-Core Version:    0.7.0.1
 */