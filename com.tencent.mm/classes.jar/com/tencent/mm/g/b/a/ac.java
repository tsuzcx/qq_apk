package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ac
  extends a
{
  public long dWc;
  public long dWd;
  public long dWe;
  public long dWf = 0L;
  public long dWg = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(73526);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dWc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWg);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(73526);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(73527);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("favid:").append(this.dWc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("favsize:").append(this.dWd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cachecnt:").append(this.dWe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cachelsize:").append(this.dWf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cachesuccess:").append(this.dWg);
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
 * Qualified Name:     com.tencent.mm.g.b.a.ac
 * JD-Core Version:    0.7.0.1
 */