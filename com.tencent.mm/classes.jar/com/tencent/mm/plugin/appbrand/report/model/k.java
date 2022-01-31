package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class k
{
  private String bFv;
  public k.b gZc;
  public int gZd;
  public String gZe;
  private long gZf;
  public k.a gZg;
  
  public final String toString()
  {
    return "kv_13917{scene=" + this.gZc.value + ", appCount=" + this.gZd + ", nearbyListId='" + this.gZe + '\'' + ", clickTime=" + this.gZf + ", sceneNote='" + this.bFv + '\'' + ", openType=" + this.gZg.value + '}';
  }
  
  public final void wn()
  {
    if ((this.gZc == null) || (this.gZg == null)) {
      return;
    }
    y.i("MicroMsg.AppBrand.kv_13917", "report " + toString());
    this.gZf = bk.UY();
    h.nFQ.f(13917, i.j(new Object[] { Integer.valueOf(this.gZc.value), Integer.valueOf(this.gZd), this.gZe, Long.valueOf(this.gZf), this.bFv, Integer.valueOf(this.gZg.value) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.k
 * JD-Core Version:    0.7.0.1
 */