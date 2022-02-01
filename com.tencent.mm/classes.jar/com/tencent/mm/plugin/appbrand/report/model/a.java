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
import com.tencent.mm.plugin.appbrand.page.bt;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class a
  implements f
{
  private final o jez;
  private boolean lAw;
  private Intent lSq;
  private boolean lSr;
  private boolean lSs;
  private k lSt;
  private m lSu;
  private p lSv;
  private q lSw;
  private volatile h lSx;
  private final String mAppId;
  
  public a(o paramo)
  {
    AppMethodBeat.i(48085);
    this.lAw = false;
    this.lSr = false;
    this.lSs = false;
    this.lSt = null;
    this.lSu = null;
    this.lSv = null;
    this.lSw = null;
    this.lSx = null;
    this.mAppId = paramo.mAppId;
    this.jez = paramo;
    this.lSw = q.J(this.jez);
    resetSession();
    AppMethodBeat.o(48085);
  }
  
  private void a(ae paramae1, ae paramae2)
  {
    AppMethodBeat.i(48088);
    if (paramae2 != null)
    {
      this.lSt.t(paramae2);
      this.lSv.a(paramae2, paramae1.lyH);
    }
    this.lSu.v(paramae1);
    AppMethodBeat.o(48088);
  }
  
  private void j(long paramLong, int paramInt)
  {
    AppMethodBeat.i(48094);
    int i = this.jez.aTR().jEg.pkgVersion;
    com.tencent.mm.plugin.report.service.h.wUl.f(13543, new Object[] { this.mAppId, Integer.valueOf(i), Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    AppMethodBeat.o(48094);
  }
  
  public final void H(Intent paramIntent)
  {
    this.lSq = paramIntent;
  }
  
  public final void a(long paramLong, bt parambt)
  {
    AppMethodBeat.i(48093);
    int i;
    switch (1.cax[parambt.ordinal()])
    {
    default: 
      i = 2;
      j(paramLong, i);
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(390L, 0L, 1L, false);
      switch ((int)paramLong / 250)
      {
      default: 
        i = 7;
      }
      break;
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(390L, i, 1L, false);
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
  
  public final void a(ae paramae1, ae paramae2, bt parambt)
  {
    int i = 0;
    AppMethodBeat.i(48087);
    h localh;
    if ((bt.lGo == parambt) && (this.lSs))
    {
      this.lSs = false;
      resetSession();
      if ((bt.lGo == parambt) || (paramae2 == null) || (bs.isNullOrNil(paramae2.lyH)) || (paramae2 == paramae1)) {
        i = 1;
      }
      localh = this.lSx;
      if (i == 0) {
        break label117;
      }
    }
    label117:
    for (ae localae = null;; localae = paramae2)
    {
      localh.a(paramae1, localae, parambt);
      if (i != 0) {
        break label123;
      }
      paramae2.lCV.onBackground();
      a(paramae1, paramae2);
      AppMethodBeat.o(48087);
      return;
      this.lSs = false;
      break;
    }
    label123:
    a(paramae1, null);
    AppMethodBeat.o(48087);
  }
  
  public final void bor()
  {
    AppMethodBeat.i(48090);
    j(0L, 4);
    AppMethodBeat.o(48090);
  }
  
  public final h bos()
  {
    return this.lSx;
  }
  
  public final Intent bot()
  {
    return this.lSq;
  }
  
  public final p bou()
  {
    return this.lSv;
  }
  
  public final q bov()
  {
    return this.lSw;
  }
  
  public final void bow()
  {
    this.lSr = true;
    this.lSs = true;
  }
  
  public final void c(ae paramae)
  {
    AppMethodBeat.i(48091);
    if ((paramae == null) || (this.lAw))
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
    this.lAw = true;
    this.lSx.d(paramae);
    paramae.lCV.onBackground();
    Object localObject1 = this.lSt;
    Object localObject2 = com.tencent.mm.sdk.f.a.jg(paramae.getContext());
    if ((localObject2 != null) && (((Activity)localObject2).isFinishing())) {
      ((k)localObject1).lTe = true;
    }
    ((k)localObject1).u(paramae);
    ((k)localObject1).report();
    localObject2 = this.lSv;
    ((p)localObject2).lTg = ((String)((p)localObject2).lUm.peekFirst());
    ((p)localObject2).lTi = null;
    Intent localIntent;
    switch (p.2.jrQ[com.tencent.mm.plugin.appbrand.g.Hg(localObject2.appId).ordinal()])
    {
    default: 
      localIntent = ((p)localObject2).jez.aTT().getReporter().bot();
      if (localIntent != null) {
        if (localIntent.getComponent() == null)
        {
          localObject1 = "";
          ac.e("MicroMsg.AppBrand.Report.kv_14992", "onBackground, intent %s, get null cmp name", new Object[] { localIntent });
          ((p)localObject2).lTh = 8;
          ((p)localObject2).lTi = bs.bG(x.getStringExtra(localIntent, AppBrandProcessProxyUI.jUR), (String)localObject1);
          localObject1 = ((p)localObject2).lTi;
          ((p)localObject2).lUm.pollFirst();
          ((p)localObject2).lUm.push(bs.nullAsNil((String)localObject1));
        }
      }
      break;
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.sdk.f.a.jg(paramae.getContext());
      if ((localObject1 != null) && (((Activity)localObject1).isFinishing())) {
        ((p)localObject2).lTe = true;
      }
      ((p)localObject2).w(paramae);
      AppMethodBeat.o(48089);
      return;
      ((p)localObject2).lTh = 3;
      continue;
      ((p)localObject2).lTh = 6;
      continue;
      localObject1 = localIntent.getComponent().getClassName();
      break;
      ((p)localObject2).lTh = 7;
    }
  }
  
  public final void e(ae paramae)
  {
    AppMethodBeat.i(48092);
    this.lSq = null;
    if (this.lSr)
    {
      this.lSr = false;
      AppMethodBeat.o(48092);
      return;
    }
    this.lSx.e(paramae);
    this.lSu.v(paramae);
    AppMethodBeat.o(48092);
  }
  
  public final void resetSession()
  {
    AppMethodBeat.i(48086);
    if (bs.isNullOrNil(this.mAppId))
    {
      ac.e("MicroMsg.AppBrandPageContainerReporter", "resetSession with dummy model, stack %s", new Object[] { bs.m(new Throwable()) });
      this.lSx = h.lSO;
      this.lSu = m.btx();
      this.lSt = k.btw();
      this.lSv = p.btG();
      AppMethodBeat.o(48086);
      return;
    }
    String str1 = this.jez.aTS().CD();
    String str2 = d.d(this.jez.aTS().cce);
    this.lSx = new c(str2, this.jez.aSI());
    this.lSt = k.a(this.jez, str1, this.lSx);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.push(bs.nullAsNil(str2));
    this.lSv = p.a(this.jez, str1, localLinkedList);
    this.lSu = m.b(this.jez, str1, this.lSx);
    AppMethodBeat.o(48086);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.a
 * JD-Core Version:    0.7.0.1
 */