package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class l
{
  private String dCw;
  public l.b nJe;
  public int nJf;
  public String nJg;
  private long nJh;
  public a nJi;
  
  public final void report()
  {
    AppMethodBeat.i(48149);
    if ((this.nJe == null) || (this.nJi == null))
    {
      AppMethodBeat.o(48149);
      return;
    }
    Log.i("MicroMsg.AppBrand.kv_13917", "report " + toString());
    this.nJh = Util.nowMilliSecond();
    h.CyF.a(13917, s.k(new Object[] { Integer.valueOf(this.nJe.value), Integer.valueOf(this.nJf), this.nJg, Long.valueOf(this.nJh), this.dCw, Integer.valueOf(this.nJi.value) }));
    AppMethodBeat.o(48149);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(48148);
    String str = "kv_13917{scene=" + this.nJe.value + ", appCount=" + this.nJf + ", nearbyListId='" + this.nJg + '\'' + ", clickTime=" + this.nJh + ", sceneNote='" + this.dCw + '\'' + ", openType=" + this.nJi.value + '}';
    AppMethodBeat.o(48148);
    return str;
  }
  
  public static enum a
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(48144);
      nJj = new a("NEARBY_H5", 0, 1);
      nJk = new a("EMPTY_PAGE", 1, 2);
      nJl = new a("LBS_NOT_ALLOW", 2, 3);
      nJm = new a("NEARBY_MINI_PROGRAM", 3, 4);
      nJn = new a[] { nJj, nJk, nJl, nJm };
      AppMethodBeat.o(48144);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.l
 * JD-Core Version:    0.7.0.1
 */