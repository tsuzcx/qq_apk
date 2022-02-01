package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ik
  extends a
{
  public int iAo = 0;
  public String iAp = "";
  public long iAq = 0L;
  public long iAr = 0L;
  public long iAs = 0L;
  public String iAt = "";
  public int iAu = 0;
  public int iAv = 0;
  public int iAw = 0;
  public int iAx = 0;
  public String ilK = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(121751);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iAo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iAp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iAq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iAr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iAs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iAt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iAu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iAv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iAw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iAx);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(121751);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(121752);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PID:").append(this.iAo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PName:").append(this.iAp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionId:").append(this.ilK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("frontTime:").append(this.iAq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("stayTotalTime:").append(this.iAr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scrollTotalTime:").append(this.iAs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reportFeedList:").append(this.iAt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reportFeedCount:").append(this.iAu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Seq:").append(this.iAv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeq:").append(this.iAw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeqSum:").append(this.iAx);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121752);
    return localObject;
  }
  
  public final int getId()
  {
    return 16242;
  }
  
  public final ik rO(String paramString)
  {
    AppMethodBeat.i(121749);
    this.iAp = F("PName", paramString, true);
    AppMethodBeat.o(121749);
    return this;
  }
  
  public final ik rP(String paramString)
  {
    AppMethodBeat.i(121750);
    this.ilK = F("sessionId", paramString, true);
    AppMethodBeat.o(121750);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ik
 * JD-Core Version:    0.7.0.1
 */