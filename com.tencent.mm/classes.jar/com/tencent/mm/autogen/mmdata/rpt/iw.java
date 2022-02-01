package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class iw
  extends a
{
  public String iCb = "";
  public long iFo;
  public String iNB = "";
  public String iQT = "";
  public long iQU;
  public long iQV;
  public long iQW;
  public long iQx;
  public long iuA;
  
  public final String aIE()
  {
    AppMethodBeat.i(368704);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iNB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQW);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368704);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368712);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.iNB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.iFo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topic:").append(this.iCb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveusername:").append(this.iQT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.iuA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveRole:").append(this.iQU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.iQx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("replayStatusEnd:").append(this.iQV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("replayStatusBegin:").append(this.iQW);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368712);
    return localObject;
  }
  
  public final int getId()
  {
    return 19897;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.iw
 * JD-Core Version:    0.7.0.1
 */