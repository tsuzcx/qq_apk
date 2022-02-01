package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class iv
  extends a
{
  public String iCb = "";
  public long iFo;
  public String iNB = "";
  private String iQS = "";
  public String iQT = "";
  public long iQx;
  public long iQy;
  public long iuA;
  
  public final String aIE()
  {
    AppMethodBeat.i(368690);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iuA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iNB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQT);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368690);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368699);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.iuA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomid:").append(this.iNB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.iFo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topic:").append(this.iCb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveuin:").append(this.iQS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.iQx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceCount:").append(this.iQy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveusername:").append(this.iQT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368699);
    return localObject;
  }
  
  public final int getId()
  {
    return 19896;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.iv
 * JD-Core Version:    0.7.0.1
 */