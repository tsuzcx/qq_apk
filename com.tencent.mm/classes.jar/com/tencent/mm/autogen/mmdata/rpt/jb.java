package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jb
  extends a
{
  public long iFo;
  public String iNB = "";
  public long iQU;
  public long iQx;
  private long iRr = 0L;
  public long iRs;
  public String iRt = "";
  public String iRu = "";
  public long iRv;
  public long ila;
  public long inE;
  
  public final String aIE()
  {
    AppMethodBeat.i(368579);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iNB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iRr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ila);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iRs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iRt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iRu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iRv);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368579);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368583);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.iNB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.iFo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceUin:").append(this.iRr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveRole:").append(this.iQU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.iQx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.ila);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionResult:").append(this.iRs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionTS:").append(this.inE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceUserName:").append(this.iRt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("anchorusername:").append(this.iRu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audiencecount:").append(this.iRv);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368583);
    return localObject;
  }
  
  public final int getId()
  {
    return 19893;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.jb
 * JD-Core Version:    0.7.0.1
 */