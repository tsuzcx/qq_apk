package com.tencent.mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.webkit.JavascriptInterface;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.j.g;
import com.tencent.luggage.l.a.d;
import com.tencent.luggage.l.a.e;
import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.config.a.b;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.i.f;
import com.tencent.mm.plugin.appbrand.jsapi.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.e.d;
import com.tencent.mm.plugin.appbrand.jsapi.e.e;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.a.c;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandCapsuleHomeButton;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.an;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;

@SuppressLint({"ViewConstructor"})
public class q
  extends d
  implements com.tencent.mm.plugin.appbrand.jsapi.e
{
  public volatile boolean ahC = false;
  private com.tencent.mm.plugin.appbrand.i fzT;
  private FrameLayout gSB;
  private List<com.tencent.mm.plugin.appbrand.menu.n> gSQ;
  private String gTA;
  private RelativeLayout gTB;
  public com.tencent.mm.plugin.appbrand.widget.actionbar.a gTC;
  private y gTD;
  private ah gTE;
  public af gTF;
  public u gTG;
  private volatile boolean gTH = false;
  volatile boolean gTI = false;
  private boolean gTJ = false;
  boolean gTK = false;
  int gTL;
  boolean gTM = false;
  String gTN = null;
  public boolean gTO = false;
  public int gTP = 0;
  private b gTQ;
  public final com.tencent.mm.plugin.appbrand.widget.e.b gTR = new com.tencent.mm.plugin.appbrand.widget.e.b(this);
  public final c gTS = ahf();
  ai gTT;
  private ViewTreeObserver.OnGlobalLayoutListener gTU;
  x gTV = new x(this);
  boolean gTW = false;
  final ConcurrentLinkedQueue<Runnable> gTX = new ConcurrentLinkedQueue();
  private final Collection<e.e> gTv = new ConcurrentLinkedQueue();
  private Set<com.tencent.mm.plugin.appbrand.jsapi.e.b> gTw = Collections.newSetFromMap(new ConcurrentHashMap());
  private Set<e.d> gTx = Collections.newSetFromMap(new ConcurrentHashMap());
  private Set<e.c> gTy = Collections.newSetFromMap(new ConcurrentHashMap());
  public Set<e.a> gTz = Collections.newSetFromMap(new ConcurrentHashMap());
  private String gcH;
  public String mAppId;
  public Context mContext;
  
  private void D(Runnable paramRunnable)
  {
    synchronized (this.gTX)
    {
      if (this.gTI)
      {
        paramRunnable.run();
        return;
      }
      this.gTX.offer(paramRunnable);
      return;
    }
  }
  
  private static void a(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    try
    {
      paramJSONObject.put(paramString, paramObject);
      return;
    }
    catch (Exception paramJSONObject)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AppBrandPageView", paramJSONObject.getMessage());
    }
  }
  
  private void and()
  {
    this.gTF.addJavascriptInterface(new a((byte)0), "__deviceInfo");
  }
  
  private void anm()
  {
    ann();
    D(new q.29(this));
  }
  
  private void ann()
  {
    if (this.gTH) {
      return;
    }
    this.gTH = true;
    this.gTF.bt(anh(), ano());
  }
  
  static void runOnUiThread(Runnable paramRunnable)
  {
    if (!com.tencent.mm.sdk.platformtools.ai.isMainThread())
    {
      com.tencent.mm.sdk.platformtools.ai.d(paramRunnable);
      return;
    }
    paramRunnable.run();
  }
  
  private String vL(String paramString)
  {
    return this.mAppId + ":" + getURL() + ":" + paramString;
  }
  
  public void E(int paramInt, boolean paramBoolean)
  {
    if (this.gSQ.size() > paramInt) {
      ((com.tencent.mm.plugin.appbrand.menu.n)this.gSQ.get(paramInt)).gPg = paramBoolean;
    }
  }
  
  public final void EV()
  {
    ahM();
    and();
    ann();
    D(new Runnable()
    {
      public final void run()
      {
        q.r(q.this);
        q.this.aao();
      }
    });
  }
  
  protected void F(JSONObject paramJSONObject) {}
  
  final void N(int paramInt, String paramString)
  {
    com.tencent.mm.ui.statusbar.a.d(getContentView(), paramInt, "black".equals(paramString));
  }
  
  public o Zy()
  {
    return getRuntime().Zy();
  }
  
  public <T> T a(int paramInt, Bundle paramBundle, Object... paramVarArgs)
  {
    return null;
  }
  
  public void a(Context paramContext, com.tencent.mm.plugin.appbrand.i parami)
  {
    this.mContext = paramContext;
    this.fzT = parami;
    this.mAppId = parami.mAppId;
    this.ahC = true;
    this.gSQ = ane();
    this.gTL = an.n(this.mContext.getResources().getColor(com.tencent.luggage.l.a.a.statusbar_fg_color), paramContext.getResources().getColor(com.tencent.luggage.l.a.a.normal_actionbar_color));
    c(parami.fyu);
    super.init();
    initView();
    anm();
    this.gTT = ch(this.mContext);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.e.b paramb)
  {
    this.gTw.add(paramb);
  }
  
  public final void a(e.c paramc)
  {
    this.gTy.add(paramc);
  }
  
  public final void a(e.d paramd)
  {
    this.gTx.add(paramd);
  }
  
  public final void a(e.e parame)
  {
    this.gTv.add(parame);
  }
  
  public void a(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    if (this.fzT == null)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AppBrandPageView", "publish runtime is null, event %s", new Object[] { paramString1 });
      return;
    }
    this.fzT.Zy().i(paramString1, paramString2, hashCode());
  }
  
  public final boolean aan()
  {
    return getRuntime() == null;
  }
  
  protected void aao() {}
  
  public final f aat()
  {
    af localaf = cg(this.mContext);
    this.gTF = localaf;
    return localaf;
  }
  
  public Map<String, com.tencent.mm.plugin.appbrand.jsapi.i> aau()
  {
    return new HashMap();
  }
  
  public ah agN()
  {
    return this.gTE;
  }
  
  public ViewGroup agO()
  {
    return this.gTE.getContainer();
  }
  
  public void agQ()
  {
    getContentView().postInvalidate();
  }
  
  public void agR()
  {
    this.gTF.pY();
    anj();
    a.a(this);
    this.gTS.agH();
    if (this.gTF.agC())
    {
      this.gTH = false;
      this.gTI = false;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AppBrandPageView", "reload page %s", new Object[] { this.gTA });
      anm();
      tB(this.gTA);
      D(new q.27(this));
    }
    this.gTF.setTitle(vL("VISIBLE"));
  }
  
  public void agS()
  {
    this.gTF.qa();
    this.gTF.setTitle(vL("INVISIBLE"));
    this.gTQ.amQ();
  }
  
  public void agT()
  {
    this.ahC = false;
  }
  
  public void agV()
  {
    this.gTF.destroy();
  }
  
  public y agW()
  {
    return this.gTD;
  }
  
  public String agX()
  {
    CharSequence localCharSequence = this.gTC.getMainTitle();
    if (localCharSequence != null) {
      return localCharSequence.toString();
    }
    return "";
  }
  
  public void agY()
  {
    runOnUiThread(new q.19(this));
  }
  
  public void agZ()
  {
    runOnUiThread(new q.20(this));
  }
  
  public FrameLayout aha()
  {
    return this.gSB;
  }
  
  public View ahb()
  {
    View localView = null;
    if (this.gTP > 0)
    {
      localView = LayoutInflater.from(this.mContext).inflate(a.e.appbrand_action_header_layout, null);
      ((TextView)localView.findViewById(a.d.appbrand_action_header_status)).setText(this.mContext.getResources().getString(this.gTP));
    }
    return localView;
  }
  
  public String ahc()
  {
    return this.gTA;
  }
  
  public c ahf()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return new com.tencent.mm.plugin.appbrand.page.a.a(this);
    }
    return new com.tencent.mm.plugin.appbrand.page.a.b();
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.input.ac anc()
  {
    if ((this.mContext instanceof com.tencent.mm.plugin.appbrand.widget.input.ac)) {
      return (com.tencent.mm.plugin.appbrand.widget.input.ac)this.mContext;
    }
    return null;
  }
  
  protected List<com.tencent.mm.plugin.appbrand.menu.n> ane()
  {
    return new LinkedList();
  }
  
  public final b anf()
  {
    if (this.gTQ != null) {
      return this.gTQ;
    }
    this.gTQ = new b(this.mContext);
    this.gTQ.a(new q.2(this));
    return this.gTQ;
  }
  
  public String ang()
  {
    return "https://servicewechat.com/";
  }
  
  protected final String anh()
  {
    String str2 = ang();
    String str1 = str2;
    if (!str2.endsWith("/")) {
      str1 = str2 + "/";
    }
    return str1 + "page-frame.html";
  }
  
  public final void ani()
  {
    N(this.gTL, this.gTN);
  }
  
  protected void anj()
  {
    ank();
  }
  
  protected final void ank()
  {
    this.gTC.setNavHidden(false);
    this.gTC.setNavBackOrClose(true);
  }
  
  protected final void anl()
  {
    if (this.fzT.Zz().getPageCount() == 1)
    {
      this.gTC.setNavHidden(true);
      return;
    }
    this.gTC.setNavHidden(false);
    this.gTC.setNavBackOrClose(true);
  }
  
  protected String ano()
  {
    return "<html></html>";
  }
  
  public final boolean anp()
  {
    return (com.tencent.mm.plugin.appbrand.config.e.r((Activity)this.mContext).cM(com.tencent.mm.plugin.appbrand.config.e.adY()) == com.tencent.mm.plugin.appbrand.config.e.b.fOs) || (com.tencent.mm.plugin.appbrand.config.e.r((Activity)this.mContext).cM(com.tencent.mm.plugin.appbrand.config.e.adY()) == com.tencent.mm.plugin.appbrand.config.e.b.fOt);
  }
  
  protected void az(List<com.tencent.mm.plugin.appbrand.menu.n> paramList)
  {
    new l(this, new LinkedList(this.gSQ)).amW();
  }
  
  public final void b(com.tencent.mm.plugin.appbrand.jsapi.e.b paramb)
  {
    this.gTw.remove(paramb);
  }
  
  public final void b(e.c paramc)
  {
    this.gTy.remove(paramc);
  }
  
  public final void b(e.d paramd)
  {
    this.gTx.remove(paramd);
  }
  
  public final void b(e.e parame)
  {
    this.gTv.remove(parame);
  }
  
  public void bu(String paramString1, String paramString2)
  {
    runOnUiThread(new q.24(this, paramString2, paramString1));
  }
  
  public void cS(boolean paramBoolean)
  {
    runOnUiThread(new q.17(this, paramBoolean));
  }
  
  public void cT(boolean paramBoolean)
  {
    runOnUiThread(new q.21(this, paramBoolean));
  }
  
  public af cg(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = ae.getContext();
    }
    return new ac(localContext, this.gTV);
  }
  
  public ai ch(Context paramContext)
  {
    return ai.gVK;
  }
  
  public final void cleanup()
  {
    super.cleanup();
    agV();
    this.gTv.clear();
    this.gTy.clear();
    this.gTw.clear();
    this.gTx.clear();
    this.gTz.clear();
  }
  
  public void dw(boolean paramBoolean)
  {
    runOnUiThread(new q.18(this, paramBoolean));
  }
  
  public final void dx(boolean paramBoolean)
  {
    ViewGroup.LayoutParams localLayoutParams1 = this.gTC.getActionView().getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams2 = this.gSB.getLayoutParams();
    this.gTW = paramBoolean;
    if ((!(localLayoutParams1 instanceof RelativeLayout.LayoutParams)) || (!(localLayoutParams2 instanceof RelativeLayout.LayoutParams))) {
      return;
    }
    ((RelativeLayout.LayoutParams)localLayoutParams1).addRule(10);
    if (paramBoolean) {
      ((RelativeLayout.LayoutParams)localLayoutParams2).removeRule(3);
    }
    for (;;)
    {
      this.gTB.requestLayout();
      return;
      ((RelativeLayout.LayoutParams)localLayoutParams2).addRule(3, a.d.app_brand_action_bar);
    }
  }
  
  public final String getAppId()
  {
    return this.mAppId;
  }
  
  public View getContentView()
  {
    return this.gTB;
  }
  
  public final Context getContext()
  {
    return this.mContext;
  }
  
  public com.tencent.mm.plugin.appbrand.i getRuntime()
  {
    return this.fzT;
  }
  
  public String getURL()
  {
    return this.gcH;
  }
  
  public void hide()
  {
    this.gTB.setVisibility(4);
  }
  
  public void i(final String paramString1, final String paramString2, final int paramInt)
  {
    D(new Runnable()
    {
      public final void run()
      {
        q.a(q.this, paramString1, paramString2, paramInt);
      }
    });
  }
  
  public final void initActionBar()
  {
    Object localObject = this.mContext;
    com.tencent.mm.plugin.appbrand.i locali = this.fzT;
    boolean bool2 = locali.getAppConfig().fNB.adW();
    boolean bool1 = locali.getAppConfig().fNF.fNL;
    if ((!bool2) || (!bool1)) {}
    for (bool1 = true;; bool1 = false)
    {
      localObject = new com.tencent.mm.plugin.appbrand.widget.actionbar.a((Context)localObject, bool1);
      ((com.tencent.mm.plugin.appbrand.widget.actionbar.a)localObject).setFullscreenMode(bool2);
      this.gTC = ((com.tencent.mm.plugin.appbrand.widget.actionbar.a)localObject);
      this.gTC.getActionView().setId(a.d.app_brand_action_bar);
      this.gTC.setBackButtonClickListener(new q.22(this));
      this.gTC.setCloseButtonClickListener(new q.31(this));
      this.gTC.setTitleAreaOnDoubleClickListener(new q.32(this));
      this.gTC.setOptionButtonClickListener(new q.33(this));
      localObject = this.gTC;
      ((com.tencent.mm.plugin.appbrand.widget.actionbar.a)localObject).hoz.reset();
      ((com.tencent.mm.plugin.appbrand.widget.actionbar.a)localObject).hoA.reset();
      ((com.tencent.mm.plugin.appbrand.widget.actionbar.a)localObject).aqZ();
      return;
    }
  }
  
  public void initView()
  {
    initActionBar();
    if (this.gTF == null)
    {
      this.gTF = cg(this.mContext);
      and();
    }
    for (;;)
    {
      this.gTF.setFullscreenImpl(anf());
      this.gTF.setOnTrimListener(new q.34(this));
      this.gTG = new u(this.mContext, this.gTF);
      this.gTG.setOnPullDownListener(new q.35(this));
      this.gTG.setOnPullDownOffsetListener(new q.36(this));
      this.gSB = new FrameLayout(this.mContext);
      this.gSB.setId(a.d.app_brand_page_area);
      this.gSB.addView(this.gTG);
      Object localObject = this.gTG;
      ah localah = ((ah.a)com.tencent.luggage.b.e.i(ah.a.class)).s(this);
      this.gTE = localah;
      ((u)localObject).addView(localah.getContainer());
      this.gTG.setOnPullDownOffsetListener(this.gTE);
      this.gTF.setOnScrollChangedListener(this.gTE);
      this.gTF.setWebViewLayoutListener(this.gTE);
      this.gTE.setupWebViewTouchInterceptor(this.gTF);
      this.gTB = new q.1(this, this.mContext);
      this.gTB.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      this.gTB.addView(this.gSB, new ViewGroup.LayoutParams(-1, -1));
      this.gTB.addView(this.gTC.getActionView());
      dx(this.fzT.getAppConfig().fNB.adW());
      this.gTD = new y(this.gTE.getContainer());
      this.gTD.setFullscreenImpl(anf());
      localObject = this.gSB.getViewTreeObserver();
      this.gTU = new q.12(this);
      if (((ViewTreeObserver)localObject).isAlive()) {
        ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(this.gTU);
      }
      return;
      this.gTF.cf(this.mContext);
    }
  }
  
  public boolean isFullScreen()
  {
    return this.gTJ;
  }
  
  public final boolean isRunning()
  {
    return this.ahC;
  }
  
  public void kW(int paramInt)
  {
    runOnUiThread(new q.11(this, paramInt));
  }
  
  public void kX(int paramInt)
  {
    runOnUiThread(new q.16(this, paramInt));
  }
  
  public void kY(int paramInt)
  {
    this.gTK = true;
    this.gTL = paramInt;
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        q.a(q.this, q.p(q.this), q.q(q.this));
      }
    });
  }
  
  public void kZ(int paramInt)
  {
    this.gTP = paramInt;
  }
  
  public final com.tencent.mm.plugin.appbrand.menu.n lY(int paramInt)
  {
    if (this.gSQ.size() > paramInt) {
      return (com.tencent.mm.plugin.appbrand.menu.n)this.gSQ.get(paramInt);
    }
    return null;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  protected void onCreate() {}
  
  public final void onDestroy()
  {
    agT();
    runOnUiThread(new q.8(this));
    ViewTreeObserver localViewTreeObserver = this.gSB.getViewTreeObserver();
    if (localViewTreeObserver.isAlive()) {
      localViewTreeObserver.removeOnGlobalLayoutListener(this.gTU);
    }
  }
  
  public final void onReady()
  {
    agQ();
    runOnUiThread(new q.5(this));
  }
  
  public final void pY()
  {
    agR();
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        Iterator localIterator = q.k(q.this).iterator();
        while (localIterator.hasNext()) {
          ((e.d)localIterator.next()).pY();
        }
      }
    });
    this.gTT.agH();
  }
  
  public final void q(double paramDouble)
  {
    runOnUiThread(new q.9(this, paramDouble));
  }
  
  public final void qa()
  {
    agS();
    runOnUiThread(new q.7(this));
    this.gTT.agI();
  }
  
  public boolean qc()
  {
    if (this.gTQ.amQ()) {
      return true;
    }
    if (this.gTz.size() == 0) {
      return false;
    }
    Iterator localIterator = this.gTz.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      if (!((e.a)localIterator.next()).qc()) {
        break label71;
      }
      bool = true;
    }
    label71:
    for (;;)
    {
      break;
      return bool;
    }
  }
  
  public void show()
  {
    this.gTB.setVisibility(0);
  }
  
  public boolean tB(String paramString)
  {
    this.gcH = g.bi(paramString);
    this.gTA = paramString;
    if (!aq.b(this.fzT, this.gcH))
    {
      vK(paramString);
      onReady();
      return false;
    }
    D(new q.3(this, paramString));
    return true;
  }
  
  public void tC(String paramString)
  {
    runOnUiThread(new q.10(this, paramString));
  }
  
  public void tD(String paramString)
  {
    runOnUiThread(new q.13(this, paramString));
  }
  
  public void tE(String paramString)
  {
    runOnUiThread(new q.15(this, paramString));
  }
  
  public void tF(String paramString)
  {
    this.gTM = true;
    this.gTN = paramString;
    runOnUiThread(new q.25(this));
  }
  
  protected void vJ(String paramString) {}
  
  protected void vK(String paramString) {}
  
  public final void vM(String paramString)
  {
    if (paramString.equalsIgnoreCase("dark"))
    {
      this.gTO = true;
      return;
    }
    this.gTO = false;
  }
  
  private final class a
  {
    private a() {}
    
    @JavascriptInterface
    public final float getPixelRatio()
    {
      return q.h(q.this).getResources().getDisplayMetrics().density;
    }
    
    @JavascriptInterface
    public final float getWidth()
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AppBrandPageView", "DeviceInfoForSDK.getWidth %d", new Object[] { Integer.valueOf(q.this.getContentView().getWidth()) });
      return q.h(q.this).getResources().getDisplayMetrics().widthPixels / getPixelRatio();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.q
 * JD-Core Version:    0.7.0.1
 */