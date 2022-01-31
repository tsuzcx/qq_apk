package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bv
  extends a
{
  public long cYR = 0L;
  private String cYW = "";
  public long cYX = 0L;
  
  public final String Ff()
  {
    AppMethodBeat.i(56605);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cYR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cYW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cYX);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(56605);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(56606);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ReportScene:").append(this.cYR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TransferUserName:").append(this.cYW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TransferAmount:").append(this.cYX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(56606);
    return localObject;
  }
  
  public final bv gR(String paramString)
  {
    AppMethodBeat.i(56604);
    this.cYW = t("TransferUserName", paramString, true);
    AppMethodBeat.o(56604);
    return this;
  }
  
  public final int getId()
  {
    return 16016;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bv
 * JD-Core Version:    0.7.0.1
 */