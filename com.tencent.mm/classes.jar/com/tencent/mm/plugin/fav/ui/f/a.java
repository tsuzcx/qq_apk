package com.tencent.mm.plugin.fav.ui.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  public int AcJ;
  private long Acx = 0L;
  public int AoY;
  public int AoZ;
  private String Apa = "0";
  public String Apb;
  private int Apc = 0;
  public int Apd;
  private String Ape = "0";
  public long Apf;
  public long Apg;
  public boolean Aph = false;
  public int actionType = 1;
  public int idY;
  public String mpa;
  private int position = 0;
  public String query;
  public int scene;
  
  public static String getSearchId()
  {
    AppMethodBeat.i(274373);
    String str = String.format("%s_%s", new Object[] { z.bAM(), Long.valueOf(System.currentTimeMillis()) });
    AppMethodBeat.o(274373);
    return str;
  }
  
  public final void report()
  {
    AppMethodBeat.i(274375);
    Log.d("MicroMsg.ReportSearchCTR", String.format("zst, 15488 on report, actionType %s, scene %s, subScene %s, actionTime %s, query %s, tabId %s, searchId:%s, searchCost:%s, localPosition %s, localResultCount %s", new Object[] { Integer.valueOf(this.actionType), Integer.valueOf(this.AcJ), Integer.valueOf(this.scene), Integer.valueOf(this.AoY), this.query, Integer.valueOf(this.idY), this.mpa, Integer.valueOf(this.AoZ), this.Apb, Integer.valueOf(this.Apd) }));
    h.OAn.b(15488, new Object[] { Integer.valueOf(this.actionType), Integer.valueOf(this.AcJ), Integer.valueOf(this.scene), Integer.valueOf(this.position), Integer.valueOf(this.AoY), this.query, Long.valueOf(this.Acx), Integer.valueOf(this.idY), this.mpa, Integer.valueOf(this.AoZ), this.Apa, this.Apb, Integer.valueOf(this.Apc), Integer.valueOf(this.Apd), this.Ape });
    AppMethodBeat.o(274375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.f.a
 * JD-Core Version:    0.7.0.1
 */