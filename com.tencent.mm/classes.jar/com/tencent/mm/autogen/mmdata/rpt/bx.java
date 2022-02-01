package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bx
  extends a
{
  public long ioV;
  private String ipT = "";
  private String iqO = "";
  private String ira = "";
  public long iuH;
  private String iuI = "";
  private String iuJ = "";
  private String iuK = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368772);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ioV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ira);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuK);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368772);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368779);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.ioV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrorReason:").append(this.iuH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedID:").append(this.iuI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LiveID:").append(this.iuJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotTipsID:").append(this.ira);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.iqO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.ipT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReportExtInfo:").append(this.iuK);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368779);
    return localObject;
  }
  
  public final int getId()
  {
    return 23083;
  }
  
  public final bx lj(String paramString)
  {
    AppMethodBeat.i(368743);
    this.iuI = F("FeedID", paramString, true);
    AppMethodBeat.o(368743);
    return this;
  }
  
  public final bx lk(String paramString)
  {
    AppMethodBeat.i(368746);
    this.iuJ = F("LiveID", paramString, true);
    AppMethodBeat.o(368746);
    return this;
  }
  
  public final bx ll(String paramString)
  {
    AppMethodBeat.i(368751);
    this.ira = F("RedDotTipsID", paramString, true);
    AppMethodBeat.o(368751);
    return this;
  }
  
  public final bx lm(String paramString)
  {
    AppMethodBeat.i(368755);
    this.iqO = F("SessionID", paramString, true);
    AppMethodBeat.o(368755);
    return this;
  }
  
  public final bx ln(String paramString)
  {
    AppMethodBeat.i(368762);
    this.ipT = F("ContextId", paramString, true);
    AppMethodBeat.o(368762);
    return this;
  }
  
  public final bx lo(String paramString)
  {
    AppMethodBeat.i(368766);
    this.iuK = F("ReportExtInfo", paramString, true);
    AppMethodBeat.o(368766);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.bx
 * JD-Core Version:    0.7.0.1
 */