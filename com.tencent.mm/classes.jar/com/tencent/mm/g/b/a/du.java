package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class du
  extends a
{
  public long dHq = 0L;
  public String dHr;
  public long dMe = 0L;
  public String dNE = "";
  private String dRR = "";
  public String dVB = "";
  public long dVC = 0L;
  public String dVD;
  private int dVE;
  public String dVF;
  
  public final String PV()
  {
    AppMethodBeat.i(193418);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dMe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVF);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(193418);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(193419);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.dHq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Word:").append(this.dVB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExpId:").append(this.dRR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Position:").append(this.dMe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("md5:").append(this.dNE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalCount:").append(this.dVC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Index:").append(this.dVD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dHr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsLocal:").append(this.dVE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsLocalSearch:").append(this.dVF);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(193419);
    return localObject;
  }
  
  public final int getId()
  {
    return 10994;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.du
 * JD-Core Version:    0.7.0.1
 */