package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dx
  extends a
{
  private long ejA;
  private long erY;
  
  public final String abV()
  {
    AppMethodBeat.i(209202);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.erY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejA);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(209202);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(209203);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Type:").append(this.erY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ejA);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209203);
    return localObject;
  }
  
  public final int getId()
  {
    return 19952;
  }
  
  public final dx lb(long paramLong)
  {
    this.erY = paramLong;
    return this;
  }
  
  public final dx lc(long paramLong)
  {
    this.ejA = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dx
 * JD-Core Version:    0.7.0.1
 */