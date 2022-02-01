package com.tencent.mm.plugin.appbrand.report.model;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.page.cb;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.LinkedList;

public final class b
  implements h
{
  private final String mAppId;
  private final w qts;
  private Intent tOX;
  private boolean tOY;
  private boolean tOZ;
  private n tPa;
  private p tPb;
  private s tPc;
  private t tPd;
  private volatile j tPe;
  private boolean tuT;
  
  public b(w paramw)
  {
    AppMethodBeat.i(48085);
    this.tuT = false;
    this.tOY = false;
    this.tOZ = false;
    this.tPa = null;
    this.tPb = null;
    this.tPc = null;
    this.tPd = null;
    this.tPe = null;
    this.mAppId = paramw.mAppId;
    this.qts = paramw;
    this.tPd = t.R(this.qts);
    aqI();
    AppMethodBeat.o(48085);
  }
  
  private void a(ah paramah1, ah paramah2)
  {
    AppMethodBeat.i(48088);
    if (paramah2 != null)
    {
      n localn = this.tPa;
      paramah1.cEE();
      localn.v(paramah2);
      this.tPc.b(paramah2, paramah1.cEE());
    }
    this.tPb.x(paramah1);
    AppMethodBeat.o(48088);
  }
  
  private void v(long paramLong, int paramInt)
  {
    AppMethodBeat.i(48094);
    int i = this.qts.ccM().qYY.pkgVersion;
    com.tencent.mm.plugin.report.service.h.OAn.b(13543, new Object[] { this.mAppId, Integer.valueOf(i), Long.valueOf(paramLong), Integer.valueOf(paramInt), Integer.valueOf(this.qts.getInitConfig().appServiceType + 1000) });
    AppMethodBeat.o(48094);
  }
  
  public final void M(Intent paramIntent)
  {
    this.tOX = paramIntent;
  }
  
  public final void a(long paramLong, cb paramcb)
  {
    AppMethodBeat.i(48093);
    int i;
    switch (1.enn[paramcb.ordinal()])
    {
    default: 
      i = 2;
      v(paramLong, i);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(390L, 0L, 1L, false);
      switch ((int)paramLong / 250)
      {
      default: 
        i = 7;
      }
      break;
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(390L, i, 1L, false);
      AppMethodBeat.o(48093);
      return;
      i = 1;
      break;
      i = 3;
      break;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
      continue;
      i = 5;
      continue;
      i = 6;
    }
  }
  
  public final void a(ah paramah1, ah paramah2, cb paramcb)
  {
    int i = 0;
    AppMethodBeat.i(48087);
    j localj;
    if ((cb.tBs == paramcb) && (this.tOZ))
    {
      this.tOZ = false;
      aqI();
      if ((cb.tBs == paramcb) || (paramah2 == null) || (Util.isNullOrNil(paramah2.cEE())) || (paramah2 == paramah1)) {
        i = 1;
      }
      localj = this.tPe;
      if (i == 0) {
        break label117;
      }
    }
    label117:
    for (ah localah = null;; localah = paramah2)
    {
      localj.a(paramah1, localah, paramcb);
      if (i != 0) {
        break label123;
      }
      paramah2.txQ.onBackground();
      a(paramah1, paramah2);
      AppMethodBeat.o(48087);
      return;
      this.tOZ = false;
      break;
    }
    label123:
    a(paramah1, null);
    AppMethodBeat.o(48087);
  }
  
  public final void aqI()
  {
    AppMethodBeat.i(48086);
    if (Util.isNullOrNil(this.mAppId))
    {
      Log.e("MicroMsg.AppBrandPageContainerReporter", "resetSession with dummy model, stack %s", new Object[] { Util.stackTraceToString(new Throwable()) });
      this.tPe = j.tPx;
      this.tPb = p.cIV();
      this.tPa = n.cIU();
      this.tPc = s.cIY();
      AppMethodBeat.o(48086);
      return;
    }
    String str1 = this.qts.getInitConfig().eoP;
    String str2 = e.d(this.qts.getInitConfig().eoV);
    if ((this.tPe != null) && (this.tPe.cIM() != null)) {}
    for (Object localObject = this.tPe.cIM().path;; localObject = this.qts.cby())
    {
      this.tPe = new d(str2, (String)localObject);
      this.tPa = n.a(this.qts, str1, this.tPe);
      localObject = new LinkedList();
      ((LinkedList)localObject).push(Util.nullAsNil(str2));
      this.tPc = s.a(this.qts, str1, (LinkedList)localObject);
      this.tPb = p.b(this.qts, str1, this.tPe);
      AppMethodBeat.o(48086);
      return;
    }
  }
  
  public final void cBj()
  {
    AppMethodBeat.i(48090);
    v(0L, 4);
    AppMethodBeat.o(48090);
  }
  
  public final j cBk()
  {
    return this.tPe;
  }
  
  public final Intent cBl()
  {
    return this.tOX;
  }
  
  public final s cBm()
  {
    return this.tPc;
  }
  
  public final t cBn()
  {
    return this.tPd;
  }
  
  public final void cBo()
  {
    this.tOY = true;
    this.tOZ = true;
  }
  
  public final void d(ah paramah)
  {
    AppMethodBeat.i(48091);
    if ((paramah == null) || (this.tuT))
    {
      AppMethodBeat.o(48091);
      return;
    }
    e(paramah);
    AppMethodBeat.o(48091);
  }
  
  public final void e(ah paramah)
  {
    AppMethodBeat.i(48089);
    this.tuT = true;
    this.tPe.e(paramah);
    paramah.txQ.onBackground();
    Object localObject1 = this.tPa;
    Object localObject2 = AndroidContextUtil.castActivityOrNull(paramah.getContext());
    if ((localObject2 != null) && (((Activity)localObject2).isFinishing())) {
      ((n)localObject1).tPN = true;
    }
    ((n)localObject1).w(paramah);
    ((n)localObject1).report();
    localObject2 = this.tPc;
    ((s)localObject2).tPO = ((String)((s)localObject2).tQY.peekFirst());
    ((s)localObject2).tPQ = null;
    Intent localIntent;
    switch (s.2.qLA[com.tencent.mm.plugin.appbrand.k.Uo(localObject2.appId).ordinal()])
    {
    default: 
      localIntent = ((s)localObject2).qts.ccN().getReporter().cBl();
      if (localIntent != null) {
        if (localIntent.getComponent() == null)
        {
          localObject1 = "";
          Log.e("MicroMsg.AppBrand.Report.kv_14992", "onBackground, intent %s, get null cmp name", new Object[] { localIntent });
          ((s)localObject2).tPP = 8;
          ((s)localObject2).tPQ = Util.nullAs(IntentUtil.getStringExtra(localIntent, AppBrandProcessProxyUI.ruI), (String)localObject1);
          localObject1 = ((s)localObject2).tPQ;
          ((s)localObject2).tQY.pollFirst();
          ((s)localObject2).tQY.push(Util.nullAsNil((String)localObject1));
        }
      }
      break;
    }
    for (;;)
    {
      localObject1 = AndroidContextUtil.castActivityOrNull(paramah.getContext());
      if ((localObject1 != null) && (((Activity)localObject1).isFinishing())) {
        ((s)localObject2).tPN = true;
      }
      ((s)localObject2).y(paramah);
      AppMethodBeat.o(48089);
      return;
      ((s)localObject2).tPP = 3;
      continue;
      ((s)localObject2).tPP = 6;
      continue;
      localObject1 = localIntent.getComponent().getClassName();
      break;
      ((s)localObject2).tPP = 7;
    }
  }
  
  public final void f(ah paramah)
  {
    AppMethodBeat.i(48092);
    this.tOX = null;
    if (this.tOY)
    {
      this.tOY = false;
      AppMethodBeat.o(48092);
      return;
    }
    this.tPe.f(paramah);
    this.tPb.x(paramah);
    AppMethodBeat.o(48092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.b
 * JD-Core Version:    0.7.0.1
 */