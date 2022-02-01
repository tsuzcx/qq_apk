package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class pi
  extends a
{
  public long jlH;
  public long jlI;
  public long jlJ;
  public String jlP = "";
  public long jlR;
  
  public final String aIE()
  {
    AppMethodBeat.i(369126);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jlH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlP);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369126);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369131);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PullStartTimeStamp:").append(this.jlH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PullEndTimeStamp:").append(this.jlI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSuccess:").append(this.jlJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WordSize:").append(this.jlR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WordVersion:").append(this.jlP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369131);
    return localObject;
  }
  
  public final int getId()
  {
    return 20203;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.pi
 * JD-Core Version:    0.7.0.1
 */