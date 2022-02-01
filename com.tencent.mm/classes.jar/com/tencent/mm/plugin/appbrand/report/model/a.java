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
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.page.ca;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.LinkedList;

public final class a
  implements f
{
  private final String mAppId;
  private final t nuJ;
  private q qKA;
  private volatile h qKB;
  private Intent qKu;
  private boolean qKv;
  private boolean qKw;
  private k qKx;
  private m qKy;
  private p qKz;
  private boolean qqr;
  
  public a(t paramt)
  {
    AppMethodBeat.i(48085);
    this.qqr = false;
    this.qKv = false;
    this.qKw = false;
    this.qKx = null;
    this.qKy = null;
    this.qKz = null;
    this.qKA = null;
    this.qKB = null;
    this.mAppId = paramt.mAppId;
    this.nuJ = paramt;
    this.qKA = q.H(this.nuJ);
    resetSession();
    AppMethodBeat.o(48085);
  }
  
  private void a(ah paramah1, ah paramah2)
  {
    AppMethodBeat.i(48088);
    if (paramah2 != null)
    {
      this.qKx.t(paramah2);
      this.qKz.a(paramah2, paramah1.qoI);
    }
    this.qKy.v(paramah1);
    AppMethodBeat.o(48088);
  }
  
  private void m(long paramLong, int paramInt)
  {
    AppMethodBeat.i(48094);
    int i = this.nuJ.bDx().nYR.pkgVersion;
    com.tencent.mm.plugin.report.service.h.IzE.a(13543, new Object[] { this.mAppId, Integer.valueOf(i), Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    AppMethodBeat.o(48094);
  }
  
  public final void J(Intent paramIntent)
  {
    this.qKu = paramIntent;
  }
  
  public final void a(long paramLong, ca paramca)
  {
    AppMethodBeat.i(48093);
    int i;
    switch (1.cvp[paramca.ordinal()])
    {
    default: 
      i = 2;
      m(paramLong, i);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(390L, 0L, 1L, false);
      switch ((int)paramLong / 250)
      {
      default: 
        i = 7;
      }
      break;
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(390L, i, 1L, false);
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
  
  public final void a(ah paramah1, ah paramah2, ca paramca)
  {
    int i = 0;
    AppMethodBeat.i(48087);
    h localh;
    if ((ca.qwD == paramca) && (this.qKw))
    {
      this.qKw = false;
      resetSession();
      if ((ca.qwD == paramca) || (paramah2 == null) || (Util.isNullOrNil(paramah2.qoI)) || (paramah2 == paramah1)) {
        i = 1;
      }
      localh = this.qKB;
      if (i == 0) {
        break label117;
      }
    }
    label117:
    for (ah localah = null;; localah = paramah2)
    {
      localh.a(paramah1, localah, paramca);
      if (i != 0) {
        break label123;
      }
      paramah2.qtk.onBackground();
      a(paramah1, paramah2);
      AppMethodBeat.o(48087);
      return;
      this.qKw = false;
      break;
    }
    label123:
    a(paramah1, null);
    AppMethodBeat.o(48087);
  }
  
  public final void caP()
  {
    AppMethodBeat.i(48090);
    m(0L, 4);
    AppMethodBeat.o(48090);
  }
  
  public final h caQ()
  {
    return this.qKB;
  }
  
  public final Intent caR()
  {
    return this.qKu;
  }
  
  public final p caS()
  {
    return this.qKz;
  }
  
  public final q caT()
  {
    return this.qKA;
  }
  
  public final void caU()
  {
    this.qKv = true;
    this.qKw = true;
  }
  
  public final void d(ah paramah)
  {
    AppMethodBeat.i(48091);
    if ((paramah == null) || (this.qqr))
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
    this.qqr = true;
    this.qKB.e(paramah);
    paramah.qtk.onBackground();
    Object localObject1 = this.qKx;
    Object localObject2 = AndroidContextUtil.castActivityOrNull(paramah.getContext());
    if ((localObject2 != null) && (((Activity)localObject2).isFinishing())) {
      ((k)localObject1).qLg = true;
    }
    ((k)localObject1).u(paramah);
    ((k)localObject1).report();
    localObject2 = this.qKz;
    ((p)localObject2).qLh = ((String)((p)localObject2).qMo.peekFirst());
    ((p)localObject2).qLj = null;
    Intent localIntent;
    switch (p.2.nLM[com.tencent.mm.plugin.appbrand.k.abM(localObject2.appId).ordinal()])
    {
    default: 
      localIntent = ((p)localObject2).nuJ.bDz().getReporter().caR();
      if (localIntent != null) {
        if (localIntent.getComponent() == null)
        {
          localObject1 = "";
          Log.e("MicroMsg.AppBrand.Report.kv_14992", "onBackground, intent %s, get null cmp name", new Object[] { localIntent });
          ((p)localObject2).qLi = 8;
          ((p)localObject2).qLj = Util.nullAs(IntentUtil.getStringExtra(localIntent, AppBrandProcessProxyUI.oqO), (String)localObject1);
          localObject1 = ((p)localObject2).qLj;
          ((p)localObject2).qMo.pollFirst();
          ((p)localObject2).qMo.push(Util.nullAsNil((String)localObject1));
        }
      }
      break;
    }
    for (;;)
    {
      localObject1 = AndroidContextUtil.castActivityOrNull(paramah.getContext());
      if ((localObject1 != null) && (((Activity)localObject1).isFinishing())) {
        ((p)localObject2).qLg = true;
      }
      ((p)localObject2).w(paramah);
      AppMethodBeat.o(48089);
      return;
      ((p)localObject2).qLi = 3;
      continue;
      ((p)localObject2).qLi = 6;
      continue;
      localObject1 = localIntent.getComponent().getClassName();
      break;
      ((p)localObject2).qLi = 7;
    }
  }
  
  public final void f(ah paramah)
  {
    AppMethodBeat.i(48092);
    this.qKu = null;
    if (this.qKv)
    {
      this.qKv = false;
      AppMethodBeat.o(48092);
      return;
    }
    this.qKB.f(paramah);
    this.qKy.v(paramah);
    AppMethodBeat.o(48092);
  }
  
  public final void resetSession()
  {
    AppMethodBeat.i(48086);
    if (Util.isNullOrNil(this.mAppId))
    {
      Log.e("MicroMsg.AppBrandPageContainerReporter", "resetSession with dummy model, stack %s", new Object[] { Util.stackTraceToString(new Throwable()) });
      this.qKB = h.qKS;
      this.qKy = m.chY();
      this.qKx = k.chX();
      this.qKz = p.cih();
      AppMethodBeat.o(48086);
      return;
    }
    String str1 = this.nuJ.bDy().cwP;
    String str2 = d.d(this.nuJ.bDy().cwV);
    if ((this.qKB != null) && (this.qKB.chR() != null)) {}
    for (Object localObject = this.qKB.chR().path;; localObject = this.nuJ.bCi())
    {
      this.qKB = new c(str2, (String)localObject);
      this.qKx = k.a(this.nuJ, str1, this.qKB);
      localObject = new LinkedList();
      ((LinkedList)localObject).push(Util.nullAsNil(str2));
      this.qKz = p.a(this.nuJ, str1, (LinkedList)localObject);
      this.qKy = m.b(this.nuJ, str1, this.qKB);
      AppMethodBeat.o(48086);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.a
 * JD-Core Version:    0.7.0.1
 */