package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bz
  extends a
{
  public int ipH;
  private String iuN = "";
  private String iuO = "";
  public int iuP = 0;
  
  public final String aIE()
  {
    AppMethodBeat.i(163530);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ipH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuP);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(163530);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(163531);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.ipH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("F2FId:").append(this.iuN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QrCodeId:").append(this.iuO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalAmount:").append(this.iuP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(163531);
    return localObject;
  }
  
  public final int getId()
  {
    return 18885;
  }
  
  public final bz lp(String paramString)
  {
    AppMethodBeat.i(163528);
    this.iuN = F("F2FId", paramString, true);
    AppMethodBeat.o(163528);
    return this;
  }
  
  public final bz lq(String paramString)
  {
    AppMethodBeat.i(163529);
    this.iuO = F("QrCodeId", paramString, true);
    AppMethodBeat.o(163529);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.bz
 * JD-Core Version:    0.7.0.1
 */