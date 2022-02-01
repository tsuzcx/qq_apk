package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class l
{
  private String cYP;
  public l.b lTr;
  public int lTs;
  public String lTt;
  private long lTu;
  public a lTv;
  
  public final void report()
  {
    AppMethodBeat.i(48149);
    if ((this.lTr == null) || (this.lTv == null))
    {
      AppMethodBeat.o(48149);
      return;
    }
    ac.i("MicroMsg.AppBrand.kv_13917", "report " + toString());
    this.lTu = bs.eWj();
    h.wUl.f(13917, o.l(new Object[] { Integer.valueOf(this.lTr.value), Integer.valueOf(this.lTs), this.lTt, Long.valueOf(this.lTu), this.cYP, Integer.valueOf(this.lTv.value) }));
    AppMethodBeat.o(48149);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(48148);
    String str = "kv_13917{scene=" + this.lTr.value + ", appCount=" + this.lTs + ", nearbyListId='" + this.lTt + '\'' + ", clickTime=" + this.lTu + ", sceneNote='" + this.cYP + '\'' + ", openType=" + this.lTv.value + '}';
    AppMethodBeat.o(48148);
    return str;
  }
  
  public static enum a
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(48144);
      lTw = new a("NEARBY_H5", 0, 1);
      lTx = new a("EMPTY_PAGE", 1, 2);
      lTy = new a("LBS_NOT_ALLOW", 2, 3);
      lTz = new a("NEARBY_MINI_PROGRAM", 3, 4);
      lTA = new a[] { lTw, lTx, lTy, lTz };
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