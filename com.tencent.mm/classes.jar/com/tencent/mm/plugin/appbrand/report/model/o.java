package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.v;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class o
{
  private String hzx;
  public b tPY;
  public int tPZ;
  public String tQa;
  private long tQb;
  public a tQc;
  
  public final void report()
  {
    AppMethodBeat.i(48149);
    if ((this.tPY == null) || (this.tQc == null))
    {
      AppMethodBeat.o(48149);
      return;
    }
    Log.i("MicroMsg.AppBrand.kv_13917", "report " + toString());
    this.tQb = Util.nowMilliSecond();
    h.OAn.b(13917, v.l(new Object[] { Integer.valueOf(this.tPY.value), Integer.valueOf(this.tPZ), this.tQa, Long.valueOf(this.tQb), this.hzx, Integer.valueOf(this.tQc.value) }));
    AppMethodBeat.o(48149);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(48148);
    String str = "kv_13917{scene=" + this.tPY.value + ", appCount=" + this.tPZ + ", nearbyListId='" + this.tQa + '\'' + ", clickTime=" + this.tQb + ", sceneNote='" + this.hzx + '\'' + ", openType=" + this.tQc.value + '}';
    AppMethodBeat.o(48148);
    return str;
  }
  
  public static enum a
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(48144);
      tQd = new a("NEARBY_H5", 0, 1);
      tQe = new a("EMPTY_PAGE", 1, 2);
      tQf = new a("LBS_NOT_ALLOW", 2, 3);
      tQg = new a("NEARBY_MINI_PROGRAM", 3, 4);
      tQh = new a[] { tQd, tQe, tQf, tQg };
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
      tQi = new b("DESKTOP_SEARCH", 0, 1);
      tQj = new b("RESUME_FROM_WEAPP_EXIT", 1, 2);
      tQk = new b("BOTTOM_ENTRANCE_IN_DESKTOP", 2, 3);
      tQl = new b("TOP_ENTRANCE_IN_DESKTOP", 3, 4);
      tQm = new b[] { tQi, tQj, tQk, tQl };
      AppMethodBeat.o(48147);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.o
 * JD-Core Version:    0.7.0.1
 */