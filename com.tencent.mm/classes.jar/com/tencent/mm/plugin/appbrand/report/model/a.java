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
import com.tencent.mm.plugin.appbrand.page.by;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class a
  implements f
{
  private final o iEx;
  private boolean kYM;
  private p lqA;
  private q lqB;
  private volatile h lqC;
  private Intent lqv;
  private boolean lqw;
  private boolean lqx;
  private k lqy;
  private m lqz;
  private final String mAppId;
  
  public a(o paramo)
  {
    AppMethodBeat.i(48085);
    this.kYM = false;
    this.lqw = false;
    this.lqx = false;
    this.lqy = null;
    this.lqz = null;
    this.lqA = null;
    this.lqB = null;
    this.lqC = null;
    this.mAppId = paramo.mAppId;
    this.iEx = paramo;
    this.lqB = q.J(this.iEx);
    resetSession();
    AppMethodBeat.o(48085);
  }
  
  private void a(ae paramae1, ae paramae2)
  {
    AppMethodBeat.i(48088);
    if (paramae2 != null)
    {
      this.lqy.t(paramae2);
      this.lqA.a(paramae2, paramae1.kWX);
    }
    this.lqz.v(paramae1);
    AppMethodBeat.o(48088);
  }
  
  private void i(long paramLong, int paramInt)
  {
    AppMethodBeat.i(48094);
    int i = this.iEx.aNb().jdS.pkgVersion;
    com.tencent.mm.plugin.report.service.h.vKh.f(13543, new Object[] { this.mAppId, Integer.valueOf(i), Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    AppMethodBeat.o(48094);
  }
  
  public final void H(Intent paramIntent)
  {
    this.lqv = paramIntent;
  }
  
  public final void a(long paramLong, by paramby)
  {
    AppMethodBeat.i(48093);
    int i;
    switch (1.cdA[paramby.ordinal()])
    {
    default: 
      i = 2;
      i(paramLong, i);
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(390L, 0L, 1L, false);
      switch ((int)paramLong / 250)
      {
      default: 
        i = 7;
      }
      break;
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(390L, i, 1L, false);
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
  
  public final void a(ae paramae1, ae paramae2, by paramby)
  {
    int i = 0;
    AppMethodBeat.i(48087);
    h localh;
    if ((by.lgu == paramby) && (this.lqx))
    {
      this.lqx = false;
      resetSession();
      if ((by.lgu == paramby) || (paramae2 == null) || (bt.isNullOrNil(paramae2.kWX)) || (paramae2 == paramae1)) {
        i = 1;
      }
      localh = this.lqC;
      if (i == 0) {
        break label117;
      }
    }
    label117:
    for (ae localae = null;; localae = paramae2)
    {
      localh.a(paramae1, localae, paramby);
      if (i != 0) {
        break label123;
      }
      paramae2.lbw.onBackground();
      a(paramae1, paramae2);
      AppMethodBeat.o(48087);
      return;
      this.lqx = false;
      break;
    }
    label123:
    a(paramae1, null);
    AppMethodBeat.o(48087);
  }
  
  public final p bhA()
  {
    return this.lqA;
  }
  
  public final q bhB()
  {
    return this.lqB;
  }
  
  public final void bhC()
  {
    this.lqw = true;
    this.lqx = true;
  }
  
  public final void bhx()
  {
    AppMethodBeat.i(48090);
    i(0L, 4);
    AppMethodBeat.o(48090);
  }
  
  public final h bhy()
  {
    return this.lqC;
  }
  
  public final Intent bhz()
  {
    return this.lqv;
  }
  
  public final void c(ae paramae)
  {
    AppMethodBeat.i(48091);
    if ((paramae == null) || (this.kYM))
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
    this.kYM = true;
    this.lqC.d(paramae);
    paramae.lbw.onBackground();
    Object localObject1 = this.lqy;
    Object localObject2 = com.tencent.mm.sdk.f.a.iV(paramae.getContext());
    if ((localObject2 != null) && (((Activity)localObject2).isFinishing())) {
      ((k)localObject1).lrj = true;
    }
    ((k)localObject1).u(paramae);
    ((k)localObject1).report();
    localObject2 = this.lqA;
    ((p)localObject2).lrl = ((String)((p)localObject2).lss.peekFirst());
    ((p)localObject2).lrn = null;
    Intent localIntent;
    switch (p.2.iRF[com.tencent.mm.plugin.appbrand.g.Dd(localObject2.appId).ordinal()])
    {
    default: 
      localIntent = ((p)localObject2).iEx.aNd().getReporter().bhz();
      if (localIntent != null) {
        if (localIntent.getComponent() == null)
        {
          localObject1 = "";
          ad.e("MicroMsg.AppBrand.Report.kv_14992", "onBackground, intent %s, get null cmp name", new Object[] { localIntent });
          ((p)localObject2).lrm = 8;
          ((p)localObject2).lrn = bt.by(y.getStringExtra(localIntent, AppBrandProcessProxyUI.juw), (String)localObject1);
          localObject1 = ((p)localObject2).lrn;
          ((p)localObject2).lss.pollFirst();
          ((p)localObject2).lss.push(bt.nullAsNil((String)localObject1));
        }
      }
      break;
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.sdk.f.a.iV(paramae.getContext());
      if ((localObject1 != null) && (((Activity)localObject1).isFinishing())) {
        ((p)localObject2).lrj = true;
      }
      ((p)localObject2).w(paramae);
      AppMethodBeat.o(48089);
      return;
      ((p)localObject2).lrm = 3;
      continue;
      ((p)localObject2).lrm = 6;
      continue;
      localObject1 = localIntent.getComponent().getClassName();
      break;
      ((p)localObject2).lrm = 7;
    }
  }
  
  public final void e(ae paramae)
  {
    AppMethodBeat.i(48092);
    this.lqv = null;
    if (this.lqw)
    {
      this.lqw = false;
      AppMethodBeat.o(48092);
      return;
    }
    this.lqC.e(paramae);
    this.lqz.v(paramae);
    AppMethodBeat.o(48092);
  }
  
  public final void resetSession()
  {
    AppMethodBeat.i(48086);
    if (bt.isNullOrNil(this.mAppId))
    {
      ad.e("MicroMsg.AppBrandPageContainerReporter", "resetSession with dummy model, stack %s", new Object[] { bt.m(new Throwable()) });
      this.lqC = h.lqT;
      this.lqz = m.bmB();
      this.lqy = k.bmA();
      this.lqA = p.bmK();
      AppMethodBeat.o(48086);
      return;
    }
    String str1 = this.iEx.aNc().Da();
    String str2 = d.d(this.iEx.aNc().cfi);
    this.lqC = new c(str2);
    this.lqy = k.a(this.iEx, str1, this.lqC);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.push(bt.nullAsNil(str2));
    this.lqA = p.a(this.iEx, str1, localLinkedList);
    this.lqz = m.b(this.iEx, str1, this.lqC);
    AppMethodBeat.o(48086);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.a
 * JD-Core Version:    0.7.0.1
 */