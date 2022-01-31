package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.luggage.sdk.b.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.q;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.b.f;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.performance.c;
import com.tencent.mm.plugin.appbrand.report.e;
import com.tencent.mm.plugin.appbrand.report.quality.b;
import com.tencent.mm.plugin.appbrand.weishi.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class y
  extends av<z>
{
  private long ixA;
  private long ixB;
  private long ixz;
  
  public y(z paramz)
  {
    super(paramz);
  }
  
  public final void Ed(String paramString)
  {
    AppMethodBeat.i(143491);
    super.Ed(paramString);
    e.bq(getAppId(), 27);
    AppMethodBeat.o(143491);
  }
  
  public final void a(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(143493);
    if (TextUtils.isEmpty(paramString1))
    {
      AppMethodBeat.o(143493);
      return;
    }
    if (!paramBoolean) {
      ab.e("MicroMsg.AppBrandPageViewRendererWC", "onScriptInjectResult !succeed appID = %s, name = %s", new Object[] { getAppId(), paramString1 });
    }
    int i = -1;
    switch (paramString1.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(143493);
        return;
        if (paramString1.equals("WAWebview.js"))
        {
          i = 0;
          continue;
          if (paramString1.equals("WAVConsole.js")) {
            i = 1;
          }
        }
        break;
      }
    }
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(370L, 1L, 1L, false);
    if (paramBoolean)
    {
      if ((aJP()) || (isRunning()))
      {
        com.tencent.mm.plugin.appbrand.report.quality.a.aLt();
        b.a(aJP(), getAppId(), paramLong1, paramString1, bo.nullAsNil(paramString2).length());
      }
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(370L, 3L, 1L, false);
      AppMethodBeat.o(143493);
      return;
    }
    ab.e("MicroMsg.AppBrandPageViewRendererWC", "Inject SDK Page Script Failed   appId = %s", new Object[] { getAppId() });
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(370L, 2L, 1L, false);
    e.bq(getAppId(), 24);
    int j = 0;
    paramString1 = ((z)this.bDN).getRuntime();
    if (paramString1 != null) {
      j = paramString1.atR().hiX.gXf;
    }
    for (i = paramString1.atR().hiX.gXe;; i = -1)
    {
      e.b(getAppId(), j, i, 370, 2);
      AppMethodBeat.o(143493);
      return;
      if ((!aJP()) && (!isRunning())) {
        break;
      }
      com.tencent.mm.plugin.appbrand.report.quality.a.aLt();
      b.a(aJP(), getAppId(), paramLong1, paramString1, bo.nullAsNil(paramString2).length());
      break;
    }
  }
  
  protected final boolean aIE()
  {
    AppMethodBeat.i(154348);
    if ("wxfe02ecfe70800f46".equalsIgnoreCase(getAppId()))
    {
      AppMethodBeat.o(154348);
      return false;
    }
    boolean bool = super.aIE();
    AppMethodBeat.o(154348);
    return bool;
  }
  
  public final boolean bX(String paramString)
  {
    AppMethodBeat.i(143490);
    this.ixB = System.currentTimeMillis();
    aJN().J(new y.3(this));
    if (((o)super.wj()).gRj) {
      ((z)this.bDN).hmw.setContentDescription(com.tencent.luggage.g.h.cg(paramString));
    }
    aJN().ap(((z)this.bDN).getContext());
    boolean bool = super.bX(paramString);
    AppMethodBeat.o(143490);
    return bool;
  }
  
  public final aq cY(Context paramContext)
  {
    AppMethodBeat.i(143488);
    this.ixz = bo.yB();
    paramContext = new ad(paramContext, (byte)0);
    AppMethodBeat.o(143488);
    return paramContext;
  }
  
  public final void ce(View paramView)
  {
    AppMethodBeat.i(143485);
    super.ce(paramView);
    if ((aJN() instanceof ak)) {}
    for (paramView = ((ak)aJN()).iuy;; paramView = aJN())
    {
      if ((paramView instanceof MMWebView)) {
        ((MMWebView)paramView).getIsX5Kernel();
      }
      ((z)this.bDN).getFullscreenImpl().a(new y.1(this));
      AppMethodBeat.o(143485);
      return;
    }
  }
  
  public final void dispatchStart()
  {
    AppMethodBeat.i(143489);
    super.dispatchStart();
    ap localap;
    if ((this.iuy instanceof ak))
    {
      localap = ((ak)this.iuy).iuy;
      if ((!(localap instanceof MMWebView)) || (!((MMWebView)localap).getIsX5Kernel())) {
        break label137;
      }
    }
    label137:
    for (boolean bool = true;; bool = false)
    {
      n.yd(getAppId()).gQX.set(bool);
      e.eL(bool);
      aJN().J(new y.2(this));
      if (g.J(((z)this.bDN).getRuntime())) {
        super.b(f.class, new com.tencent.mm.plugin.appbrand.weishi.d((v)this.bDN));
      }
      AppMethodBeat.o(143489);
      return;
      localap = this.iuy;
      break;
    }
  }
  
  public final o getRuntime()
  {
    AppMethodBeat.i(143486);
    o localo = (o)super.wj();
    AppMethodBeat.o(143486);
    return localo;
  }
  
  public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.m> vF()
  {
    AppMethodBeat.i(143487);
    Map localMap = q.aBy();
    AppMethodBeat.o(143487);
    return localMap;
  }
  
  public final void vG()
  {
    AppMethodBeat.i(143492);
    super.vG();
    ((o)super.wj()).gRn.C(4, bo.av(this.ixA));
    AppBrandPerformanceManager.a((o)super.wj(), 203, System.currentTimeMillis() - this.ixB);
    c.a(getAppId(), "Native", "PageLoad", this.ixB, System.currentTimeMillis(), "");
    AppMethodBeat.o(143492);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.y
 * JD-Core Version:    0.7.0.1
 */