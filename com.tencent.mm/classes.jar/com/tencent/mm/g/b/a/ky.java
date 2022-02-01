package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ky
  extends a
{
  public long eXG = 0L;
  public long eXH = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(91245);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eXG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXH);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(91245);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(91246);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ReportScene:").append(this.eXG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ResetScece:").append(this.eXH);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(91246);
    return localObject;
  }
  
  public final int getId()
  {
    return 15522;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ky
 * JD-Core Version:    0.7.0.1
 */