package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class l
{
  private String fvd;
  public b qLr;
  public int qLs;
  public String qLt;
  private long qLu;
  public a qLv;
  
  public final void report()
  {
    AppMethodBeat.i(48149);
    if ((this.qLr == null) || (this.qLv == null))
    {
      AppMethodBeat.o(48149);
      return;
    }
    Log.i("MicroMsg.AppBrand.kv_13917", "report " + toString());
    this.qLu = Util.nowMilliSecond();
    h.IzE.a(13917, t.j(new Object[] { Integer.valueOf(this.qLr.value), Integer.valueOf(this.qLs), this.qLt, Long.valueOf(this.qLu), this.fvd, Integer.valueOf(this.qLv.value) }));
    AppMethodBeat.o(48149);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(48148);
    String str = "kv_13917{scene=" + this.qLr.value + ", appCount=" + this.qLs + ", nearbyListId='" + this.qLt + '\'' + ", clickTime=" + this.qLu + ", sceneNote='" + this.fvd + '\'' + ", openType=" + this.qLv.value + '}';
    AppMethodBeat.o(48148);
    return str;
  }
  
  public static enum a
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(48144);
      qLw = new a("NEARBY_H5", 0, 1);
      qLx = new a("EMPTY_PAGE", 1, 2);
      qLy = new a("LBS_NOT_ALLOW", 2, 3);
      qLz = new a("NEARBY_MINI_PROGRAM", 3, 4);
      qLA = new a[] { qLw, qLx, qLy, qLz };
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
      qLB = new b("DESKTOP_SEARCH", 0, 1);
      qLC = new b("RESUME_FROM_WEAPP_EXIT", 1, 2);
      qLD = new b("BOTTOM_ENTRANCE_IN_DESKTOP", 2, 3);
      qLE = new b("TOP_ENTRANCE_IN_DESKTOP", 3, 4);
      qLF = new b[] { qLB, qLC, qLD, qLE };
      AppMethodBeat.o(48147);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.l
 * JD-Core Version:    0.7.0.1
 */