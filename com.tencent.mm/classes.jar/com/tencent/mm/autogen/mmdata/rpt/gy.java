package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gy
  extends a
{
  public long iGN = 0L;
  public String iLJ = "";
  public String iLK = "";
  public long iLL = 0L;
  public String iLM = "";
  public String ijk = "";
  public String ipU = "";
  public long ipo = 0L;
  public String iwJ = "";
  public String iwK = "";
  public long izc = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(369102);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iLJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iLK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iLL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iLM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwK);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369102);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369107);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PageName:").append(this.iLJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StayTimeMs:").append(this.ipo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTimeMs:").append(this.iGN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitTimeMs:").append(this.izc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.ipU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sid:").append(this.iLK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reportType:").append(this.iLL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderContextID:").append(this.iLM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExtraInfo:").append(this.iwJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("enterSourceInfo:").append(this.iwK);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369107);
    return localObject;
  }
  
  public final gy eZ(long paramLong)
  {
    AppMethodBeat.i(369083);
    this.ipo = paramLong;
    super.bw("StayTimeMs", this.ipo);
    AppMethodBeat.o(369083);
    return this;
  }
  
  public final gy fa(long paramLong)
  {
    AppMethodBeat.i(369090);
    this.iGN = paramLong;
    super.bw("EnterTimeMs", this.iGN);
    AppMethodBeat.o(369090);
    return this;
  }
  
  public final gy fb(long paramLong)
  {
    AppMethodBeat.i(369095);
    this.izc = paramLong;
    super.bw("ExitTimeMs", this.izc);
    AppMethodBeat.o(369095);
    return this;
  }
  
  public final int getId()
  {
    return 19943;
  }
  
  public final gy ro(String paramString)
  {
    AppMethodBeat.i(369079);
    this.iLJ = F("PageName", paramString, true);
    AppMethodBeat.o(369079);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.gy
 * JD-Core Version:    0.7.0.1
 */