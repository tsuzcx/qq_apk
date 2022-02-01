package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.p;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class l
{
  private String dlj;
  public l.b myd;
  public int mye;
  public String myf;
  private long myg;
  public a myh;
  
  public final void report()
  {
    AppMethodBeat.i(48149);
    if ((this.myd == null) || (this.myh == null))
    {
      AppMethodBeat.o(48149);
      return;
    }
    ae.i("MicroMsg.AppBrand.kv_13917", "report " + toString());
    this.myg = bu.fpO();
    g.yxI.f(13917, p.k(new Object[] { Integer.valueOf(this.myd.value), Integer.valueOf(this.mye), this.myf, Long.valueOf(this.myg), this.dlj, Integer.valueOf(this.myh.value) }));
    AppMethodBeat.o(48149);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(48148);
    String str = "kv_13917{scene=" + this.myd.value + ", appCount=" + this.mye + ", nearbyListId='" + this.myf + '\'' + ", clickTime=" + this.myg + ", sceneNote='" + this.dlj + '\'' + ", openType=" + this.myh.value + '}';
    AppMethodBeat.o(48148);
    return str;
  }
  
  public static enum a
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(48144);
      myi = new a("NEARBY_H5", 0, 1);
      myj = new a("EMPTY_PAGE", 1, 2);
      myk = new a("LBS_NOT_ALLOW", 2, 3);
      myl = new a("NEARBY_MINI_PROGRAM", 3, 4);
      mym = new a[] { myi, myj, myk, myl };
      AppMethodBeat.o(48144);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.l
 * JD-Core Version:    0.7.0.1
 */