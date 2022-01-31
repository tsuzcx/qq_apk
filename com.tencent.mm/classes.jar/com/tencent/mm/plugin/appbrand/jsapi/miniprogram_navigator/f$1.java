package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.bk;

final class f$1
  extends g.b
{
  f$1(String paramString1, String paramString2, String paramString3, long paramLong, AppBrandStatObject paramAppBrandStatObject) {}
  
  private void a(g.c paramc, String paramString1, String paramString2, String paramString3)
  {
    long l1 = bk.UY();
    long l2 = this.eow;
    int i = 0;
    switch (f.2.fGn[paramc.ordinal()])
    {
    }
    for (;;)
    {
      f.a(i, paramString1, paramString2, paramString3, l1 - l2);
      this.gxi.gxg = null;
      g.b(paramString1, this);
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  public final void a(g.c paramc)
  {
    a(paramc, this.val$appId, this.dlh, this.gxh);
  }
  
  public final void onDestroy()
  {
    a(g.qB(this.val$appId), this.val$appId, this.dlh, this.gxh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.f.1
 * JD-Core Version:    0.7.0.1
 */