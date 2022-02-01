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
import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.page.b.f;
import com.tencent.mm.plugin.appbrand.page.b.f.a;
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
  public String jzm;
  public ViewGroup kWT;
  protected bd kWU;
  boolean kWV = false;
  private boolean kWW = false;
  String kWX;
  private am kWY;
  private bh kWZ;
  ar kXa;
  private br kXb;
  boolean kXc;
  a<PAGE>.d kXd;
  private bg kXe;
  private a kXf;
  bj kXg;
  
  public a(PAGE paramPAGE)
  {
    super(paramPAGE);
  }
  
  private a Lm(String paramString)
  {
    if (this.kXf == null) {
      if (!((y)((com.tencent.luggage.sdk.b.a.c)Dj()).ar(y.class)).bjy()) {
        break label94;
      }
    }
    label94:
    for (Object localObject = new a.b(this, (byte)0);; localObject = new a.c(this, (byte)0))
    {
      this.kXf = ((a)localObject);
      localObject = bj.lfc;
      this.kXg = bj.a.d(this);
      ad.i("Luggage.AbstractMPPageViewRenderer", "getInjectionMode created mode name = %s, appId = %s, reason = %s", new Object[] { this.kXf.name(), getAppId(), paramString });
      return this.kXf;
    }
  }
  
  private void biT()
  {
    if (this.kXb != null)
    {
      this.kXb.setVisibility(8);
      if (t.aC(this.kXb))
      {
        ((com.tencent.luggage.sdk.b.a.c)Dj()).bjH().setNavLoadingIconVisibilityResetListener(null);
        ((com.tencent.luggage.sdk.b.a.c)Dj()).bjH().setLoadingIconVisibility(this.kXb.lga);
        ((ViewGroup)this.kXb.getParent()).removeView(this.kXb);
        ad.i("Luggage.AbstractMPPageViewRenderer", "dismissWaitingReadyCover appId:%s, url:%s", new Object[] { getAppId(), this.jzm });
      }
    }
  }
  
  private void c(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    ((com.tencent.luggage.sdk.b.a.c)Dj()).c(paramJSONObject, paramString, paramObject);
  }
  
  public final ar CA()
  {
    return this.kXa;
  }
  
  public void CB()
  {
    ad.i("Luggage.AbstractMPPageViewRenderer", "dispatchForeground appId:%s, url:%s, mIsPageReady:%b", new Object[] { getAppId(), this.jzm, Boolean.valueOf(this.kWW) });
    super.CB();
    this.kWU.onForeground();
    ((com.tencent.luggage.sdk.b.a.c)Dj()).Dt();
    if (!this.kWW)
    {
      if (biN()) {
        break label77;
      }
      biT();
    }
    label77:
    while (this.kXb == null) {
      return;
    }
    Object localObject = (FrameLayout)this.kWT;
    if (this.kXb.getParent() != localObject)
    {
      boolean bool = ((com.tencent.luggage.sdk.b.a.c)Dj()).bjH().bri();
      ((com.tencent.luggage.sdk.b.a.c)Dj()).bjH().setLoadingIconVisibility(true);
      ((com.tencent.luggage.sdk.b.a.c)Dj()).bjH().setNavLoadingIconVisibilityResetListener(this.kXb);
      this.kXb.lga = bool;
      if ((this.kXb.getParent() instanceof ViewGroup)) {
        ((ViewGroup)this.kXb.getParent()).removeView(this.kXb);
      }
      ((FrameLayout)localObject).addView(this.kXb, new FrameLayout.LayoutParams(-1, -1));
    }
    localObject = this.kXb;
    Context localContext = getContext();
    if (((br)localObject).laU != null) {
      ((br)localObject).laU.av(localContext);
    }
    this.kXb.bkH();
    this.kXb.bringToFront();
    ad.i("Luggage.AbstractMPPageViewRenderer", "revealWaitingReadyCover appId:%s, url:%s", new Object[] { getAppId(), this.jzm });
  }
  
  public void CC()
  {
    super.CC();
    this.kWU.onBackground();
  }
  
  public Map<String, m> CD()
  {
    return new com.tencent.luggage.sdk.a().CS();
  }
  
  public void CE()
  {
    ad.i("Luggage.AbstractMPPageViewRenderer", "dispatchPageReady appId:%s, url:%s", new Object[] { getAppId(), this.jzm });
    this.kWW = true;
    biT();
  }
  
  public final bh Cz()
  {
    return this.kWZ;
  }
  
  public final JSONObject DL()
  {
    JSONObject localJSONObject = Dl().Du().DL();
    try
    {
      localJSONObject.put("isFirstPage", ((com.tencent.luggage.sdk.b.a.c)Dj()).lbf);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      ad.e("Luggage.AbstractMPPageViewRenderer", "generateWxConfig appId[%s] put isFirstPage e=%s", new Object[] { getAppId(), localJSONException });
    }
    return localJSONObject;
  }
  
  public void Ln(String paramString)
  {
    ((com.tencent.luggage.sdk.b.a.c)Dj()).cu(paramString);
  }
  
  public <T> T Q(Class<T> paramClass)
  {
    if (ICommLibReader.class.equals(paramClass)) {
      return paramClass.cast(((com.tencent.luggage.sdk.b.a.c)Dj()).aLC());
    }
    if (paramClass.isInstance(this)) {
      return paramClass.cast(this);
    }
    return super.Q(paramClass);
  }
  
  public final View a(LayoutInflater paramLayoutInflater)
  {
    return new FrameLayout(paramLayoutInflater.getContext());
  }
  
  public void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject) {}
  
  public final bd ax(Context paramContext)
  {
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = getContext();
    }
    this.kWU = dy((Context)localObject);
    if ((System.currentTimeMillis() % 1000L == 1L) || (bu.eGT()) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED))
    {
      ad.i("Luggage.AbstractMPPageViewRenderer", "do observeLongTask");
      this.kWU.addJavascriptInterface(biP(), "PageLongTaskReporter");
      this.kXc = true;
    }
    paramContext = this.kWU;
    localObject = new d((Context)localObject);
    this.kXd = ((d)localObject);
    paramContext.addJavascriptInterface(localObject, "__deviceInfo");
    return this.kWU;
  }
  
  public final void b(com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb)
  {
    super.b(com.tencent.mm.plugin.appbrand.page.b.a.class, new bm((aa)Dj()));
    super.b(paramb);
  }
  
  public boolean b(String paramString1, String paramString2, int paramInt)
  {
    return false;
  }
  
  protected bg bhH()
  {
    return null;
  }
  
  protected boolean biN()
  {
    return (Dj() == null) || (!((com.tencent.luggage.sdk.b.a.c)Dj()).lbf);
  }
  
  protected final void biO()
  {
    Object localObject = new JSONObject();
    DisplayMetrics localDisplayMetrics = ((com.tencent.luggage.sdk.b.a.c)Dj()).iGU.getVDisplayMetrics();
    c((JSONObject)localObject, "width", Integer.valueOf((int)Math.ceil(localDisplayMetrics.widthPixels / localDisplayMetrics.density)));
    c((JSONObject)localObject, "pixelRatio", Float.valueOf(localDisplayMetrics.density));
    localObject = String.format(Locale.US, ";if(typeof __deviceInfo__ ==='undefined'){ var __deviceInfo__ = %s; };", new Object[] { ((JSONObject)localObject).toString() });
    ((com.tencent.luggage.sdk.b.a.c)Dj()).aOf().evaluateJavascript((String)localObject, null);
  }
  
  protected com.tencent.mm.plugin.appbrand.performance.g biP()
  {
    new com.tencent.mm.plugin.appbrand.performance.g()
    {
      public final void notifyLongTask(long paramAnonymousLong)
      {
        AppMethodBeat.i(169500);
        ad.d("Luggage.AbstractMPPageViewRenderer", "notifyLongTask :%d", new Object[] { Long.valueOf(paramAnonymousLong) });
        AppMethodBeat.o(169500);
      }
    };
  }
  
  protected final bg biQ()
  {
    if (this.kXe == null)
    {
      this.kXe = bhH();
      if (this.kXe == null) {
        this.kXe = new bk(this);
      }
    }
    return this.kXe;
  }
  
  protected final void biR()
  {
    if (this.kWV) {
      return;
    }
    try
    {
      Lm("injectAppSharedPageFrameScript").biR();
      this.kWV = true;
      return;
    }
    catch (ao localao) {}
  }
  
  protected void biS() {}
  
  public void cm(View paramView)
  {
    this.kWT = ((FrameLayout)paramView);
    this.kWT.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView) {}
      
      public final void onViewDetachedFromWindow(View paramAnonymousView)
      {
        AppMethodBeat.i(147413);
        Object localObject = a.this.kXa;
        long l = SystemClock.uptimeMillis();
        paramAnonymousView = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        paramAnonymousView.setSource(4098);
        localObject = ((ar)localObject).lem.iterator();
        while (((Iterator)localObject).hasNext())
        {
          View localView = (View)((ar.b)((Iterator)localObject).next()).leJ.get();
          if (localView != null) {
            localView.dispatchTouchEvent(paramAnonymousView);
          }
        }
        paramAnonymousView.recycle();
        AppMethodBeat.o(147413);
      }
    });
    this.kWZ = new al((aa)Dj());
    if (this.kWU == null) {
      ((com.tencent.luggage.sdk.b.a.c)Dj()).aXB();
    }
    this.kWU.av(getContext());
    this.kWU.setFullscreenImpl(((com.tencent.luggage.sdk.b.a.c)Dj()).getFullscreenImpl());
    this.kWU.setOnScrollChangedListener(this.kWZ);
    this.kWU.setWebViewLayoutListener(this.kWZ);
    this.kWZ.setupWebViewTouchInterceptor(this.kWU);
    paramView = this.kWU;
    this.kWY = new am(getContext(), paramView);
    this.kWY.addView(this.kWZ.getContainer());
    this.kWY.setOnPullDownOffsetListener(this.kWZ);
    this.kWY.setOnPullDownListener(new am.a()
    {
      public final void biU()
      {
        AppMethodBeat.i(147414);
        if (a.this.Dj() == null)
        {
          AppMethodBeat.o(147414);
          return;
        }
        ((com.tencent.luggage.sdk.b.a.c)a.this.Dj()).b("onPullDownRefresh", null, new int[] { ((com.tencent.luggage.sdk.b.a.c)a.this.Dj()).aOd() });
        AppMethodBeat.o(147414);
      }
    });
    this.kWT.addView(this.kWY);
    this.kXa = new ar(this.kWZ.getContainer());
    this.kXa.setFullscreenImpl(((com.tencent.luggage.sdk.b.a.c)Dj()).getFullscreenImpl());
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
  
  public boolean cn(String paramString)
  {
    this.jzm = ((com.tencent.luggage.sdk.b.a.c)Dj()).jzm;
    this.kWX = ((com.tencent.luggage.sdk.b.a.c)Dj()).kWX;
    Object localObject1 = this.kWY;
    super.b(f.class, new bo((aa)Dj(), (am)localObject1)
    {
      public final void a(f.a paramAnonymousa, final int paramAnonymousInt)
      {
        AppMethodBeat.i(147418);
        super.a(paramAnonymousa, paramAnonymousInt);
        if (a.this.Dj() == null)
        {
          AppMethodBeat.o(147418);
          return;
        }
        ((com.tencent.luggage.sdk.b.a.c)a.this.Dj()).L(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(147416);
            if ((a.this.Dj() != null) && (((com.tencent.luggage.sdk.b.a.c)a.this.Dj()).jhz != null)) {
              ((com.tencent.luggage.sdk.b.a.c)a.this.Dj()).jhz.setBackgroundColor(paramAnonymousInt);
            }
            if (a.a(a.this) != null) {
              a.a(a.this).setBackgroundColor(paramAnonymousInt);
            }
            AppMethodBeat.o(147416);
          }
        });
        AppMethodBeat.o(147418);
      }
      
      public final void dM(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(147417);
        boolean bool = a.this.Dl().getAppConfig().aTk();
        Resources localResources = a.this.Dl().mContext.getResources();
        if (bool) {}
        for (int i = 2131099650;; i = 2131099828)
        {
          i = com.tencent.mm.plugin.appbrand.aa.g.bY(paramAnonymousString2, localResources.getColor(i));
          a(f.a.av(paramAnonymousString1, bool), i);
          AppMethodBeat.o(147417);
          return;
        }
      }
    });
    this.kXa.a(new bf()
    {
      public final void a(AppBrandPageFullScreenView paramAnonymousAppBrandPageFullScreenView)
      {
        AppMethodBeat.i(147415);
        if (((com.tencent.luggage.sdk.b.a.c)a.this.Dj()).lbd == null)
        {
          ad.e("Luggage.AbstractMPPageViewRenderer", "FullScreenViewAttach getContainerPage is null, check time sequence, err, appId[%s], url[%s]", new Object[] { a.this.getAppId(), a.this.jzm });
          AppMethodBeat.o(147415);
          return;
        }
        ((com.tencent.luggage.sdk.b.a.c)a.this.Dj()).lbd.a((aa)a.this.Dj(), paramAnonymousAppBrandPageFullScreenView);
        AppMethodBeat.o(147415);
      }
    });
    Object localObject2 = ((com.tencent.luggage.sdk.b.a.c)Dj()).getPageConfig();
    ((com.tencent.luggage.sdk.b.a.c)Dj()).bjK();
    localObject1 = (bn)Q(bn.class);
    localObject2 = ((com.tencent.mm.plugin.appbrand.config.a.d)localObject2).jcb;
    ((bn)localObject1).lfo.chk = false;
    ((bn)localObject1).cdJ = ((String)localObject2);
    if (!((com.tencent.luggage.sdk.b.a.c)Dj()).aLz().DR(this.jzm))
    {
      ad.e("Luggage.AbstractMPPageViewRenderer", "Empty page content, appId[%s] url[%s], abort inject", new Object[] { getAppId(), paramString });
      Ln(paramString);
      return false;
    }
    if (biN()) {
      this.kXb = new br(getContext(), (aa)Dj());
    }
    biS();
    biR();
    paramString = this.jzm;
    try
    {
      Lm(String.format(Locale.ENGLISH, "injectModuleSharedPageFrameScript(%s)", new Object[] { paramString })).Lo(paramString);
      paramString = this.jzm;
    }
    catch (ao localao1)
    {
      try
      {
        Lm(String.format(Locale.ENGLISH, "injectPageScript(%s)", new Object[] { paramString })).Lp(paramString);
        return true;
        localao1 = localao1;
        ad.e("Luggage.AbstractMPPageViewRenderer", "injectModuleSharedPageFrameScript appId[%s] path[%s] ScriptNotFoundException", new Object[] { getAppId(), paramString });
        Dl().finish();
      }
      catch (ao localao2)
      {
        for (;;)
        {
          ad.e("Luggage.AbstractMPPageViewRenderer", "injectPageScript appId[%s] url[%s] ScriptNotFoundException", new Object[] { getAppId(), paramString });
          Dl().finish();
        }
      }
    }
  }
  
  protected final void dL(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      ad.e("Luggage.AbstractMPPageViewRenderer", "[!]injectScript appId[%s] name[%s] url[%s] hash[%d] source EMPTY", new Object[] { getAppId(), paramString1, this.jzm, Integer.valueOf(hashCode()) });
      return;
    }
    final d.a locala = new d.a();
    locala.scriptName = paramString1;
    locala.cgh = paramString2;
    locala.cgj = paramString2.length();
    final long l = System.currentTimeMillis();
    ad.i("Luggage.AbstractMPPageViewRenderer", "injectScript start, appId[%s] name[%s] url[%s] hash[%d]", new Object[] { getAppId(), paramString1, this.jzm, Integer.valueOf(hashCode()) });
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString1)) {
          continue;
        }
        ad.w("Luggage.AbstractMPPageViewRenderer", "[!] injectScript, valid name is required, appId:%s, url:%s", new Object[] { getAppId(), this.jzm });
        paramString1 = null;
      }
      catch (Exception paramString1)
      {
        paramString1 = null;
        continue;
      }
      com.tencent.mm.plugin.appbrand.utils.q.a(((com.tencent.luggage.sdk.b.a.c)Dj()).aOf(), paramString1, paramString2, new q.a()
      {
        private void de(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(169503);
          a.this.a(locala, paramAnonymousBoolean, l, System.currentTimeMillis(), null);
          AppMethodBeat.o(169503);
        }
        
        public final void cj(String paramAnonymousString)
        {
          AppMethodBeat.i(169502);
          de(false);
          AppMethodBeat.o(169502);
        }
        
        public final void onSuccess(String paramAnonymousString)
        {
          AppMethodBeat.i(169501);
          de(true);
          AppMethodBeat.o(169501);
        }
      });
      return;
      paramString1 = new URL("https", "servicewechat.com", paramString1);
    }
  }
  
  public final void dispatchDestroy()
  {
    super.dispatchDestroy();
    this.kWZ.a(this.kWU);
    this.kWU.destroy();
    this.kWU = null;
    this.kWT.removeAllViewsInLayout();
    this.kWY.removeAllViewsInLayout();
    this.kWY = null;
    this.kWZ = null;
  }
  
  public void dispatchStart()
  {
    super.dispatchStart();
    super.b(com.tencent.mm.plugin.appbrand.page.b.d.class, new bn((aa)Dj()));
    super.b(com.tencent.mm.plugin.appbrand.page.b.h.class, new bq((aa)Dj()));
    a.7 local7 = new a.7();
    super.b(f.class, (f)Proxy.newProxyInstance(f.class.getClassLoader(), new Class[] { f.class }, local7));
    com.tencent.luggage.sdk.b.a.b.b.a((aa)Dj());
    if (((com.tencent.luggage.sdk.b.a.c)Dj()).Dl().getAppConfig().aTk())
    {
      this.kWU.setBackgroundColor(android.support.v4.content.b.n(getContext(), 2131099726));
      return;
    }
    this.kWU.setBackgroundColor(-1);
  }
  
  protected abstract bd dy(Context paramContext);
  
  public final String getAppId()
  {
    com.tencent.mm.plugin.appbrand.jsapi.c localc = Dj();
    if (localc == null)
    {
      ad.printErrStackTrace("Luggage.AbstractMPPageViewRenderer", new Throwable(), "getAppId", new Object[0]);
      return null;
    }
    return localc.getAppId();
  }
  
  protected final String getURL()
  {
    return this.jzm;
  }
  
  public final boolean isRunning()
  {
    com.tencent.luggage.sdk.b.a.c localc = (com.tencent.luggage.sdk.b.a.c)Dj();
    return (localc != null) && (localc.isRunning());
  }
  
  public boolean x(String paramString1, String paramString2)
  {
    return false;
  }
  
  static abstract interface a
  {
    public abstract void Lo(String paramString);
    
    public abstract void Lp(String paramString);
    
    public abstract void biR();
    
    public abstract String name();
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
      float f1 = (float)Math.ceil(a.this.Dl().getWindowAndroid().getVDisplayMetrics().widthPixels / getPixelRatio());
      float f2 = (float)Math.ceil(a.b(a.this).getWidth() / super.getPixelRatio());
      if ((f2 > 0.0F) && (f2 != f1)) {
        ad.w("Luggage.AbstractMPPageViewRenderer", "__deviceInfo.getWidth(), resources[%f] != view[%f], may in pad env", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
      }
      AppMethodBeat.o(147429);
      return f1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.a
 * JD-Core Version:    0.7.0.1
 */