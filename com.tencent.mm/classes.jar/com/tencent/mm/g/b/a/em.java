package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class em
  extends a
{
  public long dZv = 0L;
  public long dZw = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(91245);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dZv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZw);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(91245);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(91246);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ReportScene:").append(this.dZv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ResetScece:").append(this.dZw);
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
 * Qualified Name:     com.tencent.mm.g.b.a.em
 * JD-Core Version:    0.7.0.1
 */