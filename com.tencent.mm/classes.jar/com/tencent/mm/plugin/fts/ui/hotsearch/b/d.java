package com.tencent.mm.plugin.fts.ui.hotsearch.b;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.fts.ui.o;
import com.tencent.mm.plugin.record.c;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.al;
import com.tencent.mm.plugin.websearch.api.as;
import com.tencent.mm.plugin.websearch.webview.e;
import com.tencent.mm.plugin.websearch.webview.n;
import com.tencent.mm.protocal.protobuf.dlw;
import com.tencent.mm.protocal.protobuf.dlz;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.j;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/fts/ui/hotsearch/webview/FTSRcmGuideSearchWebData;", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchQueryData;", "Lcom/tencent/mm/plugin/fts/ui/hotsearch/model/FTSMainState;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "uiComponent", "Lcom/tencent/mm/plugin/websearch/webview/IWebSearchQueryUIComponent;", "(Lcom/tencent/mm/plugin/websearch/webview/IWebSearchQueryUIComponent;)V", "bizCacheObjMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/fts/ui/hotsearch/webview/FTSRcmGuideSearchWebData$BizCacheObj;", "netSceneBizSearchGuide", "Lcom/tencent/mm/plugin/websearch/api/NetSceneWebSearchGuide;", "cancelSearchShare", "", "destroy", "getBizObjCacheFileName", "scene", "", "type", "forceNew", "", "getSearchData", "paramStr", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onTeachSearchDataReady", "requestType", "jsonData", "isCacheData", "requestId", "BizCacheObj", "Companion", "ui-fts_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends n<com.tencent.mm.plugin.fts.ui.hotsearch.a.a>
{
  public static final b HAa;
  private final HashMap<String, a> HAb;
  private ad HAc;
  
  static
  {
    AppMethodBeat.i(265814);
    HAa = new b((byte)0);
    AppMethodBeat.o(265814);
  }
  
  public d(e<com.tencent.mm.plugin.fts.ui.hotsearch.a.a> parame)
  {
    super(parame);
    AppMethodBeat.i(265800);
    this.HAb = new HashMap();
    com.tencent.mm.kernel.h.aZW().a(1048, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(265800);
  }
  
  private void iG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(265808);
    Log.i("MicroMsg.WebSearch.RcmGuideSearchWebData", "onTeachSearchDataReady");
    Object localObject1 = this.WrK;
    if (localObject1 == null) {
      localObject1 = null;
    }
    for (;;)
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("requestType", 0);
      ((JSONObject)localObject2).put("json", paramString1);
      ((JSONObject)localObject2).put("isCacheData", 0);
      ((JSONObject)localObject2).put("requestId", paramString2);
      if (localObject1 != null) {
        j.a((aq)localObject1, (kotlin.d.f)bg.kCh(), null, (kotlin.g.a.m)new c(this, (JSONObject)localObject2, null), 2);
      }
      AppMethodBeat.o(265808);
      return;
      localObject1 = ((com.tencent.mm.plugin.websearch.webview.f)localObject1).getActivityContext();
      if (localObject1 == null)
      {
        localObject1 = null;
      }
      else
      {
        localObject2 = com.tencent.mm.ui.component.k.aeZF;
        localObject1 = ((com.tencent.mm.plugin.mvvmbase.a.a)com.tencent.mm.ui.component.k.nq((Context)localObject1).q(com.tencent.mm.plugin.mvvmbase.a.a.class)).gsu();
      }
    }
  }
  
  public final void aEN(String paramString)
  {
    AppMethodBeat.i(265830);
    kotlin.g.b.s.u(paramString, "paramStr");
    Object localObject1 = new JSONObject(paramString);
    paramString = new HashMap();
    Object localObject2 = ((JSONObject)localObject1).keys();
    kotlin.g.b.s.s(localObject2, "requestObj.keys()");
    while (((Iterator)localObject2).hasNext())
    {
      str = (String)((Iterator)localObject2).next();
      Map localMap = (Map)paramString;
      kotlin.g.b.s.s(str, "it");
      localMap.put(str, ((JSONObject)localObject1).opt(str));
    }
    Log.i("MicroMsg.FTS.FTSHotSearchJSApi", "RcmGuideSearchWebData, getTeachSearchData: %s", new Object[] { paramString });
    int i = aj.c((Map)paramString, "scene", 0);
    int j = aj.c((Map)paramString, "type", 0);
    aj.c((Map)paramString, "requestType", 0);
    int k = Util.nullAsInt(paramString.get("webview_instance_id"), -1);
    localObject1 = (String)paramString.get("requestId");
    localObject2 = (String)paramString.get("guideInfo");
    String str = (String)paramString.get("sessionId");
    aj.av((Map)paramString, "ignoreCache");
    Log.i("MicroMsg.FTS.FTSHotSearchJSApi", "getTeachSearchData realTime, webviewID = %d", new Object[] { Integer.valueOf(k) });
    paramString = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    long l = al.bix("discoverSearchEntry").optLong("guideParam");
    this.HAc = new ad(i, j, aj.asY(9), k, paramString, l, (String)localObject1, str, (String)localObject2);
    com.tencent.mm.kernel.h.aZW().a((p)this.HAc, 0);
    switch (o.fyB())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(265830);
      return;
      ai.d(10000, str, "", "", (String)localObject1, j);
      AppMethodBeat.o(265830);
      return;
      ai.d(103, str, "", "", (String)localObject1, j);
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(265850);
    super.destroy();
    com.tencent.mm.kernel.h.aZW().b(1048, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(265850);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(265844);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramp);
    Log.e("MicroMsg.WebSearch.RcmGuideSearchWebData", "getTeachSearchData onSceneEnd errType %d,errCode %d, scene = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramp });
    if ((paramp instanceof ad))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.WebSearch.RcmGuideSearchWebData", "onSceneEnd errType %d,errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        iG("", ((ad)paramp).hOG);
        AppMethodBeat.o(265844);
        return;
      }
      paramString = (ad)paramp;
      a locala = new a();
      locala.scene = paramString.scene;
      locala.HAd = paramString.WoF.aaSd;
      locala.hMi = paramString.WoF.aayd;
      locala.HAe = (System.currentTimeMillis() / 1000L);
      locala.xVe = paramString.WoF.aayf;
      locala.type = paramString.businessType;
      paramInt1 = locala.scene;
      paramInt2 = locala.type;
      paramp = "FTS_BizCacheObj" + paramInt1 + '-' + paramInt2;
      Object localObject = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
      paramp = paramp + '-' + localObject;
      Log.i("MicroMsg.WebSearch.RcmGuideSearchWebData", "NetSceneWebSearchGuide cgi data %s ", new Object[] { locala.hMi });
      if (!Util.isNullOrNil(locala.hMi))
      {
        iG(locala.hMi, paramString.hOG);
        Log.i("MicroMsg.WebSearch.RcmGuideSearchWebData", "onTeachSearchDataReady, %s", new Object[] { locala.hMi });
        switch (o.fyB())
        {
        default: 
          label356:
          this.HAb.put(paramp, locala);
          if (locala.HAd == 0L)
          {
            paramInt2 = locala.scene;
            int i = locala.type;
            Log.i("MicroMsg.WebSearch.RcmGuideSearchWebData", "delete biz cache %d %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(i) });
            paramp = c.bzO();
            paramString = a.D(paramInt2, i, true);
            if (paramString == null)
            {
              paramString = null;
              label437:
              if ((paramString == null) || (paramString.jKS() != true)) {
                break label644;
              }
              paramInt1 = 1;
              label451:
              if (paramInt1 != 0) {
                paramString.diJ();
              }
              paramString = a.D(paramInt2, i, false);
              if (paramString != null) {
                break label649;
              }
              paramString = null;
              label474:
              if ((paramString == null) || (paramString.jKS() != true)) {
                break label663;
              }
              paramInt1 = 1;
              label488:
              if ((paramInt1 != 0) && (paramString != null)) {
                paramString.diJ();
              }
            }
          }
          break;
        }
      }
      for (;;)
      {
        if ((locala.scene != 20) || (locala.type != 0)) {
          break label891;
        }
        as.a(locala.scene, 1, locala.xVe, locala.type, 2, locala.fyV(), 1);
        AppMethodBeat.o(265844);
        return;
        iG("", paramString.hOG);
        break;
        ai.a(paramString.scene, paramString.sessionId, "", "", paramString.hOG, false, "", paramString.getType());
        break label356;
        ai.a(paramString.scene, paramString.sessionId, "", "", paramString.hOG, false, "", paramString.getType());
        break label356;
        paramString = new u(paramp, paramString);
        break label437;
        label644:
        paramInt1 = 0;
        break label451;
        label649:
        paramString = new u(paramp, paramString);
        break label474;
        label663:
        paramInt1 = 0;
        break label488;
        paramp = new dlw();
        paramp.scene = locala.scene;
        paramp.aayd = locala.hMi;
        paramp.aaRX = locala.HAd;
        paramp.aaRY = locala.HAe;
        paramp.YYr = locala.xVe;
        paramp.vhJ = locala.type;
        paramString = null;
        try
        {
          paramp = paramp.toByteArray();
          paramString = paramp;
        }
        catch (IOException paramp)
        {
          label749:
          break label749;
        }
        if (paramString != null)
        {
          paramp = new u(c.bzO(), a.D(locala.scene, locala.type, true));
          localObject = paramp.jKP();
          kotlin.g.b.s.checkNotNull(localObject);
          if (!((u)localObject).jKS())
          {
            localObject = paramp.jKP();
            kotlin.g.b.s.checkNotNull(localObject);
            ((u)localObject).jKY();
          }
          if (paramp.jKS()) {
            paramp.diJ();
          }
          y.f(com.tencent.mm.vfs.ah.v(paramp.jKT()), paramString, paramString.length);
          Log.i("MicroMsg.WebSearch.RcmGuideSearchWebData", "save bizCacheFile %s %d", new Object[] { com.tencent.mm.vfs.ah.v(paramp.jKT()), Integer.valueOf(paramString.length) });
        }
        else
        {
          Log.i("MicroMsg.WebSearch.RcmGuideSearchWebData", "save bizCacheFile fail");
        }
      }
      label891:
      as.a(locala.scene, 1, locala.xVe, locala.type, 1, "", 0);
    }
    AppMethodBeat.o(265844);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/fts/ui/hotsearch/webview/FTSRcmGuideSearchWebData$BizCacheObj;", "", "()V", "cacheSecond", "", "getCacheSecond", "()J", "setCacheSecond", "(J)V", "invalid", "", "getInvalid", "()Z", "setInvalid", "(Z)V", "isAvailable", "json", "", "getJson", "()Ljava/lang/String;", "setJson", "(Ljava/lang/String;)V", "lastCacheSecond", "getLastCacheSecond", "setLastCacheSecond", "<set-?>", "resultString", "getResultString", "scene", "", "getScene", "()I", "setScene", "(I)V", "searchID", "getSearchID", "setSearchID", "type", "getType", "setType", "deleteCache", "", "getBizObjCacheFileName", "forceNew", "readFromFile", "saveToFile", "ui-fts_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    long HAd;
    long HAe;
    String hMi;
    int scene;
    private String sgs;
    int type;
    String xVe;
    
    public static String D(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(265793);
      String str1 = "FTS_BizCacheObj" + paramInt1 + '-' + paramInt2;
      String str2 = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
      str2 = str1 + '-' + str2;
      if (paramBoolean)
      {
        AppMethodBeat.o(265793);
        return str2;
      }
      if (new u(c.bzO(), str2).jKS())
      {
        AppMethodBeat.o(265793);
        return str2;
      }
      AppMethodBeat.o(265793);
      return str1;
    }
    
    public final String fyV()
    {
      AppMethodBeat.i(265803);
      if (this.sgs == null) {
        this.sgs = "";
      }
      try
      {
        localObject = new JSONObject(this.hMi).optJSONObject("data").optJSONObject("hotwords").optJSONArray("items");
        localArrayList = new ArrayList();
        i = 0;
        k = ((JSONArray)localObject).length();
        if (k <= 0) {
          break label96;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject;
          ArrayList localArrayList;
          int k;
          int j;
          label96:
          continue;
          int i = j;
        }
      }
      j = i + 1;
      localArrayList.add(Uri.encode(((JSONArray)localObject).optJSONObject(i).optString("hotword")));
      if (j >= k)
      {
        this.sgs = TextUtils.join((CharSequence)"|", (Iterable)localArrayList);
        localObject = this.sgs;
        AppMethodBeat.o(265803);
        return localObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/fts/ui/hotsearch/webview/FTSRcmGuideSearchWebData$Companion;", "", "()V", "TAG", "", "ui-fts_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super kotlin.ah>, Object>
  {
    int label;
    
    c(d paramd, JSONObject paramJSONObject, kotlin.d.d<? super c> paramd1)
    {
      super(paramd1);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(265790);
      paramObject = (kotlin.d.d)new c(this.HAf, this.HzX, paramd);
      AppMethodBeat.o(265790);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(265786);
      Object localObject = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(265786);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.HAf.WrK;
      if (paramObject != null)
      {
        paramObject = paramObject.getWebView();
        if (paramObject != null)
        {
          localObject = this.HzX;
          com.tencent.mm.plugin.websearch.webview.m localm = com.tencent.mm.plugin.websearch.webview.m.WrX;
          localObject = ((JSONObject)localObject).toString();
          kotlin.g.b.s.s(localObject, "returnObj.toString()");
          com.tencent.mm.plugin.websearch.webview.m.a(paramObject, "onTeachSearchDataReady", (String)localObject);
        }
      }
      paramObject = kotlin.ah.aiuX;
      AppMethodBeat.o(265786);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.hotsearch.b.d
 * JD-Core Version:    0.7.0.1
 */