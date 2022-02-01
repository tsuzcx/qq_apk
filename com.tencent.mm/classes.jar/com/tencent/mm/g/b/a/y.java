package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class y
  extends a
{
  public long dHH;
  public long dHI;
  public long dHJ;
  public long dHK = 0L;
  public long dHL = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(73526);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHL);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(73526);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(73527);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("favid:").append(this.dHH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("favsize:").append(this.dHI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cachecnt:").append(this.dHJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cachelsize:").append(this.dHK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cachesuccess:").append(this.dHL);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(73527);
    return localObject;
  }
  
  public final int getId()
  {
    return 18053;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.y
 * JD-Core Version:    0.7.0.1
 */