package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dr
  extends a
{
  public String iAA = "";
  public int iAo;
  public String iAp = "";
  public long iAq;
  public long iAr;
  public long iAs;
  public String iAt = "";
  public int iAu;
  public int iAv;
  public int iAw;
  public int iAx;
  private String iAy = "";
  public String iAz = "";
  public String ilK = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(169253);
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
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iAy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iAz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iAA);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(169253);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(169254);
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
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Performance:").append(this.iAy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionPageId:").append(this.iAz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionKey:").append(this.iAA);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(169254);
    return localObject;
  }
  
  public final int getId()
  {
    return 18260;
  }
  
  public final dr nE(String paramString)
  {
    AppMethodBeat.i(169249);
    this.iAp = F("PName", paramString, true);
    AppMethodBeat.o(169249);
    return this;
  }
  
  public final dr nF(String paramString)
  {
    AppMethodBeat.i(169250);
    this.ilK = F("sessionId", paramString, true);
    AppMethodBeat.o(169250);
    return this;
  }
  
  public final dr nG(String paramString)
  {
    AppMethodBeat.i(169251);
    this.iAz = F("SessionPageId", paramString, true);
    AppMethodBeat.o(169251);
    return this;
  }
  
  public final dr nH(String paramString)
  {
    AppMethodBeat.i(169252);
    this.iAA = F("SessionKey", paramString, true);
    AppMethodBeat.o(169252);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.dr
 * JD-Core Version:    0.7.0.1
 */