package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import androidx.core.g.w;
import com.tencent.luggage.l.a.g;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.ar;
import com.tencent.mm.plugin.appbrand.appcache.q;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.page.a.f;
import com.tencent.mm.plugin.appbrand.page.a.f.a;
import com.tencent.mm.plugin.appbrand.page.a.h;
import com.tencent.mm.plugin.appbrand.utils.u.a;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.plugin.appbrand.widget.input.aq;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.lang.ref.WeakReference;
import java.lang.reflect.Proxy;
import java.net.URL;
import java.util.Deque;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class a<PAGE extends com.tencent.luggage.sdk.b.a.c>
  extends com.tencent.luggage.sdk.b.a.b.a<PAGE>
  implements com.tencent.luggage.sdk.b.a.d
{
  String oxe;
  ViewGroup qoE;
  bd qoF;
  boolean qoG = false;
  private boolean qoH = false;
  String qoI;
  private ak qoJ;
  private bh qoK;
  ap qoL;
  private br qoM;
  boolean qoN;
  a<PAGE>.d qoO;
  private bg qoP;
  private a qoQ;
  bj qoR;
  
  public a(PAGE paramPAGE)
  {
    super(paramPAGE);
  }
  
  private void cdn()
  {
    if (this.qoM != null)
    {
      this.qoM.setVisibility(8);
      if (w.al(this.qoM))
      {
        ((com.tencent.luggage.sdk.b.a.c)QK()).cdY().setNavLoadingIconVisibilityResetListener(null);
        ((com.tencent.luggage.sdk.b.a.c)QK()).cdY().setLoadingIconVisibility(this.qoM.qwi);
        ((ViewGroup)this.qoM.getParent()).removeView(this.qoM);
        Log.i("Luggage.AbstractMPPageViewRenderer", "dismissWaitingReadyCover appId:%s, url:%s", new Object[] { getAppId(), this.oxe });
      }
    }
  }
  
  public boolean C(String paramString1, String paramString2)
  {
    return false;
  }
  
  public final bh PU()
  {
    return this.qoK;
  }
  
  public void PV()
  {
    Log.i("Luggage.AbstractMPPageViewRenderer", "dispatchForeground appId:%s, url:%s, mIsPageReady:%b", new Object[] { getAppId(), this.oxe, Boolean.valueOf(this.qoH) });
    super.PV();
    this.qoF.onForeground();
    ((com.tencent.luggage.sdk.b.a.c)QK()).QU();
    if (!this.qoH)
    {
      if (cdh()) {
        break label77;
      }
      cdn();
    }
    label77:
    while (this.qoM == null) {
      return;
    }
    Object localObject = (FrameLayout)this.qoE;
    if (this.qoM.getParent() != localObject)
    {
      boolean bool = ((com.tencent.luggage.sdk.b.a.c)QK()).cdY().cnd();
      ((com.tencent.luggage.sdk.b.a.c)QK()).cdY().setLoadingIconVisibility(true);
      ((com.tencent.luggage.sdk.b.a.c)QK()).cdY().setNavLoadingIconVisibilityResetListener(this.qoM);
      this.qoM.qwi = bool;
      if ((this.qoM.getParent() instanceof ViewGroup)) {
        ((ViewGroup)this.qoM.getParent()).removeView(this.qoM);
      }
      ((FrameLayout)localObject).addView(this.qoM, new FrameLayout.LayoutParams(-1, -1));
    }
    localObject = this.qoM;
    Context localContext = getContext();
    if (((br)localObject).qsx != null) {
      ((br)localObject).qsx.aD(localContext);
    }
    this.qoM.cfo();
    this.qoM.bringToFront();
    Log.i("Luggage.AbstractMPPageViewRenderer", "revealWaitingReadyCover appId:%s, url:%s", new Object[] { getAppId(), this.oxe });
  }
  
  public void PW()
  {
    super.PW();
    this.qoF.onBackground();
  }
  
  public Map<String, o> PX()
  {
    return new com.tencent.luggage.sdk.a().Qo();
  }
  
  public void PY()
  {
    Log.i("Luggage.AbstractMPPageViewRenderer", "dispatchPageReady appId:%s, url:%s", new Object[] { getAppId(), this.oxe });
    this.qoH = true;
    cdn();
  }
  
  public <T> T R(Class<T> paramClass)
  {
    if (ICommLibReader.class.equals(paramClass)) {
      return paramClass.cast(((com.tencent.luggage.sdk.b.a.c)QK()).bBP());
    }
    if (paramClass.isInstance(this)) {
      return paramClass.cast(this);
    }
    return super.R(paramClass);
  }
  
  public final JSONObject Ro()
  {
    JSONObject localJSONObject = com.tencent.luggage.sdk.h.c.i(QM().QW().Ro());
    try
    {
      localJSONObject.put("isFirstPage", ((com.tencent.luggage.sdk.b.a.c)QK()).qsI);
      try
      {
        if (QM().Sk().cxe != com.tencent.luggage.sdk.launching.b.cBf) {
          break label112;
        }
        bool = true;
        localJSONObject.put("prerender", bool);
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          boolean bool;
          Log.e("Luggage.AbstractMPPageViewRenderer", "generateWxConfig appId[%s] put prerender e=%s", new Object[] { getAppId(), localJSONException2 });
        }
      }
      localJSONObject.remove("permission");
      localJSONObject.remove("subpackages");
      localJSONObject.remove("pages");
      return localJSONObject;
    }
    catch (JSONException localJSONException1)
    {
      for (;;)
      {
        Log.e("Luggage.AbstractMPPageViewRenderer", "generateWxConfig appId[%s] put isFirstPage e=%s", new Object[] { getAppId(), localJSONException1 });
        continue;
        label112:
        bool = false;
      }
    }
  }
  
  public final View a(LayoutInflater paramLayoutInflater)
  {
    return new FrameLayout(paramLayoutInflater.getContext().getApplicationContext());
  }
  
  public void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject) {}
  
  public final bd aF(Context paramContext)
  {
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = getContext();
    }
    this.qoF = ed((Context)localObject);
    if ((System.currentTimeMillis() % 1000L == 1L) || (WeChatEnvironment.hasDebugger()) || (BuildInfo.IS_FLAVOR_RED))
    {
      Log.i("Luggage.AbstractMPPageViewRenderer", "do observeLongTask");
      this.qoF.addJavascriptInterface(cdi(), "PageLongTaskReporter");
      this.qoN = true;
    }
    paramContext = this.qoF;
    localObject = new d((Context)localObject);
    this.qoO = ((d)localObject);
    paramContext.addJavascriptInterface(localObject, "__deviceInfo");
    return this.qoF;
  }
  
  protected final a aln(String paramString)
  {
    if (this.qoQ == null) {
      if (!((ab)((com.tencent.luggage.sdk.b.a.c)QK()).au(ab.class)).cdQ()) {
        break label96;
      }
    }
    label96:
    for (Object localObject = new b((byte)0);; localObject = new c((byte)0))
    {
      this.qoQ = ((a)localObject);
      localObject = bj.qvd;
      this.qoR = bj.a.d(this);
      Log.i("Luggage.AbstractMPPageViewRenderer", "getInjectionMode created mode name = %s, appId = %s, reason = %s", new Object[] { this.qoQ.name(), getAppId(), paramString });
      return this.qoQ;
    }
  }
  
  public void alo(String paramString)
  {
    ((com.tencent.luggage.sdk.b.a.c)QK()).dY(paramString);
  }
  
  public final void b(com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb)
  {
    super.b(com.tencent.mm.plugin.appbrand.page.a.a.class, new bm((ad)QK()));
    super.b(paramb);
  }
  
  public boolean b(String paramString, ca paramca)
  {
    this.oxe = ((com.tencent.luggage.sdk.b.a.c)QK()).oxe;
    this.qoI = ((com.tencent.luggage.sdk.b.a.c)QK()).qoI;
    Object localObject = this.qoJ;
    super.b(f.class, new bo((ad)QK(), (ak)localObject)
    {
      public final void a(f.a paramAnonymousa, final int paramAnonymousInt)
      {
        AppMethodBeat.i(147418);
        super.a(paramAnonymousa, paramAnonymousInt);
        if (a.this.QK() == null)
        {
          AppMethodBeat.o(147418);
          return;
        }
        ((com.tencent.luggage.sdk.b.a.c)a.this.QK()).P(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(147416);
            if ((a.this.QK() != null) && (((com.tencent.luggage.sdk.b.a.c)a.this.QK()).getContentView() != null)) {
              ((com.tencent.luggage.sdk.b.a.c)a.this.QK()).getContentView().setBackgroundColor(paramAnonymousInt);
            }
            if (a.a(a.this) != null) {
              a.a(a.this).setBackgroundColor(paramAnonymousInt);
            }
            AppMethodBeat.o(147416);
          }
        });
        AppMethodBeat.o(147418);
      }
      
      public final void eS(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(147417);
        boolean bool = a.this.QM().getAppConfig().bKS();
        Resources localResources = a.this.QM().mContext.getResources();
        if (bool) {}
        for (int i = com.tencent.luggage.l.a.a.BG_2;; i = com.tencent.luggage.l.a.a.White)
        {
          i = com.tencent.mm.plugin.appbrand.ac.g.cO(paramAnonymousString2, localResources.getColor(i));
          a(f.a.aB(paramAnonymousString1, bool), i);
          AppMethodBeat.o(147417);
          return;
        }
      }
    });
    this.qoL.a(new bf()
    {
      public final void a(AppBrandPageFullScreenView paramAnonymousAppBrandPageFullScreenView)
      {
        AppMethodBeat.i(147415);
        if (((com.tencent.luggage.sdk.b.a.c)a.this.QK()).qsG == null)
        {
          Log.e("Luggage.AbstractMPPageViewRenderer", "FullScreenViewAttach getContainerPage is null, check time sequence, err, appId[%s], url[%s]", new Object[] { a.this.getAppId(), a.this.oxe });
          AppMethodBeat.o(147415);
          return;
        }
        ((com.tencent.luggage.sdk.b.a.c)a.this.QK()).qsG.a((ad)a.this.QK(), paramAnonymousAppBrandPageFullScreenView);
        AppMethodBeat.o(147415);
      }
    });
    localObject = ((com.tencent.luggage.sdk.b.a.c)QK()).getPageConfig();
    ((com.tencent.luggage.sdk.b.a.c)QK()).b(paramca);
    paramca = (bn)R(bn.class);
    localObject = ((b.d)localObject).nWK;
    paramca.qvs.czI = false;
    paramca.cvz = ((String)localObject);
    if (!((com.tencent.luggage.sdk.b.a.c)QK()).bBO().acG(this.oxe))
    {
      Log.e("Luggage.AbstractMPPageViewRenderer", "Empty page content, appId[%s] url[%s], abort inject", new Object[] { getAppId(), paramString });
      alo(paramString);
      return false;
    }
    if (cdh()) {
      this.qoM = new br(QM().mContext, (ad)QK());
    }
    cdm();
    cdl();
    paramString = this.oxe;
    try
    {
      aln(String.format(Locale.ENGLISH, "injectModuleSharedPageFrameScript(%s)", new Object[] { paramString })).alp(paramString);
      paramString = this.oxe;
    }
    catch (ar paramca)
    {
      try
      {
        aln(String.format(Locale.ENGLISH, "injectPageScript(%s)", new Object[] { paramString })).alq(paramString);
        return true;
        paramca = paramca;
        Log.e("Luggage.AbstractMPPageViewRenderer", "injectModuleSharedPageFrameScript appId[%s] path[%s] ScriptNotFoundException", new Object[] { getAppId(), paramString });
      }
      catch (ar paramca)
      {
        for (;;)
        {
          Log.e("Luggage.AbstractMPPageViewRenderer", "injectPageScript appId[%s] url[%s] ScriptNotFoundException", new Object[] { getAppId(), paramString });
        }
      }
    }
  }
  
  public boolean b(String paramString1, String paramString2, int paramInt)
  {
    return false;
  }
  
  protected final String btD()
  {
    return this.oxe;
  }
  
  final void c(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    ((com.tencent.luggage.sdk.b.a.c)QK()).c(paramJSONObject, paramString, paramObject);
  }
  
  protected boolean cdh()
  {
    return (QK() == null) || (!((com.tencent.luggage.sdk.b.a.c)QK()).qsI);
  }
  
  protected com.tencent.mm.plugin.appbrand.performance.g cdi()
  {
    return new a.5(this);
  }
  
  protected final bg cdj()
  {
    if (this.qoP == null)
    {
      this.qoP = cdk();
      if (this.qoP == null) {
        this.qoP = new bk(this);
      }
    }
    return this.qoP;
  }
  
  protected bg cdk()
  {
    return null;
  }
  
  protected final void cdl()
  {
    if (this.qoG) {
      return;
    }
    try
    {
      aln("injectAppSharedPageFrameScript").cdl();
      this.qoG = true;
      return;
    }
    catch (ar localar) {}
  }
  
  protected void cdm() {}
  
  public void ct(View paramView)
  {
    this.qoE = ((FrameLayout)paramView);
    this.qoE.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView) {}
      
      public final void onViewDetachedFromWindow(View paramAnonymousView)
      {
        AppMethodBeat.i(147413);
        Object localObject = a.this.qoL;
        long l = SystemClock.uptimeMillis();
        paramAnonymousView = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        paramAnonymousView.setSource(4098);
        localObject = ((ap)localObject).quo.iterator();
        while (((Iterator)localObject).hasNext())
        {
          View localView = (View)((ap.b)((Iterator)localObject).next()).quK.get();
          if (localView != null) {
            localView.dispatchTouchEvent(paramAnonymousView);
          }
        }
        paramAnonymousView.recycle();
        AppMethodBeat.o(147413);
      }
    });
    this.qoK = new aq((ad)QK());
    if (this.qoF == null) {
      ((com.tencent.luggage.sdk.b.a.c)QK()).bPz();
    }
    this.qoF.aD(getContext());
    this.qoF.setFullscreenImpl(((com.tencent.luggage.sdk.b.a.c)QK()).getFullscreenImpl());
    this.qoF.setOnScrollChangedListener(this.qoK);
    this.qoF.setWebViewLayoutListener(this.qoK);
    this.qoK.setupWebViewTouchInterceptor(this.qoF);
    bd localbd = this.qoF;
    if (QM() != null) {}
    for (paramView = QM().mContext;; paramView = getContext())
    {
      this.qoJ = new ak(paramView, localbd);
      this.qoJ.addView(this.qoK.getContainer());
      this.qoJ.setOnPullDownOffsetListener(this.qoK);
      this.qoJ.setOnPullDownListener(new ak.a()
      {
        public final void cdo()
        {
          AppMethodBeat.i(147414);
          if (a.this.QK() == null)
          {
            AppMethodBeat.o(147414);
            return;
          }
          ((com.tencent.luggage.sdk.b.a.c)a.this.QK()).b("onPullDownRefresh", null, new int[] { ((com.tencent.luggage.sdk.b.a.c)a.this.QK()).getComponentId() });
          AppMethodBeat.o(147414);
        }
      });
      this.qoE.addView(this.qoJ);
      this.qoL = new ap(this.qoK.getContainer());
      this.qoL.setFullscreenImpl(((com.tencent.luggage.sdk.b.a.c)QK()).getFullscreenImpl());
      return;
    }
  }
  
  public final RelativeLayout.LayoutParams cu(View paramView)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    if (paramView != null)
    {
      if (paramView.getId() == -1) {
        paramView.setId(com.tencent.luggage.l.a.d.app_brand_page_view_footer);
      }
      localLayoutParams.addRule(2, paramView.getId());
    }
    return localLayoutParams;
  }
  
  public final void dispatchDestroy()
  {
    super.dispatchDestroy();
    this.qoK.a(this.qoF);
    this.qoF.destroy();
    this.qoF = null;
    this.qoE.removeAllViewsInLayout();
    this.qoJ.removeAllViewsInLayout();
    this.qoJ = null;
    this.qoK = null;
  }
  
  public void dispatchStart()
  {
    super.dispatchStart();
    super.b(com.tencent.mm.plugin.appbrand.page.a.d.class, new bn((ad)QK()));
    super.b(h.class, new bq((ad)QK()));
    a.7 local7 = new a.7();
    super.b(f.class, (f)Proxy.newProxyInstance(f.class.getClassLoader(), new Class[] { f.class }, local7));
    com.tencent.luggage.sdk.b.a.b.b.a((ad)QK());
    if (((com.tencent.luggage.sdk.b.a.c)QK()).QM().getAppConfig().bKS())
    {
      this.qoF.setBackgroundColor(androidx.core.content.a.w(getContext(), com.tencent.luggage.l.a.a.Dark_0));
      return;
    }
    this.qoF.setBackgroundColor(-1);
  }
  
  protected final void eR(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      Log.e("Luggage.AbstractMPPageViewRenderer", "[!]injectScript appId[%s] name[%s] url[%s] hash[%d] source EMPTY", new Object[] { getAppId(), paramString1, this.oxe, Integer.valueOf(hashCode()) });
      return;
    }
    final d.a locala = new d.a();
    locala.scriptName = paramString1;
    locala.cyv = paramString2;
    locala.cyw = paramString2.length();
    final long l = System.currentTimeMillis();
    Log.i("Luggage.AbstractMPPageViewRenderer", "injectScript start, appId[%s] name[%s] url[%s] hash[%d]", new Object[] { getAppId(), paramString1, this.oxe, Integer.valueOf(hashCode()) });
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString1)) {
          continue;
        }
        Log.w("Luggage.AbstractMPPageViewRenderer", "[!] injectScript, valid name is required, appId:%s, url:%s", new Object[] { getAppId(), this.oxe });
        paramString1 = null;
      }
      catch (Exception paramString1)
      {
        paramString1 = null;
        continue;
      }
      com.tencent.mm.plugin.appbrand.utils.u.a(((com.tencent.luggage.sdk.b.a.c)QK()).getJsRuntime(), paramString1, paramString2, new u.a()
      {
        private void eo(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(169503);
          a.this.a(locala, paramAnonymousBoolean, l, System.currentTimeMillis(), null);
          AppMethodBeat.o(169503);
        }
        
        public final void dL(String paramAnonymousString)
        {
          AppMethodBeat.i(169502);
          eo(false);
          AppMethodBeat.o(169502);
        }
        
        public final void onSuccess(String paramAnonymousString)
        {
          AppMethodBeat.i(169501);
          eo(true);
          AppMethodBeat.o(169501);
        }
      });
      return;
      paramString1 = new URL("https", WeChatHosts.domainString(a.g.host_servicewechat_com), paramString1);
    }
  }
  
  protected abstract bd ed(Context paramContext);
  
  public final ap getCustomViewContainer()
  {
    return this.qoL;
  }
  
  public final boolean isRunning()
  {
    com.tencent.luggage.sdk.b.a.c localc = (com.tencent.luggage.sdk.b.a.c)QK();
    return (localc != null) && (localc.isRunning());
  }
  
  static abstract interface a
  {
    public abstract void alp(String paramString);
    
    public abstract void alq(String paramString);
    
    public abstract boolean alr(String paramString);
    
    public abstract void cdl();
    
    public abstract String name();
  }
  
  final class b
    implements a.a
  {
    private b() {}
    
    private void als(String paramString)
    {
      AppMethodBeat.i(147423);
      String str = a.this.cdj().alO(paramString);
      if (TextUtils.isEmpty(str))
      {
        paramString = new ar(paramString);
        AppMethodBeat.o(147423);
        throw paramString;
      }
      a.this.eR(paramString, str);
      AppMethodBeat.o(147423);
    }
    
    public final void alp(String paramString)
    {
      AppMethodBeat.i(147425);
      if (!a.this.QM().ntS.cbE())
      {
        AppMethodBeat.o(147425);
        return;
      }
      paramString = a.this.QM().ntS.akH(paramString);
      if ("__APP__".equals(paramString))
      {
        AppMethodBeat.o(147425);
        return;
      }
      a.c(a.this).aA(paramString, true);
      StringBuilder localStringBuilder = new StringBuilder().append(paramString);
      if (paramString.endsWith("/")) {}
      for (paramString = "";; paramString = "/")
      {
        paramString = paramString;
        als(paramString + "common.app.js");
        als(paramString + "webview.app.js");
        AppMethodBeat.o(147425);
        return;
      }
    }
    
    public final void alq(String paramString) {}
    
    public final boolean alr(String paramString)
    {
      AppMethodBeat.i(236799);
      boolean bool = "webview.app.js".equals(paramString);
      AppMethodBeat.o(236799);
      return bool;
    }
    
    public final void cdl()
    {
      AppMethodBeat.i(147424);
      a.c(a.this).aA("__APP__", true);
      als("common.app.js");
      als("webview.app.js");
      AppMethodBeat.o(147424);
    }
    
    public final String name()
    {
      return "LazyCodeLoading";
    }
  }
  
  final class c
    implements a.a
  {
    private c() {}
    
    public final void alp(String paramString)
    {
      AppMethodBeat.i(147427);
      if (!a.this.QM().ntS.cbE())
      {
        AppMethodBeat.o(147427);
        return;
      }
      String str = a.this.QM().ntS.akH(paramString);
      Object localObject = new StringBuilder().append(str);
      if (str.endsWith("/")) {}
      for (paramString = "";; paramString = "/")
      {
        paramString = paramString + "page-frame.js";
        localObject = a.this.cdj().alO(paramString);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        paramString = new ar(paramString);
        AppMethodBeat.o(147427);
        throw paramString;
      }
      a.c(a.this).aA(str, false);
      a.this.eR(paramString, (String)localObject);
      AppMethodBeat.o(147427);
    }
    
    public final void alq(String paramString)
    {
      AppMethodBeat.i(147428);
      String str = a.this.cdj().alO(paramString);
      a.this.eR(paramString, str);
      AppMethodBeat.o(147428);
    }
    
    public final boolean alr(String paramString)
    {
      AppMethodBeat.i(234683);
      if (("app-wxss.js".equals(paramString)) || ("page-frame.html".equals(paramString)))
      {
        AppMethodBeat.o(234683);
        return true;
      }
      AppMethodBeat.o(234683);
      return false;
    }
    
    public final void cdl()
    {
      AppMethodBeat.i(147426);
      a.c(a.this).aA("__APP__", false);
      if (a.this.QM().ntS.cbE())
      {
        localObject = a.this.cdj().alO("app-wxss.js");
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = new ar("app-wxss.js");
          AppMethodBeat.o(147426);
          throw ((Throwable)localObject);
        }
        a.this.eR("app-wxss.js", (String)localObject);
        AppMethodBeat.o(147426);
        return;
      }
      Object localObject = a.this.cdj().alO("page-frame.html");
      a.this.eR("page-frame.html", (String)localObject);
      AppMethodBeat.o(147426);
    }
    
    public final String name()
    {
      return "Legacy";
    }
  }
  
  final class d
    extends ba
  {
    public d(Context paramContext)
    {
      super();
    }
    
    @JavascriptInterface
    public final float getWidth()
    {
      AppMethodBeat.i(147429);
      float f1 = (float)Math.ceil(a.this.QM().getWindowAndroid().getVDisplayMetrics().widthPixels / getPixelRatio());
      float f2 = (float)Math.ceil(a.b(a.this).getWidth() / super.getPixelRatio());
      if ((f2 > 0.0F) && (f2 != f1)) {
        Log.w("Luggage.AbstractMPPageViewRenderer", "__deviceInfo.getWidth(), resources[%f] != view[%f], may in pad env", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
      }
      AppMethodBeat.o(147429);
      return f1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.a
 * JD-Core Version:    0.7.0.1
 */