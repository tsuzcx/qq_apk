package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ab
  extends a
{
  public int dSI;
  private String dUJ;
  private String dUK;
  public int dUL = 0;
  
  public final String RD()
  {
    AppMethodBeat.i(163530);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUL);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(163530);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(163531);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.dSI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("F2FId:").append(this.dUJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QrCodeId:").append(this.dUK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalAmount:").append(this.dUL);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(163531);
    return localObject;
  }
  
  public final ab gX(String paramString)
  {
    AppMethodBeat.i(163528);
    this.dUJ = t("F2FId", paramString, true);
    AppMethodBeat.o(163528);
    return this;
  }
  
  public final ab gY(String paramString)
  {
    AppMethodBeat.i(163529);
    this.dUK = t("QrCodeId", paramString, true);
    AppMethodBeat.o(163529);
    return this;
  }
  
  public final int getId()
  {
    return 18885;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ab
 * JD-Core Version:    0.7.0.1
 */