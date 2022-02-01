package com.tencent.mm.plugin.brandservice;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.api.h.a;
import com.tencent.mm.plugin.brandservice.api.h.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.UrlExKt;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.r;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.protocal.protobuf.ghq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMCacheSlotManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/WebPrefetchServiceImpl;", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "()V", "TAG", "", "clearPrefetchContent", "", "url", "debugPreloadWebInfo", "", "(Ljava/lang/String;)[[Ljava/lang/String;", "getPreAuthUrl", "prefetchId", "getPrefetchContentResp", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PrefetchResponse;", "getPrefetchResResp", "referer", "appId", "pkgKey", "getReportScene", "", "getRespUrl", "getUrlCookie", "", "getWebId", "isDnsCached", "", "isEntranceOpen", "bit", "isUrlPreAuthed", "isWebUrlEqual", "rawUrl", "targetUrl", "preAuth", "openScene", "title", "desc", "from", "entranceBit", "preAuths", "auths", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PreAuthInfo;", "prefetchWebPage", "preAuthInfoList", "preloadVideo", "setUrlToScene", "scene", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements com.tencent.mm.plugin.brandservice.api.h
{
  private final String TAG = "MicroMsg.WebPrefetchServiceImpl";
  
  private boolean aR(int paramInt, String paramString)
  {
    AppMethodBeat.i(301509);
    if (!com.tencent.mm.plugin.expansions.e.aQh())
    {
      AppMethodBeat.o(301509);
      return false;
    }
    boolean bool1;
    if ((((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zmy, 65531) & paramInt) > 0) {
      bool1 = true;
    }
    boolean bool2;
    for (;;)
    {
      bool2 = bool1;
      CharSequence localCharSequence;
      int i;
      if (!bool1)
      {
        bool2 = bool1;
        if (paramInt == 4)
        {
          localCharSequence = (CharSequence)paramString;
          if ((localCharSequence != null) && (!n.bp(localCharSequence))) {
            break label157;
          }
          i = 1;
          bool2 = bool1;
          if (i != 0) {}
        }
      }
      try
      {
        bool2 = s.p(Uri.parse(paramString).getHost(), "wzq.tenpay.com");
        localCharSequence = (CharSequence)paramString;
        if ((localCharSequence == null) || (localCharSequence.length() == 0))
        {
          i = 1;
          if ((i != 0) || (!UrlExKt.isGameCenterUrl(paramString)) || (paramInt == 2)) {
            break label193;
          }
          AppMethodBeat.o(301509);
          return false;
          bool1 = false;
          continue;
          label157:
          i = 0;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e(this.TAG, s.X("isEntranceOpen ex=", localException.getMessage()));
          bool2 = bool1;
          continue;
          i = 0;
        }
        label193:
        AppMethodBeat.o(301509);
      }
    }
    return bool2;
  }
  
  public final void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2)
  {
    AppMethodBeat.i(301552);
    s.u(paramString1, "url");
    if (!com.tencent.mm.plugin.expansions.e.aQh())
    {
      AppMethodBeat.o(301552);
      return;
    }
    com.tencent.mm.plugin.webview.h.h.a(paramInt1, paramString1, true, false, false, false, false, 240);
    Object localObject1 = r.vTf;
    r.HG(paramInt2);
    if (!aR(paramInt2, paramString1))
    {
      Log.v(this.TAG, s.X("[TRACE_PREFETCH] preAuth isEntranceOpen false, entranceBit = ", Integer.valueOf(paramInt2)));
      AppMethodBeat.o(301552);
      return;
    }
    if ((!r.ajE(paramString1)) || ((n.a((CharSequence)paramString1, (CharSequence)":", false)) && (!n.U(paramString1, "http", false))))
    {
      AppMethodBeat.o(301552);
      return;
    }
    localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ajj(paramString1);
    Object localObject2 = c.vAt;
    if (c.dbK().contains((String)localObject1))
    {
      localObject2 = r.vTf;
      if (!r.dfO())
      {
        AppMethodBeat.o(301552);
        return;
      }
    }
    localObject2 = c.vAt;
    c.dbK().add((String)localObject1);
    long l;
    if (paramInt2 == 4)
    {
      l = 10L;
      Log.v(this.TAG, "preauth: " + (String)localObject1 + ", entranceBit: " + paramInt2);
      if (paramString2 != null) {
        break label281;
      }
      paramString2 = "";
      label222:
      if (paramString3 != null) {
        break label284;
      }
      paramString3 = "";
      label231:
      if (paramString4 != null) {
        break label287;
      }
      paramString4 = "";
      label240:
      if (paramString5 != null) {
        break label290;
      }
      paramString5 = "";
    }
    label281:
    label284:
    label287:
    label290:
    for (;;)
    {
      r.a(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, l, null, 128);
      AppMethodBeat.o(301552);
      return;
      l = 1000L;
      break;
      break label222;
      break label231;
      break label240;
    }
  }
  
  public final String aiJ(String paramString)
  {
    AppMethodBeat.i(301523);
    if (paramString == null)
    {
      AppMethodBeat.o(301523);
      return "";
    }
    Object localObject = r.vTf;
    s.u(paramString, "url");
    paramString = r.ajB(paramString);
    if (paramString == null) {
      paramString = "";
    }
    while (paramString == null)
    {
      AppMethodBeat.o(301523);
      return "";
      localObject = paramString.sMq;
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = "";
      }
    }
    AppMethodBeat.o(301523);
    return paramString;
  }
  
  public final boolean aiK(String paramString)
  {
    AppMethodBeat.i(301524);
    if (paramString != null)
    {
      Object localObject = (CharSequence)paramString;
      if ((localObject == null) || (n.bp((CharSequence)localObject))) {}
      for (int i = 1; i == 0; i = 0)
      {
        paramString = Uri.parse(paramString).getHost();
        if (paramString == null) {
          break;
        }
        localObject = c.vAt;
        boolean bool = c.dbL().contains(paramString);
        AppMethodBeat.o(301524);
        return bool;
      }
    }
    AppMethodBeat.o(301524);
    return false;
  }
  
  public final int aiL(String paramString)
  {
    AppMethodBeat.i(301530);
    r localr = r.vTf;
    int i = r.aiL(paramString);
    AppMethodBeat.o(301530);
    return i;
  }
  
  public final void aiM(String paramString)
  {
    AppMethodBeat.i(301546);
    s.u(paramString, "url");
    r localr = r.vTf;
    r.aiM(paramString);
    AppMethodBeat.o(301546);
  }
  
  public final String aiN(String paramString)
  {
    AppMethodBeat.i(301550);
    s.u(paramString, "url");
    paramString = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ajl(paramString);
    AppMethodBeat.o(301550);
    return paramString;
  }
  
  public final void dC(String paramString, int paramInt)
  {
    AppMethodBeat.i(301526);
    s.u(paramString, "url");
    r localr = r.vTf;
    r.dI(paramString, paramInt);
    AppMethodBeat.o(301526);
  }
  
  public final void ei(List<? extends h.a> paramList)
  {
    AppMethodBeat.i(301559);
    s.u(paramList, "preAuthInfoList");
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    Object localObject3;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      localObject3 = (h.a)localObject2;
      com.tencent.mm.plugin.expt.b.c localc = (com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class);
      Log.i(this.TAG, s.X("prefetchWebPage, scene: ", Integer.valueOf(((h.a)localObject3).vAZ)));
      boolean bool;
      switch (((h.a)localObject3).vAZ)
      {
      default: 
        bool = true;
      }
      while (bool)
      {
        paramList.add(localObject2);
        break;
        if (localc.a(c.a.yNh, 1) == 1) {}
        for (bool = true;; bool = false)
        {
          Log.i(this.TAG, s.X("clicfg_webview_prefetch_api_wechat_pay_open:", Boolean.valueOf(bool)));
          break;
        }
        if (localc.a(c.a.yNf, 1) == 1) {}
        for (bool = true;; bool = false)
        {
          Log.i(this.TAG, s.X("clicfg_webview_prefetch_api_web_open:", Boolean.valueOf(bool)));
          break;
        }
        if (localc.a(c.a.yNg, 1) == 1) {}
        for (bool = true;; bool = false)
        {
          Log.i(this.TAG, s.X("clicfg_webview_prefetch_api_app_brand_open:", Boolean.valueOf(bool)));
          break;
        }
        if (localc.a(c.a.yNi, 1) == 1) {}
        for (bool = true;; bool = false)
        {
          Log.i(this.TAG, s.X("clicfg_webview_prefetch_api_sns_ad_open:", Boolean.valueOf(bool)));
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
      AppMethodBeat.o(301559);
      return;
    }
    localObject1 = ((Iterable)paramList).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (h.a)((Iterator)localObject1).next();
      localObject3 = ((h.a)localObject2).url;
      s.s(localObject3, "it.url");
      dC((String)localObject3, ((h.a)localObject2).vAZ);
      i = ((h.a)localObject2).vAZ;
      localObject2 = ((h.a)localObject2).url;
      s.s(localObject2, "it.url");
      com.tencent.mm.plugin.webview.h.h.a(i, (String)localObject2, true, false, false, false, false, 240);
    }
    r.ew(paramList);
    AppMethodBeat.o(301559);
  }
  
  public final void ej(List<? extends h.a> paramList)
  {
    AppMethodBeat.i(301562);
    s.u(paramList, "preAuthInfoList");
    Log.i(this.TAG, s.X("preloadVideo:", Integer.valueOf(paramList.size())));
    if (((Collection)paramList).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e(this.TAG, "preloadVideo preAuthInfoList is null or empty");
      AppMethodBeat.o(301562);
      return;
    }
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      h.a locala = (h.a)paramList.next();
      com.tencent.mm.plugin.brandservice.ui.timeline.preload.e locale = com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.vQH;
      com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.I(locala.url, -1, locala.extInfo);
    }
    AppMethodBeat.o(301562);
  }
  
  public final boolean fI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(301515);
    if ((paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(301515);
      return false;
    }
    if (s.p(n.bY(paramString1, "#", ""), n.bY(paramString2, "#", "")))
    {
      Object localObject = r.vTf;
      s.u(paramString1, "rawUrl");
      s.u(paramString2, "targetUrl");
      if (!s.p(n.bX(paramString1, "#", paramString1), n.bX(paramString2, "#", paramString2)))
      {
        localObject = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.aX(paramString2, true);
        Log.v("MicroMsg.WebPrefetcher", s.X("isWebUrlEqual: target:#", localObject));
        String str = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.aX(paramString1, true);
        Log.v("MicroMsg.WebPrefetcher", s.X("isWebUrlEqual: raw:#", str));
        ah localah = ah.aiuX;
        if ((!s.p(localObject, str)) && (!r.fT(paramString1, paramString2))) {
          break label166;
        }
      }
      label166:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(301515);
        return true;
      }
    }
    AppMethodBeat.o(301515);
    return false;
  }
  
  public final boolean fJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(301519);
    if (paramString1 == null)
    {
      AppMethodBeat.o(301519);
      return false;
    }
    r localr = r.vTf;
    boolean bool = r.fJ(paramString1, paramString2);
    AppMethodBeat.o(301519);
    return bool;
  }
  
  public final h.b fK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(301539);
    s.u(paramString1, "url");
    r localr = r.vTf;
    paramString1 = r.fK(paramString1, paramString2);
    AppMethodBeat.o(301539);
    return paramString1;
  }
  
  public final h.b n(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(301542);
    s.u(paramString1, "referer");
    s.u(paramString2, "url");
    r localr = r.vTf;
    paramString1 = r.n(paramString1, paramString2, paramString3, paramString4);
    AppMethodBeat.o(301542);
    return paramString1;
  }
  
  public final void z(List<? extends h.a> paramList, int paramInt)
  {
    AppMethodBeat.i(301555);
    s.u(paramList, "auths");
    if (!com.tencent.mm.plugin.expansions.e.aQh())
    {
      AppMethodBeat.o(301555);
      return;
    }
    Object localObject1 = r.vTf;
    r.HG(paramInt);
    if (!aR(paramInt, null))
    {
      Log.v(this.TAG, s.X("[TRACE_PREFETCH] preAuths isEntranceOpen false, entranceBit = ", Integer.valueOf(paramInt)));
      AppMethodBeat.o(301555);
      return;
    }
    localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label212:
    label215:
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      Object localObject3 = (h.a)localObject2;
      String str = ((h.a)localObject3).url;
      s.s(str, "info.url");
      if (r.ajE(str))
      {
        str = ((h.a)localObject3).url;
        s.s(str, "info.url");
        if (!n.i((CharSequence)str, (CharSequence)":")) {
          break label212;
        }
        localObject3 = ((h.a)localObject3).url;
        s.s(localObject3, "info.url");
        if (n.U((String)localObject3, "http", false)) {
          break label212;
        }
      }
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt != 0) {
          break label215;
        }
        paramList.add(localObject2);
        break;
      }
    }
    r.ew((List)paramList);
    AppMethodBeat.o(301555);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.e
 * JD-Core Version:    0.7.0.1
 */