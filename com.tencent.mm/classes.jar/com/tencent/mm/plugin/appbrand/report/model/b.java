package com.tencent.mm.plugin.appbrand.report.model;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.page.al;
import com.tencent.mm.plugin.appbrand.page.s;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class b
  implements g
{
  private final n fzW;
  public boolean gSK = false;
  public Intent gXX;
  public boolean gXY = false;
  j gXZ = null;
  private l gYa = null;
  public o gYb = null;
  public volatile h gYc = null;
  private final String mAppId;
  
  public b(n paramn)
  {
    this.mAppId = paramn.mAppId;
    this.fzW = paramn;
    aee();
  }
  
  final void a(s params1, s params2)
  {
    if (params2 != null)
    {
      Object localObject = this.gXZ;
      ((j)localObject).i(params2);
      ((j)localObject).wn();
      localObject = this.gYb;
      String str = params1.ahc();
      ((o)localObject).gYT = ((String)((o)localObject).gZN.peekFirst());
      ((o)localObject).gYU = 2;
      ((o)localObject).gYV = str;
      ((o)localObject).gZN.push(params2.getURL());
      ((o)localObject).gZM = params2.getURL();
      ((o)localObject).k(params2);
    }
    this.gYa.j(params1);
  }
  
  public final void a(s params1, s params2, al paramal)
  {
    if (al.gVQ == paramal) {
      aee();
    }
    int i;
    h localh;
    if ((al.gVQ == paramal) || (params2 == null) || (bk.bl(params2.ahc())) || (params2 == params1))
    {
      i = 1;
      localh = this.gYc;
      if (i == 0) {
        break label94;
      }
    }
    label94:
    for (s locals = null;; locals = params2)
    {
      localh.a(params1, locals, paramal);
      if (i != 0) {
        break label100;
      }
      params2.gUj.E(new b.1(this, params1, params2));
      return;
      i = 0;
      break;
    }
    label100:
    a(params1, null);
  }
  
  public final void aee()
  {
    if (bk.bl(this.mAppId))
    {
      y.e("MicroMsg.AppBrandPageContainerReporter", "resetSession with dummy model, stack %s", new Object[] { bk.j(new Throwable()) });
      this.gYc = h.gYz;
      this.gYa = l.aos();
      this.gXZ = j.aor();
      this.gYb = o.aou();
      return;
    }
    String str1 = this.fzW.aac().fJO;
    String str2 = a.d(this.fzW.aac().fPr);
    this.gYc = new d(str2);
    this.gXZ = j.a(this.fzW, str1, this.gYc);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.push(bk.pm(str2));
    this.gYb = o.a(this.fzW, str1, localLinkedList);
    this.gYa = l.b(this.fzW, str1, this.gYc);
  }
  
  public final void c(s params)
  {
    this.gSK = true;
    this.gYc.c(params);
    params.gUj.E(new b.2(this, params));
  }
  
  public final void d(s params)
  {
    this.gXX = null;
    if (this.gXY)
    {
      this.gXY = false;
      return;
    }
    this.gYc.d(params);
    this.gYa.j(params);
  }
  
  public final void g(long paramLong, int paramInt)
  {
    int i = this.fzW.aaa().fPS.fEN;
    com.tencent.mm.plugin.report.service.h.nFQ.f(13543, new Object[] { this.mAppId, Integer.valueOf(i), Long.valueOf(paramLong), Integer.valueOf(paramInt) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.b
 * JD-Core Version:    0.7.0.1
 */