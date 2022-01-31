package com.tencent.mm.plugin.appbrand.report.model;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.page.bf;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class a
  implements f
{
  private final com.tencent.mm.plugin.appbrand.o gQn;
  private Intent iGq;
  private boolean iGr;
  j iGs;
  private l iGt;
  o iGu;
  private volatile h iGv;
  private boolean ivV;
  private final String mAppId;
  
  public a(com.tencent.mm.plugin.appbrand.o paramo)
  {
    AppMethodBeat.i(132582);
    this.ivV = false;
    this.iGr = false;
    this.iGs = null;
    this.iGt = null;
    this.iGu = null;
    this.iGv = null;
    this.mAppId = paramo.mAppId;
    this.gQn = paramo;
    resetSession();
    AppMethodBeat.o(132582);
  }
  
  private void h(long paramLong, int paramInt)
  {
    AppMethodBeat.i(132591);
    int i = this.gQn.atR().hiX.gXf;
    com.tencent.mm.plugin.report.service.h.qsU.e(13543, new Object[] { this.mAppId, Integer.valueOf(i), Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    AppMethodBeat.o(132591);
  }
  
  public final void G(Intent paramIntent)
  {
    this.iGq = paramIntent;
  }
  
  public final void a(long paramLong, bf parambf)
  {
    AppMethodBeat.i(132590);
    int i;
    switch (a.3.bBL[parambf.ordinal()])
    {
    default: 
      i = 2;
      h(paramLong, i);
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(390L, 0L, 1L, false);
      switch ((int)paramLong / 250)
      {
      default: 
        i = 7;
      }
      break;
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(390L, i, 1L, false);
      AppMethodBeat.o(132590);
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
  
  public final void a(z paramz)
  {
    AppMethodBeat.i(132588);
    if ((paramz == null) || (this.ivV))
    {
      AppMethodBeat.o(132588);
      return;
    }
    b(paramz);
    AppMethodBeat.o(132588);
  }
  
  final void a(z paramz1, z paramz2)
  {
    AppMethodBeat.i(132585);
    if (paramz2 != null)
    {
      this.iGs.k(paramz2);
      this.iGu.a(paramz2, paramz1.iuB);
    }
    this.iGt.m(paramz1);
    AppMethodBeat.o(132585);
  }
  
  public final void a(z paramz1, z paramz2, bf parambf)
  {
    AppMethodBeat.i(132584);
    if (bf.izV == parambf) {
      resetSession();
    }
    int i;
    h localh;
    if ((bf.izV == parambf) || (paramz2 == null) || (bo.isNullOrNil(paramz2.iuB)) || (paramz2 == paramz1))
    {
      i = 1;
      localh = this.iGv;
      if (i == 0) {
        break label104;
      }
    }
    label104:
    for (z localz = null;; localz = paramz2)
    {
      localh.a(paramz1, localz, parambf);
      if (i != 0) {
        break label110;
      }
      paramz2.ixF.L(new a.1(this, paramz1, paramz2));
      AppMethodBeat.o(132584);
      return;
      i = 0;
      break;
    }
    label110:
    a(paramz1, null);
    AppMethodBeat.o(132584);
  }
  
  public final void aHD()
  {
    AppMethodBeat.i(132587);
    h(0L, 4);
    AppMethodBeat.o(132587);
  }
  
  public final h aHE()
  {
    return this.iGv;
  }
  
  public final Intent aHF()
  {
    return this.iGq;
  }
  
  public final o aHG()
  {
    return this.iGu;
  }
  
  public final void aHH()
  {
    this.iGr = true;
  }
  
  public final void b(z paramz)
  {
    AppMethodBeat.i(132586);
    this.ivV = true;
    this.iGv.b(paramz);
    paramz.ixF.L(new a.2(this, paramz));
    AppMethodBeat.o(132586);
  }
  
  public final void c(z paramz)
  {
    AppMethodBeat.i(132589);
    this.iGq = null;
    if (this.iGr)
    {
      this.iGr = false;
      AppMethodBeat.o(132589);
      return;
    }
    this.iGv.c(paramz);
    this.iGt.m(paramz);
    AppMethodBeat.o(132589);
  }
  
  public final void resetSession()
  {
    AppMethodBeat.i(132583);
    if (bo.isNullOrNil(this.mAppId))
    {
      ab.e("MicroMsg.AppBrandPageContainerReporter", "resetSession with dummy model, stack %s", new Object[] { bo.l(new Throwable()) });
      this.iGv = h.iGQ;
      this.iGt = l.aLq();
      this.iGs = j.aLp();
      this.iGu = o.aLs();
      AppMethodBeat.o(132583);
      return;
    }
    String str1 = this.gQn.atS().vZ();
    String str2 = d.d(this.gQn.atS().hiz);
    this.iGv = new c(str2);
    this.iGs = j.a(this.gQn, str1, this.iGv);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.push(bo.nullAsNil(str2));
    this.iGu = o.a(this.gQn, str1, localLinkedList);
    this.iGt = l.b(this.gQn, str1, this.iGv);
    AppMethodBeat.o(132583);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.a
 * JD-Core Version:    0.7.0.1
 */