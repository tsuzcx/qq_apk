package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class r
  extends a
{
  public int ilA = 0;
  public int ilB = 0;
  public int ilC = 0;
  public int ilD = 0;
  public int ilE = 0;
  
  public final String aIE()
  {
    AppMethodBeat.i(368556);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ilA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilE);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368556);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368564);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("memory:").append(this.ilA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isSingleProcessStrategy:").append(this.ilB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasAppBrandRunning:").append(this.ilC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("runningAppBrandCount:").append(this.ilD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("maxProcessMemory:").append(this.ilE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368564);
    return localObject;
  }
  
  public final int getId()
  {
    return 21711;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.r
 * JD-Core Version:    0.7.0.1
 */