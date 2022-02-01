package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.view.u;
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
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.appcache.q;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.a.f;
import com.tencent.mm.plugin.appbrand.page.a.f.a;
import com.tencent.mm.plugin.appbrand.page.a.h;
import com.tencent.mm.plugin.appbrand.utils.m;
import com.tencent.mm.plugin.appbrand.utils.s.a;
import com.tencent.mm.plugin.appbrand.widget.input.al;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
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
  implements com.tencent.luggage.sdk.b.a.d, com.tencent.mm.plugin.appbrand.page.a.c
{
  String lBI;
  ViewGroup nmW;
  bb nmX;
  boolean nmY = false;
  private boolean nmZ = false;
  String nna;
  private aj nnb;
  private bf nnc;
  ao nnd;
  private bp nne;
  boolean nnf;
  a<PAGE>.d nng;
  private be nnh;
  private a nni;
  bh nnj;
  
  public a(PAGE paramPAGE)
  {
    super(paramPAGE);
  }
  
  private void bQx()
  {
    if (this.nne != null)
    {
      this.nne.setVisibility(8);
      if (u.aD(this.nne))
      {
        ((com.tencent.luggage.sdk.b.a.c)NN()).bRi().setNavLoadingIconVisibilityResetListener(null);
        ((com.tencent.luggage.sdk.b.a.c)NN()).bRi().setLoadingIconVisibility(this.nne.nuo);
        ((ViewGroup)this.nne.getParent()).removeView(this.nne);
        Log.i("Luggage.AbstractMPPageViewRenderer", "dismissWaitingReadyCover appId:%s, url:%s", new Object[] { getAppId(), this.lBI });
      }
    }
  }
  
  public final bf Nc()
  {
    return this.nnc;
  }
  
  public void Nd()
  {
    Log.i("Luggage.AbstractMPPageViewRenderer", "dispatchForeground appId:%s, url:%s, mIsPageReady:%b", new Object[] { getAppId(), this.lBI, Boolean.valueOf(this.nmZ) });
    super.Nd();
    this.nmX.onForeground();
    ((com.tencent.luggage.sdk.b.a.c)NN()).NW();
    if (!this.nmZ)
    {
      if (bQr()) {
        break label77;
      }
      bQx();
    }
    label77:
    while (this.nne == null) {
      return;
    }
    Object localObject = (FrameLayout)this.nmW;
    if (this.nne.getParent() != localObject)
    {
      boolean bool = ((com.tencent.luggage.sdk.b.a.c)NN()).bRi().cag();
      ((com.tencent.luggage.sdk.b.a.c)NN()).bRi().setLoadingIconVisibility(true);
      ((com.tencent.luggage.sdk.b.a.c)NN()).bRi().setNavLoadingIconVisibilityResetListener(this.nne);
      this.nne.nuo = bool;
      if ((this.nne.getParent() instanceof ViewGroup)) {
        ((ViewGroup)this.nne.getParent()).removeView(this.nne);
      }
      ((FrameLayout)localObject).addView(this.nne, new FrameLayout.LayoutParams(-1, -1));
    }
    localObject = this.nne;
    Context localContext = getContext();
    if (((bp)localObject).nqL != null) {
      ((bp)localObject).nqL.aG(localContext);
    }
    this.nne.bSo();
    this.nne.bringToFront();
    Log.i("Luggage.AbstractMPPageViewRenderer", "revealWaitingReadyCover appId:%s, url:%s", new Object[] { getAppId(), this.lBI });
  }
  
  public void Ne()
  {
    super.Ne();
    this.nmX.onBackground();
  }
  
  public Map<String, p> Nf()
  {
    return new com.tencent.luggage.sdk.a().Nt();
  }
  
  public void Ng()
  {
    Log.i("Luggage.AbstractMPPageViewRenderer", "dispatchPageReady appId:%s, url:%s", new Object[] { getAppId(), this.lBI });
    this.nmZ = true;
    bQx();
  }
  
  public final JSONObject Or()
  {
    JSONObject localJSONObject = com.tencent.luggage.sdk.g.b.f(NP().NY().Or());
    try
    {
      localJSONObject.put("isFirstPage", ((com.tencent.luggage.sdk.b.a.c)NN()).nqW);
      try
      {
        if (NP().ON().cyz != com.tencent.luggage.sdk.launching.b.cBC) {
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
  
  public <T> T S(Class<T> paramClass)
  {
    if (ICommLibReader.class.equals(paramClass)) {
      return paramClass.cast(((com.tencent.luggage.sdk.b.a.c)NN()).bqZ());
    }
    if (paramClass.isInstance(this)) {
      return paramClass.cast(this);
    }
    return super.S(paramClass);
  }
  
  public final View a(LayoutInflater paramLayoutInflater)
  {
    return new FrameLayout(paramLayoutInflater.getContext());
  }
  
  public void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject) {}
  
  public final bb aI(Context paramContext)
  {
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = getContext();
    }
    this.nmX = ee((Context)localObject);
    if ((System.currentTimeMillis() % 1000L == 1L) || (WeChatEnvironment.hasDebugger()) || (BuildInfo.IS_FLAVOR_RED))
    {
      Log.i("Luggage.AbstractMPPageViewRenderer", "do observeLongTask");
      this.nmX.addJavascriptInterface(bQs(), "PageLongTaskReporter");
      this.nnf = true;
    }
    paramContext = this.nmX;
    localObject = new d((Context)localObject);
    this.nng = ((d)localObject);
    paramContext.addJavascriptInterface(localObject, "__deviceInfo");
    return this.nmX;
  }
  
  protected final a ads(String paramString)
  {
    if (this.nni == null) {
      if (!((aa)((com.tencent.luggage.sdk.b.a.c)NN()).av(aa.class)).bRa()) {
        break label96;
      }
    }
    label96:
    for (Object localObject = new b((byte)0);; localObject = new c((byte)0))
    {
      this.nni = ((a)localObject);
      localObject = bh.ntk;
      this.nnj = bh.a.d(this);
      Log.i("Luggage.AbstractMPPageViewRenderer", "getInjectionMode created mode name = %s, appId = %s, reason = %s", new Object[] { this.nni.name(), getAppId(), paramString });
      return this.nni;
    }
  }
  
  public void adt(String paramString)
  {
    ((com.tencent.luggage.sdk.b.a.c)NN()).dF(paramString);
  }
  
  public final void b(com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb)
  {
    super.b(com.tencent.mm.plugin.appbrand.page.a.a.class, new bk((ac)NN()));
    super.b(paramb);
  }
  
  public boolean b(String paramString1, String paramString2, int paramInt)
  {
    return false;
  }
  
  protected boolean bQr()
  {
    return (NN() == null) || (!((com.tencent.luggage.sdk.b.a.c)NN()).nqW);
  }
  
  protected com.tencent.mm.plugin.appbrand.performance.g bQs()
  {
    new com.tencent.mm.plugin.appbrand.performance.g()
    {
      public final void notifyLongTask(long paramAnonymousLong)
      {
        AppMethodBeat.i(169500);
        Log.d("Luggage.AbstractMPPageViewRenderer", "notifyLongTask :%d", new Object[] { Long.valueOf(paramAnonymousLong) });
        AppMethodBeat.o(169500);
      }
    };
  }
  
  protected final be bQt()
  {
    if (this.nnh == null)
    {
      this.nnh = bQu();
      if (this.nnh == null) {
        this.nnh = new bi(this);
      }
    }
    return this.nnh;
  }
  
  protected be bQu()
  {
    return null;
  }
  
  protected final void bQv()
  {
    if (this.nmY) {
      return;
    }
    try
    {
      ads("injectAppSharedPageFrameScript").bQv();
      this.nmY = true;
      return;
    }
    catch (aq localaq) {}
  }
  
  protected void bQw() {}
  
  final void c(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    ((com.tencent.luggage.sdk.b.a.c)NN()).c(paramJSONObject, paramString, paramObject);
  }
  
  public void cb(View paramView)
  {
    this.nmW = ((FrameLayout)paramView);
    this.nmW.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView) {}
      
      public final void onViewDetachedFromWindow(View paramAnonymousView)
      {
        AppMethodBeat.i(147413);
        Object localObject = a.this.nnd;
        long l = SystemClock.uptimeMillis();
        paramAnonymousView = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        paramAnonymousView.setSource(4098);
        localObject = ((ao)localObject).nsv.iterator();
        while (((Iterator)localObject).hasNext())
        {
          View localView = (View)((ao.b)((Iterator)localObject).next()).nsR.get();
          if (localView != null) {
            localView.dispatchTouchEvent(paramAnonymousView);
          }
        }
        paramAnonymousView.recycle();
        AppMethodBeat.o(147413);
      }
    });
    this.nnc = new al((ac)NN());
    if (this.nmX == null) {
      ((com.tencent.luggage.sdk.b.a.c)NN()).bEb();
    }
    this.nmX.aG(getContext());
    this.nmX.setFullscreenImpl(((com.tencent.luggage.sdk.b.a.c)NN()).getFullscreenImpl());
    this.nmX.setOnScrollChangedListener(this.nnc);
    this.nmX.setWebViewLayoutListener(this.nnc);
    this.nnc.setupWebViewTouchInterceptor(this.nmX);
    paramView = this.nmX;
    this.nnb = new aj(getContext(), paramView);
    this.nnb.addView(this.nnc.getContainer());
    this.nnb.setOnPullDownOffsetListener(this.nnc);
    this.nnb.setOnPullDownListener(new aj.a()
    {
      public final void bQy()
      {
        AppMethodBeat.i(147414);
        if (a.this.NN() == null)
        {
          AppMethodBeat.o(147414);
          return;
        }
        ((com.tencent.luggage.sdk.b.a.c)a.this.NN()).b("onPullDownRefresh", null, new int[] { ((com.tencent.luggage.sdk.b.a.c)a.this.NN()).getComponentId() });
        AppMethodBeat.o(147414);
      }
    });
    this.nmW.addView(this.nnb);
    this.nnd = new ao(this.nnc.getContainer());
    this.nnd.setFullscreenImpl(((com.tencent.luggage.sdk.b.a.c)NN()).getFullscreenImpl());
  }
  
  public final RelativeLayout.LayoutParams cc(View paramView)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    if (paramView != null)
    {
      if (paramView.getId() == -1) {
        paramView.setId(2131296862);
      }
      localLayoutParams.addRule(2, paramView.getId());
    }
    return localLayoutParams;
  }
  
  public final void dispatchDestroy()
  {
    super.dispatchDestroy();
    this.nnc.a(this.nmX);
    this.nmX.destroy();
    this.nmX = null;
    this.nmW.removeAllViewsInLayout();
    this.nnb.removeAllViewsInLayout();
    this.nnb = null;
    this.nnc = null;
  }
  
  public void dispatchStart()
  {
    super.dispatchStart();
    super.b(com.tencent.mm.plugin.appbrand.page.a.d.class, new bl((ac)NN()));
    super.b(h.class, new bo((ac)NN()));
    m local7 = new m()
    {
      public final Object invoke(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
      {
        AppMethodBeat.i(169504);
        Log.e("Luggage.AbstractMPPageViewRenderer", "DummyPullDownExtension: invoke(%s), args=%s", new Object[] { paramAnonymousMethod.getName(), org.apache.commons.b.a.toString(paramAnonymousArrayOfObject, "NULL") });
        paramAnonymousObject = super.invoke(paramAnonymousObject, paramAnonymousMethod, paramAnonymousArrayOfObject);
        AppMethodBeat.o(169504);
        return paramAnonymousObject;
      }
    };
    super.b(f.class, (f)Proxy.newProxyInstance(f.class.getClassLoader(), new Class[] { f.class }, local7));
    com.tencent.luggage.sdk.b.a.b.b.a((ac)NN());
    if (((com.tencent.luggage.sdk.b.a.c)NN()).NP().getAppConfig().bzD())
    {
      this.nmX.setBackgroundColor(android.support.v4.content.b.n(getContext(), 2131099740));
      return;
    }
    this.nmX.setBackgroundColor(-1);
  }
  
  public boolean dy(String paramString)
  {
    this.lBI = ((com.tencent.luggage.sdk.b.a.c)NN()).lBI;
    this.nna = ((com.tencent.luggage.sdk.b.a.c)NN()).nna;
    Object localObject1 = this.nnb;
    super.b(f.class, new bm((ac)NN(), (aj)localObject1)
    {
      public final void a(f.a paramAnonymousa, final int paramAnonymousInt)
      {
        AppMethodBeat.i(147418);
        super.a(paramAnonymousa, paramAnonymousInt);
        if (a.this.NN() == null)
        {
          AppMethodBeat.o(147418);
          return;
        }
        ((com.tencent.luggage.sdk.b.a.c)a.this.NN()).P(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(147416);
            if ((a.this.NN() != null) && (((com.tencent.luggage.sdk.b.a.c)a.this.NN()).getContentView() != null)) {
              ((com.tencent.luggage.sdk.b.a.c)a.this.NN()).getContentView().setBackgroundColor(paramAnonymousInt);
            }
            if (a.a(a.this) != null) {
              a.a(a.this).setBackgroundColor(paramAnonymousInt);
            }
            AppMethodBeat.o(147416);
          }
        });
        AppMethodBeat.o(147418);
      }
      
      public final void eE(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(147417);
        boolean bool = a.this.NP().getAppConfig().bzD();
        Resources localResources = a.this.NP().mContext.getResources();
        if (bool) {}
        for (int i = 2131099650;; i = 2131099844)
        {
          i = com.tencent.mm.plugin.appbrand.ac.g.cu(paramAnonymousString2, localResources.getColor(i));
          a(f.a.az(paramAnonymousString1, bool), i);
          AppMethodBeat.o(147417);
          return;
        }
      }
    });
    this.nnd.a(new bd()
    {
      public final void a(AppBrandPageFullScreenView paramAnonymousAppBrandPageFullScreenView)
      {
        AppMethodBeat.i(147415);
        if (((com.tencent.luggage.sdk.b.a.c)a.this.NN()).nqU == null)
        {
          Log.e("Luggage.AbstractMPPageViewRenderer", "FullScreenViewAttach getContainerPage is null, check time sequence, err, appId[%s], url[%s]", new Object[] { a.this.getAppId(), a.this.lBI });
          AppMethodBeat.o(147415);
          return;
        }
        ((com.tencent.luggage.sdk.b.a.c)a.this.NN()).nqU.a((ac)a.this.NN(), paramAnonymousAppBrandPageFullScreenView);
        AppMethodBeat.o(147415);
      }
    });
    Object localObject2 = ((com.tencent.luggage.sdk.b.a.c)NN()).getPageConfig();
    ((com.tencent.luggage.sdk.b.a.c)NN()).bOF();
    localObject1 = (bl)S(bl.class);
    localObject2 = ((b.d)localObject2).lcB;
    ((bl)localObject1).ntx.cAC = false;
    ((bl)localObject1).cwU = ((String)localObject2);
    if (!((com.tencent.luggage.sdk.b.a.c)NN()).bqY().UW(this.lBI))
    {
      Log.e("Luggage.AbstractMPPageViewRenderer", "Empty page content, appId[%s] url[%s], abort inject", new Object[] { getAppId(), paramString });
      adt(paramString);
      return false;
    }
    if (bQr()) {
      this.nne = new bp(NP().mContext, (ac)NN());
    }
    bQw();
    bQv();
    paramString = this.lBI;
    try
    {
      ads(String.format(Locale.ENGLISH, "injectModuleSharedPageFrameScript(%s)", new Object[] { paramString })).adu(paramString);
      paramString = this.lBI;
    }
    catch (aq localaq1)
    {
      try
      {
        ads(String.format(Locale.ENGLISH, "injectPageScript(%s)", new Object[] { paramString })).adv(paramString);
        return true;
        localaq1 = localaq1;
        Log.e("Luggage.AbstractMPPageViewRenderer", "injectModuleSharedPageFrameScript appId[%s] path[%s] ScriptNotFoundException", new Object[] { getAppId(), paramString });
        NP().finish();
      }
      catch (aq localaq2)
      {
        for (;;)
        {
          Log.e("Luggage.AbstractMPPageViewRenderer", "injectPageScript appId[%s] url[%s] ScriptNotFoundException", new Object[] { getAppId(), paramString });
          NP().finish();
        }
      }
    }
  }
  
  protected final void eD(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      Log.e("Luggage.AbstractMPPageViewRenderer", "[!]injectScript appId[%s] name[%s] url[%s] hash[%d] source EMPTY", new Object[] { getAppId(), paramString1, this.lBI, Integer.valueOf(hashCode()) });
      return;
    }
    final d.a locala = new d.a();
    locala.scriptName = paramString1;
    locala.czz = paramString2;
    locala.czA = paramString2.length();
    final long l = System.currentTimeMillis();
    Log.i("Luggage.AbstractMPPageViewRenderer", "injectScript start, appId[%s] name[%s] url[%s] hash[%d]", new Object[] { getAppId(), paramString1, this.lBI, Integer.valueOf(hashCode()) });
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString1)) {
          continue;
        }
        Log.w("Luggage.AbstractMPPageViewRenderer", "[!] injectScript, valid name is required, appId:%s, url:%s", new Object[] { getAppId(), this.lBI });
        paramString1 = null;
      }
      catch (Exception paramString1)
      {
        paramString1 = null;
        continue;
      }
      com.tencent.mm.plugin.appbrand.utils.s.a(((com.tencent.luggage.sdk.b.a.c)NN()).getJsRuntime(), paramString1, paramString2, new s.a()
      {
        private void dP(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(169503);
          a.this.a(locala, paramAnonymousBoolean, l, System.currentTimeMillis(), null);
          AppMethodBeat.o(169503);
        }
        
        public final void du(String paramAnonymousString)
        {
          AppMethodBeat.i(169502);
          dP(false);
          AppMethodBeat.o(169502);
        }
        
        public final void onSuccess(String paramAnonymousString)
        {
          AppMethodBeat.i(169501);
          dP(true);
          AppMethodBeat.o(169501);
        }
      });
      return;
      paramString1 = new URL("https", WeChatHosts.domainString(2131761738), paramString1);
    }
  }
  
  protected abstract bb ee(Context paramContext);
  
  public final ao getCustomViewContainer()
  {
    return this.nnd;
  }
  
  protected final String getURL()
  {
    return this.lBI;
  }
  
  public final boolean isRunning()
  {
    com.tencent.luggage.sdk.b.a.c localc = (com.tencent.luggage.sdk.b.a.c)NN();
    return (localc != null) && (localc.isRunning());
  }
  
  public boolean y(String paramString1, String paramString2)
  {
    return false;
  }
  
  static abstract interface a
  {
    public abstract void adu(String paramString);
    
    public abstract void adv(String paramString);
    
    public abstract boolean adw(String paramString);
    
    public abstract void bQv();
    
    public abstract String name();
  }
  
  final class b
    implements a.a
  {
    private b() {}
    
    private void adx(String paramString)
    {
      AppMethodBeat.i(147423);
      String str = a.this.bQt().adT(paramString);
      if (TextUtils.isEmpty(str))
      {
        paramString = new aq(paramString);
        AppMethodBeat.o(147423);
        throw paramString;
      }
      a.this.eD(paramString, str);
      AppMethodBeat.o(147423);
    }
    
    public final void adu(String paramString)
    {
      AppMethodBeat.i(147425);
      if (!a.this.NP().kAI.bPn())
      {
        AppMethodBeat.o(147425);
        return;
      }
      paramString = a.this.NP().kAI.acN(paramString);
      if ("__APP__".equals(paramString))
      {
        AppMethodBeat.o(147425);
        return;
      }
      a.c(a.this).ay(paramString, true);
      StringBuilder localStringBuilder = new StringBuilder().append(paramString);
      if (paramString.endsWith("/")) {}
      for (paramString = "";; paramString = "/")
      {
        paramString = paramString;
        adx(paramString + "common.app.js");
        adx(paramString + "webview.app.js");
        AppMethodBeat.o(147425);
        return;
      }
    }
    
    public final void adv(String paramString) {}
    
    public final boolean adw(String paramString)
    {
      AppMethodBeat.i(229944);
      boolean bool = "webview.app.js".equals(paramString);
      AppMethodBeat.o(229944);
      return bool;
    }
    
    public final void bQv()
    {
      AppMethodBeat.i(147424);
      a.c(a.this).ay("__APP__", true);
      adx("common.app.js");
      adx("webview.app.js");
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
    
    public final void adu(String paramString)
    {
      AppMethodBeat.i(147427);
      if (!a.this.NP().kAI.bPn())
      {
        AppMethodBeat.o(147427);
        return;
      }
      String str = a.this.NP().kAI.acN(paramString);
      Object localObject = new StringBuilder().append(str);
      if (str.endsWith("/")) {}
      for (paramString = "";; paramString = "/")
      {
        paramString = paramString + "page-frame.js";
        localObject = a.this.bQt().adT(paramString);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        paramString = new aq(paramString);
        AppMethodBeat.o(147427);
        throw paramString;
      }
      a.c(a.this).ay(str, false);
      a.this.eD(paramString, (String)localObject);
      AppMethodBeat.o(147427);
    }
    
    public final void adv(String paramString)
    {
      AppMethodBeat.i(147428);
      String str = a.this.bQt().adT(paramString);
      a.this.eD(paramString, str);
      AppMethodBeat.o(147428);
    }
    
    public final boolean adw(String paramString)
    {
      AppMethodBeat.i(229945);
      if (("app-wxss.js".equals(paramString)) || ("page-frame.html".equals(paramString)))
      {
        AppMethodBeat.o(229945);
        return true;
      }
      AppMethodBeat.o(229945);
      return false;
    }
    
    public final void bQv()
    {
      AppMethodBeat.i(147426);
      a.c(a.this).ay("__APP__", false);
      if (a.this.NP().kAI.bPn())
      {
        localObject = a.this.bQt().adT("app-wxss.js");
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = new aq("app-wxss.js");
          AppMethodBeat.o(147426);
          throw ((Throwable)localObject);
        }
        a.this.eD("app-wxss.js", (String)localObject);
        AppMethodBeat.o(147426);
        return;
      }
      Object localObject = a.this.bQt().adT("page-frame.html");
      a.this.eD("page-frame.html", (String)localObject);
      AppMethodBeat.o(147426);
    }
    
    public final String name()
    {
      return "Legacy";
    }
  }
  
  final class d
    extends ay
  {
    public d(Context paramContext)
    {
      super();
    }
    
    @JavascriptInterface
    public final float getWidth()
    {
      AppMethodBeat.i(147429);
      float f1 = (float)Math.ceil(a.this.NP().getWindowAndroid().getVDisplayMetrics().widthPixels / getPixelRatio());
      float f2 = (float)Math.ceil(a.b(a.this).getWidth() / super.getPixelRatio());
      if ((f2 > 0.0F) && (f2 != f1)) {
        Log.w("Luggage.AbstractMPPageViewRenderer", "__deviceInfo.getWidth(), resources[%f] != view[%f], may in pad env", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
      }
      AppMethodBeat.o(147429);
      return f1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.a
 * JD-Core Version:    0.7.0.1
 */