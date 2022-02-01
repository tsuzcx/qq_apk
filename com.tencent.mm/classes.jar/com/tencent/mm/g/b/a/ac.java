package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ac
  extends a
{
  public long dUM;
  public long dUN;
  public long dUO;
  public long dUP = 0L;
  public long dUQ = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(73526);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dUM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUQ);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(73526);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(73527);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("favid:").append(this.dUM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("favsize:").append(this.dUN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cachecnt:").append(this.dUO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cachelsize:").append(this.dUP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cachesuccess:").append(this.dUQ);
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