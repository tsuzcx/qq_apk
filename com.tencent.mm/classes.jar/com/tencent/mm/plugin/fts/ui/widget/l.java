package com.tencent.mm.plugin.fts.ui.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.ce.c;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.ui.FTSBaseMainUI;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.au;
import com.tencent.mm.plugin.websearch.api.x;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.plugin.websearch.webview.j;
import com.tencent.mm.protocal.protobuf.eay;
import com.tencent.mm.protocal.protobuf.ghg;
import com.tencent.mm.protocal.protobuf.gia;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;
import com.tencent.xweb.ag;
import com.tencent.xweb.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class l
  implements com.tencent.mm.am.h, f
{
  private static final int maxHeight;
  private boolean HEA;
  public WebSearchWebView HEX;
  private FrameLayout HEY;
  private gia HEZ;
  public com.tencent.mm.plugin.websearch.webview.k<gia> HFa;
  private com.tencent.mm.plugin.fts.ui.f.a HFb;
  k HyW;
  private boolean hAE;
  String hTU;
  private FrameLayout vAf;
  
  static
  {
    AppMethodBeat.i(176953);
    maxHeight = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 163);
    AppMethodBeat.o(176953);
  }
  
  public l(k paramk, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(176944);
    this.hTU = "";
    this.vAf = paramFrameLayout;
    this.HyW = paramk;
    this.HEZ = new gia();
    this.HEZ.sessionId = e.fxw();
    this.HEZ.scene = 1;
    Object localObject1 = this.HEZ;
    Object localObject2 = new HashMap();
    ((HashMap)localObject2).put("scene", "1");
    ((HashMap)localObject2).put("lang", LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()));
    ((HashMap)localObject2).put("platform", "android");
    ((HashMap)localObject2).put("version", String.valueOf(aj.asW(5).bIG()));
    ((HashMap)localObject2).put("netType", aj.gtA());
    ((HashMap)localObject2).put("wechatVersion", BuildInfo.CLIENT_VERSION);
    ((HashMap)localObject2).put("webSearchVersion", String.valueOf(aj.asW(0).bIG()));
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("file://");
    localStringBuffer.append(aj.asW(5).iqp());
    localStringBuffer.append("/");
    localStringBuffer.append("app.html");
    localStringBuffer.append("?");
    localStringBuffer.append(aj.toUrlParams((Map)localObject2));
    ((gia)localObject1).url = localStringBuffer.toString();
    this.HFa = new com.tencent.mm.plugin.websearch.webview.k(this);
    this.HFb = new com.tencent.mm.plugin.fts.ui.f.a(this);
    localObject1 = new j(5);
    localObject2 = new com.tencent.mm.plugin.fts.ui.f.b();
    this.HEX = new WebSearchWebView(paramk.HDH);
    this.HEX.a((z)localObject2, (ag)localObject1);
    this.HEX.addJavascriptInterface(this.HFb, "pardusJSApi");
    int i = com.tencent.mm.cd.a.ms(MMApplicationContext.getContext());
    this.HEY = new FrameLayout(MMApplicationContext.getContext());
    this.HEY.addView(this.HEX, new FrameLayout.LayoutParams(i, maxHeight));
    paramFrameLayout.addView(this.HEY, new FrameLayout.LayoutParams(i, maxHeight));
    paramFrameLayout.measure(i, -2);
    paramFrameLayout.requestLayout();
    Log.i("MicroMsg.FTS.PardusWebViewLogic", "containerWidth: %s webviewWidth: %s", new Object[] { Integer.valueOf(paramFrameLayout.getMeasuredWidth()), Integer.valueOf(this.HEX.getMeasuredWidth()) });
    this.HEX.loadUrl(this.HEZ.url);
    com.tencent.mm.kernel.h.aZW().a(2975, this);
    AppMethodBeat.o(176944);
  }
  
  public final void bj(final JSONObject paramJSONObject)
  {
    boolean bool2 = true;
    AppMethodBeat.i(265907);
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
          this.HEA = bool1;
          if (!Util.isNullOrNil(paramJSONObject))
          {
            bool1 = bool2;
            this.hAE = bool1;
            this.HyW.HDH.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(265851);
                int i = Math.round(c.iRA() * j);
                Log.i("MicroMsg.FTS.PardusWebViewLogic", "start to update webview %d， height: %d， isXWalkKernel: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(l.a(l.this).isXWalkKernel()) });
                l.a(l.this).getLayoutParams().height = i;
                l.a(l.this).requestLayout();
                l.b(l.this).getLayoutParams().height = 0;
                l.b(l.this).requestLayout();
                ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, i });
                localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
                {
                  public final void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
                  {
                    AppMethodBeat.i(265846);
                    int i = ((Integer)paramAnonymous2ValueAnimator.getAnimatedValue()).intValue();
                    Log.i("MicroMsg.FTS.PardusWebViewLogic", "webview onAnimationUpdate %d", new Object[] { Integer.valueOf(i) });
                    l.b(l.this).getLayoutParams().height = i;
                    l.b(l.this).requestLayout();
                    AppMethodBeat.o(265846);
                  }
                });
                k localk = l.c(l.this);
                localValueAnimator.addListener(new k.a(localk, localk.Hyw));
                localValueAnimator.setDuration(400L);
                localValueAnimator.start();
                l.d(l.this).setVisibility(0);
                l.d(l.this).post(new Runnable()
                {
                  public final void run()
                  {
                    int j = 0;
                    AppMethodBeat.i(265843);
                    Log.i("MicroMsg.FTS.PardusWebViewLogic", "update footer view");
                    Object localObject = l.c(l.this);
                    boolean bool1 = l.e(l.this);
                    boolean bool2 = l.f(l.this);
                    ((k)localObject).HEA = bool1;
                    ((k)localObject).HEB = bool2;
                    ((k)localObject).dBz();
                    localObject = l.c(l.this).HDH.HxP.HyV;
                    int k = l.5.this.HFf;
                    if (l.f(l.this)) {}
                    for (int i = 2;; i = 0)
                    {
                      ((com.tencent.mm.plugin.fts.ui.d.b)localObject).iX(k, i);
                      if (l.e(l.this)) {
                        l.c(l.this).HDH.HxP.HyV.L(System.currentTimeMillis(), "PardusSug");
                      }
                      if (l.f(l.this))
                      {
                        i = j;
                        if (l.e(l.this)) {
                          i = 1;
                        }
                        l.c(l.this).HDH.HxP.HyV.a(i, System.currentTimeMillis(), "PardusMore", 3, l.5.this.HFg);
                        l.c(l.this).HDH.HxP.HyV.a(i + 1, System.currentTimeMillis(), l.5.this.HFg, 3, l.5.this.HFg);
                      }
                      AppMethodBeat.o(265843);
                      return;
                    }
                  }
                });
                AppMethodBeat.o(265851);
              }
            });
            AppMethodBeat.o(265907);
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
        AppMethodBeat.o(265907);
        return;
      }
      label124:
      boolean bool1 = true;
    }
  }
  
  public final void clearData()
  {
    this.HEA = false;
    this.hAE = false;
    this.hTU = "";
  }
  
  public final void d(int paramInt, final JSONObject paramJSONObject)
  {
    AppMethodBeat.i(265917);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(265917);
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
        this.HyW.n((Map)localObject2, paramJSONObject);
      }
      catch (Exception paramJSONObject)
      {
        Log.printErrStackTrace("MicroMsg.FTS.PardusWebViewLogic", paramJSONObject, "pardusAction", new Object[0]);
        AppMethodBeat.o(265917);
        return;
      }
      this.HyW.HDH.HxP.HyV.Wq(28);
      this.HyW.HDH.HxP.HyQ = true;
      this.HyW.Wu(6);
      com.tencent.mm.plugin.fts.ui.l.a(this.hTU, 1, 1, this.HyW.HDH.syO, this.HyW.HDH.HxP.HyV, 28, "", "", "");
      AppMethodBeat.o(265917);
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
      ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.websearch.api.h.class)).a(this.HyW.HDH, 3, paramJSONObject, String.valueOf(e.HrM), (Map)localObject4);
      this.HyW.HDH.HxP.HyV.Wq(27);
      this.HyW.HDH.HxP.HyQ = true;
      this.HyW.Wu(5);
      if (!this.HEA) {
        break;
      }
    }
    for (paramInt = 2;; paramInt = 1)
    {
      localObject2 = ((JSONObject)localObject1).optString("nickname");
      localObject3 = ((JSONObject)localObject1).optString("docId");
      localObject1 = ((JSONObject)localObject1).optString("appId");
      com.tencent.mm.plugin.fts.ui.l.a(paramJSONObject, paramInt, 2, this.HyW.HDH.syO, this.HyW.HDH.HxP.HyV, 27, "3$".concat(String.valueOf(localObject2)), (String)localObject3, (String)localObject1);
      AppMethodBeat.o(265917);
      return;
      localObject2 = new eay();
      ((eay)localObject2).YVh = paramJSONObject.optInt("actionType");
      localObject1 = paramJSONObject.optJSONObject("actionInfo");
      ((eay)localObject2).UserName = ((JSONObject)localObject1).optString("userName");
      ((eay)localObject2).ZrY = ((JSONObject)localObject1).optString("relativeURL");
      ((eay)localObject2).ZrZ = ((JSONObject)localObject1).optInt("appVersion");
      ((eay)localObject2).query = ((JSONObject)localObject1).optString("query", "");
      ((eay)localObject2).abgv = ((JSONObject)localObject1).optString("extParams");
      ((eay)localObject2).IGI = ((JSONObject)localObject1).optString("jumpUrl");
      this.HyW.a((eay)localObject2);
      localObject2 = new JSONObject();
      paramJSONObject.put("type", "pardusAction");
      paramJSONObject.put("actionId", "1");
      paramJSONObject.put("params", paramJSONObject);
      paramJSONObject = ((JSONObject)localObject2).toString();
      this.HyW.HDH.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184536);
          l.this.iJ("pardusActionCallBack", paramJSONObject);
          AppMethodBeat.o(184536);
        }
      });
      this.HyW.Wu(4);
      this.HyW.HDH.HxP.HyV.Wq(27);
      this.HyW.HDH.HxP.HyQ = true;
      if (this.HEA) {}
      for (paramInt = 2;; paramInt = 1)
      {
        paramJSONObject = ((JSONObject)localObject1).optString("query");
        localObject2 = ((JSONObject)localObject1).optString("nickname");
        localObject3 = ((JSONObject)localObject1).optString("docId");
        localObject1 = ((JSONObject)localObject1).optString("appId");
        com.tencent.mm.plugin.fts.ui.l.a(paramJSONObject, paramInt, 1, this.HyW.HDH.syO, this.HyW.HDH.HxP.HyV, 27, "3$".concat(String.valueOf(localObject2)), (String)localObject3, (String)localObject1);
        break;
      }
    }
  }
  
  public final com.tencent.mm.plugin.websearch.webview.k<gia> fyR()
  {
    return this.HFa;
  }
  
  public final com.tencent.mm.plugin.websearch.webview.l<gia> fyT()
  {
    return this.HFb;
  }
  
  public final void fzE()
  {
    AppMethodBeat.i(176945);
    if (this.vAf != null) {
      this.vAf.setVisibility(8);
    }
    AppMethodBeat.o(176945);
  }
  
  public final void fzz()
  {
    AppMethodBeat.i(265935);
    k localk = this.HyW;
    com.tencent.threadpool.h.ahAA.bk(new k.4(localk));
    AppMethodBeat.o(265935);
  }
  
  public final Context getActivityContext()
  {
    return this.HyW.HDH;
  }
  
  public final WebSearchWebView getWebView()
  {
    return this.HEX;
  }
  
  public final void hideVKB() {}
  
  final void iJ(final String paramString1, String paramString2)
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
      this.HyW.HDH.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(265841);
          l.a(l.this).evaluateJavascript(paramString1, null);
          AppMethodBeat.o(265841);
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
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, p paramp)
  {
    AppMethodBeat.i(265922);
    Log.i("MicroMsg.FTS.PardusWebViewLogic", "onSceneEnd errType:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    x localx;
    String str;
    if ((paramp instanceof x))
    {
      localx = (x)paramp;
      str = Util.nullAs(localx.hMP().acds, "");
      paramp = new JSONObject();
    }
    try
    {
      paramp.put("retCode", paramInt2);
      paramp.put("errMsg", paramString);
      paramp.put("json", str);
      paramp.put("requestId", localx.hOG);
      label120:
      paramString = paramp.toString();
      this.HyW.HDH.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(176943);
          l.this.iJ("pardusCommCgiReady", paramString);
          AppMethodBeat.o(176943);
        }
      });
      AppMethodBeat.o(265922);
      return;
    }
    catch (Exception paramString)
    {
      break label120;
    }
  }
  
  public final void showVKB() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.l
 * JD-Core Version:    0.7.0.1
 */