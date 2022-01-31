package com.tencent.mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.g.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.ax;
import com.tencent.mm.plugin.appbrand.config.a.d;
import com.tencent.mm.plugin.appbrand.config.a.a.b;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.f.e;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.menu.q;
import com.tencent.mm.plugin.appbrand.widget.input.ad;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

@SuppressLint({"ViewConstructor"})
public class v
  extends c
  implements com.tencent.mm.plugin.appbrand.jsapi.e
{
  protected static final int ixg = 2131820549;
  private volatile boolean ajS;
  public volatile boolean fDl;
  private volatile boolean gRF;
  protected volatile i gRG;
  public ViewGroup hmw;
  public String hzM;
  public String iuB;
  public ap iuy;
  public FrameLayout ivI;
  private List<q> iwd;
  be iwn;
  protected int ixh;
  private x ixi;
  private final Class<? extends x> ixj;
  protected com.tencent.mm.plugin.appbrand.widget.actionbar.d ixk;
  protected com.tencent.mm.plugin.appbrand.widget.actionbar.b ixl;
  public af ixm;
  public as ixn;
  public boolean ixo;
  protected CharSequence ixp;
  private d ixq;
  public final com.tencent.mm.plugin.appbrand.widget.f.b ixr;
  o ixs;
  private ae ixt;
  private boolean ixu;
  public Context mContext;
  
  public v()
  {
    this(null);
    AppMethodBeat.i(87198);
    AppMethodBeat.o(87198);
  }
  
  protected v(Class<? extends x> paramClass)
  {
    AppMethodBeat.i(141695);
    this.ixh = 2131820548;
    this.ajS = false;
    this.gRF = false;
    this.fDl = false;
    this.ixo = false;
    this.ixp = null;
    this.ixr = new com.tencent.mm.plugin.appbrand.widget.f.b(this);
    this.iwn = null;
    this.ixu = false;
    this.ixj = paramClass;
    AppMethodBeat.o(141695);
  }
  
  private static int a(a.d paramd)
  {
    AppMethodBeat.i(141699);
    try
    {
      i = com.tencent.mm.plugin.appbrand.s.g.Fn(paramd.hhp);
      AppMethodBeat.o(141699);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = com.tencent.mm.plugin.appbrand.s.g.bA(paramd.hhh, -1);
      }
    }
  }
  
  private void eD(boolean paramBoolean)
  {
    AppMethodBeat.i(87242);
    this.ixu = paramBoolean;
    Object localObject = this.ixk.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams = this.ivI.getLayoutParams();
    if ((!(localObject instanceof RelativeLayout.LayoutParams)) || (!(localLayoutParams instanceof RelativeLayout.LayoutParams)))
    {
      if (this.gPS)
      {
        localObject = new IllegalStateException("ActionBarContainer and Renderer's PageArea should be in RelativeLayout");
        AppMethodBeat.o(87242);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(87242);
      return;
    }
    ((RelativeLayout.LayoutParams)localObject).addRule(10);
    if (paramBoolean) {
      ((RelativeLayout.LayoutParams)localLayoutParams).removeRule(3);
    }
    for (;;)
    {
      this.hmw.requestLayout();
      this.ixl.setFullscreenMode(this.ixu);
      AppMethodBeat.o(87242);
      return;
      ((RelativeLayout.LayoutParams)localLayoutParams).addRule(3, ixg);
    }
  }
  
  public void BC(String paramString)
  {
    AppMethodBeat.i(87237);
    runOnUiThread(new v.7(this, paramString));
    AppMethodBeat.o(87237);
  }
  
  public void BD(String paramString)
  {
    AppMethodBeat.i(87251);
    runOnUiThread(new v.14(this, paramString));
    AppMethodBeat.o(87251);
  }
  
  public final void Do()
  {
    AppMethodBeat.i(87200);
    aBr();
    this.gRF = true;
    if (aJi() != null)
    {
      Object localObject = (com.tencent.mm.plugin.appbrand.page.b.e)aJi().x(com.tencent.mm.plugin.appbrand.page.b.e.class);
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.appbrand.page.b.e)localObject).aJO();
        AppMethodBeat.o(87200);
        return;
      }
      localObject = new IllegalAccessError(String.format(Locale.US, "Renderer[%s] impl not supports preload", new Object[] { aJi().getClass().getName() }));
      AppMethodBeat.o(87200);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(87200);
  }
  
  public boolean Em(String paramString)
  {
    AppMethodBeat.i(87215);
    this.hzM = h.cg(paramString);
    this.iuB = paramString;
    if (aJi() != null)
    {
      boolean bool = aJi().bX(paramString);
      AppMethodBeat.o(87215);
      return bool;
    }
    aJo();
    if (!ax.d(this.gRG, this.hzM))
    {
      cd(paramString);
      onReady();
      AppMethodBeat.o(87215);
      return false;
    }
    AppMethodBeat.o(87215);
    return true;
  }
  
  public final void En(String paramString)
  {
    AppMethodBeat.i(87260);
    if (paramString.equalsIgnoreCase("dark"))
    {
      this.ixo = true;
      AppMethodBeat.o(87260);
      return;
    }
    this.ixo = false;
    AppMethodBeat.o(87260);
  }
  
  public final void H(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(87248);
    Iterator localIterator = this.iwd.iterator();
    while (localIterator.hasNext())
    {
      q localq = (q)localIterator.next();
      if ((localq != null) && (localq.id == paramInt))
      {
        localq.iqO = paramBoolean;
        AppMethodBeat.o(87248);
        return;
      }
    }
    AppMethodBeat.o(87248);
  }
  
  public void a(Context paramContext, i parami)
  {
    AppMethodBeat.i(87199);
    this.mContext = paramContext;
    this.gRG = parami;
    this.ajS = true;
    this.iwd = aJm();
    c(parami.gPG);
    super.init();
    if (aJi() != null)
    {
      paramContext = aJi().a(LayoutInflater.from(getContext()));
      this.hmw = new v.a(this, getContext());
      this.hmw.addView(paramContext, new ViewGroup.LayoutParams(-1, -1));
      aJi().ce(paramContext);
      if (this.iuy == null) {
        aBr();
      }
      this.iuy.ap(getContext());
      this.iuy.setFullscreenImpl(getFullscreenImpl());
      initActionBar();
      this.hmw.addView(this.ixk, -1, new ViewGroup.LayoutParams(-1, -2));
      aJi().a(this.ixl);
      if (this.ixl.getParent() != this.ixk)
      {
        paramContext = new IllegalAccessError("You should not modify actionbar's view hierarchy");
        AppMethodBeat.o(87199);
        throw paramContext;
      }
      this.ivI = ((FrameLayout)paramContext);
      this.ixn = aJi().vB();
      this.ixm = aJi().vC();
    }
    if (aJi() != null) {
      aJi().dispatchStart();
    }
    AppMethodBeat.o(87199);
  }
  
  protected void aAE()
  {
    AppMethodBeat.i(87225);
    AppMethodBeat.o(87225);
  }
  
  protected void aAF()
  {
    AppMethodBeat.i(87227);
    AppMethodBeat.o(87227);
  }
  
  protected void aAG()
  {
    AppMethodBeat.i(87229);
    AppMethodBeat.o(87229);
  }
  
  protected void aAH()
  {
    AppMethodBeat.i(87232);
    this.ajS = false;
    AppMethodBeat.o(87232);
  }
  
  public String aAI()
  {
    AppMethodBeat.i(87238);
    Object localObject = this.ixl.getMainTitle();
    if (localObject != null)
    {
      localObject = ((CharSequence)localObject).toString();
      AppMethodBeat.o(87238);
      return localObject;
    }
    AppMethodBeat.o(87238);
    return "";
  }
  
  public void aAJ()
  {
    AppMethodBeat.i(87250);
    runOnUiThread(new v.13(this));
    AppMethodBeat.o(87250);
  }
  
  public Bitmap aAK()
  {
    AppMethodBeat.i(87269);
    Bitmap localBitmap = bh.cu(this.iuy.getWrapperView());
    if (localBitmap != null) {
      bh.a(aJk(), new Canvas(localBitmap));
    }
    AppMethodBeat.o(87269);
    return localBitmap;
  }
  
  protected void aJ(List<q> paramList)
  {
    AppMethodBeat.i(141698);
    new p(this, new LinkedList(this.iwd)).aIX();
    AppMethodBeat.o(141698);
  }
  
  public final boolean aJh()
  {
    return this.fDl;
  }
  
  protected final x aJi()
  {
    AppMethodBeat.i(141696);
    if (this.ixj == null)
    {
      AppMethodBeat.o(141696);
      return null;
    }
    if (this.ixi != null)
    {
      localx = this.ixi;
      AppMethodBeat.o(141696);
      return localx;
    }
    x localx = bk.a(this, this.ixj);
    this.ixi = localx;
    AppMethodBeat.o(141696);
    return localx;
  }
  
  public final o aJj()
  {
    return this.ixs;
  }
  
  public final ViewGroup aJk()
  {
    AppMethodBeat.i(87205);
    ViewGroup localViewGroup = this.ixn.getContainer();
    AppMethodBeat.o(87205);
    return localViewGroup;
  }
  
  public final ad aJl()
  {
    AppMethodBeat.i(141697);
    if ((getContext() instanceof ad))
    {
      ad localad = (ad)getContext();
      AppMethodBeat.o(141697);
      return localad;
    }
    AppMethodBeat.o(141697);
    return null;
  }
  
  protected List<q> aJm()
  {
    AppMethodBeat.i(87210);
    List localList = Collections.emptyList();
    AppMethodBeat.o(87210);
    return localList;
  }
  
  public final String aJn()
  {
    return this.iuB;
  }
  
  public void aJo()
  {
    AppMethodBeat.i(87216);
    a.d locald = getPageConfig();
    BC(locald.hhl);
    t(locald.hhn);
    nM(a(locald));
    runOnUiThread(new v.8(this, locald.hhm));
    eD(locald.ayo());
    boolean bool = locald.hht;
    if (aJi() != null)
    {
      localObject = (com.tencent.mm.plugin.appbrand.page.b.d)aJi().x(com.tencent.mm.plugin.appbrand.page.b.d.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.page.b.d)localObject).eE(bool);
      }
    }
    Object localObject = locald.hhv;
    String str = locald.hhh;
    if (aJi() != null)
    {
      com.tencent.mm.plugin.appbrand.page.b.d locald1 = (com.tencent.mm.plugin.appbrand.page.b.d)aJi().x(com.tencent.mm.plugin.appbrand.page.b.d.class);
      if (locald1 != null) {
        locald1.cO((String)localObject, str);
      }
    }
    if (!locald.hhr) {}
    for (bool = true;; bool = false)
    {
      bb(bool);
      AppMethodBeat.o(87216);
      return;
    }
  }
  
  public final void aJp()
  {
    AppMethodBeat.i(87223);
    this.ixk.setActuallyVisible(true);
    AppMethodBeat.o(87223);
  }
  
  public final void aJq()
  {
    AppMethodBeat.i(87233);
    runOnUiThread(new v.3(this));
    AppMethodBeat.o(87233);
  }
  
  public final void aJr()
  {
    AppMethodBeat.i(87234);
    runOnUiThread(new v.4(this));
    AppMethodBeat.o(87234);
  }
  
  public final void aJs()
  {
    AppMethodBeat.i(87243);
    if (aJi() != null)
    {
      com.tencent.luggage.g.d.i("MicroMsg.AppBrandPageView", "AppBrandPullDown startPullDownRefresh appId[%s], url[%s]", new Object[] { getAppId(), this.hzM });
      com.tencent.mm.plugin.appbrand.page.b.d locald = (com.tencent.mm.plugin.appbrand.page.b.d)aJi().x(com.tencent.mm.plugin.appbrand.page.b.d.class);
      if (locald != null)
      {
        locald.aJs();
        AppMethodBeat.o(87243);
        return;
      }
      com.tencent.luggage.g.d.w("MicroMsg.AppBrandPageView", "startPullDownRefresh no extension impl provided appId[%s], url[%s]", new Object[] { getAppId(), this.hzM });
      AppMethodBeat.o(87243);
      return;
    }
    AppMethodBeat.o(87243);
  }
  
  public final void aJt()
  {
    AppMethodBeat.i(87244);
    if (aJi() != null)
    {
      com.tencent.mm.plugin.appbrand.page.b.d locald = (com.tencent.mm.plugin.appbrand.page.b.d)aJi().x(com.tencent.mm.plugin.appbrand.page.b.d.class);
      if (locald != null)
      {
        locald.aJt();
        AppMethodBeat.o(87244);
        return;
      }
      com.tencent.luggage.g.d.w("MicroMsg.AppBrandPageView", "stopPullDownRefresh no extension impl provided");
      AppMethodBeat.o(87244);
      return;
    }
    AppMethodBeat.o(87244);
  }
  
  public final void aJu()
  {
    AppMethodBeat.i(87246);
    if (aJi() != null)
    {
      com.tencent.mm.plugin.appbrand.page.b.d locald = (com.tencent.mm.plugin.appbrand.page.b.d)aJi().x(com.tencent.mm.plugin.appbrand.page.b.d.class);
      if (locald != null) {
        locald.eF(false);
      }
      AppMethodBeat.o(87246);
      return;
    }
    AppMethodBeat.o(87246);
  }
  
  protected final void aJv()
  {
    AppMethodBeat.i(87254);
    this.ixl.setNavHidden(false);
    AppMethodBeat.o(87254);
  }
  
  public final boolean aJw()
  {
    AppMethodBeat.i(141701);
    if (aJi() != null)
    {
      com.tencent.mm.plugin.appbrand.page.b.e locale = (com.tencent.mm.plugin.appbrand.page.b.e)aJi().x(com.tencent.mm.plugin.appbrand.page.b.e.class);
      if ((locale != null) && (locale.aJw()))
      {
        AppMethodBeat.o(141701);
        return true;
      }
      AppMethodBeat.o(141701);
      return false;
    }
    boolean bool = this.gRF;
    AppMethodBeat.o(141701);
    return bool;
  }
  
  public final boolean aJx()
  {
    AppMethodBeat.i(87268);
    a.b localb = com.tencent.mm.plugin.appbrand.config.a.a.s((Activity)getContext()).dQ(com.tencent.mm.plugin.appbrand.config.a.a.ayK());
    if ((localb == a.b.hkF) || (localb == a.b.hkG) || (localb == a.b.hkH) || (localb == a.b.hkI))
    {
      AppMethodBeat.o(87268);
      return true;
    }
    AppMethodBeat.o(87268);
    return false;
  }
  
  public final String aug()
  {
    return "AppBrandPageView";
  }
  
  public void b(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(87217);
    if (this.gRG == null)
    {
      com.tencent.luggage.g.d.i("MicroMsg.AppBrandPageView", "publish runtime is null, event %s", new Object[] { paramString1 });
      AppMethodBeat.o(87217);
      return;
    }
    this.gRG.ws().c(paramString1, paramString2, hashCode());
    AppMethodBeat.o(87217);
  }
  
  public void bb(boolean paramBoolean)
  {
    AppMethodBeat.i(87241);
    runOnUiThread(new v.11(this, paramBoolean));
    AppMethodBeat.o(87241);
  }
  
  public void c(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(87218);
    if (aJi() != null)
    {
      if (!aJi().b(paramString1, paramString2, paramInt)) {
        super.c(paramString1, paramString2, paramInt);
      }
      AppMethodBeat.o(87218);
      return;
    }
    super.c(paramString1, paramString2, paramInt);
    AppMethodBeat.o(87218);
  }
  
  protected void cd(String paramString) {}
  
  public final void cleanup()
  {
    AppMethodBeat.i(87220);
    super.cleanup();
    wm();
    com.tencent.mm.plugin.appbrand.jsapi.g localg = this.ive;
    localg.hwQ.clear();
    localg.hwT.clear();
    localg.hwR.clear();
    localg.hwS.clear();
    localg.hwU.clear();
    localg.hwV.clear();
    AppMethodBeat.o(87220);
  }
  
  public void dW(boolean paramBoolean)
  {
    AppMethodBeat.i(87240);
    runOnUiThread(new v.10(this, paramBoolean));
    AppMethodBeat.o(87240);
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.actionbar.b getActionBar()
  {
    return this.ixl;
  }
  
  public final View getContentView()
  {
    return this.hmw;
  }
  
  public final d getFullscreenImpl()
  {
    AppMethodBeat.i(87211);
    if (this.ixq != null)
    {
      locald = this.ixq;
      AppMethodBeat.o(87211);
      return locald;
    }
    this.ixq = new d(getContext(), new v.19(this));
    this.ixq.a(new v.20(this));
    a(new v.21(this));
    d locald = this.ixq;
    AppMethodBeat.o(87211);
    return locald;
  }
  
  public final a.d getPageConfig()
  {
    AppMethodBeat.i(87214);
    if (!isRunning())
    {
      AppMethodBeat.o(87214);
      return null;
    }
    a.d locald = getRuntime().getAppConfig().zT(this.hzM);
    AppMethodBeat.o(87214);
    return locald;
  }
  
  public i getRuntime()
  {
    return this.gRG;
  }
  
  public final String getURL()
  {
    return this.hzM;
  }
  
  protected void initActionBar()
  {
    AppMethodBeat.i(87206);
    this.ixl = ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)this.iwn.b(getContext(), com.tencent.mm.plugin.appbrand.widget.actionbar.b.class));
    this.ixl.getActionView().setId(this.ixh);
    this.ixl.setBackButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(141684);
        if (!v.this.onBackPressed()) {
          v.h(v.this).atj().aIZ();
        }
        AppMethodBeat.o(141684);
      }
    });
    this.ixl.setCloseButtonClickListener(new v.12(this));
    this.ixl.a(new v.15(this));
    this.ixl.setOptionButtonClickListener(new v.16(this));
    this.ixl.aOG();
    this.ixk = ((com.tencent.mm.plugin.appbrand.widget.actionbar.d)this.iwn.b(getContext(), com.tencent.mm.plugin.appbrand.widget.actionbar.d.class));
    this.ixk.setId(ixg);
    this.ixk.setActuallyVisible(false);
    this.ixk.setDeferStatusBarHeightChange(false);
    this.ixk.addView(this.ixl, new ViewGroup.LayoutParams(-1, -1));
    a(new v.17(this));
    a(new v.18(this));
    AppMethodBeat.o(87206);
  }
  
  public boolean isFullScreen()
  {
    return false;
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(87219);
    if ((this.ajS) && (super.isRunning()))
    {
      AppMethodBeat.o(87219);
      return true;
    }
    AppMethodBeat.o(87219);
    return false;
  }
  
  public void nM(int paramInt)
  {
    AppMethodBeat.i(87236);
    runOnUiThread(new v.6(this, paramInt));
    AppMethodBeat.o(87236);
  }
  
  public void nN(int paramInt)
  {
    AppMethodBeat.i(87239);
    runOnUiThread(new v.9(this, paramInt));
    AppMethodBeat.o(87239);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(87230);
    if (this.ixq.aIJ())
    {
      AppMethodBeat.o(87230);
      return true;
    }
    if (aJi() != null) {
      aJi();
    }
    Iterator localIterator = this.ive.hwU.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      if (!((f.a)localIterator.next()).onBackPressed()) {
        break label90;
      }
      bool = true;
    }
    label90:
    for (;;)
    {
      break;
      AppMethodBeat.o(87230);
      return bool;
    }
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(87228);
    this.fDl = false;
    if (aJi() != null) {
      aJi().vE();
    }
    aAG();
    Iterator localIterator = this.ive.hwR.iterator();
    while (localIterator.hasNext()) {
      ((f.b)localIterator.next()).onBackground();
    }
    AppMethodBeat.o(87228);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(141700);
    if (aJi() != null) {
      aJi().dispatchConfigurationChanged(paramConfiguration);
    }
    AppMethodBeat.o(141700);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(87231);
    if (aJi() != null) {
      aJi().dispatchDestroy();
    }
    aAH();
    Iterator localIterator = this.ive.hwT.iterator();
    while (localIterator.hasNext()) {
      ((f.c)localIterator.next()).onDestroy();
    }
    AppMethodBeat.o(87231);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(87226);
    this.fDl = true;
    if (aJi() != null) {
      aJi().vD();
    }
    aAF();
    Iterator localIterator = this.ive.hwS.iterator();
    while (localIterator.hasNext()) {
      ((f.d)localIterator.next()).onForeground();
    }
    AppMethodBeat.o(87226);
  }
  
  public final void onReady()
  {
    AppMethodBeat.i(87224);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(141685);
        if (v.this.aJi() != null) {
          v.this.aJi().vG();
        }
        v.this.aAE();
        Iterator localIterator = v.this.ive.hwQ.iterator();
        while (localIterator.hasNext()) {
          ((f.e)localIterator.next()).onReady();
        }
        AppMethodBeat.o(141685);
      }
    });
    AppMethodBeat.o(87224);
  }
  
  final void pb(int paramInt)
  {
    AppMethodBeat.i(87212);
    if (this.ixu)
    {
      AppMethodBeat.o(87212);
      return;
    }
    if ((this.ixk.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.ixk.getLayoutParams();
      if (localMarginLayoutParams.bottomMargin != paramInt)
      {
        localMarginLayoutParams.bottomMargin = paramInt;
        this.ixk.setLayoutParams(localMarginLayoutParams);
      }
    }
    AppMethodBeat.o(87212);
  }
  
  public final q pc(int paramInt)
  {
    AppMethodBeat.i(87249);
    Iterator localIterator = this.iwd.iterator();
    while (localIterator.hasNext())
    {
      q localq = (q)localIterator.next();
      if ((localq != null) && (localq.id == paramInt))
      {
        AppMethodBeat.o(87249);
        return localq;
      }
    }
    AppMethodBeat.o(87249);
    return null;
  }
  
  public final void t(double paramDouble)
  {
    AppMethodBeat.i(87235);
    runOnUiThread(new v.5(this, paramDouble));
    AppMethodBeat.o(87235);
  }
  
  public final af vC()
  {
    return this.ixm;
  }
  
  public final Map<String, m> wC()
  {
    AppMethodBeat.i(87203);
    if (aJi() != null)
    {
      localMap = aJi().vF();
      AppMethodBeat.o(87203);
      return localMap;
    }
    Map localMap = Collections.emptyMap();
    AppMethodBeat.o(87203);
    return localMap;
  }
  
  public final JSONObject wE()
  {
    AppMethodBeat.i(87267);
    JSONObject localJSONObject = getRuntime().ws().wE();
    AppMethodBeat.o(87267);
    return localJSONObject;
  }
  
  public View wl()
  {
    AppMethodBeat.i(87261);
    if (!TextUtils.isEmpty(this.ixp))
    {
      View localView = LayoutInflater.from(this.mContext).inflate(2130968764, null);
      ((TextView)localView.findViewById(2131821508)).setText(this.ixp);
      AppMethodBeat.o(87261);
      return localView;
    }
    AppMethodBeat.o(87261);
    return null;
  }
  
  protected void wm()
  {
    AppMethodBeat.i(87221);
    this.iuy.destroy();
    this.ixm.removeAll();
    com.tencent.mm.plugin.appbrand.widget.actionbar.b localb = this.ixl;
    localb.removeAllViews();
    localb.getCapsuleBar().destroy();
    this.hmw.removeAllViews();
    AppMethodBeat.o(87221);
  }
  
  public void wr()
  {
    AppMethodBeat.i(87255);
    aJv();
    AppMethodBeat.o(87255);
  }
  
  public com.tencent.mm.plugin.appbrand.r ws()
  {
    AppMethodBeat.i(87204);
    com.tencent.mm.plugin.appbrand.r localr = getRuntime().ws();
    AppMethodBeat.o(87204);
    return localr;
  }
  
  public final <T> T x(Class<T> paramClass)
  {
    AppMethodBeat.i(141702);
    if (aJi() != null)
    {
      paramClass = aJi().x(paramClass);
      AppMethodBeat.o(141702);
      return paramClass;
    }
    AppMethodBeat.o(141702);
    return null;
  }
  
  public final void x(CharSequence paramCharSequence)
  {
    this.ixp = paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.v
 * JD-Core Version:    0.7.0.1
 */