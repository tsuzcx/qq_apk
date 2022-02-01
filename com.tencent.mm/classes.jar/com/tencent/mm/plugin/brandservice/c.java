package com.tencent.mm.plugin.brandservice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.ah.q;
import com.tencent.mm.ah.u;
import com.tencent.mm.ah.y;
import com.tencent.mm.plugin.brandservice.a.b.b;
import com.tencent.mm.plugin.brandservice.b.g.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.UrlExKt;
import com.tencent.mm.protocal.protobuf.fo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.t;
import d.a.j;
import d.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/BrandServiceImpl;", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService;", "()V", "TAG", "", "bizNativeVideoOpen", "", "getBizNativeVideoOpen", "()Ljava/lang/Boolean;", "setBizNativeVideoOpen", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "chatSessions", "Ljava/util/concurrent/ConcurrentHashMap;", "", "addReportParamForBizUrl", "url", "scene", "", "subScene", "clickTime", "addToPreload", "", "itemShowType", "openScene", "vals", "", "", "(Ljava/lang/String;II[Ljava/lang/Object;)V", "appMsgPaySuccess", "canPreloadIn", "doSendMpShareVideoMsg", "toUser", "msgInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "appendText", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Landroid/os/Bundle;", "getAppMsgRelatedInfo", "Lcom/tencent/mm/message/AppMsgRelatedInfo;", "reqType", "getAppMsgRelatedInfoForAppMsg", "items", "", "Lcom/tencent/mm/message/AppMsgUrlReqInfo;", "getAppMsgRelatedInfoForBizMsg", "getChannelFeeds", "getChatSession", "chatName", "getHardCodeUrl", "getUrlKey", "isBizNativePageOpen", "isBizNativeVideoOpen", "isBizTimeLineOpen", "isMpArticle", "isMpUrl", "isPayReadingOpen", "isShowBigPic", "baseInfo", "baseTopItem", "count", "isSupportStyle", "style", "openWebViewUseFastLoad", "context", "Landroid/content/Context;", "data", "Lorg/json/JSONObject;", "ret", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "preCreateWebView", "preloadByIdAndUrls", "preloadByInfoIdAndBuffer", "saveChannelFeeds", "channelFeeds", "setChatSession", "startPreloadWebView", "isNative", "intent", "Landroid/content/Intent;", "openType", "result", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService$PreloadWebViewResult;", "tryPreloadTmplWebview", "updateChannelFeeds", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService$UpdateChannelFeedsCallback;", "Companion", "plugin-brandservice_release"})
public final class c
  implements com.tencent.mm.plugin.brandservice.a.b
{
  private static final ak num;
  private static final ak nun;
  private static final ak nuo;
  public static final a nup;
  private final String TAG;
  private Boolean nuk;
  private final ConcurrentHashMap<String, Long> nul;
  
  static
  {
    AppMethodBeat.i(6487);
    nup = new a((byte)0);
    num = new ak();
    nun = new ak();
    nuo = new ak();
    AppMethodBeat.o(6487);
  }
  
  public c()
  {
    AppMethodBeat.i(6486);
    this.TAG = "MicroMsg.BrandServiceImpl";
    this.nul = new ConcurrentHashMap();
    AppMethodBeat.o(6486);
  }
  
  public final boolean D(Object paramObject1, Object paramObject2)
  {
    Object localObject = null;
    AppMethodBeat.i(6485);
    if (!(paramObject1 instanceof t)) {
      paramObject1 = null;
    }
    for (;;)
    {
      t localt = (t)paramObject1;
      if (!(paramObject2 instanceof com.tencent.mm.ah.v)) {}
      for (paramObject1 = localObject;; paramObject1 = paramObject2)
      {
        boolean bool = com.tencent.mm.plugin.brandservice.ui.b.a.a(localt, (com.tencent.mm.ah.v)paramObject1);
        AppMethodBeat.o(6485);
        return bool;
      }
    }
  }
  
  public final boolean Tg(String paramString)
  {
    AppMethodBeat.i(198798);
    if (paramString != null)
    {
      boolean bool = UrlExKt.isMpArticleUrl(paramString);
      AppMethodBeat.o(198798);
      return bool;
    }
    AppMethodBeat.o(198798);
    return false;
  }
  
  public final p Th(String paramString)
  {
    AppMethodBeat.i(6473);
    g.a locala = g.a.nvr;
    paramString = g.a.Tv(paramString);
    AppMethodBeat.o(6473);
    return paramString;
  }
  
  public final void Ti(String paramString)
  {
    AppMethodBeat.i(6483);
    d.g.b.k.h(paramString, "chatName");
    ((Map)this.nul).put(paramString, Long.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(6483);
  }
  
  public final long Tj(String paramString)
  {
    AppMethodBeat.i(6484);
    d.g.b.k.h(paramString, "chatName");
    paramString = (Long)this.nul.get(paramString);
    if (paramString != null)
    {
      long l = paramString.longValue();
      AppMethodBeat.o(6484);
      return l;
    }
    AppMethodBeat.o(6484);
    return -1L;
  }
  
  public final String Tk(String paramString)
  {
    AppMethodBeat.i(175443);
    d.g.b.k.h(paramString, "url");
    paramString = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.TL(paramString);
    AppMethodBeat.o(175443);
    return paramString;
  }
  
  public final void Tl(String paramString)
  {
    AppMethodBeat.i(175448);
    ac.d(this.TAG, "alvinluo saveChannelFeeds %s", new Object[] { paramString });
    aw.aKU("ChannelFeedData").putString("video_channel_feeds_data", paramString);
    AppMethodBeat.o(175448);
  }
  
  public final void a(Context paramContext, JSONObject paramJSONObject, HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(175450);
    d.g.b.k.h(paramHashMap, "ret");
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(175450);
      return;
    }
    int i = paramJSONObject.optInt("item_show_type");
    Object localObject = com.tencent.mm.plugin.webview.g.g.b(i, paramJSONObject);
    if (!bs.isNullOrNil((String)localObject))
    {
      ((Map)paramHashMap).put("success", Boolean.FALSE);
      ((Map)paramHashMap).put("desc", localObject);
      AppMethodBeat.o(175450);
      return;
    }
    Bundle localBundle = new Bundle();
    if ((i == 5) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).yr(i))) {
      com.tencent.mm.plugin.webview.g.g.a(localBundle, i, paramJSONObject);
    }
    for (;;)
    {
      com.tencent.mm.plugin.brandservice.a.b.a locala = new com.tencent.mm.plugin.brandservice.a.b.a();
      Intent localIntent = new Intent();
      if ((localBundle.getBoolean("isNativePage")) && (paramContext != null))
      {
        localIntent.putExtras(localBundle);
        float f = com.tencent.mm.cd.a.eSs();
        com.tencent.mm.plugin.webview.g.g.a(paramContext, localBundle.getString("currentInfo"), f, localIntent, false);
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1061L, 21L, 1L, false);
      }
      i = localBundle.getInt("scene");
      int j = localBundle.getInt("subscene", 10000);
      localObject = localBundle.getString("url");
      paramJSONObject = (JSONObject)localObject;
      if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).isMpUrl((String)localObject))
      {
        k = (int)(System.currentTimeMillis() / 1000L);
        paramJSONObject = ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).d((String)localObject, i, j, k);
      }
      localObject = (com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class);
      int k = localBundle.getInt("item_show_type");
      localBundle.getBoolean("isNativePage");
      boolean bool = ((com.tencent.mm.plugin.brandservice.a.b)localObject).a(paramContext, paramJSONObject, k, i, j, localIntent, localBundle.getInt("openType"), locala);
      ((Map)paramHashMap).put("success", Boolean.valueOf(bool));
      if ((!locala.success) && (locala.message != null))
      {
        paramContext = (Map)paramHashMap;
        paramJSONObject = locala.message;
        d.g.b.k.g(paramJSONObject, "result.message");
        paramContext.put("desc", paramJSONObject);
      }
      AppMethodBeat.o(175450);
      return;
      localBundle.putString("url", paramJSONObject.optString("url"));
      localBundle.putInt("item_show_type", paramJSONObject.optInt("item_show_type"));
      localBundle.putInt("scene", paramJSONObject.optInt("scene"));
      localBundle.putInt("subscene", paramJSONObject.optInt("subscene"));
      localBundle.putInt("openType", paramJSONObject.optInt("openType"));
      localBundle.putString("biz_video_channel_session_id", paramJSONObject.optString("channelSessionId"));
    }
  }
  
  public final void a(b.b paramb)
  {
    AppMethodBeat.i(175449);
    com.tencent.mm.plugin.brandservice.b.c localc = com.tencent.mm.plugin.brandservice.b.c.nva;
    com.tencent.mm.plugin.brandservice.b.c.b(paramb);
    AppMethodBeat.o(175449);
  }
  
  public final void a(String paramString, final int paramInt1, final int paramInt2, final Object... paramVarArgs)
  {
    AppMethodBeat.i(6461);
    d.g.b.k.h(paramString, "url");
    d.g.b.k.h(paramVarArgs, "vals");
    String str = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.TD(paramString);
    if (num.contains(str))
    {
      AppMethodBeat.o(6461);
      return;
    }
    num.Bk(str);
    ac.v(this.TAG, "preloadData: addToPreload:".concat(String.valueOf(str)));
    com.tencent.e.h.JZN.f((Runnable)new b(paramString, paramInt1, paramInt2, paramVarArgs), "tmplPreload");
    AppMethodBeat.o(6461);
  }
  
  public final void a(String paramString1, y paramy, String paramString2, com.tencent.mm.ipcinvoker.d<Bundle> paramd)
  {
    AppMethodBeat.i(6482);
    d.g.b.k.h(paramString1, "toUser");
    d.g.b.k.h(paramy, "msgInfo");
    d.g.b.k.h(paramd, "callback");
    com.tencent.mm.plugin.webview.ui.tools.media.c localc = com.tencent.mm.plugin.webview.ui.tools.media.c.CKY;
    com.tencent.mm.plugin.webview.ui.tools.media.c.b(paramString1, paramy, paramString2, paramd);
    AppMethodBeat.o(6482);
  }
  
  public final boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, Intent paramIntent)
  {
    AppMethodBeat.i(198800);
    d.g.b.k.h(paramContext, "context");
    d.g.b.k.h(paramString, "url");
    d.g.b.k.h(paramIntent, "intent");
    boolean bool = com.tencent.mm.plugin.brandservice.ui.timeline.preload.k.a(paramContext, paramString, paramInt1, paramInt2, paramInt3, paramIntent, 0, null, false, 896);
    AppMethodBeat.o(198800);
    return bool;
  }
  
  public final boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, Intent paramIntent, int paramInt4, com.tencent.mm.plugin.brandservice.a.b.a parama)
  {
    AppMethodBeat.i(198801);
    d.g.b.k.h(paramContext, "context");
    d.g.b.k.h(paramString, "url");
    d.g.b.k.h(paramIntent, "intent");
    d.g.b.k.h(parama, "result");
    boolean bool = com.tencent.mm.plugin.brandservice.ui.timeline.preload.k.a(paramContext, paramString, paramInt1, paramInt2, paramInt3, paramIntent, paramInt4, parama, false, 512);
    AppMethodBeat.o(198801);
    return bool;
  }
  
  public final boolean bIO()
  {
    AppMethodBeat.i(6458);
    boolean bool = com.tencent.mm.storage.v.bIO();
    AppMethodBeat.o(6458);
    return bool;
  }
  
  public final boolean bIP()
  {
    AppMethodBeat.i(6460);
    if (this.nuk == null) {
      if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pQg, 1) != 1) {
        break label97;
      }
    }
    label97:
    for (boolean bool = true;; bool = false)
    {
      this.nuk = Boolean.valueOf(bool);
      ac.i(this.TAG, "bizNativeVideoOpen: " + this.nuk);
      Boolean localBoolean = this.nuk;
      if (localBoolean == null) {
        d.g.b.k.fOy();
      }
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(6460);
      return bool;
    }
  }
  
  public final boolean bIQ()
  {
    AppMethodBeat.i(6474);
    com.tencent.mm.plugin.brandservice.b.a locala = com.tencent.mm.plugin.brandservice.b.a.nuP;
    boolean bool = com.tencent.mm.plugin.brandservice.b.a.bIQ();
    AppMethodBeat.o(6474);
    return bool;
  }
  
  public final String bIR()
  {
    AppMethodBeat.i(6480);
    String str = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.bLH();
    AppMethodBeat.o(6480);
    return str;
  }
  
  public final void bIS()
  {
    AppMethodBeat.i(6481);
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.a.bMy();
    AppMethodBeat.o(6481);
  }
  
  public final String bIT()
  {
    AppMethodBeat.i(175447);
    String str2 = aw.aKU("ChannelFeedData").getString("video_channel_feeds_data", "");
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(175447);
    return str1;
  }
  
  public final void cb(List<? extends q> paramList)
  {
    AppMethodBeat.i(198799);
    d.g.b.k.h(paramList, "items");
    if (bs.gY(paramList))
    {
      AppMethodBeat.o(198799);
      return;
    }
    com.tencent.e.h.JZN.f((Runnable)new d(paramList), "getAppMsgRelatedInfo");
    AppMethodBeat.o(198799);
  }
  
  public final void cp(String paramString, final int paramInt)
  {
    AppMethodBeat.i(175441);
    if (paramString == null)
    {
      AppMethodBeat.o(175441);
      return;
    }
    com.tencent.e.h.JZN.f((Runnable)new c(paramString, paramInt), "getAppMsgRelatedInfo");
    AppMethodBeat.o(175441);
  }
  
  public final void cq(String paramString, int paramInt)
  {
    AppMethodBeat.i(6475);
    d.g.b.k.h(paramString, "url");
    com.tencent.mm.plugin.brandservice.b.a locala = com.tencent.mm.plugin.brandservice.b.a.nuP;
    com.tencent.mm.plugin.brandservice.b.a.cq(paramString, paramInt);
    AppMethodBeat.o(6475);
  }
  
  public final String d(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(6457);
    paramString = m.d(paramString, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(6457);
    return paramString;
  }
  
  public final void i(List<? extends List<String>> paramList, final int paramInt)
  {
    AppMethodBeat.i(6469);
    d.g.b.k.h(paramList, "items");
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    Object localObject3;
    int i;
    label117:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      localObject3 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.TD((String)((List)localObject2).get(0));
      if (num.contains((String)localObject3)) {}
      for (i = 0;; i = 1)
      {
        if (i == 0) {
          break label117;
        }
        paramList.add(localObject2);
        break;
        num.Bk((String)localObject3);
      }
    }
    paramList = (List)paramList;
    if (!((Collection)paramList).isEmpty()) {
      i = 1;
    }
    while (i != 0)
    {
      if (ac.getLogLevel() == 0)
      {
        localObject1 = this.TAG;
        localObject2 = new StringBuilder("preloadData: preloadByIdAndUrls:");
        Object localObject4 = (Iterable)paramList;
        localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
        localObject4 = ((Iterable)localObject4).iterator();
        for (;;)
        {
          if (((Iterator)localObject4).hasNext())
          {
            ((Collection)localObject3).add(com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.TD((String)((List)((Iterator)localObject4).next()).get(0)));
            continue;
            i = 0;
            break;
          }
        }
        ac.v((String)localObject1, (List)localObject3);
      }
      com.tencent.e.h.JZN.f((Runnable)new f(paramList, this, paramInt), "tmplPreload");
    }
    AppMethodBeat.o(6469);
  }
  
  public final boolean isMpUrl(String paramString)
  {
    AppMethodBeat.i(6453);
    if (paramString != null)
    {
      boolean bool = UrlExKt.isMpUrl(paramString);
      AppMethodBeat.o(6453);
      return bool;
    }
    AppMethodBeat.o(6453);
    return false;
  }
  
  public final void j(List<String[]> paramList, final int paramInt)
  {
    AppMethodBeat.i(6470);
    d.g.b.k.h(paramList, "items");
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    Object localObject3;
    int i;
    label110:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      localObject3 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.TD(((String[])localObject2)[0]);
      if (num.contains((String)localObject3)) {}
      for (i = 0;; i = 1)
      {
        if (i == 0) {
          break label110;
        }
        paramList.add(localObject2);
        break;
        num.Bk((String)localObject3);
      }
    }
    paramList = (List)paramList;
    if (!((Collection)paramList).isEmpty()) {
      i = 1;
    }
    while (i != 0)
    {
      if (ac.getLogLevel() == 0)
      {
        localObject1 = this.TAG;
        localObject2 = new StringBuilder("preloadData: preloadByInfoIdAndBuffer:");
        Object localObject4 = (Iterable)paramList;
        localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
        localObject4 = ((Iterable)localObject4).iterator();
        for (;;)
        {
          if (((Iterator)localObject4).hasNext())
          {
            ((Collection)localObject3).add(com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.TD(((String[])localObject4.next())[0]));
            continue;
            i = 0;
            break;
          }
        }
        ac.v((String)localObject1, (List)localObject3);
      }
      com.tencent.e.h.JZN.f((Runnable)new g(paramList, this, paramInt), "tmplPreload");
    }
    AppMethodBeat.o(6470);
  }
  
  public final void k(List<? extends q> paramList, final int paramInt)
  {
    AppMethodBeat.i(6471);
    d.g.b.k.h(paramList, "items");
    if (bs.gY(paramList))
    {
      AppMethodBeat.o(6471);
      return;
    }
    com.tencent.e.h.JZN.f((Runnable)new e(paramList, paramInt), "getAppMsgRelatedInfo");
    AppMethodBeat.o(6471);
  }
  
  public final boolean yr(int paramInt)
  {
    AppMethodBeat.i(6459);
    if ((paramInt == 5) && (bIP()))
    {
      AppMethodBeat.o(6459);
      return true;
    }
    AppMethodBeat.o(6459);
    return false;
  }
  
  public final boolean ys(int paramInt)
  {
    AppMethodBeat.i(6476);
    boolean bool = com.tencent.mm.plugin.brandservice.ui.timeline.preload.k.ys(paramInt);
    AppMethodBeat.o(6476);
    return bool;
  }
  
  public final void yt(int paramInt)
  {
    AppMethodBeat.i(6479);
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.k.run(paramInt);
    AppMethodBeat.o(6479);
  }
  
  public final boolean yu(int paramInt)
  {
    AppMethodBeat.i(198802);
    boolean bool = com.tencent.mm.plugin.brandservice.ui.timeline.a.d.yu(paramInt);
    AppMethodBeat.o(198802);
    return bool;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/BrandServiceImpl$Companion;", "", "()V", "preauthLimiter", "Lcom/tencent/mm/sdk/platformtools/MMCacheSlotManager;", "getPreauthLimiter", "()Lcom/tencent/mm/sdk/platformtools/MMCacheSlotManager;", "prednsLimiter", "getPrednsLimiter", "preloadLimiter", "getPreloadLimiter", "plugin-brandservice_release"})
  public static final class a {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(String paramString, int paramInt1, int paramInt2, Object[] paramArrayOfObject) {}
    
    public final void run()
    {
      AppMethodBeat.i(6448);
      String str = this.kFm;
      int i = paramInt1;
      int j = paramInt2;
      Object[] arrayOfObject = paramVarArgs;
      com.tencent.mm.plugin.brandservice.ui.timeline.preload.k.a(str, i, j, Arrays.copyOf(arrayOfObject, arrayOfObject.length));
      AppMethodBeat.o(6448);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(String paramString, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(6449);
      com.tencent.mm.plugin.brandservice.b.g localg = com.tencent.mm.plugin.brandservice.b.g.nvq;
      com.tencent.mm.plugin.brandservice.b.g.j(this.kFm, paramInt, this.nur, this.nut);
      AppMethodBeat.o(6449);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(List paramList) {}
    
    public final void run()
    {
      AppMethodBeat.i(198797);
      Object localObject1 = com.tencent.mm.plugin.brandservice.b.g.nvq;
      localObject1 = this.ikj;
      int i = this.nur;
      d.g.b.k.h(localObject1, "items");
      com.tencent.mm.plugin.brandservice.b.g.nvo = 0L;
      com.tencent.mm.plugin.brandservice.b.g.nvp.clear();
      LinkedList localLinkedList = new LinkedList();
      Object localObject3 = (Iterable)localObject1;
      Object localObject2 = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      Object localObject4;
      Object localObject5;
      label147:
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = ((Iterator)localObject3).next();
        localObject5 = (q)localObject4;
        if (((q)localObject5).Url == null) {}
        for (boolean bool = false;; bool = UrlExKt.isMpArticleUrl((String)localObject5))
        {
          if (!bool) {
            break label147;
          }
          ((Collection)localObject2).add(localObject4);
          break;
          localObject5 = ((q)localObject5).Url;
          d.g.b.k.g(localObject5, "it.Url");
        }
      }
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (q)((Iterator)localObject2).next();
        localObject4 = new fo();
        ((fo)localObject4).Url = ((q)localObject3).Url;
        localObject5 = ((fo)localObject4).Url;
        d.g.b.k.g(localObject5, "appMsgUrlInfo.Url");
        ((fo)localObject4).hkN = com.tencent.mm.plugin.brandservice.b.g.Tt((String)localObject5);
        ((fo)localObject4).hkQ = ((q)localObject3).hkQ;
        ((fo)localObject4).ReqType = ((q)localObject3).ReqType;
        if (((fo)localObject4).ReqType > 0) {
          localLinkedList.add(localObject4);
        }
      }
      ac.v(com.tencent.mm.plugin.brandservice.b.g.TAG, "getAppMsgRelatedInfoForAppMsg size:" + ((List)localObject1).size());
      com.tencent.mm.plugin.brandservice.b.g.b(localLinkedList, i);
      AppMethodBeat.o(198797);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(List paramList, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(6450);
      Object localObject1 = com.tencent.mm.plugin.brandservice.b.g.nvq;
      Object localObject2 = this.ikj;
      int i = paramInt;
      d.g.b.k.h(localObject2, "items");
      com.tencent.mm.plugin.brandservice.b.g.nvo = 0L;
      com.tencent.mm.plugin.brandservice.b.g.nvp.clear();
      localObject1 = new LinkedList();
      Object localObject3 = (Iterable)localObject2;
      localObject2 = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      Object localObject4;
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (q)((Iterator)localObject3).next();
        j.a((Collection)localObject2, (Iterable)((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(((q)localObject4).msgId, ((q)localObject4).hkR).hkS);
      }
      localObject3 = (Iterable)localObject2;
      localObject2 = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      Object localObject5;
      label241:
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = ((Iterator)localObject3).next();
        localObject5 = (com.tencent.mm.ah.v)localObject4;
        if (((com.tencent.mm.ah.v)localObject5).url == null) {}
        for (boolean bool = false;; bool = UrlExKt.isMpArticleUrl((String)localObject5))
        {
          if (!bool) {
            break label241;
          }
          ((Collection)localObject2).add(localObject4);
          break;
          localObject5 = ((com.tencent.mm.ah.v)localObject5).url;
          d.g.b.k.g(localObject5, "it.url");
        }
      }
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (com.tencent.mm.ah.v)((Iterator)localObject2).next();
        localObject3 = new fo();
        ((fo)localObject3).Url = ((com.tencent.mm.ah.v)localObject4).url;
        localObject5 = ((fo)localObject3).Url;
        d.g.b.k.g(localObject5, "appMsgUrlInfo.Url");
        ((fo)localObject3).hkN = com.tencent.mm.plugin.brandservice.b.g.Tt((String)localObject5);
        ((fo)localObject3).hkQ = ((com.tencent.mm.ah.v)localObject4).type;
        if (i == 0)
        {
          if (((com.tencent.mm.ah.v)localObject4).hhb == 1)
          {
            localObject4 = com.tencent.mm.plugin.brandservice.b.a.nuP;
            if (com.tencent.mm.plugin.brandservice.b.a.bIQ())
            {
              ((fo)localObject3).ReqType = 2;
              ((LinkedList)localObject1).add(localObject3);
            }
          }
        }
        else
        {
          if (((com.tencent.mm.ah.v)localObject4).hhb == 1)
          {
            localObject4 = com.tencent.mm.plugin.brandservice.b.a.nuP;
            if (!com.tencent.mm.plugin.brandservice.b.a.bIQ()) {}
          }
          for (((fo)localObject3).ReqType = 3;; ((fo)localObject3).ReqType = 1)
          {
            ((LinkedList)localObject1).add(localObject3);
            break;
          }
        }
      }
      ac.v(com.tencent.mm.plugin.brandservice.b.g.TAG, "getAppMsgRelatedInfoForBizMsg size:" + ((LinkedList)localObject1).size());
      com.tencent.mm.plugin.brandservice.b.g.b((LinkedList)localObject1, i);
      AppMethodBeat.o(6450);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/brandservice/BrandServiceImpl$preloadByIdAndUrls$2$2"})
  static final class f
    implements Runnable
  {
    f(List paramList, c paramc, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(6451);
      com.tencent.mm.plugin.brandservice.ui.timeline.preload.k.i(this.mhW, paramInt);
      AppMethodBeat.o(6451);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/brandservice/BrandServiceImpl$preloadByInfoIdAndBuffer$2$2"})
  static final class g
    implements Runnable
  {
    g(List paramList, c paramc, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(6452);
      com.tencent.mm.plugin.brandservice.ui.timeline.preload.k.j(this.mhW, paramInt);
      AppMethodBeat.o(6452);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.c
 * JD-Core Version:    0.7.0.1
 */