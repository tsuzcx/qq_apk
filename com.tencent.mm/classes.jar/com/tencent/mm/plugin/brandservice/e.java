package com.tencent.mm.plugin.brandservice;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.e.a;
import com.tencent.mm.plugin.brandservice.a.e.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.UrlExKt;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.v;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.fak;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMCacheSlotManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/WebPrefetchServiceImpl;", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "()V", "TAG", "", "clearPrefetchContent", "", "url", "debugPreloadWebInfo", "", "(Ljava/lang/String;)[[Ljava/lang/String;", "getPreAuthUrl", "getPrefetchContentResp", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PrefetchResponse;", "getPrefetchResResp", "referer", "appId", "getReportScene", "", "getRespUrl", "getUrlCookie", "", "getWebId", "isDnsCached", "", "isEntranceOpen", "bit", "isUrlPreAuthed", "isWebUrlEqual", "rawUrl", "targetUrl", "preAuth", "openScene", "title", "desc", "from", "entranceBit", "preAuths", "auths", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PreAuthInfo;", "prefetchWebPage", "preAuthInfoList", "setUrlToScene", "scene", "plugin-brandservice_release"})
public final class e
  implements com.tencent.mm.plugin.brandservice.a.e
{
  private final String TAG = "MicroMsg.WebPrefetchServiceImpl";
  
  private boolean aC(int paramInt, String paramString)
  {
    AppMethodBeat.i(195120);
    boolean bool1;
    if ((((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sju, 65531) & paramInt) > 0)
    {
      bool1 = true;
      if ((bool1) || (paramInt != 4)) {
        break label133;
      }
      CharSequence localCharSequence = (CharSequence)paramString;
      if ((localCharSequence != null) && (!n.aL(localCharSequence))) {
        break label101;
      }
      paramInt = 1;
      label60:
      if (paramInt != 0) {
        break label133;
      }
    }
    label133:
    for (;;)
    {
      try
      {
        paramString = Uri.parse(paramString);
        p.g(paramString, "Uri.parse(url)");
        boolean bool2 = p.j(paramString.getHost(), "wzq.tenpay.com");
        bool1 = bool2;
        AppMethodBeat.o(195120);
        return bool1;
      }
      catch (Exception paramString)
      {
        label101:
        Log.e(this.TAG, "isEntranceOpen ex=" + paramString.getMessage());
      }
      bool1 = false;
      break;
      paramInt = 0;
      break label60;
    }
  }
  
  public final e.b R(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(195117);
    p.h(paramString1, "referer");
    p.h(paramString2, "url");
    v localv = v.pDG;
    paramString1 = v.R(paramString1, paramString2, paramString3);
    AppMethodBeat.o(195117);
    return paramString1;
  }
  
  public final void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2)
  {
    AppMethodBeat.i(195121);
    p.h(paramString1, "url");
    com.tencent.mm.plugin.webview.i.b.a(paramInt1, paramString1, true, false, false, false, false, 240);
    Object localObject1 = v.pDG;
    v.Dy(paramInt2);
    if (!aC(paramInt2, paramString1))
    {
      Log.v(this.TAG, "[TRACE_PREFETCH] preAuth isEntranceOpen false, entranceBit = ".concat(String.valueOf(paramInt2)));
      AppMethodBeat.o(195121);
      return;
    }
    if ((UrlExKt.isMpUrl(paramString1)) || ((n.a((CharSequence)paramString1, (CharSequence)":", false)) && (!n.J(paramString1, "http", false))))
    {
      AppMethodBeat.o(195121);
      return;
    }
    localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ahW(paramString1);
    Object localObject2 = c.pmm;
    if (c.clm().contains((String)localObject1))
    {
      localObject2 = v.pDG;
      if (!v.cou())
      {
        AppMethodBeat.o(195121);
        return;
      }
    }
    localObject2 = c.pmm;
    c.clm().add((String)localObject1);
    Log.v(this.TAG, "preauth: ".concat(String.valueOf(localObject1)));
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
          v.a(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1);
          AppMethodBeat.o(195121);
          return;
        }
      }
    }
  }
  
  public final boolean ahB(String paramString)
  {
    AppMethodBeat.i(195111);
    if (paramString != null)
    {
      v localv = v.pDG;
      boolean bool = v.ahB(paramString);
      AppMethodBeat.o(195111);
      return bool;
    }
    AppMethodBeat.o(195111);
    return false;
  }
  
  public final String ahC(String paramString)
  {
    AppMethodBeat.i(195112);
    Object localObject;
    if (paramString != null)
    {
      localObject = v.pDG;
      p.h(paramString, "url");
      paramString = v.aiq(paramString);
      if (paramString != null)
      {
        localObject = paramString.pFJ;
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
    AppMethodBeat.o(195112);
    return localObject;
  }
  
  public final boolean ahD(String paramString)
  {
    AppMethodBeat.i(195113);
    if (paramString != null)
    {
      if (n.aL((CharSequence)paramString)) {}
      for (int i = 1; i == 0; i = 0)
      {
        paramString = Uri.parse(paramString);
        p.g(paramString, "Uri.parse(url)");
        paramString = paramString.getHost();
        if (paramString == null) {
          break;
        }
        Object localObject = c.pmm;
        localObject = c.cln();
        p.g(paramString, "it");
        boolean bool = ((MMCacheSlotManager)localObject).contains(paramString);
        AppMethodBeat.o(195113);
        return bool;
      }
    }
    AppMethodBeat.o(195113);
    return false;
  }
  
  public final int ahE(String paramString)
  {
    AppMethodBeat.i(195115);
    v localv = v.pDG;
    int i = v.ahE(paramString);
    AppMethodBeat.o(195115);
    return i;
  }
  
  public final e.b ahF(String paramString)
  {
    AppMethodBeat.i(195116);
    p.h(paramString, "url");
    v localv = v.pDG;
    paramString = v.ahF(paramString);
    AppMethodBeat.o(195116);
    return paramString;
  }
  
  public final void ahG(String paramString)
  {
    AppMethodBeat.i(195118);
    p.h(paramString, "url");
    v localv = v.pDG;
    v.ahG(paramString);
    AppMethodBeat.o(195118);
  }
  
  public final String ahH(String paramString)
  {
    AppMethodBeat.i(195119);
    p.h(paramString, "url");
    paramString = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ahY(paramString);
    AppMethodBeat.o(195119);
    return paramString;
  }
  
  public final void cF(String paramString, int paramInt)
  {
    AppMethodBeat.i(195114);
    p.h(paramString, "url");
    v localv = v.pDG;
    v.cK(paramString, paramInt);
    AppMethodBeat.o(195114);
  }
  
  public final void cu(List<? extends e.a> paramList)
  {
    AppMethodBeat.i(195123);
    p.h(paramList, "preAuthInfoList");
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    Object localObject3;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      localObject3 = (e.a)localObject2;
      com.tencent.mm.plugin.expt.b.b localb = (com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class);
      Log.i(this.TAG, "prefetchWebPage, scene: " + ((e.a)localObject3).pmM);
      boolean bool;
      switch (((e.a)localObject3).pmM)
      {
      default: 
        bool = true;
      }
      while (bool)
      {
        paramList.add(localObject2);
        break;
        if (localb.a(b.a.rTf, 1) == 1) {}
        for (bool = true;; bool = false)
        {
          Log.i(this.TAG, "clicfg_webview_prefetch_api_wechat_pay_open:".concat(String.valueOf(bool)));
          break;
        }
        if (localb.a(b.a.rTd, 1) == 1) {}
        for (bool = true;; bool = false)
        {
          Log.i(this.TAG, "clicfg_webview_prefetch_api_web_open:".concat(String.valueOf(bool)));
          break;
        }
        if (localb.a(b.a.rTe, 1) == 1) {}
        for (bool = true;; bool = false)
        {
          Log.i(this.TAG, "clicfg_webview_prefetch_api_app_brand_open:".concat(String.valueOf(bool)));
          break;
        }
        if (localb.a(b.a.rTg, 1) == 1) {}
        for (bool = true;; bool = false)
        {
          Log.i(this.TAG, "clicfg_webview_prefetch_api_sns_ad_open:".concat(String.valueOf(bool)));
          break;
        }
        bool = true;
      }
    }
    paramList = (List)paramList;
    if (((Collection)paramList).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e(this.TAG, "result is null after filter");
      AppMethodBeat.o(195123);
      return;
    }
    localObject1 = ((Iterable)paramList).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (e.a)((Iterator)localObject1).next();
      localObject3 = ((e.a)localObject2).url;
      p.g(localObject3, "it.url");
      cF((String)localObject3, ((e.a)localObject2).pmM);
      i = ((e.a)localObject2).pmM;
      localObject2 = ((e.a)localObject2).url;
      p.g(localObject2, "it.url");
      com.tencent.mm.plugin.webview.i.b.a(i, (String)localObject2, true, false, false, false, false, 240);
    }
    localObject1 = ((Iterable)paramList).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (e.a)((Iterator)localObject1).next();
      localObject3 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.pAN;
      com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.F(((e.a)localObject2).url, -1, ((e.a)localObject2).extInfo);
    }
    v.cF(paramList);
    AppMethodBeat.o(195123);
  }
  
  public final boolean fd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(195110);
    if ((paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(195110);
      return false;
    }
    if (p.j(n.bA(paramString1, "#", ""), n.bA(paramString2, "#", "")))
    {
      Object localObject = v.pDG;
      p.h(paramString1, "rawUrl");
      p.h(paramString2, "targetUrl");
      if (!p.j(n.bz(paramString1, "#", paramString1), n.bz(paramString2, "#", paramString2)))
      {
        localObject = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.aJ(paramString2, true);
        Log.v("MicroMsg.WebPrefetcher", "isWebUrlEqual: target:#".concat(String.valueOf(localObject)));
        String str = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.aJ(paramString1, true);
        Log.v("MicroMsg.WebPrefetcher", "isWebUrlEqual: raw:#".concat(String.valueOf(str)));
        if ((!p.j(localObject, str)) && (!v.fj(paramString1, paramString2))) {
          break label167;
        }
      }
      label167:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(195110);
        return true;
      }
    }
    AppMethodBeat.o(195110);
    return false;
  }
  
  public final void m(List<? extends e.a> paramList, int paramInt)
  {
    AppMethodBeat.i(195122);
    p.h(paramList, "auths");
    Object localObject1 = v.pDG;
    v.Dy(paramInt);
    if (!aC(paramInt, null))
    {
      Log.v(this.TAG, "[TRACE_PREFETCH] preAuths isEntranceOpen false, entranceBit = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(195122);
      return;
    }
    localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label199:
    label202:
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      Object localObject3 = (e.a)localObject2;
      String str = ((e.a)localObject3).url;
      p.g(str, "info.url");
      if (!UrlExKt.isMpUrl(str))
      {
        str = ((e.a)localObject3).url;
        p.g(str, "info.url");
        if (!n.e((CharSequence)str, (CharSequence)":")) {
          break label199;
        }
        localObject3 = ((e.a)localObject3).url;
        p.g(localObject3, "info.url");
        if (n.J((String)localObject3, "http", false)) {
          break label199;
        }
      }
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt != 0) {
          break label202;
        }
        paramList.add(localObject2);
        break;
      }
    }
    v.cF((List)paramList);
    AppMethodBeat.o(195122);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.e
 * JD-Core Version:    0.7.0.1
 */