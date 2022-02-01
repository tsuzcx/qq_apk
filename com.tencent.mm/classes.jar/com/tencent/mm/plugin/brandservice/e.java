package com.tencent.mm.plugin.brandservice;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.d;
import com.tencent.mm.plugin.brandservice.a.d.a;
import com.tencent.mm.plugin.brandservice.a.d.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.UrlExKt;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.s;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import d.g.b.k;
import d.l;
import d.n.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/WebPrefetchServiceImpl;", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "()V", "TAG", "", "clearPrefetchContent", "", "url", "debugPreloadWebInfo", "", "(Ljava/lang/String;)[[Ljava/lang/String;", "getPreAuthUrl", "getPrefetchContentResp", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PrefetchResponse;", "getPrefetchResResp", "referer", "getReportScene", "", "getWebId", "isDnsCached", "", "isEntranceOpen", "bit", "isUrlPreAuthed", "isWebUrlEqual", "rawUrl", "targetUrl", "preAuth", "openScene", "appId", "title", "desc", "from", "entranceBit", "preAuths", "auths", "", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PreAuthInfo;", "setUrlToScene", "scene", "plugin-brandservice_release"})
public final class e
  implements d
{
  private final String TAG = "MicroMsg.WebPrefetchServiceImpl";
  
  private static boolean xD(int paramInt)
  {
    AppMethodBeat.i(193035);
    if ((((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pvu, 65531) & paramInt) > 0)
    {
      AppMethodBeat.o(193035);
      return true;
    }
    AppMethodBeat.o(193035);
    return false;
  }
  
  public final boolean Pc(String paramString)
  {
    AppMethodBeat.i(193027);
    if (paramString != null)
    {
      s locals = s.neQ;
      boolean bool = s.Pc(paramString);
      AppMethodBeat.o(193027);
      return bool;
    }
    AppMethodBeat.o(193027);
    return false;
  }
  
  public final boolean Pd(String paramString)
  {
    AppMethodBeat.i(193028);
    if (paramString != null)
    {
      if (n.aC((CharSequence)paramString)) {}
      for (int i = 1; i == 0; i = 0)
      {
        paramString = Uri.parse(paramString);
        k.g(paramString, "Uri.parse(url)");
        paramString = paramString.getHost();
        if (paramString == null) {
          break;
        }
        c.a locala = c.mRZ;
        boolean bool = c.bBY().contains(paramString);
        AppMethodBeat.o(193028);
        return bool;
      }
    }
    AppMethodBeat.o(193028);
    return false;
  }
  
  public final int Pe(String paramString)
  {
    AppMethodBeat.i(193030);
    s locals = s.neQ;
    int i = s.Pe(paramString);
    AppMethodBeat.o(193030);
    return i;
  }
  
  public final d.b Pf(String paramString)
  {
    AppMethodBeat.i(193031);
    k.h(paramString, "url");
    s locals = s.neQ;
    paramString = s.Pf(paramString);
    AppMethodBeat.o(193031);
    return paramString;
  }
  
  public final void Pg(String paramString)
  {
    AppMethodBeat.i(193033);
    k.h(paramString, "url");
    s locals = s.neQ;
    s.Pg(paramString);
    AppMethodBeat.o(193033);
  }
  
  public final String Ph(String paramString)
  {
    AppMethodBeat.i(193034);
    k.h(paramString, "url");
    paramString = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.Pu(paramString);
    AppMethodBeat.o(193034);
    return paramString;
  }
  
  public final void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2)
  {
    AppMethodBeat.i(193036);
    k.h(paramString1, "url");
    com.tencent.mm.plugin.webview.h.b.a(paramInt1, paramString1, true, false, false, false, false, 240);
    Object localObject = s.neQ;
    s.yi(paramInt2);
    if (!xD(paramInt2))
    {
      ad.v(this.TAG, "[TRACE_PREFETCH] preAuth isEntranceOpen false, entranceBit = ".concat(String.valueOf(paramInt2)));
      AppMethodBeat.o(193036);
      return;
    }
    if ((UrlExKt.isMpUrl(paramString1)) || ((n.a((CharSequence)paramString1, (CharSequence)":", false)) && (!n.mA(paramString1, "http"))))
    {
      AppMethodBeat.o(193036);
      return;
    }
    localObject = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.Ps(paramString1);
    c.a locala = c.mRZ;
    if (c.bBX().contains((String)localObject))
    {
      AppMethodBeat.o(193036);
      return;
    }
    locala = c.mRZ;
    c.bBX().xe((String)localObject);
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
          s.a(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1);
          AppMethodBeat.o(193036);
          return;
        }
      }
    }
  }
  
  public final void cm(String paramString, int paramInt)
  {
    AppMethodBeat.i(193029);
    k.h(paramString, "url");
    s locals = s.neQ;
    s.cs(paramString, paramInt);
    AppMethodBeat.o(193029);
  }
  
  public final boolean en(String paramString1, String paramString2)
  {
    AppMethodBeat.i(193026);
    if ((paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(193026);
      return false;
    }
    if (k.g(n.bd(paramString1, "#", ""), n.bd(paramString2, "#", "")))
    {
      Object localObject = s.neQ;
      k.h(paramString1, "rawUrl");
      k.h(paramString2, "targetUrl");
      if (!k.g(n.bc(paramString1, "#", paramString1), n.bc(paramString2, "#", paramString2)))
      {
        localObject = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.aC(paramString2, true);
        ad.v("MicroMsg.WebPrefetcher", "isWebUrlEqual: target:#".concat(String.valueOf(localObject)));
        String str = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.aC(paramString1, true);
        ad.v("MicroMsg.WebPrefetcher", "isWebUrlEqual: raw:#".concat(String.valueOf(str)));
        if ((!k.g(localObject, str)) && (!s.et(paramString1, paramString2))) {
          break label158;
        }
      }
      label158:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(193026);
        return true;
      }
    }
    AppMethodBeat.o(193026);
    return false;
  }
  
  public final d.b eo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(193032);
    k.h(paramString1, "referer");
    k.h(paramString2, "url");
    s locals = s.neQ;
    paramString1 = s.eo(paramString1, paramString2);
    AppMethodBeat.o(193032);
    return paramString1;
  }
  
  public final void l(List<? extends d.a> paramList, int paramInt)
  {
    AppMethodBeat.i(193037);
    k.h(paramList, "auths");
    Object localObject1 = s.neQ;
    s.yi(paramInt);
    if (!xD(paramInt))
    {
      ad.v(this.TAG, "[TRACE_PREFETCH] preAuths isEntranceOpen false, entranceBit = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(193037);
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
      k.g(str, "info.url");
      if (!UrlExKt.isMpUrl(str))
      {
        str = ((d.a)localObject3).url;
        k.g(str, "info.url");
        if (!n.f((CharSequence)str, (CharSequence)":")) {
          break label196;
        }
        localObject3 = ((d.a)localObject3).url;
        k.g(localObject3, "info.url");
        if (n.mA((String)localObject3, "http")) {
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
    s.cn((List)paramList);
    AppMethodBeat.o(193037);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.e
 * JD-Core Version:    0.7.0.1
 */