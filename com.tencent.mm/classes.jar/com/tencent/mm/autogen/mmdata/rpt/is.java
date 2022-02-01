package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class is
  extends a
{
  public long iFo;
  public String iNB = "";
  public long iQG = 0L;
  public long iQH;
  private String iQI = "";
  public long iQJ;
  private long isX;
  
  public final String aIE()
  {
    AppMethodBeat.i(368741);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iNB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.isX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQJ);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368741);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368745);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.iNB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.iFo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("waitCount:").append(this.iQG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("allowConnect:").append(this.iQH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceUin:").append(this.iQI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionCode:").append(this.isX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("linkCount:").append(this.iQJ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368745);
    return localObject;
  }
  
  public final int getId()
  {
    return 19894;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.is
 * JD-Core Version:    0.7.0.1
 */