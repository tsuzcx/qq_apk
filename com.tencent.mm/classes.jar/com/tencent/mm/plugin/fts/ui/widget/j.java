package com.tencent.mm.plugin.fts.ui.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.ui.FTSMainUI;
import com.tencent.mm.plugin.fts.ui.k;
import com.tencent.mm.plugin.fts.ui.l;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.at;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.plugin.websearch.webview.f;
import com.tencent.mm.plugin.websearch.webview.g;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.protocal.protobuf.fks;
import com.tencent.mm.protocal.protobuf.fll;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.ad;
import com.tencent.xweb.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class j
  implements com.tencent.mm.an.i, d
{
  private static final int maxHeight;
  i BNE;
  private boolean BSQ;
  public WebSearchWebView BTk;
  private FrameLayout BTl;
  private fll BTm;
  public g<fll> BTn;
  private com.tencent.mm.plugin.fts.ui.e.a BTo;
  String fOc;
  private boolean fwi;
  private FrameLayout soh;
  
  static
  {
    AppMethodBeat.i(176953);
    maxHeight = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 163);
    AppMethodBeat.o(176953);
  }
  
  public j(i parami, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(176944);
    this.fOc = "";
    this.soh = paramFrameLayout;
    this.BNE = parami;
    this.BTm = new fll();
    this.BTm.sessionId = e.eqP();
    this.BTm.scene = 1;
    Object localObject1 = this.BTm;
    Object localObject2 = new HashMap();
    ((HashMap)localObject2).put("scene", "1");
    ((HashMap)localObject2).put("lang", LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()));
    ((HashMap)localObject2).put("platform", "android");
    ((HashMap)localObject2).put("version", String.valueOf(ai.anf(5).bkM()));
    ((HashMap)localObject2).put("netType", ai.anV());
    ((HashMap)localObject2).put("wechatVersion", BuildInfo.CLIENT_VERSION);
    ((HashMap)localObject2).put("webSearchVersion", String.valueOf(ai.anf(0).bkM()));
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("file://");
    localStringBuffer.append(ai.anf(5).gRd());
    localStringBuffer.append("/");
    localStringBuffer.append("app.html");
    localStringBuffer.append("?");
    localStringBuffer.append(ai.toUrlParams((Map)localObject2));
    ((fll)localObject1).url = localStringBuffer.toString();
    this.BTn = new g(this);
    this.BTo = new com.tencent.mm.plugin.fts.ui.e.a(this);
    localObject1 = new f((byte)0);
    localObject2 = new com.tencent.mm.plugin.fts.ui.e.b();
    this.BTk = new WebSearchWebView(parami.BSg);
    this.BTk.a((x)localObject2, (ad)localObject1);
    this.BTk.addJavascriptInterface(this.BTo, "pardusJSApi");
    int i = com.tencent.mm.ci.a.kr(MMApplicationContext.getContext());
    this.BTl = new FrameLayout(MMApplicationContext.getContext());
    this.BTl.addView(this.BTk, new FrameLayout.LayoutParams(i, maxHeight));
    paramFrameLayout.addView(this.BTl, new FrameLayout.LayoutParams(i, maxHeight));
    paramFrameLayout.measure(i, -2);
    paramFrameLayout.requestLayout();
    Log.i("MicroMsg.FTS.PardusWebViewLogic", "containerWidth: %s webviewWidth: %s", new Object[] { Integer.valueOf(paramFrameLayout.getMeasuredWidth()), Integer.valueOf(this.BTk.getMeasuredWidth()) });
    this.BTk.loadUrl(this.BTm.url);
    com.tencent.mm.kernel.h.aGY().a(2975, this);
    AppMethodBeat.o(176944);
  }
  
  public final void aW(final JSONObject paramJSONObject)
  {
    boolean bool2 = true;
    AppMethodBeat.i(191336);
    for (;;)
    {
      try
      {
        final int j = paramJSONObject.optInt("height");
        JSONArray localJSONArray = paramJSONObject.optJSONArray("sugList");
        paramJSONObject = paramJSONObject.optString("docId");
        final int i;
        if (localJSONArray != null)
        {
          i = localJSONArray.length();
          break label124;
          this.BSQ = bool1;
          if (!Util.isNullOrNil(paramJSONObject))
          {
            bool1 = bool2;
            this.fwi = bool1;
            this.BNE.BSg.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(194382);
                int i = Math.round(com.tencent.mm.cj.a.hrl() * j);
                Log.i("MicroMsg.FTS.PardusWebViewLogic", "start to update webview %d， height: %d， isXWalkKernel: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(j.a(j.this).isXWalkKernel()) });
                j.a(j.this).getLayoutParams().height = i;
                j.a(j.this).requestLayout();
                j.b(j.this).getLayoutParams().height = 0;
                j.b(j.this).requestLayout();
                ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, i });
                localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
                {
                  public final void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
                  {
                    AppMethodBeat.i(189346);
                    int i = ((Integer)paramAnonymous2ValueAnimator.getAnimatedValue()).intValue();
                    Log.i("MicroMsg.FTS.PardusWebViewLogic", "webview onAnimationUpdate %d", new Object[] { Integer.valueOf(i) });
                    j.b(j.this).getLayoutParams().height = i;
                    j.b(j.this).requestLayout();
                    AppMethodBeat.o(189346);
                  }
                });
                i locali = j.c(j.this);
                localValueAnimator.addListener(new i.a(locali, locali.BNf));
                localValueAnimator.setDuration(400L);
                localValueAnimator.start();
                j.d(j.this).setVisibility(0);
                j.d(j.this).post(new Runnable()
                {
                  public final void run()
                  {
                    int j = 0;
                    AppMethodBeat.i(190063);
                    Log.i("MicroMsg.FTS.PardusWebViewLogic", "update footer view");
                    Object localObject = j.c(j.this);
                    boolean bool1 = j.e(j.this);
                    boolean bool2 = j.f(j.this);
                    ((i)localObject).BSQ = bool1;
                    ((i)localObject).fwi = bool2;
                    ((i)localObject).cVU();
                    localObject = j.c(j.this).BSg.BNX.BND;
                    int k = j.5.this.BTs;
                    if (j.f(j.this)) {}
                    for (int i = 2;; i = 0)
                    {
                      ((com.tencent.mm.plugin.fts.ui.c.b)localObject).hy(k, i);
                      if (j.e(j.this)) {
                        j.c(j.this).BSg.BNX.BND.A(System.currentTimeMillis(), "PardusSug");
                      }
                      if (j.f(j.this))
                      {
                        i = j;
                        if (j.e(j.this)) {
                          i = 1;
                        }
                        j.c(j.this).BSg.BNX.BND.a(i, System.currentTimeMillis(), "PardusMore", 3, j.5.this.BTt);
                        j.c(j.this).BSg.BNX.BND.a(i + 1, System.currentTimeMillis(), j.5.this.BTt, 3, j.5.this.BTt);
                      }
                      AppMethodBeat.o(190063);
                      return;
                    }
                  }
                });
                AppMethodBeat.o(194382);
              }
            });
            AppMethodBeat.o(191336);
          }
        }
        else
        {
          i = 0;
          break label124;
          bool1 = false;
          continue;
        }
        bool1 = false;
        continue;
        if (i <= 0) {
          continue;
        }
      }
      catch (Exception paramJSONObject)
      {
        AppMethodBeat.o(191336);
        return;
      }
      label124:
      boolean bool1 = true;
    }
  }
  
  public final void b(int paramInt, final JSONObject paramJSONObject)
  {
    AppMethodBeat.i(191363);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(191363);
      return;
    case 1: 
      try
      {
        localObject1 = paramJSONObject.optJSONObject("actionInfo");
        paramJSONObject = ((JSONObject)localObject1).optString("query");
        localObject1 = new JSONObject(((JSONObject)localObject1).optString("extParams"));
        localObject2 = new HashMap();
        localObject3 = ((JSONObject)localObject1).keys();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (String)((Iterator)localObject3).next();
          ((HashMap)localObject2).put(localObject4, ((JSONObject)localObject1).optString((String)localObject4));
        }
        this.BNE.l((Map)localObject2, paramJSONObject);
      }
      catch (Exception paramJSONObject)
      {
        Log.printErrStackTrace("MicroMsg.FTS.PardusWebViewLogic", paramJSONObject, "pardusAction", new Object[0]);
        AppMethodBeat.o(191363);
        return;
      }
      this.BNE.BSg.BNX.BND.SJ(28);
      this.BNE.BSg.BNX.BNy = true;
      this.BNE.SN(6);
      l.a(this.fOc, 1, 1, this.BNE.BSg.ptD, this.BNE.BSg.BNX.BND, 28, "", "", "");
      AppMethodBeat.o(191363);
      return;
    case 2: 
      localObject1 = paramJSONObject.optJSONObject("actionInfo");
      paramJSONObject = ((JSONObject)localObject1).optString("query");
      localObject3 = ((JSONObject)localObject1).optString("extParams");
      localObject2 = ((JSONObject)localObject1).optString("cachePageResult");
      localObject3 = new JSONObject((String)localObject3);
      localObject4 = new HashMap();
      Iterator localIterator = ((JSONObject)localObject3).keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ((HashMap)localObject4).put(str, ((JSONObject)localObject3).optString(str));
      }
      ((HashMap)localObject4).put("cachePageResult", localObject2);
      ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.websearch.api.h.class)).a(this.BNE.BSg, 3, paramJSONObject, String.valueOf(e.BHi), (Map)localObject4);
      this.BNE.BSg.BNX.BND.SJ(27);
      this.BNE.BSg.BNX.BNy = true;
      this.BNE.SN(5);
      if (!this.BSQ) {
        break;
      }
    }
    for (paramInt = 2;; paramInt = 1)
    {
      localObject2 = ((JSONObject)localObject1).optString("nickname");
      localObject3 = ((JSONObject)localObject1).optString("docId");
      localObject1 = ((JSONObject)localObject1).optString("appId");
      l.a(paramJSONObject, paramInt, 2, this.BNE.BSg.ptD, this.BNE.BSg.BNX.BND, 27, "3$".concat(String.valueOf(localObject2)), (String)localObject3, (String)localObject1);
      AppMethodBeat.o(191363);
      return;
      localObject2 = new dio();
      ((dio)localObject2).RXp = paramJSONObject.optInt("actionType");
      localObject1 = paramJSONObject.optJSONObject("actionInfo");
      ((dio)localObject2).UserName = ((JSONObject)localObject1).optString("userName");
      ((dio)localObject2).SsP = ((JSONObject)localObject1).optString("relativeURL");
      ((dio)localObject2).SsQ = ((JSONObject)localObject1).optInt("appVersion");
      ((dio)localObject2).query = ((JSONObject)localObject1).optString("query", "");
      ((dio)localObject2).TPY = ((JSONObject)localObject1).optString("extParams");
      ((dio)localObject2).CMD = ((JSONObject)localObject1).optString("jumpUrl");
      this.BNE.a((dio)localObject2);
      localObject2 = new JSONObject();
      paramJSONObject.put("type", "pardusAction");
      paramJSONObject.put("actionId", "1");
      paramJSONObject.put("params", paramJSONObject);
      paramJSONObject = ((JSONObject)localObject2).toString();
      this.BNE.BSg.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184536);
          j.this.hH("pardusActionCallBack", paramJSONObject);
          AppMethodBeat.o(184536);
        }
      });
      this.BNE.SN(4);
      this.BNE.BSg.BNX.BND.SJ(27);
      this.BNE.BSg.BNX.BNy = true;
      if (this.BSQ) {}
      for (paramInt = 2;; paramInt = 1)
      {
        paramJSONObject = ((JSONObject)localObject1).optString("query");
        localObject2 = ((JSONObject)localObject1).optString("nickname");
        localObject3 = ((JSONObject)localObject1).optString("docId");
        localObject1 = ((JSONObject)localObject1).optString("appId");
        l.a(paramJSONObject, paramInt, 1, this.BNE.BSg.ptD, this.BNE.BSg.BNX.BND, 27, "3$".concat(String.valueOf(localObject2)), (String)localObject3, (String)localObject1);
        break;
      }
    }
  }
  
  public final void clearData()
  {
    this.BSQ = false;
    this.fwi = false;
    this.fOc = "";
  }
  
  public final void esA()
  {
    AppMethodBeat.i(191374);
    i locali = this.BNE;
    com.tencent.e.h.ZvG.bc(new i.5(locali));
    AppMethodBeat.o(191374);
  }
  
  public final void esF()
  {
    AppMethodBeat.i(176945);
    if (this.soh != null) {
      this.soh.setVisibility(8);
    }
    AppMethodBeat.o(176945);
  }
  
  public final WebSearchWebView esG()
  {
    return this.BTk;
  }
  
  public final g<fll> esH()
  {
    return this.BTn;
  }
  
  public final com.tencent.mm.plugin.websearch.webview.h<fll> esI()
  {
    return this.BTo;
  }
  
  public final Context getActivityContext()
  {
    return this.BNE.BSg;
  }
  
  final void hH(final String paramString1, String paramString2)
  {
    AppMethodBeat.i(176946);
    try
    {
      boolean bool = Util.isNullOrNil(paramString1);
      if (bool)
      {
        AppMethodBeat.o(176946);
        return;
      }
      paramString2 = Util.nullAsNil(paramString2);
      Log.i("MicroMsg.FTS.PardusWebViewLogic", "notifyJsEvent %s %s", new Object[] { paramString1, paramString2 });
      paramString1 = String.format("javascript:window['%s'] && %s(%s)", new Object[] { paramString1, paramString1, paramString2 });
      this.BNE.BSg.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(193363);
          j.a(j.this).evaluateJavascript(paramString1, null);
          AppMethodBeat.o(193363);
        }
      });
      AppMethodBeat.o(176946);
      return;
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace("MicroMsg.FTS.PardusWebViewLogic", paramString1, "notifyJsEvent", new Object[0]);
      AppMethodBeat.o(176946);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(191367);
    Log.i("MicroMsg.FTS.PardusWebViewLogic", "onSceneEnd errType:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    w localw;
    String str;
    if ((paramq instanceof w))
    {
      localw = (w)paramq;
      str = Util.nullAs(localw.gpT().UJk, "");
      paramq = new JSONObject();
    }
    try
    {
      paramq.put("retCode", paramInt2);
      paramq.put("errMsg", paramString);
      paramq.put("json", str);
      paramq.put("requestId", localw.fIY);
      label120:
      paramString = paramq.toString();
      this.BNE.BSg.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(176943);
          j.this.hH("pardusCommCgiReady", paramString);
          AppMethodBeat.o(176943);
        }
      });
      AppMethodBeat.o(191367);
      return;
    }
    catch (Exception paramString)
    {
      break label120;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.j
 * JD-Core Version:    0.7.0.1
 */