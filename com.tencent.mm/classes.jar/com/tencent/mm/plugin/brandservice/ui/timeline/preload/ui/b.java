package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import a.f.b.j;
import a.f.b.u.a;
import a.l;
import a.l.m;
import a.y;
import android.content.Context;
import android.os.RemoteException;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic.PreloadSession;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.p;
import com.tencent.mm.plugin.webview.preload.TmplParams;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.WebView;
import com.tencent.xweb.aa;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebView;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWxJsWebView;", "context", "Landroid/content/Context;", "tmplParams", "Lcom/tencent/mm/plugin/webview/preload/TmplParams;", "delayInitJsAPI", "", "(Landroid/content/Context;Lcom/tencent/mm/plugin/webview/preload/TmplParams;Z)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "contentId", "curUrl", "getDelayInitJsAPI", "()Z", "fullUrl", "hasAuthData", "hasUpdateData", "isCheckingInject", "isEvalFinished", "<set-?>", "isInjectDataSuccess", "setInjectDataSuccess", "(Z)V", "isNotifyPageSuccess", "setNotifyPageSuccess", "isSuccess", "isTmplReady", "setTmplReady", "needClearHistory", "getNeedClearHistory", "setNeedClearHistory", "notifyPageInfoString", "getNotifyPageInfoString", "setNotifyPageInfoString", "(Ljava/lang/String;)V", "onEvalFinished", "Lkotlin/Function0;", "", "onFirstScreenCompleted", "getOnFirstScreenCompleted", "()Lkotlin/jvm/functions/Function0;", "setOnFirstScreenCompleted", "(Lkotlin/jvm/functions/Function0;)V", "onNotifyPage", "getOnNotifyPage", "setOnNotifyPage", "onStateChangeListeners", "Ljava/util/LinkedList;", "Lkotlin/Function1;", "", "rawUrl", "receivePageData", "", "recodeInject", "session", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$PreloadSession;", "startLoadPage", "state", "getState", "()I", "setState", "(I)V", "addOnStateChangedListener", "onStateChange", "adjustInnerWidth", "checkInject", "clearOnStateChanged", "getInterceptHandler", "Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/JsApiHandler$IJsapiInterceptHandler;", "msg", "Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/MsgWrapper;", "getPageString", "getUrl", "initJsEnvironment", "loadUrlAndData", "notifyPageInfo", "onFirstScreenTrigger", "onInjectReady", "onWebLog", "value", "removeOnStateChangedListener", "setOnEvalFinished", "T", "", "callback", "Ljava/lang/ref/WeakReference;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "transferToState", "newState", "updateAuth", "updateData", "updateKV", "kv", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Kv15862;", "Companion", "plugin-brandservice_release"})
public final class b
  extends e
{
  public static final b.a kdI;
  private String cJr;
  private boolean csk;
  boolean kaQ;
  private String kdA;
  private a.f.a.a<y> kdB;
  boolean kdC;
  a.f.a.a<y> kdD;
  private a.f.a.a<y> kdE;
  private boolean kdF;
  private boolean kdG;
  private final boolean kdH;
  private boolean kdo;
  private String kdp;
  private long kdq;
  private long kdr;
  private boolean kds;
  private String kdt;
  private PreloadLogic.PreloadSession kdu;
  private String kdv;
  LinkedList<a.f.a.b<Integer, y>> kdw;
  boolean kdx;
  boolean kdy;
  private boolean kdz;
  private int state;
  
  static
  {
    AppMethodBeat.i(15028);
    kdI = new b.a((byte)0);
    AppMethodBeat.o(15028);
  }
  
  public b(Context paramContext, TmplParams paramTmplParams, boolean paramBoolean)
  {
    super(paramContext, paramTmplParams);
    AppMethodBeat.i(15027);
    this.kdH = paramBoolean;
    this.state = 1;
    this.kdw = new LinkedList();
    this.kdA = "";
    this.kdB = ((a.f.a.a)b.f.kdM);
    this.kdD = ((a.f.a.a)b.d.kdK);
    this.kdE = ((a.f.a.a)b.e.kdL);
    getPerformanceHelper().aX("onTmplLoadStart", System.currentTimeMillis());
    ab.i(getTAG(), "terry trace 1.1 createTmplWebView:delayInitJsAPI=%b", new Object[] { Boolean.valueOf(this.kdH) });
    aYB();
    if (!this.kdH) {
      aYC();
    }
    AppMethodBeat.o(15027);
  }
  
  private final boolean a(i parami)
  {
    AppMethodBeat.i(154577);
    try
    {
      j.q(parami, "msg");
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("performance", (String)parami.pJb.get("performance"));
      ((JSONObject)localObject).put("injectPageDataResult", (String)parami.pJb.get("injectPageDataResult"));
      localObject = ((JSONObject)localObject).toString();
      j.p(localObject, "pageInfo.toString()");
      this.kdA = ((String)localObject);
      this.kdB.invoke();
      this.keS.j(parami.vrN, "notifyPageInfo:ok", null);
      com.tencent.mm.plugin.webview.preload.a.kS(90);
      AppMethodBeat.o(154577);
      return false;
    }
    catch (JSONException localJSONException)
    {
      ab.printErrStackTrace(getTAG(), (Throwable)localJSONException, "", new Object[0]);
      this.keS.j(parami.vrN, "notifyPageInfo:fail", null);
      com.tencent.mm.plugin.webview.preload.a.kS(91);
      AppMethodBeat.o(154577);
      return false;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ab.printErrStackTrace(getTAG(), (Throwable)localRemoteException, "", new Object[0]);
      }
    }
  }
  
  private final void aYF()
  {
    AppMethodBeat.i(15022);
    int i = com.tencent.mm.cb.a.gw(getContext());
    float f = com.tencent.mm.cb.a.getDensity(getContext());
    ab.i(getTAG(), "adjustInnerWidth() screenWidth:" + i + ", density:" + f);
    if ((i > 0) && (f > 0.0F))
    {
      i = (int)(i / f);
      ab.i(getTAG(), "adjustInnerWidth() innerWidth:".concat(String.valueOf(i)));
      evaluateJavascript("javascript:window.innerWidth = ".concat(String.valueOf(i)), null);
    }
    AppMethodBeat.o(15022);
  }
  
  private final void sB(int paramInt)
  {
    AppMethodBeat.i(15018);
    ab.i(getTAG(), "transferToState() state:%d, newState:%d", new Object[] { Integer.valueOf(this.state), Integer.valueOf(paramInt) });
    this.state = paramInt;
    Iterator localIterator = ((Iterable)this.kdw).iterator();
    while (localIterator.hasNext()) {
      ((a.f.a.b)localIterator.next()).S(Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(15018);
  }
  
  private final void setInjectDataSuccess(boolean paramBoolean)
  {
    this.kdx = paramBoolean;
  }
  
  private final void setState(int paramInt)
  {
    this.state = paramInt;
  }
  
  protected final void Hi(String paramString)
  {
    AppMethodBeat.i(152742);
    if (paramString != null)
    {
      paramString = new JSONObject(paramString).getJSONObject("err");
      if (paramString != null)
      {
        int i = paramString.getInt("errCode");
        paramString = paramString.getString("msg");
        ab.e(getTAG(), "onWebLog:" + this.kdp + ',' + i + ',' + paramString + " \n " + this.kdt);
        com.tencent.mm.plugin.webview.preload.a.JZ(114);
        AppMethodBeat.o(152742);
        return;
      }
    }
    AppMethodBeat.o(152742);
  }
  
  public final void a(boolean paramBoolean, String paramString, PreloadLogic.PreloadSession paramPreloadSession)
  {
    AppMethodBeat.i(138515);
    try
    {
      if (this.state != 4)
      {
        ab.w(getTAG(), "[updateAuth]delay update auth, return, state:%d", new Object[] { Integer.valueOf(this.state) });
        this.kds = true;
        this.csk = paramBoolean;
        this.kdt = paramString;
        if (paramPreloadSession != null) {
          this.kdu = paramPreloadSession;
        }
        return;
      }
      this.kdv = paramString;
      sB(5);
      Object localObject = y.BMg;
      if (paramBoolean)
      {
        localObject = paramPreloadSession;
        if (paramPreloadSession == null) {
          localObject = this.kdu;
        }
        paramPreloadSession = paramString;
        if (paramString != null)
        {
          paramPreloadSession = paramString;
          if (localObject != null) {
            paramPreloadSession = p.a(paramString, (PreloadLogic.PreloadSession)localObject);
          }
        }
        ab.i(getTAG(), "terry trace 2.2 updateAuth");
        ab.i(getTAG(), "[updateAuth]ok fullUrl:%s", new Object[] { paramPreloadSession });
        evaluateJavascript("javascript:window.onPageAuthOK(" + new JSONObject().put("fullUrl", paramPreloadSession) + ')', (ValueCallback)new i(this));
        com.tencent.mm.plugin.webview.preload.a.gK(this.jZV.uYL, 133);
        AppMethodBeat.o(138515);
        return;
      }
    }
    finally
    {
      AppMethodBeat.o(138515);
    }
    ab.i(getTAG(), "[updateAuth]fail");
    evaluateJavascript("javascript:window.onPageAuthFail()", (ValueCallback)new b.j(this));
    com.tencent.mm.plugin.webview.preload.a.gK(this.jZV.uYL, 134);
    AppMethodBeat.o(138515);
  }
  
  protected final void aYA()
  {
    AppMethodBeat.i(152741);
    this.kdE.invoke();
    AppMethodBeat.o(152741);
  }
  
  public final void aYB()
  {
    AppMethodBeat.i(15015);
    ab.i(getTAG(), "terry trace 1.2 loadUrlAndData");
    ab.i(getTAG(), "[loadUrlAndData]");
    super.aYB();
    com.tencent.mm.plugin.webview.preload.a.gK(this.jZV.uYL, 112);
    AppMethodBeat.o(15015);
  }
  
  protected final void aYC()
  {
    AppMethodBeat.i(15016);
    ab.i(getTAG(), "terry trace 1.3 initJsEnvironment");
    ab.i(getTAG(), "[initJsEnvironment]");
    super.aYC();
    AppMethodBeat.o(15016);
  }
  
  protected final void aYD()
  {
    AppMethodBeat.i(15020);
    ab.v(getTAG(), "onInjectReady");
    aYE();
    AppMethodBeat.o(15020);
  }
  
  public final void aYE()
  {
    AppMethodBeat.i(15021);
    if (this.kdF)
    {
      AppMethodBeat.o(15021);
      return;
    }
    this.kdF = true;
    try
    {
      if (this.state != 1)
      {
        ab.w(getTAG(), "[onPageReady] state:%d alreay preload", new Object[] { Integer.valueOf(this.state) });
        return;
      }
      y localy = y.BMg;
      com.tencent.mm.plugin.webview.preload.a.gK(this.jZV.uYL, 113);
      evaluateJavascript("javascript:JSON.stringify(window.__appmsg_skeleton_success__)", (ValueCallback)new b.b(this));
      aYF();
      ab.i(getTAG(), "[onPageReady]");
      AppMethodBeat.o(15021);
      return;
    }
    finally
    {
      AppMethodBeat.o(15021);
    }
  }
  
  public final boolean b(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(15024);
    j.q(paramString1, "contentId");
    j.q(paramString2, "rawUrl");
    label552:
    label557:
    for (;;)
    {
      try
      {
        if (this.state != 2)
        {
          ab.w(getTAG(), "[updateData]delay update data state:" + this.state + ", return");
          this.kdp = paramString1;
          this.cJr = paramString2;
          this.kdq = paramLong1;
          this.kdr = paramLong2;
          this.kdo = true;
          return false;
        }
        sB(3);
        Object localObject = y.BMg;
        long l = System.currentTimeMillis();
        getPerformanceHelper().aX("onInjectStart", l);
        ab.i(getTAG(), "[updateData]data contentId:" + paramString1 + " startLoadPage:" + paramLong1 + " receivePageData:" + paramLong2);
        this.kdp = paramString1;
        this.cJr = paramString2;
        paramString2 = new JSONObject().put("data", "@param").put("timestamp", new JSONObject().put("startLoadPage", paramLong1).put("receivePageData", paramLong2)).put("url", paramString2).put("key", getRandomStr()).toString();
        j.p(paramString2, "JSONObject()\n//         …              .toString()");
        paramString2 = "[window.onReceivePageData(" + paramString2 + "),Date.now()].join(',')";
        localObject = getInjectAPI();
        j.p(localObject, "injectAPI");
        String str = m.aL(paramString2, "\"@param\"", (String)localObject);
        localObject = new u.a();
        ((u.a)localObject).BNn = false;
        paramLong1 = System.currentTimeMillis();
        if (!f.c((WebView)this)) {
          break label552;
        }
        int i = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.GV(paramString1);
        com.tencent.mmkv.d locald = c.sD(i);
        int j = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.a(paramString1, locald);
        if ((j > 0) && (j == i))
        {
          paramString1 = m.aL(paramString2, "\"@param\"", "@param");
          ab.i(getTAG(), "onReceivePageData buff parse native:".concat(String.valueOf(paramString1)));
          paramString2 = new aa(0, 512, (WebView)this);
          paramString2.aya(paramString1);
          paramString2.M(locald.AZY, j);
          paramString2.ayb(Hp("{err:window['___xweb_script_err']}") + '\n' + str);
          paramString1 = paramString2.toString();
          j.p(paramString1, "XWebScript(\n            …             }.toString()");
          ((u.a)localObject).BNn = true;
          com.tencent.mm.plugin.webview.preload.a.ai(120, System.currentTimeMillis() - paramLong1);
          if (((u.a)localObject).BNn) {
            break label557;
          }
          paramString1 = "javascript:".concat(String.valueOf(str));
          evaluateJavascript(paramString1, (ValueCallback)new b.k(this, l, (u.a)localObject, paramLong1));
          AppMethodBeat.o(15024);
          return true;
        }
      }
      finally
      {
        AppMethodBeat.o(15024);
      }
      com.tencent.mm.plugin.webview.preload.a.JZ(115);
      paramString1 = paramString2;
    }
  }
  
  public final a.f.a.b<Integer, y> f(a.f.a.b<? super Integer, y> paramb)
  {
    AppMethodBeat.i(154575);
    j.q(paramb, "onStateChange");
    this.kdw.add(paramb);
    AppMethodBeat.o(154575);
    return paramb;
  }
  
  public final boolean getDelayInitJsAPI()
  {
    return this.kdH;
  }
  
  protected final d.a getInterceptHandler()
  {
    AppMethodBeat.i(154576);
    d.a locala = (d.a)new b.c(this);
    AppMethodBeat.o(154576);
    return locala;
  }
  
  public final boolean getNeedClearHistory()
  {
    return this.kdz;
  }
  
  public final String getNotifyPageInfoString()
  {
    return this.kdA;
  }
  
  public final a.f.a.a<y> getOnFirstScreenCompleted()
  {
    return this.kdE;
  }
  
  public final a.f.a.a<y> getOnNotifyPage()
  {
    return this.kdB;
  }
  
  protected final String getPageString()
  {
    AppMethodBeat.i(15023);
    Object localObject = this.kdp;
    if (localObject != null)
    {
      String str = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.GU((String)localObject);
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    AppMethodBeat.o(15023);
    return localObject;
  }
  
  public final int getState()
  {
    return this.state;
  }
  
  final String getTAG()
  {
    AppMethodBeat.i(15014);
    String str = "MicroMsg.Preload.WebView:" + getTmplWebViewId();
    AppMethodBeat.o(15014);
    return str;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(15026);
    String str = super.getUrl();
    if ((this.state == 5) && (str != null) && (p.GI(str) == true))
    {
      str = this.kdv;
      AppMethodBeat.o(15026);
      return str;
    }
    AppMethodBeat.o(15026);
    return str;
  }
  
  public final void setNeedClearHistory(boolean paramBoolean)
  {
    this.kdz = paramBoolean;
  }
  
  public final void setNotifyPageInfoString(String paramString)
  {
    AppMethodBeat.i(154573);
    j.q(paramString, "<set-?>");
    this.kdA = paramString;
    AppMethodBeat.o(154573);
  }
  
  public final void setNotifyPageSuccess(boolean paramBoolean)
  {
    this.kdy = paramBoolean;
  }
  
  public final void setOnFirstScreenCompleted(a.f.a.a<y> parama)
  {
    AppMethodBeat.i(152740);
    j.q(parama, "<set-?>");
    this.kdE = parama;
    AppMethodBeat.o(152740);
  }
  
  public final void setOnNotifyPage(a.f.a.a<y> parama)
  {
    AppMethodBeat.i(154574);
    j.q(parama, "<set-?>");
    this.kdB = parama;
    AppMethodBeat.o(154574);
  }
  
  public final void setTmplReady(boolean paramBoolean)
  {
    this.kaQ = paramBoolean;
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "value", "", "kotlin.jvm.PlatformType", "onReceiveValue"})
  static final class i<T>
    implements ValueCallback<String>
  {
    i(b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.b
 * JD-Core Version:    0.7.0.1
 */