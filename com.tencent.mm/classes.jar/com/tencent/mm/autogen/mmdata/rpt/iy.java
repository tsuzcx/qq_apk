package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class iy
  extends a
{
  public long iDB;
  public long iQU;
  private String iQZ = "";
  public String iRa = "";
  public long iRb;
  public long iRc;
  public long iRd;
  public int iRe;
  
  public final String aIE()
  {
    AppMethodBeat.i(368660);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iQZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iDB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iRa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iRb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iRc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iRd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iRe);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368660);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368666);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomId:").append(this.iQZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveId:").append(this.iDB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("micId:").append(this.iRa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveRole:").append(this.iQU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("groupRole:").append(this.iRb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("linkStatus:").append(this.iRc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceMode:").append(this.iRd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errorCode:").append(this.iRe);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368666);
    return localObject;
  }
  
  public final int getId()
  {
    return 19968;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.iy
 * JD-Core Version:    0.7.0.1
 */