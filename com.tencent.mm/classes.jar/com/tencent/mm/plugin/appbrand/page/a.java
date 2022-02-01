package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.view.t;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.ap;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.b.f;
import com.tencent.mm.plugin.appbrand.page.b.f.a;
import com.tencent.mm.plugin.appbrand.page.b.h;
import com.tencent.mm.plugin.appbrand.utils.q.a;
import com.tencent.mm.plugin.appbrand.widget.input.al;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bu;
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
  implements com.tencent.luggage.sdk.b.a.d, com.tencent.mm.plugin.appbrand.page.b.c
{
  public String kuf;
  ViewGroup lYb;
  protected ay lYc;
  boolean lYd = false;
  private boolean lYe = false;
  String lYf;
  private ah lYg;
  private bc lYh;
  am lYi;
  private bm lYj;
  boolean lYk;
  a<PAGE>.d lYl;
  private bb lYm;
  private a lYn;
  be lYo;
  
  public a(PAGE paramPAGE)
  {
    super(paramPAGE);
  }
  
  private void btM()
  {
    if (this.lYj != null)
    {
      this.lYj.setVisibility(8);
      if (t.aC(this.lYj))
      {
        ((com.tencent.luggage.sdk.b.a.c)El()).bux().setNavLoadingIconVisibilityResetListener(null);
        ((com.tencent.luggage.sdk.b.a.c)El()).bux().setLoadingIconVisibility(this.lYj.mfy);
        ((ViewGroup)this.lYj.getParent()).removeView(this.lYj);
        ad.i("Luggage.AbstractMPPageViewRenderer", "dismissWaitingReadyCover appId:%s, url:%s", new Object[] { getAppId(), this.kuf });
      }
    }
  }
  
  private void c(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    ((com.tencent.luggage.sdk.b.a.c)El()).c(paramJSONObject, paramString, paramObject);
  }
  
  public final bc DC()
  {
    return this.lYh;
  }
  
  public final am DD()
  {
    return this.lYi;
  }
  
  public void DE()
  {
    ad.i("Luggage.AbstractMPPageViewRenderer", "dispatchForeground appId:%s, url:%s, mIsPageReady:%b", new Object[] { getAppId(), this.kuf, Boolean.valueOf(this.lYe) });
    super.DE();
    this.lYc.onForeground();
    ((com.tencent.luggage.sdk.b.a.c)El()).Ev();
    if (!this.lYe)
    {
      if (btG()) {
        break label77;
      }
      btM();
    }
    label77:
    while (this.lYj == null) {
      return;
    }
    Object localObject = (FrameLayout)this.lYb;
    if (this.lYj.getParent() != localObject)
    {
      boolean bool = ((com.tencent.luggage.sdk.b.a.c)El()).bux().bCo();
      ((com.tencent.luggage.sdk.b.a.c)El()).bux().setLoadingIconVisibility(true);
      ((com.tencent.luggage.sdk.b.a.c)El()).bux().setNavLoadingIconVisibilityResetListener(this.lYj);
      this.lYj.mfy = bool;
      if ((this.lYj.getParent() instanceof ViewGroup)) {
        ((ViewGroup)this.lYj.getParent()).removeView(this.lYj);
      }
      ((FrameLayout)localObject).addView(this.lYj, new FrameLayout.LayoutParams(-1, -1));
    }
    localObject = this.lYj;
    Context localContext = getContext();
    if (((bm)localObject).mbU != null) {
      ((bm)localObject).mbU.aw(localContext);
    }
    this.lYj.bvx();
    this.lYj.bringToFront();
    ad.i("Luggage.AbstractMPPageViewRenderer", "revealWaitingReadyCover appId:%s, url:%s", new Object[] { getAppId(), this.kuf });
  }
  
  public void DF()
  {
    super.DF();
    this.lYc.onBackground();
  }
  
  public Map<String, m> DG()
  {
    return new com.tencent.luggage.sdk.a().DU();
  }
  
  public void DH()
  {
    ad.i("Luggage.AbstractMPPageViewRenderer", "dispatchPageReady appId:%s, url:%s", new Object[] { getAppId(), this.kuf });
    this.lYe = true;
    btM();
  }
  
  public final JSONObject EN()
  {
    JSONObject localJSONObject = En().Ew().EN();
    try
    {
      localJSONObject.put("isFirstPage", ((com.tencent.luggage.sdk.b.a.c)El()).mcf);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      ad.e("Luggage.AbstractMPPageViewRenderer", "generateWxConfig appId[%s] put isFirstPage e=%s", new Object[] { getAppId(), localJSONException });
    }
    return localJSONObject;
  }
  
  public <T> T Q(Class<T> paramClass)
  {
    if (ICommLibReader.class.equals(paramClass)) {
      return paramClass.cast(((com.tencent.luggage.sdk.b.a.c)El()).aVF());
    }
    if (paramClass.isInstance(this)) {
      return paramClass.cast(this);
    }
    return super.Q(paramClass);
  }
  
  protected final a SW(String paramString)
  {
    if (this.lYn == null) {
      if (!((y)((com.tencent.luggage.sdk.b.a.c)El()).ar(y.class)).bup()) {
        break label96;
      }
    }
    label96:
    for (Object localObject = new b((byte)0);; localObject = new c((byte)0))
    {
      this.lYn = ((a)localObject);
      localObject = be.mew;
      this.lYo = be.a.d(this);
      ad.i("Luggage.AbstractMPPageViewRenderer", "getInjectionMode created mode name = %s, appId = %s, reason = %s", new Object[] { this.lYn.name(), getAppId(), paramString });
      return this.lYn;
    }
  }
  
  public void SX(String paramString)
  {
    ((com.tencent.luggage.sdk.b.a.c)El()).dl(paramString);
  }
  
  public final View a(LayoutInflater paramLayoutInflater)
  {
    return new FrameLayout(paramLayoutInflater.getContext());
  }
  
  public void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject) {}
  
  public final ay ay(Context paramContext)
  {
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = getContext();
    }
    this.lYc = dF((Context)localObject);
    if ((System.currentTimeMillis() % 1000L == 1L) || (bu.flY()) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED))
    {
      ad.i("Luggage.AbstractMPPageViewRenderer", "do observeLongTask");
      this.lYc.addJavascriptInterface(btI(), "PageLongTaskReporter");
      this.lYk = true;
    }
    paramContext = this.lYc;
    localObject = new d((Context)localObject);
    this.lYl = ((d)localObject);
    paramContext.addJavascriptInterface(localObject, "__deviceInfo");
    return this.lYc;
  }
  
  public final void b(com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb)
  {
    super.b(com.tencent.mm.plugin.appbrand.page.b.a.class, new bh((aa)El()));
    super.b(paramb);
  }
  
  public boolean b(String paramString1, String paramString2, int paramInt)
  {
    return false;
  }
  
  protected bb bsA()
  {
    return null;
  }
  
  protected boolean btG()
  {
    return (El() == null) || (!((com.tencent.luggage.sdk.b.a.c)El()).mcf);
  }
  
  protected final void btH()
  {
    Object localObject = new JSONObject();
    DisplayMetrics localDisplayMetrics = ((com.tencent.luggage.sdk.b.a.c)El()).jzX.getVDisplayMetrics();
    c((JSONObject)localObject, "width", Integer.valueOf((int)Math.ceil(localDisplayMetrics.widthPixels / localDisplayMetrics.density)));
    c((JSONObject)localObject, "pixelRatio", Float.valueOf(localDisplayMetrics.density));
    localObject = String.format(Locale.US, ";if(typeof __deviceInfo__ ==='undefined'){ var __deviceInfo__ = %s; } else {Object.assign(__deviceInfo__, %s)};", new Object[] { ((JSONObject)localObject).toString(), ((JSONObject)localObject).toString() });
    ((com.tencent.luggage.sdk.b.a.c)El()).aYh().evaluateJavascript((String)localObject, null);
  }
  
  protected com.tencent.mm.plugin.appbrand.performance.g btI()
  {
    new com.tencent.mm.plugin.appbrand.performance.g()
    {
      public final void notifyLongTask(long paramAnonymousLong)
      {
        AppMethodBeat.i(192260);
        ad.d("Luggage.AbstractMPPageViewRenderer", "notifyLongTask :%d", new Object[] { Long.valueOf(paramAnonymousLong) });
        AppMethodBeat.o(192260);
      }
    };
  }
  
  protected final bb btJ()
  {
    if (this.lYm == null)
    {
      this.lYm = bsA();
      if (this.lYm == null) {
        this.lYm = new bf(this);
      }
    }
    return this.lYm;
  }
  
  protected final void btK()
  {
    if (this.lYd) {
      return;
    }
    try
    {
      SW("injectAppSharedPageFrameScript").btK();
      this.lYd = true;
      return;
    }
    catch (ap localap) {}
  }
  
  protected void btL() {}
  
  public boolean cX(String paramString)
  {
    this.kuf = ((com.tencent.luggage.sdk.b.a.c)El()).kuf;
    this.lYf = ((com.tencent.luggage.sdk.b.a.c)El()).lYf;
    Object localObject1 = this.lYg;
    super.b(f.class, new bj((aa)El(), (ah)localObject1)
    {
      public final void a(f.a paramAnonymousa, final int paramAnonymousInt)
      {
        AppMethodBeat.i(192259);
        super.a(paramAnonymousa, paramAnonymousInt);
        if (a.this.El() == null)
        {
          AppMethodBeat.o(192259);
          return;
        }
        ((com.tencent.luggage.sdk.b.a.c)a.this.El()).M(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(192257);
            if ((a.this.El() != null) && (((com.tencent.luggage.sdk.b.a.c)a.this.El()).kca != null)) {
              ((com.tencent.luggage.sdk.b.a.c)a.this.El()).kca.setBackgroundColor(paramAnonymousInt);
            }
            if (a.a(a.this) != null) {
              a.a(a.this).setBackgroundColor(paramAnonymousInt);
            }
            AppMethodBeat.o(192257);
          }
        });
        AppMethodBeat.o(192259);
      }
      
      public final void ei(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(192258);
        boolean bool = a.this.En().getAppConfig().bdH();
        Resources localResources = a.this.En().mContext.getResources();
        if (bool) {}
        for (int i = 2131099650;; i = 2131099828)
        {
          i = com.tencent.mm.plugin.appbrand.z.g.cg(paramAnonymousString2, localResources.getColor(i));
          a(f.a.ay(paramAnonymousString1, bool), i);
          AppMethodBeat.o(192258);
          return;
        }
      }
    });
    this.lYi.a(new ba()
    {
      public final void a(AppBrandPageFullScreenView paramAnonymousAppBrandPageFullScreenView)
      {
        AppMethodBeat.i(147415);
        if (((com.tencent.luggage.sdk.b.a.c)a.this.El()).mcd == null)
        {
          ad.e("Luggage.AbstractMPPageViewRenderer", "FullScreenViewAttach getContainerPage is null, check time sequence, err, appId[%s], url[%s]", new Object[] { a.this.getAppId(), a.this.kuf });
          AppMethodBeat.o(147415);
          return;
        }
        ((com.tencent.luggage.sdk.b.a.c)a.this.El()).mcd.a((aa)a.this.El(), paramAnonymousAppBrandPageFullScreenView);
        AppMethodBeat.o(147415);
      }
    });
    if (En().jxe != null) {
      En().jxe.a(new ba()
      {
        public final void a(AppBrandPageFullScreenView paramAnonymousAppBrandPageFullScreenView)
        {
          AppMethodBeat.i(192256);
          if (((com.tencent.luggage.sdk.b.a.c)a.this.El()).mcd == null)
          {
            ad.e("Luggage.AbstractMPPageViewRenderer", "FullScreenViewAttach getContainerPage is null, check time sequence, err, appId[%s], url[%s]", new Object[] { a.this.getAppId(), a.this.kuf });
            AppMethodBeat.o(192256);
            return;
          }
          ((com.tencent.luggage.sdk.b.a.c)a.this.El()).mcd.a((aa)a.this.El(), paramAnonymousAppBrandPageFullScreenView);
          AppMethodBeat.o(192256);
        }
      });
    }
    Object localObject2 = ((com.tencent.luggage.sdk.b.a.c)El()).getPageConfig();
    ((com.tencent.luggage.sdk.b.a.c)El()).buB();
    localObject1 = (bi)Q(bi.class);
    localObject2 = ((com.tencent.mm.plugin.appbrand.config.a.d)localObject2).jWk;
    ((bi)localObject1).meI.cov = false;
    ((bi)localObject1).ckX = ((String)localObject2);
    if (!((com.tencent.luggage.sdk.b.a.c)El()).aVC().Lm(this.kuf))
    {
      ad.e("Luggage.AbstractMPPageViewRenderer", "Empty page content, appId[%s] url[%s], abort inject", new Object[] { getAppId(), paramString });
      SX(paramString);
      return false;
    }
    if (btG()) {
      this.lYj = new bm(getContext(), (aa)El());
    }
    btL();
    btK();
    paramString = this.kuf;
    try
    {
      SW(String.format(Locale.ENGLISH, "injectModuleSharedPageFrameScript(%s)", new Object[] { paramString })).SY(paramString);
      paramString = this.kuf;
    }
    catch (ap localap1)
    {
      try
      {
        SW(String.format(Locale.ENGLISH, "injectPageScript(%s)", new Object[] { paramString })).SZ(paramString);
        return true;
        localap1 = localap1;
        ad.e("Luggage.AbstractMPPageViewRenderer", "injectModuleSharedPageFrameScript appId[%s] path[%s] ScriptNotFoundException", new Object[] { getAppId(), paramString });
        En().finish();
      }
      catch (ap localap2)
      {
        for (;;)
        {
          ad.e("Luggage.AbstractMPPageViewRenderer", "injectPageScript appId[%s] url[%s] ScriptNotFoundException", new Object[] { getAppId(), paramString });
          En().finish();
        }
      }
    }
  }
  
  public void cm(View paramView)
  {
    this.lYb = ((FrameLayout)paramView);
    this.lYb.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView) {}
      
      public final void onViewDetachedFromWindow(View paramAnonymousView)
      {
        AppMethodBeat.i(147413);
        Object localObject = a.this.lYi;
        long l = SystemClock.uptimeMillis();
        paramAnonymousView = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        paramAnonymousView.setSource(4098);
        localObject = ((am)localObject).mdH.iterator();
        while (((Iterator)localObject).hasNext())
        {
          View localView = (View)((am.b)((Iterator)localObject).next()).med.get();
          if (localView != null) {
            localView.dispatchTouchEvent(paramAnonymousView);
          }
        }
        paramAnonymousView.recycle();
        AppMethodBeat.o(147413);
      }
    });
    this.lYh = new al((aa)El());
    if (this.lYc == null) {
      ((com.tencent.luggage.sdk.b.a.c)El()).bic();
    }
    this.lYc.aw(getContext());
    this.lYc.setFullscreenImpl(((com.tencent.luggage.sdk.b.a.c)El()).getFullscreenImpl());
    this.lYc.setOnScrollChangedListener(this.lYh);
    this.lYc.setWebViewLayoutListener(this.lYh);
    this.lYh.setupWebViewTouchInterceptor(this.lYc);
    paramView = this.lYc;
    this.lYg = new ah(getContext(), paramView);
    this.lYg.addView(this.lYh.getContainer());
    this.lYg.setOnPullDownOffsetListener(this.lYh);
    this.lYg.setOnPullDownListener(new ah.a()
    {
      public final void btN()
      {
        AppMethodBeat.i(147414);
        if (a.this.El() == null)
        {
          AppMethodBeat.o(147414);
          return;
        }
        ((com.tencent.luggage.sdk.b.a.c)a.this.El()).b("onPullDownRefresh", null, new int[] { ((com.tencent.luggage.sdk.b.a.c)a.this.El()).aXC() });
        AppMethodBeat.o(147414);
      }
    });
    this.lYb.addView(this.lYg);
    this.lYi = new am(this.lYh.getContainer());
    this.lYi.setFullscreenImpl(((com.tencent.luggage.sdk.b.a.c)El()).getFullscreenImpl());
    if (En().jxe != null) {
      En().jxe.setFullscreenImpl(((com.tencent.luggage.sdk.b.a.c)El()).getFullscreenImpl());
    }
  }
  
  public final RelativeLayout.LayoutParams cn(View paramView)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    if (paramView != null)
    {
      if (paramView.getId() == -1) {
        paramView.setId(2131296780);
      }
      localLayoutParams.addRule(2, paramView.getId());
    }
    return localLayoutParams;
  }
  
  protected abstract ay dF(Context paramContext);
  
  public final void dispatchDestroy()
  {
    super.dispatchDestroy();
    this.lYh.a(this.lYc);
    this.lYc.destroy();
    this.lYc = null;
    this.lYb.removeAllViewsInLayout();
    this.lYg.removeAllViewsInLayout();
    this.lYg = null;
    this.lYh = null;
  }
  
  public void dispatchStart()
  {
    super.dispatchStart();
    super.b(com.tencent.mm.plugin.appbrand.page.b.d.class, new bi((aa)El()));
    super.b(h.class, new bl((aa)El()));
    a.8 local8 = new a.8();
    super.b(f.class, (f)Proxy.newProxyInstance(f.class.getClassLoader(), new Class[] { f.class }, local8));
    com.tencent.luggage.sdk.b.a.b.b.a((aa)El());
    if (((com.tencent.luggage.sdk.b.a.c)El()).En().getAppConfig().bdH())
    {
      this.lYc.setBackgroundColor(android.support.v4.content.b.n(getContext(), 2131099726));
      return;
    }
    this.lYc.setBackgroundColor(-1);
  }
  
  protected final void eh(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      ad.e("Luggage.AbstractMPPageViewRenderer", "[!]injectScript appId[%s] name[%s] url[%s] hash[%d] source EMPTY", new Object[] { getAppId(), paramString1, this.kuf, Integer.valueOf(hashCode()) });
      return;
    }
    final d.a locala = new d.a();
    locala.scriptName = paramString1;
    locala.cnv = paramString2;
    locala.cnw = paramString2.length();
    final long l = System.currentTimeMillis();
    ad.i("Luggage.AbstractMPPageViewRenderer", "injectScript start, appId[%s] name[%s] url[%s] hash[%d]", new Object[] { getAppId(), paramString1, this.kuf, Integer.valueOf(hashCode()) });
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString1)) {
          continue;
        }
        ad.w("Luggage.AbstractMPPageViewRenderer", "[!] injectScript, valid name is required, appId:%s, url:%s", new Object[] { getAppId(), this.kuf });
        paramString1 = null;
      }
      catch (Exception paramString1)
      {
        paramString1 = null;
        continue;
      }
      com.tencent.mm.plugin.appbrand.utils.q.a(((com.tencent.luggage.sdk.b.a.c)El()).aYh(), paramString1, paramString2, new q.a()
      {
        private void df(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(192263);
          a.this.a(locala, paramAnonymousBoolean, l, System.currentTimeMillis(), null);
          AppMethodBeat.o(192263);
        }
        
        public final void cT(String paramAnonymousString)
        {
          AppMethodBeat.i(192262);
          df(false);
          AppMethodBeat.o(192262);
        }
        
        public final void onSuccess(String paramAnonymousString)
        {
          AppMethodBeat.i(192261);
          df(true);
          AppMethodBeat.o(192261);
        }
      });
      return;
      paramString1 = new URL("https", "servicewechat.com", paramString1);
    }
  }
  
  public final String getAppId()
  {
    com.tencent.mm.plugin.appbrand.jsapi.c localc = El();
    if (localc == null)
    {
      ad.printErrStackTrace("Luggage.AbstractMPPageViewRenderer", new Throwable(), "getAppId", new Object[0]);
      return null;
    }
    return localc.getAppId();
  }
  
  protected final String getURL()
  {
    return this.kuf;
  }
  
  public final boolean isRunning()
  {
    com.tencent.luggage.sdk.b.a.c localc = (com.tencent.luggage.sdk.b.a.c)El();
    return (localc != null) && (localc.isRunning());
  }
  
  public boolean y(String paramString1, String paramString2)
  {
    return false;
  }
  
  static abstract interface a
  {
    public abstract void SY(String paramString);
    
    public abstract void SZ(String paramString);
    
    public abstract boolean Ta(String paramString);
    
    public abstract void btK();
    
    public abstract String name();
  }
  
  final class b
    implements a.a
  {
    private b() {}
    
    private void Tb(String paramString)
    {
      AppMethodBeat.i(147423);
      String str = a.this.btJ().Si(paramString);
      if (TextUtils.isEmpty(str))
      {
        paramString = new ap(paramString);
        AppMethodBeat.o(147423);
        throw paramString;
      }
      a.this.eh(paramString, str);
      AppMethodBeat.o(147423);
    }
    
    public final void SY(String paramString)
    {
      AppMethodBeat.i(147425);
      if (!a.this.En().jwT.btb())
      {
        AppMethodBeat.o(147425);
        return;
      }
      paramString = a.this.En().jwT.SB(paramString);
      if ("__APP__".equals(paramString))
      {
        AppMethodBeat.o(147425);
        return;
      }
      a.c(a.this).ax(paramString, true);
      StringBuilder localStringBuilder = new StringBuilder().append(paramString);
      if (paramString.endsWith("/")) {}
      for (paramString = "";; paramString = "/")
      {
        paramString = paramString;
        Tb(paramString + "common.app.js");
        Tb(paramString + "webview.app.js");
        AppMethodBeat.o(147425);
        return;
      }
    }
    
    public final void SZ(String paramString) {}
    
    public final boolean Ta(String paramString)
    {
      AppMethodBeat.i(192265);
      boolean bool = "webview.app.js".equals(paramString);
      AppMethodBeat.o(192265);
      return bool;
    }
    
    public final void btK()
    {
      AppMethodBeat.i(147424);
      a.c(a.this).ax("__APP__", true);
      Tb("common.app.js");
      Tb("webview.app.js");
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
    
    public final void SY(String paramString)
    {
      AppMethodBeat.i(147427);
      if (!a.this.En().jwT.btb())
      {
        AppMethodBeat.o(147427);
        return;
      }
      String str = a.this.En().jwT.SB(paramString);
      Object localObject = new StringBuilder().append(str);
      if (str.endsWith("/")) {}
      for (paramString = "";; paramString = "/")
      {
        paramString = paramString + "page-frame.js";
        localObject = a.this.btJ().Si(paramString);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        paramString = new ap(paramString);
        AppMethodBeat.o(147427);
        throw paramString;
      }
      a.c(a.this).ax(str, false);
      a.this.eh(paramString, (String)localObject);
      AppMethodBeat.o(147427);
    }
    
    public final void SZ(String paramString)
    {
      AppMethodBeat.i(147428);
      String str = a.this.btJ().Si(paramString);
      a.this.eh(paramString, str);
      AppMethodBeat.o(147428);
    }
    
    public final boolean Ta(String paramString)
    {
      AppMethodBeat.i(192266);
      if (("app-wxss.js".equals(paramString)) || ("page-frame.html".equals(paramString)))
      {
        AppMethodBeat.o(192266);
        return true;
      }
      AppMethodBeat.o(192266);
      return false;
    }
    
    public final void btK()
    {
      AppMethodBeat.i(147426);
      a.c(a.this).ax("__APP__", false);
      if (a.this.En().jwT.btb())
      {
        localObject = a.this.btJ().Si("app-wxss.js");
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = new ap("app-wxss.js");
          AppMethodBeat.o(147426);
          throw ((Throwable)localObject);
        }
        a.this.eh("app-wxss.js", (String)localObject);
        AppMethodBeat.o(147426);
        return;
      }
      Object localObject = a.this.btJ().Si("page-frame.html");
      a.this.eh("page-frame.html", (String)localObject);
      AppMethodBeat.o(147426);
    }
    
    public final String name()
    {
      return "Legacy";
    }
  }
  
  final class d
    extends av
  {
    public d(Context paramContext)
    {
      super();
    }
    
    @JavascriptInterface
    public final float getWidth()
    {
      AppMethodBeat.i(147429);
      float f1 = (float)Math.ceil(a.this.En().getWindowAndroid().getVDisplayMetrics().widthPixels / getPixelRatio());
      float f2 = (float)Math.ceil(a.b(a.this).getWidth() / super.getPixelRatio());
      if ((f2 > 0.0F) && (f2 != f1)) {
        ad.w("Luggage.AbstractMPPageViewRenderer", "__deviceInfo.getWidth(), resources[%f] != view[%f], may in pad env", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
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