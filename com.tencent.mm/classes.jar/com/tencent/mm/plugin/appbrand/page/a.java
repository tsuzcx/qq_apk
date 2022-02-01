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
import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.page.a.f;
import com.tencent.mm.plugin.appbrand.page.a.f.a;
import com.tencent.mm.plugin.appbrand.page.a.h;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.utils.s;
import com.tencent.mm.plugin.appbrand.utils.s.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.j;
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
  public String kxv;
  ViewGroup mcI;
  protected ax mcJ;
  boolean mcK = false;
  private boolean mcL = false;
  String mcM;
  private ag mcN;
  private bb mcO;
  al mcP;
  private bl mcQ;
  boolean mcR;
  a<PAGE>.d mcS;
  private ba mcT;
  private a mcU;
  bd mcV;
  
  public a(PAGE paramPAGE)
  {
    super(paramPAGE);
  }
  
  private void bux()
  {
    if (this.mcQ != null)
    {
      this.mcQ.setVisibility(8);
      if (t.aC(this.mcQ))
      {
        ((com.tencent.luggage.sdk.b.a.c)Eo()).bvi().setNavLoadingIconVisibilityResetListener(null);
        ((com.tencent.luggage.sdk.b.a.c)Eo()).bvi().setLoadingIconVisibility(this.mcQ.mjT);
        ((ViewGroup)this.mcQ.getParent()).removeView(this.mcQ);
        ae.i("Luggage.AbstractMPPageViewRenderer", "dismissWaitingReadyCover appId:%s, url:%s", new Object[] { getAppId(), this.kxv });
      }
    }
  }
  
  private void c(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    ((com.tencent.luggage.sdk.b.a.c)Eo()).c(paramJSONObject, paramString, paramObject);
  }
  
  public final bb DF()
  {
    return this.mcO;
  }
  
  public final al DG()
  {
    return this.mcP;
  }
  
  public void DH()
  {
    ae.i("Luggage.AbstractMPPageViewRenderer", "dispatchForeground appId:%s, url:%s, mIsPageReady:%b", new Object[] { getAppId(), this.kxv, Boolean.valueOf(this.mcL) });
    super.DH();
    this.mcJ.onForeground();
    ((com.tencent.luggage.sdk.b.a.c)Eo()).Ex();
    if (!this.mcL)
    {
      if (bur()) {
        break label77;
      }
      bux();
    }
    label77:
    while (this.mcQ == null) {
      return;
    }
    Object localObject = (FrameLayout)this.mcI;
    if (this.mcQ.getParent() != localObject)
    {
      boolean bool = ((com.tencent.luggage.sdk.b.a.c)Eo()).bvi().bDg();
      ((com.tencent.luggage.sdk.b.a.c)Eo()).bvi().setLoadingIconVisibility(true);
      ((com.tencent.luggage.sdk.b.a.c)Eo()).bvi().setNavLoadingIconVisibilityResetListener(this.mcQ);
      this.mcQ.mjT = bool;
      if ((this.mcQ.getParent() instanceof ViewGroup)) {
        ((ViewGroup)this.mcQ.getParent()).removeView(this.mcQ);
      }
      ((FrameLayout)localObject).addView(this.mcQ, new FrameLayout.LayoutParams(-1, -1));
    }
    localObject = this.mcQ;
    Context localContext = getContext();
    if (((bl)localObject).mgn != null) {
      ((bl)localObject).mgn.ax(localContext);
    }
    this.mcQ.bwi();
    this.mcQ.bringToFront();
    ae.i("Luggage.AbstractMPPageViewRenderer", "revealWaitingReadyCover appId:%s, url:%s", new Object[] { getAppId(), this.kxv });
  }
  
  public void DI()
  {
    super.DI();
    this.mcJ.onBackground();
  }
  
  public Map<String, com.tencent.mm.plugin.appbrand.jsapi.m> DJ()
  {
    return new com.tencent.luggage.sdk.a().DX();
  }
  
  public void DK()
  {
    ae.i("Luggage.AbstractMPPageViewRenderer", "dispatchPageReady appId:%s, url:%s", new Object[] { getAppId(), this.kxv });
    this.mcL = true;
    bux();
  }
  
  public final JSONObject EP()
  {
    JSONObject localJSONObject = Eq().Ey().EP();
    try
    {
      localJSONObject.put("isFirstPage", ((com.tencent.luggage.sdk.b.a.c)Eo()).mgx);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      ae.e("Luggage.AbstractMPPageViewRenderer", "generateWxConfig appId[%s] put isFirstPage e=%s", new Object[] { getAppId(), localJSONException });
    }
    return localJSONObject;
  }
  
  public <T> T Q(Class<T> paramClass)
  {
    if (ICommLibReader.class.equals(paramClass)) {
      return paramClass.cast(((com.tencent.luggage.sdk.b.a.c)Eo()).aWe());
    }
    if (paramClass.isInstance(this)) {
      return paramClass.cast(this);
    }
    return super.Q(paramClass);
  }
  
  protected final a TF(String paramString)
  {
    if (this.mcU == null) {
      if (!((x)((com.tencent.luggage.sdk.b.a.c)Eo()).ar(x.class)).bva()) {
        break label96;
      }
    }
    label96:
    for (Object localObject = new b((byte)0);; localObject = new c((byte)0))
    {
      this.mcU = ((a)localObject);
      localObject = bd.miQ;
      this.mcV = bd.a.d(this);
      ae.i("Luggage.AbstractMPPageViewRenderer", "getInjectionMode created mode name = %s, appId = %s, reason = %s", new Object[] { this.mcU.name(), getAppId(), paramString });
      return this.mcU;
    }
  }
  
  public void TG(String paramString)
  {
    ((com.tencent.luggage.sdk.b.a.c)Eo()).dn(paramString);
  }
  
  public final View a(LayoutInflater paramLayoutInflater)
  {
    return new FrameLayout(paramLayoutInflater.getContext());
  }
  
  public void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject) {}
  
  public final ax az(Context paramContext)
  {
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = getContext();
    }
    this.mcJ = dJ((Context)localObject);
    if ((System.currentTimeMillis() % 1000L == 1L) || (bv.fpT()) || (j.IS_FLAVOR_RED))
    {
      ae.i("Luggage.AbstractMPPageViewRenderer", "do observeLongTask");
      this.mcJ.addJavascriptInterface(but(), "PageLongTaskReporter");
      this.mcR = true;
    }
    paramContext = this.mcJ;
    localObject = new d((Context)localObject);
    this.mcS = ((d)localObject);
    paramContext.addJavascriptInterface(localObject, "__deviceInfo");
    return this.mcJ;
  }
  
  public final void b(com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb)
  {
    super.b(com.tencent.mm.plugin.appbrand.page.a.a.class, new bg((z)Eo()));
    super.b(paramb);
  }
  
  public boolean b(String paramString1, String paramString2, int paramInt)
  {
    return false;
  }
  
  protected ba btl()
  {
    return null;
  }
  
  protected boolean bur()
  {
    return (Eo() == null) || (!((com.tencent.luggage.sdk.b.a.c)Eo()).mgx);
  }
  
  protected final void bus()
  {
    Object localObject = new JSONObject();
    DisplayMetrics localDisplayMetrics = ((com.tencent.luggage.sdk.b.a.c)Eo()).jDa.getVDisplayMetrics();
    c((JSONObject)localObject, "width", Integer.valueOf((int)Math.ceil(localDisplayMetrics.widthPixels / localDisplayMetrics.density)));
    c((JSONObject)localObject, "pixelRatio", Float.valueOf(localDisplayMetrics.density));
    localObject = String.format(Locale.US, ";if(typeof __deviceInfo__ ==='undefined'){ var __deviceInfo__ = %s; } else {Object.assign(__deviceInfo__, %s)};", new Object[] { ((JSONObject)localObject).toString(), ((JSONObject)localObject).toString() });
    ((com.tencent.luggage.sdk.b.a.c)Eo()).aYB().evaluateJavascript((String)localObject, null);
  }
  
  protected com.tencent.mm.plugin.appbrand.performance.g but()
  {
    new com.tencent.mm.plugin.appbrand.performance.g()
    {
      public final void notifyLongTask(long paramAnonymousLong)
      {
        AppMethodBeat.i(220833);
        ae.d("Luggage.AbstractMPPageViewRenderer", "notifyLongTask :%d", new Object[] { Long.valueOf(paramAnonymousLong) });
        AppMethodBeat.o(220833);
      }
    };
  }
  
  protected final ba buu()
  {
    if (this.mcT == null)
    {
      this.mcT = btl();
      if (this.mcT == null) {
        this.mcT = new be(this);
      }
    }
    return this.mcT;
  }
  
  protected final void buv()
  {
    if (this.mcK) {
      return;
    }
    try
    {
      TF("injectAppSharedPageFrameScript").buv();
      this.mcK = true;
      return;
    }
    catch (aq localaq) {}
  }
  
  protected void buw() {}
  
  public boolean cZ(String paramString)
  {
    this.kxv = ((com.tencent.luggage.sdk.b.a.c)Eo()).kxv;
    this.mcM = ((com.tencent.luggage.sdk.b.a.c)Eo()).mcM;
    Object localObject1 = this.mcN;
    super.b(f.class, new bi((z)Eo(), (ag)localObject1)
    {
      public final void a(f.a paramAnonymousa, final int paramAnonymousInt)
      {
        AppMethodBeat.i(220832);
        super.a(paramAnonymousa, paramAnonymousInt);
        if (a.this.Eo() == null)
        {
          AppMethodBeat.o(220832);
          return;
        }
        ((com.tencent.luggage.sdk.b.a.c)a.this.Eo()).K(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(220830);
            if ((a.this.Eo() != null) && (((com.tencent.luggage.sdk.b.a.c)a.this.Eo()).kfr != null)) {
              ((com.tencent.luggage.sdk.b.a.c)a.this.Eo()).kfr.setBackgroundColor(paramAnonymousInt);
            }
            if (a.a(a.this) != null) {
              a.a(a.this).setBackgroundColor(paramAnonymousInt);
            }
            AppMethodBeat.o(220830);
          }
        });
        AppMethodBeat.o(220832);
      }
      
      public final void el(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(220831);
        boolean bool = a.this.Eq().getAppConfig().bem();
        Resources localResources = a.this.Eq().mContext.getResources();
        if (bool) {}
        for (int i = 2131099650;; i = 2131099828)
        {
          i = com.tencent.mm.plugin.appbrand.y.g.ck(paramAnonymousString2, localResources.getColor(i));
          a(f.a.ay(paramAnonymousString1, bool), i);
          AppMethodBeat.o(220831);
          return;
        }
      }
    });
    this.mcP.a(new az()
    {
      public final void a(AppBrandPageFullScreenView paramAnonymousAppBrandPageFullScreenView)
      {
        AppMethodBeat.i(147415);
        if (((com.tencent.luggage.sdk.b.a.c)a.this.Eo()).mgv == null)
        {
          ae.e("Luggage.AbstractMPPageViewRenderer", "FullScreenViewAttach getContainerPage is null, check time sequence, err, appId[%s], url[%s]", new Object[] { a.this.getAppId(), a.this.kxv });
          AppMethodBeat.o(147415);
          return;
        }
        ((com.tencent.luggage.sdk.b.a.c)a.this.Eo()).mgv.a((z)a.this.Eo(), paramAnonymousAppBrandPageFullScreenView);
        AppMethodBeat.o(147415);
      }
    });
    if (Eq().jAc != null) {
      Eq().jAc.a(new az()
      {
        public final void a(AppBrandPageFullScreenView paramAnonymousAppBrandPageFullScreenView)
        {
          AppMethodBeat.i(220829);
          if (((com.tencent.luggage.sdk.b.a.c)a.this.Eo()).mgv == null)
          {
            ae.e("Luggage.AbstractMPPageViewRenderer", "FullScreenViewAttach getContainerPage is null, check time sequence, err, appId[%s], url[%s]", new Object[] { a.this.getAppId(), a.this.kxv });
            AppMethodBeat.o(220829);
            return;
          }
          ((com.tencent.luggage.sdk.b.a.c)a.this.Eo()).mgv.a((z)a.this.Eo(), paramAnonymousAppBrandPageFullScreenView);
          AppMethodBeat.o(220829);
        }
      });
    }
    Object localObject2 = ((com.tencent.luggage.sdk.b.a.c)Eo()).getPageConfig();
    ((com.tencent.luggage.sdk.b.a.c)Eo()).bvm();
    localObject1 = (bh)Q(bh.class);
    localObject2 = ((com.tencent.mm.plugin.appbrand.config.a.d)localObject2).jZz;
    ((bh)localObject1).mjd.cox = false;
    ((bh)localObject1).ckZ = ((String)localObject2);
    if (!((com.tencent.luggage.sdk.b.a.c)Eo()).aWb().LN(this.kxv))
    {
      ae.e("Luggage.AbstractMPPageViewRenderer", "Empty page content, appId[%s] url[%s], abort inject", new Object[] { getAppId(), paramString });
      TG(paramString);
      return false;
    }
    if (bur()) {
      this.mcQ = new bl(getContext(), (z)Eo());
    }
    buw();
    buv();
    paramString = this.kxv;
    try
    {
      TF(String.format(Locale.ENGLISH, "injectModuleSharedPageFrameScript(%s)", new Object[] { paramString })).TH(paramString);
      paramString = this.kxv;
    }
    catch (aq localaq1)
    {
      try
      {
        TF(String.format(Locale.ENGLISH, "injectPageScript(%s)", new Object[] { paramString })).TI(paramString);
        return true;
        localaq1 = localaq1;
        ae.e("Luggage.AbstractMPPageViewRenderer", "injectModuleSharedPageFrameScript appId[%s] path[%s] ScriptNotFoundException", new Object[] { getAppId(), paramString });
        Eq().finish();
      }
      catch (aq localaq2)
      {
        for (;;)
        {
          ae.e("Luggage.AbstractMPPageViewRenderer", "injectPageScript appId[%s] url[%s] ScriptNotFoundException", new Object[] { getAppId(), paramString });
          Eq().finish();
        }
      }
    }
  }
  
  public void cm(View paramView)
  {
    this.mcI = ((FrameLayout)paramView);
    this.mcI.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView) {}
      
      public final void onViewDetachedFromWindow(View paramAnonymousView)
      {
        AppMethodBeat.i(147413);
        Object localObject = a.this.mcP;
        long l = SystemClock.uptimeMillis();
        paramAnonymousView = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        paramAnonymousView.setSource(4098);
        localObject = ((al)localObject).mia.iterator();
        while (((Iterator)localObject).hasNext())
        {
          View localView = (View)((al.b)((Iterator)localObject).next()).mix.get();
          if (localView != null) {
            localView.dispatchTouchEvent(paramAnonymousView);
          }
        }
        paramAnonymousView.recycle();
        AppMethodBeat.o(147413);
      }
    });
    this.mcO = new com.tencent.mm.plugin.appbrand.widget.input.al((z)Eo());
    if (this.mcJ == null) {
      ((com.tencent.luggage.sdk.b.a.c)Eo()).biL();
    }
    this.mcJ.ax(getContext());
    this.mcJ.setFullscreenImpl(((com.tencent.luggage.sdk.b.a.c)Eo()).getFullscreenImpl());
    this.mcJ.setOnScrollChangedListener(this.mcO);
    this.mcJ.setWebViewLayoutListener(this.mcO);
    this.mcO.setupWebViewTouchInterceptor(this.mcJ);
    paramView = this.mcJ;
    this.mcN = new ag(getContext(), paramView);
    this.mcN.addView(this.mcO.getContainer());
    this.mcN.setOnPullDownOffsetListener(this.mcO);
    this.mcN.setOnPullDownListener(new ag.a()
    {
      public final void buy()
      {
        AppMethodBeat.i(147414);
        if (a.this.Eo() == null)
        {
          AppMethodBeat.o(147414);
          return;
        }
        ((com.tencent.luggage.sdk.b.a.c)a.this.Eo()).b("onPullDownRefresh", null, new int[] { ((com.tencent.luggage.sdk.b.a.c)a.this.Eo()).aXX() });
        AppMethodBeat.o(147414);
      }
    });
    this.mcI.addView(this.mcN);
    this.mcP = new al(this.mcO.getContainer());
    this.mcP.setFullscreenImpl(((com.tencent.luggage.sdk.b.a.c)Eo()).getFullscreenImpl());
    if (Eq().jAc != null) {
      Eq().jAc.setFullscreenImpl(((com.tencent.luggage.sdk.b.a.c)Eo()).getFullscreenImpl());
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
  
  protected abstract ax dJ(Context paramContext);
  
  public final void dispatchDestroy()
  {
    super.dispatchDestroy();
    this.mcO.a(this.mcJ);
    this.mcJ.destroy();
    this.mcJ = null;
    this.mcI.removeAllViewsInLayout();
    this.mcN.removeAllViewsInLayout();
    this.mcN = null;
    this.mcO = null;
  }
  
  public void dispatchStart()
  {
    super.dispatchStart();
    super.b(com.tencent.mm.plugin.appbrand.page.a.d.class, new bh((z)Eo()));
    super.b(h.class, new bk((z)Eo()));
    com.tencent.mm.plugin.appbrand.utils.m local8 = new com.tencent.mm.plugin.appbrand.utils.m()
    {
      public final Object invoke(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
      {
        AppMethodBeat.i(220837);
        ae.e("Luggage.AbstractMPPageViewRenderer", "DummyPullDownExtension: invoke(%s), args=%s", new Object[] { paramAnonymousMethod.getName(), org.apache.commons.b.a.toString(paramAnonymousArrayOfObject, "NULL") });
        paramAnonymousObject = super.invoke(paramAnonymousObject, paramAnonymousMethod, paramAnonymousArrayOfObject);
        AppMethodBeat.o(220837);
        return paramAnonymousObject;
      }
    };
    super.b(f.class, (f)Proxy.newProxyInstance(f.class.getClassLoader(), new Class[] { f.class }, local8));
    com.tencent.luggage.sdk.b.a.b.b.a((z)Eo());
    if (((com.tencent.luggage.sdk.b.a.c)Eo()).Eq().getAppConfig().bem())
    {
      this.mcJ.setBackgroundColor(android.support.v4.content.b.n(getContext(), 2131099726));
      return;
    }
    this.mcJ.setBackgroundColor(-1);
  }
  
  protected final void ek(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      ae.e("Luggage.AbstractMPPageViewRenderer", "[!]injectScript appId[%s] name[%s] url[%s] hash[%d] source EMPTY", new Object[] { getAppId(), paramString1, this.kxv, Integer.valueOf(hashCode()) });
      return;
    }
    final d.a locala = new d.a();
    locala.scriptName = paramString1;
    locala.cnx = paramString2;
    locala.cny = paramString2.length();
    final long l = System.currentTimeMillis();
    ae.i("Luggage.AbstractMPPageViewRenderer", "injectScript start, appId[%s] name[%s] url[%s] hash[%d]", new Object[] { getAppId(), paramString1, this.kxv, Integer.valueOf(hashCode()) });
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString1)) {
          continue;
        }
        ae.w("Luggage.AbstractMPPageViewRenderer", "[!] injectScript, valid name is required, appId:%s, url:%s", new Object[] { getAppId(), this.kxv });
        paramString1 = null;
      }
      catch (Exception paramString1)
      {
        paramString1 = null;
        continue;
      }
      s.a(((com.tencent.luggage.sdk.b.a.c)Eo()).aYB(), paramString1, paramString2, new s.a()
      {
        private void df(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(220836);
          a.this.a(locala, paramAnonymousBoolean, l, System.currentTimeMillis(), null);
          AppMethodBeat.o(220836);
        }
        
        public final void cV(String paramAnonymousString)
        {
          AppMethodBeat.i(220835);
          df(false);
          AppMethodBeat.o(220835);
        }
        
        public final void onSuccess(String paramAnonymousString)
        {
          AppMethodBeat.i(220834);
          df(true);
          AppMethodBeat.o(220834);
        }
      });
      return;
      paramString1 = new URL("https", "servicewechat.com", paramString1);
    }
  }
  
  public final String getAppId()
  {
    com.tencent.mm.plugin.appbrand.jsapi.c localc = Eo();
    if (localc == null)
    {
      ae.printErrStackTrace("Luggage.AbstractMPPageViewRenderer", new Throwable(), "getAppId", new Object[0]);
      return null;
    }
    return localc.getAppId();
  }
  
  protected final String getURL()
  {
    return this.kxv;
  }
  
  public final boolean isRunning()
  {
    com.tencent.luggage.sdk.b.a.c localc = (com.tencent.luggage.sdk.b.a.c)Eo();
    return (localc != null) && (localc.isRunning());
  }
  
  public boolean y(String paramString1, String paramString2)
  {
    return false;
  }
  
  static abstract interface a
  {
    public abstract void TH(String paramString);
    
    public abstract void TI(String paramString);
    
    public abstract boolean TJ(String paramString);
    
    public abstract void buv();
    
    public abstract String name();
  }
  
  final class b
    implements a.a
  {
    private b() {}
    
    private void TK(String paramString)
    {
      AppMethodBeat.i(147423);
      String str = a.this.buu().SR(paramString);
      if (TextUtils.isEmpty(str))
      {
        paramString = new aq(paramString);
        AppMethodBeat.o(147423);
        throw paramString;
      }
      a.this.ek(paramString, str);
      AppMethodBeat.o(147423);
    }
    
    public final void TH(String paramString)
    {
      AppMethodBeat.i(147425);
      if (!a.this.Eq().jzR.btM())
      {
        AppMethodBeat.o(147425);
        return;
      }
      paramString = a.this.Eq().jzR.Tk(paramString);
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
        TK(paramString + "common.app.js");
        TK(paramString + "webview.app.js");
        AppMethodBeat.o(147425);
        return;
      }
    }
    
    public final void TI(String paramString) {}
    
    public final boolean TJ(String paramString)
    {
      AppMethodBeat.i(220838);
      boolean bool = "webview.app.js".equals(paramString);
      AppMethodBeat.o(220838);
      return bool;
    }
    
    public final void buv()
    {
      AppMethodBeat.i(147424);
      a.c(a.this).ax("__APP__", true);
      TK("common.app.js");
      TK("webview.app.js");
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
    
    public final void TH(String paramString)
    {
      AppMethodBeat.i(147427);
      if (!a.this.Eq().jzR.btM())
      {
        AppMethodBeat.o(147427);
        return;
      }
      String str = a.this.Eq().jzR.Tk(paramString);
      Object localObject = new StringBuilder().append(str);
      if (str.endsWith("/")) {}
      for (paramString = "";; paramString = "/")
      {
        paramString = paramString + "page-frame.js";
        localObject = a.this.buu().SR(paramString);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        paramString = new aq(paramString);
        AppMethodBeat.o(147427);
        throw paramString;
      }
      a.c(a.this).ax(str, false);
      a.this.ek(paramString, (String)localObject);
      AppMethodBeat.o(147427);
    }
    
    public final void TI(String paramString)
    {
      AppMethodBeat.i(147428);
      String str = a.this.buu().SR(paramString);
      a.this.ek(paramString, str);
      AppMethodBeat.o(147428);
    }
    
    public final boolean TJ(String paramString)
    {
      AppMethodBeat.i(220839);
      if (("app-wxss.js".equals(paramString)) || ("page-frame.html".equals(paramString)))
      {
        AppMethodBeat.o(220839);
        return true;
      }
      AppMethodBeat.o(220839);
      return false;
    }
    
    public final void buv()
    {
      AppMethodBeat.i(147426);
      a.c(a.this).ax("__APP__", false);
      if (a.this.Eq().jzR.btM())
      {
        localObject = a.this.buu().SR("app-wxss.js");
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = new aq("app-wxss.js");
          AppMethodBeat.o(147426);
          throw ((Throwable)localObject);
        }
        a.this.ek("app-wxss.js", (String)localObject);
        AppMethodBeat.o(147426);
        return;
      }
      Object localObject = a.this.buu().SR("page-frame.html");
      a.this.ek("page-frame.html", (String)localObject);
      AppMethodBeat.o(147426);
    }
    
    public final String name()
    {
      return "Legacy";
    }
  }
  
  final class d
    extends au
  {
    public d(Context paramContext)
    {
      super();
    }
    
    @JavascriptInterface
    public final float getWidth()
    {
      AppMethodBeat.i(147429);
      float f1 = (float)Math.ceil(a.this.Eq().getWindowAndroid().getVDisplayMetrics().widthPixels / getPixelRatio());
      float f2 = (float)Math.ceil(a.b(a.this).getWidth() / super.getPixelRatio());
      if ((f2 > 0.0F) && (f2 != f1)) {
        ae.w("Luggage.AbstractMPPageViewRenderer", "__deviceInfo.getWidth(), resources[%f] != view[%f], may in pad env", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
      }
      AppMethodBeat.o(147429);
      return f1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.a
 * JD-Core Version:    0.7.0.1
 */