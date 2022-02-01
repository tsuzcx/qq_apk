package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class h
  extends a
{
  public String gdR = "";
  public String gdS = "";
  public String gdT = "";
  public long gdU;
  public long gdV;
  public long gdW;
  
  public final String agH()
  {
    AppMethodBeat.i(239746);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gdR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gdS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gdT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gdU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gdV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gdW);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(239746);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(239747);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("lastSessionId:").append(this.gdR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("currSessionId:").append(this.gdS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("nextSessionId:").append(this.gdT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("currSessionEnterMs:").append(this.gdU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("currSessionQuitMs:").append(this.gdV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("currSessionStayTime:").append(this.gdW);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(239747);
    return localObject;
  }
  
  public final int getId()
  {
    return 21948;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.h
 * JD-Core Version:    0.7.0.1
 */