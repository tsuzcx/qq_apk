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
import com.tencent.mm.protocal.protobuf.efz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import d.g.b.p;
import d.l;
import d.n.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/WebPrefetchServiceImpl;", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "()V", "TAG", "", "clearPrefetchContent", "", "url", "debugPreloadWebInfo", "", "(Ljava/lang/String;)[[Ljava/lang/String;", "getPreAuthUrl", "getPrefetchContentResp", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PrefetchResponse;", "getPrefetchResResp", "referer", "getReportScene", "", "getRespUrl", "getUrlCookie", "", "getWebId", "isDnsCached", "", "isEntranceOpen", "bit", "isUrlPreAuthed", "isWebUrlEqual", "rawUrl", "targetUrl", "preAuth", "openScene", "appId", "title", "desc", "from", "entranceBit", "preAuths", "auths", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PreAuthInfo;", "prefetchWebPage", "preAuthInfoList", "setUrlToScene", "scene", "plugin-brandservice_release"})
public final class e
  implements d
{
  private final String TAG = "MicroMsg.WebPrefetchServiceImpl";
  
  private static boolean zo(int paramInt)
  {
    AppMethodBeat.i(208608);
    if ((((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qMD, 65531) & paramInt) > 0)
    {
      AppMethodBeat.o(208608);
      return true;
    }
    AppMethodBeat.o(208608);
    return false;
  }
  
  public final boolean XE(String paramString)
  {
    AppMethodBeat.i(208599);
    if (paramString != null)
    {
      t localt = t.oqh;
      boolean bool = t.XE(paramString);
      AppMethodBeat.o(208599);
      return bool;
    }
    AppMethodBeat.o(208599);
    return false;
  }
  
  public final String XF(String paramString)
  {
    AppMethodBeat.i(208600);
    Object localObject;
    if (paramString != null)
    {
      localObject = t.oqh;
      p.h(paramString, "url");
      paramString = t.Yq(paramString);
      if (paramString != null)
      {
        localObject = paramString.osm;
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
    AppMethodBeat.o(208600);
    return localObject;
  }
  
  public final boolean XG(String paramString)
  {
    AppMethodBeat.i(208601);
    if (paramString != null)
    {
      if (n.aD((CharSequence)paramString)) {}
      for (int i = 1; i == 0; i = 0)
      {
        paramString = Uri.parse(paramString);
        p.g(paramString, "Uri.parse(url)");
        paramString = paramString.getHost();
        if (paramString == null) {
          break;
        }
        c.a locala = c.obp;
        boolean bool = c.bOn().contains(paramString);
        AppMethodBeat.o(208601);
        return bool;
      }
    }
    AppMethodBeat.o(208601);
    return false;
  }
  
  public final int XH(String paramString)
  {
    AppMethodBeat.i(208603);
    t localt = t.oqh;
    int i = t.XH(paramString);
    AppMethodBeat.o(208603);
    return i;
  }
  
  public final d.b XI(String paramString)
  {
    AppMethodBeat.i(208604);
    p.h(paramString, "url");
    t localt = t.oqh;
    paramString = t.XI(paramString);
    AppMethodBeat.o(208604);
    return paramString;
  }
  
  public final void XJ(String paramString)
  {
    AppMethodBeat.i(208606);
    p.h(paramString, "url");
    t localt = t.oqh;
    t.XJ(paramString);
    AppMethodBeat.o(208606);
  }
  
  public final String XK(String paramString)
  {
    AppMethodBeat.i(208607);
    p.h(paramString, "url");
    paramString = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.XZ(paramString);
    AppMethodBeat.o(208607);
    return paramString;
  }
  
  public final void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2)
  {
    AppMethodBeat.i(208609);
    p.h(paramString1, "url");
    com.tencent.mm.plugin.webview.h.b.a(paramInt1, paramString1, true, false, false, false, false, 240);
    Object localObject = t.oqh;
    t.zS(paramInt2);
    if (!zo(paramInt2))
    {
      ae.v(this.TAG, "[TRACE_PREFETCH] preAuth isEntranceOpen false, entranceBit = ".concat(String.valueOf(paramInt2)));
      AppMethodBeat.o(208609);
      return;
    }
    if ((UrlExKt.isMpUrl(paramString1)) || ((n.a((CharSequence)paramString1, (CharSequence)":", false)) && (!n.nF(paramString1, "http"))))
    {
      AppMethodBeat.o(208609);
      return;
    }
    localObject = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.XX(paramString1);
    c.a locala = c.obp;
    if (c.bOm().contains((String)localObject))
    {
      AppMethodBeat.o(208609);
      return;
    }
    locala = c.obp;
    c.bOm().EL((String)localObject);
    ae.v(this.TAG, "preauth: ".concat(String.valueOf(localObject)));
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
          AppMethodBeat.o(208609);
          return;
        }
      }
    }
  }
  
  public final void cf(List<? extends d.a> paramList)
  {
    AppMethodBeat.i(208611);
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
      ae.i(this.TAG, "prefetchWebPage, scene: " + ((d.a)localObject3).obQ);
      boolean bool;
      switch (((d.a)localObject3).obQ)
      {
      default: 
        bool = true;
      }
      while (bool)
      {
        paramList.add(localObject2);
        break;
        if (localb.a(b.a.qAR, 1) == 1) {}
        for (bool = true;; bool = false)
        {
          ae.i(this.TAG, "clicfg_webview_prefetch_api_wechat_pay_open:".concat(String.valueOf(bool)));
          break;
        }
        if (localb.a(b.a.qAP, 1) == 1) {}
        for (bool = true;; bool = false)
        {
          ae.i(this.TAG, "clicfg_webview_prefetch_api_web_open:".concat(String.valueOf(bool)));
          break;
        }
        if (localb.a(b.a.qAQ, 1) == 1) {}
        for (bool = true;; bool = false)
        {
          ae.i(this.TAG, "clicfg_webview_prefetch_api_app_brand_open:".concat(String.valueOf(bool)));
          break;
        }
        if (localb.a(b.a.qAS, 1) == 1) {}
        for (bool = true;; bool = false)
        {
          ae.i(this.TAG, "clicfg_webview_prefetch_api_sns_ad_open:".concat(String.valueOf(bool)));
          break;
        }
        bool = true;
      }
    }
    paramList = (List)paramList;
    if (((Collection)paramList).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      ae.e(this.TAG, "result is null after filter");
      AppMethodBeat.o(208611);
      return;
    }
    localObject1 = ((Iterable)paramList).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (d.a)((Iterator)localObject1).next();
      localObject3 = ((d.a)localObject2).url;
      p.g(localObject3, "it.url");
      cy((String)localObject3, ((d.a)localObject2).obQ);
      i = ((d.a)localObject2).obQ;
      localObject2 = ((d.a)localObject2).url;
      p.g(localObject2, "it.url");
      com.tencent.mm.plugin.webview.h.b.a(i, (String)localObject2, true, false, false, false, false, 240);
    }
    t.cr(paramList);
    AppMethodBeat.o(208611);
  }
  
  public final void cy(String paramString, int paramInt)
  {
    AppMethodBeat.i(208602);
    p.h(paramString, "url");
    t localt = t.oqh;
    t.cE(paramString, paramInt);
    AppMethodBeat.o(208602);
  }
  
  public final boolean eL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(208598);
    if ((paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(208598);
      return false;
    }
    if (p.i(n.bs(paramString1, "#", ""), n.bs(paramString2, "#", "")))
    {
      Object localObject = t.oqh;
      p.h(paramString1, "rawUrl");
      p.h(paramString2, "targetUrl");
      if (!p.i(n.br(paramString1, "#", paramString1), n.br(paramString2, "#", paramString2)))
      {
        localObject = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.aH(paramString2, true);
        ae.v("MicroMsg.WebPrefetcher", "isWebUrlEqual: target:#".concat(String.valueOf(localObject)));
        String str = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.aH(paramString1, true);
        ae.v("MicroMsg.WebPrefetcher", "isWebUrlEqual: raw:#".concat(String.valueOf(str)));
        if ((!p.i(localObject, str)) && (!t.eS(paramString1, paramString2))) {
          break label167;
        }
      }
      label167:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(208598);
        return true;
      }
    }
    AppMethodBeat.o(208598);
    return false;
  }
  
  public final d.b eM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(208605);
    p.h(paramString1, "referer");
    p.h(paramString2, "url");
    t localt = t.oqh;
    paramString1 = t.eM(paramString1, paramString2);
    AppMethodBeat.o(208605);
    return paramString1;
  }
  
  public final void m(List<? extends d.a> paramList, int paramInt)
  {
    AppMethodBeat.i(208610);
    p.h(paramList, "auths");
    Object localObject1 = t.oqh;
    t.zS(paramInt);
    if (!zo(paramInt))
    {
      ae.v(this.TAG, "[TRACE_PREFETCH] preAuths isEntranceOpen false, entranceBit = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(208610);
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
        if (!n.f((CharSequence)str, (CharSequence)":")) {
          break label196;
        }
        localObject3 = ((d.a)localObject3).url;
        p.g(localObject3, "info.url");
        if (n.nF((String)localObject3, "http")) {
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
    t.cr((List)paramList);
    AppMethodBeat.o(208610);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.e
 * JD-Core Version:    0.7.0.1
 */