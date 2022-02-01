package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ns
  extends a
{
  public int jeZ = 0;
  public String jfM = "";
  private long jfN = 0L;
  private int jfO = 0;
  public String jfP = "";
  private long jfQ = 0L;
  private int jfR = 0;
  
  public final String aIE()
  {
    AppMethodBeat.i(367791);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jeZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfR);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(367791);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(367798);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Code:").append(this.jeZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StringParam1:").append(this.jfM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LongParam1:").append(this.jfN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IntParam1:").append(this.jfO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StringParam2:").append(this.jfP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LongParam2:").append(this.jfQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IntParam2:").append(this.jfR);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(367798);
    return localObject;
  }
  
  public final int getId()
  {
    return 23879;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ns
 * JD-Core Version:    0.7.0.1
 */