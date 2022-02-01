package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bs
  extends a
{
  private long dPH = 0L;
  private long eaw = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(209231);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eaw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPH);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(209231);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(209232);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("type:").append(this.eaw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.dPH);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209232);
    return localObject;
  }
  
  public final bs gA(long paramLong)
  {
    this.dPH = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 20673;
  }
  
  public final bs gz(long paramLong)
  {
    this.eaw = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bs
 * JD-Core Version:    0.7.0.1
 */