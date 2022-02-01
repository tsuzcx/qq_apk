package com.tencent.mm.plugin.brandservice;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.brandservice.a.f.a;
import com.tencent.mm.plugin.brandservice.a.f.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.UrlExKt;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.s;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.flc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMCacheSlotManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/WebPrefetchServiceImpl;", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "()V", "TAG", "", "clearPrefetchContent", "", "url", "debugPreloadWebInfo", "", "(Ljava/lang/String;)[[Ljava/lang/String;", "getPreAuthUrl", "getPrefetchContentResp", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PrefetchResponse;", "getPrefetchResResp", "referer", "appId", "getReportScene", "", "getRespUrl", "getUrlCookie", "", "getWebId", "isDnsCached", "", "isEntranceOpen", "bit", "isUrlPreAuthed", "isWebUrlEqual", "rawUrl", "targetUrl", "preAuth", "openScene", "title", "desc", "from", "entranceBit", "preAuths", "auths", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PreAuthInfo;", "prefetchWebPage", "preAuthInfoList", "preloadVideo", "setUrlToScene", "scene", "plugin-brandservice_release"})
public final class f
  implements com.tencent.mm.plugin.brandservice.a.f
{
  private final String TAG = "MicroMsg.WebPrefetchServiceImpl";
  
  private boolean aE(int paramInt, String paramString)
  {
    AppMethodBeat.i(264943);
    boolean bool1;
    if ((((b)h.ae(b.class)).a(b.a.vTU, 65531) & paramInt) > 0) {
      bool1 = true;
    }
    boolean bool2;
    for (;;)
    {
      bool2 = bool1;
      Object localObject;
      int i;
      if (!bool1)
      {
        bool2 = bool1;
        if (paramInt == 4)
        {
          localObject = (CharSequence)paramString;
          if ((localObject != null) && (!n.ba((CharSequence)localObject))) {
            break label155;
          }
          i = 1;
          bool2 = bool1;
          if (i != 0) {}
        }
      }
      try
      {
        localObject = Uri.parse(paramString);
        p.j(localObject, "Uri.parse(url)");
        bool2 = p.h(((Uri)localObject).getHost(), "wzq.tenpay.com");
        localObject = (CharSequence)paramString;
        if ((localObject == null) || (((CharSequence)localObject).length() == 0))
        {
          i = 1;
          if ((i != 0) || (!UrlExKt.isGameCenterUrl(paramString)) || (paramInt == 2)) {
            break label201;
          }
          AppMethodBeat.o(264943);
          return false;
          bool1 = false;
          continue;
          label155:
          i = 0;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e(this.TAG, "isEntranceOpen ex=" + localException.getMessage());
          bool2 = bool1;
          continue;
          i = 0;
        }
        label201:
        AppMethodBeat.o(264943);
      }
    }
    return bool2;
  }
  
  public final f.b P(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(264940);
    p.k(paramString1, "referer");
    p.k(paramString2, "url");
    s locals = s.sNX;
    paramString1 = s.P(paramString1, paramString2, paramString3);
    AppMethodBeat.o(264940);
    return paramString1;
  }
  
  public final void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2)
  {
    AppMethodBeat.i(264944);
    p.k(paramString1, "url");
    com.tencent.mm.plugin.webview.i.f.a(paramInt1, paramString1, true, false, false, false, false, 240);
    Object localObject1 = s.sNX;
    s.Hh(paramInt2);
    if (!aE(paramInt2, paramString1))
    {
      Log.v(this.TAG, "[TRACE_PREFETCH] preAuth isEntranceOpen false, entranceBit = ".concat(String.valueOf(paramInt2)));
      AppMethodBeat.o(264944);
      return;
    }
    if (((UrlExKt.isMpUrl(paramString1)) && (!UrlExKt.isMpAlbumUrl(paramString1))) || ((n.a((CharSequence)paramString1, (CharSequence)":", false)) && (!n.M(paramString1, "http", false))))
    {
      AppMethodBeat.o(264944);
      return;
    }
    localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.apI(paramString1);
    Object localObject2 = c.soD;
    if (c.cyM().contains((String)localObject1))
    {
      localObject2 = s.sNX;
      if (!s.cCF())
      {
        AppMethodBeat.o(264944);
        return;
      }
    }
    localObject2 = c.soD;
    c.cyM().add((String)localObject1);
    long l;
    if (paramInt2 == 4)
    {
      l = 10L;
      Log.v(this.TAG, "preauth: " + (String)localObject1 + ", entranceBit: " + paramInt2);
      if (paramString2 != null) {
        break label285;
      }
      paramString2 = "";
    }
    label285:
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
          if (paramString5 == null) {
            paramString5 = "";
          }
          for (;;)
          {
            s.a(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, l);
            AppMethodBeat.o(264944);
            return;
            l = 1000L;
            break;
          }
        }
      }
    }
  }
  
  public final boolean apm(String paramString)
  {
    AppMethodBeat.i(264934);
    if (paramString != null)
    {
      s locals = s.sNX;
      boolean bool = s.apm(paramString);
      AppMethodBeat.o(264934);
      return bool;
    }
    AppMethodBeat.o(264934);
    return false;
  }
  
  public final String apn(String paramString)
  {
    AppMethodBeat.i(264935);
    Object localObject;
    if (paramString != null)
    {
      localObject = s.sNX;
      p.k(paramString, "url");
      paramString = s.aqc(paramString);
      if (paramString != null)
      {
        localObject = paramString.pHq;
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
    AppMethodBeat.o(264935);
    return localObject;
  }
  
  public final boolean apo(String paramString)
  {
    AppMethodBeat.i(264936);
    if (paramString != null)
    {
      if (n.ba((CharSequence)paramString)) {}
      for (int i = 1; i == 0; i = 0)
      {
        paramString = Uri.parse(paramString);
        p.j(paramString, "Uri.parse(url)");
        paramString = paramString.getHost();
        if (paramString == null) {
          break;
        }
        Object localObject = c.soD;
        localObject = c.cyN();
        p.j(paramString, "it");
        boolean bool = ((MMCacheSlotManager)localObject).contains(paramString);
        AppMethodBeat.o(264936);
        return bool;
      }
    }
    AppMethodBeat.o(264936);
    return false;
  }
  
  public final int app(String paramString)
  {
    AppMethodBeat.i(264938);
    s locals = s.sNX;
    int i = s.app(paramString);
    AppMethodBeat.o(264938);
    return i;
  }
  
  public final f.b apq(String paramString)
  {
    AppMethodBeat.i(264939);
    p.k(paramString, "url");
    s locals = s.sNX;
    paramString = s.apq(paramString);
    AppMethodBeat.o(264939);
    return paramString;
  }
  
  public final void apr(String paramString)
  {
    AppMethodBeat.i(264941);
    p.k(paramString, "url");
    s locals = s.sNX;
    s.apr(paramString);
    AppMethodBeat.o(264941);
  }
  
  public final String aps(String paramString)
  {
    AppMethodBeat.i(264942);
    p.k(paramString, "url");
    paramString = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.apK(paramString);
    AppMethodBeat.o(264942);
    return paramString;
  }
  
  public final void cq(List<? extends f.a> paramList)
  {
    AppMethodBeat.i(264948);
    p.k(paramList, "preAuthInfoList");
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    Object localObject3;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      localObject3 = (f.a)localObject2;
      b localb = (b)h.ae(b.class);
      Log.i(this.TAG, "prefetchWebPage, scene: " + ((f.a)localObject3).svv);
      boolean bool;
      switch (((f.a)localObject3).svv)
      {
      default: 
        bool = true;
      }
      while (bool)
      {
        paramList.add(localObject2);
        break;
        if (localb.a(b.a.vzC, 1) == 1) {}
        for (bool = true;; bool = false)
        {
          Log.i(this.TAG, "clicfg_webview_prefetch_api_wechat_pay_open:".concat(String.valueOf(bool)));
          break;
        }
        if (localb.a(b.a.vzA, 1) == 1) {}
        for (bool = true;; bool = false)
        {
          Log.i(this.TAG, "clicfg_webview_prefetch_api_web_open:".concat(String.valueOf(bool)));
          break;
        }
        if (localb.a(b.a.vzB, 1) == 1) {}
        for (bool = true;; bool = false)
        {
          Log.i(this.TAG, "clicfg_webview_prefetch_api_app_brand_open:".concat(String.valueOf(bool)));
          break;
        }
        if (localb.a(b.a.vzD, 1) == 1) {}
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
      AppMethodBeat.o(264948);
      return;
    }
    localObject1 = ((Iterable)paramList).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (f.a)((Iterator)localObject1).next();
      localObject3 = ((f.a)localObject2).url;
      p.j(localObject3, "it.url");
      da((String)localObject3, ((f.a)localObject2).svv);
      i = ((f.a)localObject2).svv;
      localObject2 = ((f.a)localObject2).url;
      p.j(localObject2, "it.url");
      com.tencent.mm.plugin.webview.i.f.a(i, (String)localObject2, true, false, false, false, false, 240);
    }
    s.cD(paramList);
    AppMethodBeat.o(264948);
  }
  
  public final void cr(List<? extends f.a> paramList)
  {
    AppMethodBeat.i(264949);
    p.k(paramList, "preAuthInfoList");
    Log.i(this.TAG, "preloadVideo:" + paramList.size());
    if (((Collection)paramList).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e(this.TAG, "preloadVideo preAuthInfoList is null or empty");
      AppMethodBeat.o(264949);
      return;
    }
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      f.a locala = (f.a)paramList.next();
      e locale = e.sKW;
      e.G(locala.url, -1, locala.extInfo);
    }
    AppMethodBeat.o(264949);
  }
  
  public final void da(String paramString, int paramInt)
  {
    AppMethodBeat.i(264937);
    p.k(paramString, "url");
    s locals = s.sNX;
    s.dg(paramString, paramInt);
    AppMethodBeat.o(264937);
  }
  
  public final boolean fr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(264933);
    if ((paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(264933);
      return false;
    }
    if (p.h(n.bz(paramString1, "#", ""), n.bz(paramString2, "#", "")))
    {
      Object localObject = s.sNX;
      p.k(paramString1, "rawUrl");
      p.k(paramString2, "targetUrl");
      if (!p.h(n.by(paramString1, "#", paramString1), n.by(paramString2, "#", paramString2)))
      {
        localObject = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.aL(paramString2, true);
        Log.v("MicroMsg.WebPrefetcher", "isWebUrlEqual: target:#".concat(String.valueOf(localObject)));
        String str = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.aL(paramString1, true);
        Log.v("MicroMsg.WebPrefetcher", "isWebUrlEqual: raw:#".concat(String.valueOf(str)));
        if ((!p.h(localObject, str)) && (!s.fw(paramString1, paramString2))) {
          break label169;
        }
      }
      label169:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(264933);
        return true;
      }
    }
    AppMethodBeat.o(264933);
    return false;
  }
  
  public final void m(List<? extends f.a> paramList, int paramInt)
  {
    AppMethodBeat.i(264946);
    p.k(paramList, "auths");
    Object localObject1 = s.sNX;
    s.Hh(paramInt);
    if (!aE(paramInt, null))
    {
      Log.v(this.TAG, "[TRACE_PREFETCH] preAuths isEntranceOpen false, entranceBit = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(264946);
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
      Object localObject3 = (f.a)localObject2;
      String str = ((f.a)localObject3).url;
      p.j(str, "info.url");
      if (s.aqf(str))
      {
        str = ((f.a)localObject3).url;
        p.j(str, "info.url");
        if (!n.g((CharSequence)str, (CharSequence)":")) {
          break label199;
        }
        localObject3 = ((f.a)localObject3).url;
        p.j(localObject3, "info.url");
        if (n.M((String)localObject3, "http", false)) {
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
    s.cD((List)paramList);
    AppMethodBeat.o(264946);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.f
 * JD-Core Version:    0.7.0.1
 */