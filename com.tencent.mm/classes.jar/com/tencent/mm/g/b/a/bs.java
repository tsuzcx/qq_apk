package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bs
  extends a
{
  private long dQX = 0L;
  private long ebQ = 0L;
  private long ebR = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(189266);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ebQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebR);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(189266);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(189267);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("type:").append(this.ebQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.dQX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasReddot:").append(this.ebR);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(189267);
    return localObject;
  }
  
  public final bs gC(long paramLong)
  {
    this.ebQ = paramLong;
    return this;
  }
  
  public final bs gD(long paramLong)
  {
    this.dQX = paramLong;
    return this;
  }
  
  public final bs gE(long paramLong)
  {
    this.ebR = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 20673;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bs
 * JD-Core Version:    0.7.0.1
 */