package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ct
  extends a
{
  public String dGR;
  public String dSJ;
  public long dSK = 0L;
  public long dSL = 0L;
  public long dSM = 0L;
  public long dSN = 0L;
  public String dSO;
  public String dSP;
  
  public final String PV()
  {
    AppMethodBeat.i(110276);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dGR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSP);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(110276);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(110277);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.dGR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LaunchUserName:").append(this.dSJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.dSK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("deleteCount:").append(this.dSL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("addCount:").append(this.dSM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EditScene:").append(this.dSN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Identifier:").append(this.dSO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Punctuation:").append(this.dSP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(110277);
    return localObject;
  }
  
  public final int getId()
  {
    return 18246;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ct
 * JD-Core Version:    0.7.0.1
 */