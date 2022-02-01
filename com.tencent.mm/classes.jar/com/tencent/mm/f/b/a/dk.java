package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dk
  extends a
{
  private String gcU = "";
  private long giq;
  private String gnE = "";
  private long gpY;
  
  public final String agH()
  {
    AppMethodBeat.i(253673);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.giq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcU);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(253673);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(253675);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.giq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionResult:").append(this.gnE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeMs:").append(this.gpY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(253675);
    return localObject;
  }
  
  public final long ahB()
  {
    return this.gpY;
  }
  
  public final long ahC()
  {
    return this.giq;
  }
  
  public final String ahi()
  {
    return this.gnE;
  }
  
  public final int getId()
  {
    return 21919;
  }
  
  public final String getSessionId()
  {
    return this.gcU;
  }
  
  public final dk iI(long paramLong)
  {
    this.giq = paramLong;
    return this;
  }
  
  public final dk iJ(long paramLong)
  {
    AppMethodBeat.i(253668);
    this.gpY = paramLong;
    super.bk("ActionTimeMs", this.gpY);
    AppMethodBeat.o(253668);
    return this;
  }
  
  public final dk pV(String paramString)
  {
    AppMethodBeat.i(253667);
    this.gnE = z("ActionResult", paramString, true);
    AppMethodBeat.o(253667);
    return this;
  }
  
  public final dk pW(String paramString)
  {
    AppMethodBeat.i(253670);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(253670);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.dk
 * JD-Core Version:    0.7.0.1
 */