package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.p;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class l
{
  private String dkh;
  public b mtg;
  public int mth;
  public String mti;
  private long mtj;
  public a mtk;
  
  public final void report()
  {
    AppMethodBeat.i(48149);
    if ((this.mtg == null) || (this.mtk == null))
    {
      AppMethodBeat.o(48149);
      return;
    }
    ad.i("MicroMsg.AppBrand.kv_13917", "report " + toString());
    this.mtj = bt.flT();
    g.yhR.f(13917, p.l(new Object[] { Integer.valueOf(this.mtg.value), Integer.valueOf(this.mth), this.mti, Long.valueOf(this.mtj), this.dkh, Integer.valueOf(this.mtk.value) }));
    AppMethodBeat.o(48149);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(48148);
    String str = "kv_13917{scene=" + this.mtg.value + ", appCount=" + this.mth + ", nearbyListId='" + this.mti + '\'' + ", clickTime=" + this.mtj + ", sceneNote='" + this.dkh + '\'' + ", openType=" + this.mtk.value + '}';
    AppMethodBeat.o(48148);
    return str;
  }
  
  public static enum a
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(48144);
      mtl = new a("NEARBY_H5", 0, 1);
      mtm = new a("EMPTY_PAGE", 1, 2);
      mtn = new a("LBS_NOT_ALLOW", 2, 3);
      mto = new a("NEARBY_MINI_PROGRAM", 3, 4);
      mtp = new a[] { mtl, mtm, mtn, mto };
      AppMethodBeat.o(48144);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static enum b
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(48147);
      mtq = new b("DESKTOP_SEARCH", 0, 1);
      mtr = new b("RESUME_FROM_WEAPP_EXIT", 1, 2);
      mts = new b("BOTTOM_ENTRANCE_IN_DESKTOP", 2, 3);
      mtt = new b("TOP_ENTRANCE_IN_DESKTOP", 3, 4);
      mtu = new b[] { mtq, mtr, mts, mtt };
      AppMethodBeat.o(48147);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.l
 * JD-Core Version:    0.7.0.1
 */