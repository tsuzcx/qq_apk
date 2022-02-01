package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hh
  extends a
{
  public long etA = 0L;
  public long etB = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(91245);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.etA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etB);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(91245);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(91246);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ReportScene:").append(this.etA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ResetScece:").append(this.etB);
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
 * Qualified Name:     com.tencent.mm.g.b.a.hh
 * JD-Core Version:    0.7.0.1
 */