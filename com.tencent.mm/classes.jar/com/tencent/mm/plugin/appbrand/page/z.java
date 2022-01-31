package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.luggage.sdk.b.a.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.a.d;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.menu.WxaMenuHelper;
import com.tencent.mm.plugin.appbrand.menu.r;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.d.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.sdk.platformtools.f;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public class z
  extends com.tencent.luggage.sdk.b.a.c
{
  private com.tencent.mm.plugin.appbrand.o gQn;
  private List<com.tencent.mm.plugin.appbrand.menu.q> iwd;
  protected com.tencent.mm.plugin.appbrand.widget.actionbar.g ixD;
  private AppBrandRecentView ixE;
  public final com.tencent.mm.plugin.appbrand.report.model.b ixF;
  
  public z()
  {
    this(y.class);
    AppMethodBeat.i(132398);
    AppMethodBeat.o(132398);
  }
  
  public z(Class<? extends x> paramClass)
  {
    super(paramClass);
    AppMethodBeat.i(143506);
    this.ixF = new com.tencent.mm.plugin.appbrand.report.model.b(hashCode());
    if ((bp.dud()) || (f.IS_FLAVOR_RED)) {}
    for (boolean bool = true;; bool = false)
    {
      this.gPS = bool;
      AppMethodBeat.o(143506);
      return;
    }
  }
  
  public final boolean Em(String paramString)
  {
    AppMethodBeat.i(132412);
    com.tencent.mm.plugin.appbrand.report.model.b localb = this.ixF;
    localb.iGC = bo.aoy();
    localb.iGB = paramString;
    ap(getRuntime().atV());
    boolean bool = super.Em(paramString);
    AppMethodBeat.o(132412);
    return bool;
  }
  
  public void a(Context paramContext, i parami)
  {
    AppMethodBeat.i(132399);
    this.gQn = ((com.tencent.mm.plugin.appbrand.o)parami);
    super.a(paramContext, parami);
    paramContext = this.ixF;
    paramContext.mAppId = parami.mAppId;
    paramContext.iGA.start();
    aHI();
    getActionBar().setCloseButtonClickListener(new z.1(this));
    if ((parami.gPS) && (((com.tencent.mm.plugin.appbrand.o)parami).atM())) {
      getActionBar().setNavButtonLongClickListener(new z.2(this));
    }
    this.hwJ = new com.tencent.mm.plugin.appbrand.permission.a((com.tencent.mm.plugin.appbrand.o)parami, this);
    this.hmw.addOnAttachStateChangeListener(new z.3(this));
    AppMethodBeat.o(132399);
  }
  
  protected void aAE()
  {
    AppMethodBeat.i(132413);
    super.aAE();
    this.ixF.aLf();
    AppMethodBeat.o(132413);
  }
  
  protected void aAF()
  {
    AppMethodBeat.i(132414);
    ap(getRuntime().atV());
    super.aAF();
    this.ixF.onForeground();
    AppMethodBeat.o(132414);
  }
  
  protected void aAG()
  {
    AppMethodBeat.i(132415);
    super.aAG();
    if (this.ixD != null) {
      this.ixD.dismiss();
    }
    this.ixF.onBackground();
    AppMethodBeat.o(132415);
  }
  
  protected void aAH()
  {
    AppMethodBeat.i(132417);
    super.aAH();
    Object localObject = this.ixF;
    ((com.tencent.mm.plugin.appbrand.report.model.b)localObject).iGA.aLd();
    localObject = ((com.tencent.mm.plugin.appbrand.report.model.b)localObject).iGA;
    ((com.tencent.mm.plugin.appbrand.report.o)localObject).quit();
    ((com.tencent.mm.plugin.appbrand.report.o)localObject).mStopped = true;
    AppMethodBeat.o(132417);
  }
  
  protected void aHI()
  {
    AppMethodBeat.i(132407);
    com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.widget.recentview.d.class);
    if (getRuntime().atM())
    {
      AppMethodBeat.o(132407);
      return;
    }
    try
    {
      this.ixE = ((com.tencent.mm.plugin.appbrand.widget.recentview.d)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.widget.recentview.d.class)).a(getContext(), d.b.jvK, new z.4(this));
      if (this.ixE == null)
      {
        AppMethodBeat.o(132407);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.AppBrandPageViewWC", localException, "appId[%s]", new Object[] { getAppId() });
      }
      this.ixD = new com.tencent.mm.plugin.appbrand.widget.actionbar.g(getContext());
      this.ixD.setWidth(-1);
      this.ixD.setBackgroundDrawable(new ColorDrawable());
      this.ixE.refresh();
      this.ixD.setHeight(this.ixE.getLayoutParams().height);
      this.ixE.setBackground(com.tencent.mm.cb.a.k(getContext(), 2130837743));
      this.ixD.setContentView(this.ixE);
      this.ixE.setOnItemClickListener(new z.5(this));
      getActionBar().setCapsuleHomeButtonLongClickListener(new z.6(this));
      AppMethodBeat.o(132407);
    }
  }
  
  protected final void aJ(List<com.tencent.mm.plugin.appbrand.menu.q> paramList)
  {
    AppMethodBeat.i(143509);
    new q(this, paramList).aIX();
    AppMethodBeat.o(143509);
  }
  
  public final void aJA()
  {
    AppMethodBeat.i(132424);
    if ((this.iwd == null) || (this.iwd.size() <= 0))
    {
      ab.w("MicroMsg.AppBrandPageViewWC", "showPageActionSheet appId[%s], url[%s], empty list skip", new Object[] { getAppId(), this.hzM });
      AppMethodBeat.o(132424);
      return;
    }
    aJ(this.iwd);
    AppMethodBeat.o(132424);
  }
  
  protected final List<com.tencent.mm.plugin.appbrand.menu.q> aJm()
  {
    boolean bool2 = true;
    AppMethodBeat.i(132411);
    Object localObject = getAppId();
    LinkedList localLinkedList = new LinkedList();
    if ("wxfe02ecfe70800f46".equalsIgnoreCase((String)localObject))
    {
      WxaMenuHelper.c(localLinkedList, r.iqS.ordinal(), false);
      this.iwd = localLinkedList;
      AppMethodBeat.o(132411);
      return localLinkedList;
    }
    WxaMenuHelper.c(localLinkedList, r.iqQ.ordinal(), false);
    WxaMenuHelper.c(localLinkedList, r.iqR.ordinal(), false);
    WxaMenuHelper.c(localLinkedList, r.iqS.ordinal(), true);
    WxaMenuHelper.c(localLinkedList, r.iqZ.ordinal(), false);
    localObject = com.tencent.mm.plugin.appbrand.a.xM((String)localObject);
    if (!com.tencent.mm.sdk.a.b.dsf())
    {
      bool1 = bool2;
      if (localObject != null) {
        if (((h)localObject).hiX.gXe != 1) {
          break label270;
        }
      }
    }
    label270:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      WxaMenuHelper.c(localLinkedList, r.ira.ordinal(), bool1);
      WxaMenuHelper.c(localLinkedList, r.irb.ordinal(), false);
      WxaMenuHelper.c(localLinkedList, r.irc.ordinal(), false);
      WxaMenuHelper.c(localLinkedList, r.iri.ordinal(), false);
      WxaMenuHelper.c(localLinkedList, r.irj.ordinal(), false);
      WxaMenuHelper.c(localLinkedList, r.iqU.ordinal(), false);
      WxaMenuHelper.c(localLinkedList, r.iqW.ordinal(), false);
      WxaMenuHelper.c(localLinkedList, r.irf.ordinal(), false);
      WxaMenuHelper.c(localLinkedList, r.iqV.ordinal(), false);
      WxaMenuHelper.c(localLinkedList, r.iqX.ordinal(), false);
      WxaMenuHelper.c(localLinkedList, r.ire.ordinal(), false);
      WxaMenuHelper.c(localLinkedList, r.iqY.ordinal(), false);
      break;
    }
  }
  
  public final void aJo()
  {
    AppMethodBeat.i(132408);
    super.aJo();
    Object localObject = getPageConfig();
    boolean bool2 = getRuntime().wO().a(this, new c.a());
    boolean bool1;
    if ((!((a.d)localObject).hhr) || (!bool2))
    {
      bool1 = true;
      super.bb(bool1);
      if ((bool2) && (((a.d)localObject).hhr) && (getRuntime().atS().bCV == 7) && (!getActionBar().isFullscreenMode())) {
        break label192;
      }
      ab.i("MicroMsg.AppBrandPageViewWC", "hasPermission:" + bool2 + " navigationBarRightButtonHide:" + ((a.d)localObject).hhr + " appServiceType:" + getRuntime().atS().bCV + " isFullscreenMode:" + getActionBar().isFullscreenMode());
    }
    for (;;)
    {
      if (com.tencent.mm.plugin.appbrand.weishi.g.J(getRuntime())) {
        runOnUiThread(new z.9(this));
      }
      AppMethodBeat.o(132408);
      return;
      bool1 = false;
      break;
      label192:
      localObject = new com.tencent.mm.plugin.appbrand.widget.i.b(((a.d)localObject).hhq, new z.7(this));
      ((com.tencent.mm.plugin.appbrand.widget.i.b)localObject).a(new com.tencent.mm.plugin.appbrand.widget.i.e()
      {
        public final void a(Bitmap paramAnonymousBitmap, com.tencent.mm.plugin.appbrand.widget.i.d paramAnonymousd)
        {
          AppMethodBeat.i(143503);
          super.a(paramAnonymousBitmap, paramAnonymousd);
          z.this.getActionBar().a(paramAnonymousBitmap, new z.8.1(this));
          AppMethodBeat.o(143503);
        }
      });
      ((com.tencent.mm.plugin.appbrand.widget.i.b)localObject).aSq();
    }
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.u.a aJz()
  {
    AppMethodBeat.i(132410);
    Object localObject = this.hmw.findViewById(2131820570);
    if ((localObject instanceof com.tencent.mm.plugin.appbrand.jsapi.u.a))
    {
      localObject = (com.tencent.mm.plugin.appbrand.jsapi.u.a)localObject;
      AppMethodBeat.o(132410);
      return localObject;
    }
    AppMethodBeat.o(132410);
    return null;
  }
  
  public final void ap(Context paramContext)
  {
    AppMethodBeat.i(143507);
    this.iuy.ap(paramContext);
    this.ixk.ap(paramContext);
    AppMethodBeat.o(143507);
  }
  
  public final com.tencent.mm.plugin.appbrand.service.c atU()
  {
    AppMethodBeat.i(143508);
    com.tencent.mm.plugin.appbrand.service.c localc = (com.tencent.mm.plugin.appbrand.service.c)super.wk();
    AppMethodBeat.o(143508);
    return localc;
  }
  
  public final void e(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(132432);
    super.e(paramJSONObject);
    b(paramJSONObject, "clientVersion", Integer.valueOf(com.tencent.mm.protocal.d.whH));
    com.tencent.mm.plugin.appbrand.f.a.a(com.tencent.mm.plugin.appbrand.w.b.aSv(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.f.a.d(com.tencent.mm.plugin.appbrand.w.b.aSy(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.f.a.b(com.tencent.mm.plugin.appbrand.w.b.aSx(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.f.a.e(com.tencent.mm.plugin.appbrand.w.b.aSA(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.f.a.c(com.tencent.mm.plugin.appbrand.w.b.aSw(), paramJSONObject);
    AppMethodBeat.o(132432);
  }
  
  public com.tencent.mm.plugin.appbrand.o getRuntime()
  {
    AppMethodBeat.i(132404);
    com.tencent.mm.plugin.appbrand.o localo = (com.tencent.mm.plugin.appbrand.o)super.wj();
    AppMethodBeat.o(132404);
    return localo;
  }
  
  public void wm()
  {
    AppMethodBeat.i(132406);
    super.wm();
    if (this.ixE != null) {
      this.ixE.release();
    }
    if (this.ixD != null)
    {
      com.tencent.mm.plugin.appbrand.widget.actionbar.g localg = this.ixD;
      localg.dismiss();
      if (localg.jbL != null)
      {
        localg.jbL.removeAllViews();
        localg.jbL = null;
      }
    }
    AppMethodBeat.o(132406);
  }
  
  public final void wr()
  {
    AppMethodBeat.i(132420);
    if (getRuntime().atM()) {
      super.aJv();
    }
    for (;;)
    {
      if (com.tencent.mm.plugin.appbrand.weishi.g.J(this.gQn)) {
        getActionBar().aOM();
      }
      AppMethodBeat.o(132420);
      return;
      super.wr();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.z
 * JD-Core Version:    0.7.0.1
 */