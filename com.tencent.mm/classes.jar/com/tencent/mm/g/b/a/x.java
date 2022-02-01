package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class x
  extends a
{
  public int dFD;
  private String dHE;
  private String dHF;
  public int dHG = 0;
  
  public final String PR()
  {
    AppMethodBeat.i(163530);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHG);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(163530);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(163531);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.dFD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("F2FId:").append(this.dHE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QrCodeId:").append(this.dHF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalAmount:").append(this.dHG);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(163531);
    return localObject;
  }
  
  public final x fV(String paramString)
  {
    AppMethodBeat.i(163528);
    this.dHE = t("F2FId", paramString, true);
    AppMethodBeat.o(163528);
    return this;
  }
  
  public final x fW(String paramString)
  {
    AppMethodBeat.i(163529);
    this.dHF = t("QrCodeId", paramString, true);
    AppMethodBeat.o(163529);
    return this;
  }
  
  public final int getId()
  {
    return 18885;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.x
 * JD-Core Version:    0.7.0.1
 */