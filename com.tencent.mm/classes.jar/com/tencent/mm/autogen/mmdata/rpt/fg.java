package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fg
  extends a
{
  private long iGN;
  public long iGO;
  public long iGP;
  public long iGQ;
  public long iGR;
  public long iGS;
  public long inc;
  public String inx = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368055);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.inx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGS);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368055);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368062);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.inx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTimeMs:").append(this.iGN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsRedDotEnter:").append(this.iGO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Event:").append(this.inc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BannerType:").append(this.iGP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventTime:").append(this.iGQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsHaveRedDot:").append(this.iGR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgCnt:").append(this.iGS);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368062);
    return localObject;
  }
  
  public final fg eV(long paramLong)
  {
    AppMethodBeat.i(368049);
    this.iGN = paramLong;
    super.bw("EnterTimeMs", this.iGN);
    AppMethodBeat.o(368049);
    return this;
  }
  
  public final int getId()
  {
    return 20372;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.fg
 * JD-Core Version:    0.7.0.1
 */