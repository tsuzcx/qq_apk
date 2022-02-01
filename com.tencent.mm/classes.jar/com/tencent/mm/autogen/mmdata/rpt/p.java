package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class p
  extends a
{
  public int ilm;
  public long iln;
  public long ilo;
  public long ilp;
  public long ilq;
  public String ilr = "";
  public String ils = "";
  public long ilt;
  
  public final String aIE()
  {
    AppMethodBeat.i(368536);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ilm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iln);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ils);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilt);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368536);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368539);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.ilm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReqNum:").append(this.iln);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RespNum:").append(this.ilo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DataStartTime:").append(this.ilp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DataEndTime:").append(this.ilq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReqContent:").append(this.ilr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RespContent:").append(this.ils);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DataNum:").append(this.ilt);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368539);
    return localObject;
  }
  
  public final int getId()
  {
    return 20808;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.p
 * JD-Core Version:    0.7.0.1
 */