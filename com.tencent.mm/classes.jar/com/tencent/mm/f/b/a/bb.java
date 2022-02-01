package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bb
  extends a
{
  private long giq;
  private String gjO = "";
  private String gjj = "";
  private long glC;
  private String glD = "";
  private String glE = "";
  private String glF = "";
  private String glG = "";
  
  public final String agH()
  {
    AppMethodBeat.i(207562);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.giq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glG);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(207562);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(207564);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.giq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrorReason:").append(this.glC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedID:").append(this.glD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LiveID:").append(this.glE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotTipsID:").append(this.glF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.gjO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.gjj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReportExtInfo:").append(this.glG);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(207564);
    return localObject;
  }
  
  public final bb agR()
  {
    this.giq = 1L;
    return this;
  }
  
  public final bb dC(long paramLong)
  {
    this.glC = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 23083;
  }
  
  public final bb jB(String paramString)
  {
    AppMethodBeat.i(207547);
    this.glD = z("FeedID", paramString, true);
    AppMethodBeat.o(207547);
    return this;
  }
  
  public final bb jC(String paramString)
  {
    AppMethodBeat.i(207550);
    this.glE = z("LiveID", paramString, true);
    AppMethodBeat.o(207550);
    return this;
  }
  
  public final bb jD(String paramString)
  {
    AppMethodBeat.i(207554);
    this.glF = z("RedDotTipsID", paramString, true);
    AppMethodBeat.o(207554);
    return this;
  }
  
  public final bb jE(String paramString)
  {
    AppMethodBeat.i(207555);
    this.gjO = z("SessionID", paramString, true);
    AppMethodBeat.o(207555);
    return this;
  }
  
  public final bb jF(String paramString)
  {
    AppMethodBeat.i(207558);
    this.gjj = z("ContextId", paramString, true);
    AppMethodBeat.o(207558);
    return this;
  }
  
  public final bb jG(String paramString)
  {
    AppMethodBeat.i(207559);
    this.glG = z("ReportExtInfo", paramString, true);
    AppMethodBeat.o(207559);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.bb
 * JD-Core Version:    0.7.0.1
 */