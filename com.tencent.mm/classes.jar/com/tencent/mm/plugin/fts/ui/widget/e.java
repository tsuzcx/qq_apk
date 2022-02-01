package com.tencent.mm.plugin.fts.ui.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.webkit.JavascriptInterface;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.fts.ui.FTSMainUI;
import com.tencent.mm.plugin.fts.ui.j;
import com.tencent.mm.plugin.fts.ui.k;
import com.tencent.mm.plugin.fts.ui.webview.PardusWebView;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.plugin.websearch.api.v;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.protocal.protobuf.cdd;
import com.tencent.mm.protocal.protobuf.cpk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e
{
  private static final int maxHeight;
  private boolean cZP;
  String dpS;
  private FrameLayout ntV;
  d sCY;
  private boolean sHL;
  public PardusWebView sIk;
  private FrameLayout sIl;
  boolean sIm;
  
  static
  {
    AppMethodBeat.i(176953);
    maxHeight = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 163);
    AppMethodBeat.o(176953);
  }
  
  public e(d paramd, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(176944);
    this.dpS = "";
    this.ntV = paramFrameLayout;
    this.sCY = paramd;
    paramd = new com.tencent.mm.plugin.fts.ui.webview.b();
    Object localObject = new com.tencent.mm.plugin.fts.ui.webview.a();
    this.sIk = new PardusWebView(ai.getContext());
    this.sIk.a((com.tencent.mm.plugin.fts.ui.webview.a)localObject, paramd);
    this.sIk.addJavascriptInterface(this, "pardusJSApi");
    int i = com.tencent.mm.cc.a.ig(ai.getContext());
    this.sIl = new FrameLayout(ai.getContext());
    this.sIl.addView(this.sIk, new FrameLayout.LayoutParams(i, maxHeight));
    paramFrameLayout.addView(this.sIl, new FrameLayout.LayoutParams(i, maxHeight));
    paramFrameLayout.measure(i, -2);
    paramFrameLayout.requestLayout();
    ac.i("MicroMsg.FTS.PardusWebViewLogic", "containerWidth: %s webviewWidth: %s", new Object[] { Integer.valueOf(paramFrameLayout.getMeasuredWidth()), Integer.valueOf(this.sIk.getMeasuredWidth()) });
    paramd = this.sIk;
    paramFrameLayout = new HashMap();
    paramFrameLayout.put("scene", "1");
    paramFrameLayout.put("lang", ab.iC(ai.getContext()));
    paramFrameLayout.put("platform", "android");
    paramFrameLayout.put("version", String.valueOf(z.Uj(5).aEh()));
    paramFrameLayout.put("netType", z.dkv());
    paramFrameLayout.put("wechatVersion", h.gMJ);
    localObject = new StringBuffer();
    ((StringBuffer)localObject).append("file://");
    ((StringBuffer)localObject).append(z.Uj(5).exF());
    ((StringBuffer)localObject).append("/");
    ((StringBuffer)localObject).append("app.html");
    ((StringBuffer)localObject).append("?");
    ((StringBuffer)localObject).append(z.aW(paramFrameLayout));
    paramd.loadUrl(((StringBuffer)localObject).toString());
    AppMethodBeat.o(176944);
  }
  
  public final void cLY()
  {
    AppMethodBeat.i(176945);
    if (this.ntV != null) {
      this.ntV.setVisibility(8);
    }
    AppMethodBeat.o(176945);
  }
  
  public final void clearData()
  {
    this.sHL = false;
    this.cZP = false;
    this.dpS = "";
  }
  
  final void gD(final String paramString1, String paramString2)
  {
    AppMethodBeat.i(176946);
    try
    {
      boolean bool = bs.isNullOrNil(paramString1);
      if (bool)
      {
        AppMethodBeat.o(176946);
        return;
      }
      paramString2 = bs.nullAsNil(paramString2);
      ac.i("MicroMsg.FTS.PardusWebViewLogic", "notifyJsEvent %s %s", new Object[] { paramString1, paramString2 });
      paramString1 = String.format("javascript:window['%s'] && %s(%s)", new Object[] { paramString1, paramString1, paramString2 });
      this.sCY.sHc.runOnUiThread(new Runnable()
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
      ac.printErrStackTrace("MicroMsg.FTS.PardusWebViewLogic", paramString1, "notifyJsEvent", new Object[0]);
      AppMethodBeat.o(176946);
    }
  }
  
  @JavascriptInterface
  public final void pardusAction(String paramString)
  {
    AppMethodBeat.i(176950);
    ac.i("MicroMsg.FTS.PardusWebViewLogic", "pardusAction %s", new Object[] { paramString });
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
    this.sCY.k((Map)localObject2, paramString);
    this.sCY.sHc.sDq.sCX.FJ(28);
    this.sCY.sHc.sDq.sCS = true;
    this.sCY.FN(6);
    k.a(this.dpS, 1, 1, this.sCY.sHc.kNw, this.sCY.sHc.sDq.sCX, 28, "", "", "");
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
    ((com.tencent.mm.plugin.websearch.api.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.websearch.api.g.class)).a(this.sCY.sHc, 3, paramString, String.valueOf(com.tencent.mm.plugin.fts.a.e.swV), (Map)localObject3);
    this.sCY.sHc.sDq.sCX.FJ(27);
    this.sCY.sHc.sDq.sCS = true;
    this.sCY.FN(5);
    if (this.sHL) {}
    for (int i = 2;; i = 1)
    {
      localObject2 = ((JSONObject)localObject1).optString("nickname");
      localObject3 = ((JSONObject)localObject1).optString("docId");
      localObject1 = ((JSONObject)localObject1).optString("appId");
      k.a(paramString, i, 2, this.sCY.sHc.kNw, this.sCY.sHc.sDq.sCX, 27, "3$".concat(String.valueOf(localObject2)), (String)localObject3, (String)localObject1);
      AppMethodBeat.o(176950);
      return;
      localObject2 = new cdd();
      ((cdd)localObject2).Edq = ((JSONObject)localObject1).optInt("actionType");
      paramString = ((JSONObject)localObject1).optJSONObject("actionInfo");
      ((cdd)localObject2).ncR = paramString.optString("userName");
      ((cdd)localObject2).EvI = paramString.optString("relativeURL");
      ((cdd)localObject2).EvJ = paramString.optInt("appVersion");
      this.sCY.a((cdd)localObject2);
      localObject2 = new JSONObject();
      ((JSONObject)localObject1).put("type", "pardusAction");
      ((JSONObject)localObject1).put("actionId", "1");
      ((JSONObject)localObject1).put("params", localObject1);
      gD("pardusActionCallBack", ((JSONObject)localObject2).toString());
      this.sCY.FN(4);
      this.sCY.sHc.sDq.sCX.FJ(27);
      this.sCY.sHc.sDq.sCS = true;
      if (this.sHL) {}
      for (i = 2;; i = 1)
      {
        localObject1 = paramString.optString("query");
        localObject2 = paramString.optString("nickname");
        localObject3 = paramString.optString("docId");
        paramString = paramString.optString("appId");
        k.a((String)localObject1, i, 1, this.sCY.sHc.kNw, this.sCY.sHc.sDq.sCX, 27, "3$".concat(String.valueOf(localObject2)), (String)localObject3, paramString);
        break;
      }
    }
  }
  
  @JavascriptInterface
  public final void pardusCommCgi(String paramString)
  {
    AppMethodBeat.i(176949);
    ac.i("MicroMsg.FTS.PardusWebViewLogic", "pardusCommCgi %s", new Object[] { paramString });
    AppMethodBeat.o(176949);
  }
  
  @JavascriptInterface
  public final void pardusReport(String paramString)
  {
    AppMethodBeat.i(176951);
    ac.i("MicroMsg.FTS.PardusWebViewLogic", "pardusReport %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString).optString("logStr", "");
      if (!bs.isNullOrNil(paramString))
      {
        cpk localcpk = new cpk();
        localcpk.FCf = paramString;
        paramString = new v(localcpk);
        com.tencent.mm.kernel.g.agi().a(paramString, 0);
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
    ac.i("MicroMsg.FTS.PardusWebViewLogic", "renderFinish %s", new Object[] { paramString });
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
          this.sHL = bool1;
          if (!bs.isNullOrNil((String)localObject))
          {
            bool1 = bool2;
            this.cZP = bool1;
            this.sCY.sHc.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(184536);
                if (e.a(e.this).isXWalkKernel()) {}
                for (int i = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), j);; i = Math.round(com.tencent.mm.cd.a.eSs() * j))
                {
                  ac.i("MicroMsg.FTS.PardusWebViewLogic", "start to update webview %d", new Object[] { Integer.valueOf(i) });
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
                      ac.i("MicroMsg.FTS.PardusWebViewLogic", "webview onAnimationUpdate %d", new Object[] { Integer.valueOf(i) });
                      e.b(e.this).getLayoutParams().height = i;
                      e.b(e.this).requestLayout();
                      AppMethodBeat.o(184534);
                    }
                  });
                  d locald = e.c(e.this);
                  localValueAnimator.addListener(new d.a(locald, locald.sGa));
                  localValueAnimator.setDuration(400L);
                  localValueAnimator.start();
                  e.d(e.this).setVisibility(0);
                  e.d(e.this).post(new Runnable()
                  {
                    public final void run()
                    {
                      int j = 0;
                      AppMethodBeat.i(184535);
                      ac.i("MicroMsg.FTS.PardusWebViewLogic", "update footer view");
                      Object localObject = e.c(e.this);
                      boolean bool1 = e.e(e.this);
                      boolean bool2 = e.f(e.this);
                      ((d)localObject).sHL = bool1;
                      ((d)localObject).cZP = bool2;
                      ((d)localObject).cdr();
                      localObject = e.c(e.this).sHc.sDq.sCX;
                      int k = e.3.this.sIq;
                      if (e.f(e.this)) {}
                      for (int i = 2;; i = 0)
                      {
                        ((com.tencent.mm.plugin.fts.ui.c.b)localObject).fQ(k, i);
                        if (e.e(e.this)) {
                          e.c(e.this).sHc.sDq.sCX.o(System.currentTimeMillis(), "PardusSug");
                        }
                        if (e.f(e.this))
                        {
                          i = j;
                          if (e.e(e.this)) {
                            i = 1;
                          }
                          e.c(e.this).sHc.sDq.sCX.a(i, System.currentTimeMillis(), "PardusMore", 3, e.3.this.sIr);
                          e.c(e.this).sHc.sDq.sCX.a(i + 1, System.currentTimeMillis(), e.3.this.sIr, 3, e.3.this.sIr);
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
    ac.i("MicroMsg.FTS.PardusWebViewLogic", "pardusReport %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("logid");
      paramString = paramString.optString("msg", "");
      com.tencent.mm.plugin.report.e.wTc.kvStat(i, paramString);
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
    ac.i("MicroMsg.FTS.PardusWebViewLogic", "webViewReady %s", new Object[] { paramString });
    this.sIm = true;
    AppMethodBeat.o(176947);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.e
 * JD-Core Version:    0.7.0.1
 */