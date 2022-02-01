package com.tencent.mm.plugin.brandservice;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.d;
import com.tencent.mm.plugin.brandservice.a.d.a;
import com.tencent.mm.plugin.brandservice.a.d.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.UrlExKt;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.t;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.eei;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import d.g.b.p;
import d.l;
import d.n.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/WebPrefetchServiceImpl;", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "()V", "TAG", "", "clearPrefetchContent", "", "url", "debugPreloadWebInfo", "", "(Ljava/lang/String;)[[Ljava/lang/String;", "getPreAuthUrl", "getPrefetchContentResp", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PrefetchResponse;", "getPrefetchResResp", "referer", "getReportScene", "", "getRespUrl", "getUrlCookie", "", "getWebId", "isDnsCached", "", "isEntranceOpen", "bit", "isUrlPreAuthed", "isWebUrlEqual", "rawUrl", "targetUrl", "preAuth", "openScene", "appId", "title", "desc", "from", "entranceBit", "preAuths", "auths", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PreAuthInfo;", "prefetchWebPage", "preAuthInfoList", "setUrlToScene", "scene", "plugin-brandservice_release"})
public final class e
  implements d
{
  private final String TAG = "MicroMsg.WebPrefetchServiceImpl";
  
  private static boolean zf(int paramInt)
  {
    AppMethodBeat.i(209651);
    if ((((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qEX, 65531) & paramInt) > 0)
    {
      AppMethodBeat.o(209651);
      return true;
    }
    AppMethodBeat.o(209651);
    return false;
  }
  
  public final boolean WS(String paramString)
  {
    AppMethodBeat.i(209642);
    if (paramString != null)
    {
      t localt = t.okg;
      boolean bool = t.WS(paramString);
      AppMethodBeat.o(209642);
      return bool;
    }
    AppMethodBeat.o(209642);
    return false;
  }
  
  public final String WT(String paramString)
  {
    AppMethodBeat.i(209643);
    Object localObject;
    if (paramString != null)
    {
      localObject = t.okg;
      p.h(paramString, "url");
      paramString = t.XD(paramString);
      if (paramString != null)
      {
        localObject = paramString.omw;
        paramString = (String)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramString = "";
      }
      localObject = paramString;
      if (paramString != null) {}
    }
    else
    {
      localObject = "";
    }
    AppMethodBeat.o(209643);
    return localObject;
  }
  
  public final boolean WU(String paramString)
  {
    AppMethodBeat.i(209644);
    if (paramString != null)
    {
      if (n.aE((CharSequence)paramString)) {}
      for (int i = 1; i == 0; i = 0)
      {
        paramString = Uri.parse(paramString);
        p.g(paramString, "Uri.parse(url)");
        paramString = paramString.getHost();
        if (paramString == null) {
          break;
        }
        c.a locala = c.nVH;
        boolean bool = c.bNp().contains(paramString);
        AppMethodBeat.o(209644);
        return bool;
      }
    }
    AppMethodBeat.o(209644);
    return false;
  }
  
  public final int WV(String paramString)
  {
    AppMethodBeat.i(209646);
    t localt = t.okg;
    int i = t.WV(paramString);
    AppMethodBeat.o(209646);
    return i;
  }
  
  public final d.b WW(String paramString)
  {
    AppMethodBeat.i(209647);
    p.h(paramString, "url");
    t localt = t.okg;
    paramString = t.WW(paramString);
    AppMethodBeat.o(209647);
    return paramString;
  }
  
  public final void WX(String paramString)
  {
    AppMethodBeat.i(209649);
    p.h(paramString, "url");
    t localt = t.okg;
    t.WX(paramString);
    AppMethodBeat.o(209649);
  }
  
  public final String WY(String paramString)
  {
    AppMethodBeat.i(209650);
    p.h(paramString, "url");
    paramString = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.Xn(paramString);
    AppMethodBeat.o(209650);
    return paramString;
  }
  
  public final void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2)
  {
    AppMethodBeat.i(209652);
    p.h(paramString1, "url");
    com.tencent.mm.plugin.webview.h.b.a(paramInt1, paramString1, true, false, false, false, false, 240);
    Object localObject = t.okg;
    t.zJ(paramInt2);
    if (!zf(paramInt2))
    {
      ad.v(this.TAG, "[TRACE_PREFETCH] preAuth isEntranceOpen false, entranceBit = ".concat(String.valueOf(paramInt2)));
      AppMethodBeat.o(209652);
      return;
    }
    if ((UrlExKt.isMpUrl(paramString1)) || ((n.a((CharSequence)paramString1, (CharSequence)":", false)) && (!n.nz(paramString1, "http"))))
    {
      AppMethodBeat.o(209652);
      return;
    }
    localObject = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.Xl(paramString1);
    c.a locala = c.nVH;
    if (c.bNo().contains((String)localObject))
    {
      AppMethodBeat.o(209652);
      return;
    }
    locala = c.nVH;
    c.bNo().Ej((String)localObject);
    ad.v(this.TAG, "preauth: ".concat(String.valueOf(localObject)));
    if (paramString2 == null) {
      paramString2 = "";
    }
    for (;;)
    {
      if (paramString3 == null) {
        paramString3 = "";
      }
      for (;;)
      {
        if (paramString4 == null) {
          paramString4 = "";
        }
        for (;;)
        {
          t.a(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1);
          AppMethodBeat.o(209652);
          return;
        }
      }
    }
  }
  
  public final void cd(List<? extends d.a> paramList)
  {
    AppMethodBeat.i(209654);
    p.h(paramList, "preAuthInfoList");
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    Object localObject3;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      localObject3 = (d.a)localObject2;
      com.tencent.mm.plugin.expt.b.b localb = (com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class);
      ad.i(this.TAG, "prefetchWebPage, scene: " + ((d.a)localObject3).nWh);
      boolean bool;
      switch (((d.a)localObject3).nWh)
      {
      default: 
        bool = true;
      }
      while (bool)
      {
        paramList.add(localObject2);
        break;
        if (localb.a(b.a.que, 1) == 1) {}
        for (bool = true;; bool = false)
        {
          ad.i(this.TAG, "clicfg_webview_prefetch_api_wechat_pay_open:".concat(String.valueOf(bool)));
          break;
        }
        if (localb.a(b.a.quc, 1) == 1) {}
        for (bool = true;; bool = false)
        {
          ad.i(this.TAG, "clicfg_webview_prefetch_api_web_open:".concat(String.valueOf(bool)));
          break;
        }
        if (localb.a(b.a.qud, 1) == 1) {}
        for (bool = true;; bool = false)
        {
          ad.i(this.TAG, "clicfg_webview_prefetch_api_app_brand_open:".concat(String.valueOf(bool)));
          break;
        }
        bool = true;
      }
    }
    paramList = (List)paramList;
    if (((Collection)paramList).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      ad.e(this.TAG, "result is null after filter");
      AppMethodBeat.o(209654);
      return;
    }
    localObject1 = ((Iterable)paramList).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (d.a)((Iterator)localObject1).next();
      localObject3 = ((d.a)localObject2).url;
      p.g(localObject3, "it.url");
      cu((String)localObject3, ((d.a)localObject2).nWh);
      i = ((d.a)localObject2).nWh;
      localObject2 = ((d.a)localObject2).url;
      p.g(localObject2, "it.url");
      com.tencent.mm.plugin.webview.h.b.a(i, (String)localObject2, true, false, false, false, false, 240);
    }
    t.cp(paramList);
    AppMethodBeat.o(209654);
  }
  
  public final void cu(String paramString, int paramInt)
  {
    AppMethodBeat.i(209645);
    p.h(paramString, "url");
    t localt = t.okg;
    t.cA(paramString, paramInt);
    AppMethodBeat.o(209645);
  }
  
  public final boolean eI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(209641);
    if ((paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(209641);
      return false;
    }
    if (p.i(n.br(paramString1, "#", ""), n.br(paramString2, "#", "")))
    {
      Object localObject = t.okg;
      p.h(paramString1, "rawUrl");
      p.h(paramString2, "targetUrl");
      if (!p.i(n.bq(paramString1, "#", paramString1), n.bq(paramString2, "#", paramString2)))
      {
        localObject = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.aF(paramString2, true);
        ad.v("MicroMsg.WebPrefetcher", "isWebUrlEqual: target:#".concat(String.valueOf(localObject)));
        String str = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.aF(paramString1, true);
        ad.v("MicroMsg.WebPrefetcher", "isWebUrlEqual: raw:#".concat(String.valueOf(str)));
        if ((!p.i(localObject, str)) && (!t.eP(paramString1, paramString2))) {
          break label167;
        }
      }
      label167:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(209641);
        return true;
      }
    }
    AppMethodBeat.o(209641);
    return false;
  }
  
  public final d.b eJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(209648);
    p.h(paramString1, "referer");
    p.h(paramString2, "url");
    t localt = t.okg;
    paramString1 = t.eJ(paramString1, paramString2);
    AppMethodBeat.o(209648);
    return paramString1;
  }
  
  public final void m(List<? extends d.a> paramList, int paramInt)
  {
    AppMethodBeat.i(209653);
    p.h(paramList, "auths");
    Object localObject1 = t.okg;
    t.zJ(paramInt);
    if (!zf(paramInt))
    {
      ad.v(this.TAG, "[TRACE_PREFETCH] preAuths isEntranceOpen false, entranceBit = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(209653);
      return;
    }
    localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label196:
    label199:
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      Object localObject3 = (d.a)localObject2;
      String str = ((d.a)localObject3).url;
      p.g(str, "info.url");
      if (!UrlExKt.isMpUrl(str))
      {
        str = ((d.a)localObject3).url;
        p.g(str, "info.url");
        if (!n.e((CharSequence)str, (CharSequence)":")) {
          break label196;
        }
        localObject3 = ((d.a)localObject3).url;
        p.g(localObject3, "info.url");
        if (n.nz((String)localObject3, "http")) {
          break label196;
        }
      }
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt != 0) {
          break label199;
        }
        paramList.add(localObject2);
        break;
      }
    }
    t.cp((List)paramList);
    AppMethodBeat.o(209653);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.e
 * JD-Core Version:    0.7.0.1
 */