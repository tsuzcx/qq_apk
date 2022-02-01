package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class w
  extends a
{
  public long dJF;
  public long dJG;
  public long dJH;
  public long dJI = 0L;
  public long dJJ = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(73526);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dJF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJJ);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(73526);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(73527);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("favid:").append(this.dJF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("favsize:").append(this.dJG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cachecnt:").append(this.dJH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cachelsize:").append(this.dJI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cachesuccess:").append(this.dJJ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(73527);
    return localObject;
  }
  
  public final int getId()
  {
    return 18053;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.w
 * JD-Core Version:    0.7.0.1
 */