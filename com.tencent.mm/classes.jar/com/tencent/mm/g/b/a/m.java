package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class m
  extends a
{
  public String dHE = "";
  public long dHF;
  public long dHG = 0L;
  public long dHH = 0L;
  public long dHI = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(184762);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHI);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(184762);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(184763);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomusrname:").append(this.dHE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exitType:").append(this.dHF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("role:").append(this.dHG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topBefore:").append(this.dHH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topAfter:").append(this.dHI);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184763);
    return localObject;
  }
  
  public final int getId()
  {
    return 19437;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.m
 * JD-Core Version:    0.7.0.1
 */