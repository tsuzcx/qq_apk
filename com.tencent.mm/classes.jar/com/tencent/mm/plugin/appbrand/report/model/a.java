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
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.page.bs;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class a
  implements f
{
  private final o jxG;
  private boolean lZU;
  private final String mAppId;
  private Intent msh;
  private boolean msi;
  private boolean msj;
  private k msk;
  private m msl;
  private p msm;
  private q msn;
  private volatile h mso;
  
  public a(o paramo)
  {
    AppMethodBeat.i(48085);
    this.lZU = false;
    this.msi = false;
    this.msj = false;
    this.msk = null;
    this.msl = null;
    this.msm = null;
    this.msn = null;
    this.mso = null;
    this.mAppId = paramo.mAppId;
    this.jxG = paramo;
    this.msn = q.A(this.jxG);
    resetSession();
    AppMethodBeat.o(48085);
  }
  
  private void a(ae paramae1, ae paramae2)
  {
    AppMethodBeat.i(48088);
    if (paramae2 != null)
    {
      this.msk.u(paramae2);
      this.msm.a(paramae2, paramae1.lYf);
    }
    this.msl.w(paramae1);
    AppMethodBeat.o(48088);
  }
  
  private void j(long paramLong, int paramInt)
  {
    AppMethodBeat.i(48094);
    int i = this.jxG.aXb().jYh.pkgVersion;
    com.tencent.mm.plugin.report.service.g.yhR.f(13543, new Object[] { this.mAppId, Integer.valueOf(i), Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    AppMethodBeat.o(48094);
  }
  
  public final void I(Intent paramIntent)
  {
    this.msh = paramIntent;
  }
  
  public final void a(long paramLong, bs parambs)
  {
    AppMethodBeat.i(48093);
    int i;
    switch (1.ckO[parambs.ordinal()])
    {
    default: 
      i = 2;
      j(paramLong, i);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(390L, 0L, 1L, false);
      switch ((int)paramLong / 250)
      {
      default: 
        i = 7;
      }
      break;
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(390L, i, 1L, false);
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
  
  public final void a(ae paramae1, ae paramae2, bs parambs)
  {
    int i = 0;
    AppMethodBeat.i(48087);
    h localh;
    if ((bs.mfR == parambs) && (this.msj))
    {
      this.msj = false;
      resetSession();
      if ((bs.mfR == parambs) || (paramae2 == null) || (bt.isNullOrNil(paramae2.lYf)) || (paramae2 == paramae1)) {
        i = 1;
      }
      localh = this.mso;
      if (i == 0) {
        break label117;
      }
    }
    label117:
    for (ae localae = null;; localae = paramae2)
    {
      localh.a(paramae1, localae, parambs);
      if (i != 0) {
        break label123;
      }
      paramae2.mcx.onBackground();
      a(paramae1, paramae2);
      AppMethodBeat.o(48087);
      return;
      this.msj = false;
      break;
    }
    label123:
    a(paramae1, null);
    AppMethodBeat.o(48087);
  }
  
  public final void bsj()
  {
    AppMethodBeat.i(48090);
    j(0L, 4);
    AppMethodBeat.o(48090);
  }
  
  public final h bsk()
  {
    return this.mso;
  }
  
  public final Intent bsl()
  {
    return this.msh;
  }
  
  public final p bsm()
  {
    return this.msm;
  }
  
  public final q bsn()
  {
    return this.msn;
  }
  
  public final void bso()
  {
    this.msi = true;
    this.msj = true;
  }
  
  public final void c(ae paramae)
  {
    AppMethodBeat.i(48091);
    if ((paramae == null) || (this.lZU))
    {
      AppMethodBeat.o(48091);
      return;
    }
    d(paramae);
    AppMethodBeat.o(48091);
  }
  
  public final void d(ae paramae)
  {
    AppMethodBeat.i(48089);
    this.lZU = true;
    this.mso.d(paramae);
    paramae.mcx.onBackground();
    Object localObject1 = this.msk;
    Object localObject2 = com.tencent.mm.sdk.f.a.jq(paramae.getContext());
    if ((localObject2 != null) && (((Activity)localObject2).isFinishing())) {
      ((k)localObject1).msU = true;
    }
    ((k)localObject1).v(paramae);
    ((k)localObject1).report();
    localObject2 = this.msm;
    ((p)localObject2).msW = ((String)((p)localObject2).mud.peekFirst());
    ((p)localObject2).msY = null;
    Intent localIntent;
    switch (p.2.jLK[com.tencent.mm.plugin.appbrand.g.Kv(localObject2.appId).ordinal()])
    {
    default: 
      localIntent = ((p)localObject2).jxG.aXd().getReporter().bsl();
      if (localIntent != null) {
        if (localIntent.getComponent() == null)
        {
          localObject1 = "";
          ad.e("MicroMsg.AppBrand.Report.kv_14992", "onBackground, intent %s, get null cmp name", new Object[] { localIntent });
          ((p)localObject2).msX = 8;
          ((p)localObject2).msY = bt.bI(y.getStringExtra(localIntent, AppBrandProcessProxyUI.kpf), (String)localObject1);
          localObject1 = ((p)localObject2).msY;
          ((p)localObject2).mud.pollFirst();
          ((p)localObject2).mud.push(bt.nullAsNil((String)localObject1));
        }
      }
      break;
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.sdk.f.a.jq(paramae.getContext());
      if ((localObject1 != null) && (((Activity)localObject1).isFinishing())) {
        ((p)localObject2).msU = true;
      }
      ((p)localObject2).x(paramae);
      AppMethodBeat.o(48089);
      return;
      ((p)localObject2).msX = 3;
      continue;
      ((p)localObject2).msX = 6;
      continue;
      localObject1 = localIntent.getComponent().getClassName();
      break;
      ((p)localObject2).msX = 7;
    }
  }
  
  public final void e(ae paramae)
  {
    AppMethodBeat.i(48092);
    this.msh = null;
    if (this.msi)
    {
      this.msi = false;
      AppMethodBeat.o(48092);
      return;
    }
    this.mso.e(paramae);
    this.msl.w(paramae);
    AppMethodBeat.o(48092);
  }
  
  public final void resetSession()
  {
    AppMethodBeat.i(48086);
    if (bt.isNullOrNil(this.mAppId))
    {
      ad.e("MicroMsg.AppBrandPageContainerReporter", "resetSession with dummy model, stack %s", new Object[] { bt.n(new Throwable()) });
      this.mso = h.msF;
      this.msl = m.bxC();
      this.msk = k.bxB();
      this.msm = p.bxL();
      AppMethodBeat.o(48086);
      return;
    }
    String str1 = this.jxG.aXc().Ec();
    String str2 = d.d(this.jxG.aXc().cmv);
    this.mso = new c(str2, this.jxG.aVW());
    this.msk = k.a(this.jxG, str1, this.mso);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.push(bt.nullAsNil(str2));
    this.msm = p.a(this.jxG, str1, localLinkedList);
    this.msl = m.b(this.jxG, str1, this.mso);
    AppMethodBeat.o(48086);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.a
 * JD-Core Version:    0.7.0.1
 */