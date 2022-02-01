package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class rv
  extends a
{
  public long ioV = 0L;
  public long izR = 0L;
  public long jwF = 0L;
  private String jwG = "";
  public long jwH = 0L;
  private String jwI = "";
  public long jwJ;
  public long jwK;
  private String jwL = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368702);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ioV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jwF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jwG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jwH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jwI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jwJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jwK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jwL);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368702);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368707);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.ioV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeStamp:").append(this.izR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ResultType:").append(this.jwF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ResultQuery:").append(this.jwG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShareScene:").append(this.jwH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShareSceneId:").append(this.jwI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CreateTime:").append(this.jwJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TimelineEnterSource:").append(this.jwK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SearchSessionId:").append(this.jwL);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368707);
    return localObject;
  }
  
  public final int getId()
  {
    return 20998;
  }
  
  public final rv yA(String paramString)
  {
    AppMethodBeat.i(368683);
    this.jwG = F("ResultQuery", paramString, true);
    AppMethodBeat.o(368683);
    return this;
  }
  
  public final rv yB(String paramString)
  {
    AppMethodBeat.i(368688);
    this.jwI = F("ShareSceneId", paramString, true);
    AppMethodBeat.o(368688);
    return this;
  }
  
  public final rv yC(String paramString)
  {
    AppMethodBeat.i(368695);
    this.jwL = F("SearchSessionId", paramString, true);
    AppMethodBeat.o(368695);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.rv
 * JD-Core Version:    0.7.0.1
 */