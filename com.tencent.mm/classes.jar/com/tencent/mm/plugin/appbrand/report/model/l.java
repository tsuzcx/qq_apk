package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class l
{
  private String dbt;
  public a lrA;
  public l.b lrw;
  public int lrx;
  public String lry;
  private long lrz;
  
  public final void report()
  {
    AppMethodBeat.i(48149);
    if ((this.lrw == null) || (this.lrA == null))
    {
      AppMethodBeat.o(48149);
      return;
    }
    ad.i("MicroMsg.AppBrand.kv_13917", "report " + toString());
    this.lrz = bt.eGO();
    h.vKh.f(13917, p.k(new Object[] { Integer.valueOf(this.lrw.value), Integer.valueOf(this.lrx), this.lry, Long.valueOf(this.lrz), this.dbt, Integer.valueOf(this.lrA.value) }));
    AppMethodBeat.o(48149);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(48148);
    String str = "kv_13917{scene=" + this.lrw.value + ", appCount=" + this.lrx + ", nearbyListId='" + this.lry + '\'' + ", clickTime=" + this.lrz + ", sceneNote='" + this.dbt + '\'' + ", openType=" + this.lrA.value + '}';
    AppMethodBeat.o(48148);
    return str;
  }
  
  public static enum a
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(48144);
      lrB = new a("NEARBY_H5", 0, 1);
      lrC = new a("EMPTY_PAGE", 1, 2);
      lrD = new a("LBS_NOT_ALLOW", 2, 3);
      lrE = new a("NEARBY_MINI_PROGRAM", 3, 4);
      lrF = new a[] { lrB, lrC, lrD, lrE };
      AppMethodBeat.o(48144);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.l
 * JD-Core Version:    0.7.0.1
 */