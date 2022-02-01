package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dy
  extends a
{
  private long eBW = 0L;
  private long ejW = 0L;
  private long evl = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(209204);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.evl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBW);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(209204);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(209205);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("type:").append(this.evl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.ejW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasReddot:").append(this.eBW);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209205);
    return localObject;
  }
  
  public final int getId()
  {
    return 20673;
  }
  
  public final dy ld(long paramLong)
  {
    this.evl = paramLong;
    return this;
  }
  
  public final dy le(long paramLong)
  {
    this.ejW = paramLong;
    return this;
  }
  
  public final dy lf(long paramLong)
  {
    this.eBW = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dy
 * JD-Core Version:    0.7.0.1
 */