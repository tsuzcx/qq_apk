package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ia
  extends a
{
  public int iPq;
  public int iPr;
  
  public final String aIE()
  {
    AppMethodBeat.i(369219);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iPq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPr);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369219);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369227);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Status:").append(this.iPq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IfGuide:").append(this.iPr);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369227);
    return localObject;
  }
  
  public final int getId()
  {
    return 21765;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ia
 * JD-Core Version:    0.7.0.1
 */