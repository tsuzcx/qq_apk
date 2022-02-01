package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mf
  extends a
{
  public long iLB;
  public String ipW = "";
  public long iuA;
  
  public final String aIE()
  {
    AppMethodBeat.i(368435);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ipW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iLB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuA);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368435);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368439);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("feedid:").append(this.ipW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedtype:").append(this.iLB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.iuA);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368439);
    return localObject;
  }
  
  public final int getId()
  {
    return 24158;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.mf
 * JD-Core Version:    0.7.0.1
 */