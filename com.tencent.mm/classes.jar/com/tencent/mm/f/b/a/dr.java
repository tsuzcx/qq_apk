package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dr
  extends a
{
  private long guA;
  private long guB;
  private long guz;
  
  public final String agH()
  {
    AppMethodBeat.i(209003);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.guz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.guA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.guB);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(209003);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(209004);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("identity:").append(this.guz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionType:").append(this.guA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("notificationType:").append(this.guB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209004);
    return localObject;
  }
  
  public final int getId()
  {
    return 22554;
  }
  
  public final dr jA(long paramLong)
  {
    this.guB = paramLong;
    return this;
  }
  
  public final dr jy(long paramLong)
  {
    this.guz = paramLong;
    return this;
  }
  
  public final dr jz(long paramLong)
  {
    this.guA = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.dr
 * JD-Core Version:    0.7.0.1
 */