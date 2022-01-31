package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.preload.TmplParams;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f.a;
import com.tencent.mm.plugin.webview.ui.tools.k;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.b;
import com.tencent.xweb.p;
import com.tencent.xweb.t;
import com.tencent.xweb.w;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class e
  extends MMWebView
{
  private w iyq;
  private p iyr;
  public TmplParams jZV;
  public String keN;
  public int keO;
  public String keP;
  private boolean keQ;
  private LinkedList<Pair<String, ValueCallback<String>>> keR;
  protected d keS;
  private int keh;
  
  public e(Context paramContext, TmplParams paramTmplParams)
  {
    super(paramContext);
    AppMethodBeat.i(14436);
    this.keR = new LinkedList();
    this.iyr = new e.2(this);
    this.iyq = new e.3(this);
    this.keh = ((int)(System.currentTimeMillis() % 1000L));
    this.inited = true;
    this.isX5Kernel = getIsX5Kernel();
    this.keN = paramTmplParams.keN;
    this.keP = paramTmplParams.uYJ;
    this.keO = paramTmplParams.version;
    this.jZV = paramTmplParams;
    ab.i(getTagName(), "[initParams]tmplParams:%s", new Object[] { this.jZV });
    if (ah.brt())
    {
      ab.i(getTagName(), "[initWebviewCore] current process is mm");
      WebView.initWebviewCore(paramContext, ADX, "mm", null);
    }
    for (;;)
    {
      iG(paramContext);
      ab.i(getTagName(), "[initWebViewSetting]");
      getSettings().setJavaScriptEnabled(true);
      getSettings().setPluginsEnabled(true);
      getSettings().dYx();
      getSettings().setBuiltInZoomControls(false);
      getSettings().setUseWideViewPort(true);
      getSettings().setLoadWithOverviewMode(true);
      getSettings().dYs();
      getSettings().dYr();
      getSettings().setGeolocationEnabled(true);
      getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
      getSettings().dYz();
      getSettings().dYv();
      getSettings().setAppCachePath(getContext().getDir("webviewcache", 0).getAbsolutePath());
      getSettings().dYu();
      getSettings().dYy();
      getSettings().dYw();
      getSettings().setDatabasePath(com.tencent.mm.compatible.util.e.eQu + "databases/");
      b.dYg().dYh();
      b.dYg().f(this);
      paramContext = u.bD(getContext(), getSettings().getUserAgentString());
      getSettings().setUserAgentString(paramContext);
      addJavascriptInterface(new e.4(this, this), "__tmpl_webview_inject_data");
      ab.i(getTagName(), "[initJsApiHandler]");
      paramContext = new k(JsapiPermissionWrapper.wib, GeneralControlWrapper.whY, new e.5(this));
      paramTmplParams = new HashMap();
      paramTmplParams.put("webview_type", "1");
      paramTmplParams.put("init_url", getUrl());
      paramTmplParams.put("init_font_size", "1");
      this.keS = new d(this, paramContext, paramTmplParams);
      this.keS.voE = getInterceptHandler();
      addJavascriptInterface(this.keS, "__wx");
      boolean bool = ah.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("wvsha1", true);
      ab.i(getTagName(), "[initJsApiHandler]enableWvSHA1:%b", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        this.keS.dgj();
        setRandomStr(this.keS.voC);
      }
      setWebViewClient(this.iyq);
      setWebChromeClient(this.iyr);
      AppMethodBeat.o(14436);
      return;
      if (ah.dsW())
      {
        ab.i(getTagName(), "[initWebviewCore] current process is tool");
        WebView.initWebviewCore(paramContext, ADX, "tools", null);
      }
      else if (ah.dsX())
      {
        ab.i(getTagName(), "[initWebviewCore] current process is toolmp");
        WebView.initWebviewCore(paramContext, ADX, "toolsmp", null);
      }
    }
  }
  
  protected static String Hp(String paramString)
  {
    AppMethodBeat.i(152660);
    paramString = "__tmpl_webview_inject_data.__log(JSON.stringify(" + paramString + "));console.log('__log', " + paramString + ");";
    AppMethodBeat.o(152660);
    return paramString;
  }
  
  private void aYY()
  {
    try
    {
      AppMethodBeat.i(14438);
      ab.d("MicroMsg.TmplWxJsWebView", "clearPendingScript");
      Iterator localIterator = this.keR.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        super.evaluateJavascript((String)localPair.first, (ValueCallback)localPair.second);
        ab.v(getTagName(), "[evaluateJavascript]%s", new Object[] { localPair.first });
      }
      this.keR.clear();
    }
    finally {}
    AppMethodBeat.o(14438);
  }
  
  private String getTagName()
  {
    AppMethodBeat.i(14442);
    String str = "MicroMsg.TmplWxJsWebView:" + getTmplWebViewId();
    AppMethodBeat.o(14442);
    return str;
  }
  
  protected void Hi(String paramString) {}
  
  public final void aJe()
  {
    AppMethodBeat.i(14441);
    if (!this.keQ)
    {
      ab.i(getTagName(), "[onPageReady]");
      aYY();
      this.keQ = true;
      evaluateJavascript("window.onFirstScreenComplete=function(){" + getFirstScreenCompletedAPI() + ";console.log('firstScreen')}", null);
      AppMethodBeat.o(14441);
      return;
    }
    ab.e(getTagName(), "onPageReady has been done before");
    AppMethodBeat.o(14441);
  }
  
  protected void aYA() {}
  
  public void aYB()
  {
    AppMethodBeat.i(14439);
    ab.i(getTagName(), "[loadUrlAndData] url:%s", new Object[] { this.keN });
    loadUrl(this.keN);
    AppMethodBeat.o(14439);
  }
  
  protected void aYC()
  {
    AppMethodBeat.i(14440);
    ab.i(getTagName(), "[initJsEnvironment]");
    new f(this, this.keS, new f.a()
    {
      public final void aZa()
      {
        AppMethodBeat.i(154567);
        ab.i(e.a(e.this), "[initJsEnvironment] onLoadedSucc");
        ab.i(e.a(e.this), "terry trace 1.3.1 initJsEnvironment Succ");
        AppMethodBeat.o(154567);
      }
    }).dgt();
    AppMethodBeat.o(14440);
  }
  
  protected void aYD() {}
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(14437);
        if (!this.keQ)
        {
          ab.d("MicroMsg.TmplWxJsWebView", "pendingScript:%s", new Object[] { paramString });
          this.keR.add(new Pair(paramString, paramValueCallback));
          AppMethodBeat.o(14437);
          return;
        }
        paramString = new e.1(this, paramString, paramValueCallback);
        if (Looper.getMainLooper().getThread() == Thread.currentThread())
        {
          paramString.run();
          AppMethodBeat.o(14437);
          continue;
        }
        al.d(paramString);
      }
      finally {}
      AppMethodBeat.o(14437);
    }
  }
  
  protected final String getFirstScreenCompletedAPI()
  {
    return "__tmpl_webview_inject_data.__onFirstScreenCompleted()";
  }
  
  protected final String getInjectAPI()
  {
    return "__tmpl_webview_inject_data.__getString()";
  }
  
  protected d.a getInterceptHandler()
  {
    return null;
  }
  
  public d getJsApiHandler()
  {
    return this.keS;
  }
  
  protected String getPageString()
  {
    return "";
  }
  
  protected int getTmplWebViewId()
  {
    return this.keh;
  }
  
  public w getWebViewClient()
  {
    return this.iyq;
  }
  
  public final boolean isReady()
  {
    return this.keQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.e
 * JD-Core Version:    0.7.0.1
 */