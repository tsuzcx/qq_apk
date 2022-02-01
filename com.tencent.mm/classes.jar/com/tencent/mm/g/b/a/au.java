package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class au
  extends a
{
  public int enW;
  private String eqs = "";
  private String eqt = "";
  public int equ = 0;
  
  public final String abV()
  {
    AppMethodBeat.i(163530);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.enW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.equ);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(163530);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(163531);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.enW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("F2FId:").append(this.eqs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QrCodeId:").append(this.eqt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalAmount:").append(this.equ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(163531);
    return localObject;
  }
  
  public final int getId()
  {
    return 18885;
  }
  
  public final au iA(String paramString)
  {
    AppMethodBeat.i(163528);
    this.eqs = x("F2FId", paramString, true);
    AppMethodBeat.o(163528);
    return this;
  }
  
  public final au iB(String paramString)
  {
    AppMethodBeat.i(163529);
    this.eqt = x("QrCodeId", paramString, true);
    AppMethodBeat.o(163529);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.au
 * JD-Core Version:    0.7.0.1
 */