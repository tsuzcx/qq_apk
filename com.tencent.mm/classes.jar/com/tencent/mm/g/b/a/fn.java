package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fn
  extends a
{
  public String dSR = "";
  public String emB = "";
  public long emM = 0L;
  public long emN = 0L;
  public long emx = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(221095);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emN);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(221095);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(221096);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.dSR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.emx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Identifier:").append(this.emB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DisplayCount:").append(this.emM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HideCount:").append(this.emN);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(221096);
    return localObject;
  }
  
  public final int getId()
  {
    return 19964;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fn
 * JD-Core Version:    0.7.0.1
 */