package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class be
  extends a
{
  private long dCQ;
  private long dKB;
  
  public final String PR()
  {
    AppMethodBeat.i(195023);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dKB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dCQ);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(195023);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(195024);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Type:").append(this.dKB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dCQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(195024);
    return localObject;
  }
  
  public final be fk(long paramLong)
  {
    this.dKB = paramLong;
    return this;
  }
  
  public final be fl(long paramLong)
  {
    this.dCQ = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19952;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.be
 * JD-Core Version:    0.7.0.1
 */