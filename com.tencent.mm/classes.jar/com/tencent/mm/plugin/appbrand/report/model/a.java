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
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.page.bx;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.LinkedList;

public final class a
  implements f
{
  private final com.tencent.mm.plugin.appbrand.q kBw;
  private final String mAppId;
  private Intent nIi;
  private boolean nIj;
  private boolean nIk;
  private k nIl;
  private m nIm;
  private p nIn;
  private q nIo;
  private volatile h nIp;
  private boolean noI;
  
  public a(com.tencent.mm.plugin.appbrand.q paramq)
  {
    AppMethodBeat.i(48085);
    this.noI = false;
    this.nIj = false;
    this.nIk = false;
    this.nIl = null;
    this.nIm = null;
    this.nIn = null;
    this.nIo = null;
    this.nIp = null;
    this.mAppId = paramq.mAppId;
    this.kBw = paramq;
    this.nIo = q.G(this.kBw);
    resetSession();
    AppMethodBeat.o(48085);
  }
  
  private void a(ag paramag1, ag paramag2)
  {
    AppMethodBeat.i(48088);
    if (paramag2 != null)
    {
      this.nIl.v(paramag2);
      this.nIn.a(paramag2, paramag1.nna);
    }
    this.nIm.x(paramag1);
    AppMethodBeat.o(48088);
  }
  
  private void j(long paramLong, int paramInt)
  {
    AppMethodBeat.i(48094);
    int i = this.kBw.bsB().leE.pkgVersion;
    com.tencent.mm.plugin.report.service.h.CyF.a(13543, new Object[] { this.mAppId, Integer.valueOf(i), Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    AppMethodBeat.o(48094);
  }
  
  public final void I(Intent paramIntent)
  {
    this.nIi = paramIntent;
  }
  
  public final void a(long paramLong, bx parambx)
  {
    AppMethodBeat.i(48093);
    int i;
    switch (1.cwL[parambx.ordinal()])
    {
    default: 
      i = 2;
      j(paramLong, i);
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(390L, 0L, 1L, false);
      switch ((int)paramLong / 250)
      {
      default: 
        i = 7;
      }
      break;
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(390L, i, 1L, false);
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
  
  public final void a(ag paramag1, ag paramag2, bx parambx)
  {
    int i = 0;
    AppMethodBeat.i(48087);
    h localh;
    if ((bx.nuJ == parambx) && (this.nIk))
    {
      this.nIk = false;
      resetSession();
      if ((bx.nuJ == parambx) || (paramag2 == null) || (Util.isNullOrNil(paramag2.nna)) || (paramag2 == paramag1)) {
        i = 1;
      }
      localh = this.nIp;
      if (i == 0) {
        break label117;
      }
    }
    label117:
    for (ag localag = null;; localag = paramag2)
    {
      localh.a(paramag1, localag, parambx);
      if (i != 0) {
        break label123;
      }
      paramag2.nrs.onBackground();
      a(paramag1, paramag2);
      AppMethodBeat.o(48087);
      return;
      this.nIk = false;
      break;
    }
    label123:
    a(paramag1, null);
    AppMethodBeat.o(48087);
  }
  
  public final Intent bOA()
  {
    return this.nIi;
  }
  
  public final p bOB()
  {
    return this.nIn;
  }
  
  public final q bOC()
  {
    return this.nIo;
  }
  
  public final void bOD()
  {
    this.nIj = true;
    this.nIk = true;
  }
  
  public final void bOy()
  {
    AppMethodBeat.i(48090);
    j(0L, 4);
    AppMethodBeat.o(48090);
  }
  
  public final h bOz()
  {
    return this.nIp;
  }
  
  public final void c(ag paramag)
  {
    AppMethodBeat.i(48091);
    if ((paramag == null) || (this.noI))
    {
      AppMethodBeat.o(48091);
      return;
    }
    d(paramag);
    AppMethodBeat.o(48091);
  }
  
  public final void d(ag paramag)
  {
    AppMethodBeat.i(48089);
    this.noI = true;
    this.nIp.d(paramag);
    paramag.nrs.onBackground();
    Object localObject1 = this.nIl;
    Object localObject2 = AndroidContextUtil.castActivityOrNull(paramag.getContext());
    if ((localObject2 != null) && (((Activity)localObject2).isFinishing())) {
      ((k)localObject1).nIT = true;
    }
    ((k)localObject1).w(paramag);
    ((k)localObject1).report();
    localObject2 = this.nIn;
    ((p)localObject2).nIU = ((String)((p)localObject2).nKb.peekFirst());
    ((p)localObject2).nIW = null;
    Intent localIntent;
    switch (p.2.kRE[com.tencent.mm.plugin.appbrand.h.Uc(localObject2.appId).ordinal()])
    {
    default: 
      localIntent = ((p)localObject2).kBw.bsD().getReporter().bOA();
      if (localIntent != null) {
        if (localIntent.getComponent() == null)
        {
          localObject1 = "";
          Log.e("MicroMsg.AppBrand.Report.kv_14992", "onBackground, intent %s, get null cmp name", new Object[] { localIntent });
          ((p)localObject2).nIV = 8;
          ((p)localObject2).nIW = Util.nullAs(IntentUtil.getStringExtra(localIntent, AppBrandProcessProxyUI.lwf), (String)localObject1);
          localObject1 = ((p)localObject2).nIW;
          ((p)localObject2).nKb.pollFirst();
          ((p)localObject2).nKb.push(Util.nullAsNil((String)localObject1));
        }
      }
      break;
    }
    for (;;)
    {
      localObject1 = AndroidContextUtil.castActivityOrNull(paramag.getContext());
      if ((localObject1 != null) && (((Activity)localObject1).isFinishing())) {
        ((p)localObject2).nIT = true;
      }
      ((p)localObject2).y(paramag);
      AppMethodBeat.o(48089);
      return;
      ((p)localObject2).nIV = 3;
      continue;
      ((p)localObject2).nIV = 6;
      continue;
      localObject1 = localIntent.getComponent().getClassName();
      break;
      ((p)localObject2).nIV = 7;
    }
  }
  
  public final void e(ag paramag)
  {
    AppMethodBeat.i(48092);
    this.nIi = null;
    if (this.nIj)
    {
      this.nIj = false;
      AppMethodBeat.o(48092);
      return;
    }
    this.nIp.e(paramag);
    this.nIm.x(paramag);
    AppMethodBeat.o(48092);
  }
  
  public final void resetSession()
  {
    AppMethodBeat.i(48086);
    if (Util.isNullOrNil(this.mAppId))
    {
      Log.e("MicroMsg.AppBrandPageContainerReporter", "resetSession with dummy model, stack %s", new Object[] { Util.stackTraceToString(new Throwable()) });
      this.nIp = h.nIG;
      this.nIm = m.bUN();
      this.nIl = k.bUM();
      this.nIn = p.bUW();
      AppMethodBeat.o(48086);
      return;
    }
    String str1 = this.kBw.bsC().cym;
    String str2 = d.d(this.kBw.bsC().cys);
    this.nIp = new c(str2, this.kBw.brs());
    this.nIl = k.a(this.kBw, str1, this.nIp);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.push(Util.nullAsNil(str2));
    this.nIn = p.a(this.kBw, str1, localLinkedList);
    this.nIm = m.b(this.kBw, str1, this.nIp);
    AppMethodBeat.o(48086);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.a
 * JD-Core Version:    0.7.0.1
 */