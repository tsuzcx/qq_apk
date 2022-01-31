package com.tencent.mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ce;
import com.tencent.mm.g.b.a.ce.a;
import com.tencent.mm.plugin.appbrand.ReportStorageSizeTask;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.f.e;
import com.tencent.mm.plugin.appbrand.jsapi.v.d.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandRecommendStatObj;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.model.f;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

@SuppressLint({"ViewConstructor"})
public class s
  extends r
  implements r.a
{
  private ImageView iwH;
  private volatile f iwI;
  private g iwJ;
  public boolean iwK;
  public boolean iwL;
  private long iwM;
  private long iwN;
  private long iwO;
  private String iwP;
  private com.tencent.mm.sdk.b.c<d> iwQ;
  private long iwR;
  public boolean iwS;
  
  public s(Context paramContext, com.tencent.mm.plugin.appbrand.i parami, r.a parama)
  {
    super(paramContext, parami);
    AppMethodBeat.i(143477);
    this.iwK = false;
    this.iwL = false;
    this.iwI = aHC();
    this.iwQ = new com.tencent.mm.sdk.b.c() {};
    this.iwR = 0L;
    this.iwS = false;
    super.setDelegate(parama);
    AppMethodBeat.o(143477);
  }
  
  public s(Context paramContext, com.tencent.mm.plugin.appbrand.o paramo)
  {
    super(paramContext, paramo);
    AppMethodBeat.i(132351);
    this.iwK = false;
    this.iwL = false;
    this.iwI = aHC();
    this.iwQ = new com.tencent.mm.sdk.b.c() {};
    this.iwR = 0L;
    this.iwS = false;
    super.setDelegate(this);
    AppMethodBeat.o(132351);
  }
  
  private void a(String paramString, bf parambf, r.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(132357);
    h localh = h.qsU;
    if (paramBoolean) {}
    for (int i = 5;; i = 1)
    {
      localh.cT(937, i);
      getRuntime().gPM.a(paramString, true, new s.8(this, paramBoolean, paramb, paramString, parambf));
      AppMethodBeat.o(132357);
      return;
    }
  }
  
  private void aJg()
  {
    AppMethodBeat.i(132371);
    AppBrandRecommendStatObj localAppBrandRecommendStatObj;
    if ((getCurrentPage() != null) && (getCurrentPage().getCurrentPageView() != null) && (getRuntime().wS().bDh.scene == 1118))
    {
      if (getRuntime().wS().bDh != null) {
        break label138;
      }
      localAppBrandRecommendStatObj = null;
      if (localAppBrandRecommendStatObj != null)
      {
        ab.i("MicroMsg.AppBrandPageContainerWC", "recommendStatObj is got");
        if ((TextUtils.isEmpty(localAppBrandRecommendStatObj.iFJ)) || (TextUtils.isEmpty(localAppBrandRecommendStatObj.iFK))) {
          break label155;
        }
        this.iwP = (localAppBrandRecommendStatObj.iFJ + "?" + localAppBrandRecommendStatObj.iFK);
      }
    }
    for (;;)
    {
      this.iwK = true;
      this.iwN = System.currentTimeMillis();
      AppMethodBeat.o(132371);
      return;
      label138:
      localAppBrandRecommendStatObj = getRuntime().wS().bDh.iFY;
      break;
      label155:
      if (!TextUtils.isEmpty(localAppBrandRecommendStatObj.iFJ)) {
        this.iwP = localAppBrandRecommendStatObj.iFJ;
      } else {
        this.iwP = getRuntime().ato();
      }
    }
  }
  
  private void eB(boolean paramBoolean)
  {
    AppMethodBeat.i(154344);
    s.5 local5;
    if (this.iwH != null)
    {
      ImageView localImageView = this.iwH;
      local5 = new s.5(this, localImageView);
      if (!paramBoolean) {
        break label67;
      }
      localImageView.animate().alpha(0.0F).setInterpolator(new android.support.v4.view.b.a()).withEndAction(local5).start();
    }
    for (;;)
    {
      this.iwH = null;
      AppMethodBeat.o(154344);
      return;
      label67:
      local5.run();
    }
  }
  
  public final void Eg(String paramString)
  {
    AppMethodBeat.i(132354);
    super.Eg(paramString);
    if (getRuntime().atR().bDj) {
      al.p(new s.6(this), 10000L);
    }
    try
    {
      com.tencent.mm.plugin.appbrand.report.quality.a.aLt();
      a.f.b.j.q(this, "pagecontainer");
      if ((getRuntime() instanceof com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.j)) {
        break label305;
      }
      localce = new ce();
      localQualitySessionRuntime = com.tencent.mm.plugin.appbrand.report.quality.a.EM(getAppId());
      if (localQualitySessionRuntime == null) {
        break label413;
      }
      if (localQualitySessionRuntime.iIR <= 0L) {
        break label438;
      }
      localce.hg(localQualitySessionRuntime.ikX);
      localce.hh(localQualitySessionRuntime.appId);
      localce.cZB = localQualitySessionRuntime.iIG;
      localce.daG = ce.a.gR(localQualitySessionRuntime.iIF);
      localce.cZD = localQualitySessionRuntime.apptype;
      localce.cRG = localQualitySessionRuntime.scene;
      localce.eI(localQualitySessionRuntime.iIR);
      localce.eJ(bo.aoy());
      localce.eH(localce.dav - localce.dau);
      paramString = getCurrentPage();
      if (paramString == null) {
        break label341;
      }
      paramString = paramString.getCurrentPageView();
      String str = paramString;
      if (!(paramString instanceof z)) {
        str = null;
      }
      paramString = (z)str;
      if (paramString == null) {
        break label449;
      }
      if (!(paramString.iuy instanceof ad)) {
        break label346;
      }
      paramString = (ad)paramString.iuy;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        ce localce;
        QualitySessionRuntime localQualitySessionRuntime;
        label252:
        int i;
        label265:
        ab.w("MicroMsg.AppBrandPageContainerWC", "pagecontainerInitReport %s", new Object[] { paramString });
        continue;
        paramString = localQualitySessionRuntime;
        continue;
        paramString = null;
        continue;
        paramString = null;
      }
    }
    if (paramString != null) {
      if (paramString.isSysKernel())
      {
        i = 4;
        localce.cYC = i;
        localce.ake();
        break label438;
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.report.quality.c.a(paramString, "Null session with " + getAppId());
      label305:
      aJg();
      if ((com.tencent.mm.plugin.appbrand.weishi.g.J(getRuntime())) && (this.iwQ != null)) {
        this.iwQ.alive();
      }
      AppMethodBeat.o(132354);
      return;
      label341:
      paramString = null;
      break;
      label346:
      if (!(paramString.iuy instanceof ak)) {
        break label444;
      }
      paramString = ((ak)paramString.iuy).iuy;
      if (!(paramString instanceof ad)) {
        break label444;
      }
      paramString = (ad)paramString;
      break label252;
      if (paramString.getIsX5Kernel())
      {
        i = 2;
        break label265;
      }
      boolean bool = paramString.isXWalkKernel();
      if (bool)
      {
        i = 3;
        break label265;
      }
      i = -1;
      break label265;
      label413:
      paramString = null;
    }
  }
  
  public final o a(r paramr)
  {
    return null;
  }
  
  protected final void a(o paramo1, o paramo2)
  {
    AppMethodBeat.i(132358);
    super.a(paramo1, paramo2);
    this.iwI.aHD();
    this.iwI.a((z)paramo2.getCurrentPageView(), (z)paramo1.getCurrentPageView(), bf.izS);
    post(new s.9(this));
    AppMethodBeat.o(132358);
  }
  
  public final void a(o paramo1, o paramo2, bf parambf)
  {
    Object localObject = null;
    AppMethodBeat.i(132360);
    super.a(paramo1, paramo2, parambf);
    long l = System.currentTimeMillis() - this.iwR;
    this.iwI.a(l, parambf);
    ab.i("MicroMsg.AppBrandPageContainerWC", "onReady received, time: %d", new Object[] { Long.valueOf(l) });
    if (this.iwJ != null)
    {
      this.iwJ.aIM();
      this.iwJ = null;
    }
    f localf = this.iwI;
    z localz = (z)paramo2.getCurrentPageView();
    if (paramo1 == null)
    {
      paramo2 = localObject;
      localf.a(localz, paramo2, parambf);
      if ((bf.izW != parambf) && (bf.izR != parambf)) {
        post(new s.10(this, parambf));
      }
      if ((paramo1 != null) && (parambf == bf.izR) && (getRuntime().wS().bDh.scene == 1118) && (this.iwK) && (!this.iwL)) {
        if (paramo1.getCurrentPageView() != null) {
          break label259;
        }
      }
    }
    label259:
    for (paramo2 = "";; paramo2 = paramo1.getCurrentPageView().iuB)
    {
      if ((this.iwP != null) && (this.iwP.equals(paramo2)))
      {
        ab.i("MicroMsg.AppBrandPageContainerWC", "statPageTime");
        this.iwM = ((z)paramo1.getCurrentPageView()).ixF.aLg();
        this.iwL = true;
      }
      AppMethodBeat.o(132360);
      return;
      paramo2 = (z)paramo1.getCurrentPageView();
      break;
    }
  }
  
  public final void a(o paramo1, o paramo2, bf parambf, String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(132359);
    super.a(paramo1, paramo2, parambf, paramString);
    this.iwR = System.currentTimeMillis();
    if (bf.izV == parambf)
    {
      paramo1 = paramo2.getCurrentPageView();
      eB(false);
      if (!com.tencent.mm.plugin.appbrand.weishi.g.J(getRuntime())) {}
    }
    try
    {
      paramo2 = paramo1.ivI;
      this.iwH = new ImageView(getContext());
      this.iwH.setBackgroundColor(-16777216);
      paramo2.addView(this.iwH, -1, new FrameLayout.LayoutParams(-1, -1));
      com.tencent.mm.plugin.appbrand.weishi.b.a(getRuntime(), this.iwH, new s.3(this));
      paramo1.a(new f.e()
      {
        public final void onReady()
        {
          AppMethodBeat.i(155933);
          s.a(s.this);
          AppMethodBeat.o(155933);
        }
      });
      if (!getRuntime().vY()) {
        if ((parambf == bf.izV) || (parambf == bf.izQ))
        {
          if (!paramString.startsWith(getRuntime().getAppConfig().ayn())) {
            bool = true;
          }
          this.iwS = bool;
          AppMethodBeat.o(132359);
          return;
        }
      }
    }
    catch (NullPointerException paramo1)
    {
      for (;;)
      {
        eB(false);
      }
      if ((parambf == bf.izU) && (paramString.startsWith(getRuntime().getAppConfig().ayn()))) {
        this.iwS = false;
      }
      AppMethodBeat.o(132359);
    }
  }
  
  public final boolean a(String paramString, bf parambf, r paramr, r.b paramb)
  {
    AppMethodBeat.i(143478);
    paramr = getRuntime().gPM;
    if (!paramr.aIe()) {
      paramr.a(paramString, false, new s.7(this, paramb));
    }
    for (;;)
    {
      AppMethodBeat.o(143478);
      return true;
      a(paramString, parambf, paramb, false);
    }
  }
  
  protected f aHC()
  {
    AppMethodBeat.i(132352);
    com.tencent.mm.plugin.appbrand.report.model.a locala = new com.tencent.mm.plugin.appbrand.report.model.a(getRuntime());
    AppMethodBeat.o(132352);
    return locala;
  }
  
  public final Object f(o paramo)
  {
    AppMethodBeat.i(132367);
    paramo = AnimationUtils.loadAnimation(getContext(), 2131034266);
    AppMethodBeat.o(132367);
    return paramo;
  }
  
  public final Object g(o paramo)
  {
    AppMethodBeat.i(132368);
    paramo = AnimationUtils.loadAnimation(getContext(), 2131034263);
    AppMethodBeat.o(132368);
    return paramo;
  }
  
  public f getReporter()
  {
    return this.iwI;
  }
  
  public com.tencent.mm.plugin.appbrand.o getRuntime()
  {
    AppMethodBeat.i(132353);
    com.tencent.mm.plugin.appbrand.o localo = (com.tencent.mm.plugin.appbrand.o)super.getRuntime();
    AppMethodBeat.o(132353);
    return localo;
  }
  
  public final Object h(o paramo)
  {
    AppMethodBeat.i(132369);
    paramo = AnimationUtils.loadAnimation(getContext(), 2131034262);
    AppMethodBeat.o(132369);
    return paramo;
  }
  
  public final Object i(o paramo)
  {
    AppMethodBeat.i(132370);
    paramo = AnimationUtils.loadAnimation(getContext(), 2131034267);
    AppMethodBeat.o(132370);
    return paramo;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(132355);
    if (this.iwJ != null)
    {
      this.iwJ.dismiss();
      this.iwJ = null;
      AppMethodBeat.o(132355);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(132355);
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(132364);
    super.onBackground();
    if (getPageCount() > 0) {
      this.iwI.b((z)getCurrentPage().getCurrentPageView());
    }
    Object localObject;
    if ((getCurrentPage() != null) && (getCurrentPage().getCurrentPageView() != null) && (getRuntime().wS().bDh.scene == 1118)) {
      if ((this.iwK) && (!this.iwL))
      {
        localObject = getCurrentPage().getCurrentPageView().iuB;
        if ((this.iwP != null) && (this.iwP.equals(localObject)))
        {
          ab.i("MicroMsg.AppBrandPageContainerWC", "statPageTime onBackground");
          localObject = ((z)getCurrentPage().getCurrentPageView()).ixF;
          if (localObject != null) {
            break label256;
          }
        }
      }
    }
    label256:
    for (long l = 0L;; l = ((com.tencent.mm.plugin.appbrand.report.model.b)localObject).aLg())
    {
      this.iwM = l;
      this.iwL = true;
      this.iwO = (System.currentTimeMillis() - this.iwN);
      if ((this.iwK) && (this.iwL) && (getRuntime().wS().bDh != null))
      {
        ab.i("MicroMsg.AppBrandPageContainerWC", "report pageStayTime:%d, appStayTime:%d", new Object[] { Long.valueOf(this.iwM), Long.valueOf(this.iwO) });
        com.tencent.mm.plugin.appbrand.appusage.a.i.b(1, this.iwM, this.iwO, getRuntime().wS().bDh.iFY);
      }
      AppMethodBeat.o(132364);
      return;
    }
  }
  
  protected final void onDestroy()
  {
    AppMethodBeat.i(132362);
    super.onDestroy();
    if (getPageCount() > 0) {
      this.iwI.a((z)getCurrentPage().getCurrentPageView());
    }
    if (this.iwJ != null)
    {
      this.iwJ.cleanup();
      this.iwJ = null;
    }
    if (this.iwQ != null) {
      this.iwQ.dead();
    }
    AppMethodBeat.o(132362);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(132363);
    super.onForeground();
    if (getPageCount() > 0) {
      this.iwI.c((z)getCurrentPage().getCurrentPageView());
    }
    aJg();
    AppMethodBeat.o(132363);
  }
  
  protected final void onReady()
  {
    AppMethodBeat.i(132361);
    super.onReady();
    ReportStorageSizeTask localReportStorageSizeTask = new ReportStorageSizeTask();
    localReportStorageSizeTask.appId = getRuntime().mAppId;
    AppBrandMainProcessService.a(localReportStorageSizeTask);
    AppMethodBeat.o(132361);
  }
  
  public void onViewAdded(View paramView)
  {
    AppMethodBeat.i(143479);
    super.onViewAdded(paramView);
    if ((paramView instanceof o)) {
      bi.cv((o)paramView);
    }
    AppMethodBeat.o(143479);
  }
  
  public v vw()
  {
    AppMethodBeat.i(143480);
    Object localObject = null;
    if ((getRuntime().getAppConfig().hgR) || (!e.aLN())) {
      localObject = e.EP(getAppId());
    }
    if (localObject != null)
    {
      AppMethodBeat.o(143480);
      return localObject;
    }
    localObject = new z();
    AppMethodBeat.o(143480);
    return localObject;
  }
  
  public final boolean vx()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.s
 * JD-Core Version:    0.7.0.1
 */