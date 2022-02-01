package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class rw
  extends a
{
  public long ioV = 0L;
  public long izR = 0L;
  private long jwF = 0L;
  private String jwG = "";
  public long jwH = 0L;
  private String jwI = "";
  private String jwM = "";
  private String jwN = "";
  private String jwO = "";
  private String jwP = "";
  public long jwQ;
  public long jwR;
  
  public final String aIE()
  {
    AppMethodBeat.i(368662);
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
    ((StringBuffer)localObject).append(this.jwM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jwN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jwO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jwP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jwQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jwR);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368662);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368667);
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
    ((StringBuffer)localObject).append("ShareSessionId:").append(this.jwM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShareSearchId:").append(this.jwN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShareRequestId:").append(this.jwO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShareDocId:").append(this.jwP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShareBizType:").append(this.jwQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShareSubType:").append(this.jwR);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368667);
    return localObject;
  }
  
  public final rw aIX()
  {
    this.jwF = 2L;
    return this;
  }
  
  public final int getId()
  {
    return 20997;
  }
  
  public final rw yD(String paramString)
  {
    AppMethodBeat.i(368629);
    this.jwG = F("ResultQuery", paramString, true);
    AppMethodBeat.o(368629);
    return this;
  }
  
  public final rw yE(String paramString)
  {
    AppMethodBeat.i(368636);
    this.jwI = F("ShareSceneId", paramString, true);
    AppMethodBeat.o(368636);
    return this;
  }
  
  public final rw yF(String paramString)
  {
    AppMethodBeat.i(368644);
    this.jwM = F("ShareSessionId", paramString, true);
    AppMethodBeat.o(368644);
    return this;
  }
  
  public final rw yG(String paramString)
  {
    AppMethodBeat.i(368648);
    this.jwN = F("ShareSearchId", paramString, true);
    AppMethodBeat.o(368648);
    return this;
  }
  
  public final rw yH(String paramString)
  {
    AppMethodBeat.i(368653);
    this.jwO = F("ShareRequestId", paramString, true);
    AppMethodBeat.o(368653);
    return this;
  }
  
  public final rw yI(String paramString)
  {
    AppMethodBeat.i(368656);
    this.jwP = F("ShareDocId", paramString, true);
    AppMethodBeat.o(368656);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.rw
 * JD-Core Version:    0.7.0.1
 */