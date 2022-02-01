package com.tencent.mm.plugin.fts.ui.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.ui.FTSMainUI;
import com.tencent.mm.plugin.fts.ui.k;
import com.tencent.mm.plugin.fts.ui.l;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.at;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.plugin.websearch.webview.f;
import com.tencent.mm.protocal.protobuf.czc;
import com.tencent.mm.protocal.protobuf.fab;
import com.tencent.mm.protocal.protobuf.fas;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.ac;
import com.tencent.xweb.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class j
  implements com.tencent.mm.ak.i, d
{
  private static final int maxHeight;
  private boolean dDz;
  String dUA;
  private FrameLayout plP;
  i xbE;
  private boolean xgF;
  public WebSearchWebView xgX;
  private FrameLayout xgY;
  private fas xgZ;
  public com.tencent.mm.plugin.websearch.webview.g<fas> xha;
  private com.tencent.mm.plugin.fts.ui.e.a xhb;
  
  static
  {
    AppMethodBeat.i(176953);
    maxHeight = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 163);
    AppMethodBeat.o(176953);
  }
  
  public j(i parami, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(176944);
    this.dUA = "";
    this.plP = paramFrameLayout;
    this.xbE = parami;
    this.xgZ = new fas();
    this.xgZ.sessionId = e.dOy();
    this.xgZ.scene = 1;
    Object localObject1 = this.xgZ;
    Object localObject2 = new HashMap();
    ((HashMap)localObject2).put("scene", "1");
    ((HashMap)localObject2).put("lang", LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()));
    ((HashMap)localObject2).put("platform", "android");
    ((HashMap)localObject2).put("version", String.valueOf(ai.afr(5).bbw()));
    ((HashMap)localObject2).put("netType", ai.ait());
    ((HashMap)localObject2).put("wechatVersion", BuildInfo.CLIENT_VERSION);
    ((HashMap)localObject2).put("webSearchVersion", String.valueOf(ai.afr(0).bbw()));
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("file://");
    localStringBuffer.append(ai.afr(5).fYs());
    localStringBuffer.append("/");
    localStringBuffer.append("app.html");
    localStringBuffer.append("?");
    localStringBuffer.append(ai.toUrlParams((Map)localObject2));
    ((fas)localObject1).url = localStringBuffer.toString();
    this.xha = new com.tencent.mm.plugin.websearch.webview.g(this);
    this.xhb = new com.tencent.mm.plugin.fts.ui.e.a(this);
    localObject1 = new f((byte)0);
    localObject2 = new com.tencent.mm.plugin.fts.ui.e.b();
    this.xgX = new WebSearchWebView(parami.xfV);
    this.xgX.a((x)localObject2, (ac)localObject1);
    this.xgX.addJavascriptInterface(this.xhb, "pardusJSApi");
    int i = com.tencent.mm.cb.a.jn(MMApplicationContext.getContext());
    this.xgY = new FrameLayout(MMApplicationContext.getContext());
    this.xgY.addView(this.xgX, new FrameLayout.LayoutParams(i, maxHeight));
    paramFrameLayout.addView(this.xgY, new FrameLayout.LayoutParams(i, maxHeight));
    paramFrameLayout.measure(i, -2);
    paramFrameLayout.requestLayout();
    Log.i("MicroMsg.FTS.PardusWebViewLogic", "containerWidth: %s webviewWidth: %s", new Object[] { Integer.valueOf(paramFrameLayout.getMeasuredWidth()), Integer.valueOf(this.xgX.getMeasuredWidth()) });
    this.xgX.loadUrl(this.xgZ.url);
    com.tencent.mm.kernel.g.azz().a(2975, this);
    AppMethodBeat.o(176944);
  }
  
  public final void a(int paramInt, final JSONObject paramJSONObject)
  {
    AppMethodBeat.i(235417);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(235417);
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
        this.xbE.m((Map)localObject2, paramJSONObject);
      }
      catch (Exception paramJSONObject)
      {
        Log.printErrStackTrace("MicroMsg.FTS.PardusWebViewLogic", paramJSONObject, "pardusAction", new Object[0]);
        AppMethodBeat.o(235417);
        return;
      }
      this.xbE.xfV.xbX.xbD.Nv(28);
      this.xbE.xfV.xbX.xby = true;
      this.xbE.Nz(6);
      l.a(this.dUA, 1, 1, this.xbE.xfV.mve, this.xbE.xfV.xbX.xbD, 28, "", "", "");
      AppMethodBeat.o(235417);
      return;
    case 2: 
      localObject1 = paramJSONObject.optJSONObject("actionInfo");
      paramJSONObject = ((JSONObject)localObject1).optString("query");
      localObject2 = new JSONObject(((JSONObject)localObject1).optString("extParams"));
      localObject3 = new HashMap();
      localObject4 = ((JSONObject)localObject2).keys();
      while (((Iterator)localObject4).hasNext())
      {
        String str = (String)((Iterator)localObject4).next();
        ((HashMap)localObject3).put(str, ((JSONObject)localObject2).optString(str));
      }
      ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.websearch.api.h.class)).a(this.xbE.xfV, 3, paramJSONObject, String.valueOf(e.wVm), (Map)localObject3);
      this.xbE.xfV.xbX.xbD.Nv(27);
      this.xbE.xfV.xbX.xby = true;
      this.xbE.Nz(5);
      if (!this.xgF) {
        break;
      }
    }
    for (paramInt = 2;; paramInt = 1)
    {
      localObject2 = ((JSONObject)localObject1).optString("nickname");
      localObject3 = ((JSONObject)localObject1).optString("docId");
      localObject1 = ((JSONObject)localObject1).optString("appId");
      l.a(paramJSONObject, paramInt, 2, this.xbE.xfV.mve, this.xbE.xfV.xbX.xbD, 27, "3$".concat(String.valueOf(localObject2)), (String)localObject3, (String)localObject1);
      AppMethodBeat.o(235417);
      return;
      localObject2 = new czc();
      ((czc)localObject2).KWb = paramJSONObject.optInt("actionType");
      localObject1 = paramJSONObject.optJSONObject("actionInfo");
      ((czc)localObject2).UserName = ((JSONObject)localObject1).optString("userName");
      ((czc)localObject2).Lrs = ((JSONObject)localObject1).optString("relativeURL");
      ((czc)localObject2).Lrt = ((JSONObject)localObject1).optInt("appVersion");
      ((czc)localObject2).query = ((JSONObject)localObject1).optString("query", "");
      ((czc)localObject2).MEp = ((JSONObject)localObject1).optString("extParams");
      this.xbE.a((czc)localObject2);
      localObject2 = new JSONObject();
      paramJSONObject.put("type", "pardusAction");
      paramJSONObject.put("actionId", "1");
      paramJSONObject.put("params", paramJSONObject);
      paramJSONObject = ((JSONObject)localObject2).toString();
      this.xbE.xfV.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184536);
          j.this.hA("pardusActionCallBack", paramJSONObject);
          AppMethodBeat.o(184536);
        }
      });
      this.xbE.Nz(4);
      this.xbE.xfV.xbX.xbD.Nv(27);
      this.xbE.xfV.xbX.xby = true;
      if (this.xgF) {}
      for (paramInt = 2;; paramInt = 1)
      {
        paramJSONObject = ((JSONObject)localObject1).optString("query");
        localObject2 = ((JSONObject)localObject1).optString("nickname");
        localObject3 = ((JSONObject)localObject1).optString("docId");
        localObject1 = ((JSONObject)localObject1).optString("appId");
        l.a(paramJSONObject, paramInt, 1, this.xbE.xfV.mve, this.xbE.xfV.xbX.xbD, 27, "3$".concat(String.valueOf(localObject2)), (String)localObject3, (String)localObject1);
        break;
      }
    }
  }
  
  public final void aQ(final JSONObject paramJSONObject)
  {
    boolean bool2 = true;
    AppMethodBeat.i(235416);
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
          this.xgF = bool1;
          if (!Util.isNullOrNil(paramJSONObject))
          {
            bool1 = bool2;
            this.dDz = bool1;
            this.xbE.xfV.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(235415);
                if (j.a(j.this).isXWalkKernel()) {}
                for (int i = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), j);; i = Math.round(com.tencent.mm.cc.a.gvp() * j))
                {
                  Log.i("MicroMsg.FTS.PardusWebViewLogic", "start to update webview %d", new Object[] { Integer.valueOf(i) });
                  j.a(j.this).getLayoutParams().height = i;
                  j.a(j.this).requestLayout();
                  j.b(j.this).getLayoutParams().height = 0;
                  j.b(j.this).requestLayout();
                  ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, i });
                  localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
                  {
                    public final void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
                    {
                      AppMethodBeat.i(235413);
                      int i = ((Integer)paramAnonymous2ValueAnimator.getAnimatedValue()).intValue();
                      Log.i("MicroMsg.FTS.PardusWebViewLogic", "webview onAnimationUpdate %d", new Object[] { Integer.valueOf(i) });
                      j.b(j.this).getLayoutParams().height = i;
                      j.b(j.this).requestLayout();
                      AppMethodBeat.o(235413);
                    }
                  });
                  i locali = j.c(j.this);
                  localValueAnimator.addListener(new i.a(locali, locali.xbf));
                  localValueAnimator.setDuration(400L);
                  localValueAnimator.start();
                  j.d(j.this).setVisibility(0);
                  j.d(j.this).post(new Runnable()
                  {
                    public final void run()
                    {
                      int j = 0;
                      AppMethodBeat.i(235414);
                      Log.i("MicroMsg.FTS.PardusWebViewLogic", "update footer view");
                      Object localObject = j.c(j.this);
                      boolean bool1 = j.e(j.this);
                      boolean bool2 = j.f(j.this);
                      ((i)localObject).xgF = bool1;
                      ((i)localObject).dDz = bool2;
                      ((i)localObject).cHi();
                      localObject = j.c(j.this).xfV.xbX.xbD;
                      int k = j.5.this.xhf;
                      if (j.f(j.this)) {}
                      for (int i = 2;; i = 0)
                      {
                        ((com.tencent.mm.plugin.fts.ui.c.b)localObject).gF(k, i);
                        if (j.e(j.this)) {
                          j.c(j.this).xfV.xbX.xbD.t(System.currentTimeMillis(), "PardusSug");
                        }
                        if (j.f(j.this))
                        {
                          i = j;
                          if (j.e(j.this)) {
                            i = 1;
                          }
                          j.c(j.this).xfV.xbX.xbD.a(i, System.currentTimeMillis(), "PardusMore", 3, j.5.this.xhg);
                          j.c(j.this).xfV.xbX.xbD.a(i + 1, System.currentTimeMillis(), j.5.this.xhg, 3, j.5.this.xhg);
                        }
                        AppMethodBeat.o(235414);
                        return;
                      }
                    }
                  });
                  AppMethodBeat.o(235415);
                  return;
                }
              }
            });
            AppMethodBeat.o(235416);
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
        AppMethodBeat.o(235416);
        return;
      }
      label124:
      boolean bool1 = true;
    }
  }
  
  public final void clearData()
  {
    this.xgF = false;
    this.dDz = false;
    this.dUA = "";
  }
  
  public final void dQf()
  {
    AppMethodBeat.i(176945);
    if (this.plP != null) {
      this.plP.setVisibility(8);
    }
    AppMethodBeat.o(176945);
  }
  
  public final WebSearchWebView dQg()
  {
    return this.xgX;
  }
  
  public final com.tencent.mm.plugin.websearch.webview.g<fas> dQh()
  {
    return this.xha;
  }
  
  public final com.tencent.mm.plugin.websearch.webview.h<fas> dQi()
  {
    return this.xhb;
  }
  
  public final Context getActivityContext()
  {
    return this.xbE.xfV;
  }
  
  final void hA(final String paramString1, String paramString2)
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
      this.xbE.xfV.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(235412);
          j.a(j.this).evaluateJavascript(paramString1, null);
          AppMethodBeat.o(235412);
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
    AppMethodBeat.i(235418);
    Log.i("MicroMsg.FTS.PardusWebViewLogic", "onSceneEnd errType:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    w localw;
    String str;
    if ((paramq instanceof w))
    {
      localw = (w)paramq;
      str = Util.nullAs(localw.fxY().NvZ, "");
      paramq = new JSONObject();
    }
    try
    {
      paramq.put("retCode", paramInt2);
      paramq.put("errMsg", paramString);
      paramq.put("json", str);
      paramq.put("requestId", localw.dPI);
      label120:
      paramString = paramq.toString();
      this.xbE.xfV.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(176943);
          j.this.hA("pardusCommCgiReady", paramString);
          AppMethodBeat.o(176943);
        }
      });
      AppMethodBeat.o(235418);
      return;
    }
    catch (Exception paramString)
    {
      break label120;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.j
 * JD-Core Version:    0.7.0.1
 */