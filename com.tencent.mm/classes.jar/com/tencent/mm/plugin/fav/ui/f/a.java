package com.tencent.mm.plugin.fav.ui.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
{
  public int actionType = 1;
  public String kid;
  public int otZ;
  private int position = 0;
  public String query;
  private long rAG = 0L;
  public int rMk;
  public int rMl;
  public int rMm;
  private String rMn = "0";
  public String rMo;
  private int rMp = 0;
  public int rMq;
  private String rMr = "0";
  public long rMs;
  public long rMt;
  public boolean rMu = false;
  public int scene;
  
  public static String getSearchId()
  {
    AppMethodBeat.i(191108);
    String str = String.format("%s_%s", new Object[] { v.aAC(), Long.valueOf(System.currentTimeMillis()) });
    AppMethodBeat.o(191108);
    return str;
  }
  
  public final void report()
  {
    AppMethodBeat.i(191107);
    ae.d("MicroMsg.ReportSearchCTR", String.format("zst, 15488 on report, actionType %s, scene %s, subScene %s, actionTime %s, query %s, tabId %s, searchId:%s, searchCost:%s, localPosition %s, localResultCount %s", new Object[] { Integer.valueOf(this.actionType), Integer.valueOf(this.otZ), Integer.valueOf(this.scene), Integer.valueOf(this.rMk), this.query, Integer.valueOf(this.rMl), this.kid, Integer.valueOf(this.rMm), this.rMo, Integer.valueOf(this.rMq) }));
    g.yxI.f(15488, new Object[] { Integer.valueOf(this.actionType), Integer.valueOf(this.otZ), Integer.valueOf(this.scene), Integer.valueOf(this.position), Integer.valueOf(this.rMk), this.query, Long.valueOf(this.rAG), Integer.valueOf(this.rMl), this.kid, Integer.valueOf(this.rMm), this.rMn, this.rMo, Integer.valueOf(this.rMp), Integer.valueOf(this.rMq), this.rMr });
    AppMethodBeat.o(191107);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.f.a
 * JD-Core Version:    0.7.0.1
 */