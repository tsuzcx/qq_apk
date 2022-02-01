package com.tencent.mm.plugin.fts.ui.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.webkit.JavascriptInterface;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.ui.FTSMainUI;
import com.tencent.mm.plugin.fts.ui.k;
import com.tencent.mm.plugin.fts.ui.l;
import com.tencent.mm.plugin.fts.ui.webview.PardusWebView;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.plugin.websearch.api.h;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.protocal.protobuf.cvj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e
{
  private static final int maxHeight;
  String dCK;
  private boolean dmj;
  private FrameLayout oaS;
  d tKE;
  public PardusWebView tPM;
  private FrameLayout tPN;
  boolean tPO;
  private boolean tPu;
  
  static
  {
    AppMethodBeat.i(176953);
    maxHeight = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 163);
    AppMethodBeat.o(176953);
  }
  
  public e(d paramd, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(176944);
    this.dCK = "";
    this.oaS = paramFrameLayout;
    this.tKE = paramd;
    paramd = new com.tencent.mm.plugin.fts.ui.webview.b();
    Object localObject = new com.tencent.mm.plugin.fts.ui.webview.a();
    this.tPM = new PardusWebView(ak.getContext());
    this.tPM.a((com.tencent.mm.plugin.fts.ui.webview.a)localObject, paramd);
    this.tPM.addJavascriptInterface(this, "pardusJSApi");
    int i = com.tencent.mm.cb.a.iu(ak.getContext());
    this.tPN = new FrameLayout(ak.getContext());
    this.tPN.addView(this.tPM, new FrameLayout.LayoutParams(i, maxHeight));
    paramFrameLayout.addView(this.tPN, new FrameLayout.LayoutParams(i, maxHeight));
    paramFrameLayout.measure(i, -2);
    paramFrameLayout.requestLayout();
    ae.i("MicroMsg.FTS.PardusWebViewLogic", "containerWidth: %s webviewWidth: %s", new Object[] { Integer.valueOf(paramFrameLayout.getMeasuredWidth()), Integer.valueOf(this.tPM.getMeasuredWidth()) });
    paramd = this.tPM;
    paramFrameLayout = new HashMap();
    paramFrameLayout.put("scene", "1");
    paramFrameLayout.put("lang", com.tencent.mm.sdk.platformtools.ad.iR(ak.getContext()));
    paramFrameLayout.put("platform", "android");
    paramFrameLayout.put("version", String.valueOf(com.tencent.mm.plugin.websearch.api.ad.WJ(5).aHD()));
    paramFrameLayout.put("netType", com.tencent.mm.plugin.websearch.api.ad.UD());
    paramFrameLayout.put("wechatVersion", j.hju);
    localObject = new StringBuffer();
    ((StringBuffer)localObject).append("file://");
    ((StringBuffer)localObject).append(com.tencent.mm.plugin.websearch.api.ad.WJ(5).eQf());
    ((StringBuffer)localObject).append("/");
    ((StringBuffer)localObject).append("app.html");
    ((StringBuffer)localObject).append("?");
    ((StringBuffer)localObject).append(com.tencent.mm.plugin.websearch.api.ad.toUrlParams(paramFrameLayout));
    paramd.loadUrl(((StringBuffer)localObject).toString());
    AppMethodBeat.o(176944);
  }
  
  public final void cWW()
  {
    AppMethodBeat.i(176945);
    if (this.oaS != null) {
      this.oaS.setVisibility(8);
    }
    AppMethodBeat.o(176945);
  }
  
  public final void clearData()
  {
    this.tPu = false;
    this.dmj = false;
    this.dCK = "";
  }
  
  final void gT(final String paramString1, String paramString2)
  {
    AppMethodBeat.i(176946);
    try
    {
      boolean bool = bu.isNullOrNil(paramString1);
      if (bool)
      {
        AppMethodBeat.o(176946);
        return;
      }
      paramString2 = bu.nullAsNil(paramString2);
      ae.i("MicroMsg.FTS.PardusWebViewLogic", "notifyJsEvent %s %s", new Object[] { paramString1, paramString2 });
      paramString1 = String.format("javascript:window['%s'] && %s(%s)", new Object[] { paramString1, paramString1, paramString2 });
      this.tKE.tOM.runOnUiThread(new Runnable()
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
      ae.printErrStackTrace("MicroMsg.FTS.PardusWebViewLogic", paramString1, "notifyJsEvent", new Object[0]);
      AppMethodBeat.o(176946);
    }
  }
  
  @JavascriptInterface
  public final void pardusAction(String paramString)
  {
    AppMethodBeat.i(176950);
    ae.i("MicroMsg.FTS.PardusWebViewLogic", "pardusAction %s", new Object[] { paramString });
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
    this.tKE.l((Map)localObject2, paramString);
    this.tKE.tOM.tKW.tKD.Hv(28);
    this.tKE.tOM.tKW.tKy = true;
    this.tKE.Hz(6);
    l.a(this.dCK, 1, 1, this.tKE.tOM.lox, this.tKE.tOM.tKW.tKD, 28, "", "", "");
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
    ((h)g.ab(h.class)).a(this.tKE.tOM, 3, paramString, String.valueOf(com.tencent.mm.plugin.fts.a.e.tEn), (Map)localObject3);
    this.tKE.tOM.tKW.tKD.Hv(27);
    this.tKE.tOM.tKW.tKy = true;
    this.tKE.Hz(5);
    if (this.tPu) {}
    for (int i = 2;; i = 1)
    {
      localObject2 = ((JSONObject)localObject1).optString("nickname");
      localObject3 = ((JSONObject)localObject1).optString("docId");
      localObject1 = ((JSONObject)localObject1).optString("appId");
      l.a(paramString, i, 2, this.tKE.tOM.lox, this.tKE.tOM.tKW.tKD, 27, "3$".concat(String.valueOf(localObject2)), (String)localObject3, (String)localObject1);
      AppMethodBeat.o(176950);
      return;
      localObject2 = new civ();
      ((civ)localObject2).GbY = ((JSONObject)localObject1).optInt("actionType");
      paramString = ((JSONObject)localObject1).optJSONObject("actionInfo");
      ((civ)localObject2).nIJ = paramString.optString("userName");
      ((civ)localObject2).GvL = paramString.optString("relativeURL");
      ((civ)localObject2).GvM = paramString.optInt("appVersion");
      this.tKE.a((civ)localObject2);
      localObject2 = new JSONObject();
      ((JSONObject)localObject1).put("type", "pardusAction");
      ((JSONObject)localObject1).put("actionId", "1");
      ((JSONObject)localObject1).put("params", localObject1);
      gT("pardusActionCallBack", ((JSONObject)localObject2).toString());
      this.tKE.Hz(4);
      this.tKE.tOM.tKW.tKD.Hv(27);
      this.tKE.tOM.tKW.tKy = true;
      if (this.tPu) {}
      for (i = 2;; i = 1)
      {
        localObject1 = paramString.optString("query");
        localObject2 = paramString.optString("nickname");
        localObject3 = paramString.optString("docId");
        paramString = paramString.optString("appId");
        l.a((String)localObject1, i, 1, this.tKE.tOM.lox, this.tKE.tOM.tKW.tKD, 27, "3$".concat(String.valueOf(localObject2)), (String)localObject3, paramString);
        break;
      }
    }
  }
  
  @JavascriptInterface
  public final void pardusCommCgi(String paramString)
  {
    AppMethodBeat.i(176949);
    ae.i("MicroMsg.FTS.PardusWebViewLogic", "pardusCommCgi %s", new Object[] { paramString });
    AppMethodBeat.o(176949);
  }
  
  @JavascriptInterface
  public final void pardusReport(String paramString)
  {
    AppMethodBeat.i(176951);
    ae.i("MicroMsg.FTS.PardusWebViewLogic", "pardusReport %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString).optString("logStr", "");
      if (!bu.isNullOrNil(paramString))
      {
        cvj localcvj = new cvj();
        localcvj.HFU = paramString;
        paramString = new z(localcvj);
        g.ajj().a(paramString, 0);
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
    ae.i("MicroMsg.FTS.PardusWebViewLogic", "renderFinish %s", new Object[] { paramString });
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
          this.tPu = bool1;
          if (!bu.isNullOrNil((String)localObject))
          {
            bool1 = bool2;
            this.dmj = bool1;
            this.tKE.tOM.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(184536);
                if (e.a(e.this).isXWalkKernel()) {}
                for (int i = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), j);; i = Math.round(com.tencent.mm.cc.a.flD() * j))
                {
                  ae.i("MicroMsg.FTS.PardusWebViewLogic", "start to update webview %d", new Object[] { Integer.valueOf(i) });
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
                      ae.i("MicroMsg.FTS.PardusWebViewLogic", "webview onAnimationUpdate %d", new Object[] { Integer.valueOf(i) });
                      e.b(e.this).getLayoutParams().height = i;
                      e.b(e.this).requestLayout();
                      AppMethodBeat.o(184534);
                    }
                  });
                  d locald = e.c(e.this);
                  localValueAnimator.addListener(new d.a(locald, locald.tKg));
                  localValueAnimator.setDuration(400L);
                  localValueAnimator.start();
                  e.d(e.this).setVisibility(0);
                  e.d(e.this).post(new Runnable()
                  {
                    public final void run()
                    {
                      int j = 0;
                      AppMethodBeat.i(184535);
                      ae.i("MicroMsg.FTS.PardusWebViewLogic", "update footer view");
                      Object localObject = e.c(e.this);
                      boolean bool1 = e.e(e.this);
                      boolean bool2 = e.f(e.this);
                      ((d)localObject).tPu = bool1;
                      ((d)localObject).dmj = bool2;
                      ((d)localObject).cjk();
                      localObject = e.c(e.this).tOM.tKW.tKD;
                      int k = e.3.this.tPS;
                      if (e.f(e.this)) {}
                      for (int i = 2;; i = 0)
                      {
                        ((com.tencent.mm.plugin.fts.ui.c.b)localObject).gg(k, i);
                        if (e.e(e.this)) {
                          e.c(e.this).tOM.tKW.tKD.p(System.currentTimeMillis(), "PardusSug");
                        }
                        if (e.f(e.this))
                        {
                          i = j;
                          if (e.e(e.this)) {
                            i = 1;
                          }
                          e.c(e.this).tOM.tKW.tKD.a(i, System.currentTimeMillis(), "PardusMore", 3, e.3.this.tPT);
                          e.c(e.this).tOM.tKW.tKD.a(i + 1, System.currentTimeMillis(), e.3.this.tPT, 3, e.3.this.tPT);
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
    ae.i("MicroMsg.FTS.PardusWebViewLogic", "pardusReport %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("logid");
      paramString = paramString.optString("msg", "");
      com.tencent.mm.plugin.report.e.ywz.kvStat(i, paramString);
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
    ae.i("MicroMsg.FTS.PardusWebViewLogic", "webViewReady %s", new Object[] { paramString });
    this.tPO = true;
    AppMethodBeat.o(176947);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.e
 * JD-Core Version:    0.7.0.1
 */