package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class k
{
  private String cmF;
  public k.b iHs;
  public int iHt;
  public String iHu;
  private long iHv;
  public k.a iHw;
  
  public final void IE()
  {
    AppMethodBeat.i(132644);
    if ((this.iHs == null) || (this.iHw == null))
    {
      AppMethodBeat.o(132644);
      return;
    }
    ab.i("MicroMsg.AppBrand.kv_13917", "report " + toString());
    this.iHv = bo.aoy();
    h.qsU.e(13917, l.k(new Object[] { Integer.valueOf(this.iHs.value), Integer.valueOf(this.iHt), this.iHu, Long.valueOf(this.iHv), this.cmF, Integer.valueOf(this.iHw.value) }));
    AppMethodBeat.o(132644);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(132643);
    String str = "kv_13917{scene=" + this.iHs.value + ", appCount=" + this.iHt + ", nearbyListId='" + this.iHu + '\'' + ", clickTime=" + this.iHv + ", sceneNote='" + this.cmF + '\'' + ", openType=" + this.iHw.value + '}';
    AppMethodBeat.o(132643);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.k
 * JD-Core Version:    0.7.0.1
 */