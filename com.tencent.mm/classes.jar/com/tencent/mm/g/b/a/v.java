package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class v
  extends a
{
  public int dHQ;
  private String dJC;
  private String dJD;
  public int dJE = 0;
  
  public final String PV()
  {
    AppMethodBeat.i(163530);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJE);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(163530);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(163531);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.dHQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("F2FId:").append(this.dJC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QrCodeId:").append(this.dJD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalAmount:").append(this.dJE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(163531);
    return localObject;
  }
  
  public final v ge(String paramString)
  {
    AppMethodBeat.i(163528);
    this.dJC = t("F2FId", paramString, true);
    AppMethodBeat.o(163528);
    return this;
  }
  
  public final int getId()
  {
    return 18885;
  }
  
  public final v gf(String paramString)
  {
    AppMethodBeat.i(163529);
    this.dJD = t("QrCodeId", paramString, true);
    AppMethodBeat.o(163529);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.v
 * JD-Core Version:    0.7.0.1
 */