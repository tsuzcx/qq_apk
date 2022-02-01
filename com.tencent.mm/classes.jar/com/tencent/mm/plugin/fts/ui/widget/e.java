package com.tencent.mm.plugin.fts.ui.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.webkit.JavascriptInterface;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.ui.FTSMainUI;
import com.tencent.mm.plugin.fts.ui.k;
import com.tencent.mm.plugin.fts.ui.l;
import com.tencent.mm.plugin.fts.ui.webview.PardusWebView;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.plugin.websearch.api.h;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.protocal.protobuf.cib;
import com.tencent.mm.protocal.protobuf.cup;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e
{
  private static final int maxHeight;
  String dBF;
  private boolean dlh;
  private FrameLayout nVl;
  private boolean tED;
  public PardusWebView tEV;
  private FrameLayout tEW;
  boolean tEX;
  d tzN;
  
  static
  {
    AppMethodBeat.i(176953);
    maxHeight = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 163);
    AppMethodBeat.o(176953);
  }
  
  public e(d paramd, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(176944);
    this.dBF = "";
    this.nVl = paramFrameLayout;
    this.tzN = paramd;
    paramd = new com.tencent.mm.plugin.fts.ui.webview.b();
    Object localObject = new com.tencent.mm.plugin.fts.ui.webview.a();
    this.tEV = new PardusWebView(aj.getContext());
    this.tEV.a((com.tencent.mm.plugin.fts.ui.webview.a)localObject, paramd);
    this.tEV.addJavascriptInterface(this, "pardusJSApi");
    int i = com.tencent.mm.cc.a.ip(aj.getContext());
    this.tEW = new FrameLayout(aj.getContext());
    this.tEW.addView(this.tEV, new FrameLayout.LayoutParams(i, maxHeight));
    paramFrameLayout.addView(this.tEW, new FrameLayout.LayoutParams(i, maxHeight));
    paramFrameLayout.measure(i, -2);
    paramFrameLayout.requestLayout();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FTS.PardusWebViewLogic", "containerWidth: %s webviewWidth: %s", new Object[] { Integer.valueOf(paramFrameLayout.getMeasuredWidth()), Integer.valueOf(this.tEV.getMeasuredWidth()) });
    paramd = this.tEV;
    paramFrameLayout = new HashMap();
    paramFrameLayout.put("scene", "1");
    paramFrameLayout.put("lang", ac.iM(aj.getContext()));
    paramFrameLayout.put("platform", "android");
    paramFrameLayout.put("version", String.valueOf(com.tencent.mm.plugin.websearch.api.ad.Wc(5).aHm()));
    paramFrameLayout.put("netType", com.tencent.mm.plugin.websearch.api.ad.Ux());
    paramFrameLayout.put("wechatVersion", i.hgG);
    localObject = new StringBuffer();
    ((StringBuffer)localObject).append("file://");
    ((StringBuffer)localObject).append(com.tencent.mm.plugin.websearch.api.ad.Wc(5).eMw());
    ((StringBuffer)localObject).append("/");
    ((StringBuffer)localObject).append("app.html");
    ((StringBuffer)localObject).append("?");
    ((StringBuffer)localObject).append(com.tencent.mm.plugin.websearch.api.ad.toUrlParams(paramFrameLayout));
    paramd.loadUrl(((StringBuffer)localObject).toString());
    AppMethodBeat.o(176944);
  }
  
  public final void cUr()
  {
    AppMethodBeat.i(176945);
    if (this.nVl != null) {
      this.nVl.setVisibility(8);
    }
    AppMethodBeat.o(176945);
  }
  
  public final void clearData()
  {
    this.tED = false;
    this.dlh = false;
    this.dBF = "";
  }
  
  final void gO(final String paramString1, String paramString2)
  {
    AppMethodBeat.i(176946);
    try
    {
      boolean bool = bt.isNullOrNil(paramString1);
      if (bool)
      {
        AppMethodBeat.o(176946);
        return;
      }
      paramString2 = bt.nullAsNil(paramString2);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FTS.PardusWebViewLogic", "notifyJsEvent %s %s", new Object[] { paramString1, paramString2 });
      paramString1 = String.format("javascript:window['%s'] && %s(%s)", new Object[] { paramString1, paramString1, paramString2 });
      this.tzN.tDV.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(176943);
          e.a(e.this).evaluateJavascript(paramString1, null);
          AppMethodBeat.o(176943);
        }
      });
      AppMethodBeat.o(176946);
      return;
    }
    catch (Exception paramString1)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.FTS.PardusWebViewLogic", paramString1, "notifyJsEvent", new Object[0]);
      AppMethodBeat.o(176946);
    }
  }
  
  @JavascriptInterface
  public final void pardusAction(String paramString)
  {
    AppMethodBeat.i(176950);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FTS.PardusWebViewLogic", "pardusAction %s", new Object[] { paramString });
    try
    {
      localObject1 = new JSONObject(paramString);
      i = ((JSONObject)localObject1).optInt("area", 0);
      switch (i)
      {
      default: 
        AppMethodBeat.o(176950);
        return;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(176950);
      return;
    }
    Object localObject1 = ((JSONObject)localObject1).optJSONObject("actionInfo");
    paramString = ((JSONObject)localObject1).optString("query");
    localObject1 = new JSONObject(((JSONObject)localObject1).optString("extParams"));
    Object localObject2 = new HashMap();
    Object localObject3 = ((JSONObject)localObject1).keys();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (String)((Iterator)localObject3).next();
      ((HashMap)localObject2).put(localObject4, ((JSONObject)localObject1).optString((String)localObject4));
    }
    this.tzN.l((Map)localObject2, paramString);
    this.tzN.tDV.tAf.tzM.GY(28);
    this.tzN.tDV.tAf.tzH = true;
    this.tzN.Hc(6);
    l.a(this.dBF, 1, 1, this.tzN.tDV.ljZ, this.tzN.tDV.tAf.tzM, 28, "", "", "");
    AppMethodBeat.o(176950);
    return;
    localObject1 = ((JSONObject)localObject1).optJSONObject("actionInfo");
    paramString = ((JSONObject)localObject1).optString("query");
    localObject2 = new JSONObject(((JSONObject)localObject1).optString("extParams"));
    localObject3 = new HashMap();
    Object localObject4 = ((JSONObject)localObject2).keys();
    while (((Iterator)localObject4).hasNext())
    {
      String str = (String)((Iterator)localObject4).next();
      ((HashMap)localObject3).put(str, ((JSONObject)localObject2).optString(str));
    }
    ((h)g.ab(h.class)).a(this.tzN.tDV, 3, paramString, String.valueOf(com.tencent.mm.plugin.fts.a.e.ttw), (Map)localObject3);
    this.tzN.tDV.tAf.tzM.GY(27);
    this.tzN.tDV.tAf.tzH = true;
    this.tzN.Hc(5);
    if (this.tED) {}
    for (int i = 2;; i = 1)
    {
      localObject2 = ((JSONObject)localObject1).optString("nickname");
      localObject3 = ((JSONObject)localObject1).optString("docId");
      localObject1 = ((JSONObject)localObject1).optString("appId");
      l.a(paramString, i, 2, this.tzN.tDV.ljZ, this.tzN.tDV.tAf.tzM, 27, "3$".concat(String.valueOf(localObject2)), (String)localObject3, (String)localObject1);
      AppMethodBeat.o(176950);
      return;
      localObject2 = new cib();
      ((cib)localObject2).FJz = ((JSONObject)localObject1).optInt("actionType");
      paramString = ((JSONObject)localObject1).optJSONObject("actionInfo");
      ((cib)localObject2).nDo = paramString.optString("userName");
      ((cib)localObject2).Gde = paramString.optString("relativeURL");
      ((cib)localObject2).Gdf = paramString.optInt("appVersion");
      this.tzN.a((cib)localObject2);
      localObject2 = new JSONObject();
      ((JSONObject)localObject1).put("type", "pardusAction");
      ((JSONObject)localObject1).put("actionId", "1");
      ((JSONObject)localObject1).put("params", localObject1);
      gO("pardusActionCallBack", ((JSONObject)localObject2).toString());
      this.tzN.Hc(4);
      this.tzN.tDV.tAf.tzM.GY(27);
      this.tzN.tDV.tAf.tzH = true;
      if (this.tED) {}
      for (i = 2;; i = 1)
      {
        localObject1 = paramString.optString("query");
        localObject2 = paramString.optString("nickname");
        localObject3 = paramString.optString("docId");
        paramString = paramString.optString("appId");
        l.a((String)localObject1, i, 1, this.tzN.tDV.ljZ, this.tzN.tDV.tAf.tzM, 27, "3$".concat(String.valueOf(localObject2)), (String)localObject3, paramString);
        break;
      }
    }
  }
  
  @JavascriptInterface
  public final void pardusCommCgi(String paramString)
  {
    AppMethodBeat.i(176949);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FTS.PardusWebViewLogic", "pardusCommCgi %s", new Object[] { paramString });
    AppMethodBeat.o(176949);
  }
  
  @JavascriptInterface
  public final void pardusReport(String paramString)
  {
    AppMethodBeat.i(176951);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FTS.PardusWebViewLogic", "pardusReport %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString).optString("logStr", "");
      if (!bt.isNullOrNil(paramString))
      {
        cup localcup = new cup();
        localcup.Hmu = paramString;
        paramString = new z(localcup);
        g.aiU().a(paramString, 0);
      }
      AppMethodBeat.o(176951);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(176951);
    }
  }
  
  @JavascriptInterface
  public final void renderFinish(String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(176948);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FTS.PardusWebViewLogic", "renderFinish %s", new Object[] { paramString });
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString);
        final int j = ((JSONObject)localObject).optInt("height");
        paramString = ((JSONObject)localObject).optJSONArray("sugList");
        localObject = ((JSONObject)localObject).optString("docId");
        final int i;
        if (paramString != null)
        {
          i = paramString.length();
          break label153;
          this.tED = bool1;
          if (!bt.isNullOrNil((String)localObject))
          {
            bool1 = bool2;
            this.dlh = bool1;
            this.tzN.tDV.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(184536);
                if (e.a(e.this).isXWalkKernel()) {}
                for (int i = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), j);; i = Math.round(com.tencent.mm.cd.a.fhL() * j))
                {
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FTS.PardusWebViewLogic", "start to update webview %d", new Object[] { Integer.valueOf(i) });
                  e.a(e.this).getLayoutParams().height = i;
                  e.a(e.this).requestLayout();
                  e.b(e.this).getLayoutParams().height = 0;
                  e.b(e.this).requestLayout();
                  ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, i });
                  localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
                  {
                    public final void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
                    {
                      AppMethodBeat.i(184534);
                      int i = ((Integer)paramAnonymous2ValueAnimator.getAnimatedValue()).intValue();
                      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FTS.PardusWebViewLogic", "webview onAnimationUpdate %d", new Object[] { Integer.valueOf(i) });
                      e.b(e.this).getLayoutParams().height = i;
                      e.b(e.this).requestLayout();
                      AppMethodBeat.o(184534);
                    }
                  });
                  d locald = e.c(e.this);
                  localValueAnimator.addListener(new d.a(locald, locald.tzp));
                  localValueAnimator.setDuration(400L);
                  localValueAnimator.start();
                  e.d(e.this).setVisibility(0);
                  e.d(e.this).post(new Runnable()
                  {
                    public final void run()
                    {
                      int j = 0;
                      AppMethodBeat.i(184535);
                      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FTS.PardusWebViewLogic", "update footer view");
                      Object localObject = e.c(e.this);
                      boolean bool1 = e.e(e.this);
                      boolean bool2 = e.f(e.this);
                      ((d)localObject).tED = bool1;
                      ((d)localObject).dlh = bool2;
                      ((d)localObject).chU();
                      localObject = e.c(e.this).tDV.tAf.tzM;
                      int k = e.3.this.tFb;
                      if (e.f(e.this)) {}
                      for (int i = 2;; i = 0)
                      {
                        ((com.tencent.mm.plugin.fts.ui.c.b)localObject).gg(k, i);
                        if (e.e(e.this)) {
                          e.c(e.this).tDV.tAf.tzM.p(System.currentTimeMillis(), "PardusSug");
                        }
                        if (e.f(e.this))
                        {
                          i = j;
                          if (e.e(e.this)) {
                            i = 1;
                          }
                          e.c(e.this).tDV.tAf.tzM.a(i, System.currentTimeMillis(), "PardusMore", 3, e.3.this.tFc);
                          e.c(e.this).tDV.tAf.tzM.a(i + 1, System.currentTimeMillis(), e.3.this.tFc, 3, e.3.this.tFc);
                        }
                        AppMethodBeat.o(184535);
                        return;
                      }
                    }
                  });
                  AppMethodBeat.o(184536);
                  return;
                }
              }
            });
            AppMethodBeat.o(176948);
          }
        }
        else
        {
          i = 0;
          break label153;
          bool1 = false;
          continue;
        }
        bool1 = false;
        continue;
        if (i <= 0) {
          continue;
        }
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(176948);
        return;
      }
      label153:
      boolean bool1 = true;
    }
  }
  
  @JavascriptInterface
  public final void reportKV(String paramString)
  {
    AppMethodBeat.i(176952);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FTS.PardusWebViewLogic", "pardusReport %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("logid");
      paramString = paramString.optString("msg", "");
      com.tencent.mm.plugin.report.e.ygI.kvStat(i, paramString);
      AppMethodBeat.o(176952);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(176952);
    }
  }
  
  @JavascriptInterface
  public final void webViewReady(String paramString)
  {
    AppMethodBeat.i(176947);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FTS.PardusWebViewLogic", "webViewReady %s", new Object[] { paramString });
    this.tEX = true;
    AppMethodBeat.o(176947);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.e
 * JD-Core Version:    0.7.0.1
 */