package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class pg
  extends a
{
  public String ijk = "";
  public long jlH;
  public long jlI;
  public long jlJ;
  public long jlK;
  
  public final String aIE()
  {
    AppMethodBeat.i(369156);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlK);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369156);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369162);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PullStartTimeStamp:").append(this.jlH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PullEndTimeStamp:").append(this.jlI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSuccess:").append(this.jlJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FailedType:").append(this.jlK);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369162);
    return localObject;
  }
  
  public final int getId()
  {
    return 20205;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.pg
 * JD-Core Version:    0.7.0.1
 */