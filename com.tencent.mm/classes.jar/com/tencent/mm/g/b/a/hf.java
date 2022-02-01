package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hf
  extends a
{
  public long erT = 0L;
  public long erU = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(91245);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.erT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erU);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(91245);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(91246);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ReportScene:").append(this.erT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ResetScece:").append(this.erU);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(91246);
    return localObject;
  }
  
  public final int getId()
  {
    return 15522;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hf
 * JD-Core Version:    0.7.0.1
 */