package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class sg
  extends a
{
  private String imT = "";
  private String jjU = "";
  private String jxO = "";
  public long jxP;
  public long jxQ;
  
  public final String aIE()
  {
    AppMethodBeat.i(174645);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.imT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jxO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jjU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jxP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jxQ);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(174645);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(174646);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.imT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PagePath:").append(this.jxO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoUrl:").append(this.jjU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventId:").append(this.jxP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventNote:").append(this.jxQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(174646);
    return localObject;
  }
  
  public final int getId()
  {
    return 18837;
  }
  
  public final sg yT(String paramString)
  {
    AppMethodBeat.i(174642);
    this.imT = F("AppId", paramString, true);
    AppMethodBeat.o(174642);
    return this;
  }
  
  public final sg yU(String paramString)
  {
    AppMethodBeat.i(174643);
    this.jxO = F("PagePath", paramString, true);
    AppMethodBeat.o(174643);
    return this;
  }
  
  public final sg yV(String paramString)
  {
    AppMethodBeat.i(174644);
    this.jjU = F("VideoUrl", paramString, true);
    AppMethodBeat.o(174644);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.sg
 * JD-Core Version:    0.7.0.1
 */