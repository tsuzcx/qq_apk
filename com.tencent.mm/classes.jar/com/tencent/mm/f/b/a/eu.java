package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class eu
  extends a
{
  private long geB = 0L;
  private long grp = 0L;
  private long gyD = 0L;
  
  public final String agH()
  {
    AppMethodBeat.i(209443);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.grp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.geB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gyD);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(209443);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(209444);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("type:").append(this.grp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.geB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasReddot:").append(this.gyD);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209444);
    return localObject;
  }
  
  public final int getId()
  {
    return 20673;
  }
  
  public final eu mp(long paramLong)
  {
    this.grp = paramLong;
    return this;
  }
  
  public final eu mq(long paramLong)
  {
    this.geB = paramLong;
    return this;
  }
  
  public final eu mr(long paramLong)
  {
    this.gyD = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.eu
 * JD-Core Version:    0.7.0.1
 */