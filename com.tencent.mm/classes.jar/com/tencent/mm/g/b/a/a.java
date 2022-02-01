package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends com.tencent.mm.plugin.report.a
{
  public long dCO;
  public String dCP;
  public long dCQ = 0L;
  public String dCR;
  
  public final String PR()
  {
    AppMethodBeat.i(185997);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dCO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dCP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dCQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dCR);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(185997);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(185998);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Requestcode:").append(this.dCO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProcessName:").append(this.dCP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dCQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Stack:").append(this.dCR);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(185998);
    return localObject;
  }
  
  public final int getId()
  {
    return 19574;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.a
 * JD-Core Version:    0.7.0.1
 */