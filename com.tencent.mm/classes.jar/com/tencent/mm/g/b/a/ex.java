package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ex
  extends a
{
  private long dWa = 0L;
  private long dWb = 0L;
  private long dWc = 0L;
  private long dWd = 0L;
  private int dWe = 0;
  
  public final String PR()
  {
    AppMethodBeat.i(118500);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dWa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWe);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(118500);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(118501);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("StartZipTime:").append(this.dWa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Enable:").append(this.dWb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Exceed:").append(this.dWc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Cost:").append(this.dWd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Result:").append(this.dWe);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118501);
    return localObject;
  }
  
  public final ex Rs()
  {
    this.dWc = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 17654;
  }
  
  public final ex it(int paramInt)
  {
    this.dWe = paramInt;
    return this;
  }
  
  public final ex jh(long paramLong)
  {
    this.dWa = paramLong;
    return this;
  }
  
  public final ex ji(long paramLong)
  {
    this.dWb = paramLong;
    return this;
  }
  
  public final ex jj(long paramLong)
  {
    this.dWd = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ex
 * JD-Core Version:    0.7.0.1
 */