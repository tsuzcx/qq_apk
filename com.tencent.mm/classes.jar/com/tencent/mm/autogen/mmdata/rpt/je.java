package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class je
  extends a
{
  public String iCb = "";
  public long iFo;
  public String iNB = "";
  public String iQT = "";
  public long iQU;
  public long iQx;
  public long iSf;
  public long iSg;
  
  public final String aIE()
  {
    AppMethodBeat.i(368613);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iNB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSg);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368613);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368618);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.iNB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.iFo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topic:").append(this.iCb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveusername:").append(this.iQT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveRole:").append(this.iQU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.iQx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("wholeTime:").append(this.iSf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("viewTime:").append(this.iSg);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368618);
    return localObject;
  }
  
  public final int getId()
  {
    return 19898;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.je
 * JD-Core Version:    0.7.0.1
 */