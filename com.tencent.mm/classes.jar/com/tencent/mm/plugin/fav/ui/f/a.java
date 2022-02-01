package com.tencent.mm.plugin.fav.ui.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
{
  public int actionType = 1;
  public String keN;
  public int ooi;
  private int position = 0;
  public String query;
  public int rDZ;
  public int rEa;
  public int rEb;
  private String rEc = "0";
  public String rEd;
  private int rEe = 0;
  public int rEf;
  private String rEg = "0";
  public long rEh;
  public long rEi;
  public boolean rEj = false;
  private long rst = 0L;
  public int scene;
  
  public static String getSearchId()
  {
    AppMethodBeat.i(218833);
    String str = String.format("%s_%s", new Object[] { u.aAm(), Long.valueOf(System.currentTimeMillis()) });
    AppMethodBeat.o(218833);
    return str;
  }
  
  public final void report()
  {
    AppMethodBeat.i(218832);
    ad.d("MicroMsg.ReportSearchCTR", String.format("zst, 15488 on report, actionType %s, scene %s, subScene %s, actionTime %s, query %s, tabId %s, searchId:%s, searchCost:%s, localPosition %s, localResultCount %s", new Object[] { Integer.valueOf(this.actionType), Integer.valueOf(this.ooi), Integer.valueOf(this.scene), Integer.valueOf(this.rDZ), this.query, Integer.valueOf(this.rEa), this.keN, Integer.valueOf(this.rEb), this.rEd, Integer.valueOf(this.rEf) }));
    g.yhR.f(15488, new Object[] { Integer.valueOf(this.actionType), Integer.valueOf(this.ooi), Integer.valueOf(this.scene), Integer.valueOf(this.position), Integer.valueOf(this.rDZ), this.query, Long.valueOf(this.rst), Integer.valueOf(this.rEa), this.keN, Integer.valueOf(this.rEb), this.rEc, this.rEd, Integer.valueOf(this.rEe), Integer.valueOf(this.rEf), this.rEg });
    AppMethodBeat.o(218832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.f.a
 * JD-Core Version:    0.7.0.1
 */