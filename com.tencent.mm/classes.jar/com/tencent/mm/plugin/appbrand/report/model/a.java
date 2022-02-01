package com.tencent.mm.plugin.appbrand.report.model;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.br;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

public final class a
  implements f
{
  private final com.tencent.mm.plugin.appbrand.p jAF;
  private final String mAppId;
  private boolean meo;
  private Intent mxe;
  private boolean mxf;
  private boolean mxg;
  private k mxh;
  private m mxi;
  private p mxj;
  private q mxk;
  private volatile h mxl;
  
  public a(com.tencent.mm.plugin.appbrand.p paramp)
  {
    AppMethodBeat.i(48085);
    this.meo = false;
    this.mxf = false;
    this.mxg = false;
    this.mxh = null;
    this.mxi = null;
    this.mxj = null;
    this.mxk = null;
    this.mxl = null;
    this.mAppId = paramp.mAppId;
    this.jAF = paramp;
    this.mxk = q.B(this.jAF);
    resetSession();
    AppMethodBeat.o(48085);
  }
  
  private void a(ad paramad1, ad paramad2)
  {
    AppMethodBeat.i(48088);
    if (paramad2 != null)
    {
      this.mxh.v(paramad2);
      this.mxj.a(paramad2, paramad1.mcM);
    }
    this.mxi.x(paramad1);
    AppMethodBeat.o(48088);
  }
  
  private void j(long paramLong, int paramInt)
  {
    AppMethodBeat.i(48094);
    int i = this.jAF.aXw().kbw.pkgVersion;
    com.tencent.mm.plugin.report.service.g.yxI.f(13543, new Object[] { this.mAppId, Integer.valueOf(i), Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    AppMethodBeat.o(48094);
  }
  
  public final void I(Intent paramIntent)
  {
    this.mxe = paramIntent;
  }
  
  public final void a(long paramLong, br parambr)
  {
    AppMethodBeat.i(48093);
    int i;
    switch (1.ckQ[parambr.ordinal()])
    {
    default: 
      i = 2;
      j(paramLong, i);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(390L, 0L, 1L, false);
      switch ((int)paramLong / 250)
      {
      default: 
        i = 7;
      }
      break;
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(390L, i, 1L, false);
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
  
  public final void a(ad paramad1, ad paramad2, br parambr)
  {
    int i = 0;
    AppMethodBeat.i(48087);
    h localh;
    if ((br.mkm == parambr) && (this.mxg))
    {
      this.mxg = false;
      resetSession();
      if ((br.mkm == parambr) || (paramad2 == null) || (bu.isNullOrNil(paramad2.mcM)) || (paramad2 == paramad1)) {
        i = 1;
      }
      localh = this.mxl;
      if (i == 0) {
        break label117;
      }
    }
    label117:
    for (ad localad = null;; localad = paramad2)
    {
      localh.a(paramad1, localad, parambr);
      if (i != 0) {
        break label123;
      }
      paramad2.mgP.onBackground();
      a(paramad1, paramad2);
      AppMethodBeat.o(48087);
      return;
      this.mxg = false;
      break;
    }
    label123:
    a(paramad1, null);
    AppMethodBeat.o(48087);
  }
  
  public final void bsU()
  {
    AppMethodBeat.i(48090);
    j(0L, 4);
    AppMethodBeat.o(48090);
  }
  
  public final h bsV()
  {
    return this.mxl;
  }
  
  public final Intent bsW()
  {
    return this.mxe;
  }
  
  public final p bsX()
  {
    return this.mxj;
  }
  
  public final q bsY()
  {
    return this.mxk;
  }
  
  public final void bsZ()
  {
    this.mxf = true;
    this.mxg = true;
  }
  
  public final void c(ad paramad)
  {
    AppMethodBeat.i(48091);
    if ((paramad == null) || (this.meo))
    {
      AppMethodBeat.o(48091);
      return;
    }
    d(paramad);
    AppMethodBeat.o(48091);
  }
  
  public final void d(ad paramad)
  {
    AppMethodBeat.i(48089);
    this.meo = true;
    this.mxl.d(paramad);
    paramad.mgP.onBackground();
    Object localObject1 = this.mxh;
    Object localObject2 = com.tencent.mm.sdk.f.a.jw(paramad.getContext());
    if ((localObject2 != null) && (((Activity)localObject2).isFinishing())) {
      ((k)localObject1).mxR = true;
    }
    ((k)localObject1).w(paramad);
    ((k)localObject1).report();
    localObject2 = this.mxj;
    ((p)localObject2).mxT = ((String)((p)localObject2).mza.peekFirst());
    ((p)localObject2).mxV = null;
    Intent localIntent;
    switch (p.2.jOW[com.tencent.mm.plugin.appbrand.h.KU(localObject2.appId).ordinal()])
    {
    default: 
      localIntent = ((p)localObject2).jAF.aXy().getReporter().bsW();
      if (localIntent != null) {
        if (localIntent.getComponent() == null)
        {
          localObject1 = "";
          ae.e("MicroMsg.AppBrand.Report.kv_14992", "onBackground, intent %s, get null cmp name", new Object[] { localIntent });
          ((p)localObject2).mxU = 8;
          ((p)localObject2).mxV = bu.bI(com.tencent.mm.sdk.platformtools.z.getStringExtra(localIntent, AppBrandProcessProxyUI.ksv), (String)localObject1);
          localObject1 = ((p)localObject2).mxV;
          ((p)localObject2).mza.pollFirst();
          ((p)localObject2).mza.push(bu.nullAsNil((String)localObject1));
        }
      }
      break;
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.sdk.f.a.jw(paramad.getContext());
      if ((localObject1 != null) && (((Activity)localObject1).isFinishing())) {
        ((p)localObject2).mxR = true;
      }
      ((p)localObject2).y(paramad);
      AppMethodBeat.o(48089);
      return;
      ((p)localObject2).mxU = 3;
      continue;
      ((p)localObject2).mxU = 6;
      continue;
      localObject1 = localIntent.getComponent().getClassName();
      break;
      ((p)localObject2).mxU = 7;
    }
  }
  
  public final void e(ad paramad)
  {
    AppMethodBeat.i(48092);
    this.mxe = null;
    if (this.mxf)
    {
      this.mxf = false;
      AppMethodBeat.o(48092);
      return;
    }
    this.mxl.e(paramad);
    this.mxi.x(paramad);
    AppMethodBeat.o(48092);
  }
  
  public final void resetSession()
  {
    AppMethodBeat.i(48086);
    if (bu.isNullOrNil(this.mAppId))
    {
      ae.e("MicroMsg.AppBrandPageContainerReporter", "resetSession with dummy model, stack %s", new Object[] { bu.o(new Throwable()) });
      this.mxl = h.mxC;
      this.mxi = m.byv();
      this.mxh = k.byu();
      this.mxj = p.byE();
      AppMethodBeat.o(48086);
      return;
    }
    String str1 = this.jAF.aXx().Ef();
    String str2 = d.d(this.jAF.aXx().cmx);
    this.mxl = new c(str2, this.jAF.aWx());
    this.mxh = k.a(this.jAF, str1, this.mxl);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.push(bu.nullAsNil(str2));
    this.mxj = p.a(this.jAF, str1, localLinkedList);
    this.mxi = m.b(this.jAF, str1, this.mxl);
    AppMethodBeat.o(48086);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.a
 * JD-Core Version:    0.7.0.1
 */