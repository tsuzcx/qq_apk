package com.tencent.mm.plugin.fav.ui.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  public int actionType = 1;
  public int fXY;
  public String jQi;
  private int position = 0;
  public String query;
  public int scene;
  public int wGA;
  private long wGo = 0L;
  public int wSA;
  private String wSB = "0";
  public long wSC;
  public long wSD;
  public boolean wSE = false;
  public int wSv;
  public int wSw;
  private String wSx = "0";
  public String wSy;
  private int wSz = 0;
  
  public static String getSearchId()
  {
    AppMethodBeat.i(231578);
    String str = String.format("%s_%s", new Object[] { z.bcZ(), Long.valueOf(System.currentTimeMillis()) });
    AppMethodBeat.o(231578);
    return str;
  }
  
  public final void report()
  {
    AppMethodBeat.i(231576);
    Log.d("MicroMsg.ReportSearchCTR", String.format("zst, 15488 on report, actionType %s, scene %s, subScene %s, actionTime %s, query %s, tabId %s, searchId:%s, searchCost:%s, localPosition %s, localResultCount %s", new Object[] { Integer.valueOf(this.actionType), Integer.valueOf(this.wGA), Integer.valueOf(this.scene), Integer.valueOf(this.wSv), this.query, Integer.valueOf(this.fXY), this.jQi, Integer.valueOf(this.wSw), this.wSy, Integer.valueOf(this.wSA) }));
    h.IzE.a(15488, new Object[] { Integer.valueOf(this.actionType), Integer.valueOf(this.wGA), Integer.valueOf(this.scene), Integer.valueOf(this.position), Integer.valueOf(this.wSv), this.query, Long.valueOf(this.wGo), Integer.valueOf(this.fXY), this.jQi, Integer.valueOf(this.wSw), this.wSx, this.wSy, Integer.valueOf(this.wSz), Integer.valueOf(this.wSA), this.wSB });
    AppMethodBeat.o(231576);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.g.a
 * JD-Core Version:    0.7.0.1
 */