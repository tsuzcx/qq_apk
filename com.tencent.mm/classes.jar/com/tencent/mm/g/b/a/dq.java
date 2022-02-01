package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dq
  extends a
{
  public String dFy = "";
  public String dSw = "";
  public String dSx = "";
  private long dSy = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(116484);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSy);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(116484);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(116485);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("appid:").append(this.dFy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("api:").append(this.dSw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("arg:").append(this.dSx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timestampMs:").append(this.dSy);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(116485);
    return localObject;
  }
  
  public final int getId()
  {
    return 15961;
  }
  
  public final dq im(long paramLong)
  {
    AppMethodBeat.i(116483);
    this.dSy = paramLong;
    super.bd("timestampMs", this.dSy);
    AppMethodBeat.o(116483);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dq
 * JD-Core Version:    0.7.0.1
 */