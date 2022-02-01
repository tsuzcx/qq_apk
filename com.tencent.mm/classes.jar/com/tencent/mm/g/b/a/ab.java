package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ab
  extends a
{
  public int dTY;
  private String dVZ = "";
  private String dWa = "";
  public int dWb = 0;
  
  public final String RC()
  {
    AppMethodBeat.i(163530);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWb);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(163530);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(163531);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.dTY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("F2FId:").append(this.dVZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QrCodeId:").append(this.dWa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalAmount:").append(this.dWb);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(163531);
    return localObject;
  }
  
  public final int getId()
  {
    return 18885;
  }
  
  public final ab hd(String paramString)
  {
    AppMethodBeat.i(163528);
    this.dVZ = t("F2FId", paramString, true);
    AppMethodBeat.o(163528);
    return this;
  }
  
  public final ab he(String paramString)
  {
    AppMethodBeat.i(163529);
    this.dWa = t("QrCodeId", paramString, true);
    AppMethodBeat.o(163529);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ab
 * JD-Core Version:    0.7.0.1
 */