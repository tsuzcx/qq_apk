package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ug
  extends a
{
  public long ijA;
  public long ixB;
  public long jFR;
  
  public final String aIE()
  {
    AppMethodBeat.i(368115);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jFR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixB);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368115);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368119);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("WordCount:").append(this.jFR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTime:").append(this.ijA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.ixB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368119);
    return localObject;
  }
  
  public final int getId()
  {
    return 20734;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ug
 * JD-Core Version:    0.7.0.1
 */